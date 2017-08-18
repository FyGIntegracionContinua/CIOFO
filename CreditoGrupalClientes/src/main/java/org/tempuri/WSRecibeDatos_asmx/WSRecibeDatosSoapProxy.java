package org.tempuri.WSRecibeDatos_asmx;

public class WSRecibeDatosSoapProxy implements org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoap {
  private String _endpoint = null;
  private org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoap wSRecibeDatosSoap = null;
  
  public WSRecibeDatosSoapProxy() {
    _initWSRecibeDatosSoapProxy();
  }
  
  public WSRecibeDatosSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initWSRecibeDatosSoapProxy();
  }
  
  private void _initWSRecibeDatosSoapProxy() {
    try {
      wSRecibeDatosSoap = (new org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosLocator()).getWSRecibeDatosSoap();
      if (wSRecibeDatosSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wSRecibeDatosSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wSRecibeDatosSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wSRecibeDatosSoap != null)
      ((javax.xml.rpc.Stub)wSRecibeDatosSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoap getWSRecibeDatosSoap() {
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap;
  }
  
  public java.lang.String recibirDatos(java.lang.String usuario, java.lang.String password, java.lang.String archivo) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.recibirDatos(usuario, password, archivo);
  }
  
  public org.tempuri.WSRecibeDatos_asmx.EnviarResultadosResponseEnviarResultadosResult enviarResultados(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.enviarResultados(usuario, password, cliente, campaña);
  }
  
  public org.tempuri.WSRecibeDatos_asmx.EnviarDetalleResultadosResponseEnviarDetalleResultadosResult enviarDetalleResultados(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.enviarDetalleResultados(usuario, password, cliente, campaña);
  }
  
  public java.lang.String enviarDetalleRegistro(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String idenvio, java.lang.String referencia_cliente) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.enviarDetalleRegistro(usuario, password, cliente, campaña, idenvio, referencia_cliente);
  }
  
  public org.tempuri.WSRecibeDatos_asmx.EnviarSolicitudesResponseEnviarSolicitudesResult enviarSolicitudes(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.enviarSolicitudes(usuario, password, cliente, campaña);
  }
  
  public java.lang.String consultaCodigosCausa(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.consultaCodigosCausa(usuario, password, cliente, campaña);
  }
  
  public java.lang.String consultaCodigosContacto(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.consultaCodigosContacto(usuario, password, cliente, campaña);
  }
  
  public java.lang.String consultaCodigosRespuesta(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.consultaCodigosRespuesta(usuario, password, cliente, campaña);
  }
  
  public java.lang.String consultaCodigosRespuestaVerificacion(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.consultaCodigosRespuestaVerificacion(usuario, password, cliente, campaña);
  }
  
  public java.lang.String confirmarEnvio(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String llave) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.confirmarEnvio(usuario, password, cliente, campaña, llave);
  }
  
  public java.lang.String confirmarEnvio_Registro(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String idenvio, java.lang.String referencia, boolean correcto, java.lang.String llave) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.confirmarEnvio_Registro(usuario, password, cliente, campaña, idenvio, referencia, correcto, llave);
  }
  
  public java.lang.String confirmarEnvioDetalles(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String llave) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.confirmarEnvioDetalles(usuario, password, cliente, campaña, llave);
  }
  
  public java.lang.String confirmarSolicitudes(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String llave) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.confirmarSolicitudes(usuario, password, cliente, campaña, llave);
  }
  
  public java.lang.String confirmarSolicitud(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String id_envio, java.lang.String llave) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.confirmarSolicitud(usuario, password, cliente, campaña, id_envio, llave);
  }
  
  public java.lang.String statusRegistro(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String idenvio, java.lang.String referencia_cliente) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.statusRegistro(usuario, password, cliente, campaña, idenvio, referencia_cliente);
  }
  
  public java.lang.String campaniasCobranza(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.campaniasCobranza(usuario, password);
  }
  
  public void destruir_Clases() throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    wSRecibeDatosSoap.destruir_Clases();
  }
  
  public java.lang.String ping() throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.ping();
  }
  
  public java.lang.String recibirDatosVerificacionPOC2(java.lang.String usuario, java.lang.String password, java.lang.String strXML) throws java.rmi.RemoteException{
    if (wSRecibeDatosSoap == null)
      _initWSRecibeDatosSoapProxy();
    return wSRecibeDatosSoap.recibirDatosVerificacionPOC2(usuario, password, strXML);
  }
  
  
}