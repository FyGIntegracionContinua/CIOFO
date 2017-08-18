package utilitario.mensajes.condonaciones;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AplicarCondonacionTotalRespuesta.
 */
public class AplicarCondonacionTotalRespuesta extends ObjetoValor implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The aplicar condonacion total result. */
	private int aplicarCondonacionTotalResult;

    /** The detalle. */
    private java.lang.String detalle;

    /** The peticion_ofs. */
    private String peticion_ofs;

 	/**
 	 * Obtiene peticion_ofs.
 	 *
 	 * @return the peticion_ofs
 	 */
	public String getPeticion_ofs() {
		return peticion_ofs;
	}


	/**
	 * Establece peticion_ofs.
	 *
	 * @param peticion_ofs the peticion_ofs to set
	 */
	public void setPeticion_ofs(String peticion_ofs) {
		this.peticion_ofs = peticion_ofs;
	}

    /**
     * Instancia una nueva aplicar condonacion total respuesta.
     */
    public AplicarCondonacionTotalRespuesta() {
    }

    /**
     * Instancia una nueva aplicar condonacion total respuesta.
     *
     * @param aplicarCondonacionParcialResult the aplicar condonacion parcial result
     * @param detalle the detalle
     */
    public AplicarCondonacionTotalRespuesta(
           int aplicarCondonacionParcialResult,
           java.lang.String detalle) {
           this.aplicarCondonacionTotalResult = aplicarCondonacionParcialResult;
           this.detalle = detalle;
    }


    /**
     * Gets the aplicarCondonacionParcialResult value for this AplicarCondonacionParcialResponse.
     *
     * @return aplicarCondonacionParcialResult
     */
    public int getAplicarCondonacionTotalResult() {
        return aplicarCondonacionTotalResult;
    }


    /**
     * Sets the aplicarCondonacionParcialResult value for this AplicarCondonacionParcialResponse.
     *
     * @param aplicarCondonacionTotalResult a aplicar condonacion total result
     */
    public void setAplicarCondonacionTotalResult(int aplicarCondonacionTotalResult) {
        this.aplicarCondonacionTotalResult = aplicarCondonacionTotalResult;
    }


    /**
     * Gets the detalle value for this AplicarCondonacionParcialResponse.
     *
     * @return detalle
     */
    public java.lang.String getDetalle() {
        return detalle;
    }


    /**
     * Sets the detalle value for this AplicarCondonacionParcialResponse.
     *
     * @param detalle a detalle
     */
    public void setDetalle(java.lang.String detalle) {
        this.detalle = detalle;
    }

    /** The __equals calc. */
    private java.lang.Object __equalsCalc = null;

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     * @see java.lang.Object#equals(java.lang.Object)
     */
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AplicarCondonacionTotalRespuesta) || obj == null) return false;
        AplicarCondonacionTotalRespuesta other = (AplicarCondonacionTotalRespuesta) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return __equalsCalc == obj;
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true
        		&& this.aplicarCondonacionTotalResult == other.getAplicarCondonacionTotalResult()
        		&& ((this.detalle == null && other.getDetalle() == null)
        				|| (this.detalle != null && this.detalle.equals(other.getDetalle())));
        __equalsCalc = null;
        return _equals;
    }

    /** The __hash code calc. */
    private boolean __hashCodeCalc = false;

    /**
     * Hash code.
     *
     * @return the int
     * @see java.lang.Object#hashCode()
     */
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getAplicarCondonacionTotalResult();
        if (getDetalle() != null) {
            _hashCode += getDetalle().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
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
