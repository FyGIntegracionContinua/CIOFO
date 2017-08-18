package utilitario.mensajes.operacion.cierre;

import utilitario.mensajes.comun.EncabezadoRespuesta;


/**
 * @author out_mreyes
 *
 */
public 	class 	OperacionCierreRespuesta extends utilitario.mensajes.comun.ObjetoValor {


	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 3607220935572574615L;

	/**
	 * encabezadoRespuesta utilitario.mensajes.comun.EncabezadoRespuesta
	 */
	private utilitario.mensajes.comun.EncabezadoRespuesta encabezadoRespuesta; //El encabezado de la respuesta

	/**
	 * OperacionCierreRespuesta
	 */
	public OperacionCierreRespuesta() {
		encabezadoRespuesta = new EncabezadoRespuesta();
		}

	/**
	 * @return the encabezadoRespuesta
	 */
	public utilitario.mensajes.comun.EncabezadoRespuesta getEncabezadoRespuesta() {
		return encabezadoRespuesta;
	}

	/**
	 * @param encabezadoRespuesta the encabezadoRespuesta to set
	 */
	public void setEncabezadoRespuesta(
			utilitario.mensajes.comun.EncabezadoRespuesta encabezadoRespuesta) {
		this.encabezadoRespuesta = encabezadoRespuesta;
	}

	}
