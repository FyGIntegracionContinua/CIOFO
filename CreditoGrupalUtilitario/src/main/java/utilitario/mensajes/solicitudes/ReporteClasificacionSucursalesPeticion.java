package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteClasificacionSucursalesPeticion
 * @author gcorzo
 *
 */
public class ReporteClasificacionSucursalesPeticion extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = -1592101649103687682L;

	/**
	 * EncabezadoRespuesta ReporteBuroExternoRespuesta.java
	 */
	private EncabezadoPeticion header;

	/**
	 * String sucursal ReporteClasificacionSucursalesOV.java
	 */
	private String sucursal;

	/**
	 * String nivelRestriccion ReporteClasificacionSucursalesOV.java
	 */
	private String nivelRestriccion;

	/**
	 * String tipoSucursal ReporteClasificacionSucursalesOV.java
	 */
	private String tipoSucursal;



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
