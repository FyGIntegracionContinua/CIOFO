/**
 * RecibirDatosVerificacionPOC2Response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class RecibirDatosVerificacionPOC2Response  implements java.io.Serializable {
    private java.lang.String recibirDatosVerificacionPOC2Result;

    public RecibirDatosVerificacionPOC2Response() {
    }

    public RecibirDatosVerificacionPOC2Response(
           java.lang.String recibirDatosVerificacionPOC2Result) {
           this.recibirDatosVerificacionPOC2Result = recibirDatosVerificacionPOC2Result;
    }


    /**
     * Gets the recibirDatosVerificacionPOC2Result value for this RecibirDatosVerificacionPOC2Response.
     * 
     * @return recibirDatosVerificacionPOC2Result
     */
    public java.lang.String getRecibirDatosVerificacionPOC2Result() {
        return recibirDatosVerificacionPOC2Result;
    }


    /**
     * Sets the recibirDatosVerificacionPOC2Result value for this RecibirDatosVerificacionPOC2Response.
     * 
     * @param recibirDatosVerificacionPOC2Result
     */
    public void setRecibirDatosVerificacionPOC2Result(java.lang.String recibirDatosVerificacionPOC2Result) {
        this.recibirDatosVerificacionPOC2Result = recibirDatosVerificacionPOC2Result;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RecibirDatosVerificacionPOC2Response)) return false;
        RecibirDatosVerificacionPOC2Response other = (RecibirDatosVerificacionPOC2Response) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.recibirDatosVerificacionPOC2Result==null && other.getRecibirDatosVerificacionPOC2Result()==null) || 
             (this.recibirDatosVerificacionPOC2Result!=null &&
              this.recibirDatosVerificacionPOC2Result.equals(other.getRecibirDatosVerificacionPOC2Result())));
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
        if (getRecibirDatosVerificacionPOC2Result() != null) {
            _hashCode += getRecibirDatosVerificacionPOC2Result().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RecibirDatosVerificacionPOC2Response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">RecibirDatosVerificacionPOC2Response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recibirDatosVerificacionPOC2Result");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "RecibirDatosVerificacionPOC2Result"));
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
