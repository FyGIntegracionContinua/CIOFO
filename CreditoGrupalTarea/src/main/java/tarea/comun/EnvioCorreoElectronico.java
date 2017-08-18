package tarea.comun;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.correo.EnviarCorreoPeticion;
import utilitario.mensajes.correo.EnviarCorreoRespuesta;
import utilitario.mensajes.correo.DatosAdjuntos;


/**
 * Clase para enviar correos desde el ciof.
 * @author rmontellano
 *
 */
public class EnvioCorreoElectronico {
	
	public static final String MAIL_FROM = "ap_mail_finsol@finsol.com.mx";
	public static final String MAIL_PASS = "F1N60L_4PP8";
	public static final String SMTP_HOST = "smtp.gmail.com";
	public static final String SMTP_PORT = "587";
	public static final String SMTP_TLS = "true";

	/**
	 * Metodo para enviar correos.
	 * @param uid identificador unico de la transaccion
	 * @param peticion datos para envio de correo.
	 * @return confirmacion de envio de correo.
	 */
	public EnviarCorreoRespuesta enviarCorreoAdjunto(String uid,
			EnviarCorreoPeticion peticion) {

		EnviarCorreoRespuesta enviarCorreoRespuesta = new EnviarCorreoRespuesta();
		enviarCorreoRespuesta.setHeader(new EncabezadoRespuesta());

		try {

			if (peticion.getCuentaEnvio() == null) {
				peticion.setCuentaEnvio("");
			}
			if (peticion.getPasswordCuentaEnvio() == null) {
				peticion.setPasswordCuentaEnvio("");
			}
			if (!peticion.getCuentaEnvio().trim().isEmpty()) {
				if (peticion.getPasswordCuentaEnvio().trim().isEmpty()) {
					throw new Exception("Es necesario el password de la cuenta de envio.");
				}
			}
			String mail = "";
			String password = "";
			if (peticion.getCuentaEnvio().trim().isEmpty()) {
				mail = MAIL_FROM;
				password = 	MAIL_PASS;
			} else {
				mail = peticion.getCuentaEnvio();
				password = peticion.getPasswordCuentaEnvio();
			}

			Properties properties = new Properties();

			properties.put("mail.smtp.host", SMTP_HOST);
			properties.put("mail.smtp.starttls.enable", SMTP_TLS);
	        properties.put("mail.smtp.port", SMTP_PORT);
			properties.put("mail.from", MAIL_FROM);
			properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
			properties.put("mail.smtp.auth", "true");

			Session sesion = Session.getInstance(properties, new MyAuthenticator(mail, password));
			sesion.setDebug(false);

			Message msj = new MimeMessage(sesion);

			if (peticion.getArchivos() == null || peticion.getArchivos().isEmpty()) {

				msj.setFrom();
				msj.setContent(peticion.getTexto(), "text/html");
				msj.setSubject(peticion.getAsunto());
				InternetAddress [] destinatarios = InternetAddress.parse(peticion.getDestinatarios());
				msj.setRecipients(Message.RecipientType.TO,  destinatarios);
				Transport.send(msj);

				enviarCorreoRespuesta.getHeader().setMensaje(
						ReadProperties.mensajes.getProp("ciof.envio.correcto.exitoso"));
				enviarCorreoRespuesta.getHeader().setUID(uid);
			}
			else {

				MimeMultipart correo = new MimeMultipart();

				for (DatosAdjuntos archivos : peticion.getArchivos()) {
					correo.addBodyPart(getAdjunto(archivos.getNombreArchivo(), archivos.getRuta()));
				}

				msj.setFrom();
//				msj.setText(peticion.getTexto());
				msj.setContent(peticion.getTexto(), "text/html");
				msj.setSubject(peticion.getAsunto());
				InternetAddress [] destinatarios = InternetAddress.parse(peticion.getDestinatarios());
				msj.setRecipients(Message.RecipientType.TO,  destinatarios);
				msj.setContent(correo);
				Transport transport = sesion.getTransport("smtp");
				transport.connect();
				transport.sendMessage(msj, msj.getAllRecipients());
				transport.close();

				enviarCorreoRespuesta.getHeader().setMensaje(
						ReadProperties.mensajes.getProp("ciof.envio.correcto.exitoso"));
			}

		} catch (Exception ex) {
			enviarCorreoRespuesta.getHeader().setMensaje( ex.getMessage());
			enviarCorreoRespuesta.getHeader().setEstatus( false );
			enviarCorreoRespuesta.getHeader().setUID(uid);
			LogHandler.error( uid, this.getClass(),
					ReadProperties.mensajes.getProp("ciof.error.envio.correo") + ex.getMessage(), ex);
			ex.printStackTrace();
		}

		return enviarCorreoRespuesta;

	}

	/**
	 * @param nombreArchivo :
	 * @param ruta :
	 * @return :
	 */
	private BodyPart getAdjunto(String nombreArchivo, String ruta)	{

		try {
			BodyPart body = new MimeBodyPart();
			body.setDataHandler(new DataHandler(new FileDataSource(ruta)));
			body.setFileName(nombreArchivo);
			return body;

		} catch (MessagingException e) {
			e.printStackTrace();
			return null;
		}
	}

	 /**
	 * @author equipo desarrollo
	 *
	 */
	class MyAuthenticator extends Authenticator {

		/**
		 * Cuenta de mail de envio
		 */
		private String mail;
		/**
		 * Password de la cuenta de envio.
		 */
		private String password;
		 /**
		 * MyAuthenticator
		 * @param mail cuenta de envio
		 * @param password password cuenta de envio
		 */
		public MyAuthenticator(String mail, String password) {
			this.mail = mail;
			this.password = password;
		 }

			        /**
	         * PasswordAuthentication :
	         * @return :
	         */
	        protected PasswordAuthentication getPasswordAuthentication() {
	        	return new PasswordAuthentication(mail, password);
	        }
	    }

}
