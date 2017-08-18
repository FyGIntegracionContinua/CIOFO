/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.desembolso;

import utilitario.mensajes.comun.ObjetoValor;



/**
 * The Class DesembolsoOV.
 *
 * @author Juan Moreno
 * Encapsulalos
 * <ul>
 * 	<li>Identificador</li>
 * 	<li>Nombre del Grupo</li>
 * 	<li>Sucursal</li>
 * 	<li>Analista de operacion</li>
 * 	<li>Domicilio de las reuniones</li>
 * </ul>
 */
public final class DesembolsoOV extends ObjetoValor {

	/**
	 * Instancia una nueva desembolso ov.
	 */
	public DesembolsoOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4955570462066281566L;

	/** The sucursal. */
	private Integer sucursal;

	/** The contrato. */
	private String contrato;

	/** The operador. */
	private String operador;

	/** The monto. */
	private Double monto;

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene operador.
	 *
	 * @return the operador
	 */
	public String getOperador() {
		return operador;
	}

	/**
	 * Establece operador.
	 *
	 * @param operador the operador to set
	 */
	public void setOperador(String operador) {
		this.operador = operador;
	}

	/**
	 * Obtiene monto.
	 *
	 * @return the monto
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * Establece monto.
	 *
	 * @param monto the monto to set
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

}
