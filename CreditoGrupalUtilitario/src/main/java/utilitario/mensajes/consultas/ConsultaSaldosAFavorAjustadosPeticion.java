package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSaldosAFavorAjustadosPeticion.
 */
public class ConsultaSaldosAFavorAjustadosPeticion extends ObjetoValor  {

	/**
	 * Instancia una nueva consulta saldos a favor ajustados peticion.
	 */
	public ConsultaSaldosAFavorAjustadosPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -661983154627053298L;

	/** The header. */
	private EncabezadoPeticion		header;

	/** The sucursal. */
	private java.lang.Integer		sucursal;

	/** The fecha inicio. */
	private java.util.Date 			fechaInicio;

	/** The fecha fin. */
	private java.util.Date 			fechaFin;

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
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return fecha inicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio a fecha inicio
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return fecha fin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin a fecha fin
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}


}
