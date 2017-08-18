package utilitario.mensajes.correo;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class EnviarCorreoPeticion extends ObjetoValor {

	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = -8549520147592232031L;
	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion header;
	/**
	 * String asunto
	 */
	private String asunto;
	/**
	 * String destinatarios
	 */
	private String destinatarios;
	/**
	 * String texto
	 */
	private String texto;
	/**
	 * String texto
	 */
	private String cuentaEnvio;
	/**
	 * String texto
	 */
	private String passwordCuentaEnvio;
	/**
	 * List<DatosAdjuntos> archivos
	 */
	private List<DatosAdjuntos> archivos;

	/**
	 * EnviarCorreoPeticion
	 */
	public EnviarCorreoPeticion() {

	}

	/**
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return the asunto
	 */
	public String getAsunto() {
		return asunto;
	}
	/**
	 * @param asunto the asunto to set
	 */
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	/**
	 * @return the destinatarios
	 */
	public String getDestinatarios() {
		return destinatarios;
	}
	/**
	 * @param destinatarios the destinatarios to set
	 */
	public void setDestinatarios(String destinatarios) {
		this.destinatarios = destinatarios;
	}
	/**
	 * @return the texto
	 */
	public String getTexto() {
		return texto;
	}
	/**
	 * @param texto the texto to set
	 */
	public void setTexto(String texto) {
		this.texto = texto;
	}
	/**
	 * @return the archivos
	 */
	public List<DatosAdjuntos> getArchivos() {
		return archivos;
	}
	/**
	 * @param archivos the archivos to set
	 */
	public void setArchivos(List<DatosAdjuntos> archivos) {
		this.archivos = archivos;
	}

	/**
	 * @return the cuentaEnvio
	 */
	public String getCuentaEnvio() {
		return cuentaEnvio;
	}

	/**
	 * @param cuentaEnvio the cuentaEnvio to set
	 */
	public void setCuentaEnvio(String cuentaEnvio) {
		this.cuentaEnvio = cuentaEnvio;
	}

	/**
	 * @return the passwordCuentaEnvio
	 */
	public String getPasswordCuentaEnvio() {
		return passwordCuentaEnvio;
	}

	/**
	 * @param passwordCuentaEnvio the passwordCuentaEnvio to set
	 */
	public void setPasswordCuentaEnvio(String passwordCuentaEnvio) {
		this.passwordCuentaEnvio = passwordCuentaEnvio;
	}

}
