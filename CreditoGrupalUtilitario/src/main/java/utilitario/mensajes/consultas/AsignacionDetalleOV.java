package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AsignacionDetalleOV.
 *
 * @author rguadarramac
 */
public class AsignacionDetalleOV extends ObjetoValor {

	/** se genero clave unica. */
	private static final long serialVersionUID = 3100610127466534392L;


	//PARTE DE DATOS GENERALES PARA LAS ASIGNACIONES
	/** numeroSucursal entero. */
	private Integer 	numeroSucursal;

	/** nomSucursal String. */
	private String		nomSucursal;

	/** diaReunion entero. */
	private Integer		diaReunion;

	/** horaReunionInicio string. */
	private String		horaReunionInicio;

	/** horaReunionFin string. */
	private String		horaReunionFin;

	/**   numeroSemana entero Variable para el incremento en 7 dias. */
	private Integer		numeroSemana;



	//Parte para las tareas pendientes
	/** The tipo tarea. */
	private String		tipoTarea;

	/** The numero usuario alta. */
	private String		numeroUsuarioAlta;

	/** The perfil. */
	private String		perfil;

	/** The id tarea. */
	private Integer		idTarea;

	/** The motivo reasignacion. */
	private String 		motivoReasignacion;

	/** The miembros. */
	private Integer		miembros;

	/** The dia reunion nuevo. */
	private Integer		diaReunionNuevo;

	/** The hora reunion inicio nuevo. */
	private String		horaReunionInicioNuevo;

	/** The hora reunion fin nuevo. */
	private String		horaReunionFinNuevo;

	/** The numero asesor nuevo. */
	private String  	numeroAsesorNuevo;

	/** The nombre asesor nuevo. */
	private String 		nombreAsesorNuevo;

	/** The status. */
	private String		status;


	//DATOS DE UN CONTRATO DE UNA ASIGNACION LOS CUALES APARECEN EN EL UNIVERSO DE LAS ASIGNACIONES
	/** contratoLD string. */
	private String 		contratoLD;

	/** contrato string. */
	private String		contrato;

	/** nombreGrupo string. */
	private String		nombreGrupo;

	/** cicloGrupo entero. */
	private Integer     cicloGrupo;

	/** numeroAsesor string. */
	private String  	numeroAsesor;

	/** nombreAsesor string. */
	private String 		nombreAsesor;

	/** totalIntegrantes entero. */
	private Integer 	totalIntegrantes;

	/** producto string. */
	private String		producto;

	/** descProd string. */
	private String		descProd;

	/** fechaInicio string. */
	private String		fechaInicio;		//colocacion del Grupo

	/** fechaFin string. */
	private String	 	fechaFin;			//fin del ciclo

	/** numeroPagos entero. */
	private Integer 	numeroPagos;

	/** pagosRestantes entero. */
	private Integer 	pagosRestantes;

	/** diasMora entero. */
	private Integer 	diasMora;

	/** saldoTotal double. */
	private Double		saldoTotal;

	/** frecuencia string. */
	private String 		frecuencia;

	/** tipoActividad string. */
	private String		tipoActividad;

	/** parcialidad Double. */
	private Double 		parcialidad;


	//VARIABLE PARA OBTENER VALIDACION POR CLIENTE RENOVACIONES FINANCIADAS.

	/**
	 * cliente
	 */
	private String cliente;

	/** idSolicitud string. */
	private String		idSolicitud;

	//METODOS GETTERS AND SETTERS
	/**
	 * AsignacionDetalleOV.
	 */
	public AsignacionDetalleOV() {
	}

	/**
	 * Establece numero sucursal.
	 *
	 * @param numeroSucursal entero
	 */
	public void setNumeroSucursal(Integer numeroSucursal) {
		this.numeroSucursal = numeroSucursal;
	}

	/**
	 * Obtiene numero sucursal.
	 *
	 * @return numeroSucursal
	 */
	public Integer getNumeroSucursal() {
		return numeroSucursal;
	}

	/**
	 * Establece dia reunion.
	 *
	 * @param diaReunion tipo Integer
	 */
	public void setDiaReunion(Integer diaReunion) {
		this.diaReunion = diaReunion;
	}

	/**
	 * Obtiene dia reunion.
	 *
	 * @return diaReunion
	 */
	public Integer getDiaReunion() {
		return diaReunion;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD String
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Obtiene contrato ld.
	 *
	 * @return contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato String
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo String
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene ciclo grupo.
	 *
	 * @return cicloGrupo
	 */
	public Integer getCicloGrupo() {
		return cicloGrupo;
	}

	/**
	 * Establece ciclo grupo.
	 *
	 * @param cicloGrupo Integer
	 */
	public void setCicloGrupo(Integer cicloGrupo) {
		this.cicloGrupo = cicloGrupo;
	}

	/**
	 * Obtiene numero asesor.
	 *
	 * @return numeroAsesor
	 */
	public String getNumeroAsesor() {
		return numeroAsesor;
	}

	/**
	 * Establece numero asesor.
	 *
	 * @param numeroAsesor String
	 */
	public void setNumeroAsesor(String numeroAsesor) {
		this.numeroAsesor = numeroAsesor;
	}

	/**
	 * Obtiene nombre asesor.
	 *
	 * @return nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * Establece nombre asesor.
	 *
	 * @param nombreAsesor String
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * Obtiene total integrantes.
	 *
	 * @return totalIntegrantes
	 */
	public Integer getTotalIntegrantes() {
		return totalIntegrantes;
	}

	/**
	 * Establece total integrantes.
	 *
	 * @param totalIntegrantes Integer
	 */
	public void setTotalIntegrantes(Integer totalIntegrantes) {
		this.totalIntegrantes = totalIntegrantes;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * Establece producto.
	 *
	 * @param producto String
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * Establece desc prod.
	 *
	 * @param descProd String
	 */
	public void setDescProd(String descProd) {
		this.descProd = descProd;
	}

	/**
	 * Obtiene desc prod.
	 *
	 * @return descProd
	 */
	public String getDescProd() {
		return descProd;
	}

	/**
	 * Obtiene fecha inicio.
	 *
	 * @return fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio String
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	/**
	 * Obtiene fecha fin.
	 *
	 * @return fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}

	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin String
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	/**
	 * Obtiene numero pagos.
	 *
	 * @return numeroPagos
	 */
	public Integer getNumeroPagos() {
		return numeroPagos;
	}

	/**
	 * Establece numero pagos.
	 *
	 * @param numeroPagos Integer
	 */
	public void setNumeroPagos(Integer numeroPagos) {
		this.numeroPagos = numeroPagos;
	}

	/**
	 * Obtiene pagos restantes.
	 *
	 * @return pagosRestantes
	 */
	public Integer getPagosRestantes() {
		return pagosRestantes;
	}

	/**
	 * Establece pagos restantes.
	 *
	 * @param pagosRestantes Integer
	 */
	public void setPagosRestantes(Integer pagosRestantes) {
		this.pagosRestantes = pagosRestantes;
	}

	/**
	 * Obtiene dias mora.
	 *
	 * @return diasMora
	 */
	public Integer getDiasMora() {
		return diasMora;
	}

	/**
	 * Establece dias mora.
	 *
	 * @param diasMora Integer
	 */
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}

	/**
	 * Obtiene saldo total.
	 *
	 * @return saldoTotal
	 */
	public Double getSaldoTotal() {
		return saldoTotal;
	}

	/**
	 * Establece saldo total.
	 *
	 * @param saldoTotal Double
	 */
	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}

	/**
	 * Obtiene hora reunion inicio.
	 *
	 * @return horaReunionInicio
	 */
	public String getHoraReunionInicio() {
		return horaReunionInicio;
	}

	/**
	 * Establece hora reunion inicio.
	 *
	 * @param horaReunionInicio String
	 */
	public void setHoraReunionInicio(String horaReunionInicio) {
		this.horaReunionInicio = horaReunionInicio;
	}

	/**
	 * Obtiene hora reunion fin.
	 *
	 * @return horaReunionFin
	 */
	public String getHoraReunionFin() {
		return horaReunionFin;
	}

	/**
	 * Establece hora reunion fin.
	 *
	 * @param horaReunionFin String
	 */
	public void setHoraReunionFin(String horaReunionFin) {
		this.horaReunionFin = horaReunionFin;
	}

	/**
	 * Obtiene frecuencia.
	 *
	 * @return frecuencia
	 */
	public String getFrecuencia() {
		return frecuencia;
	}

	/**
	 * Establece frecuencia.
	 *
	 * @param frecuencia String
	 */
	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}

	/**
	 * Obtiene tipo actividad.
	 *
	 * @return tipoActividad
	 */
	public String getTipoActividad() {
		return tipoActividad;
	}

	/**
	 * Establece tipo actividad.
	 *
	 * @param tipoActividad String
	 */
	public void setTipoActividad(String tipoActividad) {
		this.tipoActividad = tipoActividad;
	}

	/**
	 * Establece numero semana.
	 *
	 * @param numeroSemana Integer
	 */
	public void setNumeroSemana(Integer numeroSemana) {
		this.numeroSemana = numeroSemana;
	}

	/**
	 * Obtiene numero semana.
	 *
	 * @return numeroSemana
	 */
	public Integer getNumeroSemana() {
		return numeroSemana;
	}

	/**
	 * Obtiene parcialidad.
	 *
	 * @return parcialidad
	 */
	public Double getParcialidad() {
		return parcialidad;
	}

	/**
	 * Establece parcialidad.
	 *
	 * @param parcialidad a parcialidad
	 */
	public void setParcialidad(Double parcialidad) {
		this.parcialidad = parcialidad;
	}

	/**
	 * Obtiene tipo tarea.
	 *
	 * @return tipo tarea
	 */
	public String getTipoTarea() {
		return tipoTarea;
	}

	/**
	 * Establece tipo tarea.
	 *
	 * @param tipoTarea a tipo tarea
	 */
	public void setTipoTarea(String tipoTarea) {
		this.tipoTarea = tipoTarea;
	}

	/**
	 * Obtiene numero usuario alta.
	 *
	 * @return numero usuario alta
	 */
	public String getNumeroUsuarioAlta() {
		return numeroUsuarioAlta;
	}

	/**
	 * Establece numero usuario alta.
	 *
	 * @param numeroUsuarioAlta a numero usuario alta
	 */
	public void setNumeroUsuarioAlta(String numeroUsuarioAlta) {
		this.numeroUsuarioAlta = numeroUsuarioAlta;
	}

	/**
	 * Obtiene perfil.
	 *
	 * @return perfil
	 */
	public String getPerfil() {
		return perfil;
	}

	/**
	 * Establece perfil.
	 *
	 * @param perfil a perfil
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}

	/**
	 * Obtiene motivo reasignacion.
	 *
	 * @return motivo reasignacion
	 */
	public String getMotivoReasignacion() {
		return motivoReasignacion;
	}

	/**
	 * Establece motivo reasignacion.
	 *
	 * @param motivoReasignacion a motivo reasignacion
	 */
	public void setMotivoReasignacion(String motivoReasignacion) {
		this.motivoReasignacion = motivoReasignacion;
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
	 * Obtiene id tarea.
	 *
	 * @return id tarea
	 */
	public Integer getIdTarea() {
		return idTarea;
	}

	/**
	 * Obtiene dia reunion nuevo.
	 *
	 * @return dia reunion nuevo
	 */
	public Integer getDiaReunionNuevo() {
		return diaReunionNuevo;
	}

	/**
	 * Establece dia reunion nuevo.
	 *
	 * @param diaReunionNuevo a dia reunion nuevo
	 */
	public void setDiaReunionNuevo(Integer diaReunionNuevo) {
		this.diaReunionNuevo = diaReunionNuevo;
	}

	/**
	 * Obtiene hora reunion inicio nuevo.
	 *
	 * @return hora reunion inicio nuevo
	 */
	public String getHoraReunionInicioNuevo() {
		return horaReunionInicioNuevo;
	}

	/**
	 * Establece hora reunion inicio nuevo.
	 *
	 * @param horaReunionInicioNuevo a hora reunion inicio nuevo
	 */
	public void setHoraReunionInicioNuevo(String horaReunionInicioNuevo) {
		this.horaReunionInicioNuevo = horaReunionInicioNuevo;
	}

	/**
	 * Obtiene hora reunion fin nuevo.
	 *
	 * @return hora reunion fin nuevo
	 */
	public String getHoraReunionFinNuevo() {
		return horaReunionFinNuevo;
	}

	/**
	 * Establece hora reunion fin nuevo.
	 *
	 * @param horaReunionFinNuevo a hora reunion fin nuevo
	 */
	public void setHoraReunionFinNuevo(String horaReunionFinNuevo) {
		this.horaReunionFinNuevo = horaReunionFinNuevo;
	}

	/**
	 * Obtiene numero asesor nuevo.
	 *
	 * @return numero asesor nuevo
	 */
	public String getNumeroAsesorNuevo() {
		return numeroAsesorNuevo;
	}

	/**
	 * Establece numero asesor nuevo.
	 *
	 * @param numeroAsesorNuevo a numero asesor nuevo
	 */
	public void setNumeroAsesorNuevo(String numeroAsesorNuevo) {
		this.numeroAsesorNuevo = numeroAsesorNuevo;
	}

	/**
	 * Obtiene nombre asesor nuevo.
	 *
	 * @return nombre asesor nuevo
	 */
	public String getNombreAsesorNuevo() {
		return nombreAsesorNuevo;
	}

	/**
	 * Establece nombre asesor nuevo.
	 *
	 * @param nombreAsesorNuevo a nombre asesor nuevo
	 */
	public void setNombreAsesorNuevo(String nombreAsesorNuevo) {
		this.nombreAsesorNuevo = nombreAsesorNuevo;
	}

	/**
	 * Establece miembros.
	 *
	 * @param miembros a miembros
	 */
	public void setMiembros(Integer miembros) {
		this.miembros = miembros;
	}

	/**
	 * Obtiene miembros.
	 *
	 * @return miembros
	 */
	public Integer getMiembros() {
		return miembros;
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
	 * Obtiene status.
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece nom sucursal.
	 *
	 * @param nomSucursal a nom sucursal
	 */
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}

	/**
	 * Obtiene nom sucursal.
	 *
	 * @return nom sucursal
	 */
	public String getNomSucursal() {
		return nomSucursal;
	}

	/**
	 * @return cliente
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * @param cliente a cliente
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * @return the idSolicitud
	 */
	public String getIdSolicitud() {
		return idSolicitud;
	}

	/**
	 * @param idSolicitud the idSolicitud to set
	 */
	public void setIdSolicitud(String idSolicitud) {
		this.idSolicitud = idSolicitud;
	}

}
