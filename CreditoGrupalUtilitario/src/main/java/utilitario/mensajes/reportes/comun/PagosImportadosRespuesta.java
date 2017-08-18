package utilitario.mensajes.reportes.comun;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class PagosImportadosRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5628804512910936507L;

	/** EncabezadoRespuesta header. */
	private EncabezadoRespuesta header;
	/** Colleccion de pagos. */
	private List<PagoImportado> pagos;
	/**
	 * @return the pagos
	 */
	public List<PagoImportado> getPagos() {
		return pagos;
	}
	/**
	 * @param pagos the pagos to set
	 */
	public void setPagos(List<PagoImportado> pagos) {
		this.pagos = pagos;
	}
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

}
