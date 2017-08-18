/**
 *
 */
package tarea.originacion;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.oasisopen.sca.annotation.Scope;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import utilitario.comun.GUIDGenerator;
import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.FechaContableOV;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionOV;
import utilitario.mensajes.originacion.aprobacion.PlanillaAprobacionRespuestaOV;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.consulta.ConsultaRespuesta;
import utilitario.mensajes.originacion.consulta.ConsultarSimulacionesReestructurasRespuesta;
import utilitario.mensajes.originacion.consulta.InsertarSimulacionesReestructurasPeticion;
import utilitario.mensajes.originacion.consulta.InsertarSimulacionesReestructurasRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.originacion.consulta.SimulacionReestructuraIntOV;
import utilitario.mensajes.originacion.consulta.SimulacionReestructuraOV;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;

/**
 * @author out_jcmoreno
 *
 */
@Scope("COMPOSITE")
public class OriginacionConsultasImpl implements OriginacionConsultas {
 	 
	private ComunTarea comun;
	
	public OriginacionConsultasImpl( @Reference(name = "comun") ComunTarea comun) {
		this.comun = comun;
	}


	/**
	 * @param uid  identificador unico de la transaccion
	 * @param consulta peticion donde se mapea la fecha desembolso a validar
	 * @return resultado de la validacion de la fecha desembolso
	 */
	public ConsultaRespuesta validarFechaInicioContrato( String uid, ConsultaFechaOV consulta ) {
		String msg = null;
		SqlSession 					sesionNTx			= null;
		Map<String, Object>			params		 		= new HashMap<String, Object>( );
		//Integer					respuesta			= null;
		Date fechaContable								= null;
		Integer diasCandado								= null;
		ConsultaRespuesta regreso						= new ConsultaRespuesta();

		int identificador;

		params.put( FECHA, consulta.getFecha( ) );
		params.put( SUCURSAL, consulta.getSucursal( ) );
		params.put( CODIGO, CODIGO_FECHA_CONTABLE );

		try {

			int valorDias = Integer.parseInt(
					comun.obtenerParGeneralOV(uid, "com.mx.finsol.originacion.credito.fechaautorizacion").getCgValor());

			//Se valida que la fecha no sea mayor a 15 dias
			final java.util.Calendar
							fechaSistema = java.util.Calendar.getInstance();
							fechaSistema.setTime( comun.obtenerFechaContable(uid).getFecha() );
							fechaSistema.add( Calendar.DAY_OF_YEAR , valorDias);

			//Formato de la fecha
			final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

			if ( consulta.getFecha().after( fechaSistema.getTime() ) ) {
				throw new Exception( ReadProperties.mensajes.getProp("originacion.registrarcredito.errorfechadesembolsosuperior")
						+ simpleDateFormat.format( fechaSistema.getTime() ) + "\"" );
			}

			sesionNTx 		= FabricaConexiones.obtenerSesionNTx( );

			LogHandler.trace(uid, getClass(), "==> validarFechaInicioContrato - " +  OPER_VERIFICA_DIANOHABDOM);

			fechaContable = comun.obtenerFechaContable( uid ).getFecha();
			if ( fechaContable == null ) {
					throw new Exception(ReadProperties.mensajes.getProp("ciof.errorfechacontable"));
			}

				//Se coloca correctamente la fecha
				final Calendar  auxCalendar =  Calendar.getInstance();
							    auxCalendar.setTime( fechaContable );
				fechaContable = auxCalendar.getTime();

				//Se valida que la fecha de desembolso sea igual o mayor que la contable
				if ( fechaContable != null &&  consulta.getFecha( ).before( fechaContable ) ) {
					throw new Exception( ReadProperties.mensajes.getProp(
							"originacion.registrarcredito.errorfechadesembolsoinferior"));
				}

				params.clear();
				params.put( SUCURSAL, consulta.getSucursal( ) );
				params.put( FECHA   , fechaContable 		  );
				params.put( CODIGO  , CODIGO_FECHA_CONTABLE   );

				LogHandler.trace(uid, getClass(), "==> validarFechaInicioContrato - " + OPER_VER_VALOR_HISTORICO);
			 	diasCandado = (Integer) sesionNTx.selectOne( "verValorHistorico", params );

					if ( diasCandado != null )
						{
						Calendar cal = Calendar.getInstance();
						cal.setTime( fechaContable );
						cal.add( Calendar.DATE, diasCandado );
						Calendar cal2 = Calendar.getInstance();
						cal2.setTime( consulta.getFecha( ) );
						identificador = cal.compareTo( cal2 );

							//La fecha de desembolso es menor al candado
							if ( identificador > 0  ) {
								throw new Exception(ReadProperties.mensajes.getProp(
										"originacion.validarFechaInicioContrato.errordiascandado"));
							}
						}
					else
						{
						throw new Exception(ReadProperties.mensajes.getProp(
								"originacion.validarFechaInicioContrato.errordesembolsocandado"));
						}
			regreso.setIdentificador( IDENTIFICADOR_OK );
			regreso.getHeader().setEstatus( true );
			regreso.setPeticion_ofs( consulta.getOfs_peticion() );

		} catch ( Exception e ) {
			//FabricaConexiones.rollBack( sesion );
			regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException
					? ( MENSAJE_TIMEOUT + (msg != null ? msg : "") )
					: (MENSAJE_ERROR + (msg != null ? msg : e.getMessage()) ) );
			regreso.getHeader().setEstatus( false );
			regreso.setIdentificador( IDENTIFICADOR_FAIL );
			LogHandler.error( uid, this.getClass(), "Ocurrio error al validarFechaInicioContrato: " + e.getMessage(), e);
		} finally {
			FabricaConexiones.close( sesionNTx );
			LogHandler.info( uid, this.getClass(), "validarFechaInicioContrato OK: " + regreso);
		}
		regreso.getHeader().setUID(uid);
		return regreso;
	}


	@SuppressWarnings("unchecked")
	public ConsultaRespuesta calcularFechaFinContrato(  String uid, ConsultaFechaOV consultaFecha ) {
		String msg = null;
		SqlSession 			sesionNTx		= null;
		Map<String, Object>	params			= new HashMap<String, Object>( );
		Map<String, Date>	dataCalculo		= new HashMap<String, Date>( );
		SimpleDateFormat 	sdf 			= new SimpleDateFormat("yyyyMMdd");
		ConsultaRespuesta 	regreso			= new ConsultaRespuesta();
		Date   		fechaProxVenc			= null;
		Date  		fechaProxPago			= null;
		Date dtefechaContable				= null;

		try {
			sesionNTx 		= FabricaConexiones.obtenerSesionNTx( );
			fechaProxVenc	= consultaFecha.getFecha( );
			LogHandler.debug(uid, this.getClass(), SUCURSAL + " " + consultaFecha.getSucursal( ) );
			LogHandler.debug(uid, this.getClass(), FRECUENCIA_PAGO + " " + consultaFecha.getPerido( ) );
			params.put( SUCURSAL, consultaFecha.getSucursal( ) );
			params.put( FRECUENCIA_PAGO, consultaFecha.getPerido( ) );
			dtefechaContable =  comun.obtenerFechaContable( uid ).getFecha();
			if ( dtefechaContable == null )
				{
				msg = "NO SE PUDO OBTENER LA FECHA CONTABLE.";
				throw new Exception( msg );
			}

			//Formateo
			final java.text.SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "yyyy-MM-dd" );

			//Obtener fecha ancla
			final   Calendar
					calendar = GregorianCalendar.getInstance();
					calendar.set( Calendar.DAY_OF_WEEK ,  consultaFecha.getDiaPago() + 1  );

			final java.util.HashMap<String, Object>
								paramsPrimerVencimiento = new HashMap<String, Object>();
								paramsPrimerVencimiento.put( "sucursal"		  		 , consultaFecha.getSucursal() );
								paramsPrimerVencimiento.put( "fechaDesembolso"		 , consultaFecha.getFecha()    );
								paramsPrimerVencimiento.put( "frecuencia"	  		 , consultaFecha.getPerido()   );
								paramsPrimerVencimiento.put( "fechaAncla"	  		 , calendar.getTime()		   );
								paramsPrimerVencimiento.put( "fechaPrimerVencimiento", ""   					   );
								paramsPrimerVencimiento.put( "fechaProximoPago"		 , ""   					   );

			LogHandler.info(uid, getClass(), "==> calcularFechaFinContrato - calculaFechaPrimerVencimiento" );
			final HashMap<java.lang.String, java.lang.Object> fechasCalculadas
				= ( HashMap<java.lang.String, java.lang.Object> ) sesionNTx.selectOne( "calculaFechaPrimerVencimiento",
																	paramsPrimerVencimiento );

			final java.lang.Integer diasPlazo = ( consultaFecha.getPlazo() - 2 ) * ( consultaFecha.getPerido().toUpperCase().startsWith( "S" ) ? 7 : consultaFecha.getPerido().toUpperCase().startsWith( "C" ) ? 14 : 30 );

			final Calendar fechaPrimerVenc = Calendar.getInstance();
						   fechaPrimerVenc.setTime( simpleDateFormat.parse( fechasCalculadas.get( "fecha_prim_venc" ).toString() ) );
						   fechaPrimerVenc.add( Calendar.DAY_OF_YEAR , diasPlazo );
			params.put( FECHA_ACTUAL, sdf.format(dtefechaContable)  );
			params.put( FECHA_ANCLA, sdf.format( fechaPrimerVenc.getTime() )  );

			//for (int i = 1; i <= consultaFecha.getPlazo() ;i++ ){
				//Reviso el candado de los dias...
				LogHandler.debug(uid, this.getClass(),FECHA_ULT_VENCIMIENTO + " " + sdf.format(fechaPrimerVenc.getTime()) ) ;
				params.put( FECHA_ULT_VENCIMIENTO,  sdf.format(fechaPrimerVenc.getTime()) ) ;

				LogHandler.trace(uid, getClass(), "==> calcularFechaFinContrato - " + OPER_CAL_FECHA_PROX_VENCIMIENTO);
				dataCalculo  = ( HashMap<String, Date> ) sesionNTx.selectOne( OPER_CAL_FECHA_PROX_VENCIMIENTO, params );

				LogHandler.debug( uid, this.getClass(),"dataCalculo: " + dataCalculo );
				fechaProxVenc =  dataCalculo.get( FECHA_PROXIMO_VENCIMINENTO ) ;
				LogHandler.debug(uid, this.getClass(),"fecha Prximo Vencimiento: " + fechaProxVenc );
				fechaProxPago	=    dataCalculo.get( FECHA_PROXIMO_PAGO )  ;
				LogHandler.debug(uid, this.getClass(),"fecha Prximo Pago: " + fechaProxPago );
			//}
			regreso.setFechaFin( fechaProxPago != null ?  fechaProxPago  : fechaProxVenc  );
			regreso.setIdentificador( IDENTIFICADOR_OK );
			regreso.getHeader().setEstatus( true );
			regreso.setPeticion_ofs( consultaFecha.getOfs_peticion() );
			} catch ( Exception e ) {
				regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? ( MENSAJE_TIMEOUT + (msg != null ? msg : "") ) : (MENSAJE_ERROR + (msg != null ? msg : "") ) );
				regreso.getHeader().setEstatus( false );
				regreso.setIdentificador( IDENTIFICADOR_FAIL );
				LogHandler.error(uid, this.getClass(),"Error ocurrido: " + e.getMessage(), e );
			} finally {
				FabricaConexiones.close( sesionNTx );
				LogHandler.info(uid, this.getClass(), "calcularFechaFinContrato OK" );
			}
			regreso.getHeader().setUID(uid);
			return regreso;
	}

	/**
	 * 
	 */
	
	public ConsultaRespuesta obtenFecha( String uid, ConsultaFechaOV fecha) {
		String MSG = null;
		Date 				fechaContable	= null;
		ConsultaRespuesta 	regreso			= new ConsultaRespuesta();
		try {
			fechaContable = comun.obtenerFechaContable( uid ).getFecha();
 			if ( fechaContable == null ) {
				MSG = "NO SE PUDO OBTENER LA FECHA CONTABLE.";
				throw new Exception ( MSG );
			}
			regreso.setFechaFin(fechaContable);
			regreso.setPeticion_ofs( fecha != null ? fecha.getOfs_peticion() : "" );
		} catch ( Exception e ) {
			//FabricaConexiones.rollBack( sesion );
			regreso.getHeader().setMensaje( e.getCause() instanceof java.sql.SQLTimeoutException  ? ( MENSAJE_TIMEOUT + (MSG != null ? MSG : "") ) : (MENSAJE_ERROR + (MSG != null ? MSG : "") ) );
			regreso.getHeader().setEstatus( false );
			regreso.setIdentificador( IDENTIFICADOR_FAIL );
			LogHandler.error(uid, this.getClass(), "Error ocurrido: " + MSG, e);
//			e.printStackTrace();
		}
		regreso.getHeader().setUID( uid );
		return regreso;
	}
	
	@SuppressWarnings("unchecked")
	
	public PlanillaAprobacionRespuestaOV obtenerPlantillaAprobacion(String uid, String numeroContrato ) {
		PlanillaAprobacionRespuestaOV resp = new PlanillaAprobacionRespuestaOV();
		Map<String, Object>	params	= new HashMap<String, Object>( );
		Double interesTotalCredito = null;
		Double totalPagarCredito = null;
		SqlSession sesionNTx = null;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String guid = GUIDGenerator.generateGUID( this );
		@SuppressWarnings("rawtypes")
		HashMap datosContrato = null;
		AsesorOV asesorOV = null;
		if (numeroContrato == null) {
			resp.setHeader(generarHeader(false, "Datos peticion incompletos", guid));
			return resp;
		}
		numeroContrato = comun.obtenerNumeroContrato(uid, numeroContrato); 
		LogHandler.debug(null, this.getClass(), "---------------contrato recuperado=" + numeroContrato);
		if (numeroContrato == null) {
			resp.setHeader(generarHeader(false, "Contrato Inexistente", guid));
			return resp;
		}
		
		Date fechaContable = comun.obtenerFechaContable(uid ).getFecha();
		String fechaFormateada = formatter.format(fechaContable); 
		datosContrato = comun.obtenerDatosGeneralesContrato(uid, numeroContrato);
		if(datosContrato == null || datosContrato.get("sucursal") == null) {
			resp.setHeader(generarHeader(false, "Error al obtener datos del contrato", guid));
			return resp;
		}
				
		try {
			sesionNTx 		= FabricaConexiones.obtenerSesionNTx( );
			//Se calcula el IVA
			params.put("codigo", CODIGO_IVA);
			params.put("fecha", new Date());
			params.put("sucursal", datosContrato.get("sucursal"));
			LogHandler.trace(uid, getClass(), "==> obtenerPlantillaAprobacion - verValorHistorico ");
			Integer iva = (Integer) sesionNTx.selectOne("verValorHistorico", params);
			
			if ( iva == null) {
				resp.setHeader(generarHeader(false, "No se encontro el valor del IVA para la sucursal="	+datosContrato.get("sucursal"), guid));
				return resp;
			}
			LogHandler.debug(null, this.getClass(),"----------iva=" + (1.0 + (iva.doubleValue() / 100)));
			params.clear();
			params.put("numContrato", numeroContrato);
			params.put("iva", (1.0 + (iva.doubleValue() / 100))); // el iva en CREDPROD es mensual SIN IVA, en finsol se maneja anual y con iva
			LogHandler.trace(uid, getClass(), "==> obtenerPlantillaAprobacion - obtenerDatosPlanillaAprobacion");
			List<PlanillaAprobacionOV> listaPlanillas =  sesionNTx.selectList("obtenerDatosPlanillaAprobacion", params);
			interesTotalCredito = comun.calcularInteresTotalCredito(uid, numeroContrato);
			
			//se redondea el interesTotal
			interesTotalCredito = Math.rint(interesTotalCredito * 100) / 100;
			
			totalPagarCredito = ((BigDecimal) datosContrato.get("monto")).doubleValue() + interesTotalCredito;
			
			//totalPagarCredito = Math.rint((totalPagarCredito*100)/100);
			
			LogHandler.debug(null, this.getClass(),"-------- interesTotalCredito=" + interesTotalCredito);
			
			for (int i = 0; i < listaPlanillas.size() ; i++) {
				PlanillaAprobacionOV planillaIntegrante = listaPlanillas.get(i);
				planillaIntegrante.setFecha(fechaFormateada);
				//se calcula el porcentaje de participacion para cada integrante
				Double porcentajeParticipacion = planillaIntegrante.getMntSolicitadoActual() / planillaIntegrante.getMontoAprobado();
				//LogHandler.debug("porcentaje "+i+"="+porcentajeParticipacion);
				Double cuotaSemanalIntegrante =  Math.rint(((planillaIntegrante.getMontoPagoGrupo() * porcentajeParticipacion) * 100)) / 100;//se redondea a 2 decimales
				//LogHandler.debug("--------cuota semanal="+cuotaSemanalIntegrante);
				planillaIntegrante.setCuotaSemanalActual(cuotaSemanalIntegrante);
				planillaIntegrante.setTotalInteres(interesTotalCredito);
				planillaIntegrante.setTotalPagar(totalPagarCredito);
				
				//Se consulta el WS de Asesores y se concatena el nombre del asesor
				if(planillaIntegrante.getAsesor() !=null && !planillaIntegrante.getAsesor().trim().equals(""))
					{
					asesorOV = AsesorData.obtenAsesor(uid, planillaIntegrante.getAsesor().trim());
					if (asesorOV != null) {
						planillaIntegrante.setAsesor(planillaIntegrante.getAsesor() + "-" + asesorOV.getNombreCompleto() );
						}
					}
			}

			resp.setHeader(generarHeader(true, "Consulta Ejecutada Exitosamente", guid));
			resp.setPlanilla(listaPlanillas);
		} catch (Exception e) {
			LogHandler.error(uid, this.getClass(), "ERROR Al obtener la Plantilla de Aprobacion", e);
			//e.printStackTrace();
			resp.setHeader(generarHeader(false, "Problema Al ejecutar la consulta", guid));
			resp.setPlanilla(null);
		} finally {
			FabricaConexiones.close( sesionNTx );
			LogHandler.info(uid, this.getClass(), "obtenerPlantillaAprobacion OK");
		}

		return resp;
	}


	/**
	 * Generar header.
	 *
	 * @param estatus the estatus
	 * @param mensaje the mensaje
	 * @param correlationId the correlation id
	 * @return the encabezado respuesta
	 */
	private EncabezadoRespuesta generarHeader(boolean estatus, String mensaje, String correlationId) {
		EncabezadoRespuesta header = new EncabezadoRespuesta();
		header.setCodigo("");
		header.setMensaje(mensaje);
		header.setCorrelationId(correlationId);
		header.setEstatus(estatus);

		return header;
	}


	@SuppressWarnings("deprecation")
	
	public ConsultarSimulacionesReestructurasRespuesta consultarSimuladorReestructurasTarea(
			String uid, SimulacionReestructuraOV peticion) {
		ConsultarSimulacionesReestructurasRespuesta respuesta = new ConsultarSimulacionesReestructurasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);

		SqlSession sesion = null;
//		DecimalFormat twoDForm = new DecimalFormat("#.##");

		try	{
			sesion = FabricaConexiones.obtenerSesionNTx();

		  if (peticion == null || peticion.getContrato() == null) {
				throw new Exception("LOS DATOS DE LA PETICION ESTAN INCORRECTOS");
			}

			//se valida si trae o no idSimulacion
		  if (peticion.getIdSimulacion() == null) {
			//solo mandan contrato

			String contrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());

				if (contrato == null) {
					throw new Exception("EL CONTRATO NO EXISTE");
				}
			LogHandler.info(uid, getClass(), ">>>>>>" + contrato);
			LogHandler.trace(uid, getClass(), ">>>>>>" + contrato);


			LogHandler.info(uid, getClass(),
					"==> consultarSimuladorReestructurasTarea - existeSimulacion");
			LogHandler.trace(uid, getClass(),
					"==> consultarSimuladorReestructurasTarea - existeSimulacion");

			Integer existeSim = (Integer) sesion.selectOne("existeSimulacion", contrato);

			//Se valida si existen simulaciones
			if (existeSim == 0 || peticion.getNuevaSimulacion()) {

				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				final FechaContableOV fechaContable = comun.obtenerFechaContable( uid );
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put( "fechaContable" , formatter.format(fechaContable.getFecha()));
				parametros.put( "contrato" , contrato);

				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerDatosContratoSimulacion");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerDatosContratoSimulacion");

				SimulacionReestructuraOV datosContrato = (SimulacionReestructuraOV)
						sesion.selectOne("obtenerDatosContratoSimulacion", parametros);

				if (datosContrato == null) {
					throw new Exception("LA CONSULTA PARA LOS DATOS DEL CONTRATO NO ARROJO RESULTADOS");
				}

				//validacion de la variable
				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerParGeneral");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerParGeneral");

				ParGeneralOV parGen = comun.obtenerParGeneralOV(uid, "NDIASREEST"); 
						//(ParGeneralOV) sesion.selectOne("obtenerParGeneral", "NDIASREEST");

				if (datosContrato.getDiasMora() < Integer.parseInt(parGen.getCgValor())) {
					throw new Exception("LOS DIAS DE MORA SON MENORES A 60 DIAS POR LO QUE NO PUEDE SIMULARSE LA REESTRUCTURA");
				}

				//validar diaPago
				//validaciones pagosContrato
				datosContrato.setDiaPagoNum(datosContrato.getDiaPago().getDay());
				datosContrato.setNombreGrupo(datosContrato.getNombreGrupo().trim());

				//Obtener los saldos de la simulacion
				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerSaldosSimulacion");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerSaldosSimulacion");

				@SuppressWarnings("unchecked")
				final HashMap<Object, Object> saldosSim = (HashMap<Object, Object>)
					sesion.selectOne("obtenerSaldosSim", parametros);

				if (saldosSim == null) {
					throw new Exception("LA CONSULTA PARA LOS SALDOS DEL CONTRATO NO ARROJO RESULTADOS");
				}

				final Double recargos = Double.valueOf(saldosSim.get("Moratorio").toString())
						+ Double.valueOf(saldosSim.get("Iva Moratorio").toString());
				final Double saldoInteres = Double.valueOf(saldosSim.get("Interes Vencido").toString())
						+ Double.valueOf(saldosSim.get("Iva Interes Vencido").toString());
				datosContrato.setRecargos(recargos);
				datosContrato.setSaldoInteres(saldoInteres);
				datosContrato.setAdeudoTotal(recargos + datosContrato.getSaldoCapital() + saldoInteres);
				datosContrato.setSaldoPendiente(datosContrato.getSaldoCapital() + saldoInteres);


				//Integrantes

				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerDatosIntegranteSimulacion");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerDatosIntegranteSimulacion");

				@SuppressWarnings("unchecked")
				List<SimulacionReestructuraIntOV> integrantes =
				sesion.selectList("obtenerDatosIntegranteSimulacion", contrato);

				if (integrantes.size() == 0) {
					throw new Exception("LA CONSULTA PARA OBTENER LOS INTEGRANTES DEL CONTRATO NO ARROJO RESULTADOS");
				}

				for (int i = 0; i < integrantes.size(); i++) {
					integrantes.get(i).setSaldoVigente(datosContrato.getSaldoPendiente()
							* (integrantes.get(i).getPctParticipacionVigente() / 100));
				}

				respuesta.getHeader().setMensaje("La consulta de contrato se ha realizado con exito.");
				respuesta.setSimulacion(datosContrato);
				respuesta.setIntegrantes(integrantes);


			} else {
				//existen simulaciones para el contrato

				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerSimulacionesPopup");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerSimulacionesPopup");

				@SuppressWarnings("unchecked")
				List<SimulacionReestructuraOV> simulaciones =
				sesion.selectList("obtenerSimulacionesPopup", contrato);

				if (simulaciones.size() == 0) {
					throw new Exception("LA CONSULTA PARA OBTENER LAS SIMULACIONES NO ARROJO RESULTADOS");
				}

				respuesta.getHeader().setMensaje("La consulta de simulaciones-popup se ha realizado con exito.");
				respuesta.setSimulaciones(simulaciones);
			}

			} else {
				//mandan idSimulacion y contrato DETALLE

				String contrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());

				if (contrato == null) {
					throw new Exception("EL CONTRATO NO EXISTE");
				}

				LogHandler.info(uid, getClass(), ">>>>>>" + contrato);
				LogHandler.trace(uid, getClass(), ">>>>>>" + contrato);

				SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
				final FechaContableOV fechaContable = comun.obtenerFechaContable( uid );

				final java.util.HashMap<String, Object> parametrosSim = new HashMap<String, Object>();
				parametrosSim.put( "idSimulacion" , peticion.getIdSimulacion());
				parametrosSim.put( "contrato" , contrato);
				parametrosSim.put( "fechaContable" , formatter.format(fechaContable.getFecha()));

				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerSimulacionesIdSimulacion");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerSimulacionesIdSimulacion");

				SimulacionReestructuraOV simulacion = (SimulacionReestructuraOV)
				sesion.selectOne("obtenerSimulacionesIdSimulacion", parametrosSim);

				if (simulacion == null) {
					throw new Exception("LA CONSULTA PARA OBTENER LA SIMULACION NO ARROJO RESULTADOS");
				}

				//Obtener datosContratoAnterior

			LogHandler.info(uid, getClass(),
				"==> consultarSimuladorReestructurasTarea - obtenerDatosContratoIdSimulacion");
			LogHandler.trace(uid, getClass(),
				"==> consultarSimuladorReestructurasTarea - obtenerDatosContratoIdSimulacion");

			SimulacionReestructuraOV datosContratoAnterior = (SimulacionReestructuraOV)
			sesion.selectOne("obtenerDatosContratoIdSimulacion", parametrosSim);

			if (datosContratoAnterior == null) {
				throw new Exception("LA CONSULTA PARA OBTENER LOS DATOS DEL CONTRATO ANTERIOR NO ARROJO RESULTADOS");
			}



			simulacion.setContratoLD(datosContratoAnterior.getContratoLD());
			simulacion.setNombreGrupo(datosContratoAnterior.getNombreGrupo());
			simulacion.setStatus(datosContratoAnterior.getStatus());
			simulacion.setRegionDescripcion(simulacion.getRegionDescripcion().trim());
			simulacion.setNombreSucursal(simulacion.getNombreSucursal().trim());
			simulacion.setProducto(datosContratoAnterior.getProducto());
			simulacion.setCantidadEntregada(datosContratoAnterior.getCantidadEntregada());
			simulacion.setTotalAPagar(datosContratoAnterior.getTotalAPagar());
			simulacion.setNumeroIntegrantes(datosContratoAnterior.getNumeroIntegrantes());

				//Para los Integrantes

				LogHandler.info(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerIntegrantesIdSimulacion");
				LogHandler.trace(uid, getClass(),
						"==> consultarSimuladorReestructurasTarea - obtenerIntegrantesIdSimulacion");

				@SuppressWarnings("unchecked")
				List<SimulacionReestructuraIntOV> integrantes =
				sesion.selectList("obtenerIntegrantesIdSimulacion", parametrosSim);

				if (integrantes.size() == 0) {
					throw new Exception("LA CONSULTA PARA OBTENER LOS INTEGRANTES NO ARROJO RESULTADOS");
				}

				for (int i = 0; i < integrantes.size(); i++) {
					//Seteo Saldo Vigente por integrante
					integrantes.get(i).setSaldoVigente(simulacion.getSaldoPendiente()
							* (integrantes.get(i).getPctParticipacionVigente() / 100));

					//Seteo monto enganche por integrante
					integrantes.get(i).setMontoEnganche(simulacion.getMontoReestructura()
							* integrantes.get(i).getPctParticipacionNuevo() / 100);
				}

				respuesta.getHeader().setMensaje("La consulta de idSimulaciones-comtrato se ha realizado con exito.");
				respuesta.setSimulacion(simulacion);
				respuesta.setIntegrantes(integrantes);

			}
		} catch (Exception exception ) {
			respuesta.getHeader().setUID(uid);
			respuesta.getHeader().setMensaje(exception.getMessage());
			respuesta.getHeader().setEstatus( false );
			LogHandler.error( uid, this.getClass(), "Error en consultarSimuladorReestructurasTarea : "
					+ exception.getMessage(), exception );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	
	public InsertarSimulacionesReestructurasRespuesta insertarSimuladorReestructurasTarea(
			String uid, InsertarSimulacionesReestructurasPeticion peticion) {
		InsertarSimulacionesReestructurasRespuesta respuesta = new  InsertarSimulacionesReestructurasRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesionTx = null;

		try {
			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null || peticion.getSimulacion().getContrato() == null
					|| peticion.getSimulacion().getNombreGrupo() == null) {
				throw new Exception("LOS DATOS DE LA PETICION SON INCORRECTOS");
			}

//			Calendar myDate = Calendar.getInstance();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");

			LogHandler.info(uid, getClass(), "==> insertarSimuladorReestructurasTarea - obtenerMaxIdSimulacion");
			LogHandler.trace(uid, getClass(), "==> insertarSimuladorReestructurasTarea - obtenerMaxIdSimulacion");
			Integer maxId = (Integer) sesionTx.selectOne("obtenerMaxIdSimulacion", peticion.getSimulacion().getContrato());

			if (maxId == null) {
				throw new Exception("LA CONSULTA PARA OBTENER EL MAX ID NO ARROJO RESULTADOS");
			}

			//parametros de insercion
			final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put( "idSimulacion" , maxId);
			parametros.put( "contrato" , peticion.getSimulacion().getContrato()
					!= null ? peticion.getSimulacion().getContrato() : "");
			parametros.put( "nombreGrupo" , peticion.getSimulacion().getNombreGrupo()
					!= null ? peticion.getSimulacion().getNombreGrupo() : "");
			parametros.put( "enganche" , peticion.getSimulacion().getEnganche()
					!= null ? peticion.getSimulacion().getEnganche() : 0.0);
			parametros.put( "montoReestructura" , peticion.getSimulacion().getMontoReestructura()
					!= null ? peticion.getSimulacion().getMontoReestructura() : 0.0);

			Double montoEnganche = peticion.getSimulacion().getMontoReestructura() * peticion.getSimulacion().getEnganche() / 100;

				parametros.put( "montoEnganche" , montoEnganche);

			parametros.put( "tasa" , peticion.getSimulacion().getTasa() != null ? peticion.getSimulacion().getTasa() : 0.0);
			parametros.put( "plazo" , peticion.getSimulacion().getPlazo() != null ? peticion.getSimulacion().getPlazo() : 0);
			parametros.put( "diaReunion" , peticion.getSimulacion().getDiaReunion()
					!= null ? peticion.getSimulacion().getDiaReunion() : 0);
			parametros.put( "ciclo" , peticion.getSimulacion().getCiclo()
					!= null ? peticion.getSimulacion().getCiclo()  : 0);
			parametros.put( "sucursal" , peticion.getSimulacion().getSucursal()
					!= null ? peticion.getSimulacion().getSucursal() : 0);

			parametros.put( "parcialidad" , peticion.getSimulacion().getParcialidad()
					!= null ? peticion.getSimulacion().getParcialidad() : 0.0);
			parametros.put( "horaInicio" , peticion.getSimulacion().getHoraInicio()
					!= null ? peticion.getSimulacion().getHoraInicio() : "");
			parametros.put( "horaFin" , peticion.getSimulacion().getHoraFin()
					!= null ? peticion.getSimulacion().getHoraFin() : "");
			parametros.put( "diaPago" , peticion.getSimulacion().getDiaPagoNum()
					!= null ? peticion.getSimulacion().getDiaPagoNum()  : 0);
			parametros.put( "frecuencia" , peticion.getSimulacion().getFrecuencia()
					!= null ? peticion.getSimulacion().getFrecuencia() : "");

			parametros.put( "pctSolidaridad" , peticion.getSimulacion().getPctSolidaridad()
					!= null ? peticion.getSimulacion().getPctSolidaridad() : 0.0);
			parametros.put( "numeroIntegrantes" , peticion.getSimulacion().getNumeroIntegrantes()
					!= null ? peticion.getSimulacion().getNumeroIntegrantes() : 0);
			parametros.put( "usuarioRegistro" , peticion.getSimulacion().getUsuarioRegistro()
					!= null ? peticion.getSimulacion().getUsuarioRegistro() : "");
//				parametros.put( "fechaRegistro" , myDate.getTime());
			parametros.put( "usuarioUltMod" , peticion.getSimulacion().getUsuarioUltMod()
					!= null ? peticion.getSimulacion().getUsuarioUltMod() : "");

//				parametros.put( "fechaUltMod" , myDate.getTime());
				parametros.put( "estatus" , "A");
				parametros.put( "solicitud" , " ");
			parametros.put( "saldoCapital" , peticion.getSimulacion().getSaldoCapital()
					!= null ? peticion.getSimulacion().getSaldoCapital()  : 0.0);
			parametros.put( "diasMora" , peticion.getSimulacion().getDiasMora()
					!= null ? peticion.getSimulacion().getDiasMora() : 0);

			parametros.put( "capitalPagado" , peticion.getSimulacion().getCapitalPagado()
					!= null ? peticion.getSimulacion().getCapitalPagado() : 0.0);
			parametros.put( "interesesOrdPag" , peticion.getSimulacion().getInteresOrdPag()
					!= null ? peticion.getSimulacion().getInteresOrdPag() : 0.0);
			parametros.put( "interesesMorPag" , peticion.getSimulacion().getInteresMorPag()
					!= null ? peticion.getSimulacion().getInteresMorPag() : 0.0);
			parametros.put( "adeudoTotal" , peticion.getSimulacion().getAdeudoTotal()
					!= null ? peticion.getSimulacion().getAdeudoTotal()  : 0.0);
			parametros.put( "recargos" , peticion.getSimulacion().getRecargos()
					!= null ? peticion.getSimulacion().getRecargos() : 0.0);

			parametros.put( "saldoInteres" , peticion.getSimulacion().getSaldoInteres()
					!= null ? peticion.getSimulacion().getSaldoInteres() : 0.0);
			parametros.put( "saldoPendiente" , peticion.getSimulacion().getSaldoPendiente()
					!= null ? peticion.getSimulacion().getSaldoPendiente() : "");
				parametros.put( "fechaContable" , formatter.format(comun.obtenerFechaContable(uid).getFecha()));

			LogHandler.trace(uid, getClass(), "fechaContable: " + parametros.get("fechaContable"));


			LogHandler.info(uid, getClass(), "==> insertarSimuladorReestructurasTarea - insertarSimulacion");
			LogHandler.trace(uid, getClass(), "==> insertarSimuladorReestructurasTarea - insertarSimulacion");
			Integer numeroRegistros = sesionTx.insert("insertarSimulacion", parametros);

			LogHandler.info(uid, getClass(), "numeroRegistros: " + numeroRegistros);



			//Actualizar estatus de la solicitud
			for (int i = 0; i < peticion.integrantes.size(); i++) {
				final java.util.HashMap<String, Object> parametrosIntegrantes = new HashMap<String, Object>();
				parametrosIntegrantes.put( "contrato" , peticion.getIntegrantes().get(i).getContrato()
						!= null
						? peticion.getIntegrantes().get(i).getContrato()
						: "");
				parametrosIntegrantes.put( "idSimulacion" , parametros.get("idSimulacionH"));
				parametrosIntegrantes.put( "persona" , peticion.getIntegrantes().get(i).getPersona()
						!= null ? peticion.getIntegrantes().get(i).getPersona() : "");
			parametrosIntegrantes.put( "pctParticipacionVigente" , peticion.getIntegrantes().get(i).getPctParticipacionVigente()
						!= null ? peticion.getIntegrantes().get(i).getPctParticipacionVigente() : 0.0);

				parametrosIntegrantes.put( "saldoVigente" , peticion.getIntegrantes().get(i).getSaldoVigente()
						!= null ? peticion.getIntegrantes().get(i).getSaldoVigente() : 0.0);
				parametrosIntegrantes.put( "interesVigente" , peticion.getIntegrantes().get(i).getInteresVigente()
						!= null ? peticion.getIntegrantes().get(i).getInteresVigente() : 0.0);
				parametrosIntegrantes.put( "parcialidad" , peticion.getIntegrantes().get(i).getParcialidad()
						!= null ? peticion.getIntegrantes().get(i).getParcialidad() : 0.0);
				parametrosIntegrantes.put( "montoReestructura" , peticion.getIntegrantes().get(i).getMontoReestructura()
						!= null ? peticion.getIntegrantes().get(i).getMontoReestructura() : 0.0);

				parametrosIntegrantes.put( "pctParticipacionNuevo" , peticion.getIntegrantes().get(i).getPctParticipacionNuevo()
						!= null ? peticion.getIntegrantes().get(i).getPctParticipacionNuevo() : "");
				parametrosIntegrantes.put( "coordinador" , peticion.getIntegrantes().get(i).getCoordinador()
						!= null ? peticion.getIntegrantes().get(i).getCoordinador() : "");
					parametrosIntegrantes.put( "estatus" , "A");

				LogHandler.info(uid, getClass(), "==> insertarSimuladorReestructurasTarea - insertarSimulacionIntegrantes");
				LogHandler.trace(uid, getClass(), "==> insertarSimuladorReestructurasTarea - insertarSimulacionIntegrantes");
				sesionTx.insert("insertarSimulacionIntegrantes", parametrosIntegrantes );
			}

			sesionTx.commit(true);

			respuesta.getHeader().setMensaje("Se ha insertado con exito una simulacion y sus integrantes");

		} catch (Exception ex ) {

			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "insertarSimuladorReestructurasTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );

		}
		finally {

				FabricaConexiones.close(sesionTx);

		}

		return respuesta;
	}


}
