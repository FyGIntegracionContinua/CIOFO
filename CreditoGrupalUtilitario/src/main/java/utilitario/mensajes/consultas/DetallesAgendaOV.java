package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DetallesAgendaOV.
 *
 * @author rguadarramac
 */
public class DetallesAgendaOV extends ObjetoValor {

	/**
	 * Instancia una nueva detalles agenda ov.
	 */
	public DetallesAgendaOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5833833383621274768L;

	/** The dia reunion. */
	private Integer diaReunion;

	/** The total grupo dia. */
	private Integer totalGrupoDia;

	/** The total parcialidad dia. */
	private Double totalParcialidadDia;


	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion a dia reunion
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
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
	 * Obtiene total grupo dia.
	 *
	 * @return total grupo dia
	 */
	public Integer getTotalGrupoDia() {
		return totalGrupoDia;
	}

	/**
	 * Establece total grupo dia.
	 *
	 * @param totalGrupoDia a total grupo dia
	 */
	public void setTotalGrupoDia(Integer totalGrupoDia) {
		this.totalGrupoDia = totalGrupoDia;
	}

	/**
	 * Obtiene total parcialidad dia.
	 *
	 * @return total parcialidad dia
	 */
	public Double getTotalParcialidadDia() {
		return totalParcialidadDia;
	}

	/**
	 * Establece total parcialidad dia.
	 *
	 * @param totalParcialidadDia a total parcialidad dia
	 */
	public void setTotalParcialidadDia(Double totalParcialidadDia) {
		this.totalParcialidadDia = totalParcialidadDia;
	}

}
