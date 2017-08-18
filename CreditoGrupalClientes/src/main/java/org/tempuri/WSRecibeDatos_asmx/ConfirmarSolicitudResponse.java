/**
 * ConfirmarSolicitudResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConfirmarSolicitudResponse  implements java.io.Serializable {
    private java.lang.String confirmarSolicitudResult;

    public ConfirmarSolicitudResponse() {
    }

    public ConfirmarSolicitudResponse(
           java.lang.String confirmarSolicitudResult) {
           this.confirmarSolicitudResult = confirmarSolicitudResult;
    }


    /**
     * Gets the confirmarSolicitudResult value for this ConfirmarSolicitudResponse.
     * 
     * @return confirmarSolicitudResult
     */
    public java.lang.String getConfirmarSolicitudResult() {
        return confirmarSolicitudResult;
    }


    /**
     * Sets the confirmarSolicitudResult value for this ConfirmarSolicitudResponse.
     * 
     * @param confirmarSolicitudResult
     */
    public void setConfirmarSolicitudResult(java.lang.String confirmarSolicitudResult) {
        this.confirmarSolicitudResult = confirmarSolicitudResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmarSolicitudResponse)) return false;
        ConfirmarSolicitudResponse other = (ConfirmarSolicitudResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.confirmarSolicitudResult==null && other.getConfirmarSolicitudResult()==null) || 
             (this.confirmarSolicitudResult!=null &&
              this.confirmarSolicitudResult.equals(other.getConfirmarSolicitudResult())));
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
        if (getConfirmarSolicitudResult() != null) {
            _hashCode += getConfirmarSolicitudResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmarSolicitudResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConfirmarSolicitudResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmarSolicitudResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "ConfirmarSolicitudResult"));
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
