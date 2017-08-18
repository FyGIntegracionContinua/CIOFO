package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class IntegrantePlanillaAprobOV.
 *
 * @author out_gcorzo
 * @version 1.0
 */
public class IntegrantePlanillaAprobOV extends ObjetoValor {

	/** Se genero serial. */
	private static final long serialVersionUID = 4423040734495125544L;

	/**
	 * Instancia una nueva historico planilla observacion ov.
	 */
	public IntegrantePlanillaAprobOV() {
	}

	/** The idPlanilla. */
	private Integer idPlanilla;

	/** The noPersona. */
	private String noPersona;

	/** The nombreCliente. */
	private String nombreCliente;

	/** The contrato. */
	private String contrato;

	/** The folioBuro. */
	private String folioBuro;

	/** The ligaBuroCto. */
	private String ligaEdoCtaCto;

	/** The ligaBuroFolio. */
	private String ligaBuroFolio;

	/**
	 * @return the folioBuro
	 */
	public String getFolioBuro() {
		return folioBuro;
	}

	/**
	 * @param folioBuro the folioBuro to set
	 */
	public void setFolioBuro(String folioBuro) {
		this.folioBuro = folioBuro;
	}

	/**
	 * @return the idPlanilla
	 */
	public Integer getIdPlanilla() {
		return idPlanilla;
	}

	/**
	 * @param idPlanilla the idPlanilla to set
	 */
	public void setIdPlanilla(Integer idPlanilla) {
		this.idPlanilla = idPlanilla;
	}

	/**
	 * @return the noPersona
	 */
	public String getNoPersona() {
		return noPersona;
	}

	/**
	 * @param noPersona the noPersona to set
	 */
	public void setNoPersona(String noPersona) {
		this.noPersona = noPersona;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

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
	 * @return the ligaEdoCtaCto
	 */
	public String getLigaEdoCtaCto() {
		return ligaEdoCtaCto;
	}

	/**
	 * @param ligaEdoCtaCto the ligaEdoCtaCto to set
	 */
	public void setLigaEdoCtaCto(String ligaEdoCtaCto) {
		this.ligaEdoCtaCto = ligaEdoCtaCto;
	}

	/**
	 * @return the ligaBuroFolio
	 */
	public String getLigaBuroFolio() {
		return ligaBuroFolio;
	}

	/**
	 * @param ligaBuroFolio the ligaBuroFolio to set
	 */
	public void setLigaBuroFolio(String ligaBuroFolio) {
		this.ligaBuroFolio = ligaBuroFolio;
	}

}
