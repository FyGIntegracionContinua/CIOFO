package org.example.www.ChequesOperacionWS;

public class ChequesOperacionWSProxy implements org.example.www.ChequesOperacionWS.ChequesOperacionWS_PortType {
  private String _endpoint = null;
  private org.example.www.ChequesOperacionWS.ChequesOperacionWS_PortType chequesOperacionWS_PortType = null;
  
  public ChequesOperacionWSProxy() {
    _initChequesOperacionWSProxy();
  }
  
  public ChequesOperacionWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initChequesOperacionWSProxy();
  }
  
  private void _initChequesOperacionWSProxy() {
    try {
      chequesOperacionWS_PortType = (new org.example.www.ChequesOperacionWS.ChequesOperacionWS_ServiceLocator()).getChequesOperacionWSSOAP();
      if (chequesOperacionWS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)chequesOperacionWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)chequesOperacionWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (chequesOperacionWS_PortType != null)
      ((javax.xml.rpc.Stub)chequesOperacionWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.example.www.ChequesOperacionWS.ChequesOperacionWS_PortType getChequesOperacionWS_PortType() {
    if (chequesOperacionWS_PortType == null)
      _initChequesOperacionWSProxy();
    return chequesOperacionWS_PortType;
  }
  
  public org.example.www.ChequesOperacionWS.RespuestaDTO confirmarCuenta(org.example.www.ChequesOperacionWS.SolicitudDTO solicitud) throws java.rmi.RemoteException{
    if (chequesOperacionWS_PortType == null)
      _initChequesOperacionWSProxy();
    return chequesOperacionWS_PortType.confirmarCuenta(solicitud);
  }
  
  public org.example.www.ChequesOperacionWS.RegistroRespuestaFinsolDTO generarChequeOriginacionGrupal(org.example.www.ChequesOperacionWS.RegistroFinsolDTO registroFinsol) throws java.rmi.RemoteException{
    if (chequesOperacionWS_PortType == null)
      _initChequesOperacionWSProxy();
    return chequesOperacionWS_PortType.generarChequeOriginacionGrupal(registroFinsol);
  }
  
  public org.example.www.ChequesOperacionWS.DatosChequeDTO obtenerInformacionCheque(org.example.www.ChequesOperacionWS.FoliosDTO folios) throws java.rmi.RemoteException{
    if (chequesOperacionWS_PortType == null)
      _initChequesOperacionWSProxy();
    return chequesOperacionWS_PortType.obtenerInformacionCheque(folios);
  }
  
  public org.example.www.ChequesOperacionWS.ResultadoCancelaDTO cancelarCheque(org.example.www.ChequesOperacionWS.FoliosDTO[] folios, java.lang.String usuario) throws java.rmi.RemoteException{
    if (chequesOperacionWS_PortType == null)
      _initChequesOperacionWSProxy();
    return chequesOperacionWS_PortType.cancelarCheque(folios, usuario);
  }
  
  
}