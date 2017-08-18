package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaReferenciasPagoRespuesta.
 */
public class ConsultaReferenciasPagoRespuesta  extends 	ObjetoValor {

	/**
	 * Instancia una nueva consulta referencias pago respuesta.
	 */
	public ConsultaReferenciasPagoRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -924954080972906058L;

	/** The header. */
	private EncabezadoRespuesta							header;

	/** The referencia banamex. */
	private String 										referenciaBanamex;

	/** The referencia fisa. */
	private String 										referenciaFISA;

	/** The referencia bancomer. */
	private String 										referenciaBancomer;

	/** The referencia hsbc. */
	private String 										referenciaHSBC;

	/** The referencia oxxo. */
	private String 										referenciaOXXO;

	/** The referencia DIESTEL. */
	private String 										referenciaDIESTEL;

	/** The referencia referenciaPayBin. */
	private String 										referenciaPayBin;

	/** The lista de referencias. */
	private List<ReferenciasBancariasOV> 				listaReferencias;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene referencia banamex.
	 *
	 * @return referencia banamex
	 */
	public String getReferenciaBanamex() {
		return referenciaBanamex;
	}

	/**
	 * Establece referencia banamex.
	 *
	 * @param referenciaBanamex a referencia banamex
	 */
	public void setReferenciaBanamex(String referenciaBanamex) {
		this.referenciaBanamex = referenciaBanamex;
	}

	/**
	 * Obtiene referencia fisa.
	 *
	 * @return referencia fisa
	 */
	public String getReferenciaFISA() {
		return referenciaFISA;
	}

	/**
	 * Establece referencia fisa.
	 *
	 * @param referenciaFISA a referencia fisa
	 */
	public void setReferenciaFISA(String referenciaFISA) {
		this.referenciaFISA = referenciaFISA;
	}

	/**
	 * Obtiene referencia bancomer.
	 *
	 * @return referencia bancomer
	 */
	public String getReferenciaBancomer() {
		return referenciaBancomer;
	}

	/**
	 * Establece referencia bancomer.
	 *
	 * @param referenciaBancomer a referencia bancomer
	 */
	public void setReferenciaBancomer(String referenciaBancomer) {
		this.referenciaBancomer = referenciaBancomer;
	}

	/**
	 * Obtiene referencia hsbc.
	 *
	 * @return referencia hsbc
	 */
	public String getReferenciaHSBC() {
		return referenciaHSBC;
	}

	/**
	 * Establece referencia hsbc.
	 *
	 * @param referenciaHSBC a referencia hsbc
	 */
	public void setReferenciaHSBC(String referenciaHSBC) {
		this.referenciaHSBC = referenciaHSBC;
	}

	/**
	 * Obtiene referencia oxxo.
	 *
	 * @return referencia oxxo
	 */
	public String getReferenciaOXXO() {
		return referenciaOXXO;
	}

	/**
	 * Establece referencia oxxo.
	 *
	 * @param referenciaOXXO a referencia oxxo
	 */
	public void setReferenciaOXXO(String referenciaOXXO) {
		this.referenciaOXXO = referenciaOXXO;
	}

	/**
	 * @return the referenciaDIESTEL
	 */
	public String getreferenciaDIESTEL() {
		return referenciaDIESTEL;
	}

	/**
	 * @param referenciaDIESTEL the referenciaDiestel to set
	 */
	public void setreferenciaDIESTEL(String referenciaDIESTEL) {
		this.referenciaDIESTEL = referenciaDIESTEL;
	}

	/**
	 * @return the referenciaPayBin
	 */
	public String getReferenciaPayBin() {
		return referenciaPayBin;
	}
	/**
	 * @param referenciaPayBin the referenciaPayBin to set
	 */
	public void setReferenciaPayBin(String referenciaPayBin) {
		this.referenciaPayBin = referenciaPayBin;
	}

	/**
	 * @return the listaReferencias
	 */
	public List<ReferenciasBancariasOV> getListaReferencias() {
		return listaReferencias;
	}

	/**
	 * @param listaReferencias the listaReferencias to set
	 */
	public void setListaReferencias(List<ReferenciasBancariasOV> listaReferencias) {
		this.listaReferencias = listaReferencias;
	}

}
