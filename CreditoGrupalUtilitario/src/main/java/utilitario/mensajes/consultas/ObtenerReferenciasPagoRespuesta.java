package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaReferenciasPagoRespuesta.
 */
public class ObtenerReferenciasPagoRespuesta  extends 	ObjetoValor {

	/**
	 * Instancia una nueva consulta referencias pago respuesta.
	 */
	public ObtenerReferenciasPagoRespuesta() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -924954080972906058L;

	/** The header. */
	private EncabezadoRespuesta			header;

	/**
	 * Referencias seguro vida
	 */
	private ReferenciasBancariasOV       seguroVida;

	/**
	 * Referencias seguro enfermedad
	 */
	private ReferenciasBancariasOV       seguroEnfermedad;

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
	 * @return the seguroVida
	 */
	public ReferenciasBancariasOV getSeguroVida() {
		return seguroVida;
	}

	/**
	 * @param seguroVida the seguroVida to set
	 */
	public void setSeguroVida(ReferenciasBancariasOV seguroVida) {
		this.seguroVida = seguroVida;
	}

	/**
	 * @return the seguroEnfermedad
	 */
	public ReferenciasBancariasOV getSeguroEnfermedad() {
		return seguroEnfermedad;
	}

	/**
	 * @param seguroEnfermedad the seguroEnfermedad to set
	 */
	public void setSeguroEnfermedad(ReferenciasBancariasOV seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
	}

}
