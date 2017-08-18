package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudSACGGetPeticion.
 *
 * @author out_ltorres
 */
public class SolicitudSACGGetPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud sacg get peticion.
	 */
	public SolicitudSACGGetPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6097750828368520832L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p sucursal. */
	private String pSucursal;

	/** The p estatus. */
	private String pEstatus;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Obtiene p sucursal.
	 *
	 * @return p sucursal
	 */
	public String getpSucursal() {
		return pSucursal;
	}

	/**
	 * Establece p sucursal.
	 *
	 * @param pSucursal a p sucursal
	 */
	public void setpSucursal(String pSucursal) {
		this.pSucursal = pSucursal;
	}

	/**
	 * Obtiene p estatus.
	 *
	 * @return p estatus
	 */
	public String getpEstatus() {
		return pEstatus;
	}

	/**
	 * Establece p estatus.
	 *
	 * @param pEstatus a p estatus
	 */
	public void setpEstatus(String pEstatus) {
		this.pEstatus = pEstatus;
	}

}
