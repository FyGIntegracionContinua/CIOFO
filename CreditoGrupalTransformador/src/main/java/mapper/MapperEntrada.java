package mapper;

import java.text.SimpleDateFormat;
import java.util.Map;

import transformador.TransformadorException;
import utilitario.mensajes.condonaciones.comun.CondonacionOV;
import utilitario.mensajes.operacion.pagos.PagoGrupal;
import utilitario.mensajes.originacion.cheques.ChequesPeticion;
import utilitario.mensajes.originacion.cliente.ClienteOV;
import utilitario.mensajes.originacion.consulta.ConsultaFechaOV;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.originacion.grupo.GrupoOV;

/**
 * @author Juan Carlos Moreno
 * @version 1.0.0
 */
public interface MapperEntrada {

	//Mapeo T24 de informacion CLIENTE
	/**
	 * PERSONA String
	 */
	static final String PERSONA						= "ID";
	/**
	 * PATERNO String
	 */
	static final String PATERNO						= "SHORT.NAME";
	/**
	 * NOMBRE String
	 */
	static final String	NOMBRE 						= "NAME.1";
	/**
	 * MATERNO String
	 */
	static final String	MATERNO 					= "SURNAME.2";
	/**
	 * RFC String
	 */
	static final String	RFC 						= "RFC";
	/**
	 * FECHA_NACIMIENTO String
	 */
	static final String FECHA_NACIMIENTO 			= "BIRTH.INCORP.DATE";
	/**
	 * CORREO String
	 */
	static final String CORREO 						= "MAILING.LIST";
	/**
	 * IFE String
	 */
	static final String IFE							= "LEGAL.ID";
	/**
	 * GENERO String
	 */
	static final String	GENERO 						= "GENDER";
	/**
	 * ESTADO_CIVIL String
	 */
	static final String ESTADO_CIVIL 				= "MARITAL.STATUS";
	/**
	 * TEL_HOME String
	 */
	static final String TEL_HOME 					= "TEL.HOME";
	/**
	 * TEL_CELU String
	 */
	static final String TEL_CELU 					= "TEL.CEL";
	/**
	 * TEL_EMPL String
	 */
	static final String TEL_EMPL 					= "TEL.EMPL";
	/**
	 * ANALISTA String
	 */
	static final String ANALISTA 					= "ACCOUNT.OFFICER";
	/**
	 * ACTIVIDADECONOMICA String
	 */
	static final String ACTIVIDADECONOMICA			= "ACT.ECONOMICA";

	//Mapeo T24 de informacion DIRECCION Cliente / Grupo
	/**
	 * PAIS String
	 */
	static final String PAIS 						= "F.COUNTRY";
	/**
	 * CALLE String
	 */
	static final String CALLE 						= "STREET";
	/**
	 * MUNICIPIO String
	 */
	static final String MUNICIPIO					= "F.MUNICIPALITY";
	/**
	 * CODIGO_COLONIA String
	 */
	static final String CODIGO_COLONIA 				= "NEIGHB.CODE";
	/**
	 * COLONIA String
	 */
	static final String COLONIA 					= "NEIGHB.NAME";
	/**
	 * CP String
	 */
	static final String CP							= "F.POSTAL.CODE";
	/**
	 * ENTIDAD String
	 */
	static final String ENTIDAD 					= "F.STATE";
	/**
	 * LOCALIDAD String
	 */
	static final String LOCALIDAD 					= "F.LOCALITY";

	//Mapeo T24 de la informacion  Grupo
	/**
	 * IDENTIFICADOR String
	 */
	static final String IDENTIFICADOR 				= "ID";
	/**
	 * ID_GRUPO String
	 */
	static final String ID_GRUPO 					= "CUSTOMER.ID";
	/**
	 * NOMBRE_GRUPO String
	 */
	static final String NOMBRE_GRUPO				= "SHORT.NAME";
	/**
	 * PRESIDENTE String
	 */
	static final String PRESIDENTE					= "PRESIDENT";
	/**
	 * TESORERO String
	 */
	static final String TESORERO					= "TREASURER";
	/**
	 * SECRETARIO String
	 */
	static final String SECRETARIO 					= "SECRATORY";
	/**
	 * SUPERVISOR String
	 */
	static final String SUPERVISOR 					= "SUPERVISOR";
	/**
	 * FECHA_CONFORMACION String
	 */
	static final String FECHA_CONFORMACION 			= "OPENING.DATE";

	//Mapeo T24 ed la informacion del Contrato
	/**
	 * ASESOR String
	 */
	static final String ASESOR 						= "MIS.ACCT.OFFICER";
	/**
	 * PRODUCTO String
	 */
	static final String PRODUCTO 					= "CATEGORY";
	/**
	 * MONTO String
	 */
	static final String MONTO 						= "AMOUNT.APPROVED";
	/**
	 * TASA String
	 */
	static final String TASA						= "INT.RATE";
	/**
	 * FRECUENCIA String
	 */
	static final String FRECUENCIA					= "INTEREST.FREQ";
	/**
	 * PLAZO String
	 */
	static final String PLAZO						= "TERM.(WEEKS)";
	/**
	 * MONTO_PAGO String
	 */
	static final String MONTO_PAGO 					= "OUR.INST.AMT";
	/**
	 * HORA_REUNION String
	 */
	static final String HORA_REUNION 				= "HOUR.OF.MEETING";
	/**
	 * DIA_REUNION String
	 */
	static final String DIA_REUNION 				= "DAY.OF.MEETING";
	/**
	 * RENOVACION String
	 */
	static final String RENOVACION					= "RENOVACIONES";
	/**
	 * CONTRATO_ANTERIOR String
	 */
	static final String CONTRATO_ANTERIOR			= "PREVIOUS.LOAN";
	/**
	 * FECHA_LIQUIDACION String
	 */
	static final String FECHA_LIQUIDACION			= "FIN.MAT.DATE";
	/**
	 * FECHA_CONTRATO String
	 */
	static final String FECHA_CONTRATO				= "AGREEMENT.DATE";
	/**
	 * FECHA_DESEMBOLSO String
	 */
	static final String FECHA_DESEMBOLSO  			= "VALUE.DATE";

	//Mapeo T24 de informacion DIRECCION Cliente / Grupo
	/**
	 * CALLE_DOMICILIO String
	 */
	static final String CALLE_DOMICILIO 			= "ADD.OF.MEETING";
	/**
	 * MUNICIPIO_DOMICILIO String
	 */
	static final String MUNICIPIO_DOMICILIO			= "CITY.MUNCIPLITY";
	/**
	 * COLONIA_DOMICILIO String
	 */
	static final String COLONIA_DOMICILIO			= "SUBURB.TOWN";
	/**
	 * ENTIDAD_DOMICILIO String
	 */
	static final String ENTIDAD_DOMICILIO			= "PROVINCE.STATE";
	/**
	 * CP_DOMICILIO String
	 */
	static final String CP_DOMICILIO				= "ZIP-POSTAL.CODE";

	//Mapeo T24 de informacion INTEGRANTE
	/**
	 * INTEGRANTE_CLIENTE String
	 */
	static final String INTEGRANTE_CLIENTE 			= "MEMBER.CUS.ID";
	/**
	 * MONTO_INTEGRANTE String
	 */
	static final String MONTO_INTEGRANTE 			= "MEMBER.LOAN.AMT";
	/**
	 * OBJETIVO_PRESTAMO String
	 */
	static final String OBJETIVO_PRESTAMO			= "PURPOSE.OF.LOAN";
	/**
	 * TIPO_LOCALIDAD String
	 */
	static final String TIPO_LOCALIDAD				= "TIPO.LOCALIDAD";
	/**
	 * MONTO_FINANCIADO String
	 */
	static final String MONTO_FINANCIADO			= "MMBR.CUR.AMT";

	//Mapeo T24 de informacion de consultas tipo Enquiry
	/**
	 * ENQUIRY String
	 */
	static final String ENQUIRY						= "ENQUIRY";
	/**
	 * PARAMETROS String
	 */
	static final String PARAMETROS					= "PARAMETROS";
	/**
	 * FECHA String
	 */
	static final String FECHA						= "FECHA";
	/**
	 * FRECUENCIA_PARAM String
	 */
	static final String FRECUENCIA_PARAM			= "TERMFREQ";
	/**
	 * PLAZO_PARAM String
	 */
	static final String PLAZO_PARAM					= "TERM";
	/**
	 * LD_ID String
	 */
	static final String LD_ID						= "LD.ID";
	/**
	 * CAPITAL String
	 */
	static final String CAPITAL						= "CAPITAL";
	/**
	 * MOTIVO String
	 */
	static final String MOTIVO						= "MOTIVO";
	/**
	 * INTERES String
	 */
	static final String INTERES						= "INTERES";
	/**
	 * RECARGO String
	 */
	static final String RECARGO						= "RECARGO";

	//Mapeo T24 de informacion de importacion de Pagos
	/**
	 * PAGO_MONTO String
	 */
	static final String PAGO_MONTO				= "DEBIT.AMOUNT";
	/**
	 * PAGO_CONTRATO String
	 */
	static final String PAGO_CONTRATO			= "DEBIT.THEIR.REF";
	/**
	 * FECHA_PAGO String
	 */
	static final String FECHA_PAGO		  		= "VALUE.DATE";
	/**
	 * MEDIO_PAGO String
	 */
	static final String MEDIO_PAGO				= "MEDIO.PAGO";

	/**
	 * SUFFIX_KIT_COM_CON String
	 */
	static final String SUFFIX_KIT_COM_CON			= "COM.CON";
	/**
	 * SUFFIX_KIT_COM_REN_CON String
	 */
	static final String SUFFIX_KIT_COM_REN_CON		= "COM.REN.CON";   		//Comunal Financiado - datos del contrato
	/**
	 * SUFFIX_KIT_COM_MEM String
	 */
	static final String SUFFIX_KIT_COM_MEM			= "COM.MEM";
	/**
	 * SUFFIX_KIT_COM_REN_MEM String
	 */
	static final String SUFFIX_KIT_COM_REN_MEM		= "COM.REN.MEM";   		//Comunal Financiado - datos del grupo
	/**
	 * SUFFIX_KIT_COM_SCH String
	 */
	static final String SUFFIX_KIT_COM_SCH			= "COM.SCH";
	/**
	 * SUFFIX_KIT_COM_REN_SCH String
	 */
	static final String SUFFIX_KIT_COM_REN_SCH		= "COM.REN.SCH";   		//Comunal Financiado - datos del pago
	/**
	 * SUFFIX_KIT_COM_REN_MEM_ANT String
	 */
	static final String SUFFIX_KIT_COM_REN_MEM_ANT 	= "COM.REN.ANT.MEM";	//Comunal Financiado - datos contrato anterior

	/**
	 * SUFFIX_KIT_OPO_CON String
	 */
	static final String SUFFIX_KIT_OPO_CON			= "OPO.CON";
	/**
	 * SUFFIX_KIT_OPO_MEM String
	 */
	static final String SUFFIX_KIT_OPO_MEM			= "OPO.MEM";
	/**
	 * SUFFIX_KIT_OPO_SCH String
	 */
	static final String SUFFIX_KIT_OPO_SCH			= "OPO.SCH";
	/**
	 * SUFFIX_KIT_OPO_AVA String
	 */
	static final String SUFFIX_KIT_OPO_AVA			= "OPO.AVA";
	/**
	 * SUFFIX_KIT_SOL_CON String
	 */
	static final String SUFFIX_KIT_SOL_CON			= "SOL.CON";
	/**
	 * SUFFIX_KIT_SOL_REN_CON String
	 */
	static final String SUFFIX_KIT_SOL_REN_CON		= "SOL.REN.CON";		//Solidario Financiado - datos contrato
	/**
	 * SUFFIX_KIT_SOL_MEM String
	 */
	static final String SUFFIX_KIT_SOL_MEM			= "SOL.MEM";
	/**
	 * SUFFIX_KIT_SOL_REN_MEM String
	 */
	static final String SUFFIX_KIT_SOL_REN_MEM		= "SOL.REN.MEM";		//Solidario Financiado - datos miembros
	/**
	 * SUFFIX_KIT_SOL_SCH String
	 */
	static final String SUFFIX_KIT_SOL_SCH			= "SOL.SCH";
	/**
	 * SUFFIX_KIT_SOL_REN_SCH String
	 */
	static final String SUFFIX_KIT_SOL_REN_SCH		= "SOL.REN.SCH";        //Solidario Financiado - datos squema
	/**
	 * SUFFIX_KIT_SOL_REN_MEM_ANT String
	 */
	static final String SUFFIX_KIT_SOL_REN_MEM_ANT  = "SOL.REN.ANT.MEM";
	/**
	 * SUFFIX_KIT_SLIP_REC String
	 */
	static final String SUFFIX_KIT_SLIP_REC			= "SLIP.REC";
	/**
	 * SUFFIX_KIT_SLIP_REC_MAT String
	 */
	static final String SUFFIX_KIT_SLIP_REC_MAT 	= "REC.MAT";
	/**
	 * SUFFIX_KIT_NOTE_COM_AVA String
	 */
	static final String SUFFIX_KIT_NOTE_COM_AVA 	= "NOTE.COM.AVA";
	/**
	 * SUFFIX_KIT_NOTE_COM_MEM String
	 */
	static final String SUFFIX_KIT_NOTE_COM_MEM		= "NOTE.COM.MEM";
	/**
	 * SUFFIX_KIT_NOTE_COM_SCH String
	 */
	static final String SUFFIX_KIT_NOTE_COM_SCH		= "NOTE.COM.SCH";
	/**
	 * SUFFIX_KIT_NOTE_OPO_AVA String
	 */
	static final String SUFFIX_KIT_NOTE_OPO_AVA 	= "NOTE.OPO.AVA";
	/**
	 * SUFFIX_KIT_NOTE_OPO_MEM String
	 */
	static final String SUFFIX_KIT_NOTE_OPO_MEM 	= "NOTE.OPO.MEM";
	/**
	 * SUFFIX_KIT_NOTE_OPO_SCH String
	 */
	static final String SUFFIX_KIT_NOTE_OPO_SCH		= "NOTE.OPO.SCH";
	/**
	 * SUFFIX_KIT_NOTE_SOL_AVA String
	 */
	static final String SUFFIX_KIT_NOTE_SOL_AVA		= "NOTE.SOL.AVA";
	/**
	 * SUFFIX_KIT_NOTE_SOL_MEM String
	 */
	static final String SUFFIX_KIT_NOTE_SOL_MEM		= "NOTE.SOL.MEM";
	/**
	 * SUFFIX_KIT_NOTE_SOL_SCH String
	 */
	static final String SUFFIX_KIT_NOTE_SOL_SCH		= "NOTE.SOL.SCH";

	/**
	 * PREFIJO_SUCURSAL String
	 */
	static final String PREFIJO_SUCURSAL			= "12";
	/**
	 * SUCURSAL_DEFAULT int
	 */
	static final int 	SUCURSAL_DEFAULT			= 0;
	/**
	 * SDF SimpleDateFormat
	 */
	static final SimpleDateFormat SDF				= new SimpleDateFormat("yyyyMMdd");


	/**
	 * Procesa el mapa y genera un Objeto java con los valores del Cliente ya formateados segun corresponda
	 * @param  mapCliente :
	 * @param uid :
	 * @return ClienteOV
	 * @throws TransformadorException
	 */
	ClienteOV mapearCliente( String uid, Map <String, String> mapCliente );

	/**
	 * Procesa el mapa y genera un Objeto java con los valores del Grupo ya formateados segun corresponda
	 * @param mapGrupo mapGrupo
	 * @param uid :
	 * @return GrupoOV
	 * @throws TransformadorException
	 */
	GrupoOV mapearGrupo( String uid, Map<String, ?> mapGrupo  );

	/**
	 * Procesa el mapa y genera un Objeto java con los valores del Contrato ya formateados segun corresponda
	 * @param  mapContrato Map <String,?> mapContrato
	 * @param uid :
	 * @return ContratoOV
	 * @throws TransformadorException
	 */
	ContratoOV mapearContrato( String uid, Map <String, ?> mapContrato );

	/**
	 * Procesa el mapa y genera un Objeto java con los valores de la consulta de la fecha ya formateados segun corresponda
	 * @param mapPeticion Map <String, String> mapPeticion
	 * @param uid :
	 * @return ConsultaFechaOV
	 * @throws TransformadorException
	 */
	ConsultaFechaOV mapearValidaFechaInicio(String uid, Map <String, String> mapPeticion );

	/**
	 * Procesa el mapa y genera un Objeto java con los valores de la consulta de la fecha ya formateados segun corresponda
	 * @param mapPeticion Map <String, String> mapPeticion
	 * @param uid :
	 * @return ConsultaFechaOV
	 * @throws TransformadorException
	 */
	ConsultaFechaOV mapearCalculaFechaFin(String uid, Map <String, String> mapPeticion );

	/**
	 * Procesa el mapa y genera un Objeto java con los valores de la consulta de la fecha ya formateados segun corresponda
	 * @param mapPeticion Map <String, String> mapPeticion
	 * @param uid :
	 * @return ConsultaFechaOV
	 * @throws TransformadorException
	 */
	ConsultaFechaOV mapearObtenerFecha( String uid, Map <String, String> mapPeticion );

	/**
	 * @param mapPeticion :
	 * @param uid :
	 * @return String
	 * @throws TransformadorException
	 */
	String mapearConsultaDatos(String uid, Map<String, String> mapPeticion );

	/**
	 * @param mapPeticion Map<String, String> mapPeticion
	 * @param uid :
	 * @return CondonacionOV
	 * @throws TransformadorException
	 */
	CondonacionOV mapearCondonacionParcial(String uid, Map<String, String> mapPeticion );

	/**
	 * @param mapPeticion Map<String, String>
	 * @param uid :
	 * @return PagoGrupal
	 * @throws TransformadorException
	 */
	PagoGrupal mapearAplicaPago(String uid, Map<String, String> mapPeticion );

	/**
	 * Adapta el mapper Key Value, hacia el objeto java necesario para realizar una peticion de Cheques SIC
	 * @param mapPeticion Map<String, String> mapPeticion
	 * @param uid :
	 * @return String
	 * @throws TransformadorException
	 */
	ChequesPeticion mapearChequesSICPeticion(String uid, Map<String, String> mapPeticion );

	//ChequesPeticion mapearChequesWebPeticion (String uid, Map<String, String> mapPeticion ) throws TransformadorException;

	/**
	 * Adapta el mapper Key Value, hacia el objeto java necesario para realizar una peticion de Kit de Impresion
	 * @param mapPeticion Map<String, String>
	 * @param uid :
	 * @return String[]
	 * @throws TransformadorException
	 */
	String[] mapearKitImpresionPeticion(String uid, Map<String, String> mapPeticion );
}
