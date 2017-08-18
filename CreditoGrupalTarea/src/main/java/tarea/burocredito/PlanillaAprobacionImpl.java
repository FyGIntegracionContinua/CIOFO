package tarea.burocredito;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;

import tarea.comun.ComunTarea;
import utilitario.comun.Constantes;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.BuroCreditoPlanillaAprobacionPeticion;
import utilitario.mensajes.burocredito.BuroCreditoPlanillaAprobacionRespuesta;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;

import com.findep.buro.dto.ReporteCredito;
import com.findep.buro.dto.SegmentoConsulta;
import com.findep.buro.dto.SegmentoCuenta;
import com.findep.buro.dto.SegmentoDireccion;
import com.findep.buro.dto.SegmentoEmpleo;
import com.findep.buro.dto.SegmentoEncabezado;
import com.findep.buro.dto.SegmentoFin;
import com.findep.buro.dto.SegmentoNombre;
import com.findep.buro.dto.SegmentoResumenReporte;
import com.findep.buro.dto.SegmentoScore;
import com.findep.credito.buro.bnc.modelo_comun.BncException;
import com.findep.credito.buro.dto.ObtenerXMLReporteCreditoRequest;
import com.findep.credito.buro.dto.ObtenerXMLReporteCreditoResponse;
import com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoProxy;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import entidad.conexiones.FabricaConexiones;

public class PlanillaAprobacionImpl implements PlanillaAprobacion {


	/** SEMANAS_MES int	 */
	private static final int  SEMANAS_MES			= 4;
	/** SEMANAS_BIMES int	 */
	private static final int  SEMANAS_BIMES			= 8;
	/** SEMANAS_SEMESTRE int	 */
	private static final int  SEMANAS_SEMESTRE		= 24;
	/**
	 * comun ComunTarea
	 */
	private ComunTarea comun;

	/**
	 * @param comun :
	 */
	public PlanillaAprobacionImpl( @Reference(name = "comun") ComunTarea comun) {
		this.comun = comun;
	}

	/**
	 * @param uid Identificador unico
	 * @param peticion persona que de la planilla
	 * @return BuroCreditoPlanillaAprobacionRespuesta
	 */
	public BuroCreditoPlanillaAprobacionRespuesta obtenerDatosPlanillaAprobacion(
			String uid, BuroCreditoPlanillaAprobacionPeticion peticion) {

		BuroCreditoPlanillaAprobacionRespuesta respuesta = new BuroCreditoPlanillaAprobacionRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sessionNTx	= null;
		try {

		//Se abre la session No transaccional sybase
		sessionNTx = FabricaConexiones.obtenerSesionNTx();

		LogHandler.trace(uid, getClass(), "obtenerDatosPlanillaAprobacion: - obtenerParGeneral");
		ParGeneralOV urlBuro = comun.obtenerParGeneralOV(uid, "BURO_URL");
				//(ParGeneralOV)	sessionNTx.selectOne("obtenerParGeneral", "BURO_URL");
		if (urlBuro == null || urlBuro.getCgValor().trim().isEmpty()) {
				throw new Exception("No fue posible obtener la URL del servicio de buro.");
		}
		ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
		ws.setEndpoint(urlBuro.getCgValor().trim());

		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();
		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();
		request.setPersona(peticion.getPersona());
		//request.setPersona("950463766");
		response = ws.obtenerXMLReporteCredito(request);

		if ( response == null || response.getXMLReporteCredito().isEmpty()) {
			throw new Exception("El cliente " + peticion.getPersona() + " no tiene consulta al buro.");
		}

		//LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "BURO" + response.getXMLReporteCredito());
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "BURO CORRECTO");
		ReporteCredito reporteCredito = obtenerObjetoBCN(response.getXMLReporteCredito());

		String fechaConsulta = "";
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
		Date dFechaConsulta = null;
		double saldoVencido = 0.0;
		double saldoActual = 0.0;
		double cuotaSemanal = 0.0;
		int mopMaximoAbierto = 0;
		int mopMaximoCerrado = 0;
		int mopAutoHipo = 0;
		double saldoAutoHipo = 0.0;
	    String clavesObserv = "";

		if ( reporteCredito.getConsultas().size() == 0 ) {
			throw new Exception("No es posible obtener la fecha de consulta del buro");
		} else {
			fechaConsulta = reporteCredito.getConsultas().get(0).getFechaConsulta();
			dFechaConsulta = formatter.parse(fechaConsulta);
		}

		int diasDiferencia = diferenciaEnDias(new Date(), dFechaConsulta);

		//Obtenemos valor de dias consulta vigente
		//Se obtiene el usuario que atiende las tareas de reasignacion de cartera
		LogHandler.trace(uid, getClass(), "obtenerDatosPlanillaAprobacion: - obtenerParGeneral");
		ParGeneralOV diasParametro = comun.obtenerParGeneralOV(uid, "BURO_DIASV");
				//(ParGeneralOV) sessionNTx.selectOne("obtenerParGeneral", "BURO_DIASV");

		if (diasParametro == null || diasParametro.getCgValor().trim().isEmpty() ) {
			throw new Exception("No fue posible obtener el valor de dias minimo consulta buro vigente.");
		}

		if (diasDiferencia > Integer.parseInt(diasParametro.getCgValor().trim())) {
			throw new Exception("El cliente " + peticion.getPersona()
					+ " no tiene consulta vigente al buro, ultima consulta hace " + diasDiferencia + " dias.");
		}
		if ( reporteCredito.getCuentas() != null  && reporteCredito.getCuentas().size() > 0) {

			for (  SegmentoCuenta cuenta : reporteCredito.getCuentas() ) {

				cuenta.setSaldoVencido(cuenta.getSaldoVencido() == null ? "" : cuenta.getSaldoVencido());
				cuenta.setSaldoVencido(cuenta.getSaldoVencido().isEmpty() ? "0" : cuenta.getSaldoVencido());
				cuenta.setSaldoVencido(cuenta.getSaldoVencido().replace("+", "").replace("-", ""));
				cuenta.setSaldoActual(cuenta.getSaldoActual() == null ? "" : cuenta.getSaldoActual());
				cuenta.setSaldoActual(cuenta.getSaldoActual().isEmpty() ? "0" : cuenta.getSaldoActual());
				cuenta.setSaldoActual(cuenta.getSaldoActual().replace("+", "").replace("-", ""));
				cuenta.setFechaCierreCuenta(cuenta.getFechaCierreCuenta() == null ? "" : cuenta.getFechaCierreCuenta());
				cuenta.setFrecuenciaPago(cuenta.getFrecuenciaPago() == null ? "" : cuenta.getFrecuenciaPago());
				cuenta.setFrecuenciaPago(cuenta.getFrecuenciaPago().isEmpty() ? "M" : cuenta.getFrecuenciaPago());
				cuenta.setMontoPago(cuenta.getMontoPago() == null ? "" : cuenta.getMontoPago());
				cuenta.setMontoPago(cuenta.getMontoPago().isEmpty() ? "0" : cuenta.getMontoPago());
				cuenta.setMontoPago(cuenta.getMontoPago().replace("+", "").replace("-", ""));
				cuenta.setFormaPagoActual(cuenta.getFormaPagoActual() == null ? "" : cuenta.getFormaPagoActual());
				cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().isEmpty() ? "0" : cuenta.getFormaPagoActual());
				cuenta.setFormaPagoActual(cuenta.getFormaPagoActual().equals("UR") ? "0" : cuenta.getFormaPagoActual());
				int mopCuenta = Integer.parseInt(cuenta.getFormaPagoActual());
				if ( cuenta.getNombreOrtogante() != null && !cuenta.getNombreOrtogante().trim().equals("FINSOL")) {
					//Saldo vencido sumar todas
					saldoVencido +=  Double.parseDouble(cuenta.getSaldoVencido());
					//cuentas abiertas
					if ( cuenta.getFechaCierreCuenta().isEmpty() ) {
						saldoActual +=  Double.parseDouble(cuenta.getSaldoActual());
						cuotaSemanal += calcularPagoSemanal(cuenta.getFrecuenciaPago(),
								Double.parseDouble(cuenta.getMontoPago()));
						if ( mopCuenta > mopMaximoAbierto ) {
							mopMaximoAbierto = mopCuenta;
						}
					}
					//cuentas cerradas
					else {

						if ( mopCuenta > mopMaximoCerrado ) {
							mopMaximoCerrado = mopCuenta;
						}
					}

					//Automotriz Hipotecario
					//M - Hipoteca
					//AU(Compra Automovil) RE(Bienes Raices)
					//
					if ( cuenta.getTipoCuenta().trim().equals("M")
						 || cuenta.getTipoContrato().trim().equals("AU") || cuenta.getTipoContrato().trim().equals("RE")
						 || cuenta.getNombreOrtogante().trim().equals("AUTOMOTRIZ")
						 || cuenta.getNombreOrtogante().trim().equals("BIENES RAICES")
						 ) {

						saldoAutoHipo +=  Double.parseDouble(cuenta.getSaldoVencido().replace("+", ""));
						if ( mopCuenta > mopAutoHipo ) {
							mopAutoHipo = mopCuenta;
						}
					}

					// claves observacion
					// borrar CC Y PC es para prueba
					if (cuenta.getClaveObservacion() != null) {
						if (cuenta.getClaveObservacion().trim().equals("FD") || cuenta.getClaveObservacion().trim().equals("SG")
							|| cuenta.getClaveObservacion().trim().equals("IM")
							|| cuenta.getClaveObservacion().trim().equals("LO")
							|| cuenta.getClaveObservacion().trim().equals("FR")) {
							clavesObserv = clavesObserv.equals("") ? ""  + cuenta.getClaveObservacion()
									: (clavesObserv + ";" + cuenta.getClaveObservacion() );
						}
					}

				} //fin if cuenta
			} // fin for
		}

		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "FECHA CONSULTA =" + fechaConsulta);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "SALDO VENCIDO =" + saldoVencido);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "SALDO ACTUAL =" + saldoActual);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "CUOTA SEMANAL =" + cuotaSemanal);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "MOP MAXIMO CERRADO =" + mopMaximoCerrado);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "MOP MAXIMO ABIERTO =" + mopMaximoAbierto);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:" + "MOP AUTOMOTRIZ / HIPOTECA =" + mopAutoHipo);
		LogHandler.info(uid, getClass(), "obtenerDatosPlanillaAprobacion:"
								+ "SALDO VENCIDO AUTOMOTRIZ / HIPOTECA =" + saldoAutoHipo);

		// claves observacion
		respuesta.setClavesObserv(clavesObserv.equals("") ? "-" : clavesObserv );

		respuesta.setdFechaConsulta(dFechaConsulta);
		respuesta.setSaldoVencido(saldoVencido);
		respuesta.setSaldoActual(saldoActual);
		respuesta.setCuotaSemanal(cuotaSemanal);
		respuesta.setMopMaximoCerrado(mopMaximoCerrado);
		respuesta.setMopMaximoAbierto(mopMaximoAbierto);
		respuesta.setMopAutoHipo(mopAutoHipo);
		respuesta.setSaldoAutoHipo(saldoAutoHipo);
		respuesta.setFolioConsulta(reporteCredito.getSegmentoFin().getNumeroControlConsulta());
		}
		catch (BncException exBuroSrv) {
			exBuroSrv.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en la llamada al servicio de buro [BncException]. "
					+ exBuroSrv.getRespuestaClave());
 		}
		catch (Exception ex) {
			ex.printStackTrace();
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close(sessionNTx);
		}
		return respuesta;
	}


	/**
	 * @param xml Reporte Buro Credito
	 * @return Objeto
	 * @throws Exception
	 */
	public ReporteCredito obtenerObjetoBCN(String xml) throws Exception {

		ReporteCredito reporteCredito = null;
		try {
			reporteCredito = new ReporteCredito();
			XStream xstream = new XStream(new DomDriver());
			xstream.alias("ReporteCredito", ReporteCredito.class);
			xstream.alias("SegmentoConsulta", SegmentoConsulta.class);
			xstream.alias("SegmentoCuenta", SegmentoCuenta.class);
			xstream.alias("SegmentoDireccion", SegmentoDireccion.class);
			xstream.alias("SegmentoEmpleo", SegmentoEmpleo.class);
			xstream.alias("SegmentoEncabezado", SegmentoEncabezado.class);
			xstream.alias("SegmentoFin", SegmentoFin.class);
			xstream.alias("SegmentoNombre", SegmentoNombre.class);
			xstream.alias("SegmentoScore", SegmentoScore.class);
			xstream.alias("SegmentoResumenReporte", SegmentoResumenReporte.class);
			reporteCredito = (ReporteCredito) xstream.fromXML(xml);

		}
		catch (Exception ex) {
			throw new Exception(ex.getMessage());
		}
		return reporteCredito;
	}

	/**
	 * @param fechaMayor fecha Actual
	 * @param fechaMenor fecha Menor
	 * @return diferencia de dias
	 */
	public static int diferenciaEnDias(Date fechaMayor, Date fechaMenor) {
		/* CREAMOS LOS OBJETOS GREGORIAN CALENDAR PARA EFECTUAR LA RESTA */
		GregorianCalendar date1 = new GregorianCalendar();
		date1.setTime(fechaMenor); //dateIni es el objeto Date
		GregorianCalendar date2 = new GregorianCalendar();
		date2.setTime(fechaMayor); //dateFin es el objeto Date
		int rango = 0;
		/* COMPROBAMOS SI ESTAMOS EN EL MISMO A�O */
		if (date1.get(Calendar.YEAR) == date2.get(Calendar.YEAR)) {
		rango = date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR);
		} else {
		/* SI ESTAMOS EN DISTINTO A�O COMPROBAMOS QUE EL A�O DEL DATEINI NO SEA BISIESTO
		* SI ES BISIESTO SON 366 DIAS EL A�O
		* SINO SON 365
		*/
		int diasAnyo = date1.isLeapYear(date1.get(Calendar.YEAR)) ? Constantes.DIAS_ANIO_BI : Constantes.DIAS_ANIO;
		/* CALCULAMOS EL RANGO DE A�OS */
		int rangoAnyos = date2.get(Calendar.YEAR) - date1.get(Calendar.YEAR);
		/* CALCULAMOS EL RANGO DE DIAS QUE HAY */
		rango = (rangoAnyos * diasAnyo) + (date2.get(Calendar.DAY_OF_YEAR) - date1.get(Calendar.DAY_OF_YEAR));
		}
		return rango;
		}

	/**
	 * @param frecuencia de la cauenta de buro
	 * @param montoPago monto pago reportado
	 * @return monto pago semanal
	 */
	public static double calcularPagoSemanal( String frecuencia, double montoPago) {

		if ( frecuencia == null || frecuencia.equals("") || frecuencia.equals("M")  || frecuencia.equals("Z")) {
			return montoPago / SEMANAS_MES;
		}
		else if ( frecuencia.equals("S")  || frecuencia.equals("K")) {
			 return montoPago / 2;
		}
		else if ( frecuencia.equals("B")) {
			 return montoPago / SEMANAS_BIMES;
		}
		else if ( frecuencia.equals("H")) {
			 return montoPago / SEMANAS_SEMESTRE;
		} else {
			 return montoPago;
		}
	}
}
