package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.solicitudes.SolicitudBuroClienteOV;
import utilitario.reglas.solicitudes.RespuestaReglaIncremento;

public class ValidaSolicitudRespuesta  extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -843171327755570442L;

	/** The header. */
	private EncabezadoRespuesta header;
	/**
	 * incrementos
	 */
	private List<RespuestaReglaIncremento> incrementos;

	/** The integrantes a descartar y a eleminar. */
	private List<SolicitudBuroClienteOV> integrantes;

	/**validacion  de buro*/
	private boolean validacionBC;
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

	/**
	 * @return the incrementos
	 */
	public List<RespuestaReglaIncremento> getIncrementos() {
		return incrementos;
	}

	/**
	 * @param incrementos the incrementos to set
	 */
	public void setIncrementos(List<RespuestaReglaIncremento> incrementos) {
		this.incrementos = incrementos;
	}

	/**
	 * @return the integrantes
	 */
	public List<SolicitudBuroClienteOV> getIntegrantes() {
		return integrantes;
	}

	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<SolicitudBuroClienteOV> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * @return the validacionBC
	 */
	public boolean isValidacionBC() {
		return validacionBC;
	}

	/**
	 * @param validacionBC the validacionBC to set
	 */
	public void setValidacionBC(boolean validacionBC) {
		this.validacionBC = validacionBC;
	}
}
