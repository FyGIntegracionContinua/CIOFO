package utilitario.mensajes.originacion.consulta;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class ContratoRenovacionRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5927673370527956172L;
	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;
	/** contrato */
	private String contrato;
	/** contratoLD */
	private String contratoLD;
	/** nombreGrupo */
	private String nombreGrupo;
	/** codigoProducto */
	private String codigoProducto;
	/** producto */
	private String producto;
	/** categoria */
	private String categoria;
	/** ciclo */
	private int ciclo;
	/** fechaDesembolso */
	private String fechaDesembolso;
	/** fechaFin */
	private String fechaFin;
	/** fechaEstimadaLiq */
	private String fechaEstimadaLiq;
	/** fechaProxPago */
	private String fechaProxPago;
	/** saldoCapital */
	private double saldoCapital;
	/** diasMora */
	private int diasMora;
	/** diasMaximoAtraso */
	private int diasMaximoAtraso;
	/** sucursal */
	private int sucursal;
	/** diasFaltantesLiquidacion */
	private int diasFaltantesLiquidacion;
	/** diasFaltantesLiquidacion */
	private boolean mostrarInformacion;
	/** documentos */
	private List<DocumentosKit> documentos;
	/** documentos */
	private List<IntegrantesKit> integrantes;
	/** nombreGerenteSucursal */
	private String nombreGerenteSucursal;
	/** numeroGerenteSucursal */
	private String numeroGerenteSucursal;
	/** nombreGerenteRegional */
	private String nombreGerenteRegional;
	/** numeroGerenteRegional */
	private String numeroGerenteRegional;
	/** nombreAsesorCredito */
	private String nombreAsesorCredito;
	/** numeroAsesor */
	private String numeroAsesor;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
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
	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	/**
	 * @return the codigoProducto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}
	/**
	 * @param codigoProducto the codigoProducto to set
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}
	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}
	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}
	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	/**
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}
	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	/**
	 * @return the fechaDesembolso
	 */
	public String getFechaDesembolso() {
		return fechaDesembolso;
	}
	/**
	 * @param fechaDesembolso the fechaDesembolso to set
	 */
	public void setFechaDesembolso(String fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}
	/**
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}
	/**
	 * @return the fechaEstimadaLiq
	 */
	public String getFechaEstimadaLiq() {
		return fechaEstimadaLiq;
	}
	/**
	 * @param fechaEstimadaLiq the fechaEstimadaLiq to set
	 */
	public void setFechaEstimadaLiq(String fechaEstimadaLiq) {
		this.fechaEstimadaLiq = fechaEstimadaLiq;
	}
	/**
	 * @return the fechaProxPago
	 */
	public String getFechaProxPago() {
		return fechaProxPago;
	}
	/**
	 * @param fechaProxPago the fechaProxPago to set
	 */
	public void setFechaProxPago(String fechaProxPago) {
		this.fechaProxPago = fechaProxPago;
	}
	/**
	 * @return the saldoCapital
	 */
	public double getSaldoCapital() {
		return saldoCapital;
	}
	/**
	 * @param saldoCapital the saldoCapital to set
	 */
	public void setSaldoCapital(double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}
	/**
	 * @return the diasMora
	 */
	public int getDiasMora() {
		return diasMora;
	}
	/**
	 * @param diasMora the diasMora to set
	 */
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}
	/**
	 * @return the diasMaximoAtraso
	 */
	public int getDiasMaximoAtraso() {
		return diasMaximoAtraso;
	}
	/**
	 * @param diasMaximoAtraso the diasMaximoAtraso to set
	 */
	public void setDiasMaximoAtraso(int diasMaximoAtraso) {
		this.diasMaximoAtraso = diasMaximoAtraso;
	}
	/**
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the diasFaltantesLiquidacion
	 */
	public int getDiasFaltantesLiquidacion() {
		return diasFaltantesLiquidacion;
	}
	/**
	 * @param diasFaltantesLiquidacion the diasFaltantesLiquidacion to set
	 */
	public void setDiasFaltantesLiquidacion(int diasFaltantesLiquidacion) {
		this.diasFaltantesLiquidacion = diasFaltantesLiquidacion;
	}
	/**
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}
	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}
	/**
	 * @return the mostrarInformacion
	 */
	public boolean isMostrarInformacion() {
		return mostrarInformacion;
	}
	/**
	 * @param mostrarInformacion the mostrarInformacion to set
	 */
	public void setMostrarInformacion(boolean mostrarInformacion) {
		this.mostrarInformacion = mostrarInformacion;
	}
	/**
	 * @return the documentos
	 */
	public List<DocumentosKit> getDocumentos() {
		return documentos;
	}
	/**
	 * @param documentos the documentos to set
	 */
	public void setDocumentos(List<DocumentosKit> documentos) {
		this.documentos = documentos;
	}
	/**
	 * @return the integrantes
	 */
	public List<IntegrantesKit> getIntegrantes() {
		return integrantes;
	}
	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<IntegrantesKit> integrantes) {
		this.integrantes = integrantes;
	}
	/**
	 * @return the nombreGerenteSucursal
	 */
	public String getNombreGerenteSucursal() {
		return nombreGerenteSucursal;
	}
	/**
	 * @param nombreGerenteSucursal the nombreGerenteSucursal to set
	 */
	public void setNombreGerenteSucursal(String nombreGerenteSucursal) {
		this.nombreGerenteSucursal = nombreGerenteSucursal;
	}
	/**
	 * @return the numeroGerenteSucursal
	 */
	public String getNumeroGerenteSucursal() {
		return numeroGerenteSucursal;
	}
	/**
	 * @param numeroGerenteSucursal the numeroGerenteSucursal to set
	 */
	public void setNumeroGerenteSucursal(String numeroGerenteSucursal) {
		this.numeroGerenteSucursal = numeroGerenteSucursal;
	}
	/**
	 * @return the nombreGerenteRegional
	 */
	public String getNombreGerenteRegional() {
		return nombreGerenteRegional;
	}
	/**
	 * @param nombreGerenteRegional the nombreGerenteRegional to set
	 */
	public void setNombreGerenteRegional(String nombreGerenteRegional) {
		this.nombreGerenteRegional = nombreGerenteRegional;
	}
	/**
	 * @return the numeroGerenteRegional
	 */
	public String getNumeroGerenteRegional() {
		return numeroGerenteRegional;
	}
	/**
	 * @param numeroGerenteRegional the numeroGerenteRegional to set
	 */
	public void setNumeroGerenteRegional(String numeroGerenteRegional) {
		this.numeroGerenteRegional = numeroGerenteRegional;
	}
	/**
	 * @return the nombreAsesorCredito
	 */
	public String getNombreAsesorCredito() {
		return nombreAsesorCredito;
	}
	/**
	 * @param nombreAsesorCredito the nombreAsesorCredito to set
	 */
	public void setNombreAsesorCredito(String nombreAsesorCredito) {
		this.nombreAsesorCredito = nombreAsesorCredito;
	}
	/**
	 * @return the numeroAsesor
	 */
	public String getNumeroAsesor() {
		return numeroAsesor;
	}
	/**
	 * @param numeroAsesor the numeroAsesor to set
	 */
	public void setNumeroAsesor(String numeroAsesor) {
		this.numeroAsesor = numeroAsesor;
	}

}
