package utilitario.mensajes.originacion.consulta;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SimulacionReestructuraOV.
 *
 * @author rguadarramac
 *
 */
public class SimulacionReestructuraOV extends ObjetoValor {

	/**
	 * Instantiates a new simulacion reestructura ov.
	 */
	public SimulacionReestructuraOV() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -5786851668589243169L;

	/** The id simulacion. */
	private Integer idSimulacion;

	/** The contrato ld. */
	private String contratoLD;

	/** The contrato. */
	private String contrato;

	/** The status. */
	private String status;

	/** The nombre grupo. */
	private String nombreGrupo;

	/** The nombre grupo nuevo. */
	private String nombreGrupoNuevo;

	/** The region. */
	private Integer region;

	/** The region descripcion. */
	private String regionDescripcion;

	/** The enganche. */
	private Double enganche;

	/** The monto enganche. */
	private Double montoEnganche;

	/** The monto reestructura. */
	private Double montoReestructura;

	/** The tasa. */
	private Double tasa;

	/** The plazo. */
	private Integer plazo;

	/** The dia reunion. */
	private Integer diaReunion;

	/** The desc dia reunion. */
	private String descDiaReunion;

	/** The ciclo. */
	private Integer ciclo;

	/** The sucursal. */
	private Integer sucursal;

	/** The nombre sucursal. */
	private String nombreSucursal;

	/** The fecha disposicion. */
	private Date fechaDisposicion;

	/** The fecha esp liq. */
	private Date fechaEspLiq;

	/** The parcialidad. */
	private Double parcialidad;

	/** The hora inicio. */
	private String horaInicio;

	/** The hora fin. */
	private String horaFin;

	/** The dia pago. */
	private Date diaPago;

	/** The dia pago num. */
	private Integer diaPagoNum;

	/** The desc dia pago. */
	private String descDiaPago;

	/** The frecuencia. */
	private String frecuencia;

	/** The desc frecuencia. */
	private String descFrecuencia;

	/** The producto. */
	private String producto;

	/** The coordinador. */
	private String coordinador;

	/** The cantidad entregada. */
	private Double cantidadEntregada;

	/** The total a pagar. */
	private Double totalAPagar;

	/** The pct solidaridad. */
	private Double pctSolidaridad;

	/** The numero integrantes. */
	private Integer numeroIntegrantes;

	/** The usuario registro. */
	private String usuarioRegistro;

	/** The fecha registro. */
	private Date fechaRegistro;

	/** The usuario ult mod. */
	private String usuarioUltMod;

	/** The fecha ult mod. */
	private Date fechaUltMod;

	/** The estatus. */
	private String estatus;

	/** The solicitud. */
	private String solicitud;

	/** The saldo capital. */
	private Double saldoCapital;

	/** The dias mora. */
	private Integer diasMora;

	/** The capital pagado. */
	private Double capitalPagado;

	/** The intereses ord pag. */
	private Double interesOrdPag;

	/** The intereses mor pag. */
	private Double interesMorPag;

	/** The adeudo total. */
	private Double adeudoTotal;

	/** The recargos. */
	private Double recargos;

	/** The saldo interes. */
	private Double saldoInteres;

	/** The saldo pendiente. */
	private Double saldoPendiente;

	/** The fecha contable. */
	private Date fechaContable;

	/** The fecha contable sist. */
	private Date fechaContableSist;

	/** The nueva simulacion. */
	private boolean nuevaSimulacion;


	/**
	 * Gets the id simulacion.
	 *
	 * @return the id simulacion
	 */
	public Integer getIdSimulacion() {
		return idSimulacion;
	}

	/**
	 * Sets the id simulacion.
	 *
	 * @param idSimulacion the new id simulacion
	 */
	public void setIdSimulacion(Integer idSimulacion) {
		this.idSimulacion = idSimulacion;
	}

	/**
	 * Gets the contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Sets the contrato.
	 *
	 * @param contrato the new contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Gets the nombre grupo.
	 *
	 * @return the nombre grupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Sets the nombre grupo.
	 *
	 * @param nombreGrupo the new nombre grupo
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Gets the enganche.
	 *
	 * @return the enganche
	 */
	public Double getEnganche() {
		return enganche;
	}

	/**
	 * Sets the enganche.
	 *
	 * @param enganche the new enganche
	 */
	public void setEnganche(Double enganche) {
		this.enganche = enganche;
	}

	/**
	 * Gets the monto reestructura.
	 *
	 * @return the monto reestructura
	 */
	public Double getMontoReestructura() {
		return montoReestructura;
	}

	/**
	 * Sets the monto reestructura.
	 *
	 * @param montoReestructura the new monto reestructura
	 */
	public void setMontoReestructura(Double montoReestructura) {
		this.montoReestructura = montoReestructura;
	}

	/**
	 * Gets the tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}

	/**
	 * Sets the tasa.
	 *
	 * @param tasa the new tasa
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
	}

	/**
	 * Gets the plazo.
	 *
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * Sets the plazo.
	 *
	 * @param plazo the new plazo
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Gets the dia reunion.
	 *
	 * @return the dia reunion
	 */
	public Integer getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Sets the dia reunion.
	 *
	 * @param diaReunion the new dia reunion
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Gets the ciclo.
	 *
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * Sets the ciclo.
	 *
	 * @param ciclo the new ciclo
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Gets the sucursal.
	 *
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Sets the sucursal.
	 *
	 * @param sucursal the new sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Gets the parcialidad.
	 *
	 * @return the parcialidad
	 */
	public Double getParcialidad() {
		return parcialidad;
	}

	/**
	 * Sets the parcialidad.
	 *
	 * @param parcialidad the new parcialidad
	 */
	public void setParcialidad(Double parcialidad) {
		this.parcialidad = parcialidad;
	}

	/**
	 * Gets the hora inicio.
	 *
	 * @return the hora inicio
	 */
	public String getHoraInicio() {
		return horaInicio;
	}

	/**
	 * Sets the hora inicio.
	 *
	 * @param horaInicio the new hora inicio
	 */
	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	/**
	 * Gets the hora fin.
	 *
	 * @return the hora fin
	 */
	public String getHoraFin() {
		return horaFin;
	}

	/**
	 * Sets the hora fin.
	 *
	 * @param horaFin the new hora fin
	 */
	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	/**
	 * Gets the dia pago.
	 *
	 * @return the dia pago
	 */
	public Date getDiaPago() {
		return diaPago;
	}

	/**
	 * Sets the dia pago.
	 *
	 * @param diaPago the new dia pago
	 */
	public void setDiaPago(Date diaPago) {
		this.diaPago = diaPago;
	}

	/**
	 * Gets the frecuencia.
	 *
	 * @return the frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Sets the frecuencia.
	 *
	 * @param frecuencia the new frecuencia
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Gets the pct solidaridad.
	 *
	 * @return the pct solidaridad
	 */
	public Double getPctSolidaridad() {
		return pctSolidaridad;
	}

	/**
	 * Sets the pct solidaridad.
	 *
	 * @param pctSolidaridad the new pct solidaridad
	 */
	public void setPctSolidaridad(Double pctSolidaridad) {
		this.pctSolidaridad = pctSolidaridad;
	}

	/**
	 * Gets the numero integrantes.
	 *
	 * @return the numero integrantes
	 */
	public Integer getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	/**
	 * Sets the numero integrantes.
	 *
	 * @param numeroIntegrantes the new numero integrantes
	 */
	public void setNumeroIntegrantes(Integer numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	/**
	 * Gets the usuario registro.
	 *
	 * @return the usuario registro
	 */
	public String getUsuarioRegistro() {
		return usuarioRegistro;
	}

	/**
	 * Sets the usuario registro.
	 *
	 * @param usuarioRegistro the new usuario registro
	 */
	public void setUsuarioRegistro(String usuarioRegistro) {
		this.usuarioRegistro = usuarioRegistro;
	}

	/**
	 * Gets the fecha registro.
	 *
	 * @return the fecha registro
	 */
	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * Sets the fecha registro.
	 *
	 * @param fechaRegistro the new fecha registro
	 */
	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * Gets the usuario ult mod.
	 *
	 * @return the usuario ult mod
	 */
	public String getUsuarioUltMod() {
		return usuarioUltMod;
	}

	/**
	 * Sets the usuario ult mod.
	 *
	 * @param usuarioUltMod the new usuario ult mod
	 */
	public void setUsuarioUltMod(String usuarioUltMod) {
		this.usuarioUltMod = usuarioUltMod;
	}

	/**
	 * Gets the fecha ult mod.
	 *
	 * @return the fecha ult mod
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}

	/**
	 * Sets the fecha ult mod.
	 *
	 * @param fechaUltMod the new fecha ult mod
	 */
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}

	/**
	 * Gets the estatus.
	 *
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Sets the estatus.
	 *
	 * @param estatus the new estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Gets the solicitud.
	 *
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Sets the solicitud.
	 *
	 * @param solicitud the new solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Gets the saldo capital.
	 *
	 * @return the saldo capital
	 */
	public Double getSaldoCapital() {
		return saldoCapital;
	}

	/**
	 * Sets the saldo capital.
	 *
	 * @param saldoCapital the new saldo capital
	 */
	public void setSaldoCapital(Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	/**
	 * Gets the dias mora.
	 *
	 * @return the dias mora
	 */
	public Integer getDiasMora() {
		return diasMora;
	}

	/**
	 * Sets the dias mora.
	 *
	 * @param diasMora the new dias mora
	 */
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}

	/**
	 * Gets the capital pagado.
	 *
	 * @return the capital pagado
	 */
	public Double getCapitalPagado() {
		return capitalPagado;
	}

	/**
	 * Sets the capital pagado.
	 *
	 * @param capitalPagado the new capital pagado
	 */
	public void setCapitalPagado(Double capitalPagado) {
		this.capitalPagado = capitalPagado;
	}

	/**
	 * Gets the adeudo total.
	 *
	 * @return the adeudo total
	 */
	public Double getAdeudoTotal() {
		return adeudoTotal;
	}

	/**
	 * Sets the adeudo total.
	 *
	 * @param adeudoTotal the new adeudo total
	 */
	public void setAdeudoTotal(Double adeudoTotal) {
		this.adeudoTotal = adeudoTotal;
	}

	/**
	 * Gets the recargos.
	 *
	 * @return the recargos
	 */
	public Double getRecargos() {
		return recargos;
	}

	/**
	 * Sets the recargos.
	 *
	 * @param recargos the new recargos
	 */
	public void setRecargos(Double recargos) {
		this.recargos = recargos;
	}

	/**
	 * Gets the saldo interes.
	 *
	 * @return the saldo interes
	 */
	public Double getSaldoInteres() {
		return saldoInteres;
	}

	/**
	 * Sets the saldo interes.
	 *
	 * @param saldoInteres the new saldo interes
	 */
	public void setSaldoInteres(Double saldoInteres) {
		this.saldoInteres = saldoInteres;
	}

	/**
	 * Gets the saldo pendiente.
	 *
	 * @return the saldo pendiente
	 */
	public Double getSaldoPendiente() {
		return saldoPendiente;
	}

	/**
	 * Sets the saldo pendiente.
	 *
	 * @param saldoPendiente the new saldo pendiente
	 */
	public void setSaldoPendiente(Double saldoPendiente) {
		this.saldoPendiente = saldoPendiente;
	}

	/**
	 * Gets the fecha contable.
	 *
	 * @return the fecha contable
	 */
	public Date getFechaContable() {
		return fechaContable;
	}

	/**
	 * Sets the fecha contable.
	 *
	 * @param fechaContable the new fecha contable
	 */
	public void setFechaContable(Date fechaContable) {
		this.fechaContable = fechaContable;
	}

	/**
	 * Gets the contrato ld.
	 *
	 * @return the contrato ld
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Sets the contrato ld.
	 *
	 * @param contratoLD the new contrato ld
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the nombre sucursal.
	 *
	 * @return the nombre sucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * Sets the nombre sucursal.
	 *
	 * @param nombreSucursal the new nombre sucursal
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * Gets the fecha disposicion.
	 *
	 * @return the fecha disposicion
	 */
	public Date getFechaDisposicion() {
		return fechaDisposicion;
	}

	/**
	 * Sets the fecha disposicion.
	 *
	 * @param fechaDisposicion the new fecha disposicion
	 */
	public void setFechaDisposicion(Date fechaDisposicion) {
		this.fechaDisposicion = fechaDisposicion;
	}

	/**
	 * Gets the fecha esp liq.
	 *
	 * @return the fecha esp liq
	 */
	public Date getFechaEspLiq() {
		return fechaEspLiq;
	}

	/**
	 * Sets the fecha esp liq.
	 *
	 * @param fechaEspLiq the new fecha esp liq
	 */
	public void setFechaEspLiq(Date fechaEspLiq) {
		this.fechaEspLiq = fechaEspLiq;
	}

	/**
	 * Gets the cantidad entregada.
	 *
	 * @return the cantidad entregada
	 */
	public Double getCantidadEntregada() {
		return cantidadEntregada;
	}

	/**
	 * Sets the cantidad entregada.
	 *
	 * @param cantidadEntregada the new cantidad entregada
	 */
	public void setCantidadEntregada(Double cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	/**
	 * Gets the total a pagar.
	 *
	 * @return the total a pagar
	 */
	public Double getTotalAPagar() {
		return totalAPagar;
	}

	/**
	 * Sets the total a pagar.
	 *
	 * @param totalAPagar the new total a pagar
	 */
	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}

	/**
	 * Gets the nueva simulacion.
	 *
	 * @return the nueva simulacion
	 */
	public boolean getNuevaSimulacion() {
		return nuevaSimulacion;
	}

	/**
	 * Sets the nueva simulacion.
	 *
	 * @param nuevaSimulacion the new nueva simulacion
	 */
	public void setNuevaSimulacion(boolean nuevaSimulacion) {
		this.nuevaSimulacion = nuevaSimulacion;
	}

	/**
	 * Gets the dia pago num.
	 *
	 * @return the dia pago num
	 */
	public Integer getDiaPagoNum() {
		return diaPagoNum;
	}

	/**
	 * Sets the dia pago num.
	 *
	 * @param diaPagoNum the new dia pago num
	 */
	public void setDiaPagoNum(Integer diaPagoNum) {
		this.diaPagoNum = diaPagoNum;
	}

	/**
	 * Gets the producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Sets the producto.
	 *
	 * @param producto the new producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Gets the interes ord pag.
	 *
	 * @return the interes ord pag
	 */
	public Double getInteresOrdPag() {
		return interesOrdPag;
	}

	/**
	 * Sets the interes ord pag.
	 *
	 * @param interesOrdPag the new interes ord pag
	 */
	public void setInteresOrdPag(Double interesOrdPag) {
		this.interesOrdPag = interesOrdPag;
	}

	/**
	 * Gets the interes mor pag.
	 *
	 * @return the interes mor pag
	 */
	public Double getInteresMorPag() {
		return interesMorPag;
	}

	/**
	 * Sets the interes mor pag.
	 *
	 * @param interesMorPag the new interes mor pag
	 */
	public void setInteresMorPag(Double interesMorPag) {
		this.interesMorPag = interesMorPag;
	}

	/**
	 * Gets the coordinador.
	 *
	 * @return the coordinador
	 */
	public String getCoordinador() {
		return coordinador;
	}

	/**
	 * Sets the coordinador.
	 *
	 * @param coordinador the new coordinador
	 */
	public void setCoordinador(String coordinador) {
		this.coordinador = coordinador;
	}

	/**
	 * Gets the region.
	 *
	 * @return the region
	 */
	public Integer getRegion() {
		return region;
	}

	/**
	 * Sets the region.
	 *
	 * @param region the new region
	 */
	public void setRegion(Integer region) {
		this.region = region;
	}

	/**
	 * Gets the nombre grupo nuevo.
	 *
	 * @return the nombre grupo nuevo
	 */
	public String getNombreGrupoNuevo() {
		return nombreGrupoNuevo;
	}

	/**
	 * Sets the nombre grupo nuevo.
	 *
	 * @param nombreGrupoNuevo the new nombre grupo nuevo
	 */
	public void setNombreGrupoNuevo(String nombreGrupoNuevo) {
		this.nombreGrupoNuevo = nombreGrupoNuevo;
	}

	/**
	 * Gets the region descripcion.
	 *
	 * @return the region descripcion
	 */
	public String getRegionDescripcion() {
		return regionDescripcion;
	}

	/**
	 * Sets the region descripcion.
	 *
	 * @param regionDescripcion the new region descripcion
	 */
	public void setRegionDescripcion(String regionDescripcion) {
		this.regionDescripcion = regionDescripcion;
	}

	/**
	 * Gets the desc dia reunion.
	 *
	 * @return the desc dia reunion
	 */
	public String getDescDiaReunion() {
		return descDiaReunion;
	}

	/**
	 * Sets the desc dia reunion.
	 *
	 * @param descDiaReunion the new desc dia reunion
	 */
	public void setDescDiaReunion(String descDiaReunion) {
		this.descDiaReunion = descDiaReunion;
	}

	/**
	 * Gets the desc dia pago.
	 *
	 * @return the desc dia pago
	 */
	public String getDescDiaPago() {
		return descDiaPago;
	}

	/**
	 * Sets the desc dia pago.
	 *
	 * @param descDiaPago the new desc dia pago
	 */
	public void setDescDiaPago(String descDiaPago) {
		this.descDiaPago = descDiaPago;
	}

	/**
	 * Sets the monto enganche.
	 *
	 * @param montoEnganche the new monto enganche
	 */
	public void setMontoEnganche(Double montoEnganche) {
		this.montoEnganche = montoEnganche;
	}

	/**
	 * Gets the monto enganche.
	 *
	 * @return the monto enganche
	 */
	public Double getMontoEnganche() {
		return montoEnganche;
	}

	/**
	 * Sets the desc frecuencia.
	 *
	 * @param descFrecuencia the new desc frecuencia
	 */
	public void setDescFrecuencia(String descFrecuencia) {
		this.descFrecuencia = descFrecuencia;
	}

	/**
	 * Gets the desc frecuencia.
	 *
	 * @return the desc frecuencia
	 */
	public String getDescFrecuencia() {
		return descFrecuencia;
	}

	/**
	 * Gets the fecha contable sist.
	 *
	 * @return the fecha contable sist
	 */
	public Date getFechaContableSist() {
		return fechaContableSist;
	}

	/**
	 * Sets the fecha contable sist.
	 *
	 * @param fechaContableSist the new fecha contable sist
	 */
	public void setFechaContableSist(Date fechaContableSist) {
		this.fechaContableSist = fechaContableSist;
	}

}
