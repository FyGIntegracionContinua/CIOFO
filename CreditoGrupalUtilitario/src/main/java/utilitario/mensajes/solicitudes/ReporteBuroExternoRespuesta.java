package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteBuroExternoRespuesta.
 * @author ltorres
 */
public class ReporteBuroExternoRespuesta extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = -6314349569878166239L;

	/**
	 * EncabezadoRespuesta ReporteBuroExternoRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** List<ReporteSolicitudOV> solicitudes. */
	private List<ReporteBuroExternoOV> productos;

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
	 * @return the productos
	 */
	public List<ReporteBuroExternoOV> getProductos() {
		return productos;
	}

	/**
	 * @param productos the productos to set
	 */
	public void setProductos(List<ReporteBuroExternoOV> productos) {
		this.productos = productos;
	}

}
