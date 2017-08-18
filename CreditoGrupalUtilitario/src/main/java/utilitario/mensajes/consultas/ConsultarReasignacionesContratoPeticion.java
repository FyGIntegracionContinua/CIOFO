package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarReasignacionesContratoPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ConsultarReasignacionesContratoPeticion
		extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2362237146458086954L;

	// Atributos privados  ------------------------------------------------------------------
	/** The header. */
	private EncabezadoPeticion		header;

	/** The contrato. */
	private java.lang.String		contrato;

	// Constructor --------------------------------------------------------------------------
	/**
	 * Instancia una nueva consultar reasignaciones contrato peticion.
	 */
	public ConsultarReasignacionesContratoPeticion() {
		header = new EncabezadoPeticion();
		}

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
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	}
