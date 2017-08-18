/**
 * AsignacionRespuesta.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.finsol.asignacion;

public class AsignacionRespuesta  implements java.io.Serializable {
    private boolean estatus;

    private java.lang.String mensaje;

    private java.lang.String nombrePersona;

    private java.lang.String numeroPersona;

    private java.lang.String uid;

    public AsignacionRespuesta() {
    }

    public AsignacionRespuesta(
           boolean estatus,
           java.lang.String mensaje,
           java.lang.String nombrePersona,
           java.lang.String numeroPersona,
           java.lang.String uid) {
           this.estatus = estatus;
           this.mensaje = mensaje;
           this.nombrePersona = nombrePersona;
           this.numeroPersona = numeroPersona;
           this.uid = uid;
    }


    /**
     * Gets the estatus value for this AsignacionRespuesta.
     * 
     * @return estatus
     */
    public boolean isEstatus() {
        return estatus;
    }


    /**
     * Sets the estatus value for this AsignacionRespuesta.
     * 
     * @param estatus
     */
    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }


    /**
     * Gets the mensaje value for this AsignacionRespuesta.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this AsignacionRespuesta.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the nombrePersona value for this AsignacionRespuesta.
     * 
     * @return nombrePersona
     */
    public java.lang.String getNombrePersona() {
        return nombrePersona;
    }


    /**
     * Sets the nombrePersona value for this AsignacionRespuesta.
     * 
     * @param nombrePersona
     */
    public void setNombrePersona(java.lang.String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }


    /**
     * Gets the numeroPersona value for this AsignacionRespuesta.
     * 
     * @return numeroPersona
     */
    public java.lang.String getNumeroPersona() {
        return numeroPersona;
    }


    /**
     * Sets the numeroPersona value for this AsignacionRespuesta.
     * 
     * @param numeroPersona
     */
    public void setNumeroPersona(java.lang.String numeroPersona) {
        this.numeroPersona = numeroPersona;
    }


    /**
     * Gets the uid value for this AsignacionRespuesta.
     * 
     * @return uid
     */
    public java.lang.String getUid() {
        return uid;
    }


    /**
     * Sets the uid value for this AsignacionRespuesta.
     * 
     * @param uid
     */
    public void setUid(java.lang.String uid) {
        this.uid = uid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AsignacionRespuesta)) return false;
        AsignacionRespuesta other = (AsignacionRespuesta) obj;
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
            ((this.nombrePersona==null && other.getNombrePersona()==null) || 
             (this.nombrePersona!=null &&
              this.nombrePersona.equals(other.getNombrePersona()))) &&
            ((this.numeroPersona==null && other.getNumeroPersona()==null) || 
             (this.numeroPersona!=null &&
              this.numeroPersona.equals(other.getNumeroPersona()))) &&
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
        if (getNombrePersona() != null) {
            _hashCode += getNombrePersona().hashCode();
        }
        if (getNumeroPersona() != null) {
            _hashCode += getNumeroPersona().hashCode();
        }
        if (getUid() != null) {
            _hashCode += getUid().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AsignacionRespuesta.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://asignacion.finsol.findep.com/", "asignacionRespuesta"));
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
        elemField.setFieldName("nombrePersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombrePersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
