/**
 * 
 */
package tarea.comun;

import org.osoa.sca.annotations.Scope;

import utilitario.log.LogHandler;


/**
 *
 */
@Scope("COMPOSITE")
public 	class 		InicializacionCIOF
		implements 	java.lang.Runnable
	{
	
	public void run()
		{
		try
			{
			//LogHandler.info("0000000000", getClass(), "///////////// " + getClass().getClassLoader().getResource( "" ).getPath());
			//Consulta para validacion de conexion
			//AsesorData.obtenAsesor( "uid-inicial" , "0" );
			}
		catch( Exception exception )
			{
			LogHandler.error("uid-inicial", getClass(), "Error de inicialización", exception );
			}
		}
	}
