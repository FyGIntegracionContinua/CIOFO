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
	 * Método que regresa el valor del miémbro dato header.
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * Método que establece el valor para el miémbro dato header.
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * Método que regresa el valor del miémbro dato creditosAsignados.
	 * @return the creditosAsignados
	 */
	public List<CreditosAsignadosOV> getCreditosAsignados() {
		return creditosAsignados;
	}
	/**
	 * Método que establece el valor para el miémbro dato creditosAsignados.
	 * @param creditosAsignados the creditosAsignados to set
	 */
	public void setCreditosAsignados(List<CreditosAsignadosOV> creditosAsignados) {
		this.creditosAsignados = creditosAsignados;
	}
}
