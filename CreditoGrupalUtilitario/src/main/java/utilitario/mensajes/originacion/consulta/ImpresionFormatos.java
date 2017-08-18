package utilitario.mensajes.originacion.consulta;

import java.io.Serializable;
import java.util.List;
/**
 * clase que se hizo para simplificacion de la renovacion
 * @author rmontellano
 * @version 4.10
 */
public class ImpresionFormatos implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 7766388508018445572L;
	/**
	 * numero de sucursal.
	 */
	private int numeroSucursal;
	/**
	 * Indica el nombre de la sucursal.
	 */
	private String sucursal = " ";
	/**
	 * Indica el nombre del grupo.
	 */
	private String nombreGrupo = " ";
	/**
	 * categoria del producto que puede ser comual,
	 * solidario, oprtunidad
	 */
	private String categoriaProducto = " ";
	/**
	 * tipo de producto ya se a comunal, solidario, oportunidad.
	 */
	private String tipoProducto = "";
	/**
	 * Indica el c&oacute;digo del grupo del cr&eacute;dito anterior
	 */
	private String codigoGrupo = " ";
	/**
	 * frecuencia de pago del grupo del cr&eacute;dito anterior.
	 */
	private String frecuenciaPago = " ";
	/**
	 * tasa de Inter&eacute;s Anual .
	 */
	private float tasaInteresAnual;
	/**
	 * Indica el n&uacute;mero de ciclo del grupo + 1,
	 * en la cual se solicitar&aacute; la renovaci&oacute;n de cr&eacute;dito.
	 */
	private int ciclo;
	/**
	 * plazo del cr&eacute;dito actual.
	 */
	private int plazo;
	/**
	 * n&uacute;mero de contrato actual del grupo
	 */
	private String contratoLD = " ";
	/**
	 * nombre del Asesor de Cr&eacute;dito,
	 */
	private String nombreAsesorCredito = " ";
	/**
	 * nombre del Gerente de Sucursal
	 */
	private String nombreGerenteSucursal = " ";
	/**
	 * nombre del Gerente Regional
	 */
	private String nombreGerenteRegional = " ";
	/**
	 * fecha actual en la que se generar&aacute;
	 *  la impresi&oacute;n, con fomato DD/MM/AAAA.
	 */
	private String fechaImpresion = "";
	/**
	 * clientes del contrato
	 */
	private List<ClientesGrupo> clientesA;
	/**
	 * clientes del contrato
	 */
	private List<ClientesGrupo> clientesB;
	/**
	 * directiva del grupo
	 */
	private List<DirectivaGrupo> directiva;
	/**
	 * Indica el monto grupal aprobado del cr&oacute;dito actual.
	 */
	private String montoGrupalAprobado = "0.00";
	/**
	 * Indica el n&oacute;mero de contrato actual del grupo.
	 */
	private String contrato = " ";
	/**
	 * Indica el d&iacute;a de pago del grupo de cr&eacute;dito actual.
	 */
	private String diaPago = " ";
	/**
	 * Indica la fecha fin del cr&eacute;dito actual.
	 */
	private String fechaFin = " ";
	/**
	 * maximoAtraso del credito actual.
	 */
	private int maximoAtraso;
	/**
	 *  Indica el n&uacute;mero de d&iacute;a actual.
	 */
	private String dia = " ";
	/**
	 * Indica el mes (en letra) actual.
	 */
	private String mes = " ";
	/**
	 * Indica el a&ntilde;o actual.
	 */
	private String anio = " ";
	/**
	 * Indica el nombre del presidente / coordinador.
	 */
	private String nombrePresidentaCoordinador = " ";
	/**
	 *Indica el nombre del tesorera
	 */
	private String nombreTesorera = " ";
	/**
	 * Indica el nombre del secretaria
	 */
	private String nombreSecretaria = " ";
	/**
	 * es la fecha de disposicion.
	 */
	private String fechaActual = " ";

	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String sucursal) {
		this.sucursal = sucursal;
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
	 * @return the codigoGrupo
	 */
	public String getCodigoGrupo() {
		return codigoGrupo;
	}
	/**
	 * @param codigoGrupo the codigoGrupo to set
	 */
	public void setCodigoGrupo(String codigoGrupo) {
		this.codigoGrupo = codigoGrupo;
	}
	/**
	 * @return the frecuenciaPago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}
	/**
	 * @param frecuenciaPago the frecuenciaPago to set
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago;
	}
	/**
	 * @return the tasaInteresAnual
	 */
	public float getTasaInteresAnual() {
		return tasaInteresAnual;
	}
	/**
	 * @param tasaInteresAnual the tasaInteresAnual to set
	 */
	public void setTasaInteresAnual(float tasaInteresAnual) {
		this.tasaInteresAnual = tasaInteresAnual;
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
	 * @return the plazo
	 */
	public int getPlazo() {
		return plazo;
	}
	/**
	 * @param plazo the plazo to set
	 */
	public void setPlazo(int plazo) {
		this.plazo = plazo;
	}
	/**
	 * @return the contratoLDAnterior
	 */
	public String getContratoLD() {
		return contratoLD;
	}
	/**
	 * @param contratoLD the contratoLDAnterior to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
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
	 * @return the fechaImpresion
	 */
	public String getFechaImpresion() {
		return fechaImpresion;
	}
	/**
	 * @param fechaImpresion the fechaImpresion to set
	 */
	public void setFechaImpresion(String fechaImpresion) {
		this.fechaImpresion = fechaImpresion;
	}
	/**
	 * @return the clientesA
	 */
	public List<ClientesGrupo> getClientesA() {
		return clientesA;
	}
	/**
	 * @param clientesA the clientesA to set
	 */
	public void setClientesA(List<ClientesGrupo> clientesA) {
		this.clientesA = clientesA;
	}
	/**
	 * @return the clientesB
	 */
	public List<ClientesGrupo> getClientesB() {
		return clientesB;
	}
	/**
	 * @param clientesB the clientesB to set
	 */
	public void setClientesB(List<ClientesGrupo> clientesB) {
		this.clientesB = clientesB;
	}
	/**
	 * @return the directiva
	 */
	public List<DirectivaGrupo> getDirectiva() {
		return directiva;
	}
	/**
	 * @param directiva the directiva to set
	 */
	public void setDirectiva(List<DirectivaGrupo> directiva) {
		this.directiva = directiva;
	}
	/**
	 * @return the numeroSucursal
	 */
	public int getNumeroSucursal() {
		return numeroSucursal;
	}
	/**
	 * @param numeroSucursal the numeroSucursal to set
	 */
	public void setNumeroSucursal(int numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}
	/**
	 * @return the categoriaProducto
	 */
	public String getCategoriaProducto() {
		return categoriaProducto;
	}
	/**
	 * @param categoriaProducto the categoriaProducto to set
	 */
	public void setCategoriaProducto(String categoriaProducto) {
		this.categoriaProducto = categoriaProducto;
	}
	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the montoGrupalAprobado
	 */
	public String getMontoGrupalAprobado() {
		return montoGrupalAprobado;
	}
	/**
	 * @param montoGrupalAprobado the montoGrupalAprobado to set
	 */
	public void setMontoGrupalAprobado(String montoGrupalAprobado) {
		this.montoGrupalAprobado = montoGrupalAprobado;
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
	 * @return the diaPago
	 */
	public String getDiaPago() {
		return diaPago;
	}
	/**
	 * @param diaPago the diaPago to set
	 */
	public void setDiaPago(String diaPago) {
		this.diaPago = diaPago;
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
	 * @return the tipoProducto
	 */
	public String getTipoProducto() {
		return tipoProducto;
	}
	/**
	 * @param tipoProducto the tipoProducto to set
	 */
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	/**
	 * @return the maximoAtraso
	 */
	public int getMaximoAtraso() {
		return maximoAtraso;
	}
	/**
	 * @param maximoAtraso the maximoAtraso to set
	 */
	public void setMaximoAtraso(int maximoAtraso) {
		this.maximoAtraso = maximoAtraso;
	}
	/**
	 * @return the dia
	 */
	public String getDia() {
		return dia;
	}
	/**
	 * @param dia the dia to set
	 */
	public void setDia(String dia) {
		this.dia = dia;
	}
	/**
	 * @return the mes
	 */
	public String getMes() {
		return mes;
	}
	/**
	 * @param mes the mes to set
	 */
	public void setMes(String mes) {
		this.mes = mes;
	}
	/**
	 * @return the anio
	 */
	public String getAnio() {
		return anio;
	}
	/**
	 * @param anio the anio to set
	 */
	public void setAnio(String anio) {
		this.anio = anio;
	}
	/**
	 * @return the nombrePresidentaCoordinador
	 */
	public String getNombrePresidentaCoordinador() {
		return nombrePresidentaCoordinador;
	}
	/**
	 * @param nombrePresidentaCoordinador the nombrePresidentaCoordinador to set
	 */
	public void setNombrePresidentaCoordinador(String nombrePresidentaCoordinador) {
		this.nombrePresidentaCoordinador = nombrePresidentaCoordinador;
	}
	/**
	 * @return the nombreTesorera
	 */
	public String getNombreTesorera() {
		return nombreTesorera;
	}
	/**
	 * @param nombreTesorera the nombreTesorera to set
	 */
	public void setNombreTesorera(String nombreTesorera) {
		this.nombreTesorera = nombreTesorera;
	}
	/**
	 * @return the nombreSecretaria
	 */
	public String getNombreSecretaria() {
		return nombreSecretaria;
	}
	/**
	 * @param nombreSecretaria the nombreSecretaria to set
	 */
	public void setNombreSecretaria(String nombreSecretaria) {
		this.nombreSecretaria = nombreSecretaria;
	}
	/**
	 * @return the fechaActual
	 */
	public String getFechaActual() {
		return fechaActual;
	}
	/**
	 * @param fechaActual the fechaActual to set
	 */
	public void setFechaActual(String fechaActual) {
		this.fechaActual = fechaActual;
	}

}
