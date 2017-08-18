package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ContratoCatPeticionKit.
 *
 * @author mi.mejorada
 */
public class ContratoCatPeticionKit extends ObjetoValor {

	/**
	 * ContratoPeticionKit.
	 */
	public ContratoCatPeticionKit() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -5296436412179929248L;

	/** header EncabezadoPeticion. */
	private EncabezadoPeticion	header;

	/** contrato String. */
	private String contrato;

	/** The cat. */
	private Double cat;

	/**
	 * Obtiene header.
	 *
	 * @return .
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header .
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return .
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato .
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene cat.
	 *
	 * @return cat
	 */
	public Double getCat() {
		return cat;
	}

	/**
	 * Establece cat.
	 *
	 * @param cat a cat
	 */
	public void setCat(Double cat) {
		this.cat = cat;
	}
}
