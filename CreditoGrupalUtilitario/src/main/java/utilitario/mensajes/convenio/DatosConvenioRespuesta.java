package utilitario.mensajes.convenio;



import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 *
 */
public class DatosConvenioRespuesta extends ObjetoValor {

	/**
	 * DatosConvenioRespuesta
	 */
	public DatosConvenioRespuesta() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 2326591188947092766L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta	header;
	/**
	 * convenio ConvenioOV
	 */
	private ConvenioOV convenio;

	/**
	 * @return .
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
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
	public ConvenioOV getConvenio() {
		return convenio;
	}
	/**
	 * @param convenio .
	 */
	public void setConvenio(ConvenioOV convenio) {
		this.convenio = convenio;
	}

}
