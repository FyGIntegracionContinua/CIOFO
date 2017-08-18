/**
 * CampaniasCobranzaResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class CampaniasCobranzaResponse  implements java.io.Serializable {
    private java.lang.String campaniasCobranzaResult;

    public CampaniasCobranzaResponse() {
    }

    public CampaniasCobranzaResponse(
           java.lang.String campaniasCobranzaResult) {
           this.campaniasCobranzaResult = campaniasCobranzaResult;
    }


    /**
     * Gets the campaniasCobranzaResult value for this CampaniasCobranzaResponse.
     * 
     * @return campaniasCobranzaResult
     */
    public java.lang.String getCampaniasCobranzaResult() {
        return campaniasCobranzaResult;
    }


    /**
     * Sets the campaniasCobranzaResult value for this CampaniasCobranzaResponse.
     * 
     * @param campaniasCobranzaResult
     */
    public void setCampaniasCobranzaResult(java.lang.String campaniasCobranzaResult) {
        this.campaniasCobranzaResult = campaniasCobranzaResult;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CampaniasCobranzaResponse)) return false;
        CampaniasCobranzaResponse other = (CampaniasCobranzaResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.campaniasCobranzaResult==null && other.getCampaniasCobranzaResult()==null) || 
             (this.campaniasCobranzaResult!=null &&
              this.campaniasCobranzaResult.equals(other.getCampaniasCobranzaResult())));
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
        if (getCampaniasCobranzaResult() != null) {
            _hashCode += getCampaniasCobranzaResult().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CampaniasCobranzaResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", ">CampaniasCobranzaResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("campaniasCobranzaResult");
        elemField.setXmlName(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "CampaniasCobranzaResult"));
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
