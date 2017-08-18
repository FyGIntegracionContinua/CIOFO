package utilitario.mensajes.impresiondocs.contratocomunal;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.impresiondocs.comun.AvalGrupo;
import utilitario.mensajes.impresiondocs.comun.ContratoVO;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoKitPagare;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoPagare;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;

/**
 * The Class ContratoPagareKitRespuesta.
 */
public class KitImpresionPagareRespuesta extends ObjetoValor {

	/**
	 * ContratoPagareKitRespuesta
	 */
	public KitImpresionPagareRespuesta() {

	}
	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = -3867282440585111687L;
	/**
	 * header EncabezadoRespuesta
	 */
	private EncabezadoRespuesta header;

	/** The datos contrato. */
	private ContratoVO datosContrato;

	/**
	 * avales List<AvalGrupo>
	 */
	private List<AvalGrupo> avales;
	/**
	 * miembros List<MiembroGrupoPagare>
	 */
	private List<MiembroGrupoKitPagare> miembros;
	/**
	 * amortizaciones List<PagoGrupo>
	 */
	private List<PagoGrupo> amortizaciones;

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
	 * @return the avales
	 */
	public List<AvalGrupo> getAvales() {
		return avales;
	}
	/**
	 * @param avales the avales to set
	 */
	public void setAvales(List<AvalGrupo> avales) {
		this.avales = avales;
	}
	/**
	 * @return the miembros
	 */
	public List<MiembroGrupoKitPagare> getMiembros() {
		return miembros;
	}
	/**
	 * @param miembros the miembros to set
	 */
	public void setMiembros(List<MiembroGrupoKitPagare> miembros) {
		this.miembros = miembros;
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
	public ContratoVO getDatosContrato() {
		return datosContrato;
	}
	public void setDatosContrato(ContratoVO datosContrato) {
		this.datosContrato = datosContrato;
	}


}
