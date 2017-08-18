/**
 *
 */
package utilitario.mensajes.burocredito;

import java.util.Date;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class BuroCreditoClienteGrupoPeticion.
 *
 * @author out_ltorres
 */
public class BuroCreditoClienteGrupoPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva buro credito cliente grupo peticion.
	 */
	public BuroCreditoClienteGrupoPeticion() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -829988057180519042L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The persona. */
	private String persona;

	/** The fecha. */
	private Date fecha;

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
	 * Obtiene persona.
	 *
	 * @return persona
	 */
	public String getPersona() {
		return persona;
	}

	/**
	 * Establece persona.
	 *
	 * @param persona a persona
	 */
	public void setPersona(String persona) {
		this.persona = persona;
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
	 * Establece fecha.
	 *
	 * @param fecha a fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

}
