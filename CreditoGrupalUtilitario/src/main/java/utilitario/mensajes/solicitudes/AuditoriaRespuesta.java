package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AuditoriaRespuesta.
 */
public class AuditoriaRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva auditoria respuesta.
	 */
	public AuditoriaRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6035371579190210677L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The auditorias. */
	private List<Auditoria> auditorias;

	/**
	 * Obtiene auditorias.
	 *
	 * @return auditorias
	 */
	public List<Auditoria> getAuditorias() {
		return auditorias;
	}

	/**
	 * Establece auditorias.
	 *
	 * @param auditorias a auditorias
	 */
	public void setAuditorias(List<Auditoria> auditorias) {
		this.auditorias = auditorias;
	}

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



}
