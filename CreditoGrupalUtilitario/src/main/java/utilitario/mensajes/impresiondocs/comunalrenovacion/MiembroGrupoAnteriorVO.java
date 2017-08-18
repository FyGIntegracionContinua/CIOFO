
package utilitario.mensajes.impresiondocs.comunalrenovacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes
 *
 */
public 	class 	MiembroGrupoAnteriorVO extends	ObjetoValor {

	/**
	 * MiembroGrupoAnteriorVO
	 */
	public MiembroGrupoAnteriorVO() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 8222775537189979267L;
	/**
	 * noIndice java.lang.String
	 */
	private java.lang.String		noIndice;			// consecutivo para los integrantes
	/**
	 * nombre java.lang.String
	 */
	private java.lang.String		nombre;				// nombre por integrante
	/**
	 * montochequeovale java.lang.String
	 */
	private java.lang.String		montochequeovale;	// capital del credito anterior - individual
	/**
	 * montovalecredito java.lang.String
	 */
	private java.lang.String		montovalecredito;	// 0.0 (siempre cero)
	/**
	 * capintereses java.lang.String
	 */
	private java.lang.String		capintereses;		// interes del credito mas capital
	/**
	 * fecha java.lang.String
	 */
	private java.lang.String		fecha;				// fecha desembolso del credeito anterior
	/**
	 * cantidad java.lang.String
	 */
	private java.lang.String		cantidad;			// monto capital credito anterio por grupo
	/**
	 * cantidadletra java.lang.String
	 */
	private java.lang.String		cantidadletra;		// el monto anterior pero en letra
	/**
	 * ldanterior java.lang.String
	 */
	private java.lang.String		ldanterior;			// el LD del contrato anterior
	/**
	 * pagares java.lang.String
	 */
	private java.lang.String		pagares;			// total de integrantes
	/**
	 * tasa java.lang.String
	 */
	private java.lang.String		tasa;				// tasa del contrato anterior ( CA )
	/**
	 * semanas java.lang.String
	 */
	private java.lang.String		semanas;			// numero de pagos CA
	/**
	 * ciclo java.lang.String
	 */
	private java.lang.String		ciclo;				// ciclo del grupo en el contrato anterior
	/**
	 * direccion java.lang.String
	 */
	private java.lang.String		direccion;			// direccion del grupo
	/**
	 * noamort java.lang.String
	 */
	private java.lang.String		noamort;			// va en 0 ( cero )
	/**
	 * sdocapital java.lang.String
	 */
	private java.lang.String		sdocapital;			// montochequeovale
	/**
	 * sdointeres java.lang.String
	 */
	private java.lang.String		sdointeres;			// capintereses  - montochequeovale
	/**
	 * sdototal java.lang.String
	 */
	private java.lang.String		sdototal;			// capintereses
	/**
	 * capminteres java.lang.String
	 */
	private java.lang.String		capminteres;		// capintereses
	/**
	 * chequeovale java.lang.String
	 */
	private java.lang.String		chequeovale;		// clave t24 de la persona
	/**
	 * valecredito java.lang.String
	 */
	private java.lang.String		valecredito;		// - ( un guión )

	/**
	 * @return the noIndice
	 */
	public java.lang.String getNoIndice() {
		return noIndice;
	}
	/**
	 * @param noIndice the noIndice to set
	 */
	public void setNoIndice(java.lang.String noIndice) {
		this.noIndice = noIndice;
	}
	/**
	 * @return the nombre
	 */
	public java.lang.String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the montochequeovale
	 */
	public java.lang.String getMontochequeovale() {
		return montochequeovale;
	}
	/**
	 * @param montochequeovale the montochequeovale to set
	 */
	public void setMontochequeovale(java.lang.String montochequeovale) {
		this.montochequeovale = montochequeovale;
	}
	/**
	 * @return the montovalecredito
	 */
	public java.lang.String getMontovalecredito() {
		return montovalecredito;
	}
	/**
	 * @param montovalecredito the montovalecredito to set
	 */
	public void setMontovalecredito(java.lang.String montovalecredito) {
		this.montovalecredito = montovalecredito;
	}
	/**
	 * @return the capintereses
	 */
	public java.lang.String getCapintereses() {
		return capintereses;
	}
	/**
	 * @param capintereses the capintereses to set
	 */
	public void setCapintereses(java.lang.String capintereses) {
		this.capintereses = capintereses;
	}
	/**
	 * @return the fecha
	 */
	public java.lang.String getFecha() {
		return fecha;
	}
	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(java.lang.String fecha) {
		this.fecha = fecha;
	}
	/**
	 * @return the cantidad
	 */
	public java.lang.String getCantidad() {
		return cantidad;
	}
	/**
	 * @param cantidad the cantidad to set
	 */
	public void setCantidad(java.lang.String cantidad) {
		this.cantidad = cantidad;
	}
	/**
	 * @return the cantidadletra
	 */
	public java.lang.String getCantidadletra() {
		return cantidadletra;
	}
	/**
	 * @param cantidadletra the cantidadletra to set
	 */
	public void setCantidadletra(java.lang.String cantidadletra) {
		this.cantidadletra = cantidadletra;
	}
	/**
	 * @return the ldanterior
	 */
	public java.lang.String getLdanterior() {
		return ldanterior;
	}
	/**
	 * @param ldanterior the ldanterior to set
	 */
	public void setLdanterior(java.lang.String ldanterior) {
		this.ldanterior = ldanterior;
	}
	/**
	 * @return the pagares
	 */
	public java.lang.String getPagares() {
		return pagares;
	}
	/**
	 * @param pagares the pagares to set
	 */
	public void setPagares(java.lang.String pagares) {
		this.pagares = pagares;
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
	 * @return the semanas
	 */
	public java.lang.String getSemanas() {
		return semanas;
	}
	/**
	 * @param semanas the semanas to set
	 */
	public void setSemanas(java.lang.String semanas) {
		this.semanas = semanas;
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
	 * @return the direccion
	 */
	public java.lang.String getDireccion() {
		return direccion;
	}
	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(java.lang.String direccion) {
		this.direccion = direccion;
	}
	/**
	 * @return the noamort
	 */
	public java.lang.String getNoamort() {
		return noamort;
	}
	/**
	 * @param noamort the noamort to set
	 */
	public void setNoamort(java.lang.String noamort) {
		this.noamort = noamort;
	}
	/**
	 * @return the sdocapital
	 */
	public java.lang.String getSdocapital() {
		return sdocapital;
	}
	/**
	 * @param sdocapital the sdocapital to set
	 */
	public void setSdocapital(java.lang.String sdocapital) {
		this.sdocapital = sdocapital;
	}
	/**
	 * @return the sdointeres
	 */
	public java.lang.String getSdointeres() {
		return sdointeres;
	}
	/**
	 * @param sdointeres the sdointeres to set
	 */
	public void setSdointeres(java.lang.String sdointeres) {
		this.sdointeres = sdointeres;
	}
	/**
	 * @return the sdototal
	 */
	public java.lang.String getSdototal() {
		return sdototal;
	}
	/**
	 * @param sdototal the sdototal to set
	 */
	public void setSdototal(java.lang.String sdototal) {
		this.sdototal = sdototal;
	}
	/**
	 * @return the capminteres
	 */
	public java.lang.String getCapminteres() {
		return capminteres;
	}
	/**
	 * @param capminteres the capminteres to set
	 */
	public void setCapminteres(java.lang.String capminteres) {
		this.capminteres = capminteres;
	}
	/**
	 * @return the chequeovale
	 */
	public java.lang.String getChequeovale() {
		return chequeovale;
	}
	/**
	 * @param chequeovale the chequeovale to set
	 */
	public void setChequeovale(java.lang.String chequeovale) {
		this.chequeovale = chequeovale;
	}
	/**
	 * @return the valecredito
	 */
	public java.lang.String getValecredito() {
		return valecredito;
	}
	/**
	 * @param valecredito the valecredito to set
	 */
	public void setValecredito(java.lang.String valecredito) {
		this.valecredito = valecredito;
	}

}
