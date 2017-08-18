
package utilitario.mensajes.operacion.pagos;

import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class PagoGrupal.
 */
public class PagoGrupal extends ObjetoValor {

	/**
	 * Instancia una nueva pago grupal.
	 */
	public PagoGrupal() {
		// TODO Auto-generated constructor stub
	}
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = -3126017919101332051L;

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

    /** The codigo. */
    protected String codigo = "PREF";

    /** The referencia. */
    protected String referencia = "";
    //Puede ser NORMAL o ABONO
    /** The tipo pago. */
    protected String tipoPago = "";

    /** The usuario. */
    protected String usuario = "";

    /** The sucursal. */
    protected Integer sucursal = 0;

    /** The id transaccion. */
    private String idTransaccionValida;

    /**
     * Obtiene usuario.
     *
     * @return usuario
     */
    public String getUsuario() {
		return usuario;
	}

	/**
	 * Establece usuario.
	 *
	 * @param usuario a usuario
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * Obtiene tipo pago.
	 *
	 * @return tipo pago
	 */
	public String getTipoPago() {
		return tipoPago;
	}

	/**
	 * Establece tipo pago.
	 *
	 * @param tipoPago a tipo pago
	 */
	public void setTipoPago(String tipoPago) {
		this.tipoPago = tipoPago;
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
	 * Obtiene codigo.
	 *
	 * @return codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * Establece codigo.
	 *
	 * @param codigo a codigo
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * Obtiene referencia.
	 *
	 * @return referencia
	 */
	public String getReferencia() {
		return referencia;
	}

	/**
	 * Establece referencia.
	 *
	 * @param referencia a referencia
	 */
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal a sucursal
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the idTransaccionValida
	 */
	public String getIdTransaccionValida() {
		return idTransaccionValida;
	}

	/**
	 * @param idTransaccionValida the idTransaccionValida to set
	 */
	public void setIdTransaccionValida(String idTransaccionValida) {
		this.idTransaccionValida = idTransaccionValida;
	}


}
