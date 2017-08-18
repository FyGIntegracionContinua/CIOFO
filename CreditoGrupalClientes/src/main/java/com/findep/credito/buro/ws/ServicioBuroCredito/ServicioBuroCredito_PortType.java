/**
 * ServicioBuroCredito_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.ws.ServicioBuroCredito;

public interface ServicioBuroCredito_PortType extends java.rmi.Remote {
    public com.findep.credito.buro.dto.ObtenerInformacionBncResponse obtenerInformacionBnc(com.findep.credito.buro.dto.ObtenerInformacionBncRequest obtenerInformacionBncRequest) throws java.rmi.RemoteException, com.findep.credito.buro.ws.fault.ServicioBuroCreditoFault;
    public com.findep.credito.buro.dto.ObtenerXMLReporteCreditoResponse obtenerXMLReporteCredito(com.findep.credito.buro.dto.ObtenerXMLReporteCreditoRequest obtenerXMLReporteCreditoRequest) throws java.rmi.RemoteException, com.findep.credito.buro.ws.fault.ServicioBuroCreditoFault;
    public com.findep.credito.buro.bnc.schema.ConsultarBuroResponse consultarBuro(com.findep.credito.buro.bnc.schema.ConsultarBuroRequest consultarBuroRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException;
    public com.findep.credito.buro.bnc.schema.AutenticarBuroResponse autenticarBuro(com.findep.credito.buro.bnc.schema.AutenticarBuroRequest autenticarBuroRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException;
    public com.findep.credito.buro.bnc.schema.ConsultarBuroXMLResponse consultarBuroXML(com.findep.credito.buro.bnc.schema.ConsultarBuroXMLRequest consultarBuroXMLRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException;
    public com.findep.credito.buro.bnc.schema.ObtenerHistorialResponse obtenerHistorial(com.findep.credito.buro.bnc.schema.ObtenerHistorialRequest obtenerHistorialRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException;
    public com.findep.credito.buro.bnc.schema.ObtenerXMLReporteCreditoPorFolioResponse obtenerXMLReporteCreditoPorFolio(com.findep.credito.buro.bnc.schema.ObtenerXMLReporteCreditoPorFolioRequest obtenerXMLReporteCreditoPorFolioRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException;
}
