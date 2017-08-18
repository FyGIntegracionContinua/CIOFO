package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ContratoRestructuraVO.
 */
public class ContratoRestructuraVO extends ObjetoValor {

	/**
	 * ContratoRestructuraVO.
	 */
	public ContratoRestructuraVO() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 2659243542234395119L;

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

	/** tasa String. */
	private String tasa;

	/** plazo Integer. */
	private Integer plazo;

	/** nombres String. */
	private String nombres;

	/** cat String. */
	private String cat;

	/** dirSucursal String. */
	private String dirSucursal;

	/** cdadFirma String. */
	private String cdadFirma;

	/** sucursal Integer. */
	private Integer sucursal;

	/** nomSucursal String. */
	private String nomSucursal;

	/** nomGerente String. */
	private String nomGerente;

	/** periodo String. */
	private String periodo;

	/** periodicidad String. */
	private String periodicidad;

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
	public String getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(String tasa) {
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
	 * Obtiene nombres.
	 *
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Establece nombres.
	 *
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Obtiene cat.
	 *
	 * @return the cat
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * Establece cat.
	 *
	 * @param cat the cat to set
	 */
	public void setCat(String cat) {
		this.cat = cat;
	}

	/**
	 * Obtiene dir sucursal.
	 *
	 * @return the dirSucursal
	 */
	public String getDirSucursal() {
		return dirSucursal;
	}

	/**
	 * Establece dir sucursal.
	 *
	 * @param dirSucursal the dirSucursal to set
	 */
	public void setDirSucursal(String dirSucursal) {
		this.dirSucursal = dirSucursal;
	}

	/**
	 * Obtiene cdad firma.
	 *
	 * @return the cdadFirma
	 */
	public String getCdadFirma() {
		return cdadFirma;
	}

	/**
	 * Establece cdad firma.
	 *
	 * @param cdadFirma the cdadFirma to set
	 */
	public void setCdadFirma(String cdadFirma) {
		this.cdadFirma = cdadFirma;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene nom sucursal.
	 *
	 * @return the nomSucursal
	 */
	public String getNomSucursal() {
		return nomSucursal;
	}

	/**
	 * Establece nom sucursal.
	 *
	 * @param nomSucursal the nomSucursal to set
	 */
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	/**
	 * Obtiene nom gerente.
	 *
	 * @return the nomGerente
	 */
	public String getNomGerente() {
		return nomGerente;
	}

	/**
	 * Establece nom gerente.
	 *
	 * @param nomGerente the nomGerente to set
	 */
	public void setNomGerente(String nomGerente) {
		this.nomGerente = nomGerente;
	}

	/**
	 * Obtiene periodo.
	 *
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * Establece periodo.
	 *
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * Obtiene periodicidad.
	 *
	 * @return the periodicidad
	 */
	public String getPeriodicidad() {
		return periodicidad;
	}

	/**
	 * Establece periodicidad.
	 *
	 * @param periodicidad the periodicidad to set
	 */
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}



}
