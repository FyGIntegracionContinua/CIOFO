package utilitario.mensajes.impresiondocs.solidariocontrato;

import utilitario.mensajes.impresiondocs.comun.ContratoVO;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;

/**
 * The Class SolidarioContratoRespuesta.
 */
public class SolidarioContratoRespuesta {

	/**
	 * SolidarioContratoRespuesta
	 */
	SolidarioContratoRespuesta() {

	}
	/*respuesta ofs*/
	/**
	 * solidario_contrato String
	 */
	public String  solidario_contrato;

	/**
	 * @param solidario_contrato the solidario_contrato to set
	 */
	public void setSolidario_contrato(String solidario_contrato) {
		this.solidario_contrato = solidario_contrato;
	}
	/**
	 * contrato ContratoVO
	 */
	private ContratoVO contrato;
	/**
	 * miembrosGrupo MiembroGrupoVO[]
	 */
	private MiembroGrupoVO [] miembrosGrupo;
	/**
	 * @return the contrato
	 */
	public ContratoVO getContrato() {
		return contrato;
	}
	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(ContratoVO contrato) {
		this.contrato = contrato;
	}
	/**
	 * @return the miembrosGrupo
	 */
	public MiembroGrupoVO[] getMiembrosGrupo() {
		return miembrosGrupo;
	}
	/**
	 * @param miembrosGrupo the miembrosGrupo to set
	 */
	public void setMiembrosGrupo(MiembroGrupoVO[] miembrosGrupo) {
		this.miembrosGrupo = miembrosGrupo;
	}
	/**
	 * @return the pagosGrupo
	 */
	public PagoGrupo[] getPagosGrupo() {
		return pagosGrupo;
	}
	/**
	 * @param pagosGrupo the pagosGrupo to set
	 */
	public void setPagosGrupo(PagoGrupo[] pagosGrupo) {
		this.pagosGrupo = pagosGrupo;
	}
	/**
	 * pagosGrupo PagoGrupo[]
	 */
	private PagoGrupo [] pagosGrupo;
}
