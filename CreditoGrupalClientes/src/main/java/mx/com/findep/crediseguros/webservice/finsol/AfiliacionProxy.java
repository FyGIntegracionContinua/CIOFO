package mx.com.findep.crediseguros.webservice.finsol;

public class AfiliacionProxy implements mx.com.findep.crediseguros.webservice.finsol.Afiliacion {
  private String _endpoint = null;
  private mx.com.findep.crediseguros.webservice.finsol.Afiliacion afiliacion = null;
  
  public AfiliacionProxy() {
    _initAfiliacionProxy();
  }
  
  public AfiliacionProxy(String endpoint) {
    _endpoint = endpoint;
    _initAfiliacionProxy();
  }
  
  private void _initAfiliacionProxy() {
    try {
      afiliacion = (new mx.com.findep.crediseguros.webservice.finsol.AfiliacionServiceLocator()).getAfiliacionPort();
      if (afiliacion != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)afiliacion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)afiliacion)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (afiliacion != null)
      ((javax.xml.rpc.Stub)afiliacion)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.findep.crediseguros.webservice.finsol.Afiliacion getAfiliacion() {
    if (afiliacion == null)
      _initAfiliacionProxy();
    return afiliacion;
  }
  
  public java.lang.String afiliar(java.lang.String arg0) throws java.rmi.RemoteException{
    if (afiliacion == null)
      _initAfiliacionProxy();
    return afiliacion.afiliar(arg0);
  }
  
  
}