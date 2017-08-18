package utilitario.mensajes.operacion.cierre;

import java.util.Date;

public class OperacionCierrePeticion extends utilitario.mensajes.comun.ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 1819117884400357293L;
	/**
	 * OperacionCierrePeticion
	 */
	public OperacionCierrePeticion() {

	}
	/**
	 * fechaCierre
	 */
	private Date fechaCierre;
	/**
	 * fechaCierre
	 */
	private boolean validaciones;
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
	/**
	 * @return the validaciones
	 */
	public boolean isValidaciones() {
		return validaciones;
	}
	/**
	 * @param validaciones the validaciones to set
	 */
	public void setValidaciones(boolean validaciones) {
		this.validaciones = validaciones;
	}

}
