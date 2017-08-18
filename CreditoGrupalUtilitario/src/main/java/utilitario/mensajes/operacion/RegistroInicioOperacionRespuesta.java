package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistroInicioOperacionRespuesta.
 */
public class RegistroInicioOperacionRespuesta extends ObjetoValor {


	/**
	 * RegistroInicioOperacionRespuesta.
	 */
	public RegistroInicioOperacionRespuesta() {
		super();
	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -2029005118622010184L;

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta	header;
	/**
	 * fechaContable java.util.Date
	 */
	private java.util.Date fechaContable;
	/**
	 * fechaInicioOperacion java.util.Date
	 */
	private java.util.Date fechaInicioOperacion;

	/** usuario String. */
	private String usuario;

	/** sucursal Integer. */
	private Integer sucursal;

	/** nombreSucursal String. */
	private String nombreSucursal;

	/**
	 * Obtiene header.
	 *
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene fecha inicio operacion.
	 *
	 * @return .
	 */
	public java.util.Date getFechaInicioOperacion() {
		return fechaInicioOperacion;
	}

	/**
	 * Establece fecha inicio operacion.
	 *
	 * @param fechaInicioOperacion .
	 */
	public void setFechaInicioOperacion(java.util.Date fechaInicioOperacion) {
		this.fechaInicioOperacion = fechaInicioOperacion;
	}

	/**
	 * Obtiene fecha contable.
	 *
	 * @return .
	 */
	public java.util.Date getFechaContable() {
		return fechaContable;
	}

	/**
	 * Establece fecha contable.
	 *
	 * @param fechaContable .
	 */
	public void setFechaContable(java.util.Date fechaContable) {
		this.fechaContable = fechaContable;
	}

	/**
	 * Obtiene usuario.
	 *
	 * @return .
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario .
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

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
	 * Obtiene nombre sucursal.
	 *
	 * @return .
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Establece nombre sucursal.
	 *
	 * @param nombreSucursal .
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

}
