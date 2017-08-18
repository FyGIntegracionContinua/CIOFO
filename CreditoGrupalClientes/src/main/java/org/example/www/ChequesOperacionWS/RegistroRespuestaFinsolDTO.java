/**
 * RegistroRespuestaFinsolDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ChequesOperacionWS;

public class RegistroRespuestaFinsolDTO  implements java.io.Serializable {
    private java.lang.String cliente;

    private java.lang.String contrato;

    private long folio_cheque;

    public RegistroRespuestaFinsolDTO() {
    }

    public RegistroRespuestaFinsolDTO(
           java.lang.String cliente,
           java.lang.String contrato,
           long folio_cheque) {
           this.cliente = cliente;
           this.contrato = contrato;
           this.folio_cheque = folio_cheque;
    }


    /**
     * Gets the cliente value for this RegistroRespuestaFinsolDTO.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this RegistroRespuestaFinsolDTO.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the contrato value for this RegistroRespuestaFinsolDTO.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this RegistroRespuestaFinsolDTO.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the folio_cheque value for this RegistroRespuestaFinsolDTO.
     * 
     * @return folio_cheque
     */
    public long getFolio_cheque() {
        return folio_cheque;
    }


    /**
     * Sets the folio_cheque value for this RegistroRespuestaFinsolDTO.
     * 
     * @param folio_cheque
     */
    public void setFolio_cheque(long folio_cheque) {
        this.folio_cheque = folio_cheque;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegistroRespuestaFinsolDTO)) return false;
        RegistroRespuestaFinsolDTO other = (RegistroRespuestaFinsolDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato()))) &&
            this.folio_cheque == other.getFolio_cheque();
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
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        _hashCode += new Long(getFolio_cheque()).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegistroRespuestaFinsolDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/ChequesOperacionWS/", "RegistroRespuestaFinsolDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio_cheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folio_cheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
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
