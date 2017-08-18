/**
 * ChequesOperacionWS_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.example.www.ChequesOperacionWS;

public interface ChequesOperacionWS_PortType extends java.rmi.Remote {
    public org.example.www.ChequesOperacionWS.RespuestaDTO confirmarCuenta(org.example.www.ChequesOperacionWS.SolicitudDTO solicitud) throws java.rmi.RemoteException;
    public org.example.www.ChequesOperacionWS.RegistroRespuestaFinsolDTO generarChequeOriginacionGrupal(org.example.www.ChequesOperacionWS.RegistroFinsolDTO registroFinsol) throws java.rmi.RemoteException;
    public org.example.www.ChequesOperacionWS.DatosChequeDTO obtenerInformacionCheque(org.example.www.ChequesOperacionWS.FoliosDTO folios) throws java.rmi.RemoteException;
    public org.example.www.ChequesOperacionWS.ResultadoCancelaDTO cancelarCheque(org.example.www.ChequesOperacionWS.FoliosDTO[] folios, java.lang.String usuario) throws java.rmi.RemoteException;
}
