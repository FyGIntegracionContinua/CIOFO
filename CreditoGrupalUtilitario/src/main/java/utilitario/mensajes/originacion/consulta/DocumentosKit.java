package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

public class DocumentosKit extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 322791026193748447L;

	/** codigo */
	private String codigo;

	/** documento */
	private String documento;

	/** seleccionado */
	private boolean seleccionado;
	/**
	 * @return the documento
	 */
	public String getDocumento() {
		return documento;
	}
	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	/**
	 * @return the seleccionado
	 */
	public boolean isSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(boolean seleccionado) {
		this.seleccionado = seleccionado;
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

}
