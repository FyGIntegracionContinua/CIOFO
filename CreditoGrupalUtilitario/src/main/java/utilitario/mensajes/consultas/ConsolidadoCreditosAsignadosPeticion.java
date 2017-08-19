/**
 * utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosPeticion.java
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ISC Omar Cruz Carrillo (ocruzc) 14/09/2012
 * @version 1.0
 */
public class ConsolidadoCreditosAsignadosPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consolidado creditos asignados peticion.
	 */
	public ConsolidadoCreditosAsignadosPeticion() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -7190844300206663185L;

	/** N&uacute;mero de Sucursal. */
	private Integer sucursal;
	/** Clave de Asesor. */
	private String asesor;

	/**
	 * Metodo que regresa el valor del miembro dato sucursal.
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * Metodo que establece el valor para el miembro dato sucursal.
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * Metodo que regresa el valor del miembro dato asesor.
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}
	/**
	 * Metodo que establece el valor para el miembro dato asesor.
	 * @param asesor the asesor to set
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}
}
