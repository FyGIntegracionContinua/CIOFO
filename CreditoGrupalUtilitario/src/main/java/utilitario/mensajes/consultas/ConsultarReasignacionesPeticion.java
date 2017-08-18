package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarReasignacionesPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ConsultarReasignacionesPeticion
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2362237146458086954L;

	// Atributos privados  ------------------------------------------------------------------
	/** The header. */
	private EncabezadoPeticion		header;

	/** The asesor. */
	private java.lang.String		asesor;

	/** The sucursal. */
	private java.lang.Integer		sucursal;

	/** The fecha inicio. */
	private java.util.Date 			fechaInicio;

	/** The fecha fin. */
	private java.util.Date 			fechaFin;

	/** The zona. */
	private java.lang.Integer		zona;

	// Constructor --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar reasignaciones peticion.
	 */
	public ConsultarReasignacionesPeticion() {
		header = new EncabezadoPeticion();
		}

	// Funciones get y set  -----------------------------------------------------------------
	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene asesor.
	 *
	 * @return the asesor
	 */
	public java.lang.String getAsesor() {
		return asesor;
	}

	/**
	 * Establece asesor.
	 *
	 * @param asesor the asesor to set
	 */
	public void setAsesor(java.lang.String asesor) {
		this.asesor = asesor;
	}

	/**
	 * Obtiene zona.
	 *
	 * @return the zona
	 */
	public java.lang.Integer getZona() {
		return zona;
	}

	/**
	 * Establece zona.
	 *
	 * @param zona the zona to set
	 */
	public void setZona(java.lang.Integer zona) {
		this.zona = zona;
	}

}
