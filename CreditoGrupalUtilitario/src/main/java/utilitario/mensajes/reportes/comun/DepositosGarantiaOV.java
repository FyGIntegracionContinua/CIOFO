package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class DepositosGarantiaOV extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -8369067054361279220L;

	/** Descripcion codigo */
	private String descripcionCodigo;

	/** fecha */
	private String fecha;

	/** Importe */
	private String importe;

	/** Saldo */
	private String saldo;

	/**
	 * @return the descripcionCodigo
	 */
	public String getDescripcionCodigo() {
		return descripcionCodigo;
	}

	/**
	 * @param descripcionCodigo the descripcionCodigo to set
	 */
	public void setDescripcionCodigo(String descripcionCodigo) {
		this.descripcionCodigo = descripcionCodigo;
	}

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(String importe) {
		this.importe = importe;
	}

	/**
	 * @return the saldo
	 */
	public String getSaldo() {
		return saldo;
	}

	/**
	 * @param saldo the saldo to set
	 */
	public void setSaldo(String saldo) {
		this.saldo = saldo;
	}
}
