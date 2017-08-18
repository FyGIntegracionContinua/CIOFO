/**
 * BncException.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.modelo_comun;

public class BncException  extends org.apache.axis.AxisFault  implements java.io.Serializable {
    private java.lang.String respuestaClave;

    public BncException() {
    }

    public BncException(
           java.lang.String respuestaClave) {
        this.respuestaClave = respuestaClave;
    }


    /**
     * Gets the respuestaClave value for this BncException.
     * 
     * @return respuestaClave
     */
    public java.lang.String getRespuestaClave() {
        return respuestaClave;
    }


    /**
     * Sets the respuestaClave value for this BncException.
     * 
     * @param respuestaClave
     */
    public void setRespuestaClave(java.lang.String respuestaClave) {
        this.respuestaClave = respuestaClave;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BncException)) return false;
        BncException other = (BncException) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.respuestaClave==null && other.getRespuestaClave()==null) || 
             (this.respuestaClave!=null &&
              this.respuestaClave.equals(other.getRespuestaClave())));
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
        if (getRespuestaClave() != null) {
            _hashCode += getRespuestaClave().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BncException.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/modelo-comun/", "BncException"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("respuestaClave");
        elemField.setXmlName(new javax.xml.namespace.QName("", "respuestaClave"));
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


    /**
     * Writes the exception data to the faultDetails
     */
    public void writeDetails(javax.xml.namespace.QName qname, org.apache.axis.encoding.SerializationContext context) throws java.io.IOException {
        context.serialize(qname, null, this);
    }
}
