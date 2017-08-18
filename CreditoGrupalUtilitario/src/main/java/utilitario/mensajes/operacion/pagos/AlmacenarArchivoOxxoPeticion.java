package utilitario.mensajes.operacion.pagos;

import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;

public class AlmacenarArchivoOxxoPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -3186256363654868321L;
	/** archivo */
	private String archivo;
	/** usuario */
	private String usuario;
	/** registros */
	private List<RegistroOxxoArchivo> registros;
	/**
	 * @return the archivo
	 */
	public String getArchivo() {
		return archivo;
	}
	/**
	 * @param archivo the archivo to set
	 */
	public void setArchivo(String archivo) {
		this.archivo = archivo;
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
	 * @return the registros
	 */
	public List<RegistroOxxoArchivo> getRegistros() {
		return registros;
	}
	/**
	 * @param registros the registros to set
	 */
	public void setRegistros(List<RegistroOxxoArchivo> registros) {
		this.registros = registros;
	}

}
