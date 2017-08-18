package utilitario.mensajes.operacion;

import java.util.Date;

import utilitario.mensajes.comun.ObjetoValor;

public class CargaInformacionPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 4365091621029410942L;
	/** cargaInicial */
	private boolean cargaInicial;
	/** fechaInicio */
	private Date fechaInicio;
	/** fechaFin */
	private Date fechaFin;
	/**
	 * @return the cargaInicial
	 */
	public boolean isCargaInicial() {
		return cargaInicial;
	}
	/**
	 * @param cargaInicial the cargaInicial to set
	 */
	public void setCargaInicial(boolean cargaInicial) {
		this.cargaInicial = cargaInicial;
	}
	/**
	 * @return the fechaInicio
	 */
	public Date getFechaInicio() {
		return fechaInicio;
	}
	/**
	 * @param fechaInicio the fechaInicio to set
	 */
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	/**
	 * @return the fechaFin
	 */
	public Date getFechaFin() {
		return fechaFin;
	}
	/**
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

}
