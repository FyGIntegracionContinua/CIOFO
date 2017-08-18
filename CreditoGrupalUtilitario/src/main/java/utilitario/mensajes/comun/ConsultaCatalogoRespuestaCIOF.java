/**
 *
 */
package utilitario.mensajes.comun;

import java.util.List;

/**
 * clase que genera la respuesta de los catalogos
 * @author rmontellano
 * @version 4.12
 */
public class ConsultaCatalogoRespuestaCIOF extends ObjetoValor {
	/**
	 * long serialVersionUID
	 */
	private static final long serialVersionUID = -110669935950273003L;
	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;
	/**
	 * List<CatalogosOV> catalogo
	 */
	private List<CatalogosOV> catalogo;

	/**
	 * dias de atraso del contrato anterior
	 */
	private int diasAtraso;

	/**
	 * ConsultaCatalogoRespuesta
	 */
	public ConsultaCatalogoRespuestaCIOF() {
		header = new EncabezadoRespuesta();
	}

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
	 * @return the catalogo
	 */
	public List<CatalogosOV> getCatalogo() {
		return catalogo;
	}

	/**
	 * @param catalogo the catalogo to set
	 */
	public void setCatalogo(List<CatalogosOV> catalogo) {
		this.catalogo = catalogo;
	}

	/**
	 * @return the diasAtraso
	 */
	public int getDiasAtraso() {
		return diasAtraso;
	}

	/**
	 * @param diasAtraso the diasAtraso to set
	 */
	public void setDiasAtraso(int diasAtraso) {
		this.diasAtraso = diasAtraso;
	}

}
