package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;

/**
 * The Class AjusteSaldoAFavorMasivoRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	AjusteSaldoAFavorMasivoRespuesta
		extends	AjusteSaldoAFavorRespuesta {

	/** UID para serializaci&oacute;n. */
	private static final long serialVersionUID = 105649207016477215L;

	//Atributos privados  ------------------------------------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta	header;

	/** The contrato origen. */
	private java.lang.String 	contratoOrigen;

	/** The contrato destino. */
	private java.lang.String 	contratoDestino;

	//Constructor  -------------------------------------------------------------------------------------------------
	/**
	 * Instancia una nueva ajuste saldo a favor masivo respuesta.
	 */
	public AjusteSaldoAFavorMasivoRespuesta() {
		header = new EncabezadoRespuesta();
		}

	//M&eacute;todos  -----------------------------------------------------------------------------------------------------
	/**
	 * Obtiene contrato origen.
	 *
	 * @return the contratoOrigen
	 */
	public java.lang.String getContratoOrigen() {
		return contratoOrigen;
	}

	/**
	 * Establece contrato origen.
	 *
	 * @param contratoOrigen the contratoOrigen to set
	 */
	public void setContratoOrigen(java.lang.String contratoOrigen) {
		this.contratoOrigen = contratoOrigen;
	}

	/**
	 * Obtiene contrato destino.
	 *
	 * @return the contratoDestino
	 */
	public java.lang.String getContratoDestino() {
		return contratoDestino;
	}

	/**
	 * Establece contrato destino.
	 *
	 * @param contratoDestino the contratoDestino to set
	 */
	public void setContratoDestino(java.lang.String contratoDestino) {
		this.contratoDestino = contratoDestino;
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
