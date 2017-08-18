package utilitario.mensajes.chequescreditogrupal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ValesRenovadosRespuesta.
 *
 * @author out_ltorres
 */
public class ValesRenovadosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva vales renovados respuesta.
	 */
	public ValesRenovadosRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8331850337726320440L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The vales. */
	private List<ValeRenovado> vales;

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
	 * Obtiene vales.
	 *
	 * @return vales
	 */
	public List<ValeRenovado> getVales() {
		return vales;
	}

	/**
	 * Establece vales.
	 *
	 * @param vales a vales
	 */
	public void setVales(List<ValeRenovado> vales) {
		this.vales = vales;
	}



}
