package utilitario.mensajes.consultas;

import java.io.Serializable;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaSaldosAFavorRespuesta.
 *
 * @author out_mreyes
 */
public 	class 	ConsultaSaldosAFavorRespuesta
		extends 	ObjetoValor
		implements	Serializable {

	/**
	 * Instancia una nueva consulta saldos a favor respuesta.
	 */
	public ConsultaSaldosAFavorRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -605763253829252351L;

	// Atributos de la clase  ---------------------------------------------------------------
	/** The encabezado respuesta. */
	private EncabezadoRespuesta				encabezadoRespuesta;

	/** The lista saldos. */
	private java.util.List<SaldoAFavorVO>	listaSaldos;

	// Sets y Gets  -------------------------------------------------------------------------
	/**
	 * Obtiene encabezado respuesta.
	 *
	 * @return the encabezadoRespuesta
	 */
	public EncabezadoRespuesta getEncabezadoRespuesta() {
		return encabezadoRespuesta;
	}

	/**
	 * Establece encabezado respuesta.
	 *
	 * @param encabezadoRespuesta the encabezadoRespuesta to set
	 */
	public void setEncabezadoRespuesta(EncabezadoRespuesta encabezadoRespuesta) {
		this.encabezadoRespuesta = encabezadoRespuesta;
	}

	/**
	 * Obtiene lista saldos.
	 *
	 * @return the listaSaldos
	 */
	public java.util.List<SaldoAFavorVO> getListaSaldos() {
		return listaSaldos;
	}

	/**
	 * Establece lista saldos.
	 *
	 * @param listaSaldos the listaSaldos to set
	 */
	public void setListaSaldos(java.util.List<SaldoAFavorVO> listaSaldos) {
		this.listaSaldos = listaSaldos;
	}

}
