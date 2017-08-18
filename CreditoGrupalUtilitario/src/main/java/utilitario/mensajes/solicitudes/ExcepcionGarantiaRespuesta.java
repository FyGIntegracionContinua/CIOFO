package utilitario.mensajes.solicitudes;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ExcepcionGarantiaRespuesta.
 *
 * @author out_gcorzo
 */
public class ExcepcionGarantiaRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva excepcion garantia respuesta.
	 */
	public ExcepcionGarantiaRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The listaExcepciones. */
	private List<BuzonExcepcionOV> listaExcepciones;

	/** The nombreDivisional. */
	private String nombreDivisional;

	/**
	 * @return the nombreDivisional
	 */
	public String getNombreDivisional() {
		return nombreDivisional;
	}

	/**
	 * @param nombreDivisional the nombreDivisional to set
	 */
	public void setNombreDivisional(String nombreDivisional) {
		this.nombreDivisional = nombreDivisional;
	}

	/**
	 * @return the listaExcepciones
	 */
	public List<BuzonExcepcionOV> getListaExcepciones() {
		return listaExcepciones;
	}

	/**
	 * @param listaExcepciones the listaExcepciones to set
	 */
	public void setListaExcepciones(List<BuzonExcepcionOV> listaExcepciones) {
		this.listaExcepciones = listaExcepciones;
	}

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

}
