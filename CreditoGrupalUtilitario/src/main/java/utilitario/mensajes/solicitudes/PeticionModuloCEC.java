package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class PeticionModuloCEC extends ObjetoValor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 687896179706013183L;
	private String personaAnalista;
	private String sucursal;
	private String perfil;
	private String solicitud;
	private boolean consultaMarcadas;
	
	/**
	 * @return the personaAnalista
	 */
	public String getPersonaAnalista() {
		return personaAnalista;
	}
	/**
	 * @param personaAnalista the personaAnalista to set
	 */
	public void setPersonaAnalista(String personaAnalista) {
		this.personaAnalista = personaAnalista;
	}
	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
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
	 * @return the consultaMarcadas
	 */
	public boolean isConsultaMarcadas() {
		return consultaMarcadas;
	}
	/**
	 * @param consultaMarcadas the consultaMarcadas to set
	 */
	public void setConsultaMarcadas(boolean consultaMarcadas) {
		this.consultaMarcadas = consultaMarcadas;
	}

}
