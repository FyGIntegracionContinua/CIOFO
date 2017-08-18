package utilitario.mensajes.consultas;

import java.util.Date;


import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class CreditosSinAsignar.
 */
public class CreditosSinAsignar extends ObjetoValor {

	/**
	 * Instancia una nueva creditos sin asignar.
	 */
	public CreditosSinAsignar() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3540485575866873610L;

	/** The fecha. */
	private Date fecha;

	/** The fecha disposicion. */
	private Date fechaDisposicion;

	/** The contrato. */
	private String contrato;

	/** The grupo. */
	private String grupo;

	/** The sucursal. */
	private String sucursal;

	/** The zona. */
	private Integer zona;

	/** The num dias. */
	private Integer numDias;

	/** The contratoCredprod. */
	private String contratoCredprod;
	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
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
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
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
	 * Establece num dias.
	 *
	 * @param numDias the numDias to set
	 */
	public void setNumDias(Integer numDias) {
		this.numDias = numDias;
	}

	/**
	 * Obtiene num dias.
	 *
	 * @return the numDias
	 */
	public Integer getNumDias() {
		return numDias;
	}

	/**
	 * Establece zona.
	 *
	 * @param zona a zona
	 */
	public void setZona(Integer zona) {
		this.zona = zona;
	}

	/**
	 * Obtiene zona.
	 *
	 * @return zona
	 */
	public Integer getZona() {
		return zona;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha a fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha disposicion.
	 *
	 * @param fechaDisposicion a fecha disposicion
	 */
	public void setFechaDisposicion(Date fechaDisposicion) {
		this.fechaDisposicion = fechaDisposicion;
	}

	/**
	 * Obtiene fecha disposicion.
	 *
	 * @return fecha disposicion
	 */
	public Date getFechaDisposicion() {
		return fechaDisposicion;
	}

	/**
	 * @return the contratoCredprod
	 */
	public String getContratoCredprod() {
		return contratoCredprod;
	}

	/**
	 * @param contratoCredprod the contratoCredprod to set
	 */
	public void setContratoCredprod(String contratoCredprod) {
		this.contratoCredprod = contratoCredprod;
	}

}
