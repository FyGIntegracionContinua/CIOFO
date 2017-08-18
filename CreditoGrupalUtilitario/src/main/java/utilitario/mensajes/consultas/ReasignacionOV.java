package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_oarias
 *
 */
public 	class 	ReasignacionOV 	extends ObjetoValor	{
	/**
	 * UID para la serializacion
	 */
	private static final long serialVersionUID = 5339094097640348053L;
	// Atributos privados  -------------------------------------------------------------------------------
	/**
	 * sucursalOriginal java.lang.String
	 */
	private java.lang.String	sucursalOriginal;
	/**
	 * zonaOriginal java.lang.String
	 */
	private java.lang.String	zonaOriginal;
	/**
	 * sucursalReasignada java.lang.String
	 */
	private java.lang.String	sucursalReasignada;
	/**
	 * zonaReasignada java.lang.String
	 */
	private java.lang.String	zonaReasignada;
	/**
	 * nombreAsesorOriginal java.lang.String
	 */
	private java.lang.String	nombreAsesorOriginal;
	/**
	 * nombreAsesorReasignado java.lang.String
	 */
	private java.lang.String	nombreAsesorReasignado;
	/**
	 * grupo java.lang.String
	 */
	private java.lang.String	grupo;
	/**
	 * contratoLD java.lang.String
	 */
	private java.lang.String	contratoLD;
	/**
	 * motivo java.lang.String
	 */
	private java.lang.String	motivo;
	/**
	 * numeroReasignaciones java.lang.Integer
	 */
	private java.lang.Integer	numeroReasignaciones;
	/**
	 * saldoCapital java.lang.Double
	 */
	private java.lang.Double	saldoCapital;
	/**
	 * saldoTotal java.lang.Double
	 */
	private java.lang.Double	saldoTotal;
	/**
	 * contratoLD java.lang.String
	 */
	private java.lang.String	contrato;
	// Constructor  --------------------------------------------------------------------------------------
	/**
	 * ReasignacionOV
	 */
	public ReasignacionOV() {
		}

	// Set y Get  ----------------------------------------------------------------------------------------
	/**
	 * @return the sucursalOriginal
	 */
	public java.lang.String getSucursalOriginal() {
		return sucursalOriginal;
	}

	/**
	 * @param sucursalOriginal the sucursalOriginal to set
	 */
	public void setSucursalOriginal(java.lang.String sucursalOriginal) {
		this.sucursalOriginal = sucursalOriginal;
	}

	/**
	 * @return the sucursalReasignada
	 */
	public java.lang.String getSucursalReasignada() {
		return sucursalReasignada;
	}

	/**
	 * @param sucursalReasignada the sucursalReasignada to set
	 */
	public void setSucursalReasignada(java.lang.String sucursalReasignada) {
		this.sucursalReasignada = sucursalReasignada;
	}

	/**
	 * @return the nombreAsesorOriginal
	 */
	public java.lang.String getNombreAsesorOriginal() {
		return nombreAsesorOriginal;
	}

	/**
	 * @param nombreAsesorOriginal the nombreAsesorOriginal to set
	 */
	public void setNombreAsesorOriginal(java.lang.String nombreAsesorOriginal) {
		this.nombreAsesorOriginal = nombreAsesorOriginal;
	}

	/**
	 * @return the nombreAsesorReasignado
	 */
	public java.lang.String getNombreAsesorReasignado() {
		return nombreAsesorReasignado;
	}

	/**
	 * @param nombreAsesorReasignado the nombreAsesorReasignado to set
	 */
	public void setNombreAsesorReasignado(java.lang.String nombreAsesorReasignado) {
		this.nombreAsesorReasignado = nombreAsesorReasignado;
	}

	/**
	 * @return the grupo
	 */
	public java.lang.String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(java.lang.String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the contratoLD
	 */
	public java.lang.String getContratoLD() {
		return contratoLD;
	}

	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(java.lang.String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * @return the motivo
	 */
	public java.lang.String getMotivo() {
		return motivo;
	}

	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(java.lang.String motivo) {
		this.motivo = motivo;
	}

	/**
	 * @return the numeroReasignaciones
	 */
	public java.lang.Integer getNumeroReasignaciones() {
		return numeroReasignaciones;
	}

	/**
	 * @param numeroReasignaciones the numeroReasignaciones to set
	 */
	public void setNumeroReasignaciones(java.lang.Integer numeroReasignaciones) {
		this.numeroReasignaciones = numeroReasignaciones;
	}

	/**
	 * @return the saldoCapital
	 */
	public java.lang.Double getSaldoCapital() {
		return saldoCapital;
	}

	/**
	 * @param saldoCapital the saldoCapital to set
	 */
	public void setSaldoCapital(java.lang.Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	/**
	 * @return the saldoTotal
	 */
	public java.lang.Double getSaldoTotal() {
		return saldoTotal;
	}

	/**
	 * @param saldoTotal the saldoTotal to set
	 */
	public void setSaldoTotal(java.lang.Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	/**
	 * @return the zonaOriginal
	 */
	public java.lang.String getZonaOriginal() {
		return zonaOriginal;
	}

	/**
	 * @param zonaOriginal the zonaOriginal to set
	 */
	public void setZonaOriginal(java.lang.String zonaOriginal) {
		this.zonaOriginal = zonaOriginal;
	}

	/**
	 * @return the zonaReasignada
	 */
	public java.lang.String getZonaReasignada() {
		return zonaReasignada;
	}

	/**
	 * @param zonaReasignada the zonaReasignada to set
	 */
	public void setZonaReasignada(java.lang.String zonaReasignada) {
		this.zonaReasignada = zonaReasignada;
	}

	/**
	 * @return the contrato
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

}
