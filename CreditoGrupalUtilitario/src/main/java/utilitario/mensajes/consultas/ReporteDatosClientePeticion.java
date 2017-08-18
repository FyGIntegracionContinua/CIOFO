package utilitario.mensajes.consultas;

/**
 * The Class ReporteDatosClientePeticion.
 */
public class ReporteDatosClientePeticion implements	java.io.Serializable {

	/**
	 * ReporteDatosClientePeticion.
	 */
	public ReporteDatosClientePeticion() {

	}

	/** UID para la serializacion. */
	private static final long serialVersionUID = 8894628822268863908L;

	/**
	 * apellidoMat java.lang.String
	 */
	private java.lang.String    apellidoMat;
	/**
	 * apellidoPat java.lang.String
	 */
	private java.lang.String    apellidoPat;
	/**
	 * nombre java.lang.String
	 */
	private java.lang.String    nombre;
	/**
	 * nombreGrupo java.lang.String
	 */
	private java.lang.String	nombreGrupo;			//Cadena que puede contener el nombre de grupos
	/**
	 * sucursal java.lang.Integer
	 */
	private java.lang.Integer	sucursal;		//Numero de una sucursal especifica

	/**
	 * Establece apellido mat.
	 *
	 * @param apellidoMat .
	 */
	public void setApellidoMat(java.lang.String apellidoMat) {
		this.apellidoMat = apellidoMat;
	}

	/**
	 * Obtiene apellido mat.
	 *
	 * @return .
	 */
	public java.lang.String getApellidoMat() {
		return apellidoMat;
	}

	/**
	 * Establece apellido pat.
	 *
	 * @param apellidoPat .
	 */
	public void setApellidoPat(java.lang.String apellidoPat) {
		this.apellidoPat = apellidoPat;
	}

	/**
	 * Obtiene apellido pat.
	 *
	 * @return .
	 */
	public java.lang.String getApellidoPat() {
		return apellidoPat;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre .
	 */
	public void setNombre(java.lang.String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return .
	 */
	public java.lang.String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return .
	 */
	public java.lang.String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo .
	 */
	public void setNombreGrupo(java.lang.String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return .
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal .
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return 	"[ apellidoMat = " 	+ apellidoMat
				+ ", apellidoPat = " 	+ apellidoPat
				+ ", nombre = "		+ nombre
				+ ", nombreGrupo = "	+ nombreGrupo
				+ ", sucursal = "		+ sucursal		+	" ]";
		}
	}
