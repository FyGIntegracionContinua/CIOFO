/**
 * Informacion de los clientes para la carta instruccion
 */
package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class CartaInstruccionOV extends ObjetoValor {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -7286532211305184663L;
	/**
	 * Nombre completo del cliente (Acreditado) con formato:
	 * NOMBRE(S) + APELLIDO PATERNO + APELLIDO MATERNO
	 */
	private String nombreCliente;
	/**
	 * Monto del credito a Financiar:
	 * Es el monto total del nuevo credito por cliente
	 */
	private double montoFinanciar;
	/**
	 * Adeudo del credito previo:
	 * Es el monto total del credito anterior que el cliente tiene adeudo
	 */
	private double adeudoPrevio;
	/**
	 * Efectivo a ebtregar a traves de cheque
	 */
	private double efectivoEntregar;
	/**
	 * @return the nombreCliente
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}
	/**
	 * @param nombreCliente the nombreCliente to set
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	/**
	 * @return the montoFinanciar
	 */
	public double getMontoFinanciar() {
		return montoFinanciar;
	}
	/**
	 * @param montoFinanciar the montoFinanciar to set
	 */
	public void setMontoFinanciar(double montoFinanciar) {
		this.montoFinanciar = montoFinanciar;
	}
	/**
	 * @return the adeudoPrevio
	 */
	public double getAdeudoPrevio() {
		return adeudoPrevio;
	}
	/**
	 * @param adeudoPrevio the adeudoPrevio to set
	 */
	public void setAdeudoPrevio(double adeudoPrevio) {
		this.adeudoPrevio = adeudoPrevio;
	}
	/**
	 * @return the efectivoEntregar
	 */
	public double getEfectivoEntregar() {
		return efectivoEntregar;
	}
	/**
	 * @param efectivoEntregar the efectivoEntregar to set
	 */
	public void setEfectivoEntregar(double efectivoEntregar) {
		this.efectivoEntregar = efectivoEntregar;
	}
}
