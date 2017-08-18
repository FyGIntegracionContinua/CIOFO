package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AutorizaReasignacionRespuesta.
 *
 * @author mi.mejorada
 */
public class AutorizaReasignacionRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1005635702801763464L;

	/**
	 * VerificaAsignacionRespuesta.
	 */
	public AutorizaReasignacionRespuesta() {

	}

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta header;

	/** asignacionesDetalle List<AsignacionDetalleOV>. */
	private List<AsignacionDetalleOV> autorizacionesPendientes;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Establece autorizaciones pendientes.
	 *
	 * @param autorizacionesPendientes a autorizaciones pendientes
	 */
	public void setAutorizacionesPendientes(List<AsignacionDetalleOV> autorizacionesPendientes) {
		this.autorizacionesPendientes = autorizacionesPendientes;
	}

	/**
	 * Obtiene autorizaciones pendientes.
	 *
	 * @return autorizaciones pendientes
	 */
	public List<AsignacionDetalleOV> getAutorizacionesPendientes() {
		return autorizacionesPendientes;
	}

}
