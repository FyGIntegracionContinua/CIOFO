package utilitario.mensajes.reportes.comun;

import java.math.BigDecimal;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * @author mi.mejorada
 *
 */
public 	class 	LineaContableOV extends ObjetoValor {
	/**
	 * UID para la serializacion
	 */
	private static final long serialVersionUID = -5146614330589143101L;

	//Atributos de la clase  --------------------------------------------------------------

	/**
	 * texto
	 */
	private java.lang.String 		texto;
	/**
	 * monto
	 */
	private java.math.BigDecimal 	monto;
	/**
	 * monto2
	 */
	private java.lang.String		monto2;

    /**
     * Constructor
     * @param texto :
     * @param monto :
     */
	public LineaContableOV(String texto, BigDecimal monto) {
		this.texto 	= texto;
		this.monto 	= monto;
		this.monto2 = "0";
		}

	/**
	 * @param texto :
	 * @param monto :
	 * @param monto2 :
	 */
	public LineaContableOV(String texto, BigDecimal monto, String monto2) {
		this.texto 	= texto;
		this.monto 	= monto;
		this.monto2 = monto2;
		}

	//Métodos get - set  ------------------------------------------------------------------
	/**
	 * @return the texto
	 */
	public java.lang.String getTexto() {
		return texto;
	}

	/**
	 * @param texto the texto to set
	 */
	public void setTexto(java.lang.String texto) {
		this.texto = texto;
	}

	/**
	 * @return the monto
	 */
	public java.math.BigDecimal getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(java.math.BigDecimal monto) {
		this.monto = monto;
	}

	/**
	 * @return the monto2
	 */
	public java.lang.String getMonto2() {
		return monto2;
	}

	/**
	 * @param monto2 the monto2 to set
	 */
	public void setMonto2(java.lang.String monto2) {
		this.monto2 = monto2;
	}

}
