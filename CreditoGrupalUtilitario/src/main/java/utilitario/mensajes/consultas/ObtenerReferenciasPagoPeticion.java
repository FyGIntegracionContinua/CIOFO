package utilitario.mensajes.consultas;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class ConsultaReferenciasPagoPeticion.
 *
 * @author rguadarramac
 *
 */
public class ObtenerReferenciasPagoPeticion extends ObjetoValor  {

	/**
	 * Instancia una nueva consulta referencias pago peticion.
	 */
	public ObtenerReferenciasPagoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2637486592033831657L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The num persona. */
	private String numPersona;

	/** The num sucursal. */
	private String numSucursal;

	/** The Monto. */
	private Double monto;

	/** The solo digito verificador. */
	private boolean soloDigitoVerificador;

	/**
	 * Obtiene header.
	 *
	 * @return header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}

	/**
	 * Establece header.
	 *
	 * @param header a header
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}

	/**
	 * Gets the num persona.
	 *
	 * @return the num persona
	 */
	public String getNumPersona() {
		return numPersona;
	}

	/**
	 * Sets the num persona.
	 *
	 * @param numPersona the new num persona
	 */
	public void setNumPersona(String numPersona) {
		this.numPersona = numPersona;
	}

	/**
	 * Gets the num sucursal.
	 *
	 * @return the num sucursal
	 */
	public String getNumSucursal() {
		return numSucursal;
	}

	/**
	 * Sets the num sucursal.
	 *
	 * @param numSucursal the new num sucursal
	 */
	public void setNumSucursal(String numSucursal) {
		this.numSucursal = numSucursal;
	}

	/**
	 * Gets the monto.
	 *
	 * @return the monto
	 */
	public Double getMonto() {
		return monto;
	}

	/**
	 * Sets the monto.
	 *
	 * @param monto the new monto
	 */
	public void setMonto(Double monto) {
		this.monto = monto;
	}

	/**
	 * Gets the solo digito verificador.
	 *
	 * @return the solo digito verificador
	 */
	public boolean getSoloDigitoVerificador() {
		return soloDigitoVerificador;
	}

	/**
	 * Sets the solo digito verificador.
	 *
	 * @param soloDigitoVerificador the new solo digito verificador
	 */
	public void setSoloDigitoVerificador(boolean soloDigitoVerificador) {
		this.soloDigitoVerificador = soloDigitoVerificador;
	}

}
