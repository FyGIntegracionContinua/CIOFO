package utilitario.mensajes.operacion.administracion;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DiasPeticion.
 */
public 	class DiasPeticion
		extends ObjetoValor {


	/**
	 * DiasPeticion
	 */
	public DiasPeticion() {
		super();
	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -9082325452375031534L;

	/**
	 * fecha Date
	 */
	private Date fecha; 							//SHORT.NAME

	/**
	 * @param fecha .
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return .
	 */
	public Date getFecha() {
		return fecha;
	}

	}
