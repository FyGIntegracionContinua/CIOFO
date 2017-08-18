package utilitario.mensajes.solicitudes;

import utilitario.mensajes.burocredito.ValidaBuroDTO;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudBuroClienteOV.
 *
 * @author rguadarramac
 */
public class SolicitudBuroClienteOV extends ObjetoValor {


	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1873353512956215238L;

	/** The solicitud. */
	private String solicitud;

	/** The persona. */
	private String persona;

	/** The folio consulta buro. */
	private String folioConsultaBuro;

	/** The nombre. */
	private String nombre;

	/** The apellido pat. */
	private String apellidoPat;

	/** The apellido mat. */
	private String apellidoMat;

	/** The nombre completo. */
	private String nombreCompleto;

	/** The fecha nacimiento. */
	private String fechaNacimiento;

	/** The edad. */
	private Integer edad;

	/** The descarte. */
	private String descarte;

	/** The desc descarte. */
	private String descDescarte;

	/** The ciclo. */
	private Integer ciclo;

	/** The fecha modificacion. */
	private String fechaModificacion;

	/** The fecha descartado. */
	private String descartado;

	/** The fecha causaRechazo. */
	private String causaRechazo;

	/** The cuentas. */
	private ValidaBuroDTO cuentas;

	/** The claveObservacion. */
	private String claveObservacion;

	/** The causaRechazoObs. */
	private String causaRechazoObs;

	/** The rol. */
	private String rol;

	/** The motivoCancelacion. */
	private String motivoCancelacion;

	/** The contratoAnterior. */
	private String contratoAnterior;

	/** The empresaOrigen  */
    private String empresaOrigen;

	 /**estado de si se elimina de la lista O = obligatorio, S = sugerido*/
    private String estatusBC;

    /** The montoCicloAnterior. */
    private double montoCicloAnterior;

    /** The montoSolicitadoAproElec. */
    private double montoSolicitadoAproElec;

    /**The urlBuroHistorico. */
	private String urlBuroHistorico;

	/**The urlIconoPdf */
	private String urlIconoPdf;

	/**The personaAutoriza. */
	private String personaAutoriza;
	/**
	 * Instancia una nueva solicitud buro cliente ov.
	 */
	public SolicitudBuroClienteOV() {
		descartado = " ";
		causaRechazo = " ";
	}

	/**
	 * @return the causaRechazoObs
	 */
	public String getCausaRechazoObs() {
		return causaRechazoObs;
	}



	/**
	 * @param causaRechazoObs the causaRechazoObs to set
	 */
	public void setCausaRechazoObs(String causaRechazoObs) {
		this.causaRechazoObs = causaRechazoObs;
	}



	/**
	 * @return the claveObservacion
	 */
	public String getClaveObservacion() {
		return claveObservacion;
	}



	/**
	 * @param claveObservacion the claveObservacion to set
	 */
	public void setClaveObservacion(String claveObservacion) {
		this.claveObservacion = claveObservacion;
	}



	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * @return the folioConsultaBuro
	 */
	public String getFolioConsultaBuro() {
		return folioConsultaBuro;
	}

	/**
	 * @param folioConsultaBuro the folioConsultaBuro to set
	 */
	public void setFolioConsultaBuro(String folioConsultaBuro) {
		this.folioConsultaBuro = folioConsultaBuro;
	}

	/**
	 * @return the cuentas
	 */
	public ValidaBuroDTO getCuentas() {
		return cuentas;
	}

	/**
	 * @param cuentas the cuentas to set
	 */
	public void setCuentas(ValidaBuroDTO cuentas) {
		this.cuentas = cuentas;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellidoPat
	 */
	public String getApellidoPat() {
		return apellidoPat;
	}

	/**
	 * @param apellidoPat the apellidoPat to set
	 */
	public void setApellidoPat(String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	/**
	 * @return the apellidoMat
	 */
	public String getApellidoMat() {
		return apellidoMat;
	}

	/**
	 * @param apellidoMat the apellidoMat to set
	 */
	public void setApellidoMat(String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the edad
	 */
	public Integer getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	/**
	 * @return the descarte
	 */
	public String getDescarte() {
		return descarte;
	}

	/**
	 * @param descarte the descarte to set
	 */
	public void setDescarte(String descarte) {
		this.descarte = descarte;
	}

	/**
	 * @return the descDescarte
	 */
	public String getDescDescarte() {
		return descDescarte;
	}

	/**
	 * @param descDescarte the descDescarte to set
	 */
	public void setDescDescarte(String descDescarte) {
		this.descDescarte = descDescarte;
	}

	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the fechaModificacion
	 */
	public String getFechaModificacion() {
		return fechaModificacion;
	}

	/**
	 * @param fechaModificacion the fechaModificacion to set
	 */
	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	/**
	 * @return the descartado
	 */
	public String getDescartado() {
		return descartado;
	}

	/**
	 * @param descartado the descartado to set
	 */
	public void setDescartado(String descartado) {
		this.descartado = descartado;
	}

	/**
	 * @return the causaRechazo
	 */
	public String getCausaRechazo() {
		return causaRechazo;
	}

	/**
	 * @param causaRechazo the causaRechazo to set
	 */
	public void setCausaRechazo(String causaRechazo) {
		this.causaRechazo = causaRechazo;
	}

	/**
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	/**
	 * @return the contratoAnterior
	 */
	public String getContratoAnterior() {
		return contratoAnterior;
	}

	/**
	 * @param contratoAnterior the contratoAnterior to set
	 */
	public void setContratoAnterior(String contratoAnterior) {
		this.contratoAnterior = contratoAnterior;
	}

	/**
	 * @return the estatusBC
	 */
	public String getEstatusBC() {
		return estatusBC;
	}

	/**
	 * @param estatusBC the estatusBC to set
	 */
	public void setEstatusBC(String estatusBC) {
		this.estatusBC = estatusBC;
	}

	/**
	 * @return the empresaOrigen
	 */
	public String getEmpresaOrigen() {
		return empresaOrigen;
	}

	/**
	 * @param empresaOrigen the empresaOrigen to set
	 */
	public void setEmpresaOrigen(String empresaOrigen) {
		this.empresaOrigen = empresaOrigen;
	}

	/**
	 * @return the montoCicloAnterior
	 */
	public double getMontoCicloAnterior() {
		return montoCicloAnterior;
	}

	/**
	 * @param montoCicloAnterior the montoCicloAnterior to set
	 */
	public void setMontoCicloAnterior(double montoCicloAnterior) {
		this.montoCicloAnterior = montoCicloAnterior;
	}

	/**
	 * @return the montoSolicitadoAproElec
	 */
	public double getMontoSolicitadoAproElec() {
		return montoSolicitadoAproElec;
	}

	/**
	 * @param montoSolicitadoAproElec the montoSolicitadoAproElec to set
	 */
	public void setMontoSolicitadoAproElec(double montoSolicitadoAproElec) {
		this.montoSolicitadoAproElec = montoSolicitadoAproElec;
	}

	/**
	 * @return the urlBuroHistorico
	 */
	public String getUrlBuroHistorico() {
		return urlBuroHistorico;
	}

	/**
	 * @param urlBuroHistorico the urlBuroHistorico to set
	 */
	public void setUrlBuroHistorico(String urlBuroHistorico) {
		this.urlBuroHistorico = urlBuroHistorico;
	}

	/**
	 * @return the urlIconoPdf
	 */
	public String getUrlIconoPdf() {
		return urlIconoPdf;
	}

	/**
	 * @param urlIconoPdf the urlIconoPdf to set
	 */
	public void setUrlIconoPdf(String urlIconoPdf) {
		this.urlIconoPdf = urlIconoPdf;
	}

	/**
	 * @return the personaAutoriza
	 */
	public String getPersonaAutoriza() {
		return personaAutoriza;
	}

	/**
	 * @param personaAutoriza the personaAutoriza to set
	 */
	public void setPersonaAutoriza(String personaAutoriza) {
		this.personaAutoriza = personaAutoriza;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[solicitud: " + solicitud + "  Persona: " + persona
				+ "  nombreCompleto: " + nombreCompleto + "  edad: " + edad
				+ " estatusBC: " + estatusBC +"] \n";
	}

}
