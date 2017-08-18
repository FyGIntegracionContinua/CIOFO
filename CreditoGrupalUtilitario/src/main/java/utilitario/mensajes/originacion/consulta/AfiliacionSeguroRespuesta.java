package utilitario.mensajes.originacion.consulta;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.seguros.cliente;

public class AfiliacionSeguroRespuesta extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -3379234138814783034L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/** The sum mon aho. */
	private Double montoTotalSeguroVida;

	/** The pago garantia. */
	private Double montoTotalSeguroEnfermedades;

	/** The clientes. */
	private List<cliente> clientes;

	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the montoTotalSeguroVida
	 */
	public Double getMontoTotalSeguroVida() {
		return montoTotalSeguroVida;
	}

	/**
	 * @param montoTotalSeguroVida the montoTotalSeguroVida to set
	 */
	public void setMontoTotalSeguroVida(Double montoTotalSeguroVida) {
		this.montoTotalSeguroVida = montoTotalSeguroVida;
	}

	/**
	 * @return the montoTotalSeguroEnfermedades
	 */
	public Double getMontoTotalSeguroEnfermedades() {
		return montoTotalSeguroEnfermedades;
	}

	/**
	 * @param montoTotalSeguroEnfermedades the montoTotalSeguroEnfermedades to set
	 */
	public void setMontoTotalSeguroEnfermedades(Double montoTotalSeguroEnfermedades) {
		this.montoTotalSeguroEnfermedades = montoTotalSeguroEnfermedades;
	}

	/**
	 * @return the clientes
	 */
	public List<cliente> getClientes() {
		return clientes;
	}

	/**
	 * @param clientes the clientes to set
	 */
	public void setClientes(List<cliente> clientes) {
		this.clientes = clientes;
	}

}
