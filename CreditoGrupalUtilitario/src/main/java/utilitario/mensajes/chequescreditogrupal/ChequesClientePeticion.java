package utilitario.mensajes.chequescreditogrupal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ChequesClientePeticion.
 *
 * @author out_ltorres
 */
public class ChequesClientePeticion extends ObjetoValor {

	/**
	 * Instancia una nueva cheques cliente peticion.
	 */
	public ChequesClientePeticion() {

	}


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 3699313883527979064L;

	/** The header. */
	private EncabezadoPeticion	header;

	/** The cheques. */
	private List<ChequesCliente> cheques;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene cheques.
	 *
	 * @return cheques
	 */
	public List<ChequesCliente> getCheques() {
		return cheques;
	}

	/**
	 * Establece cheques.
	 *
	 * @param cheques a cheques
	 */
	public void setCheques(List<ChequesCliente> cheques) {
		this.cheques = cheques;
	}



}
