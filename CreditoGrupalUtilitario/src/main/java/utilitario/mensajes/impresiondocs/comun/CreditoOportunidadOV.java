/**
 * Informacion del credito oportunidad (por integrante)
 */
package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class CreditoOportunidadOV extends ObjetoValor {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 2075866090226737522L;
	/**
	 * Nombre del acreditado
	 */
	private String nombreAcreditado;
	/**
	 * Numero de cheque
	 */
	private String numeroCheque;
	/**
	 * Importe en pesos otorgado al acreditado
	 */
	private double importeCheque;
	/**
	 * Monto total a pagar Capital con interes (IVA incluido)
	 */
	private double montoTotalPagar;
	/**
	 * @return the nombreAcreditado
	 */
	public String getNombreAcreditado() {
		return nombreAcreditado;
	}
	/**
	 * @param nombreAcreditado the nombreAcreditado to set
	 */
	public void setNombreAcreditado(String nombreAcreditado) {
		this.nombreAcreditado = nombreAcreditado;
	}
	/**
	 * @return the numeroCheque
	 */
	public String getNumeroCheque() {
		return numeroCheque;
	}
	/**
	 * @param numeroCheque the numeroCheque to set
	 */
	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	/**
	 * @return the importeCheque
	 */
	public double getImporteCheque() {
		return importeCheque;
	}
	/**
	 * @param importeCheque the importeCheque to set
	 */
	public void setImporteCheque(double importeCheque) {
		this.importeCheque = importeCheque;
	}
	/**
	 * @return the montoTotalPagar
	 */
	public double getMontoTotalPagar() {
		return montoTotalPagar;
	}
	/**
	 * @param montoTotalPagar the montoTotalPagar to set
	 */
	public void setMontoTotalPagar(double montoTotalPagar) {
		this.montoTotalPagar = montoTotalPagar;
	}
}
