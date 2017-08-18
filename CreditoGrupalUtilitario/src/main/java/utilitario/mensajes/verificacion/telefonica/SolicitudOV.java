package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class SolicitudOV extends ObjetoValor {

	/**
	 * SolicitudOV
	 */
	public SolicitudOV() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = -8005525520407471148L;

	//Credito
	/**
	 * java.lang.String sucursal
	 */
	private java.lang.String				sucursal;
	/**
	 * java.lang.String cdgAsesor
	 */
	private java.lang.String				cdgAsesor;
	/**
	 * java.lang.String producto
	 */
	private java.lang.String				producto;
	/**
	 * java.lang.String tasa
	 */
	private java.lang.String				tasa;
	/**
	 * java.lang.String plazo
	 */
	private java.lang.String				plazo;
	/**
	 * java.lang.String frecuenciaPago
	 */
	private java.lang.String				frecuenciaPago;
	/**
	 * java.lang.String diaReunion
	 */
	private java.lang.String				diaReunion;
	/**
	 * java.lang.String horaReunion
	 */
	private java.lang.String				horaReunion;
	/**
	 * java.math.BigDecimal nuevoCreditoSolicitado
	 */
	private java.math.BigDecimal			nuevoCreditoSolicitado;
	/**
	 * java.util.Date fechaDesembolso
	 */
	private java.util.Date					fechaDesembolso;
	/**
	 * java.util.Date fechaFin
	 */
	private java.util.Date					fechaFin;
	/**
	 * java.lang.String ciclo
	 */
	private java.lang.String				ciclo;

	//Grupo
    /**
     * java.lang.String codigoGrupo
     */
    private java.lang.String 				codigoGrupo;
  	/**
  	 * java.lang.String nombreGrupo
  	 */
  	private java.lang.String 				nombreGrupo;
 	/**
 	 * java.lang.String presidente
 	 */
 	private java.lang.String 				presidente;
 	/**
 	 * java.lang.String tesorero
 	 */
 	private java.lang.String 				tesorero;
 	/**
 	 * java.lang.String secretario
 	 */
 	private java.lang.String 				secretario;

	//Clientes
	/**
	 * java.util.List<IntegrantesOV> listaIntegrantesOVs
	 */
	private java.util.List<IntegrantesOV> 	listaIntegrantesOVs;

	/**
	 * @return the sucursal
	 */
	public java.lang.String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the cdgAsesor
	 */
	public java.lang.String getCdgAsesor() {
		return cdgAsesor;
	}

	/**
	 * @param cdgAsesor the cdgAsesor to set
	 */
	public void setCdgAsesor(java.lang.String cdgAsesor) {
		this.cdgAsesor = cdgAsesor;
	}

	/**
	 * @return the producto
	 */
	public java.lang.String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(java.lang.String producto) {
		this.producto = producto;
	}

	/**
	 * @return the tasa
	 */
	public java.lang.String getTasa() {
		return tasa;
	}

	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(java.lang.String tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the plazo
	 */
	public java.lang.String getPlazo() {
		return plazo;
	}

	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(java.lang.String plazo) {
		this.plazo = plazo;
	}

	/**
	 * @return the frecuenciaPago
	 */
	public java.lang.String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	/**
	 * @param frecuenciaPago the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(java.lang.String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}

	/**
	 * @return the diaReunion
	 */
	public java.lang.String getDiaReunion() {
		return diaReunion;
	}

	/**
	 * @param diaReunion the diaReunion to set
	 */
	public void setDiaReunion(java.lang.String diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * @return the horaReunion
	 */
	public java.lang.String getHoraReunion() {
		return horaReunion;
	}

	/**
	 * @param horaReunion the horaReunion to set
	 */
	public void setHoraReunion(java.lang.String horaReunion) {
		this.horaReunion = horaReunion;
	}

	/**
	 * @return the nuevoCreditoSolicitado
	 */
	public java.math.BigDecimal getNuevoCreditoSolicitado() {
		return nuevoCreditoSolicitado;
	}

	/**
	 * @param nuevoCreditoSolicitado the nuevoCreditoSolicitado to set
	 */
	public void setNuevoCreditoSolicitado(
			java.math.BigDecimal nuevoCreditoSolicitado) {
		this.nuevoCreditoSolicitado = nuevoCreditoSolicitado;
	}

	/**
	 * @return the fechaDesembolso
	 */
	public java.util.Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	/**
	 * @param fechaDesembolso the fechaDesembolso to set
	 */
	public void setFechaDesembolso(java.util.Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	/**
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * @return the ciclo
	 */
	public java.lang.String getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(java.lang.String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the codigoGrupo
	 */
	public java.lang.String getCodigoGrupo() {
		return codigoGrupo;
	}

	/**
	 * @param codigoGrupo the codigoGrupo to set
	 */
	public void setCodigoGrupo(java.lang.String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}

	/**
	 * @return the nombreGrupo
	 */
	public java.lang.String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(java.lang.String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * @return the presidente
	 */
	public java.lang.String getPresidente() {
		return presidente;
	}

	/**
	 * @param presidente the presidente to set
	 */
	public void setPresidente(java.lang.String presidente) {
		this.presidente = presidente;
	}

	/**
	 * @return the tesorero
	 */
	public java.lang.String getTesorero() {
		return tesorero;
	}

	/**
	 * @param tesorero the tesorero to set
	 */
	public void setTesorero(java.lang.String tesorero) {
		this.tesorero = tesorero;
	}

	/**
	 * @return the secretario
	 */
	public java.lang.String getSecretario() {
		return secretario;
	}

	/**
	 * @param secretario the secretario to set
	 */
	public void setSecretario(java.lang.String secretario) {
		this.secretario = secretario;
	}

	/**
	 * @return the listaIntegrantesOVs
	 */
	public java.util.List<IntegrantesOV> getListaIntegrantesOVs() {
		return listaIntegrantesOVs;
	}

	/**
	 * @param listaIntegrantesOVs the listaIntegrantesOVs to set
	 */
	public void setListaIntegrantesOVs(
			java.util.List<IntegrantesOV> listaIntegrantesOVs) {
		this.listaIntegrantesOVs = listaIntegrantesOVs;
	}


}
