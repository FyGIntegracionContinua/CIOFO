/**
 * 
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author fperez
 *
 */
public class ConsultaComentariosMensajesAtomosRespuesta extends ObjetoValor{

	/**
	 * La constante serialVersionUID.
	 */
	private static final long serialVersionUID = 2769958428271289246L;
	
	/**
	 * Constructor
	 */
	public ConsultaComentariosMensajesAtomosRespuesta(){
		
	}
	
	private EncabezadoRespuesta header;
	
	private Integer idTarea;
	
	private String solicitud;
	
	private String uid;
	
	/**
	 * Comentarios divisional para aprobacion firma electronica
	 */
	private String comentariosDivisional;
	
	/**
	 * Comentarios Modulo CEC para aprobacion firma electronica
	 */
	private String mensajesCEC;
	
	/**
	 * Comentarios u observaciones para los demas Atomos.
	 */
	private String observaciones;
	
	private String proceso;

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
	 * @return the idTarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * @param idTarea the idTarea to set
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}

	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
	 * @return the comentariosDivisional
	 */
	public String getComentariosDivisional() {
		return comentariosDivisional;
	}

	/**
	 * @param comentariosDivisional the comentariosDivisional to set
	 */
	public void setComentariosDivisional(String comentariosDivisional) {
		this.comentariosDivisional = comentariosDivisional;
	}

	/**
	 * @return the mensajesCEC
	 */
	public String getMensajesCEC() {
		return mensajesCEC;
	}

	/**
	 * @param mensajesCEC the mensajesCEC to set
	 */
	public void setMensajesCEC(String mensajesCEC) {
		this.mensajesCEC = mensajesCEC;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * @param proceso the proceso to set
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

		

}
