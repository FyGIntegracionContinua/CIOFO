package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClienteHistoricoRespuesta.
 */
public class ClienteHistoricoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva cliente historico respuesta.
	 */
	public ClienteHistoricoRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8202439971046525342L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The datos historicos. */
	private java.util.List<ClientesHistorico> datosHistoricos;

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece datos historicos.
	 *
	 * @param datosHistoricos a datos historicos
	 */
	public void setDatosHistoricos(java.util.List<ClientesHistorico> datosHistoricos) {
		this.datosHistoricos = datosHistoricos;
	}

	/**
	 * Obtiene datos historicos.
	 *
	 * @return datos historicos
	 */
	public java.util.List<ClientesHistorico> getDatosHistoricos() {
		return datosHistoricos;
	}

}
