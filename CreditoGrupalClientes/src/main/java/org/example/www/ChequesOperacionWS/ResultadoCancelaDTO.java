/**
 * ResultadoCancelaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ChequesOperacionWS;

public class ResultadoCancelaDTO  implements java.io.Serializable {
    private long folioCheque;

    private java.lang.String comentario;

    private int valor;

    public ResultadoCancelaDTO() {
    }

    public ResultadoCancelaDTO(
           long folioCheque,
           java.lang.String comentario,
           int valor) {
           this.folioCheque = folioCheque;
           this.comentario = comentario;
           this.valor = valor;
    }


    /**
     * Gets the folioCheque value for this ResultadoCancelaDTO.
     * 
     * @return folioCheque
     */
    public long getFolioCheque() {
        return folioCheque;
    }


    /**
     * Sets the folioCheque value for this ResultadoCancelaDTO.
     * 
     * @param folioCheque
     */
    public void setFolioCheque(long folioCheque) {
        this.folioCheque = folioCheque;
    }


    /**
     * Gets the comentario value for this ResultadoCancelaDTO.
     * 
     * @return comentario
     */
    public java.lang.String getComentario() {
        return comentario;
    }


    /**
     * Sets the comentario value for this ResultadoCancelaDTO.
     * 
     * @param comentario
     */
    public void setComentario(java.lang.String comentario) {
        this.comentario = comentario;
    }


    /**
     * Gets the valor value for this ResultadoCancelaDTO.
     * 
     * @return valor
     */
    public int getValor() {
        return valor;
    }


    /**
     * Sets the valor value for this ResultadoCancelaDTO.
     * 
     * @param valor
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ResultadoCancelaDTO)) return false;
        ResultadoCancelaDTO other = (ResultadoCancelaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.folioCheque == other.getFolioCheque() &&
            ((this.comentario==null && other.getComentario()==null) || 
             (this.comentario!=null &&
              this.comentario.equals(other.getComentario()))) &&
            this.valor == other.getValor();
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
        _hashCode += new Long(getFolioCheque()).hashCode();
        if (getComentario() != null) {
            _hashCode += getComentario().hashCode();
        }
        _hashCode += getValor();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ResultadoCancelaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/ChequesOperacionWS/", "ResultadoCancelaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioCheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folioCheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comentario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "comentario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valor"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
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
