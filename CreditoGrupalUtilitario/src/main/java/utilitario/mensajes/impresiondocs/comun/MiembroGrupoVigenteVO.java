package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class MiembroGrupoVigenteVO.
 */
public class MiembroGrupoVigenteVO extends ObjetoValor {

	/**
	 * MiembroGrupoVigenteVO.
	 */
	public MiembroGrupoVigenteVO() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = -4217942462906590603L;

	/** persona String. */
	private String persona;

	/** cliente String. */
	private String cliente;

	/** numMiembro String. */
	private String numMiembro;

	/** montoOtorgado Double. */
	private Double montoOtorgado;

	/** montoLetra String. */
	private String montoLetra;

	/** status String. */
	private String status;

	/** pctParticipacion Double. */
	private Double pctParticipacion;

	/**
	 * Obtiene persona.
	 *
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
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
	 * Obtiene num miembro.
	 *
	 * @return the numMiembro
	 */
	public String getNumMiembro() {
		return numMiembro;
	}

	/**
	 * Establece num miembro.
	 *
	 * @param numMiembro the numMiembro to set
	 */
	public void setNumMiembro(String numMiembro) {
		this.numMiembro = numMiembro;
	}

	/**
	 * Obtiene monto otorgado.
	 *
	 * @return the montoOtorgado
	 */
	public Double getMontoOtorgado() {
		return montoOtorgado;
	}

	/**
	 * Establece monto otorgado.
	 *
	 * @param montoOtorgado the montoOtorgado to set
	 */
	public void setMontoOtorgado(Double montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}

	/**
	 * Obtiene monto letra.
	 *
	 * @return the montoLetra
	 */
	public String getMontoLetra() {
		return montoLetra;
	}

	/**
	 * Establece monto letra.
	 *
	 * @param montoLetra the montoLetra to set
	 */
	public void setMontoLetra(String montoLetra) {
		this.montoLetra = montoLetra;
	}

	/**
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene pct participacion.
	 *
	 * @return the pctParticipacion
	 */
	public Double getPctParticipacion() {
		return pctParticipacion;
	}

	/**
	 * Establece pct participacion.
	 *
	 * @param pctParticipacion the pctParticipacion to set
	 */
	public void setPctParticipacion(Double pctParticipacion) {
		this.pctParticipacion = pctParticipacion;
	}

}
