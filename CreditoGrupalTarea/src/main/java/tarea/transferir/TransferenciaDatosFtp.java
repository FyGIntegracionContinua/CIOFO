/**
 * 
 */
package tarea.transferir;

import java.io.InputStream;


/**
 * @author out_jcmoreno
 *
 */
public interface TransferenciaDatosFtp {

	/**
	 * Se utiliza para realizar la transferencia de archivos via ftp, a traves de Fabric3
	 * @param fileName
	 * @param data
	 */
	public void transfiereDatos( String fileName, InputStream data);
	}
