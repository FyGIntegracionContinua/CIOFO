package utilitario.comun;

/**
 * clase que contiene los tiempos trancurridos
 * @author rmontellano
 * @version 4.17
 */
public class FechaTiempo {
	/**hora en que se asigna solicitus*/
	private int horaAlta;

	/** horas trancurridas desde que se envio el correo*/
	private int horasTranscurridas;

	/** dias trancurridos desde que se envio el correo*/
	private int diasTranscurridos;

	/**meses trnacurridos desde que se envia el correo*/
	private int mesesTranscurridos;

	/**años trancurridos desde que se envio el correo*/
	private int yearsTrancurridos;

	/**intervalo de tiempo inicial de horario habil 8*/
	private int intervaloInicial;

	/**intervalo de tiempo final de horario habil 20*/
	private int intervaloFinal;

	/**Estus de la tarea*/
	private String estatusTarea;

	/**
	 * @return the horasTranscurridas
	 */
	public int getHorasTranscurridas() {
		return horasTranscurridas;
	}

	/**
	 * @param horasTranscurridas the horasTranscurridas to set
	 */
	public void setHorasTranscurridas(int horasTranscurridas) {
		this.horasTranscurridas = horasTranscurridas;
	}

	/**
	 * @return the diasTranscurridos
	 */
	public int getDiasTranscurridos() {
		return diasTranscurridos;
	}

	/**
	 * @param diasTranscurridos the diasTranscurridos to set
	 */
	public void setDiasTranscurridos(int diasTranscurridos) {
		this.diasTranscurridos = diasTranscurridos;
	}

	/**
	 * @return the mesesTranscurridos
	 */
	public int getMesesTranscurridos() {
		return mesesTranscurridos;
	}

	/**
	 * @param mesesTranscurridos the mesesTranscurridos to set
	 */
	public void setMesesTranscurridos(int mesesTranscurridos) {
		this.mesesTranscurridos = mesesTranscurridos;
	}

	/**
	 * @return the yearsTrancurridos
	 */
	public int getYearsTrancurridos() {
		return yearsTrancurridos;
	}

	/**
	 * @param yearsTrancurridos the yearsTrancurridos to set
	 */
	public void setYearsTrancurridos(int yearsTrancurridos) {
		this.yearsTrancurridos = yearsTrancurridos;
	}

	/**
	 * @return the horaAlta
	 */
	public int getHoraAlta() {
		return horaAlta;
	}

	/**
	 * @param horaAlta the horaAlta to set
	 */
	public void setHoraAlta(int horaAlta) {
		this.horaAlta = horaAlta;
	}

	/**
	 * @return the intervaloInicial
	 */
	public int getIntervaloInicial() {
		return intervaloInicial;
	}

	/**
	 * @param intervaloInicial the intervaloInicial to set
	 */
	public void setIntervaloInicial(int intervaloInicial) {
		this.intervaloInicial = intervaloInicial;
	}

	/**
	 * @return the intervaloFinal
	 */
	public int getIntervaloFinal() {
		return intervaloFinal;
	}

	/**
	 * @param intervaloFinal the intervaloFinal to set
	 */
	public void setIntervaloFinal(int intervaloFinal) {
		this.intervaloFinal = intervaloFinal;
	}

	/**
	 * @return the estatusTarea
	 */
	public String getEstatusTarea() {
		return estatusTarea;
	}

	/**
	 * @param estatusTarea the estatusTarea to set
	 */
	public void setEstatusTarea(String estatusTarea) {
		this.estatusTarea = estatusTarea;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "horaAlta:" + horaAlta + "\thorasTranscurridas: " + horasTranscurridas
				+ "\tdiasTranscurridos:" + diasTranscurridos + "\tmesesTranscurridos: "
				+ mesesTranscurridos + "\tyearsTrancurridos:" + yearsTrancurridos
				+ "\tintervaloInicial:" + intervaloInicial + "\tintervaloFinal:"
				+ intervaloFinal + "\testatusTarea:" + estatusTarea;
	}
}
