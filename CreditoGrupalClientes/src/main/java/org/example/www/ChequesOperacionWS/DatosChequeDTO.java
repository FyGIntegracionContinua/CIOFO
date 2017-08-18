/**
 * DatosChequeDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ChequesOperacionWS;

public class DatosChequeDTO  implements java.io.Serializable {
    private java.lang.String cliente;

    private long folioCheque;

    private double monto;

    private java.lang.String fechaCaptura;

    private java.lang.String fechaImprime;

    private java.lang.String estatus;

    private int claveEstatus;

    private java.lang.String banco;

    private int claveBanco;

    private java.lang.String beneficiario;

    private long numeroCheque;

    private java.lang.String sucursal;

    private long ultimoFolioCheque;

    private java.lang.String fechaCobro;

    public DatosChequeDTO() {
    }

    public DatosChequeDTO(
           java.lang.String cliente,
           long folioCheque,
           double monto,
           java.lang.String fechaCaptura,
           java.lang.String fechaImprime,
           java.lang.String estatus,
           int claveEstatus,
           java.lang.String banco,
           int claveBanco,
           java.lang.String beneficiario,
           long numeroCheque,
           java.lang.String sucursal,
           long ultimoFolioCheque,
           java.lang.String fechaCobro) {
           this.cliente = cliente;
           this.folioCheque = folioCheque;
           this.monto = monto;
           this.fechaCaptura = fechaCaptura;
           this.fechaImprime = fechaImprime;
           this.estatus = estatus;
           this.claveEstatus = claveEstatus;
           this.banco = banco;
           this.claveBanco = claveBanco;
           this.beneficiario = beneficiario;
           this.numeroCheque = numeroCheque;
           this.sucursal = sucursal;
           this.ultimoFolioCheque = ultimoFolioCheque;
           this.fechaCobro = fechaCobro;
    }


    /**
     * Gets the cliente value for this DatosChequeDTO.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this DatosChequeDTO.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the folioCheque value for this DatosChequeDTO.
     * 
     * @return folioCheque
     */
    public long getFolioCheque() {
        return folioCheque;
    }


    /**
     * Sets the folioCheque value for this DatosChequeDTO.
     * 
     * @param folioCheque
     */
    public void setFolioCheque(long folioCheque) {
        this.folioCheque = folioCheque;
    }


    /**
     * Gets the monto value for this DatosChequeDTO.
     * 
     * @return monto
     */
    public double getMonto() {
        return monto;
    }


    /**
     * Sets the monto value for this DatosChequeDTO.
     * 
     * @param monto
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }


    /**
     * Gets the fechaCaptura value for this DatosChequeDTO.
     * 
     * @return fechaCaptura
     */
    public java.lang.String getFechaCaptura() {
        return fechaCaptura;
    }


    /**
     * Sets the fechaCaptura value for this DatosChequeDTO.
     * 
     * @param fechaCaptura
     */
    public void setFechaCaptura(java.lang.String fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }


    /**
     * Gets the fechaImprime value for this DatosChequeDTO.
     * 
     * @return fechaImprime
     */
    public java.lang.String getFechaImprime() {
        return fechaImprime;
    }


    /**
     * Sets the fechaImprime value for this DatosChequeDTO.
     * 
     * @param fechaImprime
     */
    public void setFechaImprime(java.lang.String fechaImprime) {
        this.fechaImprime = fechaImprime;
    }


    /**
     * Gets the estatus value for this DatosChequeDTO.
     * 
     * @return estatus
     */
    public java.lang.String getEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this DatosChequeDTO.
     * 
     * @param estatus
     */
    public void setEstatus(java.lang.String estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the claveEstatus value for this DatosChequeDTO.
     * 
     * @return claveEstatus
     */
    public int getClaveEstatus() {
        return claveEstatus;
    }


    /**
     * Sets the claveEstatus value for this DatosChequeDTO.
     * 
     * @param claveEstatus
     */
    public void setClaveEstatus(int claveEstatus) {
        this.claveEstatus = claveEstatus;
    }


    /**
     * Gets the banco value for this DatosChequeDTO.
     * 
     * @return banco
     */
    public java.lang.String getBanco() {
        return banco;
    }


    /**
     * Sets the banco value for this DatosChequeDTO.
     * 
     * @param banco
     */
    public void setBanco(java.lang.String banco) {
        this.banco = banco;
    }


    /**
     * Gets the claveBanco value for this DatosChequeDTO.
     * 
     * @return claveBanco
     */
    public int getClaveBanco() {
        return claveBanco;
    }


    /**
     * Sets the claveBanco value for this DatosChequeDTO.
     * 
     * @param claveBanco
     */
    public void setClaveBanco(int claveBanco) {
        this.claveBanco = claveBanco;
    }


    /**
     * Gets the beneficiario value for this DatosChequeDTO.
     * 
     * @return beneficiario
     */
    public java.lang.String getBeneficiario() {
        return beneficiario;
    }


    /**
     * Sets the beneficiario value for this DatosChequeDTO.
     * 
     * @param beneficiario
     */
    public void setBeneficiario(java.lang.String beneficiario) {
        this.beneficiario = beneficiario;
    }


    /**
     * Gets the numeroCheque value for this DatosChequeDTO.
     * 
     * @return numeroCheque
     */
    public long getNumeroCheque() {
        return numeroCheque;
    }


    /**
     * Sets the numeroCheque value for this DatosChequeDTO.
     * 
     * @param numeroCheque
     */
    public void setNumeroCheque(long numeroCheque) {
        this.numeroCheque = numeroCheque;
    }


    /**
     * Gets the sucursal value for this DatosChequeDTO.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this DatosChequeDTO.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the ultimoFolioCheque value for this DatosChequeDTO.
     * 
     * @return ultimoFolioCheque
     */
    public long getUltimoFolioCheque() {
        return ultimoFolioCheque;
    }


    /**
     * Sets the ultimoFolioCheque value for this DatosChequeDTO.
     * 
     * @param ultimoFolioCheque
     */
    public void setUltimoFolioCheque(long ultimoFolioCheque) {
        this.ultimoFolioCheque = ultimoFolioCheque;
    }


    /**
     * Gets the fechaCobro value for this DatosChequeDTO.
     * 
     * @return fechaCobro
     */
    public java.lang.String getFechaCobro() {
        return fechaCobro;
    }


    /**
     * Sets the fechaCobro value for this DatosChequeDTO.
     * 
     * @param fechaCobro
     */
    public void setFechaCobro(java.lang.String fechaCobro) {
        this.fechaCobro = fechaCobro;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DatosChequeDTO)) return false;
        DatosChequeDTO other = (DatosChequeDTO) obj;
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
            this.folioCheque == other.getFolioCheque() &&
            this.monto == other.getMonto() &&
            ((this.fechaCaptura==null && other.getFechaCaptura()==null) || 
             (this.fechaCaptura!=null &&
              this.fechaCaptura.equals(other.getFechaCaptura()))) &&
            ((this.fechaImprime==null && other.getFechaImprime()==null) || 
             (this.fechaImprime!=null &&
              this.fechaImprime.equals(other.getFechaImprime()))) &&
            ((this.estatus==null && other.getEstatus()==null) || 
             (this.estatus!=null &&
              this.estatus.equals(other.getEstatus()))) &&
            this.claveEstatus == other.getClaveEstatus() &&
            ((this.banco==null && other.getBanco()==null) || 
             (this.banco!=null &&
              this.banco.equals(other.getBanco()))) &&
            this.claveBanco == other.getClaveBanco() &&
            ((this.beneficiario==null && other.getBeneficiario()==null) || 
             (this.beneficiario!=null &&
              this.beneficiario.equals(other.getBeneficiario()))) &&
            this.numeroCheque == other.getNumeroCheque() &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            this.ultimoFolioCheque == other.getUltimoFolioCheque() &&
            ((this.fechaCobro==null && other.getFechaCobro()==null) || 
             (this.fechaCobro!=null &&
              this.fechaCobro.equals(other.getFechaCobro())));
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
        _hashCode += new Long(getFolioCheque()).hashCode();
        _hashCode += new Double(getMonto()).hashCode();
        if (getFechaCaptura() != null) {
            _hashCode += getFechaCaptura().hashCode();
        }
        if (getFechaImprime() != null) {
            _hashCode += getFechaImprime().hashCode();
        }
        if (getEstatus() != null) {
            _hashCode += getEstatus().hashCode();
        }
        _hashCode += getClaveEstatus();
        if (getBanco() != null) {
            _hashCode += getBanco().hashCode();
        }
        _hashCode += getClaveBanco();
        if (getBeneficiario() != null) {
            _hashCode += getBeneficiario().hashCode();
        }
        _hashCode += new Long(getNumeroCheque()).hashCode();
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        _hashCode += new Long(getUltimoFolioCheque()).hashCode();
        if (getFechaCobro() != null) {
            _hashCode += getFechaCobro().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DatosChequeDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/ChequesOperacionWS/", "DatosChequeDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("folioCheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "folioCheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCaptura");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaCaptura"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaImprime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaImprime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveEstatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claveEstatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("banco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "banco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("claveBanco");
        elemField.setXmlName(new javax.xml.namespace.QName("", "claveBanco"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "beneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroCheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroCheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ultimoFolioCheque");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ultimoFolioCheque"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "long"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaCobro");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaCobro"));
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
