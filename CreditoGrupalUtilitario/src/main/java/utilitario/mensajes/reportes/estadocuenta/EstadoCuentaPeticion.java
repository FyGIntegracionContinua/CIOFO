package utilitario.mensajes.reportes.estadocuenta;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class EstadoCuentaPeticion.
 */
public class EstadoCuentaPeticion  extends ObjetoValor {

	/**
	 * EstadoCuentaPeticion.
	 */
	public EstadoCuentaPeticion() {

	}

	/** long serialVersionUID. */
	private static final long serialVersionUID = 1464061521162064385L;

	/** EncabezadoPeticion encabezado. */
	private EncabezadoPeticion encabezado;

	/** String numeroCuenta. */
	private String numeroCuenta;

	/** String numeroCuenta. */
	private String muestraCancelaciones;

	/** Integer sucursal. */
	private Integer sucursal;

	/** Numero de solicitud */
	private String solicitud;

	/** Para mostrar depositos garantia */
	private boolean depgar;

	/**
	 * Obtiene numero cuenta.
	 *
	 * @return getNumeroCuenta :
	 */
	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	/**
	 * Establece numero cuenta.
	 *
	 * @param numeroCuenta setNumeroCuenta :
	 */
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	/**
	 * Obtiene encabezado.
	 *
	 * @return the encabezado
	 */
	public EncabezadoPeticion getEncabezado() {
		return encabezado;
	}

	/**
	 * Establece encabezado.
	 *
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(EncabezadoPeticion encabezado) {
		this.encabezado = encabezado;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return getSucursal :
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal setSucursal :
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Establece muestra cancelaciones.
	 *
	 * @param muestraCancelaciones a muestra cancelaciones
	 */
	public void setMuestraCancelaciones(String muestraCancelaciones) {
		this.muestraCancelaciones = muestraCancelaciones;
	}

	/**
	 * Obtiene muestra cancelaciones.
	 *
	 * @return muestra cancelaciones
	 */
	public String getMuestraCancelaciones() {
		return muestraCancelaciones;
	}

	/**
	 * Obtiene solicitud
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the depgar
	 */
	public boolean isDepgar() {
		return depgar;
	}

	/**
	 * @param depgar the depgar to set
	 */
	public void setDepgar(boolean depgar) {
		this.depgar = depgar;
	}
}
