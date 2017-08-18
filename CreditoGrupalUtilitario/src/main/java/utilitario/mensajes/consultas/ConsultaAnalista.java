package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * clase que contien los datos de los analistas
 * @author rmontellano
 * @version 4.18
 */
public class ConsultaAnalista  extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2519811356682434032L;
    
	/**numero de persona del analista*/
	private String numeroPersona;
	
	/**clave del puesto*/
	private String clavePuesto;
	
	/**nombre completo del analista*/
	private String nombreCompleto;
	
	/**correo electronico del analista*/
	private String correo;
	/**
	 * @return the numeroPersona
	 */
	public String getNumeroPersona() {
		return numeroPersona;
	}
	/**
	 * @param numeroPersona the numeroPersona to set
	 */
	public void setNumeroPersona(String numeroPersona) {
		this.numeroPersona = numeroPersona;
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
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	/**
	 * @return the clavePuesto
	 */
	public String getClavePuesto() {
		return clavePuesto;
	}
	/**
	 * @param clavePuesto the clavePuesto to set
	 */
	public void setClavePuesto(String clavePuesto) {
		this.clavePuesto = clavePuesto;
	}
	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "numeroPersona: " + numeroPersona + "\tnombre: " + nombreCompleto + "\tcorreo: " + correo
				+ "\tclavePuesto: " + clavePuesto;
	}

}
