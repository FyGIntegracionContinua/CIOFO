package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ConfirmarCreditoRespuesta extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -3379234138814783034L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/** The contrato. */
	private String contratoLD;


	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}


}
