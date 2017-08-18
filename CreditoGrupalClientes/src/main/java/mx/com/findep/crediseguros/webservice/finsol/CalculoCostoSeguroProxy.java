package mx.com.findep.crediseguros.webservice.finsol;

public class CalculoCostoSeguroProxy implements mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguro {
  private String _endpoint = null;
  private mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguro calculoCostoSeguro = null;
  
  public CalculoCostoSeguroProxy() {
    _initCalculoCostoSeguroProxy();
  }
  
  public CalculoCostoSeguroProxy(String endpoint) {
    _endpoint = endpoint;
    _initCalculoCostoSeguroProxy();
  }
  
  private void _initCalculoCostoSeguroProxy() {
    try {
      calculoCostoSeguro = (new mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroServiceLocator()).getCalculoCostoSeguroPort();
      if (calculoCostoSeguro != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)calculoCostoSeguro)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)calculoCostoSeguro)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (calculoCostoSeguro != null)
      ((javax.xml.rpc.Stub)calculoCostoSeguro)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguro getCalculoCostoSeguro() {
    if (calculoCostoSeguro == null)
      _initCalculoCostoSeguroProxy();
    return calculoCostoSeguro;
  }
  
  public java.lang.String calcularCostoSeguro(java.lang.String arg0) throws java.rmi.RemoteException{
    if (calculoCostoSeguro == null)
      _initCalculoCostoSeguroProxy();
    return calculoCostoSeguro.calcularCostoSeguro(arg0);
  }
  
  
}