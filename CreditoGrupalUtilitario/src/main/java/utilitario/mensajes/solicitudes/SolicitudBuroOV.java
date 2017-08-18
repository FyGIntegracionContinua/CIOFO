package utilitario.mensajes.solicitudes;

import java.util.ArrayList;
import java.util.List;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class SolicitudBuroOV.
 *
 * @author rguadarramac
 * @version 1.0
 */
public class SolicitudBuroOV extends ObjetoValor {

	/** Se genero serial unico. */
	private static final long serialVersionUID = -810147433747092963L;

	//Parte Encabezado
	/** The solicitud. */
	private String solicitud;
	/** The sucursal. */
	private String sucursal;
	/** The nombreSucursal. */
	private String nombreSucursal;
	/** The ciclo orcl. */
	private String cicloOrcl;
	/** The fecha solicitud. */
	private String fechaSolicitud;
	/** The fecha desembolso. */
	private String fechaDesembolso;
	/** The estatus. */
	private String estatus;
	/** The descripcion estatus. */
	private String descripcionEstatus;
	/** The ciclo. */
	private String ciclo;
	/** The nombre. */
	private String nombre;
	/** The valorTipificacion. */
	private String valorTipificacion;
	/** The tipificacionSucursal. */
	private String tipificacionSucursal;
	/** The promedioEdad. */
	private double promedioEdad;
	/** The totalMOP01. */
    private int totalMOP01;
    /** The totalMOP02. */
    private int totalMOP02;
    /** The totalMOP03. */
    private int totalMOP03;
    /** The totalMOP04. */
    private int totalMOP04;
    /** The totalMOP05. */
    private int totalMOP05;
    /** The totalMOP06. */
    private int totalMOP06;
    /** The totalMOP07. */
    private int totalMOP07;
    /** The totalMOP96. */
    private int totalMOP96;
    /** The totalMOP97. */
    private int totalMOP97;
    /** The totalMOP99. */
    private int totalMOP99;
    /** The totalMOPUR. */
    private int totalMOPUR;
    /** The totalCuentas. */
    private int totalCuentas;
    /** The totalDesde03. */
    private int totalDesde03;
    /** The totalDesde04. */
    private int totalDesde04;
    /** suma de del totalCuentas + totalDesde03 o  totalDesde04 */
    private int totalCuentasMalasAceptables;
    /** The factorDesde03. */
    private double factorDesde03;
    /** The factorDesde04. */
    private double factorDesde04;
    /** The aprobacion. */
    private String aprobacion;
    /** The leyendaNivelMedio. */
    private String leyendaNivelMedio;
    /** The leyendaNivelAlto. */
    private String leyendaNivelAlto;
    /** The motivoCancelacion. */
	private String motivoCancelacion;
	/** The integrantesOrigenCampana. */
    private String integrantesOrigenCampana;
    /** The clientesNuevoGrupo. */
    private String clientesNuevoGrupo;
    /** The clientesCicloAnterior. */
    private String clientesCicloAnterior;
    /** The tipoSucursal. */
    private String tipoSucursal;
    /** The motivoJustificacion. */
    private String motivoJustificacion;
    /** The Campana. */
    private String campana;
    /** The porcentajeGarantia. */
    private String porcentajeGarantia;
    /** The garantiaJustificacion. */
    private String garantiaJustificacion;
    /** The numeroClienteGrupo. */
    private String numeroClienteGrupo;
    /** The contratoAnteriorGrupo .*/
    private String contratoAnteriorGrupo;

    /** hipotecarios mayores a mop 01*/
	private int totalHipotecarioMop01;
	/**automotriz mayores al Mop02*/
	private int totalAutomotrizMop02;

	/** The integrantes a descartar y a eleminar. */
	private List<SolicitudBuroClienteOV> integrantes;
	/** integrantes donde se pone el de menor edad*/
	private List<SolicitudBuroClienteOV> integrantesMenorEdad;
	/** integrantes donde se ponen los descartes obligatorios*/
	private List<SolicitudBuroClienteOV> integrantesDescarteObligatorio;
	/** integrantes donde se pone los descartes sugeridos*/
	private List<SolicitudBuroClienteOV> integrantesDescarteSugerido;

	/**integrantes nuevos*/
	private int integrantesNuevos;
	/** dias mora*/
	private int diasMora;
	/**integrantes originales*/
	private int integrantesOriginales;
	/**lista de nuevos*/
	private boolean listaNuevos;
	/**
	 * Instancia una nueva solicitud buro ov.
	 */
	public SolicitudBuroOV() {
		aprobacion = " ";
		leyendaNivelMedio = " ";
		leyendaNivelAlto = " ";
		integrantesMenorEdad = new ArrayList<SolicitudBuroClienteOV>();
		integrantesDescarteObligatorio = new ArrayList<SolicitudBuroClienteOV>();
		integrantesDescarteSugerido = new ArrayList<SolicitudBuroClienteOV>();
	}

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
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene ciclo orcl.
	 *
	 * @return the cicloOrcl
	 */
	public String getCicloOrcl() {
		return cicloOrcl;
	}

	/**
	 * Establece ciclo orcl.
	 *
	 * @param cicloOrcl the cicloOrcl to set
	 */
	public void setCicloOrcl(String cicloOrcl) {
		this.cicloOrcl = cicloOrcl;
	}

	/**
	 * Obtiene fecha solicitud.
	 *
	 * @return the fechaSolicitud
	 */
	public String getFechaSolicitud() {
		return fechaSolicitud;
	}

	/**
	 * Establece fecha solicitud.
	 *
	 * @param fechaSolicitud the fechaSolicitud to set
	 */
	public void setFechaSolicitud(String fechaSolicitud) {
		this.fechaSolicitud = fechaSolicitud;
	}

	/**
	 * Obtiene fecha desembolso.
	 *
	 * @return the fechaDesembolso
	 */
	public String getFechaDesembolso() {
		return fechaDesembolso;
	}

	/**
	 * Establece fecha desembolso.
	 *
	 * @param fechaDesembolso the fechaDesembolso to set
	 */
	public void setFechaDesembolso(String fechaDesembolso) {
		this.fechaDesembolso = fechaDesembolso;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return the estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Establece estatus.
	 *
	 * @param estatus the estatus to set
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene descripcion estatus.
	 *
	 * @return the descripcionEstatus
	 */
	public String getDescripcionEstatus() {
		return descripcionEstatus;
	}

	/**
	 * Establece descripcion estatus.
	 *
	 * @param descripcionEstatus the descripcionEstatus to set
	 */
	public void setDescripcionEstatus(String descripcionEstatus) {
		this.descripcionEstatus = descripcionEstatus;
	}

	/**
	 * Obtiene integrantes.
	 *
	 * @return the integrantes
	 */
	public List<SolicitudBuroClienteOV> getIntegrantes() {
		return integrantes;
	}

	/**
	 * Establece integrantes.
	 *
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(List<SolicitudBuroClienteOV> integrantes) {
		this.integrantes = integrantes;
	}

	/**
	 * Obtiene ciclo.
	 *
	 * @return the ciclo
	 */
	public String getCiclo() {
		return ciclo;
	}

	/**
	 * Establece ciclo.
	 *
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}

	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}

	/**
	 * @return the valorTipificacion
	 */
	public String getValorTipificacion() {
		return valorTipificacion;
	}

	/**
	 * @param valorTipificacion the valorTipificacion to set
	 */
	public void setValorTipificacion(String valorTipificacion) {
		this.valorTipificacion = valorTipificacion;
	}

	/**
	 * @return the tipificacionSucursal
	 */
	public String getTipificacionSucursal() {
		return tipificacionSucursal;
	}

	/**
	 * @param tipificacionSucursal the tipificacionSucursal to set
	 */
	public void setTipificacionSucursal(String tipificacionSucursal) {
		this.tipificacionSucursal = tipificacionSucursal;
	}

	/**
	 * @return the promedioEdad
	 */
	public double getPromedioEdad() {
		return promedioEdad;
	}

	/**
	 * @param promedioEdad the promedioEdad to set
	 */
	public void setPromedioEdad(double promedioEdad) {
		this.promedioEdad = promedioEdad;
	}

	/**
	 * @return the totalMOP01
	 */
	public int getTotalMOP01() {
		return totalMOP01;
	}

	/**
	 * @param totalMOP01 the totalMOP01 to set
	 */
	public void setTotalMOP01(int totalMOP01) {
		this.totalMOP01 = totalMOP01;
	}

	/**
	 * @return the totalMOP02
	 */
	public int getTotalMOP02() {
		return totalMOP02;
	}

	/**
	 * @param totalMOP02 the totalMOP02 to set
	 */
	public void setTotalMOP02(int totalMOP02) {
		this.totalMOP02 = totalMOP02;
	}

	/**
	 * @return the totalMOP03
	 */
	public int getTotalMOP03() {
		return totalMOP03;
	}

	/**
	 * @param totalMOP03 the totalMOP03 to set
	 */
	public void setTotalMOP03(int totalMOP03) {
		this.totalMOP03 = totalMOP03;
	}

	/**
	 * @return the totalMOP04
	 */
	public int getTotalMOP04() {
		return totalMOP04;
	}

	/**
	 * @param totalMOP04 the totalMOP04 to set
	 */
	public void setTotalMOP04(int totalMOP04) {
		this.totalMOP04 = totalMOP04;
	}

	/**
	 * @return the totalMOP05
	 */
	public int getTotalMOP05() {
		return totalMOP05;
	}

	/**
	 * @param totalMOP05 the totalMOP05 to set
	 */
	public void setTotalMOP05(int totalMOP05) {
		this.totalMOP05 = totalMOP05;
	}

	/**
	 * @return the totalMOP06
	 */
	public int getTotalMOP06() {
		return totalMOP06;
	}

	/**
	 * @param totalMOP06 the totalMOP06 to set
	 */
	public void setTotalMOP06(int totalMOP06) {
		this.totalMOP06 = totalMOP06;
	}

	/**
	 * @return the totalMOP07
	 */
	public int getTotalMOP07() {
		return totalMOP07;
	}

	/**
	 * @param totalMOP07 the totalMOP07 to set
	 */
	public void setTotalMOP07(int totalMOP07) {
		this.totalMOP07 = totalMOP07;
	}

	/**
	 * @return the totalMOP96
	 */
	public int getTotalMOP96() {
		return totalMOP96;
	}

	/**
	 * @param totalMOP96 the totalMOP96 to set
	 */
	public void setTotalMOP96(int totalMOP96) {
		this.totalMOP96 = totalMOP96;
	}

	/**
	 * @return the totalMOP97
	 */
	public int getTotalMOP97() {
		return totalMOP97;
	}

	/**
	 * @param totalMOP97 the totalMOP97 to set
	 */
	public void setTotalMOP97(int totalMOP97) {
		this.totalMOP97 = totalMOP97;
	}

	/**
	 * @return the totalMOP99
	 */
	public int getTotalMOP99() {
		return totalMOP99;
	}

	/**
	 * @param totalMOP99 the totalMOP99 to set
	 */
	public void setTotalMOP99(int totalMOP99) {
		this.totalMOP99 = totalMOP99;
	}

	/**
	 * @return the totalMOPUR
	 */
	public int getTotalMOPUR() {
		return totalMOPUR;
	}

	/**
	 * @param totalMOPUR the totalMOPUR to set
	 */
	public void setTotalMOPUR(int totalMOPUR) {
		this.totalMOPUR = totalMOPUR;
	}

	/**
	 * @return the totalCuentas
	 */
	public int getTotalCuentas() {
		return totalCuentas;
	}

	/**
	 * @param totalCuentas the totalCuentas to set
	 */
	public void setTotalCuentas(int totalCuentas) {
		this.totalCuentas = totalCuentas;
	}

	/**
	 * @return the totalDesde03
	 */
	public int getTotalDesde03() {
		return totalDesde03;
	}

	/**
	 * @param totalDesde03 the totalDesde03 to set
	 */
	public void setTotalDesde03(int totalDesde03) {
		this.totalDesde03 = totalDesde03;
	}

	/**
	 * @return the totalDesde04
	 */
	public int getTotalDesde04() {
		return totalDesde04;
	}

	/**
	 * @param totalDesde04 the totalDesde04 to set
	 */
	public void setTotalDesde04(int totalDesde04) {
		this.totalDesde04 = totalDesde04;
	}

	/**
	 * @return the factorDesde03
	 */
	public double getFactorDesde03() {
		return factorDesde03;
	}

	/**
	 * @param factorDesde03 the factorDesde03 to set
	 */
	public void setFactorDesde03(double factorDesde03) {
		this.factorDesde03 = factorDesde03;
	}

	/**
	 * @return the factorDesde04
	 */
	public double getFactorDesde04() {
		return factorDesde04;
	}

	/**
	 * @param factorDesde04 the factorDesde04 to set
	 */
	public void setFactorDesde04(double factorDesde04) {
		this.factorDesde04 = factorDesde04;
	}

	/**
	 * @return the aprobacion
	 */
	public String getAprobacion() {
		return aprobacion;
	}

	/**
	 * @param aprobacion the aprobacion to set
	 */
	public void setAprobacion(String aprobacion) {
		this.aprobacion = aprobacion;
	}

	/**
	 * @return the leyendaNivelMedio
	 */
	public String getLeyendaNivelMedio() {
		return leyendaNivelMedio;
	}

	/**
	 * @param leyendaNivelMedio the leyendaNivelMedio to set
	 */
	public void setLeyendaNivelMedio(String leyendaNivelMedio) {
		this.leyendaNivelMedio = leyendaNivelMedio;
	}

	/**
	 * @return the leyendaNivelAlto
	 */
	public String getLeyendaNivelAlto() {
		return leyendaNivelAlto;
	}

	/**
	 * @param leyendaNivelAlto the leyendaNivelAlto to set
	 */
	public void setLeyendaNivelAlto(String leyendaNivelAlto) {
		this.leyendaNivelAlto = leyendaNivelAlto;
	}

	/**
	 * @return the motivoCancelacion
	 */
	public String getMotivoCancelacion() {
		return motivoCancelacion;
	}

	/**
	 * @param motivoCancelacion the motivoCancelacion to set
	 */
	public void setMotivoCancelacion(String motivoCancelacion) {
		this.motivoCancelacion = motivoCancelacion;
	}

	/**
	 * @return the integrantesOrigenCampana
	 */
	public String getIntegrantesOrigenCampana() {
		return integrantesOrigenCampana;
	}

	/**
	 * @param integrantesOrigenCampana the integrantesOrigenCampana to set
	 */
	public void setIntegrantesOrigenCampana(String integrantesOrigenCampana) {
		this.integrantesOrigenCampana = integrantesOrigenCampana;
	}

	/**
	 * @return the clientesNuevoGrupo
	 */
	public String getClientesNuevoGrupo() {
		return clientesNuevoGrupo;
	}

	/**
	 * @param clientesNuevoGrupo the clientesNuevoGrupo to set
	 */
	public void setClientesNuevoGrupo(String clientesNuevoGrupo) {
		this.clientesNuevoGrupo = clientesNuevoGrupo;
	}

	/**
	 * @return the clientesCicloAnterior
	 */
	public String getClientesCicloAnterior() {
		return clientesCicloAnterior;
	}

	/**
	 * @param clientesCicloAnterior the clientesCicloAnterior to set
	 */
	public void setClientesCicloAnterior(String clientesCicloAnterior) {
		this.clientesCicloAnterior = clientesCicloAnterior;
	}

	/**
	 * @return the tipoSucursal
	 */
	public String getTipoSucursal() {
		return tipoSucursal;
	}

	/**
	 * @param tipoSucursal the tipoSucursal to set
	 */
	public void setTipoSucursal(String tipoSucursal) {
		this.tipoSucursal = tipoSucursal;
	}

	/**
	 * @return the motivoJustificacion
	 */
	public String getMotivoJustificacion() {
		return motivoJustificacion;
	}

	/**
	 * @param motivoJustificacion the motivoJustificacion to set
	 */
	public void setMotivoJustificacion(String motivoJustificacion) {
		this.motivoJustificacion = motivoJustificacion;
	}

	/**
	 * @return the totalHipotecarioMop01
	 */
	public int getTotalHipotecarioMop01() {
		return totalHipotecarioMop01;
	}

	/**
	 * @param totalHipotecarioMop01 the totalHipotecarioMop01 to set
	 */
	public void setTotalHipotecarioMop01(int totalHipotecarioMop01) {
		this.totalHipotecarioMop01 = totalHipotecarioMop01;
	}

	/**
	 * @return the totalAutomotrizMop02
	 */
	public int getTotalAutomotrizMop02() {
		return totalAutomotrizMop02;
	}

	/**
	 * @param totalAutomotrizMop02 the totalAutomotrizMop02 to set
	 */
	public void setTotalAutomotrizMop02(int totalAutomotrizMop02) {
		this.totalAutomotrizMop02 = totalAutomotrizMop02;
	}

	/**
	 * @return the totalCuentasMalasAceptables
	 */
	public int getTotalCuentasMalasAceptables() {
		return totalCuentasMalasAceptables;
	}

	/**
	 * @param totalCuentasMalasAceptables the totalCuentasMalasAceptables to set
	 */
	public void setTotalCuentasMalasAceptables(int totalCuentasMalasAceptables) {
		this.totalCuentasMalasAceptables = totalCuentasMalasAceptables;
	}

	/**
	 * @return the integrantesMenorEdad
	 */
	public List<SolicitudBuroClienteOV> getIntegrantesMenorEdad() {
		return integrantesMenorEdad;
	}

	/**
	 * @param integrantesMenorEdad the integrantesMenorEdad to set
	 */
	public void setIntegrantesMenorEdad(List<SolicitudBuroClienteOV> integrantesMenorEdad) {
		this.integrantesMenorEdad = integrantesMenorEdad;
	}

	/**
	 * @return the integrantesDescarteObligatorio
	 */
	public List<SolicitudBuroClienteOV> getIntegrantesDescarteObligatorio() {
		return integrantesDescarteObligatorio;
	}

	/**
	 * @param integrantesDescarteObligatorio the integrantesDescarteObligatorio to set
	 */
	public void setIntegrantesDescarteObligatorio(List<SolicitudBuroClienteOV> integrantesDescarteObligatorio) {
		this.integrantesDescarteObligatorio = integrantesDescarteObligatorio;
	}

	/**
	 * @return the integrantesDescarteSugerido
	 */
	public List<SolicitudBuroClienteOV> getIntegrantesDescarteSugerido() {
		return integrantesDescarteSugerido;
	}

	/**
	 * @param integrantesDescarteSugerido the integrantesDescarteSugerido to set
	 */
	public void setIntegrantesDescarteSugerido(List<SolicitudBuroClienteOV> integrantesDescarteSugerido) {
		this.integrantesDescarteSugerido = integrantesDescarteSugerido;
	}

	/**
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}

	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}
	/**
	 * @return the porcentajeGarantia
	 */
	public String getPorcentajeGarantia() {
		return porcentajeGarantia;
	}

	/**
	 * @param porcentajeGarantia the porcentajeGarantia to set
	 */
	public void setPorcentajeGarantia(String porcentajeGarantia) {
		this.porcentajeGarantia = porcentajeGarantia;
	}

	/**
	 * @return the garantiaJustificacion
	 */
	public String getGarantiaJustificacion() {
		return garantiaJustificacion;
	}

	/**
	 * @param garantiaJustificacion the garantiaJustificacion to set
	 */
	public void setGarantiaJustificacion(String garantiaJustificacion) {
		this.garantiaJustificacion = garantiaJustificacion;
	}

	/**
	 * @return the numeroClienteGrupo
	 */
	public String getNumeroClienteGrupo() {
		return numeroClienteGrupo;
	}

	/**
	 * @param numeroClienteGrupo the numeroClienteGrupo to set
	 */
	public void setNumeroClienteGrupo(String numeroClienteGrupo) {
		this.numeroClienteGrupo = numeroClienteGrupo;
	}
	/**
	 * @return the integrantesNuevos
	 */
	public int getIntegrantesNuevos() {
		return integrantesNuevos;
	}

	/**
	 * @param integrantesNuevos the integrantesNuevos to set
	 */
	public void setIntegrantesNuevos(int integrantesNuevos) {
		this.integrantesNuevos = integrantesNuevos;
	}

	/**
	 * @return the diasMora
	 */
	public int getDiasMora() {
		return diasMora;
	}

	/**
	 * @param diasMora the diasMora to set
	 */
	public void setDiasMora(int diasMora) {
		this.diasMora = diasMora;
	}

	/**
	 * @return the integrantesOriginales
	 */
	public int getIntegrantesOriginales() {
		return integrantesOriginales;
	}

	/**
	 * @param integrantesOriginales the integrantesOriginales to set
	 */
	public void setIntegrantesOriginales(int integrantesOriginales) {
		this.integrantesOriginales = integrantesOriginales;
	}

	/**
	 * @return the listaNuevos
	 */
	public boolean isListaNuevos() {
		return listaNuevos;
	}

	/**
	 * @param listaNuevos the listaNuevos to set
	 */
	public void setListaNuevos(boolean listaNuevos) {
		this.listaNuevos = listaNuevos;
	}
	/**
	 * @return the contratoAnteriorGrupo
	 */
	public String getContratoAnteriorGrupo() {
		return contratoAnteriorGrupo;
	}

	/**
	 * @param contratoAnteriorGrupo the contratoAnteriorGrupo to set
	 */
	public void setContratoAnteriorGrupo(String contratoAnteriorGrupo) {
		this.contratoAnteriorGrupo = contratoAnteriorGrupo;
	}
}
