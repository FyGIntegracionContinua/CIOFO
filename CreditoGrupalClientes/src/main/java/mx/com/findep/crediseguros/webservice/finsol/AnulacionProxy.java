package mx.com.findep.crediseguros.webservice.finsol;

public class AnulacionProxy implements mx.com.findep.crediseguros.webservice.finsol.Anulacion {
  private String _endpoint = null;
  private mx.com.findep.crediseguros.webservice.finsol.Anulacion anulacion = null;
  
  public AnulacionProxy() {
    _initAnulacionProxy();
  }
  
  public AnulacionProxy(String endpoint) {
    _endpoint = endpoint;
    _initAnulacionProxy();
  }
  
  private void _initAnulacionProxy() {
    try {
      anulacion = (new mx.com.findep.crediseguros.webservice.finsol.AnulacionServiceLocator()).getAnulacionPort();
      if (anulacion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)anulacion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)anulacion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (anulacion != null)
      ((javax.xml.rpc.Stub)anulacion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.findep.crediseguros.webservice.finsol.Anulacion getAnulacion() {
    if (anulacion == null)
      _initAnulacionProxy();
    return anulacion;
  }
  
  public java.lang.String anularAfiliaciones(java.lang.String arg0) throws java.rmi.RemoteException{
    if (anulacion == null)
      _initAnulacionProxy();
    return anulacion.anularAfiliaciones(arg0);
  }
  
  
}