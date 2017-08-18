package utilitario.mensajes.reportes.cierre;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.session.SqlSession;

import utilitario.log.LogHandler;

/**
 * The Class CarteraActivaOV.
 */
public class CarteraActivaOV implements Serializable {

	/**
	 * Instancia una nueva cartera activa ov.
	 */
	public CarteraActivaOV() {
	}
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Mapeo de los campos de la DB para el reporte de cartera activa. */
	private String 	 noContrato;					  //contrato_clave_finsol.contrato

	/** The contrato. */
	private String 	 contrato;					  	  //contrato interno de credprod

    /** The no grupo. */
    private String 	 noGrupo; 						  //contratos.cliente

    /** The nombre grupo. */
    private String 	 nombreGrupo;	                  //personas.nombre

    /** The sucursal. */
    private String 	 sucursal;						  //sucursales.nombre

    /** The no sucursal. */
    private String 	 noSucursal;					  //sucursales.nombre

    /** The asesor. */
    private String 	 asesor;  						  //contrato_grupo.asesor

    /** The nombre asesor. */
    private String 	 nombreAsesor;		// --> se extrae desde un web service (propuesto a eliminarse)

    /** The producto. */
    private String 	 producto;						  //productos.descripcion

    /** The fecha inicio. */
    private String 	 fechaInicio;					  //c.fecha_disposicion

    /** The fecha fin. */
    private String 	 fechaFin;					      //c.fecha_esp_liq

    /** The cantidad entregada. */
    private Double 	 cantidadEntregada;				  //c.monto

    /** The intereses. */
    private Double	 intereses;   			  		  //calculado con la funcion calcularIntereses

    /** The total a pagar. */
    private Double 	 totalAPagar;                     //Suma "Cantidad entregada" + "Intereses"

    /** The parcialidad. */
    private Double 	 parcialidad;					  //c.monto_pago

    /** The plazo. */
    private Integer	 plazo;							  //c.no_pagos

    /** The tasa. */
    private Double 	 tasa;							  //c.tasa

    /** The pagado capital. */
    private Double 	 pagadoCapital;					  // -> se obtiene desde un subquery (revisar .xml iBatis)

    /** The pagado intereses. */
    private Double 	 pagadoIntereses;				  // -> se obtiene desde un subquery (revisar .xml iBatis)

    /** The pago parcial. */
    private Double 	 pagoParcial;					  //contrato_grupo.monto_devuelto

    /** The incd. */
    private String 	 incd;							  //"??"Pendiente, se debe calcular

    /** The saldo intereses. */
    private Double 	 saldoIntereses;		//esta pendiente, Resta campo "intereses" - "Pagado Intereses"

    /** The saldo capital. */
    private Double 	 saldoCapital;					  //c.capital_insoluto

    /** The saldo total. */
    private Double 	 saldoTotal;                      //Suma de campo "Saldo Interes" + "Saldo Capital"

    /** The no miembros. */
    private Integer  noMiembros;					  //-> se obtiene desde un query

    /** The fecha esp liq. */
    private String   fechaEspLiq;					  //sirven para comparar y determinar resultado de status

    /** The fecha prox pago. */
    private String	 fechaProxPago;					  //

    /** The iva. */
    private Double   iva;

    /** The status. */
    private String 	 status;					// (su valor depende la funcion calculaValorStatus)

    /** The frec pago. */
    private String	 frecPago;						  // obtiene desde la DB la frecuencia de pago

    /** The clave t24. */
    private String   claveT24;

    /** The fecha contrato. */
    private String	 fechaContrato;					  //fecha_contrato, fecha de creacion del contrato

    /** The interes total. */
    private Double	 interesTotal;

    /** The iva interes total. */
    private Double	 ivaInteresTotal;

    /**
     * M�todo que calcula el valor que debe llevar el campo status de acuerdo a las condiciones
     * especificadas por el usuario.
     *
     * @param fechaCierre the fecha cierre
     * @param fechaEspLiq the fecha esp liq
     * @param fechaProxPago the fecha prox pago
     * @return the string
     */
    public String calculaValorStatus(Date fechaCierre, String fechaEspLiq, String fechaProxPago) {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	String respuesta = "";
    	try {
			Date fechaLiq = sdf.parse(fechaEspLiq);
			Date fechaPago = sdf.parse(fechaProxPago);
			//necesario hacer esto, caso contrario la fecha pasada (fechaCierre) llevara milisegundos
			//dem�s si se intenta comparar con otra id�ntica y arrojar� resultados err�neos.
			String fechaActualTxt = sdf.format(fechaCierre);
			Date fechaActual = sdf.parse(fechaActualTxt);

			if (fechaLiq.compareTo(fechaActual) < 0) {
				respuesta = "VM";
			}
			else if (fechaLiq.compareTo(fechaActual) >= 0 && fechaPago.compareTo(fechaActual) < 0) {
				respuesta = "VE";
			}
			else if (fechaLiq.compareTo(fechaActual) >= 0 || fechaPago.compareTo(fechaActual) >= 0) {
				respuesta = "VI";
			}
			else {
				respuesta = "INDEFINIDO";
			}
		} catch (ParseException e) {
			LogHandler.debug("", getClass(),
					"LAS FECHAS PASADAS AL METODO calculaValorStatus NO SE HAN PARSEADO CORRECTAMENTE");
			e.printStackTrace();
			return "ERROR";
		}
		return respuesta;
    }

    /**
     * M�todo que efect�a el redondeo a dos decimales del valor pasado como argumento.
     *
     * @param valor the valor
     * @return the double
     */
	private double redondeoDosDecimales(Double valor) {
		BigDecimal redondeoIntereses = new BigDecimal( valor );
    		try {
    			redondeoIntereses = redondeoIntereses.setScale(2, RoundingMode.HALF_UP);
    		} catch (Exception e) {
    			LogHandler.debug("", getClass(), "ERROR AL EFECTUAR EL REDONDEO EN ==> CarteraActivaOV");
    			//si arroja excepcion es porque no se necesita redondear el numero
    			e.printStackTrace();
    		}
		return redondeoIntereses.doubleValue();
	}

    /**
     * M�todo que agrega el contenido de los campos a un StringBuffer y los separa con ","
     * para generar un encabezado CVS.
     *
     * @param fechaCierre the fecha cierre
     * @param uid the uid
     * @param sessionNTx the session n tx
     * @return the string buffer
     */
    public StringBuffer toStringCSV( Date fechaCierre, String uid, SqlSession sessionNTx ) {
    	Double tasaConIVA 		= null;
    	StringBuffer respuesta	= new StringBuffer();
    	final String COMA 		= ",";

    	//llenar el string buffer
    	respuesta.append(this.noContrato 			!= null ? this.noContrato : "");
    	respuesta.append(COMA);
    	respuesta.append(this.noGrupo				!= null ? this.noGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreGrupo			!= null ? this.nombreGrupo : "");
    	respuesta.append(COMA);
    	respuesta.append(this.sucursal 				!= null ? this.sucursal : "");
    	respuesta.append(COMA);
    	respuesta.append(this.asesor				!= null ? this.asesor : "");
    	respuesta.append(COMA);
    	respuesta.append(this.nombreAsesor			!= null ? this.nombreAsesor : "");
    	respuesta.append(COMA);
    	respuesta.append(this.producto				!= null ? this.producto : "");
    	respuesta.append(COMA);
    	respuesta.append(this.fechaInicio			!= null ? this.fechaInicio : "");
    	respuesta.append(COMA);
    	respuesta.append(this.fechaFin				!= null ? this.fechaFin : "");
    	respuesta.append(COMA);
    	respuesta.append(this.cantidadEntregada		!= null ? this.cantidadEntregada.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	//intereses
			this.intereses = this.interesTotal + this.ivaInteresTotal;
    	//se escribe el valor de intereses redondeado a dos decimales
    	respuesta.append( redondeoDosDecimales(this.intereses) );
    	respuesta.append(COMA);
    	//total a pagar
    	this.totalAPagar = this.cantidadEntregada	!= null ? this.cantidadEntregada.doubleValue()
    			+ this.intereses.doubleValue() : 0.0;
    	//se escribe el valor del total a pagar redondeado a dos decimales
    	respuesta.append( redondeoDosDecimales(this.totalAPagar) );
    	respuesta.append(COMA);
    	respuesta.append(this.parcialidad != null ? this.parcialidad.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	respuesta.append(this.plazo	!= null ? this.plazo.intValue() : 0);
    	respuesta.append(COMA);
    		this.tasa 	= this.tasa != null ? this.tasa : 0.0d;
    		this.iva 	= this.iva  != null ? this.iva : 0.0d;
    		tasaConIVA = this.tasa.doubleValue() + ( this.tasa.doubleValue() * (this.iva.doubleValue() / 100.0d) );
    	respuesta.append( tasaConIVA.doubleValue() * 12.0d ); //tasa anual
    	respuesta.append(COMA);
    	respuesta.append(this.pagadoCapital 		!= null ? this.pagadoCapital.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	respuesta.append(this.pagadoIntereses		!= null ? this.pagadoIntereses.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    		this.pagadoCapital 		= this.pagadoCapital 	!= null ? this.pagadoCapital : 0.0d;
    		this.pagadoIntereses 	= this.pagadoIntereses 	!= null ? this.pagadoIntereses : 0.0d;
       	//se calcula el campo pagadoTotal
    	respuesta.append( this.pagadoCapital.doubleValue() + this.pagadoIntereses.doubleValue() );
    	respuesta.append(COMA);
    	respuesta.append(this.pagoParcial			!= null ? this.pagoParcial.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	respuesta.append(this.incd					!= null ? this.incd : "");
    	respuesta.append(COMA);
    	//se calcula saldo intereses
    		this.saldoIntereses = this.pagadoIntereses	!= null
    				? this.intereses.doubleValue() - this.pagadoIntereses.doubleValue() : 0.0d;
    	//se escribe el valor de saldo intereses redondeado a dos decimales
    	respuesta.append( redondeoDosDecimales(this.saldoIntereses) );
    	respuesta.append(COMA);
    	respuesta.append(this.saldoCapital			!= null ? this.saldoCapital.doubleValue() : 0.0d);
    	respuesta.append(COMA);
    	//se calcula saldo total
    		this.saldoTotal = this.saldoIntereses + this.saldoCapital;
    	respuesta.append( redondeoDosDecimales(this.saldoTotal) );
    	respuesta.append(COMA);
    	 //se calcula el valor de status
    	this.status = this.fechaEspLiq != null && this.fechaProxPago != null
    			? calculaValorStatus(fechaCierre, this.fechaEspLiq, this.fechaProxPago)
    				: "Fecha Null";
    	respuesta.append( this.status );
    	respuesta.append(COMA);
    	respuesta.append(this.noMiembros			!= null ? this.noMiembros.intValue() : 0);

    	respuesta.append( "\n" );

    	return respuesta;
    }


    /*Getters and Setters*/
    /**
     * Obtiene no contrato.
     *
     * @return the noContrato
     */
	public String getNoContrato() {
		return noContrato;
	}

	/**
	 * Establece no contrato.
	 *
	 * @param noContrato the noContrato to set
	 */
	public void setNoContrato(String noContrato) {
		this.noContrato = noContrato;
	}

	/**
	 * Obtiene no grupo.
	 *
	 * @return the noGrupo
	 */
	public String getNoGrupo() {
		return noGrupo;
	}

	/**
	 * Establece no grupo.
	 *
	 * @param noGrupo the noGrupo to set
	 */
	public void setNoGrupo(String noGrupo) {
		this.noGrupo = noGrupo;
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
	 * @return the fechaInicio
	 */
	public String getFechaInicio() {
		return fechaInicio;
	}

	/**
	 * Establece fecha inicio.
	 *
	 * @param fechaInicio the fechaInicio to set
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
	 * Obtiene cantidad entregada.
	 *
	 * @return the cantidadEntregada
	 */
	public Double getCantidadEntregada() {
		return cantidadEntregada;
	}

	/**
	 * Establece cantidad entregada.
	 *
	 * @param cantidadEntregada the cantidadEntregada to set
	 */
	public void setCantidadEntregada(Double cantidadEntregada) {
		this.cantidadEntregada = cantidadEntregada;
	}

	/**
	 * Obtiene parcialidad.
	 *
	 * @return the parcialidad
	 */
	public Double getParcialidad() {
		return parcialidad;
	}

	/**
	 * Establece parcialidad.
	 *
	 * @param parcialidad the parcialidad to set
	 */
	public void setParcialidad(Double parcialidad) {
		this.parcialidad = parcialidad;
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
	 * Obtiene pagado intereses.
	 *
	 * @return the pagadoIntereses
	 */
	public Double getPagadoIntereses() {
		return pagadoIntereses;
	}

	/**
	 * Establece pagado intereses.
	 *
	 * @param pagadoIntereses the pagadoIntereses to set
	 */
	public void setPagadoIntereses(Double pagadoIntereses) {
		this.pagadoIntereses = pagadoIntereses;
	}

	/**
	 * Obtiene pago parcial.
	 *
	 * @return the pagoParcial
	 */
	public Double getPagoParcial() {
		return pagoParcial;
	}

	/**
	 * Establece pago parcial.
	 *
	 * @param pagoParcial the pagoParcial to set
	 */
	public void setPagoParcial(Double pagoParcial) {
		this.pagoParcial = pagoParcial;
	}

	/**
	 * Obtiene incd.
	 *
	 * @return the incd
	 */
	public String getIncd() {
		return incd;
	}

	/**
	 * Establece incd.
	 *
	 * @param incd the incd to set
	 */
	public void setIncd(String incd) {
		this.incd = incd;
	}

	/**
	 * Obtiene saldo intereses.
	 *
	 * @return the saldoIntereses
	 */
	public Double getSaldoIntereses() {
		return saldoIntereses;
	}

	/**
	 * Establece saldo intereses.
	 *
	 * @param saldoIntereses the saldoIntereses to set
	 */
	public void setSaldoIntereses(Double saldoIntereses) {
		this.saldoIntereses = saldoIntereses;
	}

	/**
	 * Obtiene saldo capital.
	 *
	 * @return the saldoCapital
	 */
	public Double getSaldoCapital() {
		return saldoCapital;
	}

	/**
	 * Establece saldo capital.
	 *
	 * @param saldoCapital the saldoCapital to set
	 */
	public void setSaldoCapital(Double saldoCapital) {
		this.saldoCapital = saldoCapital;
	}

	/**
	 * Obtiene no miembros.
	 *
	 * @return the noMiembros
	 */
	public Integer getNoMiembros() {
		return noMiembros;
	}

	/**
	 * Establece no miembros.
	 *
	 * @param noMiembros the noMiembros to set
	 */
	public void setNoMiembros(Integer noMiembros) {
		this.noMiembros = noMiembros;
	}

	/**
	 * Obtiene fecha esp liq.
	 *
	 * @return the fechaEspLiq
	 */
	public String getFechaEspLiq() {
		return fechaEspLiq;
	}

	/**
	 * Establece fecha esp liq.
	 *
	 * @param fechaEspLiq the fechaEspLiq to set
	 */
	public void setFechaEspLiq(String fechaEspLiq) {
		this.fechaEspLiq = fechaEspLiq;
	}

	/**
	 * Obtiene fecha prox pago.
	 *
	 * @return the fechaProxPago
	 */
	public String getFechaProxPago() {
		return fechaProxPago;
	}

	/**
	 * Establece fecha prox pago.
	 *
	 * @param fechaProxPago the fechaProxPago to set
	 */
	public void setFechaProxPago(String fechaProxPago) {
		this.fechaProxPago = fechaProxPago;
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
	 * Obtiene status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Establece status.
	 *
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * Obtiene frec pago.
	 *
	 * @return the frecPago
	 */
	public String getFrecPago() {
		return frecPago;
	}

	/**
	 * Establece frec pago.
	 *
	 * @param frecPago the frecPago to set
	 */
	public void setFrecPago(String frecPago) {
		this.frecPago = frecPago;
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
	 * Obtiene fecha contrato.
	 *
	 * @return the fechaContrato
	 */
	public String getFechaContrato() {
		return fechaContrato;
	}

	/**
	 * Establece fecha contrato.
	 *
	 * @param fechaContrato the fechaContrato to set
	 */
	public void setFechaContrato(String fechaContrato) {
		this.fechaContrato = fechaContrato;
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
	 * Obtiene no sucursal.
	 *
	 * @return the noSucursal
	 */
	public String getNoSucursal() {
		return noSucursal;
	}

	/**
	 * Establece no sucursal.
	 *
	 * @param noSucursal the noSucursal to set
	 */
	public void setNoSucursal(String noSucursal) {
		this.noSucursal = noSucursal;
	}


	/**
	 * Obtiene intereses.
	 *
	 * @return the intereses
	 */
	public Double getIntereses() {
		return intereses;
	}


	/**
	 * Establece intereses.
	 *
	 * @param intereses the intereses to set
	 */
	public void setIntereses(Double intereses) {
		this.intereses = intereses;
	}


	/**
	 * Obtiene total a pagar.
	 *
	 * @return the totalAPagar
	 */
	public Double getTotalAPagar() {
		return totalAPagar;
	}


	/**
	 * Establece total a pagar.
	 *
	 * @param totalAPagar the totalAPagar to set
	 */
	public void setTotalAPagar(Double totalAPagar) {
		this.totalAPagar = totalAPagar;
	}


	/**
	 * Obtiene saldo total.
	 *
	 * @return the saldoTotal
	 */
	public Double getSaldoTotal() {
		return saldoTotal;
	}


	/**
	 * Establece saldo total.
	 *
	 * @param saldoTotal the saldoTotal to set
	 */
	public void setSaldoTotal(Double saldoTotal) {
		this.saldoTotal = saldoTotal;
	}


	/**
	 * Obtiene interes total.
	 *
	 * @return the interesTotal
	 */
	public Double getInteresTotal() {
		return interesTotal;
	}


	/**
	 * Establece interes total.
	 *
	 * @param interesTotal the interesTotal to set
	 */
	public void setInteresTotal(Double interesTotal) {
		this.interesTotal = interesTotal;
	}


	/**
	 * Obtiene iva interes total.
	 *
	 * @return the ivaInteresTotal
	 */
	public Double getIvaInteresTotal() {
		return ivaInteresTotal;
	}


	/**
	 * Establece iva interes total.
	 *
	 * @param ivaInteresTotal the ivaInteresTotal to set
	 */
	public void setIvaInteresTotal(Double ivaInteresTotal) {
		this.ivaInteresTotal = ivaInteresTotal;
	}
}
