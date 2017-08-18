package negocio.buro;

import org.oasisopen.sca.annotation.Reference;

import tarea.buro.BuroInternoTarea;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.buro.BuroInternoKitRespuesta;
import utilitario.mensajes.buro.BuroPeticionKit;
import utilitario.mensajes.comun.EncabezadoRespuesta;

/**
 * @author rguadarramac
 * @version 1.0
 *
 */
public class BuroInternoImpl implements BuroInterno {

	/**
	 * Variable kitBuro
	 */
	private BuroInternoTarea kitBuro;
	/**
	 * Variable transformador
	 */
	private Transformador transformador;

	/**
	 * @param kitBuro de tipo BuroInternoTarea
	 * @param transformador de tipo Transformador
	 */
	public BuroInternoImpl(
			@Reference(name = "buro") BuroInternoTarea kitBuro,
			@Reference(name = "transformador") Transformador transformador) {
		this.kitBuro = kitBuro;
		this.transformador = transformador;
 		}

	/**
	 * Metodo de consulta de datos especificos para Buro Interno
	 * @see negocio.buro.BuroInterno#consultaBuroInterno(java.lang.String)
	 * @param peticion tipo String
	 * @return respuestaXML
	 */
	public String consultaBuroInterno(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultaBuroInterno - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {BuroPeticionKit.class,
									BuroInternoKitRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BuroPeticionKit   buroPeticion =
			(BuroPeticionKit) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaBuroInterno - Datos de entrada : " + buroPeticion);

		//Llamado a función principal
		final BuroInternoKitRespuesta respuesta = kitBuro.generaConsultaBuroInterno(uid, buroPeticion);
		LogHandler.info(uid, getClass(), "consultaBuroInterno - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "consultaBuroInterno - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}

}
