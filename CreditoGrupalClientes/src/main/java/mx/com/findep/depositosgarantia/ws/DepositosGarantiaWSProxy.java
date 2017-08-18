package mx.com.findep.depositosgarantia.ws;

public class DepositosGarantiaWSProxy implements mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_PortType {
  private String _endpoint = null;
  private mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_PortType depositosGarantiaWS_PortType = null;
  
  public DepositosGarantiaWSProxy() {
    _initDepositosGarantiaWSProxy();
  }
  
  public DepositosGarantiaWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initDepositosGarantiaWSProxy();
  }
  
  private void _initDepositosGarantiaWSProxy() {
    try {
      depositosGarantiaWS_PortType = (new mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_ServiceLocator()).getDepositosGarantiaWSPort();
      if (depositosGarantiaWS_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)depositosGarantiaWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)depositosGarantiaWS_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (depositosGarantiaWS_PortType != null)
      ((javax.xml.rpc.Stub)depositosGarantiaWS_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_PortType getDepositosGarantiaWS_PortType() {
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType;
  }
  
  public java.lang.String registrarUniversoDepositosGarantia(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.registrarUniversoDepositosGarantia(peticion);
  }
  
  public java.lang.String aplicarGarantiaPorIncumplimiento(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.aplicarGarantiaPorIncumplimiento(peticion);
  }
  
  public java.lang.String liquidacionContratoSaldoGarantia(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.liquidacionContratoSaldoGarantia(peticion);
  }
  
  public java.lang.String devolucionParcialSaldoGarantia(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO[] listaClientes) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.devolucionParcialSaldoGarantia(listaClientes);
  }
  
  public java.lang.String devolucionParcialLiqNoReno(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO[] listaClientes) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.devolucionParcialLiqNoReno(listaClientes);
  }
  
  public java.lang.String devolucionTotalSaldoGarantiaCancelacion(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO cliente) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.devolucionTotalSaldoGarantiaCancelacion(cliente);
  }
  
  public java.lang.String devolucionTotalSaldoGarantiaLiquidacion(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO cliente) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.devolucionTotalSaldoGarantiaLiquidacion(cliente);
  }
  
  public java.lang.String obtenerDepositoGarantiaIntegrantesPorContrato(java.lang.String contrato, java.lang.String tipoOp) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.obtenerDepositoGarantiaIntegrantesPorContrato(contrato, tipoOp);
  }
  
  public java.lang.String obtenerIntegrantesDevTotCancPorContrato(java.lang.String contrato) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.obtenerIntegrantesDevTotCancPorContrato(contrato);
  }
  
  public java.lang.String obtenerMovimientosGarantiaPorContrato(mx.com.findep.depositosgarantia.ws.MovimientosGarantiaPeticion contrato) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.obtenerMovimientosGarantiaPorContrato(contrato);
  }
  
  public java.lang.String aplicarLiqAutDepGar(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.aplicarLiqAutDepGar(peticion);
  }
  
  public java.lang.String aplicarTransaccionTraspaso(java.lang.String contrato, java.lang.String usuario) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.aplicarTransaccionTraspaso(contrato, usuario);
  }
  
  public java.lang.String reversaMovimientoGarantia(mx.com.findep.depositosgarantia.ws.ReversosGarantiaPeticion peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.reversaMovimientoGarantia(peticion);
  }
  
  public java.lang.String registrarDepositosGarantia(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.registrarDepositosGarantia(peticion);
  }
  
  public java.lang.String aplicarTraspaso(mx.com.findep.depositosgarantia.ws.TraspasoGarantiaDTO peticion) throws java.rmi.RemoteException{
    if (depositosGarantiaWS_PortType == null)
      _initDepositosGarantiaWSProxy();
    return depositosGarantiaWS_PortType.aplicarTraspaso(peticion);
  }
  
  
}