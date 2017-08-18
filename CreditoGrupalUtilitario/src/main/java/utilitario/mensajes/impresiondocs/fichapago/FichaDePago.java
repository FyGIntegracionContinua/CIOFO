package utilitario.mensajes.impresiondocs.fichapago;

/**
 * The Class FichaDePago.
 */
public class FichaDePago {

	/**
	 * FichaDePago.
	 */
	public FichaDePago() {

	}

	/**  Id del cliente. */
	private String cliente;

	/** Nombre del grupo? SI. */
	private String nombre;

	/**  ?? Codigo Producto. */
	private String tipo;

	/**  ciclo del grupo? SI. */
	private String ciclo;

	/** N�mero de pago. */
	private String numpago;

	/** Nombre de la sucursal? SI. */
	private String sucursal;

	/** Fecha de pago. */
	private String fechapago;
	/**
	 * ?? Referencia Es una parte del LD con un dv. Verificar que algoritmo
	 * utilizan
	 */
	private String contrato;

	/** ?? Referencia Bancomer. */
	private String contbcmer;
	/**
	 * ?? Referencia Banamex . Es una parte del LD con un dv. Verificar que
	 * algoritmo utilizan
	 */
	private String contbanmx;

	/** ?? Referencia HSBC. */
	private java.lang.String conthsbc;

	/** Monto de pago. */
	private String imptepago;

	/**  Monto de pago? Monto redondeado. */
	private String imptepagored;

	/** Monto de interes moratorio diario? Cantidad por un d�a de mora. */
	private String intemoratorio;

	/** N�mero de contrato. */
	private String ld;

	/** Frecuencia de pago? SI. */
	private String frecuencia;


	/**
	 * Obtiene cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene tipo.
	 *
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Establece tipo.
	 *
	 * @param tipo the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene numpago.
	 *
	 * @return the numpago
	 */
	public String getNumpago() {
		return numpago;
	}

	/**
	 * Establece numpago.
	 *
	 * @param numpago the numpago to set
	 */
	public void setNumpago(String numpago) {
		this.numpago = numpago;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene fechapago.
	 *
	 * @return the fechapago
	 */
	public String getFechapago() {
		return fechapago;
	}

	/**
	 * Establece fechapago.
	 *
	 * @param fechapago the fechapago to set
	 */
	public void setFechapago(String fechapago) {
		this.fechapago = fechapago;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contbcmer.
	 *
	 * @return the contbcmer
	 */
	public String getContbcmer() {
		return contbcmer;
	}

	/**
	 * Establece contbcmer.
	 *
	 * @param contbcmer the contbcmer to set
	 */
	public void setContbcmer(String contbcmer) {
		this.contbcmer = contbcmer;
	}

	/**
	 * Obtiene contbanmx.
	 *
	 * @return the contbanmx
	 */
	public String getContbanmx() {
		return contbanmx;
	}

	/**
	 * Establece contbanmx.
	 *
	 * @param contbanmx the contbanmx to set
	 */
	public void setContbanmx(String contbanmx) {
		this.contbanmx = contbanmx;
	}

	/**
	 * Obtiene imptepago.
	 *
	 * @return the imptepago
	 */
	public String getImptepago() {
		return imptepago;
	}

	/**
	 * Establece imptepago.
	 *
	 * @param imptepago the imptepago to set
	 */
	public void setImptepago(String imptepago) {
		this.imptepago = imptepago;
	}

	/**
	 * Obtiene imptepagored.
	 *
	 * @return the imptepagored
	 */
	public String getImptepagored() {
		return imptepagored;
	}

	/**
	 * Establece imptepagored.
	 *
	 * @param imptepagored the imptepagored to set
	 */
	public void setImptepagored(String imptepagored) {
		this.imptepagored = imptepagored;
	}

	/**
	 * Obtiene intemoratorio.
	 *
	 * @return the intemoratorio
	 */
	public String getIntemoratorio() {
		return intemoratorio;
	}

	/**
	 * Establece intemoratorio.
	 *
	 * @param intemoratorio the intemoratorio to set
	 */
	public void setIntemoratorio(String intemoratorio) {
		this.intemoratorio = intemoratorio;
	}

	/**
	 * Obtiene ld.
	 *
	 * @return the ld
	 */
	public String getLd() {
		return ld;
	}

	/**
	 * Establece ld.
	 *
	 * @param ld the ld to set
	 */
	public void setLd(String ld) {
		this.ld = ld;
	}

	/**
	 * Obtiene frecuencia.
	 *
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Establece frecuencia.
	 *
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Obtiene conthsbc.
	 *
	 * @return the conthsbc
	 */
	public java.lang.String getConthsbc() {
		return conthsbc;
	}

	/**
	 * Establece conthsbc.
	 *
	 * @param conthsbc the conthsbc to set
	 */
	public void setConthsbc(java.lang.String conthsbc) {
		this.conthsbc = conthsbc;
	}

}
