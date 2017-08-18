package utilitario.mensajes.burocredito;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoRFCRespuesta.
 *
 * @author out_ltorres
 */
public class BuroCreditoRFCRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito rfc respuesta.
	 */
	public BuroCreditoRFCRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8127051135326382924L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The rfc. */
	private String rfc;

	/** The persona. */
	private String persona;

	/** The clientes. */
	private List<BuroCreditoRFC> clientes;

	/** The clientes bce. */
	private List<BuroCreditoBCE> clientesBCE;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
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
	 * Obtiene rfc.
	 *
	 * @return rfc
	 */
	public String getRfc() {
		return rfc;
	}

	/**
	 * Establece rfc.
	 *
	 * @param rfc a rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona a persona
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Obtiene clientes.
	 *
	 * @return clientes
	 */
	public List<BuroCreditoRFC> getClientes() {
		return clientes;
	}

	/**
	 * Establece clientes.
	 *
	 * @param clientes a clientes
	 */
	public void setClientes(List<BuroCreditoRFC> clientes) {
		this.clientes = clientes;
	}

	/**
	 * Obtiene clientes bce.
	 *
	 * @return clientes bce
	 */
	public List<BuroCreditoBCE> getClientesBCE() {
		return clientesBCE;
	}

	/**
	 * Establece clientes bce.
	 *
	 * @param clientesBCE a clientes bce
	 */
	public void setClientesBCE(List<BuroCreditoBCE> clientesBCE) {
		this.clientesBCE = clientesBCE;
	}

}
