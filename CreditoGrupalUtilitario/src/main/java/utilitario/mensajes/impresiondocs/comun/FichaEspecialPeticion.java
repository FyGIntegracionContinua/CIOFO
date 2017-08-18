package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

public class FichaEspecialPeticion  extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 2508549288105878575L;

	/** contrato String	 */
	private String contrato;

	/** contrato String	 */
	private String fecha;

	/** contrato String	 */
	private String usuario;

	/** tipoImpresion String	 */
	private String tipoImpresion;
	
	/** almacenaBD boolean	 */
	private Boolean almacenaBD;

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
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the tipoImpresion
	 */
	public String getTipoImpresion() {
		return tipoImpresion;
	}

	/**
	 * @param tipoImpresion the tipoImpresion to set
	 */
	public void setTipoImpresion(String tipoImpresion) {
		this.tipoImpresion = tipoImpresion;
	}

	/**
	 * @return the almacenaBD
	 */
	public Boolean getAlmacenaBD() {
		return almacenaBD;
	}

	/**
	 * @param almacenaBD the almacenaBD to set
	 */
	public void setAlmacenaBD(Boolean almacenaBD) {
		this.almacenaBD = almacenaBD;
	}

}
