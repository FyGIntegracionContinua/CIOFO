package utilitario.mensajes.condonaciones;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaDatosRespuesta.
 */
public class ConsultaDatosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva consulta datos respuesta.
	 */
	public ConsultaDatosRespuesta() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The peticion_ofs. */
	private String peticion_ofs;

	/** The identificador. */
	private String identificador;

	/** The resultado. */
	private String resultado;

	/** The mensaje. */
	private String mensaje;

	/** The capital pd. */
	private String capitalPD;

	/** The interes pd. */
	private String interesPD;

	/** The recargos. */
	private String recargos;

	/**
	 * Obtiene resultado.
	 *
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * Establece resultado.
	 *
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	/**
	 * Obtiene mensaje.
	 *
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * Establece mensaje.
	 *
	 * @param mensaje the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * Obtiene capital pd.
	 *
	 * @return the capitalPD
	 */
	public String getCapitalPD() {
		return capitalPD;
	}

	/**
	 * Establece capital pd.
	 *
	 * @param capitalPD the capitalPD to set
	 */
	public void setCapitalPD(String capitalPD) {
		this.capitalPD = capitalPD;
	}

	/**
	 * Obtiene interes pd.
	 *
	 * @return the interesPD
	 */
	public String getInteresPD() {
		return interesPD;
	}

	/**
	 * Establece interes pd.
	 *
	 * @param interesPD the interesPD to set
	 */
	public void setInteresPD(String interesPD) {
		this.interesPD = interesPD;
	}

	/**
	 * Obtiene recargos.
	 *
	 * @return the recargos
	 */
	public String getRecargos() {
		return recargos;
	}

	/**
	 * Establece recargos.
	 *
	 * @param recargos the recargos to set
	 */
	public void setRecargos(String recargos) {
		this.recargos = recargos;
	}

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header            the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene peticion_ofs.
	 *
	 * @return the peticion_ofs
	 */
	public String getPeticion_ofs() {
		return peticion_ofs;
	}

	/**
	 * Establece peticion_ofs.
	 *
	 * @param peticion_ofs            the peticion_ofs to set
	 */
	public void setPeticion_ofs(String peticion_ofs) {
		this.peticion_ofs = peticion_ofs;
	}

	/**
	 * Obtiene identificador.
	 *
	 * @return the identificador
	 */
	public String getIdentificador() {
		return identificador;
	}

	/**
	 * Establece identificador.
	 *
	 * @param identificador            the identificador to set
	 */
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
}
