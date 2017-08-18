package utilitario.mensajes.seguros;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BeneficiarioOV.
 *
 * @author rguadarramac
 */
public class BeneficiarioOV extends ObjetoValor {

	/**
	 * Instancia una nueva beneficiario ov.
	 */
	public BeneficiarioOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 534839698349227187L;

	/** The nombre. */
	private String nombre;

	/** The apellido pat. */
	private String apellidoPat;

	/** The apellido mat. */
	private String apellidoMat;

	/** The parentesco. */
	private String parentesco;

	/** The porcentaje. */
	private Double porcentaje;

	/**
	 * Obtiene nombre.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre a nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene apellido pat.
	 *
	 * @return apellido pat
	 */
	public String getApellidoPat() {
		return apellidoPat;
	}

	/**
	 * Establece apellido pat.
	 *
	 * @param apellidoPat a apellido pat
	 */
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	/**
	 * Obtiene apellido mat.
	 *
	 * @return apellido mat
	 */
	public String getApellidoMat() {
		return apellidoMat;
	}

	/**
	 * Establece apellido mat.
	 *
	 * @param apellidoMat a apellido mat
	 */
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	/**
	 * Obtiene parentesco.
	 *
	 * @return parentesco
	 */
	public String getParentesco() {
		return parentesco;
	}

	/**
	 * Establece parentesco.
	 *
	 * @param parentesco a parentesco
	 */
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	/**
	 * Obtiene porcentaje.
	 *
	 * @return porcentaje
	 */
	public Double getPorcentaje() {
		return porcentaje;
	}

	/**
	 * Establece porcentaje.
	 *
	 * @param porcentaje a porcentaje
	 */
	public void setPorcentaje(Double porcentaje) {
		this.porcentaje = porcentaje;
	}



}
