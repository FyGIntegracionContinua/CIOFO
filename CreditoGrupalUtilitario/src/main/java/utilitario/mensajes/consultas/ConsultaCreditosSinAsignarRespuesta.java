package utilitario.mensajes.consultas;



import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaCreditosSinAsignarRespuesta.
 */
public class ConsultaCreditosSinAsignarRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3851210473450456138L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The creditos. */
	private List<CreditosSinAsignar> creditos;

	/**
	 * Instancia una nueva consulta creditos sin asignar respuesta.
	 */
	public ConsultaCreditosSinAsignarRespuesta() {
		this.setHeader(new EncabezadoRespuesta());
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
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece creditos.
	 *
	 * @param creditos the creditos to set
	 */
	public void setCreditos(List<CreditosSinAsignar> creditos) {
		this.creditos = creditos;
	}

	/**
	 * Obtiene creditos.
	 *
	 * @return the creditos
	 */
	public List<CreditosSinAsignar> getCreditos() {
		return creditos;
	}

}
