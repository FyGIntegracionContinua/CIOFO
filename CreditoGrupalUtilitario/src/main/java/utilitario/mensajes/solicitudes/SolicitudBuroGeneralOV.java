package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SolicitudBuroGeneralOV.
 */
public class SolicitudBuroGeneralOV extends ObjetoValor {

	/**
	 * Instancia una nueva solicitud buro general ov.
	 */
	public SolicitudBuroGeneralOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1844309874284067876L;

	/** The solicitud. */
	private String solicitud;

	/** The valor tipificacion. */
	private String valorTipificacion;

	/** The promedio edad. */
	private Double promedioEdad;

	/** The porcentaje cuentas1. */
	private Double porcentajeCuentas1;

	/** The porcentaje cuentas2. */
	private Double porcentajeCuentas2;

	/** The resultado. */
	private String resultado;

	/**
	 * Obtiene solicitud.
	 *
	 * @return the solicitud
	 */
	public String getSolicitud() {
		return solicitud;
	}

	/**
	 * Establece solicitud.
	 *
	 * @param solicitud the solicitud to set
	 */
	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	/**
	 * Obtiene valor tipificacion.
	 *
	 * @return the valorTipificacion
	 */
	public String getValorTipificacion() {
		return valorTipificacion;
	}

	/**
	 * Establece valor tipificacion.
	 *
	 * @param valorTipificacion the valorTipificacion to set
	 */
	public void setValorTipificacion(String valorTipificacion) {
		this.valorTipificacion = valorTipificacion;
	}

	/**
	 * Obtiene promedio edad.
	 *
	 * @return the promedioEdad
	 */
	public Double getPromedioEdad() {
		return promedioEdad;
	}

	/**
	 * Establece promedio edad.
	 *
	 * @param promedioEdad the promedioEdad to set
	 */
	public void setPromedioEdad(Double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}

	/**
	 * Obtiene porcentaje cuentas1.
	 *
	 * @return the porcentajeCuentas1
	 */
	public Double getPorcentajeCuentas1() {
		return porcentajeCuentas1;
	}

	/**
	 * Establece porcentaje cuentas1.
	 *
	 * @param porcentajeCuentas1 the porcentajeCuentas1 to set
	 */
	public void setPorcentajeCuentas1(Double porcentajeCuentas1) {
		this.porcentajeCuentas1 = porcentajeCuentas1;
	}

	/**
	 * Obtiene porcentaje cuentas2.
	 *
	 * @return the porcentajeCuentas2
	 */
	public Double getPorcentajeCuentas2() {
		return porcentajeCuentas2;
	}

	/**
	 * Establece porcentaje cuentas2.
	 *
	 * @param porcentajeCuentas2 the porcentajeCuentas2 to set
	 */
	public void setPorcentajeCuentas2(Double porcentajeCuentas2) {
		this.porcentajeCuentas2 = porcentajeCuentas2;
	}

	/**
	 * Obtiene resultado.
	 *
	 * @return the resultado
	 */
	public String getResultado() {
		return resultado;
	}

	/**
	 * Establece resultado.
	 *
	 * @param resultado the resultado to set
	 */
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}


}
