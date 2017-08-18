package utilitario.mensajes.impresiondocs.comun;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.impresiondocs.oportunidadcontrato.OportunidadContratoOV;

// TODO: Auto-generated Javadoc
/**
 * The Class PreSolicitudRespuesta.
 */
public class PreSolicitudRespuesta  extends ObjetoValor {

	/** serialVersionUID. */
	private static final long serialVersionUID = 2508549288105878575L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The respuesta datos. */
	private DatosCreditoIntegrantesRespuesta respuestaDatos;

	/** The datos contrato. */
	private ContratoVO datosContrato;

	/** datosGeneralesContrato OportunidadContratoOV. */
	private OportunidadContratoOV datosGeneralesContrato;

	/** The integrantes. */
	private List<MiembroGrupoVO> integrantes;

	/** The solicitud. */
	private KitSolicitudOV solicitud;

	/** The numero miembros. */
	private Integer numeroMiembros;

	/** The fecha solicitud. */
	private String fechaSolicitud;

	/** The monto ahorro total. */
	private Double montoAhorroTotal;

	/** The monto credito total. */
	private Double montoCreditoTotal;

	/** The monto refinanciar total. */
	private Double montoRefinanciarTotal;

	/** The monto ahorro total formato. */
	private String montoAhorroTotalFormato;

	/** The monto credito total formato. */
	private String montoCreditoTotalFormato;

	/** The monto refinanciar total formato. */
	private String montoRefinanciarTotalFormato;

	/**
	 * Gets the header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Sets the header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Gets the datos generales contrato.
	 *
	 * @return the datosGeneralesContrato
	 */
	public OportunidadContratoOV getDatosGeneralesContrato() {
		return datosGeneralesContrato;
	}

	/**
	 * Sets the datos generales contrato.
	 *
	 * @param datosGeneralesContrato the datosGeneralesContrato to set
	 */
	public void setDatosGeneralesContrato(OportunidadContratoOV datosGeneralesContrato) {
		this.datosGeneralesContrato = datosGeneralesContrato;
	}

	/**
	 * Gets the integrantes.
	 *
	 * @return the integrantes
	 */
	public List<MiembroGrupoVO> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Sets the integrantes.
	 *
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<MiembroGrupoVO> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Gets the datos contrato.
	 *
	 * @return the datosContrato
	 */
	public ContratoVO getDatosContrato() {
		return datosContrato;
	}

	/**
	 * Sets the datos contrato.
	 *
	 * @param datosContrato the datosContrato to set
	 */
	public void setDatosContrato(ContratoVO datosContrato) {
		this.datosContrato = datosContrato;
	}

	/**
	 * Gets the respuesta datos.
	 *
	 * @return the respuestaDatos
	 */
	public DatosCreditoIntegrantesRespuesta getRespuestaDatos() {
		return respuestaDatos;
	}

	/**
	 * Sets the respuesta datos.
	 *
	 * @param respuestaDatos the respuestaDatos to set
	 */
	public void setRespuestaDatos(DatosCreditoIntegrantesRespuesta respuestaDatos) {
		this.respuestaDatos = respuestaDatos;
	}

	/**
	 * Gets the solicitud.
	 *
	 * @return the solicitud
	 */
	public KitSolicitudOV getSolicitud() {
		return solicitud;
	}

	/**
	 * Sets the solicitud.
	 *
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(KitSolicitudOV solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Gets the numero miembros.
	 *
	 * @return the numeroMiembros
	 */
	public Integer getNumeroMiembros() {
		return numeroMiembros;
	}

	/**
	 * Sets the numero miembros.
	 *
	 * @param numeroMiembros the numeroMiembros to set
	 */
	public void setNumeroMiembros(Integer numeroMiembros) {
		this.numeroMiembros = numeroMiembros;
	}

	/**
	 * @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * @return the montoAhorroTotal
	 */
	public Double getMontoAhorroTotal() {
		return montoAhorroTotal;
	}

	/**
	 * @param montoAhorroTotal the montoAhorroTotal to set
	 */
	public void setMontoAhorroTotal(Double montoAhorroTotal) {
		this.montoAhorroTotal = montoAhorroTotal;
	}

	/**
	 * @return the montoCreditoTotal
	 */
	public Double getMontoCreditoTotal() {
		return montoCreditoTotal;
	}

	/**
	 * @param montoCreditoTotal the montoCreditoTotal to set
	 */
	public void setMontoCreditoTotal(Double montoCreditoTotal) {
		this.montoCreditoTotal = montoCreditoTotal;
	}

	/**
	 * @return the montoRefinanciarTotal
	 */
	public Double getMontoRefinanciarTotal() {
		return montoRefinanciarTotal;
	}

	/**
	 * @param montoRefinanciarTotal the montoRefinanciarTotal to set
	 */
	public void setMontoRefinanciarTotal(Double montoRefinanciarTotal) {
		this.montoRefinanciarTotal = montoRefinanciarTotal;
	}

	/**
	 * @return the montoAhorroTotalFormato
	 */
	public String getMontoAhorroTotalFormato() {
		return montoAhorroTotalFormato;
	}

	/**
	 * @param montoAhorroTotalFormato the montoAhorroTotalFormato to set
	 */
	public void setMontoAhorroTotalFormato(String montoAhorroTotalFormato) {
		this.montoAhorroTotalFormato = montoAhorroTotalFormato;
	}

	/**
	 * @return the montoCreditoTotalFormato
	 */
	public String getMontoCreditoTotalFormato() {
		return montoCreditoTotalFormato;
	}

	/**
	 * @param montoCreditoTotalFormato the montoCreditoTotalFormato to set
	 */
	public void setMontoCreditoTotalFormato(String montoCreditoTotalFormato) {
		this.montoCreditoTotalFormato = montoCreditoTotalFormato;
	}

	/**
	 * @return the montoRefinanciarTotalFormato
	 */
	public String getMontoRefinanciarTotalFormato() {
		return montoRefinanciarTotalFormato;
	}

	/**
	 * @param montoRefinanciarTotalFormato the montoRefinanciarTotalFormato to set
	 */
	public void setMontoRefinanciarTotalFormato(String montoRefinanciarTotalFormato) {
		this.montoRefinanciarTotalFormato = montoRefinanciarTotalFormato;
	}

}
