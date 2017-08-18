package utilitario.mensajes.impresiondocs.comun;

/**
 * The Class PagoGrupo.
 */
public class PagoGrupo {

	/**
	 * PagoGrupo
	 */
	public PagoGrupo() {

	}
	/**
	 * N�mero de pagos. Viene un registro por cada pago? SI
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
	/**
	 * @return the numpago
	 */
	private String cliente;

	/**
	 * The sdo.
	 *
	 * @return the cliente
	 */
	private String sdo;

	/** The intemoratorio. */
	private String intemoratorio;

	/**
	 * @return the sdo
	 */
	public String getSdo() {
		return sdo;
	}
	/**
	 * @param sdo the sdo to set
	 */
	public void setSdo(String sdo) {
		this.sdo = sdo;
	}
	/**
	 * @return .
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
	 * @return .
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
	 * @return the intemoratorio
	 */
	public String getIntemoratorio() {
		return intemoratorio;
	}
	/**
	 * @param intemoratorio the intemoratorio to set
	 */
	public void setIntemoratorio(String intemoratorio) {
		this.intemoratorio = intemoratorio;
	}


}
