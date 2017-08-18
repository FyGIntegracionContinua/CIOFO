package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.reportes.cierre.DesembolsoOpenContractOV;

/**
 * The Class DesembolsoOpenContractRespuesta.
 */
public class DesembolsoOpenContractRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva desembolso open contract respuesta.
	 */
	public DesembolsoOpenContractRespuesta() {
	}
	//Atributos  ---------------------------------------------------------------------------
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5082709112138876166L;
	//Encabezado de cualquier respuesta, contiene el estatus de la ejecucion del metodo
	/** The header. */
	private EncabezadoRespuesta 	header;

	//Lista que contiene los registros de la respuesta
	/** The reporte open contract. */
	private  List<DesembolsoOpenContractOV> reporteOpenContract;

	//Numero de registros que regresa la consulta
	/** The numero resultados. */
	private java.lang.Integer numeroResultados;

	//Getters y Setters  -------------------------------------------------------------------
	/**
	 * Obtiene reporte open contract.
	 *
	 * @return reporte open contract
	 */
	public List<DesembolsoOpenContractOV> getReporteOpenContract() {
		return reporteOpenContract;
	}

	/**
	 * Establece reporte open contract.
	 *
	 * @param reporteOpenContract a reporte open contract
	 */
	public void setReporteOpenContract(List<DesembolsoOpenContractOV> reporteOpenContract) {
		this.reporteOpenContract = reporteOpenContract;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
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
	 * Obtiene numero resultados.
	 *
	 * @return the numeroResultados
	 */
	public java.lang.Integer getNumeroResultados() {
		return numeroResultados;
	}

	/**
	 * Establece numero resultados.
	 *
	 * @param numeroResultados the numeroResultados to set
	 */
	public void setNumeroResultados(java.lang.Integer numeroResultados) {
		this.numeroResultados = numeroResultados;
	}

}
