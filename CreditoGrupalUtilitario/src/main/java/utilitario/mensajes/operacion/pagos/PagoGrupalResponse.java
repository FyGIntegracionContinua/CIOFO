
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class PagoGrupalResponse.
 */
public class PagoGrupalResponse extends ObjetoValor {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3228363337216730808L;

	/** The header. */
	private EncabezadoRespuesta header;

    /** The id pago. */
    protected int idPago;

    /** The numero contrato. */
    protected String numeroContrato;

    /** The monto. */
    protected double monto;

    /** The fecha valor. */
    protected java.util.Date fechaValor;

    /** The medio pago. */
    protected String medioPago;

    /** The estatus. */
    protected String estatus;

    /** The id transaccion. */
    protected Integer idTransaccion;

    /** The id promesaLiquidacion. */
    private boolean promesaLiquidacion;

    /**
     * Instancia una nueva pago grupal response.
     */
    public PagoGrupalResponse()	{
    	header = new EncabezadoRespuesta();
    	}

    /**
     * Obtiene id transaccion.
     *
     * @return id transaccion
     */
    public Integer getIdTransaccion() {
		return idTransaccion;
	}

	/**
	 * Establece id transaccion.
	 *
	 * @param idTransaccion a id transaccion
	 */
	public void setIdTransaccion(Integer idTransaccion) {
		this.idTransaccion = idTransaccion;
	}

	/**
	 * Gets the value of the idPago property.
	 *
	 * @return id pago
	 */
    public int getIdPago() {
        return idPago;
    }

    /**
     * Sets the value of the idPago property.
     *
     * @param value a id pago
     */
    public void setIdPago(int value) {
        this.idPago = value;
    }

    /**
     * Gets the value of the numeroContrato property.
     *
     * @return
     *     possible object is
     *
     */
    public String getNumeroContrato() {
        return numeroContrato;
    }

    /**
     * Sets the value of the numeroContrato property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setNumeroContrato(String value) {
        this.numeroContrato = value;
    }

    /**
     * Gets the value of the monto property.
     *
     * @return monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     *
     * @param value a monto
     */
    public void setMonto(double value) {
        this.monto = value;
    }

    /**
     * Gets the value of the fechaValor property.
     *
     * @return
     *     possible object is
     *
     */
    public java.util.Date getFechaValor() {
        return fechaValor;
    }

    /**
     * Sets the value of the fechaValor property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setFechaValor(java.util.Date value) {
        this.fechaValor = value;
    }

    /**
     * Gets the value of the medioPago property.
     *
     * @return
     *     possible object is
     *
     */
    public String getMedioPago() {
        return medioPago;
    }

    /**
     * Sets the value of the medioPago property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setMedioPago(String value) {
        this.medioPago = value;
    }

    /**
     * Gets the value of the estatus property.
     *
     * @return
     *     possible object is
     *
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * Sets the value of the estatus property.
     *
     * @param value
     *     allowed object is
     *
     */
    public void setEstatus(String value) {
        this.estatus = value;
    }

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoRespuesta getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoRespuesta header) {
		this.header = header;
	}

	/**
	 * @return the promesaLiquidacion
	 */
	public boolean isPromesaLiquidacion() {
		return promesaLiquidacion;
	}

	/**
	 * @param promesaLiquidacion the promesaLiquidacion to set
	 */
	public void setPromesaLiquidacion(boolean promesaLiquidacion) {
		this.promesaLiquidacion = promesaLiquidacion;
	}

}
