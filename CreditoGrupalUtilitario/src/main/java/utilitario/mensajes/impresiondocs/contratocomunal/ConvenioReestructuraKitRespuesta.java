package utilitario.mensajes.impresiondocs.contratocomunal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.impresiondocs.comun.ContratoRestructuraVO;
import utilitario.mensajes.impresiondocs.comun.ContratoVigenteVO;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVigenteVO;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;
import utilitario.mensajes.impresiondocs.comun.ValesVO;

/**
 * The Class ConvenioReestructuraKitRespuesta.
 */
public class ConvenioReestructuraKitRespuesta extends ObjetoValor {

	/**
	 * ConvenioReestructuraKitRespuesta
	 */
	public ConvenioReestructuraKitRespuesta() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -2678175860425914194L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;
	/**
	 * contratoNuevo ContratoRestructuraVO
	 */
	private ContratoRestructuraVO contratoNuevo;
	/**
	 * contratoAnterior ContratoVigenteVO
	 */
	private ContratoVigenteVO contratoAnterior;
	/**
	 * integrantesAnterior List<MiembroGrupoVigenteVO>
	 */
	private List<MiembroGrupoVigenteVO> integrantesAnterior;
	/**
	 * integrantes List<MiembroGrupoVO>
	 */
	private List<MiembroGrupoVO> integrantes;
	/**
	 * amortizaciones List<PagoGrupo>
	 */
	private List<PagoGrupo> amortizaciones;
	/**
	 * vales List<ValesVO>
	 */
	private List<ValesVO> vales;
	/**
	 * @return the header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}
	/**
	 * @return the contratoNuevo
	 */
	public ContratoRestructuraVO getContratoNuevo() {
		return contratoNuevo;
	}
	/**
	 * @param contratoNuevo the contratoNuevo to set
	 */
	public void setContratoNuevo(ContratoRestructuraVO contratoNuevo) {
		this.contratoNuevo = contratoNuevo;
	}
	/**
	 * @return the contratoAnterior
	 */
	public ContratoVigenteVO getContratoAnterior() {
		return contratoAnterior;
	}
	/**
	 * @param contratoAnterior the contratoAnterior to set
	 */
	public void setContratoAnterior(ContratoVigenteVO contratoAnterior) {
		this.contratoAnterior = contratoAnterior;
	}
	/**
	 * @return the integrantesAnterior
	 */
	public List<MiembroGrupoVigenteVO> getIntegrantesAnterior() {
		return integrantesAnterior;
	}
	/**
	 * @param integrantesAnterior the integrantesAnterior to set
	 */
	public void setIntegrantesAnterior(
			List<MiembroGrupoVigenteVO> integrantesAnterior) {
		this.integrantesAnterior = integrantesAnterior;
	}
	/**
	 * @return the integrantes
	 */
	public List<MiembroGrupoVO> getIntegrantes() {
		return integrantes;
	}
	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<MiembroGrupoVO> integrantes) {
		this.integrantes = integrantes;
	}
	/**
	 * @return the amortizaciones
	 */
	public List<PagoGrupo> getAmortizaciones() {
		return amortizaciones;
	}
	/**
	 * @param amortizaciones the amortizaciones to set
	 */
	public void setAmortizaciones(List<PagoGrupo> amortizaciones) {
		this.amortizaciones = amortizaciones;
	}
	/**
	 * @return the vales
	 */
	public List<ValesVO> getVales() {
		return vales;
	}
	/**
	 * @param vales the vales to set
	 */
	public void setVales(List<ValesVO> vales) {
		this.vales = vales;
	}

	}
