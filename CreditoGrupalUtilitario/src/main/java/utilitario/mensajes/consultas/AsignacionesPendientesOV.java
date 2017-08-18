package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AsignacionesPendientesOV.
 *
 * @author rguadarramac
 */
public class AsignacionesPendientesOV extends ObjetoValor {

	/**
	 * Instancia una nueva asignaciones pendientes ov.
	 */
	public AsignacionesPendientesOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6496790882947080580L;

	/** The contrato ld. */
	private String 		contratoLD;

	/** The numero asesor. */
	private String  	numeroAsesor;

	/** The dia reunion. */
	private Integer		diaReunion;

	/** The hora reunion inicio. */
	private String		horaReunionInicio;

	/** The hora reunion fin. */
	private String		horaReunionFin;


	/**
	 * Obtiene contrato ld.
	 *
	 * @return contrato ld
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD a contrato ld
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Obtiene numero asesor.
	 *
	 * @return numero asesor
	 */
	public String getNumeroAsesor() {
		return numeroAsesor;
	}

	/**
	 * Establece numero asesor.
	 *
	 * @param numeroAsesor a numero asesor
	 */
	public void setNumeroAsesor(String numeroAsesor) {
		this.numeroAsesor = numeroAsesor;
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
	 * Obtiene hora reunion inicio.
	 *
	 * @return hora reunion inicio
	 */
	public String getHoraReunionInicio() {
		return horaReunionInicio;
	}

	/**
	 * Establece hora reunion inicio.
	 *
	 * @param horaReunionInicio a hora reunion inicio
	 */
	public void setHoraReunionInicio(String horaReunionInicio) {
		this.horaReunionInicio = horaReunionInicio;
	}

	/**
	 * Obtiene hora reunion fin.
	 *
	 * @return hora reunion fin
	 */
	public String getHoraReunionFin() {
		return horaReunionFin;
	}

	/**
	 * Establece hora reunion fin.
	 *
	 * @param horaReunionFin a hora reunion fin
	 */
	public void setHoraReunionFin(String horaReunionFin) {
		this.horaReunionFin = horaReunionFin;
	}

}
