/**
 *
 */
package tarea.transferir;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import utilitario.log.LogHandler;

/**
 * @author out_jcmoreno
 *
 */
public 	class 		TransferenciaDatosFtpImpl
		implements 	TransferenciaDatosFtp
	{


	public void transfiereDatos(String fileName, InputStream data )
		{
		try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            byte buffer[] = new byte[1024];
            for (int count; (count = data.read( buffer, 0, buffer.length ) ) > 0;) {
                stream.write(buffer, 0, count);
            	}
         	}
        catch ( java.lang.Exception exception )
        	{
            LogHandler.error(fileName, getClass(), "Ocurrio un error en el componente FTP de transferencia de datos.", exception);
        	}
		}

	}
