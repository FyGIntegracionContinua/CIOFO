package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReporteClasificacionSucursalesRespuesta.
 * @author gcorzo
 */
public class ReporteClasificacionSucursalesRespuesta extends ObjetoValor {

	/** Serial. */
	private static final long serialVersionUID = -6269087027507980533L;

	/**
	 * EncabezadoRespuesta ReporteClasificacionSucursalesRespuesta.java
	 */
	private EncabezadoRespuesta header;

	/** List<ReporteClasificacionSucursalesOV> sucursales. */
	private List<ReporteClasificacionSucursalesOV> sucursales;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene sucursales.
	 *
	 * @return the sucursales
	 */
	public List<ReporteClasificacionSucursalesOV> getSucursalesClasif() {
		return sucursales;
	}

	/**
	 * Establece header.
	 *
	 * @param sucursales the sucursales to set
	 */
	public void setSucursalesClasif(List<ReporteClasificacionSucursalesOV> sucursales) {
		this.sucursales = sucursales;
	}

}
