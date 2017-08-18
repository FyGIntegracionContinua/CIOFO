package utilitario.mensajes.comun;

import java.util.Date;

/**
 * The Class FechaContableOV.
 *
 * @author out_jcmoreno
 */
public class FechaContableOV extends ObjetoValor {

	/**
	 * Instancia una nueva fecha contable ov.
	 */
	public FechaContableOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7364737561520969429L;

	/** The fecha. */
	private Date fecha;

	/** The estatus cierre. */
	private boolean estatusCierre;


	/**
	 * Obtiene fecha.
	 *
	 * @return the fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Checks if is estatus cierre.
	 *
	 * @return the estatusCierre
	 */
	public boolean isEstatusCierre() {
		return estatusCierre;
	}

	/**
	 * Establece estatus cierre.
	 *
	 * @param estatusCierre the estatusCierre to set
	 */
	public void setEstatusCierre(boolean estatusCierre) {
		this.estatusCierre = estatusCierre;
	}

}
