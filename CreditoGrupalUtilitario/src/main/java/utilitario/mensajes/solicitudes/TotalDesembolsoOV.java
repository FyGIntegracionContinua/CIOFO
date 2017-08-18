package utilitario.mensajes.solicitudes;

import java.math.BigDecimal;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class TotalDesembolsoOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class TotalDesembolsoOV extends ObjetoValor {

	/**
	 * Instancia un nuevo codigo ov.
	 */
	public TotalDesembolsoOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 31905069059425868L;

	/** The totalDesembolso. */
	private BigDecimal totalDesembolso;

	/** The NumSolicitudes. */
	private int numSolicitudes;

	/**
	 * @return the totalDesembolso
	 */
	public BigDecimal getTotalDesembolso() {
		return totalDesembolso;
	}

	/**
	 * @param totalDesembolso the totalDesembolso to set
	 */
	public void setTotalDesembolso(BigDecimal totalDesembolso) {
		this.totalDesembolso = totalDesembolso;
	}

	/**
	 * @return the numSolicitudes
	 */
	public int getNumSolicitudes() {
		return numSolicitudes;
	}

	/**
	 * @param numSolicitudes the numSolicitudes to set
	 */
	public void setNumSolicitudes(int numSolicitudes) {
		this.numSolicitudes = numSolicitudes;
	}
}

