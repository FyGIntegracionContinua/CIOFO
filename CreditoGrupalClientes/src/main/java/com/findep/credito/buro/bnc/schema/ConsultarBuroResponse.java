/**
 * ConsultarBuroResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.schema;

public class ConsultarBuroResponse  implements java.io.Serializable {
    private boolean estadoOperacion;

    private com.findep.credito.buro.bnc.schema.RespuestaBuro respuestaBuro;

    public ConsultarBuroResponse() {
    }

    public ConsultarBuroResponse(
           boolean estadoOperacion,
           com.findep.credito.buro.bnc.schema.RespuestaBuro respuestaBuro) {
           this.estadoOperacion = estadoOperacion;
           this.respuestaBuro = respuestaBuro;
    }


    /**
     * Gets the estadoOperacion value for this ConsultarBuroResponse.
     * 
     * @return estadoOperacion
     */
    public boolean isEstadoOperacion() {
        return estadoOperacion;
    }


    /**
     * Sets the estadoOperacion value for this ConsultarBuroResponse.
     * 
     * @param estadoOperacion
     */
    public void setEstadoOperacion(boolean estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }


    /**
     * Gets the respuestaBuro value for this ConsultarBuroResponse.
     * 
     * @return respuestaBuro
     */
    public com.findep.credito.buro.bnc.schema.RespuestaBuro getRespuestaBuro() {
        return respuestaBuro;
    }


    /**
     * Sets the respuestaBuro value for this ConsultarBuroResponse.
     * 
     * @param respuestaBuro
     */
    public void setRespuestaBuro(com.findep.credito.buro.bnc.schema.RespuestaBuro respuestaBuro) {
        this.respuestaBuro = respuestaBuro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarBuroResponse)) return false;
        ConsultarBuroResponse other = (ConsultarBuroResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.estadoOperacion == other.isEstadoOperacion() &&
            ((this.respuestaBuro==null && other.getRespuestaBuro()==null) || 
             (this.respuestaBuro!=null &&
              this.respuestaBuro.equals(other.getRespuestaBuro())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += (isEstadoOperacion() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getRespuestaBuro() != null) {
            _hashCode += getRespuestaBuro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarBuroResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "ConsultarBuroResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estadoOperacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estadoOperacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaBuro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuestaBuro"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "RespuestaBuro"));
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
