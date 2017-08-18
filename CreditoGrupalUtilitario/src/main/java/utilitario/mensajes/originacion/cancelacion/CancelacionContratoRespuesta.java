/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.cancelacion;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class CancelacionContratoRespuesta.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarContrato...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Identificador del Nuevo contrato.</li>
 *  <li>Numero ld_contrato.</li>
 *  <li>Numero del grupo.</li>
 *  <li>Ciclo actualizado del grupo.</li>
 *  <li>.</li>
 * </ul>
 */
public final class CancelacionContratoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva cancelacion contrato respuesta.
	 */
	public CancelacionContratoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	private List<FoliosChequesSIC> resultadoSIC;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the resultadoSIC
	 */
	public List<FoliosChequesSIC> getResultadoSIC() {
		return resultadoSIC;
	}

	/**
	 * @param resultadoSIC the resultadoSIC to set
	 */
	public void setResultadoSIC(List<FoliosChequesSIC> resultadoSIC) {
		this.resultadoSIC = resultadoSIC;
	}

}
