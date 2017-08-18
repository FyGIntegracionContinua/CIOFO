package utilitario.mensajes.originacion.consulta;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ReasignarCargaTrabajoRespuesta.
 *
 * @author rguadarramac
 */
public class InsertarSimulacionesReestructurasPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva reasignar carga trabajo respuesta.
	 */
	public InsertarSimulacionesReestructurasPeticion() {
	}
	/** Se genero nuevo serial. */
	private static final long serialVersionUID = 4771230139176220692L;

	/** The simulacion. */
	private SimulacionReestructuraOV simulacion;

	/** The integrantes. */
	//OJO: esta variable es publica para usarla en el paquete tarea
	public List<SimulacionReestructuraIntOV> integrantes;

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

}
