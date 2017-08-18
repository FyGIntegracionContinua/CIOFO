package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;

public class IntegrantesKit extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -8945216601494337828L;
	/** obligatorio */
	private boolean obligatorio;
	/** persona */
	private String persona;
	/** nombre */
	private String nombre;
	/** fechaUltimaActualizacion */
	private String fechaUltimaActualizacion;
	/** monto */
	private double monto;
	/**ciclo Cliente Grupo*/
	private int cicloClienteGrupo;
	/**
	 * @return the obligatorio
	 */
	public boolean isObligatorio() {
		return obligatorio;
	}
	/**
	 * @param obligatorio the obligatorio to set
	 */
	public void setObligatorio(boolean obligatorio) {
		this.obligatorio = obligatorio;
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
		this.persona = persona;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the fechaUltimaActualizacion
	 */
	public String getFechaUltimaActualizacion() {
		return fechaUltimaActualizacion;
	}
	/**
	 * @param fechaUltimaActualizacion the fechaUltimaActualizacion to set
	 */
	public void setFechaUltimaActualizacion(String fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}
	/**
	 * @return the monto
	 */
	public double getMonto() {
		return monto;
	}
	/**
	 * @param monto the monto to set
	 */
	public void setMonto(double monto) {
		this.monto = monto;
	}
	/**
	 * @return the cicloClienteGrupo
	 */
	public int getCicloClienteGrupo() {
		return cicloClienteGrupo;
	}
	/**
	 * @param cicloClienteGrupo the cicloClienteGrupo to set
	 */
	public void setCicloClienteGrupo(int cicloClienteGrupo) {
		this.cicloClienteGrupo = cicloClienteGrupo;
	}

}
