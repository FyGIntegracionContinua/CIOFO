package utilitario.mensajes.operacion.pagos;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class RespuestaConciliarPagos extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -7252530245901090522L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;
	/**
	 * pagos
	 */
	private List<PagoDTO> pagos;

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
	 * @return the pagos
	 */
	public List<PagoDTO> getPagos() {
		return pagos;
	}
	/**
	 * @param pagos the pagos to set
	 */
	public void setPagos(List<PagoDTO> pagos) {
		this.pagos = pagos;
	}

}
