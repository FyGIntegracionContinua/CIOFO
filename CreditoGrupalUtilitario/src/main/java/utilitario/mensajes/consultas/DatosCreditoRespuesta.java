package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosCreditoRespuesta.
 *
 * @author out_oarias
 */
public class DatosCreditoRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5082709112138876166L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The datos credito. */
	private DatosCreditoOV	datosCredito;

	/** The fechaContable. */
	private String fechaContable;

	/**
	 * Instancia una nueva datos credito respuesta.
	 */
	public DatosCreditoRespuesta() {
		header = new EncabezadoRespuesta();
		}

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
	 * Establece datos credito.
	 *
	 * @param datosCredito a datos credito
	 */
	public void setDatosCredito(DatosCreditoOV datosCredito) {
		this.datosCredito = datosCredito;
	}

	/**
	 * Obtiene datos credito.
	 *
	 * @return datos credito
	 */
	public DatosCreditoOV getDatosCredito() {
		return datosCredito;
	}

	/**
	 * @return the fechaContable
	 */
	public String getFechaContable() {
		return fechaContable;
	}

	/**
	 * @param fechaContable the fechaContable to set
	 */
	public void setFechaContable(String fechaContable) {
		this.fechaContable = fechaContable;
	}


}
