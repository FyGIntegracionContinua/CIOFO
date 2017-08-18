package tarea.buro;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Scope;

import entidad.conexiones.FabricaConexiones;
import utilitario.log.LogHandler;
import utilitario.mensajes.buro.BuroInternoKitRespuesta;
import utilitario.mensajes.buro.BuroInternoOV;
import utilitario.mensajes.buro.BuroPeticionKit;
import utilitario.mensajes.comun.EncabezadoRespuesta;

/**Clase que implementa los metodos de tarea para buro interno
 * @author rguadarramac
 * @version 1.0
 * @see BuroInternoTarea
 */
@Scope("COMPOSITE")
public class BuroInternoTareaImpl implements BuroInternoTarea {
	/**
	 * PERSONA_INVALIDA
	 */
	public static final String PERSONA_INVALIDA = "NO SE HAN ENCONTRADO DATOS PARA ESTE NUMERO DE PERSONA";

	/**
	 * Metododo que genera una consulta del historial crediticio de una persona
	 * @see tarea.buro.BuroInternoTarea#generaConsultaBuroInterno(java.lang.String, utilitario.mensajes.buro.BuroPeticionKit)
	 * @param uid :
	 * @param buroPeticion :
	 * @return BuroInternoKitRespuesta
	 */
	@SuppressWarnings("unchecked")
	public BuroInternoKitRespuesta generaConsultaBuroInterno(String uid,
			BuroPeticionKit buroPeticion) {

		BuroInternoKitRespuesta respuesta = new  BuroInternoKitRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		try {

			if (buroPeticion.getPersona() == null || buroPeticion.getPersona().isEmpty()) {
				throw new Exception(PERSONA_INVALIDA);
			}

			respuesta.setPersona(buroPeticion.getPersona());
			sesion = FabricaConexiones.obtenerSesionNTx();
//			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoPeticion.getContrato() );
//			LogHandler.info(uid, getClass(), "Numero de Contrato para consulta de buro: " + numeroContrato );
//			DecimalFormat df = new DecimalFormat("0.00");
			List<BuroInternoOV> buros = new ArrayList<BuroInternoOV>();

	 		LogHandler.trace( uid, getClass(), " ==> ConsultaBuroInterno - consultaDatosBuro");
			List<BuroInternoOV> histCreditos = sesion.selectList("consultaDatosBuro", buroPeticion.getPersona());
			if (histCreditos != null && !histCreditos.isEmpty()) {
				for (int i = 0; i < histCreditos.size(); i++) {
					BuroInternoOV buro = new BuroInternoOV();
					buro.setNumeroContratoLD(histCreditos.get(i).getNumeroContratoLD());
					buros.add(buro);
				}
			} else {
				throw new Exception(PERSONA_INVALIDA);
			}
			respuesta.setBuros(histCreditos);

		} catch (Exception ex ) {
			LogHandler.error(uid, getClass(), "generaConsultaBuroInterno(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

}
