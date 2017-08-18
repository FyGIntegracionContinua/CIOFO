/**
 * AutenticarBuroResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.schema;

public class AutenticarBuroResponse  implements java.io.Serializable {
    private java.lang.String respuesta;

    private java.lang.String mensaje;

    private java.lang.String idCallCenter;

    public AutenticarBuroResponse() {
    }

    public AutenticarBuroResponse(
           java.lang.String respuesta,
           java.lang.String mensaje,
           java.lang.String idCallCenter) {
           this.respuesta = respuesta;
           this.mensaje = mensaje;
           this.idCallCenter = idCallCenter;
    }


    /**
     * Gets the respuesta value for this AutenticarBuroResponse.
     * 
     * @return respuesta
     */
    public java.lang.String getRespuesta() {
        return respuesta;
    }


    /**
     * Sets the respuesta value for this AutenticarBuroResponse.
     * 
     * @param respuesta
     */
    public void setRespuesta(java.lang.String respuesta) {
        this.respuesta = respuesta;
    }


    /**
     * Gets the mensaje value for this AutenticarBuroResponse.
     * 
     * @return mensaje
     */
    public java.lang.String getMensaje() {
        return mensaje;
    }


    /**
     * Sets the mensaje value for this AutenticarBuroResponse.
     * 
     * @param mensaje
     */
    public void setMensaje(java.lang.String mensaje) {
        this.mensaje = mensaje;
    }


    /**
     * Gets the idCallCenter value for this AutenticarBuroResponse.
     * 
     * @return idCallCenter
     */
    public java.lang.String getIdCallCenter() {
        return idCallCenter;
    }


    /**
     * Sets the idCallCenter value for this AutenticarBuroResponse.
     * 
     * @param idCallCenter
     */
    public void setIdCallCenter(java.lang.String idCallCenter) {
        this.idCallCenter = idCallCenter;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutenticarBuroResponse)) return false;
        AutenticarBuroResponse other = (AutenticarBuroResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.respuesta==null && other.getRespuesta()==null) || 
             (this.respuesta!=null &&
              this.respuesta.equals(other.getRespuesta()))) &&
            ((this.mensaje==null && other.getMensaje()==null) || 
             (this.mensaje!=null &&
              this.mensaje.equals(other.getMensaje()))) &&
            ((this.idCallCenter==null && other.getIdCallCenter()==null) || 
             (this.idCallCenter!=null &&
              this.idCallCenter.equals(other.getIdCallCenter())));
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
        if (getRespuesta() != null) {
            _hashCode += getRespuesta().hashCode();
        }
        if (getMensaje() != null) {
            _hashCode += getMensaje().hashCode();
        }
        if (getIdCallCenter() != null) {
            _hashCode += getIdCallCenter().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutenticarBuroResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "AutenticarBuroResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuesta");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuesta"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mensaje");
        elemField.setXmlName(new javax.xml.namespace.QName("", "mensaje"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCallCenter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCallCenter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
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
