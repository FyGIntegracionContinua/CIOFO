package tarea.comun;

import java.util.Properties;

import utilitario.log.LogHandler;

/**
 * @author out_mreyes
 *
 */
public class ReadProperties
	{
	/** properties	 */
	private java.util.Properties 	properties;
	/** configFile	 */
//	private static final java.lang.String configFile = "config.properties";
	/** codesFile	 */
	private static final java.lang.String codesFile  = "codes.properties";
	/** reportFile	 */
	private static final java.lang.String reportFile = "reportes.properties";
	/** configuracion	 */
//	public static final ReadProperties configuracion;
	/** mensajes	 */
	public static final ReadProperties mensajes;
	/** reportes	 */
	public static final ReadProperties reportes;

	static
		{
//		configuracion = new ReadProperties( configFile );
		mensajes      = new ReadProperties( codesFile  );
		reportes	  = new ReadProperties( reportFile );
		}

	//Constructor privado
	/**
	 * @param pathFile archivo
	 */
	private ReadProperties( java.lang.String pathFile )
		{
		try	{
			properties = new Properties();
			properties.load( ReadProperties.class.getResourceAsStream( pathFile ) );
			}
		catch ( java.io.IOException ioException ) {
			LogHandler.error(null , getClass(), "Error al cargar el archivo de propiedades", ioException);
			}
		}

	/**
	 * Funcion para obtener la propiedad deseada a partir de una cl�ave
	 * @param claveProp valor que sirve para buscar la propiedad adecuada
	 * @return la propiedad de la clave
	 */
	public java.lang.String getProp( java.lang.String claveProp )
		{
		return claveProp != null ? this.properties.getProperty( claveProp ) : "";
		}

	/**
	 * @return el archivo de configuracion
	 */
	/*public java.lang.String getConfigFilePath( )
		{
		return configFile;
		}*/

	/**
	 * @return el archivo de configuracion
	 */
	public java.lang.String getCodesFilePath( )
		{
		return codesFile;
		}

	/**
	 * @return el archivo de configuracion
	 */
	public java.lang.String getReportFilePath( )
	{
	return reportFile;
	}
}
