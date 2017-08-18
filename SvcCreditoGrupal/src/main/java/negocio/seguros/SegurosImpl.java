package negocio.seguros;

import org.oasisopen.sca.annotation.Reference;

import tarea.seguros.SegurosTarea;
import transformador.Transformador;
import utilitario.comun.GUIDGenerator;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.seguros.BeneficiarioOV;
import utilitario.mensajes.seguros.BeneficiariosClienteOV;
import utilitario.mensajes.seguros.PeticionConsulta;
import utilitario.mensajes.seguros.SegurosRespuesta;
import utilitario.mensajes.seguros.SegurosRespuestaConsulta;

/**
 * @author rguadarramac
 * @version 1.0
 *
 */
public class SegurosImpl implements Seguros {

	/**
	 * Variable kitBuro
	 */
	private SegurosTarea seguros;
	/**
	 * Variable transformador
	 */
	private Transformador transformador;

	/**
	 * @param seguros de tipo BuroInternoTarea
	 * @param transformador de tipo Transformador
	 */
	public SegurosImpl(
			@Reference(name = "seguros") SegurosTarea seguros,
			@Reference(name = "transformador") Transformador transformador) {
		this.seguros = seguros;
		this.transformador = transformador;
 		}


	/**
	 * Metodo de modificacion de datos para Seguros
	 * @param peticion tipo String
	 * @return respuestaXML
	 */
	public String modificaSegurosBeneficiarios(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "modificaSegurosBeneficiarios - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {BeneficiariosClienteOV.class,
									BeneficiarioOV.class,
									SegurosRespuesta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final BeneficiariosClienteOV   segurosPeticion =
			(BeneficiariosClienteOV) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "modificaSegurosBeneficiarios - Datos de entrada : " + segurosPeticion);

		//Llamado a funci�n principal
		final SegurosRespuesta respuesta = seguros.modificaSegurosBeneficiariosTarea(uid, segurosPeticion);
		LogHandler.info(uid, getClass(), "modificaSegurosBeneficiarios - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		LogHandler.info(uid, getClass(), "modificaSegurosBeneficiarios - Datos de salida XML: " + respuestaXML);
		return respuestaXML;
	}


	/**
	 * Metodo de consulta de datos para Seguros
	 * @param peticion tipo String
	 * @return respuestaXML
	 */
	public String consultaSeguros(String peticion) {
		final java.lang.String uid  = GUIDGenerator.generateGUID( peticion );
		LogHandler.info(uid, getClass(), "consultaSeguros - Datos de entrada : " + peticion);

		//Parametros de entrada
		final Class<?>[] clases = {PeticionConsulta.class,
									BeneficiariosClienteOV.class,
									BeneficiarioOV.class,
									SegurosRespuestaConsulta.class,
									EncabezadoRespuesta.class};

		//Conversion de XML a Object
		final PeticionConsulta segurosPeticion =
			(PeticionConsulta) transformador.transformaXMLAObjeto(uid, peticion, clases);
		LogHandler.info(uid, getClass(), "consultaSeguros - Datos de entrada : " + segurosPeticion);

		//Llamado a funci�n principal
		final SegurosRespuestaConsulta respuesta = seguros.consultaSegurosBeneficiariosTarea(uid, segurosPeticion);
		LogHandler.info(uid, getClass(), "consultaSeguros - Datos de salida: " + respuesta);

		//Se genera la salida
		final java.lang.String respuestaXML = transformador.transformaObjetoAXML(uid, respuesta, clases);
		return respuestaXML;
	}


}
