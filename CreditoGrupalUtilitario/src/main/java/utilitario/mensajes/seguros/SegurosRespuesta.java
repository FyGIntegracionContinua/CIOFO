package utilitario.mensajes.seguros;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SegurosRespuesta.
 *
 * @author rguadarramac
 */
public class SegurosRespuesta extends ObjetoValor {

	/**
	 * Instancia una nueva seguros respuesta.
	 */
	public SegurosRespuesta() {
	}
	/** Se genero clave de objeto. */
	private static final long serialVersionUID = -6467959346298489262L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The beneficiario cliente. */
	private BeneficiariosClienteOV beneficiarioCliente;

	/** The total porcentaje beneficiarios. */
	private double totalPorcentajeBeneficiarios;

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
	 * Establece beneficiario cliente.
	 *
	 * @param beneficiarioCliente a beneficiario cliente
	 */
	public void setBeneficiarioCliente(BeneficiariosClienteOV beneficiarioCliente) {
		this.beneficiarioCliente = beneficiarioCliente;
	}

	/**
	 * Obtiene beneficiario cliente.
	 *
	 * @return beneficiario cliente
	 */
	public BeneficiariosClienteOV getBeneficiarioCliente() {
		return beneficiarioCliente;
	}

	/**
	 * Establece total porcentaje beneficiarios.
	 *
	 * @param totalPorcentajeBeneficiarios a total porcentaje beneficiarios
	 */
	public void setTotalPorcentajeBeneficiarios(double totalPorcentajeBeneficiarios) {
		this.totalPorcentajeBeneficiarios = totalPorcentajeBeneficiarios;
	}

	/**
	 * Obtiene total porcentaje beneficiarios.
	 *
	 * @return total porcentaje beneficiarios
	 */
	public double getTotalPorcentajeBeneficiarios() {
		return totalPorcentajeBeneficiarios;
	}


}
