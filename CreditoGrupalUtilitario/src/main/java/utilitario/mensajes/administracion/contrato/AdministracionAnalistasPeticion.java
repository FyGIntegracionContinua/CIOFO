/**
 * 
 */
package utilitario.mensajes.administracion.contrato;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author sramirezher
 *
 */
public class AdministracionAnalistasPeticion extends ObjetoValor {

	/**
	 * serial.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * usuario.
	 */
	private java.lang.String usuario;
	/**
	 * numAnalista.
	 */
	private java.lang.String numAnalista;
	/**
	 * cbLunes.
	 */
	private java.lang.String cbLunes;
	/**
	 * cbMartes.
	 */
	private java.lang.String cbMartes;
	/**
	 * cbMiercoles.
	 */
	private java.lang.String cbMiercoles;
	/**
	 * cbJueves.
	 */
	private java.lang.String cbJueves;
	/**
	 * cbViernes.
	 */
	private java.lang.String cbViernes;
	/**
	 * cbSabado.
	 */
	private java.lang.String cbSabado;
	/**
	 * cbDomingo.
	 */
	private java.lang.String cbDomingo;
	/**
	 * cmbHorarioTrabajoInicio.
	 */
	private java.util.Date cmbHorarioTrabajoInicio;
	/**
	 * cmbHorarioTrabajoFin.
	 */
	private java.util.Date cmbHorarioTrabajoFin;
	/**
	 * cmbHorarioDescansoInicio.
	 */
	private java.util.Date cmbHorarioDescansoInicio;
	/**
	 * cmbHorarioDescansoFin.
	 */
	private java.util.Date cmbHorarioDescansoFin;
	/**
	 * cmbHorarioTrabajoInicioFS.
	 */
	private java.util.Date cmbHorarioTrabajoInicioFS;
	/**
	 * cmbHorarioTrabajoFinFS.
	 */
	private java.util.Date cmbHorarioTrabajoFinFS;
	/**
	 * cmbHorarioDescansoInicioFS.
	 */
	private java.util.Date cmbHorarioDescansoInicioFS;
	/**
	 * cmbHorarioDescansoFinFS.
	 */
	private java.util.Date cmbHorarioDescansoFinFS;
	/**
	 * dfFechaVacacionesInicio.
	 */
	private java.util.Date dfFechaVacacionesInicio;
	/**
	 * dfFechaVacacionesFin.
	 */
	private java.util.Date dfFechaVacacionesFin;
	/**
	 * cmbCategoriaAnalista.
	 */
	private java.lang.String cmbCategoriaAnalista;
	/**
	 * cmdProducto.
	 */
	private java.util.List<String> cmdProducto;
	/**
	 * producto.
	 */
	private java.lang.String producto;
	/**
	 * cmbSucursales.
	 */
	private java.util.List<Integer> cmbSucursales;
	/**
	 * sucursal.
	 */
	private java.lang.Integer sucursal;
	/**
	 * cmbNivelRestriccion.
	 */
	private java.util.List<String> cmbNivelRestriccion;
	/**
	 * nivelRestriccion.
	 */
	private java.lang.String nivelRestriccion;
	/**
	 * cmbTipoSucursal.
	 */
	private java.util.List<String> cmbTipoSucursal;
	/**
	 * tipoSucursal.
	 */
	private java.lang.String tipoSucursal;
	/**
	 * cmbCampanas.
	 */
	private java.util.List<String> cmbCampanas;
	/**
	 * campana.
	 */
	private java.lang.String campana;
	/**
	 * fecha contingencia.
	 */
	private java.util.Date fechaContingencia;
	/**
	 * nombre analista
	 */
	private java.lang.String nombreAnalista;
	/**
	 * @return the numAnalista
	 */
	public java.lang.String getNumAnalista() {
		return numAnalista;
	}
	/**
	 * @param numAnalista the numAnalista to set
	 */
	public void setNumAnalista(java.lang.String numAnalista) {
		this.numAnalista = numAnalista;
	}
	/**
	 * @return the cbLunes
	 */
	public java.lang.String getCbLunes() {
		return cbLunes;
	}
	/**
	 * @param cbLunes the cbLunes to set
	 */
	public void setCbLunes(java.lang.String cbLunes) {
		this.cbLunes = cbLunes;
	}
	/**
	 * @return the cbMartes
	 */
	public java.lang.String getCbMartes() {
		return cbMartes;
	}
	/**
	 * @param cbMartes the cbMartes to set
	 */
	public void setCbMartes(java.lang.String cbMartes) {
		this.cbMartes = cbMartes;
	}
	/**
	 * @return the cbMiercoles
	 */
	public java.lang.String getCbMiercoles() {
		return cbMiercoles;
	}
	/**
	 * @param cbMiercoles the cbMiercoles to set
	 */
	public void setCbMiercoles(java.lang.String cbMiercoles) {
		this.cbMiercoles = cbMiercoles;
	}
	/**
	 * @return the cbJueves
	 */
	public java.lang.String getCbJueves() {
		return cbJueves;
	}
	/**
	 * @param cbJueves the cbJueves to set
	 */
	public void setCbJueves(java.lang.String cbJueves) {
		this.cbJueves = cbJueves;
	}
	/**
	 * @return the cbViernes
	 */
	public java.lang.String getCbViernes() {
		return cbViernes;
	}
	/**
	 * @param cbViernes the cbViernes to set
	 */
	public void setCbViernes(java.lang.String cbViernes) {
		this.cbViernes = cbViernes;
	}
	/**
	 * @return the cbSabado
	 */
	public java.lang.String getCbSabado() {
		return cbSabado;
	}
	/**
	 * @param cbSabado the cbSabado to set
	 */
	public void setCbSabado(java.lang.String cbSabado) {
		this.cbSabado = cbSabado;
	}
	/**
	 * @return the cbDomingo
	 */
	public java.lang.String getCbDomingo() {
		return cbDomingo;
	}
	/**
	 * @param cbDomingo the cbDomingo to set
	 */
	public void setCbDomingo(java.lang.String cbDomingo) {
		this.cbDomingo = cbDomingo;
	}
	/**
	 * @return the cmbHorarioTrabajoInicio
	 */
	public java.util.Date getCmbHorarioTrabajoInicio() {
		return cmbHorarioTrabajoInicio;
	}
	/**
	 * @param cmbHorarioTrabajoInicio the cmbHorarioTrabajoInicio to set
	 */
	public void setCmbHorarioTrabajoInicio(java.util.Date cmbHorarioTrabajoInicio) {
		this.cmbHorarioTrabajoInicio = cmbHorarioTrabajoInicio;
	}
	/**
	 * @return the cmbHorarioTrabajoFin
	 */
	public java.util.Date getCmbHorarioTrabajoFin() {
		return cmbHorarioTrabajoFin;
	}
	/**
	 * @param cmbHorarioTrabajoFin the cmbHorarioTrabajoFin to set
	 */
	public void setCmbHorarioTrabajoFin(java.util.Date cmbHorarioTrabajoFin) {
		this.cmbHorarioTrabajoFin = cmbHorarioTrabajoFin;
	}
	/**
	 * @return the cmbHorarioDescansoInicio
	 */
	public java.util.Date getCmbHorarioDescansoInicio() {
		return cmbHorarioDescansoInicio;
	}
	/**
	 * @param cmbHorarioDescansoInicio the cmbHorarioDescansoInicio to set
	 */
	public void setCmbHorarioDescansoInicio(java.util.Date cmbHorarioDescansoInicio) {
		this.cmbHorarioDescansoInicio = cmbHorarioDescansoInicio;
	}
	/**
	 * @return the cmbHorarioDescansoFin
	 */
	public java.util.Date getCmbHorarioDescansoFin() {
		return cmbHorarioDescansoFin;
	}
	/**
	 * @param cmbHorarioDescansoFin the cmbHorarioDescansoFin to set
	 */
	public void setCmbHorarioDescansoFin(java.util.Date cmbHorarioDescansoFin) {
		this.cmbHorarioDescansoFin = cmbHorarioDescansoFin;
	}
	/**
	 * @return the cmbHorarioTrabajoInicioFS
	 */
	public java.util.Date getCmbHorarioTrabajoInicioFS() {
		return cmbHorarioTrabajoInicioFS;
	}
	/**
	 * @param cmbHorarioTrabajoInicioFS the cmbHorarioTrabajoInicioFS to set
	 */
	public void setCmbHorarioTrabajoInicioFS(
			java.util.Date cmbHorarioTrabajoInicioFS) {
		this.cmbHorarioTrabajoInicioFS = cmbHorarioTrabajoInicioFS;
	}
	/**
	 * @return the cmbHorarioTrabajoFinFS
	 */
	public java.util.Date getCmbHorarioTrabajoFinFS() {
		return cmbHorarioTrabajoFinFS;
	}
	/**
	 * @param cmbHorarioTrabajoFinFS the cmbHorarioTrabajoFinFS to set
	 */
	public void setCmbHorarioTrabajoFinFS(java.util.Date cmbHorarioTrabajoFinFS) {
		this.cmbHorarioTrabajoFinFS = cmbHorarioTrabajoFinFS;
	}
	/**
	 * @return the cmbHorarioDescansoInicioFS
	 */
	public java.util.Date getCmbHorarioDescansoInicioFS() {
		return cmbHorarioDescansoInicioFS;
	}
	/**
	 * @param cmbHorarioDescansoInicioFS the cmbHorarioDescansoInicioFS to set
	 */
	public void setCmbHorarioDescansoInicioFS(
			java.util.Date cmbHorarioDescansoInicioFS) {
		this.cmbHorarioDescansoInicioFS = cmbHorarioDescansoInicioFS;
	}
	/**
	 * @return the cmbHorarioDescansoFinFS
	 */
	public java.util.Date getCmbHorarioDescansoFinFS() {
		return cmbHorarioDescansoFinFS;
	}
	/**
	 * @param cmbHorarioDescansoFinFS the cmbHorarioDescansoFinFS to set
	 */
	public void setCmbHorarioDescansoFinFS(java.util.Date cmbHorarioDescansoFinFS) {
		this.cmbHorarioDescansoFinFS = cmbHorarioDescansoFinFS;
	}
	/**
	 * @return the dfFechaVacacionesInicio
	 */
	public java.util.Date getDfFechaVacacionesInicio() {
		return dfFechaVacacionesInicio;
	}
	/**
	 * @param dfFechaVacacionesInicio the dfFechaVacacionesInicio to set
	 */
	public void setDfFechaVacacionesInicio(java.util.Date dfFechaVacacionesInicio) {
		this.dfFechaVacacionesInicio = dfFechaVacacionesInicio;
	}
	/**
	 * @return the dfFechaVacacionesFin
	 */
	public java.util.Date getDfFechaVacacionesFin() {
		return dfFechaVacacionesFin;
	}
	/**
	 * @param dfFechaVacacionesFin the dfFechaVacacionesFin to set
	 */
	public void setDfFechaVacacionesFin(java.util.Date dfFechaVacacionesFin) {
		this.dfFechaVacacionesFin = dfFechaVacacionesFin;
	}
	/**
	 * @return the cmbCategoriaAnalista
	 */
	public java.lang.String getCmbCategoriaAnalista() {
		return cmbCategoriaAnalista;
	}
	/**
	 * @param cmbCategoriaAnalista the cmbCategoriaAnalista to set
	 */
	public void setCmbCategoriaAnalista(java.lang.String cmbCategoriaAnalista) {
		this.cmbCategoriaAnalista = cmbCategoriaAnalista;
	}
	/**
	 * @return the cmdProducto
	 */
	public java.util.List<String> getCmdProducto() {
		return cmdProducto;
	}
	/**
	 * @param cmdProducto the cmdProducto to set
	 */
	public void setCmdProducto(java.util.List<String> cmdProducto) {
		this.cmdProducto = cmdProducto;
	}
	/**
	 * @return the cmbSucursales
	 */
	public java.util.List<Integer> getCmbSucursales() {
		return cmbSucursales;
	}
	/**
	 * @param cmbSucursales the cmbSucursales to set
	 */
	public void setCmbSucursales(java.util.List<Integer> cmbSucursales) {
		this.cmbSucursales = cmbSucursales;
	}
	/**
	 * @return the cmbNivelRestriccion
	 */
	public java.util.List<String> getCmbNivelRestriccion() {
		return cmbNivelRestriccion;
	}
	/**
	 * @param cmbNivelRestriccion the cmbNivelRestriccion to set
	 */
	public void setCmbNivelRestriccion(java.util.List<String> cmbNivelRestriccion) {
		this.cmbNivelRestriccion = cmbNivelRestriccion;
	}
	/**
	 * @return the cmbTipoSucursal
	 */
	public java.util.List<String> getCmbTipoSucursal() {
		return cmbTipoSucursal;
	}
	/**
	 * @param cmbTipoSucursal the cmbTipoSucursal to set
	 */
	public void setCmbTipoSucursal(java.util.List<String> cmbTipoSucursal) {
		this.cmbTipoSucursal = cmbTipoSucursal;
	}
	/**
	 * @return the cmbCampanas
	 */
	public java.util.List<String> getCmbCampanas() {
		return cmbCampanas;
	}
	/**
	 * @param cmbCampanas the cmbCampanas to set
	 */
	public void setCmbCampanas(java.util.List<String> cmbCampanas) {
		this.cmbCampanas = cmbCampanas;
	}
	/**
	 * @return the usuario
	 */
	public java.lang.String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(java.lang.String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the fechaContingencia
	 */
	public java.util.Date getFechaContingencia() {
		return fechaContingencia;
	}
	/**
	 * @param fechaContingencia the fechaContingencia to set
	 */
	public void setFechaContingencia(java.util.Date fechaContingencia) {
		this.fechaContingencia = fechaContingencia;
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
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the nivelRestriccion
	 */
	public java.lang.String getNivelRestriccion() {
		return nivelRestriccion;
	}
	/**
	 * @param nivelRestriccion the nivelRestriccion to set
	 */
	public void setNivelRestriccion(java.lang.String nivelRestriccion) {
		this.nivelRestriccion = nivelRestriccion;
	}
	/**
	 * @return the tipoSucursal
	 */
	public java.lang.String getTipoSucursal() {
		return tipoSucursal;
	}
	/**
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(java.lang.String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}
	/**
	 * @return the campana
	 */
	public java.lang.String getCampana() {
		return campana;
	}
	/**
	 * @param campana the campana to set
	 */
	public void setCampana(java.lang.String campana) {
		this.campana = campana;
	}
	/**
	 * @return the nombreAnalista
	 */
	public java.lang.String getNombreAnalista() {
		return nombreAnalista;
	}
	/**
	 * @param nombreAnalista the nombreAnalista to set
	 */
	public void setNombreAnalista(java.lang.String nombreAnalista) {
		this.nombreAnalista = nombreAnalista;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AdministracionAnalistasPeticion [usuario=" + usuario
				+ ", numAnalista=" + numAnalista + ", cbLunes=" + cbLunes
				+ ", cbMartes=" + cbMartes + ", cbMiercoles=" + cbMiercoles
				+ ", cbJueves=" + cbJueves + ", cbViernes=" + cbViernes
				+ ", cbSabado=" + cbSabado + ", cbDomingo=" + cbDomingo
				+ ", cmbHorarioTrabajoInicio=" + cmbHorarioTrabajoInicio
				+ ", cmbHorarioTrabajoFin=" + cmbHorarioTrabajoFin
				+ ", cmbHorarioDescansoInicio=" + cmbHorarioDescansoInicio
				+ ", cmbHorarioDescansoFin=" + cmbHorarioDescansoFin
				+ ", cmbHorarioTrabajoInicioFS=" + cmbHorarioTrabajoInicioFS
				+ ", cmbHorarioTrabajoFinFS=" + cmbHorarioTrabajoFinFS
				+ ", cmbHorarioDescansoInicioFS=" + cmbHorarioDescansoInicioFS
				+ ", cmbHorarioDescansoFinFS=" + cmbHorarioDescansoFinFS
				+ ", dfFechaVacacionesInicio=" + dfFechaVacacionesInicio
				+ ", dfFechaVacacionesFin=" + dfFechaVacacionesFin
				+ ", cmbCategoriaAnalista=" + cmbCategoriaAnalista
				+ ", cmdProducto=" + cmdProducto + ", producto=" + producto
				+ ", cmbSucursales=" + cmbSucursales + ", sucursal=" + sucursal
				+ ", cmbNivelRestriccion=" + cmbNivelRestriccion
				+ ", nivelRestriccion=" + nivelRestriccion
				+ ", cmbTipoSucursal=" + cmbTipoSucursal + ", tipoSucursal="
				+ tipoSucursal + ", cmbCampanas=" + cmbCampanas + ", campana="
				+ campana + ", fechaContingencia=" + fechaContingencia
				+ ", nombreAnalista=" + nombreAnalista + "]";
	}
}
