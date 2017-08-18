package utilitario.mensajes.consultas;

import java.io.Serializable;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class GrupoHistoricoRespuesta.
 *
 * @author mimejorada
 */
public class GrupoHistoricoRespuesta
extends ObjetoValor
implements Serializable {

	/**
	 * GrupoHistoricoRespuesta.
	 */
	public GrupoHistoricoRespuesta() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 3739400554739970764L;
	/**
	 * ultimoLD java.lang.String
	 */
	private java.lang.String	ultimoLD;

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta 	header;

	/**
	 * Establece ultimo ld.
	 *
	 * @param ultimoLD .
	 */
	public void setUltimoLD(java.lang.String ultimoLD) {
		this.ultimoLD = ultimoLD;
	}

	/**
	 * Obtiene ultimo ld.
	 *
	 * @return .
	 */
	public java.lang.String getUltimoLD() {
		return ultimoLD;
	}

	/**
	 * Establece header.
	 *
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

}
