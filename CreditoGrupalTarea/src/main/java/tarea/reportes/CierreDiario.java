/**
 * 
 */
package tarea.reportes;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import utilitario.mensajes.reportes.cierre.eventos.EventoReporteCierre;

/**
 * @author Angel
 *
 */
public interface CierreDiario {
	
	//Ruta fisica donde vivira el archivo tenporalmente antes de subirlo via FTP
	static final String REPORTE_PATH_DEFAULT	= "/home/ciof_des/CIOF/";
	
	static final double PORCENTAJE_AVANCE		= 0.055;
	static final int REGISTROS_MINIMOS			= 500;
	
	static SimpleDateFormat SDF 				= new  SimpleDateFormat("yyyyMMdd"); 
	static Format FORMATO_FECHA_NOM_REPORTE		= new SimpleDateFormat("ddMMyyyy");
	
	static final String EXTENSION				= ".csv";
	
	
	//PREFORMATO DE NOMBRES PARA LA HOJA Y ARCHIVO DE EXCEL (SE LES DEBE AÑADIR LA FECHA DE CREACION)
	public static final String NOMBRE_REPORTE_CARTERA_ACTIVA						= "EM.LD.GIC.OPEN_";
	public static final String NOMBRE_REPORTE_CONTRATOS_ACTIVOS_CON_MORA			= "FIN.PD.FINSOL2.DDS_";
	public static final String NOMBRE_REPORTE_CONTRATOS_ACTIVOS_CON_SALDO_FAVOR 	= "LD.ACCOUNT.NUMBER_";
	public static final String NOMBRE_REPORTE_DESEMBOLSO_OPEN_CONTRACT				= "OPEN.CONTRACT_";
	public static final String NOMBRE_REPORTE_DESEMBOLSO_REPAYMENT					= "REPAYMENTS206_";
	public static final String NOMBRE_REPORTE_DESEMBOLSO_SE_FINSOL1					= "SE.FINSOL1_";
	public static final String NOMBRE_REPORTE_DESEMBOLSO_SE_FINSOL2					= "SE.FINSOL2_";

	
	//Operaciones a efectuar para generar los reportes (ids de los select count en iBatis)
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_CARTERA_ACTIVA 			=  "obtenerTotalRegistrosReporteCierreCarteraActiva";
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_SALDO_FAVOR	 			=  "obtenerTotalRegistrosReporteCierreSaldoFavor";
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_CON_MORA		 			=  "obtenerTotalRegistrosReporteCierreConMora";
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_OPEN_CONTRACT	=  "obtenerTotalRegistrosReporteCsvCierreOpenContract";
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_REPAYMENTS		=  "obtenerTotalRegistrosReporteCierreRepayment";
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_SE_FINSOL1		=  "obtenerTotalRegistrosReporteCierreSEFinsol1";
	public static final String OPER_OBTER_TOTAL_REGISTROS_REPORTE_DESEMBOLSO_SE_FINSOL2		=  "obtenerTotalRegistrosReporteCierreSEFinsol2";
	
	//Operaciones a efectuar para obtener la informacion de la consulta a la DB (ids select en iBatis)
	public static final String OPER_OBTER_REPORTE_CARTERA_ACTIVA 				=  "obtenerReporteCierreCarteraActiva";
	public static final String OPER_OBTER_REPORTE_CONTRATOS_ACTIVOS_MORA 		=  "obtenerReporteCierreContratosActivosMora";
	public static final String OPER_OBTER_REPORTE_CONTRATOS_SALDO_FAVOR			=  "obtenerReporteCierreContratosSaldoFavor";
	public static final String OPER_OBTER_REPORTE_DESEMBOLSO_OPEN_CONTRACT		=  "obtenerReporteCierreCsvDesembolsoOpenContract";
	public static final String OPER_OBTER_REPORTE_REPAYMENTS					=  "obtenerReporteCierreDesembolsoRepayment";
	public static final String OPER_OBTER_REPORTE_SE_FINSOL1					=  "obtenerReporteCierreDesembolsoSEFinsol1";
	public static final String OPER_OBTER_REPORTE_DESEMBOLSO_SE_FINSOL2			=  "obtenerReporteCierreDesembolsoSEFinsol2";

	/**
	 * Funcion que calcula el total de registros a procesar por cada reporte
	 * @param eventoReporte
	 * @return
	 */
	public Integer calculaTotalRegistros(String uid, EventoReporteCierre eventoReporte );
	
	/**
	 * Metodo empleado para generar asincronamente el reporte.
	 * @param eventoReporte
	 * @return
	 */
	public void generaReporteCierre( EventoReporteCierre eventoReporte );
	
	/**
	 * Genera el reporte para la cartera activa.
	 * @param contrato
	 * @return
	 */
	public boolean generaReporteCarteraActiva(String uid,  Date fechaCierre, Integer totalRegistrosAProcesar );
	
	/**
	 * Genera el reporte para contratos activos con mora al día actual.
	 * @param contrato
	 * @return
	 */
	public boolean generaReporteContratosActivosConMora(String uid, Date fechaCierre, Integer totalRegistrosAProcesar );

	/**
	 * Genera el reporte para contratos con saldo a favor.
	 * @param contrato
	 * @return
	 */
	public boolean generaReporteSaldoAFavor( String uid, Date fechaCierre, Integer totalRegistrosAProcesar );
	
	/**
	 * Genera el reporte de desembolso diario tipo OpenContract
	 * @param contrato
	 * @return
	 */
	public boolean generaReporteDesembolsoOpenContract( String uid,  Date fechaCierre, Integer totalRegistrosAProcesar );
	
	/**
	 * Genera el reporte de desembolso diario tipo Repayment
	 * @param contrato
	 * @return
	 */
	
	public boolean generaReporteRepayment(String uid,  Date fechaCierre, Integer totalRegistrosAProcesar );
	
	/**
	 * Genera el reporte de desembolso dirario tipo SE_FINSOL1
	 * @param contrato
	 * @return
	 */
	public boolean generaReporteDesembolsoSEFinsol1( String uid, Date fechaCierre, Integer totalRegistrosAProcesar );
	
	/**
	 * Genera el reporte de desembolso dirario tipo SE_FINSOL2
	 * @param contrato
	 * @return
	 */
	public boolean generaReporteDesembolsoSEFinsol2(String uid, Date fechaCierre, Integer totalRegistrosAProcesar );
	
	 
}
