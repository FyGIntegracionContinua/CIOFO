package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudesRepPeticion.
 *
 * @author out_ltorres
 */
public class SolicitudesRepPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes rep peticion.
	 */
	public SolicitudesRepPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8980413224403005853L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p fecha inicio. */
	private String pFechaInicio;

	/** The p fecha fin. */
	private String pFechaFin;

	/** The p sucursal. */
	private String pSucursal;

	/** The p estatus. */
	private String pEstatus;

	/** The p ciclo. */
	private String pCiclo;

	/** The p producto. */
	private String pProducto;


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
	 * Obtiene p fecha inicio.
	 *
	 * @return p fecha inicio
	 */
	public String getpFechaInicio() {
		return pFechaInicio;
	}

	/**
	 * Establece p fecha inicio.
	 *
	 * @param pFechaInicio a p fecha inicio
	 */
	public void setpFechaInicio(String pFechaInicio) {
		this.pFechaInicio = pFechaInicio;
	}

	/**
	 * Obtiene p fecha fin.
	 *
	 * @return p fecha fin
	 */
	public String getpFechaFin() {
		return pFechaFin;
	}

	/**
	 * Establece p fecha fin.
	 *
	 * @param pFechaFin a p fecha fin
	 */
	public void setpFechaFin(String pFechaFin) {
		this.pFechaFin = pFechaFin;
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

	/**
	 * Obtiene p ciclo.
	 *
	 * @return p ciclo
	 */
	public String getpCiclo() {
		return pCiclo;
	}

	/**
	 * Establece p ciclo.
	 *
	 * @param pCiclo a p ciclo
	 */
	public void setpCiclo(String pCiclo) {
		this.pCiclo = pCiclo;
	}

	/**
	 * Obtiene p producto.
	 *
	 * @return p producto
	 */
	public String getpProducto() {
		return pProducto;
	}

	/**
	 * Establece p producto.
	 *
	 * @param pProducto a p producto
	 */
	public void setpProducto(String pProducto) {
		this.pProducto = pProducto;
	}

}
