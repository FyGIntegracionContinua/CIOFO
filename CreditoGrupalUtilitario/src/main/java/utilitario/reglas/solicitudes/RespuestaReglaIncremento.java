package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

public class RespuestaReglaIncremento  extends ObjetoValor {

	/**
	 * Serial
	 */
	private static final long serialVersionUID = -4182335161996149066L;

	/**
	 * Instantiates a new respuesta regla incremento.
	 */
	public RespuestaReglaIncremento() {
	}

	/**
	 * EncabezadoRespuesta header
	 */
	private EncabezadoRespuesta header;

	/**
	 * porcentajeIncremento
	 */
	private Double porcentajeIncremento;
	/**
	 * otorgaCredito
	 */
	private boolean otorgaCredito;
	/**
	 * persona
	 */
	private String persona;
	/**
	 * persona
	 */
	private boolean mop99;
	/**
	 * persona
	 */
	private boolean hipotecarioAutomotriz;
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
	 * @return the porcentajeIncremento
	 */
	public Double getPorcentajeIncremento() {
		return porcentajeIncremento;
	}
	/**
	 * @param porcentajeIncremento the porcentajeIncremento to set
	 */
	public void setPorcentajeIncremento(Double porcentajeIncremento) {
		this.porcentajeIncremento = porcentajeIncremento;
	}
	/**
	 * @return the otorgaCredito
	 */
	public boolean isOtorgaCredito() {
		return otorgaCredito;
	}
	/**
	 * @param otorgaCredito the otorgaCredito to set
	 */
	public void setOtorgaCredito(boolean otorgaCredito) {
		this.otorgaCredito = otorgaCredito;
	}
	/**
	 * @return the persona
	 */
	public String getPersona() {
		return persona;
	}
	/**
	 * @param persona the persona to set
	 */
	public void setPersona(String persona) {
		this.persona = persona;
	}
	/**
	 * @return the mop99
	 */
	public boolean isMop99() {
		return mop99;
	}
	/**
	 * @param mop99 the mop99 to set
	 */
	public void setMop99(boolean mop99) {
		this.mop99 = mop99;
	}
	/**
	 * @return the hipotecarioAutomotriz
	 */
	public boolean isHipotecarioAutomotriz() {
		return hipotecarioAutomotriz;
	}
	/**
	 * @param hipotecarioAutomotriz the hipotecarioAutomotriz to set
	 */
	public void setHipotecarioAutomotriz(boolean hipotecarioAutomotriz) {
		this.hipotecarioAutomotriz = hipotecarioAutomotriz;
	}

}
