/**
 * HistorialCrediticio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.schema;

public class HistorialCrediticio  implements java.io.Serializable {
    private java.lang.String tarjetaCredito;

    private java.lang.String ultimosDigitosTarjeta;

    private java.lang.String creditoHipotecario;

    private java.lang.String creditoAutomotriz;

    public HistorialCrediticio() {
    }

    public HistorialCrediticio(
           java.lang.String tarjetaCredito,
           java.lang.String ultimosDigitosTarjeta,
           java.lang.String creditoHipotecario,
           java.lang.String creditoAutomotriz) {
           this.tarjetaCredito = tarjetaCredito;
           this.ultimosDigitosTarjeta = ultimosDigitosTarjeta;
           this.creditoHipotecario = creditoHipotecario;
           this.creditoAutomotriz = creditoAutomotriz;
    }


    /**
     * Gets the tarjetaCredito value for this HistorialCrediticio.
     * 
     * @return tarjetaCredito
     */
    public java.lang.String getTarjetaCredito() {
        return tarjetaCredito;
    }


    /**
     * Sets the tarjetaCredito value for this HistorialCrediticio.
     * 
     * @param tarjetaCredito
     */
    public void setTarjetaCredito(java.lang.String tarjetaCredito) {
        this.tarjetaCredito = tarjetaCredito;
    }


    /**
     * Gets the ultimosDigitosTarjeta value for this HistorialCrediticio.
     * 
     * @return ultimosDigitosTarjeta
     */
    public java.lang.String getUltimosDigitosTarjeta() {
        return ultimosDigitosTarjeta;
    }


    /**
     * Sets the ultimosDigitosTarjeta value for this HistorialCrediticio.
     * 
     * @param ultimosDigitosTarjeta
     */
    public void setUltimosDigitosTarjeta(java.lang.String ultimosDigitosTarjeta) {
        this.ultimosDigitosTarjeta = ultimosDigitosTarjeta;
    }


    /**
     * Gets the creditoHipotecario value for this HistorialCrediticio.
     * 
     * @return creditoHipotecario
     */
    public java.lang.String getCreditoHipotecario() {
        return creditoHipotecario;
    }


    /**
     * Sets the creditoHipotecario value for this HistorialCrediticio.
     * 
     * @param creditoHipotecario
     */
    public void setCreditoHipotecario(java.lang.String creditoHipotecario) {
        this.creditoHipotecario = creditoHipotecario;
    }


    /**
     * Gets the creditoAutomotriz value for this HistorialCrediticio.
     * 
     * @return creditoAutomotriz
     */
    public java.lang.String getCreditoAutomotriz() {
        return creditoAutomotriz;
    }


    /**
     * Sets the creditoAutomotriz value for this HistorialCrediticio.
     * 
     * @param creditoAutomotriz
     */
    public void setCreditoAutomotriz(java.lang.String creditoAutomotriz) {
        this.creditoAutomotriz = creditoAutomotriz;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof HistorialCrediticio)) return false;
        HistorialCrediticio other = (HistorialCrediticio) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.tarjetaCredito==null && other.getTarjetaCredito()==null) || 
             (this.tarjetaCredito!=null &&
              this.tarjetaCredito.equals(other.getTarjetaCredito()))) &&
            ((this.ultimosDigitosTarjeta==null && other.getUltimosDigitosTarjeta()==null) || 
             (this.ultimosDigitosTarjeta!=null &&
              this.ultimosDigitosTarjeta.equals(other.getUltimosDigitosTarjeta()))) &&
            ((this.creditoHipotecario==null && other.getCreditoHipotecario()==null) || 
             (this.creditoHipotecario!=null &&
              this.creditoHipotecario.equals(other.getCreditoHipotecario()))) &&
            ((this.creditoAutomotriz==null && other.getCreditoAutomotriz()==null) || 
             (this.creditoAutomotriz!=null &&
              this.creditoAutomotriz.equals(other.getCreditoAutomotriz())));
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
        if (getTarjetaCredito() != null) {
            _hashCode += getTarjetaCredito().hashCode();
        }
        if (getUltimosDigitosTarjeta() != null) {
            _hashCode += getUltimosDigitosTarjeta().hashCode();
        }
        if (getCreditoHipotecario() != null) {
            _hashCode += getCreditoHipotecario().hashCode();
        }
        if (getCreditoAutomotriz() != null) {
            _hashCode += getCreditoAutomotriz().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(HistorialCrediticio.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "HistorialCrediticio"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tarjetaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tarjetaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimosDigitosTarjeta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimosDigitosTarjeta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditoHipotecario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditoHipotecario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditoAutomotriz");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditoAutomotriz"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
