/**
 *
 */
package utilitario.mensajes.originacion.aprobacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PlanillaAprobacionOV.
 *
 * @author out_oarias
 */
public class PlanillaAprobacionOV extends ObjetoValor {

	/**
	 * Instancia una nueva planilla aprobacion ov.
	 */
	public PlanillaAprobacionOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The producto. */
	private String producto;

	/** The fecha inicio. */
	private String fechaInicio;

	/** The fecha termino. */
	private String fechaTermino;

	/** The sucursal. */
	private String sucursal;

	/** The asesor. */
	private String asesor;

	/** The grupo id. */
	private String grupoID; //contratos.cliente

	/** The grupo. */
	private String grupo; //personas.nombre

	/** The monto aprobado. */
	private Double montoAprobado; //contrato_grupo.monto_otorgado

	/** The ciclo. */
	private Integer ciclo;

	/** The cliente id. */
	private String clienteID; //integrante

	/** The cliente. */
	private String cliente;   //personas.nombre +' '+ personas.apellido_pat +' '+ personas.apellido_mat

	/** The mnt solicitado actual. */
	private Double mntSolicitadoActual;

	/** The fecha. */
	private String fecha; //fechaContable formateada yyyymmdd

	/** The destino credito actual. */
	private String destinoCreditoActual;	//integrante_grupo.destino_credito

	/** The monto pago grupo. */
	private Double montoPagoGrupo; //se usa para calcular la cuota de pago (cuotaSemanalActual) de cada integrante

	/** The cuota semanal actual. */
	private Double cuotaSemanalActual;		//cuota semanal por integrante

	/** The tasa. */
	private Double tasa; //(contratos.tasa + iva) * 12

	/** The plazo. */
	private String plazo;

	/** The total interes. */
	private Double totalInteres;

	/** The total pagar. */
	private Double totalPagar; // Suma de montoAprobado + TotalInteres por lo tanto Pendiente

	/** The presidente. */
	private String presidente;

	/** The tesorero. */
	private String tesorero;

	/** The secretario. */
	private String secretario;

	/** The supervisor. */
	private String supervisor;

	/** The dir sucursal. */
	private String dirSucursal;

	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto == null ? "" : producto;
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
	 * Obtiene fecha inicio.
	 *
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio == null ? "" : fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha termino.
	 *
	 * @return the fechaTermino
	 */
	public String getFechaTermino() {
		return fechaTermino == null ? "" : fechaTermino;
	}

	/**
	 * Establece fecha termino.
	 *
	 * @param fechaTermino the fechaTermino to set
	 */
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal == null ? "" : sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene asesor.
	 *
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor == null ? "" : asesor;
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
	 * Obtiene grupo id.
	 *
	 * @return the grupoID
	 */
	public String getGrupoID() {
		return grupoID == null ? "" : grupoID;
	}

	/**
	 * Establece grupo id.
	 *
	 * @param grupoID the grupoID to set
	 */
	public void setGrupoID(String grupoID) {
		this.grupoID = grupoID;
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo == null ? "" : grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene monto aprobado.
	 *
	 * @return the montoAprobado
	 */
	public Double getMontoAprobado() {
		return montoAprobado == null ? 0.0 : montoAprobado;
	}

	/**
	 * Establece monto aprobado.
	 *
	 * @param montoAprobado the montoAprobado to set
	 */
	public void setMontoAprobado(Double montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo == null ? 0 : ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene cliente id.
	 *
	 * @return the clienteID
	 */
	public String getClienteID() {
		return clienteID == null ? "" : clienteID;
	}

	/**
	 * Establece cliente id.
	 *
	 * @param clienteID the clienteID to set
	 */
	public void setClienteID(String clienteID) {
		this.clienteID = clienteID;
	}

	/**
	 * Obtiene cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente == null ? "" : cliente;
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
	 * Obtiene mnt solicitado actual.
	 *
	 * @return the mntSolicitadoActual
	 */
	public Double getMntSolicitadoActual() {
		return mntSolicitadoActual == null ? 0.0 : mntSolicitadoActual;
	}

	/**
	 * Establece mnt solicitado actual.
	 *
	 * @param mntSolicitadoActual the mntSolicitadoActual to set
	 */
	public void setMntSolicitadoActual(Double mntSolicitadoActual) {
		this.mntSolicitadoActual = mntSolicitadoActual;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha == null ? "" : fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene destino credito actual.
	 *
	 * @return the destinoCreditoActual
	 */
	public String getDestinoCreditoActual() {
		return destinoCreditoActual == null ? "" : destinoCreditoActual;
	}

	/**
	 * Establece destino credito actual.
	 *
	 * @param destinoCreditoActual the destinoCreditoActual to set
	 */
	public void setDestinoCreditoActual(String destinoCreditoActual) {
		this.destinoCreditoActual = destinoCreditoActual;
	}

	/**
	 * Obtiene cuota semanal actual.
	 *
	 * @return the cuotaSemanalActual
	 */
	public Double getCuotaSemanalActual() {
		return cuotaSemanalActual == null ? 0.0 : cuotaSemanalActual;
	}

	/**
	 * Establece cuota semanal actual.
	 *
	 * @param cuotaSemanalActual the cuotaSemanalActual to set
	 */
	public void setCuotaSemanalActual(Double cuotaSemanalActual) {
		this.cuotaSemanalActual = cuotaSemanalActual;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa == null ? 0.0 : tasa;
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
	public String getPlazo() {
		return plazo == null ? "" : plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene total interes.
	 *
	 * @return the totalInteres
	 */
	public Double getTotalInteres() {
		return totalInteres == null ? 0.0 : totalInteres;
	}

	/**
	 * Establece total interes.
	 *
	 * @param totalInteres the totalInteres to set
	 */
	public void setTotalInteres(Double totalInteres) {
		this.totalInteres = totalInteres;
	}

	/**
	 * Obtiene total pagar.
	 *
	 * @return the totalPagar
	 */
	public Double getTotalPagar() {
		return totalPagar == null ? 0.0 : totalPagar;
	}

	/**
	 * Establece total pagar.
	 *
	 * @param totalPagar the totalPagar to set
	 */
	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	/**
	 * Obtiene presidente.
	 *
	 * @return the presidente
	 */
	public String getPresidente() {
		return presidente == null ? "" : presidente;
	}

	/**
	 * Establece presidente.
	 *
	 * @param presidente the presidente to set
	 */
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	/**
	 * Obtiene tesorero.
	 *
	 * @return the tesorero
	 */
	public String getTesorero() {
		return tesorero == null ? "" : tesorero;
	}

	/**
	 * Establece tesorero.
	 *
	 * @param tesorero the tesorero to set
	 */
	public void setTesorero(String tesorero) {
		this.tesorero = tesorero;
	}

	/**
	 * Obtiene secretario.
	 *
	 * @return the secretario
	 */
	public String getSecretario() {
		return secretario == null ? "" : secretario;
	}

	/**
	 * Establece secretario.
	 *
	 * @param secretario the secretario to set
	 */
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	/**
	 * Obtiene supervisor.
	 *
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return supervisor == null ? "" : supervisor;
	}

	/**
	 * Establece supervisor.
	 *
	 * @param supervisor the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}

	/**
	 * Obtiene dir sucursal.
	 *
	 * @return the dirSucursal
	 */
	public String getDirSucursal() {
		return dirSucursal == null ? "" : dirSucursal;
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
	 * Establece monto pago grupo.
	 *
	 * @param montoPagoGrupo a monto pago grupo
	 */
	public void setMontoPagoGrupo(Double montoPagoGrupo) {
		this.montoPagoGrupo = montoPagoGrupo;
	}

	/**
	 * Obtiene monto pago grupo.
	 *
	 * @return monto pago grupo
	 */
	public Double getMontoPagoGrupo() {
		return montoPagoGrupo == null ? 0.0 : montoPagoGrupo;
	}

}
