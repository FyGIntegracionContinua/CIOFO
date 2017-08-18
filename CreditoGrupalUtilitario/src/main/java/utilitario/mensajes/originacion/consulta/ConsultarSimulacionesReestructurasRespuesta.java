package utilitario.mensajes.originacion.consulta;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCargaTrabajoRespuesta.
 *
 * @author rguadarramac
 */
public class ConsultarSimulacionesReestructurasRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva reasignar carga trabajo respuesta.
	 */
	public ConsultarSimulacionesReestructurasRespuesta() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The simulacion. */
	private SimulacionReestructuraOV simulacion;

	/** The simulaciones. */
	private List<SimulacionReestructuraOV> simulaciones;

	/** The datos contrato anterior. */
	private SimulacionReestructuraOV datosContratoAnterior;

	/** The integrantes. */
	private List<SimulacionReestructuraIntOV> integrantes;

	/** The header. */
	private EncabezadoRespuesta header;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
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
	 * Gets the simulacion.
	 *
	 * @return the simulacion
	 */
	public SimulacionReestructuraOV getSimulacion() {
		return simulacion;
	}

	/**
	 * Sets the simulacion.
	 *
	 * @param simulacion the new simulacion
	 */
	public void setSimulacion(SimulacionReestructuraOV simulacion) {
		this.simulacion = simulacion;
	}

	/**
	 * Gets the integrantes.
	 *
	 * @return the integrantes
	 */
	public List<SimulacionReestructuraIntOV> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Sets the integrantes.
	 *
	 * @param integrantes the new integrantes
	 */
	public void setIntegrantes(List<SimulacionReestructuraIntOV> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Gets the simulaciones.
	 *
	 * @return the simulaciones
	 */
	public List<SimulacionReestructuraOV> getSimulaciones() {
		return simulaciones;
	}

	/**
	 * Sets the simulaciones.
	 *
	 * @param simulaciones the new simulaciones
	 */
	public void setSimulaciones(List<SimulacionReestructuraOV> simulaciones) {
		this.simulaciones = simulaciones;
	}

	/**
	 * Sets the datos contrato anterior.
	 *
	 * @param datosContratoAnterior the new datos contrato anterior
	 */
	public void setDatosContratoAnterior(SimulacionReestructuraOV datosContratoAnterior) {
		this.datosContratoAnterior = datosContratoAnterior;
	}

	/**
	 * Gets the datos contrato anterior.
	 *
	 * @return the datos contrato anterior
	 */
	public SimulacionReestructuraOV getDatosContratoAnterior() {
		return datosContratoAnterior;
	}

}
