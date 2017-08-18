package com.findep.finsol.asignacion;

public class AsignacionServiceProxy implements com.findep.finsol.asignacion.AsignacionService {
  private String _endpoint = null;
  private com.findep.finsol.asignacion.AsignacionService asignacionService = null;
  
  public AsignacionServiceProxy() {
    _initAsignacionServiceProxy();
  }
  
  public AsignacionServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initAsignacionServiceProxy();
  }
  
  private void _initAsignacionServiceProxy() {
    try {
      asignacionService = (new com.findep.finsol.asignacion.AsignacionServiceServiceLocator()).getAsignacionServicePort();
      if (asignacionService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)asignacionService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)asignacionService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (asignacionService != null)
      ((javax.xml.rpc.Stub)asignacionService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.findep.finsol.asignacion.AsignacionService getAsignacionService() {
    if (asignacionService == null)
      _initAsignacionServiceProxy();
    return asignacionService;
  }
  
  public com.findep.finsol.asignacion.AsignacionRespuesta asignaSolicitud(java.lang.String idSolicitud, boolean forzada) throws java.rmi.RemoteException{
    if (asignacionService == null)
      _initAsignacionServiceProxy();
    return asignacionService.asignaSolicitud(idSolicitud, forzada);
  }
  
  public com.findep.finsol.asignacion.RespuestaReglaIncremento calculaIncrementoMonto(com.findep.finsol.asignacion.PeticionReglaIncremento arg0) throws java.rmi.RemoteException{
    if (asignacionService == null)
      _initAsignacionServiceProxy();
    return asignacionService.calculaIncrementoMonto(arg0);
  }
  
  public com.findep.finsol.asignacion.AsignacionRespuesta registraSolicitudAsignacion(java.lang.String idSolicitud) throws java.rmi.RemoteException{
    if (asignacionService == null)
      _initAsignacionServiceProxy();
    return asignacionService.registraSolicitudAsignacion(idSolicitud);
  }
  
  public com.findep.finsol.asignacion.AsignacionRespuesta asignaSolicitudForzada(java.lang.String idSolicitud) throws java.rmi.RemoteException{
    if (asignacionService == null)
      _initAsignacionServiceProxy();
    return asignacionService.asignaSolicitudForzada(idSolicitud);
  }
  
  public com.findep.finsol.asignacion.AsignacionRespuesta registraSolicitudDocumental(java.lang.String idSolicitud, java.lang.String justificacion) throws java.rmi.RemoteException{
	    if (asignacionService == null)
	      _initAsignacionServiceProxy();
	    return asignacionService.registraSolicitudDocumental(idSolicitud, justificacion);
	  }
	  
	  public com.findep.finsol.asignacion.AsignacionRespuesta asignaSolicitudDocumental(java.lang.String idSolicitud, java.lang.String justificacion, boolean forzada) throws java.rmi.RemoteException{
	    if (asignacionService == null)
	      _initAsignacionServiceProxy();
	    return asignacionService.asignaSolicitudDocumental(idSolicitud, justificacion, forzada);
	  }
}