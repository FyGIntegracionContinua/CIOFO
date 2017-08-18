/**
 * InformacionCliente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.dto;

public class InformacionCliente  implements java.io.Serializable {
    private java.util.Date fechaConsulta;

    private int sucursalCliente;

    private java.lang.String nombreCliente;

    private java.lang.String rfcCliente;

    private java.lang.String respuestaBNC;

    public InformacionCliente() {
    }

    public InformacionCliente(
           java.util.Date fechaConsulta,
           int sucursalCliente,
           java.lang.String nombreCliente,
           java.lang.String rfcCliente,
           java.lang.String respuestaBNC) {
           this.fechaConsulta = fechaConsulta;
           this.sucursalCliente = sucursalCliente;
           this.nombreCliente = nombreCliente;
           this.rfcCliente = rfcCliente;
           this.respuestaBNC = respuestaBNC;
    }


    /**
     * Gets the fechaConsulta value for this InformacionCliente.
     * 
     * @return fechaConsulta
     */
    public java.util.Date getFechaConsulta() {
        return fechaConsulta;
    }


    /**
     * Sets the fechaConsulta value for this InformacionCliente.
     * 
     * @param fechaConsulta
     */
    public void setFechaConsulta(java.util.Date fechaConsulta) {
        this.fechaConsulta = fechaConsulta;
    }


    /**
     * Gets the sucursalCliente value for this InformacionCliente.
     * 
     * @return sucursalCliente
     */
    public int getSucursalCliente() {
        return sucursalCliente;
    }


    /**
     * Sets the sucursalCliente value for this InformacionCliente.
     * 
     * @param sucursalCliente
     */
    public void setSucursalCliente(int sucursalCliente) {
        this.sucursalCliente = sucursalCliente;
    }


    /**
     * Gets the nombreCliente value for this InformacionCliente.
     * 
     * @return nombreCliente
     */
    public java.lang.String getNombreCliente() {
        return nombreCliente;
    }


    /**
     * Sets the nombreCliente value for this InformacionCliente.
     * 
     * @param nombreCliente
     */
    public void setNombreCliente(java.lang.String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }


    /**
     * Gets the rfcCliente value for this InformacionCliente.
     * 
     * @return rfcCliente
     */
    public java.lang.String getRfcCliente() {
        return rfcCliente;
    }


    /**
     * Sets the rfcCliente value for this InformacionCliente.
     * 
     * @param rfcCliente
     */
    public void setRfcCliente(java.lang.String rfcCliente) {
        this.rfcCliente = rfcCliente;
    }


    /**
     * Gets the respuestaBNC value for this InformacionCliente.
     * 
     * @return respuestaBNC
     */
    public java.lang.String getRespuestaBNC() {
        return respuestaBNC;
    }


    /**
     * Sets the respuestaBNC value for this InformacionCliente.
     * 
     * @param respuestaBNC
     */
    public void setRespuestaBNC(java.lang.String respuestaBNC) {
        this.respuestaBNC = respuestaBNC;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InformacionCliente)) return false;
        InformacionCliente other = (InformacionCliente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.fechaConsulta==null && other.getFechaConsulta()==null) || 
             (this.fechaConsulta!=null &&
              this.fechaConsulta.equals(other.getFechaConsulta()))) &&
            this.sucursalCliente == other.getSucursalCliente() &&
            ((this.nombreCliente==null && other.getNombreCliente()==null) || 
             (this.nombreCliente!=null &&
              this.nombreCliente.equals(other.getNombreCliente()))) &&
            ((this.rfcCliente==null && other.getRfcCliente()==null) || 
             (this.rfcCliente!=null &&
              this.rfcCliente.equals(other.getRfcCliente()))) &&
            ((this.respuestaBNC==null && other.getRespuestaBNC()==null) || 
             (this.respuestaBNC!=null &&
              this.respuestaBNC.equals(other.getRespuestaBNC())));
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
        if (getFechaConsulta() != null) {
            _hashCode += getFechaConsulta().hashCode();
        }
        _hashCode += getSucursalCliente();
        if (getNombreCliente() != null) {
            _hashCode += getNombreCliente().hashCode();
        }
        if (getRfcCliente() != null) {
            _hashCode += getRfcCliente().hashCode();
        }
        if (getRespuestaBNC() != null) {
            _hashCode += getRespuestaBNC().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InformacionCliente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "informacionCliente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaConsulta");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "fechaConsulta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "date"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursalCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "sucursalCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombreCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "nombreCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rfcCliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "rfcCliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaBNC");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto.buro.credito.findep.com", "respuestaBNC"));
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
