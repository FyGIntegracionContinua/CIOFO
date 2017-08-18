/**
 * Tensegrity - 2011
 */
package utilitario.mensajes.comun;


/**
 * The Class DomicilioOV.
 *
 * @author Juan Moreno
 * Encapsula los datos del domicilio de un client de finsol...
 * <ul>
 * 	<li>Calle y numero</li>
 * 	<li>Entidad</li>
 * 	<li>Municipio / Delegaci&oacute;n</li>
 * 	<li>Localidad</li>
 * 	<li>Colonia</li>
 * 	<li>C&oacute;digo postal</li>
 * 	<li>Telefono de casa</li>
 * 	<li>Lada telefonica del telefono de casa</li>
 * 	<li>Tiempo de habitar la vivienda</li>
 * 	<li>Tipo de Vivienda</li>
 * 	<li>Dias de Localizacion en la vivienda</li>
 * 	<li>Horario Inicial de localizacion en vivienda</li>
 * 	<li>Horario Final de localizacion de vivieda</li>
 * </ul>
 */
public final class DomicilioOV extends ObjetoValor {

	/**
	 * Instancia una nueva domicilio ov.
	 */
	public DomicilioOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The pais. */
	private String pais;							//F.COUNTRY

	/** The calle. */
	private String calle;							//STREET    ||  ADD.OF.MEETING

	/** The municipio. */
	private String municipio;						//F.MUNICIPALITY  ||  CITY.MUNCIPLITY
//	private String codigoColonia;					//NEIGHB.CODE
	/** The colonia. */
private String colonia;							//NEIGHB.NAME ||  SUBURB.TOWN

	/** The cp. */
	private Integer cp;								//F.POSTAL.CODE || ZIP-POSTAL.CODE

	/** The entidad. */
	private String entidad;			//F.STATE  || PROVINCE.STATE -- Mapear con tabla estados ya que se guarda la clave

	/** The localidad. */
	private String localidad;						//F.LOCALITY	-- Se guardara la clave, mapear
	//private String	telefono;
	//private String	lada;
	//private String	tiempo_residencia;
	//private String	tipo;
	//private String	dias;
	//private String	horario_inicial;
	//private String	horario_final;


	/**
	 * Obtiene pais.
	 *
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * Obtiene localidad.
	 *
	 * @return the localidad
	 */
	public String getLocalidad() {
		return localidad;
	}

	/**
	 * Establece localidad.
	 *
	 * @param localidad the localidad to set
	 */
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	/**
	 * Establece pais.
	 *
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * Obtiene calle.
	 *
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Establece calle.
	 *
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * Obtiene municipio.
	 *
	 * @return the municipio
	 */
	public String getMunicipio() {
		return municipio;
	}

	/**
	 * Establece municipio.
	 *
	 * @param municipio the municipio to set
	 */
	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	/**
	 * Obtiene colonia.
	 *
	 * @return the codigoColonia
	 *
	 * 	public String getCodigoColonia() {
	 * 		return codigoColonia;
	 * 	}
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * Establece colonia.
	 *
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * Obtiene cp.
	 *
	 * @return the cp
	 */
	public Integer getCp() {
		return cp;
	}

	/**
	 * Establece cp.
	 *
	 * @param cp the cp to set
	 */
	public void setCp(Integer cp) {
		this.cp = cp;
	}

	/**
	 * Obtiene entidad.
	 *
	 * @return the entidad
	 */
	public String getEntidad() {
		return entidad;
	}

	/**
	 * Establece entidad.
	 *
	 * @param entidad the entidad to set
	 */
	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}


}
