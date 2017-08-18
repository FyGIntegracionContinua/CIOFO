package utilitario.mensajes.impresiondocs.contratocomunal;

import utilitario.mensajes.comun.EncabezadoPeticion;

/**
 * @author mi.mejorada
 *
 */
public class ComunalContratoPeticion {

	/**
	 * ComunalContratoPeticion
	 */
	public ComunalContratoPeticion() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;
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
	 * @return the sContrato
	 */
	public String getsContrato() {
		return sContrato;
	}
	/**
	 * @param sContrato the sContrato to set
	 */
	public void setsContrato(String sContrato) {
		this.sContrato = sContrato;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * header EncabezadoPeticion
	 */
	private EncabezadoPeticion 	header;
	/** */
	private String sContrato;


}
