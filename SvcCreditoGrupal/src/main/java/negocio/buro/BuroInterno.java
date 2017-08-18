package negocio.buro;

import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

/**
 * @author rguadarramac
 * @version 1.0
 */
@Remotable
@WebService(name = "BuroInterno", targetNamespace = "http://fisa.com.mx/CIOF/BuroInterno/V1.0")
public interface BuroInterno {

	/**
	 *
	 * @return respuestaXML
	 * @param peticion parametro de peticion
	 */
	public String consultaBuroInterno( String peticion );

}
