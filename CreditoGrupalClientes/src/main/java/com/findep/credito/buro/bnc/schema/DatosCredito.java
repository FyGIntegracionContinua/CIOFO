/**
 * DatosCredito.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.schema;

public class DatosCredito  implements java.io.Serializable {
    private java.lang.String importe;

    private java.lang.String segmento;

    private java.lang.String tipoProducto;

    private java.lang.String categoria;

    public DatosCredito() {
    }

    public DatosCredito(
           java.lang.String importe,
           java.lang.String segmento,
           java.lang.String tipoProducto,
           java.lang.String categoria) {
           this.importe = importe;
           this.segmento = segmento;
           this.tipoProducto = tipoProducto;
           this.categoria = categoria;
    }


    /**
     * Gets the importe value for this DatosCredito.
     * 
     * @return importe
     */
    public java.lang.String getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this DatosCredito.
     * 
     * @param importe
     */
    public void setImporte(java.lang.String importe) {
        this.importe = importe;
    }


    /**
     * Gets the segmento value for this DatosCredito.
     * 
     * @return segmento
     */
    public java.lang.String getSegmento() {
        return segmento;
    }


    /**
     * Sets the segmento value for this DatosCredito.
     * 
     * @param segmento
     */
    public void setSegmento(java.lang.String segmento) {
        this.segmento = segmento;
    }


    /**
     * Gets the tipoProducto value for this DatosCredito.
     * 
     * @return tipoProducto
     */
    public java.lang.String getTipoProducto() {
        return tipoProducto;
    }


    /**
     * Sets the tipoProducto value for this DatosCredito.
     * 
     * @param tipoProducto
     */
    public void setTipoProducto(java.lang.String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }


    /**
     * Gets the categoria value for this DatosCredito.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this DatosCredito.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosCredito)) return false;
        DatosCredito other = (DatosCredito) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.importe==null && other.getImporte()==null) || 
             (this.importe!=null &&
              this.importe.equals(other.getImporte()))) &&
            ((this.segmento==null && other.getSegmento()==null) || 
             (this.segmento!=null &&
              this.segmento.equals(other.getSegmento()))) &&
            ((this.tipoProducto==null && other.getTipoProducto()==null) || 
             (this.tipoProducto!=null &&
              this.tipoProducto.equals(other.getTipoProducto()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria())));
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
        if (getImporte() != null) {
            _hashCode += getImporte().hashCode();
        }
        if (getSegmento() != null) {
            _hashCode += getSegmento().hashCode();
        }
        if (getTipoProducto() != null) {
            _hashCode += getTipoProducto().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosCredito.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "DatosCredito"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipoProducto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoProducto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoria"));
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
