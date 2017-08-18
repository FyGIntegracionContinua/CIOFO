package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class RegistrarSolicitudOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes ov.
	 */
	public RegistrarSolicitudOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The express. */
	private String express;

	/** The producto. */
	private String producto;

	/** The cod producto. */
	private String codProducto;

	/** The contrato actual. */
	private String contratoActual;

	/** The renovacion. */
	private boolean renovacion;

	/** The renovacion financiada. */
	private boolean renovacionFinanciada;

	/**
	 * Gets the express.
	 *
	 * @return the express
	 */
	public String getExpress() {
		return express;
	}

	/**
	 * Sets the express.
	 *
	 * @param express the new express
	 */
	public void setExpress(String express) {
		this.express = express;
	}

	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Gets the cod producto.
	 *
	 * @return the cod producto
	 */
	public String getCodProducto() {
		return codProducto;
	}

	/**
	 * Sets the cod producto.
	 *
	 * @param codProducto the new cod producto
	 */
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	/**
	 * Gets the contrato actual.
	 *
	 * @return the contrato actual
	 */
	public String getContratoActual() {
		return contratoActual;
	}

	/**
	 * Sets the contrato actual.
	 *
	 * @param contratoActual the new contrato actual
	 */
	public void setContratoActual(String contratoActual) {
		this.contratoActual = contratoActual;
	}

	/**
	 * Checks if is renovacion.
	 *
	 * @return true, if is renovacion
	 */
	public boolean isRenovacion() {
		return renovacion;
	}

	/**
	 * Sets the renovacion.
	 *
	 * @param renovacion the new renovacion
	 */
	public void setRenovacion(boolean renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * @return the renovacionFinanciada
	 */
	public boolean isRenovacionFinanciada() {
		return renovacionFinanciada;
	}

	/**
	 * @param renovacionFinanciada the renovacionFinanciada to set
	 */
	public void setRenovacionFinanciada(boolean renovacionFinanciada) {
		this.renovacionFinanciada = renovacionFinanciada;
	}

}
