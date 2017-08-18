/**
 * MovimientosGarantiaPeticion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public class MovimientosGarantiaPeticion  extends mx.com.findep.depositosgarantia.ws.ObjetoValor  implements java.io.Serializable {
    private boolean cancelacion;

    private java.lang.String contrato;

    public MovimientosGarantiaPeticion() {
    }

    public MovimientosGarantiaPeticion(
           int tipo,
           boolean cancelacion,
           java.lang.String contrato) {
        super(
            tipo);
        this.cancelacion = cancelacion;
        this.contrato = contrato;
    }


    /**
     * Gets the cancelacion value for this MovimientosGarantiaPeticion.
     * 
     * @return cancelacion
     */
    public boolean isCancelacion() {
        return cancelacion;
    }


    /**
     * Sets the cancelacion value for this MovimientosGarantiaPeticion.
     * 
     * @param cancelacion
     */
    public void setCancelacion(boolean cancelacion) {
        this.cancelacion = cancelacion;
    }


    /**
     * Gets the contrato value for this MovimientosGarantiaPeticion.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this MovimientosGarantiaPeticion.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MovimientosGarantiaPeticion)) return false;
        MovimientosGarantiaPeticion other = (MovimientosGarantiaPeticion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            this.cancelacion == other.isCancelacion() &&
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        _hashCode += (isCancelacion() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MovimientosGarantiaPeticion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "movimientosGarantiaPeticion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cancelacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cancelacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
