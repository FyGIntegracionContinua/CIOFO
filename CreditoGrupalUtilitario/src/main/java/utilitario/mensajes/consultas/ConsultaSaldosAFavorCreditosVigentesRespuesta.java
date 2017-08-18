package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSaldosAFavorCreditosVigentesRespuesta.
 *
 * @author out_mreyes
 */
public 	class 		ConsultaSaldosAFavorCreditosVigentesRespuesta
		extends 	ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -605763253829252351L;

	// Atributos de la clase  ---------------------------------------------------------------
	/** The header. */
	private EncabezadoRespuesta							header;

	/** The creditos. */
	private java.util.List<SaldoAFavorCreditoVigenteVO>	creditos;

	//Constructor  --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consulta saldos a favor creditos vigentes respuesta.
	 */
	public ConsultaSaldosAFavorCreditosVigentesRespuesta() {
		header = new EncabezadoRespuesta();
		}

	// Sets y Gets  -------------------------------------------------------------------------
	/**
	 * Obtiene header.
	 *
	 * @return the encabezadoRespuesta
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene creditos.
	 *
	 * @return the creditos
	 */
	public java.util.List<SaldoAFavorCreditoVigenteVO> getCreditos() {
		return creditos;
	}

	/**
	 * Establece creditos.
	 *
	 * @param creditos the creditos to set
	 */
	public void setCreditos(java.util.List<SaldoAFavorCreditoVigenteVO> creditos) {
		this.creditos = creditos;
	}

}
