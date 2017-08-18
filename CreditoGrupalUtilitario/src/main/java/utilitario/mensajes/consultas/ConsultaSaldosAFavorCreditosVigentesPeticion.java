package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSaldosAFavorCreditosVigentesPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ConsultaSaldosAFavorCreditosVigentesPeticion
		extends ObjetoValor {

	/**
	 * Instancia una nueva consulta saldos a favor creditos vigentes peticion.
	 */
	public ConsultaSaldosAFavorCreditosVigentesPeticion() {
	}

	/** El UID para la serializacion. */
	private static final long serialVersionUID = -4944750387193347703L;

	/** The header. */
	private EncabezadoPeticion		header;

	/** The sucursal. */
	private java.lang.Integer		sucursal;


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


	}
