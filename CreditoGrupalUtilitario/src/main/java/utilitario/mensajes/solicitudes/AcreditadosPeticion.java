/**
 *
 */
package utilitario.mensajes.solicitudes;

import utilitario.mensajes.comun.EncabezadoPeticion;
import utilitario.mensajes.comun.ObjetoValor;

/**
 * The Class AcreditadosPeticion.
 *
 * @author out_ltorres
 */
public class AcreditadosPeticion extends ObjetoValor {

	/**
	 * Instancia una nueva acreditados peticion.
	 */
	public AcreditadosPeticion() {
	}

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -154925807775819098L;

	/** The header. */
	private EncabezadoPeticion header;

	/** The p nombre. */
	private String pNombre;

	/** The p a paterno. */
	private String pAPaterno;

	/** The p a materno. */
	private String pAMaterno;

	/** The p a rfc. */
	private String rfc;

	/** The p a fechaNacimiento. */
	private String fechaNacimiento;

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
	 * Obtiene p nombre.
	 *
	 * @return p nombre
	 */
	public String getpNombre() {
		return pNombre;
	}

	/**
	 * Establece p nombre.
	 *
	 * @param pNombre a p nombre
	 */
	public void setpNombre(String pNombre) {
		this.pNombre = pNombre;
	}

	/**
	 * Obtiene p a paterno.
	 *
	 * @return p a paterno
	 */
	public String getpAPaterno() {
		return pAPaterno;
	}

	/**
	 * Establece p a paterno.
	 *
	 * @param pAPaterno a p a paterno
	 */
	public void setpAPaterno(String pAPaterno) {
		this.pAPaterno = pAPaterno;
	}

	/**
	 * Obtiene p a materno.
	 *
	 * @return p a materno
	 */
	public String getpAMaterno() {
		return pAMaterno;
	}

	/**
	 * Establece p a materno.
	 *
	 * @param pAMaterno a p a materno
	 */
	public void setpAMaterno(String pAMaterno) {
		this.pAMaterno = pAMaterno;
	}

	/**
	 * Obtiene p a rfc.
	 *
	 * @return p a rfc
	 */
	public String getRfc() {
        java.util.StringTokenizer tokens = new java.util.StringTokenizer(rfc);
        StringBuilder buff = new StringBuilder();
        while (tokens.hasMoreTokens()) {
            buff.append(" ").append(tokens.nextToken());
        }
		return buff.toString().trim().toUpperCase();
	}

	/**
	 * Establece p a rfc.
	 *
	 * @param rfc a p a rfc
	 */
	public void setRfc(String rfc) {
		this.rfc = rfc;
	}

	/**
	 * Obtiene p a fechaNacimiento.
	 *
	 * @return p a fechaNacimiento
	 */
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * Establece p a fechaNacimiento.
	 *
	 * @param fechaNacimiento a p a fechaNacimiento
	 */
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

}
