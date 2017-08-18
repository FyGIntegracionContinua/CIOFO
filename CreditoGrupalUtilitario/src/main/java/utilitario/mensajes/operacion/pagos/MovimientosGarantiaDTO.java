/**
 *
 */
package utilitario.mensajes.operacion.pagos;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author ca.ocampo
 *
 */
public class MovimientosGarantiaDTO extends ObjetoValor {

	/**
	 * Number Serial Version
	 */
	private static final long serialVersionUID = -2267990774853216501L;

	/**
	 *contrato.
	 */
	private String contrato;
	/**
	 *codigo.
	 */
	private String codigo;

	/**
	 *decripcionCodigo.
	 */
	private String descripcionCodigo;

	/**
	 *fechaHora.
	 */
	private Date fechaHora;
	/**
	 *fechaContable.
	 */
	private String fechaContable;
	/**
	 *fechaValor.
	 */
	private String fechaValor;
	/**
	 *importe.
	 */
	private double importe;
	/**
	 *usuario.
	 */
	private String usuario;
	/**
	 *status.
	 */
	private String status;
	/**
	 *integrante.
	 */
	private String referencia;


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
	public Date getFechaHora() {
		return fechaHora;
	}
	/**
	 * @param fechaHora the fechaHora to set
	 */
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	/**
	 * @return the fechaContable
	 */
	public String getFechaContable() {
		return fechaContable;
	}
	/**
	 * @param fechaContable the fechaContable to set
	 */
	public void setFechaContable(String fechaContable) {
		this.fechaContable = fechaContable;
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
	public double getImporte() {
		return importe;
	}
	/**
	 * @param importe the importe to set
	 */
	public void setImporte(double importe) {
		this.importe = importe;
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
	/**
	 * @return the referencia
	 */
	public String getReferencia() {
		return referencia;
	}
	/**
	 * @param referencia the referencia to set
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

}
