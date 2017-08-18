/**
 * AplicarCondonacionParcial.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package utilitario.mensajes.condonaciones;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AplicarCondonacionParcialPeticion.
 */
public class AplicarCondonacionParcialPeticion extends ObjetoValor implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoPeticion 	header;

	/** The valores. */
	private java.lang.String[] valores;


	/** The detalle. */
	private java.lang.String detalle;

    /**
     * Instancia una nueva aplicar condonacion parcial peticion.
     */
    public AplicarCondonacionParcialPeticion() {

    }


    /**
     * Instancia una nueva aplicar condonacion parcial peticion.
     *
     * @param valores the valores
     * @param detalle the detalle
     */
    public AplicarCondonacionParcialPeticion(
           java.lang.String[] valores,
           java.lang.String detalle) {
           this.valores = valores;
           this.detalle = detalle;
    }


    /**
     * Gets the valores value for this AplicarCondonacionParcial.
     *
     * @return valores
     */
    public java.lang.String[] getValores() {
        return valores;
    }


    /**
     * Sets the valores value for this AplicarCondonacionParcial.
     *
     * @param valores a valores
     */
    public void setValores(java.lang.String[] valores) {
        this.valores = valores;
    }


    /**
     * Gets the detalle value for this AplicarCondonacionParcial.
     *
     * @return detalle
     */
    public java.lang.String getDetalle() {
        return detalle;
    }


    /**
     * Sets the detalle value for this AplicarCondonacionParcial.
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
        if ( !(obj instanceof AplicarCondonacionParcialPeticion) || obj == null ) return false;
        AplicarCondonacionParcialPeticion other = (AplicarCondonacionParcialPeticion) obj;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return __equalsCalc == obj;
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true
        		&& ((this.valores == null && other.getValores() == null)
        				|| (this.valores != null && java.util.Arrays.equals(this.valores, other.getValores())))
              && ((this.detalle == null && other.getDetalle() == null) || (this.detalle != null
              && this.detalle.equals(other.getDetalle())));
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
        if (getValores() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getValores());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getValores(), i);
                if (obj != null && !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
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
	public EncabezadoPeticion getHeader() {
		return header;
	}


	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}


}
