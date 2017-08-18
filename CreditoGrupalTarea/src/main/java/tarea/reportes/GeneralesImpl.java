package tarea.reportes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

import entidad.conexiones.FabricaConexiones;
import tarea.comun.ComunTarea;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.persona.PersonaOV;
import utilitario.mensajes.reportes.comun.PersonasBloqueoPeticion;
import utilitario.mensajes.reportes.comun.PersonasBloqueoRespuesta;
import utilitario.mensajes.reportes.garantias.PeticionReporteExcepcionGarantia;
import utilitario.mensajes.reportes.garantias.ReporteExcepcionGarantiaOV;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiaOV;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiaPeticion;
import utilitario.mensajes.reportes.garantias.ReporteSolicitudesGarantiasRespuesta;
import utilitario.mensajes.reportes.garantias.RespuestaReporteExcepcionGarantia;
import utilitario.mensajes.reportes.tasas.ReporteTasasPeticion;
import utilitario.mensajes.reportes.tasas.ReporteTasasRespuesta;
import utilitario.mensajes.reportes.tasas.ReporteTasasOV;

/**
 * The Class GeneralesImpl.
 */
@Scope("COMPOSITE")
public class GeneralesImpl implements Generales {

	/**
	 *  Formato para la fecha
	 */
	private static final Integer FORMATO_FECHA					= 24;

	/**
	 * SCA
	 */
	private ComunTarea comun;

	/**
	 * @param comun JCA
	 */
	public GeneralesImpl(  @Reference( name = "comun" ) ComunTarea comun) {
		this.comun = comun;
	}

	/**
	 * Metodo para obtener el reporte de las personas que estan bloqueadas.
	 *
	 * @param uid tipo String
	 * @param peticion tipo PersonasBloqueoPeticion
	 * @return PersonasBloqueoRespuesta
	 */
	public PersonasBloqueoRespuesta obtenerReportePersonasBloqueadasTarea(String uid, PersonasBloqueoPeticion peticion) {
		PersonasBloqueoRespuesta respuesta = new PersonasBloqueoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx = null;

		SimpleDateFormat in = new SimpleDateFormat("dd-MM-yyyy");

		try {

			//Se pide una conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			if (peticion.getFechaInicio() == null || peticion.getFechaFin() == null) {
            	throw new Exception("Los campos de fechas no deben estar vacios.");
            }


            if (peticion.getFechaInicio() != null || peticion.getFechaFin() != null) {
					Date dateInicio = in.parse(peticion.getFechaInicio());

					Date dateFin = in.parse(peticion.getFechaFin());

					peticion.setFechaInicioDate(dateInicio);
					peticion.setFechaFinDate(dateFin);

					Calendar fechaFin = Calendar.getInstance();
					fechaFin.setTime(peticion.getFechaFinDate());
					fechaFin.add(Calendar.HOUR, 24);

					peticion.setFechaFinDate(fechaFin.getTime());

					if (peticion.getFechaFinDate().before(peticion.getFechaInicioDate())
							|| peticion.getFechaInicioDate().equals(peticion.getFechaFinDate())) {
						throw new Exception("La Fecha Fin debe ser mayor que la Fecha Inicio.");
					}

			}

            final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			parametros.put("fechaInicio" , peticion.getFechaInicioDate());
			parametros.put("fechaFin" , peticion.getFechaFinDate());

			@SuppressWarnings("unchecked")
			List<PersonaOV> listaPersonas = sessionNTx.selectList("obtenerPersonasBloqueadas", parametros);

			if (listaPersonas == null || listaPersonas.size() == 0) {
				throw new Exception("La consulta no regreso datos para las fechas ["
						+ peticion.getFechaInicio() + " y " + peticion.getFechaFin() + "].");
			}

			respuesta.setPersonasBloqueadas(listaPersonas);

		} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error en obtenerReportePersonasBloqueadasTarea: " + e.getMessage(), e);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje("Error en obtenerReportePersonasBloqueadasTarea: " + e.getMessage());
			}
			finally {
				FabricaConexiones.close( sessionNTx );
			}
		return respuesta;
	}

	/**
	 * Método para obtener el reporte de las solicitudes con excepciones de garantía.
	 *
	 * @param uid tipo String
	 * @param peticion división, región, estatus, fecha inicial, fecha final
	 * @return 	lista de (region, nombreRegion, sucursal, nombreSucursal, solicitud, contratoNuevo, contratoRenovacion,
	 * 			ciclo, producto, fechaAltaExcepcion, estatusExcepcion, observaciones)
	 */
	public RespuestaReporteExcepcionGarantia obtenerReporteExcepcionesBuzon(
			String uid, PeticionReporteExcepcionGarantia peticion) {

		RespuestaReporteExcepcionGarantia respuesta = new RespuestaReporteExcepcionGarantia();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx = null;

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd-MM-yyyy");

		try {

			//Se pide una conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//se valida que se haya seleccionado al menos un parámetro
			if (peticion.getFechaAltaInicio() == null && peticion.getFechaAltaFin() == null
				&& peticion.getDivision() == null && peticion.getRegion() == null && peticion.getEstatusExcepcion() == null) {
            	throw new Exception("Debe seleccionar al menos un filtro");
            }

			//se valida que se haya seleccionado el reango completo de fechas
			if ((peticion.getFechaAltaInicio() == null && peticion.getFechaAltaFin() != null)
				|| (peticion.getFechaAltaInicio() != null && peticion.getFechaAltaFin() == null)) {
	            	throw new Exception("Debe seleccionar el rango completo de fechas");
	            }

			//se seleccionaron fechas
			if (peticion.getFechaAltaInicio() != null && peticion.getFechaAltaFin() != null) {

				Date dateInicio = formatoEntrada.parse(peticion.getFechaAltaInicio());
				Date dateFin = formatoEntrada.parse(peticion.getFechaAltaFin());

				//se valida que la fecha inicial sea menor que la fecha final
				if (dateFin.before(dateInicio)) {
					throw new Exception("La fecha fin debe ser mayor que la fecha inicio.");
				}

				//se convierten las fechas al formato esperado por la base de datos
				SimpleDateFormat formatoBD = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaAuxiliar = new Date();
				fechaAuxiliar = formatoEntrada.parse(peticion.getFechaAltaInicio());
				peticion.setFechaAltaInicio(formatoBD.format(fechaAuxiliar));

				fechaAuxiliar = formatoEntrada.parse(peticion.getFechaAltaFin());
				peticion.setFechaAltaFin(formatoBD.format(fechaAuxiliar));

			}

            final java.util.HashMap<String, Object> parametros = new java.util.HashMap<String, Object>();
			parametros.put("fechaAltaInicio" , peticion.getFechaAltaInicio());
			parametros.put("fechaAltaFin" , peticion.getFechaAltaFin());
			parametros.put("division", peticion.getDivision());
			parametros.put("region", peticion.getRegion());
			parametros.put("estatusExcepcion", peticion.getEstatusExcepcion());

			@SuppressWarnings("unchecked")
			List<ReporteExcepcionGarantiaOV> listaSolicitudes =
				sessionNTx.selectList("obtenerReporteExcepcionesBuzon", parametros);

			if (listaSolicitudes == null || listaSolicitudes.size() == 0) {
				throw new Exception("La consulta no regreso información para los criterios seleccionados");
			}

			respuesta.setRegistros(listaSolicitudes);

		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error en obtenerReporteExcepcionesBuzon: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error:" + e.getMessage()  + " UID - " + uid);
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;
	}

	/**
	 * Método para obtener el reporte de las solicitudes con garantía.
	 *
	 * @param uid tipo String
	 * @param peticion división, región, contrato, fecha inicial, fecha final
	 * @return 	lista de (contrato, grupo, nombreGrupo, ciclo, sucursal, nombreSucursal, region, nombreRegion, division,
	 * 					nombreDivision, garantiaRequeridaPct, garantiaRequeridaMonto, garantiaDeposito, garantiaTraspaso,
	 * 					garantiaDiferencia, garantiaDevoluciones, garantiaTotal, autorizacionExcepcion, fechaDesembolsoGrarantia,
	 * 					fechaDeposito, fechaTraspaso, banco, diasPago)
	 */
	public ReporteSolicitudesGarantiasRespuesta obtenerReporteSolicitudesGarantia(
			String uid, ReporteSolicitudesGarantiaPeticion peticion) {

		ReporteSolicitudesGarantiasRespuesta respuesta = new ReporteSolicitudesGarantiasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx = null;

		SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd-MM-yyyy");

		try
		{

			//Se pide una conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//se valida que se haya seleccionado al menos un parámetro
			if (peticion.getFechaInicial() == null && peticion.getFechaFinal() == null
				&& peticion.getDivision() == null && peticion.getRegion() == null && peticion.getContrato() == null) {
            	throw new Exception("Debe seleccionar al menos un filtro");
            }

			//se valida que se haya seleccionado el reango completo de fechas
			if ((peticion.getFechaInicial() == null && peticion.getFechaFinal() != null)
				|| (peticion.getFechaInicial() != null && peticion.getFechaFinal() == null)) {
	            	throw new Exception("Debe seleccionar el rango completo de fechas");
	            }

			//se seleccionaron fechas
			if (peticion.getFechaInicial() != null && peticion.getFechaFinal() != null) {

				Date dateInicio = formatoEntrada.parse(peticion.getFechaInicial());
				Date dateFin = formatoEntrada.parse(peticion.getFechaInicial());

				//se valida que la fecha inicial sea menor que la fecha final
				if (dateFin.before(dateInicio)) {
					throw new Exception("La fecha fin debe ser mayor que la fecha inicio.");
				}

				//se convierten las fechas al formato esperado por la base de datos
				SimpleDateFormat formatoBD = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaAuxiliar = new Date();
				fechaAuxiliar = formatoEntrada.parse(peticion.getFechaInicial());
				peticion.setFechaInicial(formatoBD.format(fechaAuxiliar));

				fechaAuxiliar = formatoEntrada.parse(peticion.getFechaFinal());
				peticion.setFechaFinal(formatoBD.format(fechaAuxiliar));

				//se obtiene el número de contrato independientemente si es contrato o LD
				if (peticion.getContrato() != null && !peticion.getContrato().isEmpty())
				{
					String contrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());

					if (contrato == null)
					{
						throw new Exception("Contrato inexistente");
					}
					peticion.setContrato(contrato);
				}

				//se llena el HashMap de parámetros
				final HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("division", peticion.getDivision());
				parametros.put("region", peticion.getRegion());
				parametros.put("contrato", peticion.getContrato());
				parametros.put("fechaInicial", peticion.getFechaInicial());
				parametros.put("fechaFinal", peticion.getFechaFinal());

				//se obtienen las jndis y se pasan como parámetros
				//tipos de producto
				String codTiposProducto = comun.obtenerParGeneral(
						uid, "mx.com.independencia.depositos.garantia.tipo.producto");

				String[] arrayTiposProducto = codTiposProducto.split(";");

				ArrayList<String> listaCodTiposProducto = new ArrayList<String>();

				for (int j = 0; j < arrayTiposProducto.length; j++)
				{
					LogHandler.debug(uid, getClass(), "garantia.deposito = " + arrayTiposProducto[j]);
					listaCodTiposProducto.add(arrayTiposProducto[j]);
				}

				//depósitos
				String codDepositosGarantia = comun.obtenerParGeneral(
						uid, "mx.com.independencia.depositos.garantia.deposito");

				String[] arrayCodDepositosGarantia = codDepositosGarantia.split(";");

				ArrayList<String> listaCodDepositosGarantia = new ArrayList<String>();

				for (int j = 0; j < arrayCodDepositosGarantia.length; j++)
				{
					LogHandler.debug(uid, getClass(), "garantia.deposito = " + arrayCodDepositosGarantia[j]);
					listaCodDepositosGarantia.add(arrayCodDepositosGarantia[j]);

				}

				//traspasos
				String codTraspasosDepositosGarantia = comun.obtenerParGeneral(
						uid, "mx.com.independencia.deposito.traspaso.garantia");

				String[] arrayCodTraspasosDepositosGarantia = codTraspasosDepositosGarantia.split(";");

				ArrayList<String> listaCodTraspasosDepositosGarantia = new ArrayList<String>();

				for (int j = 0; j < arrayCodTraspasosDepositosGarantia.length; j++)
				{
					LogHandler.debug(uid, getClass(), "traspaso.garantia = " + arrayCodTraspasosDepositosGarantia[j]);
					listaCodTraspasosDepositosGarantia.add(arrayCodTraspasosDepositosGarantia[j]);
				}

				//devoluciones
				String codDevolucionesGarantia = comun.obtenerParGeneral(
						uid, "mx.com.independencia.depositos.garantia.tipo.devoluciones");

				String[] arrayCodDevolucionesGarantia = codDevolucionesGarantia.split(";");

				ArrayList<String> listaCodDevolucionesGarantia = new ArrayList<String>();

				for (int j = 0; j < arrayCodDevolucionesGarantia.length; j++)
				{
					LogHandler.debug(uid, getClass(), "garantia.deposito = " + arrayCodDevolucionesGarantia[j]);
					listaCodDevolucionesGarantia.add(arrayCodDevolucionesGarantia[j]);
				}

				Date fechaContable = comun.obtenerFechaContable( uid ).getFecha();
				if (fechaContable == null) {
					throw new Exception("No se pudo recuperar la fecha contable");
				}

				parametros.put("listaCodTiposProducto", listaCodTiposProducto);
				parametros.put("listaCodDepositosGarantia", listaCodDepositosGarantia);
				parametros.put("listaCodTraspasosDepositosGarantia", listaCodTraspasosDepositosGarantia);
				parametros.put("listaCodDevolucionesGarantia", listaCodDevolucionesGarantia);
				parametros.put("fechaContable", new SimpleDateFormat("yyyy-MM-dd").format(fechaContable));

				@SuppressWarnings("unchecked")
				List<ReporteSolicitudesGarantiaOV> listaSolicitudes =
					sessionNTx.selectList("obtenerReporteSolicitudesGarantia", parametros);

				if (listaSolicitudes == null || listaSolicitudes.size() == 0) {
					throw new Exception("La consulta no regreso información para los criterios seleccionados");
				}

				respuesta.setRegistros(listaSolicitudes);
			}
		}
		catch (Exception e)
		{
			LogHandler.error(uid, getClass(), "Error en obtenerReporteSolicitudesGarantia: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error:" + e.getMessage() + " UID - " + uid);
		}
		finally
		{
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;
	}

	/**
	 * Método para obtener el reporte de Tasa
	 * @param uid tipo String
	 * @param peticion fechaInicial y fechafinal
	 * @return 	lista de (tasaActual, tasaInteres, tasaAnual, tasaInteresAnual, contratoLD, sucursal, sucursalNombre,
	 * 					usuarioReestructura, fechaReestructura, contrato, cliente, fechaContrato)
	 */
	public ReporteTasasRespuesta obtenerReporteTasas(String uid,
			ReporteTasasPeticion peticion) {
		ReporteTasasRespuesta respuesta = new ReporteTasasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx = null;
		SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");

		try {
			//Se pide una conexion
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//se valida que se haya seleccionado el reango completo de fechas
			if ((peticion.getFechaInicial() == null && peticion.getFechaFinal() != null)
				|| (peticion.getFechaInicial() != null && peticion.getFechaFinal() == null)) {
	            	throw new Exception("Debe seleccionar el rango completo de fechas");
	            }

			//se seleccionaron fechas
			if (peticion.getFechaInicial() != null && peticion.getFechaFinal() != null) {
				Date dateInicio = formatoFecha.parse(peticion.getFechaInicial());
				Date dateFin = formatoFecha.parse(peticion.getFechaFinal());

				peticion.setFechaInicioDate(dateInicio);
				peticion.setFechaFinDate(dateFin);

				//se convierten la fecha
				Calendar fechaFin = Calendar.getInstance();
				fechaFin.setTime(peticion.getFechaFinDate());
				fechaFin.add(Calendar.HOUR, FORMATO_FECHA);

				peticion.setFechaFinDate(fechaFin.getTime());

				//se valida que la fecha inicial sea menor que la fecha final
				if (peticion.getFechaFinDate().before(peticion.getFechaInicioDate())
						|| peticion.getFechaInicioDate().equals(peticion.getFechaFinDate())) {
					throw new Exception("La Fecha Fin debe ser mayor que la Fecha Inicio.");
				}
			}
			//se obtienen las jndis y se pasan como parámetros
			//tipos de movimientos
			String codTipoMovimiento = comun.obtenerParGeneral(
					uid, "mx.com.independencia.reportes.tasas.tipo.movimiento");

			final java.util.HashMap<String, Object>parametros = new java.util.HashMap<String, Object>();
			parametros.put("fechaInicio", peticion.getFechaInicioDate());
			parametros.put("fechaFin", peticion.getFechaFinDate());
			parametros.put("tipoMovimiento", codTipoMovimiento);

			for (String string : parametros.keySet()) {
				LogHandler.info(uid, getClass(), string + " -- " + parametros.get( string ) );
			}

			@SuppressWarnings("unchecked")
			List<ReporteTasasOV> listaTasas = sessionNTx.selectList("reporteTasas", parametros);

			if (listaTasas == null || listaTasas.size() == 0) {
				throw new Exception("La consulta no regreso información para las fechas ["
						+ peticion.getFechaInicial() + " y " + peticion.getFechaFinal() + "].");
			} else {
				for (Iterator iterator = listaTasas.iterator(); iterator
						.hasNext();) {
					ReporteTasasOV reporteTasasOV = (ReporteTasasOV) iterator
							.next();
					reporteTasasOV.setUsuarioReestructura(reporteTasasOV.getUsuarioReestructura().trim());
					reporteTasasOV.setZona(reporteTasasOV.getZona().trim());
					reporteTasasOV.setDivision(reporteTasasOV.getDivision().trim());
					reporteTasasOV.setSucursal(reporteTasasOV.getSucursal().trim());
				}
			}

			LogHandler.info(uid, getClass(), "obtenerReporteTasas -- objeto Respuesta " + respuesta );
			respuesta.setRegistros(listaTasas);

		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error en obtenerReporteTasasTarea: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en obtenerReporteTasasTarea: " + e.getMessage());
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}

		return respuesta;

	}
}
