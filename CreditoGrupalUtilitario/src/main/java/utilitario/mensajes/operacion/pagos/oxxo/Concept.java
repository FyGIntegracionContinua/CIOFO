package utilitario.mensajes.operacion.pagos.oxxo;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * Clase en la cual se contiene las descripci&oacute;n de la operaci&oacute;n a
 * realizar por ejemplo:
 * + :  Este concepto se debe cobrar al cliente
 * - : Este concepto se descuenta al cliente
 * max :Este concepto representa el monto m�ximo.
 * min: Este concepto representa el monto m�nimo.
 * t : Concepto total a pagar por el cliente
 * @author out_rmontellanom
 * @version 1.0
 */
public class Concept  extends ObjetoValor {

	/**
	 *serialVersionUID uid.
	 */
	private static final long serialVersionUID = 296995316747209558L;
	/**
	 * cantidad a cobrar o descontar.
	 */
	private String amount;
	/**
	 * Descripci&oacute;n que puedes ser (Subtotal, reconnection, discount. amount max,
	 * amount min, Total)
	 */
	private String description;
	/**
	 * Operaci&oacute;n a realizar (+, -, max, min, t)
	 */
	private String operation;
	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the operation
	 */
	public String getOperation() {
		return operation;
	}
	/**
	 * @param operation the operation to set
	 */
	public void setOperation(String operation) {
		this.operation = operation;
	}

} //end Concepts
