package utilitario.mensajes.consultas;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;


/**
 * The Class ConsultaReferenciasPagoPeticion.
 *
 * @author rguadarramac
 *
 */
public class ConsultaReferenciasPagoPeticion extends ObjetoValor  {

	/**
	 * Instancia una nueva consulta referencias pago peticion.
	 */
	public ConsultaReferenciasPagoPeticion() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2637486592033831657L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The contrato. */
	private String contrato;

	/** numero de contrato. */
	private String numContrato;

	/** The monto de pago */
	private String montoPago;

	/** The producto */
	private String producto;

	/** The lista contratos. */
	private List<ConsultaReferenciaBancariasOV> listaContratos;

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
	 * Obtiene contrato.
	 *
	 * @return contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the montoPago
	 */
	public String getMontoPago() {
		return montoPago;
	}

	/**
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(String montoPago) {
		this.montoPago = montoPago;
	}

	/**
	 * @return the listaContratos
	 */
	public List<ConsultaReferenciaBancariasOV> getListaContratos() {
		return listaContratos;
	}

	/**
	 * @param listaContratos the listaContratos to set
	 */
	public void setListaContratos(List<ConsultaReferenciaBancariasOV> listaContratos) {
		this.listaContratos = listaContratos;
	}

	/**
	 * @return the numContrato
	 */
	public String getNumContrato() {
		return numContrato;
	}

	/**
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

}
