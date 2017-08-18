package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class TrasferirSaldosAFavorCreditosVigentesPeticion.
 *
 * @author out_mreyes
 */
public 	class 	TrasferirSaldosAFavorCreditosVigentesPeticion
		extends ObjetoValor {

	/**
	 * Instancia una nueva trasferir saldos a favor creditos vigentes peticion.
	 */
	public TrasferirSaldosAFavorCreditosVigentesPeticion() {
	}
	/** UID para serializacion. */
	private static final long serialVersionUID = -5503188224455572320L;

	//Atributos privados  -----------------------------------------------------------
	/** The contratos transferir. */
	private java.util.List<TransferirSaldoAFavorOV>  contratosTransferir;

	//M&eacute;todos  -----------------------------------------------------------------------
	/**
	 * Obtiene contratos transferir.
	 *
	 * @return the contratosTransferir
	 */
	public java.util.List<TransferirSaldoAFavorOV> getContratosTransferir() {
		return contratosTransferir;
	}

	/**
	 * Establece contratos transferir.
	 *
	 * @param contratosTransferir the contratosTransferir to set
	 */
	public void setContratosTransferir(
			java.util.List<TransferirSaldoAFavorOV> contratosTransferir) {
		this.contratosTransferir = contratosTransferir;
	}


}
