/**
 *
 */
package utilitario.mensajes.chequescreditogrupal;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class UniversoPrimerPagoPeticion.
 *
 * @author out_ltorres
 */
public class UniversoPrimerPagoPeticion  extends ObjetoValor {

	/**
	 * Instancia una nueva universo primer pago peticion.
	 */
	public UniversoPrimerPagoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1863518522458278164L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The fecha proceso semanal. */
	private String fechaProcesoSemanal;

	/** The fecha proceso catorcenal. */
	private String fechaProcesoCatorcenal;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene fecha proceso semanal.
	 *
	 * @return fecha proceso semanal
	 */
	public String getFechaProcesoSemanal() {
		return fechaProcesoSemanal;
	}

	/**
	 * Establece fecha proceso semanal.
	 *
	 * @param fechaProcesoSemanal a fecha proceso semanal
	 */
	public void setFechaProcesoSemanal(String fechaProcesoSemanal) {
		this.fechaProcesoSemanal = fechaProcesoSemanal;
	}

	/**
	 * Obtiene fecha proceso catorcenal.
	 *
	 * @return fecha proceso catorcenal
	 */
	public String getFechaProcesoCatorcenal() {
		return fechaProcesoCatorcenal;
	}

	/**
	 * Establece fecha proceso catorcenal.
	 *
	 * @param fechaProcesoCatorcenal a fecha proceso catorcenal
	 */
	public void setFechaProcesoCatorcenal(String fechaProcesoCatorcenal) {
		this.fechaProcesoCatorcenal = fechaProcesoCatorcenal;
	}
}
