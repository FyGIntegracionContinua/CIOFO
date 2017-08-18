/**
 * ConsultaCodigosContactoResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConsultaCodigosContactoResponse  implements java.io.Serializable {
    private java.lang.String consultaCodigosContactoResult;

    public ConsultaCodigosContactoResponse() {
    }

    public ConsultaCodigosContactoResponse(
           java.lang.String consultaCodigosContactoResult) {
           this.consultaCodigosContactoResult = consultaCodigosContactoResult;
    }


    /**
     * Gets the consultaCodigosContactoResult value for this ConsultaCodigosContactoResponse.
     * 
     * @return consultaCodigosContactoResult
     */
    public java.lang.String getConsultaCodigosContactoResult() {
        return consultaCodigosContactoResult;
    }


    /**
     * Sets the consultaCodigosContactoResult value for this ConsultaCodigosContactoResponse.
     * 
     * @param consultaCodigosContactoResult
     */
    public void setConsultaCodigosContactoResult(java.lang.String consultaCodigosContactoResult) {
        this.consultaCodigosContactoResult = consultaCodigosContactoResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultaCodigosContactoResponse)) return false;
        ConsultaCodigosContactoResponse other = (ConsultaCodigosContactoResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.consultaCodigosContactoResult==null && other.getConsultaCodigosContactoResult()==null) || 
             (this.consultaCodigosContactoResult!=null &&
              this.consultaCodigosContactoResult.equals(other.getConsultaCodigosContactoResult())));
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
        if (getConsultaCodigosContactoResult() != null) {
            _hashCode += getConsultaCodigosContactoResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultaCodigosContactoResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConsultaCodigosContactoResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consultaCodigosContactoResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "ConsultaCodigosContactoResult"));
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
