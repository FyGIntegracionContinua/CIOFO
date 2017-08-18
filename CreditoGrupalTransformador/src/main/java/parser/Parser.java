package parser;


import java.util.Map;

import transformador.TransformadorException;

/**
 * @author mi.mejorada
 * @version 1.0.0
 */
public interface Parser {

	/**
	 * POS_OFS_UNICO int
	 */
	static final int POS_OFS_UNICO			= 1;
	/**
	 * POS_OFS_ID int
	 */
	static final int POS_OFS_ID				= 3;
	/**
	 * POS_ENQ_UNICO int
	 */
	static final int POS_ENQ_UNICO			= 4;

	/**
	 * OFS_ALTA_I String
	 */
	static final String OFS_ALTA_I			= "OFS.ALTA/I";
	/**
	 * OFS_CAMBIO_I String
	 */
	static final String OFS_CAMBIO_I		= "OFS.CAMBIO/I";
	/**
	 * OFS_ALTA_GRUPO_I String
	 */
	static final String OFS_ALTA_GRUPO_I	= "OFS.ALTA.GRUPO/I";
	/**
	 * OFS_CAMBIO_GRUPO_I String
	 */
	static final String OFS_CAMBIO_GRUPO_I	= "OFS.CAMBIO.GRUPO/I";
	/**
	 * OFS_CAPTURA_I String
	 */
	static final String OFS_CAPTURA_I		= "OFS.CAPTURA/I";
	/**
	 * OFS_APLICA_PAGO String
	 */
	static final String OFS_APLICA_PAGO		= "RPM.DDS";
	/**
	 * OFS_I String
	 */
	static final String OFS_I				= "OFS/I";

	/**
	 * E_VALIDA_VALUE_DATE String
	 */
	static final String E_VALIDA_VALUE_DATE		= "E.VALIDA.VALUE.DATE";
	/**
	 * E_CAL_FIN_MATE_DATE String
	 */
	static final String E_CAL_FIN_MATE_DATE		= "E.CAL.FIN.MATE.DATE";
	/**
	 * E_GET_FECHAT String
	 */
	static final String E_GET_FECHAT			= "E.GET.FECHAT";
	/**
	 * E_CONSULTA_PD String
	 */
	static final String E_CONSULTA_PD 			= "E.CONSULTA.PD";
	/**
	 * E_CONDONACION_PARCIAL String
	 */
	static final String E_CONDONACION_PARCIAL 	= "E.CONDONACION.PARCIAL";
	/**
	 * E_INFO_CHEQUES_GRAL String
	 */
	static final String E_INFO_CHEQUES_GRAL 	= "E.INFO.CHEQUES.GRAL";
	/**
	 * E_INFO_CHEQUES_CLIENTES String
	 */
	static final String E_INFO_CHEQUES_CLIENTES = "E.INFO.CHEQUES.CLIENTES";
	/**
	 * E_FIN_CONTRACT String
	 */
	static final String E_FIN_CONTRACT			= "E.FIN.CONTRACT"; //Prefijo Kit Impresion
	/**
	 * E_FIN_PROMISE_NOTE String
	 */
	static final String E_FIN_PROMISE_NOTE		= "E.FIN.PROMISE.NOTE"; //Prefijo Kit Impresion
	/**
	 * E_FIN_PAYMENT String
	 */
	static final String E_FIN_PAYMENT			= "E.FIN.PAYMENT"; //Prefijo Kit Impresion

	/**
	 * E_WEB_CHEQUES_GRAL String
	 */
	static final String E_WEB_CHEQUES_GRAL		= "E.CLIENTES.GRAL.CHEQUES";  //Información cheques web
	/**
	 * E_WEB_CHEQUES_INFO String
	 */
	static final String E_WEB_CHEQUES_INFO		= "E.CLIENTES.INFO.CHEQUES";  //Información clientes cheques web

	/**
	 * SUFFIX_CAMPO String
	 */
	static final String SUFFIX_CAMPO 		= "::";
	/**
	 * SUFFIX_EQ_CAMPO String
	 */
	static final String SUFFIX_EQ_CAMPO		= ":EQ";
	/**
	 * SUFFIX_VALOR String
	 */
	static final String SUFFIX_VALOR 		= ":";
	/**
	 * SUFFIX_PARAMETROS String
	 */
	static final String SUFFIX_PARAMETROS	= "|";
	/**
	 * REGEX_OFS String
	 */
	static final String REGEX_OFS 			= ",";
	/**
	 * REGEX_ENQUIRY String
	 */
	static final String REGEX_ENQUIRY		= "~EQ~";
	/**
	 * REGEX_SUBOFS String
	 */
	static final String REGEX_SUBOFS 		= "=";
	/**
	 * SEPARATOR_OFS String
	 */
	static final String SEPARATOR_OFS 		= "//";

	/**
	 * TABLA String
	 */
	static final String TABLA 				= "TABLA";
	/**
	 * VERSION_FUNC String
	 */
	static final String VERSION_FUNC 		= "VERSION/FUNC";
	/**
	 * USUARIO_PASSWORD String
	 */
	static final String USUARIO_PASSWORD 	= "USUARIO/PASSWORD";
	/**
	 * ID String
	 */
	static final String ID 					= "ID";

 	/**
 	 * grupoMultivalor String[]
 	 */
 	static final String []grupoMultivalor	= {"RELATION.CODE", "REL.CUSTOMER", "REVERS.REL.CODE"};
 	/**
 	 * creditoMultiValor String[]
 	 */
 	static final String []creditoMultiValor	= {"SOURCE.FUND.MEM", "MEMBER.CUS.ID",
 											   "MEMBER.LOAN.AMT", "PURPOSE.OF.LOAN", "TIPO.LOCALIDAD"};
 	/**
 	 * creditoFMultivalor String[]
 	 */
 	static final String []creditoFMultivalor = {"MMBR.CUS.ID", "MMBR.LOAN.AMT", "PRPS.OF.LOAN", "MMBR.NEW.AMT",
 											   "MMBR.CUR.AMT", "SRC.FUND.MEM"};

 	/**
 	 * NO_VERSION_FUNCION int
 	 */
 	static final int NO_VERSION_FUNCION		= 0;
 	/**
 	 * MAX_OPERACIONES_OFS int
 	 */
 	static final int MAX_OPERACIONES_OFS	= 1000;
 	/**
 	 * ALTA_CLIENTE int
 	 */
 	static final int ALTA_CLIENTE			= 1;
 	/**
 	 * MODIFICACION_CLIENTE int
 	 */
 	static final int MODIFICACION_CLIENTE	= 2;
 	/**
 	 * ALTA_GRUPO int
 	 */
 	static final int ALTA_GRUPO				= 3;
 	/**
 	 * MODIFICACION_GRUPO int
 	 */
 	static final int MODIFICACION_GRUPO		= 4;
 	/**
 	 * ALTA_CREDITO int
 	 */
 	static final int ALTA_CREDITO			= 5;
 	/**
 	 * APLICA_PAGO int
 	 */
 	static final int APLICA_PAGO			= 6;
 	/**
 	 * ALTA_CLIENTE_UNICO int
 	 */
 	static final int ALTA_CLIENTE_UNICO		= 7;

 	/**
 	 * VALIDA_FECHA_INICIO int
 	 */
 	static final int VALIDA_FECHA_INICIO	= 1001; //Se suma 1000 a cadenas que son ENQUIRYS no OFS
 	/**
 	 * CALCULA_FECHA_FIN int
 	 */
 	static final int CALCULA_FECHA_FIN		= 1002; //Se suma 1000 a cadenas que son ENQUIRYS no OFS
 	/**
 	 * OBTEN_FECHA int
 	 */
 	static final int OBTEN_FECHA			= 1003; //Se suma 1000 a cadenas que son ENQUIRYS no OFS
 	/**
 	 * CONSULTA_PD int
 	 */
 	static final int CONSULTA_PD			= 1004;
 	/**
 	 * CONDONACION_PARCIAL int
 	 */
 	static final int CONDONACION_PARCIAL	= 1005;
 	/**
 	 * INFO_CHEQUES_GRAL int
 	 */
 	static final int INFO_CHEQUES_GRAL		= 1006;
 	/**
 	 * INFO_CHEQUES_CLIENTES int
 	 */
 	static final int INFO_CHEQUES_CLIENTES	= 1007;
 	/**
 	 * KIT_FIN_CONTRACT int
 	 */
 	static final int KIT_FIN_CONTRACT		= 1008;
 	/**
 	 * KIT_FIN_PROMISE_NOTE int
 	 */
 	static final int KIT_FIN_PROMISE_NOTE	= 1009;
 	/**
 	 * KIT_FIN_PAYMENT int
 	 */
 	static final int KIT_FIN_PAYMENT		= 1010;
 	/**
 	 * KIT_FIN_SLIP_REC_MAT int
 	 */
 	static final int KIT_FIN_SLIP_REC_MAT   = 1011;
 	/**
 	 * WEB_CHEQUES_GRAL int
 	 */
 	static final int WEB_CHEQUES_GRAL   	= 1012;	//Cheques web, información general
 	/**
 	 * WEB_CHEQUES_CLIENTES int
 	 */
 	static final int WEB_CHEQUES_CLIENTES	= 1013; //Cheques web, información clientes
 	/**
 	 * PETICION_OFS String
 	 */
 	static final String PETICION_OFS		= "PETICION_OFS";

 	/**
 	 * Funcion que obtiene el tipo de Version/Funcion correspondiente a cada tipo de cadena JQL
 	 * @param uid :
 	 * @param peticion :
 	 * @return int
 	 */
	public int obtenTipoVersionFuncion(String uid, String peticion );

	/**
	 * Funcion que a taves de una cadena JQL tipo OFS de peticion y un tipo en especifico regresa un Mapa Key Value con los
	 * valores parseados
	 * @param peticion :
	 * @param tipoVersionFuncion :
	 * @return Map
	 * @throws TransformadorException
	 */
	public Map<String, ?> parsearPeticion( String peticion, int tipoVersionFuncion );

	/**
	 * Funcion que a taves de una cadena JQL tipo ENQUIRY de peticion y un tipo en especifico regresa un Mapa Key Value con los
	 * valores parseados
	 * @param peticion :
	 * @return Map
	 * @throws TransformadorException
	 */
	public Map<String, String> parsearPeticionParamsEnquiry( String peticion );
}
