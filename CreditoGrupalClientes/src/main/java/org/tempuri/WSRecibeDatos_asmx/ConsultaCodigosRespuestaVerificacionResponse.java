/**
 * ConsultaCodigosRespuestaVerificacionResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConsultaCodigosRespuestaVerificacionResponse  implements java.io.Serializable {
    private java.lang.String consultaCodigosRespuestaVerificacionResult;

    public ConsultaCodigosRespuestaVerificacionResponse() {
    }

    public ConsultaCodigosRespuestaVerificacionResponse(
           java.lang.String consultaCodigosRespuestaVerificacionResult) {
           this.consultaCodigosRespuestaVerificacionResult = consultaCodigosRespuestaVerificacionResult;
    }


    /**
     * Gets the consultaCodigosRespuestaVerificacionResult value for this ConsultaCodigosRespuestaVerificacionResponse.
     * 
     * @return consultaCodigosRespuestaVerificacionResult
     */
    public java.lang.String getConsultaCodigosRespuestaVerificacionResult() {
        return consultaCodigosRespuestaVerificacionResult;
    }


    /**
     * Sets the consultaCodigosRespuestaVerificacionResult value for this ConsultaCodigosRespuestaVerificacionResponse.
     * 
     * @param consultaCodigosRespuestaVerificacionResult
     */
    public void setConsultaCodigosRespuestaVerificacionResult(java.lang.String consultaCodigosRespuestaVerificacionResult) {
        this.consultaCodigosRespuestaVerificacionResult = consultaCodigosRespuestaVerificacionResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaCodigosRespuestaVerificacionResponse)) return false;
        ConsultaCodigosRespuestaVerificacionResponse other = (ConsultaCodigosRespuestaVerificacionResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultaCodigosRespuestaVerificacionResult==null && other.getConsultaCodigosRespuestaVerificacionResult()==null) || 
             (this.consultaCodigosRespuestaVerificacionResult!=null &&
              this.consultaCodigosRespuestaVerificacionResult.equals(other.getConsultaCodigosRespuestaVerificacionResult())));
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
        if (getConsultaCodigosRespuestaVerificacionResult() != null) {
            _hashCode += getConsultaCodigosRespuestaVerificacionResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaCodigosRespuestaVerificacionResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConsultaCodigosRespuestaVerificacionResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultaCodigosRespuestaVerificacionResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "ConsultaCodigosRespuestaVerificacionResult"));
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
