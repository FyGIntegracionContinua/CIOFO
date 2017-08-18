/**
 * EnviarSolicitudesResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class EnviarSolicitudesResponse  implements java.io.Serializable {
    private org.tempuri.WSRecibeDatos_asmx.EnviarSolicitudesResponseEnviarSolicitudesResult enviarSolicitudesResult;

    public EnviarSolicitudesResponse() {
    }

    public EnviarSolicitudesResponse(
           org.tempuri.WSRecibeDatos_asmx.EnviarSolicitudesResponseEnviarSolicitudesResult enviarSolicitudesResult) {
           this.enviarSolicitudesResult = enviarSolicitudesResult;
    }


    /**
     * Gets the enviarSolicitudesResult value for this EnviarSolicitudesResponse.
     * 
     * @return enviarSolicitudesResult
     */
    public org.tempuri.WSRecibeDatos_asmx.EnviarSolicitudesResponseEnviarSolicitudesResult getEnviarSolicitudesResult() {
        return enviarSolicitudesResult;
    }


    /**
     * Sets the enviarSolicitudesResult value for this EnviarSolicitudesResponse.
     * 
     * @param enviarSolicitudesResult
     */
    public void setEnviarSolicitudesResult(org.tempuri.WSRecibeDatos_asmx.EnviarSolicitudesResponseEnviarSolicitudesResult enviarSolicitudesResult) {
        this.enviarSolicitudesResult = enviarSolicitudesResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof EnviarSolicitudesResponse)) return false;
        EnviarSolicitudesResponse other = (EnviarSolicitudesResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.enviarSolicitudesResult==null && other.getEnviarSolicitudesResult()==null) || 
             (this.enviarSolicitudesResult!=null &&
              this.enviarSolicitudesResult.equals(other.getEnviarSolicitudesResult())));
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
        if (getEnviarSolicitudesResult() != null) {
            _hashCode += getEnviarSolicitudesResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(EnviarSolicitudesResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">EnviarSolicitudesResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("enviarSolicitudesResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "EnviarSolicitudesResult"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">>EnviarSolicitudesResponse>EnviarSolicitudesResult"));
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
