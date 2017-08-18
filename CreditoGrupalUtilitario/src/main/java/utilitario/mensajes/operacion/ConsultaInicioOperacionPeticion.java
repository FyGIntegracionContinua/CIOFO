package utilitario.mensajes.operacion;


import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaInicioOperacionPeticion.
 */
public class ConsultaInicioOperacionPeticion  extends ObjetoValor {


	/**
	 * ConsultaInicioOperacionPeticion.
	 */
	public ConsultaInicioOperacionPeticion() {
		super();
	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -3696748629642458553L;

	/** sucursal Integer. */
	private Integer sucursal;
	/**
	 * fechaInicio java.util.Date
	 */
	private java.util.Date fechaInicio;
	/**
	 * fechaFin java.util.Date
	 */
	private java.util.Date fechaFin;

	/**
	 * Obtiene sucursal.
	 *
	 * @return .
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal .
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return .
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio .
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return .
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin .
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
