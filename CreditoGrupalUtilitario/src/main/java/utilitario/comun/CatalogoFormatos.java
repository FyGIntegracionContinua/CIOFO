package utilitario.comun;

import java.util.ArrayList;

/**
 * catalogo de tipos de fromatos
 * @author rmontellano
 * @version 4.10
 */
public enum CatalogoFormatos {
    /**Certificación de Domicilios Particulares y/o Negocio*/
	CDPN("CDPN", "Certificación de Domicilios Particulares y/o Negocio"),
	/**Solicitud Credito Solidario"*/
	SOCS("SOCS", "Solicitud Credito Solidario"),
	/**Solicitud Crédito Comunal*/
	SOCC("SOCC", "Solicitud Crédito Comunal"),
	/**Información de Solicitante*/
	INSO("INSO",  "Información de Solicitante"),
	/**Acta de Instalación de Mesa Directiva y Reglamento Interno*/
	AIMD("AIMD", "Acta de Instalación de Mesa Directiva y Reglamento Interno"),
	/**Solicitud Crédito Oportunidad*/
	SOCO("SOCO", "Solicitud Crédito Oportunidad"),
	/**Comformidad de Oportunidad*/
	COOP("COOP", "Comformidad de Oportunidad"),
	
	/**Comformidad de Oportunidad*/
	COMU("COMN", "Producto COMUNAL"),
	
	/**Comformidad de Oportunidad*/
	SOLI("SOLN", "Producto SOLIDARIO"),
	
	/**Comformidad de Oportunidad*/
	OPOR("OPON", "Producto OPORTUNIDAD");

	/** Contiene las siglas de los formatos*/
	private String siglas;
	/**descripcion d elos formatos*/
	private String descripcion;

	/**
	 * contructor del catalogo de formatos
	 * @param sigla siglas
	 * @param descrip  descripcion
	 */
	private CatalogoFormatos(String sigla, String descrip) {
		siglas = sigla;
		descripcion = descrip;
	}

	/**
	 * @return the siglas
	 */
	public String getSiglas() {
		return siglas;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * regresar un array de las siglas del enum.
	 * @return ArrayList<String> de las siglas
	 */
	public static ArrayList<String> obtenerListaSiglas() {
		CatalogoFormatos[] catalogo = CatalogoFormatos.values();
		ArrayList<String> listSiglas = new ArrayList<String>();
		for (CatalogoFormatos catalogoFormatos : catalogo) {
			listSiglas.add(catalogoFormatos.getSiglas());
		}
		return listSiglas;
	}

}
