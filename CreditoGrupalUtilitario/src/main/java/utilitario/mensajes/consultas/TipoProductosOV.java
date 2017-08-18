package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TipoProductosOV.
 */
public class TipoProductosOV extends ObjetoValor {

	/**
	 * Instancia una nueva tipo productos ov.
	 */
	public TipoProductosOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5121944802918101099L;

	/** The contrato. */
	private String contrato;

	/** The fecha inicio. */
	private String fechaInicio;

	/** The categoria. */
	private String categoria;

	/** The producto. */
	private String producto;

	/** The frecuencia. */
	private String frecuencia;

	/** The dias periodo. */
	private Integer diasPeriodo;

	/** The descripcion. */
	private String descripcion;

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene categoria.
	 *
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Establece categoria.
	 *
	 * @param categoria a categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto a producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Obtiene frecuencia.
	 *
	 * @return frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Establece frecuencia.
	 *
	 * @param frecuencia a frecuencia
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Obtiene dias periodo.
	 *
	 * @return dias periodo
	 */
	public Integer getDiasPeriodo() {
		return diasPeriodo;
	}

	/**
	 * Establece dias periodo.
	 *
	 * @param diasPeriodo a dias periodo
	 */
	public void setDiasPeriodo(Integer diasPeriodo) {
		this.diasPeriodo = diasPeriodo;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion a descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return fecha inicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio a fecha inicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

}
