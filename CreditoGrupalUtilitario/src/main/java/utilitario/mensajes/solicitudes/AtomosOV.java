package utilitario.mensajes.solicitudes;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class AtomosOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class AtomosOV extends ObjetoValor {

	/**
	 * Instancia una nueva atomos ov.
	 */
	public AtomosOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -810147433747092963L;

	/** The id atomo. */
	private Integer idAtomo;

	/** The proceso. */
	private String proceso;

	/** The id proceso. */
	private Double idProceso;

	/** The id tarea. */
	private Integer idTarea;

	/** The solicitud. */
	private String solicitud;

	/** The cliente. */
	private String cliente;

	/** The usuario genero atomo. */
	private String usuarioGeneroAtomo;

	/** The status. */
	private String status;

	/** The tipo atomo. */
	private String tipoAtomo;

	/** The es critico. */
	private String esCritico;

	/** The etapa. */
	private String etapa;

	/** The hora registro. */
	private String horaRegistro;

	/** The hora resolucion. */
	private Date horaResolucion;

	/** The codigo resolucion. */
	private String codigoResolucion;

	/** The resolucion. */
	private String resolucion;

	/** The comentario. */
	private String comentario;

	/** The id atomo anterior. */
	private Double idAtomoAnterior;

	/** The genero atomo siguiente. */
	private String generoAtomoSiguiente;

	/** The origen error. */
	private String origenError;

	/** The numero integrante. */
	private Integer numeroIntegrante;

	/** The nombre usuario genero atomo. */
	private String nombreUsuarioGeneroAtomo;

	/** The ordenar param. */
	private String ordenar;

	/**checar si se actualiza o no la solicitud*/
	private String actualizarSolicitud;

	/**
	 * @return the ordenar
	 */
	public String getOrdenar() {
		return ordenar;
	}

	/**
	 * @param ordenar the ordenar to set
	 */
	public void setOrdenar(String ordenar) {
		this.ordenar = ordenar;
	}

	/**
	 * Obtiene id atomo.
	 *
	 * @return id atomo
	 */
	public Integer getIdAtomo() {
		return idAtomo;
	}

	/**
	 * Establece id atomo.
	 *
	 * @param idAtomo a id atomo
	 */
	public void setIdAtomo(Integer idAtomo) {
		this.idAtomo = idAtomo;
	}

	/**
	 * Obtiene proceso.
	 *
	 * @return proceso
	 */
	public String getProceso() {
		return proceso;
	}

	/**
	 * Establece proceso.
	 *
	 * @param proceso a proceso
	 */
	public void setProceso(String proceso) {
		this.proceso = proceso;
	}

	/**
	 * Obtiene id proceso.
	 *
	 * @return id proceso
	 */
	public Double getIdProceso() {
		return idProceso;
	}

	/**
	 * Establece id proceso.
	 *
	 * @param idProceso a id proceso
	 */
	public void setIdProceso(Double idProceso) {
		this.idProceso = idProceso;
	}

	/**
	 * Obtiene id tarea.
	 *
	 * @return id tarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * Establece id tarea.
	 *
	 * @param idTarea a id tarea
	 */
	public void setIdTarea(Integer idTarea) {
		this.idTarea = idTarea;
	}

	/**
	 * Obtiene solicitud.
	 *
	 * @return solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud a solicitud
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene cliente.
	 *
	 * @return cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente a cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene usuario genero atomo.
	 *
	 * @return usuario genero atomo
	 */
	public String getUsuarioGeneroAtomo() {
		return usuarioGeneroAtomo;
	}

	/**
	 * Establece usuario genero atomo.
	 *
	 * @param usuarioGeneroAtomo a usuario genero atomo
	 */
	public void setUsuarioGeneroAtomo(String usuarioGeneroAtomo) {
		this.usuarioGeneroAtomo = usuarioGeneroAtomo;
	}

	/**
	 * Obtiene status.
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status a status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Obtiene tipo atomo.
	 *
	 * @return tipo atomo
	 */
	public String getTipoAtomo() {
		return tipoAtomo;
	}

	/**
	 * Establece tipo atomo.
	 *
	 * @param tipoAtomo a tipo atomo
	 */
	public void setTipoAtomo(String tipoAtomo) {
		this.tipoAtomo = tipoAtomo;
	}

	/**
	 * Obtiene es critico.
	 *
	 * @return es critico
	 */
	public String getEsCritico() {
		return esCritico;
	}

	/**
	 * Establece es critico.
	 *
	 * @param esCritico a es critico
	 */
	public void setEsCritico(String esCritico) {
		this.esCritico = esCritico;
	}

	/**
	 * Obtiene etapa.
	 *
	 * @return etapa
	 */
	public String getEtapa() {
		return etapa;
	}

	/**
	 * Establece etapa.
	 *
	 * @param etapa a etapa
	 */
	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}

	/**
	 * Obtiene hora registro.
	 *
	 * @return hora registro
	 */
	public String getHoraRegistro() {
		return horaRegistro;
	}

	/**
	 * Establece hora registro.
	 *
	 * @param horaRegistro a hora registro
	 */
	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
	}

	/**
	 * Obtiene hora resolucion.
	 *
	 * @return hora resolucion
	 */
	public Date getHoraResolucion() {
		return horaResolucion;
	}

	/**
	 * Establece hora resolucion.
	 *
	 * @param horaResolucion a hora resolucion
	 */
	public void setHoraResolucion(Date horaResolucion) {
		this.horaResolucion = horaResolucion;
	}

	/**
	 * Obtiene codigo resolucion.
	 *
	 * @return codigo resolucion
	 */
	public String getCodigoResolucion() {
		return codigoResolucion;
	}

	/**
	 * Establece codigo resolucion.
	 *
	 * @param codigoResolucion a codigo resolucion
	 */
	public void setCodigoResolucion(String codigoResolucion) {
		this.codigoResolucion = codigoResolucion;
	}

	/**
	 * Obtiene resolucion.
	 *
	 * @return resolucion
	 */
	public String getResolucion() {
		return resolucion;
	}

	/**
	 * Establece resolucion.
	 *
	 * @param resolucion a resolucion
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	/**
	 * Obtiene comentario.
	 *
	 * @return comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Establece comentario.
	 *
	 * @param comentario a comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Obtiene id atomo anterior.
	 *
	 * @return id atomo anterior
	 */
	public Double getIdAtomoAnterior() {
		return idAtomoAnterior;
	}

	/**
	 * Establece id atomo anterior.
	 *
	 * @param idAtomoAnterior a id atomo anterior
	 */
	public void setIdAtomoAnterior(Double idAtomoAnterior) {
		this.idAtomoAnterior = idAtomoAnterior;
	}

	/**
	 * Obtiene genero atomo siguiente.
	 *
	 * @return genero atomo siguiente
	 */
	public String getGeneroAtomoSiguiente() {
		return generoAtomoSiguiente;
	}

	/**
	 * Establece genero atomo siguiente.
	 *
	 * @param generoAtomoSiguiente a genero atomo siguiente
	 */
	public void setGeneroAtomoSiguiente(String generoAtomoSiguiente) {
		this.generoAtomoSiguiente = generoAtomoSiguiente;
	}

	/**
	 * Obtiene origen error.
	 *
	 * @return origen error
	 */
	public String getOrigenError() {
		return origenError;
	}

	/**
	 * Establece origen error.
	 *
	 * @param origenError a origen error
	 */
	public void setOrigenError(String origenError) {
		this.origenError = origenError;
	}

	/**
	 * Obtiene numero integrante.
	 *
	 * @return numero integrante
	 */
	public Integer getNumeroIntegrante() {
		return numeroIntegrante;
	}

	/**
	 * Establece numero integrante.
	 *
	 * @param numeroIntegrante a numero integrante
	 */
	public void setNumeroIntegrante(Integer numeroIntegrante) {
		this.numeroIntegrante = numeroIntegrante;
	}

	/**
	 * Obtiene nombre usuario genero atomo.
	 *
	 * @return the nombreUsuarioGeneroAtomo
	 */
	public String getNombreUsuarioGeneroAtomo() {
		return nombreUsuarioGeneroAtomo;
	}

	/**
	 * Establece nombre usuario genero atomo.
	 *
	 * @param nombreUsuarioGeneroAtomo the nombreUsuarioGeneroAtomo to set
	 */
	public void setNombreUsuarioGeneroAtomo(String nombreUsuarioGeneroAtomo) {
		this.nombreUsuarioGeneroAtomo = nombreUsuarioGeneroAtomo;
	}

	/**
	 * @return the actualizarSolicitud
	 */
	public String getActualizarSolicitud() {
		return actualizarSolicitud;
	}

	/**
	 * @param actualizarSolicitud the actualizarSolicitud to set
	 */
	public void setActualizarSolicitud(String actualizarSolicitud) {
		this.actualizarSolicitud = actualizarSolicitud;
	}
}
