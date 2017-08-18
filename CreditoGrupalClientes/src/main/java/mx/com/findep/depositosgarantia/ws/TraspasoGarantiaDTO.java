/**
 * TraspasoGarantiaDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public class TraspasoGarantiaDTO  implements java.io.Serializable {
    private java.lang.String contratoDestino;

    private java.lang.String contratoOrigen;

    private java.lang.String fecha;

    private double importe;

    private java.lang.String usuario;

    public TraspasoGarantiaDTO() {
    }

    public TraspasoGarantiaDTO(
           java.lang.String contratoDestino,
           java.lang.String contratoOrigen,
           java.lang.String fecha,
           double importe,
           java.lang.String usuario) {
           this.contratoDestino = contratoDestino;
           this.contratoOrigen = contratoOrigen;
           this.fecha = fecha;
           this.importe = importe;
           this.usuario = usuario;
    }


    /**
     * Gets the contratoDestino value for this TraspasoGarantiaDTO.
     * 
     * @return contratoDestino
     */
    public java.lang.String getContratoDestino() {
        return contratoDestino;
    }


    /**
     * Sets the contratoDestino value for this TraspasoGarantiaDTO.
     * 
     * @param contratoDestino
     */
    public void setContratoDestino(java.lang.String contratoDestino) {
        this.contratoDestino = contratoDestino;
    }


    /**
     * Gets the contratoOrigen value for this TraspasoGarantiaDTO.
     * 
     * @return contratoOrigen
     */
    public java.lang.String getContratoOrigen() {
        return contratoOrigen;
    }


    /**
     * Sets the contratoOrigen value for this TraspasoGarantiaDTO.
     * 
     * @param contratoOrigen
     */
    public void setContratoOrigen(java.lang.String contratoOrigen) {
        this.contratoOrigen = contratoOrigen;
    }


    /**
     * Gets the fecha value for this TraspasoGarantiaDTO.
     * 
     * @return fecha
     */
    public java.lang.String getFecha() {
        return fecha;
    }


    /**
     * Sets the fecha value for this TraspasoGarantiaDTO.
     * 
     * @param fecha
     */
    public void setFecha(java.lang.String fecha) {
        this.fecha = fecha;
    }


    /**
     * Gets the importe value for this TraspasoGarantiaDTO.
     * 
     * @return importe
     */
    public double getImporte() {
        return importe;
    }


    /**
     * Sets the importe value for this TraspasoGarantiaDTO.
     * 
     * @param importe
     */
    public void setImporte(double importe) {
        this.importe = importe;
    }


    /**
     * Gets the usuario value for this TraspasoGarantiaDTO.
     * 
     * @return usuario
     */
    public java.lang.String getUsuario() {
        return usuario;
    }


    /**
     * Sets the usuario value for this TraspasoGarantiaDTO.
     * 
     * @param usuario
     */
    public void setUsuario(java.lang.String usuario) {
        this.usuario = usuario;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof TraspasoGarantiaDTO)) return false;
        TraspasoGarantiaDTO other = (TraspasoGarantiaDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.contratoDestino==null && other.getContratoDestino()==null) || 
             (this.contratoDestino!=null &&
              this.contratoDestino.equals(other.getContratoDestino()))) &&
            ((this.contratoOrigen==null && other.getContratoOrigen()==null) || 
             (this.contratoOrigen!=null &&
              this.contratoOrigen.equals(other.getContratoOrigen()))) &&
            ((this.fecha==null && other.getFecha()==null) || 
             (this.fecha!=null &&
              this.fecha.equals(other.getFecha()))) &&
            this.importe == other.getImporte() &&
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
        if (getContratoDestino() != null) {
            _hashCode += getContratoDestino().hashCode();
        }
        if (getContratoOrigen() != null) {
            _hashCode += getContratoOrigen().hashCode();
        }
        if (getFecha() != null) {
            _hashCode += getFecha().hashCode();
        }
        _hashCode += new Double(getImporte()).hashCode();
        if (getUsuario() != null) {
            _hashCode += getUsuario().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TraspasoGarantiaDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "traspasoGarantiaDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contratoDestino");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contratoDestino"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contratoOrigen");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contratoOrigen"));
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
