package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AsignacionOV.
 *
 * @author rguadarramac
 *
 */
public class AsignacionOV extends ObjetoValor {

	/**
	 * Instancia una nueva asignacion ov.
	 */
	public AsignacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2916422337122933550L;

	/** The numero sucursal. */
	private Integer numeroSucursal;

	/** The dia reunion. */
	private Integer diaReunion;

	/** The hora reunion. */
	private String horaReunion;

	/** The num contratos. */
	private Integer numContratos;

	/** The frecuencia. */
	private String frecuencia;



	/**
	 * Establece numero sucursal.
	 *
	 * @param numeroSucursal a numero sucursal
	 */
	public void setNumeroSucursal(Integer numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	/**
	 * Obtiene numero sucursal.
	 *
	 * @return numero sucursal
	 */
	public Integer getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * Obtiene dia reunion.
	 *
	 * @return dia reunion
	 */
	public Integer getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion a dia reunion
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Obtiene hora reunion.
	 *
	 * @return hora reunion
	 */
	public String getHoraReunion() {
		return horaReunion;
	}

	/**
	 * Establece hora reunion.
	 *
	 * @param horaReunion a hora reunion
	 */
	public void setHoraReunion(String horaReunion) {
		this.horaReunion = horaReunion;
	}

	/**
	 * Obtiene num contratos.
	 *
	 * @return num contratos
	 */
	public Integer getNumContratos() {
		return numContratos;
	}

	/**
	 * Establece num contratos.
	 *
	 * @param numContratos a num contratos
	 */
	public void setNumContratos(Integer numContratos) {
		this.numContratos = numContratos;
	}

	/**
	 * Establece frecuencia.
	 *
	 * @param frecuencia a frecuencia
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Obtiene frecuencia.
	 *
	 * @return frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

}
