/**
 * ConfirmarEnvioResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConfirmarEnvioResponse  implements java.io.Serializable {
    private java.lang.String confirmarEnvioResult;

    public ConfirmarEnvioResponse() {
    }

    public ConfirmarEnvioResponse(
           java.lang.String confirmarEnvioResult) {
           this.confirmarEnvioResult = confirmarEnvioResult;
    }


    /**
     * Gets the confirmarEnvioResult value for this ConfirmarEnvioResponse.
     * 
     * @return confirmarEnvioResult
     */
    public java.lang.String getConfirmarEnvioResult() {
        return confirmarEnvioResult;
    }


    /**
     * Sets the confirmarEnvioResult value for this ConfirmarEnvioResponse.
     * 
     * @param confirmarEnvioResult
     */
    public void setConfirmarEnvioResult(java.lang.String confirmarEnvioResult) {
        this.confirmarEnvioResult = confirmarEnvioResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmarEnvioResponse)) return false;
        ConfirmarEnvioResponse other = (ConfirmarEnvioResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.confirmarEnvioResult==null && other.getConfirmarEnvioResult()==null) || 
             (this.confirmarEnvioResult!=null &&
              this.confirmarEnvioResult.equals(other.getConfirmarEnvioResult())));
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
        if (getConfirmarEnvioResult() != null) {
            _hashCode += getConfirmarEnvioResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmarEnvioResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConfirmarEnvioResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmarEnvioResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "ConfirmarEnvioResult"));
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
