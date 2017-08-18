package tarea.comun;

import java.util.List;

import utilitario.comun.Constantes;
import utilitario.comun.Validaciones;
import utilitario.log.LogHandler;
import utilitario.mensajes.burocredito.ResumenBuroCliente;
import utilitario.mensajes.burocredito.ResumenBuroMop;
import utilitario.mensajes.burocredito.ResumenBuroPeticion;
import utilitario.mensajes.burocredito.ResumenBuroRespuesta;
import utilitario.mensajes.correo.EnviarCorreoPeticion;
import utilitario.mensajes.correo.EnviarCorreoRespuesta;
import utilitario.mensajes.solicitudes.ExcepcionGarantiaPeticion;
import utilitario.mensajes.solicitudes.InformacionContratosAnteriores;

/**
 * clase que se encargara de llamar a. un srevicio del SAF para el envio de
 * correos
 *
 * @author out_rmontellanom
 * @version 1.0
 */
public class EnvioDeCorreos {

	/**
	 * Constructor para instancias de subclases.
	 */
	public EnvioDeCorreos() {
	}

	/**
	 * envia correo.
	 *
	 * @param uid
	 *            identificador &uacute;nico de transacaci&oacute;n
	 * @param datos SolicitudSACGPeticion datos de la solicitud
	 *            datos del usuario para el xml
	 * @return   EnviarCorreoRespuesta respuesta.
	 */
	public static EnviarCorreoRespuesta enviarCorreo(String uid, ExcepcionGarantiaPeticion datos)
			throws Exception {
		LogHandler.info(uid, EnvioDeCorreos.class, "ENVIANDO CORREO:::");
		EnviarCorreoPeticion peticion = new EnviarCorreoPeticion();
		EnviarCorreoRespuesta respuestaObj = null;
		EnvioCorreoElectronico port = new EnvioCorreoElectronico();

		if (datos != null && datos.getCorreo() != null
				&& !datos.getCorreo().isEmpty()) {
			try {
				String sucursal = datos.getNombreSucursal() == null
						        ? "" : datos.getNombreSucursal().toString();
				String ciclo = datos.getCiclo() + "";
				String campana = datos.getCampana() == null
						        ? "" : datos.getCampana().toString();
				String monto = datos.getMontoSolicitado() + "";
				String nombreGrupo = datos.getNombreGrupo() == null
						        ? "" : datos.getNombreGrupo().toString();
				String integrantes = datos.getNumeroIntegrantes() + "";
				String nombreAsesor =  datos.getNombreAsesor() == null
						        ? "" : datos.getNombreAsesor();
				String justificacion = datos.getObservaciones() == null
						        ? "" : datos.getObservaciones();
				String solicitud = datos.getSolicitud() == null
				        ? "" : datos.getSolicitud().toString();

				String peticionHTML = "<body><div marginheight=\"0\" marginwidth=\"0\" "
						+ "style=\"width:100%!important;margin:0;padding:0\""
						+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:200;"
						+ "text-align:left;text-decoration:none;font-size:11px;line-height:1.65em;color:rgb(136,137,140)\">"
						+ "<p>Se gener&oacute; la siguiente solicitud de excepci&oacute;n de"
						+ " restricci&oacute;n con la siguiente informaci&oacute;n: </p>"
                        + "<p><br>"
						+ "<strong>Sucursal:  </strong>" + sucursal + "<br>"
					    + "<strong>Solicitud:  </strong>" + solicitud + "<br>"
                        + "<strong>Ciclo:  </strong>" + ciclo + "<br>"
                        + "<strong>Campa&ntilde;a:  </strong>" + campana + "<br>"
                        + "<strong>Monto:  </strong>" + monto + "<br>"
                        + "<strong>Nombre Grupo:  </strong>" + nombreGrupo + "<br>"
                        + "<strong>No. Integrantes:  </strong>" + integrantes + "<br>"
                        + "<strong>Nombre Asesor:  </strong>" + nombreAsesor + "<br>"
                        + "<strong>Justificaci&oacute;n de Excepci&oacute;n de Restricci&oacute;n:  </strong>"
                        +  justificacion + "<br>"
                        +  "</p> </div> </body>";

				peticion.setAsunto("Solicitud de Excepción de Restricción - Solicitud: "
				                   + solicitud);
				peticion.setCuentaEnvio(Constantes.CORREO_NOTIFICACIONES_SACG); //Constantes.ENVIO_MAIL.getNombres()
				peticion.setDestinatarios(datos.getCorreo());

				peticion.setPasswordCuentaEnvio(Constantes.PASSWORD_NOTIFICACIONES_SACG); // Constantes.PWENV_MAIL.getNombres()
				peticion.setTexto(peticionHTML);

				respuestaObj = port.enviarCorreoAdjunto(uid, peticion);

				LogHandler.info(uid, EnvioDeCorreos.class,
						"Respuesta del servicio SAF  :: " + peticion.getDestinatarios()
						 + " respuesta " + respuestaObj.toString());

				if (respuestaObj != null) {
					LogHandler.info(uid, EnvioDeCorreos.class,
							"se envio correo satisfactoriamente a :: " + respuestaObj.getHeader().getMensaje());
				}
			} catch (Exception e) {
				LogHandler.info(uid, EnvioDeCorreos.class,
					"NO SE PUDO ENVIAR CORREO A [" /*+ usuarioFinsol.getNumeroPersona()*/);
				throw new Exception("No se pudo enviar el correo " + peticion.getDestinatarios());
			}

		} else {
			LogHandler.info(uid, EnvioDeCorreos.class, "NO SE PUDO ENVIAR CORREO DATOS INCORRECTOS");
		}
		return respuestaObj;
	}

	/**
	 * M&eacute;todo que envia el correo con el resumen de la solicitud
	 * @param uid id unico de transacci&oacute;n
	 * @param datos  datos de la petici&oacute;n
	 * @param respuesta datos del resumen de la solicitud
	 * @return EnviarCorreoRespuesta respuesta de si se env&iacute;o el correo satisfactoriamente o no
	 * @throws Exception se puede lanzar una excepci&oacute;n.
	 */
	public EnviarCorreoRespuesta enviarCorreoSolicitud(String uid, ResumenBuroPeticion datos, ResumenBuroRespuesta respuesta)
			throws Exception {
		LogHandler.info(uid, EnvioDeCorreos.class, "ENVIANDO CORREO:::");
		EnviarCorreoPeticion peticion = new EnviarCorreoPeticion();
		EnviarCorreoRespuesta respuestaObj = null;
		EnvioCorreoElectronico port = new EnvioCorreoElectronico();

		if (datos != null && datos.getCorreo() != null && !datos.getCorreo().isEmpty()
			&& respuesta != null && respuesta.getUrlConsultaDatosSolicitud() != null
			&& !respuesta.getUrlConsultaDatosSolicitud().trim().isEmpty()
			&& respuesta.getUrlRealiazarOperacionSolicitud() != null
			&& !respuesta.getUrlRealiazarOperacionSolicitud().trim().isEmpty()
			&& respuesta.getInformacionContratosAnteriores() != null) {

			try {
				String peticionHTML = encabezadoCorreo(uid, respuesta, datos)
						+ agregarMensaje("Los datos de la solictud son:", "18", "0,50,160")
                        + "<tr><br/><br/></tr>"

                        //contenido del correo datos de solicitud y sus ciclos anteriores
				        + agregarFilaSolicitud("Sucursal: ",
				        		respuesta.getNombreSucursal() == null ? "" : respuesta.getNombreSucursal())
				        + agregarFilaSolicitud("Riesgo Sucursal: ",
				        		respuesta.getTipificacionSucursal() == null ? "" : respuesta.getTipificacionSucursal())
				        + agregarFilaSolicitud("Nombre Grupo: ",
				        		respuesta.getNombreGrupo() == null ? "" : respuesta.getNombreGrupo() )
				        + agregarFilaSolicitud("Motivo Solicitud Aprobaci&oacute;n: ",
				        		respuesta.getMotivoExcepcion() == null ? "" : respuesta.getMotivoExcepcion())
				        + agregarFilaSolicitud("Observaciones:",
				        		respuesta.getMotivoCEC() == null ? "" : respuesta.getMotivoCEC())

				        + agregarLista("Ciclo: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Contrato LD: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Producto: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Campa&ntilde;a: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Tasa Anual: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("% Garant&iacute;a: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Monto: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Plazo: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Frecuencia: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("No.Integrantes: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Nombre Asesor: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Nivel Estrellas Asesor: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Pagos realizados: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Pagos faltantes: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("Estatus: ", respuesta.getInformacionContratosAnteriores())
				        + agregarLista("D&iacute;as m&aacute;ximo de atraso: ", respuesta.getInformacionContratosAnteriores())

				        //checar desde aqui empece a poner sin probar
				        + "<tr valign=\"middle\" height=\"15px\" style=\"border:none;margin:0px;padding:0px\"></tr>"
				        + agregarMensaje("Resumen Bur&oacute; de Integrantes", "18", "0,50,160")
				        + "<tr valign=\"middle\" height=\"15px\" style=\"border:none;margin:0px;padding:0px\"></tr>"
				        + "</tbody></table>"
				        //contenido del correo: datos de buro de cada integrante de la solicitud
				        + agregarResumenBuro(uid, respuesta)
				        //+ agregarFormulario(uid, respuesta)
				        //se quita el formulario y solo se envia un link a la pagina  de mostar informacion de firma electronica.
				        + agregarBotonEnviarRespuesta(uid, respuesta)
						+ footerCorreo(uid, datos);

				peticion.setAsunto("Aprobación Electrónica Solicitud: " + datos.getSolicitud());
				peticion.setCuentaEnvio(Constantes.CORREO_NOTIFICACIONES_SACG); //Constantes.ENVIO_MAIL.getNombres()
				peticion.setDestinatarios(datos.getCorreo());

				peticion.setPasswordCuentaEnvio(Constantes.PASSWORD_NOTIFICACIONES_SACG); // Constantes.PWENV_MAIL.getNombres()
				peticion.setTexto(peticionHTML);

				respuestaObj = port.enviarCorreoAdjunto(uid, peticion);

				LogHandler.info(uid, EnvioDeCorreos.class,
						"Respuesta del servicio SAF  :: " + peticion.getDestinatarios()
						 + " respuesta " + respuestaObj.toString());

				if (respuestaObj != null) {
					LogHandler.info(uid, EnvioDeCorreos.class,
							"se envio correo satisfactoriamente a :: " + respuestaObj.getHeader().getMensaje());
				}
			} catch (Exception e) {
				LogHandler.info(uid, EnvioDeCorreos.class,
					"NO SE PUDO ENVIAR CORREO A [" /*+ usuarioFinsol.getNumeroPersona()*/);
				throw new Exception("No se pudo enviar el correo " + peticion.getDestinatarios());
			}
		} else {
			LogHandler.info(uid, EnvioDeCorreos.class, "NO SE PUDO ENVIAR CORREO DATOS INCORRECTOS");
		}

		return respuestaObj;
	}
	/**
	 * M&eacute;todo que contine el encabezado del correo
	 * @param uid id &uacute;nico de transacci&oacute;n
	 * @param respuesta datos d ela peticion
	 * @param datos datos peticion
	 * @return String adena de la cabecera
	 */
	private String encabezadoCorreo(String uid, ResumenBuroRespuesta respuesta, ResumenBuroPeticion datos) {
		return "<body>"
				+ "<div marginheight=\"0\" marginwidth=\"0\" "
				+ "style=\"width:100%!important;margin:0;padding:0\">"
				+ "<table cellpadding=\"0\" cellspacing=\"0\" border=\"0\" align=\"top\" width=\"100%\" "
				+ "align=\"center\" style=\"width:100%;max-width:480px\">"
				+ "<tbody><tr><td valign=\"top\" align=\"left\" style=\"word-break:normal;border-collapse:collapse;"
				+ "font-family:'Circular','Helvetica Neue',Helvetica,Arial,sans-serif;font-size:10px;"
				+ "line-height:15px;color:#555555\"><center><div>"

				/*
				+ "<h1 align=\"center\" style=\"border:none;margin:0px;padding:0px;"
				+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:bold;"
				+ "text-align:center;text-decoration:none;font-size:15px;line-height:25px;color:rgb(148,94,94);"
				+ "letter-spacing:-0.04em\"> Si no ves este mensaje correctamente o no puedes capturar"
				+ " tu observaci&oacute;n, haz clic <a href=\"" + respuesta.getUrlConsultaDatosSolicitud()
				+ "\"target=\"_blank\">aqu&iacute;</a>  </h1> "
				*/

				+ "<table width=\"100%\" height=\"50\" cellpadding=\"0\" cellspacing=\"0\" "
				+ "style=\"border:none;margin:0px;padding:0px;border-collapse:collapse;width:100%;height:50px; "
				+ "background-color: rgb(0, 50, 160);\"><tbody valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px\"><tr height=\"5\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;height:5px\"><td colspan=\"3\" height=\"5\" "
				+ "valign=\"middle\" style=\"border:none;margin:0px;padding:0px;height:5px\"></td></tr>"
				+ "<tr valign=\"middle\" style=\"border:none;margin:10px;padding:10px\"><td width=\"6.25%\" "
				+ "valign=\"middle\" style=\"border:none;margin:12px;padding:12px;width:70%\">"
				+ "<h2 style=\"color:#fff; font-size:18px; font-family:verdana;line-height:25px;\">"
				+ respuesta.getTituloEncabezado() + ": " + datos.getSolicitud() + "</h2></td>"
				+ "<td valign=\"middle\" style=\"border:none;margin:0px;padding:0px;float:right\">"
				+ "<a href=\"http://www.finsol.com.mx\" style=\"border:none;margin:0px;padding:0px;"
				+ "text-decoration:none\" target=\"_blank\">"
				+ "<img src=\"http://galeon.com/mramosme/imagenes/finsol/logo-firma.png\"  alt=\"\" "
				+ "style=\"border:none;margin:0px;padding:0px;display:block;max-width:100%;width:122px;min-height:37px\">"
				+ "</a></td><td width=\"6.25%\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;width:6.25%\"></td></tr>"
				+ "<tr height=\"5\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;height:5px\">"
				+ "<td colspan=\"3\" height=\"5\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;height:5px\">"
				+ "</td></tr></tbody></table><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" "
				+ "style=\"border:none;margin:0px;padding:0px;border-collapse:collapse;width:100%;\">"
				+ "<tbody valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<tr height=\"28\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;height:28px\">"
				+ "<td colspan=\"3\" height=\"28\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;height:28px\"></td></tr>";
	}

	/**
	 * M&eacute;todo que contiene el pie de pagina del correo
	 * @param uid id unico de transaccion
	 * @param datos datos de la peticion
	 * @return String cadena del footer
	 */
	private String footerCorreo(String uid, ResumenBuroPeticion datos) {
		return  "<table width=\"100%\" "
				+ "cellpadding=\"0\" cellspacing=\"0\" style=\"border:none;margin:0px;padding:0px;"
				+ "border-collapse:collapse;width:100%\"><tbody valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px\"><tr valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px\"><td width=\"6.25%\" valign=\"middle\" "
				+ "style=\"width:6.25%;border:none;margin:0px;padding:0px\"></td><td valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px\"><table cellspacing=\"0\" cellpadding=\"0\" "
				+ "border=\"0\" width=\"100%\" style=\"margin:0px;padding:0px\"><tbody><tr>"
				+ "<td align=\"left\" style=\"border:none;margin:0px;padding:0px 0px 5px;"
				+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:200;"
				+ "text-align:left;text-decoration:none;font-size:14px;line-height:20px;color:rgb(97,100,103)\"> "
				+ "</td></tr>" + "</tbody></table></td>"
				+ "<td width=\"6.25%\" valign=\"middle\" style=\"width:6.25%;border:none;margin:0px;padding:0px\">"
				+ "</td></tr><tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<td colspan=\"3\" valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px;\"></td></tr></tbody></table><table width=\"100%\" cellpadding=\"0\" "
				+ "cellspacing=\"0\" style=\"border:none;margin:0px;padding:0px;border-collapse:collapse;"
				+ "width:100%\"><tbody valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<td width=\"6.25%\" valign=\"middle\" style=\"width:6.25%;border:none;margin:0px;padding:0px\">"
				+ "</td><td valign=\"middle\" align=\"left\" style=\"border:none;margin:0px;padding:0px;"
				+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:200;text-align:left;"
				+ "text-decoration:none;font-size:14px;line-height:1.1em\"><center style=\"border:none;"
				+ "margin:0px;padding:0px\">"
				+ "<table width=\"240\" cellpadding=\"0\" cellspacing=\"0\" "
				+ "style=\"border:none;margin:0px;padding:0px;border-collapse:collapse;width:240px;\">"
				+ "<tbody valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<td width=\"22\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;width:22px\">"
				+ "</td><td  valign=\"middle\" align=\"center\" style=\"border:none;margin:0px;"
				+ "padding:0px;font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
				+ "font-weight:bold;text-align:center;text-decoration:none;font-size:13px;line-height:16px;"
				+ "border-radius:22px;color:rgb(255,255,255);text-transform:uppercase\">"
				+ "</td><td width=\"22\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;width:22px\"></td></tr></tbody>"
				+ "</table></a></center></td><td width=\"6.25%\" valign=\"middle\" "
				+ "style=\"width:6.25%;border:none;margin:0px;padding:0px\"></td></tr><tr "
				+ "valign=\"middle\" style=\"border:none;margin:0px;padding:0px;\">"
				+ "<td colspan=\"3\" height=\"35\" valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px;\"></td></tr><tr valign=\"middle\" style=\"border:none;"
				+ "margin:0px;padding:0px\"><td width=\"6.25%\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;width:6.25%\"></td><td valign=\"middle\" "
				+ "align=\"left\" style=\"border:none;margin:0px;padding:0px;"
				+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:200;"
				+ "text-align:left;text-decoration:none;font-size:11px;line-height:1.65em;color:rgb(136,137,140)\">"
				+ "Este correo fue enviado a <a href=\"mailto:" + datos.getCorreo() + "\" target=\"_blank\">"
				+ datos.getCorreo()
				+ "</a>. Si tu no pediste el correo, haz caso omiso del mismo."
				+ "</td><td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px;width:6.25%\"></td></tr></tbody></table><table width=\"100%\" "
				+ "cellpadding=\"0\" cellspacing=\"0\" style=\"border:none;margin:0px;padding:0px;"
				+ "border-collapse:collapse;width:100%\"><tbody valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px\"><tr height=\"22\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;\"><td colspan=\"3\" "
				+ "valign=\"middle\" style=\"border:none;margin:0px;padding:0px;\"></td></tr>"
				+ "</tbody></table><table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" "
				+ "bgcolor=\"#F7F7F7\" style=\"border:none;margin:0px;padding:0px;border-collapse:collapse;"
				+ "width:100%;background-color:rgb(247,247,247)\"><tbody valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px\"><tr valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;\"><td colspan=\"3\"  "
				+ "valign=\"middle\" style=\"border:none;margin:0px;padding:0px;\"></td></tr>"
				+ "<tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;"
				+ "width:6.25%\"></td><td valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<img src=\"" + "http://calculatuesfuerzo.finsol.com.mx/"
				+ "PlataformaFinsolMovilWEB/login/resources/images/logoFinsol.png\" "
				+ "width=\"77\" alt=\"\" style=\"border:none;margin:0px;padding:0px;"
				+ "display:block;max-width:100%;width:77px;min-height:23px\"></td><td width=\"6.25%\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;width:6.25%\"></td></tr><tr  "
				+ "valign=\"middle\" style=\"border:none;margin:0px;padding:0px;\">"
				+ "<td colspan=\"3\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;"
				+ "\"></td></tr><tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;width:6.25%\">"
				+ "</td><td valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<hr bgcolor=\"#D1D5D9\" style=\"border:none;margin:0px;padding:0px;min-height:1px;"
				+ "background-color:rgb(209,213,217)\"></td><td width=\"6.25%\" valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;width:6.25%\"></td></tr><tr  "
				+ "valign=\"middle\" style=\"border:none;margin:0px;padding:0px;\">"
				+ "<td colspan=\"3\" valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px;\"></td></tr><tr valign=\"middle\" style=\"border:none;"
				+ "margin:0px;padding:0px\"><td width=\"6.25%\" valign=\"middle\" style=\"border:none;"
				+ "margin:0px;padding:0px;width:6.25%\"></td><td valign=\"middle\" align=\"left\" "
				+ "style=\"border:none;margin:0px;padding:0px;"
				+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:200;"
				+ "text-align:left;text-decoration:none;font-size:11px;line-height:1.65em;"
				+ "color:rgb(136,137,140)\">Si el formulario no funciona intente comunicarse"
				+ " con el &aacute;rea de operaciones. <br/>"
				+ "</td><td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;width:6.25%\">"
				+ "</td></tr><tr valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;\">"
				+ "<td colspan=\"3\" valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px;\"></td></tr><tr valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px\"><td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;"
				+ "padding:0px;width:6.25%\"></td><td valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<hr bgcolor=\"#D1D5D9\" style=\"border:none;margin:0px;padding:0px;min-height:1px;"
				+ "background-color:rgb(209,213,217)\">"
				+ "<img src=\"http://galeon.com/mramosme/imagenes/finsol/CAMINANTES.png\" height=\"20\">"
				+ "<img src=\"http://galeon.com/mramosme/imagenes/finsol/CAMINANTES.png\" height=\"20\">"
				+ "<img src=\"http://galeon.com/mramosme/imagenes/finsol/CAMINANTES.png\" height=\"20\">"
				+ "<img src=\"http://galeon.com/mramosme/imagenes/finsol/CAMINANTES.png\" height=\"20\">"
				+ "</td><td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;width:6.25%\">"
				+ "</td></tr><tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				+ "<td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;width:6.25%\"></td>"
				+ "<td valign=\"middle\" align=\"left\" style=\"border:none;margin:0px;padding:0px;"
				+ "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;font-weight:200;"
				+ "text-align:left;text-decoration:none;font-size:11px;line-height:1.65em;color:rgb(136,137,140)\">"
				+ "<hr style=\"border:none;margin:0px;padding:0px;min-height:1px;background-color:rgb(209,213,217)\">"
				+ "Prolongación Reforma 600 · Col. Peña Blanca Santa Fé <br/> Del. Álvaro Obregón ·CP 01210 · México, D.F"
				+ "</td><td width=\"6.25%\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px;width:6.25%\">"
				+ "</td></tr><tr  valign=\"middle\" "
				+ "style=\"border:none;margin:0px;padding:0px;\">"
				+ "<td colspan=\"3\"  valign=\"middle\" style=\"border:none;margin:0px;padding:0px;"
				+ "\"></td></tr></tbody></table></div></center></td></tr></tbody></table></div></body>";
	}

	/**
	 * M&eacute;todo que agrega un msj
	 * @param mensaje mensaje a mostar
	 * @param size tamano de letra
	 * @param color color de letra
	 * @return String cadena que agrega el msj
	 */
	public String agregarMensaje(String mensaje, String size, String color) {

		String trMensaje = "<tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				           + "<td colspan=\"15\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
				           +    "<h3  style=\"border:none;margin:4px;padding:0px;"
				           +          "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
				           +          "text-decoration:none;font-size:" + size + "px;line-height:25px;"
				           +          "color:rgb(" + color + ");"
				           +          "letter-spacing:-0.04em\"> " + mensaje
				           +     " </h3>"
				           + "</td>"
				         + "</tr>";
		return trMensaje;
	}

	/**
	 * M&eacute;todo que agrega una fila
	 * @param etiqueta nombre de la fila
	 * @param valor  valor de la fila
	 * @return String cadena con el nombre y valor agregados.
	 */
	private String agregarFilaSolicitud(String etiqueta, String valor) {
		String trMensaje = "<tr style=\"border:none;margin:0px;padding:0px\">"
				+ "<td colspan=\"3\" style=\"width:1000px;border:none;margin:4px;padding:0px\">"
		            + "<h3 style=\"border:none;margin:4px;padding:0px;"
		            + "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
		            + "text-decoration:none;font-size:15px;color:rgb(124,120,120);"
		            + "letter-spacing:-0.04em\">"
		            + "<strong style=\"font-weight:bold;color:rgb(85,85,85);\">"
			        + etiqueta + "</strong> </h3>"
		        + "</td>"
				+ "<td colspan=\"9\" style=\"width:1500px;border:none;margin:4px;padding:0px\">"
				    + "<h3 style=\"border:none;margin:4px;padding:0px;"
				    + "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
				    + "text-decoration:none;font-size:15px;color:rgb(5,9,244);"
				    + "letter-spacing:-0.04em\">" + valor + "</h3>"
				+ "</td>"
				+ "</tr>";
		return trMensaje;
	}

	/**
	 * M&eacute;todo que agrega la informacion del contrato
	 * @param etiqueta nombre de la fila
	 * @param info datos de los contratos anteriores
	 * @return String cadena con las filas a ser agregadas
	 */
	private String agregarLista(String etiqueta, List<InformacionContratosAnteriores> info) {
		String trMensaje = "";
		if (info != null && info.size() > 0) {
		trMensaje =	"<tr style=\"border:none;margin:0px;padding:0px\">"
				+ "<td colspan=\"3\" style=\"width:1000px;border:none;margin:4px;padding:0px;\">"
			        + "<h3 style=\"border:none;margin:4px;padding:0px;"
			        + "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
			        + "text-decoration:none;font-size:15px;color:rgb(124,120,120);"
			        + "letter-spacing:-0.04em\">"
			        + "<strong style=\"font-weight:bold;color:rgb(85,85,85);\">"
				    + etiqueta + "</strong> </h3>"
			    + "</td>";

				for (InformacionContratosAnteriores inConAnt : info) {
					String valor = "";
					if (etiqueta.contains("Ciclo:")) {
						valor = "CICLO " + inConAnt.getCiclo() + "";
					} else if  (etiqueta.contains("Contrato LD:")) {
						if (inConAnt.getContratoLd() == null ) {
							valor =  "-";
						} else {
							String cadenaEstadoCuenta = "<a href=\"" + inConAnt.getEstadoCuenta()
		    	              + 	"\" target=\"_blank\">"
		    	              + 	"<img src=\""
		    	              +			inConAnt.getUrlIconoPdf() + "\""
		    	              + 	" alt=\"Estado Cuenta\" width=\"30\" height=\"30\">"
		    	              +		"</a>";
							valor =  inConAnt.getContratoLd()  + " - " + cadenaEstadoCuenta;
							LogHandler.info(etiqueta, getClass(), "cadenaEstadoCuenta:::  " + valor);
						}
					} else if  (etiqueta.contains("Producto:")) {
						valor = inConAnt.getProducto() == null ? "-" : inConAnt.getProducto();
					} else if  (etiqueta.contains("Campa")) {
						valor = inConAnt.getCampana() == null ? "-" : inConAnt.getCampana();
					} else if  (etiqueta.contains("Tasa")) {
						valor = inConAnt.getTasaAnual() + "%";
					} else if  (etiqueta.contains("Garant")) {
						valor = inConAnt.getPctGarantia() + "%";
					} else if  (etiqueta.contains("Monto")) {
						valor = "$" + Validaciones.formatoMoneda("", inConAnt.getMonto());
					} else if  (etiqueta.contains("Plazo")) {
						valor = inConAnt.getPlazo() + "";
					} else if  (etiqueta.contains("Frecuencia")) {
						valor = inConAnt.getFrecuencia() == null ? "" : inConAnt.getFrecuencia();
					} else if  (etiqueta.contains("Integrantes")) {
						valor = inConAnt.getNumIntegrantes() + "";
					} else if  (etiqueta.contains("Nombre Asesor")) {
						valor = inConAnt.getNombreAsesor() == null ? "" : inConAnt.getNombreAsesor();
					} else if  (etiqueta.contains("Estrellas")) {
						valor = Validaciones.nivelEstrellas(inConAnt.getNivelEstrellaAsesor());
					} else if  (etiqueta.contains("Pagos reali")) {
						if (inConAnt.getPagosRealizados() == null) {
							valor = "-";
						} else {
							valor = inConAnt.getPagosRealizados() + "";
						}
					} else if  (etiqueta.contains("Pagos falt")) {
						if (inConAnt.getPagosFaltantes() == null) {
							valor = "-";
						} else {
							valor = inConAnt.getPagosFaltantes() + "";
						}
					} else if  (etiqueta.contains("Estatus")) {
						valor = inConAnt.getEstatusContrato() == null ? "-" : inConAnt.getEstatusContrato();
					} else if  (etiqueta.contains("atraso")) {
						if (inConAnt.getDiasMaximoAtraso() == null) {
							valor = "-";
						} else {
							valor = inConAnt.getDiasMaximoAtraso() + "";
						}

					}

					if (etiqueta.contains("Ciclo:")) {
					trMensaje = trMensaje
							+ "<td colspan=\"3\" style=\"width:1500px; background: blue;"
							            + "margin:3px;padding:2px\">"
						    + "<h3 style=\"margin:4px;padding:0px;"
						    + "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
						    + "text-decoration:none;font-size:15px;color:rgb(255,255,255);"
						    + "letter-spacing:-0.04em\">" + valor + "</h3>"
						+ "</td>";
					} else {
						trMensaje = trMensaje
								+ "<td colspan=\"3\" style=\"width:1500px;border:blue 1px solid;margin:3px;padding:2px\">"
							    + "<h3 style=\"margin:4px;padding:0px;"
							    + "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
							    + "text-decoration:none;font-size:15px;color:rgb(5,9,244);"
							    + "letter-spacing:-0.04em\">" + valor + "</h3>"
							+ "</td>";
					}

					if (info.size() < 2) {
					    trMensaje = trMensaje
							+ "<td colspan=\"3\"  style=\"width:1500px;margin:3px;padding:2px;border:white 1px solid\">"
							+ "</td>";
					}
				}
				trMensaje = trMensaje + "</tr>";
		}
		return trMensaje;
	}

	/**
	 * M&eacute;todo que agrega el resumen de buro de los integrantes
	 * @param uid  identificador &uacute;nico de transacaci&oacute;n
	 * @param resumen resumen del buro
	 * @return String cadena del buro de cada cliente
	 */
	private String agregarResumenBuro( String uid, ResumenBuroRespuesta resumen) {
		String resumenBuro = "";
		   if (resumen != null && resumen.getResumenCliente() != null && resumen.getResumenCliente().size() > 0) {
		       resumenBuro = "<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:none;margin:0px;"
		       		          + "padding:0px;border-collapse:collapse;width:100%\">"
		    		          + "<tr style=\"border:none;margin:0px;padding:0px\">"
		    		          +     " <td></td><td></td><td></td><td></td><td style=\"border-right: white 2px solid;\"></td>"
		    		          +     " <td colspan=\"3\" style=\"border-right: white 2px solid;background:rgb(0, 50, 160);"
		    		          +           "border:blue 1px solid;margin:3px;padding:2px\">"
		    		          +        " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue'"
		    		          +        ",Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;color:rgb(255,255,255);"
		   	                  +                   "letter-spacing:-0.04em;text-align:center\">"
		                      +                    "CUENTAS ABIERTAS"
		                      +        "</h3>"
		                      +     " </td>"
		                      +     " <td colspan=\"3\" style=\"border-right: white 2px solid;background:rgb(0, 50, 160);"
		                      +                         "border:blue 1px solid;margin:3px;padding:2px\">"
		    		          +        " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    		          +               "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		    		          +               "color:rgb(255,255,255);letter-spacing:-0.04em;text-align:center\">"
		                      +                    "CUENTAS CERRADAS"
		                      +        "</h3>"
		                      +     " </td>"
		                      + "</tr>"
		                      + "<tr style=\"border:none;margin:0px;padding:0px\">"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "No."
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"width:60px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "# PERSONA"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border-right: white 2px solid;"
		                      +           "margin:3px;padding:2px\">"
		                      +           " <h3 style=\"width:180px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "CLIENTE"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border-right: white 2px solid;"
		                      +           "margin:3px;padding:2px\">"
		                      +           " <h3 style=\"width:60px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "MONTO SOLICITADO"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border-right: white 2px solid;"
		                      +           "margin:3px;padding:2px\">"
		                      +           " <h3 style=\"width:80px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "MONTO SOLICITADO CICLO ANTERIOR"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border-right: white 2px solid;"
		                      +           "margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "MOP"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "CA"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "SAA"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "SVA"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "CC"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "SAC"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border-right: white 2px solid;"
		                      +           "margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "MC"
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "HIPOT."
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "AUTOM."
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "CLAVES OBSERV."
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"width:90px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "NUM SOLIC ULTIMOS 6 MESES."
		                      +           " </h3>"
		                      +     " </td>"
		                      +     " <td style=\"background:rgb(0, 50, 160);border:blue 1px solid;margin:3px;padding:2px\">"
		                      +           " <h3 style=\"width:50px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +                 "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		                      +                 "color:rgb(255,255,255);letter-spacing:-0.04em;text-align: center\">"
		                      +                  "HIST&Oacute;RICO BUR&Oacute;."
		                      +           " </h3>"
		                      +     " </td>"
		                      +     "<td style=\"width:130px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		                      +          "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;color:rgb(0, 50, 160);"
		                      +          "letter-spacing:-0.04em\"> "
		                      +          " <div style=\" width:130px;margin-left: 10px\">"
		   	                  +                "CA = Cuentas Abierta <br/>"
		                      +                "SAA = Saldo Actual Abiertas <br/>"
		   	                  +                "SVA = Saldo Vencido Abiertas"
		                      +          " </div>"
		   	                  +     "</td>"
		                      + "</tr>"
		   	                  + "<tr>"
		   	                  +	   "<td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td>"
		   	                  +	   "<td></td><td></td><td></td><td></td><td></td><td></td><td></td>"
		   	                  +     "<td style=\"width:130px;margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		   	                  +            "Helvetica,Arial,sans-serif;"
		   	                  +            "text-decoration:none;font-size:9px;color:rgb(0, 50, 160);letter-spacing:-0.04em\"> "
		                      +          " <div style=\" width:130px;margin-left: 10px\">"
		   	                  +                " CC = Cuentas Cerradas"
		                      +          " </div>"
		   	                  +     "</td>"
		   	                  + "</tr>";

		    for (ResumenBuroCliente cliente : resumen.getResumenCliente()) {
		    	String numeroPersona =  cliente.getNumeroPersona() == null ? "" :  cliente.getNumeroPersona();
		    	String nombreCompleto = cliente.getNombreCompleto() == null ? "" : cliente.getNombreCompleto();
		    	String montoCicloAnterior = cliente.getMontoCicloAnterior() == null ? "" : cliente.getMontoCicloAnterior();
		    	String montoSolicitadoAproElec =
		    			cliente.getMontoSolicitadoAproElec() == null ? "" : cliente.getMontoSolicitadoAproElec();
		    	String colorMop = cliente.getStyleBackground() == null ? "" : cliente.getStyleBackground();
		    	String  mopTitulo = cliente.getMop() == null ? "" : cliente.getMop();
		    	LogHandler.info(uid, EnvioDeCorreos.class, "Mop: " + mopTitulo + " Color mop: " + colorMop);
		    	String hipotecario = cliente.getHipotecario() == null ? "" : cliente.getHipotecario();
		    	String automotriz = cliente.getAutomotriz() == null ? "" : cliente.getAutomotriz();
		    	String clavesObservacion = cliente.getClaveObservacion() == null ? "" : cliente.getClaveObservacion();
		    	String buroHistorico = cliente.getBuroHistorico() == null ? "" : cliente.getBuroHistorico();
		    	String urlIconoPdf = cliente.getUrlIconoPdf() == null ? "" : cliente.getUrlIconoPdf();
		    	String cadenaArmada = "<a href=\"" + buroHistorico
	    	              + 	"\" target=\"_blank\">"
	    	              + 	"<img src=\""
	    	              +		urlIconoPdf + "\""
	    	              + 	" alt=\"Buró Histórico\" width=\"30\" height=\"30\">"
	    	              +		"</a>";
		    	LogHandler.info(uid, EnvioDeCorreos.class, "buroHistorico::: " + buroHistorico);
		    	LogHandler.info(uid, EnvioDeCorreos.class, "urlIconoPdf::: " + urlIconoPdf);
		    	LogHandler.info(uid, EnvioDeCorreos.class, "cadenaArmada::: " + cadenaArmada);

		    	resumenBuro = resumenBuro + " <tr style=\"border:none;margin:0px;padding:0px;"
		                      +                   cliente.getBackgroundFila() + "\">"
		    			      +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    			      +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    			      +                "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		    			      +                "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    			      +                cliente.getIndice()
		    			      +           "</h3>"
		    	              +      "</td>"
		    	              +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    	              +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    			      +                "Helvetica,Arial,sans-serif;text-decoration:none;font-size:9px;"
		    			      +                "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    			      +                numeroPersona
		    			      +           "</h3>"
		    	              +      "</td>"
		    	              +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    	              +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
		    	              +                      "text-decoration:none;font-size:9px;color:rgb(0, 50, 160);"
		    	              +                      "letter-spacing:-0.04em;width:190px\">"
		    			      +                nombreCompleto
		    			      +           "</h3>"
		    	              +      "</td>"
		    	              +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    	              +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
		    	              +                      "text-decoration:none;font-size:9px;color:rgb(0, 50, 160);"
		    	              +                      "letter-spacing:-0.04em;width:60px\">"
		    			      +                montoSolicitadoAproElec
		    			      +           "</h3>"
		    	              +      "</td>"
		    	              +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    	              +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
		    	              +                      "text-decoration:none;font-size:9px;color:rgb(0, 50, 160);"
		    	              +                      "letter-spacing:-0.04em;width:80px\">"
		    			      +                montoCicloAnterior
		    			      +           "</h3>"
		    	              +      "</td>"
		    			      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;margin:4px;"
		    			      +           "padding:0px;font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
		    			      +           "text-decoration:none;font-size:8px;color:rgb(0, 50, 160);letter-spacing:-0.04em;"
		    			      +           "text-align: center;" + colorMop + "\">"
		    	              +            mopTitulo
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    	              +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align:center\">"
		    	              +            cliente.getCuentasAbiertas()
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            cliente.getFormatoSaldoActualAbiertas()
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            cliente.getFormatoSaldoVencidoAbiertas()
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            cliente.getCuentasCerradas()
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            cliente.getFormatoSaldoActualCerradas()
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            cliente.getFormatoMontoCerradas()
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            hipotecario
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            automotriz
		    	              +      "</td>"
		    	              +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	              +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	              +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
		    	              +            clavesObservacion
		    	              +      "</td>"
		    	              +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    	              +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    			      +                "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +                "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center;"
		    	              +                      "width:90px\">"
		    			      +                cliente.getHistoricoFinsol()
		    			      +           "</h3>"
		    			      +      "</td>"
		    	              +      "<td rowspan=\"" + cliente.getSizeMops() + "\""
		    	              +           " style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center\">"
		    			      +           "<h3 style=\"margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    			      +                "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
		    			      +                "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center;"
		    	              +                      "width:60px\">"
		    			      +							cadenaArmada
		    			      +           "</h3>"
		    	              +      "</td>";
		    	         if (cliente.getIndice() == 1) {
		    	        	 resumenBuro = resumenBuro + " <td style=\"width:130px;margin:4px;padding:0px;"
		    	        	  +          "font-family:Circular,'Helvetica Neue',Helvetica,Arial,sans-serif;"
		    	        	  +          "text-decoration:none;font-size:9px;color:rgb(0, 50, 160);letter-spacing:-0.04em\">"
		    	        	  +                               "<div style=\"width:130px;margin-left: 10px\">"
		    	        	  +                                     " SAC = Saldo Actual Cerradas <br/>"
		    	        	  +                                     "  MC = Monto Cerradas "
		    	        	  +                               "</div>"
		    	        	  +     "</td>";
		    	         }

		    	         resumenBuro = resumenBuro + "</tr>";
                    if (cliente != null && cliente.getMops() != null && cliente.getMops().size() > 0) {
		    	       for (ResumenBuroMop mop : cliente.getMops()) {
		    	    	    String colorMopInt = mop.getStyleBackground() == null ? "" : mop.getStyleBackground();
		    	    	    String mopTituloInt = mop.getMop() == null ? "" : mop.getMop();
		    	    	    LogHandler.info(uid, EnvioDeCorreos.class, "Mop: " + mopTituloInt + " Color mop: " + colorMopInt);
		    	    	    String hipotecarioInt = mop.getHipotecario() == null ? "" :  mop.getHipotecario();
		    	    	    String automotrizInt = mop.getAutomotriz() == null ? "" : mop.getAutomotriz();
		    	    	    String clavesObservacionInt = mop.getClaveObservacion() == null ? "" :  mop.getClaveObservacion();

		    	    	    resumenBuro = resumenBuro + " <tr style=\" " + cliente.getBackgroundFila() + "\">"
		    	    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
		    	    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
		    	    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center;"
		    	    	      +            colorMopInt + "\">"
				    	      +            mopTituloInt
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            mop.getCuentasAbiertas()
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            mop.getFormatoSaldoActualAbiertas()
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            mop.getFormatoSaldoVencidoAbiertas()
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            mop.getCuentasCerradas()
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            mop.getFormatoSaldoActualCerradas()
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            mop.getFormatoMontoCerradas()
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            hipotecarioInt
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            automotrizInt
				    	      +      "</td>"
				    	      +      "<td style=\"border:blue 1px solid;padding:0px 10px 5px;text-align: center;"
				    	      +           "margin:4px;padding:0px;font-family:Circular,'Helvetica Neue',"
				    	      +           "Helvetica,Arial,sans-serif;text-decoration:none;font-size:8px;"
				    		  +           "color:rgb(0, 50, 160);letter-spacing:-0.04em;text-align: center\">"
				    	      +            clavesObservacionInt
				    	      +      "</td>"
				    	      +  "</tr>";
					   }
		         }
			}

		    resumenBuro = resumenBuro + "<tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\" height=\"25px\">"
		    		          + " </tr>	"
		    		          + " <tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
		    		          +       "<td colspan=\"15\" valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
		    		          +            " <h3 style=\"border:none;margin:4px;padding:0px;font-family:Circular,"
		    		          +                  "'Helvetica Neue',Helvetica,Arial,sans-serif;"
		                      +                  "text-decoration:none;font-size:18px;color:rgb(0, 50, 160);"
		                      +                  "letter-spacing:-0.04em\">"
		    		          //+                  "Captura tu Observaci&oacute;n:"
		                      +            " </h3>"
		    		          +       "</td>"
		                      + "</tr>"
		    		          + "<tr valign=\"middle\" style=\"border:none;margin:0px;padding:0px\" height=\"25px\">"
		    		          + "</tr>	"
		    		          + " </table>";
		   }
		return resumenBuro;
	}

	/**
	 * M&eacute;todo que agrega el formulario
	 * @param uid  identificador &uacute;nico de transacaci&oacute;n
	 * @param url url de donde se mnada la peticion
	 * @return String cadena con el formulario
	 */
	private String agregarFormulario( String uid, ResumenBuroRespuesta url) {
		String formulario = null;
		       formulario = " <table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\" style=\"border:none;margin:0px;"
		       		      +       "padding:0px;border-collapse:collapse;width:100%\">"
		    		      +       " <tr style=\"border:none;margin:0px;padding:0px\">"
		    		      +            "<td valign=\"middle\" style=\"border:none;margin:0px;padding:0px\">"
		    		      +                " <form method=\"post\" action=\" " + url.getUrlRealiazarOperacionSolicitud() + "\">"
		    		      +                       "<textarea  rows=\"4\" cols=\"40\" maxlength=\"500\" name=\"observaciones\""
		    		      +                         " style=\"border: 2px solid #0032a0;width:480px; height:100px\">"
		    		      +                       "</textarea>"
		    		      +                       "<br /><br /><br />"
		    		      +                       "<div style=\"width:150px;margin-left: 100px;font-size:18px;\">"
		    		      +                           " <input type=\"radio\" name=\"operacion\" value=\"APROBADA\""
		    		      +                           " style=\"border: 1px solid #0032a0;background: #0032a0;color: #0032a0\" >"
		    		      +                                   "  <label style=\"margin:4px;padding:0px;font-family:Circular,"
		    		      +                                             "'Helvetica Neue',Helvetica,Arial,sans-serif;"
	                      +                                             "text-decoration:none;color:rgb(0, 50, 160);"
	                      +                                             "letter-spacing:-0.06em;font-weight:bold\">"
	                      +                                         " Aprobar"
	                      +                                   "  </label>"
	                      +                           " </input>"
	                      +                           " <br/><br/>"
	                      +                           "<input type=\"radio\" name=\"operacion\" value=\"RECHAZADA\""
	                      +                           " style=\"border: 1px solid #0032a0;background: #0032a0;color: #0032a0\" >"
	                      +                                "<label style=\"margin:4px;padding:0px;font-family:Circular,"
	                      +                                              "'Helvetica Neue',Helvetica,Arial,sans-serif;"
	                      +                                              "text-decoration:none;color:rgb(0, 50, 160);"
	                      +                                              "letter-spacing:-0.06em;font-weight:bold\">"
	                      +                                    " Rechazar"
	                      +                                 "</label>"
	                      +                           "</input>"
	                      +                        "</div>"
	                      +                           "<br /><br /><br />"
	                      +                           " <input type=\"submit\" value=\"Enviar datos >>\"  style=\"color:#e8f602;"
	                      +                           "text-align:center;font-size:20px;background-color:#0032a0;"
	                      +                           "border:1px solid #0032a0;margin-left: 110px;width:190px; height:30px\" />"
	                      +                    " </form>"
                          +               " </td>"
	                      +         " </tr>"
                          +  "</table>";
		return formulario;
	}

	/**
	 * M&eacute;todo que agrega un boton de enlace a la pagina de la captura de la respuesta
	 * @param uid  identificador &uacute;nico de transacaci&oacute;n
	 * @param url url de donde se mnada la peticion
	 * @return String cadena con el link a la pagina
	 */
	private String agregarBotonEnviarRespuesta( String uid, ResumenBuroRespuesta url) {
		LogHandler.info(uid, EnvioDeCorreos.class, "agregarBotonEnviarRespuesta:::" + url.getUrlConsultaDatosSolicitud());
		String botonEnviarRespuesta = null;
		botonEnviarRespuesta =  "<center>"
		    		      +               " <a href=\"" + url.getUrlConsultaDatosSolicitud() + "\"target=\"_blank\""
		    		      +                   "style=\"font-family: verdana, arial, sans-serif;font-size:20px;font-weight: bold;"
		    		      +                   "padding: 4px; background-color: #0032a0;color:#ffffff; text-decoration: none;"
		    		      +                   " text-align:center; border:1px solid #0032a0;\">"
		                  +                   "<< Mostrar solicitud >>"
		                  +                 "</a>"
                          +      "</center>";
		return botonEnviarRespuesta;
	}
}
