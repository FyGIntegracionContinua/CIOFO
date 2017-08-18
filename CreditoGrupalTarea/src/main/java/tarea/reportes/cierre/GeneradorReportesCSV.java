package tarea.reportes.cierre;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import utilitario.mensajes.reportes.cierre.CarteraActivaOV;
import utilitario.mensajes.reportes.cierre.ContratosActivosMoraOV;
import utilitario.mensajes.reportes.cierre.ContratosActivosSaldoFavorOV;
import utilitario.mensajes.reportes.cierre.DesembolsoOpenContractOV;
import utilitario.mensajes.reportes.cierre.DesembolsoRepaymentsOV;
import utilitario.mensajes.reportes.cierre.DesembolsoSEFinsol1OV;
import utilitario.mensajes.reportes.cierre.DesembolsoSEFinsol2OV;
import utilitario.mensajes.reportes.cierre.TiposReporteCierre;

public interface GeneradorReportesCSV {
	
	//ARREGLO DE ENCABEZADOS PARA CADA TIPO DE CONTRATO
	public static final String COMA = ",";
	public static final String[] ENCABEZADO_CARTERA_ACTIVA = 
	{	"No. Contrato" 			+ COMA,
		"No. Grupo" 			+ COMA, 
		"Nombre Grupo" 			+ COMA,
		"Sucursal" 				+ COMA,
		"Asesor" 				+ COMA,
		"Nombre Asesor" 		+ COMA,
		"Producto" 				+ COMA,
		"Fecha Inicio" 			+ COMA,
		"Fecha Fin" 			+ COMA,
		"Cantidad Entregada" 	+ COMA,
		"Intereses" 			+ COMA,
		"Total a Pagar" 		+ COMA,
		"Parcialidad" 			+ COMA,
		"Plazo" 				+ COMA,
		"Tasa" 					+ COMA,
		"Pagado Capital" 		+ COMA,
		"Pagado Intereses" 		+ COMA,
		"Pagado Total" 			+ COMA,
		"Pago Parcial" 			+ COMA,
		"INCD" 					+ COMA,
		"Saldo Intereses" 		+ COMA,
		"Saldo Capital" 		+ COMA,
		"Saldo Total" 			+ COMA,
		"Status" 				+ COMA,
		"No. Miembros" 			+ COMA,
		"\n"
	};
	public static final String[] ENCABEZADO_CONTRATOS_ACTIVOS_CON_MORA = 
	{	"Contrato"	 			+ COMA,
		"No. Grupo" 			+ COMA, 
		"Producto" 				+ COMA,
		"1er Día Mora" 			+ COMA,
		"Fecha Reporte"			+ COMA,
		"Días Mora" 			+ COMA,
		"Capital en Mora"		+ COMA,
		"Interés en Mora" 		+ COMA,
		"Mora Total" 			+ COMA,
		"Recargos" 				+ COMA,
		"Sucursal" 				+ COMA,
		"Plazo"			 		+ COMA,
		"Tasa"			 		+ COMA,
		"Fecha Fin" 			+ COMA,
		"Asesor"	 			+ COMA,
		"Nombre Asesor" 		+ COMA,
		"Nombre Grupo"	 		+ COMA,
		"No. Miembros" 			+ COMA,
		"\n"
	};
	public static final String[] ENCABEZADO_CONTRATOS_ACTIVOS_CON_SALDO_FAVOR = 
	{	"Contrato"	 				+ COMA,
		"No. Grupo" 				+ COMA, 
		"Nombre Grupo"				+ COMA,
		"Producto" 					+ COMA,
		"Saldo" 					+ COMA,
		"Fecha Apertura"			+ COMA,
		"No. Sucursal" 				+ COMA,
		"Nombre Sucursal" 			+ COMA,
		"Fecha Ultimo Mov. Credito"	+ COMA,
		"\n"
	};
	public static final String[] ENCABEZADO_DESEMBOLSO_OPEN_CONTRACT = 
	{	"No. Contrato" 				+ COMA,
		"No. Grupo" 				+ COMA, 
		"Nombre Grupo"				+ COMA,
		"Producto" 					+ COMA,
		"Fecha Inicio" 				+ COMA,
		"Fecha Fin" 				+ COMA,
		"Monto Préstamo"			+ COMA,
		"Monto Financiado"			+ COMA,
		"Comisión"					+ COMA,
		"Monto Real"				+ COMA,
		"Periodicidad"				+ COMA,
		"Tasa"						+ COMA,
		"No. Sucursal" 				+ COMA,
		"Sucursal"		 			+ COMA,
		"Asesor"					+ COMA,
		"Nombre Asesor"				+ COMA,
		"Authorizer"				+ COMA,
		"\n"
	};
	public static final String[] ENCABEZADO_DESEMBOLSO_REPAYMENT = 
	{	"FECHA_PAGO" 				+ COMA,
		"NO_CONTRATO" 				+ COMA, 
		"NO_SUCURSAL"				+ COMA,
		"NOMBRE_SUCURSAL"			+ COMA,
		"MONTO_PAGO" 				+ COMA,
		"\n"
	};
	public static final String[] ENCABEZADO_DESEMBOLSO_SE_FINSOL1 = 
	{	"No. Contrato" 				+ COMA,
		"Producto" 					+ COMA,
		"Día Pago" 					+ COMA,
		"No. Grupo" 				+ COMA,
		"Nombre Grupo"				+ COMA,
		"Pagado Capital"			+ COMA,
		"Pagado Interés"			+ COMA,
		"Pagado Total"				+ COMA,
		"Código Sucursal"			+ COMA,
		"Nombre Sucursal"			+ COMA,
		"Parcialidad"				+ COMA,
		"\n"
	};
	public static final String[] ENCABEZADO_DESEMBOLSO_SE_FINSOL2 = 
	{	"No. Contrato" 				+ COMA,
		"Producto" 					+ COMA,
		"Día Pago" 					+ COMA,
		"No. Grupo" 				+ COMA,
		"Nombre Grupo"				+ COMA,
		"Pagado Capital"			+ COMA,
		"Pagado Interés"			+ COMA,
		"Pagado Recargos"			+ COMA,
		"Abono"						+ COMA,
		"Código Sucursal"			+ COMA,
		"Nombre Sucursal"			+ COMA,
		"\n"
	};
	
	/**
	 * Genera el reporte que posteriormente sera llenado por el tipo de reporte que sea necesario.  
	 * @param tipo
	 * @param fileName
	 * @return boolean si fue o no creado.
	 */
	public boolean generaReporteCSV ( String uid, TiposReporteCierre tipo , String path, String fileName );
	
	/**
	 * Agrega el resultado de los registros de la DB al reporte de cartera Activa.
	 * @param fechaCierre
	 * @param listaCarteraActiva
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVCarteraActiva( String uid, String path, String fileName, Date fechaCierre, List<CarteraActivaOV> listaCarteraActiva, java.lang.Integer conteoRegistros, SqlSession sessionNTx );
 	
	/**
	 * Agrega el resultado de los registros de la DB al reporte de contratos activos con mora.
	 * @param fechaCierre
	 * @param listaContratosActivosMora
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVContratosActivosConMora(String uid, String path, String fileName, Date fechaCierre, List<ContratosActivosMoraOV> listaContratosActivosMora, java.lang.Integer conteoRegistros );
 	 
	
	/**
	 * Agrega el resultado de los registros de la DB al reporte de contratos activos con saldo a favor.
	 * @param fechaCierre
	 * @param listaSaldoFavor
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVContratosActivosSaldoAFavor( String uid, String path, String fileName, Date fechaCierre, List<ContratosActivosSaldoFavorOV> listaSaldoFavor );

	/**
	 * Agrega el resultado de los registros de la DB al reporte de desembolso OpenContract.
	 * @param fechaCierre
	 * @param listaDesembolsoOpenContract
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVDesembolsoOpenContract( String uid, String path, String fileName, Date fechaCierre, List<DesembolsoOpenContractOV> listaDesembolsoOpenContract );
	
	/**
	 * Agrega el resultado de los registros de la DB al reporte de pagos Repayment.
	 * @param fechaCierre
	 * @param listaDesembolsoRepayment
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVDesembolsoRepayment( String uid, String path, String fileName, Date fechaCierre, List<DesembolsoRepaymentsOV> listaDesembolsoRepayment );
	
	 
	
	/**
	 * Agrega el resultado de los registros de la DB al reporte de pagos SE_Finsol1.
	 * @param fechaCierre
	 * @param listaDesembolsoSEFinsol1
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVDesembolsoSEFinsol1( String uid, String path, String fileName, Date fechaCierre, List<DesembolsoSEFinsol1OV> listaDesembolsoSEFinsol1, HashMap<String,Object> mapPagosCapital, HashMap<String,Object> mapPagosInteres, List<String> listContratosInvalidos );
	
	 
	
	/**
	 * Agrega el resultado de los registros de la DB al reporte de pagos SE_Finsol2.
	 * @param fechaCierre
	 * @param listaCarteraActiva
	 * @return
	 */
	public boolean  agregaRegistrosReporteCSVDesembolsoSEFinsol2( String uid, String path, String fileName, Date fechaCierre, List<DesembolsoSEFinsol2OV> listaDesembolsoSEFinsol2, HashMap<String,Object> capitalMap, HashMap<String,Object> interesMap, HashMap<String,Object> moraMap );
	
}
