/**
 *
 */
package utilitario.mensajes.operacion;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
/**
 * @author ca.ocampo
 *
 */
public class TraspasoPagosRespuesta  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2887792392967548389L;

	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;

	/**
	 * pagos
	 */
	private List<TraspasoPagos> pagos;

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
	public List<TraspasoPagos> getPagos() {
		return pagos;
	}
	/**
	 * @param pagos the pagos to set
	 */
	public void setPagos(List<TraspasoPagos> pagos) {
		this.pagos = pagos;
	}


	
}

