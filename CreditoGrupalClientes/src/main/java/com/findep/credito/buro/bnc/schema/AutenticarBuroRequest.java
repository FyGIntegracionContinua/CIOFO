/**
 * AutenticarBuroRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.bnc.schema;

public class AutenticarBuroRequest  implements java.io.Serializable {
    private java.lang.String solicitud;

    private java.lang.String idReferenciaCallCenter;

    private java.lang.String sucursal;

    private java.lang.String numeroPersona;

    private com.findep.credito.buro.bnc.schema.DatosBnc bnc;

    private com.findep.credito.buro.bnc.schema.HistorialCrediticio historial;

    private java.lang.String operador;

    private java.lang.String eobjXMLDatos;

    private java.lang.String empresa;

    public AutenticarBuroRequest() {
    }

    public AutenticarBuroRequest(
           java.lang.String solicitud,
           java.lang.String idReferenciaCallCenter,
           java.lang.String sucursal,
           java.lang.String numeroPersona,
           com.findep.credito.buro.bnc.schema.DatosBnc bnc,
           com.findep.credito.buro.bnc.schema.HistorialCrediticio historial,
           java.lang.String operador,
           java.lang.String eobjXMLDatos,
           java.lang.String empresa) {
           this.solicitud = solicitud;
           this.idReferenciaCallCenter = idReferenciaCallCenter;
           this.sucursal = sucursal;
           this.numeroPersona = numeroPersona;
           this.bnc = bnc;
           this.historial = historial;
           this.operador = operador;
           this.eobjXMLDatos = eobjXMLDatos;
           this.empresa = empresa;
    }


    /**
     * Gets the solicitud value for this AutenticarBuroRequest.
     * 
     * @return solicitud
     */
    public java.lang.String getSolicitud() {
        return solicitud;
    }


    /**
     * Sets the solicitud value for this AutenticarBuroRequest.
     * 
     * @param solicitud
     */
    public void setSolicitud(java.lang.String solicitud) {
        this.solicitud = solicitud;
    }


    /**
     * Gets the idReferenciaCallCenter value for this AutenticarBuroRequest.
     * 
     * @return idReferenciaCallCenter
     */
    public java.lang.String getIdReferenciaCallCenter() {
        return idReferenciaCallCenter;
    }


    /**
     * Sets the idReferenciaCallCenter value for this AutenticarBuroRequest.
     * 
     * @param idReferenciaCallCenter
     */
    public void setIdReferenciaCallCenter(java.lang.String idReferenciaCallCenter) {
        this.idReferenciaCallCenter = idReferenciaCallCenter;
    }


    /**
     * Gets the sucursal value for this AutenticarBuroRequest.
     * 
     * @return sucursal
     */
    public java.lang.String getSucursal() {
        return sucursal;
    }


    /**
     * Sets the sucursal value for this AutenticarBuroRequest.
     * 
     * @param sucursal
     */
    public void setSucursal(java.lang.String sucursal) {
        this.sucursal = sucursal;
    }


    /**
     * Gets the numeroPersona value for this AutenticarBuroRequest.
     * 
     * @return numeroPersona
     */
    public java.lang.String getNumeroPersona() {
        return numeroPersona;
    }


    /**
     * Sets the numeroPersona value for this AutenticarBuroRequest.
     * 
     * @param numeroPersona
     */
    public void setNumeroPersona(java.lang.String numeroPersona) {
        this.numeroPersona = numeroPersona;
    }


    /**
     * Gets the bnc value for this AutenticarBuroRequest.
     * 
     * @return bnc
     */
    public com.findep.credito.buro.bnc.schema.DatosBnc getBnc() {
        return bnc;
    }


    /**
     * Sets the bnc value for this AutenticarBuroRequest.
     * 
     * @param bnc
     */
    public void setBnc(com.findep.credito.buro.bnc.schema.DatosBnc bnc) {
        this.bnc = bnc;
    }


    /**
     * Gets the historial value for this AutenticarBuroRequest.
     * 
     * @return historial
     */
    public com.findep.credito.buro.bnc.schema.HistorialCrediticio getHistorial() {
        return historial;
    }


    /**
     * Sets the historial value for this AutenticarBuroRequest.
     * 
     * @param historial
     */
    public void setHistorial(com.findep.credito.buro.bnc.schema.HistorialCrediticio historial) {
        this.historial = historial;
    }


    /**
     * Gets the operador value for this AutenticarBuroRequest.
     * 
     * @return operador
     */
    public java.lang.String getOperador() {
        return operador;
    }


    /**
     * Sets the operador value for this AutenticarBuroRequest.
     * 
     * @param operador
     */
    public void setOperador(java.lang.String operador) {
        this.operador = operador;
    }


    /**
     * Gets the eobjXMLDatos value for this AutenticarBuroRequest.
     * 
     * @return eobjXMLDatos
     */
    public java.lang.String getEobjXMLDatos() {
        return eobjXMLDatos;
    }


    /**
     * Sets the eobjXMLDatos value for this AutenticarBuroRequest.
     * 
     * @param eobjXMLDatos
     */
    public void setEobjXMLDatos(java.lang.String eobjXMLDatos) {
        this.eobjXMLDatos = eobjXMLDatos;
    }


    /**
     * Gets the empresa value for this AutenticarBuroRequest.
     * 
     * @return empresa
     */
    public java.lang.String getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this AutenticarBuroRequest.
     * 
     * @param empresa
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof AutenticarBuroRequest)) return false;
        AutenticarBuroRequest other = (AutenticarBuroRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.solicitud==null && other.getSolicitud()==null) || 
             (this.solicitud!=null &&
              this.solicitud.equals(other.getSolicitud()))) &&
            ((this.idReferenciaCallCenter==null && other.getIdReferenciaCallCenter()==null) || 
             (this.idReferenciaCallCenter!=null &&
              this.idReferenciaCallCenter.equals(other.getIdReferenciaCallCenter()))) &&
            ((this.sucursal==null && other.getSucursal()==null) || 
             (this.sucursal!=null &&
              this.sucursal.equals(other.getSucursal()))) &&
            ((this.numeroPersona==null && other.getNumeroPersona()==null) || 
             (this.numeroPersona!=null &&
              this.numeroPersona.equals(other.getNumeroPersona()))) &&
            ((this.bnc==null && other.getBnc()==null) || 
             (this.bnc!=null &&
              this.bnc.equals(other.getBnc()))) &&
            ((this.historial==null && other.getHistorial()==null) || 
             (this.historial!=null &&
              this.historial.equals(other.getHistorial()))) &&
            ((this.operador==null && other.getOperador()==null) || 
             (this.operador!=null &&
              this.operador.equals(other.getOperador()))) &&
            ((this.eobjXMLDatos==null && other.getEobjXMLDatos()==null) || 
             (this.eobjXMLDatos!=null &&
              this.eobjXMLDatos.equals(other.getEobjXMLDatos()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa())));
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
        if (getSolicitud() != null) {
            _hashCode += getSolicitud().hashCode();
        }
        if (getIdReferenciaCallCenter() != null) {
            _hashCode += getIdReferenciaCallCenter().hashCode();
        }
        if (getSucursal() != null) {
            _hashCode += getSucursal().hashCode();
        }
        if (getNumeroPersona() != null) {
            _hashCode += getNumeroPersona().hashCode();
        }
        if (getBnc() != null) {
            _hashCode += getBnc().hashCode();
        }
        if (getHistorial() != null) {
            _hashCode += getHistorial().hashCode();
        }
        if (getOperador() != null) {
            _hashCode += getOperador().hashCode();
        }
        if (getEobjXMLDatos() != null) {
            _hashCode += getEobjXMLDatos().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AutenticarBuroRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "AutenticarBuroRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "solicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idReferenciaCallCenter");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idReferenciaCallCenter"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("numeroPersona");
        elemField.setXmlName(new javax.xml.namespace.QName("", "numeroPersona"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bnc");
        elemField.setXmlName(new javax.xml.namespace.QName("", "bnc"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "DatosBnc"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("historial");
        elemField.setXmlName(new javax.xml.namespace.QName("", "historial"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://buro.credito.findep.com/bnc/schema", "HistorialCrediticio"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("operador");
        elemField.setXmlName(new javax.xml.namespace.QName("", "operador"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("eobjXMLDatos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "eobjXMLDatos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
