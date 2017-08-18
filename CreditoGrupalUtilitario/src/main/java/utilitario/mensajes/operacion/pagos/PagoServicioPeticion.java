package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PagoServicioPeticion.
 */
public class PagoServicioPeticion extends ObjetoValor {

	/**
	 * PagoServicioPeticion
	 */
	public PagoServicioPeticion() {

	}
	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 3491790693175818978L;

	/**
	 * String codigo
	 */
	private String codigo;
	/**
	 * Integer claveCliente
	 */
	private Integer claveCliente;
	/**
	 * String claveProducto
	 */
	private String claveProducto;
	/**
	 * Double monto
	 */
	private Double monto;
	/**
	 * String usuario
	 */
	private String usuario;
	/**
	 * Integer sucursal
	 */
	private Integer sucursal;
	/**
	 * String referencia1
	 */
	private String referencia1;
	/**
	 * String referencia2
	 */
	private String referencia2;
	/**
	 * String referencia3
	 */
	private String referencia3;
	/**
	 * String referencia4
	 */
	private String referencia4;
	/**
	 * String referencia5
	 */
	private String referencia5;
	/**
	 * Double comision
	 */
	private Double comision;
	/**
	 * Double ivaComision
	 */
	private Double ivaComision;

	/** The facha valor. */
	private String fechaValor;

	/** The id transaccion. */
	private String idTransaccion;


	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}
	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	/**
	 * @return the claveCliente
	 */
	public Integer getClaveCliente() {
		return claveCliente;
	}
	/**
	 * @param claveCliente the claveCliente to set
	 */
	public void setClaveCliente(Integer claveCliente) {
		this.claveCliente = claveCliente;
	}
	/**
	 * @return the claveProducto
	 */
	public String getClaveProducto() {
		return claveProducto;
	}
	/**
	 * @param claveProducto the claveProducto to set
	 */
	public void setClaveProducto(String claveProducto) {
		this.claveProducto = claveProducto;
	}
	/**
	 * @return the monto
	 */
	public Double getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the referencia1
	 */
	public String getReferencia1() {
		return referencia1;
	}
	/**
	 * @param referencia1 the referencia1 to set
	 */
	public void setReferencia1(String referencia1) {
		this.referencia1 = referencia1;
	}
	/**
	 * @return the referencia2
	 */
	public String getReferencia2() {
		return referencia2;
	}
	/**
	 * @param referencia2 the referencia2 to set
	 */
	public void setReferencia2(String referencia2) {
		this.referencia2 = referencia2;
	}
	/**
	 * @return the referencia3
	 */
	public String getReferencia3() {
		return referencia3;
	}
	/**
	 * @param referencia3 the referencia3 to set
	 */
	public void setReferencia3(String referencia3) {
		this.referencia3 = referencia3;
	}
	/**
	 * @return the referencia4
	 */
	public String getReferencia4() {
		return referencia4;
	}
	/**
	 * @param referencia4 the referencia4 to set
	 */
	public void setReferencia4(String referencia4) {
		this.referencia4 = referencia4;
	}
	/**
	 * @return the referencia5
	 */
	public String getReferencia5() {
		return referencia5;
	}
	/**
	 * @param referencia5 the referencia5 to set
	 */
	public void setReferencia5(String referencia5) {
		this.referencia5 = referencia5;
	}
	/**
	 * @return the comision
	 */
	public Double getComision() {
		return comision;
	}
	/**
	 * @param comision the comision to set
	 */
	public void setComision(Double comision) {
		this.comision = comision;
	}
	/**
	 * @return the ivaComision
	 */
	public Double getIvaComision() {
		return ivaComision;
	}
	/**
	 * @param ivaComision the ivaComision to set
	 */
	public void setIvaComision(Double ivaComision) {
		this.ivaComision = ivaComision;
	}
	/**
	 * @return the fechaValor
	 */
	public String getFechaValor() {
		return fechaValor;
	}
	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(String fechaValor) {
		this.fechaValor = fechaValor;
	}
	/**
	 * @return the idTransaccion
	 */
	public String getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

}
