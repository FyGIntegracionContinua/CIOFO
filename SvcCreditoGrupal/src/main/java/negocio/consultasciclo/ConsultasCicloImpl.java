package negocio.consultasciclo;

import org.oasisopen.sca.annotation.Reference;

import tarea.consultas.Consultas;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.consultas.ObtenerReferenciasPagoPeticion;
import utilitario.mensajes.consultas.ObtenerReferenciasPagoRespuesta;

/**
 * @author rguadarramac
 * @version 1.0
 *
 */
public class ConsultasCicloImpl implements ConsultasCiclo {

	/**
	 * SCA Component Fabric
	 */
	private Consultas consultas;
	/**
	 * Variable transformador
	 */
	private Transformador transformador;

	/**
	 * @param consultas de tipo Consultas
	 * @param transformador de tipo Transformador
	 */
	public ConsultasCicloImpl(
			@Reference(name = "consultas") Consultas consultas,
			@Reference(name = "transformador") Transformador transformador) {
		this.consultas = consultas;
		this.transformador = transformador;
 		}

	/**
	 * @param peticion para referencias
	 * @return XML de respuesta
	 */
	public String obtenerReferenciasPago(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID(peticion);
		LogHandler.info(uid, getClass(), "obtenerReferenciasPago - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {ObtenerReferenciasPagoPeticion.class,
									ObtenerReferenciasPagoRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final ObtenerReferenciasPagoPeticion   peticionObtenerRef	=
			(ObtenerReferenciasPagoPeticion) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "obtenerReferenciasPago - Datos de entrada : " + peticionObtenerRef);

		//Llamado a función principal
		final ObtenerReferenciasPagoRespuesta respuesta = consultas.obtenerReferenciasPagoSeguros(peticionObtenerRef, uid);
		LogHandler.info(uid, getClass(), "obtenerReferenciasPago - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "obtenerReferenciasPago - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

}
