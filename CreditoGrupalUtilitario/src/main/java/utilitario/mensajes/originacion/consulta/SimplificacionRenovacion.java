package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
/**
 * clase que contendra la infomacion para los fomatos de solicitud.
 * @author rmontellano
 * @version 4.10
 */
public class SimplificacionRenovacion extends ObjetoValor {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 6352214962485754862L;

	/**
	 * EncabezadoRespuesta header.
	 */
	private EncabezadoRespuesta header;
	/**
	 * xml de respuesta.
	 */
	private String solicitudXml;
	/**
	 * KitImpresionSimplificacionRenovacion de donde se saca el xml.
	 */
	private KitImpresionSimplificacionRenovacion kitImpresionSimplificacionRenovacion;
	/**
	 * @return the solicitudXml
	 */
	public String getSolicitudXml() {
		return solicitudXml;
	}
	/**
	 * @param solicitudXml the solicitudXml to set
	 */
	public void setSolicitudXml(String solicitudXml) {
		this.solicitudXml = solicitudXml;
	}
	/**
	 * @return the kitImpresionSimplificacionRenovacion
	 */
	public KitImpresionSimplificacionRenovacion getKitImpresionSimplificacionRenovacion() {
		return kitImpresionSimplificacionRenovacion;
	}
	/**
	 * @param kitImpresionSimplificacionRenovacion the kitImpresionSimplificacionRenovacion to set
	 */
	public void setKitImpresionSimplificacionRenovacion(
			KitImpresionSimplificacionRenovacion kitImpresionSimplificacionRenovacion) {
		this.kitImpresionSimplificacionRenovacion = kitImpresionSimplificacionRenovacion;
	}
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
