package utilitario.mensajes.administracion.contrato;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.originacion.cancelacion.FoliosChequesSIC;

/**
 * The Class AjusteChequeDevueltoRespuesta.
 *
 * @author out_oarias
 */
public class AjusteChequeDevueltoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva ajuste cheque devuelto respuesta.
	 */
	public AjusteChequeDevueltoRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/**
	 * The resultadoSIC
	 */
	private List<FoliosChequesSIC> resultadoSIC;

	/**
	 * Establece el resultado de Cheques SIC se se tiene
	 * 
	 * @param resultadoSIC
	 *            the resultadoSIC to set
	 */
	public void setResultadoSIC(List<FoliosChequesSIC> resultadoSIC) {
		this.resultadoSIC = resultadoSIC;
	}

	/**
	 * @return the resultadoSIC
	 */
	public List<FoliosChequesSIC> getResultadoSIC() {
		return resultadoSIC;
	}
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

}
