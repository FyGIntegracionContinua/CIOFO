/**
 *
 */
package utilitario.mensajes.originacion.aprobacion;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaAprobacionPeticion.
 *
 * @author out_oarias
 */
public class PlanillaAprobacionPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva planilla aprobacion peticion.
	 */
	public PlanillaAprobacionPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The encabezado. */
	private EncabezadoPeticion encabezado;

	/** The numero contrato. */
	private String numeroContrato;

	/**
	 * Obtiene encabezado.
	 *
	 * @return the encabezado
	 */
	public EncabezadoPeticion getEncabezado() {
		return encabezado;
	}

	/**
	 * Establece encabezado.
	 *
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(EncabezadoPeticion encabezado) {
		this.encabezado = encabezado;
	}

	/**
	 * Obtiene numero contrato.
	 *
	 * @return the numeroContrato
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}

	/**
	 * Establece numero contrato.
	 *
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}

}
