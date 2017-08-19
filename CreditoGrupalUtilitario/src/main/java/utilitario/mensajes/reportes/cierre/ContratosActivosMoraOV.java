package utilitario.mensajes.reportes.cierre;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * The Class ContratosActivosMoraOV.
 */
public class ContratosActivosMoraOV implements Serializable {

	/**
	 * Instancia una nueva contratos activos mora ov.
	 */
	public ContratosActivosMoraOV() { }
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Mapeo de los campos de la DB para el reporte de contratos activos con saldo a favor. */
	private String 	 	contrato;			  //

    /** The num grupo. */
    private String 	 	numGrupo; 			  //

    /** The producto. */
    private String 	 	producto;			  //

    /** The primer dia mora. */
    private String 	 	primerDiaMora;	      //

    /** The fecha actual reporte. */
    private String 	 	fechaActualReporte;   //

    /** The dias mora. */
    private Integer	 	diasMora;			  //

    /** The capital en mora. */
    private Double 	 	capitalEnMora;		  //

    /** The saldo periodo. */
    private Double 	 	saldoPeriodo;		  //

    /** The saldo iva periodo. */
    private Double	 	saldoIVAPeriodo;	  //

    /** The interes en mora. */
    private Double	 	interesEnMora;		  //

    /** The mora total. */
    private BigDecimal 	moraTotal;			  //

    /** The saldo moratorios. */
    private Double	 	saldoMoratorios;	  //

    /** The saldo iva moratorios. */
    private Double 	 	saldoIVAMoratorios;  //

    /** The recargos. */
    private Double 	 	recargos;			  //

    /** The nombre sucursal. */
    private String 	 	nombreSucursal;		  //

    /** The plazo. */
    private Integer	 	plazo;				  //

    /** The tasa. */
    private Double	 	tasa;				  //

    /** The fecha fin. */
    private String 	 	fechaFin;			  //

    /** The asesor. */
    private String	 	asesor;				  //

    /** The nombre asesor. */
    private String	 	nombreAsesor;		  //

    /** The nombre grupo. */
    private String	 	nombreGrupo; 		  //

    /** The num miembros. */
    private Integer  	numMiembros;		  //

    /** The iva. */
    private Double		iva;

    /** The clave t24. */
    private String   	claveT24;


    /**
     * Metodo que agrega el contenido de los campos a un StringBuffer y los separa con ","
     * para generar un encabezado CVS.
     *
     * @param fecha the fecha
     * @return the string buffer
     */
    public StringBuffer toStringCSV( Date fecha ) {
    	Double tasaConIVA 			= null;
    	StringBuffer respuesta 		= new StringBuffer();
    	SimpleDateFormat formatter 	= new SimpleDateFormat("dd/MM/yyyy");
    	final String COMA = ",";

    	//llenar el string buffer
    	respuesta.append(this.contrato	!= null ? this.contrato : "");
    	respuesta.append(COMA);
    	respuesta.append(this.numGrupo	!= null ? this.numGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.producto 	!= null ? this.producto : "");
    	respuesta.append(COMA);
    	respuesta.append(this.primerDiaMora	!= null ? this.primerDiaMora : "");
    	respuesta.append(COMA);
    	respuesta.append( fecha	!= null ? formatter.format(fecha) : "Fecha Invalida"); //fechaActualReporte
    	respuesta.append(COMA);
    	respuesta.append(this.diasMora				!= null ? this.diasMora.intValue() : 0);
    	respuesta.append(COMA);
    	respuesta.append(this.capitalEnMora			!= null ? this.capitalEnMora.doubleValue() : 0.0d );
    	respuesta.append(COMA);
    		this.saldoPeriodo 	= this.saldoPeriodo != null ? this.saldoPeriodo : 0.0d;
    		this.saldoIVAPeriodo = this.saldoIVAPeriodo 	!= null ? this.saldoIVAPeriodo : 0.0d;
    		this.interesEnMora 						= this.saldoPeriodo + this.saldoIVAPeriodo;
    	respuesta.append( this.interesEnMora.doubleValue() );
    	respuesta.append(COMA);
    		this.interesEnMora 	= this.interesEnMora 	 != null ? this.interesEnMora : 0.0d;
    		this.moraTotal 	= new BigDecimal( this.interesEnMora.doubleValue() ).add(
    				new BigDecimal( this.capitalEnMora.doubleValue() ) );
    	respuesta.append( this.moraTotal );
    	respuesta.append(COMA);
    		this.saldoMoratorios = this.saldoMoratorios != null ? this.saldoMoratorios : 0.0d;
    		this.saldoIVAMoratorios	= this.saldoIVAMoratorios != null ? this.saldoIVAMoratorios : 0.0d;
    		this.recargos = this.saldoMoratorios + this.saldoIVAMoratorios;
    	respuesta.append( this.recargos.doubleValue() );
    	respuesta.append(COMA);
    	respuesta.append(this.nombreSucursal		!= null ? this.nombreSucursal : "");
    	respuesta.append(COMA);
    	respuesta.append(this.plazo					!= null ? this.plazo.intValue() : 0);
    	respuesta.append(COMA);
    		this.tasa 								 = this.tasa != null ? this.tasa : 0.0d;
			this.iva = this.iva  != null ? this.iva : 0.0d;
			tasaConIVA = this.tasa + ( this.tasa.doubleValue() * (this.iva.doubleValue() / 100.0d) );
		respuesta.append( tasaConIVA.doubleValue() * 12.0d ); //tasa anual
    	respuesta.append(COMA);
    	respuesta.append(this.fechaFin				!= null ?  this.fechaFin : "");
    	respuesta.append(COMA);
    	respuesta.append(this.asesor				!= null ? this.asesor : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreAsesor			!= null ? this.nombreAsesor : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreGrupo			!= null ? this.nombreGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.numMiembros			!= null ? this.numMiembros.intValue() : 0);

    	respuesta.append( "\n" );

    	return respuesta;
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
	 * Obtiene primer dia mora.
	 *
	 * @return the primerDiaMora
	 */
	public String getPrimerDiaMora() {
		return primerDiaMora;
	}


	/**
	 * Establece primer dia mora.
	 *
	 * @param primerDiaMora the primerDiaMora to set
	 */
	public void setPrimerDiaMora(String primerDiaMora) {
		this.primerDiaMora = primerDiaMora;
	}


	/**
	 * Obtiene fecha actual reporte.
	 *
	 * @return the fechaActualReporte
	 */
	public String getFechaActualReporte() {
		return fechaActualReporte;
	}

	/**
	 * Obtiene dias mora.
	 *
	 * @return the diasMora
	 */
	public Integer getDiasMora() {
		return diasMora;
	}


	/**
	 * Establece dias mora.
	 *
	 * @param diasMora the diasMora to set
	 */
	public void setDiasMora(Integer diasMora) {
		this.diasMora = diasMora;
	}


	/**
	 * Obtiene capital en mora.
	 *
	 * @return the capitalEnMora
	 */
	public Double getCapitalEnMora() {
		return capitalEnMora;
	}


	/**
	 * Establece capital en mora.
	 *
	 * @param capitalEnMora the capitalEnMora to set
	 */
	public void setCapitalEnMora(Double capitalEnMora) {
		this.capitalEnMora = capitalEnMora;
	}


	/**
	 * Obtiene interes en mora.
	 *
	 * @return the interesEnMora
	 */
	public Double getInteresEnMora() {
		return interesEnMora;
	}


	/**
	 * Establece interes en mora.
	 *
	 * @param interesEnMora the interesEnMora to set
	 */
	public void setInteresEnMora(Double interesEnMora) {
		this.interesEnMora = interesEnMora;
	}


	/**
	 * Obtiene mora total.
	 *
	 * @return the moraTotal
	 */
	public BigDecimal getMoraTotal() {
		return moraTotal;
	}


	/**
	 * Establece mora total.
	 *
	 * @param moraTotal the moraTotal to set
	 */
	public void setMoraTotal(BigDecimal moraTotal) {
		this.moraTotal = moraTotal;
	}


	/**
	 * Obtiene recargos.
	 *
	 * @return the recargos
	 */
	public Double getRecargos() {
		return recargos;
	}


	/**
	 * Establece recargos.
	 *
	 * @param recargos the recargos to set
	 */
	public void setRecargos(Double recargos) {
		this.recargos = recargos;
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
	 * Obtiene plazo.
	 *
	 * @return the plazo
	 */
	public Integer getPlazo() {
		return plazo;
	}


	/**
	 * Establece plazo.
	 *
	 * @param plazo the plazo to set
	 */
	public void setPlazo(Integer plazo) {
		this.plazo = plazo;
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
	 * Obtiene num miembros.
	 *
	 * @return the numMiembros
	 */
	public Integer getNumMiembros() {
		return numMiembros;
	}


	/**
	 * Establece num miembros.
	 *
	 * @param numMiembros the numMiembros to set
	 */
	public void setNumMiembros(Integer numMiembros) {
		this.numMiembros = numMiembros;
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
	 * Establece saldo periodo.
	 *
	 * @param saldoPeriodo the saldoPeriodo to set
	 */
	public void setSaldoPeriodo(Double saldoPeriodo) {
		this.saldoPeriodo = saldoPeriodo;
	}

	/**
	 * Obtiene saldo periodo.
	 *
	 * @return the saldoPeriodo
	 */
	public Double getSaldoPeriodo() {
		return saldoPeriodo;
	}

	/**
	 * Establece saldo iva periodo.
	 *
	 * @param saldoIVAPeriodo the saldoIVAPeriodo to set
	 */
	public void setSaldoIVAPeriodo(Double saldoIVAPeriodo) {
		this.saldoIVAPeriodo = saldoIVAPeriodo;
	}

	/**
	 * Obtiene saldo iva periodo.
	 *
	 * @return the saldoIVAPeriodo
	 */
	public Double getSaldoIVAPeriodo() {
		return saldoIVAPeriodo;
	}

	/**
	 * Establece saldo moratorios.
	 *
	 * @param saldoMoratorios the saldoMoratorios to set
	 */
	public void setSaldoMoratorios(Double saldoMoratorios) {
		this.saldoMoratorios = saldoMoratorios;
	}

	/**
	 * Obtiene saldo moratorios.
	 *
	 * @return the saldoMoratorios
	 */
	public Double getSaldoMoratorios() {
		return saldoMoratorios;
	}

	/**
	 * Establece saldo iva moratorios.
	 *
	 * @param saldoIVAMoratorios the saldoIVAMoratorios to set
	 */
	public void setSaldoIVAMoratorios(Double saldoIVAMoratorios) {
		this.saldoIVAMoratorios = saldoIVAMoratorios;
	}

	/**
	 * Obtiene saldo iva moratorios.
	 *
	 * @return the saldoIVAMoratorios
	 */
	public Double getSaldoIVAMoratorios() {
		return saldoIVAMoratorios;
	}

	/**
	 * Obtiene iva.
	 *
	 * @return the iva
	 */
	public Double getIva() {
		return iva;
	}

	/**
	 * Establece iva.
	 *
	 * @param iva the iva to set
	 */
	public void setIva(Double iva) {
		this.iva = iva;
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
