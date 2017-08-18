package tarea.condonaciones;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.consultas.Consultas;
import tarea.reportes.EstadoCuentaImpl;
import transformador.Transformador;
import utilitario.comun.ConstantesPagos;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionParcialRespuesta;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalPeticion;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalRespuesta;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.reportes.comun.CreditoOV;
import utilitario.mensajes.reportes.comun.ResumenSaldoOV;
import utilitario.mensajes.reportes.estadocuenta.EstadoCuentaMontos;
import entidad.conexiones.FabricaConexiones;

/**
 * @author Antonio Fentanes Implementacion del componenete Entity
 *         CondonacionManual.
 *         <ul>
 *         <li></li>
 *         </ul>
 */
public class CondonacionesManualesImpl implements CondonacionesManuales {

	/**
	 * Mensaje de Condonacion
	 */
	private static final String MENSAJE_CONDONACION = "Aplicado en T24";
	/**
	 * Mensaje de error en la condonacio
	 */
	private static final String ERROR_APLICAR_CONDONACION = "Error al aplicar la condonacion";
	/**
	 * Mensaje de error cuando no existe el credito
	 */
	private static final String ERROR_CONSULTA_CREDITO = "El credito no existe";
	/**
	 * Mensaje de error cuando el monto a condonar es mayor
	 */
	private static final String ERROR_CREDITO_MONTO = "El monto a condonar es mayor al monto en mora";

	/**
	 * Fabric comun
	 */
	private ComunTarea comun;

	/**
	 * Fabric consultas
	 */
	private Consultas consultas;
	/**
	 * Fabric consultas
	 */
	private Transformador transformador;

	/**
	 * @param comun fabric
	 * @param consultas fabric
	 */
	public CondonacionesManualesImpl(@Reference(name = "comun") ComunTarea comun,
			@Reference(name = "consultas") Consultas consultas,
			@Reference(name = "transformador") Transformador transformador) {
		this.comun = comun;
		this.consultas = consultas;
		this.transformador = transformador;
	}

	/**
	 * @param uid identificador unico de la peticion
	 * @param peticion con los datos necesarios para realizar la condonacion
	 * @return Respuesta de aplicacion de condonacion
	 */
	public AplicarCondonacionParcialRespuesta aplicarCondonacionParcial(String uid,	AplicarCondonacionParcialPeticion peticion)
		{
		aplicarCondonacion(uid, peticion.getValores()[0], getMonto(peticion), peticion.getDetalle() , 0 , null);
		AplicarCondonacionParcialRespuesta respuesta = new AplicarCondonacionParcialRespuesta();
		respuesta.setAplicarCondonacionParcialResult(0);
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setMensaje(MENSAJE_CONDONACION);
		return respuesta;
		}

	/**
	 * @param peticion montos condonacion
	 * @return monto
	 */
	private Double getMonto(AplicarCondonacionParcialPeticion peticion) {
		if (peticion != null && peticion.getValores().length > 4) {
			return Double.parseDouble(peticion.getValores()[1] + peticion.getValores()[2] + peticion.getValores()[3]);
			}
		return null;
		}

	/**
	 * @param uid identificador unico de la peticion
	 * @param peticion con los datos necesarios para realizar la condonacion
	 * @return Respuesta de aplicacion de condonacion
	 */
	public AplicarCondonacionTotalRespuesta aplicarCondonacionTotal(
			String uid, AplicarCondonacionTotalPeticion peticion) {
		AplicarCondonacionTotalRespuesta respuesta = aplicarCondonacion(uid, peticion.getCondonacion().getCredito(),
				Double.parseDouble(peticion.getCondonacion().getImporte()), peticion.getCondonacion().getMotivo(),
				peticion.getCondonacion().getSucursal(), peticion.getCondonacion().getUsuario());

		return respuesta;
	}

	/**
	 * @param uid identificador unico de la transaccion
	 * @param credito a condonar
	 * @param monto  a condonar
	 * @param motivo de la condonacion
	 * @param sucursal del contrato
	 * @param usuario que realiza la condonacion
	 * @return el resultado de la condonacion
	 */
	private AplicarCondonacionTotalRespuesta aplicarCondonacion(String uid, String credito, Double monto,
				String motivo, Integer sucursal, String usuario) {
		DecimalFormat formateador = new DecimalFormat("$###,###,###.##");
		AplicarCondonacionTotalRespuesta respuesta = new  AplicarCondonacionTotalRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		SqlSession sesion = null;
		SqlSession sesionNTx = null;

		try {
			final String numeroContrato = comun.obtenerNumeroContrato( uid, credito);
			if (numeroContrato == null || numeroContrato.equals("0")) {
				throw new Exception(ERROR_CONSULTA_CREDITO);

			}

			final FechaContableOV fechaContable = comun.obtenerFechaContable(uid);

			final CreditoSaldo creditoCliente = consultas.consultaSaldoCredito(uid,
					numeroContrato,  fechaContable.getFecha()); //fechaContable
			sesion = FabricaConexiones.obtenerSesionTx();

			if (creditoCliente.getFechaProximoPago() == null) {
				throw new Exception(ERROR_APLICAR_CONDONACION);
			}

			if ( monto > creditoCliente.getSaldoLiquidar()) {
				throw new Exception(ERROR_CREDITO_MONTO);
			}

			//Validacion Montos
			if (sucursal == null) {
					throw new Exception("La peticion no cuenta con la sucursal para validar");
			}

			if (usuario == null || usuario.trim().isEmpty()) {
				usuario = null;
			}

			if (sucursal != 0 || motivo.trim().equals("Condonaci�n Saldo Total.")) {
				EstadoCuentaImpl estadocuenta = new EstadoCuentaImpl(comun, transformador);

				CreditoOV creditoOV = estadocuenta.obtenerCredito(uid, numeroContrato);

				if (creditoOV == null) {
					throw new Exception("No hay resultados para los datos del credito");
				}

				EstadoCuentaMontos montos = estadocuenta.recuperaMontosExtras(uid, numeroContrato, creditoOV);

				if (montos == null) {
					throw new Exception("No hay resultados para los montos del credito");
				}

				ResumenSaldoOV pagos = estadocuenta.obtenerFinalEstadoCuenta( uid, numeroContrato);

				if (pagos == null) {
					throw new Exception("No hay resultados para los pagos del contrato");
				}

				if (Math.abs(pagos.getPagos()) < (montos.getNuevoInteresOrdinario() + creditoOV.getMontoReal())) {
					throw new Exception("No se puede condonar ya que el monto de lo pagado "
							+ formateador.format(Math.abs(pagos.getPagos())) + " , no cubre el monto total a pagar por el grupo "
							+ formateador.format(montos.getNuevoInteresOrdinario() + creditoOV.getMontoReal()));
				}
			}

			if (sucursal != 0) {
				sesionNTx = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "aplicarCondonacion: - obtenerParGeneral");
	     		ParGeneralOV montoMinimoCondonacion = comun.obtenerParGeneralOV(uid, "CON_MONMIN");
	     				//(ParGeneralOV) sesionNTx.selectOne("obtenerParGeneral", "CON_MONMIN");

	     		if (montoMinimoCondonacion == null || montoMinimoCondonacion.getCgValor().trim().isEmpty()) {
	     				throw new Exception("No fue posible obtener el monto minimo de Condonacion.");
	     		}

	     		double montoMinimoCond = Double.parseDouble(montoMinimoCondonacion.getCgValor().trim());

				if ( monto > montoMinimoCond) {
					throw new Exception("El monto a condonar es mayor al monto permitido ["
							+ formateador.format(montoMinimoCond) + "].");
				}
				FabricaConexiones.close(sesionNTx);
			}

			//Fin Validar Montos

			//APERTURA DE CAJA
			comun.aperturaCaja(uid, creditoCliente.getSucursal(), fechaContable.getFecha());
			// SE OBTIENE ID DE TRANSACCION DE LA CAJA

			//OBTENER ID DE TRANSACCION
			Integer idTransaccion = comun.obtenerIdTransaccion(uid, creditoCliente.getSucursal(), fechaContable.getFecha());

			//	map.put("fechaActual", formatter.formACTUALat(new Date()));
					// REGISTRAR MOVIMIENTO EN INVENTARIO
			HashMap<String, Object> mapInventario = new HashMap<String, Object>();

			mapInventario.put("sucursal", creditoCliente.getSucursal());
			mapInventario.put("fechaContable", formatter.format( fechaContable.getFecha()));
			mapInventario.put("codigo",
					ConstantesPagos.PAGO_BONIFICACION.getValue());
			mapInventario.put("fechaValor", formatter.format( fechaContable.getFecha()));
			mapInventario.put("medioRecepcion",
					ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
			mapInventario.put("monto", monto.doubleValue());
			mapInventario.put("usuario", usuario == null ? ConstantesPagos.USUARIO_PAGO.getValue() : usuario);
			mapInventario.put("clave", 0);
			mapInventario.put("clave_produccion", "");
			mapInventario.put("referencia1",
					ConstantesPagos.BONIFICACION_REFERENCIA1.getValue());
			mapInventario.put("referencia2",
					ConstantesPagos.BONIFICACION_REFERENCIA2.getValue());
			mapInventario.put("referencia3", "");

			//REGISTA CAJA INVENTARIO
			LogHandler.trace(uid, this.getClass(), "==> aplicarCondonacion - registraCajaInventario");
			sesion.selectOne("registraCajaInventario", mapInventario);

			mapInventario.put("contrato", creditoCliente.getContrato());
			mapInventario.put("idTrxCaja", idTransaccion);
			mapInventario.put("fechaActual", formatter.format( fechaContable.getFecha()));

			LogHandler.trace(uid, this.getClass(), "==> aplicarCondonacion - registraOperacionCaja");
			sesion.selectOne("registraOperacionCaja", mapInventario);

			mapInventario.put("codigoServicio", " ");
			mapInventario.put("descripcionPago", motivo);

			LogHandler.trace(uid, this.getClass(), "==> aplicarCondonacion - calculaParcialidad");
			sesion.selectOne("calculaParcialidad", mapInventario);

			sesion.commit(true);

		} catch (Exception e) {
			FabricaConexiones.rollBack(sesion);
			LogHandler.error(uid, getClass(), "Error en aplicarCondonacion(): " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( "Error al Aplicar Condonacion: " + e.getMessage() );
		} finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}
}

