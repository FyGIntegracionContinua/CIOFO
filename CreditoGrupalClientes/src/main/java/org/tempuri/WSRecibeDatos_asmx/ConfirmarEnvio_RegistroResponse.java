/**
 * ConfirmarEnvio_RegistroResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConfirmarEnvio_RegistroResponse  implements java.io.Serializable {
    private java.lang.String confirmarEnvio_RegistroResult;

    public ConfirmarEnvio_RegistroResponse() {
    }

    public ConfirmarEnvio_RegistroResponse(
           java.lang.String confirmarEnvio_RegistroResult) {
           this.confirmarEnvio_RegistroResult = confirmarEnvio_RegistroResult;
    }


    /**
     * Gets the confirmarEnvio_RegistroResult value for this ConfirmarEnvio_RegistroResponse.
     * 
     * @return confirmarEnvio_RegistroResult
     */
    public java.lang.String getConfirmarEnvio_RegistroResult() {
        return confirmarEnvio_RegistroResult;
    }


    /**
     * Sets the confirmarEnvio_RegistroResult value for this ConfirmarEnvio_RegistroResponse.
     * 
     * @param confirmarEnvio_RegistroResult
     */
    public void setConfirmarEnvio_RegistroResult(java.lang.String confirmarEnvio_RegistroResult) {
        this.confirmarEnvio_RegistroResult = confirmarEnvio_RegistroResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmarEnvio_RegistroResponse)) return false;
        ConfirmarEnvio_RegistroResponse other = (ConfirmarEnvio_RegistroResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.confirmarEnvio_RegistroResult==null && other.getConfirmarEnvio_RegistroResult()==null) || 
             (this.confirmarEnvio_RegistroResult!=null &&
              this.confirmarEnvio_RegistroResult.equals(other.getConfirmarEnvio_RegistroResult())));
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
        if (getConfirmarEnvio_RegistroResult() != null) {
            _hashCode += getConfirmarEnvio_RegistroResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmarEnvio_RegistroResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConfirmarEnvio_RegistroResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmarEnvio_RegistroResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "ConfirmarEnvio_RegistroResult"));
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
