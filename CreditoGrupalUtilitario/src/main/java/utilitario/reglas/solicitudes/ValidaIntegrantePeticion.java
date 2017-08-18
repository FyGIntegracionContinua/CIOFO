package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class ValidaIntegrantePeticion extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 2481624307041105116L;
	/**
	 * persona
	 */
	private String persona;
	/**
	 * producto
	 */
	private String producto;
	/**
	 * solicitud
	 */
	private String solicitud;
	/**
	 * monto
	 */
	private double monto;
	/**
	 * express
	 */
	private boolean express;
	/**
	 * iguala
	 */
	private boolean iguala;
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
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	/**
	 * @return the iguala
	 */
	public boolean isIguala() {
		return iguala;
	}
	/**
	 * @param iguala the iguala to set
	 */
	public void setIguala(boolean iguala) {
		this.iguala = iguala;
	}
	/**
	 * @return the express
	 */
	public boolean isExpress() {
		return express;
	}
	/**
	 * @param express the express to set
	 */
	public void setExpress(boolean express) {
		this.express = express;
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
}
