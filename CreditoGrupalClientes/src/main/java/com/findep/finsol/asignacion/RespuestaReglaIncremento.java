/**
 * RespuestaReglaIncremento.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.finsol.asignacion;

public class RespuestaReglaIncremento  implements java.io.Serializable {
    private boolean estatus;

    private java.lang.String mensaje;

    private boolean otorgaCredito;

    private java.lang.Double porcentajeIncremento;

    private java.lang.String uid;

    public RespuestaReglaIncremento() {
    }

    public RespuestaReglaIncremento(
           boolean estatus,
           java.lang.String mensaje,
           boolean otorgaCredito,
           java.lang.Double porcentajeIncremento,
           java.lang.String uid) {
           this.estatus = estatus;
           this.mensaje = mensaje;
           this.otorgaCredito = otorgaCredito;
           this.porcentajeIncremento = porcentajeIncremento;
           this.uid = uid;
    }


    /**
     * Gets the estatus value for this RespuestaReglaIncremento.
     * 
     * @return estatus
     */
    public boolean isEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this RespuestaReglaIncremento.
     * 
     * @param estatus
     */
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the mensaje value for this RespuestaReglaIncremento.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this RespuestaReglaIncremento.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the otorgaCredito value for this RespuestaReglaIncremento.
     * 
     * @return otorgaCredito
     */
    public boolean isOtorgaCredito() {
        return otorgaCredito;
    }


    /**
     * Sets the otorgaCredito value for this RespuestaReglaIncremento.
     * 
     * @param otorgaCredito
     */
    public void setOtorgaCredito(boolean otorgaCredito) {
        this.otorgaCredito = otorgaCredito;
    }


    /**
     * Gets the porcentajeIncremento value for this RespuestaReglaIncremento.
     * 
     * @return porcentajeIncremento
     */
    public java.lang.Double getPorcentajeIncremento() {
        return porcentajeIncremento;
    }


    /**
     * Sets the porcentajeIncremento value for this RespuestaReglaIncremento.
     * 
     * @param porcentajeIncremento
     */
    public void setPorcentajeIncremento(java.lang.Double porcentajeIncremento) {
        this.porcentajeIncremento = porcentajeIncremento;
    }


    /**
     * Gets the uid value for this RespuestaReglaIncremento.
     * 
     * @return uid
     */
    public java.lang.String getUid() {
        return uid;
    }


    /**
     * Sets the uid value for this RespuestaReglaIncremento.
     * 
     * @param uid
     */
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RespuestaReglaIncremento)) return false;
        RespuestaReglaIncremento other = (RespuestaReglaIncremento) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.estatus == other.isEstatus() &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            this.otorgaCredito == other.isOtorgaCredito() &&
            ((this.porcentajeIncremento==null && other.getPorcentajeIncremento()==null) || 
             (this.porcentajeIncremento!=null &&
              this.porcentajeIncremento.equals(other.getPorcentajeIncremento()))) &&
            ((this.uid==null && other.getUid()==null) || 
             (this.uid!=null &&
              this.uid.equals(other.getUid())));
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
        _hashCode += (isEstatus() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        _hashCode += (isOtorgaCredito() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        if (getPorcentajeIncremento() != null) {
            _hashCode += getPorcentajeIncremento().hashCode();
        }
        if (getUid() != null) {
            _hashCode += getUid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RespuestaReglaIncremento.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://asignacion.finsol.findep.com/", "respuestaReglaIncremento"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("estatus");
        elemField.setXmlName(new javax.xml.namespace.QName("", "estatus"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
        elemField.setFieldName("otorgaCredito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "otorgaCredito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("porcentajeIncremento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "porcentajeIncremento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("uid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "uid"));
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
