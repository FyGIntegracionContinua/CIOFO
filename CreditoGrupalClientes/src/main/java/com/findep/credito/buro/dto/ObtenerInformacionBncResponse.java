/**
 * ObtenerInformacionBncResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.dto;

public class ObtenerInformacionBncResponse  implements java.io.Serializable {
    private boolean obtuvoHistorial;

    private com.findep.credito.buro.dto.InformacionCliente[] historialRespuestas;

    public ObtenerInformacionBncResponse() {
    }

    public ObtenerInformacionBncResponse(
           boolean obtuvoHistorial,
           com.findep.credito.buro.dto.InformacionCliente[] historialRespuestas) {
           this.obtuvoHistorial = obtuvoHistorial;
           this.historialRespuestas = historialRespuestas;
    }


    /**
     * Gets the obtuvoHistorial value for this ObtenerInformacionBncResponse.
     * 
     * @return obtuvoHistorial
     */
    public boolean isObtuvoHistorial() {
        return obtuvoHistorial;
    }


    /**
     * Sets the obtuvoHistorial value for this ObtenerInformacionBncResponse.
     * 
     * @param obtuvoHistorial
     */
    public void setObtuvoHistorial(boolean obtuvoHistorial) {
        this.obtuvoHistorial = obtuvoHistorial;
    }


    /**
     * Gets the historialRespuestas value for this ObtenerInformacionBncResponse.
     * 
     * @return historialRespuestas
     */
    public com.findep.credito.buro.dto.InformacionCliente[] getHistorialRespuestas() {
        return historialRespuestas;
    }


    /**
     * Sets the historialRespuestas value for this ObtenerInformacionBncResponse.
     * 
     * @param historialRespuestas
     */
    public void setHistorialRespuestas(com.findep.credito.buro.dto.InformacionCliente[] historialRespuestas) {
        this.historialRespuestas = historialRespuestas;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ObtenerInformacionBncResponse)) return false;
        ObtenerInformacionBncResponse other = (ObtenerInformacionBncResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.obtuvoHistorial == other.isObtuvoHistorial() &&
            ((this.historialRespuestas==null && other.getHistorialRespuestas()==null) || 
             (this.historialRespuestas!=null &&
              java.util.Arrays.equals(this.historialRespuestas, other.getHistorialRespuestas())));
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
        _hashCode += (isObtuvoHistorial() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getHistorialRespuestas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getHistorialRespuestas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getHistorialRespuestas(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ObtenerInformacionBncResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "obtenerInformacionBncResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("obtuvoHistorial");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "ObtuvoHistorial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historialRespuestas");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "HistorialRespuestas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "informacionCliente"));
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "item"));
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
