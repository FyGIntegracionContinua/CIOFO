/**
 *
 */
package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class ReporteAsistencias extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 5354870896607027340L;

	/**
	 * ReporteAsistencias
	 */
	public ReporteAsistencias() {

	}

	/** The header. */
	private EncabezadoRespuesta header;

	/** The PersonasOV */
	private List<AnalistasCEC> analistasCEC;

	/** The AsistenciaOV. */
	private List<AsistenciaOV> asistenciaOV;

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
	 * @return the analistasCEC
	 */
	public List<AnalistasCEC> getAnalistasCEC() {
		return analistasCEC;
	}

	/**
	 * @param analistasCEC the analistasCEC to set
	 */
	public void setAnalistasCEC(List<AnalistasCEC> analistasCEC) {
		this.analistasCEC = analistasCEC;
	}

	/**
	 * @return the asistenciaOV
	 */
	public List<AsistenciaOV> getAsistenciaOV() {
		return asistenciaOV;
	}

	/**
	 * @param asistenciaOV the asistenciaOV to set
	 */
	public void setAsistenciaOV(List<AsistenciaOV> asistenciaOV) {
		this.asistenciaOV = asistenciaOV;
	}





}
