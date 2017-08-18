/**
 * ConfirmarSolicitudesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConfirmarSolicitudesResponse  implements java.io.Serializable {
    private java.lang.String confirmarSolicitudesResult;

    public ConfirmarSolicitudesResponse() {
    }

    public ConfirmarSolicitudesResponse(
           java.lang.String confirmarSolicitudesResult) {
           this.confirmarSolicitudesResult = confirmarSolicitudesResult;
    }


    /**
     * Gets the confirmarSolicitudesResult value for this ConfirmarSolicitudesResponse.
     * 
     * @return confirmarSolicitudesResult
     */
    public java.lang.String getConfirmarSolicitudesResult() {
        return confirmarSolicitudesResult;
    }


    /**
     * Sets the confirmarSolicitudesResult value for this ConfirmarSolicitudesResponse.
     * 
     * @param confirmarSolicitudesResult
     */
    public void setConfirmarSolicitudesResult(java.lang.String confirmarSolicitudesResult) {
        this.confirmarSolicitudesResult = confirmarSolicitudesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmarSolicitudesResponse)) return false;
        ConfirmarSolicitudesResponse other = (ConfirmarSolicitudesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.confirmarSolicitudesResult==null && other.getConfirmarSolicitudesResult()==null) || 
             (this.confirmarSolicitudesResult!=null &&
              this.confirmarSolicitudesResult.equals(other.getConfirmarSolicitudesResult())));
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
        if (getConfirmarSolicitudesResult() != null) {
            _hashCode += getConfirmarSolicitudesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmarSolicitudesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConfirmarSolicitudesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("confirmarSolicitudesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "ConfirmarSolicitudesResult"));
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
