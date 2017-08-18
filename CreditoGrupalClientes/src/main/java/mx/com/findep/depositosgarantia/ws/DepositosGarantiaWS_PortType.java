/**
 * DepositosGarantiaWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public interface DepositosGarantiaWS_PortType extends java.rmi.Remote {
    public java.lang.String registrarUniversoDepositosGarantia(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException;
    public java.lang.String aplicarGarantiaPorIncumplimiento(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException;
    public java.lang.String liquidacionContratoSaldoGarantia(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException;
    public java.lang.String devolucionParcialSaldoGarantia(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO[] listaClientes) throws java.rmi.RemoteException;
    public java.lang.String devolucionParcialLiqNoReno(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO[] listaClientes) throws java.rmi.RemoteException;
    public java.lang.String devolucionTotalSaldoGarantiaCancelacion(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO cliente) throws java.rmi.RemoteException;
    public java.lang.String devolucionTotalSaldoGarantiaLiquidacion(mx.com.findep.depositosgarantia.ws.ClientesChequesDTO cliente) throws java.rmi.RemoteException;
    public java.lang.String obtenerDepositoGarantiaIntegrantesPorContrato(java.lang.String contrato, java.lang.String tipoOp) throws java.rmi.RemoteException;
    public java.lang.String obtenerIntegrantesDevTotCancPorContrato(java.lang.String contrato) throws java.rmi.RemoteException;
    public java.lang.String obtenerMovimientosGarantiaPorContrato(mx.com.findep.depositosgarantia.ws.MovimientosGarantiaPeticion contrato) throws java.rmi.RemoteException;
    public java.lang.String aplicarLiqAutDepGar(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException;
    public java.lang.String aplicarTransaccionTraspaso(java.lang.String contrato, java.lang.String usuario) throws java.rmi.RemoteException;
    public java.lang.String reversaMovimientoGarantia(mx.com.findep.depositosgarantia.ws.ReversosGarantiaPeticion peticion) throws java.rmi.RemoteException;
    public java.lang.String registrarDepositosGarantia(mx.com.findep.depositosgarantia.ws.DepositosGarantiaPeticion peticion) throws java.rmi.RemoteException;
    public java.lang.String aplicarTraspaso(mx.com.findep.depositosgarantia.ws.TraspasoGarantiaDTO peticion) throws java.rmi.RemoteException;
}
