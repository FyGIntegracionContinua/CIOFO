package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ConsultaDatosPromediosMonitorRespuesta extends ObjetoValor {


	/**
	 * Instancia una nueva datos promedios monitor respuesta.
	 */
	public ConsultaDatosPromediosMonitorRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;
	/** The header. */
	private EncabezadoRespuesta header;

	/** The datosPromediosMonitor. */
	private List<DatosPromediosMonitorOV> datosPromediosMonitor;


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
	 * Obtiene datosPromediosMonitor.
	 *
	 * @return datosPromediosMonitor
	 */
	public List<DatosPromediosMonitorOV> getDatosPromediosMonitor() {
		return datosPromediosMonitor;
	}

	/**
	 * Establece datosPromediosMonitor.
	 *
	 * @param datosPromediosMonitor datosPromediosMonitor
	 */
	public void setDatosPromediosMonitor(List<DatosPromediosMonitorOV> datosPromediosMonitor) {
		this.datosPromediosMonitor = datosPromediosMonitor;
	}

}
