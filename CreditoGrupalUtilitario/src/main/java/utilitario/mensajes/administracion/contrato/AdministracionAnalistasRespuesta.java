/**
 * AdministracionAnalistasRespuesta.
 */
package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author sramirezher
 *
 */
public class AdministracionAnalistasRespuesta extends ObjetoValor {
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -7449850345754092295L;

	/** The header. */
	private EncabezadoRespuesta header;
	
	/** Consulta Analista. */
	private AdministracionAnalistasPeticion consulta;

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
	 * @return the consulta
	 */
	public AdministracionAnalistasPeticion getConsulta() {
		return consulta;
	}

	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(AdministracionAnalistasPeticion consulta) {
		this.consulta = consulta;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdministracionAnalistasRespuesta [header=" + header
				+ ", consulta=" + consulta + "]";
	}
	
}
