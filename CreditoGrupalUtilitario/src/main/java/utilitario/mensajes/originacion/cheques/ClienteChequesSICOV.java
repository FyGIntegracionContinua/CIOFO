/**
 *
 */
package utilitario.mensajes.originacion.cheques;

import java.math.BigDecimal;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ClienteChequesSICOV.
 *
 * @author out_jcmoreno
 */
public class ClienteChequesSICOV extends ObjetoValor {

	/**
	 * Instancia una nueva cliente cheques sicov.
	 */
	public ClienteChequesSICOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The cliente id. */
	private String clienteId;

	/** The cliente. */
	private String cliente;

	/** The monto. */
	private BigDecimal monto;

	/** The saldo vigente. */
	private BigDecimal saldoVigente;

	/** The ciclo. */
	private Integer ciclo;


		/**
		 * Obtiene renovacion.
		 *
		 * @return the renovacion
		 */
	public String getRenovacion() {
		if ( this.saldoVigente != null && saldoVigente.doubleValue() > 0 ) {
			return "1";
		}
		else {
			return "0";
		}
	}


		/**
		 * Obtiene cliente id.
		 *
		 * @return the clienteId
		 */
		public String getClienteId() {
			return clienteId;
		}


		/**
		 * Establece cliente id.
		 *
		 * @param clienteId the clienteId to set
		 */
		public void setClienteId(String clienteId) {
			this.clienteId = clienteId;
		}


		/**
		 * Obtiene cliente.
		 *
		 * @return the cliente
		 */
		public String getCliente() {
			return cliente;
		}


		/**
		 * Establece cliente.
		 *
		 * @param cliente the cliente to set
		 */
		public void setCliente(String cliente) {
			this.cliente = cliente;
		}


		/**
		 * Obtiene monto.
		 *
		 * @return the monto
		 */
		public BigDecimal getMonto() {
			return monto;
		}


		/**
		 * Establece monto.
		 *
		 * @param monto the monto to set
		 */
		public void setMonto(BigDecimal monto) {
			this.monto = monto;
		}


		/**
		 * Obtiene saldo vigente.
		 *
		 * @return the saldoVigente
		 */
		public BigDecimal getSaldoVigente() {
			return saldoVigente;
		}


		/**
		 * Establece saldo vigente.
		 *
		 * @param saldoVigente the saldoVigente to set
		 */
		public void setSaldoVigente(BigDecimal saldoVigente) {
			this.saldoVigente = saldoVigente;
		}


		/**
		 * Obtiene ciclo.
		 *
		 * @return the ciclo
		 */
		public Integer getCiclo() {
			return ciclo;
		}


		/**
		 * Establece ciclo.
		 *
		 * @param ciclo the ciclo to set
		 */
		public void setCiclo(Integer ciclo) {
			this.ciclo = ciclo;
		}

}
