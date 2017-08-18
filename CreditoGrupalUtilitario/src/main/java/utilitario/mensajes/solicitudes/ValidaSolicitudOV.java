package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudesOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class ValidaSolicitudOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitudes ov.
	 */
	public ValidaSolicitudOV() {
	}
	/** Se genero serial. */
	private static final long serialVersionUID = 9096745766154723290L;

	/** The cliente. */
	private String cliente;

	/** The vendedor. */
	private String vendedor;

	/** The codigo producto. */
	private String codigoProducto;

	/** The tasa. */
	private Double tasa;

	/** The plazo. */
	private Integer plazo;

	/** The dia reunion. */
	private Integer diaReunion;

	/** The hora reunion. */
	private String horaReunionInicio;

	/** The hora reunion. */
	private String horaReunionFin;

	/** The dia pago. */
	private Integer diaPago;

	/** The fecha resolucion. */
	private Date fechaCaptura;

	/** The efectivo solicitado. */
	private Double efectivoSolicitado;

	/** The codigo destino credito. */
	private String codigoDestinoCredito;

	/** The seguro. */
	private String seguro;

	/** The status. */
	private String status;

	/** The ciclo. */
	private Integer ciclo;

	/** The categoria. */
	private String categoria;

	/**
	 * Gets the cliente.
	 *
	 * @return the cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Sets the cliente.
	 *
	 * @param cliente the new cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Gets the vendedor.
	 *
	 * @return the vendedor
	 */
	public String getVendedor() {
		return vendedor;
	}

	/**
	 * Sets the vendedor.
	 *
	 * @param vendedor the new vendedor
	 */
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}

	/**
	 * Gets the codigo producto.
	 *
	 * @return the codigo producto
	 */
	public String getCodigoProducto() {
		return codigoProducto;
	}

	/**
	 * Sets the codigo producto.
	 *
	 * @param codigoProducto the new codigo producto
	 */
	public void setCodigoProducto(String codigoProducto) {
		this.codigoProducto = codigoProducto;
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
	 * Gets the hora reunion inicio.
	 *
	 * @return the hora reunion inicio
	 */
	public String getHoraReunionInicio() {
		return horaReunionInicio;
	}

	/**
	 * Sets the hora reunion inicio.
	 *
	 * @param horaReunionInicio the new hora reunion inicio
	 */
	public void setHoraReunionInicio(String horaReunionInicio) {
		this.horaReunionInicio = horaReunionInicio;
	}

	/**
	 * Gets the hora reunion fin.
	 *
	 * @return the hora reunion fin
	 */
	public String getHoraReunionFin() {
		return horaReunionFin;
	}

	/**
	 * Sets the hora reunion fin.
	 *
	 * @param horaReunionFin the new hora reunion fin
	 */
	public void setHoraReunionFin(String horaReunionFin) {
		this.horaReunionFin = horaReunionFin;
	}

	/**
	 * Gets the dia pago.
	 *
	 * @return the dia pago
	 */
	public Integer getDiaPago() {
		return diaPago;
	}

	/**
	 * Sets the dia pago.
	 *
	 * @param diaPago the new dia pago
	 */
	public void setDiaPago(Integer diaPago) {
		this.diaPago = diaPago;
	}

	/**
	 * Gets the fecha captura.
	 *
	 * @return the fecha captura
	 */
	public Date getFechaCaptura() {
		return fechaCaptura;
	}

	/**
	 * Sets the fecha captura.
	 *
	 * @param fechaCaptura the new fecha captura
	 */
	public void setFechaCaptura(Date fechaCaptura) {
		this.fechaCaptura = fechaCaptura;
	}

	/**
	 * Gets the efectivo solicitado.
	 *
	 * @return the efectivo solicitado
	 */
	public Double getEfectivoSolicitado() {
		return efectivoSolicitado;
	}

	/**
	 * Sets the efectivo solicitado.
	 *
	 * @param efectivoSolicitado the new efectivo solicitado
	 */
	public void setEfectivoSolicitado(Double efectivoSolicitado) {
		this.efectivoSolicitado = efectivoSolicitado;
	}

	/**
	 * Gets the codigo destino credito.
	 *
	 * @return the codigo destino credito
	 */
	public String getCodigoDestinoCredito() {
		return codigoDestinoCredito;
	}

	/**
	 * Sets the codigo destino credito.
	 *
	 * @param codigoDestinoCredito the new codigo destino credito
	 */
	public void setCodigoDestinoCredito(String codigoDestinoCredito) {
		this.codigoDestinoCredito = codigoDestinoCredito;
	}

	/**
	 * Gets the seguro.
	 *
	 * @return the seguro
	 */
	public String getSeguro() {
		return seguro;
	}

	/**
	 * Sets the seguro.
	 *
	 * @param seguro the new seguro
	 */
	public void setSeguro(String seguro) {
		this.seguro = seguro;
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
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}

	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
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
}
