/**
 *
 */
package utilitario.mensajes.comun;

/**
 * Catalogo de campañas segun el ciclo
 * @author rmontellano
 * @version 4.12
 */
public class CatalogosOV extends ObjetoValor {
	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = -87170596708102813L;
	/**
	 * String codigo
	 */
	private String codigo;
	/**
	 * String descripcion
	 */
	private String descripcion;
	/**
	 * indica que elemento debe estar seleccionado en el combo
	 */
	private int seleccionado;
	
	private String tipoPerfil;

	/**
	 * CatalogosOV
	 */
	public CatalogosOV() {

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
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the seleccionado
	 */
	public int getSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(int seleccionado) {
		this.seleccionado = seleccionado;
	}
	/**
	 * @return the tipoPerfil
	 */
	public String getTipoPerfil() {
		return tipoPerfil;
	}
	/**
	 * @param tipoPerfil the tipoPerfil to set
	 */
	public void setTipoPerfil(String tipoPerfil) {
		this.tipoPerfil = tipoPerfil;
	}
	/* (non-Javadoc)
	 * @see utilitario.mensajes.comun.ObjetoValor#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Codigo: " + codigo + "\nDecripcion: " + descripcion
				+ "Seleccionado: " + seleccionado + " Persona: " + tipoPerfil;
	}
	
	
}
