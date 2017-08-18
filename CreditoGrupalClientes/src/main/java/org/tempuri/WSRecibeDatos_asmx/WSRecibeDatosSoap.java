/**
 * WSRecibeDatosSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public interface WSRecibeDatosSoap extends java.rmi.Remote {

    /**
     * Metodo para recibir Archivo de Entrada
     */
    public java.lang.String recibirDatos(java.lang.String usuario, java.lang.String password, java.lang.String archivo) throws java.rmi.RemoteException;

    /**
     * Metodo para enviar resultados de registros
     */
    public org.tempuri.WSRecibeDatos_asmx.EnviarResultadosResponseEnviarResultadosResult enviarResultados(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Metodo para enviar detalle de resultados
     */
    public org.tempuri.WSRecibeDatos_asmx.EnviarDetalleResultadosResponseEnviarDetalleResultadosResult enviarDetalleResultados(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Metodo para enviar resultados de un registro
     */
    public java.lang.String enviarDetalleRegistro(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String idenvio, java.lang.String referencia_cliente) throws java.rmi.RemoteException;

    /**
     * Metodo para enviar resultados de solicitudes
     */
    public org.tempuri.WSRecibeDatos_asmx.EnviarSolicitudesResponseEnviarSolicitudesResult enviarSolicitudes(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Relación entre codigos causa anteriores
     */
    public java.lang.String consultaCodigosCausa(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Relación entre codigos contacto anteriores
     */
    public java.lang.String consultaCodigosContacto(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Relación entre codigos Respuesta anteriores
     */
    public java.lang.String consultaCodigosRespuesta(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Relación entre codigos Respuesta Verificacion
     */
    public java.lang.String consultaCodigosRespuestaVerificacion(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña) throws java.rmi.RemoteException;

    /**
     * Metodo para confirmar recepción de resultados
     */
    public java.lang.String confirmarEnvio(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String llave) throws java.rmi.RemoteException;

    /**
     * Metodo para confirmar recepción de resultados por registro
     */
    public java.lang.String confirmarEnvio_Registro(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String idenvio, java.lang.String referencia, boolean correcto, java.lang.String llave) throws java.rmi.RemoteException;

    /**
     * Metodo para confirmar recepción de detalle de resultados
     */
    public java.lang.String confirmarEnvioDetalles(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String llave) throws java.rmi.RemoteException;

    /**
     * Metodo para confirmar recepción de solicitudes
     */
    public java.lang.String confirmarSolicitudes(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String llave) throws java.rmi.RemoteException;

    /**
     * Metodo para confirmar recepción de una solicitud
     */
    public java.lang.String confirmarSolicitud(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String id_envio, java.lang.String llave) throws java.rmi.RemoteException;

    /**
     * Metodo para obtener el status de un registro
     */
    public java.lang.String statusRegistro(java.lang.String usuario, java.lang.String password, java.lang.String cliente, java.lang.String campaña, java.lang.String idenvio, java.lang.String referencia_cliente) throws java.rmi.RemoteException;

    /**
     * Metodo para obtener las campañas activas de cobranza
     */
    public java.lang.String campaniasCobranza(java.lang.String usuario, java.lang.String password) throws java.rmi.RemoteException;

    /**
     * Metodo para destruir clases
     */
    public void destruir_Clases() throws java.rmi.RemoteException;

    /**
     * Metodo para verificar que el webservice este corriendo
     */
    public java.lang.String ping() throws java.rmi.RemoteException;

    /**
     * Metodo para recibir Archivo de Entrada Verificación POC2
     */
    public java.lang.String recibirDatosVerificacionPOC2(java.lang.String usuario, java.lang.String password, java.lang.String strXML) throws java.rmi.RemoteException;
}
