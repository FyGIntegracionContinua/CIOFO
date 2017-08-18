package utilitario.buzon;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class ConsultaAvanceTrabajoRespuesta extends ObjetoValor {

	/**
	 * long defaul serial
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EncabezadoRespuesta ReporteAsignacionesRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/**
	 * estatusAvance
	 */
	private AvanceTrabajo estatusAvance;

	/**
	 * estatusAvance
	 */
	private List<AvanceTrabajo> barra;

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
	 * @return the estatusAvance
	 */
	public AvanceTrabajo getEstatusAvance() {
		return estatusAvance;
	}

	/**
	 * @param estatusAvance the estatusAvance to set
	 */
	public void setEstatusAvance(AvanceTrabajo estatusAvance) {
		this.estatusAvance = estatusAvance;
	}

	/**
	 * @return the barra
	 */
	public List<AvanceTrabajo> getBarra() {
		return barra;
	}

	/**
	 * @param barra the barra to set
	 */
	public void setBarra(List<AvanceTrabajo> barra) {
		this.barra = barra;
	}

}
