package negocio.consultasciclo;

import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

/**
 * @author rguadarramac
 * @version 1.0
 */
@Remotable
@WebService(name = "ConsultasCiclo", targetNamespace = "http://fisa.com.mx/CIOF/ConsultasCiclo/V1.0")
public interface ConsultasCiclo {

	/**
	 * @param peticion :
	 * @return String
	 */
	String obtenerReferenciasPago(String peticion);

}
