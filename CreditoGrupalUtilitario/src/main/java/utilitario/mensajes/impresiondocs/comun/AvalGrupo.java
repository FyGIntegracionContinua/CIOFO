package utilitario.mensajes.impresiondocs.comun;

/**
 * The Class AvalGrupo.
 */
public class AvalGrupo {

	/**
	 * Instancia una nueva aval grupo.
	 */
	public AvalGrupo() {
	}
	/**  Id del cliente? SI. */
	private String cliente;
	/**
	 * ?? Titulo de la persona, Sr.,Sra, etc Se obtiene de acuerdo a un catalogo
	 */
	private String titaval;

	/**  ?? Consecutivo, para comunal son 4 avales. */
	private String numaval;

	/** Nombre del aval ? SI. */
	private String nomaval;
	
	/**  Domicilio aval (calle). */
	private String calleaval;

	/**  Domicilio aval (colonia). */
	private String coloniaaval;

	/**  Domicilio aval (ciudad). */
	private String ciudadaval;

	/** Domicilio aval (estado). */
	private String estadoaval;

	/** Domicilio aval (cp). */
	private String cpaval;

	/** Telefono del aval �domicilio? SI. */
	private String tel;

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
	 * Obtiene titaval.
	 *
	 * @return the titaval
	 */
	public String getTitaval() {
		return titaval;
	}

	/**
	 * Establece titaval.
	 *
	 * @param titaval the titaval to set
	 */
	public void setTitaval(String titaval) {
		this.titaval = titaval;
	}

	/**
	 * Obtiene numaval.
	 *
	 * @return the numaval
	 */
	public String getNumaval() {
		return numaval;
	}

	/**
	 * Establece numaval.
	 *
	 * @param numaval the numaval to set
	 */
	public void setNumaval(String numaval) {
		this.numaval = numaval;
	}

	/**
	 * Obtiene nomaval.
	 *
	 * @return the nomaval
	 */
	public String getNomaval() {
		return nomaval;
	}

	/**
	 * Establece nomaval.
	 *
	 * @param nomaval the nomaval to set
	 */
	public void setNomaval(String nomaval) {
		this.nomaval = nomaval;
	}

	/**
	 * Obtiene calleaval.
	 *
	 * @return the calleaval
	 */
	public String getCalleaval() {
		return calleaval;
	}

	/**
	 * Establece calleaval.
	 *
	 * @param calleaval the calleaval to set
	 */
	public void setCalleaval(String calleaval) {
		this.calleaval = calleaval;
	}

	/**
	 * Obtiene coloniaaval.
	 *
	 * @return the coloniaaval
	 */
	public String getColoniaaval() {
		return coloniaaval;
	}

	/**
	 * Establece coloniaaval.
	 *
	 * @param coloniaaval the coloniaaval to set
	 */
	public void setColoniaaval(String coloniaaval) {
		this.coloniaaval = coloniaaval;
	}

	/**
	 * Obtiene ciudadaval.
	 *
	 * @return the ciudadaval
	 */
	public String getCiudadaval() {
		return ciudadaval;
	}

	/**
	 * Establece ciudadaval.
	 *
	 * @param ciudadaval the ciudadaval to set
	 */
	public void setCiudadaval(String ciudadaval) {
		this.ciudadaval = ciudadaval;
	}

	/**
	 * Obtiene estadoaval.
	 *
	 * @return the estadoaval
	 */
	public String getEstadoaval() {
		return estadoaval;
	}

	/**
	 * Establece estadoaval.
	 *
	 * @param estadoaval the estadoaval to set
	 */
	public void setEstadoaval(String estadoaval) {
		this.estadoaval = estadoaval;
	}

	/**
	 * Obtiene cpaval.
	 *
	 * @return the cpaval
	 */
	public String getCpaval() {
		return cpaval;
	}

	/**
	 * Establece cpaval.
	 *
	 * @param cpaval the cpaval to set
	 */
	public void setCpaval(String cpaval) {
		this.cpaval = cpaval;
	}

	/**
	 * Obtiene tel.
	 *
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Establece tel.
	 *
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel == null ? "" : tel;
	}

}
