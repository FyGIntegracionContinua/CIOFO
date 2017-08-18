/**
 *
 */
package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class RespuestaSucursalOV  extends ObjetoValor {

	/**
	 * RespuestaSucursalOV
	 */
	public RespuestaSucursalOV() {

	}

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 5643197908763011014L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The sucursal. */
	private java.util.ArrayList<SucursalOV> sucursalOV;

	/** The AsesoresOV. */
	private java.util.ArrayList<AsesoresOV> asesoresOV;

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
	 * @return the sucursalOV
	 */
	public java.util.ArrayList<SucursalOV> getSucursalOV() {
		return sucursalOV;
	}

	/**
	 * @param sucursalOV the sucursalOV to set
	 */
	public void setSucursalOV(java.util.ArrayList<SucursalOV> sucursalOV) {
		this.sucursalOV = sucursalOV;
	}

	/**
	 * @return the asesoresOV
	 */
	public java.util.ArrayList<AsesoresOV> getAsesoresOV() {
		return asesoresOV;
	}

	/**
	 * @param asesoresOV the asesoresOV to set
	 */
	public void setAsesoresOV(java.util.ArrayList<AsesoresOV> asesoresOV) {
		this.asesoresOV = asesoresOV;
	}


}
