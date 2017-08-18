/**
 * utilitario.mensajes.consultas.ConsultarCreditosAsignadosPeticion.java
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarCreditosAsignadosPeticion.
 *
 * @author ISC Omar Cruz Carrillo (ocruzc) 14/09/2012
 * @version 1.0
 */
public class ConsultarCreditosAsignadosPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva consultar creditos asignados peticion.
	 */
	public ConsultarCreditosAsignadosPeticion() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -7992350647901491158L;

	/** N&uacute;mero de Sucursal. */
	private Integer sucursal;
	/** Clave de Asesor. */
	private String asesor;

	/**
	 * M�todo que regresa el valor del mi�mbro dato sucursal.
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato sucursal.
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato asesor.
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato asesor.
	 * @param asesor the asesor to set
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}
}
