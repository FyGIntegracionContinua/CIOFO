/**
 * Detalle de movimiento deposito garantia
 */
package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author hsamano
 *
 */
public class MovimientoDetalleDepgar extends ObjetoValor {

	/**
	 * Serializable
	 */
	private static final long serialVersionUID = 8881290913625483302L;

	/** Contrato */
	private String contrato;

	/** Codigo */
	private String codigo;

	/** descripcion del codigo */
	private String descripcionCodigo;

	/** Fecha hora */
	private String fechaHora;

	/** Fecha Valor */
	private String fechaValor;

	/** importe */
	private String importe;

	/** saldoGarantia */
	private String saldoGarantia;

	/** usuario */
	private String usuario;

	/** status */
	private String status;

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
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the descripcionCodigo
	 */
	public String getDescripcionCodigo() {
		return descripcionCodigo;
	}

	/**
	 * @param descripcionCodigo the descripcionCodigo to set
	 */
	public void setDescripcionCodigo(String descripcionCodigo) {
		this.descripcionCodigo = descripcionCodigo;
	}

	/**
	 * @return the fechaHora
	 */
	public String getFechaHora() {
		return fechaHora;
	}

	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(String fechaHora) {
		this.fechaHora = fechaHora;
	}

	/**
	 * @return the fechaValor
	 */
	public String getFechaValor() {
		return fechaValor;
	}

	/**
	 * @param fechaValor the fechaValor to set
	 */
	public void setFechaValor(String fechaValor) {
		this.fechaValor = fechaValor;
	}

	/**
	 * @return the importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * @param importe the importe to set
	 */
	public void setImporte(String importe) {
		this.importe = importe;
	}

	/**
	 * @return the saldoGarantia
	 */
	public String getSaldoGarantia() {
		return saldoGarantia;
	}

	/**
	 * @param saldoGarantia the saldoGarantia to set
	 */
	public void setSaldoGarantia(String saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
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
}
