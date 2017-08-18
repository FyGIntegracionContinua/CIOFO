package utilitario.mensajes.grupos.gps;

import utilitario.mensajes.comun.ObjetoValor;

public class GruposGPSPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7176447056722791045L;
	/**	sucursal */
	private int sucursal;
	/**	grupo */
	private String grupo;
	/**	latitud */
	private float latitud;
	/**	longitud */
	private float longitud;
	/**	usuario */
	private String usuario;
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
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	/**
	 * @return the latitud
	 */
	public float getLatitud() {
		return latitud;
	}
	/**
	 * @param latitud the latitud to set
	 */
	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}
	/**
	 * @return the longitud
	 */
	public float getLongitud() {
		return longitud;
	}
	/**
	 * @param longitud the longitud to set
	 */
	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}
