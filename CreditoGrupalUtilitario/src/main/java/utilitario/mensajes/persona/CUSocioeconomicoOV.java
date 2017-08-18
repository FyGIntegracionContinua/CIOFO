/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CUSocioeconomicoOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class 	CUSocioeconomicoOV extends ObjetoValor {

	/** UID para serializacion. */
	private static final long serialVersionUID = -405303030011995698L;

	// Atributos  -----------------------------------------------------------------------
	/** The socioeconomico id. */
	private java.lang.Long					socioeconomicoID;

	/** The customer id. */
	private java.lang.String				customerID;

	/** The empresa. */
	private java.lang.String				empresa;

	/** The telefono. */
	private java.lang.String				telefono;

	/** The giro negocio. */
	private java.lang.Integer				giroNegocio;

	/** The tipo actividad. */
	private java.lang.Integer				tipoActividad;

	/** The tipo negocio. */
	private java.lang.Integer				tipoNegocio;

	/** The experiencia rubro. */
	private java.lang.Double				experienciaRubro;

	/** The experiencia negocio. */
	private java.lang.Double				experienciaNegocio;

	/** The ventas. */
	private java.lang.Double				ventas;

	/** The ganacia neta. */
	private java.lang.Double				ganaciaNeta;

	/** The ingresos otros. */
	private java.lang.Double				ingresosOtros;

	/** The ganacia actividad secundaria. */
	private java.lang.Double				ganaciaActividadSecundaria;

	/** The gasto familiar. */
	private java.lang.Double				gastoFamiliar;

	/** The inventario. */
	private java.lang.Double				inventario;

	/** The mobiliario equipo. */
	private java.lang.Double				mobiliarioEquipo;

	/** The superavit. */
	private java.lang.Double				superavit;

	/** The date insercion. */
	private java.util.Date					dateInsercion;

	/** The dias vende tianguis. */
	private java.lang.String				diasVendeTianguis;

	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva CU socioeconomico ov.
	 */
	public CUSocioeconomicoOV() {

		}

	// M&eacute;todo de acceso  ----------------------------------------------------------------
	/**
	 * Obtiene socioeconomico id.
	 *
	 * @return the socioeconomicoID
	 */
	public java.lang.Long getSocioeconomicoID() {
		return socioeconomicoID;
	}

	/**
	 * Establece socioeconomico id.
	 *
	 * @param socioeconomicoID the socioeconomicoID to set
	 */
	public void setSocioeconomicoID(java.lang.Long socioeconomicoID) {
		this.socioeconomicoID = socioeconomicoID;
	}

	/**
	 * Obtiene customer id.
	 *
	 * @return the customerID
	 */
	public java.lang.String getCustomerID() {
		return customerID;
	}

	/**
	 * Establece customer id.
	 *
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(java.lang.String customerID) {
		this.customerID = customerID;
	}

	/**
	 * Obtiene empresa.
	 *
	 * @return the empresa
	 */
	public java.lang.String getEmpresa() {
		return empresa;
	}

	/**
	 * Establece empresa.
	 *
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(java.lang.String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Obtiene telefono.
	 *
	 * @return the telefono
	 */
	public java.lang.String getTelefono() {
		return telefono;
	}

	/**
	 * Establece telefono.
	 *
	 * @param telefono the telefono to set
	 */
	public void setTelefono(java.lang.String telefono) {
		this.telefono = telefono;
	}

	/**
	 * Obtiene giro negocio.
	 *
	 * @return the giroNegocio
	 */
	public java.lang.Integer getGiroNegocio() {
		return giroNegocio;
	}

	/**
	 * Establece giro negocio.
	 *
	 * @param giroNegocio the giroNegocio to set
	 */
	public void setGiroNegocio(java.lang.Integer giroNegocio) {
		this.giroNegocio = giroNegocio;
	}

	/**
	 * Obtiene tipo actividad.
	 *
	 * @return the tipoActividad
	 */
	public java.lang.Integer getTipoActividad() {
		return tipoActividad;
	}

	/**
	 * Establece tipo actividad.
	 *
	 * @param tipoActividad the tipoActividad to set
	 */
	public void setTipoActividad(java.lang.Integer tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	/**
	 * Obtiene tipo negocio.
	 *
	 * @return the tipoNegocio
	 */
	public java.lang.Integer getTipoNegocio() {
		return tipoNegocio;
	}

	/**
	 * Establece tipo negocio.
	 *
	 * @param tipoNegocio the tipoNegocio to set
	 */
	public void setTipoNegocio(java.lang.Integer tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}

	/**
	 * Obtiene experiencia rubro.
	 *
	 * @return the experienciaRubro
	 */
	public java.lang.Double getExperienciaRubro() {
		return experienciaRubro;
	}

	/**
	 * Establece experiencia rubro.
	 *
	 * @param experienciaRubro the experienciaRubro to set
	 */
	public void setExperienciaRubro(java.lang.Double experienciaRubro) {
		this.experienciaRubro = experienciaRubro;
	}

	/**
	 * Obtiene experiencia negocio.
	 *
	 * @return the experienciaNegocio
	 */
	public java.lang.Double getExperienciaNegocio() {
		return experienciaNegocio;
	}

	/**
	 * Establece experiencia negocio.
	 *
	 * @param experienciaNegocio the experienciaNegocio to set
	 */
	public void setExperienciaNegocio(java.lang.Double experienciaNegocio) {
		this.experienciaNegocio = experienciaNegocio;
	}

	/**
	 * Obtiene ventas.
	 *
	 * @return the ventas
	 */
	public java.lang.Double getVentas() {
		return ventas;
	}

	/**
	 * Establece ventas.
	 *
	 * @param ventas the ventas to set
	 */
	public void setVentas(java.lang.Double ventas) {
		this.ventas = ventas;
	}

	/**
	 * Obtiene ganacia neta.
	 *
	 * @return the ganaciaNeta
	 */
	public java.lang.Double getGanaciaNeta() {
		return ganaciaNeta;
	}

	/**
	 * Establece ganacia neta.
	 *
	 * @param ganaciaNeta the ganaciaNeta to set
	 */
	public void setGanaciaNeta(java.lang.Double ganaciaNeta) {
		this.ganaciaNeta = ganaciaNeta;
	}

	/**
	 * Obtiene ingresos otros.
	 *
	 * @return the ingresosOtros
	 */
	public java.lang.Double getIngresosOtros() {
		return ingresosOtros;
	}

	/**
	 * Establece ingresos otros.
	 *
	 * @param ingresosOtros the ingresosOtros to set
	 */
	public void setIngresosOtros(java.lang.Double ingresosOtros) {
		this.ingresosOtros = ingresosOtros;
	}

	/**
	 * Obtiene ganacia actividad secundaria.
	 *
	 * @return the ganaciaActividadSecundaria
	 */
	public java.lang.Double getGanaciaActividadSecundaria() {
		return ganaciaActividadSecundaria;
	}

	/**
	 * Establece ganacia actividad secundaria.
	 *
	 * @param ganaciaActividadSecundaria the ganaciaActividadSecundaria to set
	 */
	public void setGanaciaActividadSecundaria(
			java.lang.Double ganaciaActividadSecundaria) {
		this.ganaciaActividadSecundaria = ganaciaActividadSecundaria;
	}

	/**
	 * Obtiene gasto familiar.
	 *
	 * @return the gastoFamiliar
	 */
	public java.lang.Double getGastoFamiliar() {
		return gastoFamiliar;
	}

	/**
	 * Establece gasto familiar.
	 *
	 * @param gastoFamiliar the gastoFamiliar to set
	 */
	public void setGastoFamiliar(java.lang.Double gastoFamiliar) {
		this.gastoFamiliar = gastoFamiliar;
	}

	/**
	 * Obtiene inventario.
	 *
	 * @return the inventario
	 */
	public java.lang.Double getInventario() {
		return inventario;
	}

	/**
	 * Establece inventario.
	 *
	 * @param inventario the inventario to set
	 */
	public void setInventario(java.lang.Double inventario) {
		this.inventario = inventario;
	}

	/**
	 * Obtiene mobiliario equipo.
	 *
	 * @return the mobiliarioEquipo
	 */
	public java.lang.Double getMobiliarioEquipo() {
		return mobiliarioEquipo;
	}

	/**
	 * Establece mobiliario equipo.
	 *
	 * @param mobiliarioEquipo the mobiliarioEquipo to set
	 */
	public void setMobiliarioEquipo(java.lang.Double mobiliarioEquipo) {
		this.mobiliarioEquipo = mobiliarioEquipo;
	}

	/**
	 * Obtiene superavit.
	 *
	 * @return the superavit
	 */
	public java.lang.Double getSuperavit() {
		return superavit;
	}

	/**
	 * Establece superavit.
	 *
	 * @param superavit the superavit to set
	 */
	public void setSuperavit(java.lang.Double superavit) {
		this.superavit = superavit;
	}

	/**
	 * Obtiene date insercion.
	 *
	 * @return the dateInsercion
	 */
	public java.util.Date getDateInsercion() {
		return dateInsercion;
	}

	/**
	 * Establece date insercion.
	 *
	 * @param dateInsercion the dateInsercion to set
	 */
	public void setDateInsercion(java.util.Date dateInsercion) {
		this.dateInsercion = dateInsercion;
	}

	/**
	 * Obtiene dias vende tianguis.
	 *
	 * @return the diasVendeTianguis
	 */
	public java.lang.String getDiasVendeTianguis() {
		return diasVendeTianguis;
	}

	/**
	 * Establece dias vende tianguis.
	 *
	 * @param diasVendeTianguis the diasVendeTianguis to set
	 */
	public void setDiasVendeTianguis(java.lang.String diasVendeTianguis) {
		this.diasVendeTianguis = diasVendeTianguis;
	}

}
