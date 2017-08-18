package utilitario.mensajes.correo;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class DatosAdjuntos extends ObjetoValor {

	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = 8549355606004169214L;
	/**
	 * String nombreArchivo
	 */
	private String nombreArchivo;
	/**
	 * String ruta
	 */
	private String ruta;

	/**
	 * DatosAdjuntos
	 */
	public DatosAdjuntos() {

	}

	/**
	 * @return the nombreArchivo
	 */
	public String getNombreArchivo() {
		return nombreArchivo;
	}
	/**
	 * @param nombreArchivo the nombreArchivo to set
	 */
	public void setNombreArchivo(String nombreArchivo) {
		this.nombreArchivo = nombreArchivo;
	}
	/**
	 * @return the ruta
	 */
	public String getRuta() {
		return ruta;
	}
	/**
	 * @param ruta the ruta to set
	 */
	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

}
