package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSISEFINPeticion.
 *
 * @author out_mreyes
 */
public 	class 	ConsultaSISEFINPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consulta sisefin peticion.
	 */
	public ConsultaSISEFINPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6796116871913105251L;

	/** The sucursal. */
	private java.lang.Integer	sucursal;

	/** The codigo. */
	private java.lang.String	codigo;

	/** The apellido paterno. */
	private java.lang.String	apellidoPaterno;

	/** The apellido materno. */
	private java.lang.String	apellidoMaterno;

	/** The nombre. */
	private java.lang.String	nombre;

	/** The fecha inicio. */
	private java.util.Date		fechaInicio;

	/** The fecha fin. */
	private java.util.Date		fechaFin;

	/** The grupo. */
	private java.lang.String	grupo;

	/** The contrato ld. */
	private java.lang.String	contratoLD;

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene codigo.
	 *
	 * @return the codigo
	 */
	public java.lang.String getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo the codigo to set
	 */
	public void setCodigo(java.lang.String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene apellido paterno.
	 *
	 * @return the apellidoPaterno
	 */
	public java.lang.String getApellidoPaterno() {
		return apellidoPaterno;
	}

	/**
	 * Establece apellido paterno.
	 *
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(java.lang.String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	/**
	 * Obtiene apellido materno.
	 *
	 * @return the apellidoMaterno
	 */
	public java.lang.String getApellidoMaterno() {
		return apellidoMaterno;
	}

	/**
	 * Establece apellido materno.
	 *
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(java.lang.String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public java.lang.String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public java.util.Date getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(java.util.Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return the fechaFin
	 */
	public java.util.Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(java.util.Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public java.lang.String getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(java.lang.String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene contrato ld.
	 *
	 * @return the contratoLD
	 */
	public java.lang.String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(java.lang.String contratoLD) {
		this.contratoLD = contratoLD;
	}

}
