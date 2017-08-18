/**
 * Tensegrity - Febrero 2011
 */
package utilitario.mensajes.originacion.cliente;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class RegistrarTelefonoPeticion.
 *
 * @author out_mreyes@independencia.com.mx
 * Encapsula los datos de la peticion de registrar el telefono de un cliente
 */
public final class RegistrarTelefonoPeticion extends ObjetoValor {
	//UID para la serialización
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	//Atributos privados  - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/** The usuario. */
	private java.lang.String	usuario;

	/** The integrante. */
	private java.lang.String	integrante;

	/** The tipo telefono. */
	private java.lang.String	tipoTelefono;

	/** The lada. */
	private java.lang.String 	lada;

	/** The telefono. */
	private java.lang.String	telefono;

	/** The relacion. */
	private java.lang.String	relacion;

	/** The nombre. */
	private java.lang.String	nombre;

	/** The apellido paterno. */
	private java.lang.String	apellidoPaterno;

	/** The apellido materno. */
	private java.lang.String	apellidoMaterno;

	//Constructor - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * Instancia una nueva registrar telefono peticion.
	 */
	public RegistrarTelefonoPeticion() {

		}

	//Métodos - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
	/**
	 * Obtiene integrante.
	 *
	 * @return the integrante
	 */
	public java.lang.String getIntegrante() {
		return integrante;
	}

	/**
	 * Establece integrante.
	 *
	 * @param integrante the integrante to set
	 */
	public void setIntegrante(java.lang.String integrante) {
		this.integrante = integrante;
	}

	/**
	 * Obtiene tipo telefono.
	 *
	 * @return the tipo
	 */
	public java.lang.String getTipoTelefono() {
		return tipoTelefono;
	}

	/**
	 * Establece tipo telefono.
	 *
	 * @param tipoTelefono a tipo telefono
	 */
	public void setTipoTelefono(java.lang.String tipoTelefono) {
		this.tipoTelefono = tipoTelefono;
	}

	/**
	 * Obtiene lada.
	 *
	 * @return the lada
	 */
	public java.lang.String getLada() {
		return lada;
	}

	/**
	 * Establece lada.
	 *
	 * @param lada the lada to set
	 */
	public void setLada(java.lang.String lada) {
		this.lada = lada;
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
	 * Obtiene relacion.
	 *
	 * @return the relacion
	 */
	public java.lang.String getRelacion() {
		return relacion;
	}

	/**
	 * Establece relacion.
	 *
	 * @param relacion the relacion to set
	 */
	public void setRelacion(java.lang.String relacion) {
		this.relacion = relacion;
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
	 * Obtiene usuario.
	 *
	 * @return the usuario
	 */
	public java.lang.String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario the usuario to set
	 */
	public void setUsuario(java.lang.String usuario) {
		this.usuario = usuario;
	}

}
