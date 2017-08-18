/**
 *
 */
package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SemaforoSolicitudesPeticion.
 *
 * @author out_gcorzo
 */
public class SemaforoSolicitudesPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva codigos peticion.
	 */
	public SemaforoSolicitudesPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1255447782180796419L;

	/** The header. */
	private EncabezadoPeticion header;

	/**
	 * Date fechaInicial SemaforoSolicitudesPeticion.java
	 */
	private Date fechaInicial;

	/**
	 * Date fechaFinal SemaforoSolicitudesPeticion.java
	 */
	private Date fechaFinal;

	/**
	 * String persona SemaforoSolicitudesPeticion.java
	 */
	private String persona;

	/**
	 * int rangoRojo SemaforoSolicitudesPeticion.java
	 */
	private int rangoRojo;

	/**
	 * int rangoVerde SemaforoSolicitudesPeticion.java
	 */
	private int rangoVerde;

	/**
	 * int rangoAmarillo SemaforoSolicitudesPeticion.java
	 */
	private int rangoAmarillo;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * @return the fechaInicial
	 */
	public Date getFechaInicial() {
		return fechaInicial;
	}

	/**
	 * @param fechaInicial the fechaInicial to set
	 */
	public void setFechaInicial(Date fechaInicial) {
		this.fechaInicial = fechaInicial;
	}

	/**
	 * @return the fechaFinal
	 */
	public Date getFechaFinal() {
		return fechaFinal;
	}

	/**
	 * @param fechaFinal the fechaFinal to set
	 */
	public void setFechaFinal(Date fechaFinal) {
		this.fechaFinal = fechaFinal;
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
	 * @return the rangoRojo
	 */
	public int getRangoRojo() {
		return rangoRojo;
	}

	/**
	 * @param rangoRojo the rangoRojo to set
	 */
	public void setRangoRojo(int rangoRojo) {
		this.rangoRojo = rangoRojo;
	}

	/**
	 * @return the rangoVerde
	 */
	public int getRangoVerde() {
		return rangoVerde;
	}

	/**
	 * @param rangoVerde the rangoVerde to set
	 */
	public void setRangoVerde(int rangoVerde) {
		this.rangoVerde = rangoVerde;
	}

	/**
	 * @return the rangoAmarillo
	 */
	public int getRangoAmarillo() {
		return rangoAmarillo;
	}

	/**
	 * @param rangoAmarillo the rangoAmarillo to set
	 */
	public void setRangoAmarillo(int rangoAmarillo) {
		this.rangoAmarillo = rangoAmarillo;
	}

}
