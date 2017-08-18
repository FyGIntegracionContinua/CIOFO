package tarea.reportes;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import tarea.comun.ReadProperties;
import utilitario.log.LogHandler;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.reportes.cierre.ReportesContabilidadOV;
import utilitario.mensajes.reportes.comun.LineaContableOV;
import utilitario.mensajes.reportes.comun.PagoImportado;
import utilitario.mensajes.reportes.comun.PagosImportadosPeticion;
import utilitario.mensajes.reportes.comun.PagosImportadosRespuesta;
import utilitario.mensajes.reportes.comun.ReportesContablesPeticion;
import utilitario.mensajes.reportes.comun.ReportesContablesRespuesta;
import entidad.conexiones.FabricaConexiones;

/**
 * The Class ContablesImpl.
 */
@SuppressWarnings("unchecked")
public 	class 		ContablesImpl
		implements	Contables
	{

	/** The Constant formatMesAnio. */
	final private static SimpleDateFormat formatMesAnio = new SimpleDateFormat("MMyyyy");

	/** The Constant formatFecha. */
	final private static SimpleDateFormat formatFecha = new SimpleDateFormat("dd/MM/yyyy");

	//Variables para la consulta
	/** The mapa cuentas. */
	private static java.util.HashMap<String, ReportesContabilidadOV> mapaCuentas;

	/** The fecha reportes contables. */
	private static java.util.Date						  			 fechaReportesContables = null;

	/** The mes consulta. */
	private static java.lang.Integer								 mesConsulta;

	/** The calculos rm. */
	private java.util.List<HashMap<String, Object>>			 		 calculosRM = null;

	static
		{
		mapaCuentas = new HashMap<String, ReportesContabilidadOV>();
		//cargarCuentas( null );
		}

	/**
	 * M�todo utilizado para cargar todas las cuentas.
	 *
	 * @param fecha the fecha
	 */
	private static void cargarCuentas( java.util.Date fecha )
		{
		//Session
		SqlSession sessionSqlBatch = null;

		//Se verifica la instancia del mapeo
		mapaCuentas = mapaCuentas == null ? new HashMap<String, ReportesContabilidadOV>() : mapaCuentas;

		try {
			if ( fechaReportesContables == null || ( fecha != null
					? !formatMesAnio.format( fechaReportesContables ).equals( formatMesAnio.format( fecha ) ) : false ) ) {
				//Se abre la session
				sessionSqlBatch = FabricaConexiones.obtenerSesionSqlBatch();

				//Se recupera el a�o
				final java.lang.Integer year = fecha == null ? Calendar.getInstance().get( Calendar.YEAR )
						: Integer.valueOf( ( new SimpleDateFormat("yyyy") ).format( fecha ) );

				LogHandler.trace("0000000000000000000", ContablesImpl.class,
						"==> ContablesImpl - static - consultarMontosCuentas");
				final List<ReportesContabilidadOV> listaCuentas
					= (List<ReportesContabilidadOV>) sessionSqlBatch.selectList( "consultarMontosCuentas" , year.toString() );

				//se carga el hash principal
				for ( ReportesContabilidadOV reportesContabilidadOV : listaCuentas ) {
					mapaCuentas.put( reportesContabilidadOV.getCuenta().trim(), reportesContabilidadOV );
					}

				//Se coloca la fecha en que se obtienen los datos
				fechaReportesContables = fecha == null ? java.util.Calendar.getInstance().getTime() : fecha;

				//Se recupera el mes de consulta
				mesConsulta = fechaReportesContables == null ? Calendar.getInstance().get( Calendar.MONTH )
						: Integer.valueOf( ( new SimpleDateFormat("MM") ).format( fechaReportesContables ) ) - 1;

				LogHandler.info("0000000000000000000", ContablesImpl.class, "El mes elegido para la consulta es : "
							+ mesConsulta );
				}
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error("0000000000000000000", Contables.class, "No se pudieron recuperar las cuentas.", exception );
			}
		finally	{
			FabricaConexiones.close( sessionSqlBatch );
			}
		}

	/**
	 * Informaci�n para monitoreo mensual - del estado de resultados
	 * @param peticion tipo ReportesContablesPeticion
	 *  @param uid tipo String
	 * @return respuesta
	 */
	public ReportesContablesRespuesta generarReportedeEstadosResultados(String uid, ReportesContablesPeticion peticion) {

		LogHandler.info(uid, getClass(), "Se generar� el reporte de Estados de Resultados....... Entrada OK");
		ReportesContablesRespuesta respuesta = new ReportesContablesRespuesta();

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		final LineaContableOV textosFinales [] = {
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ),
				calculaValor( "4110000-4119999" ).add( calculaValor( "4120005" ) ).add( calculaValor( "4120000" ) )
				.add( calculaValor( "4130000" ) ).add( calculaValor( "4140000" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ),
				calculaValor( "4110000-4119999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), calculaValor( "4120005" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), calculaValor( "4120000" ) ),
		//.subtract( calculaValor( "4120005" ) ) ),Se realizo el cambio, para q ya no se reste
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), calculaValor( "4130000" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ),
				calculaValor( "4140000" ).add( calculaValor( "4140001" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
 /*10*/ new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.ingresos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ),
				calculaValor( "5110000-5119999" ).subtract( calculaValor( "5117000" ) ).subtract( calculaValor( "5110110" ) )
				.subtract( calculaValor( "5110200" ).add( calculaValor( "5110300" ) ) ).add( calculaValor( "5117000" ) )
				.add( calculaValor( "5110110" ) ).add( calculaValor( "5110200" ).add( calculaValor( "5110300" ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ),
				calculaValor( "5110000-5119999" ).subtract( calculaValor( "5117000" ) ).subtract( calculaValor( "5110110" ) )
				.subtract( calculaValor( "5110200" ).add( calculaValor( "5110300" ) ) ) ),
 /*20*/ new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), calculaValor( "5117000" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), calculaValor( "5110110" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), calculaValor( "5110200" )
				.add( calculaValor( "5110300" ) ) ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
	    new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastos" ), BigDecimal.ZERO ),
/*30*/	new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.depreciacion" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.depreciacion" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.depreciacion" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.depreciacion" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.repomo" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.margenfinanciero" ),
				calculaValor( "4110000-4119999" ).add( calculaValor( "4120005" ) ).add( calculaValor( "4120000" ) )
				.add( calculaValor( "4130000" ) ).add( calculaValor( "4140000" ) ).subtract( calculaValor( "5110000-5119999" )
				.subtract( calculaValor( "5117000" ) ).subtract( calculaValor( "5110110" ) ).subtract( calculaValor( "5110200" )
				.add( calculaValor( "5110300" ) ) ).add( calculaValor( "5117000" ) ).add( calculaValor( "5110110" ) )
				.add( calculaValor( "5110200" ).add( calculaValor( "5110300" ) ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.estimacionpreventiva" ),
				calculaValor( "5810000-5820100" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.margenfinancieroajustado" ),
				calculaValor( "4110000-4119999" ).add( calculaValor( "4120005" ) ).add( calculaValor( "4120000" ) )
				.add( calculaValor( "4130000" ) ).add( calculaValor( "4140000" ) ).subtract( calculaValor( "5110000-5119999" )
				.subtract( calculaValor( "5117000" ) ).subtract( calculaValor( "5110110" ) ).subtract( calculaValor( "5110200" )
				.add( calculaValor( "5110300" ) ) ).add( calculaValor( "5117000" ) ).add( calculaValor( "5110110" ) )
				.add( calculaValor("5110200").add(calculaValor("5110300")))).subtract(calculaValor("5810000-5820100"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
/*40*/	new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionescobradas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"),
				calculaValor("5120000-5129999")),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"),
				calculaValor("5120000-5129999")),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"), BigDecimal.ZERO),
/*50*/	new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.comisionespagadas"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.resultadointermediarios"),
				calculaValor("4340000").subtract(calculaValor("5150000"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosoperacion"),
				calculaValor( "4320000-4320200" ).add( calculaValor( "4330100-4330300" ) ).subtract( calculaValor( "5820000" ) )
				.add( calculaValor( "4330301" ) ).add( calculaValor( "4330302" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.totaloperacion" ),
				calculaValor( "4110000-4119999" ).add( calculaValor( "4120005" ) ).add( calculaValor( "4120000" ) )
				.add( calculaValor( "4130000" ) ).add( calculaValor( "4140000" ) ).subtract( calculaValor( "5110000-5119999" )
				.subtract( calculaValor( "5117000" ) ).subtract( calculaValor( "5110110" ) ).subtract( calculaValor( "5110200" )
				.add(calculaValor("5110300"))).add(calculaValor("5117000")).add(calculaValor("5110110"))
				.add( calculaValor( "5110200" ).add( calculaValor( "5110300" ) ) ) ).subtract( calculaValor( "5810000-5820100" ) )
				.subtract(calculaValor("5120000-5129999")).add(calculaValor("4340000").subtract(calculaValor("5150000")))
				.add(calculaValor("4320000-4320200").add(calculaValor("4330100-4330300")).subtract(calculaValor("5820000")))),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5310300-5310350" ).add( calculaValor( "5310200-5310220" ).add( calculaValor( "5312005" ) ) )
				.add(calculaValor("5310700-5310799")).add(calculaValor("5311500-5311599")).add(calculaValor("5720000-5729999"))
				.add(calculaValor("5610100")).add(calculaValor("5410000-5419999")).add(calculaValor("5510100-5510200"))
				.add(calculaValor("5210000-5219999")).add(calculaValor("5310000-5319999").subtract(calculaValor("5313300"))
				.subtract(calculaValor("5310300-5310350")).subtract(calculaValor("5310200-5310220").add(calculaValor("5312005")))
				.subtract(calculaValor("5310700-5310799")).subtract(calculaValor("5311500-5311599")))), //57-68
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.gastosadministracion"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.gastosadministracion"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.gastosadministracion"),
				calculaValor("5310300-5310350")),
/*60*/	new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.gastosadministracion"),
		calculaValor("5310200-5310220").add(calculaValor("5312005"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.gastosadministracion"),
				calculaValor("5310700-5310799")),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5311500-5311599" ) ), //calculaValor( "5310500-5310510" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5720000-5729999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5610100" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5410000-5419999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5510100-5510200" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor( "5210000-5219999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.gastosadministracion" ),
				calculaValor("5310000-5319999").subtract(calculaValor("5313300")).subtract(calculaValor("5310300-5310350"))
				.subtract(calculaValor("5310200-5310220").add(calculaValor("5312005"))).subtract(calculaValor("5310700-5310799"))
				.subtract(calculaValor("5311500-5311599"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.resultadooperacion"),
				calculaValor("4110000-4119999").add(calculaValor("4120005")).add(calculaValor("4120000"))
				.add(calculaValor("4130000")).add(calculaValor("4140000")).subtract(calculaValor("5110000-5119999")
				.subtract(calculaValor("5117000")).subtract(calculaValor("5110110")).subtract(calculaValor("5110200")
				.add(calculaValor("5110300"))).add(calculaValor("5117000")).add(calculaValor("5110110"))
				.add(calculaValor("5110200").add(calculaValor("5110300")))).subtract(calculaValor("5810000-5820100"))
				.subtract(calculaValor("5120000-5129999")).add(calculaValor("4340000").subtract(calculaValor("5150000")))
				.add(calculaValor("4320000-4320200").add(calculaValor("4330100-4330300")).subtract(calculaValor("5820000")))
				.subtract(calculaValor("5310300-5310350").add(calculaValor("5310200-5310220").add(calculaValor("5312005")))
				.add(calculaValor("5310700-5310799")).add(calculaValor("5311500-5311599")).add(calculaValor("5720000-5729999"))
				.add(calculaValor("5610100")).add(calculaValor("5410000-5419999")).add(calculaValor("5510100-5510200"))
				.add(calculaValor("5210000-5219999")).add(calculaValor("5310000-5319999").subtract(calculaValor("5313300"))
				.subtract(calculaValor("5310300-5310350")).subtract(calculaValor("5310200-5310220").add(calculaValor("5312005")))
				.subtract(calculaValor("5310700-5310799")).subtract(calculaValor("5311500-5311599"))))),
/*70*/	new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosproductos"),
				calculaValor("4330000-4330015")),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosproductos"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosproductos"),
				calculaValor("4330000-4330015")),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosgastos"),
				calculaValor("5313300").add(calculaValor("5820300"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosgastos"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosgastos"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosgastos"), BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.otrosgastos"),
				calculaValor("5313300").add(calculaValor("5820300"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.resultadoanteimpuestos"),
				calculaValor("4110000-4119999").add(calculaValor("4120005") ).add( calculaValor( "4120000" ) )
				.add( calculaValor( "4130000" ) ).add( calculaValor( "4140000" ) ).subtract( calculaValor( "5110000-5119999" )
				.subtract( calculaValor( "5117000" ) ).subtract( calculaValor( "5110110" ) ).subtract( calculaValor( "5110200" )
				.add( calculaValor( "5110300" ) ) ).add( calculaValor( "5117000" ) ).add( calculaValor( "5110110" ) )
				.add( calculaValor( "5110200" ).add( calculaValor( "5110300" ) ) ) ).subtract( calculaValor( "5810000-5820100" ) )
				.subtract(calculaValor("5120000-5129999")).add(calculaValor("4340000").subtract(calculaValor("5150000")))
				.add(calculaValor("4320000-4320200").add(calculaValor("4330100-4330300")).subtract(calculaValor("5820000")))
				.subtract(calculaValor("5310300-5310350").add(calculaValor("5310200-5310220").add(calculaValor("5312005")))
				.add(calculaValor("5310700-5310799")).add(calculaValor("5311500-5311599")).add(calculaValor("5720000-5729999"))
				.add(calculaValor("5610100")).add(calculaValor("5410000-5419999")).add(calculaValor("5510100-5510200"))
				.add(calculaValor("5210000-5219999")).add(calculaValor("5310000-5319999").subtract(calculaValor("5313300"))
				.subtract(calculaValor("5310300-5310350")).subtract(calculaValor("5310200-5310220").add(calculaValor("5312005")))
				.subtract(calculaValor("5310700-5310799")).subtract(calculaValor("5311500-5311599"))))
				.add(calculaValor("4330000-4330015")).subtract(calculaValor("5313300").add(calculaValor("5820300")))),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.resultadoanteimpuestos" ),
				calculaValor( "5640000-5649999" ) ),
/*80*/	new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.resultadoanteimpuestos" ),
		calculaValor( "5650000-5650100" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.resutadoantesubsidiarias" ),
			calculaValor("4110000-4119999").add(calculaValor("4120005")).add(calculaValor("4120000"))
			.add(calculaValor("4130000")).add(calculaValor("4140000")).subtract(calculaValor("5110000-5119999")
			.subtract(calculaValor("5117000")).subtract(calculaValor("5110110")).subtract(calculaValor("5110200")
			.add(calculaValor("5110300"))).add(calculaValor("5117000")).add(calculaValor("5110110")).add(calculaValor("5110200")
			.add(calculaValor("5110300")))).subtract(calculaValor("5810000-5820100")).subtract(calculaValor("5120000-5129999"))
			.add(calculaValor("4340000").subtract(calculaValor("5150000"))).add(calculaValor("4320000-4320200")
			.add(calculaValor("4330100-4330300")).subtract(calculaValor("5820000"))).subtract(calculaValor("5310300-5310350")
			.add(calculaValor("5310200-5310220").add(calculaValor("5312005"))).add(calculaValor("5310700-5310799"))
			.add(calculaValor("5311500-5311599")).add(calculaValor("5720000-5729999")).add(calculaValor("5610100"))
			.add(calculaValor("5410000-5419999")).add(calculaValor("5510100-5510200")).add(calculaValor("5210000-5219999"))
			.add(calculaValor("5310000-5319999").subtract(calculaValor("5313300")).subtract(calculaValor("5310300-5310350"))
			.subtract(calculaValor("5310200-5310220").add(calculaValor("5312005"))).subtract(calculaValor("5310700-5310799"))
			.subtract(calculaValor("5311500-5311599")))).add(calculaValor("4330000-4330015")).subtract(calculaValor("5313300")
			.add(calculaValor("5820300"))).subtract(calculaValor("5640000-5649999")).subtract(calculaValor("5650000-5650100"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.resutadoantesubsidiarias"),
			BigDecimal.ZERO),
		new LineaContableOV( ReadProperties.reportes.getProp( "estadoresultados.finlinea.resultadoantesdiscontinuas" ),
			calculaValor("4110000-4119999").add(calculaValor("4120005")).add(calculaValor("4120000"))
			.add(calculaValor("4130000")).add(calculaValor("4140000")).subtract(calculaValor("5110000-5119999")
			.subtract(calculaValor("5117000")).subtract(calculaValor("5110110")).subtract(calculaValor("5110200")
			.add(calculaValor("5110300"))).add(calculaValor("5117000")).add(calculaValor("5110110")).add(calculaValor("5110200")
			.add(calculaValor("5110300")))).subtract(calculaValor("5810000-5820100")).subtract(calculaValor("5120000-5129999"))
			.add(calculaValor("4340000").subtract(calculaValor("5150000"))).add(calculaValor("4320000-4320200").add(
			calculaValor("4330100-4330300")).subtract(calculaValor("5820000"))).subtract(calculaValor("5310300-5310350")
			.add(calculaValor("5310200-5310220").add(calculaValor("5312005"))).add(calculaValor("5310700-5310799"))
			.add(calculaValor("5311500-5311599")).add(calculaValor("5720000-5729999")).add(calculaValor("5610100"))
			.add(calculaValor("5410000-5419999")).add(calculaValor("5510100-5510200")).add(calculaValor("5210000-5219999"))
			.add(calculaValor("5310000-5319999").subtract(calculaValor("5313300")).subtract(calculaValor("5310300-5310350"))
			.subtract(calculaValor("5310200-5310220").add(calculaValor("5312005"))).subtract(calculaValor("5310700-5310799"))
			.subtract(calculaValor("5311500-5311599")))).add(calculaValor("4330000-4330015")).subtract(calculaValor("5313300")
			.add(calculaValor("5820300"))).subtract(calculaValor("5640000-5649999")).subtract(calculaValor("5650000-5650100"))),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.resultadoantesdiscontinuas"),
				BigDecimal.ZERO),
		new LineaContableOV(ReadProperties.reportes.getProp("estadoresultados.finlinea.resultadoneto"),
			calculaValor("4110000-4119999").add(calculaValor("4120005")).add(calculaValor("4120000")).add(calculaValor("4130000"))
			.add(calculaValor("4140000")).subtract(calculaValor("5110000-5119999").subtract(calculaValor("5117000"))
			.subtract(calculaValor("5110110")).subtract(calculaValor("5110200").add(calculaValor("5110300")))
			.add(calculaValor("5117000")).add(calculaValor("5110110")).add(calculaValor("5110200").add(calculaValor("5110300"))))
			.subtract(calculaValor("5810000-5820100")).subtract(calculaValor("5120000-5129999")).add(calculaValor("4340000")
			.subtract(calculaValor("5150000"))).add(calculaValor("4320000-4320200").add(calculaValor("4330100-4330300"))
			.subtract(calculaValor("5820000"))).subtract(calculaValor("5310300-5310350").add(calculaValor("5310200-5310220")
			.add(calculaValor("5312005"))).add(calculaValor("5310700-5310799")).add(calculaValor("5311500-5311599"))
			.add(calculaValor("5720000-5729999")).add(calculaValor("5610100")).add(calculaValor("5410000-5419999"))
			.add(calculaValor("5510100-5510200")).add(calculaValor("5210000-5219999")).add(calculaValor("5310000-5319999")
			.subtract(calculaValor("5313300")).subtract(calculaValor("5310300-5310350")).subtract(calculaValor("5310200-5310220")
			.add(calculaValor("5312005"))).subtract(calculaValor("5310700-5310799")).subtract(calculaValor("5311500-5311599"))))
			.add(calculaValor("4330000-4330015")).subtract(calculaValor("5313300").add(calculaValor("5820300")))
			.subtract(calculaValor("5640000-5649999")).subtract(calculaValor("5650000-5650100")))
			};

		final List<String> cadena = new ArrayList<String>();
		final StringBuffer encabezado = new StringBuffer();
		BigDecimal resultadoFinal = BigDecimal.ZERO;

		//Se arma el encabezado de la cadena a regresar
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("estadoresultados.iniciolinea.parteuno"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("estadoresultados.titulo"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se arma el cuerpo de la cadena a regresar
		for (int i = 1; i <= 85; i++) {
			final StringBuffer cadenaTemp = new StringBuffer();
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(i);
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(ReadProperties.reportes.getProp("estadoresultados." + i + ".titulo"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( ( new java.text.DecimalFormat( "0.00" ) ).format( textosFinales[i - 1].getMonto().doubleValue() ));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(textosFinales[i - 1].getTexto());
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cadenaTemp.toString());

			resultadoFinal = resultadoFinal.add( new BigDecimal( textosFinales[i - 1].getMonto().doubleValue() ) );
		}

		//Se arma el resultado de la cadena que se regresara
		final String finArchivo = generarFinReporte(86, resultadoFinal );
		cadena.add(finArchivo);

		respuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se genero el reporte de Estados de Resultados....... Salida OK");
		return respuesta;
	}

	/**
	 * Reporte para generar las cifras de activos, pasivos, capital contable y cuentas de orden
	 * @param peticion ReportesContablesPeticion
	 * @param uid String
	 * @return reportesContablesRespuesta
	 */
	public ReportesContablesRespuesta generarReporteBalanceGeneral(String uid, ReportesContablesPeticion peticion) {
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Balance General....... Entrada OK");

		//Se crea el objeto de respuesta
		final ReportesContablesRespuesta
					reportesContablesRespuesta = new ReportesContablesRespuesta();

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Textos para finalizar la linea
		final LineaContableOV textosFinales [] = {
/*1*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
			calculaValor( "1110100-1129999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
			calculaValor( "1131900" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
			calculaValor( "1130500" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
			calculaValor("1130000-1139999").subtract(calculaValor("1131900")).subtract(calculaValor("1130500"))),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
			calculaValor( "1130000-1139999" ).subtract( calculaValor( "1131900" ) ).subtract( calculaValor( "1130500" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
/*10*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "2210110-2210115" ).add( calculaValor( "1140100" ).add(calculaValor( "1150100" ) ).subtract(
				calculaValor( "2210110-2210115" ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "2210110-2210115" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1140100" ).add( calculaValor( "1150100" ) ).subtract( calculaValor( "2210110-2210115" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1140200" ).add( calculaValor( "1150200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
/*20*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1140200" ).add( calculaValor( "1150200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "2210110-2210115" ).add( calculaValor( "1140100" ).add(calculaValor( "1150100" ) ).subtract(
				calculaValor( "2210110-2210115" ) ) ).add( calculaValor( "1140200" ).add( calculaValor( "1150200" ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "2130100" ).multiply( new BigDecimal( -1 ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "2210110-2210115" ).add( calculaValor( "1140100" ).add(calculaValor( "1150100" ) ).subtract(
				calculaValor( "2210110-2210115" ) ) ).add( calculaValor( "1140200" ).add( calculaValor( "1150200" ) ) )
				.subtract( calculaValor( "2130100" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "2210110-2210115" ).add( calculaValor( "1140100" ).add(calculaValor( "1150100" ) ).subtract(
				calculaValor( "2210110-2210115" ) ) ).add( calculaValor( "1140200" ).add( calculaValor( "1150200" ) ) )
				.subtract( calculaValor( "2130100" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1160000-1209999" ).add( calculaValor( "1330000-1339999" ) ) ),
/*30*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1210000-1319999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), calculaValor( "1360100" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1320000-1329999" ).add( calculaValor( "1340000-1349999" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1320000-1329999" ).add( calculaValor( "1340000-1349999" ) ) ),
/*40*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.activos" ),
				calculaValor( "1110100-1129999" ).add( calculaValor( "1131900" ) ).add( calculaValor( "1130500" ) )
				.add(calculaValor( "1130000-1139999" ).subtract( calculaValor( "1131900" ) ).subtract(
				calculaValor( "1130500" ) ) ).add( calculaValor( "2210110-2210115" ).add( calculaValor( "1140100" )
				.add(calculaValor( "1150100" ) ).subtract( calculaValor( "2210110-2210115" ) ) ).add( calculaValor( "1140200" )
				.add( calculaValor( "1150200" ) ) ).subtract( calculaValor( "2130100" ))).add(calculaValor("1160000-1209999")
				.add(calculaValor("1330000-1339999"))).add(calculaValor("1210000-1319999")).add(calculaValor("1360100"))
				.add(calculaValor("1320000-1329999").add(calculaValor("1340000-1349999")))),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor( "2210160" ).add( calculaValor( "2210165" ) ).add( calculaValor( "2217000" ).add(
				calculaValor( "2217005" ) ) ).add( calculaValor( "2210110" ).add( calculaValor( "2210115" ) ) ).add(
				calculaValor( "2210000-2229999" ).subtract( ( calculaValor( "2210160" ) ).add( calculaValor( "2210165" ) ) )
				.subtract( ( calculaValor( "2217000" ) ).add( calculaValor( "2217005" ) ) ).subtract(
				( calculaValor("2210110" ) ).add( calculaValor( "2210115" ) ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor( "2210160" ).add( calculaValor( "2210165" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor( "2217000" ).add( calculaValor( "2217005" ) ) ),
/*50*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor( "2210110" ).add( calculaValor( "2210115" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor("2210000-2229999").subtract((calculaValor("2210160")).add(calculaValor("2210165"))).subtract(
				(calculaValor("2217000")).add(calculaValor("2217005"))).subtract((calculaValor("2210110"))
				.add(calculaValor("2210115")))),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
/*60*/			new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor( "2110000-2129999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
/*70*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ),
				calculaValor( "2110000-2129999" ).add( calculaValor( "2140000 " ) ) ),//Se agrego la segnda cuenta
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.pasivos" ), calculaValor( "2210160" ).add( calculaValor( "2210165" ) ).add( calculaValor( "2217000" ).add( calculaValor( "2217005" ) ) ).add( calculaValor( "2210110" ).add( calculaValor( "2210115" ) ) ).add( calculaValor( "2210000-2229999" ).subtract( ( calculaValor( "2210160" ) ).add( calculaValor( "2210165" ) ) ).subtract( ( calculaValor( "2217000" ) ).add( calculaValor( "2217005" ) ) ).subtract( ( calculaValor( "2210110" ) ).add( calculaValor( "2210115" ) ) ) ).add( calculaValor( "2110000-2129999" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3110100" ).add( calculaValor( "3110200" ) ).add( calculaValor( "3120100" ) ).add( calculaValor( "3120200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3110100" ).add( calculaValor( "3110200" ) ).add( calculaValor( "3120100" ) ).add( calculaValor( "3120200" ) ) ),
/*80*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3110100" ).add( calculaValor( "3110200" ) ).add( calculaValor( "3120100" ) ).add( calculaValor( "3120200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3110100" ).add( calculaValor( "3110200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3120100" ).add( calculaValor( "3120200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3610100" ).add( calculaValor( "3610200" ) ).add( calculaValor( "3210000-3219999" ) ).add( calculaValorStartWith( "4" ).subtract( calculaValorStartWith( "5" ) ) ) ),
/*90*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3610100" ).add( calculaValor( "3610200" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3210000-3219999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValorStartWith( "4" ).subtract( calculaValorStartWith( "5" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "3110100" ).add( calculaValor( "3110200" ) ).add( calculaValor( "3120100" ) ).add( calculaValor( "3120200" ) ).add( calculaValor( "3610100" ).add( calculaValor( "3610200" ) ).add( calculaValor( "3210000-3219999" ) ).add( calculaValorStartWith( "4" ).subtract( calculaValorStartWith( "5" ) ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.capitalcontable" ), calculaValor( "2210160" ).add( calculaValor( "2210165" ) ).add( calculaValor( "2217000" ).add( calculaValor( "2217005" ) ) ).add( calculaValor( "2210110" ).add( calculaValor( "2210115" ) ) ).add( calculaValor( "2210000-2229999" ).subtract( ( calculaValor( "2210160" ) ).add( calculaValor( "2210165" ) ) ).subtract( ( calculaValor( "2217000" ) ).add( calculaValor( "2217005" ) ) ).subtract( ( calculaValor( "2210110" ) ).add( calculaValor( "2210115" ) ) ) ).add( calculaValor( "2110000-2129999" ) ).add( calculaValor( "3110100" ).add( calculaValor( "3110200" ) ).add( calculaValor( "3120100" ) ).add( calculaValor( "3120200" ) ).add( calculaValor( "3610100" ).add( calculaValor( "3610200" ) ).add( calculaValor( "3210000-3219999" ) ).add( calculaValorStartWith( "4" ).subtract( calculaValorStartWith( "5" ) ) ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ), 
/*100*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ), 
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
/*110*/	new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), calculaValor( "8120300" ).add( calculaValor( "8130121" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "balancegeneral.finlinea.cuentasdeorden" ), calculaValor( "8120300" ).add( calculaValor( "8130121" ) ) )};

		//Variables necesarias
		final List<String> cadena = new ArrayList<String>();
		final StringBuffer encabezado = new StringBuffer();
		BigDecimal resultadoFinal = BigDecimal.ZERO;

		//Se arma el encabezado de la cadena a regresar
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(ReadProperties.reportes.getProp("balancegeneral.cabecera.numeroreporte"));
		encabezado.append(ReadProperties.reportes.getProp("balancegeneral.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("balancegeneral.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se arma el cuerpo de la cadena a regresar
		for (int i = 1; i <= 112; i++)
			{
			final StringBuffer cadenaTemp = new StringBuffer();
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(i);
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(ReadProperties.reportes.getProp("balancegeneral." + i + ".titulo"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( ( new java.text.DecimalFormat( "0.00" ) ).format( textosFinales[i - 1].getMonto().doubleValue() ));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( textosFinales[i - 1].getTexto());
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cadenaTemp.toString());

			resultadoFinal = resultadoFinal.add( new BigDecimal( textosFinales[i - 1].getMonto().doubleValue() )
			.setScale( 2, BigDecimal.ROUND_HALF_EVEN ) );
			}

		//Se arma el resultado de la cadena que se regresara
		final String finArchivo = generarFinReporte(113, resultadoFinal );

		//Se agrega el fin de archivo
		cadena.add( finArchivo );

		//Se agregan las cadenas al objeto respuesta
		reportesContablesRespuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Balance General....... Salida OK");

		return reportesContablesRespuesta;
		}


	public ReportesContablesRespuesta generarReportePasivosdeFondeo(String uid, ReportesContablesPeticion peticion)
		{
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Pasivos de Fondeo....... Entrada OK");

		//Se crea el objeto de respuesta
		final ReportesContablesRespuesta
					reportesContablesRespuesta = new ReportesContablesRespuesta();

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Textos para finalizar la linea
		final LineaContableOV textosFinales [] = {
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.prestamobancariobancamultiple" ), calculaValor( "2210160" ).add( calculaValor( "2210165" ) ), ReadProperties.reportes.getProp("pasivosfondeo.bancamultiple.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.prestamobancariobancadesarrollo"), calculaValor( "2217000" ).add( calculaValor( "2217005" ) ), ReadProperties.reportes.getProp("pasivosfondeo.bancadesarrollo.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), calculaValor( "2210110" ).add( calculaValor( "2210115" ) ), ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), calculaValor( "2210110" ), ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), BigDecimal.ZERO, ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), calculaValor( "2210115" ), ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), BigDecimal.ZERO, ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), BigDecimal.ZERO, ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientofira" ), BigDecimal.ZERO, ReadProperties.reportes.getProp("pasivosfondeo.fondosfomento.credito") ),
/*10*/	new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientonofira" ), BigDecimal.ZERO, ReadProperties.reportes.getProp("pasivosfondeo.microempresa.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.financiamientonofira" ), BigDecimal.ZERO, ReadProperties.reportes.getProp("pasivosfondeo.mujeresrurales.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.prestamonocbancario" ), calculaValor( "2210170" ).add( calculaValor( "2210175" ) ), ReadProperties.reportes.getProp("pasivosfondeo.independencia.credito") ),
		new LineaContableOV( ReadProperties.reportes.getProp( "pasivosfondeo.tipo.prestamonocbancario" ), calculaValor( "2210180" ).add( calculaValor( "2210185" ) ), ReadProperties.reportes.getProp("pasivosfondeo.finsol.credito") )};

		//Variables necesarias
		final List<String> cadena = new ArrayList<String>();
		final StringBuffer encabezado = new StringBuffer();
		BigDecimal resultadoFinal = BigDecimal.ZERO;

		//Se arma el encabezado de la cadena a regresar
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(ReadProperties.reportes.getProp("pasivosfondeo.cabecera.numeroreporte"));
		encabezado.append(ReadProperties.reportes.getProp("pasivosfondeo.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("pasivosfondeo.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se arma el cuerpo de la cadena a regresar
		for (int i = 1; i <= 13; i++) {
			final StringBuffer cadenaTemp = new StringBuffer();
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.linea") );
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadenaTemp.append( i );
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadenaTemp.append( textosFinales[i - 1].getTexto());
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadenaTemp.append( ReadProperties.reportes.getProp("pasivosfondeo." + i + ".fondeadora") );
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadenaTemp.append( textosFinales[i - 1].getMonto2());
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadenaTemp.append( ReadProperties.reportes.getProp("pasivosfondeo." + i + ".fecha") );
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadenaTemp.append( ( new java.text.DecimalFormat( "0.00" ) ).format( textosFinales[i - 1].getMonto().doubleValue() ) );
			cadenaTemp.append( ReadProperties.reportes.getProp("reportes.contables.separador") );
			cadena.add( cadenaTemp.toString() );

			resultadoFinal = resultadoFinal.add( new BigDecimal( textosFinales[i - 1].getMonto().doubleValue() ) );
			}

		//Se arma el resultado de la cadena que se regresara
		final String finArchivo = generarFinReporte(14, resultadoFinal);

		//Se agrega el fin de archivo
		cadena.add( finArchivo );

		//Se agregan las cadenas al objeto respuesta
		reportesContablesRespuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Pasivos de Fondeo....... Salida OK");

		return reportesContablesRespuesta;
		}


	public ReportesContablesRespuesta generarReporteCastigoVentadeCarteraVencida(
			String uid, ReportesContablesPeticion peticion) {

		LogHandler.info(uid, getClass(), "Se generar� el reporte de Castigo Venta de Cartera Vencida....... Entrada OK");

		ReportesContablesRespuesta respuesta = new ReportesContablesRespuesta();
		//Cadena que regresa el metodo(reporte)
		List<String> cadena = new ArrayList<String>();

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		final java.util.Calendar fechaReporte = java.util.Calendar.getInstance();
		fechaReporte.setTime(peticion.getFecha());

		//Arreglo con fin de linea y montos
		LineaContableOV []textosFinales = {
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte,  0,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -1,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -2,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -3,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -4,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -5,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -6,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -7,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -8,  "CVMC" ) ),
	/*10*/	new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -9,  "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -10, "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, -11, "CVMC" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.1.finlinea"), castigoCartera(uid, fechaReporte, 0, "CVMC" ).add(castigoCartera(uid, fechaReporte, -1, "CVMC" )).add(castigoCartera(uid, fechaReporte, -2, "CVMC" )).add(castigoCartera(uid, fechaReporte, -3, "CVMC" )).add(castigoCartera(uid, fechaReporte, -4, "CVMC" )).add(castigoCartera(uid, fechaReporte, -5, "CVMC" )).add(castigoCartera(uid, fechaReporte, -6, "CVMC" )).add(castigoCartera(uid, fechaReporte, -7, "CVMC" )).add(castigoCartera(uid, fechaReporte, -8, "CVMC" )).add(castigoCartera(uid, fechaReporte, -9, "CVMC" )).add(castigoCartera(uid, fechaReporte, -10, "CVMC" )).add(castigoCartera(uid, fechaReporte, -11, "CVMC" ))),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte,  0,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -1,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -2,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -3,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -4,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -5,  "CVMV" ) ),
	/*20*/	new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -6,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -7,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -8,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -9,  "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -10, "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"), castigoCartera(uid, fechaReporte, -11, "CVMV" ) ),
			new LineaContableOV(ReadProperties.reportes.getProp("castigocarteravencida.2.finlinea"),  castigoCartera(uid, fechaReporte, 0, "CVMV" ).add(castigoCartera(uid, fechaReporte, -1, "CVMV" )).add(castigoCartera(uid, fechaReporte, -2, "CVMV" )).add(castigoCartera(uid, fechaReporte, -3, "CVMV" )).add(castigoCartera(uid, fechaReporte, -4, "CVMV" )).add(castigoCartera(uid, fechaReporte, -5, "CVMV" )).add(castigoCartera(uid, fechaReporte, -6, "CVMV" )).add(castigoCartera(uid, fechaReporte, -7, "CVMV" )).add(castigoCartera(uid, fechaReporte, -8, "CVMV" )).add(castigoCartera(uid, fechaReporte, -9, "CVMV" )).add(castigoCartera(uid, fechaReporte, -10, "CVMV" )).add(castigoCartera(uid, fechaReporte, -11, "CVMV" ))),
		};
		BigDecimal resultadoFinal = BigDecimal.ZERO;

		//Se arma el encabezado del reporte
		final StringBuffer encabezado = new StringBuffer();
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("castigocarteravencida.iniciolinea.nombrearchivo"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("castigocarteravencida.titulo"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se arma el cuerpo de la cadena (reporte)
		for (int i = 0; i < 26; i++) {
				final StringBuffer cuerpo = new StringBuffer();
				cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
				cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
				cuerpo.append(i + 1);
				cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
				cuerpo.append(ReadProperties.reportes.getProp("castigocarteravencida." + (i + 1) + ".titulo"));
				cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
				cuerpo.append( ( new java.text.DecimalFormat( "0.00" ) ).format( textosFinales[ i ].getMonto().doubleValue() ) );
				cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
				cuerpo.append(textosFinales[i].getTexto());
				cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
				cadena.add(cuerpo.toString());

				resultadoFinal = resultadoFinal.add( new BigDecimal( textosFinales[i].getMonto().doubleValue() ) );
		}

		//Se arma el final de la cadena (reporte)
		final String finArchivo = generarFinReporte(27, resultadoFinal);
		cadena.add(finArchivo.toString());

		respuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Castigo Venta de Cartera Vencida....... Salida OK");

		return respuesta;
	}


	public ReportesContablesRespuesta generarReporteRiesgoCredito(String uid, ReportesContablesPeticion peticion) 
		{
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Riesgo Credito....... Entrada OK");

		//Se crea el objeto de respuesta
		final ReportesContablesRespuesta
					reportesContablesRespuesta = new ReportesContablesRespuesta();

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Textos para finalizar la linea
		final LineaContableOV textosFinales [] = {
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo2" ), BigDecimal.ZERO ),
/*10*/			new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesfiragrupo3" ), calculaValor( "2210110" ).add( calculaValor( "2210115" ) ) ), 
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), calculaValor( "1110100-1129999" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), BigDecimal.ZERO ),
/*20*/			new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo1" ), calculaValor( "1130500" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.operacionesotrogrupo3" ), calculaValor( "1140100" ).add( calculaValor( "1150100" ) ).subtract( calculaValor( "2210110-2210115" ) ).add( calculaValor( "1140200" ).add( calculaValor( "1150200" ) ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
/*30*/			new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo1" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo2" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgocredito.finlinea.noelegiblesfiragrupo3" ), BigDecimal.ZERO )};

		//Variables necesarias
		final List<String> cadena = new ArrayList<String>();
		final StringBuffer encabezado = new StringBuffer();
		BigDecimal resultadoFinal = BigDecimal.ZERO;

		//Se arma el encabezado de la cadena a regresar
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(ReadProperties.reportes.getProp("riesgocredito.cabecera.numeroreporte"));
		encabezado.append(ReadProperties.reportes.getProp("riesgocredito.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("riesgocredito.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se arma el cuerpo de la cadena a regresar
		for (int i = 1; i <= 39; i++) {
			final StringBuffer cadenaTemp = new StringBuffer();
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( i );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(ReadProperties.reportes.getProp("riesgocredito." + i + ".titulo"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( ( new java.text.DecimalFormat( "0.00" ) ).format( textosFinales[i - 1].getMonto().doubleValue() ) );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( textosFinales[i - 1].getTexto() );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cadenaTemp.toString());

			resultadoFinal = resultadoFinal.add( new BigDecimal( textosFinales[i - 1].getMonto().doubleValue() ) );
			}

		//Se arma el resultado de la cadena que se regresara
		final String finArchivo = generarFinReporte(40, resultadoFinal);

		//Se agrega el fin de archivo
		cadena.add( finArchivo );

		//Se agregan las cadenas al objeto respuesta
		reportesContablesRespuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Riesgo Credito....... Salida OK");

		return reportesContablesRespuesta;
		}


	public ReportesContablesRespuesta generarReporteRiesgoMercado(String uid,
			ReportesContablesPeticion peticion) {
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Riesgo Mercado....... Entrada OK");

		//Objeto para la respuesta
		final ReportesContablesRespuesta
	respuesta = new ReportesContablesRespuesta();

		//Se cargan las cuentas de ser necesario
		cargarCuentas( peticion.getFecha() );

		//Textos para finalizar la linea
		final LineaContableOV textosFinales [] = {
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), calculaValor( "1110100-1129999" ).add( obtenerDatosRiesgoMercado( uid, "1 a 7 dias", "I" ) ).add( obtenerDatosRiesgoMercado( uid, "1 a 7 dias", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), calculaValor( "1160000-1209999" ).add( calculaValor( "1330000-1339999" ) ).add( obtenerDatosRiesgoMercado( uid, "7 dias a 1 mes", "I" ) ).add( obtenerDatosRiesgoMercado( uid, "7 dias a 1 mes", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), obtenerDatosRiesgoMercado( uid, "1 a 3 meses", "I" ).add( obtenerDatosRiesgoMercado( uid, "1 a 3 meses", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), obtenerDatosRiesgoMercado( uid, "3 a 6 meses", "I" ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), calculaValor( "1131900" ).add( calculaValor( "1130500" ) ).add( obtenerDatosRiesgoMercado( uid, "6 meses a 1 a�o", "I" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apain" ), BigDecimal.ZERO ),
/*10*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), calculaValor( "1110100-1129999" ).add( obtenerDatosRiesgoMercado( uid, "1 a 7 dias", "I" ) ).add( obtenerDatosRiesgoMercado( uid, "1 a 7 dias", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), calculaValor( "1160000-1209999" ).add( calculaValor( "1330000-1339999" ) ).add( obtenerDatosRiesgoMercado( uid, "7 dias a 1 mes", "I" ) ).add( obtenerDatosRiesgoMercado( uid, "7 dias a 1 mes", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), recuperarValorDatosHistoricos( uid, "RMP3", "01", null ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), recuperarValorDatosHistoricos( uid, "RMP4", "01", null ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acain" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
/*20*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.apair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
/*30*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.acair" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), recuperarValorDatosHistoricos( uid, "RMP2", "01", null ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), recuperarValorDatosHistoricos( uid, "RMP3", "01", null ) ),
/*40*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), recuperarValorDatosHistoricos( uid, "RMP4", "01", null ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), calculaValor( "1110100-1129999" ).add( obtenerDatosRiesgoMercado( uid, "1 a 7 dias", "I" ) ).add( obtenerDatosRiesgoMercado( uid, "1 a 7 dias", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), calculaValor( "1160000-1209999" ).add( calculaValor( "1330000-1339999" ) ).add( obtenerDatosRiesgoMercado( uid, "7 dias a 1 mes", "I" ) ).add( obtenerDatosRiesgoMercado( uid, "7 dias a 1 mes", "E" ) ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), recuperarValorDatosHistoricos( uid, "RMP3", "01", null ) ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), recuperarValorDatosHistoricos( uid, "RMP4", "01", null ) ),
/*50*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpin" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
/*60*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pppir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
/*70*/	new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO ),
		new LineaContableOV( ReadProperties.reportes.getProp( "riesgomercado.finlinea.pcpir" ), BigDecimal.ZERO )
		};
		List<String> cadena = new ArrayList<String>();
		BigDecimal resultadoFinal = BigDecimal.ZERO;

		//Se arma el encabezado del reporte
		final StringBuffer encabezado = new StringBuffer();
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("riesgomercado.iniciolinea.nombrearchivo"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("riesgomercado.titulo"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Se arma el cuerpo de la cadena (reporte)
		for (int i = 0; i < 72; i++) {
			StringBuffer cuerpo = new StringBuffer();
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(i + 1);
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(ReadProperties.reportes.getProp("riesgomercado." + (i + 1) + ".titulo"));
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append( ( new java.text.DecimalFormat( "0.00" ) ).format( textosFinales[i].getMonto().doubleValue() ) );
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(textosFinales[i].getTexto());
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cuerpo.toString());

			resultadoFinal = resultadoFinal.add( new BigDecimal( textosFinales[i].getMonto().doubleValue() ) );
			}

		//Se arma el final de la cadena (reporte)
		final String finArchivo = generarFinReporte(73, resultadoFinal);
		cadena.add(finArchivo.toString());

		respuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Riesgo Mercado....... Salida OK");

		return respuesta;
	}


	public ReportesContablesRespuesta generarReporteFinanciamientoRiesgoComun(String uid, ReportesContablesPeticion peticion) 
		{
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Financiamiento Riesgo Comun....... Entrada OK");

		//Se crea el objeto de respuesta
		final ReportesContablesRespuesta
					reportesContablesRespuesta = new ReportesContablesRespuesta();

		//Textos para finalizar la linea
		//final String textosFinales [] = {};

		//Variables necesarias
		final List<String> cadena = new ArrayList<String>();
		final StringBuffer encabezado = new StringBuffer();


		//Se arma el encabezado de la cadena a regresar
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(ReadProperties.reportes.getProp("financiamientoriesgocomun.cabecera.numeroreporte"));
		encabezado.append(ReadProperties.reportes.getProp("financiamientoriesgocomun.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("financiamientoriesgocomun.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Se arma el cuerpo de la cadena a regresar
		for (int i = 1; i <= 1; i++)	{
			final StringBuffer cadenaTemp = new StringBuffer();
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(i);
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(ReadProperties.reportes.getProp("financiamientoriesgocomun." + i + ".titulo"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( 0 );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cadenaTemp.toString());
			}

		//Se arma el resultado de la cadena que se regresara
		final String finArchivo = generarFinReporte(2, BigDecimal.ZERO);

		//Se agrega el fin de archivo
		cadena.add( finArchivo );

		//Se agregan las cadenas al objeto respuesta
		reportesContablesRespuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Financiamiento Riesgo Comun....... Salida OK");

		return reportesContablesRespuesta;
		}


	public ReportesContablesRespuesta generarReporteCreditosRelacionados(String uid, ReportesContablesPeticion peticion) 
		{
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Creditos Relacionados....... Entrada OK");

		//Se crea el objeto de respuesta
		final ReportesContablesRespuesta
					reportesContablesRespuesta = new ReportesContablesRespuesta();

		//Textos para finalizar la linea
		//final String textosFinales [] = {};

		//Variables necesarias
		final List<String> cadena = new ArrayList<String>();
		final StringBuffer encabezado = new StringBuffer();

		//Se arma el encabezado de la cadena a regresar
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(ReadProperties.reportes.getProp("creditosrelacionados.cabecera.numeroreporte"));
		encabezado.append(ReadProperties.reportes.getProp("creditosrelacionados.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separadornombres"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("creditosrelacionados.cabecera.nombrereporte"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Se arma el cuerpo de la cadena a regresar
		for (int i = 1; i <= 1; i++)	{
			final StringBuffer cadenaTemp = new StringBuffer();
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(i);
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append(ReadProperties.reportes.getProp("creditosrelacionados." + i + ".titulo"));
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( "NULO" );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( 0 );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadenaTemp.append( 0 );
			cadenaTemp.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cadenaTemp.toString());
			}

		//Se arma el resultado de la cadena que se regresara
		final String finArchivo = generarFinReporte(2, BigDecimal.ZERO);

		//Se agrega el fin de archivo
		cadena.add( finArchivo );

		//Se agregan las cadenas al objeto respuesta
		reportesContablesRespuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Creditos Relacionados....... Salida OK");

		return reportesContablesRespuesta;
		}


	public ReportesContablesRespuesta generarReporteCapitalNeto(String uid,
			ReportesContablesPeticion peticion) {
		LogHandler.info(uid, getClass(), "Se generar� el reporte de Capital Neto....... Entrada OK");

		ReportesContablesRespuesta respuesta = new ReportesContablesRespuesta();
		List<String> cadena = new ArrayList<String>();

		//Textos para finalizar la linea
		final String textosFinales [] = {
				ReadProperties.reportes.getProp("capitalneto.finlinea.primerparte") ,
				ReadProperties.reportes.getProp("capitalneto.finlinea.primerparte") ,
				ReadProperties.reportes.getProp("capitalneto.finlinea.primerparte") ,
				ReadProperties.reportes.getProp("capitalneto.finlinea.segundaparte") ,
				ReadProperties.reportes.getProp("capitalneto.finlinea.segundaparte") ,
				ReadProperties.reportes.getProp("capitalneto.finlinea.segundaparte") ,
				ReadProperties.reportes.getProp("capitalneto.finlinea.segundaparte") ,
		};

		//Se arma el encabezado del reporte
		final StringBuffer encabezado = new StringBuffer();
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.encabezado"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("capitalneto.iniciolinea.nombrearchivo"));
		encabezado.append(formatMesAnio.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.extension"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.empresa"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.numeroregistro"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(formatFecha.format(peticion.getFecha()));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.uno"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		encabezado.append(ReadProperties.reportes.getProp("capitalneto.titulo"));
		encabezado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		cadena.add(encabezado.toString());

		//Se realizan los calculos
		cargarCuentas( peticion.getFecha() );

		//Se arma el cuerpo de la cadena (reporte)
		for (int i = 0 ; i < 7 ; i++) {
			StringBuffer cuerpo = new StringBuffer();
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.linea"));
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(i + 1);
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(ReadProperties.reportes.getProp("capitalneto." + (i + 1) + ".titulo"));
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(0);
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cuerpo.append(textosFinales[i]);
			cuerpo.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
			cadena.add(cuerpo.toString());
		}

		//Se arma el final de la cadena (reporte)
		final String finArchivo = generarFinReporte(8, BigDecimal.ZERO);
		cadena.add(finArchivo.toString());

		respuesta.setCadena(cadena);

		LogHandler.info(uid, getClass(), "Se gener� el reporte de Capital Neto....... Salida OK");

		return respuesta;
	}

	/**
	 * M�todo para armar la linea final de los reportes.
	 *
	 * @param numeroLinea the numero linea
	 * @param montoFinal the monto final
	 * @return the string
	 */
	private String generarFinReporte(Integer numeroLinea, BigDecimal montoFinal)
		{
		final StringBuffer resultado = new StringBuffer();
		resultado.append(ReadProperties.reportes.getProp("reportes.contables.resultado"));
		resultado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		resultado.append(numeroLinea);
		resultado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));
		resultado.append( ( new java.text.DecimalFormat( "0.00" ) ).format( montoFinal.doubleValue() ) );
		resultado.append(ReadProperties.reportes.getProp("reportes.contables.separador"));

		return resultado.toString();
		}

	/**
	 * Calcula valor.
	 *
	 * @param rangoCuentas the rango cuentas
	 * @return the java.math. big decimal
	 */
	private static java.math.BigDecimal calculaValor( java.lang.String rangoCuentas )
		{
		//Se crea el objeto para la respuesta
		java.math.BigDecimal montoCalculado = BigDecimal.ZERO;

		//Se le asigna la cuenta
		java.lang.String [] cuentas = { rangoCuentas.trim() };

		//Si corresponde a un rango de cuentas obtenemos los limites
		if ( rangoCuentas.contains( "-" ) ) {
			cuentas = rangoCuentas.split( "-" );
			}

		//Se verifica, si no hay rango, se regresa el valor obtenido de la consulta a la BD, sino se calcula
		if ( cuentas.length == 1 ) {
			montoCalculado = mapaCuentas.get( cuentas[0] ) == null ? BigDecimal.ZERO : mapaCuentas.get( cuentas[0] ).getSaldoFinal( mesConsulta ).setScale( 2, BigDecimal.ROUND_HALF_UP );
			}
		else
			{
			//Los rangos para efectuar la suma
			final java.lang.Long rangoInferior = Long.valueOf( cuentas[0].trim() );
			final java.lang.Long rangoSuperior = Long.valueOf( cuentas[1].trim() );

			for ( java.lang.String llave : mapaCuentas.keySet() ) {
				//Valor de la cuenta que sirve como llave
				final java.lang.Long cuentaLlave = Long.valueOf( llave.trim() );

				//Si esta en el rango solicitado, se suma el monto
				if ( cuentaLlave >= rangoInferior && cuentaLlave <= rangoSuperior  )	{
					montoCalculado = montoCalculado.add( mapaCuentas.get( llave ).getSaldoFinal( mesConsulta ) ).setScale( 2, BigDecimal.ROUND_HALF_UP );
					}
				}
			}

		return montoCalculado;
		}

	/**
	 * Calcula valor start with.
	 *
	 * @param startWith the start with
	 * @return the java.math. big decimal
	 */
	private static java.math.BigDecimal calculaValorStartWith( java.lang.String startWith )
		{
		LogHandler.info("0000000000000", ContablesImpl.class, "Se sumaran las cuentas q comiencen con >> " + startWith );

		//Se crea el objeto para la respuesta
		java.math.BigDecimal montoCalculado = BigDecimal.ZERO;

		//Los rangos para efectuar la suma
		for ( java.lang.String llave : mapaCuentas.keySet() ) {
			//Si esta en el rango solicitado, se suma el monto
			if ( llave.startsWith( startWith ) ) {
				montoCalculado = montoCalculado.add( mapaCuentas.get( llave ).getSaldoFinal( mesConsulta ) ).setScale( 2, BigDecimal.ROUND_HALF_UP );
				}
			}

		return montoCalculado;
		}

	/**
	 * Castigo cartera.
	 *
	 * @param uid the uid
	 * @param fechaReporte the fecha reporte
	 * @param mesRestar the mes restar
	 * @param codigo the codigo
	 * @return the big decimal
	 */
	private BigDecimal castigoCartera(String uid, Calendar fechaReporte, Integer mesRestar, String codigo)
		{
		//Se declaran los formatos de las fechas para la cosulta
		final SimpleDateFormat formatFechaMes = new SimpleDateFormat("yyyyMM");

		//Se resta el numero de mes correspondiente a la fecha actual
		final java.util.Calendar
					fechaRefMes = Calendar.getInstance();
					fechaRefMes.setTime(  fechaReporte.getTime() );
					fechaRefMes.add(Calendar.MONTH, ( mesRestar - 1 ) );

		final java.util.Calendar
					fechaRefAnio = Calendar.getInstance();
					fechaRefAnio.setTime(  fechaReporte.getTime() );
					fechaRefAnio.add(Calendar.MONTH, mesRestar );

		BigDecimal montoMes = BigDecimal.ZERO;
		SqlSession sesion = null;

		try	{
			//Se crea una fecha temporal con el limite de 1� de Abril
			final java.util.Calendar
							calendarLimite = Calendar.getInstance();
							calendarLimite.setTime( new SimpleDateFormat( "yyyyMMdd" ).parse( "20130401" ) );

			sesion = FabricaConexiones.obtenerSesionNTx();
			final HashMap <String, Object> params = new HashMap<String, Object>();
			params.put("fechaAnioMes", formatFechaMes.format(fechaRefAnio.getTime()) );

			//Se resta un mes como para realizar la consulta
			params.put("fechaMes", Integer.valueOf( formatFechaMes.format( fechaRefMes.getTime() ) ) );

			//Si el reporte es de meses anteriores al 1� de Abril 2013
			if ( fechaRefAnio.getTime().before( calendarLimite.getTime() ) ) {
				//Se recupera de los datos historicos
				montoMes = recuperarValorDatosHistoricos( uid, codigo, "", fechaRefAnio.getTime() );
				}
			else
				{
				//Se realiza la consulta
				LogHandler.trace( uid, ContablesImpl.class, "==> ContablesImpl - " + ( codigo.trim().equals( "CVMC" ) ? "obtenerMontoCastigoCarteraVencida" : "obtenerMontoVentaCarteraVencida" ) );
				montoMes = (BigDecimal) sesion.selectOne( codigo.trim().equals( "CVMC" ) ? "obtenerMontoCastigoCarteraVencida" : "obtenerMontoVentaCarteraVencida", params);
				}

			//Valida q no sea cero
			if ( montoMes == null ) {
				montoMes = BigDecimal.ZERO; 	}
			}
		catch (Exception e)
			{
			LogHandler.error( uid, ContablesImpl.class, "No se pudieron obtener el monto", e);
			}
		finally
			{
			FabricaConexiones.close( sesion );
			}

		return montoMes;
		}

	/**
	 * Obtener datos riesgo mercado.
	 *
	 * @param uid the uid
	 * @param etiqueta the etiqueta
	 * @param estado the estado
	 * @return the big decimal
	 */
	private BigDecimal obtenerDatosRiesgoMercado(String uid, String etiqueta, String estado)
		{
		if ( calculosRM == null ) {
			//Session
			SqlSession sessionSybaseIQ = null;

			try	{
				//Se abre la session
				sessionSybaseIQ = FabricaConexiones.obtenerSesionSybaseIQ();

				final java.util.HashMap<String, Object>
								parametros = new HashMap<String, Object>();
								parametros.put( "yearmonth", Integer.valueOf( new SimpleDateFormat( "yyyyMM" ).format( fechaReportesContables ) ) );
								parametros.put( "ultimoDiaMes", obtenerUltimoDia( Integer.valueOf( new SimpleDateFormat( "MM" ).format( fechaReportesContables ) ) ) );
								parametros.put( "ultimoDiaMes", new SimpleDateFormat( "yyyyMM" ).format( fechaReportesContables ) + parametros.get( "ultimoDiaMes" ).toString() );

				//Se realiza la consulta
				LogHandler.trace(uid, getClass(), "==> obtenerDatosRiesgoMercado - obtenerDatosRM" );
				calculosRM = (List<HashMap<String, Object>>)sessionSybaseIQ.selectList( "obtenerDatosRM", parametros );
				}
			catch ( java.lang.Exception exception )	{
				LogHandler.error(uid, getClass(), "Se fallo al recuperar los datos del RM.", exception );

				//Se fallo al cargar los datos, para evitar fallos posteriors se inicializa la lista
				calculosRM = new ArrayList<HashMap<String,Object>>();
				}
			finally
				{
				FabricaConexiones.close( sessionSybaseIQ );
				}
			}//Fin de if para saber si se deben cargar o no los datos

		//Se busca el bucket y el estado para regresar el dato correcto
		for( HashMap<String, Object> calculo : calculosRM )
			{
			if( calculo.get( "bucket" ).toString().trim().equals( etiqueta.trim() ) &&
					calculo.get( "status" ).toString().trim().equals( estado.trim() ) )
				{
				return new BigDecimal( calculo.get( "monto" ).toString() );
				}
			}

		LogHandler.error(uid, getClass(), "No se encontro el bucket", new Exception( "Bucket no encontrado : <" +  etiqueta + ", " + estado + ">") );
		return BigDecimal.ZERO;
		}

	/**
	 * Sirve para recuperar el ultimo dia del mes, junto con el mes.
	 *
	 * @param mes the mes
	 * @return the java.lang. string
	 */
	private java.lang.String obtenerUltimoDia( Integer mes )
		{
		final java.lang.String [] dias = {"31", "28-29", "31", "30",
										   "31", "30"   , "31", "31",
										   "30", "31"   , "30", "31"};

		return mes.intValue() == 2 ? dias[1].split( "-" )[0] : dias[ mes - 1 ];
		}

	/**
	 * Recupera un dato de los valores historicos.
	 *
	 * @param uid the uid
	 * @param codigo the codigo
	 * @param cuandoDia si recibe 01 es el primer dia del mes, de lo contrario sera el ultimo
	 * @param fechaRef the fecha ref
	 * @return the java.math. big decimal
	 */
	private java.math.BigDecimal recuperarValorDatosHistoricos( java.lang.String uid, java.lang.String codigo, java.lang.String cuandoDia, java.util.Date fechaRef )
		{
		//Objeto para la respuesta
		BigDecimal respuesta = BigDecimal.ZERO;

		//Objeto para abrir la session a la BD
		SqlSession sessionNTx = null;

		try	{
			//Se pide una conexi�n
			sessionNTx = FabricaConexiones.obtenerSesionNTx();

			//Parametros
			final java.util.HashMap<String, Object>
							parametros = new HashMap<String, Object>();
							parametros.put( "codigo", codigo );
							parametros.put( "fecha" , new SimpleDateFormat( "yyyyMM" ).format( fechaRef == null ? fechaReportesContables : fechaRef ) +
										( cuandoDia.trim().equals( "01" ) ? "01"
										: obtenerUltimoDia( Integer.valueOf( new SimpleDateFormat( "MM" ).format( fechaRef == null ? fechaReportesContables : fechaRef ) ) ) ) );

			LogHandler.trace( uid, getClass(), "==> recuperarValorDatosHistoricos - obtenerValorHistorico" );
			final java.lang.Double
							consultaValor = (Double) sessionNTx.selectOne( "obtenerValorHistorico", parametros );

			//Se asigna la respuesta
			respuesta =  new BigDecimal( consultaValor != null ? consultaValor.doubleValue() : 0 );
			}
		catch ( java.lang.Exception exception ) {
			LogHandler.error(uid, getClass(), "Error al intentar recuperar el valor historico", exception );
			}
		finally
			{
			FabricaConexiones.close( sessionNTx );
			}

		return respuesta;
		}


	/**
	 * Metodo para consultar los pagos importados de una fecha solicitada.
	 * @param uid identificador unico de la peticion.
	 * @param  peticion  contiene la fecha para generar el reporte de pagos importados.
	 * @return respuesta lista de pagos importados.
	 */
	public PagosImportadosRespuesta generarReportePagosImportados(String uid, PagosImportadosPeticion peticion) {
		PagosImportadosRespuesta respuesta = new PagosImportadosRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setMensaje("Reporte generado correctamente.");

		//Objeto para abrir la session a la BD
		SqlSession sessionNTx = null;

		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

		try {

			if ( peticion.getFecha() == null || peticion.getFecha().trim().isEmpty()) {
				throw new Exception("La fecha es obligatoria en la peticion.");
			}

			//Se pide una conexion
			sessionNTx = FabricaConexiones.obtenerSesionBatch();

			LogHandler.trace( uid, getClass(), "==> generarReportePagosImportados - obtenerPagosImportados" );
			final List<PagoImportado> pagosImportados
				= (List<PagoImportado>) sessionNTx.selectList("obtenerPagosImportados", peticion.getFecha().trim());

			if (pagosImportados == null || pagosImportados.size() == 0) {
				throw new Exception("La consulta no regreso datos para la fecha ["
						+ peticion.getFecha().trim() + "].");
			}

			for (int i = 0; i < pagosImportados.size(); i++) {

				Date dateProceso = sdf2.parse(pagosImportados.get(i).getFechaProceso());

				pagosImportados.get(i).setFechaProceso(sdf3.format(dateProceso));

				Date dateValor = sdf2.parse(pagosImportados.get(i).getFechaValor());

				pagosImportados.get(i).setFechaValor(sdf3.format(dateValor));

				pagosImportados.get(i).setObservaciones(pagosImportados.get(i).getObservaciones().toUpperCase());

				if (!pagosImportados.get(i).getMedioPago().trim().equals("HSBC")) {

					if (pagosImportados.get(i).getMedioPago().trim().equals("BANAMEX")
						&& (pagosImportados.get(i).getContrato() == null || pagosImportados.get(i).getContrato().trim().isEmpty())
						&& pagosImportados.get(i).getOrigen().trim().equals("pagos_externos")) {

					if (pagosImportados.get(i).getContratoLD().trim().length() >= 18
							&& !pagosImportados.get(i).getContratoLD().startsWith("LD")) {
						String numPersona = pagosImportados.get(i).getContratoLD().trim().substring(9, 18);

						pagosImportados.get(i).setContratoLD("CTE" + numPersona);
					}

					}

					if (pagosImportados.get(i).getMedioPago().trim().equals("BANCOMER")
						&& (pagosImportados.get(i).getContrato() == null || pagosImportados.get(i).getContrato().trim().isEmpty())
							&& pagosImportados.get(i).getOrigen().trim().equals("pagos_externos")) {

						if (pagosImportados.get(i).getContratoLD().trim().length() >= 20
								&& !pagosImportados.get(i).getContratoLD().startsWith("LD")) {
							String numPersona = pagosImportados.get(i).getContratoLD().trim().substring(11, 20);

							pagosImportados.get(i).setContratoLD("CTE" + numPersona);
						}

					}

				} //end if 1

		} //end for

			LogHandler.info( uid, getClass(), "==> Se obtubieron:" + pagosImportados.size() );
			respuesta.setPagos(pagosImportados);

		} catch (Exception ex) {
			LogHandler.error(uid, getClass(), "generarReportePagosImportados", ex );
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje(ex.getMessage());
		}
		finally {
			FabricaConexiones.close( sessionNTx );
		}
		return respuesta;
	}
}
