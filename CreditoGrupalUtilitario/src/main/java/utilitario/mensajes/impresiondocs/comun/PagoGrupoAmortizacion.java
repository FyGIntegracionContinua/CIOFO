package utilitario.mensajes.impresiondocs.comun;

/**
 * The Class PagoGrupoAmortizacion.
 */
public class PagoGrupoAmortizacion {

	/**
	 * Instancia una nueva pago grupo amortizacion.
	 */
	public PagoGrupoAmortizacion() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Id del cliente? SI
	 */
	private String cliente;
	/**
	 * ?? Saldo del cliente
	 */
	private String saldoCliente;

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the saldoCliente
	 */
	public String getSaldoCliente() {
		return saldoCliente;
	}
	/**
	 * @param saldoCliente the saldoCliente to set
	 */
	public void setSaldoCliente(String saldoCliente) {
		this.saldoCliente = saldoCliente;
	}
	/**
	 * @return the numpago
	 */
	public String getNumpago() {
		return numpago;
	}
	/**
	 * @param numpago the numpago to set
	 */
	public void setNumpago(String numpago) {
		this.numpago = numpago;
	}
	/**
	 * @return the capital
	 */
	public String getCapital() {
		return capital;
	}
	/**
	 * @param capital the capital to set
	 */
	public void setCapital(String capital) {
		this.capital = capital;
	}
	/**
	 * @return the interes
	 */
	public String getInteres() {
		return interes;
	}
	/**
	 * @param interes the interes to set
	 */
	public void setInteres(String interes) {
		this.interes = interes;
	}
	/**
	 * @return the imptepago
	 */
	public String getImptepago() {
		return imptepago;
	}
	/**
	 * @param imptepago the imptepago to set
	 */
	public void setImptepago(String imptepago) {
		this.imptepago = imptepago;
	}
	/**
	 * @return the imptepagored
	 */
	public String getImptepagored() {
		return imptepagored;
	}
	/**
	 * @param imptepagored the imptepagored to set
	 */
	public void setImptepagored(String imptepagored) {
		this.imptepagored = imptepagored;
	}
	/**
	 * @return the fechapago
	 */
	public String getFechapago() {
		return fechapago;
	}
	/**
	 * @param fechapago the fechapago to set
	 */
	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}
	/**
	 * Número de pagos. Viene un registro por cada pago? SI
	 */
	private String numpago;
	/**
	 * Capital a pagar de cada pago? SI
	 */
	private String capital;
	/**
	 * Interes a pagar de cada pago? SI
	 */
	private String interes;
	/**
	 * Monto de pago de cada periodo? SI
	 */
	private String imptepago;
	/**
	 * Monto de pago de cada periodo? Es dif del anterior? SI esta redondeado
	 */
	private String imptepagored;
	/**
	 * Fecha de pago.
	 */
	private String fechapago;
}
