package utilitario.mensajes.reportes.cierre;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * The Class ContratosActivosSaldoFavorOV.
 */
public class ContratosActivosSaldoFavorOV implements Serializable {

	/**
	 * Instancia una nueva contratos activos saldo favor ov.
	 */
	public ContratosActivosSaldoFavorOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Mapeo de los campos de la DB para el reporte de contratos activos con saldo a favor. */
	private String 	 contrato;				  //

    /** The num grupo. */
    private String 	 numGrupo; 				  //

    /** The nombre grupo. */
    private String 	 nombreGrupo;	          //

    /** The producto. */
    private String 	 producto;				  //

    /** The saldo. */
    private Double 	 saldo;					  //

    /** The fecha apertura. */
    private String 	 fechaApertura;			  //

    /** The num sucursal. */
    private Integer	 numSucursal;			  //

    /** The nombre sucursal. */
    private String 	 nombreSucursal;		  //

    /** The fecha ultimo mov credito. */
    private String 	 fechaUltimoMovCredito;   //

    /** The clave t24. */
    private String 	 claveT24;



    /**
     * Metodo que agrega el contenido de los campos a un StringBuffer y los separa con ","
     * para generar un encabezado CVS.
     *
     * @return the string buffer
     */
    public StringBuffer toStringCSV() {
    	StringBuffer respuesta 		= new StringBuffer();
    	NumberFormat formatoNum 	= new DecimalFormat(".00");
    	final String COMA = ",";

    	//llenar el string buffer
    	respuesta.append(this.contrato	 			!= null ? this.contrato : "");
    	respuesta.append(COMA);
    	respuesta.append(this.numGrupo				!= null ? this.numGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreGrupo			!= null ? this.nombreGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.producto 				!= null ? this.producto : "");
    	respuesta.append(COMA);
    	respuesta.append(this.saldo	!= null ? formatoNum.format( this.saldo.doubleValue() ) : 0.0d );
    	respuesta.append(COMA);
    	respuesta.append(this.fechaApertura			!= null ? this.fechaApertura : "");
    	respuesta.append(COMA);
    	respuesta.append(this.numSucursal			!= null ? this.numSucursal.intValue() : 0);
    	respuesta.append(COMA);
    	respuesta.append(this.nombreSucursal		!= null ? this.nombreSucursal : "" );
    	respuesta.append(COMA);
    	respuesta.append(this.fechaUltimoMovCredito	!= null ? this.fechaUltimoMovCredito : "");
    	respuesta.append( "\n" );

    	return respuesta;
    }

    //GETTERS & SETTERS
    /**
     * Obtiene contrato.
     *
     * @return the contrato
     */
	public String getContrato() {
		return contrato;
	}


	/**
	 * Establece contrato.
	 *
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}


	/**
	 * Obtiene num grupo.
	 *
	 * @return the numGrupo
	 */
	public String getNumGrupo() {
		return numGrupo;
	}


	/**
	 * Establece num grupo.
	 *
	 * @param numGrupo the numGrupo to set
	 */
	public void setNumGrupo(String numGrupo) {
		this.numGrupo = numGrupo;
	}


	/**
	 * Obtiene nombre grupo.
	 *
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}


	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}


	/**
	 * Obtiene producto.
	 *
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}


	/**
	 * Establece producto.
	 *
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}


	/**
	 * Obtiene saldo.
	 *
	 * @return the saldo
	 */
	public Double getSaldo() {
		return saldo;
	}


	/**
	 * Establece saldo.
	 *
	 * @param saldo the saldo to set
	 */
	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}


	/**
	 * Obtiene fecha apertura.
	 *
	 * @return the fechaApertura
	 */
	public String getFechaApertura() {
		return fechaApertura;
	}


	/**
	 * Establece fecha apertura.
	 *
	 * @param fechaApertura the fechaApertura to set
	 */
	public void setFechaApertura(String fechaApertura) {
		this.fechaApertura = fechaApertura;
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
	 * Obtiene fecha ultimo mov credito.
	 *
	 * @return the fechaUltimoMovCredito
	 */
	public String getFechaUltimoMovCredito() {
		return fechaUltimoMovCredito;
	}


	/**
	 * Establece fecha ultimo mov credito.
	 *
	 * @param fechaUltimoMovCredito the fechaUltimoMovCredito to set
	 */
	public void setFechaUltimoMovCredito(String fechaUltimoMovCredito) {
		this.fechaUltimoMovCredito = fechaUltimoMovCredito;
	}


	/**
	 * Obtiene serialversionuid.
	 *
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * Establece clave t24.
	 *
	 * @param claveT24 a clave t24
	 */
	public void setClaveT24(String claveT24) {
		this.claveT24 = claveT24;
	}

	/**
	 * Obtiene clave t24.
	 *
	 * @return clave t24
	 */
	public String getClaveT24() {
		return claveT24;
	}
}
