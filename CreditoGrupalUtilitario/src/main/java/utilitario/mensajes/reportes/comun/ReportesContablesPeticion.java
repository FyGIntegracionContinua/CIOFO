package utilitario.mensajes.reportes.comun;

import java.util.Date;

import utilitario.mensajes.reportes.cierre.ReportesCierrePeticion;

/**
 * @author mi.mejorada
 *
 */
public class ReportesContablesPeticion extends ReportesCierrePeticion {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 8043066602198518062L;

	/**
	 * Constructor
	 */
	ReportesContablesPeticion() {

	}

	/**
	 * Obtiene la fecha
	 * @return fecha
	 */
	public Date getFecha() {
		return getFechaCierre();
	}

	/**
	 * @param fecha .
	 */
	public void setFecha(Date fecha) {
		setFechaCierre(fecha);
	}

}
