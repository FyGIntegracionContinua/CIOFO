package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosCreditoIntegrantesRespuesta.
 */
public class DatosCreditoIntegrantesRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva datos credito integrantes respuesta.
	 */
	public DatosCreditoIntegrantesRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The datos credito. */
	private DatosCreditoOV	datosCredito;

	/** The integrantes. */
	private DatosIntegranteResumenOV[] integrantes;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return integrantes
	 */
	public DatosIntegranteResumenOV[] getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes a integrantes
	 */
	public void setIntegrantes(DatosIntegranteResumenOV[] integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Establece datos credito.
	 *
	 * @param datosCredito a datos credito
	 */
	public void setDatosCredito(DatosCreditoOV datosCredito) {
		this.datosCredito = datosCredito;
	}

	/**
	 * Obtiene datos credito.
	 *
	 * @return datos credito
	 */
	public DatosCreditoOV getDatosCredito() {
		return datosCredito;
	}

}
