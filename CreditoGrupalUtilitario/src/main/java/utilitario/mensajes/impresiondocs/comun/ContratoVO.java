package utilitario.mensajes.impresiondocs.comun;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ContratoVO.
 */
public class ContratoVO extends ObjetoValor {

	/**
	 * ContratoVO.
	 */
	public ContratoVO() {

	}

	/** serialVersionUID long. */
	private static final long serialVersionUID = 6704008540575343662L;

	/**  Id del grupo. */
	private String grupo;

	/** The contrato ld. */
	private String contratoLD;

	/** The contrato. */
	private String contrato;

	/**  Nombre del grupo. */
	private String nombregpo;

	/**  Monto total del cr�dito? SI. */
	private String importe;

	/**  Monto total del cr�dito en letra. */
	private String impteletras;

	/**  tasa anual? SI. */
	private String tasa;

	/**  N�mero de pagos. */
	private String plazo;

	/**  Fecha Fin Cr�dito. */
	private String fechavto;

	/**  Monto de pago en cada periodo. */
	private String imptepago;

	/**  Monto de pago en cada periodo en letra. */
	private String imptepagoletra;

	/**  Importe redondeado. */
	private String imptepagored;

	/**  Importe redondeado letra. */
	private String imptepagoletrared;

	/**  Nombre del presidente del grupo. */
	private String presidente;

	/**  Nombre del tesorero del grupo. */
	private String tesorero;

	/**  Nombre del secretario del grupo. */
	private String secretario;

	/**  N�mero de ciclo del grupo. */
	private String ciclogpo;

	/**  ejecutivo? Nombre del asesor. */
	private String ejecutivo;

	/**  Nombre del gerente de la sucursal? Si. */
	private String gtesucursal;

	/** Direcci�n dle la sucursal: calle, colonia, cp, ciudad, entidad ->
	 *  Se obtiene de catalogo DAO T24 -> Extraer informacion. */
	private String dirsucursal;

	/**  Ciudad, entidad de la sucursal. */
	private String cdadfirma;

	/**  Fecha actual -> Fecha desembolso Value Date. */
	private String fechafirma;

	/**  Nombres de los integrantes del grupo? -> Todos los integrantes. */
	private String nombres;

	/**  Tipo de contrato. */
	private String tipocont;

	/** sucursal. */
	private String sucursal;

	/** diasreales String. */
	private String diasreales;

	/** montoGarantia String. */
	private String montoGarantia;

	/** montoGarantia String. */
	private double saldoGarantia;
	
	/** The garantia a depositar. */
	private Double garantiaADepositar;
	
	/** The garantia traspasada. */
	private Double garantiaTraspasada;

	/**
	 * Obtiene diasreales.
	 *
	 * @return the diasreales
	 */
	public String getDiasreales() {
		return diasreales;
	}

	/**
	 * Establece diasreales.
	 *
	 * @param diasreales the diasreales to set
	 */
	public void setDiasreales(String diasreales) {
		this.diasreales = diasreales;
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

	/** Nombre del apoderado legal? -> Se obtiene del catalogo DAO T24 -> Extraer informacion. */
	private String NombreApoderado;
	/**
	 * N�mero de escritura? .. De donde lo obtienen? -> Se obtiene del catalogo
	 * DAO T24 -> Extraer informacion
	 */
	private String NoEscritura;

	/** Fecha de la escritura?? -> Se obtiene del catalogo DAO T24 -> Extraer informacion. */
	private String FechaEscritura;

	/**  Supervisor?? -> Era una posicion de la mesa directiva. */
	private String Supervisor;

	/**  Frecuencia de pago. */
	private String Periodo;

	/**  Frecuencia de pago ? Dif con el anterior -> Esta es un sustantivo. */
	private String Periodicidad;

	/** Nombres de los integrantes del grupo? En caso de que no alcance la longitud de nombres se utiliza este campo. */
	private String nombres2;

	/** ?? En caso de que no alcance la longitud de nombres2 se utiliza este campo. */
	private String nombres3;

	/** ?? En caso de que no alcance la longitud de nombres3se utiliza este campo. */
	private String nombres4;
	/**
	 * CAT?... -> Es la cadena necesaria para calcularlo, es -MONTO
	 * APROBADO,PARCIALIDAD1,PARCIALIDAD2,PARCIALIDAD N
	 */
	private String cat;

	/**  ?? Codigo Sucursal T24 - Existe un catalogo. */
	private String branchcode;

	/**  Fecha en que inicia el contrato? SI. */
	private String finicio;

	/**  Fecha de termino del contrato? SI. */
	private String ffin;

	/** Nombres de los avales del grupo?. */
	private String nombresAvales;
	/** Indica si es renovaci�n?... */
	private String renovaciones;

	/** descContrato String. */
	private String descContrato;

	/** descSucursal String. */
	private String descSucursal;


	/**
	 * Obtiene desc sucursal.
	 *
	 * @return the descSucursal
	 */
	public String getDescSucursal() {
		return descSucursal;
	}

	/**
	 * Establece desc sucursal.
	 *
	 * @param descSucursal the descSucursal to set
	 */
	public void setDescSucursal(String descSucursal) {
		this.descSucursal = descSucursal;
	}

	/**
	 * Obtiene desc contrato.
	 *
	 * @return the descContrato
	 */
	public String getDescContrato() {
		return descContrato;
	}

	/**
	 * Establece desc contrato.
	 *
	 * @param descContrato the descContrato to set
	 */
	public void setDescContrato(String descContrato) {
		this.descContrato = descContrato;
	}

	/**
	 * Obtiene nombres avales.
	 *
	 * @return .
	 */
	public String getNombresAvales() {
		return nombresAvales;
	}

	/**
	 * Establece nombres avales.
	 *
	 * @param nombresAvales the nombresAvales to set
	 */
	public void setNombresAvales(String nombresAvales) {
		this.nombresAvales = nombresAvales;
	}

	/**
	 * Obtiene renovaciones.
	 *
	 * @return the renovaciones
	 */
	public String getRenovaciones() {
		return renovaciones;
	}

	/**
	 * Establece renovaciones.
	 *
	 * @param renovaciones the renovaciones to set
	 */
	public void setRenovaciones(String renovaciones) {
		this.renovaciones = renovaciones;
	}


	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo            the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene contrato ld.
	 *
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}

	/**
	 * Establece contrato ld.
	 *
	 * @param contratoLD            the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}

	/**
	 * Obtiene nombregpo.
	 *
	 * @return the nombregpo
	 */
	public String getNombregpo() {
		return nombregpo;
	}

	/**
	 * Establece nombregpo.
	 *
	 * @param nombregpo            the nombregpo to set
	 */
	public void setNombregpo(String nombregpo) {
		this.nombregpo = nombregpo;
	}

	/**
	 * Obtiene importe.
	 *
	 * @return the importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * Establece importe.
	 *
	 * @param importe            the importe to set
	 */
	public void setImporte(String importe) {

		this.importe = importe == null ? "0.0" : importe;
	}

	/**
	 * Obtiene impteletras.
	 *
	 * @return the impteletras
	 */
	public String getImpteletras() {
		return impteletras;
	}

	/**
	 * Establece impteletras.
	 *
	 * @param impteletras            the impteletras to set
	 */
	public void setImpteletras(String impteletras) {
		this.impteletras = impteletras;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa            the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public String getPlazo() {
		return plazo;
	}

	/**
	 * Establece plazo.
	 *
	 * @param plazo            the plazo to set
	 */
	public void setPlazo(String plazo) {
		this.plazo = plazo;
	}

	/**
	 * Obtiene fechavto.
	 *
	 * @return the fechavto
	 */
	public String getFechavto() {
		return fechavto;
	}

	/**
	 * Establece fechavto.
	 *
	 * @param fechavto            the fechavto to set
	 */
	public void setFechavto(String fechavto) {
		this.fechavto = fechavto;
	}

	/**
	 * Obtiene imptepago.
	 *
	 * @return the imptepago
	 */
	public String getImptepago() {
		return imptepago;
	}

	/**
	 * Establece imptepago.
	 *
	 * @param imptepago            the imptepago to set
	 */
	public void setImptepago(String imptepago) {
		this.imptepago = imptepago == null ? "0.0" : imptepago;

	}

	/**
	 * Obtiene imptepagoletra.
	 *
	 * @return the imptepagoletra
	 */
	public String getImptepagoletra() {
		return imptepagoletra;
	}

	/**
	 * Establece imptepagoletra.
	 *
	 * @param imptepagoletra            the imptepagoletra to set
	 */
	public void setImptepagoletra(String imptepagoletra) {
		this.imptepagoletra = imptepagoletra;
	}

	/**
	 * Obtiene imptepagored.
	 *
	 * @return the imptepagored
	 */
	public String getImptepagored() {
		return imptepagored;
	}

	/**
	 * Establece imptepagored.
	 *
	 * @param imptepagored            the imptepagored to set
	 */
	public void setImptepagored(String imptepagored) {
		this.imptepagored = imptepagored;
	}

	/**
	 * Obtiene imptepagoletrared.
	 *
	 * @return the imptepagoletrared
	 */
	public String getImptepagoletrared() {
		return imptepagoletrared;
	}

	/**
	 * Establece imptepagoletrared.
	 *
	 * @param imptepagoletrared            the imptepagoletrared to set
	 */
	public void setImptepagoletrared(String imptepagoletrared) {
		this.imptepagoletrared = imptepagoletrared;
	}

	/**
	 * Obtiene presidente.
	 *
	 * @return the presidente
	 */
	public String getPresidente() {
		return presidente;
	}

	/**
	 * Establece presidente.
	 *
	 * @param presidente            the presidente to set
	 */
	public void setPresidente(String presidente) {
		this.presidente = presidente;
	}

	/**
	 * Obtiene tesorero.
	 *
	 * @return the tesorero
	 */
	public String getTesorero() {
		return tesorero;
	}

	/**
	 * Establece tesorero.
	 *
	 * @param tesorero            the tesorero to set
	 */
	public void setTesorero(String tesorero) {
		this.tesorero = tesorero;
	}

	/**
	 * Obtiene secretario.
	 *
	 * @return the secretario
	 */
	public String getSecretario() {
		return secretario;
	}

	/**
	 * Establece secretario.
	 *
	 * @param secretario            the secretario to set
	 */
	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	/**
	 * Obtiene ciclogpo.
	 *
	 * @return the ciclogpo
	 */
	public String getCiclogpo() {
		return ciclogpo;
	}

	/**
	 * Establece ciclogpo.
	 *
	 * @param ciclogpo            the ciclogpo to set
	 */
	public void setCiclogpo(String ciclogpo) {
		this.ciclogpo = ciclogpo;
	}

	/**
	 * Obtiene ejecutivo.
	 *
	 * @return the ejecutivo
	 */
	public String getEjecutivo() {
		return ejecutivo;
	}

	/**
	 * Establece ejecutivo.
	 *
	 * @param ejecutivo            the ejecutivo to set
	 */
	public void setEjecutivo(String ejecutivo) {
		this.ejecutivo = ejecutivo;
	}

	/**
	 * Obtiene gtesucursal.
	 *
	 * @return the gtesucursal
	 */
	public String getGtesucursal() {
		return gtesucursal;
	}

	/**
	 * Establece gtesucursal.
	 *
	 * @param gtesucursal            the gtesucursal to set
	 */
	public void setGtesucursal(String gtesucursal) {
		this.gtesucursal = gtesucursal;
	}

	/**
	 * Obtiene dirsucursal.
	 *
	 * @return the dirsucursal
	 */
	public String getDirsucursal() {
		return dirsucursal;
	}

	/**
	 * Establece dirsucursal.
	 *
	 * @param dirsucursal            the dirsucursal to set
	 */
	public void setDirsucursal(String dirsucursal) {
		this.dirsucursal = dirsucursal;
	}

	/**
	 * Obtiene cdadfirma.
	 *
	 * @return the cdadfirma
	 */
	public String getCdadfirma() {
		return cdadfirma;
	}

	/**
	 * Establece cdadfirma.
	 *
	 * @param cdadfirma            the cdadfirma to set
	 */
	public void setCdadfirma(String cdadfirma) {
		this.cdadfirma = cdadfirma;
	}

	/**
	 * Obtiene fechafirma.
	 *
	 * @return the fechafirma
	 */
	public String getFechafirma() {
		return fechafirma;
	}

	/**
	 * Establece fechafirma.
	 *
	 * @param fechafirma            the fechafirma to set
	 */
	public void setFechafirma(String fechafirma) {
		this.fechafirma = fechafirma;
	}

	/**
	 * Obtiene nombres.
	 *
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * Establece nombres.
	 *
	 * @param nombres            the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * Obtiene tipocont.
	 *
	 * @return the tipocont
	 */
	public String getTipocont() {
		return tipocont;
	}

	/**
	 * Establece tipocont.
	 *
	 * @param tipocont            the tipocont to set
	 */
	public void setTipocont(String tipocont) {
		this.tipocont = tipocont;
	}

	/**
	 * Obtiene nombre apoderado.
	 *
	 * @return the nombreApoderado
	 */
	public String getNombreApoderado() {
		return NombreApoderado;
	}

	/**
	 * Establece nombre apoderado.
	 *
	 * @param nombreApoderado            the nombreApoderado to set
	 */
	public void setNombreApoderado(String nombreApoderado) {
		NombreApoderado = nombreApoderado;
	}

	/**
	 * Obtiene no escritura.
	 *
	 * @return the noEscritura
	 */
	public String getNoEscritura() {
		return NoEscritura;
	}

	/**
	 * Establece no escritura.
	 *
	 * @param noEscritura            the noEscritura to set
	 */
	public void setNoEscritura(String noEscritura) {
		NoEscritura = noEscritura;
	}

	/**
	 * Obtiene fecha escritura.
	 *
	 * @return the fechaEscritura
	 */
	public String getFechaEscritura() {
		return FechaEscritura;
	}

	/**
	 * Establece fecha escritura.
	 *
	 * @param fechaEscritura            the fechaEscritura to set
	 */
	public void setFechaEscritura(String fechaEscritura) {
		FechaEscritura = fechaEscritura;
	}

	/**
	 * Obtiene supervisor.
	 *
	 * @return the supervisor
	 */
	public String getSupervisor() {
		return Supervisor;
	}

	/**
	 * Establece supervisor.
	 *
	 * @param supervisor            the supervisor to set
	 */
	public void setSupervisor(String supervisor) {
		Supervisor = supervisor;
	}

	/**
	 * Obtiene periodo.
	 *
	 * @return the periodo
	 */
	public String getPeriodo() {
		return Periodo;
	}

	/**
	 * Establece periodo.
	 *
	 * @param periodo            the periodo to set
	 */
	public void setPeriodo(String periodo) {
		Periodo = periodo;
	}

	/**
	 * Obtiene periodicidad.
	 *
	 * @return the periodicidad
	 */
	public String getPeriodicidad() {
		return Periodicidad;
	}

	/**
	 * Establece periodicidad.
	 *
	 * @param periodicidad            the periodicidad to set
	 */
	public void setPeriodicidad(String periodicidad) {
		Periodicidad = periodicidad;
	}

	/**
	 * Obtiene nombres2.
	 *
	 * @return the nombres2
	 */
	public String getNombres2() {
		return nombres2;
	}

	/**
	 * Establece nombres2.
	 *
	 * @param nombres2            the nombres2 to set
	 */
	public void setNombres2(String nombres2) {
		this.nombres2 = nombres2;
	}

	/**
	 * Obtiene nombres3.
	 *
	 * @return the nombres3
	 */
	public String getNombres3() {
		return nombres3;
	}

	/**
	 * Establece nombres3.
	 *
	 * @param nombres3            the nombres3 to set
	 */
	public void setNombres3(String nombres3) {
		this.nombres3 = nombres3;
	}

	/**
	 * Obtiene nombres4.
	 *
	 * @return the nombres4
	 */
	public String getNombres4() {
		return nombres4;
	}

	/**
	 * Establece nombres4.
	 *
	 * @param nombres4            the nombres4 to set
	 */
	public void setNombres4(String nombres4) {
		this.nombres4 = nombres4;
	}

	/**
	 * Obtiene cat.
	 *
	 * @return the cat
	 */
	public String getCat() {
		return cat;
	}

	/**
	 * Establece cat.
	 *
	 * @param cat            the cat to set
	 */
	public void setCat(String cat) {
		this.cat = cat;
	}

	/**
	 * Obtiene branchcode.
	 *
	 * @return the branchcode
	 */
	public String getBranchcode() {
		return branchcode;
	}

	/**
	 * Establece branchcode.
	 *
	 * @param branchcode            the branchcode to set
	 */
	public void setBranchcode(String branchcode) {
		this.branchcode = branchcode;
	}

	/**
	 * Obtiene finicio.
	 *
	 * @return the finicio
	 */
	public String getFinicio() {
		return finicio;
	}

	/**
	 * Establece finicio.
	 *
	 * @param finicio            the finicio to set
	 */
	public void setFinicio(String finicio) {
		this.finicio = finicio;
	}

	/**
	 * Obtiene ffin.
	 *
	 * @return the ffin
	 */
	public String getFfin() {
		return ffin;
	}

	/**
	 * Establece ffin.
	 *
	 * @param ffin            the ffin to set
	 */
	public void setFfin(String ffin) {
		this.ffin = ffin;
	}

	/**
	 * Establece monto garantia.
	 *
	 * @param montoGarantia a monto garantia
	 */
	public void setMontoGarantia(String montoGarantia) {
		this.montoGarantia = montoGarantia;
	}

	/**
	 * Obtiene monto garantia.
	 *
	 * @return monto garantia
	 */
	public String getMontoGarantia() {
		return montoGarantia;
	}

	/**
	 * @return the saldoGarantia
	 */
	public double getSaldoGarantia() {
		return saldoGarantia;
	}

	/**
	 * @param saldoGarantia the saldoGarantia to set
	 */
	public void setSaldoGarantia(double saldoGarantia) {
		this.saldoGarantia = saldoGarantia;
	}

	/**
	 * @return the garantiaADepositar
	 */
	public Double getGarantiaADepositar() {
		return garantiaADepositar;
	}

	/**
	 * @param garantiaADepositar the garantiaADepositar to set
	 */
	public void setGarantiaADepositar(Double garantiaADepositar) {
		this.garantiaADepositar = garantiaADepositar;
	}

	/**
	 * @return the garantiaTraspasada
	 */
	public Double getGarantiaTraspasada() {
		return garantiaTraspasada;
	}

	/**
	 * @param garantiaTraspasada the garantiaTraspasada to set
	 */
	public void setGarantiaTraspasada(Double garantiaTraspasada) {
		this.garantiaTraspasada = garantiaTraspasada;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

}
