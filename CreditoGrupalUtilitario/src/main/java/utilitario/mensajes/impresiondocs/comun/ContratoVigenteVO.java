package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ContratoVigenteVO.
 */
public class ContratoVigenteVO extends ObjetoValor {

	/**
	 * ContratoVigenteVO.
	 */
	public ContratoVigenteVO() {

	}

	/** Se genero serial unico. */
	private static final long serialVersionUID = 3751917324704915021L;

	/** contrato String. */
	private String contrato;

	/** producto String. */
	private String producto;

	/** contratoLD String. */
	private String contratoLD;
	/**
	 * fechaDesembolso java.util.Date
	 */
	private java.util.Date fechaDesembolso;

	/** fechaDesembolsoFormato String. */
	private String fechaDesembolsoFormato;

	/** nombreGrupo String. */
	private String nombreGrupo;

	/** contratoVigente String. */
	private String contratoVigente;

	/** monto Double. */
	private Double monto;

	/** montoLetra String. */
	private String montoLetra;

	/** efectivo Double. */
	private Double efectivo;

	/** tasa Double. */
	private Double tasa;

	/** plazo Integer. */
	private Integer plazo;

	/** adeudo Double. */
	private Double adeudo;

	/** adeudoLetra String. */
	private String adeudoLetra;

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
	 * Obtiene contrato ld.
	 *
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Obtiene fecha desembolso.
	 *
	 * @return the fechaDesembolso
	 */
	public java.util.Date getFechaDesembolso() {
		return fechaDesembolso;
	}

	/**
	 * Establece fecha desembolso.
	 *
	 * @param fechaDesembolso the fechaDesembolso to set
	 */
	public void setFechaDesembolso(java.util.Date fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	/**
	 * Obtiene fecha desembolso formato.
	 *
	 * @return the fechaDesembolsoFormato
	 */
	public String getFechaDesembolsoFormato() {
		return fechaDesembolsoFormato;
	}

	/**
	 * Establece fecha desembolso formato.
	 *
	 * @param fechaDesembolsoFormato the fechaDesembolsoFormato to set
	 */
	public void setFechaDesembolsoFormato(String fechaDesembolsoFormato) {
		this.fechaDesembolsoFormato = fechaDesembolsoFormato;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene contrato vigente.
	 *
	 * @return the contratoVigente
	 */
	public String getContratoVigente() {
		return contratoVigente;
	}

	/**
	 * Establece contrato vigente.
	 *
	 * @param contratoVigente the contratoVigente to set
	 */
	public void setContratoVigente(String contratoVigente) {
		this.contratoVigente = contratoVigente;
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
	 * Obtiene monto letra.
	 *
	 * @return the montoLetra
	 */
	public String getMontoLetra() {
		return montoLetra;
	}

	/**
	 * Establece monto letra.
	 *
	 * @param montoLetra the montoLetra to set
	 */
	public void setMontoLetra(String montoLetra) {
		this.montoLetra = montoLetra;
	}

	/**
	 * Obtiene efectivo.
	 *
	 * @return the efectivo
	 */
	public Double getEfectivo() {
		return efectivo;
	}

	/**
	 * Establece efectivo.
	 *
	 * @param efectivo the efectivo to set
	 */
	public void setEfectivo(Double efectivo) {
		this.efectivo = efectivo;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene adeudo.
	 *
	 * @return the adeudo
	 */
	public Double getAdeudo() {
		return adeudo;
	}

	/**
	 * Establece adeudo.
	 *
	 * @param adeudo the adeudo to set
	 */
	public void setAdeudo(Double adeudo) {
		this.adeudo = adeudo;
	}

	/**
	 * Obtiene adeudo letra.
	 *
	 * @return the adeudoLetra
	 */
	public String getAdeudoLetra() {
		return adeudoLetra;
	}

	/**
	 * Establece adeudo letra.
	 *
	 * @param adeudoLetra the adeudoLetra to set
	 */
	public void setAdeudoLetra(String adeudoLetra) {
		this.adeudoLetra = adeudoLetra;
	}
}
