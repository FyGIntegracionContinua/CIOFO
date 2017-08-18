package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.impresiondocs.fichapagoespecial.EspecialFichaPago;

public class FichaEspecialRespuesta extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -1185422286004132740L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta	header;
	/**
	 * fichaEspecial
	 */
	private EspecialFichaPago fichaEspecial;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the fichaEspecial
	 */
	public EspecialFichaPago getFichaEspecial() {
		return fichaEspecial;
	}
	/**
	 * @param fichaEspecial the fichaEspecial to set
	 */
	public void setFichaEspecial(EspecialFichaPago fichaEspecial) {
		this.fichaEspecial = fichaEspecial;
	}

}
