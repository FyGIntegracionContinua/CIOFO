package utilitario.buzon;

import utilitario.mensajes.comun.ObjetoValor;

public class ConsultaAvanceTrabajoPeticion extends ObjetoValor {

	/**
	 * long ConsultaAvanceTrabajoPeticion.java
	 */
	private static final long serialVersionUID = 6336342377090813337L;
	/**
	 * String ConsultaBuzonPeticion.java
	 */
	private String usuarioPropietario;

	/**
	 * @return the usuarioPropietario
	 */
	public String getUsuarioPropietario() {
		return usuarioPropietario;
	}

	/**
	 * @param usuarioPropietario the usuarioPropietario to set
	 */
	public void setUsuarioPropietario(String usuarioPropietario) {
		this.usuarioPropietario = usuarioPropietario;
	}

}
