package negocio.seguros;

import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

/**
 * @author rguadarramac
 * @version 1.0
 */
@Remotable
@WebService(name = "Seguros", targetNamespace = "http://fisa.com.mx/CIOF/Seguros/V1.0")
public interface Seguros {


	/**
	 *
	 * @return respuestaXML
	 * @param peticion parametro de peticion
	 */
	public String modificaSegurosBeneficiarios( String peticion );

	/**
	 *
	 * @return respuestaXML
	 * @param peticion parametro de peticion
	 */
	public String consultaSeguros( String peticion );


}
