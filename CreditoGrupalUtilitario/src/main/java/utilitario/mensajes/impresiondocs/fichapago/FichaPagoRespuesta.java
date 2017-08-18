package utilitario.mensajes.impresiondocs.fichapago;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoVO;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;

/**
 * The Class FichaPagoEspecialRespuesta.
 */
public class FichaPagoRespuesta extends ObjetoValor {

	/**
	 * FichaPagoEspecialRespuesta.
	 */
	public FichaPagoRespuesta() {
	}

	/**
	 * Serial version id
	 */
	private static final long serialVersionUID = 1L;

	/** The header. */
	private EncabezadoRespuesta	header;

	/** The datos contrato. */
	private ContratoVO datosContrato;

	/** amortizacion List<PagoGrupo>. */
	private List<PagoGrupo> amortizacion;

	/** The referencias. */
	private ConsultaReferenciasPagoRespuesta referencias;

	/** The interes moratorio dia. */
	private String interesMoratorioDia;

	/** The clave ficha. */
	private String claveFicha;

	/** The revision ficha. */
	private String revisionFicha;

	/** The clave ficha 2. */
	private String claveFicha2;

	/** The revision ficha 2. */
	private String revisionFicha2;

	/** The revision ficha Diestel1. */
	private String revisionFichaDiestel1;

	/** The revision ficha Diestel2. */
	private String revisionFichaDiestel2;

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
	 * @return the datosContrato
	 */
	public ContratoVO getDatosContrato() {
		return datosContrato;
	}

	/**
	 * @param datosContrato the datosContrato to set
	 */
	public void setDatosContrato(ContratoVO datosContrato) {
		this.datosContrato = datosContrato;
	}

	/**
	 * @return the amortizacion
	 */
	public List<PagoGrupo> getAmortizacion() {
		return amortizacion;
	}

	/**
	 * @param amortizacion the amortizacion to set
	 */
	public void setAmortizacion(List<PagoGrupo> amortizacion) {
		this.amortizacion = amortizacion;
	}

	/**
	 * @return the referencias
	 */
	public ConsultaReferenciasPagoRespuesta getReferencias() {
		return referencias;
	}

	/**
	 * @param referencias the referencias to set
	 */
	public void setReferencias(ConsultaReferenciasPagoRespuesta referencias) {
		this.referencias = referencias;
	}

	/**
	 * @return the interesMoratorioDia
	 */
	public String getInteresMoratorioDia() {
		return interesMoratorioDia;
	}

	/**
	 * @param interesMoratorioDia the interesMoratorioDia to set
	 */
	public void setInteresMoratorioDia(String interesMoratorioDia) {
		this.interesMoratorioDia = interesMoratorioDia;
	}

	/**
	 * @return the claveFicha
	 */
	public String getClaveFicha() {
		return claveFicha;
	}

	/**
	 * @param claveFicha the claveFicha to set
	 */
	public void setClaveFicha(String claveFicha) {
		this.claveFicha = claveFicha;
	}

	/**
	 * @return the revisionFicha
	 */
	public String getRevisionFicha() {
		return revisionFicha;
	}

	/**
	 * @param revisionFicha the revisionFicha to set
	 */
	public void setRevisionFicha(String revisionFicha) {
		this.revisionFicha = revisionFicha;
	}

	/**
	 * @return the claveFicha2
	 */
	public String getClaveFicha2() {
		return claveFicha2;
	}

	/**
	 * @param claveFicha2 the claveFicha2 to set
	 */
	public void setClaveFicha2(String claveFicha2) {
		this.claveFicha2 = claveFicha2;
	}

	/**
	 * @return the revisionFicha2
	 */
	public String getRevisionFicha2() {
		return revisionFicha2;
	}

	/**
	 * @param revisionFicha2 the revisionFicha2 to set
	 */
	public void setRevisionFicha2(String revisionFicha2) {
		this.revisionFicha2 = revisionFicha2;
	}

	/**
	 * @return the revisionFichaDiestel1
	 */
	public String getRevisionFichaDiestel1() {
		return revisionFichaDiestel1;
	}

	/**
	 * @param revisionFichaDiestel1 the revisionFichaDiestel1 to set
	 */
	public void setRevisionFichaDiestel1(String revisionFichaDiestel1) {
		this.revisionFichaDiestel1 = revisionFichaDiestel1;
	}

	/**
	 * @return the revisionFichaDiestel2
	 */
	public String getRevisionFichaDiestel2() {
		return revisionFichaDiestel2;
	}

	/**
	 * @param revisionFichaDiestel2 the revisionFichaDiestel2 to set
	 */
	public void setRevisionFichaDiestel2(String revisionFichaDiestel2) {
		this.revisionFichaDiestel2 = revisionFichaDiestel2;
	}
}
