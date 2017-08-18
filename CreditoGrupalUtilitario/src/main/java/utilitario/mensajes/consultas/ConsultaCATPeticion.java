package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaCATPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ConsultaCATPeticion
		extends	ObjetoValor	{

	/**
	 * Instancia una nueva consulta cat peticion.
	 */
	public ConsultaCATPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -395733995819139421L;

	// Atributos privados  ------------------------------------------------------------------
	/** The header. */
	private EncabezadoPeticion 					header;

	/** The pagos. */
	private java.util.List<java.lang.Double>	pagos;

	/** The monto credito. */
	private java.lang.Double					montoCredito;

	/** The plazo. */
	private java.lang.Integer					plazo;

	/** The periodo. */
	private java.lang.Integer					periodo;

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
	 * Obtiene pagos.
	 *
	 * @return the pagos
	 */
	public java.util.List<java.lang.Double> getPagos() {
		return pagos;
	}

	/**
	 * Establece pagos.
	 *
	 * @param pagos the pagos to set
	 */
	public void setPagos(java.util.List<java.lang.Double> pagos) {
		this.pagos = pagos;
	}

	/**
	 * Obtiene monto credito.
	 *
	 * @return the montoCredito
	 */
	public java.lang.Double getMontoCredito() {
		return montoCredito;
	}

	/**
	 * Establece monto credito.
	 *
	 * @param montoCredito the montoCredito to set
	 */
	public void setMontoCredito(java.lang.Double montoCredito) {
		this.montoCredito = montoCredito;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public java.lang.Integer getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(java.lang.Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene periodo.
	 *
	 * @return the periodo
	 */
	public java.lang.Integer getPeriodo() {
		return periodo;
	}

	/**
	 * Establece periodo.
	 *
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(java.lang.Integer periodo) {
		this.periodo = periodo;
	}

}
