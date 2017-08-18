package utilitario.mensajes.burocredito;

import utilitario.mensajes.comun.ObjetoValor;

public class ValidaBuroDTO extends ObjetoValor {

	/**
	 * serial
	 */
	private static final long serialVersionUID = 7671540211093614556L;

	/** The hipotecario. */
	private boolean hipotecario;
	/** The hipMop. */
	private int hipMop;
	/** The hipDescripcion. */
	private String hipDescripcion;
	/** The hipSaldoVencido. */
	private double hipSaldoVencido;
	/** The automotriz. */
	private boolean automotriz;
	/** The autoMop. */
	private int autoMop;
	/** The autoDescripcion. */
	private String autoDescripcion;
	/** The autoSaldoVencido. */
	private double autoSaldoVencido;

	/** The frontTitulos. */
	private String frontTitulos;
	/** The frontMop01. */
	private String frontMop01;
	/** The frontMop02. */
	private String frontMop02;
	/** The frontMop03. */
	private String frontMop03;
	/** The frontMop04. */
	private String frontMop04;
	/** The frontMop05. */
	private String frontMop05;
	/** The frontMop06. */
	private String frontMop06;
	/** The frontMop07. */
	private String frontMop07;
	/** The frontMop96. */
	private String frontMop96;
	/** The frontMop97. */
	private String frontMop97;
	/** The frontMop99. */
	private String frontMop99;
	/** The frontMopUR. */
	private String frontMopUR;
	/** The frontTotal. */
	private String frontTotal;
	/** The clavesObserv. */
	private String clavesObserv;

	/** The totalDesde03. */
	private int totalDesde03;
	/** The totalDesde04. */
	private int totalDesde04;


	/** The frontTitulosExportar. */
	private String frontTitulosExportar;
	/** The frontMop01Exportar. */
	private String frontMop01Exportar;
	/** The frontMop02Exportar. */
	private String frontMop02Exportar;
	/** The frontMop03Exportar. */
	private String frontMop03Exportar;
	/** The frontMop04Exportar. */
	private String frontMop04Exportar;
	/** The frontMop05Exportar. */
	private String frontMop05Exportar;
	/** The frontMop06Exportar. */
	private String frontMop06Exportar;
	/** The frontMop07Exportar. */
	private String frontMop07Exportar;
	/** The frontMop96Exportar. */
	private String frontMop96Exportar;
	/** The frontMop97Exportar. */
	private String frontMop97Exportar;
	/** The frontMop99Exportar. */
	private String frontMop99Exportar;
	/** The frontMopURExportar. */
	private String frontMopURExportar;
	/** The frontTotalExportar. */
	private String frontTotalExportar;
	/** The clavesObservExportar. */
	private String clavesObservExportar;

	/** The totalDesde03Exportar. */
	private int totalDesde03Exportar;
	/** The totalDesde04Exportar. */
	private int totalDesde04Exportar;


	/** hipotecarios mayores a mop 01*/
	private int totalHipotecarioMop01;
	/**automotriz mayores al Mop02*/
	private int totalAutomotrizMop02;
	/**checar a los clientes que tengan un mop 99*/
	private int totalMop99;

	/** suma de cuentas aceptables y malas por integrante*/
	private double sami;
	/**contribucion a las cuentas malas cuentas malas/sm*/
	private double contCuentasMalas;
	/**Contribucion al total de cuentas sami/sam*/
	private double contTotalCuentas;
	/** Indicador de salida contribucion de cuentas contCuentasMalas- contTotalCuentas*/
	private double indicadorSalida;

	/** The mop01. */
	private CuentaTLDTO mop01;
	/** The mop02. */
	private CuentaTLDTO mop02;
	/** The mop03. */
	private CuentaTLDTO mop03;
	/** The mop04. */
	private CuentaTLDTO mop04;
	/** The mop05. */
	private CuentaTLDTO mop05;
	/** The mop06. */
	private CuentaTLDTO mop06;
	/** The mop07. */
	private CuentaTLDTO mop07;
	/** The mop96. */
	private CuentaTLDTO mop96;
	/** The mop97. */
	private CuentaTLDTO mop97;
	/** The mop99. */
	private CuentaTLDTO mop99;
	/** The mopUR. */
	private CuentaTLDTO mopUR;
	/** The total. */
	private CuentaTLDTO total;

	/**
	 * ValidaBuroDTO
	 */
	public ValidaBuroDTO() {
		this.mop01 = new CuentaTLDTO();
		this.mop02 = new CuentaTLDTO();
		this.mop03 = new CuentaTLDTO();
		this.mop04 = new CuentaTLDTO();
		this.mop05 = new CuentaTLDTO();
		this.mop06 = new CuentaTLDTO();
		this.mop07 = new CuentaTLDTO();
		this.mop96 = new CuentaTLDTO();
		this.mop97 = new CuentaTLDTO();
		this.mop99 = new CuentaTLDTO();
		this.mopUR = new CuentaTLDTO();
		this.total = new CuentaTLDTO();

		this.hipotecario = false;
		this.hipMop = 0;
		this.hipDescripcion = " ";
		this.hipSaldoVencido = 0;
		this.automotriz = false;
		this.autoMop = 0;
		this.autoDescripcion = " ";
		this.autoSaldoVencido = 0;

		this.frontTitulos = " ";
		this.frontMop01 = " ";
		this.frontMop02 = " ";
		this.frontMop03 = " ";
		this.frontMop04 = " ";
		this.frontMop05 = " ";
		this.frontMop06 = " ";
		this.frontMop07 = " ";
		this.frontMop96 = " ";
		this.frontMop97 = " ";
		this.frontMop99 = " ";
		this.frontMopUR = " ";
		this.frontTotal = " ";
		this.clavesObserv = " ";

		this.totalDesde03 = 0;
		this.totalDesde04 = 0;

		this.totalHipotecarioMop01 = 0;
		this.totalAutomotrizMop02 = 0;
	}


	/**
	 * @return the clavesObserv
	 */
	public String getClavesObserv() {
		return clavesObserv;
	}

	/**
	 * @param clavesObserv the clavesObserv to set
	 */
	public void setClavesObserv(String clavesObserv) {
		this.clavesObserv = clavesObserv;
	}

	/**
	 * @return the mop01
	 */
	public CuentaTLDTO getMop01() {
		return mop01;
	}

	/**
	 * @param mop01 the mop01 to set
	 */
	public void setMop01(CuentaTLDTO mop01) {
		this.mop01 = mop01;
	}

	/**
	 * @return the mop02
	 */
	public CuentaTLDTO getMop02() {
		return mop02;
	}

	/**
	 * @param mop02 the mop02 to set
	 */
	public void setMop02(CuentaTLDTO mop02) {
		this.mop02 = mop02;
	}

	/**
	 * @return the mop03
	 */
	public CuentaTLDTO getMop03() {
		return mop03;
	}

	/**
	 * @param mop03 the mop03 to set
	 */
	public void setMop03(CuentaTLDTO mop03) {
		this.mop03 = mop03;
	}

	/**
	 * @return the mop04
	 */
	public CuentaTLDTO getMop04() {
		return mop04;
	}

	/**
	 * @param mop04 the mop04 to set
	 */
	public void setMop04(CuentaTLDTO mop04) {
		this.mop04 = mop04;
	}

	/**
	 * @return the mop05
	 */
	public CuentaTLDTO getMop05() {
		return mop05;
	}

	/**
	 * @param mop05 the mop05 to set
	 */
	public void setMop05(CuentaTLDTO mop05) {
		this.mop05 = mop05;
	}

	/**
	 * @return the mop06
	 */
	public CuentaTLDTO getMop06() {
		return mop06;
	}

	/**
	 * @param mop06 the mop06 to set
	 */
	public void setMop06(CuentaTLDTO mop06) {
		this.mop06 = mop06;
	}

	/**
	 * @return the mop07
	 */
	public CuentaTLDTO getMop07() {
		return mop07;
	}

	/**
	 * @param mop07 the mop07 to set
	 */
	public void setMop07(CuentaTLDTO mop07) {
		this.mop07 = mop07;
	}

	/**
	 * @return the mop96
	 */
	public CuentaTLDTO getMop96() {
		return mop96;
	}

	/**
	 * @param mop96 the mop96 to set
	 */
	public void setMop96(CuentaTLDTO mop96) {
		this.mop96 = mop96;
	}

	/**
	 * @return the mop97
	 */
	public CuentaTLDTO getMop97() {
		return mop97;
	}

	/**
	 * @param mop97 the mop97 to set
	 */
	public void setMop97(CuentaTLDTO mop97) {
		this.mop97 = mop97;
	}

	/**
	 * @return the mop99
	 */
	public CuentaTLDTO getMop99() {
		return mop99;
	}

	/**
	 * @param mop99 the mop99 to set
	 */
	public void setMop99(CuentaTLDTO mop99) {
		this.mop99 = mop99;
	}

	/**
	 * @return the mopUR
	 */
	public CuentaTLDTO getMopUR() {
		return mopUR;
	}

	/**
	 * @param mopUR the mopUR to set
	 */
	public void setMopUR(CuentaTLDTO mopUR) {
		this.mopUR = mopUR;
	}

	/**
	 * @return the total
	 */
	public CuentaTLDTO getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(CuentaTLDTO total) {
		this.total = total;
	}

	/**
	 * @return the hipotecario
	 */
	public boolean isHipotecario() {
		return hipotecario;
	}

	/**
	 * @param hipotecario the hipotecario to set
	 */
	public void setHipotecario(boolean hipotecario) {
		this.hipotecario = hipotecario;
	}

	/**
	 * @return the hipMop
	 */
	public int getHipMop() {
		return hipMop;
	}

	/**
	 * @param hipMop the hipMop to set
	 */
	public void setHipMop(int hipMop) {
		this.hipMop = hipMop;
	}

	/**
	 * @return the hipDescripcion
	 */
	public String getHipDescripcion() {
		return hipDescripcion;
	}

	/**
	 * @param hipDescripcion the hipDescripcion to set
	 */
	public void setHipDescripcion(String hipDescripcion) {
		this.hipDescripcion = hipDescripcion;
	}

	/**
	 * @return the hipSaldoVencido
	 */
	public double getHipSaldoVencido() {
		return hipSaldoVencido;
	}

	/**
	 * @param hipSaldoVencido the hipSaldoVencido to set
	 */
	public void setHipSaldoVencido(double hipSaldoVencido) {
		this.hipSaldoVencido = hipSaldoVencido;
	}

	/**
	 * @return the automotriz
	 */
	public boolean isAutomotriz() {
		return automotriz;
	}

	/**
	 * @param automotriz the automotriz to set
	 */
	public void setAutomotriz(boolean automotriz) {
		this.automotriz = automotriz;
	}

	/**
	 * @return the autoMop
	 */
	public int getAutoMop() {
		return autoMop;
	}

	/**
	 * @param autoMop the autoMop to set
	 */
	public void setAutoMop(int autoMop) {
		this.autoMop = autoMop;
	}

	/**
	 * @return the autoDescripcion
	 */
	public String getAutoDescripcion() {
		return autoDescripcion;
	}

	/**
	 * @param autoDescripcion the autoDescripcion to set
	 */
	public void setAutoDescripcion(String autoDescripcion) {
		this.autoDescripcion = autoDescripcion;
	}

	/**
	 * @return the autoSaldoVencido
	 */
	public double getAutoSaldoVencido() {
		return autoSaldoVencido;
	}

	/**
	 * @param autoSaldoVencido the autoSaldoVencido to set
	 */
	public void setAutoSaldoVencido(double autoSaldoVencido) {
		this.autoSaldoVencido = autoSaldoVencido;
	}

	/**
	 * @return the frontTitulos
	 */
	public String getFrontTitulos() {
		return frontTitulos;
	}

	/**
	 * @param frontTitulos the frontTitulos to set
	 */
	public void setFrontTitulos(String frontTitulos) {
		this.frontTitulos = frontTitulos;
	}

	/**
	 * @return the frontMop01
	 */
	public String getFrontMop01() {
		return frontMop01;
	}

	/**
	 * @param frontMop01 the frontMop01 to set
	 */
	public void setFrontMop01(String frontMop01) {
		this.frontMop01 = frontMop01;
	}

	/**
	 * @return the frontMop02
	 */
	public String getFrontMop02() {
		return frontMop02;
	}

	/**
	 * @param frontMop02 the frontMop02 to set
	 */
	public void setFrontMop02(String frontMop02) {
		this.frontMop02 = frontMop02;
	}

	/**
	 * @return the frontMop03
	 */
	public String getFrontMop03() {
		return frontMop03;
	}

	/**
	 * @param frontMop03 the frontMop03 to set
	 */
	public void setFrontMop03(String frontMop03) {
		this.frontMop03 = frontMop03;
	}

	/**
	 * @return the frontMop04
	 */
	public String getFrontMop04() {
		return frontMop04;
	}

	/**
	 * @param frontMop04 the frontMop04 to set
	 */
	public void setFrontMop04(String frontMop04) {
		this.frontMop04 = frontMop04;
	}

	/**
	 * @return the frontMop05
	 */
	public String getFrontMop05() {
		return frontMop05;
	}

	/**
	 * @param frontMop05 the frontMop05 to set
	 */
	public void setFrontMop05(String frontMop05) {
		this.frontMop05 = frontMop05;
	}

	/**
	 * @return the frontMop06
	 */
	public String getFrontMop06() {
		return frontMop06;
	}

	/**
	 * @param frontMop06 the frontMop06 to set
	 */
	public void setFrontMop06(String frontMop06) {
		this.frontMop06 = frontMop06;
	}

	/**
	 * @return the frontMop07
	 */
	public String getFrontMop07() {
		return frontMop07;
	}

	/**
	 * @param frontMop07 the frontMop07 to set
	 */
	public void setFrontMop07(String frontMop07) {
		this.frontMop07 = frontMop07;
	}

	/**
	 * @return the frontMop96
	 */
	public String getFrontMop96() {
		return frontMop96;
	}

	/**
	 * @param frontMop96 the frontMop96 to set
	 */
	public void setFrontMop96(String frontMop96) {
		this.frontMop96 = frontMop96;
	}

	/**
	 * @return the frontMop97
	 */
	public String getFrontMop97() {
		return frontMop97;
	}

	/**
	 * @param frontMop97 the frontMop97 to set
	 */
	public void setFrontMop97(String frontMop97) {
		this.frontMop97 = frontMop97;
	}

	/**
	 * @return the frontMop99
	 */
	public String getFrontMop99() {
		return frontMop99;
	}

	/**
	 * @param frontMop99 the frontMop99 to set
	 */
	public void setFrontMop99(String frontMop99) {
		this.frontMop99 = frontMop99;
	}

	/**
	 * @return the frontMopUR
	 */
	public String getFrontMopUR() {
		return frontMopUR;
	}

	/**
	 * @param frontMopUR the frontMopUR to set
	 */
	public void setFrontMopUR(String frontMopUR) {
		this.frontMopUR = frontMopUR;
	}

	/**
	 * @return the frontTotal
	 */
	public String getFrontTotal() {
		return frontTotal;
	}

	/**
	 * @param frontTotal the frontTotal to set
	 */
	public void setFrontTotal(String frontTotal) {
		this.frontTotal = frontTotal;
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
	 * @return the sami
	 */
	public double getSami() {
		return sami;
	}


	/**
	 * @param sami the sami to set
	 */
	public void setSami(double sami) {
		this.sami = sami;
	}


	/**
	 * @return the contCuentasMalas
	 */
	public double getContCuentasMalas() {
		return contCuentasMalas;
	}


	/**
	 * @param contCuentasMalas the contCuentasMalas to set
	 */
	public void setContCuentasMalas(double contCuentasMalas) {
		this.contCuentasMalas = contCuentasMalas;
	}


	/**
	 * @return the contTotalCuentas
	 */
	public double getContTotalCuentas() {
		return contTotalCuentas;
	}


	/**
	 * @param contTotalCuentas the contTotalCuentas to set
	 */
	public void setContTotalCuentas(double contTotalCuentas) {
		this.contTotalCuentas = contTotalCuentas;
	}


	/**
	 * @return the indicadorSalida
	 */
	public double getIndicadorSalida() {
		return indicadorSalida;
	}


	/**
	 * @param indicadorSalida the indicadorSalida to set
	 */
	public void setIndicadorSalida(double indicadorSalida) {
		this.indicadorSalida = indicadorSalida;
	}


	/**
	 * @return the frontTitulosExportar
	 */
	public String getFrontTitulosExportar() {
		return frontTitulosExportar;
	}


	/**
	 * @param frontTitulosExportar the frontTitulosExportar to set
	 */
	public void setFrontTitulosExportar(String frontTitulosExportar) {
		this.frontTitulosExportar = frontTitulosExportar;
	}


	/**
	 * @return the frontMop01Exportar
	 */
	public String getFrontMop01Exportar() {
		return frontMop01Exportar;
	}


	/**
	 * @param frontMop01Exportar the frontMop01Exportar to set
	 */
	public void setFrontMop01Exportar(String frontMop01Exportar) {
		this.frontMop01Exportar = frontMop01Exportar;
	}


	/**
	 * @return the frontMop02Exportar
	 */
	public String getFrontMop02Exportar() {
		return frontMop02Exportar;
	}


	/**
	 * @param frontMop02Exportar the frontMop02Exportar to set
	 */
	public void setFrontMop02Exportar(String frontMop02Exportar) {
		this.frontMop02Exportar = frontMop02Exportar;
	}


	/**
	 * @return the frontMop03Exportar
	 */
	public String getFrontMop03Exportar() {
		return frontMop03Exportar;
	}


	/**
	 * @param frontMop03Exportar the frontMop03Exportar to set
	 */
	public void setFrontMop03Exportar(String frontMop03Exportar) {
		this.frontMop03Exportar = frontMop03Exportar;
	}


	/**
	 * @return the frontMop04Exportar
	 */
	public String getFrontMop04Exportar() {
		return frontMop04Exportar;
	}


	/**
	 * @param frontMop04Exportar the frontMop04Exportar to set
	 */
	public void setFrontMop04Exportar(String frontMop04Exportar) {
		this.frontMop04Exportar = frontMop04Exportar;
	}


	/**
	 * @return the frontMop05Exportar
	 */
	public String getFrontMop05Exportar() {
		return frontMop05Exportar;
	}


	/**
	 * @param frontMop05Exportar the frontMop05Exportar to set
	 */
	public void setFrontMop05Exportar(String frontMop05Exportar) {
		this.frontMop05Exportar = frontMop05Exportar;
	}


	/**
	 * @return the frontMop06Exportar
	 */
	public String getFrontMop06Exportar() {
		return frontMop06Exportar;
	}


	/**
	 * @param frontMop06Exportar the frontMop06Exportar to set
	 */
	public void setFrontMop06Exportar(String frontMop06Exportar) {
		this.frontMop06Exportar = frontMop06Exportar;
	}


	/**
	 * @return the frontMop07Exportar
	 */
	public String getFrontMop07Exportar() {
		return frontMop07Exportar;
	}


	/**
	 * @param frontMop07Exportar the frontMop07Exportar to set
	 */
	public void setFrontMop07Exportar(String frontMop07Exportar) {
		this.frontMop07Exportar = frontMop07Exportar;
	}


	/**
	 * @return the frontMop96Exportar
	 */
	public String getFrontMop96Exportar() {
		return frontMop96Exportar;
	}


	/**
	 * @param frontMop96Exportar the frontMop96Exportar to set
	 */
	public void setFrontMop96Exportar(String frontMop96Exportar) {
		this.frontMop96Exportar = frontMop96Exportar;
	}


	/**
	 * @return the frontMop97Exportar
	 */
	public String getFrontMop97Exportar() {
		return frontMop97Exportar;
	}


	/**
	 * @param frontMop97Exportar the frontMop97Exportar to set
	 */
	public void setFrontMop97Exportar(String frontMop97Exportar) {
		this.frontMop97Exportar = frontMop97Exportar;
	}


	/**
	 * @return the frontMop99Exportar
	 */
	public String getFrontMop99Exportar() {
		return frontMop99Exportar;
	}


	/**
	 * @param frontMop99Exportar the frontMop99Exportar to set
	 */
	public void setFrontMop99Exportar(String frontMop99Exportar) {
		this.frontMop99Exportar = frontMop99Exportar;
	}


	/**
	 * @return the frontMopURExportar
	 */
	public String getFrontMopURExportar() {
		return frontMopURExportar;
	}


	/**
	 * @param frontMopURExportar the frontMopURExportar to set
	 */
	public void setFrontMopURExportar(String frontMopURExportar) {
		this.frontMopURExportar = frontMopURExportar;
	}


	/**
	 * @return the frontTotalExportar
	 */
	public String getFrontTotalExportar() {
		return frontTotalExportar;
	}


	/**
	 * @param frontTotalExportar the frontTotalExportar to set
	 */
	public void setFrontTotalExportar(String frontTotalExportar) {
		this.frontTotalExportar = frontTotalExportar;
	}


	/**
	 * @return the clavesObservExportar
	 */
	public String getClavesObservExportar() {
		return clavesObservExportar;
	}


	/**
	 * @param clavesObservExportar the clavesObservExportar to set
	 */
	public void setClavesObservExportar(String clavesObservExportar) {
		this.clavesObservExportar = clavesObservExportar;
	}


	/**
	 * @return the totalDesde03Exportar
	 */
	public int getTotalDesde03Exportar() {
		return totalDesde03Exportar;
	}


	/**
	 * @param totalDesde03Exportar the totalDesde03Exportar to set
	 */
	public void setTotalDesde03Exportar(int totalDesde03Exportar) {
		this.totalDesde03Exportar = totalDesde03Exportar;
	}


	/**
	 * @return the totalDesde04Exportar
	 */
	public int getTotalDesde04Exportar() {
		return totalDesde04Exportar;
	}


	/**
	 * @param totalDesde04Exportar the totalDesde04Exportar to set
	 */
	public void setTotalDesde04Exportar(int totalDesde04Exportar) {
		this.totalDesde04Exportar = totalDesde04Exportar;
	}


	/**
	 * @return the totalMop99
	 */
	public int getTotalMop99() {
		return totalMop99;
	}


	/**
	 * @param totalMop99 the totalMop99 to set
	 */
	public void setTotalMop99(int totalMop99) {
		this.totalMop99 = totalMop99;
	}

}
