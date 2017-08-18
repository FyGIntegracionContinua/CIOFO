package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * clase que contendra la informacion de los creditos anteriores
 * @author rmontellano
 * @version 4.16
 */
public class InformacionContratosAnteriores extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1645187349005534032L;

	/**ciclos anteriores*/
	private int ciclo;

	/**LD anteriores*/
	private String contratoLd;

	/** numero de la solicitud anterior*/
	private String solicitudAnterior;

	/**productos anteriores*/
	private String producto;

	/**campanas anteriores*/
	private String campana;

	/**tasa anual anteriores*/
	private float tasaAnual;

	/**% garantia anteriores*/
	private int pctGarantia;

	/**montos anteriores*/
	private double monto;

	/**plazos anteriores*/
	private int plazo;

	/**Frecuencia de pago anteriores*/
	private String frecuencia;

	/**No.Integrantes anteriores*/
	private int numIntegrantes;

	/**Nombre de asesores anteriores*/
	private String nombreAsesor;

	/**nivel de estrellas de los asesores anteriores*/
	private int nivelEstrellaAsesor;

	/**pagos realizados anteriores*/
	private Integer pagosRealizados;

	/**pagos faltantes*/
	private Integer pagosFaltantes;

	/**Estatus de los contratos anteriores*/
	private String estatusContrato;

	/**dias maximo atraso en contratos anteriores*/
	private Integer diasMaximoAtraso;

	/**the estadoCuenta. */
	private String estadoCuenta;

	/**The urlEstadoCuenta. */
	private String urlEstadoCuenta;

	/**The urlBuroHistorico. */
	private String urlBuroHistorico;

	/**The urlIconoPdf */
	private String urlIconoPdf;

	/**The personaAutoriza. */
	 private String personaAutoriza;

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
	 * @return the contratoLd
	 */
	public String getContratoLd() {
		return contratoLd;
	}



	/**
	 * @param contratoLd the contratoLd to set
	 */
	public void setContratoLd(String contratoLd) {
		if (contratoLd == null) {
			this.contratoLd = "-";
		} else {
			this.contratoLd = contratoLd;
		}
		
	}



	/**
	 * @return the solicitudAnterior
	 */
	public String getSolicitudAnterior() {
		return solicitudAnterior;
	}



	/**
	 * @param solicitudAnterior the solicitudAnterior to set
	 */
	public void setSolicitudAnterior(String solicitudAnterior) {
		this.solicitudAnterior = solicitudAnterior;
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
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}



	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}



	/**
	 * @return the tasaAnual
	 */
	public float getTasaAnual() {
		return tasaAnual;
	}



	/**
	 * @param tasaAnual the tasaAnual to set
	 */
	public void setTasaAnual(float tasaAnual) {
		this.tasaAnual = tasaAnual;
	}



	/**
	 * @return the pctGarantia
	 */
	public int getPctGarantia() {
		return pctGarantia;
	}



	/**
	 * @param pctGarantia the pctGarantia to set
	 */
	public void setPctGarantia(int pctGarantia) {
		this.pctGarantia = pctGarantia;
	}



	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}



	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
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
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}



	/**
	 * @param frecuencia the frecuencia to set
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}



	/**
	 * @return the numIntegrantes
	 */
	public int getNumIntegrantes() {
		return numIntegrantes;
	}



	/**
	 * @param numIntegrantes the numIntegrantes to set
	 */
	public void setNumIntegrantes(int numIntegrantes) {
		this.numIntegrantes = numIntegrantes;
	}



	/**
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}



	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}



	/**
	 * @return the nivelEstrellaAsesor
	 */
	public int getNivelEstrellaAsesor() {
		return nivelEstrellaAsesor;
	}



	/**
	 * @param nivelEstrellaAsesor the nivelEstrellaAsesor to set
	 */
	public void setNivelEstrellaAsesor(int nivelEstrellaAsesor) {
		this.nivelEstrellaAsesor = nivelEstrellaAsesor;
	}



	/**
	 * @return the pagosRealizados
	 */
	public Integer getPagosRealizados() {
		return pagosRealizados;
	}



	/**
	 * @param pagosRealizados the pagosRealizados to set
	 */
	public void setPagosRealizados(Integer pagosRealizados) {
		this.pagosRealizados = pagosRealizados;
	}



	/**
	 * @return the pagosFaltantes
	 */
	public Integer getPagosFaltantes() {
		return pagosFaltantes;
	}



	/**
	 * @param pagosFaltantes the pagosFaltantes to set
	 */
	public void setPagosFaltantes(Integer pagosFaltantes) {
		this.pagosFaltantes = pagosFaltantes;
	}



	/**
	 * @return the estatusContrato
	 */
	public String getEstatusContrato() {
		return estatusContrato;
	}



	/**
	 * @param estatusContrato the estatusContrato to set
	 */
	public void setEstatusContrato(String estatusContrato) {
		if (estatusContrato == null) {
			this.estatusContrato = "-";
		} else {
			this.estatusContrato = estatusContrato;
		}
	}



	/**
	 * @return the diasMaximoAtraso
	 */
	public Integer getDiasMaximoAtraso() {
		return diasMaximoAtraso;
	}



	/**
	 * @param diasMaximoAtraso the diasMaximoAtraso to set
	 */
	public void setDiasMaximoAtraso(Integer diasMaximoAtraso) {
		this.diasMaximoAtraso = diasMaximoAtraso;
	}



	/**
	 * @return the estadoCuenta
	 */
	public String getEstadoCuenta() {
		return estadoCuenta;
	}

	/**
	 * @param estadoCuenta the estadoCuenta to set
	 */
	public void setEstadoCuenta(String estadoCuenta) {
		this.estadoCuenta = estadoCuenta;
	}

	/**
	 * @return the urlEstadoCuenta
	 */
	public String getUrlEstadoCuenta() {
		return urlEstadoCuenta;
	}

	/**
	 * @param urlEstadoCuenta the urlEstadoCuenta to set
	 */
	public void setUrlEstadoCuenta(String urlEstadoCuenta) {
		this.urlEstadoCuenta = urlEstadoCuenta;
	}

	/**
	 * @return the urlBuroHistorico
	 */
	public String getUrlBuroHistorico() {
		return urlBuroHistorico;
	}

	/**
	 * @param urlBuroHistorico the urlBuroHistorico to set
	 */
	public void setUrlBuroHistorico(String urlBuroHistorico) {
		this.urlBuroHistorico = urlBuroHistorico;
	}

	/**
	 * @return the urlIconoPdf
	 */
	public String getUrlIconoPdf() {
		return urlIconoPdf;
	}

	/**
	 * @param urlIconoPdf the urlIconoPdf to set
	 */
	public void setUrlIconoPdf(String urlIconoPdf) {
		this.urlIconoPdf = urlIconoPdf;
	}

	/**
	 * @return the personaAutoriza
	 */
	public String getPersonaAutoriza() {
		return personaAutoriza;
	}

	/**
	 * @param personaAutoriza the personaAutoriza to set
	 */
	public void setPersonaAutoriza(String personaAutoriza) {
		this.personaAutoriza = personaAutoriza;
	}



	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		return "ciclo: " + ciclo + "\t contratoLd: " + contratoLd + "\t producto: " + producto
			 + "\t campana: " + campana + "\t tasaAnual: " + tasaAnual + "\t porcentajeGarantia: "
			 + pctGarantia + "\t monto: " + monto + "\t plazo: " + plazo + "\t frecuencia: "
			 + frecuencia + "\t numIntegrantes: " + numIntegrantes + "\t nombreAsesor: " + nombreAsesor
			 + "\t nivelEstrellaAsesor: " + nivelEstrellaAsesor + "\t pagosRealizados: " + pagosRealizados
			 + "\t pagosFaltantes: " + pagosFaltantes + "\t estatusContrato: " + estatusContrato
			 + "\t diasMaximoAtraso: " + diasMaximoAtraso;
	}



}
