/**
 *
 */
package utilitario.mensajes.persona;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DetalleSocioeconomicoOV.
 *
 * @author out_mreyes@independencia.com.mx
 */
public 	class	DetalleSocioeconomicoOV extends ObjetoValor {

	/** UID de serializacion. */
	private static final long serialVersionUID = -8940212278404023023L;

	// Atributos  -----------------------------------------------------------------------
	/** The numero persona. */
	private java.lang.String			numeroPersona;

	/** The monto semana pago. */
	private java.lang.Double			montoSemanaPago;

	/** The inicia negocio. */
	private java.lang.Boolean			iniciaNegocio;

	/** The nombre negocio. */
	private java.lang.String			nombreNegocio;

	/** The tipo actividad. */
	private java.lang.String			tipoActividad;

	/** The tipo negocio. */
	private java.lang.String			tipoNegocio;

	/** The giro negocio. */
	private java.lang.String			giroNegocio;

	/** The numero empleados. */
	private java.lang.Integer			numeroEmpleados;

	/** The experiencia rubro. */
	private java.lang.Integer			experienciaRubro;

	/** The experiencia negocio. */
	private java.lang.Integer			experienciaNegocio;

	/** The ingresos. */
	private java.lang.Double			ingresos;

	/** The ganancia neta. */
	private java.lang.Double			gananciaNeta;

	/** The otros ingresos. */
	private java.lang.Double			otrosIngresos;

	/** The ganancia act sec. */
	private java.lang.Double			gananciaActSec;

	/** The gastos familiares. */
	private java.lang.Double			gastosFamiliares;

	/** The monto superavit. */
	private java.lang.Double			montoSuperavit;

	/** The monto inventario. */
	private java.lang.Double			montoInventario;

	/** The monto mobiliario equipo. */
	private java.lang.Double			montoMobiliarioEquipo;

	/** The domicilio negocio. */
	private DomicilioOV					domicilioNegocio;


	// Constructor  ---------------------------------------------------------------------
	/**
	 * Instancia una nueva detalle socioeconomico ov.
	 */
	public DetalleSocioeconomicoOV() {

		}




	/**
	 * Obtiene numero persona.
	 *
	 * @return the numeroPersona
	 */
	public java.lang.String getNumeroPersona() {
		return numeroPersona;
	}




	/**
	 * Establece numero persona.
	 *
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(java.lang.String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}




	/**
	 * Obtiene inicia negocio.
	 *
	 * @return the iniciaNegocio
	 */
	public java.lang.Boolean getIniciaNegocio() {
		return iniciaNegocio;
	}


	/**
	 * Establece inicia negocio.
	 *
	 * @param iniciaNegocio the iniciaNegocio to set
	 */
	public void setIniciaNegocio(java.lang.Boolean iniciaNegocio) {
		this.iniciaNegocio = iniciaNegocio;
	}


	/**
	 * Obtiene nombre negocio.
	 *
	 * @return the nombreNegocio
	 */
	public java.lang.String getNombreNegocio() {
		return nombreNegocio;
	}


	/**
	 * Establece nombre negocio.
	 *
	 * @param nombreNegocio the nombreNegocio to set
	 */
	public void setNombreNegocio(java.lang.String nombreNegocio) {
		this.nombreNegocio = nombreNegocio;
	}


	/**
	 * Obtiene tipo actividad.
	 *
	 * @return the tipoActividad
	 */
	public java.lang.String getTipoActividad() {
		return tipoActividad;
	}


	/**
	 * Establece tipo actividad.
	 *
	 * @param tipoActividad the tipoActividad to set
	 */
	public void setTipoActividad(java.lang.String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}


	/**
	 * Obtiene tipo negocio.
	 *
	 * @return the tipoNegocio
	 */
	public java.lang.String getTipoNegocio() {
		return tipoNegocio;
	}


	/**
	 * Establece tipo negocio.
	 *
	 * @param tipoNegocio the tipoNegocio to set
	 */
	public void setTipoNegocio(java.lang.String tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}


	/**
	 * Obtiene giro negocio.
	 *
	 * @return the giroNegocio
	 */
	public java.lang.String getGiroNegocio() {
		return giroNegocio;
	}


	/**
	 * Establece giro negocio.
	 *
	 * @param giroNegocio the giroNegocio to set
	 */
	public void setGiroNegocio(java.lang.String giroNegocio) {
		this.giroNegocio = giroNegocio;
	}


	/**
	 * Obtiene numero empleados.
	 *
	 * @return the numeroEmpleados
	 */
	public java.lang.Integer getNumeroEmpleados() {
		return numeroEmpleados;
	}


	/**
	 * Establece numero empleados.
	 *
	 * @param numeroEmpleados the numeroEmpleados to set
	 */
	public void setNumeroEmpleados(java.lang.Integer numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}


	/**
	 * Obtiene experiencia rubro.
	 *
	 * @return the experienciaRubro
	 */
	public java.lang.Integer getExperienciaRubro() {
		return experienciaRubro;
	}


	/**
	 * Establece experiencia rubro.
	 *
	 * @param experienciaRubro the experienciaRubro to set
	 */
	public void setExperienciaRubro(java.lang.Integer experienciaRubro) {
		this.experienciaRubro = experienciaRubro;
	}


	/**
	 * Obtiene experiencia negocio.
	 *
	 * @return the experienciaNegocio
	 */
	public java.lang.Integer getExperienciaNegocio() {
		return experienciaNegocio;
	}


	/**
	 * Establece experiencia negocio.
	 *
	 * @param experienciaNegocio the experienciaNegocio to set
	 */
	public void setExperienciaNegocio(java.lang.Integer experienciaNegocio) {
		this.experienciaNegocio = experienciaNegocio;
	}


	/**
	 * Obtiene domicilio negocio.
	 *
	 * @return the domicilioNegocio
	 */
	public DomicilioOV getDomicilioNegocio() {
		return domicilioNegocio;
	}


	/**
	 * Establece domicilio negocio.
	 *
	 * @param domicilioNegocio the domicilioNegocio to set
	 */
	public void setDomicilioNegocio(DomicilioOV domicilioNegocio) {
		this.domicilioNegocio = domicilioNegocio;
	}


	/**
	 * Obtiene ingresos.
	 *
	 * @return the ingresos
	 */
	public java.lang.Double getIngresos() {
		return ingresos;
	}


	/**
	 * Establece ingresos.
	 *
	 * @param ingresos the ingresos to set
	 */
	public void setIngresos(java.lang.Double ingresos) {
		this.ingresos = ingresos;
	}


	/**
	 * Obtiene ganancia neta.
	 *
	 * @return the gananciaNeta
	 */
	public java.lang.Double getGananciaNeta() {
		return gananciaNeta;
	}


	/**
	 * Establece ganancia neta.
	 *
	 * @param gananciaNeta the gananciaNeta to set
	 */
	public void setGananciaNeta(java.lang.Double gananciaNeta) {
		this.gananciaNeta = gananciaNeta;
	}


	/**
	 * Obtiene otros ingresos.
	 *
	 * @return the otrosIngresos
	 */
	public java.lang.Double getOtrosIngresos() {
		return otrosIngresos;
	}


	/**
	 * Establece otros ingresos.
	 *
	 * @param otrosIngresos the otrosIngresos to set
	 */
	public void setOtrosIngresos(java.lang.Double otrosIngresos) {
		this.otrosIngresos = otrosIngresos;
	}




	/**
	 * Obtiene ganancia act sec.
	 *
	 * @return the gananciaActSec
	 */
	public java.lang.Double getGananciaActSec() {
		return gananciaActSec;
	}


	/**
	 * Establece ganancia act sec.
	 *
	 * @param gananciaActSec the gananciaActSec to set
	 */
	public void setGananciaActSec(java.lang.Double gananciaActSec) {
		this.gananciaActSec = gananciaActSec;
	}


	/**
	 * Obtiene gastos familiares.
	 *
	 * @return the gastosFamiliares
	 */
	public java.lang.Double getGastosFamiliares() {
		return gastosFamiliares;
	}


	/**
	 * Establece gastos familiares.
	 *
	 * @param gastosFamiliares the gastosFamiliares to set
	 */
	public void setGastosFamiliares(java.lang.Double gastosFamiliares) {
		this.gastosFamiliares = gastosFamiliares;
	}


	/**
	 * Obtiene monto superavit.
	 *
	 * @return the montoSuperavit
	 */
	public java.lang.Double getMontoSuperavit() {
		return montoSuperavit;
	}


	/**
	 * Establece monto superavit.
	 *
	 * @param montoSuperavit the montoSuperavit to set
	 */
	public void setMontoSuperavit(java.lang.Double montoSuperavit) {
		this.montoSuperavit = montoSuperavit;
	}


	/**
	 * Obtiene monto inventario.
	 *
	 * @return the montoInventario
	 */
	public java.lang.Double getMontoInventario() {
		return montoInventario;
	}


	/**
	 * Establece monto inventario.
	 *
	 * @param montoInventario the montoInventario to set
	 */
	public void setMontoInventario(java.lang.Double montoInventario) {
		this.montoInventario = montoInventario;
	}


	/**
	 * Obtiene monto mobiliario equipo.
	 *
	 * @return the montoMobiliarioEquipo
	 */
	public java.lang.Double getMontoMobiliarioEquipo() {
		return montoMobiliarioEquipo;
	}


	/**
	 * Establece monto mobiliario equipo.
	 *
	 * @param montoMobiliarioEquipo the montoMobiliarioEquipo to set
	 */
	public void setMontoMobiliarioEquipo(java.lang.Double montoMobiliarioEquipo) {
		this.montoMobiliarioEquipo = montoMobiliarioEquipo;
	}



	/**
	 * Obtiene monto semana pago.
	 *
	 * @return the montoSemanaPago
	 */
	public java.lang.Double getMontoSemanaPago() {
		return montoSemanaPago;
	}


	/**
	 * Establece monto semana pago.
	 *
	 * @param montoSemanaPago the montoSemanaPago to set
	 */
	public void setMontoSemanaPago(java.lang.Double montoSemanaPago) {
		this.montoSemanaPago = montoSemanaPago;
	}

	// M&eacute;todos de acceso  ---------------------------------------------------------------
}
