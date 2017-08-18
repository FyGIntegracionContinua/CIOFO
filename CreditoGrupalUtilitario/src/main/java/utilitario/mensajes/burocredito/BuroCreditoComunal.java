package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoComunal.
 *
 * @author out_ltorres
 * @version 1.0
 */
public class BuroCreditoComunal extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito comunal.
	 */
	public BuroCreditoComunal() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4237087817761546165L;

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
	private String grupoID;

	/** The grupo. */
	private String grupo;

	/** The monto aprobado. */
	private Double montoAprobado;

	/** The ciclo. */
	private Integer ciclo;

	/** The cliente id. */
	private String clienteID;

	/** The cliente. */
	private String cliente;

	/** The mnt solicitado actual. */
	private Double mntSolicitadoActual;

	/** The fecha. */
	private String fecha;

	/** The destino credito actual. */
	private String destinoCreditoActual;

	/** The cuota semanal actual. */
	private Double cuotaSemanalActual;

	/** The tasa. */
	private Double tasa;

	/** The plazo. */
	private String plazo;

	/** The total interes. */
	private Double totalInteres;

	/** The total pagar. */
	private Double totalPagar;

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
	 * @return producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto a producto
	 */
	public void setProducto(String producto) {
		this.producto = producto.trim();
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return fecha inicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio a fecha inicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio.trim();
	}

	/**
	 * Obtiene fecha termino.
	 *
	 * @return fecha termino
	 */
	public String getFechaTermino() {
		return fechaTermino;
	}

	/**
	 * Establece fecha termino.
	 *
	 * @param fechaTermino a fecha termino
	 */
	public void setFechaTermino(String fechaTermino) {
		this.fechaTermino = fechaTermino.trim();
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal.trim();
	}

	/**
	 * Obtiene asesor.
	 *
	 * @return asesor
	 */
	public String getAsesor() {
		return asesor;
	}

	/**
	 * Establece asesor.
	 *
	 * @param asesor a asesor
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor.trim();
	}

	/**
	 * Obtiene grupo id.
	 *
	 * @return grupo id
	 */
	public String getGrupoID() {
		return grupoID;
	}

	/**
	 * Establece grupo id.
	 *
	 * @param grupoID a grupo id
	 */
	public void setGrupoID(String grupoID) {
		this.grupoID = grupoID.trim();
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo a grupo
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo.trim();
	}

	/**
	 * Obtiene monto aprobado.
	 *
	 * @return monto aprobado
	 */
	public Double getMontoAprobado() {
		return montoAprobado;
	}

	/**
	 * Establece monto aprobado.
	 *
	 * @param montoAprobado a monto aprobado
	 */
	public void setMontoAprobado(Double montoAprobado) {
		this.montoAprobado = montoAprobado;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo a ciclo
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene cliente id.
	 *
	 * @return cliente id
	 */
	public String getClienteID() {
		return clienteID;
	}

	/**
	 * Establece cliente id.
	 *
	 * @param clienteID a cliente id
	 */
	public void setClienteID(String clienteID) {
		this.clienteID = clienteID.trim();
	}

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
		this.cliente = cliente.trim();
	}

	/**
	 * Obtiene mnt solicitado actual.
	 *
	 * @return mnt solicitado actual
	 */
	public Double getMntSolicitadoActual() {
		return mntSolicitadoActual;
	}

	/**
	 * Establece mnt solicitado actual.
	 *
	 * @param mntSolicitadoActual a mnt solicitado actual
	 */
	public void setMntSolicitadoActual(Double mntSolicitadoActual) {
		this.mntSolicitadoActual = mntSolicitadoActual;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha a fecha
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha.trim();
	}

	/**
	 * Obtiene destino credito actual.
	 *
	 * @return destino credito actual
	 */
	public String getDestinoCreditoActual() {
		return destinoCreditoActual;
	}

	/**
	 * Establece destino credito actual.
	 *
	 * @param destinoCreditoActual a destino credito actual
	 */
	public void setDestinoCreditoActual(String destinoCreditoActual) {
		this.destinoCreditoActual = destinoCreditoActual.trim();
	}

	/**
	 * Obtiene cuota semanal actual.
	 *
	 * @return cuota semanal actual
	 */
	public Double getCuotaSemanalActual() {
		return cuotaSemanalActual;
	}

	/**
	 * Establece cuota semanal actual.
	 *
	 * @param cuotaSemanalActual a cuota semanal actual
	 */
	public void setCuotaSemanalActual(Double cuotaSemanalActual) {
		this.cuotaSemanalActual = cuotaSemanalActual;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa a tasa
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return plazo
	 */
	public String getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo a plazo
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo.trim();
	}

	/**
	 * Obtiene total interes.
	 *
	 * @return total interes
	 */
	public Double getTotalInteres() {
		return totalInteres;
	}

	/**
	 * Establece total interes.
	 *
	 * @param totalInteres a total interes
	 */
	public void setTotalInteres(Double totalInteres) {
		this.totalInteres = totalInteres;
	}

	/**
	 * Obtiene total pagar.
	 *
	 * @return total pagar
	 */
	public Double getTotalPagar() {
		return totalPagar;
	}

	/**
	 * Establece total pagar.
	 *
	 * @param totalPagar a total pagar
	 */
	public void setTotalPagar(Double totalPagar) {
		this.totalPagar = totalPagar;
	}

	/**
	 * Obtiene presidente.
	 *
	 * @return presidente
	 */
	public String getPresidente() {
		return presidente;
	}

	/**
	 * Establece presidente.
	 *
	 * @param presidente a presidente
	 */
	public void setPresidente(String presidente) {
		this.presidente = presidente.trim();
	}

	/**
	 * Obtiene tesorero.
	 *
	 * @return tesorero
	 */
	public String getTesorero() {
		return tesorero;
	}

	/**
	 * Establece tesorero.
	 *
	 * @param tesorero a tesorero
	 */
	public void setTesorero(String tesorero) {
		this.tesorero = tesorero.trim();
	}

	/**
	 * Obtiene secretario.
	 *
	 * @return secretario
	 */
	public String getSecretario() {
		return secretario;
	}

	/**
	 * Establece secretario.
	 *
	 * @param secretario a secretario
	 */
	public void setSecretario(String secretario) {
		this.secretario = secretario.trim();
	}

	/**
	 * Obtiene supervisor.
	 *
	 * @return supervisor
	 */
	public String getSupervisor() {
		return supervisor;
	}

	/**
	 * Establece supervisor.
	 *
	 * @param supervisor a supervisor
	 */
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor.trim();
	}

	/**
	 * Obtiene dir sucursal.
	 *
	 * @return dir sucursal
	 */
	public String getDirSucursal() {
		return dirSucursal;
	}

	/**
	 * Establece dir sucursal.
	 *
	 * @param dirSucursal a dir sucursal
	 */
	public void setDirSucursal(String dirSucursal) {
		this.dirSucursal = dirSucursal;
	}

}


