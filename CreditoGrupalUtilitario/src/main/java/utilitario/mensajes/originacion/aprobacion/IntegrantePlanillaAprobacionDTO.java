package utilitario.mensajes.originacion.aprobacion;

import utilitario.mensajes.comun.ObjetoValor;

public class IntegrantePlanillaAprobacionDTO extends ObjetoValor implements Comparable<IntegrantePlanillaAprobacionDTO>  {

	/**
	 * constructor
	 */
	public IntegrantePlanillaAprobacionDTO() {

	}
	/**
	 * LONG
	 */
	private static final long serialVersionUID = -4478902924736329332L;

	/** The id planilla. */
	private int idPlanilla;
	/**
	 * persona
	 */
	private String persona;
	/**
	 * claveClienteUnico
	 */
	private String claveClienteUnico;

	//Datos por integrante
	/**
	 * dINombreCliente
	 */
	private String dINombreCliente;
	/**
	 * dIEdad
	 */
	private int dIEdad;
	/**
	 * dIEstadoCivil
	 */
	private String dIEstadoCivil;
	/**
	 * dICiclo
	 */
	private int dICiclo;
	/**
	 * dIContratoAnterior
	 */
	private String dIContratoAnterior;
	/**
	 * dIMontoContratoAnterior
	 */
	private double dIMontoContratoAnterior;
	/**
	 * dIEstatusContratoAnterior
	 */
	private String dIEstatusContratoAnterior;
	/**
	 * dIProductoContratoAnterior
	 */
	private String dIProductoContratoAnterior;
	/**
	 * dITipificacionProducto
	 */
	private String dITipificacionProducto;
	/**
	 * dIMontoSolicitado
	 */
	private double dIMontoSolicitado;
	/**
	 * dIMontoPropuesto
	 */
	private double dIMontoPropuesto;
	/**
	 * dILinkEstadoCuenta
	 */
	private String dILinkEstadoCuenta;
	/**
	 * dILinkResumenBuros
	 */
	private String dILinkResumenBuros;
	/**
	 * dILinkBuroCredito
	 */
	private String dILinkBuroCredito;

	//Antecedentes Finsol
	/**
	 * aFmontoUltimoCredito
	 */
	private double aFmontoUltimoCredito;
	/**
	 * aFmaximoAtrasoUltimoCredito
	 */
	private int aFmaximoAtrasoUltimoCredito;
	/**
	 * aFmaximoAtrasoPosteriorUltimoCredito
	 */
	private int aFmaximoAtrasoPosteriorUltimoCredito;
	/**
	 * aFmontoPenultimoCredito
	 */
	private double aFmontoPenultimoCredito;
	/**
	 * aFmaximoAtrasoPenultimoCredito
	 */
	private int aFmaximoAtrasoPenultimoCredito;
	/**
	 * aFmaximoAtrasoPosteriorPenultimoCredito
	 */
	private int aFmaximoAtrasoPosteriorPenultimoCredito;
	/**
	 * aFmontoAntepenultimoCredito
	 */
	private double aFmontoAntepenultimoCredito;
	/**
	 * aFmaximoAtrasoAntepenultimoCredito
	 */
	private int aFmaximoAtrasoAntepenultimoCredito;
	/**
	 * aFmaximoAtrasoPosteriorAntepenultimoCredito
	 */
	private int aFmaximoAtrasoPosteriorAntepenultimoCredito;

	//Antecedentes Sistema Financiero
	/**
	 * asFFolioConsulta
	 */
	private String asFFolioConsulta;
	/**
	 * aSFVigencia
	 */
	private String aSFVigencia;
	/**
	 * aSFSaldoDeudaVigente
	 */
	private double aSFSaldoDeudaVigente;
	/**
	 * aSFSaldoDeudaVencido
	 */
	private double aSFSaldoDeudaVencido;
	/**
	 * aSFCuotaSemanal
	 */
	private double aSFCuotaSemanal;
	/**
	 * aSFMopMaximoAbierto
	 */
	private String aSFMopMaximoAbierto;
	/**
	 * aSFMopMaximoCerrado
	 */
	private String aSFMopMaximoCerrado;
	/**
	 * aSFMopAutomotrizHipotecario
	 */
	private String aSFMopAutomotrizHipotecario;
	/**
	 * aSFSaldoVenciodotrizHipotecario
	 */
	private String aSFSaldoVenciodotrizHipotecario;

	//Situacion Economica Financiera
	/**
	 * sECuotaSemanal
	 */
	private double sECuotaSemanal;
	/**
	 * sETipoDomicilio
	 */
	private String sETipoDomicilio;
	/**
	 * sETiempoResidencia
	 */
	private int sETiempoResidencia;
	/**
	 * sEDestinoCredito
	 */
	private String sEDestinoCredito;
	/**
	 * sEActividadPrimaria
	 */
	private String sEActividadPrimaria;
	/**
	 * sEAntiguedadNegocio
	 */
	private int sEAntiguedadNegocio;
	/**
	 * sEAntiguedadRubro
	 */
	private int sEAntiguedadRubro;
	/**
	 * sETipoNegocio
	 */
	private String sETipoNegocio;
	/**
	 * sEPorcentajeGanancia
	 */
	private double sEPorcentajeGanancia;
	/**
	 * sEGananciaSemanalNegocio
	 */
	private double sEGananciaSemanalNegocio;
	/**
	 * sEOtrosIngresos
	 */
	private double sEOtrosIngresos;
	/**
	 * sEGananciaActividadSecundaria
	 */
	private double sEGananciaActividadSecundaria;
	/**
	 * sETotalGastosFamiliares
	 */
	private double sETotalGastosFamiliares;
	/**
	 * sEDisponibleCalculado
	 */
	private double sEDisponibleCalculado;
	/**
	 * sEMontoDeclarado
	 */
	private double sEMontoDeclarado;
	/**
	 * sESuperavitCuotaMonto
	 */
	private double sESuperavitCuotaMonto;
	/**
	 * sESuperavitCuotaDisponible
	 */
	private double sESuperavitCuotaDisponible;
	/**
	 * sETotalDeclaradoNegocio
	 */
	private double sETotalDeclaradoNegocio;
	/**
	 * clavesObservacion
	 */
	private String clavesObservacion;

	/**
	 * @return the dINombreCliente
	 */
	public String getdINombreCliente() {
		return dINombreCliente;
	}
	/**
	 * @param dINombreCliente the dINombreCliente to set
	 */
	public void setdINombreCliente(String dINombreCliente) {
		this.dINombreCliente = dINombreCliente;
	}
	/**
	 * @return the dIEdad
	 */
	public int getdIEdad() {
		return dIEdad;
	}
	/**
	 * @param dIEdad the dIEdad to set
	 */
	public void setdIEdad(int dIEdad) {
		this.dIEdad = dIEdad;
	}
	/**
	 * @return the dIEstadoCivil
	 */
	public String getdIEstadoCivil() {
		return dIEstadoCivil;
	}
	/**
	 * @param dIEstadoCivil the dIEstadoCivil to set
	 */
	public void setdIEstadoCivil(String dIEstadoCivil) {
		this.dIEstadoCivil = dIEstadoCivil;
	}
	/**
	 * @return the dICiclo
	 */
	public int getdICiclo() {
		return dICiclo;
	}
	/**
	 * @param dICiclo the dICiclo to set
	 */
	public void setdICiclo(int dICiclo) {
		this.dICiclo = dICiclo;
	}
	/**
	 * @return the dIContratoAnterior
	 */
	public String getdIContratoAnterior() {
		return dIContratoAnterior;
	}
	/**
	 * @param dIContratoAnterior the dIContratoAnterior to set
	 */
	public void setdIContratoAnterior(String dIContratoAnterior) {
		this.dIContratoAnterior = dIContratoAnterior;
	}
	/**
	 * @return the dIEstatusContratoAnterior
	 */
	public String getdIEstatusContratoAnterior() {
		return dIEstatusContratoAnterior;
	}
	/**
	 * @param dIEstatusContratoAnterior the dIEstatusContratoAnterior to set
	 */
	public void setdIEstatusContratoAnterior(String dIEstatusContratoAnterior) {
		this.dIEstatusContratoAnterior = dIEstatusContratoAnterior;
	}
	/**
	 * @return the dIProductoContratoAnterior
	 */
	public String getdIProductoContratoAnterior() {
		return dIProductoContratoAnterior;
	}
	/**
	 * @param dIProductoContratoAnterior the dIProductoContratoAnterior to set
	 */
	public void setdIProductoContratoAnterior(String dIProductoContratoAnterior) {
		this.dIProductoContratoAnterior = dIProductoContratoAnterior;
	}
	/**
	 * @return the dITipificacionProducto
	 */
	public String getdITipificacionProducto() {
		return dITipificacionProducto;
	}
	/**
	 * @param dITipificacionProducto the dITipificacionProducto to set
	 */
	public void setdITipificacionProducto(String dITipificacionProducto) {
		this.dITipificacionProducto = dITipificacionProducto;
	}
	/**
	 * @return the dIMontoSolicitado
	 */
	public double getdIMontoSolicitado() {
		return dIMontoSolicitado;
	}
	/**
	 * @param dIMontoSolicitado the dIMontoSolicitado to set
	 */
	public void setdIMontoSolicitado(double dIMontoSolicitado) {
		this.dIMontoSolicitado = dIMontoSolicitado;
	}
	/**
	 * @return the dIMontoPropuesto
	 */
	public double getdIMontoPropuesto() {
		return dIMontoPropuesto;
	}
	/**
	 * @param dIMontoPropuesto the dIMontoPropuesto to set
	 */
	public void setdIMontoPropuesto(double dIMontoPropuesto) {
		this.dIMontoPropuesto = dIMontoPropuesto;
	}
	/**
	 * @return the dILinkEstadoCuenta
	 */
	public String getdILinkEstadoCuenta() {
		return dILinkEstadoCuenta;
	}
	/**
	 * @param dILinkEstadoCuenta the dILinkEstadoCuenta to set
	 */
	public void setdILinkEstadoCuenta(String dILinkEstadoCuenta) {
		this.dILinkEstadoCuenta = dILinkEstadoCuenta;
	}
	/**
	 * @return the dILinkResumenBuros
	 */
	public String getdILinkResumenBuros() {
		return dILinkResumenBuros;
	}
	/**
	 * @param dILinkResumenBuros the dILinkResumenBuros to set
	 */
	public void setdILinkResumenBuros(String dILinkResumenBuros) {
		this.dILinkResumenBuros = dILinkResumenBuros;
	}
	/**
	 * @return the dILinkBuroCredito
	 */
	public String getdILinkBuroCredito() {
		return dILinkBuroCredito;
	}
	/**
	 * @param dILinkBuroCredito the dILinkBuroCredito to set
	 */
	public void setdILinkBuroCredito(String dILinkBuroCredito) {
		this.dILinkBuroCredito = dILinkBuroCredito;
	}
	/**
	 * @return the aFmontoUltimoCredito
	 */
	public double getaFmontoUltimoCredito() {
		return aFmontoUltimoCredito;
	}
	/**
	 * @param aFmontoUltimoCredito the aFmontoUltimoCredito to set
	 */
	public void setaFmontoUltimoCredito(double aFmontoUltimoCredito) {
		this.aFmontoUltimoCredito = aFmontoUltimoCredito;
	}
	/**
	 * @return the aFmaximoAtrasoUltimoCredito
	 */
	public int getaFmaximoAtrasoUltimoCredito() {
		return aFmaximoAtrasoUltimoCredito;
	}
	/**
	 * @param aFmaximoAtrasoUltimoCredito the aFmaximoAtrasoUltimoCredito to set
	 */
	public void setaFmaximoAtrasoUltimoCredito(int aFmaximoAtrasoUltimoCredito) {
		this.aFmaximoAtrasoUltimoCredito = aFmaximoAtrasoUltimoCredito;
	}
	/**
	 * @return the aFmaximoAtrasoPosteriorUltimoCredito
	 */
	public int getaFmaximoAtrasoPosteriorUltimoCredito() {
		return aFmaximoAtrasoPosteriorUltimoCredito;
	}
	/**
	 * @param aFmaximoAtrasoPosteriorUltimoCredito the aFmaximoAtrasoPosteriorUltimoCredito to set
	 */
	public void setaFmaximoAtrasoPosteriorUltimoCredito(
			int aFmaximoAtrasoPosteriorUltimoCredito) {
		this.aFmaximoAtrasoPosteriorUltimoCredito = aFmaximoAtrasoPosteriorUltimoCredito;
	}
	/**
	 * @return the aFmontoPenultimoCredito
	 */
	public double getaFmontoPenultimoCredito() {
		return aFmontoPenultimoCredito;
	}
	/**
	 * @param aFmontoPenultimoCredito the aFmontoPenultimoCredito to set
	 */
	public void setaFmontoPenultimoCredito(double aFmontoPenultimoCredito) {
		this.aFmontoPenultimoCredito = aFmontoPenultimoCredito;
	}
	/**
	 * @return the aFmaximoAtrasoPenultimoCredito
	 */
	public int getaFmaximoAtrasoPenultimoCredito() {
		return aFmaximoAtrasoPenultimoCredito;
	}
	/**
	 * @param aFmaximoAtrasoPenultimoCredito the aFmaximoAtrasoPenultimoCredito to set
	 */
	public void setaFmaximoAtrasoPenultimoCredito(int aFmaximoAtrasoPenultimoCredito) {
		this.aFmaximoAtrasoPenultimoCredito = aFmaximoAtrasoPenultimoCredito;
	}
	/**
	 * @return the aFmaximoAtrasoPosteriorPenultimoCredito
	 */
	public int getaFmaximoAtrasoPosteriorPenultimoCredito() {
		return aFmaximoAtrasoPosteriorPenultimoCredito;
	}
	/**
	 * @param aFmaximoAtrasoPosteriorPenultimoCredito the aFmaximoAtrasoPosteriorPenultimoCredito to set
	 */
	public void setaFmaximoAtrasoPosteriorPenultimoCredito(
			int aFmaximoAtrasoPosteriorPenultimoCredito) {
		this.aFmaximoAtrasoPosteriorPenultimoCredito = aFmaximoAtrasoPosteriorPenultimoCredito;
	}
	/**
	 * @return the aFmontoAntepenultimoCredito
	 */
	public double getaFmontoAntepenultimoCredito() {
		return aFmontoAntepenultimoCredito;
	}
	/**
	 * @param aFmontoAntepenultimoCredito the aFmontoAntepenultimoCredito to set
	 */
	public void setaFmontoAntepenultimoCredito(double aFmontoAntepenultimoCredito) {
		this.aFmontoAntepenultimoCredito = aFmontoAntepenultimoCredito;
	}
	/**
	 * @return the aFmaximoAtrasoAntepenultimoCredito
	 */
	public int getaFmaximoAtrasoAntepenultimoCredito() {
		return aFmaximoAtrasoAntepenultimoCredito;
	}
	/**
	 * @param aFmaximoAtrasoAntepenultimoCredito the aFmaximoAtrasoAntepenultimoCredito to set
	 */
	public void setaFmaximoAtrasoAntepenultimoCredito(
			int aFmaximoAtrasoAntepenultimoCredito) {
		this.aFmaximoAtrasoAntepenultimoCredito = aFmaximoAtrasoAntepenultimoCredito;
	}
	/**
	 * @return the aFmaximoAtrasoPosteriorAntepenultimoCredito
	 */
	public int getaFmaximoAtrasoPosteriorAntepenultimoCredito() {
		return aFmaximoAtrasoPosteriorAntepenultimoCredito;
	}
	/**
	 * @param aFmaximoAtrasoPosteriorAntepenultimoCredito the aFmaximoAtrasoPosteriorAntepenultimoCredito to set
	 */
	public void setaFmaximoAtrasoPosteriorAntepenultimoCredito(
			int aFmaximoAtrasoPosteriorAntepenultimoCredito) {
		this.aFmaximoAtrasoPosteriorAntepenultimoCredito = aFmaximoAtrasoPosteriorAntepenultimoCredito;
	}
	/**
	 * @return the aSFVigencia
	 */
	public String getaSFVigencia() {
		return aSFVigencia;
	}
	/**
	 * @param aSFVigencia the aSFVigencia to set
	 */
	public void setaSFVigencia(String aSFVigencia) {
		this.aSFVigencia = aSFVigencia;
	}
	/**
	 * @return the aSFSaldoDeudaVigente
	 */
	public double getaSFSaldoDeudaVigente() {
		return aSFSaldoDeudaVigente;
	}
	/**
	 * @param aSFSaldoDeudaVigente the aSFSaldoDeudaVigente to set
	 */
	public void setaSFSaldoDeudaVigente(double aSFSaldoDeudaVigente) {
		this.aSFSaldoDeudaVigente = aSFSaldoDeudaVigente;
	}
	/**
	 * @return the aSFSaldoDeudaVencido
	 */
	public double getaSFSaldoDeudaVencido() {
		return aSFSaldoDeudaVencido;
	}
	/**
	 * @param aSFSaldoDeudaVencido the aSFSaldoDeudaVencido to set
	 */
	public void setaSFSaldoDeudaVencido(double aSFSaldoDeudaVencido) {
		this.aSFSaldoDeudaVencido = aSFSaldoDeudaVencido;
	}
	/**
	 * @return the aSFCuotaSemanal
	 */
	public double getaSFCuotaSemanal() {
		return aSFCuotaSemanal;
	}
	/**
	 * @param aSFCuotaSemanal the aSFCuotaSemanal to set
	 */
	public void setaSFCuotaSemanal(double aSFCuotaSemanal) {
		this.aSFCuotaSemanal = aSFCuotaSemanal;
	}
	/**
	 * @return the aSFMopMaximoAbierto
	 */
	public String getaSFMopMaximoAbierto() {
		return aSFMopMaximoAbierto;
	}
	/**
	 * @param aSFMopMaximoAbierto the aSFMopMaximoAbierto to set
	 */
	public void setaSFMopMaximoAbierto(String aSFMopMaximoAbierto) {
		this.aSFMopMaximoAbierto = aSFMopMaximoAbierto;
	}
	/**
	 * @return the aSFMopMaximoCerrado
	 */
	public String getaSFMopMaximoCerrado() {
		return aSFMopMaximoCerrado;
	}
	/**
	 * @param aSFMopMaximoCerrado the aSFMopMaximoCerrado to set
	 */
	public void setaSFMopMaximoCerrado(String aSFMopMaximoCerrado) {
		this.aSFMopMaximoCerrado = aSFMopMaximoCerrado;
	}
	/**
	 * @return the sECuotaSemanal
	 */
	public double getsECuotaSemanal() {
		return sECuotaSemanal;
	}
	/**
	 * @param sECuotaSemanal the sECuotaSemanal to set
	 */
	public void setsECuotaSemanal(double sECuotaSemanal) {
		this.sECuotaSemanal = sECuotaSemanal;
	}
	/**
	 * @return the sETipoDomicilio
	 */
	public String getsETipoDomicilio() {
		return sETipoDomicilio;
	}
	/**
	 * @param sETipoDomicilio the sETipoDomicilio to set
	 */
	public void setsETipoDomicilio(String sETipoDomicilio) {
		this.sETipoDomicilio = sETipoDomicilio;
	}
	/**
	 * @return the sETiempoResidencia
	 */
	public int getsETiempoResidencia() {
		return sETiempoResidencia;
	}
	/**
	 * @param sETiempoResidencia the sETiempoResidencia to set
	 */
	public void setsETiempoResidencia(int sETiempoResidencia) {
		this.sETiempoResidencia = sETiempoResidencia;
	}
	/**
	 * @return the sEDestinoCredito
	 */
	public String getsEDestinoCredito() {
		return sEDestinoCredito;
	}
	/**
	 * @param sEDestinoCredito the sEDestinoCredito to set
	 */
	public void setsEDestinoCredito(String sEDestinoCredito) {
		this.sEDestinoCredito = sEDestinoCredito;
	}
	/**
	 * @return the sEActividadPrimaria
	 */
	public String getsEActividadPrimaria() {
		return sEActividadPrimaria;
	}
	/**
	 * @param sEActividadPrimaria the sEActividadPrimaria to set
	 */
	public void setsEActividadPrimaria(String sEActividadPrimaria) {
		this.sEActividadPrimaria = sEActividadPrimaria;
	}
	/**
	 * @return the sEAntiguedadNegocio
	 */
	public int getsEAntiguedadNegocio() {
		return sEAntiguedadNegocio;
	}
	/**
	 * @param sEAntiguedadNegocio the sEAntiguedadNegocio to set
	 */
	public void setsEAntiguedadNegocio(int sEAntiguedadNegocio) {
		this.sEAntiguedadNegocio = sEAntiguedadNegocio;
	}
	/**
	 * @return the sEAntiguedadRubro
	 */
	public int getsEAntiguedadRubro() {
		return sEAntiguedadRubro;
	}
	/**
	 * @param sEAntiguedadRubro the sEAntiguedadRubro to set
	 */
	public void setsEAntiguedadRubro(int sEAntiguedadRubro) {
		this.sEAntiguedadRubro = sEAntiguedadRubro;
	}
	/**
	 * @return the sETipoNegocio
	 */
	public String getsETipoNegocio() {
		return sETipoNegocio;
	}
	/**
	 * @param sETipoNegocio the sETipoNegocio to set
	 */
	public void setsETipoNegocio(String sETipoNegocio) {
		this.sETipoNegocio = sETipoNegocio;
	}
	/**
	 * @return the sEPorcentajeGanancia
	 */
	public double getsEPorcentajeGanancia() {
		return sEPorcentajeGanancia;
	}
	/**
	 * @param sEPorcentajeGanancia the sEPorcentajeGanancia to set
	 */
	public void setsEPorcentajeGanancia(double sEPorcentajeGanancia) {
		this.sEPorcentajeGanancia = sEPorcentajeGanancia;
	}
	/**
	 * @return the sEGananciaSemanalNegocio
	 */
	public double getsEGananciaSemanalNegocio() {
		return sEGananciaSemanalNegocio;
	}
	/**
	 * @param sEGananciaSemanalNegocio the sEGananciaSemanalNegocio to set
	 */
	public void setsEGananciaSemanalNegocio(double sEGananciaSemanalNegocio) {
		this.sEGananciaSemanalNegocio = sEGananciaSemanalNegocio;
	}
	/**
	 * @return the sEOtrosIngresos
	 */
	public double getsEOtrosIngresos() {
		return sEOtrosIngresos;
	}
	/**
	 * @param sEOtrosIngresos the sEOtrosIngresos to set
	 */
	public void setsEOtrosIngresos(double sEOtrosIngresos) {
		this.sEOtrosIngresos = sEOtrosIngresos;
	}
	/**
	 * @return the sEGananciaActividadSecundaria
	 */
	public double getsEGananciaActividadSecundaria() {
		return sEGananciaActividadSecundaria;
	}
	/**
	 * @param sEGananciaActividadSecundaria the sEGananciaActividadSecundaria to set
	 */
	public void setsEGananciaActividadSecundaria(
			double sEGananciaActividadSecundaria) {
		this.sEGananciaActividadSecundaria = sEGananciaActividadSecundaria;
	}
	/**
	 * @return the sETotalGastosFamiliares
	 */
	public double getsETotalGastosFamiliares() {
		return sETotalGastosFamiliares;
	}
	/**
	 * @param sETotalGastosFamiliares the sETotalGastosFamiliares to set
	 */
	public void setsETotalGastosFamiliares(double sETotalGastosFamiliares) {
		this.sETotalGastosFamiliares = sETotalGastosFamiliares;
	}
	/**
	 * @return the sEDisponibleCalculado
	 */
	public double getsEDisponibleCalculado() {
		return sEDisponibleCalculado;
	}
	/**
	 * @param sEDisponibleCalculado the sEDisponibleCalculado to set
	 */
	public void setsEDisponibleCalculado(double sEDisponibleCalculado) {
		this.sEDisponibleCalculado = sEDisponibleCalculado;
	}
	/**
	 * @return the sEMontoDeclarado
	 */
	public double getsEMontoDeclarado() {
		return sEMontoDeclarado;
	}
	/**
	 * @param sEMontoDeclarado the sEMontoDeclarado to set
	 */
	public void setsEMontoDeclarado(double sEMontoDeclarado) {
		this.sEMontoDeclarado = sEMontoDeclarado;
	}
	/**
	 * @return the sESuperavitCuotaMonto
	 */
	public double getsESuperavitCuotaMonto() {
		return sESuperavitCuotaMonto;
	}
	/**
	 * @param sESuperavitCuotaMonto the sESuperavitCuotaMonto to set
	 */
	public void setsESuperavitCuotaMonto(double sESuperavitCuotaMonto) {
		this.sESuperavitCuotaMonto = sESuperavitCuotaMonto;
	}
	/**
	 * @return the sESuperavitCuotaDisponible
	 */
	public double getsESuperavitCuotaDisponible() {
		return sESuperavitCuotaDisponible;
	}
	/**
	 * @param sESuperavitCuotaDisponible the sESuperavitCuotaDisponible to set
	 */
	public void setsESuperavitCuotaDisponible(double sESuperavitCuotaDisponible) {
		this.sESuperavitCuotaDisponible = sESuperavitCuotaDisponible;
	}
	/**
	 * @return the sETotalDeclaradoNegocio
	 */
	public double getsETotalDeclaradoNegocio() {
		return sETotalDeclaradoNegocio;
	}
	/**
	 * @param sETotalDeclaradoNegocio the sETotalDeclaradoNegocio to set
	 */
	public void setsETotalDeclaradoNegocio(double sETotalDeclaradoNegocio) {
		this.sETotalDeclaradoNegocio = sETotalDeclaradoNegocio;
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
		this.persona = persona.trim();
	}
	/**
	 * @return the claveClienteUnico
	 */
	public String getClaveClienteUnico() {
		return claveClienteUnico;
	}
	/**
	 * @param claveClienteUnico the claveClienteUnico to set
	 */
	public void setClaveClienteUnico(String claveClienteUnico) {
		this.claveClienteUnico = claveClienteUnico.trim();
	}
	/**
	 * @return the aSFMopAutomotrizHipotecario
	 */
	public String getaSFMopAutomotrizHipotecario() {
		return aSFMopAutomotrizHipotecario;
	}
	/**
	 * @param aSFMopAutomotrizHipotecario the aSFMopAutomotrizHipotecario to set
	 */
	public void setaSFMopAutomotrizHipotecario(String aSFMopAutomotrizHipotecario) {
		this.aSFMopAutomotrizHipotecario = aSFMopAutomotrizHipotecario;
	}
	/**
	 * @return the aSFSaldoVenciodotrizHipotecario
	 */
	public String getaSFSaldoVenciodotrizHipotecario() {
		return aSFSaldoVenciodotrizHipotecario;
	}
	/**
	 * @param aSFSaldoVenciodotrizHipotecario the aSFSaldoVenciodotrizHipotecario to set
	 */
	public void setaSFSaldoVenciodotrizHipotecario(
			String aSFSaldoVenciodotrizHipotecario) {
		this.aSFSaldoVenciodotrizHipotecario = aSFSaldoVenciodotrizHipotecario;
	}
	/**
	 * @return the dIMontoContratoAnterior
	 */
	public double getdIMontoContratoAnterior() {
		return dIMontoContratoAnterior;
	}
	/**
	 * @param dIMontoContratoAnterior the dIMontoContratoAnterior to set
	 */
	public void setdIMontoContratoAnterior(double dIMontoContratoAnterior) {
		this.dIMontoContratoAnterior = dIMontoContratoAnterior;
	}
	/**
	 * @return the asFFolioConsulta
	 */
	public String getAsFFolioConsulta() {
		return asFFolioConsulta;
	}
	/**
	 * @param asFFolioConsulta the asFFolioConsulta to set
	 */
	public void setAsFFolioConsulta(String asFFolioConsulta) {
		this.asFFolioConsulta = asFFolioConsulta;
	}

	/**
	 * @param compare comparacion de listas
	 * @return resultado comparacion
	 */
	public int compareTo(IntegrantePlanillaAprobacionDTO compare) {

		return this.getdIContratoAnterior().compareTo(compare.getdIContratoAnterior());

	}
	/**
	 * @return the idPlanilla
	 */
	public int getIdPlanilla() {
		return idPlanilla;
	}
	/**
	 * @param idPlanilla the idPlanilla to set
	 */
	public void setIdPlanilla(int idPlanilla) {
		this.idPlanilla = idPlanilla;
	}
	/**
	 * @return the clavesObservacion
	 */
	public String getClavesObservacion() {
		return clavesObservacion;
	}
	/**
	 * @param clavesObservacion the clavesObservacion to set
	 */
	public void setClavesObservacion(String clavesObservacion) {
		this.clavesObservacion = clavesObservacion;
	}
}
