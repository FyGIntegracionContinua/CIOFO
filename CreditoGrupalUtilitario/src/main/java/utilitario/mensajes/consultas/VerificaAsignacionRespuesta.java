package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class VerificaAsignacionRespuesta.
 *
 * @author mi.mejorada
 */
public class VerificaAsignacionRespuesta extends ObjetoValor {

	/**
	 * VerificaAsignacionRespuesta.
	 */
	public VerificaAsignacionRespuesta() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 2616763700807344368L;

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta header;

	/** asignacionesDetalle List<AsignacionDetalleOV>. */
	private List<AsignacionDetalleOV> asignacionesDetalle;

	/** cambioDiaAsesor boolean. */
	private boolean cambioDiaAsesor;

	/** The valida producto. */
	private boolean validaProducto;

	/** The mensaje valida producto. */
	private String mensajeValidaProducto;

	/** The numero traslapes. */
	private int numeroTraslapes;


	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene asignaciones detalle.
	 *
	 * @return the asignacionesDetalle
	 */
	public List<AsignacionDetalleOV> getAsignacionesDetalle() {
		return asignacionesDetalle;
	}

	/**
	 * Establece asignaciones detalle.
	 *
	 * @param asignacionesDetalle the asignacionesDetalle to set
	 */
	public void setAsignacionesDetalle(List<AsignacionDetalleOV> asignacionesDetalle) {
		this.asignacionesDetalle = asignacionesDetalle;
	}

	/**
	 * Checks if is cambio dia asesor.
	 *
	 * @return the cambioDiaAsesor
	 */
	public boolean isCambioDiaAsesor() {
		return cambioDiaAsesor;
	}

	/**
	 * Establece cambio dia asesor.
	 *
	 * @param cambioDiaAsesor the cambioDiaAsesor to set
	 */
	public void setCambioDiaAsesor(boolean cambioDiaAsesor) {
		this.cambioDiaAsesor = cambioDiaAsesor;
	}

	/**
	 * Obtiene cambio dia asesor.
	 *
	 * @return the cambioDiaAsesor
	 */
	public boolean getCambioDiaAsesor() {
		return cambioDiaAsesor;
	}

	/**
	 * Obtiene valida producto.
	 *
	 * @return valida producto
	 */
	public boolean getValidaProducto() {
		return validaProducto;
	}

	/**
	 * Establece valida producto.
	 *
	 * @param validaProducto a valida producto
	 */
	public void setValidaProducto(boolean validaProducto) {
		this.validaProducto = validaProducto;
	}

	/**
	 * Obtiene numero traslapes.
	 *
	 * @return numero traslapes
	 */
	public int getNumeroTraslapes() {
		return numeroTraslapes;
	}

	/**
	 * Establece numero traslapes.
	 *
	 * @param numeroTraslapes a numero traslapes
	 */
	public void setNumeroTraslapes(int numeroTraslapes) {
		this.numeroTraslapes = numeroTraslapes;
	}

	/**
	 * Establece mensaje valida producto.
	 *
	 * @param mensajeValidaProducto a mensaje valida producto
	 */
	public void setMensajeValidaProducto(String mensajeValidaProducto) {
		this.mensajeValidaProducto = mensajeValidaProducto;
	}

	/**
	 * Obtiene mensaje valida producto.
	 *
	 * @return mensaje valida producto
	 */
	public String getMensajeValidaProducto() {
		return mensajeValidaProducto;
	}

}
