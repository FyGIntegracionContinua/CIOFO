package negocio.chequescreditogrupal;

import javax.jws.WebService;

import org.oasisopen.sca.annotation.Remotable;

/**
 * @author out_ltorres
 * @version 1.0.0
 */
@Remotable
@WebService(name = "ChequesCreditoGrupal", targetNamespace = "http://fisa.com.mx/CIOF/ChequesCreditoGrupal/V1.0")
public interface ChequesCreditoGrupal {

	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getUniversoPrimerPago(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String proc_get_folios(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String proc_save_clientes(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String proc_regenera_folio(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String proc_get_folios_imp(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getvaleRenovado(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String insertalogvale(String peticionXML);
	/**
	 * Retorna universo de cheques.
	 * @param peticionXML String
	 * @return String
	 */
	String proc_get_universo_primer_pago(String peticionXML);
	/**
	 * @param peticionXML :
	 * @return String
	 */
	String getChequesDesembolsados(String peticionXML);
}
