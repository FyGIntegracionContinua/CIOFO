/**
 * utilitario.mensajes.consultas.ConsolidadoCreditosAsignadosOV.java
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ISC Omar Cruz Carrillo (ocruzc) 17/09/2012
 * @version 1.0
 */
public class ConsolidadoCreditosAsignadosOV extends ObjetoValor {

	/**
	 * Instancia una nueva consolidado creditos asignados ov.
	 */
	public ConsolidadoCreditosAsignadosOV() {
	}
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 2560148965907267650L;

	/** Total de Cr&eacute;ditos Asignados. */
	private Integer creditosAsignados;
	/** Total de Clientes. */
	private Integer clientes;
	/** Monto total Asignado. */
	private Double montoAsociado;

	/**
	 * M�todo que regresa el valor del mi�mbro dato creditosAsignados.
	 * @return the creditosAsignados
	 */
	public Integer getCreditosAsignados() {
		return creditosAsignados;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato creditosAsignados.
	 * @param creditosAsignados the creditosAsignados to set
	 */
	public void setCreditosAsignados(Integer creditosAsignados) {
		this.creditosAsignados = creditosAsignados;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato clientes.
	 * @return the clientes
	 */
	public Integer getClientes() {
		return clientes;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato clientes.
	 * @param clientes the clientes to set
	 */
	public void setClientes(Integer clientes) {
		this.clientes = clientes;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato montoAsociado.
	 * @return the montoAsociado
	 */
	public Double getMontoAsociado() {
		return montoAsociado;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato montoAsociado.
	 * @param montoAsociado the montoAsociado to set
	 */
	public void setMontoAsociado(Double montoAsociado) {
		this.montoAsociado = montoAsociado;
	}
}
