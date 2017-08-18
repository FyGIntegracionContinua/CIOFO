/**
 * 
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author fperez
 *
 */
public class ConsultaComentariosMensajesAtomosPeticion extends ObjetoValor {
	
	/**
	 * The constant serialVerisonUID.
	 */
	private static final long serialVersionUID = -695190712663528826L;

	/**
	 * Constructor de clase
	 */
	public ConsultaComentariosMensajesAtomosPeticion(){
		
	}
	
	/**
	 * uid
	 */
	private String uid;
	
	/**
	 *  idTarea
	 */
	private Integer idTarea;
	
	/**
	 * Solicitud
	 */
	private String solicitud;
	
	/**
	 * Proceso
	 */
	private String proceso;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getIdTarea() {
		return idTarea;
	}

	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}
	
	public String getProceso() {
		return proceso;
	}

	public void setProceso(String proceso) {
		this.proceso = proceso;
	}
	
}
