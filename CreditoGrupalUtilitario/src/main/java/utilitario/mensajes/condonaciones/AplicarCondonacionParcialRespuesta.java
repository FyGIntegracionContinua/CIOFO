package utilitario.mensajes.condonaciones;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class AplicarCondonacionParcialRespuesta.
 */
public class AplicarCondonacionParcialRespuesta extends ObjetoValor implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The aplicar condonacion parcial result. */
	private int aplicarCondonacionParcialResult;

    /** The detalle. */
    private java.lang.String detalle;

    /**
     * Instancia una nueva aplicar condonacion parcial respuesta.
     */
    public AplicarCondonacionParcialRespuesta() {
    }

    /**
     * Instancia una nueva aplicar condonacion parcial respuesta.
     *
     * @param aplicarCondonacionParcialResult the aplicar condonacion parcial result
     * @param detalle the detalle
     */
    public AplicarCondonacionParcialRespuesta(
           int aplicarCondonacionParcialResult,
           java.lang.String detalle) {
           this.aplicarCondonacionParcialResult = aplicarCondonacionParcialResult;
           this.detalle = detalle;
    }


    /**
     * Gets the aplicarCondonacionParcialResult value for this AplicarCondonacionParcialRespuesta.
     *
     * @return aplicarCondonacionParcialResult
     */
    public int getAplicarCondonacionParcialResult() {
        return aplicarCondonacionParcialResult;
    }


    /**
     * Sets the aplicarCondonacionParcialResult value for this AplicarCondonacionParcialRespuesta.
     *
     * @param aplicarCondonacionParcialResult a aplicar condonacion parcial result
     */
    public void setAplicarCondonacionParcialResult(int aplicarCondonacionParcialResult) {
        this.aplicarCondonacionParcialResult = aplicarCondonacionParcialResult;
    }


    /**
     * Gets the detalle value for this AplicarCondonacionParcialRespuesta.
     *
     * @return detalle
     */
    public java.lang.String getDetalle() {
        return detalle;
    }


    /**
     * Sets the detalle value for this AplicarCondonacionParcialRespuesta.
     *
     * @param detalle a detalle
     */
    public void setDetalle(java.lang.String detalle) {
        this.detalle = detalle;
    }


    /**
     * Obtiene header.
     *
     * @return the header
     */
	public final EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the identificador
	 */

}
