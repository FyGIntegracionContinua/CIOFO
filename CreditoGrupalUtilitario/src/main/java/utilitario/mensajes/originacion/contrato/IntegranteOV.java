/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.contrato;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;



/**
 * The Class IntegranteOV.
 *
 * @author Juan Moreno
 * Encapsula los datos del integrante de un grupo...
 * <ul>
 * 	<li>Identificador del cliente</li>
 * 	<li>Funcion en el grupo</li>
 * 	<li>Monto Individual</li>
 * 	<li>Objetivo del cliente para el prestamo</li>
 * 	<li>Numero de cheque asociado al Cliente</li>
 * 	<li>Localidaddel cliente</li>
 * </ul>
 */
public final class IntegranteOV extends ObjetoValor {

	/**
	 * Instancia una nueva integrante ov.
	 */
	public IntegranteOV() { }
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

	/** The cliente. */
	private String cliente;  					//MEMBER.CUS.ID

	/** The rol. */
	private String rol;							// Se mapea con el catalogo

	/** The monto. */
	private Double monto;						//MEMBER.LOAN.AMT

	/** The monto financiado. */
	private Double montoFinanciado;

	/** The objetivo. */
	private String objetivo;					//PURPOSE.OF.LOAN

	/** The cheque. */
	private String cheque;

	/** The tipo localidad. */
	private String tipoLocalidad;					//TIPO.LOCALIDAD


	//MMH 2013-11-11 Seguros Finsol
	/**
	 * java.lang.Double montoSeguro
	 */
	private java.lang.Double 	montoSeguro;

	//MMH 2013-11-11 Seguros Finsol
	/**
	 * java.lang.Double montoSeguroEnfermedad
	 */
	private java.lang.Double 	montoSeguroEnfermedad;

	//Transaccionalidad confirmarCredito
	/** The seguro vida. */
	private String seguroVida;

	/** The seguro enfermedad. */
	private String seguroEnfermedad;

	/** The plazo seguro. */
	private String plazoSeguro;

	/** The existe ben. */
	private Boolean existeBen;

	/** The pct participacion. */
	private Double pctParticipacion;

	/** The nombre completo. */
	private String nombreCompleto;

	/** The desertor garantia aplicar. */
	private Double desertorGarantiaAplicar;

	/** The desertor diferencia pagar. */
	private Double desertorDiferenciaPagar;

	/** The validaDesertorGarantiaAplicar. */
	private Double validaDesertorGarantiaAplicar;

	/** The edad. */
	private int edad;

	/** The edad. */
	private Date fechaNacimiento;

	/** desertor*/
	private String desertor;

	/** perteneceCreditoRenovar*/
	private String perteneceCreditoRenovar;

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
	 * Obtiene monto.
	 *
	 * @return the monto
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * Establece monto.
	 *
	 * @param monto the monto to set
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * Obtiene objetivo.
	 *
	 * @return the objetivo
	 */
	public String getObjetivo() {
		return objetivo;
	}

	/**
	 * Establece objetivo.
	 *
	 * @param objetivo the objetivo to set
	 */
	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	/**
	 * Obtiene cheque.
	 *
	 * @return the cheque
	 */
	public String getCheque() {
		return cheque;
	}

	/**
	 * Establece cheque.
	 *
	 * @param cheque the cheque to set
	 */
	public void setCheque(String cheque) {
		this.cheque = cheque;
	}

	/**
	 * Establece tipo localidad.
	 *
	 * @param tipoLocalidad a tipo localidad
	 */
	public void setTipoLocalidad(String tipoLocalidad) {
		this.tipoLocalidad = tipoLocalidad;
	}

	/**
	 * Obtiene tipo localidad.
	 *
	 * @return tipo localidad
	 */
	public String getTipoLocalidad() {
		return tipoLocalidad;
	}

	/**
	 * Obtiene monto financiado.
	 *
	 * @return the monto_financiado
	 */
	public Double getMontoFinanciado() {
		return montoFinanciado;
	}

	/**
	 * Establece monto financiado.
	 *
	 * @param montoFinanciado a monto financiado
	 */
	public void setMontoFinanciado(Double montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}

	/**
	 * Obtiene monto seguro.
	 *
	 * @return the montoSeguro
	 */
	public java.lang.Double getMontoSeguro() {
		return montoSeguro;
	}

	/**
	 * Establece monto seguro.
	 *
	 * @param montoSeguro the montoSeguro to set
	 */
	public void setMontoSeguro(java.lang.Double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}

	/**
	 * @return the montoSeguroEnfermedad
	 */
	public java.lang.Double getMontoSeguroEnfermedad() {
		return montoSeguroEnfermedad;
	}

	/**
	 * @param montoSeguroEnfermedad the montoSeguroEnfermedad to set
	 */
	public void setMontoSeguroEnfermedad(java.lang.Double montoSeguroEnfermedad) {
		this.montoSeguroEnfermedad = montoSeguroEnfermedad;
	}

	/**
	 * Gets the seguro vida.
	 *
	 * @return the seguro vida
	 */
	public String getSeguroVida() {
		return seguroVida;
	}

	/**
	 * Sets the seguro vida.
	 *
	 * @param seguroVida the new seguro vida
	 */
	public void setSeguroVida(String seguroVida) {
		this.seguroVida = seguroVida;
	}

	/**
	 * Gets the seguro enfermedad.
	 *
	 * @return the seguro enfermedad
	 */
	public String getSeguroEnfermedad() {
		return seguroEnfermedad;
	}

	/**
	 * Sets the seguro enfermedad.
	 *
	 * @param seguroEnfermedad the new seguro enfermedad
	 */
	public void setSeguroEnfermedad(String seguroEnfermedad) {
		this.seguroEnfermedad = seguroEnfermedad;
	}

	/**
	 * Gets the plazo seguro.
	 *
	 * @return the plazo seguro
	 */
	public String getPlazoSeguro() {
		return plazoSeguro;
	}

	/**
	 * Sets the plazo seguro.
	 *
	 * @param plazoSeguro the new plazo seguro
	 */
	public void setPlazoSeguro(String plazoSeguro) {
		this.plazoSeguro = plazoSeguro;
	}

	/**
	 * Gets the existe ben.
	 *
	 * @return the existe ben
	 */
	public Boolean getExisteBen() {
		return existeBen;
	}

	/**
	 * Sets the existe ben.
	 *
	 * @param existeBen the new existe ben
	 */
	public void setExisteBen(Boolean existeBen) {
		this.existeBen = existeBen;
	}

	/**
	 * @return the pctParticipacion
	 */
	public Double getPctParticipacion() {
		return pctParticipacion;
	}

	/**
	 * @param pctParticipacion the pctParticipacion to set
	 */
	public void setPctParticipacion(Double pctParticipacion) {
		this.pctParticipacion = pctParticipacion;
	}

	/**
	 * @return the nombreCompleto
	 */
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	/**
	 * @param nombreCompleto the nombreCompleto to set
	 */
	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	/**
	 * @return the desertorGarantiaAplicar
	 */
	public Double getDesertorGarantiaAplicar() {
		return desertorGarantiaAplicar;
	}

	/**
	 * @param desertorGarantiaAplicar the desertorGarantiaAplicar to set
	 */
	public void setDesertorGarantiaAplicar(Double desertorGarantiaAplicar) {
		this.desertorGarantiaAplicar = desertorGarantiaAplicar;
	}

	/**
	 * @return the desertorDiferenciaPagar
	 */
	public Double getDesertorDiferenciaPagar() {
		return desertorDiferenciaPagar;
	}

	/**
	 * @param desertorDiferenciaPagar the desertorDiferenciaPagar to set
	 */
	public void setDesertorDiferenciaPagar(Double desertorDiferenciaPagar) {
		this.desertorDiferenciaPagar = desertorDiferenciaPagar;
	}

	/**
	 * @return the validaDesertorGarantiaAplicar
	 */
	public Double getValidaDesertorGarantiaAplicar() {
		return validaDesertorGarantiaAplicar;
	}

	/**
	 * @param validaDesertorGarantiaAplicar the validaDesertorGarantiaAplicar to set
	 */
	public void setValidaDesertorGarantiaAplicar(
			Double validaDesertorGarantiaAplicar) {
		this.validaDesertorGarantiaAplicar = validaDesertorGarantiaAplicar;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}

	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the desertor
	 */
	public String getDesertor() {
		return desertor;
	}

	/**
	 * @param desertor the desertor to set
	 */
	public void setDesertor(String desertor) {
		this.desertor = desertor;
	}

	/**
	 * @return the perteneceCreditoRenovar
	 */
	public String getPerteneceCreditoRenovar() {
		return perteneceCreditoRenovar;
	}

	/**
	 * @param perteneceCreditoRenovar the perteneceCreditoRenovar to set
	 */
	public void setPerteneceCreditoRenovar(String perteneceCreditoRenovar) {
		this.perteneceCreditoRenovar = perteneceCreditoRenovar;
	}

}
