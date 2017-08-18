package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ValidaPagoGarantiaRespuesta extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = -3379234138814783034L;

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/** The sum mon aho. */
	private Double sumMonAho;

	/** The pago garantia. */
	private Double pagoGarantia;

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
	 * Gets the sum mon aho.
	 *
	 * @return the sum mon aho
	 */
	public Double getSumMonAho() {
		return sumMonAho;
	}

	/**
	 * Sets the sum mon aho.
	 *
	 * @param sumMonAho the new sum mon aho
	 */
	public void setSumMonAho(Double sumMonAho) {
		this.sumMonAho = sumMonAho;
	}

	/**
	 * Gets the pago garantia.
	 *
	 * @return the pago garantia
	 */
	public Double getPagoGarantia() {
		return pagoGarantia;
	}

	/**
	 * Sets the pago garantia.
	 *
	 * @param pagoGarantia the new pago garantia
	 */
	public void setPagoGarantia(Double pagoGarantia) {
		this.pagoGarantia = pagoGarantia;
	}


}
