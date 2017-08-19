/**
 * utilitario.mensajes.consultas.ConsultarCreditosAsignadosRespuesta.java
 */
package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultarCreditosAsignadosRespuesta.
 *
 * @author ISC Omar Cruz Carrillo (ocruzc) 14/09/2012
 * @version 1.0
 */
public class ConsultarCreditosAsignadosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consultar creditos asignados respuesta.
	 */
	public ConsultarCreditosAsignadosRespuesta() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = -1641387672539026647L;

	/** Encabezado de Respuesta. */
	private EncabezadoRespuesta	header;
	/** {@link List} de {@link CreditosAsignadosOV}. */
	private List<CreditosAsignadosOV> creditosAsignados;

	/**
	 * Metodo que regresa el valor del miembro dato header.
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * Metodo que establece el valor para el miembro dato header.
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * Metodo que regresa el valor del miembro dato creditosAsignados.
	 * @return the creditosAsignados
	 */
	public List<CreditosAsignadosOV> getCreditosAsignados() {
		return creditosAsignados;
	}
	/**
	 * Metodo que establece el valor para el miembro dato creditosAsignados.
	 * @param creditosAsignados the creditosAsignados to set
	 */
	public void setCreditosAsignados(List<CreditosAsignadosOV> creditosAsignados) {
		this.creditosAsignados = creditosAsignados;
	}
}
