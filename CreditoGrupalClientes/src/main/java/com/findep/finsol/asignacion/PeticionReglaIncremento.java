/**
 * PeticionReglaIncremento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.finsol.asignacion;

public class PeticionReglaIncremento  implements java.io.Serializable {
    private java.lang.String numeroContrato;

    private java.lang.String numeroPersona;

    public PeticionReglaIncremento() {
    }

    public PeticionReglaIncremento(
           java.lang.String numeroContrato,
           java.lang.String numeroPersona) {
           this.numeroContrato = numeroContrato;
           this.numeroPersona = numeroPersona;
    }


    /**
     * Gets the numeroContrato value for this PeticionReglaIncremento.
     * 
     * @return numeroContrato
     */
    public java.lang.String getNumeroContrato() {
        return numeroContrato;
    }


    /**
     * Sets the numeroContrato value for this PeticionReglaIncremento.
     * 
     * @param numeroContrato
     */
    public void setNumeroContrato(java.lang.String numeroContrato) {
        this.numeroContrato = numeroContrato;
    }


    /**
     * Gets the numeroPersona value for this PeticionReglaIncremento.
     * 
     * @return numeroPersona
     */
    public java.lang.String getNumeroPersona() {
        return numeroPersona;
    }


    /**
     * Sets the numeroPersona value for this PeticionReglaIncremento.
     * 
     * @param numeroPersona
     */
    public void setNumeroPersona(java.lang.String numeroPersona) {
        this.numeroPersona = numeroPersona;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PeticionReglaIncremento)) return false;
        PeticionReglaIncremento other = (PeticionReglaIncremento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.numeroContrato==null && other.getNumeroContrato()==null) || 
             (this.numeroContrato!=null &&
              this.numeroContrato.equals(other.getNumeroContrato()))) &&
            ((this.numeroPersona==null && other.getNumeroPersona()==null) || 
             (this.numeroPersona!=null &&
              this.numeroPersona.equals(other.getNumeroPersona())));
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
        if (getNumeroContrato() != null) {
            _hashCode += getNumeroContrato().hashCode();
        }
        if (getNumeroPersona() != null) {
            _hashCode += getNumeroPersona().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PeticionReglaIncremento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://asignacion.finsol.findep.com/", "peticionReglaIncremento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroContrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroContrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPersona"));
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
