/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.contrato;

import java.util.Date;
import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.originacion.grupo.GrupoOV;
import utilitario.mensajes.seguros.BeneficiariosClienteOV;


/**
 * The Class ContratoOV.
 *
 * @author Juan Moreno
 *
 * <ul>
 * 	<li>Numero de Solicitud</li>
 * 	<li>Identificador del grupo</li>
 * 	<li>Ciclo del Grupo</li>
 * 	<li>Numero de la sucursal</li>
 * 	<li>Clave del asesor de credito</li>
 * 	<li>Tipo de credito</li>
 * 	<li>Monto del prestamo</li>
 * 	<li>Tasa de interes</li>
 * 	<li>Frecuencia de pago</li>
 * 	<li>Fecha esperada de liquidacion del contrato</li>
 * 	<li>Fecha de contrato</li>
 * </ul>
 */
public final class ContratoOV extends ObjetoValor {

	/** long serialVersionUID. */
	private static final long	serialVersionUID	= 1L;

 	/**
 	 * java.lang.Integer sucursal
 	 */
 	private java.lang.Integer 	sucursal;	//12+substring(MIS.ACCT.OFFICER, 0,3)
 	/**
 	 * java.lang.String asesor
 	 */
 	private java.lang.String  	asesor;		//MIS.ACCT.OFFICER
	/**
	 * java.lang.String producto
	 */
	private java.lang.String  	producto;	//CATEGORY quitar el primer 2, substring(1,length)
	/**
	 * java.lang.Double monto_otorgado
	 */
	private java.lang.Double  	monto_otorgado;		//AMOUNT.APPROVED
	/**
	 * java.lang.Double montoFinanciado
	 */
	private java.lang.Double  	montoFinanciado;
	/**
	 * java.lang.String contratoActual
	 */
	private java.lang.String  	contratoActual;		//Campo para almacenar el contrato anterior
	/**
	 * java.lang.Double tasa
	 */
	private java.lang.Double  	tasa;		//INT.RATE
	/**
	 * java.lang.String frecuencia
	 */
	private java.lang.String  	frecuencia;		//INTEREST.FREQ hacer conversion w->S, f->C, m->M
	/**
	 * java.util.Date fecha_esp_liquidacion
	 */
	private java.util.Date 	  	fecha_esp_liquidacion;			//FIN.MAT.DATE
	/**
	 * java.util.Date fecha_contrato
	 */
	private java.util.Date 	  	fecha_contrato;					//AGREEMENT.DATE
	/**
	 * java.lang.Integer plazo
	 */
	private java.lang.Integer 	plazo;							//TERM.(WEEKS)
	/**
	 * java.util.Date fecha_desembolso
	 */
	private java.util.Date 	  	fecha_desembolso;				//VALUE.DATE

	/** GrupoOV grupo. */
	private GrupoOV			  	grupo;		//Se llena con datos del credito
 	/**
 	 * java.lang.String hora_reunion
 	 */
 	private java.lang.String  	hora_reunion;					//HOUR.OF.MEETING
 	/**
 	 * java.lang.Integer dia_reunion
 	 */
 	private java.lang.Integer 	dia_reunion;					//DAY.OF.MEETING
 	/**
 	 * java.lang.Integer diaPago
 	 */
 	private java.lang.Integer 	diaPago;						//Utilizado para el dia ancla
	/**
	 * java.lang.Boolean renovacion
	 */
	private java.lang.Boolean 	renovacion;						//RENOVACIONES 0 false else true

	/** IntegranteOV[] integrantes. */
	private IntegranteOV[]    	integrantes;

	/** String peticion_ofs. */
	private String peticion_ofs;
	/**
	 * java.lang.Double montoGarantia
	 */
	private java.lang.Double 	montoGarantia;
	/**
	 * java.lang.String hora_reunion_fin
	 */
	private java.lang.String  	hora_reunion_fin;
	/**
	 * java.lang.String numero_cliente_reunion
	 */
	private java.lang.String  	numero_cliente_reunion;

	//MMH 2013-10-29 Seguros Finsol
	/**
	 * java.lang.Double montoSeguro
	 */
	private java.lang.Double 	montoSeguroEnfermedad;

	//MMH 2013-10-14 Seguros Finsol Enfermedad
	/**
	 * java.lang.Double montoSeguro
	 */
	private java.lang.Double 	montoSeguro;

	//MMH 2014-09-08 Almacenar numero solicitud contratos
	/**
	 * java.lang.String solicitud
	 */
	private java.lang.String  	solicitud;

	//Movimientos Deposito Garantia ***

	/** The pct garantia. */
	private Integer pctGarantia;

	/** The fecha maxima. */
	private Date fechaMaxima;

	/** The renovacion financiada. */
	private Boolean renovacionFinanciada;

	/** The status. */
	private String status;

	/** The beneficiarios. */
	private List<BeneficiariosClienteOV> beneficiarioCliente;

	/** The usuario. */
	private String usuario;

	/** The integrantes list. */
	private List<IntegranteOV> integrantesList;

	/** The codigo producto. */
	private String codProducto;

	/** The saldo garantia. */
	private Double saldoGarantia;

	/** The traspaso garantia. */
	private String traspasoGarantia;

	/** The contratoRenovacion. */
	private String contratoRenovacion;

	/** The justificacionExc. */
	private String justificacionExc;

	/** The aplicar garantia. */
	private String aplicarGarantia;

	/** The aplicar garantia desertor. */
	private String aplicarGarantiaDesertor;

	/** The medio pago. */
	private String medioPago;

	/** The pago garantia. */
	private boolean pagoGarantia;

	/** LRSS ORIG-276 The justificación excepción documental */
	private String justificacionExcepcionDocumental;

	/** LRSS ORIG-276 enviarDocumental */
	private boolean enviarDocumental;

	/**
	 * ContratoOV.
	 */
	public ContratoOV()	{
		montoFinanciado = 0.0;
	}

	/**
	 * Obtiene peticion_ofs.
	 *
	 * @return the peticion_ofs
	 */
	public String getPeticion_ofs() {
		return peticion_ofs;
	}

	/**
	 * Establece peticion_ofs.
	 *
	 * @param peticion_ofs the peticion_ofs to set
	 */
	public void setPeticion_ofs(String peticion_ofs) {
		this.peticion_ofs = peticion_ofs;
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
	 * Obtiene asesor.
	 *
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}

	/**
	 * Establece asesor.
	 *
	 * @param asesor the asesor to set
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
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
	 * Obtiene monto_otorgado.
	 *
	 * @return the monto_otorgado
	 */
	public Double getMonto_otorgado() {
		return monto_otorgado;
	}

	/**
	 * Establece monto_otorgado.
	 *
	 * @param monto_otorgado the monto_otorgado to set
	 */
	public void setMonto_otorgado(Double monto_otorgado) {
		this.monto_otorgado = monto_otorgado;
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
	 * Obtiene fecha_esp_liquidacion.
	 *
	 * @return the fecha_esp_liquidacion
	 */
	public Date getFecha_esp_liquidacion() {
		return fecha_esp_liquidacion;
	}

	/**
	 * Establece fecha_esp_liquidacion.
	 *
	 * @param fecha_esp_liquidacion the fecha_esp_liquidacion to set
	 */
	public void setFecha_esp_liquidacion(Date fecha_esp_liquidacion) {
		this.fecha_esp_liquidacion = fecha_esp_liquidacion;
	}

	/**
	 * Obtiene fecha_contrato.
	 *
	 * @return the fecha_contrato
	 */
	public Date getFecha_contrato() {
		return fecha_contrato;
	}

	/**
	 * Establece fecha_contrato.
	 *
	 * @param fecha_contrato the fecha_contrato to set
	 */
	public void setFecha_contrato(Date fecha_contrato) {
		this.fecha_contrato = fecha_contrato;
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
	 * Obtiene fecha_desembolso.
	 *
	 * @return the fecha_desembolso
	 */
	public Date getFecha_desembolso() {
		return fecha_desembolso;
	}

	/**
	 * Establece fecha_desembolso.
	 *
	 * @param fecha_desembolso the fecha_desembolso to set
	 */
	public void setFecha_desembolso(Date fecha_desembolso) {
		this.fecha_desembolso = fecha_desembolso;
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public GrupoOV getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(GrupoOV grupo) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene hora_reunion.
	 *
	 * @return the hora_inicio_reunion
	 */
	public String getHora_reunion() {
		return hora_reunion;
	}

	/**
	 * Establece hora_reunion.
	 *
	 * @param hora_reunion the hora_reunion to set
	 */
	public void setHora_reunion(String hora_reunion) {
		this.hora_reunion = hora_reunion;
	}

	/**
	 * Obtiene dia_reunion.
	 *
	 * @return the dia_reunion
	 */
	public Integer getDia_reunion() {
		return dia_reunion;
	}

	/**
	 * Establece dia_reunion.
	 *
	 * @param dia_reunion the dia_reunion to set
	 */
	public void setDia_reunion(Integer dia_reunion) {
		this.dia_reunion = dia_reunion;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return the integrantes
	 */
	public IntegranteOV[] getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(IntegranteOV[] integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Obtiene monto financiado.
	 *
	 * @return the montoFinanciado
	 */
	public Double getMontoFinanciado() {
		return montoFinanciado;
	}

	/**
	 * Establece monto financiado.
	 *
	 * @param montoFinanciado the montoFinanciado to set
	 */
	public void setMontoFinanciado(Double montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}

	/**
	 * Obtiene contrato actual.
	 *
	 * @return the contratoActual
	 */
	public String getContratoActual() {
		return contratoActual;
	}

	/**
	 * Establece contrato actual.
	 *
	 * @param contratoActual the contratoActual to set
	 */
	public void setContratoActual(String contratoActual) {
		this.contratoActual = contratoActual;
	}

	/**
	 * Checks if is renovacion.
	 *
	 * @return the renovacion
	 */
	public java.lang.Boolean isRenovacion() {
		return renovacion;
	}

	/**
	 * Establece renovacion.
	 *
	 * @param renovacion the renovacion to set
	 */
	public void setRenovacion(java.lang.Boolean renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * Obtiene dia pago.
	 *
	 * @return the diaPago
	 */
	public java.lang.Integer getDiaPago() {
		return diaPago;
	}

	/**
	 * Establece dia pago.
	 *
	 * @param diaPago the diaPago to set
	 */
	public void setDiaPago(java.lang.Integer diaPago) {
		this.diaPago = diaPago;
	}


	/**
	 * Obtiene monto garantia.
	 *
	 * @return getMontoGarantia :
	 */
	public java.lang.Double getMontoGarantia() {
		return montoGarantia;
	}


	/**
	 * Establece monto garantia.
	 *
	 * @param montoGarantia setMontoGarantia :
	 */
	public void setMontoGarantia(java.lang.Double montoGarantia) {
		this.montoGarantia = montoGarantia;
	}


	/**
	 * Obtiene hora_reunion_fin.
	 *
	 * @return the hora_reunion_fin
	 */
	public java.lang.String getHora_reunion_fin() {
		return hora_reunion_fin;
	}


	/**
	 * Establece hora_reunion_fin.
	 *
	 * @param hora_reunion_fin the hora_reunion_fin to set
	 */
	public void setHora_reunion_fin(java.lang.String hora_reunion_fin) {
		this.hora_reunion_fin = hora_reunion_fin;
	}


	/**
	 * Obtiene numero_cliente_reunion.
	 *
	 * @return the numero_cliente_reunion
	 */
	public java.lang.String getNumero_cliente_reunion() {
		return numero_cliente_reunion;
	}


	/**
	 * Establece numero_cliente_reunion.
	 *
	 * @param numero_cliente_reunion the numero_cliente_reunion to set
	 */
	public void setNumero_cliente_reunion(java.lang.String numero_cliente_reunion) {
		this.numero_cliente_reunion = numero_cliente_reunion;
	}


	/**
	 * Obtiene renovacion.
	 *
	 * @return the renovacion
	 */
	public java.lang.Boolean getRenovacion() {
		return renovacion;
	}


	/**
	 * Obtiene monto seguro.
	 *
	 * @return monto seguro
	 */
	public java.lang.Double getMontoSeguro() {
		return montoSeguro;
	}


	/**
	 * Establece monto seguro.
	 *
	 * @param montoSeguro a monto seguro
	 */
	public void setMontoSeguro(java.lang.Double montoSeguro) {
		this.montoSeguro = montoSeguro;
	}


	/**
	 * @return the solicitud
	 */
	public java.lang.String getSolicitud() {
		return solicitud;
	}


	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(java.lang.String solicitud) {
		this.solicitud = solicitud;
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
	 * Gets the pct garantia.
	 *
	 * @return the pct garantia
	 */
	public Integer getPctGarantia() {
		return pctGarantia;
	}


	/**
	 * Sets the pct garantia.
	 *
	 * @param pctGarantia the new pct garantia
	 */
	public void setPctGarantia(Integer pctGarantia) {
		this.pctGarantia = pctGarantia;
	}

	/**
	 * @return the fechaMaxima
	 */
	public Date getFechaMaxima() {
		return fechaMaxima;
	}

	/**
	 * @param fechaMaxima the fechaMaxima to set
	 */
	public void setFechaMaxima(Date fechaMaxima) {
		this.fechaMaxima = fechaMaxima;
	}

	/**
	 * @return the renovacionFinanciada
	 */
	public Boolean getRenovacionFinanciada() {
		return renovacionFinanciada;
	}

	/**
	 * @param renovacionFinanciada the renovacionFinanciada to set
	 */
	public void setRenovacionFinanciada(Boolean renovacionFinanciada) {
		this.renovacionFinanciada = renovacionFinanciada;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the beneficiarioCliente
	 */
	public List<BeneficiariosClienteOV> getBeneficiarioCliente() {
		return beneficiarioCliente;
	}

	/**
	 * @param beneficiarioCliente the beneficiarioCliente to set
	 */
	public void setBeneficiarioCliente(List<BeneficiariosClienteOV> beneficiarioCliente) {
		this.beneficiarioCliente = beneficiarioCliente;
	}

	/**
	 * @return the integrantesList
	 */
	public List<IntegranteOV> getIntegrantesList() {
		return integrantesList;
	}

	/**
	 * @param integrantesList the integrantesList to set
	 */
	public void setIntegrantesList(List<IntegranteOV> integrantesList) {
		this.integrantesList = integrantesList;
	}

	/**
	 * @return the codProducto
	 */
	public String getCodProducto() {
		return codProducto;
	}

	/**
	 * @param codProducto the codProducto to set
	 */
	public void setCodProducto(String codProducto) {
		this.codProducto = codProducto;
	}

	/**
	 * Gets the saldo garantia.
	 *
	 * @return the saldo garantia
	 */
	public Double getSaldoGarantia() {
		return saldoGarantia;
	}

	/**
	 * Sets the saldo garantia.
	 *
	 * @param saldoGarantia the new saldo garantia
	 */
	public void setSaldoGarantia(Double saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
	}

	/**
	 * @return the traspasoGarantia
	 */
	public String getTraspasoGarantia() {
		return traspasoGarantia;
	}

	/**
	 * @param traspasoGarantia the traspasoGarantia to set
	 */
	public void setTraspasoGarantia(String traspasoGarantia) {
		this.traspasoGarantia = traspasoGarantia;
	}

	/**
	 * @return the contratoRenovacion
	 */
	public String getContratoRenovacion() {
		return contratoRenovacion;
	}

	/**
	 * @param contratoRenovacion the contratoRenovacion to set
	 */
	public void setContratoRenovacion(String contratoRenovacion) {
		this.contratoRenovacion = contratoRenovacion;
	}

	/**
	 * @return the justificacionExc
	 */
	public String getJustificacionExc() {
		return justificacionExc;
	}

	/**
	 * @param justificacionExc the justificacionExc to set
	 */
	public void setJustificacionExc(String justificacionExc) {
		this.justificacionExc = justificacionExc;
	}

	/**
	 * @return the aplicarGarantia
	 */
	public String getAplicarGarantia() {
		return aplicarGarantia;
	}

	/**
	 * @param aplicarGarantia the aplicarGarantia to set
	 */
	public void setAplicarGarantia(String aplicarGarantia) {
		this.aplicarGarantia = aplicarGarantia;
	}

	/**
	 * @return the aplicarGarantiaDesertor
	 */
	public String getAplicarGarantiaDesertor() {
		return aplicarGarantiaDesertor;
	}

	/**
	 * @param aplicarGarantiaDesertor the aplicarGarantiaDesertor to set
	 */
	public void setAplicarGarantiaDesertor(String aplicarGarantiaDesertor) {
		this.aplicarGarantiaDesertor = aplicarGarantiaDesertor;
	}

	/**
	 * @return the medioPago
	 */
	public String getMedioPago() {
		return medioPago;
	}

	/**
	 * @param medioPago the medioPago to set
	 */
	public void setMedioPago(String medioPago) {
		this.medioPago = medioPago;
	}

	/**
	 * @return the pagoGarantia
	 */
	public boolean getPagoGarantia() {
		return pagoGarantia;
	}

	/**
	 * @param pagoGarantia the pagoGarantia to set
	 */
	public void setPagoGarantia(boolean pagoGarantia) {
		this.pagoGarantia = pagoGarantia;
	}

	/**
	 * @return the justificacionExcepcionDocumental
	 */
	public String getJustificacionExcepcionDocumental() {
		return justificacionExcepcionDocumental;
	}

	/**
	 * @param justificacionExcepcionDocumental the justificacionExcepcionDocumental to set
	 */
	public void setJustificacionExcepcionDocumental(
			String justificacionExcepcionDocumental) {
		this.justificacionExcepcionDocumental = justificacionExcepcionDocumental;
	}

	/**
	 * @return the enviarDocumental
	 */
	public boolean isEnviarDocumental() {
		return enviarDocumental;
	}

	/**
	 * @param enviarDocumental the enviarDocumental to set
	 */
	public void setEnviarDocumental(boolean enviarDocumental) {
		this.enviarDocumental = enviarDocumental;
	}

}
