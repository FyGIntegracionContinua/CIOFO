package utilitario.mensajes.impresiondocs;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * @author rguadarramac
 *
 */
public class ImpresionDocsConsulta extends ObjetoValor {

	/**
	 * serialVersionUID long
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * numeroCredito String
	 */
	private String numeroCredito;
	/**
	 * tipoDato String
	 */
	private String tipoDato;
	/**
	 * fechaPeticion String
	 */
	private String fechaPeticion;

	/**
	 * ImpresionDocsConsulta
	 */
	public ImpresionDocsConsulta() {
	}


	/**
	 * @return the tipoDato
	 */
	public String getTipoDato() {
		return tipoDato;
	}

	/**
	 * @param tipoDato the tipoDato to set
	 */
	public void setTipoDato(String tipoDato) {
		this.tipoDato = tipoDato;
	}
	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return  getTipo() + "_" + getTipoDato();
	}
	/**
	 * @return the numeroCredito
	 */
	public String getNumeroCredito() {
		return  this.numeroCredito;
	}
	/**
	 * @param numeroCredito the numeroCredito to set
	 */
	public void setNumeroCredito(String numeroCredito) {
		this.numeroCredito = numeroCredito;
	}


	/**
	 * @return the fechaPeticion
	 */
	public String getFechaPeticion() {
		return fechaPeticion;
	}


	/**
	 * @param fechaPeticion the fechaPeticion to set
	 */
	public void setFechaPeticion(String fechaPeticion) {
		this.fechaPeticion = fechaPeticion;
	}

	}
