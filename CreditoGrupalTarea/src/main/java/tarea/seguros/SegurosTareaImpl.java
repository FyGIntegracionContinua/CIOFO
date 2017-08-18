package tarea.seguros;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.oasisopen.sca.annotation.Reference;
import org.osoa.sca.annotations.Scope;

import entidad.conexiones.FabricaConexiones;
import tarea.comun.ComunTarea;
import tarea.comun.ReadProperties;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.seguros.BeneficiarioOV;
import utilitario.mensajes.seguros.BeneficiariosClienteOV;
import utilitario.mensajes.seguros.PeticionConsulta;
import utilitario.mensajes.seguros.SegurosRespuesta;
import utilitario.mensajes.seguros.SegurosRespuestaConsulta;

/**Clase que implementa los metodos de tarea para buro interno
 * @author rguadarramac
 * @version 1.0
 * @see BuroInternoTarea
 */
@Scope("COMPOSITE")
public class SegurosTareaImpl implements SegurosTarea {


	/**
	 * comun tipo ComunTarea
	 */
	private ComunTarea comun;


	/**
	 * @param comun tipo ComunTarea
	 */
	public SegurosTareaImpl( @Reference(name = "comun") ComunTarea comun) {
		this.comun = comun;
 		}


	
	public SegurosRespuesta modificaSegurosBeneficiariosTarea(String uid, BeneficiariosClienteOV peticion) {

		SegurosRespuesta respuesta = new  SegurosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;
		SqlSession sesionTx = null;

		try {
			//Se abre la conexion hacia la base de datos
			sesion = FabricaConexiones.obtenerSesionNTx();
			sesionTx = FabricaConexiones.obtenerSesionTx();

			if (peticion == null || peticion.getBeneficiarios() == null
					|| peticion.getPersona() == null || peticion.getPersona().trim().isEmpty()) {
				throw new Exception(ReadProperties.mensajes.getProp("seguros.modifica.error.datos.vacios"));
			}


			//Obtencion del cliente si es t24
			final java.lang.String clienteAux = comun.obtenerPersonaCliente(uid, peticion.getPersona());
			if (clienteAux != null) {
				peticion.setPersona(clienteAux);
			}

			//En esta seccion me traigo los datos de la persona para obtener el nombre y poderlo comparar
			LogHandler.trace(uid, getClass(),
			"==> modificaSegurosTarea - consultaNombrePersona");
			BeneficiarioOV objetoCliente = (BeneficiarioOV)
				sesion.selectOne("consultaNombrePersona", peticion.getPersona());

			if (objetoCliente == null) {
				throw new Exception(ReadProperties.mensajes.getProp("seguros.modifica.error.objeto.incorrecto"));
			} else {
				objetoCliente.setNombre( objetoCliente.getNombre() != null ? objetoCliente.getNombre() : "");
				objetoCliente.setApellidoPat( objetoCliente.getApellidoPat() != null ? objetoCliente.getApellidoPat() : "");
				objetoCliente.setApellidoMat( objetoCliente.getApellidoMat() != null ? objetoCliente.getApellidoMat() : "");
			}
			String nombreCliente = objetoCliente.getNombre().trim()
									+ objetoCliente.getApellidoPat().trim()
										+ objetoCliente.getApellidoMat().trim();

			//Se borran los beneficiarios que correspondan al numero de la persona
			LogHandler.trace(uid, getClass(),
			"==> modificaSegurosTarea - borraSegurosPersona");
			sesionTx.delete("borraSegurosPersona", peticion.getPersona());


			double totalPorcentaje = 0;
			if (peticion.getBeneficiarios().size() > 0) {
			for (int i = 0; i < peticion.getBeneficiarios().size(); i++) {
				//Cada beneficiario se inserta y se compara su nombre y se suma en el porcentaje
				String nombreBeneficiario = null;
				final java.util.HashMap<String, Object> parametros = new HashMap<String, Object>();
				parametros.put("persona", peticion.getPersona());
				parametros.put("nombre", peticion.getBeneficiarios().get(i).getNombre().toUpperCase());
				parametros.put("apellidoPat", peticion.getBeneficiarios().get(i).getApellidoPat().toUpperCase());
				parametros.put("apellidoMat", peticion.getBeneficiarios().get(i).getApellidoMat().toUpperCase());
				parametros.put("parentesco", peticion.getBeneficiarios().get(i).getParentesco());
				parametros.put("porcentaje", peticion.getBeneficiarios().get(i).getPorcentaje());

				nombreBeneficiario = peticion.getBeneficiarios().get(i).getNombre().toUpperCase().trim()
							+ peticion.getBeneficiarios().get(i).getApellidoPat().toUpperCase().trim()
						+ peticion.getBeneficiarios().get(i).getApellidoMat().toUpperCase().trim();

				LogHandler.trace(uid, getClass(),
				"==> modificaSegurosTarea - cliente: " + nombreCliente + " Beneficiario: " + nombreBeneficiario);

				//el nombre del cliente debera ser diferente al del beneficiario
				if (nombreCliente.equals(nombreBeneficiario)) {
					throw new Exception(ReadProperties.mensajes.getProp("seguros.modifica.error.nombre"));
				}

				totalPorcentaje = totalPorcentaje + peticion.getBeneficiarios().get(i).getPorcentaje();

				LogHandler.trace(uid, getClass(),
					"==> modificaSegurosTarea - insertaSeguros");
				sesionTx.insert("insertaSeguros", parametros);

			}

			sesionTx.commit(true);

			//el porcentaje total debera sumar 100%
			if (totalPorcentaje != 100) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"seguros.modifica.error.porcentaje.incorrecto"));
			}

			respuesta.setTotalPorcentajeBeneficiarios(totalPorcentaje);

			respuesta.getHeader().setMensaje("Los beneficiarios del cliente se han insertado con exito");

			} else {
				throw new Exception(ReadProperties.mensajes.getProp(
						"seguros.modifica.error.beneficiarios.vacios"));
			}
		} catch (Exception ex ) {
			FabricaConexiones.rollBack(sesionTx);
			LogHandler.error(uid, getClass(), "modificaSegurosBeneficiariosTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
			FabricaConexiones.close(sesionTx);
		}

		return respuesta;
	}


	@SuppressWarnings("unchecked")
	
	public SegurosRespuestaConsulta consultaSegurosBeneficiariosTarea(String uid,
			PeticionConsulta peticion) {

		SegurosRespuestaConsulta respuesta = new  SegurosRespuestaConsulta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;

		try {
			if (peticion == null || peticion.getBeneficiariosClientes() == null) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"seguros.consulta.error.datos.vacios"));
			}

			//Se abre la conexion hacia la base de datos
			sesion = FabricaConexiones.obtenerSesionNTx();

			List<BeneficiariosClienteOV> listaClientes = new ArrayList<BeneficiariosClienteOV>();
			for (int i = 0; i < peticion.getBeneficiariosClientes().size(); i++) {
				if (peticion.getBeneficiariosClientes().get(i).getPersona() == null
						|| peticion.getBeneficiariosClientes().get(i).getPersona().trim().isEmpty()) {
					throw new Exception(ReadProperties.mensajes.getProp(
							"seguros.consulta.error.datos.vacios"));
				}

				//Obtencion del cliente si es t24
				final java.lang.String clienteAux = comun.obtenerPersonaCliente(uid,
						peticion.getBeneficiariosClientes().get(i).getPersona());
				if (clienteAux != null) {
					peticion.getBeneficiariosClientes().get(i).setClaveFinsol(
							peticion.getBeneficiariosClientes().get(i).getPersona());
					peticion.getBeneficiariosClientes().get(i).setPersona(clienteAux);
				}

				BeneficiariosClienteOV clienteNuevo = new BeneficiariosClienteOV();
				List<BeneficiarioOV> beneficiariosNuevos = new ArrayList<BeneficiarioOV>();
				LogHandler.trace(uid, getClass(),
				"==> consultaSegurosBeneficiariosTarea - consultaBeneficiariosPersona");
				beneficiariosNuevos = sesion.selectList("consultaBeneficiariosPersona",
						peticion.getBeneficiariosClientes().get(i).getPersona());

				clienteNuevo.setPersona(peticion.getBeneficiariosClientes().get(i).getPersona());
				clienteNuevo.setClaveFinsol(peticion.getBeneficiariosClientes().get(i).getClaveFinsol()
						!= null ? peticion.getBeneficiariosClientes().get(i).getClaveFinsol() : "");
				clienteNuevo.setBeneficiarios(beneficiariosNuevos);
				if (clienteNuevo.getBeneficiarios() != null & clienteNuevo.getBeneficiarios().size() > 0) {
					listaClientes.add(clienteNuevo);
				}

			}

			if (listaClientes.size() == 0) {
				throw new Exception(ReadProperties.mensajes.getProp(
				"seguros.consulta.error.listaClientes.vacia"));
			}

			respuesta.setBeneficiarioCliente(listaClientes);


		} catch (Exception ex ) {
			LogHandler.error(uid, getClass(), "consultaSegurosBeneficiariosTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;

	}

	public SegurosRespuestaConsulta consultaPersonaBeneficiarios(String uid,
			PeticionConsulta peticion) {

		SegurosRespuestaConsulta respuesta = new  SegurosRespuestaConsulta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		SqlSession sesion = null;

		try {
			if (peticion == null || peticion.getBeneficiariosClientes() == null) {
				throw new Exception(ReadProperties.mensajes.getProp(
						"seguros.consulta.error.datos.vacios"));
			}

			//Se abre la conexion hacia la base de datos
			sesion = FabricaConexiones.obtenerSesionNTx();

			List<BeneficiariosClienteOV> listaClientes = new ArrayList<BeneficiariosClienteOV>();
			for (int i = 0; i < peticion.getBeneficiariosClientes().size(); i++) {
				if (peticion.getBeneficiariosClientes().get(i).getPersona() == null
						|| peticion.getBeneficiariosClientes().get(i).getPersona().trim().isEmpty()) {
					throw new Exception(ReadProperties.mensajes.getProp(
							"seguros.consulta.error.datos.vacios"));
				}

				//Obtencion del cliente si es t24
				final java.lang.String clienteAux = comun.obtenerPersonaCliente(uid,
						peticion.getBeneficiariosClientes().get(i).getPersona());
				if (clienteAux != null) {
					peticion.getBeneficiariosClientes().get(i).setClaveFinsol(
							peticion.getBeneficiariosClientes().get(i).getPersona());
					peticion.getBeneficiariosClientes().get(i).setPersona(clienteAux);
				}

				BeneficiariosClienteOV clienteNuevo = new BeneficiariosClienteOV();
				List<BeneficiarioOV> beneficiariosNuevos = new ArrayList<BeneficiarioOV>();
				LogHandler.trace(uid, getClass(),
				"==> consultaSegurosBeneficiariosTarea - consultaBeneficiariosPersona");
				beneficiariosNuevos = sesion.selectList("consultaBeneficiariosPersona",
						peticion.getBeneficiariosClientes().get(i).getPersona());

				clienteNuevo.setPersona(peticion.getBeneficiariosClientes().get(i).getPersona());
				clienteNuevo.setClaveFinsol(peticion.getBeneficiariosClientes().get(i).getClaveFinsol()
						!= null ? peticion.getBeneficiariosClientes().get(i).getClaveFinsol() : "");
				clienteNuevo.setBeneficiarios(beneficiariosNuevos);
				if (clienteNuevo.getBeneficiarios() != null & clienteNuevo.getBeneficiarios().size() > 0) {
					listaClientes.add(clienteNuevo);
				}

			}

//			if (listaClientes.size() == 0) {
//				throw new Exception(ReadProperties.mensajes.getProp(
//				"seguros.consulta.error.listaClientes.vacia"));
//			}

			respuesta.setBeneficiarioCliente(listaClientes);


		} catch (Exception ex ) {
			LogHandler.error(uid, getClass(), "consultaSegurosBeneficiariosTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;

	}

}
