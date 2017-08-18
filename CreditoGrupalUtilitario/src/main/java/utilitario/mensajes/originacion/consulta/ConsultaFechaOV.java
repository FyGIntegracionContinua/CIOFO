/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.consulta;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaFechaOV.
 *
 * @author Juan Moreno
 * Encapsula los datos para consultar fechas del sistema necesarias para dar de alta un
 * credito grupal en CREDPROD.
 * <ul>
 * 	<li>Fecha</li>
 * 	<li>Sucursal</li>
 * 	<li>Periodo</li>
 * 	<li>Plazo</li>
 * </ul>
 */
public final class ConsultaFechaOV extends ObjetoValor {

	/**
	 * Instancia una nueva consulta fecha ov.
	 */
	public ConsultaFechaOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	 /** The fecha. */
	 private Date  				fecha;					//PARAMETROS FECHA

	 /** The sucursal. */
	 private int 				sucursal;

	 /** The perido. */
	 private String 				perido;

	 /** The plazo. */
	 private int 				plazo;

	 /** The dia pago. */
	 private java.lang.Integer 	diaPago;	//Utilizado para el dia ancla

	/**
	 * Obtiene perido.
	 *
	 * @return the perido
	 */
	public String getPerido() {
		return perido;
	}

	/**
	 * Establece perido.
	 *
	 * @param perido the perido to set
	 */
	public void setPerido(String perido) {
		this.perido = perido;
	}

	/** The ofs_peticion. */
	private String ofs_peticion;			//Cadena que se guarda para la respuesta;


	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

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
	 * Obtiene ofs_peticion.
	 *
	 * @return the ofs_peticion
	 */
	public String getOfs_peticion() {
		return ofs_peticion;
	}

	/**
	 * Establece ofs_peticion.
	 *
	 * @param ofs_peticion the ofs_peticion to set
	 */
	public void setOfs_peticion(String ofs_peticion) {
		this.ofs_peticion = ofs_peticion;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public int getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene dia pago.
	 *
	 * @return the diaPago
	 */
	public java.lang.Integer getDiaPago() {
		return diaPago;
	}

	/**
	 * Establece dia pago.
	 *
	 * @param diaPago the diaPago to set
	 */
	public void setDiaPago(java.lang.Integer diaPago) {
		this.diaPago = diaPago;
	}

}
