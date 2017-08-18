package utilitario.mensajes.reportes.comun;

/**
 * The Enum ObtenerEstadoCuenta.
 */
public enum ObtenerEstadoCuenta {
	/**
	 * ObtenerEstadoCuenta INTEGRANTES
	 */
	INTEGRANTES("consulaDatosIntegrantes"),
	/**
	 * ObtenerEstadoCuenta GRUPO
	 */
	GRUPO("obtenerGrupoEstadoDeCuenta"),
	/**
	 * ObtenerEstadoCuenta DETALLE
	 */
	DETALLE("obtenerDetalleEstadoDeCuenta"),
	/**
	 * ObtenerEstadoCuenta DATOS
	 */
	DATOS("obtenerDatosEstadoDeCuenta"),
	/**
	 * ObtenerEstadoCuenta FINAL
	 */
	FINAL("obtenerFinalEstadoDeCuenta"),
	/**
	 * ObtenerEstadoCuenta VENCIDOS
	 */
	VENCIDOS("obtenerVencidoEstadoDeCuenta"),
	/**
	 * ObtenerEstadoCuenta AMORTIZACION_GRUPAL
	 */
	AMORTIZACION_GRUPAL("obtenerAmortizacionGrupal"),
	/**
	 * ObtenerEstadoCuenta AMORTIZACION_GRUPAL_ACTUAL
	 */
	AMORTIZACION_GRUPAL_ACTUAL("obtenerAmortizacionGrupalActual"),
	/**
	 * ObtenerEstadoCuenta AMORTIZACION_INDIVIDUAL
	 */
	AMORTIZACION_INDIVIDUAL("obtenerAmortizacionIndividual"),
	/**
	 * ObtenerEstadoCuenta UNIDAD_ESPECIALIZADA
	 */
	UNIDAD_ESPECIALIZADA("obtenerUnidadEspecializada");

	/**
	 * String seccion
	 */
	private String seccion;

	/**
	 * @param seccion :
	 */
	ObtenerEstadoCuenta(String seccion) {
		this.seccion = seccion;
	}

	/**
	 * @return getSeccion :
	 */
	public String getSeccion() {
		return seccion;
	}
}
