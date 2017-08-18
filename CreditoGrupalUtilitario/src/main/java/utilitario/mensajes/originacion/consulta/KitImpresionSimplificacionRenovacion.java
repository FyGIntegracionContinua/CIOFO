package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * objeto principal
 * @author rmontellano
 * @version 4.10
 */
public class KitImpresionSimplificacionRenovacion extends ObjetoValor {
	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 6416429585119582270L;
	/**
	 * ImpresionFormatos impresionFormatos.
	 */
	private ImpresionFormatos impresionFormatos;

	/**
	 * @return the impresionFormatos
	 */
	public ImpresionFormatos getImpresionFormatos() {
		return impresionFormatos;
	}
	/**
	 * @param impresionFormatos the impresionFormatos to set
	 */
	public void setImpresionFormatos(ImpresionFormatos impresionFormatos) {
		this.impresionFormatos = impresionFormatos;
	}

}
