package utilitario.reglas.solicitudes;

import utilitario.mensajes.comun.ObjetoValor;

public class InputReglasIncremento extends ObjetoValor {

	/**
	 * Instantiates a new input reglas incremento.
	 */
	public InputReglasIncremento() {
	}
	/**
	 * serial
	 */
	private static final long serialVersionUID = 658320298277464901L;
	/**
	 * ciclo
	 */
	private int ciclo;
	/**
	 * atrasoMaximo
	 */
	private int atrasoMaximo;
	/**
	 * atrasoFechaFin
	 */
	private int atrasoFechaFin;
	/**
	 * edad
	 */
	private int edad;
	/**
	 * experienciaCrediticia
	 */
	private String experienciaCrediticia;
	/**
	 * mop99
	 */
	private boolean mop99;
	/**
	 * automotrizHipotecario
	 */
	private boolean automotrizHipotecario;
	/**
	 * montoManejado
	 */
	private double montoManejado;
	/**
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}
	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	/**
	 * @return the atrasoMaximo
	 */
	public int getAtrasoMaximo() {
		return atrasoMaximo;
	}
	/**
	 * @param atrasoMaximo the atrasoMaximo to set
	 */
	public void setAtrasoMaximo(int atrasoMaximo) {
		this.atrasoMaximo = atrasoMaximo;
	}
	/**
	 * @return the atrasoFechaFin
	 */
	public int getAtrasoFechaFin() {
		return atrasoFechaFin;
	}
	/**
	 * @param atrasoFechaFin the atrasoFechaFin to set
	 */
	public void setAtrasoFechaFin(int atrasoFechaFin) {
		this.atrasoFechaFin = atrasoFechaFin;
	}
	/**
	 * @return the edad
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	/**
	 * @return the experienciaCrediticia
	 */
	public String getExperienciaCrediticia() {
		return experienciaCrediticia;
	}
	/**
	 * @param experienciaCrediticia the experienciaCrediticia to set
	 */
	public void setExperienciaCrediticia(String experienciaCrediticia) {
		this.experienciaCrediticia = experienciaCrediticia;
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
	 * @return the automotrizHipotecario
	 */
	public boolean isAutomotrizHipotecario() {
		return automotrizHipotecario;
	}
	/**
	 * @param automotrizHipotecario the automotrizHipotecario to set
	 */
	public void setAutomotrizHipotecario(boolean automotrizHipotecario) {
		this.automotrizHipotecario = automotrizHipotecario;
	}
	/**
	 * @return the montoManejado
	 */
	public double getMontoManejado() {
		return montoManejado;
	}
	/**
	 * @param montoManejado the montoManejado to set
	 */
	public void setMontoManejado(double montoManejado) {
		this.montoManejado = montoManejado;
	}

}
