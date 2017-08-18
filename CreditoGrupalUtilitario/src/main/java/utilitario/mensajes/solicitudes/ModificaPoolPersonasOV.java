package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ModificaPoolPersonasOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class ModificaPoolPersonasOV extends ObjetoValor {

	/**
	 * Instancia una nueva modifica pool personas ov.
	 */
	public ModificaPoolPersonasOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = -9159036514039132884L;

	/** The tipo perfil. */
	private String tipoPerfil;

	/** The fecha ult mod. */
	private Date fechaUltMod;

	/** The usuario mod. */
	private String usuarioMod;

	/** The persona. */
	private String persona;

	/** The estatus. */
	private String estatus;

	/**
	 * Obtiene tipo perfil.
	 *
	 * @return tipo perfil
	 */
	public String getTipoPerfil() {
		return tipoPerfil;
	}

	/**
	 * Establece tipo perfil.
	 *
	 * @param tipoPerfil a tipo perfil
	 */
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}

	/**
	 * Obtiene fecha ult mod.
	 *
	 * @return fecha ult mod
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}

	/**
	 * Establece fecha ult mod.
	 *
	 * @param fechaUltMod a fecha ult mod
	 */
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}

	/**
	 * Obtiene usuario mod.
	 *
	 * @return usuario mod
	 */
	public String getUsuarioMod() {
		return usuarioMod;
	}

	/**
	 * Establece usuario mod.
	 *
	 * @param usuarioMod a usuario mod
	 */
	public void setUsuarioMod(String usuarioMod) {
		this.usuarioMod = usuarioMod;
	}

	/**
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona a persona
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus a estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}


}
