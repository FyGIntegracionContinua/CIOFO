/**
 * utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosRespuesta.java
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ISC Omar Cruz Carrillo (ocruzc) 14/09/2012
 * @version 1.0
 */
public class ConsolidadoCreditosAsignadosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consolidado creditos asignados respuesta.
	 */
	public ConsolidadoCreditosAsignadosRespuesta() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5366941953254592035L;

	/** Encabezado de Respuesta. */
	private EncabezadoRespuesta	header;
	/** Consolidado de Cr&eacute;ditos Asignados. */
	private ConsolidadoCreditosAsignadosOV consolidadoCreditosAsignados;

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
	 * Metodo que regresa el valor del miembro dato consolidadoCreditosAsignados.
	 * @return the consolidadoCreditosAsignados
	 */
	public ConsolidadoCreditosAsignadosOV getConsolidadoCreditosAsignados() {
		return consolidadoCreditosAsignados;
	}
	/**
	 * Metodo que establece el valor para el miembro dato consolidadoCreditosAsignados.
	 * @param consolidadoCreditosAsignados the consolidadoCreditosAsignados to set
	 */
	public void setConsolidadoCreditosAsignados(
			ConsolidadoCreditosAsignadosOV consolidadoCreditosAsignados) {
		this.consolidadoCreditosAsignados = consolidadoCreditosAsignados;
	}
}
