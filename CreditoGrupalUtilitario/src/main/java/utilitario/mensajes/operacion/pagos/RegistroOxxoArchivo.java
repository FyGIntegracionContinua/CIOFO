package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

public class RegistroOxxoArchivo extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -2531265641926546465L;
	/** ciudad */
	private String ciudad;
	/** sucursalOxxo */
	private String sucursalOxxo;
	/** referencia */
	private String referencia;
	/** fechaOperacion */
	private String fechaOperacion;
	/** hora */
	private String hora;
	/** monto */
	private double monto;
	/** contrato */
	private String contrato;
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the sucursalOxxo
	 */
	public String getSucursalOxxo() {
		return sucursalOxxo;
	}
	/**
	 * @param sucursalOxxo the sucursalOxxo to set
	 */
	public void setSucursalOxxo(String sucursalOxxo) {
		this.sucursalOxxo = sucursalOxxo;
	}
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	/**
	 * @return the fechaOperacion
	 */
	public String getFechaOperacion() {
		return fechaOperacion;
	}
	/**
	 * @param fechaOperacion the fechaOperacion to set
	 */
	public void setFechaOperacion(String fechaOperacion) {
		this.fechaOperacion = fechaOperacion;
	}
	/**
	 * @return the hora
	 */
	public String getHora() {
		return hora;
	}
	/**
	 * @param hora the hora to set
	 */
	public void setHora(String hora) {
		this.hora = hora;
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
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}
}
