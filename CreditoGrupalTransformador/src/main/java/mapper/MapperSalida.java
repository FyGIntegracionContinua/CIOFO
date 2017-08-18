package mapper;


import java.text.SimpleDateFormat;

import utilitario.mensajes.comun.ErrorTransformacion;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.condonaciones.AplicarCondonacionTotalRespuesta;
import utilitario.mensajes.condonaciones.ConsultaDatosRespuesta;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaRespuesta;
import utilitario.mensajes.operacion.pagos.PagoGrupalResponse;
import utilitario.mensajes.originacion.cheques.ClientesChequesRespuesta;
import utilitario.mensajes.originacion.cheques.ContratoChequesSICOV;

/**
 * @author mi.mejorada
 * @version 1.0.0
 */
public interface MapperSalida {


	/**
	 * RESPUESTA_OFS_PASS String
	 */
	static final String RESPUESTA_OFS_PASS				= "1";
	/**
	 * RESPUESTA_OFS_FAIL String
	 */
	static final String RESPUESTA_OFS_FAIL				= "x//-1/NO";
	/**
	 * APLICA_PAGO_ERROR String
	 */
	static final String APLICA_PAGO_ERROR				=	"NO,ERROR:1:1=";

	/**
	 * RESP_ENQUIRY String
	 */
	static final String RESP_ENQUIRY					= ",NOFILE::NOFILE,";
	/**
	 * RESP_QUOTE String
	 */
	static final String RESP_QUOTE						= "\"";
	/**
	 * RESP_VALIDA_FECHA_INICIO String
	 */
	static final String RESP_VALIDA_FECHA_INICIO		= "\"1|error~fechaerror\",";
	/**
	 * RESP_VALIDA_FECHA_INICIO_PASS String
	 */
	static final String RESP_VALIDA_FECHA_INICIO_PASS	= "\"0~\"";
	/**
	 * RESP_VALIDA_FECHA_INICIO_FAIL String
	 */
	static final String RESP_VALIDA_FECHA_INICIO_FAIL	= "\"1~Fecha de desembolso invalida (Dia Festivo)\"";
	/**
	 * RESP_CALCULA_FECHA_FIN String
	 */
	static final String RESP_CALCULA_FECHA_FIN			= "\"1|FechaFin\",";
	/**
	 * RESP_OBTEN_FECHA String
	 */
	static final String RESP_OBTEN_FECHA				= "\"1|FechaHoy~Ambiente\",";
	/**
	 * RESP_OBTEN_FECHA_MSG String
	 */
	static final String RESP_OBTEN_FECHA_MSG			= "~FINANCIER FINSOL(LIVE)";
	/**
	 * RESP_ENQUIRY_OK String
	 */
	static final String RESP_ENQUIRY_OK					= "1|";
	/**
	 * RESP_ENQUIRY_FAIL String
	 */
	static final String RESP_ENQUIRY_FAIL				= "0|";
	/**
	 * RESP_SEPARADOR_FIELD_ENQUIRY String
	 */
	static final String RESP_SEPARADOR_FIELD_ENQUIRY	= "~";
	/**
	 * RESP_SEPARADOR_ENQUIRY_CW String
	 */
	static final String RESP_SEPARADOR_ENQUIRY_CW		= "\t";
	/**
	 * RESP_COMMA String
	 */
	static final String RESP_COMMA						= ",";

	/**
	 * ERROR_APPLICATION String
	 */
	static final String ERROR_APPLICATION				= "APPLICATION MISSING. ";
	/**
	 * ERROR_FIELD String
	 */
	static final String ERROR_FIELD						= "INVALID FIELD.";

	/**
	 * CONDONACION_RESP_PREFIX String
	 */
	static final String CONDONACION_RESP_PREFIX			= ",NOFILE::NOFILE,\"1|Resultado~Mensaje~MensajeT24\",\"";
	/**
	 * CONSULTA_DATOS_RESPUESTA String
	 */
	static final String CONSULTA_DATOS_RESPUESTA
           = ",NOFILE::NOFILE,\"1|Resultado~Mensaje~CapitalPD~InteresPD~PenaltySpread~PenaltyInterest~Recargos\",\"1~~capResult~intResult~0~morResult~morResult\"";
	/**
	 * CONSULTA_DATOS_ERROR_PREFIX String
	 */
	static final String CONSULTA_DATOS_ERROR_PREFIX
	= ",NOFILE::NOFILE,\"1|Resultado~Mensaje~CapitalPD~InteresPD~PenaltySpread~PenaltyInterest~Recargos\",\"-1~";
	/**
	 * ERROR_CONDONACION String
	 */
	static final String ERROR_CONDONACION				= "NO SIGN ON NAME SUPPLIED DURING SIGN ON PROCESS";
	/**
	 * CHEQUES_CREDITO_ENCABEZADO String
	 */
	static final String CHEQUES_CREDITO_ENCABEZADO
    = "ProductoID~Producto~FechaInicio~FechaTermino~SucursalID~Sucursal~AsesorID~Asesor~CuentaSucursal ID~CuentaSucursal~GrupoID~Grupo~CuentaGrupo ID~Fecha~NoMiembros~Fecha1erPago~StatusMora~MontoAprobado~Renovacion~Gerente~SucursalDir~FechaLugar~SucursalEdo~SucursalCd~Empresa~SucursalDirSinAcento~Commision";
	/**
	 * CHEQUES_CLIENTES_ENCABEZADO String
	 */
	static final String CHEQUES_CLIENTES_ENCABEZADO		= "|ClienteID~Cliente~Monto~SaldoVigente~Renovacion~Ciclo~Cycle";
	/**
	 * CHEQUES_WEB_CREDITO_ENCABEZADO String
	 */
	static final String CHEQUES_WEB_CREDITO_ENCABEZADO
	 = ",Y.CATEGORY.ID::Producto ID/Y.CATEGORY.NAME::Producto/Y.VALUE.DATE::Fecha de Inicio/Y.FIN.MAT.DATE::Fecha de Termino/Y.BRANCH.ID::Sucursal ID/Y.BRANCH.NAME::Sucursal/Y.MIS.OFFICER.ID::Asesor ID/Y.MIS.OFFICER.NAME::Asesor/Y.BRANCH.ACCT.ID::Cuenta Sucursal ID/Y.BRANCH.ACCT.NAME::Cuenta Sucursal/Y.GROUP.ID::Grupo ID/Y.GROUP.NAME::Grupo/Y.GROUP.ACCT.ID::Cuenta Grupo ID/Y.TODAY::Fecha/Y.NO.MEMBER.CUS::No de Miembros/Y.INT.START.DT::Fecha 1er Pago/Y.STATUS.MORA::Status Mora/Y.MONTO.APROBADO::Monto Aprobado/Y.RENOVACION::Renovacion/YBRANCH.MGR::Gerente/Y.BRANCH.ADD::SucursalDir/Y.PLACE.DATE::FechaLugar/Y.SUCURSAL.EDO::SucursalEdo/Y.SUCURSAL.CD::SucursalCd/Y.EMPRESA::Empresa/Y.BRANCH.ADD.SIN.A::SucursalDirSinAcento/Y.COMMISION::Commision,";
	/**
	 * CHEQUES_WEB_CLIENTES_ENCABEZADO String
	 */
	static final String CHEQUES_WEB_CLIENTES_ENCABEZADO
	= ",Y.CUSTOMER.ID::Cliente Id/Y.CUSTOMER.NAME::Cliente/Y.AMOUNT::Monto/Y.SALDO.VIGENTE::Saldo Vigente/Y.RENOVACION::Renovacion/Y.TARGET::Ciclo/Y.CYCLE::Cycle/Y.PERTENECE::Pertenece";
	/**
	 * ERROR_KIT_IMPRESION String
	 */
	static final String ERROR_KIT_IMPRESION				= "No se encontraron datos para el LD solicitado";

	/**
	 * SDF_OBTEN_FECHA SimpleDateFormat
	 */
	static final SimpleDateFormat SDF_OBTEN_FECHA		= new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * SDF SimpleDateFormat
	 */
	static final SimpleDateFormat SDF					= new SimpleDateFormat("yyyyMMdd");

	/**
	 * Genera un OFS con mensaje de error
	 * @return String
	 */
	public String generaRespuestaOFSErrorApp( );

	/**
	 * Genera un OFS con mensaje de error
	 * @param message :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaOFSErrorApp( String uid, String message );

	/**
	 * Genera un OFS con mensaje de error respecto a un campo mal formado
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaOFSErrorField( String uid );

	/**
	 * Genera una respuesta OFS dependiendo del ObjetoValor arrojado
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuesta(String uid, ObjetoValor respuesta );

	/**
	 * Genera una respuesta OFS dependiendo del ErrorTransformacion generado
	 * @param error :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaError( String uid,  ErrorTransformacion error );

	/**
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaConsultaDatos( String uid,  ConsultaDatosRespuesta respuesta );

	/**
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaCondonacionParcial(String uid,  AplicarCondonacionTotalRespuesta respuesta);

	/**
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaAplicaPago(String uid,  PagoGrupalResponse respuesta);

	/**
	 * Genera un OFS correspondinete a la respuesta de cheques en General
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaChequesGeneral( String uid,  ContratoChequesSICOV respuesta );

	/**
	 * Genera un OFS correspondiente a la respuesta de informacion general de los cheques web
	 * @param uid :
	 * @param respuesta :
	 * @return String
	 */
	public String generaRespuestaChequesWebGeneral( String uid,  ContratoChequesSICOV respuesta );

	/**
	 * Genera un OFS correspondinete a la respuesta de cheques para cada uno de los clientes
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaChequesClientes( String uid,  ClientesChequesRespuesta respuesta );

	/**
	 * Genera un OFS correspondinete a la respuesta de cheques web para cada uno de los clientes
	 * @param uid :
	 * @param respuesta :
	 * @return String
	 */
	public String generaRespuestaChequesWebClientes( String uid,  ClientesChequesRespuesta respuesta );

	/**
	 * @param respuesta :
	 * @param uid :
	 * @return String
	 */
	public String generaRespuestaKitImpresion(String uid, ImpresionDocsConsultaRespuesta respuesta);

}
