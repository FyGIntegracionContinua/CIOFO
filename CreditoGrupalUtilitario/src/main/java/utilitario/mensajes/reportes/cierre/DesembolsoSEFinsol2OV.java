package utilitario.mensajes.reportes.cierre;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class DesembolsoSEFinsol2OV.
 */
public class DesembolsoSEFinsol2OV implements Serializable {

	/**
	 * Instancia una nueva desembolso se finsol2 ov.
	 */
	public DesembolsoSEFinsol2OV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Mapeo de los campos de la DB para el reporte de contratos activos con saldo a favor. */
	private String 	 numContrato;		//

	/** The producto. */
	private String 	 producto;			//

    /** The num grupo. */
    private String 	 numGrupo;  		//

    /** The nombre grupo. */
    private String	 nombreGrupo; 		//

    /** The pagado capital. */
    private Double 	 pagadoCapital;		//

    /** The pagado interes. */
    private Double 	 pagadoInteres;		//

    /** The pagado recargos. */
    private Double	 pagadoRecargos;	//

    /** The codigo sucursal. */
    private Integer	 codigoSucursal;	//

    /** The nombre sucursal. */
    private String 	 nombreSucursal;	//

    /** The clave t24. */
    private	String 	 claveT24;

    /** The contrato. */
    private String 	 contrato;

    /**
     * M�todo que agrega el contenido de los campos a un StringBuffer y los separa con ","
     * para generar un encabezado CVS.
     *
     * @param fechaCierre the fecha cierre
     * @return the string buffer
     */
    public StringBuffer toStringCSV( Date fechaCierre ) {
    	StringBuffer respuesta 		= new StringBuffer();
    	final String coma = ",";
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    	//llenar el string buffer
    	respuesta.append(this.numContrato	 	!= null ? this.numContrato : "");
    	respuesta.append(coma);
    	respuesta.append(this.producto 			!= null ? this.producto : "");
    	respuesta.append(coma);
    	respuesta.append(fechaCierre			!= null ? sdf.format(fechaCierre) : "Fecha Inv�lida"); //Dia Pago
    	respuesta.append(coma);
    	respuesta.append(this.numGrupo			!= null ? this.numGrupo : "");
    	respuesta.append(coma);
    	respuesta.append(this.nombreGrupo		!= null ? this.nombreGrupo : "");
    	respuesta.append(coma);
    	respuesta.append(this.pagadoCapital		!= null ? this.pagadoCapital.doubleValue() : 0.0d);
    	respuesta.append(coma);
    	respuesta.append(this.pagadoInteres		!= null ? this.pagadoInteres.doubleValue() : 0.0d );
    	respuesta.append(coma);
    	respuesta.append(this.pagadoRecargos	!= null ? this.pagadoRecargos.doubleValue() : 0.0d );
    	respuesta.append(coma);
    		this.pagadoCapital = this.pagadoCapital 	!= null ? this.pagadoCapital : 0.0d;
    		this.pagadoInteres = this.pagadoInteres 	!= null ? this.pagadoInteres : 0.0d;
    		this.pagadoRecargos = this.pagadoRecargos 	!= null ? this.pagadoRecargos : 0.0d;
       	respuesta.append(this.pagadoCapital.doubleValue() + this.pagadoInteres.doubleValue()
       			+ this.pagadoRecargos.doubleValue() ); //Abono
    	respuesta.append(coma);
    	respuesta.append(this.codigoSucursal	!= null ? this.codigoSucursal 	  : "");
    	respuesta.append(coma);
    	respuesta.append(this.nombreSucursal	!= null ? this.nombreSucursal : "");

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
	 * Obtiene pagado capital.
	 *
	 * @return the pagadoCapital
	 */
	public Double getPagadoCapital() {
		return pagadoCapital;
	}

	/**
	 * Establece pagado capital.
	 *
	 * @param pagadoCapital the pagadoCapital to set
	 */
	public void setPagadoCapital(Double pagadoCapital) {
		this.pagadoCapital = pagadoCapital;
	}

	/**
	 * Obtiene pagado interes.
	 *
	 * @return the pagadoInteres
	 */
	public Double getPagadoInteres() {
		return pagadoInteres;
	}

	/**
	 * Establece pagado interes.
	 *
	 * @param pagadoInteres the pagadoInteres to set
	 */
	public void setPagadoInteres(Double pagadoInteres) {
		this.pagadoInteres = pagadoInteres;
	}

	/**
	 * Obtiene pagado recargos.
	 *
	 * @return the pagadoRecargos
	 */
	public Double getPagadoRecargos() {
		return pagadoRecargos;
	}

	/**
	 * Establece pagado recargos.
	 *
	 * @param pagadoRecargos the pagadoRecargos to set
	 */
	public void setPagadoRecargos(Double pagadoRecargos) {
		this.pagadoRecargos = pagadoRecargos;
	}

	/**
	 * Obtiene codigo sucursal.
	 *
	 * @return the codigoSucursal
	 */
	public Integer getCodigoSucursal() {
		return codigoSucursal;
	}

	/**
	 * Establece codigo sucursal.
	 *
	 * @param codigoSucursal the codigoSucursal to set
	 */
	public void setCodigoSucursal(Integer codigoSucursal) {
		this.codigoSucursal = codigoSucursal;
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

}
