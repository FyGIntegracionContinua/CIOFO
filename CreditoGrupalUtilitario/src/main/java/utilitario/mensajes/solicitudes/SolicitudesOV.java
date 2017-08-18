package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class SolicitudesOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes ov.
	 */
	public SolicitudesOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The solicitud. */
	private String solicitud;

	/** The clave empresa. */
	private String claveEmpresa;

	/** The credito grupal. */
	private String creditoGrupal;

	/** The numero integrantes. */
	private Integer numeroIntegrantes;

	/** The oficina. */
	private Integer oficina;

	/** The segmento. */
	private String segmento;

	/** The categoria. */
	private String categoria;

	/** The codigo producto. */
	private String codigoProducto;

	/** The cliente. */
	private String cliente;

	/** The efectivo solicitado. */
	private Double efectivoSolicitado;

	/** The monto solicitado. */
	private Double montoSolicitado;

	/** The frecuencia pago. */
	private String frecuenciaPago;

	/** The plazo solicitado. */
	private Integer plazoSolicitado;

	/** The dia pago. */
	private Integer diaPago;

	/** The tasa. */
	private Double tasa;

	/** The comision apertura. */
	private Double comisionApertura;

	/** The cat. */
	private Double cat;

	/** The oficina disposicion. */
	private Integer oficinaDisposicion;

	/** The plazo. */
	private Integer plazo;

	/** The hora reunion. */
	private String horaReunion;

	/** The dia reunion. */
	private Integer diaReunion;

	/** The numero familiares grupo. */
	private Integer numeroFamiliaresGrupo;

	/** The monto pago. */
	private Double montoPago;

	/** The monto financiado cont ant. */
	private Double montoFinanciadoContAnt;

	/** The contrato ant. */
	private String contratoAnt;

	/** The fecha resolucion. */
	private Date fechaResolucion;

	/** The hora resolucion. */
	private Date horaResolucion;

	/** The efectivo otorgado. */
	private Double efectivoOtorgado;

	/** The monto otorgado. */
	private Double montoOtorgado;

	/** The contrato. */
	private String contrato;

	/** The vendedor. */
	private String vendedor;

	/** The vendedor orig. */
	private String vendedorOrig;

	/** The gte ventas. */
	private String gteVentas;

	/** The grupo ventas. */
	private Integer grupoVentas;

	/** The gte sucursal. */
	private String gteSucursal;

	/** The contrato recomienda. */
	private String contratoRecomienda;

	/** The clave corresponsal. */
	private String claveCorresponsal;

	/** The status. */
	private String status;

	/** The ciclo. */
	private Integer ciclo;

	/** The origen venta. */
	private String origenVenta;

	/** The etapa. */
	private String etapa;

	/** The tipo verificacion. */
	private String tipoVerificacion;

	/** The fecha captura. */
	private Date fechaCaptura;

	/** The hora captura. */
	private Date horaCaptura;

	/** The etapa anterior. */
	private String etapaAnterior;

	/** The motivo status. */
	private String motivoStatus;

	/** The fecha ult mod. */
	private Date fechaUltMod;

	/** The hora ult mod. */
	private Date horaUltMod;

	/** The usuario registra solicitud. */
	private String usuarioRegistraSolicitud;

	/** The hora reunion fin. */
	private String horaReunionFin;

	/** The persona dom reunion. */
	private String personaDomReunion;

	/** The excepcion garantia. */
	private String excepcionGarantia;

	/** The autorizacion garantia. */
	private String autorizacionGarantia;

	/** The usuario autorizacion. */
	private String usuarioAutorizacion;

	/** The fecha autorizacion. */
	private Date fechaAutorizacion;

	/** The seguro. */
	private String seguro;

	/** The estatus. */
	private String estatus;

	/** The descripcion. */
	private String descripcion;

	/** The fecha fin. */
	private Date fechaFin;

	/** The express. */
	private String express;

	/** The campana. */
	private String campana;

	/** The senalamientoExcepcion. */
	private String senalamientoExcepcion;

	/** The traspaso garantia. */
	private String traspasoGarantia;

	/** The pct garantia. */
	private Integer pctGarantia;

	/** The motivoCancelacion. */
	private String motivoCancelacion;

	/** The aplicarGarantia. */
	private String aplicarGarantia;

	/** The aplicarGarantia. */
	private String aplicarGarantiaDesertor;

	/** The justificacionExc. */
	private String justificacionExc;

	/** tipo de excepcion que puede ser de cupo o monto*/
	private String tipoExcepcion;

	/** The reactivacion. */
	private Integer reactivacion;

	/** The justificacionExc. */
	private String solicitudOrigen;

	/**
	 * variable que se utilizara para madar a buzon o no.
	 */
	private String entrarBuzon;
	/**
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud.trim();
	}

	/**
	 * Obtiene clave empresa.
	 *
	 * @return clave empresa
	 */
	public String getClaveEmpresa() {
		return claveEmpresa;
	}

	/**
	 * Establece clave empresa.
	 *
	 * @param claveEmpresa a clave empresa
	 */
	public void setClaveEmpresa(String claveEmpresa) {
		this.claveEmpresa = claveEmpresa.trim();
	}

	/**
	 * Obtiene credito grupal.
	 *
	 * @return credito grupal
	 */
	public String getCreditoGrupal() {
		return creditoGrupal;
	}

	/**
	 * Establece credito grupal.
	 *
	 * @param creditoGrupal a credito grupal
	 */
	public void setCreditoGrupal(String creditoGrupal) {
		this.creditoGrupal = creditoGrupal.trim();
	}

	/**
	 * Obtiene numero integrantes.
	 *
	 * @return numero integrantes
	 */
	public Integer getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	/**
	 * Establece numero integrantes.
	 *
	 * @param numeroIntegrantes a numero integrantes
	 */
	public void setNumeroIntegrantes(Integer numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	/**
	 * Obtiene oficina.
	 *
	 * @return oficina
	 */
	public Integer getOficina() {
		return oficina;
	}

	/**
	 * Establece oficina.
	 *
	 * @param oficina a oficina
	 */
	public void setOficina(Integer oficina) {
		this.oficina = oficina;
	}

	/**
	 * Obtiene segmento.
	 *
	 * @return segmento
	 */
	public String getSegmento() {
		return segmento;
	}

	/**
	 * Establece segmento.
	 *
	 * @param segmento a segmento
	 */
	public void setSegmento(String segmento) {
		this.segmento = segmento.trim();
	}

	/**
	 * Obtiene categoria.
	 *
	 * @return categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * Establece categoria.
	 *
	 * @param categoria a categoria
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria.trim();
	}

	/**
	 * Obtiene codigo producto.
	 *
	 * @return codigo producto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Establece codigo producto.
	 *
	 * @param codigoProducto a codigo producto
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto.trim();
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
	 * Obtiene efectivo solicitado.
	 *
	 * @return efectivo solicitado
	 */
	public Double getEfectivoSolicitado() {
		return efectivoSolicitado;
	}

	/**
	 * Establece efectivo solicitado.
	 *
	 * @param efectivoSolicitado a efectivo solicitado
	 */
	public void setEfectivoSolicitado(Double efectivoSolicitado) {
		this.efectivoSolicitado = efectivoSolicitado;
	}

	/**
	 * Obtiene monto solicitado.
	 *
	 * @return monto solicitado
	 */
	public Double getMontoSolicitado() {
		return montoSolicitado;
	}

	/**
	 * Establece monto solicitado.
	 *
	 * @param montoSolicitado a monto solicitado
	 */
	public void setMontoSolicitado(Double montoSolicitado) {
		this.montoSolicitado = montoSolicitado;
	}

	/**
	 * Obtiene frecuencia pago.
	 *
	 * @return frecuencia pago
	 */
	public String getFrecuenciaPago() {
		return frecuenciaPago;
	}

	/**
	 * Establece frecuencia pago.
	 *
	 * @param frecuenciaPago a frecuencia pago
	 */
	public void setFrecuenciaPago(String frecuenciaPago) {
		this.frecuenciaPago = frecuenciaPago.trim();
	}

	/**
	 * Obtiene plazo solicitado.
	 *
	 * @return plazo solicitado
	 */
	public Integer getPlazoSolicitado() {
		return plazoSolicitado;
	}

	/**
	 * Establece plazo solicitado.
	 *
	 * @param plazoSolicitado a plazo solicitado
	 */
	public void setPlazoSolicitado(Integer plazoSolicitado) {
		this.plazoSolicitado = plazoSolicitado;
	}

	/**
	 * Obtiene dia pago.
	 *
	 * @return dia pago
	 */
	public Integer getDiaPago() {
		return diaPago;
	}

	/**
	 * Establece dia pago.
	 *
	 * @param diaPago a dia pago
	 */
	public void setDiaPago(Integer diaPago) {
		this.diaPago = diaPago;
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
	 * Obtiene comision apertura.
	 *
	 * @return comision apertura
	 */
	public Double getComisionApertura() {
		return comisionApertura;
	}

	/**
	 * Establece comision apertura.
	 *
	 * @param comisionApertura a comision apertura
	 */
	public void setComisionApertura(Double comisionApertura) {
		this.comisionApertura = comisionApertura;
	}

	/**
	 * Obtiene cat.
	 *
	 * @return cat
	 */
	public Double getCat() {
		return cat;
	}

	/**
	 * Establece cat.
	 *
	 * @param cat a cat
	 */
	public void setCat(Double cat) {
		this.cat = cat;
	}

	/**
	 * Obtiene oficina disposicion.
	 *
	 * @return oficina disposicion
	 */
	public Integer getOficinaDisposicion() {
		return oficinaDisposicion;
	}

	/**
	 * Establece oficina disposicion.
	 *
	 * @param oficinaDisposicion a oficina disposicion
	 */
	public void setOficinaDisposicion(Integer oficinaDisposicion) {
		this.oficinaDisposicion = oficinaDisposicion;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo a plazo
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene hora reunion.
	 *
	 * @return hora reunion
	 */
	public String getHoraReunion() {
		return horaReunion;
	}

	/**
	 * Establece hora reunion.
	 *
	 * @param horaReunion a hora reunion
	 */
	public void setHoraReunion(String horaReunion) {
		this.horaReunion = horaReunion.trim();
	}

	/**
	 * Obtiene dia reunion.
	 *
	 * @return dia reunion
	 */
	public Integer getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion a dia reunion
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Obtiene numero familiares grupo.
	 *
	 * @return numero familiares grupo
	 */
	public Integer getNumeroFamiliaresGrupo() {
		return numeroFamiliaresGrupo;
	}

	/**
	 * Establece numero familiares grupo.
	 *
	 * @param numeroFamiliaresGrupo a numero familiares grupo
	 */
	public void setNumeroFamiliaresGrupo(Integer numeroFamiliaresGrupo) {
		this.numeroFamiliaresGrupo = numeroFamiliaresGrupo;
	}

	/**
	 * Obtiene monto pago.
	 *
	 * @return monto pago
	 */
	public Double getMontoPago() {
		return montoPago;
	}

	/**
	 * Establece monto pago.
	 *
	 * @param montoPago a monto pago
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * Obtiene monto financiado cont ant.
	 *
	 * @return monto financiado cont ant
	 */
	public Double getMontoFinanciadoContAnt() {
		return montoFinanciadoContAnt;
	}

	/**
	 * Establece monto financiado cont ant.
	 *
	 * @param montoFinanciadoContAnt a monto financiado cont ant
	 */
	public void setMontoFinanciadoContAnt(Double montoFinanciadoContAnt) {
		this.montoFinanciadoContAnt = montoFinanciadoContAnt;
	}

	/**
	 * Obtiene contrato ant.
	 *
	 * @return contrato ant
	 */
	public String getContratoAnt() {
		return contratoAnt;
	}

	/**
	 * Establece contrato ant.
	 *
	 * @param contratoAnt a contrato ant
	 */
	public void setContratoAnt(String contratoAnt) {
		this.contratoAnt = contratoAnt.trim();
	}

	/**
	 * Obtiene fecha resolucion.
	 *
	 * @return fecha resolucion
	 */
	public Date getFechaResolucion() {
		return fechaResolucion;
	}

	/**
	 * Establece fecha resolucion.
	 *
	 * @param fechaResolucion a fecha resolucion
	 */
	public void setFechaResolucion(Date fechaResolucion) {
		this.fechaResolucion = fechaResolucion;
	}

	/**
	 * Obtiene hora resolucion.
	 *
	 * @return hora resolucion
	 */
	public Date getHoraResolucion() {
		return horaResolucion;
	}

	/**
	 * Establece hora resolucion.
	 *
	 * @param horaResolucion a hora resolucion
	 */
	public void setHoraResolucion(Date horaResolucion) {
		this.horaResolucion = horaResolucion;
	}

	/**
	 * Obtiene efectivo otorgado.
	 *
	 * @return efectivo otorgado
	 */
	public Double getEfectivoOtorgado() {
		return efectivoOtorgado;
	}

	/**
	 * Establece efectivo otorgado.
	 *
	 * @param efectivoOtorgado a efectivo otorgado
	 */
	public void setEfectivoOtorgado(Double efectivoOtorgado) {
		this.efectivoOtorgado = efectivoOtorgado;
	}

	/**
	 * Obtiene monto otorgado.
	 *
	 * @return monto otorgado
	 */
	public Double getMontoOtorgado() {
		return montoOtorgado;
	}

	/**
	 * Establece monto otorgado.
	 *
	 * @param montoOtorgado a monto otorgado
	 */
	public void setMontoOtorgado(Double montoOtorgado) {
		this.montoOtorgado = montoOtorgado;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato.trim();
	}

	/**
	 * Obtiene vendedor.
	 *
	 * @return vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * Establece vendedor.
	 *
	 * @param vendedor a vendedor
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor.trim();
	}

	/**
	 * Obtiene vendedor orig.
	 *
	 * @return vendedor orig
	 */
	public String getVendedorOrig() {
		return vendedorOrig;
	}

	/**
	 * Establece vendedor orig.
	 *
	 * @param vendedorOrig a vendedor orig
	 */
	public void setVendedorOrig(String vendedorOrig) {
		this.vendedorOrig = vendedorOrig.trim();
	}

	/**
	 * Obtiene gte ventas.
	 *
	 * @return gte ventas
	 */
	public String getGteVentas() {
		return gteVentas;
	}

	/**
	 * Establece gte ventas.
	 *
	 * @param gteVentas a gte ventas
	 */
	public void setGteVentas(String gteVentas) {
		this.gteVentas = gteVentas.trim();
	}

	/**
	 * Obtiene grupo ventas.
	 *
	 * @return grupo ventas
	 */
	public Integer getGrupoVentas() {
		return grupoVentas;
	}

	/**
	 * Establece grupo ventas.
	 *
	 * @param grupoVentas a grupo ventas
	 */
	public void setGrupoVentas(Integer grupoVentas) {
		this.grupoVentas = grupoVentas;
	}

	/**
	 * Obtiene gte sucursal.
	 *
	 * @return gte sucursal
	 */
	public String getGteSucursal() {
		return gteSucursal;
	}

	/**
	 * Establece gte sucursal.
	 *
	 * @param gteSucursal a gte sucursal
	 */
	public void setGteSucursal(String gteSucursal) {
		this.gteSucursal = gteSucursal.trim();
	}

	/**
	 * Obtiene contrato recomienda.
	 *
	 * @return contrato recomienda
	 */
	public String getContratoRecomienda() {
		return contratoRecomienda;
	}

	/**
	 * Establece contrato recomienda.
	 *
	 * @param contratoRecomienda a contrato recomienda
	 */
	public void setContratoRecomienda(String contratoRecomienda) {
		this.contratoRecomienda = contratoRecomienda.trim();
	}

	/**
	 * Obtiene clave corresponsal.
	 *
	 * @return clave corresponsal
	 */
	public String getClaveCorresponsal() {
		return claveCorresponsal;
	}

	/**
	 * Establece clave corresponsal.
	 *
	 * @param claveCorresponsal a clave corresponsal
	 */
	public void setClaveCorresponsal(String claveCorresponsal) {
		this.claveCorresponsal = claveCorresponsal.trim();
	}

	/**
	 * Obtiene status.
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status a status
	 */
	public void setStatus(String status) {
		this.status = status.trim();
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
	 * Obtiene origen venta.
	 *
	 * @return origen venta
	 */
	public String getOrigenVenta() {
		return origenVenta;
	}

	/**
	 * Establece origen venta.
	 *
	 * @param origenVenta a origen venta
	 */
	public void setOrigenVenta(String origenVenta) {
		this.origenVenta = origenVenta.trim();
	}

	/**
	 * Obtiene etapa.
	 *
	 * @return etapa
	 */
	public String getEtapa() {
		return etapa;
	}

	/**
	 * Establece etapa.
	 *
	 * @param etapa a etapa
	 */
	public void setEtapa(String etapa) {
		this.etapa = etapa.trim();
	}

	/**
	 * Obtiene tipo verificacion.
	 *
	 * @return tipo verificacion
	 */
	public String getTipoVerificacion() {
		return tipoVerificacion;
	}

	/**
	 * Establece tipo verificacion.
	 *
	 * @param tipoVerificacion a tipo verificacion
	 */
	public void setTipoVerificacion(String tipoVerificacion) {
		this.tipoVerificacion = tipoVerificacion.trim();
	}

	/**
	 * Obtiene fecha captura.
	 *
	 * @return fecha captura
	 */
	public Date getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * Establece fecha captura.
	 *
	 * @param fechaCaptura a fecha captura
	 */
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * Obtiene hora captura.
	 *
	 * @return hora captura
	 */
	public Date getHoraCaptura() {
		return horaCaptura;
	}

	/**
	 * Establece hora captura.
	 *
	 * @param horaCaptura a hora captura
	 */
	public void setHoraCaptura(Date horaCaptura) {
		this.horaCaptura = horaCaptura;
	}

	/**
	 * Obtiene etapa anterior.
	 *
	 * @return etapa anterior
	 */
	public String getEtapaAnterior() {
		return etapaAnterior;
	}

	/**
	 * Establece etapa anterior.
	 *
	 * @param etapaAnterior a etapa anterior
	 */
	public void setEtapaAnterior(String etapaAnterior) {
		this.etapaAnterior = etapaAnterior.trim();
	}

	/**
	 * Obtiene motivo status.
	 *
	 * @return motivo status
	 */
	public String getMotivoStatus() {
		return motivoStatus;
	}

	/**
	 * Establece motivo status.
	 *
	 * @param motivoStatus a motivo status
	 */
	public void setMotivoStatus(String motivoStatus) {
		this.motivoStatus = motivoStatus.trim();
	}

	/**
	 * Obtiene fecha ult mod.
	 *
	 * @return fecha ult mod
	 */
	public Date getFechaUltMod() {
		return fechaUltMod;
	}

	/**
	 * Establece fecha ult mod.
	 *
	 * @param fechaUltMod a fecha ult mod
	 */
	public void setFechaUltMod(Date fechaUltMod) {
		this.fechaUltMod = fechaUltMod;
	}

	/**
	 * Obtiene hora ult mod.
	 *
	 * @return hora ult mod
	 */
	public Date getHoraUltMod() {
		return horaUltMod;
	}

	/**
	 * Establece hora ult mod.
	 *
	 * @param horaUltMod a hora ult mod
	 */
	public void setHoraUltMod(Date horaUltMod) {
		this.horaUltMod = horaUltMod;
	}

	/**
	 * Obtiene usuario registra solicitud.
	 *
	 * @return usuario registra solicitud
	 */
	public String getUsuarioRegistraSolicitud() {
		return usuarioRegistraSolicitud;
	}

	/**
	 * Establece usuario registra solicitud.
	 *
	 * @param usuarioRegistraSolicitud a usuario registra solicitud
	 */
	public void setUsuarioRegistraSolicitud(String usuarioRegistraSolicitud) {
		this.usuarioRegistraSolicitud = usuarioRegistraSolicitud.trim();
	}

	/**
	 * Obtiene hora reunion fin.
	 *
	 * @return hora reunion fin
	 */
	public String getHoraReunionFin() {
		return horaReunionFin;
	}

	/**
	 * Establece hora reunion fin.
	 *
	 * @param horaReunionFin a hora reunion fin
	 */
	public void setHoraReunionFin(String horaReunionFin) {
		this.horaReunionFin = horaReunionFin;
	}

	/**
	 * Obtiene persona dom reunion.
	 *
	 * @return persona dom reunion
	 */
	public String getPersonaDomReunion() {
		return personaDomReunion;
	}

	/**
	 * Establece persona dom reunion.
	 *
	 * @param personaDomReunion a persona dom reunion
	 */
	public void setPersonaDomReunion(String personaDomReunion) {
		this.personaDomReunion = personaDomReunion;
	}

	/**
	 * Obtiene excepcion garantia.
	 *
	 * @return excepcion garantia
	 */
	public String getExcepcionGarantia() {
		return excepcionGarantia;
	}

	/**
	 * Establece excepcion garantia.
	 *
	 * @param excepcionGarantia a excepcion garantia
	 */
	public void setExcepcionGarantia(String excepcionGarantia) {
		this.excepcionGarantia = excepcionGarantia;
	}

	/**
	 * Obtiene autorizacion garantia.
	 *
	 * @return autorizacion garantia
	 */
	public String getAutorizacionGarantia() {
		return autorizacionGarantia;
	}

	/**
	 * Establece autorizacion garantia.
	 *
	 * @param autorizacionGarantia a autorizacion garantia
	 */
	public void setAutorizacionGarantia(String autorizacionGarantia) {
		this.autorizacionGarantia = autorizacionGarantia;
	}

	/**
	 * Obtiene usuario autorizacion.
	 *
	 * @return usuario autorizacion
	 */
	public String getUsuarioAutorizacion() {
		return usuarioAutorizacion;
	}

	/**
	 * Establece usuario autorizacion.
	 *
	 * @param usuarioAutorizacion a usuario autorizacion
	 */
	public void setUsuarioAutorizacion(String usuarioAutorizacion) {
		this.usuarioAutorizacion = usuarioAutorizacion;
	}

	/**
	 * Obtiene fecha autorizacion.
	 *
	 * @return fecha autorizacion
	 */
	public Date getFechaAutorizacion() {
		return fechaAutorizacion;
	}

	/**
	 * Establece fecha autorizacion.
	 *
	 * @param fechaAutorizacion a fecha autorizacion
	 */
	public void setFechaAutorizacion(Date fechaAutorizacion) {
		this.fechaAutorizacion = fechaAutorizacion;
	}

	/**
	 * Obtiene seguro.
	 *
	 * @return seguro
	 */
	public String getSeguro() {
		return seguro;
	}

	/**
	 * Establece seguro.
	 *
	 * @param seguro a seguro
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus a estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion a descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return fecha fin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin a fecha fin
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene express.
	 *
	 * @return express
	 */
	public String getExpress() {
		return express;
	}

	/**
	 * Establece express.
	 *
	 * @param express a express
	 */
	public void setExpress(String express) {
		this.express = express;
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
	 * @return the senalamientoExcepcion
	 */
	public String getSenalamientoExcepcion() {
		return senalamientoExcepcion;
	}

	/**
	 * @param senalamientoExcepcion the senalamientoExcepcion to set
	 */
	public void setSenalamientoExcepcion(String senalamientoExcepcion) {
		this.senalamientoExcepcion = senalamientoExcepcion;
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
	 * @return the entrarBuzon
	 */
	public String getEntrarBuzon() {
		return entrarBuzon;
	}

	/**
	 * @param entrarBuzon the entrarBuzon to set
	 */
	public void setEntrarBuzon(String entrarBuzon) {
		this.entrarBuzon = entrarBuzon;
	}

	/**
	 * @return the tipoExcepcion
	 */
	public String getTipoExcepcion() {
		return tipoExcepcion;
	}

	/**
	 * @param tipoExcepcion the tipoExcepcion to set
	 */
	public void setTipoExcepcion(String tipoExcepcion) {
		this.tipoExcepcion = tipoExcepcion;
	}

	/**
	 * @return the reactivacion
	 */
	public Integer getReactivacion() {
		return reactivacion;
	}

	/**
	 * @param reactivacion the reactivacion to set
	 */
	public void setReactivacion(Integer reactivacion) {
		this.reactivacion = reactivacion;
	}

	/**
	 * @return the solicitudOrigen
	 */
	public String getSolicitudOrigen() {
		return solicitudOrigen;
	}

	/**
	 * @param solicitudOrigen the solicitudOrigen to set
	 */
	public void setSolicitudOrigen(String solicitudOrigen) {
		this.solicitudOrigen = solicitudOrigen;
	}

}
