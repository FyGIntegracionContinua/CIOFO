package utilitario.mensajes.reportes.cierre;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DesembolsoRepaymentsOV.
 */
public class DesembolsoRepaymentsOV implements Serializable {

	/**
	 * Instancia una nueva desembolso repayments ov.
	 */
	public DesembolsoRepaymentsOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Mapeo de los campos de la DB para el reporte de contratos activos con saldo a favor. */
	private String 	 numContrato; 			//

    /** The num sucursal. */
    private Integer	 numSucursal;			//

    /** The nombre sucursal. */
    private String 	 nombreSucursal;	    //

    /** The monto pago. */
    private String 	 montoPago; 	 		//


    /**
     * Metodo que agrega el contenido de los campos a un StringBuffer y los separa con ","
     * para generar un encabezado CVS.
     *
     * @param fechaCierre the fecha cierre
     * @return the string buffer
     */
    public StringBuffer toStringCSV( Date fechaCierre ) {
    	StringBuffer respuesta 	= new StringBuffer();
    	final String COMA 		= ",";
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

    	//llenar el string buffer
    	respuesta.append(fechaCierre 			!= null ? sdf.format( fechaCierre ) : "Fecha Invalida" ); //fecha de pago
    	respuesta.append(COMA);
    	respuesta.append(this.numContrato		!= null ? this.numContrato : "");
    	respuesta.append(COMA);
    	respuesta.append(this.numSucursal		!= null ? this.numSucursal 	  : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreSucursal	!= null ? this.nombreSucursal : "");
    	respuesta.append(COMA);
    	respuesta.append(this.montoPago			!= null ? this.montoPago : 0);
    	respuesta.append( "\n" );

    	return respuesta;
    }


	/**
	 * Obtiene num contrato.
	 *
	 * @return the numContrato
	 */
	public String getNumContrato() {
		return numContrato;
	}


	/**
	 * Establece num contrato.
	 *
	 * @param numContrato the numContrato to set
	 */
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}


	/**
	 * Obtiene num sucursal.
	 *
	 * @return the numSucursal
	 */
	public Integer getNumSucursal() {
		return numSucursal;
	}


	/**
	 * Establece num sucursal.
	 *
	 * @param numSucursal the numSucursal to set
	 */
	public void setNumSucursal(Integer numSucursal) {
		this.numSucursal = numSucursal;
	}


	/**
	 * Obtiene nombre sucursal.
	 *
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}


	/**
	 * Establece nombre sucursal.
	 *
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}


	/**
	 * Obtiene monto pago.
	 *
	 * @return the montoPago
	 */
	public String getMontoPago() {
		return montoPago;
	}


	/**
	 * Establece monto pago.
	 *
	 * @param montoPago the montoPago to set
	 */
	public void setMontoPago(String montoPago) {
		this.montoPago = montoPago;
	}


	/**
	 * Obtiene serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
