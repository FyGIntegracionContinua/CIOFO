package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ConsultaDatosImagenesMonitorRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva datos imagenes monitor respuesta.
	 */
	public ConsultaDatosImagenesMonitorRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;
	/** The header. */
	private EncabezadoRespuesta header;

	/** The datosImagenes. */
	private List<DatosImagenesMonitorOV> datosImagenes;


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
	 * Obtiene datosImagenes.
	 *
	 * @return datosImagenes
	 */
	public List<DatosImagenesMonitorOV> getDatosImagenes() {
		return datosImagenes;
	}

	/**
	 * Establece datosImagenes.
	 *
	 * @param datosImagenes a datosImagenes
	 */
	public void setDatosImagenes(List<DatosImagenesMonitorOV> datosImagenes) {
		this.datosImagenes = datosImagenes;
	}
}
