package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DatosIntegranteResumenOV.
 *
 * @author mimejorada
 */
public class DatosIntegranteResumenOV extends ObjetoValor {

	/**
	 * Instancia una nueva datos integrante resumen ov.
	 */
	public DatosIntegranteResumenOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2420073756128515569L;

	/** The cliente. */
	private String cliente;  					//MEMBER.CUS.ID

	/** The monto. */
	private Double monto;						//MEMBER.LOAN.AMT

	/** The nombre. */
	private String nombre; 							//SHORT.NAME

	/** The paterno. */
	private String paterno;							//NAME.1

	/** The materno. */
	private String materno;							//SURNAME.2

	/** The rol. */
	private String rol;

	/** The producto. */
	private String producto;

	/** The seguro. */
	private java.lang.String 	seguro;

	/** The seguro. */
	private java.lang.String 	seguroEnfermedad;

	/** The objetivo. */
	private java.lang.String 	objetivo;		//detino_credito

	/** The monto pago atrasado. */
	private java.lang.Double	montoPagoAtrasado;	//

	/** The monto corriente. */
	private java.lang.Double	montoCorriente;		//

	/** The saldo liquidar. */
	private java.lang.Double	saldoLiquidar;		//

	/** The clave t24. */
	private java.lang.String	claveT24;

	/** The monto liq. */
	private java.lang.Double	montoLiq;

	/** The financiada. */
	private java.lang.String	financiada;

	/** The saldo capital. */
	private java.lang.Double	saldoCapital;

	/** The saldo interes. */
	private java.lang.Double	saldoInteres;

	/** The saldo moratorios. */
	private java.lang.Double	saldoMoratorios;

	/** The fecha nacimiento. */
	private java.lang.String	fechaNacimiento;

	/** The sexo. */
	private java.lang.String	sexo;


	//MIMH 2013-11-21 OPERFIN-138
	/** The porcentaje participacion. */
	private java.lang.Double	porcentajeParticipacion;

	//MIMH 2014-01-21 OPERFIN-128
	/** The estatus. */
	private String estatus;

	/** The des estatus. */
	private String desEstatus;

	/** The curp. */
	private String curp;

	/** The saldoGarantia */
	private java.lang.Double	saldoGarantia;

	/** The Monto del Cheque */
	private java.lang.Double	montoCheque;

	/** The medioPago*/
	private java.lang.String	medioPago;

	/** The monto ahorro. */
	private String montoAhorro;

	/** The ciclo integrante. */
	private Integer cicloIntegrante;

	/** The monto seguro. */
	private Double montoSeguro;

	/** The num integrante. */
	private Integer numIntegrante;

	/** The monto refinanciar. */
	private Double montoRefinanciar;
	
	private String montoFormato;
	
	private String montoRefinanciarFormato;

	//STAF-195
	/** Folio del cheque */
	private String folioCheque;

	/** empresaOrigenDesc. */
	private String empresaOrigenDesc;

	/**
	 * Obtiene cliente.
	 *
	 * @return cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente a cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene monto.
	 *
	 * @return monto
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * Establece monto.
	 *
	 * @param monto a monto
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre a nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene paterno.
	 *
	 * @return paterno
	 */
	public String getPaterno() {
		return paterno;
	}

	/**
	 * Establece paterno.
	 *
	 * @param paterno a paterno
	 */
	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	/**
	 * Obtiene materno.
	 *
	 * @return materno
	 */
	public String getMaterno() {
		return materno;
	}

	/**
	 * Establece materno.
	 *
	 * @param materno a materno
	 */
	public void setMaterno(String materno) {
		this.materno = materno;
	}

	/**
	 * Obtiene objetivo.
	 *
	 * @return objetivo
	 */
	public java.lang.String getObjetivo() {
		return objetivo;
	}

	/**
	 * Establece objetivo.
	 *
	 * @param objetivo a objetivo
	 */
	public void setObjetivo(java.lang.String objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * Obtiene monto pago atrasado.
	 *
	 * @return monto pago atrasado
	 */
	public java.lang.Double getMontoPagoAtrasado() {
		return montoPagoAtrasado;
	}

	/**
	 * Establece monto pago atrasado.
	 *
	 * @param montoPagoAtrasado a monto pago atrasado
	 */
	public void setMontoPagoAtrasado(java.lang.Double montoPagoAtrasado) {
		this.montoPagoAtrasado = montoPagoAtrasado;
	}

	/**
	 * Obtiene monto corriente.
	 *
	 * @return monto corriente
	 */
	public java.lang.Double getMontoCorriente() {
		return montoCorriente;
	}

	/**
	 * Establece monto corriente.
	 *
	 * @param montoCorriente a monto corriente
	 */
	public void setMontoCorriente(java.lang.Double montoCorriente) {
		this.montoCorriente = montoCorriente;
	}

	/**
	 * Obtiene saldo liquidar.
	 *
	 * @return saldo liquidar
	 */
	public java.lang.Double getSaldoLiquidar() {
		return saldoLiquidar;
	}

	/**
	 * Establece saldo liquidar.
	 *
	 * @param saldoLiquidar a saldo liquidar
	 */
	public void setSaldoLiquidar(java.lang.Double saldoLiquidar) {
		this.saldoLiquidar = saldoLiquidar;
	}

	/**
	 * Establece clave t24.
	 *
	 * @param claveT24 a clave t24
	 */
	public void setClaveT24(java.lang.String claveT24) {
		this.claveT24 = claveT24;
	}

	/**
	 * Obtiene clave t24.
	 *
	 * @return clave t24
	 */
	public java.lang.String getClaveT24() {
		return claveT24;
	}

	/**
	 * Establece monto liq.
	 *
	 * @param montoLiq a monto liq
	 */
	public void setMontoLiq(java.lang.Double montoLiq) {
		this.montoLiq = montoLiq;
	}

	/**
	 * Obtiene monto liq.
	 *
	 * @return monto liq
	 */
	public java.lang.Double getMontoLiq() {
		return montoLiq;
	}

	/**
	 * Establece financiada.
	 *
	 * @param financiada a financiada
	 */
	public void setFinanciada(java.lang.String financiada) {
		this.financiada = financiada;
	}

	/**
	 * Obtiene financiada.
	 *
	 * @return financiada
	 */
	public java.lang.String getFinanciada() {
		return financiada;
	}

	/**
	 * Obtiene saldo capital.
	 *
	 * @return saldo capital
	 */
	public java.lang.Double getSaldoCapital() {
		return saldoCapital;
	}

	/**
	 * Establece saldo capital.
	 *
	 * @param saldoCapital a saldo capital
	 */
	public void setSaldoCapital(java.lang.Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	/**
	 * Obtiene saldo interes.
	 *
	 * @return saldo interes
	 */
	public java.lang.Double getSaldoInteres() {
		return saldoInteres;
	}

	/**
	 * Establece saldo interes.
	 *
	 * @param saldoInteres a saldo interes
	 */
	public void setSaldoInteres(java.lang.Double saldoInteres) {
		this.saldoInteres = saldoInteres;
	}

	/**
	 * Obtiene saldo moratorios.
	 *
	 * @return saldo moratorios
	 */
	public java.lang.Double getSaldoMoratorios() {
		return saldoMoratorios;
	}

	/**
	 * Establece saldo moratorios.
	 *
	 * @param saldoMoratorios a saldo moratorios
	 */
	public void setSaldoMoratorios(java.lang.Double saldoMoratorios) {
		this.saldoMoratorios = saldoMoratorios;
	}

	/**
	 * Obtiene fecha nacimiento.
	 *
	 * @return the fechaNacimiento
	 */
	public java.lang.String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece fecha nacimiento.
	 *
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(java.lang.String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * Obtiene sexo.
	 *
	 * @return the sexo
	 */
	public java.lang.String getSexo() {
		return sexo;
	}

	/**
	 * Establece sexo.
	 *
	 * @param sexo the sexo to set
	 */
	public void setSexo(java.lang.String sexo) {
		this.sexo = sexo;
	}

	/**
	 * Obtiene porcentaje participacion.
	 *
	 * @return the porcentajeParticipacion
	 */
	public java.lang.Double getPorcentajeParticipacion() {
		return porcentajeParticipacion;
	}

	/**
	 * Establece porcentaje participacion.
	 *
	 * @param porcentajeParticipacion the porcentajeParticipacion to set
	 */
	public void setPorcentajeParticipacion(java.lang.Double porcentajeParticipacion) {
		this.porcentajeParticipacion = porcentajeParticipacion;
	}

	/**
	 * Establece seguro.
	 *
	 * @param seguro a seguro
	 */
	public void setSeguro(java.lang.String seguro) {
		this.seguro = seguro;
	}

	/**
	 * Obtiene seguro.
	 *
	 * @return seguro
	 */
	public java.lang.String getSeguro() {
		return seguro;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus a estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene des estatus.
	 *
	 * @return des estatus
	 */
	public String getDesEstatus() {
		return desEstatus;
	}

	/**
	 * Establece des estatus.
	 *
	 * @param desEstatus a des estatus
	 */
	public void setDesEstatus(String desEstatus) {
		this.desEstatus = desEstatus;
	}

	/**
	 * @return the seguroEnfermedad
	 */
	public java.lang.String getSeguroEnfermedad() {
		return seguroEnfermedad;
	}

	/**
	 * @param seguroEnfermedad the seguroEnfermedad to set
	 */
	public void setSeguroEnfermedad(java.lang.String seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
	}


	/**
	 * @return the curp
	 */
	public String getCurp() {
		return curp;
	}

	/**
	 * @param curp the curp to set
	 */
	public void setCurp(String curp) {
		this.curp = curp;
	}

	/**
	 * @return the saldo Garantia
	 */
	public java.lang.Double getSaldoGarantia() {
		return saldoGarantia;
	}

	/**
	 * @param saldoGarantia to set
	 */
	public void setSaldoGarantia(java.lang.Double saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
	}

	/**
	 * @return the monto Cheque
	 */
	public java.lang.Double getMontoCheque() {
		return montoCheque;
	}

	/**
	 * @param montoCheque to set
	 */
	public void setMontoCheque(java.lang.Double montoCheque) {
		this.montoCheque = montoCheque;
	}
	/**
	 * @return the medioPago
	 */
	public java.lang.String getMedioPago() {
		return medioPago;
	}
	/**
	 * @param medioPago to set
	 */
	public void setMedioPago(java.lang.String medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * @return the montoAhorro
	 */
	public String getMontoAhorro() {
		return montoAhorro;
	}

	/**
	 * @param montoAhorro the montoAhorro to set
	 */
	public void setMontoAhorro(String montoAhorro) {
		this.montoAhorro = montoAhorro;
	}

	/**
	 * @return the cicloIntegrante
	 */
	public Integer getCicloIntegrante() {
		return cicloIntegrante;
	}

	/**
	 * @param cicloIntegrante the cicloIntegrante to set
	 */
	public void setCicloIntegrante(Integer cicloIntegrante) {
		this.cicloIntegrante = cicloIntegrante;
	}

	/**
	 * @return the montoSeguro
	 */
	public Double getMontoSeguro() {
		return montoSeguro;
	}

	/**
	 * @param montoSeguro the montoSeguro to set
	 */
	public void setMontoSeguro(Double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}

	/**
	 * @return the numIntegrante
	 */
	public Integer getNumIntegrante() {
		return numIntegrante;
	}

	/**
	 * @param numIntegrante the numIntegrante to set
	 */
	public void setNumIntegrante(Integer numIntegrante) {
		this.numIntegrante = numIntegrante;
	}

	/**
	 * Obtiene rol.
	 *
	 * @return the rol
	 */
	public String getRol() {
		return rol;
	}

	/**
	 * Establece rol.
	 *
	 * @param rol the rol to set
	 */
	public void setRol(String rol) {
		this.rol = rol;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the montoRefinanciar
	 */
	public Double getMontoRefinanciar() {
		return montoRefinanciar;
	}

	/**
	 * @param montoRefinanciar the montoRefinanciar to set
	 */
	public void setMontoRefinanciar(Double montoRefinanciar) {
		this.montoRefinanciar = montoRefinanciar;
	}

	/**
	 * @return the montoFormato
	 */
	public String getMontoFormato() {
		return montoFormato;
	}

	/**
	 * @param montoFormato the montoFormato to set
	 */
	public void setMontoFormato(String montoFormato) {
		this.montoFormato = montoFormato;
	}

	/**
	 * @return the montoRefinanciarFormato
	 */
	public String getMontoRefinanciarFormato() {
		return montoRefinanciarFormato;
	}

	/**
	 * @param montoRefinanciarFormato the montoRefinanciarFormato to set
	 */
	public void setMontoRefinanciarFormato(String montoRefinanciarFormato) {
		this.montoRefinanciarFormato = montoRefinanciarFormato;
	}

	/**
	 * @return the folioCheque
	 */
	public String getFolioCheque() {
		return folioCheque;
	}

	/**
	 * @param folioCheque the folioCheque to set
	 */
	public void setFolioCheque(String folioCheque) {
		this.folioCheque = folioCheque;
	}

	/**
	 * @return the empresaOrigenDesc
	 */
	public String getEmpresaOrigenDesc() {
		return empresaOrigenDesc;
	}

	/**
	 * @param empresaOrigenDesc the empresaOrigenDesc to set
	 */
	public void setEmpresaOrigenDesc(String empresaOrigenDesc) {
		this.empresaOrigenDesc = empresaOrigenDesc;
	}
}
