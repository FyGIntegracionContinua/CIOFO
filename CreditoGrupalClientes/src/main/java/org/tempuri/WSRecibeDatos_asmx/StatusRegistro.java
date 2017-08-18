/**
 * StatusRegistro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class StatusRegistro  implements java.io.Serializable {
    private java.lang.String usuario;

    private java.lang.String password;

    private java.lang.String cliente;

    private java.lang.String campaña;

    private java.lang.String idenvio;

    private java.lang.String referencia_cliente;

    public StatusRegistro() {
    }

    public StatusRegistro(
           java.lang.String usuario,
           java.lang.String password,
           java.lang.String cliente,
           java.lang.String campaña,
           java.lang.String idenvio,
           java.lang.String referencia_cliente) {
           this.usuario = usuario;
           this.password = password;
           this.cliente = cliente;
           this.campaña = campaña;
           this.idenvio = idenvio;
           this.referencia_cliente = referencia_cliente;
    }


    /**
     * Gets the usuario value for this StatusRegistro.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this StatusRegistro.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the password value for this StatusRegistro.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this StatusRegistro.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the cliente value for this StatusRegistro.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this StatusRegistro.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the campaña value for this StatusRegistro.
     * 
     * @return campaña
     */
    public java.lang.String getCampaña() {
        return campaña;
    }


    /**
     * Sets the campaña value for this StatusRegistro.
     * 
     * @param campaña
     */
    public void setCampaña(java.lang.String campaña) {
        this.campaña = campaña;
    }


    /**
     * Gets the idenvio value for this StatusRegistro.
     * 
     * @return idenvio
     */
    public java.lang.String getIdenvio() {
        return idenvio;
    }


    /**
     * Sets the idenvio value for this StatusRegistro.
     * 
     * @param idenvio
     */
    public void setIdenvio(java.lang.String idenvio) {
        this.idenvio = idenvio;
    }


    /**
     * Gets the referencia_cliente value for this StatusRegistro.
     * 
     * @return referencia_cliente
     */
    public java.lang.String getReferencia_cliente() {
        return referencia_cliente;
    }


    /**
     * Sets the referencia_cliente value for this StatusRegistro.
     * 
     * @param referencia_cliente
     */
    public void setReferencia_cliente(java.lang.String referencia_cliente) {
        this.referencia_cliente = referencia_cliente;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StatusRegistro)) return false;
        StatusRegistro other = (StatusRegistro) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.password==null && other.getPassword()==null) || 
             (this.password!=null &&
              this.password.equals(other.getPassword()))) &&
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.campaña==null && other.getCampaña()==null) || 
             (this.campaña!=null &&
              this.campaña.equals(other.getCampaña()))) &&
            ((this.idenvio==null && other.getIdenvio()==null) || 
             (this.idenvio!=null &&
              this.idenvio.equals(other.getIdenvio()))) &&
            ((this.referencia_cliente==null && other.getReferencia_cliente()==null) || 
             (this.referencia_cliente!=null &&
              this.referencia_cliente.equals(other.getReferencia_cliente())));
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
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getPassword() != null) {
            _hashCode += getPassword().hashCode();
        }
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getCampaña() != null) {
            _hashCode += getCampaña().hashCode();
        }
        if (getIdenvio() != null) {
            _hashCode += getIdenvio().hashCode();
        }
        if (getReferencia_cliente() != null) {
            _hashCode += getReferencia_cliente().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StatusRegistro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">StatusRegistro"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("password");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "password"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaña");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "campaña"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idenvio");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "idenvio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("referencia_cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "referencia_cliente"));
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
