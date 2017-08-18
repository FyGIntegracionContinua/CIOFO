package utilitario.mensajes.impresiondocs;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ImpresionDocsConsultaRespuesta.
 */
public class ImpresionDocsConsultaRespuesta extends ObjetoValor {

	/**
	 * ImpresionDocsConsultaRespuesta.
	 */
	public ImpresionDocsConsultaRespuesta() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 1L;

	/** encabezado EncabezadoRespuesta. */
	private EncabezadoRespuesta encabezado;

	/**
	 * Obtiene encabezado.
	 *
	 * @return the encabezado
	 */
	public EncabezadoRespuesta getEncabezado() {
		return encabezado;
	}

	/**
	 * Establece encabezado.
	 *
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(EncabezadoRespuesta encabezado) {
		this.encabezado = encabezado;
	}

	/** ofs_result String. */
	private  String  ofs_result;

	/** msjError String. */
	private String msjError;

	/** numVeces String. */
	private String numVeces;

	/**
	 * Obtiene msj error.
	 *
	 * @return the msjError
	 */
	public String getMsjError() {
		return msjError;
	}

	/**
	 * Establece msj error.
	 *
	 * @param msjError the msjError to set
	 */
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

	/**
	 * Obtiene num veces.
	 *
	 * @return the numVeces
	 */
	public String getNumVeces() {
		return numVeces;
	}

	/**
	 * Establece num veces.
	 *
	 * @param numVeces the numVeces to set
	 */
	public void setNumVeces(String numVeces) {
		this.numVeces = numVeces;
	}

	/**
	 * Obtiene ofs_result.
	 *
	 * @return the ofs_result
	 */
	public String getOfs_result() {
		return ofs_result;
	}

	/**
	 * Establece ofs_result.
	 *
	 * @param ofs_result the ofs_result to set
	 */
	public void setOfs_result(String ofs_result) {
		this.ofs_result = ofs_result;
	}

}
