package utilitario.mensajes.operacion.administracion;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CandadoPeticion.
 */
public 	class CandadoPeticion
		extends ObjetoValor	{


	/**
	 * CandadoPeticion
	 */
	public CandadoPeticion() {
		super();
	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 5542846713093194404L;

	/**
	 * fechaInicial Date
	 */
	private Date fechaInicial;

	/**
	 * @return .
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}
	/**
	 * @param fechaInicial .
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	}
