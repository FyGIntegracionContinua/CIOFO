package utilitario.mensajes.verificacion.telefonica;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class ConsultaSolicitudesVerificacionPeticion extends ObjetoValor {

	/**
	 * ConsultaSolicitudesVerificacionPeticion
	 */
	public ConsultaSolicitudesVerificacionPeticion() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = 1572032855769539415L;
	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion	header;
	/**
	 * Integer sucursal
	 */
	private Integer sucursal;
	/**
	 * Integer horas
	 */
	private Integer horas;
	/**
	 * String estatus
	 */
	private String estatus;

	//aqui se agregaran los demas criterios de busqueda

	/**
	 * @return getHeader :
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header setHeader :
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return getSucursal :
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal setSucursal :
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return getHoras :
	 */
	public Integer getHoras() {
		return horas;
	}
	/**
	 * @param horas setHoras :
	 */
	public void setHoras(Integer horas) {
		this.horas = horas;
	}
	/**
	 * @return getEstatus :
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus setEstatus :
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

}
