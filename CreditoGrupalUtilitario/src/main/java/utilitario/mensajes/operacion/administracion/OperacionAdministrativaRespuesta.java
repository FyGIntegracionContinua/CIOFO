package utilitario.mensajes.operacion.administracion;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class OperacionAdministrativaRespuesta.
 */
public 	class 	OperacionAdministrativaRespuesta
		extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -6937337571213976678L;

	//Se almacena el encabezado
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta 	header;
	/**
	 * OperacionAdministrativaRespuesta
	 */
	public OperacionAdministrativaRespuesta() {
		header = new EncabezadoRespuesta();
		}

	/**
	 * @param header .
	 */
	public void setHeader(EncabezadoRespuesta header) {
			this.header = header;
		}

	/**
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
			return header;
		}
	}
