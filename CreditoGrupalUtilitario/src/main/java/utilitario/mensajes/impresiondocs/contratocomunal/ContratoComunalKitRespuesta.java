package utilitario.mensajes.impresiondocs.contratocomunal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;
import utilitario.mensajes.impresiondocs.oportunidadcontrato.OportunidadContratoOV;


/**
 * The Class ContratoComunalKitRespuesta.
 */
public class ContratoComunalKitRespuesta  extends ObjetoValor {

	/**
	 * ContratoComunalKitRespuesta.
	 */
	public ContratoComunalKitRespuesta() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 6661572892205793543L;

	/** header EncabezadoRespuesta. */
	private EncabezadoRespuesta header;

	/** datosGeneralesContrato OportunidadContratoOV. */
	private OportunidadContratoOV datosGeneralesContrato;

	/** datosGeneralesContrato OportunidadContratoOV. */
	private OportunidadContratoOV datosGeneralesContratoAnterior;

	/** integrantes List<MiembroGrupoVO>. */
	private List<MiembroGrupoVO> integrantes;

	/** integrantes List<MiembroGrupoVO>. */
	private List<MiembroGrupoVO> integrantesAnterior;

	/** amortizacion List<PagoGrupo>. */
	private List<PagoGrupo> amortizacion;

	/**
	 * Obtiene header.
	 *
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * Obtiene datos generales contrato.
	 *
	 * @return the datosGeneralesContrato
	 */
	public OportunidadContratoOV getDatosGeneralesContrato() {
		return datosGeneralesContrato;
	}

	/**
	 * Establece datos generales contrato.
	 *
	 * @param datosGeneralesContrato the datosGeneralesContrato to set
	 */
	public void setDatosGeneralesContrato(
			OportunidadContratoOV datosGeneralesContrato) {
		this.datosGeneralesContrato = datosGeneralesContrato;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return the integrantes
	 */
	public List<MiembroGrupoVO> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<MiembroGrupoVO> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Obtiene amortizacion.
	 *
	 * @return the amortizacion
	 */
	public List<PagoGrupo> getAmortizacion() {
		return amortizacion;
	}

	/**
	 * Establece amortizacion.
	 *
	 * @param amortizacion the amortizacion to set
	 */
	public void setAmortizacion(List<PagoGrupo> amortizacion) {
		this.amortizacion = amortizacion;
	}

	/**
	 * @return the datosGeneralesContratoAnterior
	 */
	public OportunidadContratoOV getDatosGeneralesContratoAnterior() {
		return datosGeneralesContratoAnterior;
	}

	/**
	 * @param datosGeneralesContratoAnterior the datosGeneralesContratoAnterior to set
	 */
	public void setDatosGeneralesContratoAnterior(
			OportunidadContratoOV datosGeneralesContratoAnterior) {
		this.datosGeneralesContratoAnterior = datosGeneralesContratoAnterior;
	}

	/**
	 * @return the integrantesAnterior
	 */
	public List<MiembroGrupoVO> getIntegrantesAnterior() {
		return integrantesAnterior;
	}

	/**
	 * @param integrantesAnterior the integrantesAnterior to set
	 */
	public void setIntegrantesAnterior(List<MiembroGrupoVO> integrantesAnterior) {
		this.integrantesAnterior = integrantesAnterior;
	}

}
