/**
 * DepositosGarantiaPeticion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public class DepositosGarantiaPeticion  extends mx.com.findep.depositosgarantia.ws.ObjetoValor  implements java.io.Serializable {
    private java.lang.String contrato;

    private java.lang.String fecha;

    private double importe;

    private java.lang.String integranteSaldoGarantia;

    private java.lang.String medioPago;

    private java.lang.String noIntegrante;

    private java.lang.String tipoAplicacion;

    private java.lang.String transaccion;

    private java.lang.String usuario;

    public DepositosGarantiaPeticion() {
    }

    public DepositosGarantiaPeticion(
           int tipo,
           java.lang.String contrato,
           java.lang.String fecha,
           double importe,
           java.lang.String integranteSaldoGarantia,
           java.lang.String medioPago,
           java.lang.String noIntegrante,
           java.lang.String tipoAplicacion,
           java.lang.String transaccion,
           java.lang.String usuario) {
        super(
            tipo);
        this.contrato = contrato;
        this.fecha = fecha;
        this.importe = importe;
        this.integranteSaldoGarantia = integranteSaldoGarantia;
        this.medioPago = medioPago;
        this.noIntegrante = noIntegrante;
        this.tipoAplicacion = tipoAplicacion;
        this.transaccion = transaccion;
        this.usuario = usuario;
    }


    /**
     * Gets the contrato value for this DepositosGarantiaPeticion.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this DepositosGarantiaPeticion.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the fecha value for this DepositosGarantiaPeticion.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this DepositosGarantiaPeticion.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the importe value for this DepositosGarantiaPeticion.
     * 
     * @return importe
     */
    public double getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this DepositosGarantiaPeticion.
     * 
     * @param importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }


    /**
     * Gets the integranteSaldoGarantia value for this DepositosGarantiaPeticion.
     * 
     * @return integranteSaldoGarantia
     */
    public java.lang.String getIntegranteSaldoGarantia() {
        return integranteSaldoGarantia;
    }


    /**
     * Sets the integranteSaldoGarantia value for this DepositosGarantiaPeticion.
     * 
     * @param integranteSaldoGarantia
     */
    public void setIntegranteSaldoGarantia(java.lang.String integranteSaldoGarantia) {
        this.integranteSaldoGarantia = integranteSaldoGarantia;
    }


    /**
     * Gets the medioPago value for this DepositosGarantiaPeticion.
     * 
     * @return medioPago
     */
    public java.lang.String getMedioPago() {
        return medioPago;
    }


    /**
     * Sets the medioPago value for this DepositosGarantiaPeticion.
     * 
     * @param medioPago
     */
    public void setMedioPago(java.lang.String medioPago) {
        this.medioPago = medioPago;
    }


    /**
     * Gets the noIntegrante value for this DepositosGarantiaPeticion.
     * 
     * @return noIntegrante
     */
    public java.lang.String getNoIntegrante() {
        return noIntegrante;
    }


    /**
     * Sets the noIntegrante value for this DepositosGarantiaPeticion.
     * 
     * @param noIntegrante
     */
    public void setNoIntegrante(java.lang.String noIntegrante) {
        this.noIntegrante = noIntegrante;
    }


    /**
     * Gets the tipoAplicacion value for this DepositosGarantiaPeticion.
     * 
     * @return tipoAplicacion
     */
    public java.lang.String getTipoAplicacion() {
        return tipoAplicacion;
    }


    /**
     * Sets the tipoAplicacion value for this DepositosGarantiaPeticion.
     * 
     * @param tipoAplicacion
     */
    public void setTipoAplicacion(java.lang.String tipoAplicacion) {
        this.tipoAplicacion = tipoAplicacion;
    }


    /**
     * Gets the transaccion value for this DepositosGarantiaPeticion.
     * 
     * @return transaccion
     */
    public java.lang.String getTransaccion() {
        return transaccion;
    }


    /**
     * Sets the transaccion value for this DepositosGarantiaPeticion.
     * 
     * @param transaccion
     */
    public void setTransaccion(java.lang.String transaccion) {
        this.transaccion = transaccion;
    }


    /**
     * Gets the usuario value for this DepositosGarantiaPeticion.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this DepositosGarantiaPeticion.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DepositosGarantiaPeticion)) return false;
        DepositosGarantiaPeticion other = (DepositosGarantiaPeticion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            this.importe == other.getImporte() &&
            ((this.integranteSaldoGarantia==null && other.getIntegranteSaldoGarantia()==null) || 
             (this.integranteSaldoGarantia!=null &&
              this.integranteSaldoGarantia.equals(other.getIntegranteSaldoGarantia()))) &&
            ((this.medioPago==null && other.getMedioPago()==null) || 
             (this.medioPago!=null &&
              this.medioPago.equals(other.getMedioPago()))) &&
            ((this.noIntegrante==null && other.getNoIntegrante()==null) || 
             (this.noIntegrante!=null &&
              this.noIntegrante.equals(other.getNoIntegrante()))) &&
            ((this.tipoAplicacion==null && other.getTipoAplicacion()==null) || 
             (this.tipoAplicacion!=null &&
              this.tipoAplicacion.equals(other.getTipoAplicacion()))) &&
            ((this.transaccion==null && other.getTransaccion()==null) || 
             (this.transaccion!=null &&
              this.transaccion.equals(other.getTransaccion()))) &&
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
        int _hashCode = super.hashCode();
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        _hashCode += new Double(getImporte()).hashCode();
        if (getIntegranteSaldoGarantia() != null) {
            _hashCode += getIntegranteSaldoGarantia().hashCode();
        }
        if (getMedioPago() != null) {
            _hashCode += getMedioPago().hashCode();
        }
        if (getNoIntegrante() != null) {
            _hashCode += getNoIntegrante().hashCode();
        }
        if (getTipoAplicacion() != null) {
            _hashCode += getTipoAplicacion().hashCode();
        }
        if (getTransaccion() != null) {
            _hashCode += getTransaccion().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DepositosGarantiaPeticion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "depositosGarantiaPeticion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("importe");
        elemField.setXmlName(new javax.xml.namespace.QName("", "importe"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("integranteSaldoGarantia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "integranteSaldoGarantia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("medioPago");
        elemField.setXmlName(new javax.xml.namespace.QName("", "medioPago"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
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
        elemField.setFieldName("tipoAplicacion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipoAplicacion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("transaccion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "transaccion"));
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
