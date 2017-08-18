package utilitario.reglas.solicitudes;

/**
 * The Class InputReglasTasaInteres.
 */
public class InputReglasTasaInteres {

	/**
	 * Instantiates a new input reglas tasa interes.
	 */
	public InputReglasTasaInteres() {
	}

	/** The renovacion. */
	private boolean renovacion;

	/** The campana. */
	private boolean campana;

	/** The central cec. */
	private boolean centralCec;

	/** The atraso. */
	private double atraso;

	/** The integrantes. */
	private double numeroIntegrantes;

	/** The ciclo. */
	private int ciclo;

	/** monto grupal del credito */
	private double montoGrupal;

	/**codigoCampana*/
	private String codigoCampana;


	/**
	 * Checks if is renovacion.
	 *
	 * @return true, if is renovacion
	 */
	public boolean isRenovacion() {
		return renovacion;
	}

	/**
	 * Sets the renovacion.
	 *
	 * @param renovacion the new renovacion
	 */
	public void setRenovacion(boolean renovacion) {
		this.renovacion = renovacion;
	}

	/**
	 * Checks if is campana.
	 *
	 * @return true, if is campana
	 */
	public boolean isCampana() {
		return campana;
	}

	/**
	 * Sets the campana.
	 *
	 * @param campana the new campana
	 */
	public void setCampana(boolean campana) {
		this.campana = campana;
	}

	/**
	 * Checks if is central cec.
	 *
	 * @return true, if is central cec
	 */
	public boolean isCentralCec() {
		return centralCec;
	}

	/**
	 * Sets the central cec.
	 *
	 * @param centralCec the new central cec
	 */
	public void setCentralCec(boolean centralCec) {
		this.centralCec = centralCec;
	}

	/**
	 * Gets the atraso.
	 *
	 * @return the atraso
	 */
	public double getAtraso() {
		return atraso;
	}

	/**
	 * Sets the atraso.
	 *
	 * @param atraso the new atraso
	 */
	public void setAtraso(double atraso) {
		this.atraso = atraso;
	}

	/**
	 * Gets the numero integrantes.
	 *
	 * @return the numero integrantes
	 */
	public double getNumeroIntegrantes() {
		return numeroIntegrantes;
	}

	/**
	 * Sets the numero integrantes.
	 *
	 * @param numeroIntegrantes the new numero integrantes
	 */
	public void setNumeroIntegrantes(double numeroIntegrantes) {
		this.numeroIntegrantes = numeroIntegrantes;
	}

	/**
	 * Gets the ciclo.
	 *
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}

	/**
	 * Sets the ciclo.
	 *
	 * @param ciclo the new ciclo
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	
	/**
	 * @return the montoGrupal
	 */
	public double getMontoGrupal() {
		return montoGrupal;
	}

	/**
	 * @param montoGrupal the montoGrupal to set
	 */
	public void setMontoGrupal(double montoGrupal) {
		this.montoGrupal = montoGrupal;
	}

	/**
	 * @return the codigoCampana
	 */
	public String getCodigoCampana() {
		return codigoCampana;
	}

	/**
	 * @param codigoCampana the codigoCampana to set
	 */
	public void setCodigoCampana(String codigoCampana) {
		this.codigoCampana = codigoCampana;
	}


}
