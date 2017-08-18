package com.findep.credito.buro.ws.ServicioBuroCredito;

public class ServicioBuroCreditoProxy implements com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_PortType {
  private String _endpoint = null;
  private com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_PortType servicioBuroCredito_PortType = null;
  
  public ServicioBuroCreditoProxy() {
    _initServicioBuroCreditoProxy();
  }
  
  public ServicioBuroCreditoProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioBuroCreditoProxy();
  }
  
  private void _initServicioBuroCreditoProxy() {
    try {
      servicioBuroCredito_PortType = (new com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_ServiceLocator()).getServicioBuroCreditoSOAP();
      if (servicioBuroCredito_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioBuroCredito_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioBuroCredito_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioBuroCredito_PortType != null)
      ((javax.xml.rpc.Stub)servicioBuroCredito_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_PortType getServicioBuroCredito_PortType() {
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType;
  }
  
  public com.findep.credito.buro.dto.ObtenerInformacionBncResponse obtenerInformacionBnc(com.findep.credito.buro.dto.ObtenerInformacionBncRequest obtenerInformacionBncRequest) throws java.rmi.RemoteException, com.findep.credito.buro.ws.fault.ServicioBuroCreditoFault{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.obtenerInformacionBnc(obtenerInformacionBncRequest);
  }
  
  public com.findep.credito.buro.dto.ObtenerXMLReporteCreditoResponse obtenerXMLReporteCredito(com.findep.credito.buro.dto.ObtenerXMLReporteCreditoRequest obtenerXMLReporteCreditoRequest) throws java.rmi.RemoteException, com.findep.credito.buro.ws.fault.ServicioBuroCreditoFault{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.obtenerXMLReporteCredito(obtenerXMLReporteCreditoRequest);
  }
  
  public com.findep.credito.buro.bnc.schema.ConsultarBuroResponse consultarBuro(com.findep.credito.buro.bnc.schema.ConsultarBuroRequest consultarBuroRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.consultarBuro(consultarBuroRequest);
  }
  
  public com.findep.credito.buro.bnc.schema.AutenticarBuroResponse autenticarBuro(com.findep.credito.buro.bnc.schema.AutenticarBuroRequest autenticarBuroRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.autenticarBuro(autenticarBuroRequest);
  }
  
  public com.findep.credito.buro.bnc.schema.ConsultarBuroXMLResponse consultarBuroXML(com.findep.credito.buro.bnc.schema.ConsultarBuroXMLRequest consultarBuroXMLRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.consultarBuroXML(consultarBuroXMLRequest);
  }
  
  public com.findep.credito.buro.bnc.schema.ObtenerHistorialResponse obtenerHistorial(com.findep.credito.buro.bnc.schema.ObtenerHistorialRequest obtenerHistorialRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.obtenerHistorial(obtenerHistorialRequest);
  }
  
  public com.findep.credito.buro.bnc.schema.ObtenerXMLReporteCreditoPorFolioResponse obtenerXMLReporteCreditoPorFolio(com.findep.credito.buro.bnc.schema.ObtenerXMLReporteCreditoPorFolioRequest obtenerXMLReporteCreditoPorFolioRequest) throws java.rmi.RemoteException, com.findep.credito.buro.bnc.modelo_comun.BncException{
    if (servicioBuroCredito_PortType == null)
      _initServicioBuroCreditoProxy();
    return servicioBuroCredito_PortType.obtenerXMLReporteCreditoPorFolio(obtenerXMLReporteCreditoPorFolioRequest);
  }
  
  
}