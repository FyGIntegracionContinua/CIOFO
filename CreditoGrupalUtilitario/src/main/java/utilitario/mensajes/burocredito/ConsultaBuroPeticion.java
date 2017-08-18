package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class ConsultaBuroPeticion extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1380215824996860334L;
	/**
	 * persona
	 */
	private String persona;

	/**
	 * folio
	 */
	private String folio;

	/**
	 * importe
	 */
	private double importe;
	/**
	 * usuario
	 */
	private String usuario;
	/**
	 * sucursal
	 */
	private int sucursal;

	/**
	 * @return the folio
	 */
	public String getFolio() {
		return folio;
	}
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(String folio) {
		this.folio = folio;
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
	 * @return the importe
	 */
	public double getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
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


}
