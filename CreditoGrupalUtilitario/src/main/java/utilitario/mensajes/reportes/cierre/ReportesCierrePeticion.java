
package utilitario.mensajes.reportes.cierre;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author out_jcmoreno
 *
 */
public 	class 	ReportesCierrePeticion extends ObjetoValor {



	/**
	 * ReportesCierrePeticion
	 */
	public ReportesCierrePeticion() {
		super();
	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -1114240096842388792L;

	/**
	 * header EncabezadoPeticion
	 */
	private EncabezadoPeticion header;
	/**
	 * fechaCierre Date
	 */
	private Date fechaCierre;
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
	 * @return the fechaCierre
	 */
	public Date getFechaCierre() {
		return fechaCierre;
	}
	/**
	 * @param fechaCierre the fechaCierre to set
	 */
	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

}
