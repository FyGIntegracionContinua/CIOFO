package tarea.originacion;

import java.io.StringReader;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import mx.com.findep.crediseguros.webservice.finsol.AfiliacionServiceLocator;
import mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroServiceLocator;

import org.apache.ibatis.session.SqlSession;
import org.oasisopen.sca.annotation.Reference;
import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import tarea.consultas.Consultas;
import tarea.operacion.PagosCredito;
import tarea.seguros.SegurosTarea;
import tarea.solicitudes.SolicitudesCreditoTarea;
import transformador.Transformador;
import utilitario.comun.Constantes;
import utilitario.comun.ConstantesPagos;
import utilitario.comun.Funciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.comun.ResultadoOV;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.consultas.ConsultaCATPeticion;
import utilitario.mensajes.consultas.ConsultaCATRespuesta;
import utilitario.mensajes.consultas.ConsultaCreditoPeticion;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.consultas.DatosCreditoOV;
import utilitario.mensajes.consultas.DatosIntegranteResumenOV;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.originacion.cliente.ActualizarChequeClientePeticion;
import utilitario.mensajes.originacion.cliente.ClienteRespuesta;
import utilitario.mensajes.originacion.consulta.AfiliacionSeguroRespuesta;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoPeticion;
import utilitario.mensajes.originacion.consulta.ConfirmarCreditoRespuesta;
import utilitario.mensajes.originacion.consulta.GuardarOpcionGarantiaPeticion;
import utilitario.mensajes.originacion.consulta.GuardarOpcionGarantiaRespuesta;
import utilitario.mensajes.originacion.consulta.ObtenerMontosSegurosRespuesta;
import utilitario.mensajes.originacion.consulta.PagoDocumentoPeticion;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.originacion.consulta.TraspasoGarantiaOV;
import utilitario.mensajes.originacion.consulta.ValidaPagoGarantiaPeticion;
import utilitario.mensajes.originacion.consulta.ValidaPagoGarantiaRespuesta;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.originacion.contrato.ContratoRespuesta;
import utilitario.mensajes.originacion.contrato.IntegranteOV;
import utilitario.mensajes.originacion.desembolso.DesembolsoOV;
import utilitario.mensajes.originacion.desembolso.DesembolsoRespuesta;
import utilitario.mensajes.originacion.grupo.GrupoOV;
import utilitario.mensajes.seguros.BeneficiariosClienteOV;
import utilitario.mensajes.seguros.PeticionConsulta;
import utilitario.mensajes.seguros.SegurosRespuestaConsulta;
import utilitario.mensajes.seguros.cliente;
import utilitario.mensajes.solicitudes.AtomosOV;
import utilitario.mensajes.solicitudes.AtomosRespuesta;
import utilitario.mensajes.solicitudes.RegistrarSolicitudOV;
import utilitario.mensajes.solicitudes.SolicitudesOV;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;
import entidad.originacion.secuencias.GeneraSecuencias;



/**
 * @author Juan Moreno
 * Encapsula la implementacion de la clase
 * <ul>
 *  <li></li>
 * </ul>
 */
public final class OriginacionCreditoImpl implements OriginacionCredito {

	/** The componente grupo. */
	private OriginacionGrupo componenteGrupo;

	/** The comun. */
	private ComunTarea comun;

	/** The pagos. */
	private PagosCredito pagos;

	/** The consultas. */
	private Consultas consultas;

	/** The seguros. */
	private SegurosTarea seguros;

	/** The solicitudes. */
	private SolicitudesCreditoTarea solicitudes;

	/** The transformador. */
	private Transformador transformador;

	/**
	 * Instantiates a new originacion credito impl.
	 *
	 * @param componente the componente
	 * @param comun the comun
	 * @param pagos the pagos
	 * @param consultas the consultas
	 * @param seguros the seguros
	 * @param solicitudes the solicitudes
	 * @param transformador the transformador
	 */
	public OriginacionCreditoImpl(@Reference(name = "grupo" ) OriginacionGrupo componente,
								  @Reference(name = "comun") ComunTarea comun,
								  @Reference(name = "pagos") PagosCredito pagos,
								  @Reference(name = "consultas") Consultas consultas,
								  @Reference(name = "seguros") SegurosTarea seguros,
								  @Reference(name = "solicitudes") SolicitudesCreditoTarea solicitudes,
								  @Reference(name = "transformador") Transformador transformador) {

		componenteGrupo = componente;
		this.comun = comun;
		this.pagos = pagos;
		this.consultas = consultas;
		this.seguros = seguros;
		this.solicitudes = solicitudes;
		this.transformador = transformador;
	}

  	/**
	 * Genera el numero de Contrato
	 * @param uid String
	 * @return identificador
	 */
	private final String generarContrato( String uid ) {
		String identificador = null;
		try {
			Long id = GeneraSecuencias.getSigSecuenciaCreditos( uid );
			if ( id != null ) {
				identificador = Funciones.padLeftZeros( id.toString(),  8 );
			}
		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Existio un error al generar el contrato.", e);
		}
		LogHandler.info(uid, getClass(), "El contrato generado es:" + identificador);
		return identificador;
	}

	/**
	 * Genera el numero de LDContrato
	 * se conforma con LD mas el dia del a�o en 3 digitos y un consecutivo en 5 digitos..
	 * @param uid String
	 * @param sesion SqlSession
	 * @return respuesta
	 */
	private final String generarLdContrato(String uid, SqlSession sesion )throws Exception {
		String respuesta = null;
		String prefijo = null;
		Integer consecutivo = null;
		try {
			prefijo		= Funciones.obtenerPrefijoLD( comun.obtenerFechaContable(uid).getFecha() );
			LogHandler.trace(uid, getClass(), "==> generarLdContrato - " + OPER_OBTENER_CONSECUTIVO_LD_CONTRATO);
			consecutivo = (Integer) sesion.selectOne( OPER_OBTENER_CONSECUTIVO_LD_CONTRATO, prefijo );
			if ( consecutivo ==  null ) {
				consecutivo = 1;
			}
		} catch ( Exception e) {
			LogHandler.error( uid, getClass(), "Ocurrio un error  dentro de generarLdContrato prefijo: " + prefijo, e );
		}
		respuesta = prefijo + Funciones.formatoConsecutivoLDContrato( consecutivo );
		LogHandler.info( uid, getClass(), "LDGenerado: " + respuesta );
		return respuesta;
	}

	/**
	 * Metodo que calcula la tasa mensual
	 * @param sesionNTx
	 * @param parametros
	 * @param tasa
	 * @return
	 * @throws Exception
	 */
	private final Double calculaTasaMensual ( String uid, SqlSession sesionNTx, @SuppressWarnings("rawtypes") Map parametros, Double tasa)throws Exception {
		double 	tasaMensual			= 0d;
		try {
			LogHandler.trace(uid, getClass(), "==> calculaTasaMensual - " + OPER_VER_VALOR_HISTORICO );
			Integer iva  = ( Integer ) sesionNTx.selectOne( OPER_VER_VALOR_HISTORICO, parametros );
			if ( iva != null && iva > 0 )
				tasaMensual = ( iva != 0 ? Double.valueOf( DF.format( ( tasa / ( 1 + ( iva.doubleValue() / 100 ) ) ) / 12 ) ) : 0 );
			else
				throw new Exception ();
		} catch(Exception e) {
			LogHandler.error(uid, getClass(), "NO SE PUDO OBTENER EL VALOR DEL IVA DE LA SUCURSAL. NI SE PUDO CALCULAR LA TASA MENSUAL.", e);
			throw new Exception ( ReadProperties.mensajes.getProp("administracion.ajustartasaplazo.errorivasucural"));
		}
		return tasaMensual;
	}

	/**
	 *
	 * @param sesionNTx
	 * @param grupo
	 * @return
	 * @throws Exception
	 */
	private final Integer obtenerCiclo (String uid, SqlSession sesionNTx, String grupo )throws Exception {
		Integer ciclo = null;
		try {
			LogHandler.trace(uid, getClass(), "==> obtenerCiclo - " +  OPER_OBTENER_CICLO_GRUPO);
			ciclo  = ( Integer )sesionNTx.selectOne( OPER_OBTENER_CICLO_GRUPO, grupo );
			if ( ciclo == null )
				throw new Exception ("");
		} catch(Exception e) {
			LogHandler.error(uid, getClass(), " NO SE PUDO OBTENER EL VALOR DEL CICLO DEL GRUPO: " + grupo, e);
			throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.ciclogrupo"));
		}
		return ciclo;
	}


	/**
	 *
	 * @param sesionNTx
	 * @param params
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	private final Double calcularMonto( String uid, SqlSession sesionNTx, @SuppressWarnings("rawtypes") Map params) throws Exception {
		 Double montoPago = null;
		try {
			//Obtener el - codigo - para tipo de c�lculo
			LogHandler.trace(uid, this.getClass(), "==> calcularMonto - obtenerTipoCalculoInteresProducto");
			final java.util.HashMap<String, Object>
										mapaCodigoCalculo = ( HashMap<String, Object> )sesionNTx.selectOne( "obtenerTipoCalculoInteresProducto", params );

//			//Obtener el - valor - para tipo de c�lculo
//			final HashMap<String, Object> parametros = new HashMap<String, Object>();
//			parametros.put( "tipoCalculoInteres", mapaCodigoCalculo.get( "valor" ).toString() );
//			parametros.put( "sucursal"  		, Integer.valueOf( params.get( "sucursal" ).toString() ) );
//			parametros.put( "fechaContrato"	    , params.get( "fecha_contrato" ).toString() );
//
//			LogHandler.trace(uid, this.getClass(), "==> calcularMonto - obtenerValorTipoCalculoInteres");
//			final java.lang.String
//				  valorTipoCalculo = ( java.lang.String )sesionNTx.selectOne( "obtenerValorTipoCalculoInteres", parametros );

			//Campos para el calculo de intereses
			params.put( "tipoCalculo"  , mapaCodigoCalculo.get( "valor" ).toString() );
			params.put( "fechaInicial" , params.get( "fecha_disposicion" ) );
			params.put( "fechaFinal"   , params.get( "fecha_esp_liq" ) );
			params.put( "producto"   ,   params.get( "producto" ) );

			LogHandler.trace(uid, getClass(), "==> calcularMonto - " + OPER_CALCULA_MONTO_PAGO);
			montoPago  = (Double) sesionNTx.selectOne(OPER_CALCULA_MONTO_PAGO,  params );
			if ( montoPago == null )
				throw new Exception (ReadProperties.mensajes.getProp("ciof.error.calcularmonto"));
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass() , "NO SE PUDO CALCULAR EL MONTO DEL PAGO" ,e);
 			throw new Exception (ReadProperties.mensajes.getProp("ciof.error.calcularmonto"));
		}
		return montoPago;
	}

	/**
	 * @param uid tipo String
	 * @param contrato tipo ContratoOV
	 * @param sesion tipo SqlSession
	 * @return ContratoRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ContratoRespuesta registrar( String uid, SqlSession sesion, ContratoOV contrato ) {
		String MSG = "REGISTRADO.  ";

		SqlSession 					sesionNTx			= null;
		SqlSession 					sesionTx			= null;
		Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
		Map<String, Object> 		parametrosInt 		= new HashMap<String, Object>( );
		HashMap<String, Object> 	params				= new HashMap<String, Object>( );
		List<String>				integrantes			= new ArrayList<String>( );
		List<IntegranteOV>			integrantesCredAct	= new ArrayList<IntegranteOV>( );
 		Date						fecha 				= new Date( );
		double 						tasaMensual			= 0d;
		Integer						ciclo;
		Integer 					noCreditosActuales;
		Integer 					noCreditosActualesPorCliente;
		String 						identificador;
		String 						categoria			= null;
 		ContratoRespuesta			regreso				= new ContratoRespuesta( );
 		ResultadoOV					resultadoContrato	= null;
 		String 						contratoLD			= null;
 		Double						montoPago			= null;
 		CreditoSaldo 				creditoSaldo		= null; //para el saldo liquidar contrato anterior (financiadas)
 		boolean sesionExterna = false;

		regreso.setHeader( new EncabezadoRespuesta( ) );
		regreso.getHeader().setUID( uid );
		String express = "";

		try {

			//Abrimos las conexiones correspondientes
			sesionNTx	= FabricaConexiones.obtenerSesionNTx( );

			//Se abre la conexion hacia la base de datos
			if (sesion == null) {
				sesionTx = FabricaConexiones.obtenerSesionTx();
			} else {
				sesionTx = sesion;
				sesionExterna = true;
			}

			LogHandler.debug(uid, getClass(), "Datos de entrada : " + contrato );
 			identificador = generarContrato( uid ); //Obtenemos el numero de contrato
			if ( identificador == null ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.noexisterelacion") );
			}

			//Se valida la propiedad de renovacion
			if ( contrato.isRenovacion() == null ) {
				contrato.setRenovacion( false );
			}

			//Movimientos Deposito Garantia
			if ( contrato.getProducto().equals(PRODUCTO_DG_SEMANAL) ||  contrato.getProducto().equals(PRODUCTO_DG_CATORCENAL) ) {
				if ( contrato.getPctGarantia() == null) {
					throw new Exception("La consulta no cuenta con el porcentaje de garantia");
				}
			}

			//Validacion Renovacion ORD
			if (contrato.getRenovacion()) {
				for (int i = 0; i < contrato.getIntegrantes().length; i++) {
					contrato.getIntegrantes()[i].setMontoFinanciado(0.0);
				}
			}

			//Se valida que la hora de reunion que se ingreso sea correcta
			try {
				final SimpleDateFormat simpleDateFormatHoras = new SimpleDateFormat( "HH:mm" );
				if ( contrato.getHora_reunion( ) != null )
					{	simpleDateFormatHoras.parse( contrato.getHora_reunion( ) ).getTime(); 	}
			}
			catch ( java.text.ParseException parseException ) {
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorhorareunion" ) );
			}

			//2013-10-11
			//MMH Se valida que la hora de reunion fin sea correcta
			try {
				final SimpleDateFormat simpleDateFormatHoras = new SimpleDateFormat( "HH:mm" );
				if ( contrato.getHora_reunion_fin() != null )
					{	simpleDateFormatHoras.parse( contrato.getHora_reunion_fin( ) ).getTime(); 	}
			}
			catch ( java.text.ParseException parseException ) {
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorhorareunionfin" ) );
			}

			Date fechaContable = comun.obtenerFechaContable(uid ).getFecha();

			LogHandler.debug(uid, this.getClass(), "Tratando de abrir la caja... ");
			ResultadoOV aperturaCaja = comun.aperturaCaja(uid, contrato.getSucursal(), fechaContable );
			if ( aperturaCaja.getCodigoRetorno() < 0 ) {
				throw new Exception(ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
			}

			//Se cambia el contrato a clave credprod
			if ( contrato.getContratoActual() != null && !contrato.getContratoActual().trim().equals( "" ) ) {
				LogHandler.trace(uid, getClass(), "==> registrar - obtenerNumeroContrato" );
				contrato.setContratoActual( comun.obtenerNumeroContrato(uid,
						contrato.getContratoActual().toString()).toString() );
			}

			//Monto total basado en montos de los integrates
			java.math.BigDecimal montoIntegrantes = new BigDecimal( 0 );

			//Actualizar el ciclo del integrante en la tabla de personas contrato.getIntegrantes( )
			for ( IntegranteOV integrante : contrato.getIntegrantes( ) ) {

				if ( integrante.getMonto() == null || integrante.getMonto() == 0 ) {
					throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontointegrante" ) );
				}

				if ( integrante.getCliente() == null || integrante.getCliente().trim().equals( "" ) ) {
					throw new Exception(ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorcodigointegrante" ));
				}

				if (integrante.getDesertor() != null) {
					if (integrante.getDesertor().equals("N")) {
						//Se suman montos de los integrantes
						montoIntegrantes = montoIntegrantes.add( new BigDecimal( "" + integrante.getMonto() ) );
					}
				} else {
					//Se suman montos de los integrantes
					montoIntegrantes = montoIntegrantes.add( new BigDecimal( "" + integrante.getMonto() ) );
				}

				integrante.setCliente(comun.obtenerPersonaCliente(uid, integrante.getCliente()));

				if ( integrante.getCliente() != null && !integrante.getCliente().equals( "" ) ) {
					integrantes.add( integrante.getCliente( ) );
				}
			}

			LogHandler.info(uid, getClass(), "Los montos son mIs = " +  montoIntegrantes + ", mCp = "
					+ contrato.getMonto_otorgado().doubleValue() );

			//Se validan los montos iguales
			if ( montoIntegrantes.doubleValue() != contrato.getMonto_otorgado().doubleValue() ) {
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontointegrantes" ) );
			}

			//Se agrega validacion de express si express es renovacion
			LogHandler.trace(uid, getClass(), "==> registrar - obtenerExpressSolicitud ");
			RegistrarSolicitudOV registrarSolicitud =  (RegistrarSolicitudOV)
					sesionNTx.selectOne( "obtenerExpressSolicitud" , contrato.getSolicitud());

			if (registrarSolicitud ==  null) {
				throw new Exception("No fue posible recuperar los datos de la solicitud.");
			}

			express = registrarSolicitud.getExpress();

			if (express.trim().equals("S")) {
				contrato.setRenovacion(registrarSolicitud.isRenovacion());
				if (registrarSolicitud.isRenovacionFinanciada()) {
					contrato.setContratoActual(registrarSolicitud.getContratoActual());
					if (contrato.getContratoActual() == null || contrato.getContratoActual().isEmpty()) {
						throw new Exception("Es necesario el contrato actual en la petición para express financiada.");
					}
				} else {
					contrato.setContratoActual(null);
				}
			}

			if (contrato.getRenovacionFinanciada() == null) {
				contrato.setRenovacionFinanciada(false);
			}
			
			if (express.trim().equals("S")) {
				LogHandler.trace(uid, getClass(), "validacionSolicitudExpressFinanciada: - obtenerParGeneral");
				ParGeneralOV pctNuevosFinanciados = comun.obtenerParGeneralOV(uid, "RE_PCTNUEV_FINANCIADO");
	
				double pctNuevosMaximoFinanciados
				= Double.parseDouble(pctNuevosFinanciados.getCgValor().trim()) / Constantes.CENTENA_DOUBLE;
	
				int nuevosGrupo = 0;
				//Obtiene el numero de integrantes nuevos y desertores
				for ( IntegranteOV integrante : contrato.getIntegrantes( ) ) {
	
					if ( integrante.getDesertor() != null && integrante.getPerteneceCreditoRenovar() != null) {
						if ( integrante.getDesertor().equals("S") || integrante.getPerteneceCreditoRenovar().equals("N")) {
							nuevosGrupo++;
						}
					}
				}
	
				if (nuevosGrupo > (contrato.getIntegrantes().length * pctNuevosMaximoFinanciados)) {
					throw new Exception("La solicitud tiene más de 20% de integrantes nuevos."
							+ " Ajustar integrantes de acuerdo a política.");
				}
			}

			LogHandler.info(uid, getClass(), "==> renovacion :" + contrato.getRenovacion().toString());
			LogHandler.info(uid, getClass(), "==> renovacionFinanciada :" + contrato.getRenovacionFinanciada().toString());
			contrato.setMontoFinanciado( 0.0 );
			//se cambia el contrato anterior por el credprod y se obtiene el saldo liquidar en renovaciones
			//y se calcula el monto financiado
			if (contrato.isRenovacion() && contrato.getContratoActual() != null
								&& !contrato.getContratoActual().trim().equals( "" )) {


				//Se recalculan el saldo del credito a renovar con la fecha desembolso.
				creditoSaldo = consultas.consultaSaldoCredito(uid, contrato.getContratoActual(),
						contrato.getFecha_desembolso(), sesionTx);
				creditoSaldo.setSaldoLiquidar(creditoSaldo.getSaldoLiquidar() != null
												? creditoSaldo.getSaldoLiquidar() : 0.0 );
				LogHandler.info(uid, getClass(), "==> creditoSaldo :" + creditoSaldo);

				//Monto contrato anterior, contratos.monto
				LogHandler.trace(uid, getClass(), "==> registrar - obtenerMontoContrato ");
				final Double montoAnterior = (Double) sesionNTx.selectOne("obtenerMontoContrato", contrato.getContratoActual());
				LogHandler.info(uid, getClass(), "==> montoAnterior :" + montoAnterior);
				//Monto contrato anterior, integrante_grupo.monto_otorgado + seguro
				LogHandler.trace(uid, getClass(), "==> registrar - obtenerMontoIntegrantes ");
				final List<HashMap<String, Object>> listaMontos = (List<HashMap<String, Object>>)
						sesionNTx.selectList( "obtenerMontoIntegrantes" , contrato.getContratoActual() );
				//se determinan los saldos anteriores
				final HashMap<String, Double> montoIntegrante = new HashMap<String, Double>();
				for ( HashMap<String, Object> montos : listaMontos ) {
					montoIntegrante.put(montos.get("integrante").toString(), Double.parseDouble(montos.get("monto").toString()));
				}

				java.lang.Boolean tieneMonto = false;

				//For para monto financiado
				for ( IntegranteOV integranteOV : contrato.getIntegrantes() ) {
					if ( montoIntegrante.get( integranteOV.getCliente() ) != null ) {
						//Clientes que si renuevan y por lo tanto tienen saldo.

						if ( express.trim().equals("S")) {
							if (integranteOV.getDesertor().equals("N")) {
								//No tiene desertores por lo cual se toma el calculo a la fecha desembolso.
								LogHandler.info(uid, getClass(), "==> Es express :" + express);
								final java.lang.Double percent =  montoIntegrante.get( integranteOV.getCliente() ) / montoAnterior;
								integranteOV.setMontoFinanciado( Funciones.redondeo( creditoSaldo.getSaldoLiquidar() != null
										? percent * creditoSaldo.getSaldoLiquidar() : 0.0 ) );
							}
						} else if (contrato.getPagoGarantia()) {
							//Existio pago por lo cual hay que tomar lo almacenado.
							if (contrato.getAplicarGarantiaDesertor().equals("S")) {
								LogHandler.info(uid, getClass(), "==> Pago desertor, tomar lo almacenado.");
								Map<String, Object> 		parametrosCliente = new HashMap<String, Object>( );
								parametrosCliente.put("solicitud",  contrato.getSolicitud() );
								parametrosCliente.put("cliente",   integranteOV.getCliente() );
								LogHandler.trace(uid, getClass(), "==> registrar - obtenerMontoFinanciadoPersona ");
								//solicitud_integrantes.saldo_actual
								Double montoIntegranteSolicitudFinanciada
									= (Double) sesionNTx.selectOne( "obtenerMontoFinanciadoPersona" , parametrosCliente);
								integranteOV.setMontoFinanciado( Funciones.redondeo( montoIntegranteSolicitudFinanciada ) );
							} else {
								LogHandler.info(uid, getClass(), "==> Pago aplicar garantia parcialidad, toma el recalculo.");
								final java.lang.Double percent = montoIntegrante.get(integranteOV.getCliente()) / montoAnterior;
								integranteOV.setMontoFinanciado( Funciones.redondeo( creditoSaldo.getSaldoLiquidar() != null
										? percent * creditoSaldo.getSaldoLiquidar() : 0.0 ) );
							}
						} else {
							Map<String, Object> 		parametrosCliente = new HashMap<String, Object>( );
							parametrosCliente.put("solicitud",  contrato.getSolicitud() );
							parametrosCliente.put("cliente",   integranteOV.getCliente() );
							LogHandler.trace(uid, getClass(), "==> registrar - obtenerMontoFinanciadoPersona ");
							//solicitud_integrantes.saldo_actual
							Double montoIntegranteSolicitudFinanciada
								= (Double) sesionNTx.selectOne( "obtenerMontoFinanciadoPersona" , parametrosCliente);
							integranteOV.setMontoFinanciado( Funciones.redondeo( montoIntegranteSolicitudFinanciada ) );
						}
					} else {
						//Los que no vienen del credito anterior, el monto financiado es 0.
						integranteOV.setMontoFinanciado( 0D );
					}

					//Suma el monto Financiado para el contrato.
					if ( integranteOV.getMontoFinanciado() != null && integranteOV.getMontoFinanciado() >= 0 ) {
							LogHandler.info(uid, getClass(), "==> integranteOV.getMontoFinanciado()"
									+ integranteOV.getMontoFinanciado());
							contrato.setMontoFinanciado( contrato.getMontoFinanciado() + integranteOV.getMontoFinanciado() );
					}

				} //Fin for para monto financiado

				//Si es una renovacion financiada
				LogHandler.info(uid, getClass(), "==> montoFinanciado: " + contrato.getMontoFinanciado());

				if (contrato.getMontoFinanciado() == null) {
					contrato.setMontoFinanciado(0d);
				}

				if ( contrato.getMontoFinanciado() == 0 ) {
					throw new Exception(ReadProperties.mensajes.getProp(
							"originacion.registrar.errormontofinanciado"));
				} else {
					tieneMonto = true;
				}

				if ( tieneMonto && creditoSaldo.getSaldoLiquidar() == 0.0 ) {
					throw new Exception(ReadProperties.mensajes.getProp(
							"originacion.registrarcredito.errorcontratoanteriorinvalido"));
				}

			} //Fin if saldo a liquidar y se calcula monto financiado

			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");

			//Se valida que la fecha de desembolso sea igual o mayor que la contable
			if ( fechaContable != null &&  contrato.getFecha_desembolso().before( fechaContable ) ) {
				throw new Exception(ReadProperties.mensajes.getProp("originacion.registrarcredito.errorfechadesembolsoinferior"));
			}

			//Dias
			int valorDias = Integer.parseInt(
					comun.obtenerParGeneralOV(uid, "com.mx.finsol.originacion.credito.fechaautorizacion").getCgValor());

			//Se valida que la fecha de desembolso no sea mayor que la fecha de autorizacion
			final java.util.Calendar fechaAuto = Calendar.getInstance();
			fechaAuto.setTime( fechaContable );
			fechaAuto.add(Calendar.DAY_OF_YEAR, valorDias);

			if ( contrato.getFecha_desembolso().after( fechaAuto.getTime() ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrarcredito.errorfechadesembolsosuperior")
						+ simpleDateFormat.format( fechaAuto.getTime() ) + "\"" );
			}

			//Calculamos el valor de la tasa mensual sin IVA, en cfuncion de la sucursal
			LogHandler.debug( uid, getClass(), SUCURSAL + ": " + contrato.getSucursal( ) );
			parametros.put( SUCURSAL, contrato.getSucursal( ) );
			parametros.put( FECHA, fecha );
			parametros.put( CODIGO , CODIGO_IVA );
			tasaMensual = calculaTasaMensual( uid, sesionNTx, parametros, contrato.getTasa() );

			//MIMH 2013-10-29
			LogHandler.trace(uid, getClass(), "==> registrar - verValorHistorico " );
			final Integer iva = (Integer) sesionNTx.selectOne("verValorHistorico", parametros);

			//Se obtiene la parte sin iva
			final Double ivaD = Double.parseDouble( iva.toString() );

			parametros.clear();

			//Obetenemos el ciclo actual de la tabla personas
			contrato.getGrupo( ).setIdentificador( comun.obtenerPersonaCliente(uid, contrato.getGrupo( ).getIdentificador( )) );
			ciclo = obtenerCiclo(uid, sesionNTx, contrato.getGrupo( ).getIdentificador( ) );

			LogHandler.debug(uid, getClass(), "Grupo: " + contrato.getGrupo( ).getIdentificador( ) + " Ciclo Actual: " + ciclo );

			//Verificar la categoria del producto
			categoria  = comun.obtenerCategoria(uid, contrato.getProducto() );

			LogHandler.debug(uid, getClass(), "categoria: " +  categoria );

			//Verificar duplicidad de creditos
			noCreditosActuales = 0;

			parametros.put( "grupo" , contrato.getGrupo( ).getIdentificador( ) );


			if (categoria.equals( PREF_OPORTUNIDAD ) ) {
				parametros.put( "tipo", 1 );

				LogHandler.trace(uid, getClass(), "==> registrar - obtenerCreditosActuales" );
				//***Se cambio sesionNTx
				noCreditosActuales  = (Integer) sesionTx.selectOne("obtenerCreditosActuales", parametros);

				if (noCreditosActuales != 0) {
					throw new Exception(ReadProperties.mensajes.getProp("originacion.registrarcredito.errorcreditosactuales"));
				}

			} else {
				parametros.put( "tipo", 2 );

				LogHandler.trace(uid, getClass(), "==> registrar - obtenerCreditosActuales" );
				//***Se cambio sesionNTx
				noCreditosActuales  = (Integer) sesionTx.selectOne( "obtenerCreditosActuales", parametros );

				if ( contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 && noCreditosActuales != 1) {
					throw new Exception(ReadProperties.mensajes.getProp(
							"originacion.registrarcredito.errorcreditosactuales.fin"));
				}

				if ( !contrato.isRenovacion() && noCreditosActuales != 0) {
					throw new Exception(ReadProperties.mensajes.getProp("originacion.registrarcredito.errorcreditosactuales"));
				}
			}

			//verificar duplicidad de creditos por integrante
			for (IntegranteOV integrante : contrato.getIntegrantes( )) {
					LogHandler.trace(uid, getClass(), "==> registrar - obtenerCreditosActualesIntegrante" );
					parametrosInt.put("tipo", parametros.get("tipo"));
					parametrosInt.put("integrante", integrante.getCliente());
					//Se cambia la sesionNTx
					noCreditosActualesPorCliente  = (Integer)
							sesionTx.selectOne( "obtenerCreditosActualesIntegrante", parametrosInt);

					if ( contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 && noCreditosActualesPorCliente > 1) {
						integrantesCredAct.add(integrante);
					}

					if ( !contrato.isRenovacion() && noCreditosActualesPorCliente != 0) {
						integrantesCredAct.add(integrante);

					}
					/*
					if (noCreditosActualesPorCliente > 0) {
						integrantesCredAct.add(integrante);
					}*/
			}

			String mensaje = "";
			for (int i = 0; i < integrantesCredAct.size(); i++) {
				IntegranteOV integranteCredAct = integrantesCredAct.get(i);
				mensaje = integranteCredAct.getCliente() + " ";
			}

			if (!mensaje.isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"originacion.registrarcredito.errorcreditoactivocliente" ) + ": " + mensaje);
			}
			/*
			if ( contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 && integrantesCredAct.size() != 1 ) {
						String mensaje = " ";
						for (int i = 0; i < integrantesCredAct.size(); i++) {
							IntegranteOV integranteCredAct = integrantesCredAct.get(i);
							mensaje = integranteCredAct.getCliente() + " ";
						}
						throw new Exception(ReadProperties.mensajes.getProp(
								"originacion.registrarcredito.errorcreditoactivocliente" ) + ": " + mensaje);
			}
			if ( !contrato.isRenovacion() && integrantesCredAct.size() != 0) {
						String mensaje = " ";
						for (int i = 0; i < integrantesCredAct.size(); i++) {
							IntegranteOV integranteCredAct = integrantesCredAct.get(i);
							mensaje = integranteCredAct.getCliente() + " ";
						}
						throw new Exception( ReadProperties.mensajes.getProp(
								"originacion.registrarcredito.errorcreditoactivocliente" ) + ": " + mensaje);
			}
			*/
			//verificar duplicidad de creditos por integrante

			//Verificamos si es un producto de oportunidad
			if ( !categoria.equals( PREF_OPORTUNIDAD ) ) {
				ciclo++;
				LogHandler.debug(uid, getClass(), "NO ES CATEGORIA OPORTUNIDAD CICLO: " + ciclo);
			}

			//Asignamos el valor para el ciclo del grupo
 			contrato.getGrupo( ).setCiclo( ciclo );

 			//Actualizar informacion del grupo que es enviada por el credito
 			ResultadoOV resultado = null;

 			if ( !categoria.equals( PREF_OPORTUNIDAD ) ) {
				resultado = componenteGrupo.actualizarTx(uid, sesionTx, contrato.getGrupo( ) );

				if ( !resultado.isEstatus() ) {
					LogHandler.debug(uid, getClass(), ReadProperties.mensajes.getProp("originacion.registrar.errorregistro"));
					throw new Exception(ReadProperties.mensajes.getProp("originacion.registrar.errorregistro") );
				}
	 		}
			LogHandler.debug(uid, getClass(), "ACTUALIZA INFORMACION DEL GRUPO Realizado...");

		//COMERFIN 41 Comercial_20130717_Seguro de vida Finsol
		//MIMH 2013-10-29
		//Validacion monto seguro
			if ( contrato.getMontoSeguro() == null) {
				contrato.setMontoSeguro(0.0);
			}

			//MIMH 2014-10-14
			//Validacion monto seguro enfermedad
			if ( contrato.getMontoSeguroEnfermedad() == null) {
				contrato.setMontoSeguroEnfermedad(0.0);
			}

			//Fecha para el dia de pago
			final Calendar calendar = java.util.GregorianCalendar.getInstance();

			if ( contrato.getDiaPago() != null ) {
				calendar.set( Calendar.DAY_OF_WEEK , contrato.getDiaPago() + 1 );
			}

			final SimpleDateFormat simpleDateFormatAncla = new SimpleDateFormat( "yyyy-MM-dd" );

 			parametros.put( SUCURSAL, contrato.getSucursal( ) );
 			parametros.put( MONTO, contrato.getMonto_otorgado( ) + contrato.getMontoSeguro()
 							+ contrato.getMontoSeguroEnfermedad());
 			parametros.put( TASA, tasaMensual );
			parametros.put( NO_PAGOS, contrato.getPlazo( ) );
 			parametros.put( FRECUENCIA_PAGO, contrato.getFrecuencia()  );
 			parametros.put( CONTRATO, identificador );
 			parametros.put( SUCURSAL, contrato.getSucursal( ) );
 			parametros.put( FECHA_DISPOSICION, contrato.getFecha_desembolso( ) );
 			parametros.put( "fecha_contrato" , comun.obtenerFechaContable( uid ).getFecha() );
 			parametros.put( PRODUCTO, contrato.getProducto( ) );
 			parametros.put( "fecha_esp_liq", contrato.getFecha_esp_liquidacion() );
 			montoPago = calcularMonto( uid, sesionNTx, parametros );
 			parametros.clear();

			//Se da de alta el contrato SP en CREDPROD

 			contrato.setProducto( contrato.getProducto().trim() );

			parametros.put( CONTRATO, identificador );
			//MMH 2014-09-08 Almacenar numero solicitud contratos
			parametros.put( SOLICITUD, contrato.getSolicitud() == null ? "-1" : contrato.getSolicitud() );
			//parametros.put( SOLICITUD,"-1" );
			parametros.put( GRUPO, contrato.getGrupo( ).getIdentificador( ) );
			parametros.put( SUCURSAL, contrato.getSucursal( ) );
			parametros.put( ASESOR, contrato.getAsesor( ) != null
							?  AsesorData.obtenerClavePersona(uid, contrato.getAsesor( ) ) : "");
			parametros.put( RENOVACION, ciclo > 1 ? VALOR_RENOVACION_SI : VALOR_RENOVACION_NO );
			parametros.put( MONTO , contrato.getMonto_otorgado( ) + contrato.getMontoSeguro()
							+ contrato.getMontoSeguroEnfermedad());
 			parametros.put( MONTO_PAGO, montoPago );
			parametros.put( PLAZO, contrato.getPlazo( ) );
			parametros.put( TASA, tasaMensual );
			parametros.put( FRECUENCIA, contrato.getFrecuencia( ) );
			parametros.put( FECHA_DESEMBOLSO, contrato.getFecha_desembolso( ) );
			parametros.put( FECHA_DIA_PAGO, contrato.getDiaPago() != null ? simpleDateFormatAncla.parse(
							simpleDateFormatAncla.format( calendar.getTime() ) ) : contrato.getFecha_desembolso( ) );
			parametros.put( PRODUCTO, contrato.getProducto( ) );
			parametros.put( FECHA_TERMINO, contrato.getFecha_esp_liquidacion() );
			parametros.put( CONSECUTIVO, ciclo );
			parametros.put( FECHA_DISPOSICION, simpleDateFormat.format( contrato.getFecha_desembolso( ) ) );

			//OPERFIN 114 Almacenar el montoGarantia ***
			//MIMH 2013-08-21
			if ( contrato.getProducto().equals(PRODUCTO_DG_SEMANAL) ||  contrato.getProducto().equals(PRODUCTO_DG_CATORCENAL) ) {

				contrato.setMontoGarantia(contrato.getMonto_otorgado() * contrato.getPctGarantia() / 100);

				parametros.put( MONTO_AHORRO, contrato.getMontoGarantia() != null ? contrato.getMontoGarantia() : 0.0 );
			}
			else {
				parametros.put( MONTO_AHORRO, contrato.getMontoGarantia() != null ? contrato.getMontoGarantia() : 0.0 );
			}

			//COMERFIN 41 Comercial_20130717_Seguro de vida Finsol
			//MIMH 2013-10-29

			if ( contrato.getMontoSeguro() > 0 || contrato.getMontoSeguroEnfermedad() > 0 ) {
				parametros.put( MONTO_SEGURO    , contrato.getMontoSeguro() + contrato.getMontoSeguroEnfermedad());
				parametros.put( PCT_IVA_SEGURO  , ivaD);
			}
			else {
				parametros.put( MONTO_SEGURO   , 0.0);
				parametros.put( PCT_IVA_SEGURO , 0.0);
			}

		//Registrar Contrato
			LogHandler.trace(uid, getClass(), "==> registrar - registrarContrato");
			resultadoContrato = (ResultadoOV) sesionTx.selectOne( OPER_REGISTRAR_CONTRATO, parametros );
			LogHandler.debug(uid, getClass(), "OPER_REGISTRAR_CONTRATO " + OPER_REGISTRAR_CONTRATO
							+ " Realizado... 		ResultadoContrato: " + resultadoContrato );
			parametros.clear( );


			if ( resultadoContrato == null || !resultadoContrato.getCodigo().equals( CODIGO_CREDITO_OK ) ) {
				MSG += resultadoContrato != null ? ( resultadoContrato.getMensaje().toUpperCase() + " CODIGO: "
						+ resultadoContrato.getCodigo( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP alta_contrato.";
				LogHandler.debug(uid, getClass(), MSG);
				throw new Exception( MSG );
			}

		//insertamos el contrato grupo
			parametros.put( CONTRATO, identificador );
			parametros.put( ASESOR, AsesorData.obtenerClavePersona(uid, contrato.getAsesor( ) ) );
			parametros.put( MONTO_OTORGADO, contrato.getMonto_otorgado( ) );
			parametros.put( CICLO_GRUPO, contrato.getGrupo().getCiclo( ) );
			parametros.put( HORA_REUNION, contrato.getHora_reunion( ) != null ? contrato.getHora_reunion( ) : "");
			parametros.put( DIA_REUNION, contrato.getDia_reunion( ) != null ? contrato.getDia_reunion( ) : 0 );


			//2013-10-11
			//MMH Se insertan los nuevos campos de hora fin grupo y persona domicilio reunion
			if ( contrato.getNumero_cliente_reunion() != null ) {
				contrato.setNumero_cliente_reunion( comun.obtenerPersonaCliente(uid, contrato.getNumero_cliente_reunion()) );
			}
			parametros.put( "hora_reunion_fin", contrato.getHora_reunion_fin() != null ? contrato.getHora_reunion_fin( ) : "");
			parametros.put( "persona_dom_reunion", contrato.getNumero_cliente_reunion() != null
							? contrato.getNumero_cliente_reunion( ) : "");

		//Registrar Grupo
			LogHandler.trace(uid, getClass(), "==> registrar - registrarContratoGrupo" );
			sesionTx.insert( OPER_REGISTRAR_CONTRATO_GRUPO, parametros );
			parametros.clear( );
			LogHandler.debug(uid, getClass(), "OPER_REGISTRAR_CONTRATO_GRUPO  " + OPER_REGISTRAR_CONTRATO_GRUPO
							+ " Realizado...");


			//Generamos el identificador de contrato LD
			contratoLD = generarLdContrato( uid, sesionNTx );
			if ( contratoLD == null ) {
				LogHandler.debug( uid, getClass(), ReadProperties.mensajes.getProp("originacion.registrar.errorgenerarcontrato"));
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errorgenerarcontrato") );
			}

			//Agregar contrato clave finsol guaradar  el numero de contrato LD y numeero FISA
			LogHandler.debug(uid, getClass(), "ContratoLD: " + contratoLD );
			parametros.put( CONTRATO_LD, contratoLD );
			parametros.put( CONTRATO, identificador);
			LogHandler.trace(uid, getClass(), "==> registrar - " + "registrarContratoClaveFinsol");
			sesionTx.insert( "registrarContratoClaveFinsol", parametros );
			parametros.clear( );

			//Se cambia el nombre de los roles
			contrato.getGrupo().setPresidente( contrato.getGrupo().getPresidente() != null
					? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getPresidente()) : "" );
			contrato.getGrupo().setSecretario( contrato.getGrupo().getSecretario() != null
					? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getSecretario()) : "" );
			contrato.getGrupo().setTesorero( contrato.getGrupo().getTesorero() != null
					? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getTesorero())   : ""	);
			contrato.getGrupo().setSupervisor( contrato.getGrupo().getSupervisor() != null
					? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getSupervisor()) : "" );

			if ( !categoria.equals( PREF_OPORTUNIDAD ) )
				{
				//Actualizar el ciclo del grupo en la tabla de personas
				parametros.put( CICLO, contrato.getGrupo().getCiclo( ) );
				parametros.put( PERSONA, contrato.getGrupo().getIdentificador( ) );
				LogHandler.trace(uid, getClass(), "==> registrar - actualizarCicloGrupo" );
				sesionTx.update(OPER_ACTUALIZAR_CICLO_GRUPO, parametros );
				parametros.clear();
				LogHandler.debug(uid, getClass(), "OPER_ACTUALIZAR_CICLO_GRUPO: 			" + OPER_ACTUALIZAR_CICLO_GRUPO
								+ " Realizado...");

				//Actualizar el ciclo de los integrantes
				LogHandler.trace(uid, getClass(), "==> registrar - " + OPER_ACTUALIZAR_CICLO_INTEGRANTE);
				sesionTx.update( OPER_ACTUALIZAR_CICLO_INTEGRANTE, integrantes );
				LogHandler.debug(uid, getClass(), "OPER_ACTUALIZAR_CICLO_INTEGRANTE:		" + OPER_ACTUALIZAR_CICLO_INTEGRANTE
								+ " Realizado...");
				}

			//Se recupera a la persona con su ciclo actualizado
			LogHandler.trace(uid, getClass(), "==> registrar - obtenerCicloIntegrante ");
			List<HashMap<String, Object>> listaIntegranteCiclo = (List<HashMap<String, Object>>) sesionTx.selectList(
							"obtenerCicloIntegrante", integrantes);
 			HashMap<String, Integer> mapIntegrantesCiclo = new HashMap<String, Integer>();
 			for ( HashMap<String, Object> cicloIntegrante : listaIntegranteCiclo)
 				{
 				mapIntegrantesCiclo.put(cicloIntegrante.get("persona").toString(),
 						Integer.parseInt(cicloIntegrante.get("ciclo").toString()));
 				}

 			//Se valdia q todos los integrantes puedan ser actualizados en el ciclo
 			if ( mapIntegrantesCiclo.size() != contrato.getIntegrantes().length ) {
 				throw new Exception("No se pudo obtener el ciclo de todos los integrante");
 				}

			//Insertar Integrantes
			if ( contrato.getGrupo() != null && contrato.getIntegrantes( ) != null )
				{
				contrato.setIntegrantes( setRolIntegrantes(uid, contrato.getGrupo(), contrato.getIntegrantes( ) ) );
				}
			else {
				throw new Exception(ReadProperties.mensajes.getProp("originacion.registrar.errorintegrantesguardar") );
				}

			//Registrar integrantes

			if (!registrarIntegrantes( uid, sesionTx, identificador, contrato.getMonto_otorgado(),
					mapIntegrantesCiclo, contrato.getIntegrantes( ) ) )
				{
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errorintegrantesguardar") );
				}

			if (!comun.actualizarPorcentajeParticipacionIntegrante(uid, sesionTx, identificador)) {
			throw new Exception( "Existio un error en la actualizacion del porcentaje de los integrantes del credito anterior." );
			}


			//Movimientos Deposito Garantia ***
			if (contrato.getProducto().equals(PRODUCTO_DG_SEMANAL) ||  contrato.getProducto().equals(PRODUCTO_DG_CATORCENAL)) {
				Map<String, Object> parametrosGarantia = new HashMap<String, Object>( );
				parametrosGarantia.put("producto", contrato.getProducto() );
				parametrosGarantia.put("claveCondicion", PCT_DEP_GAR);
				parametrosGarantia.put("contrato", identificador);
				parametrosGarantia.put("valor", String.valueOf(contrato.getPctGarantia()
						!= null ? contrato.getPctGarantia() : 0.0));
				sesionTx.insert("insertarCondicionesContrato", parametrosGarantia);
			}


			//MIMH 2014-10-15
			//Registrar seguros
			//Seguro Vida
			if ( contrato.getMontoSeguro() > 0.0) {
				Map<String, Object> parametrosSeguro = new HashMap<String, Object>( );
				parametrosSeguro.put("producto", contrato.getProducto() );
				parametrosSeguro.put("claveCondicion", SEGURO_VIDA);
				parametrosSeguro.put("contrato", identificador);
				parametrosSeguro.put("valor", String.valueOf(contrato.getMontoSeguro()));
				sesionTx.insert("insertarCondicionesContrato", parametrosSeguro);
			}
			//Seguro Enfermedad
			if ( contrato.getMontoSeguroEnfermedad() > 0.0) {
				Map<String, Object> parametrosSeguro = new HashMap<String, Object>( );
				parametrosSeguro.put("producto", contrato.getProducto() );
				parametrosSeguro.put("claveCondicion", SEGURO_ENFERMEDAD);
				parametrosSeguro.put("contrato", identificador);
				parametrosSeguro.put("valor", String.valueOf(contrato.getMontoSeguroEnfermedad()));
				sesionTx.insert("insertarCondicionesContrato", parametrosSeguro);
			}

			parametros.put( CICLO, contrato.getGrupo().getCiclo( ) );

			//Actualiza monto-liq
			if ( contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 ) {
				//Se actualiza monto_liq_ctrant
				final HashMap<String, Object>
				paramActContrato = new HashMap<String, Object>();
				paramActContrato.put( "contrato", identificador );
				paramActContrato.put( "monto"	, contrato.getMontoFinanciado() );

				//Se actualiza el monto financiado
				LogHandler.trace(uid, getClass(), "==> registrar - actualizaMontoFinanciado");
				sesionTx.update( "actualizaMontoFinanciado", paramActContrato );
			}

			//Verificar duplicidad de creditos
			noCreditosActuales = 0;
			parametros.put( "grupo" , contrato.getGrupo( ).getIdentificador( ) );
			if (categoria.equals( PREF_OPORTUNIDAD ) ) {
				parametros.put( "tipo", 1 );

				LogHandler.trace(uid, getClass(), "==> registrar - obtenerCreditosActuales" );
				//***Se cambio sesionNTx
				noCreditosActuales  = (Integer) sesionTx.selectOne( "obtenerCreditosActuales", parametros );

				if (noCreditosActuales == 0) {
					throw new Exception(ReadProperties.mensajes.getProp("originacion.registrarcredito.errorcreditosactuales"));
				}
			}


			parametros.clear();

			//ORIG-458 AOC
			//Se obtiene los desertores si Aplicar Garantia desertor
			Double montoAplicarGarantiaDesertor = 0.0;

			//VARIABLE PARA SABER SI SE APLICO GARANTIA POR DESERTOR
	        boolean aplicoGarantiaDesertor = false;
			if (express.trim().equals("S") && contrato.getRenovacionFinanciada()) {
	        	if (contrato.getAplicarGarantiaDesertor() != null) {
	        		//Se obtiene los desertores si Aplicar Garantia desertor
		            if (contrato.getRenovacionFinanciada() && contrato.getAplicarGarantiaDesertor().equals("S")) {

		                Double sumaPctParticipacion = 0.0;

		                //Obtener los elementos de integrantes
		                LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarIntegrantesGarantiaDesertor");
		                LogHandler.info(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarIntegrantesGarantiaDesertor");
		                @SuppressWarnings("unchecked")
		                List<IntegranteOV> integrantesListGarantia = (List<IntegranteOV>) sesionNTx.selectList(
		                                    "obtenerConfirmarIntegrantesGarantiaDesertorExpress", contrato.getSolicitud());

		                if (integrantesListGarantia == null || integrantesListGarantia.size() == 0) {
		                    throw new Exception("La consulta no arrojo resultados de integrantes para la solicitud");
		                }

		                for (int i = 0; i < integrantesListGarantia.size(); i++) {
		                    montoAplicarGarantiaDesertor = montoAplicarGarantiaDesertor
		                            + integrantesListGarantia.get(i).getDesertorGarantiaAplicar();

		                    sumaPctParticipacion = sumaPctParticipacion
		                            + integrantesListGarantia.get(i).getPctParticipacion();
		                }

		                LogHandler.info(uid, getClass(), "montoAplicarGarantiaDesertor: " + montoAplicarGarantiaDesertor);
		                LogHandler.info(uid, getClass(), "sumaPctParticipacion: " + sumaPctParticipacion);

		                //Datos Contrato Anterior
		                String contratoAnteriorDesertor = comun.obtenerNumeroContrato(uid, contrato.getContratoActual());

		                final java.util.HashMap<String, Object> parametrosConAntDesertor = new HashMap<String, Object>();
		                parametrosConAntDesertor.put( "contratoAnt" , contratoAnteriorDesertor);

		                LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtDatAntConfirmar");
		                ContratoOV contratoAntOVDesertor = (ContratoOV) sesionTx.selectOne("obtDatAntConfirmar", parametrosConAntDesertor);

		                if ( contratoAntOVDesertor == null) {
		                    throw new Exception("No se pudo recuperar informacion del contrato anterior para el traspaso de"
		                            + " garantia.");
		                }

		                if (montoAplicarGarantiaDesertor > 0.0 ) {

		                	//Se obtienen los parametros que se van a enviar
		                    //Se inserta el tipo de movimiento en contrato_movimientos_dg
		                    FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

		                    // Obtiener id de transaccion
		                    Integer idTransa = comun.obtenerIdTransaccion(uid, contrato.getSucursal(), fechaContableOV.getFecha());
		                    LogHandler.info(uid, getClass(), " idTransaccion=" + idTransa);

		                    double montoCapital = 0.0;
		                    double montoInteres = 0.0;
		                    double montoRecargos = 0.0;

		                    //Se inserta el tipo de movimiento en contrato_movimientos_dg
		                    HashMap<String, Object> paramsMovimientos = new HashMap<String, Object>();
		                    paramsMovimientos.put("contrato", contratoAnteriorDesertor);
		                    paramsMovimientos.put("codigo", CODIGO_APLICA_GARANTIA_DESERTOR);
		                    paramsMovimientos.put("fechaContable", formatter.format(fechaContable.getTime()));
		                    paramsMovimientos.put("fechaValor", formatter.format(fechaContable.getTime()));
		                    paramsMovimientos.put("importe", montoAplicarGarantiaDesertor);
		                    paramsMovimientos.put("montoCapital", montoCapital);
		                    paramsMovimientos.put("montoInteres", montoInteres);
		                    paramsMovimientos.put("montoRecargos", montoRecargos);
		                    paramsMovimientos.put("usuario", "000000043");
		                    paramsMovimientos.put("noIntegrante", "");
		                    paramsMovimientos.put("folioCheque", 0);
		                    paramsMovimientos.put("contratoTransaccion", "");
		                    paramsMovimientos.put("fechaBaja", "");
		                    paramsMovimientos.put("usuarioBaja", "");

		                    for ( String string : paramsMovimientos.keySet() ) {
		                        LogHandler.info(uid, getClass(), string + " -- " + paramsMovimientos.get( string ) );
		                    }

		                    LogHandler.trace(uid, getClass(), "==> insertaMovimientoDepositoGarantia - insertContratoMovimientosGarantia");
		                    sesionTx.insert("insertContratoMovimientosGarantia", paramsMovimientos);

		                    //Se hace un update a contrato_deposito_garantia
		                    HashMap<String, Object> paramsActDepGar = new HashMap<String, Object>();
		                    paramsActDepGar.put("contrato", contrato.getContratoActual());
		                    paramsActDepGar.put("montoAplicar", montoAplicarGarantiaDesertor);
		                    LogHandler.trace(uid, getClass(),
		                            "==> aplicarGarantiaLiquidacion - actualizaSaldoGarantiaDepositoGarantia");
		                    sesionTx.update("actualizaSaldoGarantiaDepositoGarantia", paramsActDepGar);

		                    //Pago
		                    final PagoGrupal pago = new PagoGrupal();
		                    PagoGrupalResponse pagoResponse = new PagoGrupalResponse();

		                    pago.setMonto(montoAplicarGarantiaDesertor);
		                    pago.setNumeroContrato(contratoAnteriorDesertor);
		                    pago.setMedioPago(contratoAntOVDesertor.getMedioPago() + "_");
		                    pago.setReferencia("");
		                    pago.setTipoPago(ConstantesPagos.TIPO_PAGO_ABONO.getValue());
		                    pago.setUsuario(contrato.getUsuario());
		                    pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());
		                    pago.setIdTransaccionValida(null);
		                    LogHandler.info(uid, getClass(), "medio Pago: Pago " + pago.getMedioPago());
		                    pagoResponse = pagos.aplicarPagoGrupal(uid, sesionTx, idTransa, pago );

		                    if ( !pagoResponse.getHeader().isEstatus()) {
		                        throw new Exception(pagoResponse.getHeader().getMensaje());
		                    }

		                    aplicoGarantiaDesertor = true;
		                }
		            }
	        	}
			}

			//Si es una Renovacion Fin o Ord
			if (contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 ) {
				//Actualiza los montos a liquidar de los integrantes
				actualizarIntegrantes(uid, sesionTx, identificador, contrato.getIntegrantes( ));
			}

			//Se obtiene el ID de transaccion, util para mantener un control del proceso
			final Integer idTransaccion = comun.obtenerIdTransaccion(uid, contrato.getSucursal(), fechaContable);

			//Es oportunidad o Renovacion?
			if ( contrato.getContratoActual() != null && !contrato.getContratoActual().trim().equals( "" ) ) {
				//Se registra el contrato en folio_notas
				final HashMap<String, Object>
								paramFolioNotas = new HashMap<String, Object>();
								paramFolioNotas.put( "header", "P" );
								paramFolioNotas.put( "contrato", identificador );
								paramFolioNotas.put( "montoLiquidar", contrato.getMontoFinanciado() );
								paramFolioNotas.put( "montoPromedio", 0 );
								paramFolioNotas.put( "folio", generarFolio( uid, contrato.getSucursal(), sesionTx ) );
								paramFolioNotas.put( "contratoAnterior", contrato.getContratoActual() );
								paramFolioNotas.put( "fechaHora", comun.obtenerFechaActual( uid ) );
								paramFolioNotas.put( "folioPagare", "" );

				LogHandler.trace(uid, getClass(), "==> registrar - registrarFolioNotas");
				sesionTx.selectOne( "registrarFolioNotas", paramFolioNotas);

				//Validacion fecha contable igual a fecha desembolso
				if (fechaContable != null && simpleDateFormat.format(contrato.getFecha_desembolso( ))
						.equals( simpleDateFormat.format( fechaContable ) ) ) {

					//Si es una renovacion financiada se actualizan los folios
					if ( contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 ) {

						//Se aplica el pago al contrato vigente por el monto del saldo de los integrantes a renovar
						//aplicarPago(uid, sesionTx, idTransaccion, contrato );
						//Objeto auxiliar para dar de alta un pago
						final 	PagoGrupal
							pagoGrupal = new PagoGrupal();
							pagoGrupal.setIdPago( 0 );
							pagoGrupal.setCodigo( "PADO" );
							pagoGrupal.setFechaValor( null );
							pagoGrupal.setMedioPago( "" );
							pagoGrupal.setMonto( contrato.getMontoFinanciado() );
							pagoGrupal.setNumeroContrato( contrato.getContratoActual() );
							pagoGrupal.setReferencia("");

							//06/06/2013 OPERFIN-90
							pagoGrupal.setTipoPago("ABO");

							if ( !pagos.aplicarPagoGrupal(uid, sesionTx, idTransaccion, pagoGrupal).getHeader().isEstatus() ) {
								throw new Exception( ReadProperties.mensajes.getProp("ciof.error.aplicarpagos") );
							} else {
									params.clear();
									params.put(SUCURSAL, contrato.getSucursal() );
									params.put(FECHA_CONTABLE, formatter.format(fechaContable));
									params.put(MONTO, contrato.getMontoFinanciado() );
									LogHandler.trace(uid, getClass(), "==> registrar - registraCajaInventario ");
									sesionTx.selectOne("registraCajaInventario", params);

									params.clear();
									params.put(CODIGO, CODIGO_CANC_PAGODOC );
									params.put(CONTRATO, contrato.getContratoActual());
									params.put(SUCURSAL, contrato.getSucursal() );
									params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
									params.put(FECHA_CONTABLE, formatter.format(fechaContable));
									params.put(MONTO, contrato.getMontoFinanciado() );
									params.put(IDXTRXCAJA, idTransaccion);
									params.put(FECHA_ACTUAL, formatter.format( fechaContable ) );
									params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
									params.put(CLAVE, 0);
									params.put(CLAVE_PRODUCCION, "");
									params.put(REFERENCIA1, " ");
									params.put(REFERENCIA2, " ");
									params.put(REFERENCIA3, " ");
									LogHandler.trace(uid, getClass(), "==> registrar - " + "registraOperacionCaja");
									resultado = (ResultadoOV) sesionTx.selectOne( "registraOperacionCaja", params );
									params.clear();

									if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
										LogHandler.info(uid, this.getClass(), ReadProperties.mensajes.getProp(
												"ciof.error.cajavirtualregistro"));
										throw new Exception( ReadProperties.mensajes.getProp("ciof.error.cajavirtualregistro") );
									}
								}
						} //Fin Si es una renovacion financiada se actualizan los folios

				//Actualizar los folios notas
					final HashMap<String, String>
								paramUpdateNotasFolio = new HashMap<String, String>();
								paramUpdateNotasFolio.put( "contratoVigente", contrato.getContratoActual());
								paramUpdateNotasFolio.put( "contratoNuevo"  , identificador);
								paramUpdateNotasFolio.put( "status"			, "L");

				//Se actualiza folio-notas
					LogHandler.trace(uid, getClass(), "==> registrar - actualizarFolioNotas");
					int act = sesionTx.update( "actualizarFolioNotas", paramUpdateNotasFolio );

					LogHandler.info(uid, getClass(), "Numero de registros afectados en la actualizacion : " + act);

					if ( act == 0 ) {
						throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errordisposicion") );
						//Error al generar la disposicion de contrato
					}

					DesembolsoOV desembolso = new DesembolsoOV();
					desembolso.setContrato(identificador);
					desembolso.setMonto( contrato.getMonto_otorgado( ) );
					desembolso.setSucursal( contrato.getSucursal() );
					desembolso.setOperador( OPERADOR_DEF );
					resultado = desembolsarTx(uid, idTransaccion, sesionTx, fechaContable, desembolso );

					if ( resultado == null || !(resultado.getCodigoRetorno() == 1)) {
						MSG += resultado != null ? ( resultado.getMensaje().toUpperCase() + " CODIGO: "
						+ resultado.getCodigoRetorno( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP Caja_Trad_Disp.";
						LogHandler.debug(uid, getClass(), MSG);
						throw new Exception(MSG);
					} else {
					//Se da de alta en movimiento y en auditoria caja el movimiento de desembolso con DISP
						params.clear();
						params.put(SUCURSAL, contrato.getSucursal() );
						params.put(FECHA_CONTABLE, formatter.format(fechaContable));
						params.put(MONTO, contrato.getMonto_otorgado( ));
						LogHandler.trace(uid, getClass(), "==> registrar - registraCajaInventario ");
						sesionTx.selectOne("registraCajaInventario", params);

						params.clear();
						params.put(CODIGO, CODIGO_PAGO_DISP );
						params.put(CONTRATO, identificador);
						params.put(SUCURSAL, contrato.getSucursal() );
						params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
						params.put(FECHA_CONTABLE, formatter.format(fechaContable));
						params.put(MONTO, contrato.getMonto_otorgado( ) );
						params.put(IDXTRXCAJA, idTransaccion);
						params.put(FECHA_ACTUAL, formatter.format( fechaContable ) );
						params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
						params.put(CLAVE, 0);
						params.put(CLAVE_PRODUCCION, "");
						params.put(REFERENCIA1, " ");
						params.put(REFERENCIA2, " ");
						params.put(REFERENCIA3, " ");
						LogHandler.trace(uid, getClass(), "==> registrar - " + "registraOperacionCaja");
						resultado = (ResultadoOV) sesionTx.selectOne( "registraOperacionCaja", params );
						params.clear();

						if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
							LogHandler.info(uid, this.getClass(), ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
							throw new Exception(ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
							//ERROR AL TRATAR DE ABRIR LA CAJA
						}
						LogHandler.debug(uid, getClass(), ReadProperties.mensajes.getProp("ciof.error.commit"));

						}
				} else {
					LogHandler.debug(uid, getClass(), ReadProperties.mensajes.getProp("ciof.error.commit"));
				} //FinValidacion fecha contable igual a fecha desembolso

			} else {

			//Se verifica el desembolso para los contratos normales
				if ( fechaContable != null && simpleDateFormat.format( contrato.getFecha_desembolso( ) ).equals(
						simpleDateFormat.format( fechaContable ) ) ) {
					final DesembolsoOV desembolso = new DesembolsoOV();
					desembolso.setContrato(identificador);
					desembolso.setMonto( contrato.getMonto_otorgado( ) );
					desembolso.setSucursal( contrato.getSucursal() );
					desembolso.setOperador( OPERADOR_DEF );
					resultado = desembolsarTx(uid, idTransaccion, sesionTx, fechaContable, desembolso );
				}

				LogHandler.debug(uid, getClass(), ReadProperties.mensajes.getProp("ciof.error.commit"));
			} //fin else Es oportunidad o Renovacion?


//		Traspaso si Garantia
//			Que los dos contratos existan
//			Que los dos sean del producto garantía.
//			Que el crédito viejo este liquidado, estatus P.
//			Que el saldo de la garantía a traspasar sea mayor a 0.
			//Validamos si es express
		if (express.trim().equals("S")) {
		if (contrato.getTraspasoGarantia().equals("S")) {
		if (contrato.getProducto().trim().equals("GCDG") || contrato.getProducto().trim().equals("GCDC") ) {

				SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
				contrato.setContratoActual(registrarSolicitud.getContratoActual());
				String contratoAnterior = comun.obtenerNumeroContrato(uid, contrato.getContratoActual());

				if (contratoAnterior == null) {
					throw new Exception("No hay resultados para obtener el numero de contrato anterior.");
				}

				final java.util.HashMap<String, Object> parametrosConAnt = new HashMap<String, Object>();
				parametrosConAnt.put( "contratoAnt" , contratoAnterior);

				LogHandler.trace(uid, getClass(), "registrar: - obtDatAntConfirmar");
				ContratoOV contratoAnt = (ContratoOV) sesionTx.selectOne("obtDatAntConfirmarTraspaso", parametrosConAnt);

				if ( contratoAnt == null) {
					throw new Exception("No se pudo recuperar informacion del contrato anterior para el traspaso de"
							+ " garantia.");
				}

				if (contratoAnt.getSaldoGarantia() > 0) {
					if ( contratoAnt.getProducto().trim().equals("GCDG")
							|| contratoAnt.getProducto().trim().equals("GCDC") ) {

						final java.util.HashMap<String, Object> parametrosTraspasoPct = new HashMap<String, Object>();
						parametrosTraspasoPct.put("contratoAnt" , contratoAnterior);
						parametrosTraspasoPct.put("contratoNuevo", identificador);

						LogHandler.trace(uid, getClass(), "registrar: - obtenerIntegrantesContratosTraspaso");
						TraspasoGarantiaOV obtenerSumPct = (TraspasoGarantiaOV)
								sesionTx.selectOne("obtenerIntegrantesContratosTraspaso", parametrosTraspasoPct);

						if ( obtenerSumPct == null) {
							throw new Exception("No se pudo obtener la suma de porcentajes");
						}

						//Redondeo
						obtenerSumPct.setPctParticipacionTotal(obtenerSumPct.getPctParticipacionTotal());
						Double saldoTraspaso = contratoAnt.getSaldoGarantia() * obtenerSumPct.getPctParticipacionTotal();
						saldoTraspaso = Funciones.redondeo(saldoTraspaso);

						//Sumar Garantia Credito Nuevo
						final java.util.HashMap<String, Object> parametrosSumTraspaso = new HashMap<String, Object>();
						parametrosSumTraspaso.put("contratoAnt" , contratoAnterior);
						parametrosSumTraspaso.put("contratoNuevo", identificador);
						parametrosSumTraspaso.put("saldoTraspaso" , saldoTraspaso);

						LogHandler.trace(uid, getClass(), "registrar: - insertarTraspasoConDepGar");
						Integer contratoValor = sesionTx.insert( "insertarTraspasoConDepGar", parametrosSumTraspaso);

						LogHandler.info(uid, getClass(), "numeroRegistros: " + contratoValor);

						final java.util.HashMap<String, Object> parametrosSumTraspaso2 = new HashMap<String, Object>();
						parametrosSumTraspaso2.put("contratoAnt" , contratoAnterior);
						parametrosSumTraspaso2.put("contratoNuevo", identificador);
						parametrosSumTraspaso2.put("saldoTraspaso" , saldoTraspaso);
						parametrosSumTraspaso2.put("codigo", "DGTR");
						parametrosSumTraspaso2.put("fechaContable" , formato.format(fechaContable));
						parametrosSumTraspaso2.put("usuario", "000000043");

						LogHandler.trace(uid, getClass(), "registrar: - insertarTraspasoSumConMovDepGar");
						sesionTx.insert( "insertarTraspasoSumConMovDepGar", parametrosSumTraspaso2 );

						//Restar Garantia Credito Viejo
						final java.util.HashMap<String, Object> parametrosResTraspaso = new HashMap<String, Object>();
						parametrosResTraspaso.put("contratoAnt" , contratoAnterior);
						parametrosResTraspaso.put("saldoTraspaso" , saldoTraspaso);
						parametrosResTraspaso.put("saldoGarantia", contratoAnt.getSaldoGarantia());

						LogHandler.trace(uid, getClass(), "registrar: - actualizarSaldoDepGar");
						sesionTx.update("actualizarSaldoDepGar", parametrosResTraspaso);

						parametrosResTraspaso.put("contratoNuevo", identificador);
						parametrosResTraspaso.put("codigo", "TRGR");
						parametrosResTraspaso.put("fechaContable" , formato.format(fechaContable));
						parametrosResTraspaso.put("usuario", "000000043");

						LogHandler.trace(uid, getClass(), "registrar: - insertarTraspasoConMovDepGarRes");
						sesionTx.insert( "insertarTraspasoConMovDepGarRes", parametrosResTraspaso );

						}
					}
				}
			} //Fin Traspaso si Garantia
		} //Fin if express

		//Se prepara un solo commit si no es sesion externa
			if (!sesionExterna) {

				sesionTx.commit(true);

				// se calcula y se guarda el CAT del contrato solo para las que no tienen trasaccional
				LogHandler.trace(uid, getClass(), "==> registrar - obtenerAmortizacionGrupal" );
				final List<AmortizacionOV> pagosAmortizacion =
						(List<AmortizacionOV>) sesionNTx.selectList("obtenerAmortizacionGrupal", identificador );

				final List<Double>
						pagosPeriodo = new ArrayList<Double>();

				try {

					for (AmortizacionOV amortizacionOV : pagosAmortizacion) {
						final java.lang.Double  montoSinIva = amortizacionOV.getAbonoCapital()
								+ ( amortizacionOV.getInteresPeriodo() / ( 1.0 + ivaD / 100.0 ));
						pagosPeriodo.add( montoSinIva );
					}

					final ConsultaCATPeticion consultaCATPeticion = new ConsultaCATPeticion();
					consultaCATPeticion.setMontoCredito( contrato.getMonto_otorgado( ) );
					consultaCATPeticion.setPagos( pagosPeriodo );
					consultaCATPeticion.setPeriodo( contrato.getFrecuencia( ).trim().startsWith( "S" ) ? 52
							: contrato.getFrecuencia( ).trim().startsWith( "C" ) ? 26 : 12 );
					consultaCATPeticion.setPlazo( pagosPeriodo.size() );

					LogHandler.info(uid, getClass(), "Objeto que se envia a calcular el CAT : " + consultaCATPeticion );

					final ConsultaCATRespuesta
						  consultaCATRespuesta = consultas.consultarCAT( consultaCATPeticion, uid );


					final java.util.HashMap<String, Object>
							paramsCondicionesContrato = new HashMap<String, Object>();
							paramsCondicionesContrato.put( "producto", contrato.getProducto() );
							paramsCondicionesContrato.put( "contrato", identificador );
							paramsCondicionesContrato.put( "valor"	 , consultaCATRespuesta.getCAT().toString() );

					LogHandler.trace(uid, getClass(), "==> registrar - insertarCondicionesContratoCAT");
					//Cambio sesion NTX a TX
					sesionTx.insert( "insertarCondicionesContratoCAT", paramsCondicionesContrato );
					sesionTx.commit(true);
				} catch (java.lang.Exception exception) {
					LogHandler.error( uid, getClass(), ReadProperties.mensajes.getProp("originacion.registrarcredito.errorcat")
							+ contratoLD, exception );
				}

				//2013-10-11
				//MMH Registrar sucursal cobranza

				final HashMap<String, Object>	paramActSucursalCobranza = new HashMap<String, Object>();
				paramActSucursalCobranza.put("tipo_ejecucion", "U");
				paramActSucursalCobranza.put("contrato", identificador);

				LogHandler.trace(uid, getClass(), "==> registrar - actualizaSucursalCobranza");
				sesionNTx.selectOne( "actualizaSucursalCobranza", paramActSucursalCobranza );

				//Se hace un update a a solicitudes_finsol
				if (aplicoGarantiaDesertor) {
	                LogHandler.trace(uid, getClass(),
	                        "==> aplicarGarantiaDesertor - updateSolicitudFinsolDesertor");
	                int sol = sesionTx.update("updateSolicitudFinsolDesertor", contrato.getSolicitud());
					LogHandler.info(uid, getClass(), "Numero de registros afectados en solicitudes_finsol : " + sol);
				}

				LogHandler.info(uid, getClass(), "==> registrar - COMMIT sesion NO externa." );
				sesionTx.commit(true);
			}

			regreso.setIva(ivaD);
			regreso.getHeader().setMensaje( MENSAJE_ALTA_CONTRATO );
			regreso.setContrato( identificador );
			regreso.setLd_contrato( contratoLD );
			regreso.setGrupo(contrato.getGrupo( ).getIdentificador( ));
			regreso.setCiclo(ciclo);
			regreso.setPeticion_ofs(contrato.getPeticion_ofs());
		} catch ( Exception e ) {
			e.printStackTrace();
			//FabricaConexiones.rollBack( sesionTx );
			if (!sesionExterna) {
				FabricaConexiones.rollBack(sesionTx);
			}
			LogHandler.debug(uid, getClass(), "ROLLBACK REALIZADO...");
			regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException
					? MENSAJE_TIMEOUT + e.getMessage() : e.getMessage() );
			regreso.getHeader().setEstatus( false );
			regreso.getHeader().setCodigo( null );
			regreso.getHeader().setUID(uid);
			LogHandler.error( uid, getClass(), MSG != null ? MSG : "EXISTIO UN ERROR EN EL REGISTRO DEL CONTRATO "
					+ contratoLD + " MENSAJE: " + e.getMessage(), e);
		}
		finally {
			//FabricaConexiones.close( sesionTx );
			FabricaConexiones.close( sesionNTx );
			if (!sesionExterna) {
				FabricaConexiones.close(sesionTx);
			}
			LogHandler.info(uid, getClass(), "EL CONTRATO: " + contratoLD + " HA SIDO CREADO EXITOSAMENTE... " + regreso);
		}
		return regreso;
	}


	/**
	 * @param contrato
	 * @param ints
	 */
	private IntegranteOV[] setRolIntegrantes( String uid, GrupoOV grupo, IntegranteOV[] ints) {
		IntegranteOV[] intsRol = ints;
		for ( IntegranteOV integrante : intsRol ) {
			if ( grupo.getPresidente() != null && grupo.getPresidente().equals( integrante.getCliente() ) ) {
				integrante.setRol( ROL_PRES );
				grupo.setPresidente( integrante.getCliente() );
				LogHandler.debug(uid, getClass(),"PRESIDENTE ASIGNADO: " + integrante.getCliente() );
			}
			else if ( grupo.getSecretario() != null && grupo.getSecretario().equals( integrante.getCliente() ) ) {
				integrante.setRol( ROL_SECR );
				LogHandler.debug(uid, getClass(),"SECRETARIO ASIGNADO: " + integrante.getCliente() );
			}
			else if ( grupo.getSupervisor() != null && grupo.getSupervisor().equals( integrante.getCliente() ) ) {
				integrante.setRol( ROL_SUPE );
				LogHandler.debug(uid, getClass(),"SUPERVISOR ASIGNADO: " + integrante.getCliente() );
			}
			else if ( grupo.getTesorero() != null && grupo.getTesorero().equals( integrante.getCliente() ) ) {
				integrante.setRol( ROL_TESO );
				LogHandler.debug(uid, getClass(),"TESORERO ASIGNADO: " + integrante.getCliente() );
			}
			else {
				integrante.setRol( ROL_INTE );
				LogHandler.debug(uid, getClass(),"INTEGRANTE ASIGNADO: " + integrante.getCliente() );
			}
		}
		return intsRol;
	}

	/**
	 *
	 * @param sesion
	 * @param grupo
	 * @param consecutivo_grupo
	 * @param ciclo
	 * @param integrantes
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private boolean registrarIntegrantes( String uid, SqlSession sesion, String identificador, Double montoContrato, HashMap<String,Integer> ciclo,  IntegranteOV[ ] integrantes ) {
		HashMap<String, Object> parametros;
		for ( IntegranteOV integrante : integrantes ) {
			//Se determina el tipo de localidad
			try	{
				LogHandler.trace(uid, getClass(), "==> registrarIntegrantes - obtenLocalidadPersona");
				final java.util.List<String> 
								localidades = (List<String>)sesion.selectList( "obtenLocalidadPersona", integrante.getCliente() );

				integrante.setTipoLocalidad( localidades == null ? "" : localidades.size() == 1 ? localidades.get(0) == null ? "" : localidades.get(0) : "U" );
				}
			catch ( java.lang.Exception exception )
				{
				integrante.setTipoLocalidad( "" );
				}

			//OPERFIN 114 Almacenar el montoGarantia
			//MIMH 2013-08-21
			if( integrante.getMontoSeguro() == null )
				integrante.setMontoSeguro( 0.0 );
			if( integrante.getMontoSeguroEnfermedad() == null )
				integrante.setMontoSeguroEnfermedad( 0.0 );
			
			parametros = new HashMap<String, Object>( );
			parametros.put( CONTRATO, identificador );
			parametros.put( INTEGRANTE , integrante.getCliente() );
			parametros.put( ROL, integrante.getRol( ) != null ? integrante.getRol( ) : ROL_INTE );  
			parametros.put( CICLO_INTEGRANTE, ciclo.get(integrante.getCliente()));
			parametros.put( MONTO_OTORGADO, integrante.getMonto( ) );
			parametros.put( DESTINO_CREDITO, integrante.getObjetivo() ) ;
			parametros.put( CAPITAL_INSOLUTO, integrante.getMonto() ) ;
			parametros.put( TIPO_LOCALIDAD, integrante.getTipoLocalidad() );
			parametros.put( PORCENTAJE_PARTICIPACION, ( integrante.getMonto( ) / montoContrato ) * 100.0 );
			parametros.put( "cheque", Integer.valueOf( integrante.getCheque() == null || integrante.getCheque().trim().equals( "" ) ? "0" : integrante.getCheque() ) );
			parametros.put( "monto_seguro", integrante.getMontoSeguro() + integrante.getMontoSeguroEnfermedad());
			parametros.put( "monto_seguro_vida", integrante.getMontoSeguro());
			parametros.put( "monto_seguro_enfermedad", integrante.getMontoSeguroEnfermedad());
			
			//COMERFIN 41 Comercial_20130717_Seguro de vida Finsol
			//MIMH 2013-11-11
			
			LogHandler.trace(uid, getClass(), "==> registrarIntegrantes - " + OPER_REGISTRAR_INTEGRANTE_GRUPO);
			sesion.insert( OPER_REGISTRAR_INTEGRANTE_GRUPO, parametros );
		}
		return true;
	}

	private boolean actualizarIntegrantes( String uid, SqlSession sesion, String identificador,  IntegranteOV[ ] integrantes )
		{
		HashMap<String, Object> parametros;
		for ( IntegranteOV integrante : integrantes ) {
			parametros = new HashMap<String, Object>( );
			parametros.put( "montoFin", integrante.getMontoFinanciado());
			parametros.put( "contrato", identificador );
			parametros.put( "integrante" , integrante.getCliente() );

			LogHandler.trace(uid, getClass(), "==> registrarIntegrantes - actualizarIntegranteGrupo");
			sesion.update( "actualizarIntegranteGrupo", parametros );
		}
		return true;
	}


	public DesembolsoRespuesta desembolsar( String uid, DesembolsoOV desembolso ) {
		String MSG = "DESEMBOLSADO.  ";
		SqlSession 				sesionTx	= null;
		DesembolsoRespuesta		regreso		= new DesembolsoRespuesta( );
		ResultadoOV				resultado	= null;
		regreso.setHeader( new EncabezadoRespuesta( ) );

		regreso.getHeader().setUID(uid);
		try {
			Date fechaContable = comun.obtenerFechaContable( uid ).getFecha();
			if ( fechaContable == null ) {
				LogHandler.debug(uid, getClass(), ReadProperties.mensajes.getProp("ciof.errorfechacontable"));
				throw new Exception( ReadProperties.mensajes.getProp("ciof.errorfechacontable") );
			}
			sesionTx  = FabricaConexiones.obtenerSesionTx( );
			resultado = desembolsarTx(uid, null, sesionTx, fechaContable, desembolso );
			if ( resultado == null || !(resultado.getCodigoRetorno() == 1)) {
				MSG += resultado != null ? ( resultado.getMensaje().toUpperCase() + " CODIGO: " + resultado.getCodigoRetorno( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP Caja_Trad_Disp.";
				LogHandler.debug(uid, getClass(),MSG);
				throw new Exception ( MSG );
			}
			sesionTx.commit( true );
			regreso.getHeader( ).setMensaje( MENSAJE_DISPOSICION_CONTRATO );
			regreso.getHeader().setEstatus( true );
			regreso.getHeader().setCodigo( resultado.getCodigoRetorno().toString() );
		} catch ( Exception e ) {
			e.printStackTrace();
			FabricaConexiones.rollBack( sesionTx );
			LogHandler.debug(uid, getClass(),"ROLLBACK REALIZADO...");
			regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + MSG : MENSAJE_ERROR + e.getMessage() );
			regreso.getHeader().setEstatus( false );
			regreso.getHeader().setCodigo( null );
			LogHandler.error(uid, getClass(), MSG + "  Existio un error al Ejecutar el desembolso del contrato: " + desembolso.getContrato() , e);
		}
		finally {
			FabricaConexiones.close( sesionTx );
			regreso.getHeader( ).setCorrelationId(uid);
			LogHandler.info(uid, getClass(),ReadProperties.mensajes.getProp("ciof.error.desembolso"));
		}
		return regreso;

	}
 
	/**
	 * 
	 * @param id
	 * @param sesionTx
	 * @param desembolso
	 * @return
	 */
	private ResultadoOV desembolsarTx (String uid, Integer idTransaccion,  SqlSession sesionTx, Date fechaContable, DesembolsoOV desembolso ) {
		String MSG = "DESEMBOLSADO.  ";
		Map<String, Object> 	params		= new HashMap<String, Object>( );
  		ResultadoOV				resultado 	= null;
 		SimpleDateFormat 		sdf 		= new  SimpleDateFormat("yyyyMMdd"); 
	
		try {
 			if ( idTransaccion == null )
 				{
 				idTransaccion = comun.obtenerIdTransaccion(uid, desembolso.getSucursal( ) , fechaContable );
 				if ( idTransaccion == null )
 					{
 					MSG = "EL ID TRX CAJA NO PUEDE SER NULO"; 
 					LogHandler.debug(uid, getClass(),MSG); 
 					throw new Exception ( MSG );
 					}
 				}
			LogHandler.debug(uid, getClass(), CONTRATO + " " +  desembolso.getContrato( ) );
			LogHandler.debug(uid, getClass(), SUCURSAL + " " +  desembolso.getSucursal( ) );
			LogHandler.debug(uid, getClass(), OPERADOR + " " +  desembolso.getOperador( ) );
			LogHandler.debug(uid, getClass(), FECHA_DISPOSICION + " " +  sdf.format( fechaContable ) );
			LogHandler.debug(uid, getClass(), FECHA_HORA_MOVIMIENTO + " " +   new Date( ) );
			LogHandler.debug(uid, getClass(), MONTO + " " +   desembolso.getMonto() );

			params.put( CONTRATO, desembolso.getContrato( ) );
			params.put( SUCURSAL, desembolso.getSucursal( ) );
			params.put( OPERADOR, desembolso.getOperador( ) );
			params.put( FECHA_DISPOSICION, sdf.format( fechaContable ) );
			params.put( FECHA_HORA_MOVIMIENTO,  new Date( ) );
			params.put( MONTO,  desembolso.getMonto() );
			params.put( IDX_TRX_CAJA, idTransaccion );
			LogHandler.trace(uid, getClass(), "==> desembolsarTx - " + "realizaDisposicion");
			resultado = ( ResultadoOV )sesionTx.selectOne( "realizaDisposicion" , params );
		}
		catch ( Exception e) {
			resultado.setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + MSG : MENSAJE_ERROR + e.getMessage() );
			resultado.setExcepcion( e.getCause() +"");
			resultado.setEstatus(false);
			resultado.setCodigo(null);
			LogHandler.error(uid, getClass(),MSG, e );
		}
		finally {
			resultado.setUid(uid);
			LogHandler.info(uid, getClass(),ReadProperties.mensajes.getProp("ciof.error.desembolso"));
		}
		return resultado;
	}

	//Funciones privadas  ------------------------------------------------------------------------------------------------
	
	/*Funcion para generar el folio para la tabla folios_nota a partir de sucursal_folio*/
	private String generarFolio(String uid, Integer sucursal, SqlSession sesionTx ) throws Exception
		{
		//Se obtiene el contador del folio
		LogHandler.trace(uid, getClass(), "==> generarFolio - obtenerSucursalFolio" );
		final Object folioRes = sesionTx.selectOne( "obtenerSucursalFolio", sucursal );		
		
		Long folioTabla   = folioRes == null ? 0 : ( Long ) folioRes;
		
		//Se aumenta el contador
		folioTabla ++;
		
		//Se actualiza el contador de la tabla sucursal_folio
		final HashMap<String, Object> 
					paramActualizaFolioSucursal = new HashMap<String, Object>();
					paramActualizaFolioSucursal.put( "folio"   , folioTabla);
					paramActualizaFolioSucursal.put( "sucursal", sucursal);
					
		if( folioTabla == 1 )
			{
			LogHandler.trace(uid, getClass(), "==> generarFolio - insertarSucursalFolio");
			sesionTx.insert( "insertarSucursalFolio", paramActualizaFolioSucursal );
			}
		else
			{
			LogHandler.trace(uid, getClass(), "==> generarFolio - actualizarSucursalFolio");
			sesionTx.update( "actualizarSucursalFolio", paramActualizaFolioSucursal );
			}
		
		//Formateo adecuado para el folio
		final java.text.DecimalFormat 
						decimalFormat = new DecimalFormat( "00000000" );
		
		final String folio = decimalFormat.format( folioTabla );
		
		return folio;
 		}


	public ClienteRespuesta actualizarNumeroCheque(String uid, ActualizarChequeClientePeticion peticion) 
		{
		//Objeto para almacenar la respuesta
		final ClienteRespuesta respuesta = new ClienteRespuesta();
		
		//Sesion para mybatis
		SqlSession sessionTx = null;
		try {
			//Conversion del contrato a dato de credprod_finsol
			peticion.setContrato( comun.obtenerNumeroContrato(uid, peticion.getContrato() ) );
			
			//Se abre la conexion transaccional a la base de datos
			sessionTx = FabricaConexiones.obtenerSesionTx();
			
			LogHandler.trace(uid, getClass(), "==> actualizarNumeroCheque - actualizarNumeroCheque" );
			final java.lang.Integer 
							actualizados = sessionTx.update( "actualizarNumeroCheque", peticion );
			
			//Se valida q se halla actualizado el registro
			if( actualizados == null || actualizados == 0 )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.actualizarnumerocheque.errordatosintegrante" ) );
				}
			
			//el commit a la transaccion
			sessionTx.commit( true );
			}
		catch( java.lang.Exception exception )
			{
			FabricaConexiones.rollBack( sessionTx );
			LogHandler.error(uid, getClass(), "Error al actualizar los cheques : " + exception.getMessage(), exception );
			respuesta.getHeader().setUID( uid );
			respuesta.getHeader().setMensaje( exception.getMessage() );
			respuesta.getHeader().setEstatus( false );
			}
		finally
			{
			FabricaConexiones.close( sessionTx );
			}
		
		return respuesta;
		}
		
	@SuppressWarnings("unchecked")
	public ContratoRespuesta registrarContratoRestructura( String uid, ContratoOV contrato ) 
	{
		ContratoRespuesta regreso = new ContratoRespuesta( );
		regreso.setHeader( new EncabezadoRespuesta( ) );
		regreso.getHeader().setUID( uid );
		regreso.getHeader().setEstatus(true);
		
		//Variables
		String 						identificador;
		SqlSession 					sesionNTx			= null ;
		SqlSession 					sesionTx			= null ;
		String 						MSG					= "REGISTRADO.  ";
		java.math.BigDecimal 		montoIntegrantes 	= new BigDecimal( 0 );
		List<String>				integrantes			= new ArrayList<String>( );
		SimpleDateFormat 			simpleDateFormat 	= new SimpleDateFormat("yyyyMMdd");
		HashMap<String, Object> 	parametros 			= new HashMap<String, Object>( );
		HashMap<String, Object> 	params				= new HashMap<String, Object>( );
		Date						fecha 				= new Date( );
		double 						tasaMensual			= 0d;
		Integer						ciclo				= 0;
		String						categoria 			= "";
		Integer 					noCreditosActuales  = 0;
		Double						montoPago			= null;
		ResultadoOV					resultadoContrato	= null;
		String 						contratoLD			= null;
		
		try {
			
			LogHandler.debug(uid, getClass(), "Datos de entrada : " + contrato );
 			
			if(!contrato.getProducto().equals(PRODUCTO_RESTRUCTURA)) {
				throw new Exception( "El producto de la peticion es incorrecto." );
			}
			
			identificador = generarContrato( uid ); //Obtenemos el numero de contrato
			if ( identificador == null ) 
				throw new Exception( ReadProperties.mensajes.getProp("ciof.noexisterelacion") );
			
			//Se valida la propiedad de renovacion
			if ( contrato.isRenovacion() == true )
				throw new Exception( "La peticion no puede ser una renovacion financiada." );				
			if ( contrato.isRenovacion() == null )
			{ contrato.setRenovacion( false ); }
						
			
			//Se valida que la hora de reunion que se ingreso sea correcta
			try {
				final SimpleDateFormat simpleDateFormatHoras = new SimpleDateFormat( "HH:mm" );
				if ( contrato.getHora_reunion( ) != null ) 
					{	simpleDateFormatHoras.parse( contrato.getHora_reunion( ) ).getTime(); 	}
				} 
			catch ( java.text.ParseException parseException ) 
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorhorareunion" ) );
				}
			
			//2013-10-11
			//MMH Se valida que la hora de reunion fin sea correcta
			try {
				final SimpleDateFormat simpleDateFormatHoras = new SimpleDateFormat( "HH:mm" );
				if ( contrato.getHora_reunion_fin() != null ) 
					{	simpleDateFormatHoras.parse( contrato.getHora_reunion_fin( ) ).getTime(); 	}
				} 
			catch ( java.text.ParseException parseException ) 
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorhorareunionfin" ) );
				}
			
			//Abrir caja	
			Date fechaContable = comun.obtenerFechaContable(uid ).getFecha();			
			LogHandler.debug(uid, this.getClass(),"Tratando de abrir la caja... ");
			ResultadoOV aperturaCaja = comun.aperturaCaja(uid, contrato.getSucursal(), fechaContable );
			if ( aperturaCaja.getCodigoRetorno() < 0 )
				{
				throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
				}
			
			
			//Se cambia el contrato a clave credprod
			if( contrato.getContratoActual() != null && !contrato.getContratoActual().trim().equals( "" ) )					
				{
				LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - obtenerNumeroContrato" );
				contrato.setContratoActual( comun.obtenerNumeroContrato(uid, contrato.getContratoActual().toString()).toString() );
				}
			else
				throw new Exception ( "El contrato vigente es necesario en la peticion." );
			
			if(contrato.getContratoActual() == null)
				throw new Exception ( "El contrato vigente no tiene relacion en credprod." );
														
			

			//Validar datos integrante en la tabla de personas contrato.getIntegrantes( )			
			if(contrato.getIntegrantes() == null)
				throw new Exception ( "La peticion debe tener al menos un integrante." );
			
			//Abrimos las conexiones correspondientes
			sesionNTx	= FabricaConexiones.obtenerSesionNTx( ); 
			
						
			for( IntegranteOV integrante : contrato.getIntegrantes( ) )
			{
				if( integrante.getMonto() == null || integrante.getMonto() == 0 )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontointegrante" ) );
					}
				
				if( integrante.getMontoFinanciado() == null || integrante.getMontoFinanciado()  == 0 )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontosolidariointegrante" ) );
				}
					
				if( integrante.getCliente() == null || integrante.getCliente().trim().equals( "" ) )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorcodigointegrante" ) );
					}
											
				//Se suman montos de los integrantes
				montoIntegrantes = montoIntegrantes.add( new BigDecimal( "" + integrante.getMonto() ) );
				
				integrante.setCliente(comun.obtenerPersonaCliente(uid, integrante.getCliente()));

				if( integrante.getCliente() != null && !integrante.getCliente().equals( "" ) ) { 
					integrantes.add( integrante.getCliente( ) ); 
				}

				//Validar el integrante pertenezca al contrato anterior
				parametros.clear();
				parametros.put("contrato", contrato.getContratoActual() );
				parametros.put("integrante", integrante.getCliente( ) );
				int contContratoCliente = 0;
				LogHandler.trace(uid,getClass(),"==> registrarContratoRestructura - verificarContratoCliente");
				contContratoCliente  = ( Integer ) sesionNTx.selectOne( "verificarContratoCliente", parametros);

				if (contContratoCliente != 1) {
					throw new Exception( "El cliente " + integrante.getCliente( ) + " no pertenece al contrato actual." );
				}

			}

			parametros.clear();

			LogHandler.info(uid, getClass(), "Los montos son mIs = " +  montoIntegrantes + ", mCp = " + contrato.getMonto_otorgado().doubleValue() );


			//Se validan los montos iguales
			if( montoIntegrantes.doubleValue() != contrato.getMonto_otorgado().doubleValue() )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontointegrantes" ) );
				}

			if(contrato.getMontoFinanciado() == null || contrato.getMontoFinanciado() <= 0)
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontofinanciado" ) );
				}


			//Se valida que la fecha de desembolso sea igual o mayor que la contable
			if( fechaContable != null &&  contrato.getFecha_desembolso().before( fechaContable ) )
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorfechadesembolsoinferior" ) );
				}

			int valorDias = Integer.parseInt(
					comun.obtenerParGeneralOV(uid, "com.mx.finsol.originacion.credito.fechaautorizacion").getCgValor());

			//Se valida que la fecha de desembolso no sea mayor que la fecha de autorizacion
			final java.util.Calendar 
							fechaAuto = Calendar.getInstance();
							fechaAuto.setTime( fechaContable );
							fechaAuto.add( Calendar.DAY_OF_YEAR , valorDias);
							
							
			if( contrato.getFecha_desembolso().after( fechaAuto.getTime() ) ) 
				{
				throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorfechadesembolsosuperior" )  + simpleDateFormat.format( fechaAuto.getTime() ) + "\"" );
				}
			
			//Abrimos las conexiones correspondientes			
			sesionTx	= FabricaConexiones.obtenerSesionTx( );
			
			//Calculamos el valor de la tasa mensual sin IVA, en cfuncion de la sucursal
			LogHandler.debug( uid, getClass(),SUCURSAL + ": " + contrato.getSucursal( ) );
			parametros.put( SUCURSAL, contrato.getSucursal( ) );
			parametros.put( FECHA, fecha );
			parametros.put( CODIGO , CODIGO_IVA );
			tasaMensual = calculaTasaMensual ( uid, sesionNTx, parametros, contrato.getTasa() );
			parametros.clear();
			
			
			//Obtener persona para grupo
			contrato.getGrupo( ).setIdentificador( comun.obtenerPersonaCliente(uid, contrato.getGrupo( ).getIdentificador( )) );
			ciclo = obtenerCiclo(uid, sesionNTx, contrato.getGrupo( ).getIdentificador( ) );
			
			LogHandler.debug(uid, getClass(),"Grupo: " + contrato.getGrupo( ).getIdentificador( ) + " Ciclo Actual: " + ciclo );

			//Verificar la categoria del producto
			categoria  = comun.obtenerCategoria(uid, contrato.getProducto() );
			LogHandler.debug(uid, getClass(),"categoria: " +  categoria );

			//Verificar duplicidad de creditos
			noCreditosActuales = 0;
			parametros.put( "grupo" , contrato.getGrupo( ).getIdentificador( ) );
			parametros.put( "tipo", 2 );

			LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - obtenerCreditosActuales" );
			noCreditosActuales  = ( Integer ) sesionNTx.selectOne( "obtenerCreditosActuales", parametros );

			if(noCreditosActuales != 0) {
				throw new Exception ( ReadProperties.mensajes.getProp("originacion.registrarcredito.errorcreditosactuales"));
			}

			//Verificamos si es un producto de oportunidad
			if ( !categoria.equals( PREF_OPORTUNIDAD ) ) {
				ciclo++;
				LogHandler.debug(uid, getClass(),"NO ES CATEGORIA OPORTUNIDAD CICLO: " + ciclo);
			}

			//Asignamos el valor para el ciclo del grupo
 			contrato.getGrupo( ).setCiclo( ciclo );

 			//Actualizar informacion del grupo que es enviada por el credito
 			ResultadoOV resultado = null;
 			resultado = componenteGrupo.actualizarTx(uid, sesionTx, contrato.getGrupo( ) );
			if ( !resultado.isEstatus() )
				{
				LogHandler.debug(uid, getClass(),ReadProperties.mensajes.getProp("originacion.registrar.errorregistro"));
				throw new Exception ( ReadProperties.mensajes.getProp("originacion.registrar.errorregistro") );
				}

			LogHandler.debug(uid, getClass(),"ACTUALIZA INFORMACION DEL GRUPO Realizado...");

			//Fecha para el dia de pago
			final 	Calendar
					calendar = java.util.GregorianCalendar.getInstance();
			if ( contrato.getDiaPago() != null ) {
				calendar.set( Calendar.DAY_OF_WEEK , contrato.getDiaPago() + 1 );
			}


			//Se calcula el montoPago

 			parametros.put( SUCURSAL, contrato.getSucursal( ) );
 			parametros.put( MONTO, contrato.getMonto_otorgado( )  );
 			parametros.put( TASA, tasaMensual );
			parametros.put( NO_PAGOS, contrato.getPlazo( ) );
 			parametros.put( FRECUENCIA_PAGO, contrato.getFrecuencia()  );
 			parametros.put( CONTRATO, identificador );
 			parametros.put( SUCURSAL, contrato.getSucursal( ) );
 			parametros.put( FECHA_DISPOSICION, contrato.getFecha_desembolso( ) );
 			parametros.put( "fecha_contrato" , comun.obtenerFechaContable( uid ).getFecha() );
 			parametros.put( PRODUCTO, contrato.getProducto( ) );
 			parametros.put( "fecha_esp_liq", contrato.getFecha_esp_liquidacion() );
 			montoPago = calcularMonto( uid, sesionNTx, parametros );
 			parametros.clear();

 			LogHandler.info(uid, getClass(), "==> registrarContratoRestructura - montoPago:" + montoPago );


 			//se recupera el iva
			final java.util.HashMap<String, Object> paramsIVA = new HashMap<String, Object>();
			paramsIVA.put( "sucursal" , contrato.getSucursal());
			paramsIVA.put( "codigo"   , "IVIN");
			paramsIVA.put( "fecha"	   , contrato.getFecha_contrato());
			
			LogHandler.trace(uid, getClass(), "==> recuperaMontosExtras - verValorHistorico " );
			final Integer iva = (Integer) sesionNTx.selectOne("verValorHistorico", paramsIVA);
				
			//Se obtiene la parte sin iva
			final Double ivaD = Double.parseDouble( iva.toString() );
			
			java.lang.Double  comisionSinIva = contrato.getMonto_otorgado() - contrato.getMontoFinanciado();  
			comisionSinIva = ( comisionSinIva / ( 1.0 + ivaD / 100.0 )) ;			
				
			 //Se da de alta el contrato SP en CREDPROD
 			final SimpleDateFormat simpleDateFormatAncla = new SimpleDateFormat( "yyyy-MM-dd" );
			parametros.put( CONTRATO, identificador );
			//MMH 2014-09-08 Almacenar numero solicitud contratos
			parametros.put( SOLICITUD, contrato.getSolicitud() == null ? "-1" : contrato.getSolicitud() );
			//parametros.put( SOLICITUD,"-1" );			
			parametros.put( GRUPO, contrato.getGrupo( ).getIdentificador( ) );
			parametros.put( SUCURSAL, contrato.getSucursal( ) );
			parametros.put( ASESOR, contrato.getAsesor( ) != null ?  AsesorData.obtenerClavePersona(uid, contrato.getAsesor( ) ) : "");
			parametros.put( RENOVACION, ciclo > 1 ? VALOR_RENOVACION_SI : VALOR_RENOVACION_NO );
			parametros.put( MONTO , contrato.getMonto_otorgado( ) );
 			parametros.put( MONTO_PAGO, montoPago );
			parametros.put( PLAZO, contrato.getPlazo( ) );
			parametros.put( TASA, tasaMensual );
			parametros.put( FRECUENCIA, contrato.getFrecuencia( ) );
			parametros.put( FECHA_DESEMBOLSO, contrato.getFecha_desembolso( ) );
			parametros.put( FECHA_DIA_PAGO, contrato.getDiaPago() != null ? simpleDateFormatAncla.parse( simpleDateFormatAncla.format( calendar.getTime() ) ) : contrato.getFecha_desembolso( ) );
			parametros.put( PRODUCTO, contrato.getProducto( ) );
			parametros.put( FECHA_TERMINO, contrato.getFecha_esp_liquidacion() );
			parametros.put( CONSECUTIVO, ciclo );
			parametros.put( FECHA_DISPOSICION, simpleDateFormat.format( contrato.getFecha_desembolso( ) ) );
			parametros.put( "efectivo", contrato.getMontoFinanciado() );
			parametros.put( "comision", comisionSinIva );
			parametros.put( "pct_comision", ivaD );			
			
			LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - " + OPER_REGISTRAR_CONTRATO_RESTRUCTURA );
			resultadoContrato = ( ResultadoOV )sesionTx.selectOne( OPER_REGISTRAR_CONTRATO_RESTRUCTURA, parametros );
			LogHandler.debug(uid, getClass(),"OPER_REGISTRAR_CONTRATO " + OPER_REGISTRAR_CONTRATO_RESTRUCTURA + " Realizado... 		ResultadoContrato: " + resultadoContrato );
			parametros.clear( );
			
			if( resultadoContrato == null || !resultadoContrato.getCodigo().equals( CODIGO_CREDITO_OK ) )
			{
			MSG += resultadoContrato != null ? ( resultadoContrato.getMensaje().toUpperCase() + " CODIGO: " + resultadoContrato.getCodigo( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP alta_contrato.";
			LogHandler.debug(uid, getClass(),MSG);
			throw new Exception ( MSG );
			}
			
			//insertamos el contrato grupo
			parametros.put( CONTRATO, identificador );
			parametros.put( ASESOR, AsesorData.obtenerClavePersona(uid, contrato.getAsesor( ) ) );
			parametros.put( MONTO_OTORGADO, contrato.getMonto_otorgado( ) );
			parametros.put( CICLO_GRUPO, contrato.getGrupo().getCiclo( ) );
			parametros.put( HORA_REUNION, contrato.getHora_reunion( ) != null ? contrato.getHora_reunion( ) : "");
			parametros.put( DIA_REUNION, contrato.getDia_reunion( ) != null ? contrato.getDia_reunion( ) : 0 );
			
			//2013-10-11
			//MMH Se insertan los nuevos campos de hora fin grupo y persona domicilio reunion	
			if( contrato.getNumero_cliente_reunion() != null ) {
				contrato.setNumero_cliente_reunion( comun.obtenerPersonaCliente(uid, contrato.getNumero_cliente_reunion()) );
			}
			parametros.put( "hora_reunion_fin", contrato.getHora_reunion_fin() != null ? contrato.getHora_reunion_fin( ) : "");
			parametros.put( "persona_dom_reunion", contrato.getNumero_cliente_reunion() != null ? contrato.getNumero_cliente_reunion( ) : "");
						
			LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - registrarContratoGrupo" );
			sesionTx.insert( OPER_REGISTRAR_CONTRATO_GRUPO, parametros );
			parametros.clear( );
			LogHandler.debug(uid, getClass(),"OPER_REGISTRAR_CONTRATO_GRUPO  " + OPER_REGISTRAR_CONTRATO_GRUPO + " Realizado...");
			
			
			//Generamos el identificador de contrato LD
			contratoLD = generarLdContrato( uid, sesionNTx );
			if ( contratoLD == null )
				{
				LogHandler.debug( uid, getClass(),ReadProperties.mensajes.getProp("originacion.registrar.errorgenerarcontrato") ); 
				throw new Exception ( ReadProperties.mensajes.getProp("originacion.registrar.errorgenerarcontrato") );
				}	
						
			//Agregar contrato clave finsol guaradar  el numero de contrato LD y numeero FISA
			LogHandler.debug(uid, getClass(),"registrarContratoRestructura ContratoLD: " + contratoLD );
			parametros.put( CONTRATO_LD, contratoLD );
			parametros.put( CONTRATO, identificador);
			LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - " + "registrarContratoClaveFinsol");
			sesionTx.insert( "registrarContratoClaveFinsol", parametros );
			parametros.clear( );
			
			//Supervisor
			contrato.getGrupo().setSupervisor( contrato.getGrupo().getSupervisor() != null ? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getSupervisor()) : "" );
						
			//Actualizar el ciclo del grupo en la tabla de personas
			parametros.put( CICLO, contrato.getGrupo().getCiclo( ) );
			parametros.put( PERSONA, contrato.getGrupo().getIdentificador( ) );
			LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - actualizarCicloGrupo" );
			sesionTx.update(OPER_ACTUALIZAR_CICLO_GRUPO, parametros );
			parametros.clear();
			LogHandler.debug(uid, getClass(),"OPER_ACTUALIZAR_CICLO_GRUPO: 			" + OPER_ACTUALIZAR_CICLO_GRUPO 			+ " Realizado...");
							
			//Se recupera a la persona con su ciclo actualizado
			LogHandler.trace(uid,getClass(),"==> registrarContratoRestructura - obtenerCicloIntegrante ");
			List<HashMap<String,Object>> listaIntegranteCiclo =  (List<HashMap<String,Object>>)sesionTx.selectList("obtenerCicloIntegrante",integrantes);
 			HashMap<String,Integer> mapIntegrantesCiclo = new HashMap<String, Integer>();
 			for ( HashMap<String,Object> cicloIntegrante : listaIntegranteCiclo)
 			{
 				mapIntegrantesCiclo.put(cicloIntegrante.get("persona").toString(), Integer.parseInt(cicloIntegrante.get("ciclo").toString()));
 			}
 			
			//Insertar Integrantes
			if ( contrato.getGrupo() != null && contrato.getIntegrantes( ) != null )
				{
				contrato.setIntegrantes( setRolIntegrantes(uid, contrato.getGrupo(), contrato.getIntegrantes( ) ) );
				}
			else {
				throw new Exception(ReadProperties.mensajes.getProp("originacion.registrar.errorintegrantesguardar") );
				}

			//Registrar integrantes
			
			if (!registrarIntegrantes( uid, sesionTx, identificador, contrato.getMonto_otorgado(), mapIntegrantesCiclo, contrato.getIntegrantes( ) ) )
				{
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errorintegrantesguardar") );
				}
						
			//Actualiza monto-liq
			if ( contrato.getMontoFinanciado() > 0.0 )
				{
				//Se actualiza monto_liq_ctrant
				final HashMap<String, Object> 
				paramActContrato = new HashMap<String, Object>();
				paramActContrato.put( "contrato", identificador );
				paramActContrato.put( "monto"	, contrato.getMontoFinanciado() );

				//Se actualiza el monto financiado
				LogHandler.trace(uid,getClass(),"==> registrarContratoRestructura - actualizaMontoFinanciado");
				sesionTx.update( "actualizaMontoFinanciado", paramActContrato );
				}
			
			//Actualiza los montos a liquidar de los integrantes			
			if (contrato.getMontoFinanciado() > 0.0 )
			{	
				actualizarIntegrantes(uid, sesionTx, identificador, contrato.getIntegrantes( ));
			}

			//Se obtiene el ID de transaccion, util para mantener un control del proceso
			final Integer idTransaccion = comun.obtenerIdTransaccion(uid, contrato.getSucursal(), fechaContable);
			
			//Se registra el contrato en folio_notas
			final HashMap<String, Object> 
							paramFolioNotas = new HashMap<String, Object>();
							paramFolioNotas.put( "header", "P" );
							paramFolioNotas.put( "contrato", identificador );
							paramFolioNotas.put( "montoLiquidar", contrato.getMontoFinanciado() );
							paramFolioNotas.put( "montoPromedio", 0 );
							paramFolioNotas.put( "folio", generarFolio( uid, contrato.getSucursal(), sesionTx ) );
							paramFolioNotas.put( "contratoAnterior", contrato.getContratoActual() );
							paramFolioNotas.put( "fechaHora", comun.obtenerFechaActual( uid ) );
							paramFolioNotas.put( "folioPagare", "" );
									
			LogHandler.trace(uid,getClass(),"==> registrarContratoRestructura - registrarFolioNotas");
			sesionTx.selectOne( "registrarFolioNotas", paramFolioNotas);
			
			if ( fechaContable != null && simpleDateFormat.format( contrato.getFecha_desembolso( ) ).equals( simpleDateFormat.format( fechaContable ) ) )
			{
				
				
				//Condonacion de Recargos
				//**********FALTA*********
				
				LogHandler.debug(uid, getClass(),"Calculo monto condonar moratorios");
				Double montoCondonarMoratorios = 0d;
				Double montoPagoSinMoratorios = 0d;
										
				List<HashMap<String,Object>> detallePagosVencidos = (List<HashMap<String,Object>>) sesionNTx.selectList("obtenerVencido", contrato.getContratoActual() );
				
				
				if (detallePagosVencidos != null ) {
					for (HashMap<String,Object> pagoVencido : detallePagosVencidos ) {
						Double capital = 0d;
						Double interes = 0d;
						capital = Double.parseDouble( pagoVencido.get("p_capital").toString() );
						interes = Double.parseDouble( pagoVencido.get("p_interes").toString() );
						montoPagoSinMoratorios += (capital +  interes);												
						
						if ( (montoPagoSinMoratorios) >  contrato.getMontoFinanciado() ) {
							montoCondonarMoratorios += Double.parseDouble( pagoVencido.get("p_moratorio").toString() );
							break;
						}
						else {
							montoCondonarMoratorios += Double.parseDouble( pagoVencido.get("p_moratorio").toString() );							
						}
						LogHandler.debug(uid, getClass(),"montoCondonarMoratorios=" + montoCondonarMoratorios);
					}					
					
				} else {
					throw new Exception("No es posible obtener los pagos vencidos del credito actual.");
				}
				
				LogHandler.debug(uid, getClass(),"montoCondonarMoratorios=" + montoCondonarMoratorios);
				
				//montoCondonarMoratorios = 100.0;
				
				HashMap<String, Object> resultadoCondonacion;
				HashMap<String, Object> parametroscondonacion = new HashMap<String, Object>( );
				parametroscondonacion.put( CONTRATO, contrato.getContratoActual() );
				parametroscondonacion.put("montoCondonar", (Math.rint(montoCondonarMoratorios * 100) /100)  );
				parametroscondonacion.put("tipo", "BORE");
				parametroscondonacion.put("idTrxCaja", idTransaccion);
				parametroscondonacion.put( SUCURSAL, contrato.getSucursal( ) );
				parametroscondonacion.put( "descripcion", "" );
								
				LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - bonificaMora");
				resultadoCondonacion = (HashMap<String, Object>) sesionTx.selectOne( "bonificaMora", parametroscondonacion );

				if ( resultadoCondonacion != null && Integer.parseInt(resultadoCondonacion.get("resultado").toString()) == 0) {


				}	else {
					throw new Exception("Error en la aplicacion de la condonacion de moratorios.");
				}



				//Marcar Integrantes con estatus R en credito anterior
				HashMap<String, Object> parametrosStatus;
				for( IntegranteOV integrante : contrato.getIntegrantes() ) {
					parametrosStatus = new HashMap<String, Object>( );
					parametrosStatus.put( CONTRATO, contrato.getContratoActual() );
					parametrosStatus.put( "cliente" , integrante.getCliente() );
					parametrosStatus.put( "estatus", "R" );
					parametrosStatus.put( "fecha", new Date() );

					LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - actualizaEstatusIntegrante");
					sesionTx.update( "actualizaEstatusIntegrante", parametrosStatus );
				}

				//Actualizar Porcentaje de Participacion del credito anterior
				LogHandler.debug(uid, getClass(),"Actualizando porcentaje integrantes credito anterior");
				if(!comun.actualizarPorcentajeParticipacionIntegrante(uid, sesionTx, contrato.getContratoActual())) {
					throw new Exception( "Existio un error en la actualizacion del porcentaje de los integrantes del credito anterior." );
				}
				
				final 	PagoGrupal	pagoGrupal = new PagoGrupal();
				pagoGrupal.setIdPago		( 0 );
				pagoGrupal.setCodigo		( "PADO" );
				pagoGrupal.setFechaValor	( null );
				pagoGrupal.setMedioPago		( "" );
				pagoGrupal.setMonto			( contrato.getMontoFinanciado() );
				pagoGrupal.setNumeroContrato( contrato.getContratoActual() );
				pagoGrupal.setReferencia	( "" );
		
				//Aplicar Pago por Documento
				LogHandler.debug(uid, getClass(),"Aplicar Pago por Documento");

				if( !pagos.aplicarPagoGrupal(uid, sesionTx, idTransaccion, pagoGrupal).getHeader().isEstatus() )
				{
					throw new Exception( ReadProperties.mensajes.getProp("ciof.error.aplicarpagos") );
				}
				else
				{
					//Registra Caja Inventario
					LogHandler.debug(uid, getClass(),"Registra Caja Inventario");
					params.clear();
					params.put(SUCURSAL, contrato.getSucursal() );
					params.put(FECHA_CONTABLE, formatter.format(fechaContable));
					params.put(MONTO, contrato.getMontoFinanciado() );
					LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - registraCajaInventario ");
					sesionTx.selectOne("registraCajaInventario", params);
					
					
					//registraOperacionCaja
					LogHandler.debug(uid, getClass(),"Registra Operacion Caja");
					
					params.clear();
					params.put(CODIGO, CODIGO_CANC_PAGODOC );
					params.put(CONTRATO, contrato.getContratoActual());
					params.put(SUCURSAL, contrato.getSucursal() );
					params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
					params.put(FECHA_CONTABLE, formatter.format(fechaContable));
					params.put(MONTO, contrato.getMontoFinanciado() );
					params.put(IDXTRXCAJA, idTransaccion);
					params.put(FECHA_ACTUAL, formatter.format( fechaContable ) );
					params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
					params.put(CLAVE, 0);
					params.put(CLAVE_PRODUCCION, "");
					params.put(REFERENCIA1, " ");
					params.put(REFERENCIA2, " ");
					params.put(REFERENCIA3, " ");
					LogHandler.trace(uid, getClass(), "==> registrarContratoRestructura - " + "registraOperacionCaja");
					resultado = (ResultadoOV) sesionTx.selectOne( "registraOperacionCaja", params );
					params.clear();

					if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
						LogHandler.info(uid, this.getClass(),ReadProperties.mensajes.getProp("ciof.error.cajavirtualregistro")); 
						throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtualregistro") );
					}
				}


				//Actualizar los folios notas
				final HashMap<String, String>
							paramUpdateNotasFolio = new HashMap<String, String>();
							paramUpdateNotasFolio.put( "contratoVigente", contrato.getContratoActual());
							paramUpdateNotasFolio.put( "contratoNuevo"  , identificador);
							paramUpdateNotasFolio.put( "status"			, "L");

				//Se actualiza folio-notas
				LogHandler.trace(uid,getClass(),"==> registrarContratoRestructura - actualizarFolioNotas");
				int act = sesionTx.update( "actualizarFolioNotas", paramUpdateNotasFolio );
				
				LogHandler.info(uid, getClass(), "Numero de registros afectados en la actualizacion : " + act);
				
				if( act == 0 )
					{throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errordisposicion") ); }
			
				//Aplicar Disposicion del contrato
				DesembolsoOV desembolso = new DesembolsoOV();
				desembolso.setContrato(identificador);
				desembolso.setMonto( contrato.getMonto_otorgado( ) );
				desembolso.setSucursal( contrato.getSucursal() );
				desembolso.setOperador( OPERADOR_DEF );
				resultado = desembolsarTx(uid, idTransaccion, sesionTx,fechaContable, desembolso );

				if( resultado == null || !(resultado.getCodigoRetorno() == 1) )
					{
					MSG += resultado != null ? ( resultado.getMensaje().toUpperCase() + " CODIGO: " + resultado.getCodigoRetorno( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP Caja_Trad_Disp.";
					LogHandler.debug(uid, getClass(),MSG);
					throw new Exception ( MSG );
					}
				else
					{
					//Se da de alta en movimiento y en auditoria caja el movimiento de desembolso con DISP
					params.clear();
					params.put(SUCURSAL, contrato.getSucursal() );
					params.put(FECHA_CONTABLE, formatter.format(fechaContable));
					params.put(MONTO, contrato.getMonto_otorgado( ));
					LogHandler.trace(uid, getClass(), "==> registrar - registraCajaInventario ");
					sesionTx.selectOne("registraCajaInventario", params);
					
					params.clear();
					params.put(CODIGO, CODIGO_PAGO_DISP );
					params.put(CONTRATO, identificador);
					params.put(SUCURSAL, contrato.getSucursal() );
					params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
					params.put(FECHA_CONTABLE, formatter.format(fechaContable));
					params.put(MONTO, contrato.getMonto_otorgado( ) );
					params.put(IDXTRXCAJA, idTransaccion);
					params.put(FECHA_ACTUAL, formatter.format( fechaContable ) );
					params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
					params.put(CLAVE, 0);
					params.put(CLAVE_PRODUCCION, "");
					params.put(REFERENCIA1, " ");
					params.put(REFERENCIA2, " ");
					params.put(REFERENCIA3, " ");
					LogHandler.trace(uid, getClass(), "==> registrar - " + "registraOperacionCaja");
					resultado = (ResultadoOV)sesionTx.selectOne( "registraOperacionCaja", params );
					params.clear();
					
					if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
						LogHandler.info(uid, this.getClass(),ReadProperties.mensajes.getProp("ciof.error.cajavirtual")); 
						throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
						}
					
					sesionTx.commit( true );
					LogHandler.debug(uid, getClass(),ReadProperties.mensajes.getProp("ciof.error.commit"));
					
					}

				
			}
			else
			{
				sesionTx.commit( true );
				LogHandler.debug(uid, getClass(),ReadProperties.mensajes.getProp("COMMIT"));
			}
		
			
			
			
			// se calcula y se guarda el CAT del contrato
			{
			LogHandler.trace(uid, getClass(), "==> registrar - obtenerAmortizacionGrupal" );
			final List<AmortizacionOV> 
					pagosAmortizacion = (List<AmortizacionOV>)sesionNTx.selectList("obtenerAmortizacionGrupal", identificador );
			
			final List<Double>
					pagosPeriodo = new ArrayList<Double>();
						
			try {				
				for( AmortizacionOV amortizacionOV : pagosAmortizacion )
					{
					final java.lang.Double  montoSinIva = amortizacionOV.getAbonoCapital() + ( amortizacionOV.getInteresPeriodo() / ( 1.0 + ivaD / 100.0 )) ;
					pagosPeriodo.add( montoSinIva );
					}
				
				final ConsultaCATPeticion consultaCATPeticion = new ConsultaCATPeticion();
				consultaCATPeticion.setMontoCredito( contrato.getMonto_otorgado( ) );
				consultaCATPeticion.setPagos( pagosPeriodo );
				consultaCATPeticion.setPeriodo( contrato.getFrecuencia( ).trim().startsWith( "S" ) ? 52 : 
												contrato.getFrecuencia( ).trim().startsWith( "C" ) ? 26 : 12 );
				consultaCATPeticion.setPlazo( pagosPeriodo.size() );
				
				LogHandler.info(uid, getClass(), "Objeto que se envia a calcular el CAT : " + consultaCATPeticion );
				
				final ConsultaCATRespuesta 
					  consultaCATRespuesta = consultas.consultarCAT( consultaCATPeticion, uid );
			
			
				final java.util.HashMap<String,Object>
						paramsCondicionesContrato = new HashMap<String, Object>();
						paramsCondicionesContrato.put( "producto", contrato.getProducto() );
						paramsCondicionesContrato.put( "contrato", identificador );
						paramsCondicionesContrato.put( "valor"	 , consultaCATRespuesta.getCAT().toString() );
				
				LogHandler.trace(uid, getClass(), "==> registrar - insertarCondicionesContratoCAT");
				sesionNTx.insert( "insertarCondicionesContratoCAT", paramsCondicionesContrato );
				}
			catch( java.lang.Exception exception )
				{
				LogHandler.error( uid, getClass(), ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorcat" ) + contratoLD, exception );
				}				
			}
			
			//2013-10-11
			//MMH Registrar sucursal cobranza
			
			final HashMap<String, Object>	paramActSucursalCobranza = new HashMap<String, Object>();
			paramActSucursalCobranza.put("tipo_ejecucion", "U");
			paramActSucursalCobranza.put("contrato", identificador);
			 			
			LogHandler.trace(uid,getClass(),"==> registrar - actualizaSucursalCobranza");
			sesionNTx.selectOne( "actualizaSucursalCobranza", paramActSucursalCobranza );
			
		
		regreso.getHeader( ).setMensaje( MENSAJE_ALTA_CONTRATO );
		regreso.setContrato( identificador );
		regreso.setLd_contrato( contratoLD );		
		regreso.setGrupo( contrato.getGrupo( ).getIdentificador( ) );
		regreso.setCiclo( ciclo );
		regreso.setPeticion_ofs( " " ) ;
			
		}
		catch(Exception e) {
		
			FabricaConexiones.rollBack( sesionTx );
			LogHandler.debug(uid, getClass(),"ROLLBACK REALIZADO...");
			regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + e.getMessage() : e.getMessage() );
			regreso.getHeader().setEstatus( false );
			regreso.getHeader().setCodigo( null );
			LogHandler.error( uid, getClass(), MSG != null ? MSG : "EXISTIO UN ERROR EN EL REGISTRO DEL CONTRATO " + contratoLD +" MENSAJE: " + e.getMessage() , e);
		}
		finally {
			FabricaConexiones.close( sesionTx );
			FabricaConexiones.close( sesionNTx );
		   LogHandler.info(uid, getClass(),"EL CONTRATO: " + contratoLD +" HA SIDO CREADO EXITOSAMENTE... " + regreso);
		}
		
		
		return regreso;
	}

	
	/**
	 * 
	 */
	@SuppressWarnings("unchecked")
	public ContratoRespuesta registrarContratoVentaCartera( String uid, ContratoOV contrato ) 
		{
		String MSG = "REGISTRADO.  ";

		SqlSession 					sesionNTx			= null ;
		SqlSession 					sesionTx			= null ;
		Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
		
		HashMap<String, Object> 	params				= new HashMap<String, Object>( );
		List<String>				integrantes			= new ArrayList<String>( );
		
 		Date						fecha 				= new Date( );
		double 						tasaMensual			= 0d;
		Integer						ciclo;
		String 						identificador;
		String 						categoria			= null;
 		ContratoRespuesta			regreso				= new ContratoRespuesta( );
 		ResultadoOV					resultadoContrato	= null;
 		String 						contratoLD			= null;
 		Double						montoPago			= null;
 		

		regreso.setHeader( new EncabezadoRespuesta( ) );
		regreso.getHeader().setUID( uid );
		//DatosCreditoRespuesta resp = new DatosCreditoRespuesta();

		try {
			LogHandler.debug(uid, getClass(), "Datos de entrada : " + contrato );			
 			identificador = generarContrato( uid ); //Obtenemos el numero de contrato
			if ( identificador == null ) 
				throw new Exception( ReadProperties.mensajes.getProp("ciof.noexisterelacion") );
			
			
			//Abrimos las conexiones correspondientes
			sesionNTx	= FabricaConexiones.obtenerSesionNTx( ); 
			sesionTx	= FabricaConexiones.obtenerSesionTx( );
			
			Date fechaContable = comun.obtenerFechaContable(uid ).getFecha();
			
			
			
			ConsultaCreditoPeticion peticionContratoActual = new ConsultaCreditoPeticion();
			peticionContratoActual.setContrato(contrato.getContratoActual());
			
			
			DatosCreditoIntegrantesRespuesta respuestaContratoActual = consultas.obtenerDatosCreditoIntegrantesCompleto(uid,peticionContratoActual);
			
			DatosCreditoOV datosContratoActual = respuestaContratoActual.getDatosCredito();			
			contrato.setAsesor(datosContratoActual.getAsesor().toString());
			contrato.setDia_reunion(1);
			contrato.setDiaPago(1);
			contrato.setFecha_contrato(fechaContable);
			contrato.setFecha_desembolso(fechaContable);
			contrato.setFecha_esp_liquidacion(fechaContable);
			contrato.setFrecuencia("Semanal");

			//Identificador grupo desde la llamada al WS
			
			contrato.setHora_reunion("10:00");
			contrato.setHora_reunion_fin("10:30");
			
			contrato.setMonto_otorgado(0.0);
			contrato.setMontoFinanciado(0.0);
			contrato.setMontoGarantia(0.0);
			contrato.setMontoSeguro(0.0);
			contrato.setPlazo(1);
			contrato.setProducto(datosContratoActual.getProducto());
			contrato.setRenovacion(false);
			contrato.setSucursal(datosContratoActual.getNumeroSucursal());
			
			LogHandler.debug(uid, this.getClass(),"Tasa... " +datosContratoActual.getTasa());
			
			contrato.setTasa(datosContratoActual.getTasa());
			
			
			
			int dimension = 0;
			for ( DatosIntegranteResumenOV integrante : respuestaContratoActual.getIntegrantes() ) {
				
				if (integrante.getEstatus().trim().equals("A")) {
					dimension++;
				}
			}
			
			IntegranteOV[] listaIntegrantes = new IntegranteOV[dimension];
			int posicion = 0;
			for ( DatosIntegranteResumenOV integrante : respuestaContratoActual.getIntegrantes() ) {
				
				if (integrante.getEstatus().trim().equals("A")) {
					IntegranteOV integranteNuevo = new IntegranteOV();					
					integranteNuevo.setCheque("10");
					integranteNuevo.setCliente(integrante.getCliente());
					integranteNuevo.setMonto(integrante.getSaldoCapital());
					integranteNuevo.setMontoFinanciado(0.0);
					integranteNuevo.setMontoSeguro(0.0);
					integranteNuevo.setMontoSeguroEnfermedad(0.0);
					integranteNuevo.setRol("INTE");
					integranteNuevo.setTipoLocalidad("U");
					integranteNuevo.setObjetivo(integrante.getObjetivo());
					listaIntegrantes[posicion]  =  integranteNuevo;
					posicion++;
				}
			}
			
			contrato.setIntegrantes( listaIntegrantes);
			
			
			
			
			
			LogHandler.debug(uid, this.getClass(),"Tratando de abrir la caja... ");
			ResultadoOV aperturaCaja = comun.aperturaCaja(uid, contrato.getSucursal(), fechaContable );
			if ( aperturaCaja.getCodigoRetorno() < 0 )
				{
				throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
				}
			
			//Se cambia el contrato a clave credprod
			if( contrato.getContratoActual() != null && !contrato.getContratoActual().trim().equals( "" ) )					
			{
				LogHandler.trace(uid, getClass(), "==> registrar - obtenerNumeroContrato" );
				contrato.setContratoActual( comun.obtenerNumeroContrato(uid, contrato.getContratoActual().toString()).toString() );
			}
			
			//Monto total basado en montos de los integrates
			java.math.BigDecimal montoIntegrantes = new BigDecimal( 0 );
			
			
			//Actualizar el ciclo del integrante en la tabla de personas contrato.getIntegrantes( )
			for( IntegranteOV integrante : contrato.getIntegrantes( ) )
				{
				if( integrante.getMonto() == null || integrante.getMonto() == 0 )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errormontointegrante" ) );
					}
				
				if( integrante.getCliente() == null || integrante.getCliente().trim().equals( "" ) )
					{
					throw new Exception( ReadProperties.mensajes.getProp( "originacion.registrarcredito.errorcodigointegrante" ) );
					}
				
				//Se suman montos de los integrantes
				montoIntegrantes = montoIntegrantes.add( new BigDecimal( "" + integrante.getMonto() ) );
				
				integrante.setCliente(integrante.getCliente());
				
				if( integrante.getCliente() != null && !integrante.getCliente().equals( "" ) ) { integrantes.add( integrante.getCliente( ) ); }
				}
			
			LogHandler.info(uid, getClass(), "Los montos son mIs = " +  montoIntegrantes + ", mCp = " + contrato.getMonto_otorgado().doubleValue() );
			
			contrato.setMonto_otorgado(montoIntegrantes.doubleValue());
			
			LogHandler.info(uid, getClass(), "Los montos son mIs = " +  montoIntegrantes + ", mCp = " + contrato.getMonto_otorgado().doubleValue() );
			
			
			contrato.setFecha_desembolso(fechaContable);
			contrato.setMontoFinanciado( 0.0 );
			contrato.setFecha_esp_liquidacion(contrato.getFecha_desembolso());
		
				
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
																									
			//Calculamos el valor de la tasa mensual sin IVA, en cfuncion de la sucursal
			LogHandler.debug( uid, getClass(),SUCURSAL + ": " + contrato.getSucursal( ) );
			parametros.put( SUCURSAL, contrato.getSucursal( ) );
			parametros.put( FECHA, fecha );
			parametros.put( CODIGO , CODIGO_IVA );
			tasaMensual = calculaTasaMensual ( uid, sesionNTx, parametros, contrato.getTasa() );
			
			
			//MIMH 2013-10-29
			LogHandler.trace(uid, getClass(), "==> registrar - verValorHistorico " );
			//final Integer iva = (Integer) sesionNTx.selectOne("verValorHistorico", parametros);
			
			//Se obtiene la parte sin iva
			//final Double ivaD = Double.parseDouble( iva.toString() );
			
			parametros.clear();
						
						
			//Obetenemos el ciclo actual de la tabla personas
			//sesionNTx.selectOne("obtenerClienteFinsol",  contrato.getGrupo( ).getIdentificador( ).toString() );
			contrato.getGrupo( ).setIdentificador( comun.obtenerPersonaCliente(uid, contrato.getGrupo( ).getIdentificador( )) );
			ciclo = obtenerCiclo(uid, sesionNTx, contrato.getGrupo( ).getIdentificador( ) );
			
			LogHandler.debug(uid, getClass(),"Grupo: " + contrato.getGrupo( ).getIdentificador( ) + " Ciclo Actual: " + ciclo );

			//Verificar la categoria del producto
			categoria  = comun.obtenerCategoria(uid, contrato.getProducto() );
			LogHandler.debug(uid, getClass(),"categoria: " +  categoria );
			
			
			parametros.put( "grupo" , contrato.getGrupo( ).getIdentificador( ) );

			
			//Asignamos el valor para el ciclo del grupo 
 			contrato.getGrupo( ).setCiclo( ciclo );
 			
 			//Actualizar informacion del grupo que es enviada por el credito
 			ResultadoOV resultado = null;
 			
			//COMERFIN 41 Comercial_20130717_Seguro de vida Finsol
			//MIMH 2013-10-29
			//Validacion monto seguro
			contrato.setMontoSeguro(0.0);
			

			//MIMH 2014-10-14
			//Validacion monto seguro enfermedad
			contrato.setMontoSeguroEnfermedad(0.0);
			
			
			//Fecha para el dia de pago
			final 	Calendar
					calendar = java.util.GregorianCalendar.getInstance();
			
			if ( contrato.getDiaPago() != null ) {calendar.set( Calendar.DAY_OF_WEEK , contrato.getDiaPago() + 1 ); }
			
			final SimpleDateFormat simpleDateFormatAncla = new SimpleDateFormat( "yyyy-MM-dd" );
			
 			parametros.put( SUCURSAL, contrato.getSucursal( ) );
 			parametros.put( MONTO, contrato.getMonto_otorgado( ) + contrato.getMontoSeguro() + contrato.getMontoSeguroEnfermedad() );
 			parametros.put( TASA, tasaMensual );
			parametros.put( NO_PAGOS, contrato.getPlazo( ) );
 			parametros.put( FRECUENCIA_PAGO, contrato.getFrecuencia()  );
 			parametros.put( CONTRATO, identificador );
 			parametros.put( SUCURSAL, contrato.getSucursal( ) );
 			parametros.put( FECHA_DISPOSICION, contrato.getFecha_desembolso( ) );
 			parametros.put( "fecha_contrato" , comun.obtenerFechaContable( uid ).getFecha() );
 			parametros.put( PRODUCTO, contrato.getProducto( ) );
 			parametros.put( "fecha_esp_liq", contrato.getFecha_esp_liquidacion() );
 			
 			//montoPago = calcularMonto( uid, sesionNTx, parametros );
 			montoPago = contrato.getMonto_otorgado();
 			parametros.clear();
			
			 //Se da de alta el contrato SP en CREDPROD  
 			
 			contrato.setProducto( contrato.getProducto().trim() );
 			
			parametros.put( CONTRATO, identificador );
			//MMH 2014-09-08 Almacenar numero solicitud contratos
			parametros.put( SOLICITUD,"-1" );
			parametros.put( GRUPO, contrato.getGrupo( ).getIdentificador( ) );
			parametros.put( SUCURSAL, contrato.getSucursal( ) );
			parametros.put( ASESOR, contrato.getAsesor( ));
			
			parametros.put( RENOVACION, ciclo > 1 ? VALOR_RENOVACION_SI : VALOR_RENOVACION_NO );
			parametros.put( MONTO , contrato.getMonto_otorgado( ) + contrato.getMontoSeguro() + contrato.getMontoSeguroEnfermedad());
 			parametros.put( MONTO_PAGO, montoPago );
			parametros.put( PLAZO, contrato.getPlazo( ) );
			parametros.put( TASA, tasaMensual );
			parametros.put( FRECUENCIA, contrato.getFrecuencia( ) );
			parametros.put( FECHA_DESEMBOLSO, contrato.getFecha_desembolso( ) );
			//parametros.put( FECHA_DIA_PAGO, contrato.getDiaPago() != null ? simpleDateFormatAncla.parse( simpleDateFormatAncla.format( calendar.getTime() ) ) : contrato.getFecha_desembolso( ) );
			parametros.put( FECHA_DIA_PAGO, simpleDateFormatAncla.parse( simpleDateFormatAncla.format( calendar.getTime() ) ) );
			parametros.put( PRODUCTO, contrato.getProducto( ) );
			parametros.put( FECHA_TERMINO, simpleDateFormatAncla.format(contrato.getFecha_esp_liquidacion()) );
			parametros.put( CONSECUTIVO, ciclo );
			parametros.put( FECHA_DISPOSICION, simpleDateFormat.format( contrato.getFecha_desembolso( ) ) );
			
			parametros.put( MONTO_AHORRO   , 0.0 );
			parametros.put( MONTO_SEGURO   , 0.0);
			parametros.put( PCT_IVA_SEGURO , 0.0);
			
			
			LogHandler.trace(uid, getClass(), "==> registrar - registrarContrato");
			
			
			for(String valor : parametros.keySet()) {
				
				LogHandler.info(uid, getClass(), valor + "-" + parametros.get(valor));
				
				
			}
			
			resultadoContrato = ( ResultadoOV )sesionTx.selectOne( "registrarContratoVenta", parametros );
			LogHandler.debug(uid, getClass(),"OPER_REGISTRAR_CONTRATO " + OPER_REGISTRAR_CONTRATO + " Realizado... 		ResultadoContrato: " + resultadoContrato );
			parametros.clear( );
			
			
			if( resultadoContrato == null || !resultadoContrato.getCodigo().equals( CODIGO_CREDITO_OK ) )
				{
				MSG += resultadoContrato != null ? ( resultadoContrato.getMensaje().toUpperCase() + " CODIGO: " + resultadoContrato.getCodigo( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP alta_contrato.";
				LogHandler.debug(uid, getClass(),MSG);
				throw new Exception ( MSG );
				}
			
			//insertamos el contrato grupo
			parametros.put( CONTRATO, identificador );
			parametros.put( ASESOR, AsesorData.obtenerClavePersona(uid, contrato.getAsesor( ) ) );
			parametros.put( MONTO_OTORGADO, contrato.getMonto_otorgado( ) );
			parametros.put( CICLO_GRUPO, contrato.getGrupo().getCiclo( ) );
			parametros.put( HORA_REUNION, contrato.getHora_reunion( ) != null ? contrato.getHora_reunion( ) : "");
			parametros.put( DIA_REUNION, contrato.getDia_reunion( ) != null ? contrato.getDia_reunion( ) : 0 );
			
			
			//2013-10-11
			//MMH Se insertan los nuevos campos de hora fin grupo y persona domicilio reunion	
			if( contrato.getNumero_cliente_reunion() != null ) {
				contrato.setNumero_cliente_reunion( comun.obtenerPersonaCliente(uid, contrato.getNumero_cliente_reunion()) );
			}
			parametros.put( "hora_reunion_fin", contrato.getHora_reunion_fin() != null ? contrato.getHora_reunion_fin( ) : "");
			parametros.put( "persona_dom_reunion", contrato.getNumero_cliente_reunion() != null ? contrato.getNumero_cliente_reunion( ) : "");
			
			
			LogHandler.trace(uid, getClass(), "==> registrar - registrarContratoGrupo" );
			sesionTx.insert( OPER_REGISTRAR_CONTRATO_GRUPO, parametros );
			parametros.clear( );
			LogHandler.debug(uid, getClass(),"OPER_REGISTRAR_CONTRATO_GRUPO  " + OPER_REGISTRAR_CONTRATO_GRUPO + " Realizado...");
			
			
			//Generamos el identificador de contrato LD
			contratoLD = generarLdContrato( uid, sesionNTx );
			if ( contratoLD == null )
				{
				LogHandler.debug( uid, getClass(),ReadProperties.mensajes.getProp("originacion.registrar.errorgenerarcontrato") ); 
				throw new Exception ( ReadProperties.mensajes.getProp("originacion.registrar.errorgenerarcontrato") );
				}	
			//Agregar contrato clave finsol guaradar  el numero de contrato LD y numeero FISA
			LogHandler.debug(uid, getClass(),"ContratoLD: " + contratoLD );
			parametros.put( CONTRATO_LD, contratoLD );
			parametros.put( CONTRATO, identificador);
			LogHandler.trace(uid, getClass(), "==> registrar - " + "registrarContratoClaveFinsol");
			sesionTx.insert( "registrarContratoClaveFinsol", parametros );
			parametros.clear( );
			
			//Se cambia el nombre de los roles
			contrato.getGrupo().setPresidente( contrato.getGrupo().getPresidente() != null ? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getPresidente()) : "" );
			contrato.getGrupo().setSecretario( contrato.getGrupo().getSecretario() != null ? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getSecretario()) : "" );
			contrato.getGrupo().setTesorero	 ( contrato.getGrupo().getTesorero	() != null ? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getTesorero())   : ""	);
			contrato.getGrupo().setSupervisor( contrato.getGrupo().getSupervisor() != null ? comun.obtenerPersonaCliente(uid, contrato.getGrupo().getSupervisor()) : "" );

			
			//Se recupera a la persona con su ciclo actualizado
			LogHandler.trace(uid,getClass(),"==> registrar - obtenerCicloIntegrante ");
			List<HashMap<String,Object>> listaIntegranteCiclo =  (List<HashMap<String,Object>>)sesionTx.selectList("obtenerCicloIntegrante",integrantes);
 			HashMap<String,Integer> mapIntegrantesCiclo = new HashMap<String, Integer>();
 			for ( HashMap<String,Object> cicloIntegrante : listaIntegranteCiclo)
 				{
 				mapIntegrantesCiclo.put(cicloIntegrante.get("persona").toString(), Integer.parseInt(cicloIntegrante.get("ciclo").toString()));
 				}
 			
 			//Se valdia q todos los integrantes puedan ser actualizados en el ciclo
 			if( mapIntegrantesCiclo.size() != contrato.getIntegrantes().length )
 				{
 				throw new Exception("No se pudo obtener el ciclo de todos los integrante");
 				}
			
			//Insertar Integrantes
			if ( contrato.getGrupo() != null && contrato.getIntegrantes( ) != null )
				{
				contrato.setIntegrantes( setRolIntegrantes(uid, contrato.getGrupo(), contrato.getIntegrantes( ) ) );
				}
			else {
				throw new Exception(ReadProperties.mensajes.getProp("originacion.registrar.errorintegrantesguardar") );
				}

			//Registrar integrantes
			
			if(!registrarIntegrantes( uid, sesionTx, identificador, contrato.getMonto_otorgado(), mapIntegrantesCiclo, contrato.getIntegrantes( ) ) )
				{
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errorintegrantesguardar") );
				}
						
			if(!comun.actualizarPorcentajeParticipacionIntegrante(uid, sesionTx, identificador)) {
				throw new Exception( "Existio un error en la actualizacion del porcentaje de los integrantes del credito anterior." );
			}
			
			//Se obtiene el ID de transaccion, util para mantener un control del proceso
			final Integer idTransaccion = comun.obtenerIdTransaccion(uid, contrato.getSucursal(), fechaContable);
			
			//Es oportunidad o Renovacion?
			if( contrato.getContratoActual() != null && !contrato.getContratoActual().trim().equals( "" ) )
				{
				//Se registra el contrato en folio_notas
				final HashMap<String, Object> 
								paramFolioNotas = new HashMap<String, Object>();
								paramFolioNotas.put( "header", "P" );
								paramFolioNotas.put( "contrato", identificador );								
								paramFolioNotas.put( "montoLiquidar", contrato.getMontoFinanciado() );
								paramFolioNotas.put( "montoPromedio", 0 );
								paramFolioNotas.put( "folio", generarFolio( uid, contrato.getSucursal(), sesionTx ) );
								paramFolioNotas.put( "contratoAnterior", contrato.getContratoActual() );
								paramFolioNotas.put( "fechaHora", comun.obtenerFechaActual( uid ) );
								paramFolioNotas.put( "folioPagare", "" );
				
				LogHandler.trace(uid,getClass(),"==> registrar - registrarFolioNotas");
				sesionTx.selectOne( "insertarRegistrarFolioNotas", paramFolioNotas);
			
			
				if ( fechaContable != null && simpleDateFormat.format( contrato.getFecha_desembolso( ) ).equals( simpleDateFormat.format( fechaContable ) ) )
					{
					//Si es una renovacion financiada se actualizan los folios
					if( contrato.isRenovacion() && contrato.getMontoFinanciado() > 0.0 )
						{
						
						//Se aplica el pago al contrato vigente por el monto del saldo de los integrantes a renovar
						//aplicarPago(uid, sesionTx, idTransaccion, contrato );
						//Objeto auxiliar para dar de alta un pago
						final 	PagoGrupal 
							pagoGrupal = new PagoGrupal();
							pagoGrupal.setIdPago		( 0 );
							pagoGrupal.setCodigo		( "PADO" );
							pagoGrupal.setFechaValor	( null );
							pagoGrupal.setMedioPago		( "" );
							pagoGrupal.setMonto			( contrato.getMontoFinanciado() );
							pagoGrupal.setNumeroContrato( contrato.getContratoActual() );
							pagoGrupal.setReferencia	( "" );
							
							//06/06/2013 OPERFIN-90
							pagoGrupal.setTipoPago("ABO");
					
							if( !pagos.aplicarPagoGrupal(uid, sesionTx, idTransaccion, pagoGrupal).getHeader().isEstatus() )
								{
								throw new Exception( ReadProperties.mensajes.getProp("ciof.error.aplicarpagos") );
								}
							else
								{
									params.clear();
									params.put(SUCURSAL, contrato.getSucursal() );
									params.put(FECHA_CONTABLE, formatter.format(fechaContable));
									params.put(MONTO, contrato.getMontoFinanciado() );
									LogHandler.trace(uid, getClass(), "==> registrar - registraCajaInventario ");
									sesionTx.selectOne("registraCajaInventario", params);
									
									params.clear();
									params.put(CODIGO, CODIGO_CANC_PAGODOC );
									params.put(CONTRATO, contrato.getContratoActual());
									params.put(SUCURSAL, contrato.getSucursal() );
									params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
									params.put(FECHA_CONTABLE, formatter.format(fechaContable));
									params.put(MONTO, contrato.getMontoFinanciado() );
									params.put(IDXTRXCAJA, idTransaccion);
									params.put(FECHA_ACTUAL, formatter.format( fechaContable ) );
									params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
									params.put(CLAVE, 0);
									params.put(CLAVE_PRODUCCION, "");
									params.put(REFERENCIA1, " ");
									params.put(REFERENCIA2, " ");
									params.put(REFERENCIA3, " ");
									LogHandler.trace(uid, getClass(), "==> registrar - " + "registraOperacionCaja");
									resultado = (ResultadoOV)sesionTx.selectOne( "registraOperacionCaja", params );
									params.clear();
									
									if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
										LogHandler.info(uid, this.getClass(),ReadProperties.mensajes.getProp("ciof.error.cajavirtualregistro")); 
										throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtualregistro") );
										}
								}
						}

					//Actualizar los folios notas
					final HashMap<String, String>
								paramUpdateNotasFolio = new HashMap<String, String>();
								paramUpdateNotasFolio.put( "contratoVigente", contrato.getContratoActual());
								paramUpdateNotasFolio.put( "contratoNuevo"  , identificador);
								paramUpdateNotasFolio.put( "status"			, "L");
	
					//Se actualiza folio-notas
					LogHandler.trace(uid,getClass(),"==> registrar - actualizarFolioNotas");
					int act = sesionTx.update( "actualizarFolioNotas", paramUpdateNotasFolio );
					
					LogHandler.info(uid, getClass(), "Numero de registros afectados en la actualizacion : " + act);
					
					if( act == 0 )
						{throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errordisposicion") ); }
				
					DesembolsoOV desembolso = new DesembolsoOV();
					desembolso.setContrato(identificador);
					desembolso.setMonto( contrato.getMonto_otorgado( ) );
					desembolso.setSucursal( contrato.getSucursal() );
					desembolso.setOperador( OPERADOR_DEF );
					resultado = desembolsarTx(uid, idTransaccion, sesionTx,fechaContable, desembolso );
	
					if( resultado == null || !(resultado.getCodigoRetorno() == 1) )
						{
						MSG += resultado != null ? ( resultado.getMensaje().toUpperCase() + " CODIGO: " + resultado.getCodigoRetorno( ) ) : "ERROR INTERNO DE SYBASE EJECUTANDO SP Caja_Trad_Disp.";
						LogHandler.debug(uid, getClass(),MSG);
						throw new Exception ( MSG );
						}
					else
						{
						//Se da de alta en movimiento y en auditoria caja el movimiento de desembolso con DISP
						params.clear();
						params.put(SUCURSAL, contrato.getSucursal() );
						params.put(FECHA_CONTABLE, formatter.format(fechaContable));
						params.put(MONTO, contrato.getMonto_otorgado( ));
						LogHandler.trace(uid, getClass(), "==> registrar - registraCajaInventario ");
						sesionTx.selectOne("registraCajaInventario", params);
						
						params.clear();
						params.put(CODIGO, CODIGO_PAGO_DISP );
						params.put(CONTRATO, identificador);
						params.put(SUCURSAL, contrato.getSucursal() );
						params.put(USUARIO, ConstantesPagos.USUARIO_PAGO.getValue());
						params.put(FECHA_CONTABLE, formatter.format(fechaContable));
						params.put(MONTO, contrato.getMonto_otorgado( ) );
						params.put(IDXTRXCAJA, idTransaccion);
						params.put(FECHA_ACTUAL, formatter.format( fechaContable ) );
						params.put(MEDIO_RECEPCION, ConstantesPagos.MEDIO_RECEPCION_FSOL.getValue());
						params.put(CLAVE, 0);
						params.put(CLAVE_PRODUCCION, "");
						params.put(REFERENCIA1, " ");
						params.put(REFERENCIA2, " ");
						params.put(REFERENCIA3, " ");
						LogHandler.trace(uid, getClass(), "==> registrar - " + "registraOperacionCaja");
						resultado = (ResultadoOV)sesionTx.selectOne( "registraOperacionCaja", params );
						params.clear();

						if ( resultado != null && resultado.getCodigoRetorno() < 0 ) {
							LogHandler.info(uid, this.getClass(),ReadProperties.mensajes.getProp("ciof.error.cajavirtual")); 
							throw new Exception ( ReadProperties.mensajes.getProp("ciof.error.cajavirtual"));
							}
						sesionTx.commit( );
						LogHandler.debug(uid, getClass(),ReadProperties.mensajes.getProp("ciof.error.commit"));

						}
					}
				else
					{
					sesionTx.commit( );
					LogHandler.debug(uid, getClass(),ReadProperties.mensajes.getProp("ciof.error.commit"));
					}
				}
			else
				{

				//Se verifica el desembolso para los contratos normales
				if ( fechaContable != null && simpleDateFormat.format( contrato.getFecha_desembolso( ) ).equals( simpleDateFormat.format( fechaContable ) ) )
					{
					final DesembolsoOV desembolso = new DesembolsoOV();
					desembolso.setContrato(identificador);
					desembolso.setMonto( contrato.getMonto_otorgado( ) );
					desembolso.setSucursal( contrato.getSucursal() );
					desembolso.setOperador( OPERADOR_DEF );
					resultado = desembolsarTx(uid, idTransaccion, sesionTx,fechaContable, desembolso );
					}

				sesionTx.commit( );
				LogHandler.debug(uid, getClass(),ReadProperties.mensajes.getProp("ciof.error.commit"));
				}

				//2013-10-11
				//MMH Registrar sucursal cobranza

				final HashMap<String, Object>	paramActSucursalCobranza = new HashMap<String, Object>();
				paramActSucursalCobranza.put("tipo_ejecucion", "U");
				paramActSucursalCobranza.put("contrato", identificador);

				LogHandler.trace(uid,getClass(),"==> registrar - actualizaSucursalCobranza");
				sesionNTx.selectOne( "actualizaSucursalCobranza", paramActSucursalCobranza );


			regreso.getHeader( ).setMensaje( MENSAJE_ALTA_CONTRATO );
			regreso.setContrato( identificador );
			regreso.setLd_contrato( contratoLD );
			regreso.setGrupo( contrato.getGrupo( ).getIdentificador( ) );
			regreso.setCiclo( ciclo );
			regreso.setPeticion_ofs( contrato.getPeticion_ofs() ) ;
		} catch ( Exception e ) {
			e.printStackTrace();
			FabricaConexiones.rollBack( sesionTx );
			LogHandler.debug(uid, getClass(),"ROLLBACK REALIZADO...");
			regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? MENSAJE_TIMEOUT + e.getMessage() : e.getMessage() );
			regreso.getHeader().setEstatus( false );
			regreso.getHeader().setCodigo( null );
			regreso.getHeader().setUID(uid);
			LogHandler.error( uid, getClass(), MSG != null ? MSG : "EXISTIO UN ERROR EN EL REGISTRO DEL CONTRATO " + contratoLD +" MENSAJE: " + e.getMessage() , e);
		}
		finally {
			FabricaConexiones.close( sesionTx );
			FabricaConexiones.close( sesionNTx );
			LogHandler.info(uid, getClass(),"EL CONTRATO: " + contratoLD +" HA SIDO CREADO EXITOSAMENTE... " + regreso);
		}
		return regreso;
	}

	/**
	 * Valida pago garantia tarea.
	 *
	 * @param uid the uid
	 * @param peticion the peticion
	 * @return the valida pago garantia respuesta
	 */
	public ValidaPagoGarantiaRespuesta validaPagoGarantiaTarea(String uid,
			ValidaPagoGarantiaPeticion peticion) {

		ValidaPagoGarantiaRespuesta respuesta = new  ValidaPagoGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		DecimalFormat formateador = new DecimalFormat("$###,###,###.##");
		SqlSession sesion = null;

		try {

			LogHandler.info(uid, getClass(), "validaIntegranteSolicitud - Abriendo conexion...");
			sesion = FabricaConexiones.obtenerSesionNTx();

			//Obtener datos solicitud

			if (peticion == null || peticion.getSolicitud() == null || peticion.getSolicitud().isEmpty()) {
				throw new Exception("La solicitud esta vacia o nula");
			}

			LogHandler.trace(uid, getClass(), "validaPagoGarantiaTarea: - consultaSolicitud");
			LogHandler.info(uid, getClass(), "validaPagoGarantiaTarea: - consultaSolicitud");
			SolicitudesOV solicitudesOV = (SolicitudesOV) sesion.selectOne("consultaSolicitud", peticion.getSolicitud());

			if (solicitudesOV == null) {
				throw new Exception("La consulta no arrojo resultados para la solicitud, no existe.");
			}


			if (solicitudesOV.getCodigoProducto().equals("GCDG") || solicitudesOV.getCodigoProducto().equals("GCDC")) {
			if (Funciones.validarString(solicitudesOV.getContratoAnt())) {
			//solicitudesOV.getContratoAnt() != null || !solicitudesOV.getContratoAnt().trim().isEmpty()
			//|| !solicitudesOV.getContratoAnt().equals("")
				LogHandler.trace(uid, getClass(), "validaPagoGarantiaTarea: - obtenerMontoAhorroIntegrantes");
				LogHandler.info(uid, getClass(), "validaPagoGarantiaTarea: - obtenerMontoAhorroIntegrantes");
				ValidaPagoGarantiaRespuesta respuestaAhorro = (ValidaPagoGarantiaRespuesta) sesion.selectOne(
						"obtenerMontoAhorroIntegrantes", solicitudesOV.getContratoAnt());

				if (respuestaAhorro == null || respuestaAhorro.getSumMonAho() == null
						|| respuestaAhorro.getSumMonAho() == 0d) {
					respuesta.getHeader().setEstatus(true);
					respuesta.getHeader().setMensaje(
							"La consulta no arrojo resultados para la consulta obtenerMontoAhorroIntegrantes");
					return respuesta;
				}

				respuesta.setSumMonAho(respuestaAhorro.getSumMonAho());

				LogHandler.trace(uid, getClass(), "validaPagoGarantiaTarea: - obtenerPagoGarantia");
				LogHandler.info(uid, getClass(), "validaPagoGarantiaTarea: - obtenerPagoGarantia");
				ValidaPagoGarantiaRespuesta respuestaPago = (ValidaPagoGarantiaRespuesta) sesion.selectOne("obtenerPagoGarantia",
								solicitudesOV.getContratoAnt());

				if (respuestaPago == null) {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje("El depósito pactado era de "
									+ formateador.format(respuesta.getSumMonAho()) + " y lo depositado realmente fue  $0.00.");
					return respuesta;
				}

				respuesta.setPagoGarantia(respuestaPago.getPagoGarantia());

				if (respuesta.getPagoGarantia() < respuesta.getSumMonAho()) {
					respuesta.getHeader().setEstatus(false);
					respuesta.getHeader().setMensaje("El depósito pactado era de "
									+ formateador.format(respuesta.getSumMonAho()) + " y lo depositado realmente fue "
									+ formateador.format(respuesta.getPagoGarantia()) + ".");
				}

			} else {
				respuesta.getHeader().setEstatus(true);
				respuesta.getHeader().setMensaje("La solicitud no tiene contrato anterior.");
			}
		} else {
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensaje("La solicitud no es un producto de garantia.");
		}

	}
	catch (Exception ex) {
		LogHandler.error(uid, getClass(), "Existio un error en validaPagoGarantiaTarea(): " + ex.getMessage(), ex);
		respuesta.getHeader().setEstatus(false);
		respuesta.getHeader().setMensaje( ex.getMessage() );
	}
	finally {
		FabricaConexiones.close(sesion);
	}
	return respuesta;
	}




	/**
	 * Metodo para Confirmar credito.
	 *
	 * @param peticion the peticion
	 * @param uid the string
	 * @return the string
	 */
	@SuppressWarnings("unchecked")
	public ConfirmarCreditoRespuesta confirmarCreditoTarea(String uid,
			ConfirmarCreditoPeticion peticion) {
		ConfirmarCreditoRespuesta respuesta = new  ConfirmarCreditoRespuesta();
		ContratoRespuesta respuestaReg = null;
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		SqlSession sesionTx = null;

		PeticionConsulta peticionBeneficiarios = new PeticionConsulta();

		SegurosRespuestaConsulta beneficiariosRespuesta = new SegurosRespuestaConsulta();

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy" );

		final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

		try {

			LogHandler.info(uid, getClass(), "confirmarCreditoTarea - Abriendo conexion...");
			sesion = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			Date fechaContable = comun.obtenerFechaContable(uid ).getFecha();

			if (peticion == null || peticion.getSolicitud() == null || peticion.getSolicitud().isEmpty()
					|| peticion.getUsuario() == null || peticion.getUsuario().isEmpty()) {
				throw new Exception("La peticion o sus datos son incorrectos");
			}


			//Obtener los elementos del contrato
			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarCredito");
			LogHandler.info(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarCredito");
			ContratoOV contratoOV = (ContratoOV) sesion.selectOne("obtenerConfirmarCredito", peticion.getSolicitud());

			if (contratoOV == null) {
			throw new Exception("La consulta no arrojo resultados para la solicitud, la solicitud no existe o esta cancelada");
			}

			contratoOV.setUsuario(peticion.getUsuario());

			//Obtener los elementos del grupo
			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarGrupo");
			LogHandler.info(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarGrupo");
			GrupoOV grupoOV = (GrupoOV) sesion.selectOne("obtenerConfirmarGrupo", peticion.getSolicitud());

			if (grupoOV == null) {
				throw new Exception("La consulta no arrojo resultados de grupo para la solicitud");
			}

			contratoOV.setGrupo(grupoOV);

			//Obtener los elementos de integrantes
			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarIntegrantes");
			LogHandler.info(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarIntegrantes");
			@SuppressWarnings("unchecked")
			List<IntegranteOV> integrantesList = (List<IntegranteOV>) sesion.selectList(
								"obtenerConfirmarIntegrantes", peticion.getSolicitud());

			if (integrantesList == null || integrantesList.size() == 0) {
				throw new Exception("La consulta no arrojo resultados de integrantes para la solicitud");
			}

			//Obtenemos los montos seguros desde crediseguros
			Boolean unotieneSeguro = existeSeguro(integrantesList);

			if (unotieneSeguro == null) {
				throw new Exception("Ocurrio un error al verificar si algun integrante tiene seguro");
			}

			if (unotieneSeguro) {
			ObtenerMontosSegurosRespuesta obtMontosSeguros = obtenerMontoSeguros(uid, contratoOV, integrantesList);

			if (!obtMontosSeguros.getHeader().isEstatus()) {
				throw new Exception("Ocurrio un error al obtener el monto seguros: "
							+ obtMontosSeguros.getHeader().getMensaje());
			}

			contratoOV.setMontoSeguro(obtMontosSeguros.getMontoTotalSeguroVida());
			contratoOV.setMontoSeguroEnfermedad(obtMontosSeguros.getMontoTotalSeguroEnfermedades());

			//set montos seguros para cada integrante
			for (int i = 0; i < integrantesList.size(); i++) {
				integrantesList.get(i).setCliente(integrantesList.get(i).getCliente().trim());
				for (int j = 0; j < obtMontosSeguros.getClientes().size(); j++) {
					if (integrantesList.get(i).getCliente().equals(obtMontosSeguros.getClientes().get(j).getNumeroPersona())) {
						integrantesList.get(i).setMontoSeguro(obtMontosSeguros.getClientes().get(j).getCostoSeguroVida());
						integrantesList.get(i).setMontoSeguroEnfermedad(obtMontosSeguros.getClientes().get(j).
								getCostoSeguroEnfermedad());
					}
				}
			}

			}

			IntegranteOV[] arregloIntegrantes = new IntegranteOV[integrantesList.size()];

			for (int i = 0; i < integrantesList.size(); i++) {
				arregloIntegrantes[i] = integrantesList.get(i);
			}

			//Agregamos la edad a los clientes
			for (int i = 0; i < arregloIntegrantes.length; i++) {
				int edad = comun.calcularEdad(arregloIntegrantes[i].getFechaNacimiento());
				arregloIntegrantes[i].setEdad(edad);
				LogHandler.info(uid, getClass(), arregloIntegrantes[i].getNombreCompleto()
						+ " edad:" + arregloIntegrantes[i].getEdad());
			}

			contratoOV.setIntegrantes(arregloIntegrantes);
			//Fin Obtenemos los montos seguros desde crediseguros

			//Validar aprobar clientes
			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - validarAprobadosConfirmar");
			Integer noAprobados = (Integer) sesion.selectOne("validarAprobadosConfirmar", peticion.getSolicitud());

			if (noAprobados == null) {
				throw new Exception("La consulta para validar aprobados no regreso resultados.");
			}

			if (noAprobados > 1) {
				throw new Exception("Existen clientes activos que no han sido aprobados, favor de verificar.");
			}
			//Fin Validar aprobar clientes

			//Validar beneficiarios
			Boolean tieneSeguroVida = existeSeguroVida(integrantesList);

			if (tieneSeguroVida == null) {
				throw new Exception("Ocurrio un error al verificar si algun integrante tiene seguro de vida");
			}

			if (tieneSeguroVida) {

			List<BeneficiariosClienteOV> listaBeneficiarios = new ArrayList<BeneficiariosClienteOV>();

			for (int i = 0; i < integrantesList.size(); i++) {
				BeneficiariosClienteOV beneficiario = new BeneficiariosClienteOV();

				if (integrantesList.get(i).getSeguroVida().equals("S")) {
					beneficiario.setPersona(integrantesList.get(i).getCliente());

					listaBeneficiarios.add(beneficiario);
				}

			}

			//se obtienen los beneficiarios con los clientes
			peticionBeneficiarios.setBeneficiariosClientes(listaBeneficiarios);

			beneficiariosRespuesta =  seguros.consultaSegurosBeneficiariosTarea(uid, peticionBeneficiarios);

			if (!beneficiariosRespuesta.getHeader().isEstatus()) {
				throw new Exception("Ocurrio un error al validar Beneficiarios: "
							+ beneficiariosRespuesta.getHeader().getMensaje());
			}

			//se verifica que todos los clientes tengan beneficiarios
			String mensajeBeneficiarios = "";

			for (int i = 0; i < integrantesList.size(); i++) {
				if (integrantesList.get(i).getSeguroVida().equals("S")) {
				Boolean existeBen = false;
				for (int j = 0; j < beneficiariosRespuesta.getBeneficiarioCliente().size(); j++) {
				if (integrantesList.get(i).getCliente().trim().contentEquals(
					beneficiariosRespuesta.getBeneficiarioCliente().get(j).getPersona().trim())) {
					existeBen = true;
				}
			  }

					integrantesList.get(i).setExisteBen(existeBen);

			  }
			}

			for (int i = 0; i < integrantesList.size(); i++) {
				if (integrantesList.get(i).getSeguroVida().equals("S") && !integrantesList.get(i).getExisteBen()) {
					mensajeBeneficiarios = mensajeBeneficiarios + "El cliente "
							+ integrantesList.get(i).getNombreCompleto()
							+ " no cuenta con beneficiarios\n";
				}
			}

			if (!mensajeBeneficiarios.equals("")) {
				throw new Exception(mensajeBeneficiarios);
			}

			contratoOV.setBeneficiarioCliente(beneficiariosRespuesta.getBeneficiarioCliente());

		} // fin tieneSeguroVida
	//Fin Validar beneficiarios


//			Dentro del método de confirmar también debes validar que dentro de la tabla de átomos
//			para esa solicitud exista el átomo de
//			proceso = EVALUACION_CEC  con codigo_resolucion = EVCR_OK
//			Si no existe este registro enviar el mensaje
//			No ha sido aprobada la solicitud por el CEC
//Validacion EVALUACION_CEC
			//parametros de consulta
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "solicitud" , peticion.getSolicitud());
			parametros.put( "proceso" , "EVALUACION_CEC");
			parametros.put( "codigoRes" , "EVCR_OK");

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea - verificaConfirmarAtomo");
			Integer existeAtomo = (Integer) sesionTx.selectOne("verificaConfirmarAtomo", parametros);

			if ( existeAtomo == null || existeAtomo == 0) {
				throw new Exception("No ha sido aprobada la solicitud por el CEC");
			}
//Fin Validacion EVALUACION_CEC

//Validacion Verificacion telefonica

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
			ParGeneralOV varVerificacion = comun.obtenerParGeneralOV(uid, "VCIC_VE_TE");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "VCIC_VE_TE");
			if (varVerificacion == null || varVerificacion.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener el valor de VARIABLE_CICLO_VERIFICACION_TELEFONICA.");
			}

			if (contratoOV.getGrupo().getCiclo() <= Integer.parseInt(varVerificacion.getCgValor())) {

				final java.util.HashMap<String, Object> parVerificacion = new HashMap<String, Object>();
				parVerificacion.put( "solicitud" , peticion.getSolicitud());
				parVerificacion.put( "estatusVer" , "SOLICITUD_VALIDA");

				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea - verificaConfirmarAtomo");
				Integer bitacoraVer = (Integer) sesionTx.selectOne("consultaConfirmarVerificacion", parVerificacion);

				if ( bitacoraVer == null || bitacoraVer == 0) {
					throw new Exception("Aun no han validado la solicitud en el proceso de verificación telefonica,"
							+ " Intentar más tarde.");
				}

			}
//Fin Verificacion Telefonica


//Validacion numero de integrantes y plazo
			if (contratoOV.getGrupo().getCiclo() == 0) {
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV valorMin = comun.obtenerParGeneralOV(uid, "COMGAINMIN");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "COMGAINMIN");
				if (valorMin == null || valorMin.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el numero minimo de integrantes.");
				}
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV valorMax = comun.obtenerParGeneralOV(uid, "COMGAINMAX");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "COMGAINMAX");
				if (valorMax == null || valorMax.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el numero maximo de integrantes.");
				}
				if (integrantesList.size() < Integer.parseInt(valorMin.getCgValor()) || integrantesList.size()
						> Integer.parseInt(valorMax.getCgValor())) {
					throw new Exception("El número de integrantes esta fuera del rango permitido (min: "
						+ valorMin.getCgValor() + " , max: " + valorMax.getCgValor() + ")");
				}
			}
			if (contratoOV.getGrupo().getCiclo() > 0) {
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV valorMin = comun.obtenerParGeneralOV(uid, "COMREINMIN");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "COMREINMIN");
				if (valorMin == null || valorMin.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el numero minimo de integrantes.");
				}
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV valorMax = comun.obtenerParGeneralOV(uid, "COMREINMAX");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "COMREINMAX");
				if (valorMax == null || valorMax.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el numero maximo de integrantes.");
				}
				if (integrantesList.size() < Integer.parseInt(valorMin.getCgValor()) || integrantesList.size()
						> Integer.parseInt(valorMax.getCgValor())) {
					throw new Exception("El número de integrantes esta fuera del rango permitido (min: "
						+ valorMin.getCgValor() + " , max: " + valorMax.getCgValor() + ")");
				}
			}

			if (contratoOV.getFrecuencia().equals("S")) {
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV plazoMin = comun.obtenerParGeneralOV(uid, "PLAMINSEM");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "PLAMINSEM");
				if (plazoMin == null || plazoMin.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el plazo minimo.");
				}
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV plazoMax = comun.obtenerParGeneralOV(uid, "PLAMAXSEM");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "PLAMAXSEM");
				if (plazoMax == null || plazoMax.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el plazo maximo.");
				}
				if (contratoOV.getPlazo() < Integer.parseInt(plazoMin.getCgValor()) || contratoOV.getPlazo()
						> Integer.parseInt(plazoMax.getCgValor())) {
					throw new Exception("Verifique plazo (Min: " + plazoMin.getCgValor() + " , Max: " + plazoMax.getCgValor());
				}
			}
			if (contratoOV.getFrecuencia().equals("C")) {
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV plazoMin = comun.obtenerParGeneralOV(uid, "PLAMINCAT");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "PLAMINCAT");
				if (plazoMin == null || plazoMin.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el plazo minimo.");
				}
				LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
				ParGeneralOV plazoMax = comun.obtenerParGeneralOV(uid, "PLAMAXCAT");
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "PLAMAXCAT");
				if (plazoMax == null || plazoMax.getCgValor().trim().isEmpty()) {
						throw new Exception("No fue posible obtener el plazo maximo.");
				}
				if (contratoOV.getPlazo() < Integer.parseInt(plazoMin.getCgValor()) || contratoOV.getPlazo()
						> Integer.parseInt(plazoMax.getCgValor())) {
					throw new Exception("Verifique plazo (Min: " + plazoMin.getCgValor() + " , Max: " + plazoMax.getCgValor());
				}
			}
			//Fin Validacion numero de integrantes y plazo


			//Validacion Dias Renovacion Financiada
		if (contratoOV.getRenovacionFinanciada()) {
			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerParGeneral");
			ParGeneralOV diasRen = comun.obtenerParGeneralOV(uid, "DIASRENFIN");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "DIASRENFIN");
			if (diasRen == null || diasRen.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener los dias de Renovacion de par_general.");
			}

			String numConAnt = comun.obtenerNumeroContrato(uid, contratoOV.getContratoActual().trim());

			if (numConAnt == null) {
				throw new Exception("No hay resultados para obtener el numero de contrato anterior.");
			}

			final java.util.HashMap<String, Object> paramDias = new HashMap<String, Object>();
			paramDias.put( "contratoAnt" , numConAnt);
			paramDias.put( "dias" , diasRen.getCgValor());

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtFecDatAntConfirmar");
			ContratoOV contratoAnt = (ContratoOV) sesion.selectOne("obtFecDatAntConfirmar", paramDias);

			if ( contratoAnt == null) {
				throw new Exception("No se pudo recuperar informacion del contrato anterior para la validacion de los dias de"
						+ "renovacion financiada.");
			}

			Calendar fechaHoy = Calendar.getInstance();

			if (fechaContable.after(contratoAnt.getFechaMaxima()) || fechaContable.equals(contratoAnt.getFechaMaxima())) {
				throw new Exception("La renovación debio ser capturada/confirmada antes de: "
						+ simpleDateFormat.format(contratoAnt.getFechaMaxima()) + " para la fecha de liquidación restan "
						+ diferenciaEnDias(contratoAnt.getFechaMaxima(), fechaHoy.getTime()));
			}

		}
//Fin Validacion Dias Renovacion Financiada


		//Validacion Renovacion Ordinaria
		if (contratoOV.getRenovacion()) {
			String numConAnt = comun.obtenerNumeroContrato(uid, contratoOV.getContratoActual().trim());

			if (numConAnt == null) {
				throw new Exception("No hay resultados para obtener el numero de contrato anterior.");
			}

			final java.util.HashMap<String, Object> paramRenOrd = new HashMap<String, Object>();
			paramRenOrd.put( "contratoAnt" , numConAnt);

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtDatAntConfirmar");
			ContratoOV contratoAnt = (ContratoOV) sesion.selectOne("obtDatAntConfirmar", paramRenOrd);

			if ( contratoAnt == null) {
				throw new Exception("No se pudo recuperar informacion del contrato anterior para la validacion de la"
						+ " Renovacion Ordinaria");
			}

			if (!contratoAnt.getStatus().equals("P")) {
				throw new Exception("El contrato anterior (" + numConAnt + ") no ha sido liquidado."
						+ " Para confirmar este crédito liquide el contrato previo.");
			}

		}
	//Fin Validacion Renovacion Ordinaria



	//Validacion Traspaso y aplicar garantia
		if (contratoOV.getAplicarGarantia().equals("S") && contratoOV.getAplicarGarantiaDesertor().equals("S")) {
			throw new Exception("Debes seleccionar solo una opcion aplicar garantia o aplicar garantia desertor.");
		}

	boolean aplicoGarantiaParcialidad = false;
	//Se valida Aplicar Garantia ***
		if (contratoOV.getRenovacionFinanciada() && contratoOV.getAplicarGarantia().equals("S")) {

			String contratoAnterior = comun.obtenerNumeroContrato(uid, contratoOV.getContratoActual().trim());

			if (contratoAnterior == null) {
				throw new Exception("No hay resultados para obtener el numero de contrato anterior.");
			}

			final java.util.HashMap<String, Object> parametrosConAnt = new HashMap<String, Object>();
			parametrosConAnt.put( "contratoAnt" , contratoAnterior);

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtDatAntConfirmar");
			ContratoOV contratoAntOV = (ContratoOV) sesion.selectOne("obtDatAntConfirmar", parametrosConAnt);

			if ( contratoAntOV == null) {
				throw new Exception("No se pudo recuperar informacion del contrato anterior para el traspaso de"
						+ " garantia.");
			}

			if (contratoAntOV.getSaldoGarantia() > 0.0) {
				//Se obtienen los parametros que se van a enviar
				//Se inserta el tipo de movimiento en contrato_movimientos_dg
				FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

				// Obtiener id de transaccion
				Integer idTransaccion = comun.obtenerIdTransaccion(uid, contratoOV.getSucursal(), fechaContableOV.getFecha());
				LogHandler.info(uid, getClass(), " idTransaccion=" + idTransaccion);

				double montoCapital = 0.0;
				double montoInteres = 0.0;
				double montoRecargos = 0.0;

				//Se inserta el tipo de movimiento en contrato_movimientos_dg
				HashMap<String, Object> paramsMovimientos = new HashMap<String, Object>();
				paramsMovimientos.put("contrato", contratoAnterior);
				paramsMovimientos.put("codigo", CODIGO_APLICA_GARANTIA_PARCIALIDAD);
				paramsMovimientos.put("fechaContable", formatter.format(fechaContable.getTime()));
				paramsMovimientos.put("fechaValor", formatter.format(fechaContable.getTime()));
				paramsMovimientos.put("importe", contratoAntOV.getSaldoGarantia());
				paramsMovimientos.put("montoCapital", montoCapital);
				paramsMovimientos.put("montoInteres", montoInteres);
				paramsMovimientos.put("montoRecargos", montoRecargos);
				paramsMovimientos.put("usuario", "000000043");
				paramsMovimientos.put("noIntegrante", "");
				paramsMovimientos.put("folioCheque", 0);
				paramsMovimientos.put("contratoTransaccion", "");
				paramsMovimientos.put("fechaBaja", "");
				paramsMovimientos.put("usuarioBaja", "");

				for ( String string : paramsMovimientos.keySet() ) {
					LogHandler.info(uid, getClass(), string + " -- " + paramsMovimientos.get( string ) );
				}

				LogHandler.trace(uid, getClass(), "==> insertaMovimientoDepositoGarantia - insertContratoMovimientosGarantia");
				sesionTx.insert("insertContratoMovimientosGarantia", paramsMovimientos);

				//Se hace un update a contrato_deposito_garantia
				HashMap<String, Object> paramsActDepGar = new HashMap<String, Object>();
		    	paramsActDepGar.put("contrato", contratoAnterior);
		    	paramsActDepGar.put("montoAplicar", contratoAntOV.getSaldoGarantia());
		    	LogHandler.trace(uid, getClass(),
		    			"==> aplicarGarantiaLiquidacion - actualizaSaldoGarantiaDepositoGarantia");
		    	sesionTx.update("actualizaSaldoGarantiaDepositoGarantia", paramsActDepGar);

		    	//Pago
                final PagoGrupal pago = new PagoGrupal();
                PagoGrupalResponse pagoResponse = new PagoGrupalResponse();

                pago.setMonto(contratoAntOV.getSaldoGarantia());
                pago.setNumeroContrato(contratoAnterior);
                pago.setMedioPago(contratoAntOV.getMedioPago() + "_");
                pago.setReferencia("");
                pago.setTipoPago(ConstantesPagos.TIPO_PAGO_NORMAL.getValue());
                pago.setUsuario(peticion.getUsuario());
                pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());
                pago.setIdTransaccionValida(null);
                LogHandler.info(uid, getClass(), "medio Pago: Pago " + pago.getMedioPago());
                pagoResponse = pagos.aplicarPagoGrupal(uid, sesionTx, idTransaccion, pago );

                if ( !pagoResponse.getHeader().isEstatus()) {
    				throw new Exception(pagoResponse.getHeader().getMensaje());
    			}
                aplicoGarantiaParcialidad = true;
			}
		}

		//VARIABLE PARA SABER SI SE APLICO GARANTIA POR DESERTOR
        boolean aplicoGarantiaDesertor = false;
		//Se obtiene los desertores si Aplicar Garantia desertor
        if (contratoOV.getRenovacionFinanciada() && contratoOV.getAplicarGarantiaDesertor().equals("S")) {

            Double montoAplicarGarantiaDesertor = 0.0;
            Double sumaPctParticipacion = 0.0;

            //Obtener los elementos de integrantes
            LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarIntegrantesGarantiaDesertor");
            LogHandler.info(uid, getClass(), "confirmarCreditoTarea: - obtenerConfirmarIntegrantesGarantiaDesertor");
            @SuppressWarnings("unchecked")
            List<IntegranteOV> integrantesListGarantia = (List<IntegranteOV>) sesion.selectList(
                                "obtenerConfirmarIntegrantesGarantiaDesertor", peticion.getSolicitud());

            if (integrantesListGarantia == null || integrantesListGarantia.size() == 0) {
                throw new Exception("La consulta no arrojo resultados de integrantes para la solicitud");
            }

            for (int i = 0; i < integrantesListGarantia.size(); i++) {
                montoAplicarGarantiaDesertor = montoAplicarGarantiaDesertor
                        + integrantesListGarantia.get(i).getDesertorGarantiaAplicar();

                sumaPctParticipacion = sumaPctParticipacion
                        + integrantesListGarantia.get(i).getPctParticipacion();
            }

            LogHandler.info(uid, getClass(), "montoAplicarGarantiaDesertor: " + montoAplicarGarantiaDesertor);
            LogHandler.info(uid, getClass(), "sumaPctParticipacion: " + sumaPctParticipacion);

            //Datos Contrato Anterior
            String contratoAnterior = comun.obtenerNumeroContrato(uid, contratoOV.getContratoActual().trim());

            if (contratoAnterior == null) {
                throw new Exception("No hay resultados para obtener el numero de contrato anterior.");
            }

            final java.util.HashMap<String, Object> parametrosConAnt = new HashMap<String, Object>();
            parametrosConAnt.put( "contratoAnt" , contratoAnterior);

            LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtDatAntConfirmar");
            ContratoOV contratoAntOV = (ContratoOV) sesion.selectOne("obtDatAntConfirmar", parametrosConAnt);

            if ( contratoAntOV == null) {
                throw new Exception("No se pudo recuperar informacion del contrato anterior para el traspaso de"
                        + " garantia.");
            }

            if (montoAplicarGarantiaDesertor > 0.0 && contratoAntOV.getSaldoGarantia() > 0.0) {

                //Se obtienen los parametros que se van a enviar
                //Se inserta el tipo de movimiento en contrato_movimientos_dg
                FechaContableOV fechaContableOV = comun.obtenerFechaContable( uid );

                // Obtiener id de transaccion
                Integer idTransaccion = comun.obtenerIdTransaccion(uid, contratoOV.getSucursal(), fechaContableOV.getFecha());
                LogHandler.info(uid, getClass(), " idTransaccion=" + idTransaccion);

                double montoCapital = 0.0;
                double montoInteres = 0.0;
                double montoRecargos = 0.0;

                //Se inserta el tipo de movimiento en contrato_movimientos_dg
                HashMap<String, Object> paramsMovimientos = new HashMap<String, Object>();
                paramsMovimientos.put("contrato", contratoAnterior);
                paramsMovimientos.put("codigo", CODIGO_APLICA_GARANTIA_DESERTOR);
                paramsMovimientos.put("fechaContable", formatter.format(fechaContable.getTime()));
                paramsMovimientos.put("fechaValor", formatter.format(fechaContable.getTime()));
                paramsMovimientos.put("importe", montoAplicarGarantiaDesertor);
                paramsMovimientos.put("montoCapital", montoCapital);
                paramsMovimientos.put("montoInteres", montoInteres);
                paramsMovimientos.put("montoRecargos", montoRecargos);
                paramsMovimientos.put("usuario", "000000043");
                paramsMovimientos.put("noIntegrante", "");
                paramsMovimientos.put("folioCheque", 0);
                paramsMovimientos.put("contratoTransaccion", "");
                paramsMovimientos.put("fechaBaja", "");
                paramsMovimientos.put("usuarioBaja", "");

                for ( String string : paramsMovimientos.keySet() ) {
                    LogHandler.info(uid, getClass(), string + " -- " + paramsMovimientos.get( string ) );
                }

                LogHandler.trace(uid, getClass(), "==> insertaMovimientoDepositoGarantia - insertContratoMovimientosGarantia");
                sesionTx.insert("insertContratoMovimientosGarantia", paramsMovimientos);

                //Se hace un update a contrato_deposito_garantia
                HashMap<String, Object> paramsActDepGar = new HashMap<String, Object>();
                paramsActDepGar.put("contrato", contratoAnterior);
                paramsActDepGar.put("montoAplicar", montoAplicarGarantiaDesertor);
                LogHandler.trace(uid, getClass(),
                        "==> aplicarGarantiaLiquidacion - actualizaSaldoGarantiaDepositoGarantia");
                sesionTx.update("actualizaSaldoGarantiaDepositoGarantia", paramsActDepGar);

                //Pago
                final PagoGrupal pago = new PagoGrupal();
                PagoGrupalResponse pagoResponse = new PagoGrupalResponse();

                pago.setMonto(montoAplicarGarantiaDesertor);
                pago.setNumeroContrato(contratoAnterior);
                pago.setMedioPago(contratoAntOV.getMedioPago() + "_");
                pago.setReferencia("");
                pago.setTipoPago(ConstantesPagos.TIPO_PAGO_ABONO.getValue());
                pago.setUsuario(peticion.getUsuario());
                pago.setCodigo(ConstantesPagos.PAGO_REFERENCIADO.getValue());
                pago.setIdTransaccionValida(null);
                LogHandler.info(uid, getClass(), "medio Pago: Pago " + pago.getMedioPago());
                pagoResponse = pagos.aplicarPagoGrupal(uid, sesionTx, idTransaccion, pago );

                if ( !pagoResponse.getHeader().isEstatus()) {
                    throw new Exception(pagoResponse.getHeader().getMensaje());
                }
                aplicoGarantiaDesertor = true;

            }
        }

      //Ocurrio un pago?
        LogHandler.trace(uid, getClass(), "aplicarGarantiaLiquidacion : aplicoGarantiaParcialidad = " + aplicoGarantiaParcialidad
        		+ "aplicoGarantiaDesertor = " + aplicoGarantiaDesertor);
        if ( aplicoGarantiaParcialidad || aplicoGarantiaDesertor ) {
        	contratoOV.setPagoGarantia(true);
        } else {
        	contratoOV.setPagoGarantia(false);
        }

        //TEMPORAL PARA ORDINARIAS, CAMBIAR PARA FINANCIADAS.
        //(la renovacion financiada se marcara a renovacion para el codigo de registar)
        contratoOV.setContratoRenovacion(contratoOV.getContratoActual());
        if (contratoOV.getRenovacion()) {
        	contratoOV.setContratoActual(null);
        }
        if (contratoOV.getRenovacionFinanciada()) {
            contratoOV.setRenovacion(true);
        }

        //Registramos el contrato
		LogHandler.info(uid, getClass(), "se manda a registrar contratoOV: " + contratoOV);
		respuestaReg = registrar(uid, sesionTx, contratoOV);
		//Fin Registramos el contrato

		if (!respuestaReg.getHeader().isEstatus()) {
			 throw new Exception(respuestaReg.getHeader().getMensaje());
		}

		if (respuestaReg.getContrato() == null || respuestaReg.getContrato().trim().isEmpty()) {
				throw new Exception("No se pudo recuperar informacion del Contrato Nuevo");
		}

			//Traspaso si Garantia
			//		Que los dos contratos existan
			//		Que los dos sean del producto garantía.
		    //      Que sea renovacion financiada u ordinaria
			//		Que el crédito viejo este liquidado, estatus P.
			//		Que el saldo de la garantía a traspasar sea mayor a 0.
		    //      si es renovada o financiada
		    //      si es transpaso garantia
				if ((contratoOV.getProducto().trim().equals("GCDG") || contratoOV.getProducto().trim().equals("GCDC"))
						&& (contratoOV.getRenovacionFinanciada() || contratoOV.getRenovacion() )) {
				if (contratoOV.getTraspasoGarantia().equals("S")) {
						LogHandler.info(uid, getClass(), "Inicia traspaso garantia TraspasoGarantia: "
				                                       + contratoOV.getTraspasoGarantia());

						SimpleDateFormat formato = new SimpleDateFormat("yyyyMMdd");
						String contratoAnterior = comun.obtenerNumeroContrato(uid, contratoOV.getContratoRenovacion().trim());

						if (contratoAnterior == null) {
							throw new Exception("No hay resultados para obtener el numero de contrato anterior.");
						}

						final java.util.HashMap<String, Object> parametrosConAnt = new HashMap<String, Object>();
						parametrosConAnt.put( "contratoAnt" , contratoAnterior);

						LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - obtDatAntConfirmarTraspaso");
						//nos manda el status, el saldo de la garantia y el producto
						ContratoOV contratoAnt = (ContratoOV) sesionTx.selectOne("obtDatAntConfirmarTraspaso", parametrosConAnt);

						if ( contratoAnt == null) {
							throw new Exception("No se pudo recuperar informacion del contrato anterior para el traspaso de"
									+ " garantia.");
						}
						//se valida si esl contrato anterior su estatus es liquidado
						if (contratoAnt.getStatus().equals("P")) {
						LogHandler.info(uid, getClass(), "Traspaso garantia saldo garantia = " + contratoAnt.getSaldoGarantia());

						//Paso 1: Calcular el monto de la garantia de la solicitud
						double montoGarantiaSolicitudCredito = (contratoOV.getMonto_otorgado() != null
								                               && contratoOV.getPctGarantia() != null)
								                             ? contratoOV.getMonto_otorgado() * contratoOV.getPctGarantia() / 100 : 0.0;

						LogHandler.info(uid, getClass(), "contratoOV.getMonto_otorgado: " + contratoOV.getMonto_otorgado()
						  + " \ncontratoOV.getPctGarantia: " + contratoOV.getPctGarantia()
						  + "\nmontoGarantiaSolicitudCredito: " + montoGarantiaSolicitudCredito);

						//Paso 2: Obtener Monto de la garantia del contrato anterior
						LogHandler.info(uid, getClass(), "Saldo garantia contrato amterior: " + contratoAnt.getSaldoGarantia());

							ParGeneralOV listaCodigos = comun.obtenerParGeneralOV(uid,
									"mx.com.independencia.devoluciones.garantia.parciales");

							final java.util.HashMap<String, Object> parametrosMontoDev = new HashMap<String, Object>();
							parametrosMontoDev.put("contrato", contratoAnterior);
							parametrosMontoDev.put("listDevolucionesParciales", listaCodigos.getCgValor().split(";"));

							LogHandler.info(uid, getClass(), "parametrosMontoDev: " + parametrosMontoDev);

							Double montoDev = (Double) sesionTx.selectOne("obtenerMontoDevolucionesParciales",
									parametrosMontoDev);

							if ( montoDev == null ) {
								montoDev = 0d;
							}

							Double saldoTraspaso = 0d;
							saldoTraspaso = contratoAnt.getSaldoGarantia() - montoDev;

							if (saldoTraspaso < 0) {
								saldoTraspaso = 0d;
							}
							saldoTraspaso = Funciones.redondeo(saldoTraspaso);
							LogHandler.info(uid, getClass(), "saldo que puede ser traspasados: " + saldoTraspaso);

							//Paso 3: Validar montoGarantiaSolicitudCredito >= contratoAnt.getSaldoGarantia()
					         //realizar traspaso del paso2 al paso 1
					       if (montoGarantiaSolicitudCredito >= saldoTraspaso) {
					    	   LogHandler.info(uid, getClass(), "Entre al paso 3 de la "
					    	   		+ "validacion del traspaso de la garantia-----");

							//Sumar Garantia Credito Nuevo
							final java.util.HashMap<String, Object> parametrosSumTraspaso = new HashMap<String, Object>();
							parametrosSumTraspaso.put("contratoAnt" , contratoAnterior);
							parametrosSumTraspaso.put("contratoNuevo", respuestaReg.getContrato());
							parametrosSumTraspaso.put("saldoTraspaso" , saldoTraspaso);

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - insertarTraspasoConDepGar");
							Integer contratoValor = sesionTx.insert( "insertarTraspasoConDepGar", parametrosSumTraspaso);

							LogHandler.info(uid, getClass(), "numeroRegistros: " + contratoValor);

							final java.util.HashMap<String, Object> parametrosSumTraspaso2 = new HashMap<String, Object>();
							parametrosSumTraspaso2.put("contratoAnt" , contratoAnterior);
							parametrosSumTraspaso2.put("contratoNuevo", respuestaReg.getContrato());
							parametrosSumTraspaso2.put("saldoTraspaso" , saldoTraspaso);
							parametrosSumTraspaso2.put("codigo", "DGTR");
							parametrosSumTraspaso2.put("fechaContable" , formato.format(fechaContable));
							parametrosSumTraspaso2.put("usuario", "000000043");

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - insertarTraspasoSumConMovDepGar");
							sesionTx.insert( "insertarTraspasoSumConMovDepGar", parametrosSumTraspaso2 );

							//Restar Garantia Credito Viejo
							final java.util.HashMap<String, Object> parametrosResTraspaso = new HashMap<String, Object>();
							parametrosResTraspaso.put("contratoAnt" , contratoAnterior);
							parametrosResTraspaso.put("saldoTraspaso" , saldoTraspaso);
							parametrosResTraspaso.put("saldoGarantia", contratoAnt.getSaldoGarantia());

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - actualizarSaldoDepGar");
							sesionTx.update("actualizarSaldoDepGar", parametrosResTraspaso);

							parametrosResTraspaso.put("contratoNuevo", respuestaReg.getContrato());
							parametrosResTraspaso.put("codigo", "TRGR");
							parametrosResTraspaso.put("fechaContable" , formato.format(fechaContable));
							parametrosResTraspaso.put("usuario", "000000043");

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - insertarTraspasoConMovDepGarRes");
							sesionTx.insert( "insertarTraspasoConMovDepGarRes", parametrosResTraspaso );
						//Paso 4 :	Validar montoGarantiaSolicitudCredito < contratoAnt.getSaldoGarantia()
						//traspasar contratoAnt.getSaldoGarantia al  montoGarantiaSolicitudCredito y
							//el monto restante de queda en el contrato anterior
						} else if (montoGarantiaSolicitudCredito < saldoTraspaso) {
							LogHandler.info(uid, getClass(), "Entre al paso 4 de la validacion del traspaso de la garantia-----");

							//Sumar Garantia Credito Nuevo
							final java.util.HashMap<String, Object> parametrosSumTraspaso = new HashMap<String, Object>();
							parametrosSumTraspaso.put("contratoAnt" , contratoAnterior);
							parametrosSumTraspaso.put("contratoNuevo", respuestaReg.getContrato());
							parametrosSumTraspaso.put("saldoTraspaso" , montoGarantiaSolicitudCredito);

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - insertarTraspasoConDepGar: "
							                                + parametrosSumTraspaso);
							Integer contratoValor = sesionTx.insert( "insertarTraspasoConDepGar", parametrosSumTraspaso);

							LogHandler.info(uid, getClass(), "numeroRegistros: " + contratoValor);

							final java.util.HashMap<String, Object> parametrosSumTraspaso2 = new HashMap<String, Object>();
							parametrosSumTraspaso2.put("contratoAnt" , contratoAnterior);
							parametrosSumTraspaso2.put("contratoNuevo", respuestaReg.getContrato());
							parametrosSumTraspaso2.put("saldoTraspaso" , montoGarantiaSolicitudCredito);
							parametrosSumTraspaso2.put("codigo", "DGTR");
							parametrosSumTraspaso2.put("fechaContable" , formato.format(fechaContable));
							parametrosSumTraspaso2.put("usuario", "000000043");

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - insertarTraspasoSumConMovDepGar: "
									                        + parametrosSumTraspaso2);
							sesionTx.insert( "insertarTraspasoSumConMovDepGar", parametrosSumTraspaso2 );

							//Restar Garantia Credito Viejo
							final java.util.HashMap<String, Object> parametrosResTraspaso = new HashMap<String, Object>();
							parametrosResTraspaso.put("contratoAnt" , contratoAnterior);
							parametrosResTraspaso.put("saldoTraspaso" , montoGarantiaSolicitudCredito);
							parametrosResTraspaso.put("saldoGarantia", contratoAnt.getSaldoGarantia());

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - actualizarSaldoDepGar: "
							                 + parametrosResTraspaso);
							sesionTx.update("actualizarSaldoDepGar", parametrosResTraspaso);

							parametrosResTraspaso.put("contratoNuevo", respuestaReg.getContrato());
							parametrosResTraspaso.put("codigo", "TRGR");
							parametrosResTraspaso.put("fechaContable" , formato.format(fechaContable));
							parametrosResTraspaso.put("usuario", "000000043");

							LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - insertarTraspasoConMovDepGarRes");
							sesionTx.insert( "insertarTraspasoConMovDepGarRes", parametrosResTraspaso );
						}

					} //termina validacion de contrato liquidado
				}
			} //Fin Traspaso si Garantia

			//Atomo GENERA_CONTRATO
			AtomosOV peticionAtomosOV = new AtomosOV();
			peticionAtomosOV.setProceso("GENERA_CONTRATO");
			peticionAtomosOV.setSolicitud(peticion.getSolicitud());
			peticionAtomosOV.setUsuarioGeneroAtomo(peticion.getUsuario());
			peticionAtomosOV.setComentario(respuestaReg.getContrato());
			AtomosRespuesta respuestaAtomos = solicitudes.registrarAtomosTarea(uid, sesionTx, peticionAtomosOV);
			if (!respuestaAtomos.getHeader().isEstatus()) {
				throw new Exception("No se pudo registrar el atomo" + respuestaAtomos.getHeader().getMensaje());
			}

			//Afiliacion
			AfiliacionSeguroRespuesta respuestaAfiliacion = afiliacionSeguros(uid, respuestaReg.getContrato(), contratoOV);
			//Fin Afiliacion

			if (!respuestaAfiliacion.getHeader().isEstatus()) {
				throw new Exception("Ocurrio un error al momento de afiliar los seguros en afiliacionSeguros:"
				+ respuestaAfiliacion.getHeader().getMensaje());
			}

			//Update a solicitudes Finsol
			final java.util.HashMap<String, Object> parActCont = new HashMap<String, Object>();
			parActCont.put("contrato", respuestaReg.getContrato());
			parActCont.put("solicitud", peticion.getSolicitud());

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea: - actualizarContratoConfirmar");
			sesionTx.update("actualizarContratoConfirmar", parActCont);

			LogHandler.info(uid, getClass(), "COMMIT!!!!");
			sesionTx.commit(true);

			//CAT el SP tiene problemas con la transaccional
			// se calcula y se guarda el CAT del contrato solo para las que no tienen trasaccional
			LogHandler.trace(uid, getClass(), "==> registrar - obtenerAmortizacionGrupal" );
			final List<AmortizacionOV> pagosAmortizacion =
					(List<AmortizacionOV>) sesion.selectList("obtenerAmortizacionGrupal", respuestaReg.getContrato() );

			final List<Double>
					pagosPeriodo = new ArrayList<Double>();

			try {

				for (AmortizacionOV amortizacionOV : pagosAmortizacion) {
					final java.lang.Double  montoSinIva = amortizacionOV.getAbonoCapital()
							+ ( amortizacionOV.getInteresPeriodo() / ( 1.0 + respuestaReg.getIva() / 100.0 ));
					pagosPeriodo.add( montoSinIva );
				}

				final ConsultaCATPeticion consultaCATPeticion = new ConsultaCATPeticion();
				consultaCATPeticion.setMontoCredito( contratoOV.getMonto_otorgado( ) );
				consultaCATPeticion.setPagos( pagosPeriodo );
				consultaCATPeticion.setPeriodo( contratoOV.getFrecuencia( ).trim().startsWith( "S" ) ? 52
						: contratoOV.getFrecuencia( ).trim().startsWith( "C" ) ? 26 : 12 );
				consultaCATPeticion.setPlazo( pagosPeriodo.size() );

				LogHandler.info(uid, getClass(), "Objeto que se envia a calcular el CAT : " + consultaCATPeticion );

				final ConsultaCATRespuesta
					  consultaCATRespuesta = consultas.consultarCAT( consultaCATPeticion, uid );


				final java.util.HashMap<String, Object>
						paramsCondicionesContrato = new HashMap<String, Object>();
						paramsCondicionesContrato.put( "producto", contratoOV.getProducto() );
						paramsCondicionesContrato.put( "contrato", respuestaReg.getContrato() );
						paramsCondicionesContrato.put( "valor"	 , consultaCATRespuesta.getCAT().toString() );

				LogHandler.trace(uid, getClass(), "==> registrar - insertarCondicionesContratoCAT");
				//Cambio sesion NTX a TX
				sesionTx.insert( "insertarCondicionesContratoCAT", paramsCondicionesContrato );
				sesionTx.commit(true);
			} catch (java.lang.Exception exception) {
				LogHandler.error( uid, getClass(), ReadProperties.mensajes.getProp("originacion.registrarcredito.errorcat")
						+ respuestaReg.getLd_contrato(), exception );
			}

			//2013-10-11
			//MMH Registrar sucursal cobranza

			final HashMap<String, Object>	paramActSucursalCobranza = new HashMap<String, Object>();
			paramActSucursalCobranza.put("tipo_ejecucion", "U");
			paramActSucursalCobranza.put("contrato", respuestaReg.getContrato());

			LogHandler.trace(uid, getClass(), "==> registrar - actualizaSucursalCobranza");
			sesion.selectOne( "actualizaSucursalCobranza", paramActSucursalCobranza );

			respuesta.setContratoLD(respuestaReg.getLd_contrato());
			respuesta.getHeader().setEstatus(true);
			respuesta.getHeader().setMensaje("El credito se ha confirmado correctamente.");

		}
		catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.info(uid, getClass(), "ROLLBACK REALIZADO!!!");
			LogHandler.error(uid, getClass(), "Existio un error en confirmarCreditoTarea(): " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(e.getMessage());

		}
		finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Round two decimals.
	 *
	 * @param d the d
	 * @return el valor double redondeado
	 */
	public double roundTwoDecimals(double d) {
	      DecimalFormat twoDForm = new DecimalFormat("#.##");
	      return Double.valueOf(twoDForm.format(d));
	}

	/**
	 * Verifica si Seguro completo.
	 *
	 * @param arregloIntegrantes the arreglo integrantes
	 * @return the string
	 */
	private Boolean existeSeguro(List<IntegranteOV> arregloIntegrantes) {
		Boolean unotieneSeguro = false;
		for (int i = 0; i < arregloIntegrantes.size(); i++) {
	                if (arregloIntegrantes.get(i).getSeguroVida().equals("S")
	                		| arregloIntegrantes.get(i).getSeguroEnfermedad().equals("S")) {
	                	unotieneSeguro = true;
	                }
		}
		return unotieneSeguro;
	}

	/**
	 * Verifica si Seguro completo.
	 *
	 * @param arregloIntegrantes the arreglo integrantes
	 * @return the string
	 */
	private Boolean existeSeguroVida(List<IntegranteOV> arregloIntegrantes) {
		Boolean unotieneSeguro = false;
		for (int i = 0; i < arregloIntegrantes.size(); i++) {
	                if (arregloIntegrantes.get(i).getSeguroVida().equals("S")) {
	                	unotieneSeguro = true;
	                }
		}
		return unotieneSeguro;
	}

	/**
	 * Afiliacion seguros.
	 *
	 * @param uid the uid
	 * @param contrato the contrato
	 * @param contratoOV the contrato ov
	 * @return the afiliacion seguro respuesta
	 */
	private AfiliacionSeguroRespuesta afiliacionSeguros(String uid, String contrato, ContratoOV contratoOV) {
		AfiliacionSeguroRespuesta respuesta = new  AfiliacionSeguroRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;

		Integer plazoSeguro = 0;
		Integer plazoCredito = 0;
		String peticion = "";

		IntegranteOV[] arregloIntegrantes = contratoOV.getIntegrantes();

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy" );

		Boolean unotieneSeguro = seguroCompleto(arregloIntegrantes);
		String grupoCompleto = grupoCompleto(arregloIntegrantes);

		if (unotieneSeguro) {
		peticion = "<clientes>";
        peticion += "<grupoCompleto>" + grupoCompleto + "</grupoCompleto>";

		for (int i = 0; i < arregloIntegrantes.length; i++) {


			if (arregloIntegrantes[i].getSeguroVida().equals("S") || arregloIntegrantes[i].getSeguroEnfermedad().equals("S")) {

				if (arregloIntegrantes[i].getPlazoSeguro().equals("A")) {
		            plazoSeguro = Constantes.SEMANAS_ANIO;
				} else {
		            plazoSeguro = obtienePlazoSeguroSemanas(contratoOV.getProducto(), contratoOV.getPlazo());
				}

				plazoCredito = obtienePlazoSeguroSemanas(contratoOV.getProducto(), contratoOV.getPlazo());

				peticion += "<cliente>";
                peticion += "<inicioVigencia>" + simpleDateFormat.format(contratoOV.getFecha_desembolso()) + "</inicioVigencia>";
                peticion += "<numero>" + arregloIntegrantes[i].getCliente().trim() + "</numero>";
                peticion += "<numeroContrato>" + contrato + "</numeroContrato>";
                peticion += "<numeroSucursal>" + contratoOV.getSucursal() + "</numeroSucursal>";
                peticion += "<usuario>" + contratoOV.getUsuario() + "</usuario>";
                peticion += "<vendedor>" + contratoOV.getAsesor().trim() + "</vendedor>";
                peticion += "<plazoSeguro>" + plazoSeguro + "</plazoSeguro>"; //STAF-70 AOC
                peticion += "<seguroVida>" + arregloIntegrantes[i].getSeguroVida() + "</seguroVida>"; //STAF-70 AOC
                peticion += "<plazoCredito>" + plazoCredito + "</plazoCredito>";
                peticion += "<seguroEnfermedad>" + arregloIntegrantes[i].getSeguroEnfermedad() + "</seguroEnfermedad>";

                //Envio de edad MIMH 20151014
                peticion += "<edad>" + arregloIntegrantes[i].getEdad() + "</edad>";

                peticion += "<beneficiarios>";

                if (arregloIntegrantes[i].getSeguroVida().equals("S")) {
                    //se obtienen los beneficiarios
                if (contratoOV.getBeneficiarioCliente().size() > 0) {

                for (int j = 0; j < contratoOV.getBeneficiarioCliente().size(); j++) {
                    if (arregloIntegrantes[i].getCliente().trim().equals(contratoOV.getBeneficiarioCliente()
                    		.get(j).getPersona())) {
                    	for (int k = 0; k < contratoOV.getBeneficiarioCliente().get(j).getBeneficiarios().size(); k++) {

	                    peticion += "<beneficiario>";

	                    peticion += "<apellidoPaterno>" + contratoOV.getBeneficiarioCliente().get(j).getBeneficiarios()
	                    		.get(k).getApellidoPat() + "</apellidoPaterno>";
	                    peticion += "<apellidoMaterno>" + contratoOV.getBeneficiarioCliente().get(j).getBeneficiarios()
	                    		.get(k).getApellidoMat() + "</apellidoMaterno>";
	                    peticion += "<nombre>" + contratoOV.getBeneficiarioCliente().get(j).getBeneficiarios()
	                    		.get(k).getNombre() + "</nombre>";
	                    peticion += "<parentesco>" + contratoOV.getBeneficiarioCliente().get(j).getBeneficiarios()
	                    		.get(k).getParentesco() + "</parentesco>";
	                    peticion += "<porcentaje>" + contratoOV.getBeneficiarioCliente().get(j).getBeneficiarios()
	                    		.get(k).getPorcentaje().intValue() + "</porcentaje>";

	                    peticion += "</beneficiario>";

                    	}
                    }
                   }

                  }
                } else {
                    if (arregloIntegrantes[i].getSeguroEnfermedad().equals("S"))
                    {
                        peticion += "<beneficiario>";
                        peticion += "<apellidoPaterno>X</apellidoPaterno>";
                        peticion += "<apellidoMaterno></apellidoMaterno>";
                        peticion += "<nombre>X</nombre>";
                        peticion += "<parentesco>0</parentesco>";
                        peticion += "<porcentaje>0</porcentaje>";
                        peticion += "</beneficiario>";
                    }
                }

                peticion += "</beneficiarios>";
                peticion += "</cliente>";

			}

	} //fin for

		peticion += "</clientes>";

		LogHandler.info(uid, getClass(), "afiliacionSeguros - Datos de salida XML: " + peticion);

		try {
			LogHandler.info(uid, getClass(), "confirmarCreditoTarea - Abriendo conexion...");
			sesion = FabricaConexiones.obtenerSesionNTx();

			LogHandler.info(uid, getClass(), "Se intenta obtener una instancia del WS");

			LogHandler.trace(uid, getClass(), "afiliacionSeguros: - obtenerParGeneral");
			ParGeneralOV urlWSAfiliacion = comun.obtenerParGeneralOV(uid, "WS_AFILIAC");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "WS_AFILIAC");
			if (urlWSAfiliacion == null || urlWSAfiliacion.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de afiliaciones.");
			}

			LogHandler.info(uid, getClass(), "afiliacionSeguros - afiliar URL= " + urlWSAfiliacion.getCgValor().trim());

			////////////////////////////************************************//////////////////////
			//urlWSAfiliacion.setCgValor("http://10.1.50.139:7001/CredisegurosWS/AfiliacionService?wsdl");

			AfiliacionServiceLocator servicioAfiliacion = new AfiliacionServiceLocator();
			servicioAfiliacion.setAfiliacionPortEndpointAddress(urlWSAfiliacion.getCgValor().trim());
			String respuestaAfiliacion = servicioAfiliacion.getAfiliacionPort().afiliar(peticion);

			LogHandler.info(uid, getClass(), "afiliacionSeguros - respuesta afiliacion= " + respuestaAfiliacion);

			if (respuestaAfiliacion.contains("false")) {
				//Ocurrio un error en la anulacion del seguro
				String tag = "mensajeError";
				String value = "";
				String tagBuscar = "<" + tag + ">";
				String tagFinBuscar = "</" + tag + ">";
				value = respuestaAfiliacion.substring(respuestaAfiliacion.indexOf(tagBuscar)
						+ tagBuscar.length(), respuestaAfiliacion.indexOf(tagFinBuscar));
				throw new Exception(value);
			}
			  	respuesta.getHeader().setMensaje("La afiliacion se ha terminado con exito");
		}
		catch (Exception e) {
			LogHandler.error(uid, getClass(), "Existio un error en afiliacionSeguros(): " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( e.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		} else {
			respuesta.getHeader().setMensaje("No existen seguros que afiliar");

		}
		return respuesta;
	}

	/**
	 * Verifica si Seguro completo.
	 *
	 * @param arregloIntegrantes the arreglo integrantes
	 * @return the string
	 */
	private Boolean seguroCompleto(IntegranteOV[] arregloIntegrantes) {
		Boolean unotieneSeguro = false;
		for (int i = 0; i < arregloIntegrantes.length; i++) {
	                if (arregloIntegrantes[i].getSeguroVida().equals("S")
	                		| arregloIntegrantes[i].getSeguroEnfermedad().equals("S")) {
	                	unotieneSeguro = true;
	                }
		}
		return unotieneSeguro;
	}

	/**
	 * Grupo completo.
	 *
	 * @param arregloIntegrantes the arreglo integrantes
	 * @return the string
	 */
	private String grupoCompleto(IntegranteOV[] arregloIntegrantes) {
		String todos = "S";
		for (int i = 0; i < arregloIntegrantes.length; i++) {
	                if (arregloIntegrantes[i].getSeguroVida().equals("S")
	                		| arregloIntegrantes[i].getSeguroEnfermedad().equals("S")) {
	                	todos = "N";
	                	break;
	                }
		}
		return todos;
	}

	/**
	 * Obtiene los montos seguros.
	 *
	 * @param uid the uid
	 * @param contratoOV the contrato ov
	 * @param integrantesList the integrantes list
	 * @return the obtener montos seguros respuesta
	 * @throws Exception the exception
	 */
	public ObtenerMontosSegurosRespuesta obtenerMontoSeguros(String uid, ContratoOV contratoOV,
			List<IntegranteOV> integrantesList)throws Exception {

		ObtenerMontosSegurosRespuesta respuesta = new  ObtenerMontosSegurosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;

		//Parte para calcular Montos Seguros
		//Parametros de entrada
		Double montoTotalSeguroVida = 0.0;
		Double montoTotalSeguroEnfermedades = 0.0;
		Integer plazoSeguro = 0;
		Integer plazoCredito = 0;
		String peticion = "";

		final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy" );


		peticion += "<clientes>";
		for (int i = 0; i < integrantesList.size(); i++) {

			if (integrantesList.get(i).getSeguroVida().equals("S") || integrantesList.get(i).getSeguroEnfermedad().equals("S")) {

				if (integrantesList.get(i).getPlazoSeguro().equals("A")) {
		            plazoSeguro = Constantes.SEMANAS_ANIO;
				} else {
		            plazoSeguro = obtienePlazoSeguroSemanas(contratoOV.getProducto(), contratoOV.getPlazo());
				}

				plazoCredito = obtienePlazoSeguroSemanas(contratoOV.getProducto(), contratoOV.getPlazo());

				peticion += "<cliente>";
                peticion += "<inicioVigencia>" + simpleDateFormat.format(contratoOV.getFecha_desembolso()) + "</inicioVigencia>";
                peticion += "<numeroPersona>" + integrantesList.get(i).getCliente().trim() + "</numeroPersona>";
                peticion += "<plazoSeguro>" + plazoSeguro + "</plazoSeguro>";
                peticion += "<seguroVida>" + integrantesList.get(i).getSeguroVida() + "</seguroVida>";
                peticion += "<plazoCredito>" + plazoCredito + "</plazoCredito>";
                peticion += "<seguroEnfermedad>" + integrantesList.get(i).getSeguroEnfermedad() + "</seguroEnfermedad>";
                peticion += "</cliente>";

			}
		}

		peticion += "</clientes>";

		//Se genera la peticion
		LogHandler.info(uid, getClass(), "obtenerMontoSeguros - Datos de salida XML: " + peticion);

		try {
			LogHandler.info(uid, getClass(), "confirmarCreditoTarea - Abriendo conexion...");
			sesion = FabricaConexiones.obtenerSesionNTx();

			LogHandler.info(uid, getClass(), "Se intenta obtener una instancia del WS");

			// mx.com.findep.crediseguros.webservice.finsol

			LogHandler.trace(uid, getClass(), "obtenerMontoSeguros: - obtenerParGeneral");
			ParGeneralOV urlWSCalCos = comun.obtenerParGeneralOV(uid, "WS_CAL_COS");
					//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "WS_CAL_COS");
			if (urlWSCalCos == null || urlWSCalCos.getCgValor().trim().isEmpty()) {
					throw new Exception("No fue posible obtener la URL del servicio de obtener monto seguros.");
			}

			LogHandler.info(uid, getClass(), "obtenerMontoSeguros - calcularCostoSeguro=" + urlWSCalCos.getCgValor().trim());

			CalculoCostoSeguroServiceLocator servicioSeguros = new CalculoCostoSeguroServiceLocator();
			servicioSeguros.setCalculoCostoSeguroPortEndpointAddress(urlWSCalCos.getCgValor().trim());
			String respuestaCalcular = servicioSeguros.getCalculoCostoSeguroPort().calcularCostoSeguro(peticion);

			LogHandler.info(uid, getClass(), "obtenerMontoSeguros - calcularCostoSeguro=" + respuestaCalcular);

			if (respuestaCalcular.contains("mensajeError") || respuestaCalcular.contains("false")) {
				//Ocurrio un error en la anulacion del seguro
				String tag = "mensajeError";
				String value = "";
				String tagBuscar = "<" + tag + ">";
				String tagFinBuscar = "</" + tag + ">";
				value = respuestaCalcular.substring(respuestaCalcular.indexOf(tagBuscar)
						+ tagBuscar.length(), respuestaCalcular.indexOf(tagFinBuscar));
			throw new Exception("Ocurrio un error en web service para Calcular Costos Seguros - calcularCostoSeguro: " + value);
			}

			//Convertir a objeto y sumar montos;

			        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			        DocumentBuilder db = dbf.newDocumentBuilder();
			        InputSource is = new InputSource();
			        is.setCharacterStream(new StringReader(respuestaCalcular));

			        Document doc = db.parse(is);
			        NodeList nodes = doc.getElementsByTagName("cliente");

			        List<cliente> clientes = new ArrayList<cliente>();

			        // iterate the employees
			        for (int i = 0; i < nodes.getLength(); i++) {
			           Element element = (Element) nodes.item(i);

			           cliente nuevoCliente = new cliente();

			           NodeList costoSeguroVida = element.getElementsByTagName("costoSeguroVida");
			           Element line = (Element) costoSeguroVida.item(0);
			           if (line != null) {

			           nuevoCliente.setCostoSeguroVida(Double.parseDouble(getCharacterDataFromElement(line)));
			           montoTotalSeguroVida += Double.parseDouble(getCharacterDataFromElement(line));
			           }

			           NodeList costoSeguroEnfermedad = element.getElementsByTagName("costoSeguroEnfermedad");
			           Element line2 = (Element) costoSeguroEnfermedad.item(0);
			           if (line2 != null) {

			           nuevoCliente.setCostoSeguroEnfermedad(Double.parseDouble(getCharacterDataFromElement(line2)));
			           montoTotalSeguroEnfermedades += Double.parseDouble(getCharacterDataFromElement(line2));
			           }

			           NodeList numeroPersona = element.getElementsByTagName("numeroPersona");
			           Element line3 = (Element) numeroPersona.item(0);
			           if (line3 != null) {

			           nuevoCliente.setNumeroPersona(getCharacterDataFromElement(line3));
			           }
			           clientes.add(nuevoCliente);
			        }

			  respuesta.setMontoTotalSeguroVida(montoTotalSeguroVida);
			  respuesta.setMontoTotalSeguroEnfermedades(montoTotalSeguroEnfermedades);
			  respuesta.setClientes(clientes);

		}
		catch (Exception e) {
			LogHandler.error(uid, getClass(), "Existio un error en obtienerMontoSeguros(): " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( e.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}

	/**
	 * Obtiene plazo seguro semanas.
	 *
	 * @param producto the producto
	 * @param plazo the plazo
	 * @return the int
	 */
	public int obtienePlazoSeguroSemanas(String producto, int plazo) {

	            if (producto.equals("GCC1") || producto.equals("GSC1") || producto.equals("GCDC")) {
	            	plazo = plazo * 2;
	            }

		return plazo;
	}

	/**
	 * Gets the character data from element.
	 *
	 * @param e the e
	 * @return the character data from element
	 */
	public static String getCharacterDataFromElement(Element e) {
	    Node child = e.getFirstChild();
	    if (child instanceof CharacterData) {
	       CharacterData cd = (CharacterData) child;
	       return cd.getData();
	    }
	    return "?";
	  }

	/**
	 * Diferencia en dias2.
	 *
	 * @param fechaMayor the fecha mayor
	 * @param fechaMenor the fecha menor
	 * @return the int
	 */
	public static int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
		long diferenciaEnMs = fechaMayor.getTime() - fechaMenor.getTime();
		long dias = diferenciaEnMs / (1000 * 60 * 60 * 24);
		return (int) dias;
	}

	/**
	 * Guardar opcion garantia tarea.
	 *
	 * @param uid the uid
	 * @param peticion the GuardarOpcionGarantiaPeticion
	 * @return the guardar opcion garantia respuesta
	 */
	public GuardarOpcionGarantiaRespuesta guardarOpcionGarantiaTarea(
			String uid, GuardarOpcionGarantiaPeticion peticion) {
		GuardarOpcionGarantiaRespuesta respuesta = new  GuardarOpcionGarantiaRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		SqlSession sesionTx = null;

		try {
			if (peticion == null || peticion.getContrato() == null || peticion.getUsuario() == null
					|| peticion.getOpcionGarantia() == null) {
				String mensajePeticion = "";
				if (peticion.getContrato() == null ) {
					mensajePeticion = "La peticion no contiene contrato";
				}
				if (peticion.getUsuario() == null ) {
					mensajePeticion = "La peticion no contiene usuario";
				}
				if (peticion.getOpcionGarantia() == null ) {
					mensajePeticion = "La peticion no contiene opcion garantia";
				}
				throw new Exception("La peticion es incorrecta." + mensajePeticion);
			}

			String numContrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());

			if (numContrato == null) {
				throw new Exception("No se pudo obtener el numero de contrato");
			}

			LogHandler.info(uid, getClass(), "confirmarCreditoTarea - Abriendo conexion...");
			sesion = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			LogHandler.info(uid, getClass(), "confirmarCreditoTarea - existeContratoDepGar");
			Integer existeCont = (Integer) sesion.selectOne("existeContratoDepGar", numContrato);

			if (existeCont == null || existeCont == 0) {
				throw new Exception("La consulta de contrato no regreso resultados");
			}

			final HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "opcionGarantia", peticion.getOpcionGarantia());
			parametros.put( "usuario", peticion.getUsuario());
			parametros.put( "contrato", numContrato);

			LogHandler.info(uid, getClass(), "confirmarCreditoTarea - actualizarOpcionGarantiaDepGar");
			sesionTx.update("actualizarOpcionGarantiaDepGar", parametros);

			sesionTx.commit();

		}
		catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "Existio un error en obtienerMontoSeguros(): " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( e.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * Guardar opcion garantia tarea.
	 *
	 * @param uid the uid
	 * @param peticion the GuardarOpcionGarantiaPeticion
	 * @return the guardar opcion garantia respuesta
	 */
	public ConfirmarCreditoRespuesta confirmaSolicitudVerificacionTelefonica(
			String uid, ConfirmarCreditoPeticion peticion) {
		ConfirmarCreditoRespuesta respuesta = new  ConfirmarCreditoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {
			if (peticion == null) {
				throw new Exception("La peticion no puede ser nula.");
			}
			if (peticion.getSolicitud() == null || peticion.getSolicitud().trim().isEmpty()) {
				throw new Exception("La solicitud es obligatoria en la peticion.");
			}

			sesionTx = FabricaConexiones.obtenerSesionTx();

			final java.util.HashMap<String, Object> parVerificacion = new HashMap<String, Object>();
			parVerificacion.put( "solicitud" , peticion.getSolicitud());
			parVerificacion.put( "estatusVer" , "SOLICITUD_VALIDA");

			LogHandler.trace(uid, getClass(), "confirmarCreditoTarea - verificaConfirmarAtomo");
			Integer bitacoraVer = (Integer) sesionTx.selectOne("consultaConfirmarVerificacion", parVerificacion);

			if ( bitacoraVer == null || bitacoraVer == 0) {
				throw new Exception("Aun no han validado la solicitud en el proceso de verificación telefonica,"
						+ " Intentar más tarde.");
			}
		}
		catch (Exception e) {

			LogHandler.error(uid, getClass(), "Existio un error en confirmaSolicitudVerificacionTelefonica(): "
					+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( e.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}
	
	public ConfirmarCreditoRespuesta aplicarPagoDocumento(String uid, PagoDocumentoPeticion peticion) {
		ConfirmarCreditoRespuesta respuesta = new ConfirmarCreditoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;
		try {
			sesionTx = FabricaConexiones.obtenerSesionTx();
			//Se registra el contrato en folio_notas
			final HashMap<String, Object>
							paramFolioNotas = new HashMap<String, Object>();
							paramFolioNotas.put( "header", "P" );
							paramFolioNotas.put( "contrato", peticion.getContratoNuevo() );
							paramFolioNotas.put( "montoLiquidar", peticion.getMontoFinanciado() );
							paramFolioNotas.put( "montoPromedio", 0 );
							paramFolioNotas.put( "folio", generarFolio( uid, peticion.getSucursal(), sesionTx ) );
							paramFolioNotas.put( "contratoAnterior", peticion.getContratoAnterior() );
							paramFolioNotas.put( "fechaHora", comun.obtenerFechaActual( uid ) );
							paramFolioNotas.put( "folioPagare", "" );

			LogHandler.trace(uid, getClass(), "==> registrar - registrarFolioNotas");
			sesionTx.selectOne( "registrarFolioNotas", paramFolioNotas);
			Date fechaContable = comun.obtenerFechaContable(uid ).getFecha();
			final Integer idTransaccion = comun.obtenerIdTransaccion(uid, peticion.getSucursal(), fechaContable);

			final 	PagoGrupal
			pagoGrupal = new PagoGrupal();
			pagoGrupal.setIdPago( 0 );
			pagoGrupal.setCodigo( "PADO" );
			pagoGrupal.setFechaValor( null );
			pagoGrupal.setMedioPago( "" );
			pagoGrupal.setMonto( peticion.getMontoFinanciado() );
			pagoGrupal.setNumeroContrato( peticion.getContratoAnterior() );
			pagoGrupal.setReferencia("");

			//06/06/2013 OPERFIN-90
			pagoGrupal.setTipoPago("ABO");

			if ( !pagos.aplicarPagoGrupal(uid, sesionTx, idTransaccion, pagoGrupal).getHeader().isEstatus() ) {
				throw new Exception( ReadProperties.mensajes.getProp("ciof.error.aplicarpagos") );
			}
			final HashMap<String, String>
			paramUpdateNotasFolio = new HashMap<String, String>();
			paramUpdateNotasFolio.put( "contratoVigente", peticion.getContratoAnterior());
			paramUpdateNotasFolio.put( "contratoNuevo"  , peticion.getContratoNuevo());
			paramUpdateNotasFolio.put( "status"			, "L");

			//Se actualiza folio-notas
			LogHandler.trace(uid, getClass(), "==> registrar - actualizarFolioNotas");
			int act = sesionTx.update( "actualizarFolioNotas", paramUpdateNotasFolio );
			if ( act == 0 ) {
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrar.errordisposicion") );
				//Error al generar la disposicion de contrato
			}

			sesionTx.commit();
		}
		catch (Exception e) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "Existio un error en aplicarPagoDocumento(): "
					+ e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( e.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}
}

