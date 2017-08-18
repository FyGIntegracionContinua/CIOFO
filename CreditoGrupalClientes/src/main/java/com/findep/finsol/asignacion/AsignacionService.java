/**
 * AsignacionService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.finsol.asignacion;

public interface AsignacionService extends java.rmi.Remote {
    public com.findep.finsol.asignacion.AsignacionRespuesta asignaSolicitud(java.lang.String idSolicitud, boolean forzada) throws java.rmi.RemoteException;
    public com.findep.finsol.asignacion.RespuestaReglaIncremento calculaIncrementoMonto(com.findep.finsol.asignacion.PeticionReglaIncremento arg0) throws java.rmi.RemoteException;
    public com.findep.finsol.asignacion.AsignacionRespuesta registraSolicitudAsignacion(java.lang.String idSolicitud) throws java.rmi.RemoteException;
    public com.findep.finsol.asignacion.AsignacionRespuesta asignaSolicitudForzada(java.lang.String idSolicitud) throws java.rmi.RemoteException;
    public com.findep.finsol.asignacion.AsignacionRespuesta registraSolicitudDocumental(java.lang.String idSolicitud, java.lang.String justificacion) throws java.rmi.RemoteException;
    public com.findep.finsol.asignacion.AsignacionRespuesta asignaSolicitudDocumental(java.lang.String idSolicitud, java.lang.String justificacion, boolean forzada) throws java.rmi.RemoteException;
}
