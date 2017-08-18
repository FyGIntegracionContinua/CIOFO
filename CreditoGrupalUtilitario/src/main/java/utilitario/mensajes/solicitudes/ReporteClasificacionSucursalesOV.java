package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class ReporteClasificacionSucursalesOV extends ObjetoValor {

	/**
	 * constructor
	 */
	public ReporteClasificacionSucursalesOV() {

	}
	/**
	 * serial
	 */
	private static final long serialVersionUID = 1203692521135427001L;

	/**
	 * String nombre ReporteClasificacionSucursalesOV.java
	 */
	private String nombreSucursal;

	/**
	 * String nivelRestriccion ReporteClasificacionSucursalesOV.java
	 */
	private String nivelRestriccion;

	/**
	 * String tipoSucursal ReporteClasificacionSucursalesOV.java
	 */
	private String tipoSucursal;


	/**
	 * Obtiene nombre.
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Obtiene nivelRestriccion.
	 *
	 * @return the nivelRestriccion
	 */
	public String getNivelRestriccion() {
		return nivelRestriccion;
	}

	/**
	 * @param nivelRestriccion the nivelRestriccion to set
	 */
	public void setNivelRestriccion(String nivelRestriccion) {
		this.nivelRestriccion = nivelRestriccion;
	}

	/**
	 * Obtiene tipoSucursal.
	 *
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

}
