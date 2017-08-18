/**
 * utilitario.mensajes.operacion.ActaRecaudacionClienteOV.java
 */
package utilitario.mensajes.operacion;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ISC Omar Cruz Carrillo (ocruzc) 21/09/2012
 * @version 1.0
 */
public class ActaRecaudacionClienteOV extends ObjetoValor {


	/**
	 * ActaRecaudacionClienteOV
	 */
	public ActaRecaudacionClienteOV() {
		super();
	}
	/** serialVersionUID. */
	private static final long serialVersionUID = -1926785339282382993L;

	/** Clave de Integrante. */
	private String integrante;
	/** Clave t24. */
	private String claveT24;
	/** Nombre. */
	private String nombre;
	/** Apellido Paterno. */
	private String apellidoPaterno;
	/** Apellido Materno. */
	private String apellidoMaterno;
	/** Monto Total. */
	private Double montoTotal;
	/** Monto del Pago. */
	private Double montoPago;
	/** Monto Recibido. */
	private Double montoRecibido;
	/** Monto Solidario. */
	private Double montoSolidario;
	/** Asistencia. */
	private String asistenciaIntegrante;

	/**
	 * saldoAhorro java.lang.Double
	 */
	private java.lang.Double	saldoAhorro;		//Saldo ahorro del cliente
	/**
	 * saldoSolidario java.lang.Double
	 */
	private java.lang.Double	saldoSolidario;		//La suma del saldo solidario correspondiente a acta_recaudacion
	/**
	 * saldoTotalSistema java.lang.Double
	 */
	private java.lang.Double	saldoTotalSistema;	//Sale del concentrado
	/**
	 * montoEntregado java.lang.Double
	 */
	private java.lang.Double	montoEntregado;		//monto que recibe cada integrante del grupo

	/**
	 * M�todo que regresa el valor del mi�mbro dato integrante.
	 * @return the integrante
	 */
	public String getIntegrante() {
		return integrante;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato integrante.
	 * @param integrante the integrante to set
	 */
	public void setIntegrante(String integrante) {
		this.integrante = integrante;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato nombre.
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato nombre.
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato apellidoPaterno.
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato apellidoPaterno.
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato apellidoMaterno.
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		return apellidoMaterno;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato apellidoMaterno.
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	/**
	 * M�todo que regresa el valor del mi�mbro dato montoTotal.
	 * @return the montoTotal
	 */
	public Double getMontoTotal() {
		return montoTotal;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato montoTotal.
	 * @param montoTotal the montoTotal to set
	 */
	public void setMontoTotal(Double montoTotal) {
		this.montoTotal = montoTotal;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato montoPago.
	 * @return the montoPago
	 */
	public Double getMontoPago() {
		return montoPago;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato montoPago.
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(Double montoPago) {
		this.montoPago = montoPago;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato montoRecibido.
	 * @return the montoRecibido
	 */
	public Double getMontoRecibido() {
		return montoRecibido;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato montoRecibido.
	 * @param montoRecibido the montoRecibido to set
	 */
	public void setMontoRecibido(Double montoRecibido) {
		this.montoRecibido = montoRecibido;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato montoSolidario.
	 * @return the montoSolidario
	 */
	public Double getMontoSolidario() {
		return montoSolidario;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato montoSolidario.
	 * @param montoSolidario the montoSolidario to set
	 */
	public void setMontoSolidario(Double montoSolidario) {
		this.montoSolidario = montoSolidario;
	}
	/**
	 * M�todo que regresa el valor del mi�mbro dato asistenciaIntegrante.
	 * @return the asistenciaIntegrante
	 */
	public String getAsistenciaIntegrante() {
		return asistenciaIntegrante;
	}
	/**
	 * M�todo que establece el valor para el mi�mbro dato asistenciaIntegrante.
	 * @param asistenciaIntegrante the asistenciaIntegrante to set
	 */
	public void setAsistenciaIntegrante(String asistenciaIntegrante) {
		this.asistenciaIntegrante = asistenciaIntegrante;
	}
	/**
	 * @return the claveT24
	 */
	public String getClaveT24() {
		return claveT24;
	}
	/**
	 * @param claveT24 the claveT24 to set
	 */
	public void setClaveT24(String claveT24) {
		this.claveT24 = claveT24;
	}
	/**
	 * @return the saldoAhorro
	 */
	public java.lang.Double getSaldoAhorro() {
		return saldoAhorro;
	}
	/**
	 * @param saldoAhorro the saldoAhorro to set
	 */
	public void setSaldoAhorro(java.lang.Double saldoAhorro) {
		this.saldoAhorro = saldoAhorro;
	}
	/**
	 * @return the saldoSolidario
	 */
	public java.lang.Double getSaldoSolidario() {
		return saldoSolidario;
	}
	/**
	 * @param saldoSolidario the saldoSolidario to set
	 */
	public void setSaldoSolidario(java.lang.Double saldoSolidario) {
		this.saldoSolidario = saldoSolidario;
	}
	/**
	 * @return the saldoTotalSistema
	 */
	public java.lang.Double getSaldoTotalSistema() {
		return saldoTotalSistema;
	}
	/**
	 * @param saldoTotalSistema the saldoTotalSistema to set
	 */
	public void setSaldoTotalSistema(java.lang.Double saldoTotalSistema) {
		this.saldoTotalSistema = saldoTotalSistema;
	}
	/**
	 * @return the montoEntregado
	 */
	public java.lang.Double getMontoEntregado() {
		return montoEntregado;
	}
	/**
	 * @param montoEntregado the montoEntregado to set
	 */
	public void setMontoEntregado(java.lang.Double montoEntregado) {
		this.montoEntregado = montoEntregado;
	}

	}
