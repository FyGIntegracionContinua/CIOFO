package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class SucursalOV extends ObjetoValor {

	/**
	 * SucursalOV
	 */
	public SucursalOV() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 4624718408909104962L;

	/**numero de sucursal*/
	private int sucursal;

	/**cupos de campaña para la sucursal*/
	private int cuposCampana;

	/**Monto $ exposiciónen el mes por Campaña */
	private double montoMesCampania;

	/**suspencion de grupos nuevos para la sucursal*/
	private String suspencionGrupoNuevo;

	/**Restricción colocación mayor a 16 semanas
	 * esto es para poner el 16 y en base a eso poner
	 * la validacion*/
	private int plazoRestriccionSemanal;

	/**Restricción colocació npago catorcenal*/
	private String plazoRestriccionCatorcenal;

	/** division de la sucursal */
	private String division;

	/** zona de la sucursal */
	private String zona;

	/** nombre de la sucursal */
	private String nombreSucursal;

	/** tipificacion de la sucursal */
	private String tipificacion;

	/** tipoSucursal de la sucursal */
	private String tipoSucursal;

	/**tipoSucursalDescripcion de la sucusal */
	private String tipoSucursalDescripcion;

	/**nivel de la sucursal */
	private String nivel;

	/** nivelRestriccion de la sucursal */
	private String nivelRestriccion;

	/**descripcion de la sucursal */
	private String descripcion;

	/**fecha_modificacion de la sucursal */
	private String fecha_modificacion;

	/** usuario_modificacion de la sucursal*/
	private String usuario_modificacion;

	/** cupoCampana de la sucursal */
	private String cupoCampana;

	/** montoMesCampana de la sucursal */
	private String montoMesCampana;

	/** suspensionGrupoNuevo de la sucursal */
	private String suspensionGrupoNuevo;

	/** restriccionColocacion de la sucursal */
	private String restriccionColocacion;

	/** restriccionPlazoCatorcenal de la sucursal */
	private String restriccionPlazoCatorcenal;

	/** aplicaCampana3 de la sucursal */
	private String aplicaCampana3;

	/** estatus de la sucursal estatus*/
	private String estatus;

	/**
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the cuposCampana
	 */
	public int getCuposCampana() {
		return cuposCampana;
	}

	/**
	 * @param cuposCampana the cuposCampana to set
	 */
	public void setCuposCampana(int cuposCampana) {
		this.cuposCampana = cuposCampana;
	}

	/**
	 * @return the montoMesCampania
	 */
	public double getMontoMesCampania() {
		return montoMesCampania;
	}

	/**
	 * @param montoMesCampania the montoMesCampania to set
	 */
	public void setMontoMesCampania(double montoMesCampania) {
		this.montoMesCampania = montoMesCampania;
	}

	/**
	 * @return the suspencionGrupoNuevo
	 */
	public String getSuspencionGrupoNuevo() {
		return suspencionGrupoNuevo;
	}

	/**
	 * @param suspencionGrupoNuevo the suspencionGrupoNuevo to set
	 */
	public void setSuspencionGrupoNuevo(String suspencionGrupoNuevo) {
		this.suspencionGrupoNuevo = suspencionGrupoNuevo;
	}

	/**
	 * @return the plazoRestriccionSemanal
	 */
	public int getPlazoRestriccionSemanal() {
		return plazoRestriccionSemanal;
	}

	/**
	 * @param plazoRestriccionSemanal the plazoRestriccionSemanal to set
	 */
	public void setPlazoRestriccionSemanal(int plazoRestriccionSemanal) {
		this.plazoRestriccionSemanal = plazoRestriccionSemanal;
	}

	/**
	 * @return the plazoRestriccionCatorcenal
	 */
	public String getPlazoRestriccionCatorcenal() {
		return plazoRestriccionCatorcenal;
	}

	/**
	 * @param plazoRestriccionCatorcenal the plazoRestriccionCatorcenal to set
	 */
	public void setPlazoRestriccionCatorcenal(String plazoRestriccionCatorcenal) {
		this.plazoRestriccionCatorcenal = plazoRestriccionCatorcenal;
	}

	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}

	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}

	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}

	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * @return the tipificacion
	 */
	public String getTipificacion() {
		return tipificacion;
	}

	/**
	 * @param tipificacion the tipificacion to set
	 */
	public void setTipificacion(String tipificacion) {
		this.tipificacion = tipificacion;
	}

	/**
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	/**
	 * @return the tipoSucursalDescripcion
	 */
	public String getTipoSucursalDescripcion() {
		return tipoSucursalDescripcion;
	}

	/**
	 * @param tipoSucursalDescripcion the tipoSucursalDescripcion to set
	 */
	public void setTipoSucursalDescripcion(String tipoSucursalDescripcion) {
		this.tipoSucursalDescripcion = tipoSucursalDescripcion;
	}

	/**
	 * @return the nivel
	 */
	public String getNivel() {
		return nivel;
	}

	/**
	 * @param nivel the nivel to set
	 */
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	/**
	 * @return the nivelRestriccion
	 */
	public String getNivelRestriccion() {
		return nivelRestriccion;
	}

	/**
	 * @param nivelRestriccion the nivelRestriccion to set
	 */
	public void setNivelRestriccion(String nivelRestriccion) {
		this.nivelRestriccion = nivelRestriccion;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the fecha_modificacion
	 */
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}

	/**
	 * @param fecha_modificacion the fecha_modificacion to set
	 */
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}

	/**
	 * @return the usuario_modificacion
	 */
	public String getUsuario_modificacion() {
		return usuario_modificacion;
	}

	/**
	 * @param usuario_modificacion the usuario_modificacion to set
	 */
	public void setUsuario_modificacion(String usuario_modificacion) {
		this.usuario_modificacion = usuario_modificacion;
	}

	/**
	 * @return the cupoCampana
	 */
	public String getCupoCampana() {
		return cupoCampana;
	}

	/**
	 * @param cupoCampana the cupoCampana to set
	 */
	public void setCupoCampana(String cupoCampana) {
		this.cupoCampana = cupoCampana;
	}

	/**
	 * @return the montoMesCampana
	 */
	public String getMontoMesCampana() {
		return montoMesCampana;
	}

	/**
	 * @param montoMesCampana the montoMesCampana to set
	 */
	public void setMontoMesCampana(String montoMesCampana) {
		this.montoMesCampana = montoMesCampana;
	}

	/**
	 * @return the suspensionGrupoNuevo
	 */
	public String getSuspensionGrupoNuevo() {
		return suspensionGrupoNuevo;
	}

	/**
	 * @param suspensionGrupoNuevo the suspensionGrupoNuevo to set
	 */
	public void setSuspensionGrupoNuevo(String suspensionGrupoNuevo) {
		this.suspensionGrupoNuevo = suspensionGrupoNuevo;
	}

	/**
	 * @return the restriccionColocacion
	 */
	public String getRestriccionColocacion() {
		return restriccionColocacion;
	}

	/**
	 * @param restriccionColocacion the restriccionColocacion to set
	 */
	public void setRestriccionColocacion(String restriccionColocacion) {
		this.restriccionColocacion = restriccionColocacion;
	}

	/**
	 * @return the restriccionPlazoCatorcenal
	 */
	public String getRestriccionPlazoCatorcenal() {
		return restriccionPlazoCatorcenal;
	}

	/**
	 * @param restriccionPlazoCatorcenal the restriccionPlazoCatorcenal to set
	 */
	public void setRestriccionPlazoCatorcenal(String restriccionPlazoCatorcenal) {
		this.restriccionPlazoCatorcenal = restriccionPlazoCatorcenal;
	}

	/**
	 * @return the aplicaCampana3
	 */
	public String getAplicaCampana3() {
		return aplicaCampana3;
	}

	/**
	 * @param aplicaCampana3 the aplicaCampana3 to set
	 */
	public void setAplicaCampana3(String aplicaCampana3) {
		this.aplicaCampana3 = aplicaCampana3;
	}

	/**
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "sucursal: " + sucursal + "\tcuposCampana: " + cuposCampana
				+ "\tmontoMesCampania: " + montoMesCampania + "\tsuspencionGrupoNuevo: " + suspencionGrupoNuevo
				+ "\tplazoRestriccionSemanal: " + plazoRestriccionSemanal + "\tplazoRestriccionCatorcenal: "
				+ plazoRestriccionCatorcenal;
	}

}
