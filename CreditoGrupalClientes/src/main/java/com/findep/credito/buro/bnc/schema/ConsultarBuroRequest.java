/**
 * ConsultarBuroRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.schema;

public class ConsultarBuroRequest  implements java.io.Serializable {
    private com.findep.credito.buro.bnc.schema.ControlInterno control;

    private com.findep.credito.buro.bnc.schema.DatosCredito credito;

    private com.findep.credito.buro.bnc.schema.DatosBnc bnc;

    public ConsultarBuroRequest() {
    }

    public ConsultarBuroRequest(
           com.findep.credito.buro.bnc.schema.ControlInterno control,
           com.findep.credito.buro.bnc.schema.DatosCredito credito,
           com.findep.credito.buro.bnc.schema.DatosBnc bnc) {
           this.control = control;
           this.credito = credito;
           this.bnc = bnc;
    }


    /**
     * Gets the control value for this ConsultarBuroRequest.
     * 
     * @return control
     */
    public com.findep.credito.buro.bnc.schema.ControlInterno getControl() {
        return control;
    }


    /**
     * Sets the control value for this ConsultarBuroRequest.
     * 
     * @param control
     */
    public void setControl(com.findep.credito.buro.bnc.schema.ControlInterno control) {
        this.control = control;
    }


    /**
     * Gets the credito value for this ConsultarBuroRequest.
     * 
     * @return credito
     */
    public com.findep.credito.buro.bnc.schema.DatosCredito getCredito() {
        return credito;
    }


    /**
     * Sets the credito value for this ConsultarBuroRequest.
     * 
     * @param credito
     */
    public void setCredito(com.findep.credito.buro.bnc.schema.DatosCredito credito) {
        this.credito = credito;
    }


    /**
     * Gets the bnc value for this ConsultarBuroRequest.
     * 
     * @return bnc
     */
    public com.findep.credito.buro.bnc.schema.DatosBnc getBnc() {
        return bnc;
    }


    /**
     * Sets the bnc value for this ConsultarBuroRequest.
     * 
     * @param bnc
     */
    public void setBnc(com.findep.credito.buro.bnc.schema.DatosBnc bnc) {
        this.bnc = bnc;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ConsultarBuroRequest)) return false;
        ConsultarBuroRequest other = (ConsultarBuroRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.control==null && other.getControl()==null) || 
             (this.control!=null &&
              this.control.equals(other.getControl()))) &&
            ((this.credito==null && other.getCredito()==null) || 
             (this.credito!=null &&
              this.credito.equals(other.getCredito()))) &&
            ((this.bnc==null && other.getBnc()==null) || 
             (this.bnc!=null &&
              this.bnc.equals(other.getBnc())));
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
        if (getControl() != null) {
            _hashCode += getControl().hashCode();
        }
        if (getCredito() != null) {
            _hashCode += getCredito().hashCode();
        }
        if (getBnc() != null) {
            _hashCode += getBnc().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ConsultarBuroRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "ConsultarBuroRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("control");
        elemField.setXmlName(new javax.xml.namespace.QName("", "control"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "ControlInterno"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("credito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "credito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "DatosCredito"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "DatosBnc"));
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
