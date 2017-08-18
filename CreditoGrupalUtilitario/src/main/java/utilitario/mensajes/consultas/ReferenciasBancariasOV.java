package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

public class ReferenciasBancariasOV extends 	ObjetoValor {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = 3243644904865278578L;

	/** The referencia banamex. */
	private String 										referenciaBanamex;

	/** The referencia fisa. */
	private String 										referenciaFISA;

	/** The referencia bancomer. */
	private String 										referenciaBancomer;

	/** The referencia hsbc. */
	private String 										referenciaHSBC;

	/** The referencia oxxo. */
	private String 										referenciaOXXO;

	/** The referencia Diestel. */
	private String 										referenciaDIESTEL;

	/** The referencia referenciaPayBin. */
	private String 										referenciaPayBin;

	/** The contrato. */
	private String  								    contrato;

	/** The referencia oxxo. */
	private String  									grupo;

	/**
	 * Constructor
	 */
	public ReferenciasBancariasOV() {

	}
	/**
	 * @return the referenciaBanamex
	 */
	public String getReferenciaBanamex() {
		return referenciaBanamex;
	}

	/**
	 * @param referenciaBanamex the referenciaBanamex to set
	 */
	public void setReferenciaBanamex(String referenciaBanamex) {
		this.referenciaBanamex = referenciaBanamex;
	}

	/**
	 * @return the referenciaFISA
	 */
	public String getReferenciaFISA() {
		return referenciaFISA;
	}

	/**
	 * @param referenciaFISA the referenciaFISA to set
	 */
	public void setReferenciaFISA(String referenciaFISA) {
		this.referenciaFISA = referenciaFISA;
	}

	/**
	 * @return the referenciaBancomer
	 */
	public String getReferenciaBancomer() {
		return referenciaBancomer;
	}

	/**
	 * @param referenciaBancomer the referenciaBancomer to set
	 */
	public void setReferenciaBancomer(String referenciaBancomer) {
		this.referenciaBancomer = referenciaBancomer;
	}

	/**
	 * @return the referenciaHSBC
	 */
	public String getReferenciaHSBC() {
		return referenciaHSBC;
	}

	/**
	 * @param referenciaHSBC the referenciaHSBC to set
	 */
	public void setReferenciaHSBC(String referenciaHSBC) {
		this.referenciaHSBC = referenciaHSBC;
	}

	/**
	 * @return the referenciaOXXO
	 */
	public String getReferenciaOXXO() {
		return referenciaOXXO;
	}

	/**
	 * @param referenciaOXXO the referenciaOXXO to set
	 */
	public void setReferenciaOXXO(String referenciaOXXO) {
		this.referenciaOXXO = referenciaOXXO;
	}
	/**
	 * @return the referenciaDIESTEL
	 */
	public String getReferenciaDIESTEL() {
		return referenciaDIESTEL;
	}
	/**
	 * @param referenciaDIESTEL the referenciaDiestel to set
	 */
	public void setReferenciaDIESTEL(String referenciaDIESTEL) {
		this.referenciaDIESTEL = referenciaDIESTEL;
	}
	/**
	 * @return the referenciaPayBin
	 */
	public String getReferenciaPayBin() {
		return referenciaPayBin;
	}
	/**
	 * @param referenciaPayBin the referenciaPayBin to set
	 */
	public void setReferenciaPayBin(String referenciaPayBin) {
		this.referenciaPayBin = referenciaPayBin;
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
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

}
