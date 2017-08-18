/**
 *
 */
package utilitario.mensajes.reportes.cierre;

import java.lang.reflect.Field;

/**
 * The Class ReporteDesembolsoPeticion.
 *
 * @author m_valdez
 */
public class ReporteDesembolsoPeticion implements java.io.Serializable {

	/**
	 * Instancia una nueva reporte desembolso peticion.
	 */
	public ReporteDesembolsoPeticion() {
	}
	/** UID para la serializacion. */
	private static final long serialVersionUID = 8894628822268863908L;

	/** The fecha inicial inicio. */
	private java.util.Date		fechaInicialInicio;		//Inicio de rango para fecha adquisicion

	/** The fecha inicial final. */
	private java.util.Date		fechaInicialFinal;		//Fin de rango para fecha adquisicion

	/** The fecha termino inicio. */
	private java.util.Date		fechaTerminoInicio;		//Inicio de rango para fecha de liquidacion esperada

	/** The fecha termino final. */
	private java.util.Date		fechaTerminoFinal;		//Fin de rango para fecha de liquidacion esperada

	/** The contrato. */
	private java.lang.String	contrato;				//Indica el numero de contrato

	/** The nombre grupo. */
	private java.lang.String	nombreGrupo;			//Cadena que puede contener el nombre de grupos

	/** The sucursal. */
	private java.lang.Integer	sucursal;				//Numero de una sucursal especifica

	/** The asesor. */
	private java.lang.String	asesor;					//Clave de un asesor

	/** The fecha. */
	private java.util.Date		fecha;	//fecha opcional, si no se emplea,se usa la contable

	/**
	 * Obtiene fecha inicial inicio.
	 *
	 * @return the fechaInicialInicio
	 */
	public java.util.Date getFechaInicialInicio() {
		return fechaInicialInicio;
	}

	/**
	 * Establece fecha inicial inicio.
	 *
	 * @param fechaInicialInicio the fechaInicialInicio to set
	 */
	public void setFechaInicialInicio(java.util.Date fechaInicialInicio) {
		this.fechaInicialInicio = fechaInicialInicio;
	}

	/**
	 * Obtiene fecha inicial final.
	 *
	 * @return the fechaInicialFinal
	 */
	public java.util.Date getFechaInicialFinal() {
		return fechaInicialFinal;
	}

	/**
	 * Establece fecha inicial final.
	 *
	 * @param fechaInicialFinal the fechaInicialFinal to set
	 */
	public void setFechaInicialFinal(java.util.Date fechaInicialFinal) {
		this.fechaInicialFinal = fechaInicialFinal;
	}

	/**
	 * Obtiene fecha termino inicio.
	 *
	 * @return the fechaTerminoInicio
	 */
	public java.util.Date getFechaTerminoInicio() {
		return fechaTerminoInicio;
	}

	/**
	 * Establece fecha termino inicio.
	 *
	 * @param fechaTerminoInicio the fechaTerminoInicio to set
	 */
	public void setFechaTerminoInicio(java.util.Date fechaTerminoInicio) {
		this.fechaTerminoInicio = fechaTerminoInicio;
	}

	/**
	 * Obtiene fecha termino final.
	 *
	 * @return the fechaTerminoFinal
	 */
	public java.util.Date getFechaTerminoFinal() {
		return fechaTerminoFinal;
	}

	/**
	 * Establece fecha termino final.
	 *
	 * @param fechaTerminoFinal the fechaTerminoFinal to set
	 */
	public void setFechaTerminoFinal(java.util.Date fechaTerminoFinal) {
		this.fechaTerminoFinal = fechaTerminoFinal;
	}

	/**
	 * Obtiene contrato.
	 *
	 * @return the contratoInicio
	 */
	public java.lang.String getContrato() {
		return contrato;
	}

	/**
	 * Establece contrato.
	 *
	 * @param contrato a contrato
	 */
	public void setContrato(java.lang.String contrato) {
		this.contrato = contrato;
	}

	/**
	 * Obtiene nombre grupo.
	 *
	 * @return the nombreGrupo
	 */
	public java.lang.String getNombreGrupo() {
		return nombreGrupo;
	}

	/**
	 * Establece nombre grupo.
	 *
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(java.lang.String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}

	/**
	 * Obtiene sucursal.
	 *
	 * @return the sucursal
	 */
	public java.lang.Integer getSucursal() {
		return sucursal;
	}

	/**
	 * Establece sucursal.
	 *
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(java.lang.Integer sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * Obtiene asesor.
	 *
	 * @return the asesor
	 */
	public java.lang.String getAsesor() {
		return asesor;
	}

	/**
	 * Establece asesor.
	 *
	 * @param asesor the asesor to set
	 */
	public void setAsesor(java.lang.String asesor) {
		this.asesor = asesor;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return the fecha
	 */
	public java.util.Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha the fecha to set
	 */
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public java.lang.String toString() {
		final java.lang.StringBuffer
						stringObject = new StringBuffer();

		try {
			final java.lang.reflect.Field []
			                        atributos = this.getClass().getDeclaredFields();

			for ( Field field : atributos ) {
				java.lang.reflect.Method method = null;

				try {
					method = this.getClass().getMethod("get" + field.getName().toUpperCase().charAt(0)
							 + field.getName().substring( 1 ) );
					}
				catch ( java.lang.NoSuchMethodException noSuchMethodException )	{
					noSuchMethodException.getMessage();
					method = null;
					}
				if ( method != null ) {
					final java.lang.Object valor =
							( method != null ?  method.invoke( this ) : "" );

					stringObject.append( ( stringObject.toString().equals( "" ) ? "[ " : ", " )
							+ ( field.getName() + " = " + valor ) );
					}
				}
			}
		catch ( java.lang.SecurityException securityException )	{
			securityException.getMessage();
			}
		catch ( java.lang.reflect.InvocationTargetException invocationTargetException )	{
			invocationTargetException.getMessage();
			}
		catch ( java.lang.IllegalAccessException illegalAccessException ) {
			illegalAccessException.getMessage();
			}

		stringObject.append( " ]" );

		return stringObject.toString();
		}
	}
