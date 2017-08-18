/**
 * ClientesChequesDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public class ClientesChequesDTO  implements java.io.Serializable {
    private java.lang.String contrato;

    private int folioCheque;

    private java.lang.String integrante;

    private java.lang.String mensaje;

    private double montoGarInt;

    private java.lang.String noIntegrante;

    private java.lang.String usuario;

    public ClientesChequesDTO() {
    }

    public ClientesChequesDTO(
           java.lang.String contrato,
           int folioCheque,
           java.lang.String integrante,
           java.lang.String mensaje,
           double montoGarInt,
           java.lang.String noIntegrante,
           java.lang.String usuario) {
           this.contrato = contrato;
           this.folioCheque = folioCheque;
           this.integrante = integrante;
           this.mensaje = mensaje;
           this.montoGarInt = montoGarInt;
           this.noIntegrante = noIntegrante;
           this.usuario = usuario;
    }


    /**
     * Gets the contrato value for this ClientesChequesDTO.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this ClientesChequesDTO.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the folioCheque value for this ClientesChequesDTO.
     * 
     * @return folioCheque
     */
    public int getFolioCheque() {
        return folioCheque;
    }


    /**
     * Sets the folioCheque value for this ClientesChequesDTO.
     * 
     * @param folioCheque
     */
    public void setFolioCheque(int folioCheque) {
        this.folioCheque = folioCheque;
    }


    /**
     * Gets the integrante value for this ClientesChequesDTO.
     * 
     * @return integrante
     */
    public java.lang.String getIntegrante() {
        return integrante;
    }


    /**
     * Sets the integrante value for this ClientesChequesDTO.
     * 
     * @param integrante
     */
    public void setIntegrante(java.lang.String integrante) {
        this.integrante = integrante;
    }


    /**
     * Gets the mensaje value for this ClientesChequesDTO.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this ClientesChequesDTO.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the montoGarInt value for this ClientesChequesDTO.
     * 
     * @return montoGarInt
     */
    public double getMontoGarInt() {
        return montoGarInt;
    }


    /**
     * Sets the montoGarInt value for this ClientesChequesDTO.
     * 
     * @param montoGarInt
     */
    public void setMontoGarInt(double montoGarInt) {
        this.montoGarInt = montoGarInt;
    }


    /**
     * Gets the noIntegrante value for this ClientesChequesDTO.
     * 
     * @return noIntegrante
     */
    public java.lang.String getNoIntegrante() {
        return noIntegrante;
    }


    /**
     * Sets the noIntegrante value for this ClientesChequesDTO.
     * 
     * @param noIntegrante
     */
    public void setNoIntegrante(java.lang.String noIntegrante) {
        this.noIntegrante = noIntegrante;
    }


    /**
     * Gets the usuario value for this ClientesChequesDTO.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this ClientesChequesDTO.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ClientesChequesDTO)) return false;
        ClientesChequesDTO other = (ClientesChequesDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato()))) &&
            this.folioCheque == other.getFolioCheque() &&
            ((this.integrante==null && other.getIntegrante()==null) || 
             (this.integrante!=null &&
              this.integrante.equals(other.getIntegrante()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            this.montoGarInt == other.getMontoGarInt() &&
            ((this.noIntegrante==null && other.getNoIntegrante()==null) || 
             (this.noIntegrante!=null &&
              this.noIntegrante.equals(other.getNoIntegrante()))) &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario())));
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
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        _hashCode += getFolioCheque();
        if (getIntegrante() != null) {
            _hashCode += getIntegrante().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        _hashCode += new Double(getMontoGarInt()).hashCode();
        if (getNoIntegrante() != null) {
            _hashCode += getNoIntegrante().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ClientesChequesDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "clientesChequesDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioCheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folioCheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integrante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "integrante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("montoGarInt");
        elemField.setXmlName(new javax.xml.namespace.QName("", "montoGarInt"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("noIntegrante");
        elemField.setXmlName(new javax.xml.namespace.QName("", "noIntegrante"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
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
