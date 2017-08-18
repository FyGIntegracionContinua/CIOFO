/**
 *
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class TraspasoPagosPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5610238515218600021L;

	/** The fechaInicio. */
	private String fechaInicio;

	/** The fechaFin. */
	private String fechaFin;

	/** The sucursal */
	private String sucursal;

	/** The fechaPago */
	private String fechaPago;

	/** The fechaAplicacion */
	private String fechaAplicacion;

	/**
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the fechaAplicacion
	 */
	public String getFechaAplicacion() {
		return fechaAplicacion;
	}

	/**
	 * @param fechaAplicacion the fechaAplicacion to set
	 */
	public void setFechaAplicacion(String fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	
}
