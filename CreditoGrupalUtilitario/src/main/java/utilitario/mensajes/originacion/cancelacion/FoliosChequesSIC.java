package utilitario.mensajes.originacion.cancelacion;

import utilitario.mensajes.comun.ObjetoValor;

public class FoliosChequesSIC extends ObjetoValor {
	/**
	 * Serializable
	 */
	private static final long serialVersionUID = -470831405632452755L;

	private long folioCheque;

	private java.lang.String comentario;

	private int valor;

	private String nombre;

	private String persona;

	private String montoCheque;
	
	private boolean cancelacionCheque;

	public long getFolioCheque() {
		return folioCheque;
	}

	public void setFolioCheque(long folioCheque) {
		this.folioCheque = folioCheque;
	}

	public java.lang.String getComentario() {
		return comentario;
	}

	public void setComentario(java.lang.String comentario) {
		this.comentario = comentario;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMontoCheque() {
		return montoCheque;
	}

	public void setMontoCheque(String montoCheque) {
		this.montoCheque = montoCheque;
	}

	public String getPersona() {
		return persona;
	}

	public void setPersona(String persona) {
		this.persona = persona;
	}

	public boolean isCancelacionCheque() {
		return cancelacionCheque;
	}

	public void setCancelacionCheque(boolean cancelacionCheque) {
		this.cancelacionCheque = cancelacionCheque;
	}

	@Override
	public String toString() {
		return "FoliosChequesSIC [folioCheque=" + folioCheque + ", comentario=" + comentario + ", valor=" + valor
				+ ", nombre=" + nombre + ", persona=" + persona + ", montoCheque=" + montoCheque
				+ ", cancelacionCheque=" + cancelacionCheque + "]";
	}
	

}
