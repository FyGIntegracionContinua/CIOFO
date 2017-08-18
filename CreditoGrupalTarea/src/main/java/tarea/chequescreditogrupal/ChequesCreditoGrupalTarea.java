/**
 *
 */
package tarea.chequescreditogrupal;

import utilitario.comun.Constantes;
import utilitario.mensajes.chequescreditogrupal.ChequesClientePeticion;
import utilitario.mensajes.chequescreditogrupal.ChequesClienteRespuesta;
import utilitario.mensajes.chequescreditogrupal.ChequesDesembolsadosPeticion;
import utilitario.mensajes.chequescreditogrupal.ChequesDesembolsadosRespuesta;
import utilitario.mensajes.chequescreditogrupal.ChequesRegeneraFolioPeticion;
import utilitario.mensajes.chequescreditogrupal.ChequesRegeneraFolioRespuesta;
import utilitario.mensajes.chequescreditogrupal.FoliosImpRespuesta;
import utilitario.mensajes.chequescreditogrupal.FoliosRespuesta;
import utilitario.mensajes.chequescreditogrupal.ProcUniversoPrimerPagoRespuesta;
import utilitario.mensajes.chequescreditogrupal.UniversoPrimerPagoPeticion;
import utilitario.mensajes.chequescreditogrupal.UniversoPrimerPagoRespuesta;
import utilitario.mensajes.chequescreditogrupal.ValeCreditoPeticion;
import utilitario.mensajes.chequescreditogrupal.ValesRenovadosRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;

/**
 * @author out_ltorres
 * @version 1.0.0
 */
public interface ChequesCreditoGrupalTarea extends Constantes {

	/**
	 * Obtiene universo primer pago tarea.
	 *
	 * @param uid the uid
	 * @param universoPrimerPagoPeticion the universo primer pago peticion
	 * @return universo primer pago tarea
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#getUniversoPrimerPagoTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.UniversoPrimerPagoPeticion)
	 */
	UniversoPrimerPagoRespuesta getUniversoPrimerPagoTarea(String uid, UniversoPrimerPagoPeticion universoPrimerPagoPeticion);

	/**
	 * Proc_get_folios tarea.
	 *
	 * @param uid the uid
	 * @param contratoPeticionKit the contrato peticion kit
	 * @return the folios respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_get_foliosTarea(
	 * java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	FoliosRespuesta proc_get_foliosTarea(String uid, ContratoPeticionKit contratoPeticionKit);

	/**
	 * Proc_save_clientes tarea.
	 *
	 * @param uid the uid
	 * @param chequesClientePeticion the cheques cliente peticion
	 * @return the cheques cliente respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_save_clientesTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ChequesClientePeticion)
	 */
	ChequesClienteRespuesta proc_save_clientesTarea(String uid, ChequesClientePeticion chequesClientePeticion);

	/**
	 * Proc_regenera_folio tarea.
	 *
	 * @param uid String
	 * @param chequesRegeneraFolioPeticion the cheques regenera folio peticion
	 * @return the cheques regenera folio respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_regenera_folioTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ChequesRegeneraFolioPeticion)
	 */
	ChequesRegeneraFolioRespuesta proc_regenera_folioTarea(String uid, ChequesRegeneraFolioPeticion chequesRegeneraFolioPeticion);

	/**
	 * Proc_get_folios_imp tarea.
	 *
	 * @param uid the uid
	 * @param contratoPeticionKit the contrato peticion kit
	 * @return the folios imp respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#proc_get_folios_impTarea(
	 * java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	FoliosImpRespuesta proc_get_folios_impTarea(String uid, ContratoPeticionKit contratoPeticionKit);

	/**
	 * Obtiene vale renovado tarea.
	 *
	 * @param uid the uid
	 * @param contratoPeticionKit the contrato peticion kit
	 * @return vale renovado tarea
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#getvaleRenovadoTarea(
	 * java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	ValesRenovadosRespuesta getvaleRenovadoTarea(String uid, ContratoPeticionKit contratoPeticionKit);

	/**
	 * Insertalogvale tarea.
	 *
	 * @param uid the uid
	 * @param valeCreditoPeticion the vale credito peticion
	 * @return the vales renovados respuesta
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#insertalogvaleTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ValeCreditoPeticion)
	 */
	ValesRenovadosRespuesta insertalogvaleTarea(String uid, ValeCreditoPeticion valeCreditoPeticion);

	/**
	 * Metodo retorna universo de cheques
	 * @param uid String
	 * @param universoPrimerPagoPeticion UniversoPrimerPagoPeticion
	 * @return respuesta
	 */
	ProcUniversoPrimerPagoRespuesta proc_get_universo_primer_pagoTarea(
			String uid, UniversoPrimerPagoPeticion universoPrimerPagoPeticion);
	/**
	 * Obtiene cheques desembolsados tarea.
	 *
	 * @param uid the uid
	 * @param chequesDesembolsadosPeticion the cheques desembolsados peticion
	 * @return cheques desembolsados tarea
	 * @see tarea.chequescreditogrupal.ChequesCreditoGrupalTarea#ChequesDesembolsadosTarea(
	 * java.lang.String, utilitario.mensajes.chequescreditogrupal.ChequesDesembolsadosPeticion)
	 */
	ChequesDesembolsadosRespuesta getChequesDesembolsadosTarea(String uid,
			ChequesDesembolsadosPeticion chequesDesembolsadosPeticion);

}
