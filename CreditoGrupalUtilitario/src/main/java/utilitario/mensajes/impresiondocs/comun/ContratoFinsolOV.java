/**
 * DTO contrato Finsol
 */
package utilitario.mensajes.impresiondocs.comun;

import java.util.List;

import utilitario.mensajes.comun.AmortizacionActualOV;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 * @version 1.0
 */
public class ContratoFinsolOV extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 4674140405357238608L;
	/**
	 * Numero de Contrato
	 */
	private String contrato;
	/**
	 * Numero de ContratoLD
	 */
	private String contratoLD;
	/**
	 * Contrato Anterior
	 */
	private String contratoAnt;
	/**
	 * ContratoLD Anterior
	 */
	private String contratoLDAnt;
	/**
	 * Bandera para saber si es financiado (true/false)
	 */
	private boolean financiado;
	/**
	 * nombre del grupo
	 */
	private String nombreGrupo;
	/**
	 * Cantidad total Credito Grupal
	 */
	private double cantidadTotalCredGrp;
	/**
	 * Numero de ciclo del credito
	 */
	private int ciclo;
	/**
	 * Numero de pagos parciales del credito grupal
	 */
	private int numPagos;
	/**
	 * Cantidad en pesos de cada uno de los pagos parciales que realizara el grupo
	 */
	private double pagoParcialPesos;
	/**
	 * Tasa de interes Anual del Credito grupal
	 */
	private double tasaInteresAnual;
	/**
	 * Numero de semanas del plazo del credito
	 */
	private int numPlazoCredito;
	/**
	 * Numero de dia de la generacion del contrato
	 */
	private String diaGeneraContrato;
	/**
	 * Numero de mes de la generacion del contrato
	 */
	private String mesGeneraContrato;
	/**
	 * Numero de año de la generacion del contrato
	 */
	private String anioGeneraContrato;
	/**
	 * Direccion completa de la sucursal con el formato:
	 * calle + noExterior + noInterior + codigoPostal + colonia
	 * + municipio o ciudad + estado
	 */
	private String direccionSucursal;
	/**
	 * Numero de juegos de impresion de contrato
	 */
	private int juegosImpresion;
	/**
	 * Registro de Contratos de Adhesion (RECA)
	 */
	private String reca;
	/**
	 * Estado donde se encuentra la sucursal
	 */
	private String estadoSucursal;
	/**
	 * Fecha disposicion
	 */
	private String fechaDisposicion;
	/**
	 * Fecha liquidacion
	 */
	private String fechaLiquidacion;
	/**
	 * Nombre apoderado (Gerente de la sucursal)
	 */
	private String apoderado;
	/**
	 * tasa
	 */
	private String tasa;
	/**
	 * cat
	 */
	private String cat;
	/**
	 * Importe pago redondeado
	 */
	private String imptepagored;
	/**
	 * Periodicidad
	 */
	private String periodicidad;
	/**
	 * Dia de pago
	 */
	private String diaPago;
	/**
	 * Leyenda Seguro Vida
	 */
	private String leyendaVidaCaratula;
	/**
	 * Leyenda Seguro Enfermedad
	 */
	private String leyendaEnfermedadCaratula;
	/**
	 * Tipo de producto
	 */
	private String tipoProducto;
	/**
	 * Ciudad
	 */
	private String ciudad;
	/**
	 * Monto total a pagar
	 */
	private double montoTotalPagar;
	/**
	 * Frecuencia pago
	 */
	private String frecuenciaPago;
	/**
	 * Tabla de amortizacion
	 */
	private List<AmortizacionActualOV> amorizaciones;
	/**
	 * Informacion del credito Grupal (Credito comunal y Credito Solidario)
	 */
	private List<CreditoGrupalCSOV> infoCreditoGrupal;
	/**
	 * Informacion del credito oportunidad
	 */
	private List<CreditoOportunidadOV> infoCreditoOportunidad;
	/**
	 * Informacion para la carta instruccion
	 */
	private List<CartaInstruccionOV> infoCartaInstruccion;
	/**
	 * Numero de Paginas
	 */
	private String numeroPagina;
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
	 * @return the contratoAnt
	 */
	public String getContratoAnt() {
		return contratoAnt;
	}
	/**
	 * @param contratoAnt the contratoAnt to set
	 */
	public void setContratoAnt(String contratoAnt) {
		this.contratoAnt = contratoAnt;
	}
	/**
	 * @return the contratoLDAnt
	 */
	public String getContratoLDAnt() {
		return contratoLDAnt;
	}
	/**
	 * @param contratoLDAnt the contratoLDAnt to set
	 */
	public void setContratoLDAnt(String contratoLDAnt) {
		this.contratoLDAnt = contratoLDAnt;
	}
	/**
	 * @return the financiado
	 */
	public boolean isFinanciado() {
		return financiado;
	}
	/**
	 * @param financiado the financiado to set
	 */
	public void setFinanciado(boolean financiado) {
		this.financiado = financiado;
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
	 * @return the cantidadTotalCredGrp
	 */
	public double getCantidadTotalCredGrp() {
		return cantidadTotalCredGrp;
	}
	/**
	 * @param cantidadTotalCredGrp the cantidadTotalCredGrp to set
	 */
	public void setCantidadTotalCredGrp(double cantidadTotalCredGrp) {
		this.cantidadTotalCredGrp = cantidadTotalCredGrp;
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
	 * @return the numPagos
	 */
	public int getNumPagos() {
		return numPagos;
	}
	/**
	 * @param numPagos the numPagos to set
	 */
	public void setNumPagos(int numPagos) {
		this.numPagos = numPagos;
	}
	/**
	 * @return the pagoParcialPesos
	 */
	public double getPagoParcialPesos() {
		return pagoParcialPesos;
	}
	/**
	 * @param pagoParcialPesos the pagoParcialPesos to set
	 */
	public void setPagoParcialPesos(double pagoParcialPesos) {
		this.pagoParcialPesos = pagoParcialPesos;
	}
	/**
	 * @return the tasaInteresAnual
	 */
	public double getTasaInteresAnual() {
		return tasaInteresAnual;
	}
	/**
	 * @param tasaInteresAnual the tasaInteresAnual to set
	 */
	public void setTasaInteresAnual(double tasaInteresAnual) {
		this.tasaInteresAnual = tasaInteresAnual;
	}
	/**
	 * @return the numPlazoCredito
	 */
	public int getNumPlazoCredito() {
		return numPlazoCredito;
	}
	/**
	 * @param numPlazoCredito the numPlazoCredito to set
	 */
	public void setNumPlazoCredito(int numPlazoCredito) {
		this.numPlazoCredito = numPlazoCredito;
	}
	/**
	 * @return the diaGeneraContrato
	 */
	public String getDiaGeneraContrato() {
		return diaGeneraContrato;
	}
	/**
	 * @param diaGeneraContrato the diaGeneraContrato to set
	 */
	public void setDiaGeneraContrato(String diaGeneraContrato) {
		this.diaGeneraContrato = diaGeneraContrato;
	}
	/**
	 * @return the mesGeneraContrato
	 */
	public String getMesGeneraContrato() {
		return mesGeneraContrato;
	}
	/**
	 * @param mesGeneraContrato the mesGeneraContrato to set
	 */
	public void setMesGeneraContrato(String mesGeneraContrato) {
		this.mesGeneraContrato = mesGeneraContrato;
	}
	/**
	 * @return the anioGeneraContrato
	 */
	public String getAnioGeneraContrato() {
		return anioGeneraContrato;
	}
	/**
	 * @param anioGeneraContrato the anioGeneraContrato to set
	 */
	public void setAnioGeneraContrato(String anioGeneraContrato) {
		this.anioGeneraContrato = anioGeneraContrato;
	}
	/**
	 * @return the direccionSucursal
	 */
	public String getDireccionSucursal() {
		return direccionSucursal;
	}
	/**
	 * @param direccionSucursal the direccionSucursal to set
	 */
	public void setDireccionSucursal(String direccionSucursal) {
		this.direccionSucursal = direccionSucursal;
	}
	/**
	 * @return the juegosImpresion
	 */
	public int getJuegosImpresion() {
		return juegosImpresion;
	}
	/**
	 * @param juegosImpresion the juegosImpresion to set
	 */
	public void setJuegosImpresion(int juegosImpresion) {
		this.juegosImpresion = juegosImpresion;
	}
	/**
	 * @return the reca
	 */
	public String getReca() {
		return reca;
	}
	/**
	 * @param reca the reca to set
	 */
	public void setReca(String reca) {
		this.reca = reca;
	}
	/**
	 * @return the estadoSucursal
	 */
	public String getEstadoSucursal() {
		return estadoSucursal;
	}
	/**
	 * @param estadoSucursal the estadoSucursal to set
	 */
	public void setEstadoSucursal(String estadoSucursal) {
		this.estadoSucursal = estadoSucursal;
	}
	/**
	 * @return the fechaDisposicion
	 */
	public String getFechaDisposicion() {
		return fechaDisposicion;
	}
	/**
	 * @param fechaDisposicion the fechaDisposicion to set
	 */
	public void setFechaDisposicion(String fechaDisposicion) {
		this.fechaDisposicion = fechaDisposicion;
	}
	/**
	 * @return the fechaLiquidacion
	 */
	public String getFechaLiquidacion() {
		return fechaLiquidacion;
	}
	/**
	 * @param fechaLiquidacion the fechaLiquidacion to set
	 */
	public void setFechaLiquidacion(String fechaLiquidacion) {
		this.fechaLiquidacion = fechaLiquidacion;
	}
	/**
	 * @return the apoderado
	 */
	public String getApoderado() {
		return apoderado;
	}
	/**
	 * @param apoderado the apoderado to set
	 */
	public void setApoderado(String apoderado) {
		this.apoderado = apoderado;
	}
	/**
	 * @return the infoCreditoGrupal
	 */
	public List<CreditoGrupalCSOV> getInfoCreditoGrupal() {
		return infoCreditoGrupal;
	}
	/**
	 * @param infoCreditoGrupal the infoCreditoGrupal to set
	 */
	public void setInfoCreditoGrupal(List<CreditoGrupalCSOV> infoCreditoGrupal) {
		this.infoCreditoGrupal = infoCreditoGrupal;
	}
	/**
	 * @return the infoCreditoOportunidad
	 */
	public List<CreditoOportunidadOV> getInfoCreditoOportunidad() {
		return infoCreditoOportunidad;
	}
	/**
	 * @param infoCreditoOportunidad the infoCreditoOportunidad to set
	 */
	public void setInfoCreditoOportunidad(List<CreditoOportunidadOV> infoCreditoOportunidad) {
		this.infoCreditoOportunidad = infoCreditoOportunidad;
	}
	/**
	 * @return the infoCartaInstruccion
	 */
	public List<CartaInstruccionOV> getInfoCartaInstruccion() {
		return infoCartaInstruccion;
	}
	/**
	 * @param infoCartaInstruccion the infoCartaInstruccion to set
	 */
	public void setInfoCartaInstruccion(List<CartaInstruccionOV> infoCartaInstruccion) {
		this.infoCartaInstruccion = infoCartaInstruccion;
	}
	/**
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}
	/**
	 * @param tasa the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}
	/**
	 * @return the cat
	 */
	public String getCat() {
		return cat;
	}
	/**
	 * @param cat the cat to set
	 */
	public void setCat(String cat) {
		this.cat = cat;
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
	 * @return the periodicidad
	 */
	public String getPeriodicidad() {
		return periodicidad;
	}
	/**
	 * @param periodicidad the periodicidad to set
	 */
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
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
	 * @return the leyendaVidaCaratula
	 */
	public String getLeyendaVidaCaratula() {
		return leyendaVidaCaratula;
	}
	/**
	 * @param leyendaVidaCaratula the leyendaVidaCaratula to set
	 */
	public void setLeyendaVidaCaratula(String leyendaVidaCaratula) {
		this.leyendaVidaCaratula = leyendaVidaCaratula;
	}
	/**
	 * @return the leyendaEnfermedadCaratula
	 */
	public String getLeyendaEnfermedadCaratula() {
		return leyendaEnfermedadCaratula;
	}
	/**
	 * @param leyendaEnfermedadCaratula the leyendaEnfermedadCaratula to set
	 */
	public void setLeyendaEnfermedadCaratula(String leyendaEnfermedadCaratula) {
		this.leyendaEnfermedadCaratula = leyendaEnfermedadCaratula;
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
	 * @return the amorizaciones
	 */
	public List<AmortizacionActualOV> getAmorizaciones() {
		return amorizaciones;
	}
	/**
	 * @param amorizaciones the amorizaciones to set
	 */
	public void setAmorizaciones(List<AmortizacionActualOV> amorizaciones) {
		this.amorizaciones = amorizaciones;
	}
	/**
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}
	/**
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	/**
	 * @return the montoTotalPagar
	 */
	public double getMontoTotalPagar() {
		return montoTotalPagar;
	}
	/**
	 * @param montoTotalPagar the montoTotalPagar to set
	 */
	public void setMontoTotalPagar(double montoTotalPagar) {
		this.montoTotalPagar = montoTotalPagar;
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
	 * @return the numeroPagina
	 */
	public String getNumeroPagina() {
		return numeroPagina;
	}
	/**
	 * @param numeroPagina the numeroPagina to set
	 */
	public void setNumeroPagina(String numeroPagina) {
		this.numeroPagina = numeroPagina;
	}
}
