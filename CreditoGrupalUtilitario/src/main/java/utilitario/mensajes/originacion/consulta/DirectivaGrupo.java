package utilitario.mensajes.originacion.consulta;

import java.io.Serializable;
/**
 * clase que se hizo para renovacion financiera
 * @author rmontellano
 * @version 4.10
 */
public class DirectivaGrupo implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 5813313376840982160L;
	/**
	 * nombre de la directiva del grupo.
	 */
	private String nombreDirectivaGrupo;
	/**
	 * puesto en la directiva del grupo.
	 */
	private String puestoDirectivaGrupo;
	/**
	 * @return the nombreDirectivaGrupo
	 */
	public String getNombreDirectivaGrupo() {
		return nombreDirectivaGrupo;
	}
	/**
	 * @param nombreDirectivaGrupo the nombreDirectivaGrupo to set
	 */
	public void setNombreDirectivaGrupo(String nombreDirectivaGrupo) {
		this.nombreDirectivaGrupo = nombreDirectivaGrupo;
	}
	/**
	 * @return the puestoDirectivaGrupo
	 */
	public String getPuestoDirectivaGrupo() {
		return puestoDirectivaGrupo;
	}
	/**
	 * @param puestoDirectivaGrupo the puestoDirectivaGrupo to set
	 */
	public void setPuestoDirectivaGrupo(String puestoDirectivaGrupo) {
		this.puestoDirectivaGrupo = puestoDirectivaGrupo;
	}

}
