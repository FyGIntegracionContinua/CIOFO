/**
 *
 */
package utilitario.comun;

/**
 * The Interface Constantes.
 *
 * @author out_ltorres
 * @version 1.0.0
 */
public interface Constantes {

	/** The Constant ERROR_CONSULTA. */
	static final String ERROR_CONSULTA 					= "SE HA PRODUCIDO UN ERROR DURANTE LA CONSULTA";

	/** The Constant ERROR_ACTUALIZACION. */
	static final String ERROR_ACTUALIZACION				= "SE HA PRODUCIDO UN ERROR DURANTE LA ACTUALIZACION";

	/** The Constant ERROR_INSERCION. */
	static final String ERROR_INSERCION					= "SE HA PRODUCIDO UN ERROR DURANTE LA INSERCION";

	/** The Constant OK_INSERCION. */
	static final String OK_INSERCION					= "LA INSERCION SE REALIZO CORRECTAMENTE";

	/** The Constant CODIGO_IVA. */
	static final String CODIGO_IVA						= "IVIN";

	/** The Constant CONTRATO_INVALIDO. */
	static final String CONTRATO_INVALIDO 	= "NO SE HAN ENCONTRADO DATOS PARA ESTE NUMERO DE CONTRATO";

	/** The Constant INTEGRANTES_MINIMOS_AVAL. */
	static final int 	INTEGRANTES_MINIMOS_AVAL    	= 3;

	/** The Constant MUJER. */
	static final String MUJER							= "F";

	/** The Constant HOMBRE. */
	static final String HOMBRE							= "H";

	/** The Constant CASADO. */
	static final String CASADO							= "C";

	/** The Constant SOLTERO. */
	static final String SOLTERO							= "S";

	/** The Constant VIUDO. */
	static final String VIUDO 							= "V";

	/** The Constant DIVORCIADO. */
	static final String DIVORCIADO						= "D";

	/** The Constant UNION_LIBRE. */
	static final String UNION_LIBRE						= "U";

	/** The Constant CUENTA_BANCO. */
	static final String CUENTA_BANCO =
	"cuenta n�mero 165-7840897 de Banco Nacional de M�xico, S.A. (BANAMEX); cuenta n�mero 674133 de BBVA Bancomer S.A.";

	/** The Constant EMPRESA_FINSOL. */
	static final String EMPRESA_FINSOL = "Financiera Finsol S.A. de C.V., Sociedad Financiera de Objeto M�ltiple, Entidad No "
	+ "Regulada";

	/** The Constant OPER_VER_VALOR_HISTORICO. */
	static final String OPER_VER_VALOR_HISTORICO 		= "verValorHistorico";

	/** The Constant CONTRATO_SOLIDARIO_CAT. */
	static final String CONTRATO_SOLIDARIO_CAT     		= "SOLN";

	/** The Constant ID_TESORERO. */
	static final String ID_TESORERO 					= "TESO";

	/** The Constant ID_PRESIDENTE. */
	static final String ID_PRESIDENTE 					= "PRES";

	/** The Constant ID_SECRETARIO. */
	static final String ID_SECRETARIO 					= "SECR";

	/** The Constant ID_SUPERVISOR. */
	static final String ID_SUPERVISOR					= "SUPE";

	/** The Constant CAMPO_CADENA_VACIA. */
	static final int 	CAMPO_CADENA_VACIA 				= 0;

	/** The Constant FECHA_INVALIDA. */
	static final String FECHA_INVALIDA 					= "LA FECHA ESTA INCORRECTA";

	/** The Constant CONSULTA_SINREGISTROS. */
	static final String CONSULTA_SINREGISTROS 			= "NO SE HAN ENCONTRADO DATOS PARA ESTA CONSULTA";

	/** The Constant INSERCION_SINREGISTROS. */
	static final String INSERCION_SINREGISTROS 			= "NO SE HA INSERTADO NINGUN REGISTRO";

	/** The Constant DATOS_REQUERIDOS. */
	static final String DATOS_REQUERIDOS	 			=
		"DATOS REQUERIDOS, NO SE PUEDE REALIZAR CONSULTA. FALTA EL VALOR DE: ";

	/** The Constant RFC_INVALIDO. */
	static final String RFC_INVALIDO	 			=   	"RFC INVALIDO (MIN 10 CARACTERES) O NULO ";

	/** The Constant RFC_INVALIDO. */
	static final String CURP_INVALIDO	 			=		"CURP INVALIDO O NULO ";

	/** The Constant CURP_INVALIDO_ESTADO. */
	static final String CURP_INVALIDO_ESTADO	 			=		"ESTADO FED NO EXISTE ";

	/** The Constant CURP_INVALIDO_ESTADO_NO_COINCIDE. */
	static final String CURP_INVALIDO_ESTADO_NO_COINCIDE	=		"ESTADO NO COINCIDE CON EL CURP ";

	/** The Constant CURP_INVALIDO_SEXO. */
	static final String CURP_INVALIDO_SEXO	 			=		"SEXO NO EXISTE ";

	/** The Constant CURP_INVALIDO_SEXO_NO_COINCIDE. */
	static final String CURP_INVALIDO_SEXO_NO_COINCIDE	=		"EL SEXO NO COINCIDE CON EL CURP ";

	/** The Constant RFC_CURP_DISTINTOS. */
	static final String RFC_CURP_DISTINTOS	 			=		"EL RFC DIFIERE DEL CURP ";

	/** The Constant DATOS_INCORRECTOS. */
	static final String DATOS_INCORRECTOS	 			= "DATOS INCORRECTOS, NO SE PUEDE REALIZAR CONSULTA";

	/** The Constant CONSULTA_SIN_REGISTROS. */
	static final String CONSULTA_SIN_REGISTROS	 		= "LA CONSULTA NO REGRESO DATOS";

	/** The Constant CLIENTE_INEXISTENTE. */
	static final String CLIENTE_INEXISTENTE	 		= "No se encontro al cliente";

	/** The Constant SOLICITUD_CANCELADA. */
	static final String SOLICITUD_CANCELADA		 		= "LA SOLICITUD HA SIDO CANCELADA";

	/** The Constant SOLICITUD_ELIMINADA. */
	static final String SOLICITUD_ELIMINADA		 		= "LA SOLICITUD HA SIDO ELIMINADA";

	/** The Constant SOLICITUD_GUARDADA. */
	static final String SOLICITUD_GUARDADA		 		= "LA SOLICITUD HA SIDO GUARDADA CORRECTAMENTE";

	/** The Constant SOLICITUD_ACTUALIZADA. */
	static final String SOLICITUD_ACTUALIZADA		 	= "LA SOLICITUD HA SIDO ACTUALIZADA CORRECTAMENTE";

	/** The Constant SOLICITUD_CATEGORIA_ORDINARIA. */
	static final String	SOLICITUD_CATEGORIA_ORDINARIA	= "ORD";

	/** The Constant SOLICITUD_CATEGORIA_FINANCIADA. */
	static final String	SOLICITUD_CATEGORIA_FINANCIADA	= "FIN";

	/** The Constant SOLICITUD_NO_ENCONTRADA. */
	static final String	SOLICITUD_NO_ENCONTRADA			= "NO SE ENCONTRO SOLICITUD";

	/** The Constant SOLICITUD_ESTATUS_NO_VALIDO. */
	static final String SOLICITUD_ESTATUS_NO_VALIDO		= "ESTATUS SOLICITADO NO ES VALIDO";

	/** The Constant SOLICITUD_ESTATUS_AUTORIZADO. */
	static final String SOLICITUD_ESTATUS_AUTORIZADO	= "AUTORIZADO";

	/** The Constant SOLICITUD_ESTATUS_REVISION. */
	static final String SOLICITUD_ESTATUS_REVISION		= "REVISION";

	/** The Constant SOLICITUD_ESTATUS_CAPTURA. */
	static final String SOLICITUD_ESTATUS_CAPTURA		= "CAPTURA";

	/** The Constant SOLICITUD_ESTATUS_TODOS. */
	static final String SOLICITUD_ESTATUS_TODOS			= "%";

	/** The Constant SOLICITUD_SUCURSAL_NO_VALIDA. */
	static final String SOLICITUD_SUCURSAL_NO_VALIDA	= "SUCURSAL SOLICITADA NO ES VALIDA";


	/** The Constant SOLICITUD_STATUS_APROBADO. */
	static final String SOLICITUD_STATUS_APROBADO		= "A";

	/** The Constant SOLICITUD_STATUS_ERRONEA. */
	static final String SOLICITUD_STATUS_ERRONEA		= "E";

	/** The Constant SOLICITUD_STATUS_ENPROCESO. */
	static final String SOLICITUD_STATUS_ENPROCESO		= "P";

	/** The Constant SOLICITUD_STATUS_RECHAZADO. */
	static final String SOLICITUD_STATUS_RECHAZADO		= "R";

	/** The Constant SOLICITUD_STATUS_CANCELADO. */
	static final String SOLICITUD_STATUS_CANCELADO		= "X";

	/** The Constant SOLICITUD_STATUS_VENCIDO. */
	static final String SOLICITUD_STATUS_VENCIDO		= "V";

	/** The Constant INTEGRANTE_ERROR_NUMERO. */
	static final String INTEGRANTE_ERROR_NUMERO			= "NO SE PUDO OBTENER NUMERO DE INTEGRANTE";

	/** The Constant INTEGRANTE_STATUS_ACTIVO. */
	static final String INTEGRANTE_STATUS_ACTIVO 		= "A";

	/** The Constant INTEGRANTE_STATUS_RECHAZADO. */
	static final String INTEGRANTE_STATUS_RECHAZADO		= "R";

	/** The Constant INTEGRANTE_STATUS_CANCELADO. */
	static final String INTEGRANTE_STATUS_CANCELADO 	= "X";

	/** The Constant INTEGRANTE_TDISP_EFECTIVO. */
	static final String INTEGRANTE_TDISP_EFECTIVO		= "E";

	/** The Constant INTEGRANTE_TDISP_CHEQUE. */
	static final String INTEGRANTE_TDISP_CHEQUE			= "C";

	/** The Constant INTEGRANTE_TDISP_ORDENPAGO. */
	static final String INTEGRANTE_TDISP_ORDENPAGO		= "O";

	/** The Constant INTEGRANTE_TDISP_TRANSFERENCIA. */
	static final String INTEGRANTE_TDISP_TRANSFERENCIA	= "T";

	/** The Constant INTEGRANTE_TDISP_VALE. */
	static final String INTEGRANTE_TDISP_VALE			= "V";

	/** The Constant INTEGRANTE_INSERT_DUPLICIDAD_E. */
	static final String INTEGRANTE_INSERT_DUPLICIDAD_E	=
		"INTEGRANTE YA HABIA SIDO ELIMINADO DE LA SOLICITUD, NO SE PUEDE DAR DE ALTA NUEVAMENTE";

	/** The Constant INTEGRANTE_INSERT_DUPLICIDAD. */
	static final String INTEGRANTE_INSERT_DUPLICIDAD	=
		"INTEGRANTE YA HABIA SIDO AGREGADO A LA SOLICITUD, NO SE PUEDE DAR DE ALTA NUEVAMENTE";

	/** The Constant DIAS_ANIO. */
	static final int DIAS_ANIO	= 365;
	/** The Constant DIAS_ANIO_BI. */
	static final int DIAS_ANIO_BI	= 366;
	/** The Constant DIAS_SEMANA. */
	static final int DIAS_SEMANA	= 7;
	/** The Constant DIAS_CATORCENA. */
	static final int DIAS_CATORCENA	= 14;
	/** The Constant DIAS_CATORCENA. */
	static final int DIAS_MES	= 30;
	/** The Constant SEMANAS_ANIO. */
	static final int SEMANAS_ANIO	= 52;
	/** The Constant CATORCENAS_ANIO. */
	static final int CATORCENAS_ANIO	= 26;
	/** The Constant MAXIMO_DIAS_SEMANA. */
	static final int MESES_ANIO	= 12;
	/** The Constant CENTENA. */
	static final int CENTENA	= 100;
	/** The Constant DIEZ. */
	static final int DIEZ	= 10;
	/** The Constant CENTENA DOUBLE. */
	static final double CENTENA_DOUBLE	= 100.0;
	/** The Constant MIL DOUBLE. */
	static final double MIL	= 1000.0;
	/** The Constant QUINIENTOS DOUBLE. */
	static final double QUINIENTOS	= 500.0;
	/** The Constant USUARIO_SISTEMA. */
	static final String USUARIO_SISTEMA	= "000000043";
	/** The Constant PRODUCTO_DG_SEMANAL. */
	static final String  PRODUCTO_DG_SEMANAL = "GCDG";
	/** The Constant PRODUCTO_DG_CATORCENAL. */
	static final String PRODUCTO_DG_CATORCENAL = "GCDC";
	/** The Constant ATOMO_EXCEPCION_GARANTIA. */
	static final String ATOMO_EXCEPCION_GARANTIA = "EXCEPCION_GARANTIA";
	/** The Constant ATOMO_EXCEPCION_GARANTIA_OK. */
	static final String ATOMO_EXCEPCION_GARANTIA_OK = "APROBADA";
	/** The Constant ATOMO_EXCEPCION_GARANTIA_RECHAZO. */
	static final String ATOMO_EXCEPCION_GARANTIA_RECHAZO = "RECHAZADA";
	/** The Constant ATOMO_EXCEPCION_GARANTIA_RECHAZO. */
	static final String ATOMO_EXCEPCION_GARANTIA_INICIO = "REVISION";
	/**contante para saber que atomo de que tarea se crea*/
	static final String ATOMO_EXCEPCION_CUPO_MONTO = "EXCEPCION_CUPO_MONTO";
	/**contante para saber que atomo de que tarea se crea*/
	static final String ATOMO_FIRMA_ELECTRONICA = "FIRMA_ELECTRONICA";
	/**contante para saber que atomo de que tarea se crea*/
	static final String ATOMO_CR_FIRMA_ELECTRONICA_PETICION = "ENVIADO_CEC";
	/**contante para saber que atomo de que tarea se crea*/
	static final String ATOMO_CR_FIRMA_ELECTRONICA_OK = "APROBADA";
	/**contante para saber que atomo de que tarea se crea*/
	static final String ATOMO_CR_FIRMA_ELECTRONICA_RECHAZO = "RECHAZADA";

	/*************  Integrantes de la mesa directiva **********************/
	/** siglas siglas presidente de la mesa directiva.(comunal) */
	static final String PRES = "PRESIDENTA";
	/**siglas secretario de la mesa directiva.(comunal) */
	static final String SECR = "SECRETARIA";
	/** siglas tesorero de la mesa directiva.(comunal) */
	static final String TESO = "TESORERA";
	/** siglas supervisor o coordinador de la mesa directiva.(solidario) */
	static final String SUPE = "COORDINADOR";

	/********************BURO DE CREDITO**************************************/
	/**validar dias atraso de un contrato*/
	int DIAS_ATRASO = 60;
	/**dias mora en renovaciones para buro*/
	int DIAS_MORA_BURO = 7;
	/**minimo de integrantes para un ciclo 0*/
	int INTEGRANTE_CICLO_UNO = 8;
	/** minimo de intregrantes para un ciclo 1*/
	int INTEGRANTE_CICLO_DOS = 7;
	/** minimo integrantes renovacionvnes especiales campaña 5*/
	int INTEGRANTE_CICLO_ESPECIAL = 3;
	/** CREDITO HIPOTECARIO*/
	String HIPOTECARIO = "RE";
	/** CREDITO AUTOMOTRIZ*/
	String AUTOMOTRIZ = "AU";
	/**Sin campa&ntilde;a*/
	String SIN_CAMPANA = "CE00";

	/********************VALIDACIONES ADICIONALES ORIGINACION********************/
	/** ciclo uno*/
	int CICLO_UNO = 1;
	/**ciclo en el que se deja de validar el 50 % de integrantes que renuevan*/
	int CICLO_CUATRO = 4;
	/** ciclo tres*/
	int CICLO_TRES = 3;
	/**Campa&ntilde;a 2*/
	String CAMPANA_DOS = "CE02";

	/******************** perfiles **************************************/
	/** Subdirector comercial */
	String PUESTO_SUBCOMERCIAL = "200";
	/** Divisional */
	String PUESTO_DIVISIONAL = "100";
	/** Regional */
	String PUESTO_REGIONAL = "10";
	/** Riesgos*/
	String PUESTO_RIESGOS = "46,47";

	/*****************************tipos de Excepcion CAMPANA*******************/
	/**Tipo de tarea de campaña*/
	String TIPO_TAREA_CAMPANA_EXCEPTION = "TRCE";
	/**tipo de tarea cando es por cupo*/
	String TIPO_TAREA_CUPO = "CUPO";
	/**tipo d etarea cuando es por monto*/
	String TIPO_TAREA_MONTO = "MNTO";
	/**tipo de tarea cuando es por monto y cupo*/
	String TIPO_TAREA_CUPO_MONTO = "CUMO";

	/**********PEFILES A LOS QUE SE LES ENVIA EL CORREO ************************/
	/**Correo del divisional*/
	String CORREO_DIVISIONAL = "DIVISIONAL";
	/**Correo del regional*/
	String CORREO_REGIONAL = "REGIONAL";
	/**Correo del gerente de riesgo*/
	String CORREO_RIESGO = "RIESGO";
	/**Correo se notificaciones de sacg*/
	String CORREO_NOTIFICACIONES_SACG = "notificaciones_sacg@finsol.com.mx";
	/**Password del correo de notificacione sde sacg*/
	String PASSWORD_NOTIFICACIONES_SACG = "Julio2016*.*";
	/**limite del estatus*/
	int LIMITE_STATUS = 4;

	/**********PEFILES A LOS QUE SE LES ENVIA EL CORREO PARA EL ESCALAMIENTO ************************/
	/**Correo del divisional*/
	String DIVISIONAL = "DIVISIONAL";
	/**Correo del regional*/
	String REGIONAL = "REGIONAL";
	/**Correo del subdirector*/
	String SUBDIRECTOR = "SUBDIRECTOR";

	/***************codigos de campaña ********************************/
	/**Campa&ntilde;a 1*/
	String CAMPANA_UNO = "CE01";
	/**Campa&ntilde;a 5*/
	String CAMPANA_CINCO = "CE05";

	/**********************TIPOS DE TAREA************/
	/**TAREA DEL DOCUMENTAL*/
	String TAREA_DOCUMENTAL = "TRED";
	/**TAREA DE CUPO Y MONTO*/
	String TAREA_CUPO_MONTO = "TRCE";
	/**TAREA DE FIRMA ELECTRONICA*/
	String TAREA_FIRMA_ELECTRONICA = "TFIE";

	/***************************perfiles *********************/
	String PERFIL_CEC = "PCEC";

	/*************************Repeticiones *******************/
	/**numero d eveces que se repiten los ciclos del contrato*/
	int REPETIR_CONTRATOS = 3;

	/****************Firma electronica intervalos de tiempo***/
	/**intervalo inicial*/
	 int INTERVALO_INICIAL = 8;
	 /**intervalo final*/
	 int INTERVALO_FINAL = 20;
	 /**tiempo de espera*/
	 int HORA_ESPERA = 6;
	 /**HORAS DE DESCUENTO*/
	 int DESCUENTO_HORA = 12;
}
