/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.originacion.contrato;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ContratoRespuesta.
 *
 * @author Juan Moreno
 * Encapsula los datos de la respuesta de la operacion RegistrarContrato...
 * <ul>
 *  <li>Header con el resultado de la operacion</li>
 *  <li>Identificador del Nuevo contrato.</li>
 *  <li>Numero ld_contrato.</li>
 *  <li>Numero del grupo.</li>
 *  <li>Ciclo actualizado del grupo.</li>
 *  <li>.</li>
 * </ul>
 */
public final class ContratoRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva contrato respuesta.
	 */
	public ContratoRespuesta() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta 	header;

	/** The contrato. */
	private String 			contrato;

	/** The ld_contrato. */
	private String 			ld_contrato;

	/** The grupo. */
	private String 			grupo;

	/** The ciclo. */
	private Integer			ciclo;

	/** The peticion_ofs. */
	private String 			peticion_ofs;

	/** The iva. */
	private Double iva;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public final EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public final void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public final String getContrato( ) {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public final void setContrato( String contrato ) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene ld_contrato.
	 *
	 * @return the ld_contrato
	 */
	public final String getLd_contrato( ) {
		return ld_contrato;
	}

	/**
	 * Establece ld_contrato.
	 *
	 * @param ld_contrato the ld_contrato to set
	 */
	public final void setLd_contrato( String ld_contrato ) {
		this.ld_contrato = ld_contrato;
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public final String getGrupo( ) {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public final void setGrupo( String grupo ) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public final Integer getCiclo( ) {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public final void setCiclo( Integer ciclo ) {
		this.ciclo = ciclo;
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
	 * @param peticion_ofs the peticion_ofs to set
	 */
	public void setPeticion_ofs(String peticion_ofs) {
		this.peticion_ofs = peticion_ofs;
	}

	/**
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}
}
