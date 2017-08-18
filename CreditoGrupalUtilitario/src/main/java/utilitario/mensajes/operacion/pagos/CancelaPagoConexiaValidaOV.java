package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class DetalleTransaccionOV.
 *
 * @author out_ltorres
 */
public 	class CancelaPagoConexiaValidaOV extends ObjetoValor {
    /**
	 * Instancia una nueva detalle transaccion ov.
	 */
	public CancelaPagoConexiaValidaOV() { }

	/** Id para serializacion. */
    private static final long serialVersionUID = -4913391168440862760L;

	/** The monto. */
	private Double monto;

	/** The idTransaccion. */
	private Integer idTransaccion;


    /**
     * Obtiene monto.
     *
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * Establece monto.
     *
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * Obtiene idTransaccion.
     *
     * @return the idTransaccion
     */
    public Integer getIdTransaccion() {
        return idTransaccion;
    }

    /**
     * Establece idTransaccion.
     *
     * @param idTransaccion the idTransaccion to set
     */
    public void setIdTransaccion(Integer idTransaccion) {
        this.idTransaccion = idTransaccion;
    }
}
