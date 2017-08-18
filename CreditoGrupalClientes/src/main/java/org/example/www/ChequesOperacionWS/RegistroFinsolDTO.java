/**
 * RegistroFinsolDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ChequesOperacionWS;

public class RegistroFinsolDTO  implements java.io.Serializable {
    private java.lang.String cliente;

    private java.lang.String contrato;

    private double monto_cheque;

    private java.lang.String beneficiario;

    private int empresa;

    private int tipo_transaccion;

    private int transaccion;

    private java.lang.String num_sucursal;

    private long folio_cheque;

    private java.lang.String usuario;

    private java.lang.String categoria;

    private int clave_cuenta;

    private int tipo_cuenta;

    public RegistroFinsolDTO() {
    }

    public RegistroFinsolDTO(
           java.lang.String cliente,
           java.lang.String contrato,
           double monto_cheque,
           java.lang.String beneficiario,
           int empresa,
           int tipo_transaccion,
           int transaccion,
           java.lang.String num_sucursal,
           long folio_cheque,
           java.lang.String usuario,
           java.lang.String categoria,
           int clave_cuenta,
           int tipo_cuenta) {
           this.cliente = cliente;
           this.contrato = contrato;
           this.monto_cheque = monto_cheque;
           this.beneficiario = beneficiario;
           this.empresa = empresa;
           this.tipo_transaccion = tipo_transaccion;
           this.transaccion = transaccion;
           this.num_sucursal = num_sucursal;
           this.folio_cheque = folio_cheque;
           this.usuario = usuario;
           this.categoria = categoria;
           this.clave_cuenta = clave_cuenta;
           this.tipo_cuenta = tipo_cuenta;
    }


    /**
     * Gets the cliente value for this RegistroFinsolDTO.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this RegistroFinsolDTO.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the contrato value for this RegistroFinsolDTO.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this RegistroFinsolDTO.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the monto_cheque value for this RegistroFinsolDTO.
     * 
     * @return monto_cheque
     */
    public double getMonto_cheque() {
        return monto_cheque;
    }


    /**
     * Sets the monto_cheque value for this RegistroFinsolDTO.
     * 
     * @param monto_cheque
     */
    public void setMonto_cheque(double monto_cheque) {
        this.monto_cheque = monto_cheque;
    }


    /**
     * Gets the beneficiario value for this RegistroFinsolDTO.
     * 
     * @return beneficiario
     */
    public java.lang.String getBeneficiario() {
        return beneficiario;
    }


    /**
     * Sets the beneficiario value for this RegistroFinsolDTO.
     * 
     * @param beneficiario
     */
    public void setBeneficiario(java.lang.String beneficiario) {
        this.beneficiario = beneficiario;
    }


    /**
     * Gets the empresa value for this RegistroFinsolDTO.
     * 
     * @return empresa
     */
    public int getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this RegistroFinsolDTO.
     * 
     * @param empresa
     */
    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the tipo_transaccion value for this RegistroFinsolDTO.
     * 
     * @return tipo_transaccion
     */
    public int getTipo_transaccion() {
        return tipo_transaccion;
    }


    /**
     * Sets the tipo_transaccion value for this RegistroFinsolDTO.
     * 
     * @param tipo_transaccion
     */
    public void setTipo_transaccion(int tipo_transaccion) {
        this.tipo_transaccion = tipo_transaccion;
    }


    /**
     * Gets the transaccion value for this RegistroFinsolDTO.
     * 
     * @return transaccion
     */
    public int getTransaccion() {
        return transaccion;
    }


    /**
     * Sets the transaccion value for this RegistroFinsolDTO.
     * 
     * @param transaccion
     */
    public void setTransaccion(int transaccion) {
        this.transaccion = transaccion;
    }


    /**
     * Gets the num_sucursal value for this RegistroFinsolDTO.
     * 
     * @return num_sucursal
     */
    public java.lang.String getNum_sucursal() {
        return num_sucursal;
    }


    /**
     * Sets the num_sucursal value for this RegistroFinsolDTO.
     * 
     * @param num_sucursal
     */
    public void setNum_sucursal(java.lang.String num_sucursal) {
        this.num_sucursal = num_sucursal;
    }


    /**
     * Gets the folio_cheque value for this RegistroFinsolDTO.
     * 
     * @return folio_cheque
     */
    public long getFolio_cheque() {
        return folio_cheque;
    }


    /**
     * Sets the folio_cheque value for this RegistroFinsolDTO.
     * 
     * @param folio_cheque
     */
    public void setFolio_cheque(long folio_cheque) {
        this.folio_cheque = folio_cheque;
    }


    /**
     * Gets the usuario value for this RegistroFinsolDTO.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this RegistroFinsolDTO.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }


    /**
     * Gets the categoria value for this RegistroFinsolDTO.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this RegistroFinsolDTO.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the clave_cuenta value for this RegistroFinsolDTO.
     * 
     * @return clave_cuenta
     */
    public int getClave_cuenta() {
        return clave_cuenta;
    }


    /**
     * Sets the clave_cuenta value for this RegistroFinsolDTO.
     * 
     * @param clave_cuenta
     */
    public void setClave_cuenta(int clave_cuenta) {
        this.clave_cuenta = clave_cuenta;
    }


    /**
     * Gets the tipo_cuenta value for this RegistroFinsolDTO.
     * 
     * @return tipo_cuenta
     */
    public int getTipo_cuenta() {
        return tipo_cuenta;
    }


    /**
     * Sets the tipo_cuenta value for this RegistroFinsolDTO.
     * 
     * @param tipo_cuenta
     */
    public void setTipo_cuenta(int tipo_cuenta) {
        this.tipo_cuenta = tipo_cuenta;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RegistroFinsolDTO)) return false;
        RegistroFinsolDTO other = (RegistroFinsolDTO) obj;
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
            this.monto_cheque == other.getMonto_cheque() &&
            ((this.beneficiario==null && other.getBeneficiario()==null) || 
             (this.beneficiario!=null &&
              this.beneficiario.equals(other.getBeneficiario()))) &&
            this.empresa == other.getEmpresa() &&
            this.tipo_transaccion == other.getTipo_transaccion() &&
            this.transaccion == other.getTransaccion() &&
            ((this.num_sucursal==null && other.getNum_sucursal()==null) || 
             (this.num_sucursal!=null &&
              this.num_sucursal.equals(other.getNum_sucursal()))) &&
            this.folio_cheque == other.getFolio_cheque() &&
            ((this.usuario==null && other.getUsuario()==null) || 
             (this.usuario!=null &&
              this.usuario.equals(other.getUsuario()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            this.clave_cuenta == other.getClave_cuenta() &&
            this.tipo_cuenta == other.getTipo_cuenta();
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
        _hashCode += new Double(getMonto_cheque()).hashCode();
        if (getBeneficiario() != null) {
            _hashCode += getBeneficiario().hashCode();
        }
        _hashCode += getEmpresa();
        _hashCode += getTipo_transaccion();
        _hashCode += getTransaccion();
        if (getNum_sucursal() != null) {
            _hashCode += getNum_sucursal().hashCode();
        }
        _hashCode += new Long(getFolio_cheque()).hashCode();
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        _hashCode += getClave_cuenta();
        _hashCode += getTipo_cuenta();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RegistroFinsolDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/ChequesOperacionWS/", "RegistroFinsolDTO"));
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
        elemField.setFieldName("monto_cheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monto_cheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "beneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo_transaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transaccion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("num_sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "num_sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folio_cheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folio_cheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("usuario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "usuario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave_cuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clave_cuenta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_cuenta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo_cuenta"));
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
