/**
 * ConfirmarEnvio_Registro.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class ConfirmarEnvio_Registro  implements java.io.Serializable {
    private java.lang.String usuario;

    private java.lang.String password;

    private java.lang.String cliente;

    private java.lang.String campaña;

    private java.lang.String idenvio;

    private java.lang.String referencia;

    private boolean correcto;

    private java.lang.String llave;

    public ConfirmarEnvio_Registro() {
    }

    public ConfirmarEnvio_Registro(
           java.lang.String usuario,
           java.lang.String password,
           java.lang.String cliente,
           java.lang.String campaña,
           java.lang.String idenvio,
           java.lang.String referencia,
           boolean correcto,
           java.lang.String llave) {
           this.usuario = usuario;
           this.password = password;
           this.cliente = cliente;
           this.campaña = campaña;
           this.idenvio = idenvio;
           this.referencia = referencia;
           this.correcto = correcto;
           this.llave = llave;
    }


    /**
     * Gets the usuario value for this ConfirmarEnvio_Registro.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this ConfirmarEnvio_Registro.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the password value for this ConfirmarEnvio_Registro.
     * 
     * @return password
     */
    public java.lang.String getPassword() {
        return password;
    }


    /**
     * Sets the password value for this ConfirmarEnvio_Registro.
     * 
     * @param password
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }


    /**
     * Gets the cliente value for this ConfirmarEnvio_Registro.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this ConfirmarEnvio_Registro.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the campaña value for this ConfirmarEnvio_Registro.
     * 
     * @return campaña
     */
    public java.lang.String getCampaña() {
        return campaña;
    }


    /**
     * Sets the campaña value for this ConfirmarEnvio_Registro.
     * 
     * @param campaña
     */
    public void setCampaña(java.lang.String campaña) {
        this.campaña = campaña;
    }


    /**
     * Gets the idenvio value for this ConfirmarEnvio_Registro.
     * 
     * @return idenvio
     */
    public java.lang.String getIdenvio() {
        return idenvio;
    }


    /**
     * Sets the idenvio value for this ConfirmarEnvio_Registro.
     * 
     * @param idenvio
     */
    public void setIdenvio(java.lang.String idenvio) {
        this.idenvio = idenvio;
    }


    /**
     * Gets the referencia value for this ConfirmarEnvio_Registro.
     * 
     * @return referencia
     */
    public java.lang.String getReferencia() {
        return referencia;
    }


    /**
     * Sets the referencia value for this ConfirmarEnvio_Registro.
     * 
     * @param referencia
     */
    public void setReferencia(java.lang.String referencia) {
        this.referencia = referencia;
    }


    /**
     * Gets the correcto value for this ConfirmarEnvio_Registro.
     * 
     * @return correcto
     */
    public boolean isCorrecto() {
        return correcto;
    }


    /**
     * Sets the correcto value for this ConfirmarEnvio_Registro.
     * 
     * @param correcto
     */
    public void setCorrecto(boolean correcto) {
        this.correcto = correcto;
    }


    /**
     * Gets the llave value for this ConfirmarEnvio_Registro.
     * 
     * @return llave
     */
    public java.lang.String getLlave() {
        return llave;
    }


    /**
     * Sets the llave value for this ConfirmarEnvio_Registro.
     * 
     * @param llave
     */
    public void setLlave(java.lang.String llave) {
        this.llave = llave;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConfirmarEnvio_Registro)) return false;
        ConfirmarEnvio_Registro other = (ConfirmarEnvio_Registro) obj;
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
            ((this.referencia==null && other.getReferencia()==null) || 
             (this.referencia!=null &&
              this.referencia.equals(other.getReferencia()))) &&
            this.correcto == other.isCorrecto() &&
            ((this.llave==null && other.getLlave()==null) || 
             (this.llave!=null &&
              this.llave.equals(other.getLlave())));
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
        if (getReferencia() != null) {
            _hashCode += getReferencia().hashCode();
        }
        _hashCode += (isCorrecto() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getLlave() != null) {
            _hashCode += getLlave().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConfirmarEnvio_Registro.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">ConfirmarEnvio_Registro"));
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
        elemField.setFieldName("referencia");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "referencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correcto");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "Correcto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("llave");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "llave"));
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
