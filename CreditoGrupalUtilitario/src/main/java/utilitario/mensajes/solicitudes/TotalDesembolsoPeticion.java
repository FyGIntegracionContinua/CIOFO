/**
 *
 */
package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TotalDesembolsoPeticion.
 *
 * @author out_gcorzo
 */
public class TotalDesembolsoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva codigos peticion.
	 */
	public TotalDesembolsoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1255447782180796419L;

	/** The header. */
	private EncabezadoPeticion header;

	/**
	 * Date fechaInicial ReporteSolicitudesPeticion.java
	 */
	private Date fechaInicial;

	/**
	 * Date fechaFinal ReporteSolicitudesPeticion.java
	 */
	private Date fechaFinal;

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
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
	}
}
