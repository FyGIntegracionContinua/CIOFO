package org.tempuri;

public class WSVerifTelefonicaSoapProxy implements org.tempuri.WSVerifTelefonicaSoap {
  private String _endpoint = null;
  private org.tempuri.WSVerifTelefonicaSoap wSVerifTelefonicaSoap = null;
  
  public WSVerifTelefonicaSoapProxy() {
    _initWSVerifTelefonicaSoapProxy();
  }
  
  public WSVerifTelefonicaSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSVerifTelefonicaSoapProxy();
  }
  
  private void _initWSVerifTelefonicaSoapProxy() {
    try {
      wSVerifTelefonicaSoap = (new org.tempuri.WSVerifTelefonicaLocator()).getWSVerifTelefonicaSoap();
      if (wSVerifTelefonicaSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSVerifTelefonicaSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSVerifTelefonicaSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSVerifTelefonicaSoap != null)
      ((javax.xml.rpc.Stub)wSVerifTelefonicaSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.WSVerifTelefonicaSoap getWSVerifTelefonicaSoap() {
    if (wSVerifTelefonicaSoap == null)
      _initWSVerifTelefonicaSoapProxy();
    return wSVerifTelefonicaSoap;
  }
  
  public java.lang.String obtenerSolicitudVerificar(java.lang.String solicitud) throws java.rmi.RemoteException{
    if (wSVerifTelefonicaSoap == null)
      _initWSVerifTelefonicaSoapProxy();
    return wSVerifTelefonicaSoap.obtenerSolicitudVerificar(solicitud);
  }
  
  public java.lang.String enviarBitacora(java.lang.String idSolicitud, java.lang.String usuario, java.lang.String fhcc, java.lang.String sucursal, java.lang.String nombre_grupo) throws java.rmi.RemoteException{
    if (wSVerifTelefonicaSoap == null)
      _initWSVerifTelefonicaSoapProxy();
    return wSVerifTelefonicaSoap.enviarBitacora(idSolicitud, usuario, fhcc, sucursal, nombre_grupo);
  }
  
  public java.lang.String enviarCallCenter(java.lang.String usuario, java.lang.String password, java.lang.String respuestaCIOF) throws java.rmi.RemoteException{
    if (wSVerifTelefonicaSoap == null)
      _initWSVerifTelefonicaSoapProxy();
    return wSVerifTelefonicaSoap.enviarCallCenter(usuario, password, respuestaCIOF);
  }
  
  public java.lang.String enviarVerificarAutorizacion(java.lang.String idSolicitud) throws java.rmi.RemoteException{
    if (wSVerifTelefonicaSoap == null)
      _initWSVerifTelefonicaSoapProxy();
    return wSVerifTelefonicaSoap.enviarVerificarAutorizacion(idSolicitud);
  }
  
  public java.lang.String obtieneSolicitudesVerificacionTelefonica(java.lang.String idSucursal, java.lang.String estatus_solicitud, javax.xml.rpc.holders.StringHolder error) throws java.rmi.RemoteException{
    if (wSVerifTelefonicaSoap == null)
      _initWSVerifTelefonicaSoapProxy();
    return wSVerifTelefonicaSoap.obtieneSolicitudesVerificacionTelefonica(idSucursal, estatus_solicitud, error);
  }
  
  
}