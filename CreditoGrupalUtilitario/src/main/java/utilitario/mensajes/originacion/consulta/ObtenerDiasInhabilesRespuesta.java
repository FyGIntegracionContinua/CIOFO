/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ObtenerDiasInhabilesRespuesta.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarCliente...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Identificador del ConsultaFechaOV Nuevo.</li>
 * </ul>
 */
public final class ObtenerDiasInhabilesRespuesta extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 			header;

	/** The dias habiles. */
	private java.util.List<java.util.Date>	diasHabiles;

	/**
	 * Instancia una nueva obtener dias inhabiles respuesta.
	 */
	public ObtenerDiasInhabilesRespuesta() {
	  header = new EncabezadoRespuesta();
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public final EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene dias habiles.
	 *
	 * @return the diasHabiles
	 */
	public java.util.List<java.util.Date> getDiasHabiles() {
		return diasHabiles;
	}

	/**
	 * Establece dias habiles.
	 *
	 * @param diasHabiles the diasHabiles to set
	 */
	public void setDiasHabiles(java.util.List<java.util.Date> diasHabiles) {
		this.diasHabiles = diasHabiles;
	}

	}
