package utilitario.mensajes.seguros;

import java.util.List;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class SegurosRespuestaConsulta.
 *
 * @author rguadarramac
 */
public class SegurosRespuestaConsulta extends ObjetoValor {

	/**
	 * Instancia una nueva seguros respuesta consulta.
	 */
	public SegurosRespuestaConsulta() {
	}
	/** Se genero clave de objeto. */
	private static final long serialVersionUID = 6582327159216619247L;

	/** The header. */
	private EncabezadoRespuesta header;

	/** The beneficiario cliente. */
	private List<BeneficiariosClienteOV> beneficiarioCliente;

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
	public void setBeneficiarioCliente(List<BeneficiariosClienteOV> beneficiarioCliente) {
		this.beneficiarioCliente = beneficiarioCliente;
	}

	/**
	 * Obtiene beneficiario cliente.
	 *
	 * @return beneficiario cliente
	 */
	public List<BeneficiariosClienteOV> getBeneficiarioCliente() {
		return beneficiarioCliente;
	}


}
