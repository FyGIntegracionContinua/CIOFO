package utilitario.mensajes.impresiondocs.fichapagoespecial;

/**
 * @author mi.mejorada
 *
 */

public class EspecialFichaPago {

	/**
	 * EspecialFichaPago
	 */
	public EspecialFichaPago() {

	}

	/** cliente String */
	private String cliente;    			//id del cliente
	/** nombre String */
	private String nombre;     			//Nombre del Grupo
	/** tipo String */
	private String tipo;       			//Codigo producto ???
	/** ciclo String */
	private String ciclo;      			//Ciclo del grupo
	/** numpago String */
	private String numpago;    			//N�mero de pago? SI
	/** sucursal String */
	private String sucursal;   			//Nombre de la sucursal
	/** contrato String	 */
	private String contrato;   			//Referencia
	/** contbcmer String */
	private String contbcmer;  			//Referencia Bancomer
	/** contbanmx String */
	private String contbanmx;  			//Referencia Banamex
	/** conthsbc java.lang.String */
	private java.lang.String conthsbc;  			//Referencia Banamex
	/** imptepago String */
	private String imptepago;  			//Monto de pago
	/** imptepagored String	 */
	private String imptepagored;  		//Monto de pago? Monto redondeado
	/** intemoratorio String */
	private String intemoratorio;		//Monto de interes moratorio a que fecha? Por un d�a en mora
	/** ld String */
	private String ld;					//N�mero de contrato
	/** frecuencia String */
	private String frecuencia;			//Frecuencia de pago
	/** fechainicio String */
	private String fechainicio;			//Fecha actual? Fecha Desembolso
	/** tasa String */
	private String tasa;				//Tasa de interes ordinario anual?
	/** cantidadauto String */
	private String cantidadauto;		//Monto Autorizado capital
	/** diasreales String */
	private String diasreales;			//Dias desde la fecha inicio a la fecha actual
	/** interespagado String */
	private String interespagado;		//Interes pagado
	/** saldocapital String */
	private String saldocapital;		//Saldo Capital
	/** interesmora String */
	private String interesmora;			//Interes en mora
	/** recargos String */
	private String recargos;			//Recargos
	/** interesdevengados String */
	private String interesdevengados;	//Intereses devengados
	/** totalpagar String */
	private String totalpagar;			//Total a pagar
	/** workingbalance String	 */
	private String workingbalance;		//Saldo Cuenta
	/** fechafin String	 */
	private String fechafin;			//Fecha Fin
	/** saldoGarantia String	 */
	private Double saldoGarantia;			//Saldo Garantia

	/** The saldo garantia formato. */
	private String saldoGarantiaFormato;

	/** The total a pagar. */
	private Double totalAPagar;

	/** The total a pagar. */
	private String totalAPagarFormato;

	/** The fecha pago. */
	private String fechaPago;

	/** The total pagar formato. */
	private String totalPagarFormato;

	/** The garantia a depositar. */
	private Double garantiaADepositar;

	/** The garantia traspasada. */
	private Double garantiaTraspasada;

	/** The garantia a depositar format. */
	private String garantiaADepositarFormat;

	/** The garantia traspasada format. */
	private String garantiaTraspasadaFormat;

	/** The total pagar garantia. */
	private Double totalPagarGarantia;

	/** The total pagar garantia format. */
	private String totalPagarGarantiaFormat;

	/** The codigo barras. */
	private String codigoBarras;

	/** codigo de referenciaOXXO. */
	private String referenciaOXXO;

	/** codigo de referenciaDIESTEL. */
	private String referenciaDIESTEL;

	/** The referencia referenciaPayBin. */
	private String referenciaPayBin;

	/**
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}
	/**
	 * @param cliente
	 *            the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * @param tipo
	 *            the tipo to set
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * @return the ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo
	 *            the ciclo to set
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * @return the numpago
	 */
	public String getNumpago() {
		return numpago;
	}

	/**
	 * @param numpago
	 *            the numpago to set
	 */
	public void setNumpago(String numpago) {
		this.numpago = numpago;
	}

	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal
	 *            the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato
	 *            the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the contbcmer
	 */
	public String getContbcmer() {
		return contbcmer;
	}

	/**
	 * @param contbcmer
	 *            the contbcmer to set
	 */
	public void setContbcmer(String contbcmer) {
		this.contbcmer = contbcmer;
	}

	/**
	 * @return the contbanmx
	 */
	public String getContbanmx() {
		return contbanmx;
	}

	/**
	 * @param contbanmx
	 *            the contbanmx to set
	 */
	public void setContbanmx(String contbanmx) {
		this.contbanmx = contbanmx;
	}

	/**
	 * @return the imptepago
	 */
	public String getImptepago() {
		return imptepago;
	}

	/**
	 * @param imptepago
	 *            the imptepago to set
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
	 * @param imptepagored
	 *            the imptepagored to set
	 */
	public void setImptepagored(String imptepagored) {
		this.imptepagored = imptepagored;
	}

	/**
	 * @return the intemoratorio
	 */
	public String getIntemoratorio() {
		return intemoratorio;
	}

	/**
	 * @param intemoratorio
	 *            the intemoratorio to set
	 */
	public void setIntemoratorio(String intemoratorio) {
		this.intemoratorio = intemoratorio;
	}

	/**
	 * @return the ld
	 */
	public String getLd() {
		return ld;
	}

	/**
	 * @param ld
	 *            the ld to set
	 */
	public void setLd(String ld) {
		this.ld = ld;
	}

	/**
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * @param frecuencia
	 *            the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * @return the fechainicio
	 */
	public String getFechainicio() {
		return fechainicio;
	}

	/**
	 * @param fechainicio
	 *            the fechainicio to set
	 */
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	/**
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}

	/**
	 * @param tasa
	 *            the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	/**
	 * @return the cantidadauto
	 */
	public String getCantidadauto() {
		return cantidadauto;
	}

	/**
	 * @param cantidadauto
	 *            the cantidadauto to set
	 */
	public void setCantidadauto(String cantidadauto) {
		this.cantidadauto = cantidadauto;
	}

	/**
	 * @return the diasreales
	 */
	public String getDiasreales() {
		return diasreales;
	}

	/**
	 * @param diasreales
	 *            the diasreales to set
	 */
	public void setDiasreales(String diasreales) {
		this.diasreales = diasreales;
	}

	/**
	 * @return the interespagado
	 */
	public String getInterespagado() {
		return interespagado;
	}

	/**
	 * @param interespagado
	 *            the interespagado to set
	 */
	public void setInterespagado(String interespagado) {
		this.interespagado = interespagado;
	}

	/**
	 * @return the saldocapital
	 */
	public String getSaldocapital() {
		return saldocapital;
	}

	/**
	 * @param saldocapital
	 *            the saldocapital to set
	 */
	public void setSaldocapital(String saldocapital) {
		this.saldocapital = saldocapital;
	}

	/**
	 * @return the interesmora
	 */
	public String getInteresmora() {
		return interesmora;
	}

	/**
	 * @param interesmora
	 *            the interesmora to set
	 */
	public void setInteresmora(String interesmora) {
		this.interesmora = interesmora;
	}

	/**
	 * @return the recargos
	 */
	public String getRecargos() {
		return recargos;
	}

	/**
	 * @param recargos
	 *            the recargos to set
	 */
	public void setRecargos(String recargos) {
		this.recargos = recargos;
	}

	/**
	 * @return the interesdevengados
	 */
	public String getInteresdevengados() {
		return interesdevengados;
	}

	/**
	 * @param interesdevengados
	 *            the interesdevengados to set
	 */
	public void setInteresdevengados(String interesdevengados) {
		this.interesdevengados = interesdevengados;
	}

	/**
	 * @return the totalpagar
	 */
	public String getTotalpagar() {
		return totalpagar;
	}

	/**
	 * @param totalpagar
	 *            the totalpagar to set
	 */
	public void setTotalpagar(String totalpagar) {
		this.totalpagar = totalpagar;
	}

	/**
	 * @return the workingbalance
	 */
	public String getWorkingbalance() {
		return workingbalance;
	}

	/**
	 * @param workingbalance
	 *            the workingbalance to set
	 */
	public void setWorkingbalance(String workingbalance) {
		this.workingbalance = workingbalance;
	}

	/**
	 * @return the fechafin
	 */
	public String getFechafin() {
		return fechafin;
	}

	/**
	 * @param fechafin
	 *            the fechafin to set
	 */
	public void setFechafin(String fechafin) {
		this.fechafin = fechafin;
	}

	/**
	 * @return .
	 */
	public java.lang.String getConthsbc() {
		return conthsbc;
	}
	/**
	 * @param conthsbc .
	 */
	public void setConthsbc(java.lang.String conthsbc) {
		this.conthsbc = conthsbc;
	}
	/**
	 * @return the saldoGarantia
	 */
	public Double getSaldoGarantia() {
		return saldoGarantia;
	}
	/**
	 * @param saldoGarantia the saldoGarantia to set
	 */
	public void setSaldoGarantia(Double saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
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
	 * @return the saldoGarantiaFormato
	 */
	public String getSaldoGarantiaFormato() {
		return saldoGarantiaFormato;
	}
	/**
	 * @param saldoGarantiaFormato the saldoGarantiaFormato to set
	 */
	public void setSaldoGarantiaFormato(String saldoGarantiaFormato) {
		this.saldoGarantiaFormato = saldoGarantiaFormato;
	}
	/**
	 * @return the totalAPagar
	 */
	public Double getTotalAPagar() {
		return totalAPagar;
	}
	/**
	 * @param totalAPagar the totalAPagar to set
	 */
	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}
	/**
	 * @return the totalAPagarFormato
	 */
	public String getTotalAPagarFormato() {
		return totalAPagarFormato;
	}
	/**
	 * @param totalAPagarFormato the totalAPagarFormato to set
	 */
	public void setTotalAPagarFormato(String totalAPagarFormato) {
		this.totalAPagarFormato = totalAPagarFormato;
	}
	/**
	 * @return the totalPagarFormato
	 */
	public String getTotalPagarFormato() {
		return totalPagarFormato;
	}
	/**
	 * @param totalPagarFormato the totalPagarFormato to set
	 */
	public void setTotalPagarFormato(String totalPagarFormato) {
		this.totalPagarFormato = totalPagarFormato;
	}
	/**
	 * @return the garantiaADepositar
	 */
	public Double getGarantiaADepositar() {
		return garantiaADepositar;
	}
	/**
	 * @param garantiaADepositar the garantiaADepositar to set
	 */
	public void setGarantiaADepositar(Double garantiaADepositar) {
		this.garantiaADepositar = garantiaADepositar;
	}
	/**
	 * @return the garantiaTraspasada
	 */
	public Double getGarantiaTraspasada() {
		return garantiaTraspasada;
	}
	/**
	 * @param garantiaTraspasada the garantiaTraspasada to set
	 */
	public void setGarantiaTraspasada(Double garantiaTraspasada) {
		this.garantiaTraspasada = garantiaTraspasada;
	}
	/**
	 * @return the garantiaADepositarFormat
	 */
	public String getGarantiaADepositarFormat() {
		return garantiaADepositarFormat;
	}
	/**
	 * @param garantiaADepositarFormat the garantiaADepositarFormat to set
	 */
	public void setGarantiaADepositarFormat(String garantiaADepositarFormat) {
		this.garantiaADepositarFormat = garantiaADepositarFormat;
	}
	/**
	 * @return the garantiaTraspasadaFormat
	 */
	public String getGarantiaTraspasadaFormat() {
		return garantiaTraspasadaFormat;
	}
	/**
	 * @param garantiaTraspasadaFormat the garantiaTraspasadaFormat to set
	 */
	public void setGarantiaTraspasadaFormat(String garantiaTraspasadaFormat) {
		this.garantiaTraspasadaFormat = garantiaTraspasadaFormat;
	}
	/**
	 * @return the totalPagarGarantiaFormat
	 */
	public String getTotalPagarGarantiaFormat() {
		return totalPagarGarantiaFormat;
	}
	/**
	 * @param totalPagarGarantiaFormat the totalPagarGarantiaFormat to set
	 */
	public void setTotalPagarGarantiaFormat(String totalPagarGarantiaFormat) {
		this.totalPagarGarantiaFormat = totalPagarGarantiaFormat;
	}
	/**
	 * @return the totalPagarGarantia
	 */
	public Double getTotalPagarGarantia() {
		return totalPagarGarantia;
	}
	/**
	 * @param totalPagarGarantia the totalPagarGarantia to set
	 */
	public void setTotalPagarGarantia(Double totalPagarGarantia) {
		this.totalPagarGarantia = totalPagarGarantia;
	}
	/**
	 * @return the codigoBarras
	 */
	public String getCodigoBarras() {
		return codigoBarras;
	}
	/**
	 * @param codigoBarras the codigoBarras to set
	 */
	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}
	/**
	 * @return the referenciaOXXO
	 */
	public String getReferenciaOXXO() {
		return referenciaOXXO;
	}
	/**
	 * @param referenciaOXXO the referenciaOXXO to set
	 */
	public void setReferenciaOXXO(String referenciaOXXO) {
		this.referenciaOXXO = referenciaOXXO;
	}
	/**
	 * @return the referenciaDIESTEL
	 */
	public String getReferenciaDIESTEL() {
		return referenciaDIESTEL;
	}
	/**
	 * @param referenciaDIESTEL the referenciaDIESTEL to set
	 */
	public void setReferenciaDIESTEL(String referenciaDIESTEL) {
		this.referenciaDIESTEL = referenciaDIESTEL;
	}

	/**
	 * @return the referenciaPayBin
	 */
	public String getReferenciaPayBin() {
		return referenciaPayBin;
	}
	/**
	 * @param referenciaPayBin the referenciaPayBin to set
	 */
	public void setReferenciaPayBin(String referenciaPayBin) {
		this.referenciaPayBin = referenciaPayBin;
	}
}
