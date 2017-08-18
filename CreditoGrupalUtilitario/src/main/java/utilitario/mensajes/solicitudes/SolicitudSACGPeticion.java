package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudSACGPeticion.
 *
 * @author out_ltorres
 */
public class SolicitudSACGPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg peticion.
	 */
	public SolicitudSACGPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1055069317547962922L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The solicitud sacg. */
	private SolicitudSACG solicitudSACG;

	/** The solicitud sacg grupo. */
	private SolicitudSACGGrupo solicitudSACGGrupo;

	/** The solicitud sacg integrantes. */
	private List<SolicitudSACGIntegrante> solicitudSACGIntegrantes;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
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
	 * Obtiene solicitud sacg integrantes.
	 *
	 * @return solicitud sacg integrantes
	 */
	public List<SolicitudSACGIntegrante> getSolicitudSACGIntegrantes() {
		return solicitudSACGIntegrantes;
	}

	/**
	 * Establece solicitud sacg integrantes.
	 *
	 * @param solicitudSACGIntegrantes a solicitud sacg integrantes
	 */
	public void setSolicitudSACGIntegrantes(
			List<SolicitudSACGIntegrante> solicitudSACGIntegrantes) {
		this.solicitudSACGIntegrantes = solicitudSACGIntegrantes;
	}

}
