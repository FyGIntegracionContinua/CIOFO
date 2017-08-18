package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

public class PorcentajeGarantia extends ObjetoValor {
	/**
	 * Instancia una nueva PorcentajeGarantia.
	 */
	public PorcentajeGarantia() {
	}

	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The solicitud. */
	private String producto;

	/** The fechaInicioVigencia*/
	private String fechaInicioVigencia;

	/**The claveCondicion*/
	private String claveCondicion;

	/**The contrato*/
	private String contrato;

	/**The valor */
	private Integer valor;

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @return the fechaInicioVigencia
	 */
	public String getFechaInicioVigencia() {
		return fechaInicioVigencia;
	}
	/**
	 * @return the claveCondicion
	 */
	public String getClaveCondicion() {
		return claveCondicion;
	}
	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @return the valor
	 */
	public Integer getValor() {
		return valor;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @param fechaInicioVigencia the fechaInicioVigencia to set
	 */
	public void setFechaInicioVigencia(String fechaInicioVigencia) {
		this.fechaInicioVigencia = fechaInicioVigencia;
	}
	/**
	 * @param claveCondicion the claveCondicion to set
	 */
	public void setClaveCondicion(String claveCondicion) {
		this.claveCondicion = claveCondicion;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(Integer valor) {
		this.valor = valor;
	}
}
