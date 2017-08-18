package utilitario.mensajes.impresiondocs;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class ImpresionDocsConsultaPeticion extends ObjetoValor {

	/**
	 * ImpresionDocsConsultaPeticion
	 */
	public ImpresionDocsConsultaPeticion() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * encabezado EncabezadoPeticion
	 */
	private EncabezadoPeticion encabezado;
 	/**
 	 * body ImpresionDocsConsulta
 	 */
 	private ImpresionDocsConsulta body;



	/**
	 * @return the data
	 */
	public ImpresionDocsConsulta getBody() {
		return body;
	}
	/**
	 * @param body data the data to set
	 */
	public void setBody(ImpresionDocsConsulta body) {
		this.body = body;
	}
	/**
	 * @return the encabezado
	 */
	public EncabezadoPeticion getEncabezado() {
		return encabezado;
	}
	/**
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(EncabezadoPeticion encabezado) {
		this.encabezado = encabezado;
	}

}
