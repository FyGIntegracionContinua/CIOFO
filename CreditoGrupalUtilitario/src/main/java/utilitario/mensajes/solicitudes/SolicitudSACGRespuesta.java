package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudSACGRespuesta.
 */
public class SolicitudSACGRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg respuesta.
	 */
	public SolicitudSACGRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3224824740740952023L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The solicitud sacg. */
	private SolicitudSACG solicitudSACG;

	/** The solicitud sacg grupo. */
	private SolicitudSACGGrupo solicitudSACGGrupo;

	/** The integrantes. */
	private List<SolicitudSACGIntegrante> integrantes;

	/** The integrantes sin curp. */
	private List<SolicitudSACGIntegranteCurp> integrantesCurp;

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
	 * Obtiene solicitud sacg.
	 *
	 * @return solicitud sacg
	 */
	public SolicitudSACG getSolicitudSACG() {
		return solicitudSACG;
	}

	/**
	 * Establece solicitud sacg.
	 *
	 * @param solicitudSACG a solicitud sacg
	 */
	public void setSolicitudSACG(SolicitudSACG solicitudSACG) {
		this.solicitudSACG = solicitudSACG;
	}

	/**
	 * Obtiene solicitud sacg grupo.
	 *
	 * @return solicitud sacg grupo
	 */
	public SolicitudSACGGrupo getSolicitudSACGGrupo() {
		return solicitudSACGGrupo;
	}

	/**
	 * Establece solicitud sacg grupo.
	 *
	 * @param solicitudSACGGrupo a solicitud sacg grupo
	 */
	public void setSolicitudSACGGrupo(SolicitudSACGGrupo solicitudSACGGrupo) {
		this.solicitudSACGGrupo = solicitudSACGGrupo;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return integrantes
	 */
	public List<SolicitudSACGIntegrante> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes a integrantes
	 */
	public void setIntegrantes(List<SolicitudSACGIntegrante> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * @return the integrantesCurp
	 */
	public List<SolicitudSACGIntegranteCurp> getIntegrantesCurp() {
		return integrantesCurp;
	}

	/**
	 * @param integrantesCurp the integrantesCurp to set
	 */
	public void setIntegrantesCurp(List<SolicitudSACGIntegranteCurp> integrantesCurp) {
		this.integrantesCurp = integrantesCurp;
	}

}
