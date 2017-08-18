/**
 * ObtenerInformacionBncRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.dto;

public class ObtenerInformacionBncRequest  implements java.io.Serializable {
    private java.lang.String persona;

    public ObtenerInformacionBncRequest() {
    }

    public ObtenerInformacionBncRequest(
           java.lang.String persona) {
           this.persona = persona;
    }


    /**
     * Gets the persona value for this ObtenerInformacionBncRequest.
     * 
     * @return persona
     */
    public java.lang.String getPersona() {
        return persona;
    }


    /**
     * Sets the persona value for this ObtenerInformacionBncRequest.
     * 
     * @param persona
     */
    public void setPersona(java.lang.String persona) {
        this.persona = persona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerInformacionBncRequest)) return false;
        ObtenerInformacionBncRequest other = (ObtenerInformacionBncRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.persona==null && other.getPersona()==null) || 
             (this.persona!=null &&
              this.persona.equals(other.getPersona())));
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
        if (getPersona() != null) {
            _hashCode += getPersona().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerInformacionBncRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "obtenerInformacionBncRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("persona");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "persona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
