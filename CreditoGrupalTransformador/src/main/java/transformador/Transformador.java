package transformador;

import org.oasisopen.sca.annotation.Remotable;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author mi.mejorada
 * @version 1.0.0
 */
@Remotable
 public interface Transformador {

	/**
	 * OFS
	 */
	static int ERROR_APP	= 1;
	/**
	 * OFS
	 */
	static int ERROR_FIELD	= 2;

	/**
	 * Funcion que transforma una CadenaOFS en un objeto java a ser invocado por el servicio
	 * de Negocio.
	 * @param peticion String cadena OFS de interprotaci
	 * @param uid Idetificador unico
	 * @return ObjetoValor
	 */
	public ObjetoValor transformaStringAObjetoValor(String uid, String peticion );

	/**
	 * Funcion que transforma una  objeto java a una respuesta OFS a ser interpretada por
	 * los sistemas satelites de soporte a la operaci�n necesarios para el credito Grupal
	 * @param respuesta String Objeto Valor con la informacion de respuesta;
	 * @param uid Idetificador unico
	 * @return String
	 */
	public String transformaObjetoValorAString(String uid, ObjetoValor respuesta);

	/**
	 * M�todo que realiza la transformaci&oacute;n de un Objeto de cualquier tipo a una
	 * cadena (String) con formato XML.
	 * @author ISC Omar CC (ocruzc)
	 * @param uid {@link String} identificador de transacciones.
	 * @param objeto {@link ObjetoValor} objeto a transformar.
	 * @param clases Arreglo de {@link Class<?>[]} con las clases que se registrar&aacute;n como alias con Xstream.
	 * @return {@link String} del Objeto con formato XML.
	 */
	public String transformaObjetoAXML(String uid, ObjetoValor objeto, Class<?>[] clases);

	/**
	 * M�todo que realiza la tranfomaci&oacute;n de una cadena (String) a un Objeto de
	 * cualquier tipo.
	 * @author ISC Omar CC (ocruzc)
	 * <br/><b>Postcondici&oacute;n:</b><br/>
	 * Es necesario aplicar un <i>cast</i> al tipo de Objeto que se requiera obtener.
	 * @param uid {@link String} identificador de transacciones.
	 * @param xml {@link String} del Objeto con formato XML.
	 * @param clases Arreglo de {@link Class<?>[]} con las clases que se registrar&aacute;n como alias con Xstream.
	 * @return {@link ObjetoValor} objeto obtenido desde la cadena XML.
	 */
	public ObjetoValor transformaXMLAObjeto(String uid, String xml, Class<?>[] clases);

	/**
	 * @param uid Identificador unico
	 * @param objeto Objeto a convertir a JSon
	 * @return String con formato de Json
	 */
	public String transformaObjetoAJSON(String uid, Object objeto);


}
