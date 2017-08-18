/**
 * SolicitudDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ChequesOperacionWS;

public class SolicitudDTO  implements java.io.Serializable {
    private java.lang.String cliente;

    private java.lang.String contrato;

    private java.lang.String fecha_contrato;

    private double efectivo_otorgado;

    private java.lang.String tipo_credito;

    private int consecutivo;

    private int lugar_disposicion;

    private double monto_liquida_cont_ant;

    private java.lang.String segmento;

    private java.lang.String producto;

    private double monto_promocion;

    private java.lang.String clave_promocion;

    private double monto_descuento_prom;

    private java.lang.String desc_promocion;

    private java.lang.String beneficiario;

    private int num_sucursal;

    private int plazo;

    private java.lang.String frecuencia;

    private double tasa;

    private java.lang.String solicitud;

    private java.lang.String fecha_solicitud;

    private java.lang.String tipo_analisis;

    private java.lang.String empresa;

    private java.lang.String tipo_producto;

    private java.lang.String categoria;

    private java.lang.String beneficiario_promocion;

    public SolicitudDTO() {
    }

    public SolicitudDTO(
           java.lang.String cliente,
           java.lang.String contrato,
           java.lang.String fecha_contrato,
           double efectivo_otorgado,
           java.lang.String tipo_credito,
           int consecutivo,
           int lugar_disposicion,
           double monto_liquida_cont_ant,
           java.lang.String segmento,
           java.lang.String producto,
           double monto_promocion,
           java.lang.String clave_promocion,
           double monto_descuento_prom,
           java.lang.String desc_promocion,
           java.lang.String beneficiario,
           int num_sucursal,
           int plazo,
           java.lang.String frecuencia,
           double tasa,
           java.lang.String solicitud,
           java.lang.String fecha_solicitud,
           java.lang.String tipo_analisis,
           java.lang.String empresa,
           java.lang.String tipo_producto,
           java.lang.String categoria,
           java.lang.String beneficiario_promocion) {
           this.cliente = cliente;
           this.contrato = contrato;
           this.fecha_contrato = fecha_contrato;
           this.efectivo_otorgado = efectivo_otorgado;
           this.tipo_credito = tipo_credito;
           this.consecutivo = consecutivo;
           this.lugar_disposicion = lugar_disposicion;
           this.monto_liquida_cont_ant = monto_liquida_cont_ant;
           this.segmento = segmento;
           this.producto = producto;
           this.monto_promocion = monto_promocion;
           this.clave_promocion = clave_promocion;
           this.monto_descuento_prom = monto_descuento_prom;
           this.desc_promocion = desc_promocion;
           this.beneficiario = beneficiario;
           this.num_sucursal = num_sucursal;
           this.plazo = plazo;
           this.frecuencia = frecuencia;
           this.tasa = tasa;
           this.solicitud = solicitud;
           this.fecha_solicitud = fecha_solicitud;
           this.tipo_analisis = tipo_analisis;
           this.empresa = empresa;
           this.tipo_producto = tipo_producto;
           this.categoria = categoria;
           this.beneficiario_promocion = beneficiario_promocion;
    }


    /**
     * Gets the cliente value for this SolicitudDTO.
     * 
     * @return cliente
     */
    public java.lang.String getCliente() {
        return cliente;
    }


    /**
     * Sets the cliente value for this SolicitudDTO.
     * 
     * @param cliente
     */
    public void setCliente(java.lang.String cliente) {
        this.cliente = cliente;
    }


    /**
     * Gets the contrato value for this SolicitudDTO.
     * 
     * @return contrato
     */
    public java.lang.String getContrato() {
        return contrato;
    }


    /**
     * Sets the contrato value for this SolicitudDTO.
     * 
     * @param contrato
     */
    public void setContrato(java.lang.String contrato) {
        this.contrato = contrato;
    }


    /**
     * Gets the fecha_contrato value for this SolicitudDTO.
     * 
     * @return fecha_contrato
     */
    public java.lang.String getFecha_contrato() {
        return fecha_contrato;
    }


    /**
     * Sets the fecha_contrato value for this SolicitudDTO.
     * 
     * @param fecha_contrato
     */
    public void setFecha_contrato(java.lang.String fecha_contrato) {
        this.fecha_contrato = fecha_contrato;
    }


    /**
     * Gets the efectivo_otorgado value for this SolicitudDTO.
     * 
     * @return efectivo_otorgado
     */
    public double getEfectivo_otorgado() {
        return efectivo_otorgado;
    }


    /**
     * Sets the efectivo_otorgado value for this SolicitudDTO.
     * 
     * @param efectivo_otorgado
     */
    public void setEfectivo_otorgado(double efectivo_otorgado) {
        this.efectivo_otorgado = efectivo_otorgado;
    }


    /**
     * Gets the tipo_credito value for this SolicitudDTO.
     * 
     * @return tipo_credito
     */
    public java.lang.String getTipo_credito() {
        return tipo_credito;
    }


    /**
     * Sets the tipo_credito value for this SolicitudDTO.
     * 
     * @param tipo_credito
     */
    public void setTipo_credito(java.lang.String tipo_credito) {
        this.tipo_credito = tipo_credito;
    }


    /**
     * Gets the consecutivo value for this SolicitudDTO.
     * 
     * @return consecutivo
     */
    public int getConsecutivo() {
        return consecutivo;
    }


    /**
     * Sets the consecutivo value for this SolicitudDTO.
     * 
     * @param consecutivo
     */
    public void setConsecutivo(int consecutivo) {
        this.consecutivo = consecutivo;
    }


    /**
     * Gets the lugar_disposicion value for this SolicitudDTO.
     * 
     * @return lugar_disposicion
     */
    public int getLugar_disposicion() {
        return lugar_disposicion;
    }


    /**
     * Sets the lugar_disposicion value for this SolicitudDTO.
     * 
     * @param lugar_disposicion
     */
    public void setLugar_disposicion(int lugar_disposicion) {
        this.lugar_disposicion = lugar_disposicion;
    }


    /**
     * Gets the monto_liquida_cont_ant value for this SolicitudDTO.
     * 
     * @return monto_liquida_cont_ant
     */
    public double getMonto_liquida_cont_ant() {
        return monto_liquida_cont_ant;
    }


    /**
     * Sets the monto_liquida_cont_ant value for this SolicitudDTO.
     * 
     * @param monto_liquida_cont_ant
     */
    public void setMonto_liquida_cont_ant(double monto_liquida_cont_ant) {
        this.monto_liquida_cont_ant = monto_liquida_cont_ant;
    }


    /**
     * Gets the segmento value for this SolicitudDTO.
     * 
     * @return segmento
     */
    public java.lang.String getSegmento() {
        return segmento;
    }


    /**
     * Sets the segmento value for this SolicitudDTO.
     * 
     * @param segmento
     */
    public void setSegmento(java.lang.String segmento) {
        this.segmento = segmento;
    }


    /**
     * Gets the producto value for this SolicitudDTO.
     * 
     * @return producto
     */
    public java.lang.String getProducto() {
        return producto;
    }


    /**
     * Sets the producto value for this SolicitudDTO.
     * 
     * @param producto
     */
    public void setProducto(java.lang.String producto) {
        this.producto = producto;
    }


    /**
     * Gets the monto_promocion value for this SolicitudDTO.
     * 
     * @return monto_promocion
     */
    public double getMonto_promocion() {
        return monto_promocion;
    }


    /**
     * Sets the monto_promocion value for this SolicitudDTO.
     * 
     * @param monto_promocion
     */
    public void setMonto_promocion(double monto_promocion) {
        this.monto_promocion = monto_promocion;
    }


    /**
     * Gets the clave_promocion value for this SolicitudDTO.
     * 
     * @return clave_promocion
     */
    public java.lang.String getClave_promocion() {
        return clave_promocion;
    }


    /**
     * Sets the clave_promocion value for this SolicitudDTO.
     * 
     * @param clave_promocion
     */
    public void setClave_promocion(java.lang.String clave_promocion) {
        this.clave_promocion = clave_promocion;
    }


    /**
     * Gets the monto_descuento_prom value for this SolicitudDTO.
     * 
     * @return monto_descuento_prom
     */
    public double getMonto_descuento_prom() {
        return monto_descuento_prom;
    }


    /**
     * Sets the monto_descuento_prom value for this SolicitudDTO.
     * 
     * @param monto_descuento_prom
     */
    public void setMonto_descuento_prom(double monto_descuento_prom) {
        this.monto_descuento_prom = monto_descuento_prom;
    }


    /**
     * Gets the desc_promocion value for this SolicitudDTO.
     * 
     * @return desc_promocion
     */
    public java.lang.String getDesc_promocion() {
        return desc_promocion;
    }


    /**
     * Sets the desc_promocion value for this SolicitudDTO.
     * 
     * @param desc_promocion
     */
    public void setDesc_promocion(java.lang.String desc_promocion) {
        this.desc_promocion = desc_promocion;
    }


    /**
     * Gets the beneficiario value for this SolicitudDTO.
     * 
     * @return beneficiario
     */
    public java.lang.String getBeneficiario() {
        return beneficiario;
    }


    /**
     * Sets the beneficiario value for this SolicitudDTO.
     * 
     * @param beneficiario
     */
    public void setBeneficiario(java.lang.String beneficiario) {
        this.beneficiario = beneficiario;
    }


    /**
     * Gets the num_sucursal value for this SolicitudDTO.
     * 
     * @return num_sucursal
     */
    public int getNum_sucursal() {
        return num_sucursal;
    }


    /**
     * Sets the num_sucursal value for this SolicitudDTO.
     * 
     * @param num_sucursal
     */
    public void setNum_sucursal(int num_sucursal) {
        this.num_sucursal = num_sucursal;
    }


    /**
     * Gets the plazo value for this SolicitudDTO.
     * 
     * @return plazo
     */
    public int getPlazo() {
        return plazo;
    }


    /**
     * Sets the plazo value for this SolicitudDTO.
     * 
     * @param plazo
     */
    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }


    /**
     * Gets the frecuencia value for this SolicitudDTO.
     * 
     * @return frecuencia
     */
    public java.lang.String getFrecuencia() {
        return frecuencia;
    }


    /**
     * Sets the frecuencia value for this SolicitudDTO.
     * 
     * @param frecuencia
     */
    public void setFrecuencia(java.lang.String frecuencia) {
        this.frecuencia = frecuencia;
    }


    /**
     * Gets the tasa value for this SolicitudDTO.
     * 
     * @return tasa
     */
    public double getTasa() {
        return tasa;
    }


    /**
     * Sets the tasa value for this SolicitudDTO.
     * 
     * @param tasa
     */
    public void setTasa(double tasa) {
        this.tasa = tasa;
    }


    /**
     * Gets the solicitud value for this SolicitudDTO.
     * 
     * @return solicitud
     */
    public java.lang.String getSolicitud() {
        return solicitud;
    }


    /**
     * Sets the solicitud value for this SolicitudDTO.
     * 
     * @param solicitud
     */
    public void setSolicitud(java.lang.String solicitud) {
        this.solicitud = solicitud;
    }


    /**
     * Gets the fecha_solicitud value for this SolicitudDTO.
     * 
     * @return fecha_solicitud
     */
    public java.lang.String getFecha_solicitud() {
        return fecha_solicitud;
    }


    /**
     * Sets the fecha_solicitud value for this SolicitudDTO.
     * 
     * @param fecha_solicitud
     */
    public void setFecha_solicitud(java.lang.String fecha_solicitud) {
        this.fecha_solicitud = fecha_solicitud;
    }


    /**
     * Gets the tipo_analisis value for this SolicitudDTO.
     * 
     * @return tipo_analisis
     */
    public java.lang.String getTipo_analisis() {
        return tipo_analisis;
    }


    /**
     * Sets the tipo_analisis value for this SolicitudDTO.
     * 
     * @param tipo_analisis
     */
    public void setTipo_analisis(java.lang.String tipo_analisis) {
        this.tipo_analisis = tipo_analisis;
    }


    /**
     * Gets the empresa value for this SolicitudDTO.
     * 
     * @return empresa
     */
    public java.lang.String getEmpresa() {
        return empresa;
    }


    /**
     * Sets the empresa value for this SolicitudDTO.
     * 
     * @param empresa
     */
    public void setEmpresa(java.lang.String empresa) {
        this.empresa = empresa;
    }


    /**
     * Gets the tipo_producto value for this SolicitudDTO.
     * 
     * @return tipo_producto
     */
    public java.lang.String getTipo_producto() {
        return tipo_producto;
    }


    /**
     * Sets the tipo_producto value for this SolicitudDTO.
     * 
     * @param tipo_producto
     */
    public void setTipo_producto(java.lang.String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }


    /**
     * Gets the categoria value for this SolicitudDTO.
     * 
     * @return categoria
     */
    public java.lang.String getCategoria() {
        return categoria;
    }


    /**
     * Sets the categoria value for this SolicitudDTO.
     * 
     * @param categoria
     */
    public void setCategoria(java.lang.String categoria) {
        this.categoria = categoria;
    }


    /**
     * Gets the beneficiario_promocion value for this SolicitudDTO.
     * 
     * @return beneficiario_promocion
     */
    public java.lang.String getBeneficiario_promocion() {
        return beneficiario_promocion;
    }


    /**
     * Sets the beneficiario_promocion value for this SolicitudDTO.
     * 
     * @param beneficiario_promocion
     */
    public void setBeneficiario_promocion(java.lang.String beneficiario_promocion) {
        this.beneficiario_promocion = beneficiario_promocion;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SolicitudDTO)) return false;
        SolicitudDTO other = (SolicitudDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.cliente==null && other.getCliente()==null) || 
             (this.cliente!=null &&
              this.cliente.equals(other.getCliente()))) &&
            ((this.contrato==null && other.getContrato()==null) || 
             (this.contrato!=null &&
              this.contrato.equals(other.getContrato()))) &&
            ((this.fecha_contrato==null && other.getFecha_contrato()==null) || 
             (this.fecha_contrato!=null &&
              this.fecha_contrato.equals(other.getFecha_contrato()))) &&
            this.efectivo_otorgado == other.getEfectivo_otorgado() &&
            ((this.tipo_credito==null && other.getTipo_credito()==null) || 
             (this.tipo_credito!=null &&
              this.tipo_credito.equals(other.getTipo_credito()))) &&
            this.consecutivo == other.getConsecutivo() &&
            this.lugar_disposicion == other.getLugar_disposicion() &&
            this.monto_liquida_cont_ant == other.getMonto_liquida_cont_ant() &&
            ((this.segmento==null && other.getSegmento()==null) || 
             (this.segmento!=null &&
              this.segmento.equals(other.getSegmento()))) &&
            ((this.producto==null && other.getProducto()==null) || 
             (this.producto!=null &&
              this.producto.equals(other.getProducto()))) &&
            this.monto_promocion == other.getMonto_promocion() &&
            ((this.clave_promocion==null && other.getClave_promocion()==null) || 
             (this.clave_promocion!=null &&
              this.clave_promocion.equals(other.getClave_promocion()))) &&
            this.monto_descuento_prom == other.getMonto_descuento_prom() &&
            ((this.desc_promocion==null && other.getDesc_promocion()==null) || 
             (this.desc_promocion!=null &&
              this.desc_promocion.equals(other.getDesc_promocion()))) &&
            ((this.beneficiario==null && other.getBeneficiario()==null) || 
             (this.beneficiario!=null &&
              this.beneficiario.equals(other.getBeneficiario()))) &&
            this.num_sucursal == other.getNum_sucursal() &&
            this.plazo == other.getPlazo() &&
            ((this.frecuencia==null && other.getFrecuencia()==null) || 
             (this.frecuencia!=null &&
              this.frecuencia.equals(other.getFrecuencia()))) &&
            this.tasa == other.getTasa() &&
            ((this.solicitud==null && other.getSolicitud()==null) || 
             (this.solicitud!=null &&
              this.solicitud.equals(other.getSolicitud()))) &&
            ((this.fecha_solicitud==null && other.getFecha_solicitud()==null) || 
             (this.fecha_solicitud!=null &&
              this.fecha_solicitud.equals(other.getFecha_solicitud()))) &&
            ((this.tipo_analisis==null && other.getTipo_analisis()==null) || 
             (this.tipo_analisis!=null &&
              this.tipo_analisis.equals(other.getTipo_analisis()))) &&
            ((this.empresa==null && other.getEmpresa()==null) || 
             (this.empresa!=null &&
              this.empresa.equals(other.getEmpresa()))) &&
            ((this.tipo_producto==null && other.getTipo_producto()==null) || 
             (this.tipo_producto!=null &&
              this.tipo_producto.equals(other.getTipo_producto()))) &&
            ((this.categoria==null && other.getCategoria()==null) || 
             (this.categoria!=null &&
              this.categoria.equals(other.getCategoria()))) &&
            ((this.beneficiario_promocion==null && other.getBeneficiario_promocion()==null) || 
             (this.beneficiario_promocion!=null &&
              this.beneficiario_promocion.equals(other.getBeneficiario_promocion())));
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
        if (getCliente() != null) {
            _hashCode += getCliente().hashCode();
        }
        if (getContrato() != null) {
            _hashCode += getContrato().hashCode();
        }
        if (getFecha_contrato() != null) {
            _hashCode += getFecha_contrato().hashCode();
        }
        _hashCode += new Double(getEfectivo_otorgado()).hashCode();
        if (getTipo_credito() != null) {
            _hashCode += getTipo_credito().hashCode();
        }
        _hashCode += getConsecutivo();
        _hashCode += getLugar_disposicion();
        _hashCode += new Double(getMonto_liquida_cont_ant()).hashCode();
        if (getSegmento() != null) {
            _hashCode += getSegmento().hashCode();
        }
        if (getProducto() != null) {
            _hashCode += getProducto().hashCode();
        }
        _hashCode += new Double(getMonto_promocion()).hashCode();
        if (getClave_promocion() != null) {
            _hashCode += getClave_promocion().hashCode();
        }
        _hashCode += new Double(getMonto_descuento_prom()).hashCode();
        if (getDesc_promocion() != null) {
            _hashCode += getDesc_promocion().hashCode();
        }
        if (getBeneficiario() != null) {
            _hashCode += getBeneficiario().hashCode();
        }
        _hashCode += getNum_sucursal();
        _hashCode += getPlazo();
        if (getFrecuencia() != null) {
            _hashCode += getFrecuencia().hashCode();
        }
        _hashCode += new Double(getTasa()).hashCode();
        if (getSolicitud() != null) {
            _hashCode += getSolicitud().hashCode();
        }
        if (getFecha_solicitud() != null) {
            _hashCode += getFecha_solicitud().hashCode();
        }
        if (getTipo_analisis() != null) {
            _hashCode += getTipo_analisis().hashCode();
        }
        if (getEmpresa() != null) {
            _hashCode += getEmpresa().hashCode();
        }
        if (getTipo_producto() != null) {
            _hashCode += getTipo_producto().hashCode();
        }
        if (getCategoria() != null) {
            _hashCode += getCategoria().hashCode();
        }
        if (getBeneficiario_promocion() != null) {
            _hashCode += getBeneficiario_promocion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SolicitudDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.example.org/ChequesOperacionWS/", "SolicitudDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cliente");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cliente"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_contrato");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha_contrato"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("efectivo_otorgado");
        elemField.setXmlName(new javax.xml.namespace.QName("", "efectivo_otorgado"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_credito");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo_credito"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("consecutivo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "consecutivo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lugar_disposicion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lugar_disposicion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto_liquida_cont_ant");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monto_liquida_cont_ant"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmento");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmento"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("producto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "producto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto_promocion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monto_promocion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("clave_promocion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "clave_promocion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("monto_descuento_prom");
        elemField.setXmlName(new javax.xml.namespace.QName("", "monto_descuento_prom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desc_promocion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "desc_promocion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiario");
        elemField.setXmlName(new javax.xml.namespace.QName("", "beneficiario"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("num_sucursal");
        elemField.setXmlName(new javax.xml.namespace.QName("", "num_sucursal"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("plazo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "plazo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("frecuencia");
        elemField.setXmlName(new javax.xml.namespace.QName("", "frecuencia"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tasa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tasa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("solicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "solicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fecha_solicitud");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fecha_solicitud"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_analisis");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo_analisis"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("empresa");
        elemField.setXmlName(new javax.xml.namespace.QName("", "empresa"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tipo_producto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "tipo_producto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categoria");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categoria"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("beneficiario_promocion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "beneficiario_promocion"));
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
