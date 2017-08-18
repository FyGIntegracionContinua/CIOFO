package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

public class ConsultaDatosPromediosMonitorPeticion extends ObjetoValor {


	/**
	 * Instancia una nueva datos imagenes monitor peticion.
	 */
	public ConsultaDatosPromediosMonitorPeticion() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;

	/** The header. */
	private EncabezadoPeticion header;


	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

}
