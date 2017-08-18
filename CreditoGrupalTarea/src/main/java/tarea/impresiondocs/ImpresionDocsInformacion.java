package tarea.impresiondocs;

import utilitario.mensajes.impresiondocs.ImpresionDocsConsulta;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoFinsolRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;
import utilitario.mensajes.impresiondocs.comun.FichaEspecialPeticion;
import utilitario.mensajes.impresiondocs.comun.FichaEspecialRespuesta;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudPeticion;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ContratoComunalKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ContratoPagareKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ConvenioReestructuraKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.KitImpresionPagareRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.PagareReestructuraKitRespuesta;
import utilitario.mensajes.impresiondocs.fichapago.FichaPagoPeticion;
import utilitario.mensajes.impresiondocs.fichapago.FichaPagoRespuesta;
import utilitario.mensajes.impresiondocs.fichapagoespecial.FichaPagoEspecialRespuesta;
import utilitario.mensajes.impresiondocs.oportunidapagare.OportunidadPagareRespuesta;
import utilitario.mensajes.impresiondocs.solidariocontrato.SolidarioContratoRespuesta;
import utilitario.mensajes.impresiondocs.solidariopagare.SolidarioPagareRespuesta;

public interface ImpresionDocsInformacion {

	 static String CONTRATO_INVALIDO 					= "NO SE HAN ENCONTRADO DATOS PARA ESTE NUMERO DE CONTRATO";
	 static String ERROR_CONSULTA 						= "SE HA PRODUCIDO UN ERROR DURANTE LA CONSULTA";
	 static final String ID_TESORERO 					= "TESO";
	 static final String ID_PRESIDENTE 					= "PRES";
	 static final String ID_SECRETARIO 					= "SECR";
	 static final String ID_SUPERVISOR					= "SUPE";
	 static final String EMPRESA_FINSOL 				= "Financiera Finsol S.A. de C.V., Sociedad Financiera de Objeto M�ltiple, Entidad No " +
															  "Regulada";
	 static final String OPER_VER_VALOR_HISTORICO 		= "verValorHistorico";
	 static final String CODIGO_IVA						= "IVIN";
	 static final String VIUDO 							= "V";
	 static final String CASADO							= "C";
	 static final String SOLTERO						= "S";
	 static final String UNION_LIBRE					= "U";
	 static final String DIVORCIADO						= "D";
	 static final String MUJER							= "F";
	 static final String HOMBRE							= "H";
	 static final String AMORTIZACION_INDIVIDUAL		= "obtenerAmortizacionGrupal";
	 static final int 	INTEGRANTES_MINIMOS_AVAL    	= 3;
	 static final int 	INTEGRANTES_MINIMOS_REESTRUCTURA = 1;
	 static final String CUENTA_BANCO               	= "cuenta n�mero 165-7840897 de Banco Nacional de M�xico, S.A. (BANAMEX); cuenta n�mero 674133 de BBVA Bancomer S.A.";
	 static final String OPORTUNIDAD_DATOS_GRUPO    	= "0";
	 static final String OPORTUNIDAD_DATOS_MIEMBROS 	= "1";
	 static final String OPORTUNIDAD_DATOS_PAGOS    	= "2";
	 static final String OPORTUNIDAD_NOMBRE_CLIENTE 	= "3";
	 static final String COMUNALES_DATOS_GRUPO    		= "0";
	 static final String COMUNALES_DATOS_GRUPO_FIN		= "21";
	 static final String COMUNALES_DATOS_MIEMBROS   	= "1";
	 static final String COMUNALES_DATOS_MIEMBROS_FIN 	= "22";
	 static final String COMUNALES_DATOS_MIEMBROS_FIN_A = "23";
	 static final String CONTRATO_SOLIDARIO_CAT     	= "SOLN";
	 static final int    MAXIMO_DECENAS 				= 11; 
	 static final String CADENA_FIJA_BANCOMER 			= "212121212"; 
	 static final String YBANAMEX_SUC 					= "0165";
	 static final String YBANAMEX_CTA 					= "7840897";
	 static final String YCONST_REF_BANAMEX 			= "000000008";
	 static final String YALFANUMERICA_BANAMEX  		= "T";
	 static final int 	YPONDERADOR2 					= 97;
	 static final int 	YPONDERADOR3 					= 99;
	 static final int[]  YPONDERADORES1					= {23,29,31,37,13,17,19,23,29,31,37,19,23,29,31,37,1,2,3,5,7,11,13,17,19,23,29,31,37};
	 static final int 	CAMPO_CADENA_VACIA 				= 0;
	 static final int 	CAMPO_NUMERO_VACIO				= 1;

	 	static final int KIT_FIN_CONTRACT		= 1008;
	 	static final int KIT_FIN_PROMISE_NOTE	= 1009;
	 	static final int KIT_FIN_PAYMENT		= 1010;
	 	static final int KIT_FIN_SLIP_REC_MAT   = 1011;

 	/** The Constant MIL. */
	 static final int MIL = 1000;

 	/** The Constant CIEN. */
	 static final int CIEN = 100;

	 /** The Constant DOCE. */
 	static final int DOCE = 100;
 	
 	/** The Constant TREINTA. */
	 static final int TREINTA = 30;

	 /** The Constant TIPO IMPRESION GARANTIA. */
	 static final String TIPO_IMPR_GAR = "2";	
	/**
	 * TODO
	 * @param uid
	 * @param peticion
	 * @return
	 */
	public ImpresionDocsConsultaRespuesta generaDocumentoKitImpresion( String uid, ImpresionDocsConsulta peticion);
		
	
	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#comunalConrato(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ImpresionDocsConsultaRespuesta comunalContrato( /*String uid,*/ String contrato, String ld, String tipoInfo, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#comunalPagare(java.lang.String, java.lang.String, java.lang.String)
	 */
	public ImpresionDocsConsultaRespuesta comunalPagare(/*String uid,*/ String contrato,	String ld, String tipoInfo, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#fichaPagoEspecial(java.lang.String)
	 */
	public FichaPagoEspecialRespuesta fichaPagoEspecial(/*String uid,*/ String credito, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#fichaPago(java.lang.String, java.lang.String)
	 */
	public ImpresionDocsConsultaRespuesta fichaPago(/*String uid,*/ String contrato, String ld, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#fichaPagoEspecail(java.lang.String, java.lang.String)
	 */
	public ImpresionDocsConsultaRespuesta fichaPagoEspecial(/*String uid,*/ String contrato, String ld, String fecha, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#oportunidadContrato(java.lang.String)
	 */
	public ImpresionDocsConsultaRespuesta oportunidadContrato(String contrato, String ld, String tipoInfo, String uid); 

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#oportunidadPagare(java.lang.String)
	 */
	public OportunidadPagareRespuesta oportunidadPagare(/*String uid,*/ String contrato, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#solidarioContrato(java.lang.String)
	 */
	public SolidarioContratoRespuesta solidarioContrato(/*String uid,*/ String contrato, String uid);

	/* (non-Javadoc)
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#solidarioPagare(java.lang.String)
	 */
	public SolidarioPagareRespuesta solidarioPagare(/*String uid,*/ String contrato, String uid);


	//Nuevos metodos sin OFS

	/**
	 * @param uid .
	 * @param contratoPeticion .
	 * @return ContratoPeticionKit
	 */
	public ContratoComunalKitRespuesta generaContratoComunalDepositoGarantia(String uid , ContratoPeticionKit contratoPeticion);	

	/**
	 * @param uid .
	 * @param contratoPeticion .
	 * @return ContratoPagareKitRespuesta
	 */
	public ContratoPagareKitRespuesta generaPagareComunalDepositoGarantia(String uid , ContratoPeticionKit contratoPeticion);

	/**
	 * @param uid .
	 * @param contratoPeticion .
	 * @return ConvenioReestructuraKitRespuesta
	 */
	public ConvenioReestructuraKitRespuesta generaConvenioReestructura(String uid, ContratoPeticionKit contratoPeticion);

	/**
	 * @param uid .
	 * @param contratoPeticion .
	 * @return PagareReestructuraKitRespuesta
	 */
	public PagareReestructuraKitRespuesta generaPagareReestructura(String uid, ContratoPeticionKit contratoPeticion);

	/**
	 * @param uid identificador unico
	 * @param peticion donde viene el contrato
	 * @return ContratoFinsolRespuesta
	 */
	public ContratoFinsolRespuesta generaContratoFinsol(String uid,
			ContratoPeticionKit peticion);

	/**
	 * @param uid identificador unico de la peticion
	 * @param peticion para la generacion de la ficha especial de pago
	 * @return resultado de la ficha especial de pago
	 */
	public FichaEspecialRespuesta generaFichaEspecialPago(String uid, FichaEspecialPeticion peticion);


	/**
	 * Ficha pago.
	 *
	 * @param uid the uid
	 * @param contratoPeticion the contrato
	 * @return the ficha pago respuesta
	 */
	public FichaPagoRespuesta generaFichaPagoTarea(String uid, FichaPagoPeticion contratoPeticion);


	public KitImpresionPagareRespuesta generarKitImpresionPagareTarea(String uid, ContratoPeticionKit peticion);
	
	public PreSolicitudRespuesta generarPreSolicitudCreditoTarea(String uid , PreSolicitudPeticion peticion);
}