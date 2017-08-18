/**
 * WSVerifTelefonicaSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public interface WSVerifTelefonicaSoap extends java.rmi.Remote {
    public java.lang.String obtenerSolicitudVerificar(java.lang.String solicitud) throws java.rmi.RemoteException;
    public java.lang.String enviarBitacora(java.lang.String idSolicitud, java.lang.String usuario, java.lang.String fhcc, java.lang.String sucursal, java.lang.String nombre_grupo) throws java.rmi.RemoteException;
    public java.lang.String enviarCallCenter(java.lang.String usuario, java.lang.String password, java.lang.String respuestaCIOF) throws java.rmi.RemoteException;
    public java.lang.String enviarVerificarAutorizacion(java.lang.String idSolicitud) throws java.rmi.RemoteException;
    public java.lang.String obtieneSolicitudesVerificacionTelefonica(java.lang.String idSucursal, java.lang.String estatus_solicitud, javax.xml.rpc.holders.StringHolder error) throws java.rmi.RemoteException;
}
