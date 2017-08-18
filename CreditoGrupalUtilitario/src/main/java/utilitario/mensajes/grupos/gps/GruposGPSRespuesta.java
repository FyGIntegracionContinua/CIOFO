package utilitario.mensajes.grupos.gps;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class GruposGPSRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 9202417111330629069L;
	/** respuesta */
	private EncabezadoRespuesta header;
	/** contratos */
	private List<ContratoDTO> contratos;
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
	 * @return the contratos
	 */
	public List<ContratoDTO> getContratos() {
		return contratos;
	}
	/**
	 * @param contratos the contratos to set
	 */
	public void setContratos(List<ContratoDTO> contratos) {
		this.contratos = contratos;
	}

}
