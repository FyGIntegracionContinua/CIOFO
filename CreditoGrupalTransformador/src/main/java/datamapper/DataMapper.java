
package datamapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import utilitario.log.LogHandler;

/**
 * @author Juan Carlos Moreno
 *
 */

@SuppressWarnings({ "rawtypes", "unchecked" })
public class DataMapper {

	/**
	 * OPER_OBTENER_CLAVES_ENTIDADES String
	 */
	private static final String OPER_OBTENER_CLAVES_ENTIDADES	= "obtenerClavesEntidades";
	/**
	 * ESTADO String
	 */
	private static final  String ESTADO					= "estado";
	/**
	 * CODIGO_FINANCIERA String
	 */
	private static final  String CODIGO_FINANCIERA		= "codigo_financiera";

	/**
	 * DEFAULT_FRECUENCIA_PAGO String
	 */
	private static final String DEFAULT_FRECUENCIA_PAGO	= "S";		//SEMANAL
	/**
	 * DEFAULT_ESTADO_CIVIL String
	 */
	private static final String DEFAULT_ESTADO_CIVIL	= "C";		//CASADO
	/**
	 * DEFAULT_PRODUCTO String
	 */
	private static final String DEFAULT_PRODUCTO 		= "GCS1"; 	//CREDITO COMUNAL
	/**
	 * DEFAULT_PRODUCTO_FSOL String
	 */
	private static final String DEFAULT_PRODUCTO_FSOL	= "21050"; 	//CREDITO COMUNAL

	/**
	 * SUFIJO_ENTIDAD String
	 */
	private static final String SUFIJO_ENTIDAD			= "SUR";

	/**
	 * horaMinima String
	 */
	public static final String horaMinima = "07:59";
	/**
	 * horaMaxima String
	 */
	public static final String horaMaxima = "18:31";

	/**
	 * mapFrecuencia Map<String,String>
	 */
	private static Map<String, String> mapFrecuencia		= new HashMap<String, String>();
	/**
	 * mapEntidades Map<String,String>
	 */
	private static Map<String, String> mapEntidades		= new LinkedHashMap<String, String>();
	/**
	 * mapEstadoCivil Map<String,String>
	 */
	private static Map<String, String> mapEstadoCivil	= new HashMap<String, String>();
	/**
	 * mapProductos Map<String,String>
	 */
	public static Map<String, String> mapProductos		= new HashMap<String, String>();
	/**
	 * mapProductosFsol Map<String,String>
	 */
	public static Map<String, String> mapProductosFsol  	= new HashMap<String, String>();
	/**
	 * mapMedioPago Map<String,String>
	 */
	public static Map<String, String> mapMedioPago		= new HashMap<String, String>();

	/**
	 * mapEscolaridadOracle Map<String,Integer>
	 */
	public static Map<String, Integer> mapEscolaridadOracle		= new HashMap<String, Integer>();
	/**
	 * mapTipoViviendaOracle Map<String,Integer>
	 */
	public static Map<String, Integer> mapTipoViviendaOracle		= new HashMap<String, Integer>();
	/**
	 * mapRelacionOracle Map<String,Integer>
	 */
	public static Map<String, Integer> mapRelacionOracle		= new HashMap<String, Integer>();
	/**
	 * mapTipoActividadOracle Map<String,Integer>
	 */
	public static Map<String, Integer> mapTipoActividadOracle		= new HashMap<String, Integer>();
	/**
	 * mapTipoNegocioOracle Map<String,Integer>
	 */
	public static Map<String, Integer> mapTipoNegocioOracle		= new HashMap<String, Integer>();
	/**
	 * mapGiroNegocioOracle Map<String,Integer>
	 */
	public static Map<String, Integer> mapGiroNegocioOracle		= new HashMap<String, Integer>();

	/**
	 * mapEntidadesOracle Map<String,String>
	 */
	public static Map<String, String> mapEntidadesOracle		= new HashMap<String, String>();

	/**
	 * mapCategoriaProductos Map<String,String>
	 */
	public static Map<String, String> mapCategoriaProductos		= new HashMap<String, String>();

 	static {
		//Estados
 		recuperaEstados();

		//Estado Civil T24 -- CREDPROD
		mapEstadoCivil.put("2", "C"); 		//CASADO
		mapEstadoCivil.put("3", "D"); 		//DIVORCIADO
		mapEstadoCivil.put("1", "S"); 		//SOLTERO
		mapEstadoCivil.put("5", "U"); 		//UNION LIBRE
		mapEstadoCivil.put("4", "V"); 		//VIUDO

 		//Frecuencia de Pago T24 -- CREDPROD
		mapFrecuencia.put("W", "S");		//SEMANAL
		mapFrecuencia.put("F", "C");  		//CATORCENAL
		mapFrecuencia.put("M", "M");		//MENSUAL

		//Productos T24 -- CREDPROD
		mapProductos.put("21050", "GCS1"); 	//CREDITO COMUNAL
		mapProductos.put("21057", "GCC1"); 	//CREDITO COMUNAL FORTNIGHT
		mapProductos.put("21056", "GCM1"); 	//CREDITO COMUNAL MONTHLY
		mapProductos.put("21051", "GSS1"); 	//CREDITO GRUPO SOLIDARIO
		mapProductos.put("21059", "GSC1"); 	//CREDITO GRUPO SOLIDARIO FORNIGHT
		mapProductos.put("21060", "GOS1"); 	//CREDITO OPORTUNIDAD
		mapProductos.put("21070", "GCDG"); 	//CREDITO COMUNAL DEPOSITO GARANTIA SEMANAL
		mapProductos.put("21071", "GCDC"); 	//CREDITO COMUNAL DEPOSITO GARANTIA CATORCENAL

		mapProductos.put("GCS1", "GCS1"); 	//CREDITO COMUNAL
		mapProductos.put("GCC1", "GCC1"); 	//CREDITO COMUNAL FORTNIGHT
		mapProductos.put("GCM1", "GCM1"); 	//CREDITO COMUNAL MONTHLY
		mapProductos.put("GSS1", "GSS1"); 	//CREDITO GRUPO SOLIDARIO
		mapProductos.put("GSC1", "GSC1"); 	//CREDITO GRUPO SOLIDARIO FORNIGHT
		mapProductos.put("GOS1", "GOS1"); 	//CREDITO OPORTUNIDAD
		mapProductos.put("GCDG", "GCDG"); 	//CREDITO COMUNAL DEPOSITO GARANTIA SEMANAL
		mapProductos.put("GCDC", "GCDC"); 	//CREDITO COMUNAL DEPOSITO GARANTIA CATORCENAL

		//Productos T24 -- CREDPROD
		mapProductosFsol.put("GCS1", "21050"); 	//CREDITO COMUNAL
		mapProductosFsol.put("GCC1", "21057"); 	//CREDITO COMUNAL FORTNIGHT
		mapProductosFsol.put("GCM1", "21056"); 	//CREDITO COMUNAL MONTHLY
		mapProductosFsol.put("GSS1", "21051"); 	//CREDITO GRUPO SOLIDARIO
		mapProductosFsol.put("GSC1", "21059"); 	//CREDITO GRUPO SOLIDARIO FORNIGHT
		mapProductosFsol.put("GOS1", "21060"); 	//CREDITO OPORTUNIDAD
		mapProductosFsol.put("GCDG", "21070"); 	//CREDITO OPORTUNIDAD
		mapProductosFsol.put("GCDC", "21071"); 	//CREDITO OPORTUNIDAD
		//Medio-pago sirve para identificar la procedencia de los pagos
		//Solo se usa para OFS
		mapMedioPago.put("09", "BCOM");
		mapMedioPago.put("15", "BMEX");
		//mapMedioPago.put("40", "CAJA");
		mapMedioPago.put("06", "HSBC");
		//mapMedioPago.put("80", "EMPR");
		//mapMedioPago.put("60", "RPP");
		mapMedioPago.put("99", "FISA");
		mapMedioPago.put("98", "OXXO");
		mapMedioPago.put("10", "PBMX");
		mapMedioPago.put("17", "PBCM");
		mapMedioPago.put("7", "POXO");
		mapMedioPago.put("9", "PHSB");
		mapMedioPago.put("12", "TRPG");
		mapMedioPago.put("0", "CONT");

		//Medio-pago codigos de servicio por cliente
		mapMedioPago.put("FISA", "CONT");
		mapMedioPago.put("BMEX", "PBMX");
		mapMedioPago.put("BCOM", "PBCM");
		mapMedioPago.put("OXXO", "POXO");
		mapMedioPago.put("HSBC", "PHSB");
		mapMedioPago.put("DEVS", "TRPG");
		mapMedioPago.put("CXIA", "SOLI");

		//Solo se usa para obtener clave de cliente
		mapMedioPago.put("CONT", "0");
		mapMedioPago.put("PBMX", "10");
		mapMedioPago.put("PBCM", "17");
		mapMedioPago.put("POXO", "7");
		mapMedioPago.put("DIES", "26");
		mapMedioPago.put("PHSB", "9");
		mapMedioPago.put("TRPG", "12");
		mapMedioPago.put("SOLI", "12");

		mapMedioPago.put("SOLI_", "CXIA");
		//DepositosGarantia
		mapMedioPago.put("GBMX_", "GBMX");
		mapMedioPago.put("GBCM_", "GBCM");
		mapMedioPago.put("GHSB_", "GHSB");
		mapMedioPago.put("GBMX", "10");
		mapMedioPago.put("GBCM", "17");
		mapMedioPago.put("GHSB", "9");
		mapMedioPago.put("RBMX_", "RBMX");
		mapMedioPago.put("RBCM_", "RBCM");
		mapMedioPago.put("RHSB_", "RHSB");
		mapMedioPago.put("RBMX", "10");
		mapMedioPago.put("RBCM", "17");
		mapMedioPago.put("RHSB", "9");

		//Pagos en linea OXXO
		mapMedioPago.put("POXO_", "POXO");
		//Pagos en linea DIESTEL
		mapMedioPago.put("DIES_", "DIES");

		//ClienteUnico

		mapEscolaridadOracle.put("", 0);

		mapTipoViviendaOracle.put("F", 4);
		mapTipoViviendaOracle.put("H", 5);
		mapTipoViviendaOracle.put("O", 6);
		mapTipoViviendaOracle.put("P", 0);
		mapTipoViviendaOracle.put("R", 1);
		mapTipoViviendaOracle.put("E", 2);
		mapTipoViviendaOracle.put("A", 6);

		mapRelacionOracle.put("01", 5);
		mapRelacionOracle.put("02", 9);
		mapRelacionOracle.put("03", 9);
		mapRelacionOracle.put("04", 9);
		mapRelacionOracle.put("05", 9);
		mapRelacionOracle.put("06", 9);
		mapRelacionOracle.put("07", 7);
		mapRelacionOracle.put("08", 11);
		mapRelacionOracle.put("09", 3);
		mapRelacionOracle.put("10", 13);
		mapRelacionOracle.put("11", 9);
		mapRelacionOracle.put("12", 2);
		mapRelacionOracle.put("13", 9);
		mapRelacionOracle.put("14", 1);
		mapRelacionOracle.put("15", 6);
		mapRelacionOracle.put("16", 11);
		mapRelacionOracle.put("17", 8);
		mapRelacionOracle.put("18", 4);
		mapRelacionOracle.put("19", 9);
		mapRelacionOracle.put("20", 9);
		mapRelacionOracle.put("21", 9);
		mapRelacionOracle.put("", 9);


		mapTipoActividadOracle.put("COME", 1);
		mapTipoActividadOracle.put("OTRO", 4);
		mapTipoActividadOracle.put("PROD", 2);
		mapTipoActividadOracle.put("SERV", 3);
		mapTipoActividadOracle.put("", 4);

		mapTipoNegocioOracle.put("A", 5);
		mapTipoNegocioOracle.put("C", 6);
		mapTipoNegocioOracle.put("H", 2);
		mapTipoNegocioOracle.put("M", 7);
		mapTipoNegocioOracle.put("O", 9);
		mapTipoNegocioOracle.put("P", 3);
		mapTipoNegocioOracle.put("R", 4);
		mapTipoNegocioOracle.put("T", 8);
		mapTipoNegocioOracle.put("U", 10);
		mapTipoNegocioOracle.put("", 9);

		mapEntidadesOracle.put("AGS", "AGUASCALIENTES");
		mapEntidadesOracle.put("BC", "BAJA CALIFORNIA");
		mapEntidadesOracle.put("BCS", "BAJA CALIFORNIA SUR");
		mapEntidadesOracle.put("CAM", "CAMPECHE");
		mapEntidadesOracle.put("COA", "COAHUILA");
		mapEntidadesOracle.put("COL", "COLIMA");
		mapEntidadesOracle.put("CHS", "CHIAPAS");
		mapEntidadesOracle.put("CHI", "CHIHUAHUA");
		mapEntidadesOracle.put("DF", "DISTRITO FEDERAL");
		mapEntidadesOracle.put("DGO", "DURANGO");
		mapEntidadesOracle.put("GTO", "GUANAJUATO");
		mapEntidadesOracle.put("GRO", "GUERRERO");
		mapEntidadesOracle.put("HGO", "HIDALGO");
		mapEntidadesOracle.put("JAL", "JALISCO");
		mapEntidadesOracle.put("MEX", "MEXICO");
		mapEntidadesOracle.put("MIC", "MICHOACAN");
		mapEntidadesOracle.put("MOR", "MORELOS");
		mapEntidadesOracle.put("NAY", "NAYARIT");
		mapEntidadesOracle.put("NL", "NUEVO LEON");
		mapEntidadesOracle.put("OAX", "OAXACA");
		mapEntidadesOracle.put("PUE", "PUEBLA");
		mapEntidadesOracle.put("QRO", "QUERETARO");
		mapEntidadesOracle.put("QR", "QUINTANA ROO");
		mapEntidadesOracle.put("SLP", "SAN LUIS POTOSI");
		mapEntidadesOracle.put("SIN", "SINALOA");
		mapEntidadesOracle.put("SON", "SONORA");
		mapEntidadesOracle.put("TAB", "TABASCO");
		mapEntidadesOracle.put("TAM", "TAMAULIPAS");
		mapEntidadesOracle.put("TLA", "TLAXCALA");
		mapEntidadesOracle.put("VER", "VERACRUZ");
		mapEntidadesOracle.put("YUC", "YUCATAN");
		mapEntidadesOracle.put("ZAC", "ZACATECAS");

		mapGiroNegocioOracle.put("", 0);
		/* mapGiroNegocioOracle.put("ADECUACION Y REPARACION DE INMUEBLES",1);
		mapGiroNegocioOracle.put("ALQUILER DE PELICULAS Y VIDEOJUEGOS",10);
		mapGiroNegocioOracle.put("POLLERIA",100);
		mapGiroNegocioOracle.put("PRODUCTOS DE CUERO Y PIEL",101);
		mapGiroNegocioOracle.put("PRODUCTOS QUIMICOS",102);
		mapGiroNegocioOracle.put("PRODUCTOS TEXTILES",103);
		mapGiroNegocioOracle.put("PROTECCION Y CUSTODIA",104);
		mapGiroNegocioOracle.put("PUBLICIDAD",105);
		mapGiroNegocioOracle.put("RASTROS Y OBRADORES",106);
		mapGiroNegocioOracle.put("REFACCIONARIA",107);
		mapGiroNegocioOracle.put("REFACCIONES Y ACCESORIOS USADAS",108);
		mapGiroNegocioOracle.put("REPARACION DE APARATOS DOMESTICOS",109);
		mapGiroNegocioOracle.put("ALQUILER DE SALONES PARA EVENTOS",11);
		mapGiroNegocioOracle.put("RESTAURANTES Y CAFETERIAS",110);
		mapGiroNegocioOracle.put("ROPA PARA CABALLERO HECHA EN SERIE",111);
		mapGiroNegocioOracle.put("ROPA PARA DAMA HECHA EN SERIE",112);
		mapGiroNegocioOracle.put("ROPA PARA NINOS Y NINAS",113);
		mapGiroNegocioOracle.put("SABANAS MANTELES Y COLCHAS",114);
		mapGiroNegocioOracle.put("SALCHICHONERIA Y CREMERIA",115);
		mapGiroNegocioOracle.put("SALONES DE BELLEZA PELUQUERIAS Y ESTETICAS",116);
		mapGiroNegocioOracle.put("SASTRERIA",117);
		mapGiroNegocioOracle.put("SERVICIO DE TAXI",118);
		mapGiroNegocioOracle.put("SERVICIO DE TRANSPORTE DE CARGA EN GENERAL",119);
		mapGiroNegocioOracle.put("ALQUILER DE TERRENOS Y LOCALES COMERCIALES",12);
		mapGiroNegocioOracle.put("SERVICIO DE TRANSPORTE EN RUTA FIJA",120);
		mapGiroNegocioOracle.put("SERVICIOS DE INFORMATICA",121);
		mapGiroNegocioOracle.put("SERVICIOS DOMESTICOS EN GENERAL",122);
		mapGiroNegocioOracle.put("SERVICIOS JURIDICOS",123);
		mapGiroNegocioOracle.put("SERVICIOS MUSICALES Y DE ESPECTACULOS",124);
		mapGiroNegocioOracle.put("SERVICIOS PRIVADOS DE EDUCACION",125);
		mapGiroNegocioOracle.put("SERVICIOS PRIVADOS DE HOSPITALIZACION",126);
		mapGiroNegocioOracle.put("SERVICIOS TELEFONICOS",127);
		mapGiroNegocioOracle.put("TABAQUERIA",128);
		mapGiroNegocioOracle.put("TALLER DE BICICLETAS",129);
		mapGiroNegocioOracle.put("ALQUILER DE VIVIENDAS",13);
		mapGiroNegocioOracle.put("TALLER DE COSTURA",130);
		mapGiroNegocioOracle.put("TALLER DE HOJALATERIA Y PINTURA",131);
		mapGiroNegocioOracle.put("TALLER DE MOTOCICLETAS",132);
		mapGiroNegocioOracle.put("TALLER DE REFRIGERACION",133);
		mapGiroNegocioOracle.put("TALLER MECANICO",134);
		mapGiroNegocioOracle.put("TAPICERIA",135);
		mapGiroNegocioOracle.put("TELAS Y CASIMIRES",136);
		mapGiroNegocioOracle.put("TEXTILES Y PRENDAS DE VESTIR",137);
		mapGiroNegocioOracle.put("TLAPALERIA Y FERRETERIA",138);
		mapGiroNegocioOracle.put("TORTILLERIA",139);
		mapGiroNegocioOracle.put("APARATOS Y ARTICULOS DEPORTIVOS",14);
		mapGiroNegocioOracle.put("TRANSFERENCIA",140);
		mapGiroNegocioOracle.put("TRANSPORTE FORANEO DE PASAJEROS",141);
		mapGiroNegocioOracle.put("TRANSPORTE URBANO DE PASAJEROS",142);
		mapGiroNegocioOracle.put("UNIFORMES Y ROPA DE TRABAJO",143);
		mapGiroNegocioOracle.put("VENTA DE ANTOJITOS",144);
		mapGiroNegocioOracle.put("VENTA DE CALZADO",145);
		mapGiroNegocioOracle.put("VENTA DE CERVEZA",146);
		mapGiroNegocioOracle.put("VENTA DE HUEVO",147);
		mapGiroNegocioOracle.put("VENTA DE REFRESCOS",148);
		mapGiroNegocioOracle.put("VENTA DE ROPA",149);
		mapGiroNegocioOracle.put("APARATOS Y ARTICULOS ORTOPEDICOS",15);
		mapGiroNegocioOracle.put("VENTA REPARACION Y MANTENIMIENTO DE EQUIPO DE COMPUTO",150);
		mapGiroNegocioOracle.put("VETERINARIA",151);
		mapGiroNegocioOracle.put("VIDRIOS Y ALUMINIO",152);
		mapGiroNegocioOracle.put("VULCANIZADORA",153);
		mapGiroNegocioOracle.put("ZAPATERO",154);
		mapGiroNegocioOracle.put("NINGUNA",155);
		mapGiroNegocioOracle.put("VENTA DE PRODUCTOS NATURALES",156);
		mapGiroNegocioOracle.put("ABARROTES",157);
		mapGiroNegocioOracle.put("BISUTERIA",158);
		mapGiroNegocioOracle.put("AGRICULTURA",159);
		mapGiroNegocioOracle.put("APICULTURA",16);
		mapGiroNegocioOracle.put("GANADERIA",160);
		mapGiroNegocioOracle.put("PESCA, CAZA Y CAPTURA",161);
		mapGiroNegocioOracle.put("AGUA Y SUMINISTRO DE GAS POR DUCTOS AL CONSUMIDOR FINAL",162);
		mapGiroNegocioOracle.put("EDIFICACION",163);
		mapGiroNegocioOracle.put("CONSTRUCCION DE OBRAS DE INGENIERIA CIVIL U OBRA PESADA",164);
		mapGiroNegocioOracle.put("TRABAJOS ESPECIALIZADOS PARA LA CONSTRUCCION",165);
		mapGiroNegocioOracle.put("INDUSTRIA ALIMENTARIA",166);
		mapGiroNegocioOracle.put("INDUSTRIA DE LAS BEBIDAS Y DEL TABACO",167);
		mapGiroNegocioOracle.put("FABRICACION DE INSUMOS TEXTILES",168);
		mapGiroNegocioOracle.put("CONFECCION DE PRODUCTOS TEXTILES, EXCEPTO PRENDAS DE VESTIR",169);
		mapGiroNegocioOracle.put("ARTESANIAS",17);
		mapGiroNegocioOracle.put("FABRICACION DE PRENDAS DE VESTIR",170);
		mapGiroNegocioOracle.put("FABRICACION DE PRODUCTOS DE CUERO, PIEL Y MATERIALES SUCEDANEOS, EXCEPTO PRENDAS",171);
		mapGiroNegocioOracle.put("INDUSTRIA DE LA MADERA",172);
		mapGiroNegocioOracle.put("INDUSTRIA DEL PAPEL",173);
		mapGiroNegocioOracle.put("IMPRESION E INDUSTRIAS CONEXAS",174);
		mapGiroNegocioOracle.put("FABRICACION DE PRODUCTOS DERIVADOS DEL PETROLEO Y DEL CARBON",175);
		mapGiroNegocioOracle.put("INDUSTRIA QUIMICA",176);
		mapGiroNegocioOracle.put("INDUSTRIA DEL PLASTICO Y DEL HULE",177);
		mapGiroNegocioOracle.put("FABRICACION DE PRODUCTOS A BASE DE MINERALES NO METALICOS",178);
		mapGiroNegocioOracle.put("INDUSTRIAS METALICAS BASICAS",179);
		mapGiroNegocioOracle.put("ARTICULOS DE PLASTICO PARA EL HOGAR",18);
		mapGiroNegocioOracle.put("FABRICACION DE PRODUCTOS METALICOS",180);
		mapGiroNegocioOracle.put("FABRICACION DE MAQUINARIA Y EQUIPO",181);
		mapGiroNegocioOracle.put("FABRICACION DE EQUIPO DE COMPUTACION, COMUNICACION, MEDICION Y DE OTROS EQUIPOS,",182);
		mapGiroNegocioOracle.put("FABRICACION DE EQUIPO DE GENERACION ELECTRICA Y APARATOS Y ACCESORIOS ELECTRICOS",183);
		mapGiroNegocioOracle.put("FABRICACION DE EQUIPO DE TRANSPORTE",184);
		mapGiroNegocioOracle.put("FABRICACION DE MUEBLES Y PRODUCTOS RELACIONADOS",185);
		mapGiroNegocioOracle.put("OTRAS INDUSTRIAS MANUFACTURERAS",186);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE ALIMENTOS, BEBIDAS Y TABACO",187);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR EN TIENDAS DE AUTOSERVICIO Y DEPARTAMENTALES",188);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE PRODUCTOS TEXTILES, ACCESORIOS DE VESTIR Y CALZADO",189);
		mapGiroNegocioOracle.put("ARTICULOS PARA EL HOGAR",19);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE ARTICULOS PARA EL CUIDADO DE LA SALUD",190);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE ARTICULOS DE PAPELERIA, PARA EL ESPARCIMIENTO Y OTROS A",191);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE ENSERES DOMESTICOS, COMPUTADORAS Y ARTICULOS PARA LA DE",192);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE ARTICULOS DE FERRETERIA, TLAPALERIA Y VIDRIOS",193);
		mapGiroNegocioOracle.put("COMERCIO AL POR MENOR DE VEHICULOS DE MOTOR, REFACCIONES, COMBUSTIBLES Y LUBRICA",194);
		mapGiroNegocioOracle.put("INTERMEDIACION Y COMERCIO AL POR MENOR POR MEDIOS MASIVOS DE COMUNICACION Y OTRO",195);
		mapGiroNegocioOracle.put("TRANSPORTE AEREO",196);
		mapGiroNegocioOracle.put("TRANSPORTE POR FERROCARRIL",197);
		mapGiroNegocioOracle.put("TRANSPORTE POR AGUA",198);
		mapGiroNegocioOracle.put("AUTOTRANSPORTE DE CARGA",199);
		mapGiroNegocioOracle.put("AGENCIA DE VIAJES",2);
		mapGiroNegocioOracle.put("ARTICULOS RELIGIOSOS",20);
		mapGiroNegocioOracle.put("TRANSPORTE TERRESTRE DE PASAJEROS, EXCEPTO POR FERROCARRIL",200);
		mapGiroNegocioOracle.put("TRANSPORTE TURISTICO",201);
		mapGiroNegocioOracle.put("SERVICIOS RELACIONADOS CON EL TRANSPORTE",202);
		mapGiroNegocioOracle.put("SERVICIOS POSTALES",203);
		mapGiroNegocioOracle.put("SERVICIOS DE MENSAJERIA Y PAQUETERIA",204);
		mapGiroNegocioOracle.put("SERVICIOS DE ALMACENAMIENTO",205);
		mapGiroNegocioOracle.put("EDICION DE PUBLICACIONES Y DE SOFTWARE, EXCEPTO A TRAVES DE INTERNET",206);
		mapGiroNegocioOracle.put("INDUSTRIA FILMICA Y DEL VIDEO, E INDUSTRIA DEL SONIDO",207);
		mapGiroNegocioOracle.put("RADIO Y TELEVISION, EXCEPTO A TRAVES DE INTERNET",208);
		mapGiroNegocioOracle.put("CREACION Y DIFUSION DE CONTENIDO EXCLUSIVAMENTE A TRAVES DE INTERNET",209);
		mapGiroNegocioOracle.put("ARTICULOS USADOS PARA EL HOGAR",21);
		mapGiroNegocioOracle.put("OTRAS TELECOMUNICACIONES",210);
		mapGiroNegocioOracle.put("PROVEEDORES DE ACCESO A INTERNET, SERVICIOS DE BUSQUEDA EN LA RED Y SERVICIOS DE",211);
		mapGiroNegocioOracle.put("OTROS SERVICIOS DE INFORMACION",212);
		mapGiroNegocioOracle.put("COMPA�IAS DE FIANZAS, SEGUROS Y PENSIONES",213);
		mapGiroNegocioOracle.put("SERVICIOS INMOBILIARIOS",214);
		mapGiroNegocioOracle.put("SERVICIOS DE ALQUILER DE BIENES MUEBLES",215);
		mapGiroNegocioOracle.put("SERVICIOS DE ALQUILER DE MARCAS REGISTRADAS, PATENTES Y FRANQUICIAS",216);
		mapGiroNegocioOracle.put("SERVICIOS PROFESIONALES, CIENTIFICOS Y TECNICOS",217);
		mapGiroNegocioOracle.put("SERVICIOS DE APOYO A LOS NEGOCIOS",218);
		mapGiroNegocioOracle.put("SERVICIOS DE ADMINISTRACION DE NEGOCIOS",219);
		mapGiroNegocioOracle.put("AUTOLAVADO",22);
		mapGiroNegocioOracle.put("SERVICIOS COMBINADOS DE APOYO EN INSTALACIONES",220);
		mapGiroNegocioOracle.put("SERVICIOS DE EMPLEO",221);
		mapGiroNegocioOracle.put("SERVICIOS DE APOYO SECRETARIAL, FOTOCOPIADO, COBRANZA, INVESTIGACION CREDITICIA",222);
		mapGiroNegocioOracle.put("AGENCIAS DE VIAJES Y SERVICIOS DE RESERVACIONES",223);
		mapGiroNegocioOracle.put("SERVICIOS DE INVESTIGACION, PROTECCION Y SEGURIDAD",224);
		mapGiroNegocioOracle.put("SERVICIOS DE LIMPIEZA",225);
		mapGiroNegocioOracle.put("OTROS SERVICIOS DE APOYO A LOS NEGOCIOS",226);
		mapGiroNegocioOracle.put("SERVICIOS EDUCATIVOS",227);
		mapGiroNegocioOracle.put("SERVICIOS MEDICOS DE CONSULTA EXTERNA Y SERVICIOS RELACIONADOS",228);
		mapGiroNegocioOracle.put("HOSPITALES",229);
		mapGiroNegocioOracle.put("AVICULTURA",23);
		mapGiroNegocioOracle.put("RESIDENCIAS DE ASISTENCIA SOCIAL Y PARA EL CUIDADO DE LA SALUD",230);
		mapGiroNegocioOracle.put("OTROS SERVICIOS DE ASISTENCIA SOCIAL",231);
		mapGiroNegocioOracle.put("SERVICIOS ARTISTICOS Y DEPORTIVOS Y OTROS SERVICIOS RELACIONADOS",232);
		mapGiroNegocioOracle.put("MUSEOS, SITIOS HISTORICOS, JARDINES BOTANICOS Y SIMILARES",233);
		mapGiroNegocioOracle.put("SERVICIOS DE ENTRETENIMIENTO EN INSTALACIONES RECREATIVAS Y OTROS SERVICIOS RECR",234);
		mapGiroNegocioOracle.put("SERVICIOS DE ALOJAMIENTO TEMPORAL",235);
		mapGiroNegocioOracle.put("SERVICIOS DE PREPARACION DE ALIMENTOS Y BEBIDAS",236);
		mapGiroNegocioOracle.put("SERVICIOS DE REPARACION Y MANTENIMIENTO",237);
		mapGiroNegocioOracle.put("SERVICIOS PERSONALES",238);
		mapGiroNegocioOracle.put("SALONES Y CLINICAS DE BELLEZA, BA�OS PUBLICOS Y BOLERIAS",239);
		mapGiroNegocioOracle.put("CA�EROS",24);
		mapGiroNegocioOracle.put("LAVANDERIAS Y TINTORERIAS",240);
		mapGiroNegocioOracle.put("SERVICIOS FUNERARIOS Y ADMINISTRACION DE CEMENTERIOS",241);
		mapGiroNegocioOracle.put("ESTACIONAMIENTOS Y PENSIONES PARA AUTOMOVILES",242);
		mapGiroNegocioOracle.put("SERVICIOS DE REVELADO DE FOTOGRAFIAS Y OTROS SERVICIOS PERSONALES",243);
		mapGiroNegocioOracle.put("ASOCIACIONES Y ORGANIZACIONES",244);
		mapGiroNegocioOracle.put("CARNICERIA",25);
		mapGiroNegocioOracle.put("CARPINTERIA",26);
		mapGiroNegocioOracle.put("CASA DE ASISTENCIA",27);
		mapGiroNegocioOracle.put("CENTROS SOCIALES RECREATIVOS Y DEPORTIVOS",28);
		mapGiroNegocioOracle.put("CERRAJERIA",29);
		mapGiroNegocioOracle.put("AGUAS PURIFICADAS",3);
		mapGiroNegocioOracle.put("CHILES SECOS ESPECIAS Y CONDIMENTOS",30);
		mapGiroNegocioOracle.put("COCINA ECONOMICA",31);
		mapGiroNegocioOracle.put("COMERCIO DE ANIMALES VIVOS",32);
		mapGiroNegocioOracle.put("COMERCIO DE CARBON",33);
		mapGiroNegocioOracle.put("COMERCIO DE DISCOS Y CINTAS",34);
		mapGiroNegocioOracle.put("COMERCIO DE GRASAS Y ACEITES LUBRICANTES",35);
		mapGiroNegocioOracle.put("COMERCIO EN GENERAL",36);
		mapGiroNegocioOracle.put("CONSTRUCTORA",37);
		mapGiroNegocioOracle.put("CONSULTORIO DENTAL",38);
		mapGiroNegocioOracle.put("CONSULTORIO MEDICO",39);
		mapGiroNegocioOracle.put("ALFARERIA Y CERAMICA",4);
		mapGiroNegocioOracle.put("CORSETERIA Y LENCERIA",40);
		mapGiroNegocioOracle.put("CREMERIA",41);
		mapGiroNegocioOracle.put("CRIA DE PORCINOS",42);
		mapGiroNegocioOracle.put("CRIANZA DE ANIMALES",43);
		mapGiroNegocioOracle.put("CULTIVO DE ARBOLES FRUTALES",44);
		mapGiroNegocioOracle.put("CULTIVO DE HORTALIZAS Y FLORES",45);
		mapGiroNegocioOracle.put("CYBERCAFE",46);
		mapGiroNegocioOracle.put("DECORACION DE INTERIORES",47);
		mapGiroNegocioOracle.put("DESECHOS INDUSTRIALES",48);
		mapGiroNegocioOracle.put("DESPACHO CONTABLE",49);
		mapGiroNegocioOracle.put("ALFOMBRAS CORTINAS Y PERSIANAS",5);
		mapGiroNegocioOracle.put("DULCERIA",50);
		mapGiroNegocioOracle.put("ESCUELA DE GIMNASIA Y ARTES MARCIALES",51);
		mapGiroNegocioOracle.put("ESCUELA DE MUSICA Y BAILE",52);
		mapGiroNegocioOracle.put("ESTACIONAMIENTO Y PENSION PARA VEHICULOS",53);
		mapGiroNegocioOracle.put("ESTUDIO FOTOGRAFICO",54);
		mapGiroNegocioOracle.put("FARMACIA",55);
		mapGiroNegocioOracle.put("FERTILIZANTES Y PLAGUICIDAS",56);
		mapGiroNegocioOracle.put("FLORERIA",57);
		mapGiroNegocioOracle.put("FOTOCOPIADO Y ENGARGOLADO",58);
		mapGiroNegocioOracle.put("FRUTAS Y VERDURAS",59);
		mapGiroNegocioOracle.put("ALIMENTO PARA ANIMALES",6);
		mapGiroNegocioOracle.put("GRANOS Y SEMILLAS",60);
		mapGiroNegocioOracle.put("GUARDERIA Y JARDIN DE NI�OS",61);
		mapGiroNegocioOracle.put("HERRERIA",62);
		mapGiroNegocioOracle.put("HOSPEDAJE Y HOTELERIA",63);
		mapGiroNegocioOracle.put("IMPRENTA",64);
		mapGiroNegocioOracle.put("INSTALACIONES ELECTRICAS",65);
		mapGiroNegocioOracle.put("INSTRUMENTOS MUSICALES",66);
		mapGiroNegocioOracle.put("JOYERIA DE FANTASIA",67);
		mapGiroNegocioOracle.put("JOYERIA Y ACCESORIOS",68);
		mapGiroNegocioOracle.put("JOYERIA Y RELOJERIA",69);
		mapGiroNegocioOracle.put("ALQUILER DE CRISTALERIA LOZA Y CUCHILLERIA",7);
		mapGiroNegocioOracle.put("JUGOS Y LICUADOS",70);
		mapGiroNegocioOracle.put("JUGUETERIA",71);
		mapGiroNegocioOracle.put("LADRILLOS TABIQUES",72);
		mapGiroNegocioOracle.put("LAVANDERIA Y TINTORERIA",73);
		mapGiroNegocioOracle.put("LECHERIA",74);
		mapGiroNegocioOracle.put("LIBRERIA",75);
		mapGiroNegocioOracle.put("LICORERIA",76);
		mapGiroNegocioOracle.put("LLANTAS Y CAMARAS PARA AUTOMOVILES",77);
		mapGiroNegocioOracle.put("LONCHERIAS TAQUERIAS Y TORTERIAS",78);
		mapGiroNegocioOracle.put("MADERERIA",79);
		mapGiroNegocioOracle.put("ALQUILER DE MAQUINARIA Y EQUIPO",8);
		mapGiroNegocioOracle.put("MATERIALES PARA LA CONSTRUCCION",80);
		mapGiroNegocioOracle.put("MATERIAS PRIMAS",81);
		mapGiroNegocioOracle.put("MERCERIA",82);
		mapGiroNegocioOracle.put("METALES EN GENERAL",83);
		mapGiroNegocioOracle.put("MOLINO DE NIXTAMAL",84);
		mapGiroNegocioOracle.put("MUEBLERIA",85);
		mapGiroNegocioOracle.put("NEVERIA",86);
		mapGiroNegocioOracle.put("OPTICA",87);
		mapGiroNegocioOracle.put("OTRAS INDUSTRIAS MANUFACTURERAS",88);
		mapGiroNegocioOracle.put("OTROS SERVICIOS PROFESIONALES",89);
		mapGiroNegocioOracle.put("ALQUILER DE MESAS SILLAS Y LONAS",9);
		mapGiroNegocioOracle.put("PANADERIA",90);
		mapGiroNegocioOracle.put("PAPELERIA",91);
		mapGiroNegocioOracle.put("PASTELERIA Y REPOSTERIA",92);
		mapGiroNegocioOracle.put("PERFUMES Y COSMETICOS",93);
		mapGiroNegocioOracle.put("PERIODICOS Y REVISTAS",94);
		mapGiroNegocioOracle.put("PESCA EN GENERAL",95);
		mapGiroNegocioOracle.put("PESCADOS Y MARISCOS",96);
		mapGiroNegocioOracle.put("PINTURAS LACAS Y BARNICES",97);
		mapGiroNegocioOracle.put("PLANTAS Y HIERBAS MEDICINALES",98);
		mapGiroNegocioOracle.put("PLOMERIA",99);
		*/

		mapGiroNegocioOracle.put("AGENCIA DE VIAJES", 10);
		mapGiroNegocioOracle.put("PASTELERIA Y REPOSTERIA", 100);
		mapGiroNegocioOracle.put("PERFUMES Y COSMETICOS", 101);
		mapGiroNegocioOracle.put("PERIODICOS Y REVISTAS", 102);
		mapGiroNegocioOracle.put("PESCA EN GENERAL", 103);
		mapGiroNegocioOracle.put("PESCADOS Y MARISCOS", 104);
		mapGiroNegocioOracle.put("PINTURAS LACAS Y BARNICES", 105);
		mapGiroNegocioOracle.put("PLANTAS Y HIERBAS MEDICINALES", 106);
		mapGiroNegocioOracle.put("PLOMERIA", 107);
		mapGiroNegocioOracle.put("POLLERIA", 108);
		mapGiroNegocioOracle.put("PRODUCTOS DE CUERO Y PIEL", 109);
		mapGiroNegocioOracle.put("AGUAS PURIFICADAS", 11);
		mapGiroNegocioOracle.put("PRODUCTOS QUIMICOS", 110);
		mapGiroNegocioOracle.put("PRODUCTOS TEXTILES", 111);
		mapGiroNegocioOracle.put("PROTECCION Y CUSTODIA", 112);
		mapGiroNegocioOracle.put("PUBLICIDAD", 113);
		mapGiroNegocioOracle.put("RASTROS Y OBRADORES", 114);
		mapGiroNegocioOracle.put("REFACCIONARIA", 115);
		mapGiroNegocioOracle.put("REFACCIONES Y ACCESORIOS USADAS", 116);
		mapGiroNegocioOracle.put("REPARACION DE APARATOS DOMESTICOS", 117);
		mapGiroNegocioOracle.put("RESTAURANTES Y CAFETERIAS", 118);
		mapGiroNegocioOracle.put("ROPA PARA CABALLERO HECHA EN SERIE", 119);
		mapGiroNegocioOracle.put("ALFARERIA Y CERAMICA", 12);
		mapGiroNegocioOracle.put("ROPA PARA DAMA HECHA EN SERIE", 120);
		mapGiroNegocioOracle.put("ROPA PARA NINOS Y NINAS", 121);
		mapGiroNegocioOracle.put("SABANAS MANTELES Y COLCHAS", 122);
		mapGiroNegocioOracle.put("SALCHICHONERIA Y CREMERIA", 123);
		mapGiroNegocioOracle.put("SALONES DE BELLEZA PELUQUERIAS Y ESTETICAS", 124);
		mapGiroNegocioOracle.put("SASTRERIA", 125);
		mapGiroNegocioOracle.put("SERVICIO DE TAXI", 126);
		mapGiroNegocioOracle.put("SERVICIO DE TRANSPORTE DE CARGA EN GENERAL", 127);
		mapGiroNegocioOracle.put("SERVICIO DE TRANSPORTE EN RUTA FIJA", 128);
		mapGiroNegocioOracle.put("SERVICIOS DE INFORMATICA", 129);
		mapGiroNegocioOracle.put("ALFOMBRAS CORTINAS Y PERSIANAS", 13);
		mapGiroNegocioOracle.put("SERVICIOS DOMESTICOS EN GENERAL", 130);
		mapGiroNegocioOracle.put("SERVICIOS JURIDICOS", 131);
		mapGiroNegocioOracle.put("SERVICIOS MUSICALES Y DE ESPECTACULOS", 132);
		mapGiroNegocioOracle.put("SERVICIOS PRIVADOS DE EDUCACION", 133);
		mapGiroNegocioOracle.put("SERVICIOS PRIVADOS DE HOSPITALIZACION", 134);
		mapGiroNegocioOracle.put("SERVICIOS TELEFONICOS", 135);
		mapGiroNegocioOracle.put("TABAQUERIA", 136);
		mapGiroNegocioOracle.put("TALLER DE BICICLETAS", 137);
		mapGiroNegocioOracle.put("TALLER DE COSTURA", 138);
		mapGiroNegocioOracle.put("TALLER DE HOJALATERIA Y PINTURA", 139);
		mapGiroNegocioOracle.put("ALIMENTO PARA ANIMALES", 14);
		mapGiroNegocioOracle.put("TALLER DE MOTOCICLETAS", 140);
		mapGiroNegocioOracle.put("TALLER DE REFRIGERACION", 141);
		mapGiroNegocioOracle.put("TALLER MECANICO", 142);
		mapGiroNegocioOracle.put("TAPICERIA", 143);
		mapGiroNegocioOracle.put("TELAS Y CASIMIRES", 144);
		mapGiroNegocioOracle.put("TEXTILES Y PRENDAS DE VESTIR", 145);
		mapGiroNegocioOracle.put("TLAPALERIA Y FERRETERIA", 146);
		mapGiroNegocioOracle.put("TORTILLERIA", 147);
		mapGiroNegocioOracle.put("TRANSFERENCIA", 148);
		mapGiroNegocioOracle.put("TRANSPORTE FORANEO DE PASAJEROS", 149);
		mapGiroNegocioOracle.put("ALQUILER DE CRISTALERIA LOZA Y CUCHILLERIA", 15);
		mapGiroNegocioOracle.put("TRANSPORTE URBANO DE PASAJEROS", 150);
		mapGiroNegocioOracle.put("UNIFORMES Y ROPA DE TRABAJO", 151);
		mapGiroNegocioOracle.put("VENTA DE ANTOJITOS", 152);
		mapGiroNegocioOracle.put("VENTA DE CALZADO", 153);
		mapGiroNegocioOracle.put("VENTA DE CERVEZA", 154);
		mapGiroNegocioOracle.put("VENTA DE HUEVO", 155);
		mapGiroNegocioOracle.put("VENTA DE REFRESCOS", 156);
		mapGiroNegocioOracle.put("VENTA DE ROPA", 157);
		mapGiroNegocioOracle.put("VENTA REPARACION Y MANTENIMIENTO DE EQUIPO DE COMPUTO", 158);
		mapGiroNegocioOracle.put("VETERINARIA", 159);
		mapGiroNegocioOracle.put("ALQUILER DE MAQUINARIA Y EQUIPO", 16);
		mapGiroNegocioOracle.put("VIDRIOS Y ALUMINIO", 160);
		mapGiroNegocioOracle.put("VULCANIZADORA", 161);
		mapGiroNegocioOracle.put("ZAPATERO", 162);
		mapGiroNegocioOracle.put("BISUTERIA", 166);
		mapGiroNegocioOracle.put("VENTA DE PRODUCTOS NATURALES", 167);
		mapGiroNegocioOracle.put("VENTA DE GAS", 168);
		mapGiroNegocioOracle.put("ALQUILER DE MESAS SILLAS Y LONAS", 17);
		mapGiroNegocioOracle.put("ABARROTES", 170);
		mapGiroNegocioOracle.put("ALQUILER DE PELICULAS Y VIDEOJUEGOS", 18);
		mapGiroNegocioOracle.put("ALQUILER DE SALONES PARA EVENTOS", 19);
		mapGiroNegocioOracle.put("ALQUILER DE TERRENOS Y LOCALES COMERCIALES", 20);
		mapGiroNegocioOracle.put("ALQUILER DE VIVIENDAS", 21);
		mapGiroNegocioOracle.put("APARATOS Y ARTICULOS DEPORTIVOS", 22);
		mapGiroNegocioOracle.put("APARATOS Y ARTICULOS ORTOPEDICOS", 23);
		mapGiroNegocioOracle.put("APICULTURA", 24);
		mapGiroNegocioOracle.put("ARTESANIAS", 25);
		mapGiroNegocioOracle.put("ARTICULOS DE PLASTICO PARA EL HOGAR", 26);
		mapGiroNegocioOracle.put("ARTICULOS PARA EL HOGAR", 27);
		mapGiroNegocioOracle.put("ARTICULOS RELIGIOSOS", 28);
		mapGiroNegocioOracle.put("ARTICULOS USADOS PARA EL HOGAR", 29);
		mapGiroNegocioOracle.put("AUTOLAVADO", 30);
		mapGiroNegocioOracle.put("AVICULTURA", 31);
		mapGiroNegocioOracle.put("CA�EROS", 32);
		mapGiroNegocioOracle.put("CARNICERIA", 33);
		mapGiroNegocioOracle.put("CARPINTERIA", 34);
		mapGiroNegocioOracle.put("CASA DE ASISTENCIA", 35);
		mapGiroNegocioOracle.put("CENTROS SOCIALES RECREATIVOS Y DEPORTIVOS", 36);
		mapGiroNegocioOracle.put("CERRAJERIA", 37);
		mapGiroNegocioOracle.put("CHILES SECOS ESPECIAS Y CONDIMENTOS", 38);
		mapGiroNegocioOracle.put("COCINA ECONOMICA", 39);
		mapGiroNegocioOracle.put("COMERCIO DE ANIMALES VIVOS", 40);
		mapGiroNegocioOracle.put("COMERCIO DE CARBON", 1);
		mapGiroNegocioOracle.put("COMERCIO DE DISCOS Y CINTAS", 42);
		mapGiroNegocioOracle.put("COMERCIO DE GRASAS Y ACEITES LUBRICANTES", 43);
		mapGiroNegocioOracle.put("COMERCIO EN GENERAL", 44);
		mapGiroNegocioOracle.put("CONSTRUCTORA", 45);
		mapGiroNegocioOracle.put("CONSULTORIO DENTAL", 46);
		mapGiroNegocioOracle.put("CONSULTORIO MEDICO", 47);
		mapGiroNegocioOracle.put("CORSETERIA Y LENCERIA", 48);
		mapGiroNegocioOracle.put("CREMERIA", 49);
		mapGiroNegocioOracle.put("CRIA DE PORCINOS", 50);
		mapGiroNegocioOracle.put("CRIANZA DE ANIMALES", 51);
		mapGiroNegocioOracle.put("CULTIVO DE ARBOLES FRUTALES", 52);
		mapGiroNegocioOracle.put("CULTIVO DE HORTALIZAS Y FLORES", 53);
		mapGiroNegocioOracle.put("CYBERCAFE", 54);
		mapGiroNegocioOracle.put("DECORACION DE INTERIORES", 55);
		mapGiroNegocioOracle.put("DESECHOS INDUSTRIALES", 56);
		mapGiroNegocioOracle.put("DESPACHO CONTABLE", 57);
		mapGiroNegocioOracle.put("DULCERIA", 58);
		mapGiroNegocioOracle.put("ESCUELA DE GIMNASIA Y ARTES MARCIALES", 59);
		mapGiroNegocioOracle.put("ESCUELA DE MUSICA Y BAILE", 60);
		mapGiroNegocioOracle.put("ESTACIONAMIENTO Y PENSION PARA VEHICULOS", 61);
		mapGiroNegocioOracle.put("ESTUDIO FOTOGRAFICO", 62);
		mapGiroNegocioOracle.put("FARMACIA", 63);
		mapGiroNegocioOracle.put("FERTILIZANTES Y PLAGUICIDAS", 64);
		mapGiroNegocioOracle.put("FLORERIA", 65);
		mapGiroNegocioOracle.put("FOTOCOPIADO Y ENGARGOLADO", 66);
		mapGiroNegocioOracle.put("FRUTAS Y VERDURAS", 67);
		mapGiroNegocioOracle.put("GRANOS Y SEMILLAS", 68);
		mapGiroNegocioOracle.put("GUARDERIA Y JARDIN DE NI�OS", 69);
		mapGiroNegocioOracle.put("HERRERIA", 70);
		mapGiroNegocioOracle.put("HOSPEDAJE Y HOTELERIA", 71);
		mapGiroNegocioOracle.put("IMPRENTA", 72);
		mapGiroNegocioOracle.put("INSTALACIONES ELECTRICAS", 73);
		mapGiroNegocioOracle.put("INSTRUMENTOS MUSICALES", 74);
		mapGiroNegocioOracle.put("JOYERIA DE FANTASIA", 75);
		mapGiroNegocioOracle.put("JOYERIA Y ACCESORIOS", 76);
		mapGiroNegocioOracle.put("JOYERIA Y RELOJERIA", 77);
		mapGiroNegocioOracle.put("JUGOS Y LICUADOS", 78);
		mapGiroNegocioOracle.put("JUGUETERIA", 79);
		mapGiroNegocioOracle.put("LADRILLOS TABIQUES", 80);
		mapGiroNegocioOracle.put("LAVANDERIA Y TINTORERIA", 81);
		mapGiroNegocioOracle.put("LECHERIA", 82);
		mapGiroNegocioOracle.put("LIBRERIA", 83);
		mapGiroNegocioOracle.put("LICORERIA", 84);
		mapGiroNegocioOracle.put("LLANTAS Y CAMARAS PARA AUTOMOVILES", 85);
		mapGiroNegocioOracle.put("LONCHERIAS TAQUERIAS Y TORTERIAS", 86);
		mapGiroNegocioOracle.put("MADERERIA", 87);
		mapGiroNegocioOracle.put("MATERIALES PARA LA CONSTRUCCION", 88);
		mapGiroNegocioOracle.put("MATERIAS PRIMAS", 89);
		mapGiroNegocioOracle.put("ADECUACION Y REPARACION DE INMUEBLES", 9);
		mapGiroNegocioOracle.put("MERCERIA", 90);
		mapGiroNegocioOracle.put("METALES EN GENERAL", 91);
		mapGiroNegocioOracle.put("MOLINO DE NIXTAMAL", 92);
		mapGiroNegocioOracle.put("MUEBLERIA", 93);
		mapGiroNegocioOracle.put("NEVERIA", 94);
		mapGiroNegocioOracle.put("OPTICA", 95);
		mapGiroNegocioOracle.put("OTRAS INDUSTRIAS MANUFACTURERAS", 96);
		mapGiroNegocioOracle.put("OTROS SERVICIOS PROFESIONALES", 97);
		mapGiroNegocioOracle.put("PANADERIA", 98);
		mapGiroNegocioOracle.put("PAPELERIA", 99);

		mapCategoriaProductos.put("GCS1", "COMUNAL");
		mapCategoriaProductos.put("GCC1", "COMUNAL");
		mapCategoriaProductos.put("GCM1", "COMUNAL");
		mapCategoriaProductos.put("GES1", "COMUNAL");
		mapCategoriaProductos.put("GIC1", "COMUNAL");
		mapCategoriaProductos.put("GICN", "COMUNAL");
		mapCategoriaProductos.put("GIS1", "COMUNAL");
		mapCategoriaProductos.put("GCDG", "COMUNAL");
		mapCategoriaProductos.put("GCDC", "COMUNAL");
		mapCategoriaProductos.put("GSS1", "SOLIDARIO");
		mapCategoriaProductos.put("GSC1", "SOLIDARIO");
		mapCategoriaProductos.put("GOS1", "OPORTUNIDAD");

		mapCategoriaProductos.put("21050", "COMUNAL"); 	//CREDITO COMUNAL
		mapCategoriaProductos.put("21057", "COMUNAL"); 	//CREDITO COMUNAL FORTNIGHT
		mapCategoriaProductos.put("21056", "COMUNAL"); 	//CREDITO COMUNAL MONTHLY
		mapCategoriaProductos.put("21051", "SOLIDARIO"); 	//CREDITO GRUPO SOLIDARIO
		mapCategoriaProductos.put("21059", "SOLIDARIO"); 	//CREDITO GRUPO SOLIDARIO FORNIGHT
		mapCategoriaProductos.put("21070", "COMUNAL"); 	//CREDITO COMUNAL DEPOSITO GARANTIA SEMANAL
		mapCategoriaProductos.put("21071", "COMUNAL"); 	//CREDITO COMUNAL DEPOSITO GARANTIA CATORCENAL

	}

 	/**
 	 *  void
 	 */
 	private static void recuperaEstados() {
 		//Obtenemos una lista con todas las entidades del pais
		SqlSession 	sesionNTx = null;
		try	{
			//Recuperamos las entidades
		  	sesionNTx	 = FabricaConexiones.obtenerSesionNTx();
		  	LogHandler.trace("MAPPER", DataMapper.class, "==> static - " + OPER_OBTENER_CLAVES_ENTIDADES);
			ArrayList<HashMap<String, String>> lstEntidades =   (ArrayList<HashMap<String, String>>)
					sesionNTx.selectList( OPER_OBTENER_CLAVES_ENTIDADES );
			for ( int i = 0;  i < lstEntidades.size( ); i++) {
				java.util.HashMap miMap = (java.util.HashMap) lstEntidades.get(i);
				mapEntidades.put( (String) miMap.get( CODIGO_FINANCIERA ), (String) miMap.get( ESTADO ) );
				}
 			}
		catch (Exception e ) {
 			//e.printStackTrace();
 			LogHandler.error(null, DataMapper.class, "Error al momento de cargar las entidades", e);
 			}
 		finally {
			FabricaConexiones.close( sesionNTx);
			}
 		}
	/**
	 * @param entidadT24 :
	 * @return String
	 */
	public static String mapClaveEntidad( String entidadT24 ) {

		String claveEntidad 	= null;
		try {
			//Si no hay datos cargados se cargan
			if ( mapEntidades.size() == 0 ) {
				recuperaEstados();
				}

			Iterator<String> keys	= mapEntidades.keySet( ).iterator( );
			while ( keys.hasNext( ) ) {
				claveEntidad = keys.next();
				String entidad = mapEntidades.get( claveEntidad );
				if ( entidadT24.endsWith( SUFIJO_ENTIDAD ) &&  entidad.equalsIgnoreCase( entidadT24 ) ) {
					break;
				}
				else if ( entidad.startsWith( entidadT24 ) ) {
						break;
				}
			}
		} catch ( Exception e) {
			LogHandler.error(null, DataMapper.class, "Error en el metodo mapClaveEntidad", e);
			claveEntidad = null;
		}
		return claveEntidad;
	}

	/**
	 * @param edoCivilT24 :
	 * @return String
	 */
	public static String mapEstadoCivil(String edoCivilT24) {
		String edoCivil = null;
		if ( edoCivilT24 != null ) {
			edoCivil 	= mapEstadoCivil.get(edoCivilT24);
		}
		return  edoCivil != null ? edoCivil : DEFAULT_ESTADO_CIVIL;
	}

	/**
	 * @param frecuenciaT24 :
	 * @return String
	 */
	public static String mapFrecuencia( String frecuenciaT24 ) {
		String frecuencia = null;
		if ( frecuenciaT24 != null ) {
			frecuencia = mapFrecuencia.get( frecuenciaT24 );
		}
		return 	frecuencia != null ? frecuencia : DEFAULT_FRECUENCIA_PAGO;
	}

	/**
	 * @param productoT24 :
	 * @return String
	 */
	public static String mapProducto(String productoT24) {
		String producto = null;
		if ( productoT24 != null) {
			producto  = mapProductos.get( productoT24 );
		}
		return producto != null ? producto : DEFAULT_PRODUCTO;
	}

	/**
	 * @param productoCP :
	 * @return String
	 */
	public static String mapProductoFsol(String productoCP) {
		String producto = null;
		if ( productoCP != null) {
			producto  = mapProductosFsol.get( productoCP );
		}
		return producto != null ? producto : DEFAULT_PRODUCTO_FSOL;
	}

	/**
	 * @param renovacionT24 :
	 * @return boolean
	 */
	public static boolean mapRenovacion(String renovacionT24) {
		return renovacionT24 == null || renovacionT24.trim().length() <= 0 || renovacionT24.equals("")
				|| renovacionT24.equals("0") ? false : true;
	}

	/**
	 * @return Integer
	 */
	public static Integer getNumeroEntidades() {
		return mapEntidades == null ? null : mapEntidades.size();
	}
 }
