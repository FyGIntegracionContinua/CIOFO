/**
 * ReversosGarantiaPeticion.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public class ReversosGarantiaPeticion  extends mx.com.findep.depositosgarantia.ws.ObjetoValor  implements java.io.Serializable {
    private java.lang.String codigo;

    private java.lang.String contrato;

    private java.lang.String contratoNuevo;

    private java.lang.String fechaHora;

    private java.lang.String fechaValor;

    private java.lang.String usuario;

    public ReversosGarantiaPeticion() {
    }

    public ReversosGarantiaPeticion(
           int tipo,
           java.lang.String codigo,
           java.lang.String contrato,
           java.lang.String contratoNuevo,
           java.lang.String fechaHora,
           java.lang.String fechaValor,
           java.lang.String usuario) {
        super(
            tipo);
        this.codigo = codigo;
        this.contrato = contrato;
        this.contratoNuevo = contratoNuevo;
        this.fechaHora = fechaHora;
        this.fechaValor = fechaValor;
        this.usuario = usuario;
    }


    /**
     * Gets the codigo value for this ReversosGarantiaPeticion.
     * 
     * @return codigo
     */
    public java.lang.String getCodigo() {
        return codigo;
    }


    /**
     * Sets the codigo value for this ReversosGarantiaPeticion.
     * 
     * @param codigo
     */
    public void setCodigo(java.lang.String codigo) {
        this.codigo = codigo;
    }


    /**
     * Gets the contrato value for this ReversosGarantiaPeticion.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this ReversosGarantiaPeticion.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the contratoNuevo value for this ReversosGarantiaPeticion.
     * 
     * @return contratoNuevo
     */
    public java.lang.String getContratoNuevo() {
        return contratoNuevo;
    }


    /**
     * Sets the contratoNuevo value for this ReversosGarantiaPeticion.
     * 
     * @param contratoNuevo
     */
    public void setContratoNuevo(java.lang.String contratoNuevo) {
        this.contratoNuevo = contratoNuevo;
    }


    /**
     * Gets the fechaHora value for this ReversosGarantiaPeticion.
     * 
     * @return fechaHora
     */
    public java.lang.String getFechaHora() {
        return fechaHora;
    }


    /**
     * Sets the fechaHora value for this ReversosGarantiaPeticion.
     * 
     * @param fechaHora
     */
    public void setFechaHora(java.lang.String fechaHora) {
        this.fechaHora = fechaHora;
    }


    /**
     * Gets the fechaValor value for this ReversosGarantiaPeticion.
     * 
     * @return fechaValor
     */
    public java.lang.String getFechaValor() {
        return fechaValor;
    }


    /**
     * Sets the fechaValor value for this ReversosGarantiaPeticion.
     * 
     * @param fechaValor
     */
    public void setFechaValor(java.lang.String fechaValor) {
        this.fechaValor = fechaValor;
    }


    /**
     * Gets the usuario value for this ReversosGarantiaPeticion.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this ReversosGarantiaPeticion.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ReversosGarantiaPeticion)) return false;
        ReversosGarantiaPeticion other = (ReversosGarantiaPeticion) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.codigo==null && other.getCodigo()==null) || 
             (this.codigo!=null &&
              this.codigo.equals(other.getCodigo()))) &&
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato()))) &&
            ((this.contratoNuevo==null && other.getContratoNuevo()==null) || 
             (this.contratoNuevo!=null &&
              this.contratoNuevo.equals(other.getContratoNuevo()))) &&
            ((this.fechaHora==null && other.getFechaHora()==null) || 
             (this.fechaHora!=null &&
              this.fechaHora.equals(other.getFechaHora()))) &&
            ((this.fechaValor==null && other.getFechaValor()==null) || 
             (this.fechaValor!=null &&
              this.fechaValor.equals(other.getFechaValor()))) &&
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
        if (getCodigo() != null) {
            _hashCode += getCodigo().hashCode();
        }
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        if (getContratoNuevo() != null) {
            _hashCode += getContratoNuevo().hashCode();
        }
        if (getFechaHora() != null) {
            _hashCode += getFechaHora().hashCode();
        }
        if (getFechaValor() != null) {
            _hashCode += getFechaValor().hashCode();
        }
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ReversosGarantiaPeticion.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "reversosGarantiaPeticion"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("codigo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "codigo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contratoNuevo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contratoNuevo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaHora");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaHora"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaValor");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaValor"));
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
