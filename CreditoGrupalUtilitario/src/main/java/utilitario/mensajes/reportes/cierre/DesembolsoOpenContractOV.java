package utilitario.mensajes.reportes.cierre;

import java.io.Serializable;

/**
 * The Class DesembolsoOpenContractOV.
 */
public class DesembolsoOpenContractOV implements Serializable {

	/**
	 * Instancia una nueva desembolso open contract ov.
	 */
	public DesembolsoOpenContractOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Mapeo de los campos de la DB para el reporte de contratos activos con saldo a favor. */
	private String	numContrato;

	/** The clave t24. */
	private String  claveT24;			//

    /** The nombre grupo. */
    private String	nombreGrupo; 		//

    /** The producto. */
    private String 	producto;			//

    /** The fecha inicio. */
    private String	fechaInicio;		//

    /** The fecha fin. */
    private String 	fechaFin;			//

    /** The monto prestamo. */
    private Double 	montoPrestamo;		//

    /** The monto financiado. */
    private Double 	montoFinanciado;	//

    /** The monto devuelto. */
    private Double  montoDevuelto;

    /** The comision. */
    private int		comision	= 0;	//debe regresar 0 siempre

    /** The monto real. */
    private Double  montoReal;			//

    /** The periodicidad. */
    private String  periodicidad;		//

    /** The tasa. */
    private Double	tasa;	  		    //

    /** The num sucursal. */
    private Integer numSucursal;		//se modifica con el m�todo conversionNumSucursal

    /** The sucursal. */
    private String 	sucursal;			//

    /** The asesor. */
    private String	asesor;				//

    /** The nombre asesor. */
    private String	nombreAsesor;	  	//pendiente

    /** The authorizer. */
    private String 	authorizer;		  	//pendiente

    /** The iva. */
    private Double	iva;

    /** The estatus. */
    private String  estatus;

    /** The contrato. */
	private String	contrato;

    /**
     * M�todo que agrega el contenido de los campos a un StringBuffer y los separa con ","
     * para generar un encabezado CVS.
     *
     * @return the string buffer
     */
    public StringBuffer toStringCSV( ) {
    	Double tasaConIVA		= null;
    	StringBuffer respuesta 	= new StringBuffer();
    	final String COMA 		= ",";

    	//llenar el string buffer
    	respuesta.append(this.numContrato	 		!= null ? this.numContrato : "");
    	respuesta.append(COMA);
    	respuesta.append(this.claveT24				!= null ? this.claveT24 : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreGrupo			!= null ? this.nombreGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.producto 				!= null ? this.producto : "");
    	respuesta.append(COMA);
    	respuesta.append(this.fechaInicio			!= null ? this.fechaInicio : "");
    	respuesta.append(COMA);
    	respuesta.append(this.fechaFin				!= null ?  this.fechaFin : "");
    	respuesta.append(COMA);
    	respuesta.append(this.montoPrestamo			!= null ? this.montoPrestamo.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	respuesta.append(this.montoFinanciado		!= null ? this.montoFinanciado.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	respuesta.append( this.comision );
    	respuesta.append(COMA);
    	respuesta.append(this.montoReal				!= null ? this.montoReal.doubleValue() : 0.0d );
    	respuesta.append(COMA);
    	respuesta.append(this.periodicidad			!= null ? this.periodicidad : "" );
    	respuesta.append(COMA);
    		this.tasa = this.tasa != null ? this.tasa : 0.0d;
    		this.iva = this.iva 	!= null ? this.iva : 0.0d;
    		tasaConIVA = this.tasa + ( this.tasa.doubleValue() * (this.iva.doubleValue() / 100.0d) );
		respuesta.append( tasaConIVA.doubleValue() * 12.0d ); //tasa anual
    	respuesta.append(COMA);
    	respuesta.append(this.numSucursal		!= null ? this.numSucursal 	  : "");
    	respuesta.append(COMA);
    	respuesta.append(this.sucursal				!= null ? this.sucursal : "" );
    	respuesta.append(COMA);
    	respuesta.append(this.asesor				!= null ? this.asesor : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreAsesor			!= null ? this.nombreAsesor : "");
    	respuesta.append(COMA);
    	respuesta.append(this.authorizer			!= null ? this.authorizer : "");

    	respuesta.append( "\n" );

    	return respuesta;
    }

    /**
     * M�todo que reliza una conversi�n al n�mero de cuenta manejado por finsol, quitando
     * el prefijo "12" de todos los contratos y anexandole 3 ceros.
     *
     * @param numSucursal the num sucursal
     * @return the integer
     */
    public Integer conversionNumSucursal(Integer numSucursal) {
    	String original = String.valueOf( numSucursal );
    	String subCadena = original.substring(2); //se quita el 12 de todos los contratos
    	//se concatenan 3 ceros a la cadena
    	subCadena += "000";
    	//se regresa el valor entero de la cadena recien modificada
    	return Integer.parseInt(subCadena);
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
	 * Obtiene fecha inicio.
	 *
	 * @return the fecha_inicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}


	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio a fecha inicio
	 */
	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	/**
	 * Obtiene fecha fin.
	 *
	 * @return the fechaFin
	 */
	public String getFechaFin() {
		return fechaFin;
	}


	/**
	 * Establece fecha fin.
	 *
	 * @param fechaFin the fechaFin to set
	 */
	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	/**
	 * Obtiene monto prestamo.
	 *
	 * @return the montoPrestamo
	 */
	public Double getMontoPrestamo() {
		return montoPrestamo;
	}


	/**
	 * Establece monto prestamo.
	 *
	 * @param montoPrestamo the montoPrestamo to set
	 */
	public void setMontoPrestamo(Double montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}


	/**
	 * Obtiene monto financiado.
	 *
	 * @return the montoFinanciado
	 */
	public Double getMontoFinanciado() {
		return montoFinanciado;
	}


	/**
	 * Establece monto financiado.
	 *
	 * @param montoFinanciado the montoFinanciado to set
	 */
	public void setMontoFinanciado(Double montoFinanciado) {
		this.montoFinanciado = montoFinanciado;
	}


	/**
	 * Obtiene comision.
	 *
	 * @return the comision
	 */
	public int getComision() {
		return comision;
	}

	/**
	 * Obtiene monto real.
	 *
	 * @return the montoReal
	 */
	public Double getMontoReal() {
		return montoReal;
	}


	/**
	 * Establece monto real.
	 *
	 * @param montoReal the montoReal to set
	 */
	public void setMontoReal(Double montoReal) {
		this.montoReal = montoReal;
	}


	/**
	 * Obtiene periodicidad.
	 *
	 * @return the periodicidad
	 */
	public String getPeriodicidad() {
		return periodicidad;
	}


	/**
	 * Establece periodicidad.
	 *
	 * @param periodicidad the periodicidad to set
	 */
	public void setPeriodicidad(String periodicidad) {
		this.periodicidad = periodicidad;
	}


	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public Double getTasa() {
		return tasa;
	}


	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(Double tasa) {
		this.tasa = tasa;
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
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}


	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}


	/**
	 * Obtiene asesor.
	 *
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}


	/**
	 * Establece asesor.
	 *
	 * @param asesor the asesor to set
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
	}


	/**
	 * Obtiene nombre asesor.
	 *
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}


	/**
	 * Establece nombre asesor.
	 *
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}


	/**
	 * Obtiene authorizer.
	 *
	 * @return the authorizer
	 */
	public String getAuthorizer() {
		return authorizer;
	}


	/**
	 * Establece authorizer.
	 *
	 * @param authorizer the authorizer to set
	 */
	public void setAuthorizer(String authorizer) {
		this.authorizer = authorizer;
	}

	/**
	 * Establece iva.
	 *
	 * @param iva a iva
	 */
	public void setIva(Double iva) {
		this.iva = iva;
	}

	/**
	 * Obtiene iva.
	 *
	 * @return iva
	 */
	public Double getIva() {
		return iva;
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
	 * Establece estatus.
	 *
	 * @param estatus a estatus
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * Obtiene estatus.
	 *
	 * @return estatus
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * Obtiene monto devuelto.
	 *
	 * @return monto devuelto
	 */
	public Double getMontoDevuelto() {
		return montoDevuelto;
	}

	/**
	 * Establece monto devuelto.
	 *
	 * @param montoDevuelto a monto devuelto
	 */
	public void setMontoDevuelto(Double montoDevuelto) {
		this.montoDevuelto = montoDevuelto;
	}

	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

}
