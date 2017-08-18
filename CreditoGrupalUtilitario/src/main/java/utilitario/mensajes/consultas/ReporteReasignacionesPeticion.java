package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_mreyes
 *
 */
public 	class 	ReporteReasignacionesPeticion extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -2362237146458086954L;

	// Atributos privados  ------------------------------------------------------------------
	/**
	 * header EncabezadoPeticion
	 */
	private EncabezadoPeticion		header;
	/**
	 * sucursal java.lang.Integer
	 */
	private java.lang.Integer		sucursal;
	/**
	 * zona java.lang.Integer
	 */
	private java.lang.Integer 		zona;

	// Constructor --------------------------------------------------------------------------
	/**
	 * ReporteReasignacionesPeticion
	 */
	public ReporteReasignacionesPeticion() {
		header = new EncabezadoPeticion();
		}

	// Funciones get y set  -----------------------------------------------------------------
	/**
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the zona
	 */
	public java.lang.Integer getZona() {
		return zona;
	}

	/**
	 * @param zona the zona to set
	 */
	public void setZona(java.lang.Integer zona) {
		this.zona = zona;
	}

	}
