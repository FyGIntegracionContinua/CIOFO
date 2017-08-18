package utilitario.mensajes.operacion.administracion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes
 *
 */
public 	class 	SucursalCambiosPeticion extends ObjetoValor {
	//Atributos privados  --------------------------------------------------------------------


	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 6577467929688555390L;

	/**
	 * SucursalCambiosPeticion
	 */
	public SucursalCambiosPeticion() {
		super();
	}

	/**
	 * nombreApoderado java.lang.String
	 */
	private java.lang.String	nombreApoderado;
	/**
	 * nombreGerente java.lang.String
	 */
	private java.lang.String	nombreGerente;
	/**
	 * fechaEscritura java.lang.String
	 */
	private java.lang.String 	fechaEscritura;
	/**
	 * numeroEscritura java.lang.String
	 */
	private java.lang.String	numeroEscritura;
	/**
	 * sucursal java.lang.Integer
	 */
	private java.lang.Integer	sucursal;
	/**
	 * calle java.lang.String
	 */
	private java.lang.String	calle;
	/**
	 * colonia java.lang.String
	 */
	private java.lang.String	colonia;
	/**
	 * cp java.lang.Integer
	 */
	private java.lang.Integer	cp;
	/**
	 * ciudad java.lang.String
	 */
	private java.lang.String	ciudad;

	//Getters y Setter  ----------------------------------------------------------------------
	/**
	 * @return the nombreApoderado
	 */
	public java.lang.String getNombreApoderado() {
		return nombreApoderado;
	}

	/**
	 * @param nombreApoderado the nombreApoderado to set
	 */
	public void setNombreApoderado(java.lang.String nombreApoderado) {
		this.nombreApoderado = nombreApoderado;
	}

	/**
	 * @return the nombreGerente
	 */
	public java.lang.String getNombreGerente() {
		return nombreGerente;
	}

	/**
	 * @param nombreGerente the nombreGerente to set
	 */
	public void setNombreGerente(java.lang.String nombreGerente) {
		this.nombreGerente = nombreGerente;
	}

	/**
	 * @return the fechaEscritura
	 */
	public java.lang.String getFechaEscritura() {
		return fechaEscritura;
	}

	/**
	 * @param fechaEscritura the fechaEscritura to set
	 */
	public void setFechaEscritura(java.lang.String fechaEscritura) {
		this.fechaEscritura = fechaEscritura;
	}

	/**
	 * @return the numeroEscritura
	 */
	public java.lang.String getNumeroEscritura() {
		return numeroEscritura;
	}

	/**
	 * @param numeroEscritura the numeroEscritura to set
	 */
	public void setNumeroEscritura(java.lang.String numeroEscritura) {
		this.numeroEscritura = numeroEscritura;
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
	 * @return the calle
	 */
	public java.lang.String getCalle() {
		return calle;
	}

	/**
	 * @param calle the calle to set
	 */
	public void setCalle(java.lang.String calle) {
		this.calle = calle;
	}

	/**
	 * @return the colonia
	 */
	public java.lang.String getColonia() {
		return colonia;
	}

	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(java.lang.String colonia) {
		this.colonia = colonia;
	}

	/**
	 * @return the cp
	 */
	public java.lang.Integer getCp() {
		return cp;
	}

	/**
	 * @param cp the cp to set
	 */
	public void setCp(java.lang.Integer cp) {
		this.cp = cp;
	}

	/**
	 * @return the ciudad
	 */
	public java.lang.String getCiudad() {
		return ciudad;
	}

	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(java.lang.String ciudad) {
		this.ciudad = ciudad;
	}

	}
