package utilitario.mensajes.seguros;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BeneficiariosClienteOV.
 *
 * @author rguadarramac
 */
public class BeneficiariosClienteOV extends ObjetoValor {

	/**
	 * Instancia una nueva beneficiarios cliente ov.
	 */
	public BeneficiariosClienteOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8162503219272468310L;

	/** The id. */
	private Integer id;

	/** The persona. */
	private String persona;

	/** The clave finsol. */
	private String claveFinsol;

	/** The beneficiarios. */
	private List<BeneficiarioOV> beneficiarios;


	/**
	 * Obtiene id.
	 *
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Establece id.
	 *
	 * @param id a id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona a persona
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Establece clave finsol.
	 *
	 * @param claveFinsol a clave finsol
	 */
	public void setClaveFinsol(String claveFinsol) {
		this.claveFinsol = claveFinsol;
	}

	/**
	 * Obtiene clave finsol.
	 *
	 * @return clave finsol
	 */
	public String getClaveFinsol() {
		return claveFinsol;
	}

	/**
	 * Obtiene beneficiarios.
	 *
	 * @return beneficiarios
	 */
	public List<BeneficiarioOV> getBeneficiarios() {
		return beneficiarios;
	}

	/**
	 * Establece beneficiarios.
	 *
	 * @param beneficiarios a beneficiarios
	 */
	public void setBeneficiarios(List<BeneficiarioOV> beneficiarios) {
		this.beneficiarios = beneficiarios;
	}

}
