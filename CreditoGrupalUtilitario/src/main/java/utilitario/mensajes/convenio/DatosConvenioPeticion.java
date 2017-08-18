package utilitario.mensajes.convenio;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class DatosConvenioPeticion extends ObjetoValor  {


	/**
	 * DatosConvenioPeticion
	 */
	public DatosConvenioPeticion() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 4082787371775140757L;
	/**
	 * numeroContrato String
	 */
	private String numeroContrato;
	/**
	 * numeroPersona String
	 */
	private String numeroPersona;

	/**
	 * @return .
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato .
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
	}
	/**
	 * @return .
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}
	/**
	 * @param numeroPersona .
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
	}

}

