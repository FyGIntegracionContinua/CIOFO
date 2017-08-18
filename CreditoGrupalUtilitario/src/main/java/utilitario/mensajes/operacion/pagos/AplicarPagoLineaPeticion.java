package utilitario.mensajes.operacion.pagos;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

public class AplicarPagoLineaPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -5728501404482790503L;
	/** idTransaccion */
	private String idTransaccion;
	/** folio */
	private long folio;
	/** contrato */
	private String contrato;
	/** claveCliente */
	private int claveCliente;
	/** peticion */
	private String peticion;
	/** respuesta */
	private String respuesta;
	/** fechaPeticion */
	private Date fechaPeticion;
	/** fechaRespuesta */
	private Date fechaRespuesta;
	/** fechaAplicacion */
	private Date fechaAplicacion;
	/** horaPeticion */
	private Date horaPeticion;
	/** horaRespuesta */
	private Date horaRespuesta;
	/** horaAplicacion */
	private Date horaAplicacion;
	/** noIntento */
	private int idAutorizacion;
	/** noIntento */
	private int noIntento;
	/** usuario */
	private String usuario;
	/** estatus */
	private String estatus;
	/** tipoOperacion */
	private String tipoOperacion;
	/** persona */
	private String persona;
	/** idTransProveedor */
	private String idTransProveedor;
	/** monto */
	private double monto;

	/**
	 * @return the idTransaccion
	 */
	public String getIdTransaccion() {
		return idTransaccion;
	}
	/**
	 * @param idTransaccion the idTransaccion to set
	 */
	public void setIdTransaccion(String idTransaccion) {
		this.idTransaccion = idTransaccion;
	}
	/**
	 * @return the folio
	 */
	public long getFolio() {
		return folio;
	}
	/**
	 * @param folio the folio to set
	 */
	public void setFolio(long folio) {
		this.folio = folio;
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
	 * @return the claveCliente
	 */
	public int getClaveCliente() {
		return claveCliente;
	}
	/**
	 * @param claveCliente the claveCliente to set
	 */
	public void setClaveCliente(int claveCliente) {
		this.claveCliente = claveCliente;
	}
	/**
	 * @return the peticion
	 */
	public String getPeticion() {
		return peticion;
	}
	/**
	 * @param peticion the peticion to set
	 */
	public void setPeticion(String peticion) {
		this.peticion = peticion;
	}
	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}
	/**
	 * @param respuesta the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	/**
	 * @return the fechaPeticion
	 */
	public Date getFechaPeticion() {
		return fechaPeticion;
	}
	/**
	 * @param fechaPeticion the fechaPeticion to set
	 */
	public void setFechaPeticion(Date fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}
	/**
	 * @return the fechaRespuesta
	 */
	public Date getFechaRespuesta() {
		return fechaRespuesta;
	}
	/**
	 * @param fechaRespuesta the fechaRespuesta to set
	 */
	public void setFechaRespuesta(Date fechaRespuesta) {
		this.fechaRespuesta = fechaRespuesta;
	}
	/**
	 * @return the fechaAplicacion
	 */
	public Date getFechaAplicacion() {
		return fechaAplicacion;
	}
	/**
	 * @param fechaAplicacion the fechaAplicacion to set
	 */
	public void setFechaAplicacion(Date fechaAplicacion) {
		this.fechaAplicacion = fechaAplicacion;
	}
	/**
	 * @return the horaPeticion
	 */
	public Date getHoraPeticion() {
		return horaPeticion;
	}
	/**
	 * @param horaPeticion the horaPeticion to set
	 */
	public void setHoraPeticion(Date horaPeticion) {
		this.horaPeticion = horaPeticion;
	}
	/**
	 * @return the horaRespuesta
	 */
	public Date getHoraRespuesta() {
		return horaRespuesta;
	}
	/**
	 * @param horaRespuesta the horaRespuesta to set
	 */
	public void setHoraRespuesta(Date horaRespuesta) {
		this.horaRespuesta = horaRespuesta;
	}
	/**
	 * @return the horaAplicacion
	 */
	public Date getHoraAplicacion() {
		return horaAplicacion;
	}
	/**
	 * @param horaAplicacion the horaAplicacion to set
	 */
	public void setHoraAplicacion(Date horaAplicacion) {
		this.horaAplicacion = horaAplicacion;
	}
	/**
	 * @return the noIntento
	 */
	public int getNoIntento() {
		return noIntento;
	}
	/**
	 * @param noIntento the noIntento to set
	 */
	public void setNoIntento(int noIntento) {
		this.noIntento = noIntento;
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
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}
	/**
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	/**
	 * @return the tipoOperacion
	 */
	public String getTipoOperacion() {
		return tipoOperacion;
	}
	/**
	 * @param tipoOperacion the tipoOperacion to set
	 */
	public void setTipoOperacion(String tipoOperacion) {
		this.tipoOperacion = tipoOperacion;
	}
	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}
	/**
	 * @return the idTransProveedor
	 */
	public String getIdTransProveedor() {
		return idTransProveedor;
	}
	/**
	 * @param idTransProveedor the idTransProveedor to set
	 */
	public void setIdTransProveedor(String idTransProveedor) {
		this.idTransProveedor = idTransProveedor;
	}
	/**
	 * @return the idAutorizacion
	 */
	public int getIdAutorizacion() {
		return idAutorizacion;
	}
	/**
	 * @param idAutorizacion the idAutorizacion to set
	 */
	public void setIdAutorizacion(int idAutorizacion) {
		this.idAutorizacion = idAutorizacion;
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

}
