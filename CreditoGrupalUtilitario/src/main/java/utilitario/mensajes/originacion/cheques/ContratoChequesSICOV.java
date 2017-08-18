/**
 *
 */
package utilitario.mensajes.originacion.cheques;

import java.math.BigDecimal;
import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ContratoChequesSICOV.
 *
 * @author out_jcmoreno
 */
public class ContratoChequesSICOV extends ObjetoValor {

	/**
	 * Instancia una nueva contrato cheques sicov.
	 */
	public ContratoChequesSICOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

 	/** The producto id. */
 	private String productoId;

 	/** The producto. */
 	private String producto;

 	/** The fecha inicio. */
 	private Date fechaInicio;

 	/** The fecha termino. */
 	private Date fechaTermino;

 	/** The sucursal id. */
 	private String sucursalId;

 	/** The sucursal. */
 	private String sucursal;

 	/** The asesor. */
 	private String asesor;

 	/** The nom asesor. */
 	private String nomAsesor;

 	/** The cuenta sucursal id. */
 	private final String cuentaSucursalId = "MXN160400";

 	/** The cuenta sucursal. */
 	private String cuentaSucursal;

 	/** The grupo id. */
 	private String grupoId;

 	/** The grupo. */
 	private String grupo;

 	/** The cuenta grupo id. */
 	private String cuentaGrupoId;

 	/** The fecha. */
 	private Date fecha;

 	/** The num miembros. */
 	private Integer numMiembros;

 	/** The fecha1er pago. */
 	private Date fecha1erPago;

 	/** The fecha proxpago. */
 	private Date fechaProxpago;

 	/** The monto aprobado. */
 	private BigDecimal montoAprobado;

 	/** The monto liq c trant. */
 	private BigDecimal montoLiqCTrant;

 	/** The gerente. */
 	private String gerente;

 	/** The sucursal dir. */
 	private String sucursalDir;

 	/** The fecha lugar. */
 	private String fechaLugar;

 	/** The sucursal edo. */
 	private String sucursalEdo;

 	/** The sucursal cd. */
 	private String sucursalCd;

 	/** The empresa. */
 	private String empresa;

 	/** The sucursal dir sin acento. */
 	private String sucursalDirSinAcento;

 	/** The comision. */
 	private final String comision = "0.00";


	 /** The mensaje. */
 	private String mensaje;

 	/** The status. */
 	private boolean status;

	 /**
 	 * Obtiene status mora.
 	 *
 	 * @return the statusMora
 	 */
	public String getStatusMora() {
		//StatusMora~~	fecha_prox_pago < fechaContable entonces esta en mora... PDO sino vacio...
		if ( this.fecha != null &&  this.fechaProxpago != null ) {
				return this.fecha.after(  this.fechaProxpago ) ? "PDO" : "";
		}
		return  "";
	}


		/**
		 * Obtiene renovacion.
		 *
		 * @return the renovacion
		 */
	public String getRenovacion() {
		if ( montoLiqCTrant != null && montoLiqCTrant.doubleValue() > 0) {
			return "1";
		}
		return "0";
	}


		/**
		 * Obtiene producto id.
		 *
		 * @return the productoId
		 */
		public String getProductoId() {
			return productoId;
		}


		/**
		 * Establece producto id.
		 *
		 * @param productoId the productoId to set
		 */
		public void setProductoId(String productoId) {
			this.productoId = productoId;
		}


		/**
		 * Obtiene producto.
		 *
		 * @return the producto
		 */
		public String getProducto() {
			return producto;
		}


		/**
		 * Establece producto.
		 *
		 * @param producto the producto to set
		 */
		public void setProducto(String producto) {
			this.producto = producto;
		}


		/**
		 * Obtiene fecha inicio.
		 *
		 * @return the fechaInicio
		 */
		public Date getFechaInicio() {
			return fechaInicio;
		}


		/**
		 * Establece fecha inicio.
		 *
		 * @param fechaInicio the fechaInicio to set
		 */
		public void setFechaInicio(Date fechaInicio) {
			this.fechaInicio = fechaInicio;
		}


		/**
		 * Obtiene fecha termino.
		 *
		 * @return the fechaTermino
		 */
		public Date getFechaTermino() {
			return fechaTermino;
		}


		/**
		 * Establece fecha termino.
		 *
		 * @param fechaTermino the fechaTermino to set
		 */
		public void setFechaTermino(Date fechaTermino) {
			this.fechaTermino = fechaTermino;
		}


		/**
		 * Obtiene sucursal id.
		 *
		 * @return the sucursalId
		 */
		public String getSucursalId() {
			return sucursalId;
		}


		/**
		 * Establece sucursal id.
		 *
		 * @param sucursalId the sucursalId to set
		 */
		public void setSucursalId(String sucursalId) {
			this.sucursalId = sucursalId;
		}


		/**
		 * Obtiene sucursal.
		 *
		 * @return the sucursal
		 */
		public String getSucursal() {
			return sucursal;
		}


		/**
		 * Establece sucursal.
		 *
		 * @param sucursal the sucursal to set
		 */
		public void setSucursal(String sucursal) {
			this.sucursal = sucursal;
		}


		/**
		 * Obtiene asesor.
		 *
		 * @return the asesor
		 */
		public String getAsesor() {
			return asesor;
		}


		/**
		 * Establece asesor.
		 *
		 * @param asesor the asesor to set
		 */
		public void setAsesor(String asesor) {
			this.asesor = asesor;
		}


		/**
		 * Obtiene nom asesor.
		 *
		 * @return the nomAsesor
		 */
		public String getNomAsesor() {
			return nomAsesor;
		}


		/**
		 * Establece nom asesor.
		 *
		 * @param nomAsesor the nomAsesor to set
		 */
		public void setNomAsesor(String nomAsesor) {
			this.nomAsesor = nomAsesor;
		}


		/**
		 * Obtiene cuenta sucursal.
		 *
		 * @return the cuentaSucursal
		 */
		public String getCuentaSucursal() {
			return cuentaSucursal;
		}


		/**
		 * Establece cuenta sucursal.
		 *
		 * @param cuentaSucursal the cuentaSucursal to set
		 */
		public void setCuentaSucursal(String cuentaSucursal) {
			this.cuentaSucursal = cuentaSucursal;
		}


		/**
		 * Obtiene grupo id.
		 *
		 * @return the grupoId
		 */
		public String getGrupoId() {
			return grupoId;
		}


		/**
		 * Establece grupo id.
		 *
		 * @param grupoId the grupoId to set
		 */
		public void setGrupoId(String grupoId) {
			this.grupoId = grupoId;
		}


		/**
		 * Obtiene grupo.
		 *
		 * @return the grupo
		 */
		public String getGrupo() {
			return grupo;
		}


		/**
		 * Establece grupo.
		 *
		 * @param grupo the grupo to set
		 */
		public void setGrupo(String grupo) {
			this.grupo = grupo;
		}


		/**
		 * Obtiene fecha.
		 *
		 * @return the fecha
		 */
		public Date getFecha() {
			return fecha;
		}


		/**
		 * Establece fecha.
		 *
		 * @param fecha the fecha to set
		 */
		public void setFecha(Date fecha) {
			this.fecha = fecha;
		}


		/**
		 * Obtiene num miembros.
		 *
		 * @return the numMiembros
		 */
		public Integer getNumMiembros() {
			return numMiembros;
		}


		/**
		 * Establece num miembros.
		 *
		 * @param numMiembros the numMiembros to set
		 */
		public void setNumMiembros(Integer numMiembros) {
			this.numMiembros = numMiembros;
		}


		/**
		 * Obtiene fecha1er pago.
		 *
		 * @return the fecha1erPago
		 */
		public Date getFecha1erPago() {
			return fecha1erPago;
		}


		/**
		 * Establece fecha1er pago.
		 *
		 * @param fecha1erPago the fecha1erPago to set
		 */
		public void setFecha1erPago(Date fecha1erPago) {
			this.fecha1erPago = fecha1erPago;
		}


		/**
		 * Obtiene fecha proxpago.
		 *
		 * @return the fechaProxpago
		 */
		public Date getFechaProxpago() {
			return fechaProxpago;
		}


		/**
		 * Establece fecha proxpago.
		 *
		 * @param fechaProxpago the fechaProxpago to set
		 */
		public void setFechaProxpago(Date fechaProxpago) {
			this.fechaProxpago = fechaProxpago;
		}


		/**
		 * Obtiene monto aprobado.
		 *
		 * @return the montoAprobado
		 */
		public BigDecimal getMontoAprobado() {
			return montoAprobado;
		}


		/**
		 * Establece monto aprobado.
		 *
		 * @param montoAprobado the montoAprobado to set
		 */
		public void setMontoAprobado(BigDecimal montoAprobado) {
			this.montoAprobado = montoAprobado;
		}


		/**
		 * Obtiene monto liq c trant.
		 *
		 * @return the montoLiqCTrant
		 */
		public BigDecimal getMontoLiqCTrant() {
			return montoLiqCTrant;
		}


		/**
		 * Establece monto liq c trant.
		 *
		 * @param montoLiqCTrant the montoLiqCTrant to set
		 */
		public void setMontoLiqCTrant(BigDecimal montoLiqCTrant) {
			this.montoLiqCTrant = montoLiqCTrant;
		}


		/**
		 * Obtiene gerente.
		 *
		 * @return the gerente
		 */
		public String getGerente() {
			return gerente;
		}


		/**
		 * Establece gerente.
		 *
		 * @param gerente the gerente to set
		 */
		public void setGerente(String gerente) {
			this.gerente = gerente;
		}


		/**
		 * Obtiene empresa.
		 *
		 * @return the empresa
		 */
		public String getEmpresa() {
			return empresa;
		}


		/**
		 * Establece empresa.
		 *
		 * @param empresa the empresa to set
		 */
		public void setEmpresa(String empresa) {
			this.empresa = empresa;
		}


		/**
		 * Obtiene mensaje.
		 *
		 * @return the mensaje
		 */
		public String getMensaje() {
			return mensaje;
		}


		/**
		 * Establece mensaje.
		 *
		 * @param mensaje the mensaje to set
		 */
		public void setMensaje(String mensaje) {
			this.mensaje = mensaje;
		}


		/**
		 * Checks if is status.
		 *
		 * @return the status
		 */
		public boolean isStatus() {
			return status;
		}


		/**
		 * Establece status.
		 *
		 * @param status the status to set
		 */
		public void setStatus(boolean status) {
			this.status = status;
		}


		/**
		 * Obtiene cuenta sucursal id.
		 *
		 * @return the cuentaSucursalId
		 */
		public String getCuentaSucursalId() {
			return cuentaSucursalId;
		}


		/**
		 * Obtiene cuenta grupo id.
		 *
		 * @return the cuentaGrupoId
		 */
		public String getCuentaGrupoId() {
			return cuentaGrupoId;
		}


		/**
		 * Obtiene sucursal dir.
		 *
		 * @return the sucursalDir
		 */
		public String getSucursalDir() {
			return sucursalDir;
		}


		/**
		 * Obtiene fecha lugar.
		 *
		 * @return the fechaLugar
		 */
		public String getFechaLugar() {
			return fechaLugar;
		}


		/**
		 * Obtiene sucursal edo.
		 *
		 * @return the sucursalEdo
		 */
		public String getSucursalEdo() {
			return sucursalEdo;
		}


		/**
		 * Obtiene sucursal cd.
		 *
		 * @return the sucursalCd
		 */
		public String getSucursalCd() {
			return sucursalCd;
		}


		/**
		 * Obtiene sucursal dir sin acento.
		 *
		 * @return the sucursalDirSinAcento
		 */
		public String getSucursalDirSinAcento() {
			return sucursalDirSinAcento;
		}


		/**
		 * Obtiene comision.
		 *
		 * @return the comision
		 */
		public String getComision() {
			return comision;
		}


		/**
		 * Establece sucursal dir.
		 *
		 * @param sucursalDir the sucursalDir to set
		 */
		public void setSucursalDir(String sucursalDir) {
			this.sucursalDir = sucursalDir;
		}

		/**
		 * Establece sucursal edo.
		 *
		 * @param sucursalEdo the sucursalEdo to set
		 */
		public void setSucursalEdo(String sucursalEdo) {
			this.sucursalEdo = sucursalEdo;
		}

		/**
		 * Establece sucursal cd.
		 *
		 * @param sucursalCd the sucursalCd to set
		 */
		public void setSucursalCd(String sucursalCd) {
			this.sucursalCd = sucursalCd;
		}

		/**
		 * Establece fecha lugar.
		 *
		 * @param fechaLugar the fechaLugar to set
		 */
		public void setFechaLugar(String fechaLugar) {
			this.fechaLugar = fechaLugar;
		}

		/**
		 * Establece cuenta grupo id.
		 *
		 * @param cuentaGrupoId the cuentaGrupoId to set
		 */
		public void setCuentaGrupoId(String cuentaGrupoId) {
			this.cuentaGrupoId = cuentaGrupoId;
		}


		/**
		 * Establece sucursal dir sin acento.
		 *
		 * @param sucursalDirSinAcento the sucursalDirSinAcento to set
		 */
		public void setSucursalDirSinAcento(String sucursalDirSinAcento) {
			this.sucursalDirSinAcento = sucursalDirSinAcento;
		}

	}
