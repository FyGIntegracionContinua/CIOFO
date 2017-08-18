package negocio.procesarOFS;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

/**
 * @version 1.0.0
 * @author mi.mejorada
 *
 */
@Remotable
@WebService(name = "ProcesaOFSCreditoGrupal", targetNamespace = "http://fisa.com.mx/CIOF/ProcesaOFSCreditoGrupal/V1.0")
public interface ProcesaOFSCreditoGrupal {

	/**
	 * Punto de Acceso a las entradas OFS del POCG y sietmas satelites que se persitiran en CREDPROD las operaciones que reciben
	 * son:
	 * <ul>
	 * 	<li>Validar la fecha de inicio del contrato 	E.VALIDA.VALUE.DATE</li>
	 * 	<li>Calcular la fecha de fin del contrato 		E.CAL.FIN.MATE.DATE</li>
	 * 	<li>Obtener la fecha del sistema				E.GET.FECHAT</li>
	 * 	<li>Alta de Cliente   							OFS.ALTA/I </li>
	 * 	<li>Modificacion del Cliente 					OFS.CAMBIO/I</li>
	 * 	<li>Alta de Grupo 			 					OFS.ALTA.GRUPO/I</li>
	 * 	<li>Modificacion de Grupo 						OFS.CAMBIO.GRUPO/I</li>
	 * 	<li>Alta de Credito	Grupal						OFS.CAPTURA/I</li>
	 * 	<li>Aplicacion de Pagos							RPM.DDS</li>
	 * 	<li>Alta de Cliente Unico						OFS/I</li>
	 * 	<li>Consulta PD									E.CONSULTA.PD</li>
	 * 	<li>Condonacion Parcial 						E.CONDONACION.PARCIAL</li>
	 * 	<li>Consulta Credito Cheques SIC				E.INFO.CHEQUES.GRAL</li>
	 *  <li>Consulta Credito Clientes SIC				E.INFO.CHEQUES.CLIENTES</li>
	 * </ul>
	 * CREDPROD
	 * @param peticion cadena OFS que indica que acción se realizara.
	 * @return String cadena OFS con el resultado el procesamiento.
	 */
	String procesarOFSCreditoGrupal(
			@WebParam(name = "peticion", targetNamespace = "http://fisa.com.mx/CIOF/ProcesaOFSCreditoGrupal/V1.0")
			String peticion);

}
