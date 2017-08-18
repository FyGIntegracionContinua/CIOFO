package utilitario.mensajes.operacion.pagos;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ConsultarPagosLineaRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -4580324462946407381L;

	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;

	/** pagos */
	private List<PagoLineaDTO> pagos;

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
	public List<PagoLineaDTO> getPagos() {
		return pagos;
	}

	/**
	 * @param pagos the pagos to set
	 */
	public void setPagos(List<PagoLineaDTO> pagos) {
		this.pagos = pagos;
	}

}
