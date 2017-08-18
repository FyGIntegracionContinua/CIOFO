/**
 *
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class TraspasoPagos extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5131949068408422335L;

	/** The num. */
	private Integer num;

	/** The fechaPago. */
	private String fechaPago;

	/** The contratoLiquidado. */
	private String contratoLiquidado;

	/** The fechaAplicacion. */
	private String fechaAplicacion;

	/** The contratoCorrecto. */
	private String contratoCorrecto;

	/** The monto */
	private double monto;

	/** The medioPago */
	private String medioPago;

	/** The grupo */
	private String grupo;

	/** The sucursal */
	private String sucursal;

	/** The status */
	private String status;
	
	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}

	/**
	 * @return the fechaPago
	 */
	public String getFechaPago() {
		return fechaPago;
	}

	/**
	 * @param fechaPago the fechaPago to set
	 */
	public void setFechaPago(String fechaPago) {
		this.fechaPago = fechaPago;
	}

	/**
	 * @return the contratoLiquidado
	 */
	public String getContratoLiquidado() {
		return contratoLiquidado;
	}

	/**
	 * @param contratoLiquidado the contratoLiquidado to set
	 */
	public void setContratoLiquidado(String contratoLiquidado) {
		this.contratoLiquidado = contratoLiquidado;
	}

	/**
	 * @return the fechaAplicacion
	 */
	public String getFechaAplicacion() {
		return fechaAplicacion;
	}

	/**
	 * @param fechaAplicacion the fechaAplicacion to set
	 */
	public void setFechaAplicacion(String fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}

	/**
	 * @return the contratoCorrecto
	 */
	public String getContratoCorrecto() {
		return contratoCorrecto;
	}

	/**
	 * @param contratoCorrecto the contratoCorrecto to set
	 */
	public void setContratoCorrecto(String contratoCorrecto) {
		this.contratoCorrecto = contratoCorrecto;
	}

	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}

	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}

	/**
	 * @return the medioPago
	 */
	public String getMedioPago() {
		return medioPago;
	}

	/**
	 * @param medioPago the medioPago to set
	 */
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}



}

