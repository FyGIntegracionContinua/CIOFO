package tarea.impresiondocs;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

import datamapper.DataMapper;
import tarea.comun.ComunTarea;
import tarea.comun.OFSResultAssemblerImpl;
import tarea.comun.ReadProperties;
import tarea.consultas.Consultas;
import utilitario.comun.Constantes;
import utilitario.comun.DataMapperAdministracion;
import utilitario.comun.Funciones;
import utilitario.comun.Numero2Letra;
import utilitario.comun.asesores.AsesorOV;
import utilitario.log.LogHandler;
import utilitario.mensajes.chequescreditogrupal.ChequeOV;
import utilitario.mensajes.comun.AmortizacionActualOV;
import utilitario.mensajes.comun.AmortizacionOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.condonaciones.comun.CreditoSaldo;
import utilitario.mensajes.consultas.ConsultaCreditoPeticion;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoPeticion;
import utilitario.mensajes.consultas.ConsultaReferenciasPagoRespuesta;
import utilitario.mensajes.consultas.DatosCreditoIntegrantesRespuesta;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsulta;
import utilitario.mensajes.impresiondocs.ImpresionDocsConsultaRespuesta;
import utilitario.mensajes.impresiondocs.comun.AvalGrupo;
import utilitario.mensajes.impresiondocs.comun.CartaInstruccionOV;
import utilitario.mensajes.impresiondocs.comun.ContratoFinsolOV;
import utilitario.mensajes.impresiondocs.comun.ContratoFinsolRespuesta;
import utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit;
import utilitario.mensajes.impresiondocs.comun.ContratoRestructuraVO;
import utilitario.mensajes.impresiondocs.comun.ContratoVO;
import utilitario.mensajes.impresiondocs.comun.ContratoVigenteVO;
import utilitario.mensajes.impresiondocs.comun.CreditoGrupalCSOV;
import utilitario.mensajes.impresiondocs.comun.CreditoOportunidadOV;
import utilitario.mensajes.impresiondocs.comun.DatosMiembrosVO;
import utilitario.mensajes.impresiondocs.comun.FichaEspecialPeticion;
import utilitario.mensajes.impresiondocs.comun.FichaEspecialRespuesta;
import utilitario.mensajes.impresiondocs.comun.KitSolicitudOV;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoKitPagare;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoPagare;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVigenteVO;
import utilitario.mensajes.impresiondocs.comun.ObjetosImpresionDocumentos;
import utilitario.mensajes.impresiondocs.comun.PagoGrupo;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudPeticion;
import utilitario.mensajes.impresiondocs.comun.PreSolicitudRespuesta;
import utilitario.mensajes.impresiondocs.comun.ValesVO;
import utilitario.mensajes.impresiondocs.comunalrenovacion.MiembroGrupoAnteriorVO;
import utilitario.mensajes.impresiondocs.contratocomunal.ContratoComunalKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ContratoPagareKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.ConvenioReestructuraKitRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.KitImpresionPagareRespuesta;
import utilitario.mensajes.impresiondocs.contratocomunal.PagareReestructuraKitRespuesta;
import utilitario.mensajes.impresiondocs.fichapago.FichaDePago;
import utilitario.mensajes.impresiondocs.fichapago.FichaPagoPeticion;
import utilitario.mensajes.impresiondocs.fichapago.FichaPagoRespuesta;
import utilitario.mensajes.impresiondocs.fichapagoespecial.EspecialFichaPago;
import utilitario.mensajes.impresiondocs.fichapagoespecial.FichaPagoEspecialRespuesta;
import utilitario.mensajes.impresiondocs.oportunidadcontrato.OportunidadContratoOV;
import utilitario.mensajes.impresiondocs.oportunidapagare.OportunidadPagareRespuesta;
import utilitario.mensajes.impresiondocs.solidariocontrato.SolidarioContratoRespuesta;
import utilitario.mensajes.impresiondocs.solidariopagare.SolidarioPagareRespuesta;
import utilitario.mensajes.originacion.consulta.ParGeneralOV;
import utilitario.mensajes.originacion.contrato.ContratoOV;
import utilitario.mensajes.reportes.comun.ObtenerEstadoCuenta;
import utilitario.mensajes.solicitudes.ObtenerDatosSolicitudRespuesta;
import utilitario.mensajes.solicitudes.SolicitudesOV;
import entidad.asesores.data.AsesorData;
import entidad.conexiones.FabricaConexiones;


@Scope("COMPOSITE")
public class ImpresionDocsInformacionImpl implements ImpresionDocsInformacion {

	/** The PAGINA_INICAL_FIRMAS. */
	private final static int PAGINA_INICAL_FIRMAS = 20;
	/** The PAGINA_SIGUIENTE_FIRMAS. */
	private final static int PAGINA_SIGUIENTE_FIRMAS = 24;
	/** The PAGINA_COMUNAL. */
	private final static int PAGINA_COMUNAL = 9;
	/** The PAGINA_SOLIDARIO. */
	private final static int PAGINA_SOLIDARIO = 8;
	/** The PAGINA_OPORTUNIDAD. */
	private final static int PAGINA_OPORTUNIDAD = 8;

	/** The comun. */
	private ComunTarea comun;

	/** The consultas. */
	private Consultas consultas;


	/**
	 * Instantiates a new impresion docs informacion impl.
	 *
	 * @param comun the comun
	 * @param consultas the consultas
	 */
	public ImpresionDocsInformacionImpl( @Reference(name = "comun") ComunTarea comun,
			@Reference(name = "consultas") Consultas consultas) {
 		this.comun = comun;
 		this.consultas = consultas;
	}

	/**
	 * @author out_jflores
	 * @param contrato .
	 * @param ld .
	 * @param tipoInfo .
	 * @param uid .
	 * @return OFS Con el formato de los contratos comunales
	 */
	@SuppressWarnings("unchecked")
	public ImpresionDocsConsultaRespuesta comunalContrato(String contrato, String ld, String tipoInfo, String uid) {
		//formateo de numero cheque
		final java.text.DecimalFormat decimalFormat = new DecimalFormat( "000000000" );
		ImpresionDocsConsultaRespuesta respuesta = new ImpresionDocsConsultaRespuesta();
		OFSResultAssemblerImpl ofsComunal = new OFSResultAssemblerImpl();
		EncabezadoRespuesta header  = new EncabezadoRespuesta();
		SqlSession sesion = null;
		ContratoVO contratoVO = null;
		DecimalFormat df = new DecimalFormat("0.00");
		if (contrato == null || contrato.isEmpty()) {
			respuesta.setMsjError(CONTRATO_INVALIDO);
			return respuesta;
		}

		if (tipoInfo.equals(COMUNALES_DATOS_GRUPO) || tipoInfo.equals( COMUNALES_DATOS_GRUPO_FIN ) ) {
			try {
				LogHandler.debug(uid, getClass(), "Contrato " + contrato + " " + "tipo " + tipoInfo );
				sesion = FabricaConexiones.obtenerSesionNTx();
				OportunidadContratoOV oportunidadContraro = null;
				String nombres = "";
				Double aux = 0.0;
				ObjetosImpresionDocumentos tipoContratoRespuesta = null;
				LogHandler.trace("", getClass(), "==>comunalContrato - dsConsultaContratoOportunidad");
				oportunidadContraro = (OportunidadContratoOV) sesion.selectOne("dsConsultaContratoOportunidad", contrato);
				LogHandler.trace("", getClass(), "==>comunalContrato - consulaDatosIntegrantes");
				List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", contrato);

				//Formateo del numero de cheque
				for ( MiembroGrupoVO miembroGrupoVO : miembros ) {
					miembroGrupoVO.setNumcheque( decimalFormat.format(
							Double.parseDouble( miembroGrupoVO.getNumcheque() ) ).trim() );
				}

				ofsComunal.inicializaResultAssembler(1);
				LogHandler.trace(uid, getClass(), "==> comunalContrato - dsObtenerTipoContrato ");
				HashMap<String, Object> tipoContrato
					= (HashMap<String, Object>) sesion.selectOne( 	"dsObtenerTipoContrato", contrato );
				String categoria = (String) tipoContrato.get("categoria");
				//oportunidadContraro.setNombreApoderado(oportunidadContraro.getNombreApoderado());
				oportunidadContraro.setImpteletras(getMontoLetras(oportunidadContraro.getImporte()));
				oportunidadContraro.setImptepagoletra(getMontoLetras(oportunidadContraro.getImptepago()));
				LogHandler.trace(uid, getClass(), "==> comunalContrato - consulaDatosContrato");
				contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
				String importeRed = Math.rint((Double.parseDouble(oportunidadContraro.getImptepago()) * 1000) / 1000) + "";
				oportunidadContraro.setImptepagoletrared(getMontoLetras(importeRed));
				oportunidadContraro.setNombregpo(contratoVO.getNombregpo());
				Map<String, Object>parametros = new HashMap<String, Object>();
				parametros.put("sucursal", Integer.parseInt(oportunidadContraro.getBranchcode()));
				parametros.put("codigo", CODIGO_IVA);
				parametros.put("fecha", new Date());
				LogHandler.trace(uid, getClass(), "==> comunalContrato - verValorHistorico");
				Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
				aux = (double) iva;
				Double tasa = Double.parseDouble(oportunidadContraro.getTasa());
				oportunidadContraro.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
				//Se adapta la direccion de la sucursal
				oportunidadContraro.setDirsucursal(oportunidadContraro.getDirsucursal()
						+ ", " + textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase()));
				LogHandler.trace(uid, getClass(), "==> comunalContrato - consulaDatosContrato");
				contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
				LogHandler.info(uid, this.getClass(), "Se carga el asesor externo." +  contratoVO.getEjecutivo() );
				//Obtenemos los asesores
				final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, contratoVO.getEjecutivo().trim());
				oportunidadContraro.setEjecutivo( asesorOV != null ? asesorOV.getNombreCompleto() : "" );
					if (categoria.equals(CONTRATO_SOLIDARIO_CAT) && !tipoInfo.equals( COMUNALES_DATOS_GRUPO_FIN )) {
						oportunidadContraro.setFechaEscritura(oportunidadContraro.getFechaEscritura());
						oportunidadContraro.setTipocont("CREDITO GRUPO SOLIDARIO");
						ofsComunal.setTypeReturn(ObjetosImpresionDocumentos.CONTRATO_SOLIDARIO_DATOS_GRUPO);
						tipoContratoRespuesta = ObjetosImpresionDocumentos.CONTRATO_SOLIDARIO_DATOS_GRUPO;
						//cdadfirma
						oportunidadContraro.setCdadfirma( oportunidadContraro.getCdadfirma().toUpperCase() );
					} else	{
						oportunidadContraro.setFechaEscritura(oportunidadContraro.getFechaEscritura());
						oportunidadContraro.setTipocont("CREDITO COMUNAL");
						//Se selecciona entre comunal normal y renovacion financiada
						tipoContratoRespuesta = tipoInfo.equals( COMUNALES_DATOS_GRUPO_FIN )
								? ObjetosImpresionDocumentos.CONTRATO_FIN : ObjetosImpresionDocumentos.CONTRATO;

						oportunidadContraro.setSucursal( oportunidadContraro.getSucursal().trim() );
						ofsComunal.setTypeReturn( tipoContratoRespuesta );
						/*ObjetosImpresionDocumentos.CONTRATO);
						tipoContratoRespuesta = ObjetosImpresionDocumentos.CONTRATO;*/
						}
			 			for (int i = 0; i < miembros.size(); i++) {
			 				if (miembros.get(i).getRol().equals(ID_PRESIDENTE)) {
								oportunidadContraro.setPresidente(miembros.get(i).getCliente());
							}
			 				if (miembros.get(i).getRol().equals(ID_SECRETARIO)) {
								oportunidadContraro.setSecretario(miembros.get(i).getCliente());
							}
			 				if (miembros.get(i).getRol().equals(ID_TESORERO)) {
								oportunidadContraro.setTesorero(miembros.get(i).getCliente());
							}
			 				if (miembros.get(i).getRol().equals(ID_SUPERVISOR)) {
			 					if (miembros.get(i).getCliente() == null || miembros.get(i).getCliente().isEmpty()) {
			 						oportunidadContraro.setSupervisor("");
			 					} else {
			 						oportunidadContraro.setSupervisor(miembros.get(i).getCliente());
			 					}
			 				}
			 				if (oportunidadContraro.getPresidente() == null || oportunidadContraro.getPresidente().isEmpty()
			 					|| oportunidadContraro.getSecretario() == null || oportunidadContraro.getSecretario().isEmpty()
			 					|| oportunidadContraro.getTesorero() == null || oportunidadContraro.getTesorero().isEmpty() ) {
			 					oportunidadContraro.setPresidente(validarCamposNulosCadenas(oportunidadContraro.getPresidente(),
			 							CAMPO_CADENA_VACIA));
			 					oportunidadContraro.setSecretario(validarCamposNulosCadenas(oportunidadContraro.getSecretario(),
			 							CAMPO_CADENA_VACIA));
			 					oportunidadContraro.setTesorero(validarCamposNulosCadenas(oportunidadContraro.getTesorero(),
			 							CAMPO_CADENA_VACIA));
			 				}

									if (i + 1 != miembros.size()) {
										nombres = nombres + miembros.get(i).getCliente() + ", ";
									} else {
										nombres = nombres + miembros.get(i).getCliente();
									}
						}

		 			LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerCAT" );
					final java.util.HashMap<String, Object>	condicionesValor = (HashMap<String, Object>)
							sesion.selectOne( "obtenerCAT", contrato );
					final java.lang.String CAT = condicionesValor != null && condicionesValor.get( "valor" )
							!= null ? condicionesValor.get( "valor" ).toString() : "0";
					oportunidadContraro.setNombres2("");oportunidadContraro.setNombres3("");
					oportunidadContraro.setNombres4("");
		 			oportunidadContraro.setCat( CAT );
		 			oportunidadContraro.setNombres( validarCamposNulosCadenas(nombres, CAMPO_CADENA_VACIA) );
		 			oportunidadContraro.setNombresava( validarCamposNulosCadenas(nombres, CAMPO_CADENA_VACIA) );
		 			oportunidadContraro.setBranchcode( getBranchCodeMapeado(oportunidadContraro.getBranchcode()) );

		 			ofsComunal.addObject(oportunidadContraro, tipoContratoRespuesta);
					respuesta.setOfs_result(ofsComunal.getOFS());
				return respuesta;
			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS de salida: " + e.getMessage(), e);
				header.setMensaje( e.getMessage() );
				header.setEstatus( false );
				header.setUID( uid );
				respuesta.setEncabezado(header);
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}

		if (tipoInfo.equals(COMUNALES_DATOS_MIEMBROS) || tipoInfo.equals(COMUNALES_DATOS_MIEMBROS_FIN) ) {
			try {
				ObjetosImpresionDocumentos tipoContratoRespuesta = null;
				LogHandler.debug(uid, getClass(), "Contrato " + contrato
						+ " Tipo info " + tipoInfo + " COMUNALES DATOS MIEMBROS");
				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> comunalContrato - consulaDatosIntegrantes");
				List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", contrato);

				//Formateo del numero de cheque
				for ( MiembroGrupoVO miembroGrupoVO : miembros  )
					{
					miembroGrupoVO.setNumcheque( decimalFormat.format(
									Double.parseDouble( miembroGrupoVO.getNumcheque() ) ).trim() );
					//miembroGrupoVO.setCodigocte( miembroGrupoVO.getNumcheque() ) ;
					}

				ofsComunal.inicializaResultAssembler(miembros.size());
				LogHandler.trace(uid, getClass(), "==> comunalContrato - dsObtenerTipoContrato");
				HashMap<String, Object> tipoContrato = (HashMap<String, Object>)
						sesion.selectOne( "dsObtenerTipoContrato", contrato );
				String categoria = (String) tipoContrato.get("categoria");
				if (categoria.equals(CONTRATO_SOLIDARIO_CAT) && !tipoInfo.equals(COMUNALES_DATOS_MIEMBROS_FIN)) {
					ofsComunal.setTypeReturn(ObjetosImpresionDocumentos.CONTRATO_SOLIDARIO_DATOS_MIEMBROS);
						for (int i = 0; i < miembros.size(); i++)
							{
							LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerTelefonoKitImpresion");
							String telefono = (String) sesion.selectOne("obtenerTelefonoKitImpresion",
										miembros.get(i).getPersona());
							miembros.get(i).setNummiembro(i + 1 + "");
							Double montoFinanciado = Double.parseDouble(miembros.get(i).getMontoFinanciado());
							if (miembros.get(i).getImptecte() == null || miembros.get(i).getImptecte().isEmpty()) {
								miembros.get(i).setImptecte("No esta en catalogo");
							}
							if (montoFinanciado == null || montoFinanciado.equals(0) || montoFinanciado.equals("0.0000")) {
								miembros.get(i).setMontofin("0");
								miembros.get(i).setMontoreal("0");
							} else {
								Double montoReal = Double.parseDouble( miembros.get(i).getCapitalcte())
											- Double.parseDouble( miembros.get(i).getMontoFinanciado());
								miembros.get(i).setMontofin(miembros.get(i).getMontoFinanciado());
								miembros.get(i).setMontoreal(montoReal + "");
							}
							if (i != miembros.size() - 1) {
								miembros.get(i).setCodigocte( miembros.get(i).getCodigocte() == null
										|| miembros.get(i).getCodigocte().isEmpty()
										|| miembros.get(i).getCodigocte().trim().equals( "" ) ? ""
												: miembros.get(i).getCodigocte());
							} else {
								miembros.get(i).setCodigocte(miembros.get(i).getCodigocte());
							}
							miembros.get(i).setTel(telefono);
							ofsComunal.addObject(miembros.get(i), ObjetosImpresionDocumentos.CONTRATO_SOLIDARIO_DATOS_MIEMBROS);
						}
				} else {
					//Formato de la fecha
					final SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd/MM/yyyy" );

					//Fecha contable
					final Date fechaContable = comun.obtenerFechaContable(uid).getFecha();

					//Se define el tipo de cabecera
					tipoContratoRespuesta = tipoInfo.equals( COMUNALES_DATOS_MIEMBROS_FIN )
							? ObjetosImpresionDocumentos.MIEMBRO_GRUPO_FIN
									: ObjetosImpresionDocumentos.MIEMBRO_GRUPO;

					ofsComunal.setTypeReturn( tipoContratoRespuesta );

					for (int i = 0; i < miembros.size(); i++)
						{
						String montoFinanciado = miembros.get(i).getMontoFinanciado();
						if (miembros.get(i).getTipoid() == null || miembros.get(i).getTipoid().isEmpty())
							{
							miembros.get(i).setTipoid("No esta en catalogo");
							}
						if (montoFinanciado == null || montoFinanciado.isEmpty() || montoFinanciado.equals("0")
								|| montoFinanciado.equals("0.0000"))
							{
							miembros.get(i).setMontofin("0.0");
							//Mario Mejorada
							//2013-09-23 Comunal Financiada con clientes nuevos.
							//miembros.get(i).setMontoreal("0.0");
							miembros.get(i).setMontoreal(miembros.get(i).getCapitalcte());
							}
						else
							{
							Double montoReal = Double.parseDouble( miembros.get(i).getCapitalcte())
									- Double.parseDouble( miembros.get(i).getMontoFinanciado());
							miembros.get(i).setMontofin(miembros.get(i).getMontoFinanciado());
							miembros.get(i).setMontoreal(montoReal + "");
							}
						miembros.get(i).setNummiembro(i + 1 + "");

						//Datos contrato anterior
						//--Se realiza la consulta para traer el anterior contrato y su monto_liq
						if ( tipoContratoRespuesta.equals( ObjetosImpresionDocumentos.MIEMBRO_GRUPO_FIN ) )
							{
							miembros.get(i).setFecha( simpleDateFormat.format( fechaContable ) );
							miembros.get(i).setNumvale( "" );
							miembros.get(i).setNocliente( "" );
							miembros.get(i).setMontofinletra( getMontoLetras( miembros.get(i).getMontofin() ) );
							}

						ofsComunal.addObject(miembros.get(i), tipoContratoRespuesta);
						}
					}
				respuesta.setOfs_result(ofsComunal.getOFS());
				return respuesta;
			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS COMUNALES DATOS MIEMBROS: " + e.getMessage(), e);
				//e.printStackTrace();
				header.setMensaje( e.getMessage() );
				header.setEstatus( false );
				header.setUID( uid );
				respuesta.setEncabezado(header);
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}

		if (tipoInfo.equals(OPORTUNIDAD_DATOS_PAGOS)) {
			try {
				LogHandler.debug(uid, getClass(), "contrato " + contrato + " tipo info"
						+ tipoInfo + " OPORTUNIDAD DATOS PAGOS");
				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerAmortizacionGrupal ");
				List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", contrato);
				ofsComunal.inicializaResultAssembler(result.size());
				ofsComunal.setTypeReturn(ObjetosImpresionDocumentos.PAGO);
					for (int i = 0; i < result.size(); i++) {
						PagoGrupo pago = new PagoGrupo();
						pago.setFechapago(result.get(i).getFechaPago());
						pago.setImptepago(result.get(i).getMontoPago() + "");
						pago.setInteres(result.get(i).getInteresPeriodo() + "");
						pago.setNumpago(result.get(i).getNoPago() + "");
						pago.setCapital((result.get(i).getAbonoCapital() * 1000) / 1000 + "");
						pago.setImptepagored(Math.rint((result.get(i).getMontoPago() * 1000) / 1000) + "");
						ofsComunal.addObject(pago, ObjetosImpresionDocumentos.PAGO);
					}
				respuesta.setOfs_result(ofsComunal.getOFS());
				return respuesta;

			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS OPORTUNIDAD DATOS PAGOS: " + e.getMessage(), e);
				//e.printStackTrace();
				header.setMensaje( e.getMessage() );
				header.setEstatus( false );
				header.setUID( uid );
				respuesta.setEncabezado(header);
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}

		if (tipoInfo.equals(COMUNALES_DATOS_MIEMBROS_FIN_A) )
			{
			//Objeto para abrir una sesion de mybatis
			SqlSession sessionNTx = null;

			try {
				sessionNTx = FabricaConexiones.obtenerSesionNTx();

				//Se comprueba la validez del contrato y si es un contrato de una renovacion
				final String contratoAnterior = (String) sessionNTx.selectOne( "buscarContratoAnterior", contrato );

				if ( contratoAnterior == null )
					{
					throw new Exception( ReadProperties.mensajes.getProp(
							"kitimpresion.contratocomunalrenovado.error.contratoinvalido" )   + " ( " + contrato + " )" );
					}

				LogHandler.trace(uid, getClass(), " ==> comunalContrato - obtenerIntegrantesContratoAnterior");
				final List<HashMap<String, Object>>
								datosContrato = ( List<HashMap<String, Object>> )
								sessionNTx.selectList( "obtenerIntegrantesContratoAnterior" , contrato );

				//Se asignan los datos obtenidos
				if ( datosContrato == null || datosContrato.size() == 0 )
					{
					throw new Exception( ReadProperties.mensajes.getProp(
								"kitimpresion.contratocomunalrenovado.error.faltandatoscontrato" ) );
					}

				//Datos para inicializar el OFS
				ofsComunal.inicializaResultAssembler(datosContrato.size());
				ofsComunal.setTypeReturn(ObjetosImpresionDocumentos.MIEMBRO_GRUPO_ANT);

				//Se recupera el interes del contrato
				LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerAmortizacionGrupal ");
				final List<AmortizacionOV>
								pagosAmortizacion = sessionNTx.selectList("obtenerAmortizacionGrupal", contratoAnterior );

				Double interescontrato = 0D;
				for ( AmortizacionOV amortizacionOV : pagosAmortizacion )
					{
					interescontrato += Double.parseDouble( amortizacionOV.getInteresPeriodo().toString() );
					}

				//nos servira para el conteo de datos
				Integer indice = 1;
				for ( HashMap<String, Object> integrante :  datosContrato )
					{
					//Se calcula el interes
					final java.lang.Double interes = ( Double.parseDouble( integrante.get( "montoIntegrante" ).toString() )
							/ Double.parseDouble( integrante.get( "montoCapital" ).toString()  ) ) * interescontrato;

					//objeto para generar la salida del m�todo
					final 	MiembroGrupoAnteriorVO
							miembroGrupoAnteriorVO = new MiembroGrupoAnteriorVO();
							miembroGrupoAnteriorVO.setNoIndice( "" + indice++ );
							miembroGrupoAnteriorVO.setNombre( integrante.get( "nombre" ).toString() );
							miembroGrupoAnteriorVO.setMontochequeovale( integrante.get( "montoIntegrante" ).toString() );
							miembroGrupoAnteriorVO.setMontovalecredito( "0.00" );
							miembroGrupoAnteriorVO.setCapintereses("" + (interes
										+ Double.parseDouble(miembroGrupoAnteriorVO.getMontochequeovale())));
							miembroGrupoAnteriorVO.setFecha( integrante.get( "fecha" ) != null
										? integrante.get( "fecha" ).toString() : ""  );
							miembroGrupoAnteriorVO.setCantidad( integrante.get( "montoCapital" ).toString() );
							miembroGrupoAnteriorVO.setCantidadletra( getMontoLetras( miembroGrupoAnteriorVO.getCantidad() ) );
							miembroGrupoAnteriorVO.setLdanterior( integrante.get( "LDanterior" ).toString() );
							miembroGrupoAnteriorVO.setPagares( "" + datosContrato.size() );
							miembroGrupoAnteriorVO.setTasa( integrante.get( "tasa" ).toString() );
							miembroGrupoAnteriorVO.setSemanas( integrante.get( "numeroPagos" ).toString() );
							miembroGrupoAnteriorVO.setCiclo( integrante.get( "ciclo" ).toString() );
							miembroGrupoAnteriorVO.setDireccion( integrante.get( "direccion" ).toString() );
							//miembroGrupoAnteriorVO.setNoamort( "0" );
							miembroGrupoAnteriorVO.setNoamort( integrante.get( "ultimoPago" ) != null
										? integrante.get( "ultimoPago" ).toString() : "" );
							miembroGrupoAnteriorVO.setSdocapital( miembroGrupoAnteriorVO.getMontochequeovale() );
							miembroGrupoAnteriorVO.setSdointeres( interes.toString() );
							//miembroGrupoAnteriorVO.getCapintereses() );
							miembroGrupoAnteriorVO.setSdototal( "" + ( Double.parseDouble(
									miembroGrupoAnteriorVO.getMontochequeovale() )
									+ Double.parseDouble( miembroGrupoAnteriorVO.getSdointeres() ) ) );
							miembroGrupoAnteriorVO.setCapminteres( miembroGrupoAnteriorVO.getSdototal() );
							miembroGrupoAnteriorVO.setChequeovale( integrante.get( "chequeovale" ).toString() );
							miembroGrupoAnteriorVO.setValecredito( "-" );
							ofsComunal.addObject(miembroGrupoAnteriorVO, ObjetosImpresionDocumentos.MIEMBRO_GRUPO_ANT);
							respuesta.setOfs_result(ofsComunal.getOFS());
					}
				}
			catch ( java.lang.Exception exception )
				{
				LogHandler.error(uid, getClass(), "Error ocurrido : " + exception.getMessage(), exception );
				header.setMensaje( exception.getMessage() );
				header.setEstatus( false );
				header.setUID( uid );
				respuesta.setEncabezado( header );
				respuesta.setOfs_result(null);
				}
			finally
				{
				FabricaConexiones.close(sessionNTx);
				}
			}
		return respuesta;
		}

	/**
	 * @author out_jflores
	 * @param contrato .
	 * @param ld .
	 * @param tipoInfo .
	 * @param uid .
	 * @return OFS con el formato de los pagares Comunales
	 */
 	@SuppressWarnings(value = { "rawtypes", "unchecked" })
	public ImpresionDocsConsultaRespuesta comunalPagare(String contrato, String ld, String tipoInfo, String uid) {
		ImpresionDocsConsultaRespuesta respuesta = new ImpresionDocsConsultaRespuesta();
		final java.text.DecimalFormat decimalFormat = new DecimalFormat( "000000000" );
		SqlSession sesion = null;
		try {
			if (contrato == null || contrato.isEmpty()) {
				respuesta.setMsjError(CONTRATO_INVALIDO);
				return respuesta;
			}
			sesion = FabricaConexiones.obtenerSesionNTx();
			DecimalFormat df = new DecimalFormat("0.00");
	 		LogHandler.trace( uid, getClass(), " ==> comunalPagare - consulaDatosIntegrantes");
			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", contrato);

			//Objeto para los telefonos
			final java.util.HashMap<String, String>
										telefonos = new HashMap<String, String>();

			//Formateo del numero de cheque
			for ( MiembroGrupoVO miembroGrupoVO : miembros  )
				{
				miembroGrupoVO.setNumcheque( decimalFormat.format(
						Double.parseDouble( miembroGrupoVO.getNumcheque() ) ).trim() );
				//miembroGrupoVO.setCodigocte( miembroGrupoVO.getNumcheque() ) ;

				//Calculamos los telefonos
				LogHandler.trace(uid, getClass(), "==> comunalPagare - obtenerTelefonoKitImpresion");
				final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
				final String telefono = objectTel != null ? "" + objectTel : "";
				telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());
				}

			if (tipoInfo.equals("0")) {
				LogHandler.debug(uid, getClass(), "Comunal pagare ");
				OFSResultAssemblerImpl ofsAvales = new OFSResultAssemblerImpl();
				ofsAvales.inicializaResultAssembler( miembros.size( ) *4);
				ofsAvales.setTypeReturn(ObjetosImpresionDocumentos.AVAL);
				int count = 0;

				//Se determina el tipo de contrato
				LogHandler.trace(uid, getClass(), "==> comunalPagare - dsObtenerTipoContrato");
				final HashMap<String, Object>
							tipoContrato = (HashMap<String, Object>) sesion.selectOne( "dsObtenerTipoContrato", contrato );

				final String categoria = (String) tipoContrato.get("categoria");

				final java.lang.Integer miembrosOriginales = miembros.size();

				//Compensacion de avales solo para creditos comunales
				if (  miembros.size() <= INTEGRANTES_MINIMOS_AVAL && categoria.contains( "COM" )
						|| miembros.size() < INTEGRANTES_MINIMOS_AVAL && !categoria.contains( "COM" ) )
					{
					final HashMap<String, Object>
									params = new HashMap<String, Object>();
									params.put("contrato"	, contrato);

					LogHandler.trace(uid, getClass(), "==> comunalPagare - obtenerDatosAvales");
					final List<MiembroGrupoVO> miembrosExtras = sesion.selectList("obtenerDatosAvales", params);

					if (miembrosExtras.size() == 0) {
					  //Renovacion Especial
						LogHandler.debug(uid, getClass(), "Avales Renovacion Especial");
						for (int i = 0; i < miembrosOriginales; i++)
						{
						count = i + 1;

						for (int j = 1; j < miembrosOriginales; j++) {
							count =+ count;
							if ( count >= miembros.size() ) {
									count = 0;
								}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
										miembros.get(count).getEdocivil()));
							count ++;
							ofsAvales.addObject(aval, ObjetosImpresionDocumentos.AVAL);
							respuesta.setOfs_result(ofsAvales.getOFS());
						}
					}


					}

					//Formateo del numero de cheque
					for ( MiembroGrupoVO miembroGrupoVO : miembrosExtras  )
						{
						//Se determinan los telefonos
						LogHandler.trace(uid, getClass(), "==> comunalPagare - obtenerTelefonoKitImpresion");
						final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
						final String telefono = objectTel != null ? "" + objectTel : "";
						telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());

						//Se agrega los avalaes faltantes
						if ( miembros.size() <= INTEGRANTES_MINIMOS_AVAL ) {
								miembros.add( miembroGrupoVO );
							} else {
								break;
								}
						}

					}

				if (miembros.size() >= INTEGRANTES_MINIMOS_AVAL ) {
					for (int i = 0; i < miembrosOriginales; i++)
						{
						count = i + 1;
						for (int j = 1; j < (categoria.contains( "COM" ) ? 5 : 3); j++) {
							count =+count;
							if ( count >= miembros.size() ) {
									count = 0;
									}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
									miembros.get(count).getEdocivil()));
							count ++;
						ofsAvales.addObject(aval, ObjetosImpresionDocumentos.AVAL);
						respuesta.setOfs_result(ofsAvales.getOFS());
						}
					}
				}

				return respuesta;
			}

				LogHandler.trace(uid, getClass(), "==> comunalPagare - consulaDatosIntegrantes ");
				List<MiembroGrupoVO> miembrosGrupo = sesion.selectList("consulaDatosIntegrantes", contrato);

				//Formateo del numero de cheque
				for ( MiembroGrupoVO miembroGrupoVO : miembros  )
					{
					miembroGrupoVO.setNumcheque(decimalFormat.format(
							Double.parseDouble(miembroGrupoVO.getNumcheque() ) ).trim() );
					//miembroGrupoVO.setCodigocte( miembroGrupoVO.getNumcheque() ) ;
					}

				if (tipoInfo.equals("1")) {
					LogHandler.debug(uid, getClass(), "Comunal pagare Datos de los MIEMBROS");
					OFSResultAssemblerImpl ofsMiembros = new OFSResultAssemblerImpl();
					ofsMiembros.inicializaResultAssembler( miembrosGrupo.size() );
					ofsMiembros.setTypeReturn(ObjetosImpresionDocumentos.MIEMBRO_PAGARE);
					HashMap params = new HashMap();
					HashMap datosPersona = new HashMap();
					String edoCivil = "";
					String titGrupo = "";
					params.put("contrato", contrato);
					params.put("fechaActual", new Date());
					LogHandler.trace(uid, getClass(), "==> comunalPagare - consulaDatosContrato ");
					ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
					LogHandler.trace(uid, getClass(), "==> comunalPagare - obtenerSaldoFv ");
					CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne(	"obtenerSaldoFv", params);
					LogHandler.trace(uid, getClass(), "==> comunalPagare - direccionSucursal ");
					String direccionSucursal = (String) sesion.selectOne("direccionSucursal", creditoCliente.getSucursal());

					/*Se le da el formato en la direccion de la sucursal para el estado*/
					final String [] datosDirecccion = direccionSucursal.split(",");
					final String estadoTit =
							textoTipoTitulo( datosDirecccion[ datosDirecccion.length - 1 ].trim().toLowerCase() );
					direccionSucursal = direccionSucursal.replace(
							datosDirecccion[datosDirecccion.length - 1 ].trim(), estadoTit );
					//String entidad =textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase());
					//direccionSucursal = datamapper.DataMapper.mapClaveEntidad( direccionSucursal );
					for (int i = 0; i < miembrosGrupo.size(); i++)
						{
						LogHandler.trace(uid, getClass(), "==> comunalPagare - obtenerTelefonoKitImpresion");
						//Integer clienteId= Integer.parseInt(miembrosGrupo.get(i).getNumcheque());
						Integer clienteId = Integer.parseInt(miembrosGrupo.get(i).getCodigocte());
						MiembroGrupoPagare mp = new MiembroGrupoPagare();
						String persona = (String) miembros.get(i).getPersona();
						LogHandler.trace(uid, getClass(), "==> comunalPagare - datosPersona");
						datosPersona = (HashMap) sesion.selectOne("datosPersona", persona);
						String sexo = datosPersona.get("sexo") != null ? (String) datosPersona.get("sexo") : "";
						edoCivil = datosPersona.get("edoCivil") != null ? (String) datosPersona.get("edoCivil") : "";
						titGrupo = ObtenerTitAval(sexo, edoCivil);
						String montoLetra = miembros.get(i).getMontoOtorgado();
						mp.setCalle(miembrosGrupo.get(i).getCallecte());
						mp.setCiudad(miembrosGrupo.get(i).getCiudadcte());
						mp.setCliente(clienteId.toString());
						mp.setColonia(miembrosGrupo.get(i).getColoniacte());
						mp.setCp(miembrosGrupo.get(i).getCpcte());
						mp.setCtabanco(CUENTA_BANCO);
						mp.setDirsucursal(direccionSucursal);
						mp.setEmpresa(EMPRESA_FINSOL);
						mp.setEstado(miembrosGrupo.get(i).getEstadocte());
						mp.setFechainicio(direccionSucursal + "|" + contratoVO.getFechafirma());
						mp.setImporte(miembros.get(i).getMontoOtorgado());
						mp.setNombre(miembrosGrupo.get(i).getCliente());
						mp.setPagos(miembrosGrupo.get(i).getNoPagos());
						mp.setPeriodo(creditoCliente.getFrecuenciaPago());
						LogHandler.info(uid, getClass(), "====> Numero telefonico : "
										+ telefonos.get(miembros.get(i).getNummiembro()));
						mp.setTel( telefonos.get(miembros.get(i).getNummiembro()) );
						mp.setImpteletra(getMontoLetras(montoLetra));
						mp.setTitulo(titGrupo);
						//CALCULO DE LA TASA
								Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
								parametros.put( "sucursal", (Integer) (creditoCliente.getSucursal()));
								parametros.put( "fecha", new Date() );
								parametros.put( "codigo" , CODIGO_IVA );

								LogHandler.trace(uid, getClass(), "==> comunalPagare - obtenerTasaMoratoria");
								HashMap map = (HashMap) sesion.selectOne( "obtenerTasaMoratoria", contrato );
								Double tasa = Double.parseDouble(creditoCliente.getTasa());
								LogHandler.trace(uid, getClass(), "==> comunalPagare - " + OPER_VER_VALOR_HISTORICO);
								Integer iva  = (Integer) sesion.selectOne(OPER_VER_VALOR_HISTORICO, parametros);
								Double aux = (double) iva;
								mp.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
								Double tasaMora = Double.parseDouble( (String) map.get("valor") );
								mp.setTasamora(df.format((tasaMora * (1 + (aux / 100))) * 12));
						ofsMiembros.addObject(mp, ObjetosImpresionDocumentos.MIEMBRO_PAGARE);
					}
					respuesta.setOfs_result(ofsMiembros.getOFS());
					return respuesta;
				}

				if (tipoInfo.equals("2")) {
					LogHandler.trace("", getClass(), "==> comunalPagare - amortizacionPagares");
					List<AmortizacionOV> obj = sesion.selectList("amortizacionPagares", contrato);
					LogHandler.debug(uid, getClass(), "Comunal pagare Datos de los PAGO AMORTIZACION");
					OFSResultAssemblerImpl ofsPagos = new OFSResultAssemblerImpl();
					ofsPagos.inicializaResultAssembler(obj.size());
					ofsPagos.setTypeReturn(ObjetosImpresionDocumentos.PAGO_AMORTIZACION);
					for (int i = 0; i < obj.size(); i++) {
						int cliente = Integer.parseInt(obj.get(i).getIntegrante().trim());
						String saldoCapital = Double.toString(obj.get(i).getSaldoCapital());
						PagoGrupo pago = new PagoGrupo();
						pago.setCliente(cliente + "");
						pago.setFechapago(obj.get(i).getFechaPago());
						pago.setImptepago(Double.toString(obj.get(i).getMontoPago()));
						pago.setInteres(Double.toString(obj.get(i).getInteresPeriodo()));
						pago.setNumpago(obj.get(i).getNoPago().toString());
						pago.setCapital(Double.toString(obj.get(i).getAbonoCapital()));
						pago.setImptepagored(Math.rint((obj.get(i).getMontoPago() * 1000) / 1000) + "");
						pago.setSdo(saldoCapital);
						ofsPagos.addObject(pago, ObjetosImpresionDocumentos.PAGO_AMORTIZACION);
						respuesta.setOfs_result(ofsPagos.getOFS());
					}
					return respuesta;
				}

		} catch (Exception e) {
			//e.printStackTrace();
			respuesta.getEncabezado().setMensaje( e.getMessage() );
			respuesta.getEncabezado().setEstatus( false );
			respuesta.getEncabezado().setUID( uid );
			LogHandler.error(uid, getClass(), "Error al generar la cadena OFS de los pagares: " + e.getMessage(), e);
			respuesta.setMsjError(ERROR_CONSULTA);
		} finally {
			FabricaConexiones.close( sesion );
		}
		return respuesta;
	}

 	@SuppressWarnings("unchecked")
	public ImpresionDocsConsultaRespuesta fichaPagoEspecial(String contrato, String ld, String fecha, String uid) {
		ImpresionDocsConsultaRespuesta respuesta = new ImpresionDocsConsultaRespuesta();
		OFSResultAssemblerImpl ofsFichaEspecial = new OFSResultAssemblerImpl();
		EncabezadoRespuesta header  = new EncabezadoRespuesta();
		SqlSession sesion 			= null;
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();
			HashMap params = new HashMap();
			params.put("contrato", contrato);
			params.put("fechaActual", fecha == null || fecha.trim().equals( "" ) ? new Date() : fecha );

			//Se realiza el calculo de los sanldos apartir del SP
			LogHandler.trace(uid, getClass(), "==> fichaPagoEspecial - obtenerSaldoFv");
			CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne("obtenerSaldoFv", params);
			LogHandler.trace(uid, getClass(), "==> fichaPagoEspecial - consulaDatosContrato");
			ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
			LogHandler.trace(uid, getClass(), "==> fichaPagoEspecial - obtenerAmortizacionGrupal");
			List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", contrato);
			ofsFichaEspecial.inicializaResultAssembler(1);
			ofsFichaEspecial.setTypeReturn(ObjetosImpresionDocumentos.FICHA_PAGO_ESPECIAL);
			Double capitalPago = result.get(0).getAbonoCapital();
			Double tasa = Double.parseDouble(contratoVO.getTasa());
			LogHandler.trace(uid, getClass(), "==> fichaPagoEspecial - obtenerTasaMoratoria");
			HashMap map = (HashMap) sesion.selectOne( "obtenerTasaMoratoria", contrato );
			String tasaMora = (String) map.get("valor");
			Map<String, Object>parametros = new HashMap<String, Object>();
			parametros.put("sucursal", Integer.parseInt(contratoVO.getBranchcode()));
			parametros.put("codigo", CODIGO_IVA);
			parametros.put("fecha", new Date());
			LogHandler.trace(uid, getClass(), "==> fichaPagoEspecial - verValorHistorico");
			Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
			Double aux = (double) iva;

			final Double intMora = (((capitalPago * (Double.parseDouble(tasaMora) / 100)) / 30) * (1 + (aux / 100)));
			final DecimalFormat df = new DecimalFormat("0.00000");
				if (result != null) {
					double cantidadAuto = Double.parseDouble(creditoCliente.getMontoPrestamo());
					String cadenaBancomer = Funciones.obtenerCadenaBancomer(contratoVO.getContratoLD()) + "";
					String cadenaBanamex = Funciones.obtenerCadenaBanamex(contratoVO.getContratoLD()) + "";
					EspecialFichaPago pagoEspecial = new EspecialFichaPago();
					pagoEspecial.setCliente(contrato);
					pagoEspecial.setCiclo(contratoVO.getCiclogpo());
					pagoEspecial.setContbanmx(cadenaBanamex);
					pagoEspecial.setContbcmer(cadenaBancomer);
					pagoEspecial.setContrato(cadenaBancomer);
					//MHM 2012-08-02 Referencia HSBC
					parametros.clear();
					parametros.put("contrato", contrato );
					parametros.put("plazo", Integer.valueOf(contratoVO.getPlazo()) );
					LogHandler.trace(uid, getClass(), "==> fichaPago - obtenerReferencia30");
					HashMap<String,Object>  mapResult = (HashMap<String, Object>)
								sesion.selectOne("obtenerReferencia30", parametros);
					final String cadenaHSBC = mapResult.get("ref_30posiciones").toString();
					LogHandler.debug(uid, getClass(), "ref_30posiciones !!!!!!!!" + cadenaHSBC);
					pagoEspecial.setConthsbc(cadenaHSBC);
					pagoEspecial.setFrecuencia(creditoCliente.getFrecuenciaPago());
					pagoEspecial.setImptepago(result.get(0).getMontoPago().toString());
					pagoEspecial.setImptepagored(result.get(0).getMontoPagoRed().toString());
					pagoEspecial.setIntemoratorio(df.format(intMora));
					pagoEspecial.setLd(contratoVO.getContratoLD());
					pagoEspecial.setNombre(creditoCliente.getNombre().trim());
					pagoEspecial.setNumpago(result.get(0).getNoPago().toString());
					pagoEspecial.setSucursal(contratoVO.getDescSucursal().trim());
					pagoEspecial.setFechainicio(contratoVO.getFechafirma());
					pagoEspecial.setFechafin(contratoVO.getFfin());
					pagoEspecial.setCantidadauto((Math.rint((Double.parseDouble(creditoCliente.getMontoPrestamo()) * 100) / 100) + ""));
					pagoEspecial.setTotalpagar(creditoCliente.getSaldoLiquidar() + "");
					pagoEspecial.setSaldocapital(result.get(0).getSaldoCapital() + "");
					pagoEspecial.setDiasreales(getDiasTranscurridos(contratoVO.getDiasreales()) + "");
					pagoEspecial.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));

					/*
					 * TODO - Se mandara CERO hasta que A.Navarrete indique si son o
					 * no necesarios para la impresion de fichas especiales,
					 * si son necesarios estos campos, Cindy analizara de donde obtenerlos.
					 * (Ya se indico que si se pueden imprimir las fichas especiales
					 * ahora solo resta saber de donde se obtienen)
					 */
					pagoEspecial.setInteresmora("0"); //Se trabaja sobre la fecha de retorno
					pagoEspecial.setRecargos("0");
					pagoEspecial.setWorkingbalance("0");
					pagoEspecial.setInteresdevengados("0");
					pagoEspecial.setInterespagado("0");

					if (DataMapperAdministracion.mapProductosFinsol.containsKey(contratoVO.getTipocont()))
						{
						pagoEspecial.setTipo(DataMapperAdministracion.mapProductosFinsol.get(contratoVO.getTipocont()));
						}
					else {
						pagoEspecial.setTipo(contratoVO.getTipocont());
						}
					ofsFichaEspecial.addObject(pagoEspecial, ObjetosImpresionDocumentos.FICHA_PAGO_ESPECIAL);
				}
				respuesta.setOfs_result(ofsFichaEspecial.getOFS());
				return respuesta;
		} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS de las fichas de pago: " + e.getMessage(), e);
				//e.printStackTrace();
				respuesta.getEncabezado().setMensaje( e.getMessage() );
				respuesta.getEncabezado().setEstatus( false );
				respuesta.getEncabezado().setUID( uid );
				respuesta.setEncabezado(header);
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
	}

	/**
	 * @author out_jflores
	 * @param contrato .
	 * @param ld .
	 * @param uid .
	 * @return OFS con el formato de las fichas de pago
	 */
	@SuppressWarnings("unchecked")
	public ImpresionDocsConsultaRespuesta fichaPago(String contrato, String ld, String uid ) {
		ImpresionDocsConsultaRespuesta respuesta = new ImpresionDocsConsultaRespuesta();
		SqlSession sesion = null;
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", contrato);
			params.put("fechaActual", new Date());
			sesion = FabricaConexiones.obtenerSesionNTx();

			LogHandler.trace(uid, getClass(), "==> fichaPago - obtenerSaldoFv");
			CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne(	"obtenerSaldoFv", params);
			LogHandler.trace(uid, getClass(), "==> fichaPago - consulaDatosContrato");
			ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
			Map<String, Object>parametros = new HashMap<String, Object>();
			parametros.put("sucursal", Integer.parseInt(contratoVO.getBranchcode()));
			parametros.put("codigo", CODIGO_IVA);
			parametros.put("fecha", new Date());
			LogHandler.trace(uid, getClass(), "==> fichaPago - verValorHistorico");
			Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
			Double aux = (double) iva;
			if (creditoCliente == null ) {
				respuesta.setMsjError(CONTRATO_INVALIDO);
				return respuesta;
			}
			LogHandler.trace(uid, getClass(), "==> fichaPago - obtenerAmortizacionGrupal");
			List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", contrato);

			if (result != null) {
				OFSResultAssemblerImpl ofs = new OFSResultAssemblerImpl();
				ofs.inicializaResultAssembler(result.size());
				ofs.setTypeReturn(ObjetosImpresionDocumentos.FICHA_PAGO);
				FichaDePago pago = null;
				final String cadenaBancomer = Funciones.obtenerCadenaBancomer(contratoVO.getContratoLD()) + "";
				final String cadenaBanamex = Funciones.obtenerCadenaBanamex(contratoVO.getContratoLD()) + "";
				//MHM 2012-08-02 Referencia HSBC
				parametros.clear();
				parametros.put("contrato", contrato );
				parametros.put("plazo", Integer.valueOf( contratoVO.getPlazo() ) );
				LogHandler.trace(uid, getClass(), "==> fichaPago - obtenerReferencia30");
				HashMap<String, Object>  mapResult =
						(HashMap<String, Object>) sesion.selectOne("obtenerReferencia30", parametros);
				final String cadenaHSBC = mapResult.get("ref_30posiciones").toString();
				LogHandler.debug(uid, getClass(), "ref_30posiciones !!!!!!!!" + cadenaHSBC);

				LogHandler.trace(uid, getClass(), "==> fichaPago - obtenerTasaMoratoria");
				HashMap<String, Object> map =
						(HashMap<String, Object>) sesion.selectOne( "obtenerTasaMoratoria", contrato );
				for (int i = 0; i < result.size(); i++) {
					pago = new FichaDePago();
					pago.setCliente(contrato);
					pago.setCiclo(contratoVO.getCiclogpo());
					Double capitalPago = result.get(i).getAbonoCapital();
					Double tasaMora = Double.parseDouble((String)map.get("valor"));
					Double intMora = ((((capitalPago * (tasaMora / 100)) / 30)) * ((1 + (aux / 100))));

					LogHandler.debug(uid, getClass(), "INTERES MORA !!!!!!!!" + intMora);
					DecimalFormat df = new DecimalFormat("0.00000");
					pago.setFechapago(result.get(i).getFechaPago().toString());
					pago.setContbanmx(cadenaBanamex);
					pago.setContbcmer(cadenaBancomer);
					pago.setConthsbc(cadenaHSBC);
					pago.setContrato(cadenaBancomer);
					pago.setFrecuencia(creditoCliente.getFrecuenciaPago());
					pago.setImptepago(result.get(i).getMontoPago().toString());
					pago.setImptepagored(result.get(i).getMontoPagoRed().toString());
					pago.setIntemoratorio(df.format(intMora));
					pago.setLd(contratoVO.getContratoLD());
					pago.setNombre(creditoCliente.getNombre().trim());
					pago.setNumpago(result.get(i).getNoPago().toString());
					pago.setSucursal(contratoVO.getDescSucursal().trim() + "");

					if (DataMapperAdministracion.mapProductosFinsol.containsKey(contratoVO.getTipocont())) {
						pago.setTipo(           DataMapperAdministracion.mapProductosFinsol.get(contratoVO.getTipocont()));
					} else {
						pago.setTipo(             contratoVO.getTipocont());
					}
					ofs.addObject(pago, ObjetosImpresionDocumentos.FICHA_PAGO);

				}
				respuesta.setOfs_result(ofs.getOFS());
			}

		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error al generar el OFS de las fichas de pago" + e.getMessage(), e);
			//e.printStackTrace();
			respuesta.getEncabezado().setMensaje( e.getMessage() );
			respuesta.getEncabezado().setEstatus( false );
			respuesta.getEncabezado().setUID( uid );
			respuesta.setMsjError(ERROR_CONSULTA);
		} finally {
			FabricaConexiones.close( sesion );
		}
		return respuesta;
	}


	/**
	 * @param uid identificador unico de la peticion
	 * @param peticion para la generacion de la ficha especial de pago
	 * @return resultado de la ficha especial de pago
	 */
 	@SuppressWarnings("unchecked")
	public FichaEspecialRespuesta generaFichaEspecialPago(String uid, FichaEspecialPeticion peticion) {
 		FichaEspecialRespuesta respuesta = new FichaEspecialRespuesta();
 		respuesta.setHeader(new EncabezadoRespuesta());
 		respuesta.getHeader().setUID( uid );
		EspecialFichaPago pagoEspecial = new EspecialFichaPago();
		SqlSession sesion 			= null;
		SqlSession sesionTx 			= null;
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMdd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		String cadenaBancomer = "";
		String cadenaBanamex = "";
		String cadenaHSBC = "";
		String contratoGarantia = "";
		try {

			if ( peticion.getContrato() == null || peticion.getContrato().trim().isEmpty()) {
				throw new Exception("Es necesario el contrato en la peticion.");
			}

			if ( peticion.getUsuario() == null || peticion.getUsuario().trim().isEmpty()) {
				throw new Exception("Es necesario el usuario en la peticion.");
			}

			if ( peticion.getAlmacenaBD() == null) {
				peticion.setAlmacenaBD(true);
			}

			if ( peticion.getTipoImpresion() != null && peticion.getTipoImpresion().equals(TIPO_IMPR_GAR)) {

				peticion.setContrato(comun.obtenerNumeroContratoLD(uid, peticion.getContrato()));

				LogHandler.trace(uid, getClass(), "==> contratoGarantia - "
						+ peticion.getContrato());
				contratoGarantia = peticion.getContrato().substring(0,7)
						+ TIPO_IMPR_GAR + peticion.getContrato().substring(8);
				LogHandler.trace(uid, getClass(), "==> contratoGarantia - " + contratoGarantia);
			}

			sesion = FabricaConexiones.obtenerSesionNTx();
			String contrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());

			if ( contrato == null || contrato.trim().isEmpty()) {
				throw new Exception("El contrato no existe.");
			}
			String fecha = peticion.getFecha();

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", contrato);
			params.put("fechaActual", fecha == null || fecha.trim().equals( "" ) ? new Date() : fecha );
			//Se realiza el calculo de los sanldos apartir del SP
			LogHandler.trace(uid, getClass(), "==> generaFichaEspecialPago - obtenerSaldoFv");
			CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne("obtenerSaldoFv", params);
			LogHandler.trace(uid, getClass(), "==> generaFichaEspecialPago - consulaDatosContrato");
			ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
			LogHandler.trace(uid, getClass(), "==> generaFichaEspecialPago - obtenerAmortizacionGrupal");
			List<AmortizacionOV> result = (List<AmortizacionOV>) sesion.selectList("obtenerAmortizacionGrupal", contrato);
			Double capitalPago = result.get(0).getAbonoCapital();
			Double tasa = Double.parseDouble(contratoVO.getTasa());
			LogHandler.trace(uid, getClass(), "==> generaFichaEspecialPago - obtenerTasaMoratoria");
			HashMap<String, Object> map = (HashMap<String, Object>) sesion.selectOne( "obtenerTasaMoratoria", contrato );
			String tasaMora = (String) map.get("valor");
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("sucursal", Integer.parseInt(contratoVO.getBranchcode()));
			parametros.put("codigo", CODIGO_IVA);
			parametros.put("fecha", new Date());
			LogHandler.trace(uid, getClass(), "==> generaFichaEspecialPago - verValorHistorico");
			Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
			Double aux = (double) iva;

			final Double intMora = ((capitalPago * (Double.parseDouble(tasaMora) / Constantes.CENTENA)) / Constantes.DIAS_MES)
					* (1 + (aux / Constantes.CENTENA));
			final DecimalFormat df = new DecimalFormat("0.00000");
				if (result != null) {

					if (contratoGarantia.equals("")) {
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - sin garantia");
						cadenaBancomer = Funciones.obtenerCadenaBancomer(contratoVO.getContratoLD()) + "";
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - sg - Bancomer " + cadenaBancomer );
						cadenaBanamex = Funciones.obtenerCadenaBanamex(contratoVO.getContratoLD()) + "";
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - sg - Banamex " + cadenaBanamex);
						cadenaHSBC = "8003"	+ contratoVO.getContratoLD().substring(2) + "002012319999999";
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - sg - HSBC " + cadenaHSBC);

					} else {
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - con garantia");
						cadenaBancomer = Funciones.obtenerCadenaBancomer(contratoGarantia) + "";
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - cg - Bancomer " + cadenaBancomer );
						cadenaBanamex = Funciones.obtenerCadenaBanamexDepositoGarantia(contratoGarantia) + "";
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - cg - Banamex " + cadenaBanamex);
						cadenaHSBC = "7582"	+ contratoGarantia.substring(2) + "002012319999999";
						LogHandler.trace(uid, getClass(), "==> referenciasBancarias - cg - HSBC " + cadenaHSBC);

					}

					//Parametros de la consulta
					java.util.HashMap<String, Object> paramsDV = new java.util.HashMap<String, Object>();
					paramsDV.put("referencia", cadenaHSBC);
					LogHandler.trace(uid, getClass(), "==> consultaReferenciasPago - algoritmo21" );
					final String digitoVerificador = (String) sesion.selectOne( "algoritmo21" , paramsDV );
					cadenaHSBC += digitoVerificador;

					pagoEspecial.setCliente(contrato);
					pagoEspecial.setCiclo(contratoVO.getCiclogpo());
					pagoEspecial.setContbanmx(cadenaBanamex);
					pagoEspecial.setContbcmer(cadenaBancomer);

					pagoEspecial.setContrato(contrato);//Comentar para pagos en linea OXXO
//NO OXXO					pagoEspecial.setContrato(cadenaBancomer); //Descomentar para pagos en linea OXXO
					//MHM 2012-08-02 Referencia HSBC
					parametros.clear();
					parametros.put("contrato", contrato );
					parametros.put("plazo", Integer.valueOf(contratoVO.getPlazo()) );
					LogHandler.trace(uid, getClass(), "==> generaFichaEspecialPago - obtenerReferencia30");
//					HashMap<String, Object>  mapResult
//						= (HashMap<String, Object>) sesion.selectOne("obtenerReferencia30", parametros);
//					final String cadenaHSBC = mapResult.get("ref_30posiciones").toString();
					LogHandler.debug(uid, getClass(), "ref_30posiciones !!!!!!!!" + cadenaHSBC);
					pagoEspecial.setConthsbc(cadenaHSBC);
					pagoEspecial.setFrecuencia(creditoCliente.getFrecuenciaPago());
					pagoEspecial.setImptepago(result.get(0).getMontoPago().toString());
					pagoEspecial.setImptepagored(result.get(0).getMontoPagoRed().toString());
					pagoEspecial.setIntemoratorio(df.format(intMora));
					pagoEspecial.setLd(contratoVO.getContratoLD());
					pagoEspecial.setNombre(creditoCliente.getNombre().trim());
					pagoEspecial.setNumpago(result.get(0).getNoPago().toString());
					pagoEspecial.setSucursal(contratoVO.getDescSucursal().trim());
					pagoEspecial.setFechainicio(contratoVO.getFechafirma());
					pagoEspecial.setFechafin(contratoVO.getFfin());
					pagoEspecial.setCantidadauto(Math.rint((Double.parseDouble(
								creditoCliente.getMontoPrestamo()) * Constantes.CENTENA) / Constantes.CENTENA) + "");
					pagoEspecial.setTotalpagar(creditoCliente.getSaldoLiquidar() + "");
					pagoEspecial.setTotalPagarFormato(formatMontos(creditoCliente.getSaldoLiquidar().toString() != null
							? creditoCliente.getSaldoLiquidar().toString() : "0.0"));
					pagoEspecial.setSaldocapital(result.get(0).getSaldoCapital() + "");
					pagoEspecial.setDiasreales(getDiasTranscurridos(contratoVO.getDiasreales()) + "");
					pagoEspecial.setTasa(df.format((tasa * (1 + (aux / Constantes.CENTENA))) * Constantes.MESES_ANIO));
					pagoEspecial.setInteresmora("0"); //Se trabaja sobre la fecha de retorno
					pagoEspecial.setRecargos("0");
					pagoEspecial.setWorkingbalance("0");
					pagoEspecial.setInteresdevengados("0");
					pagoEspecial.setInterespagado("0");

					if (DataMapperAdministracion.mapProductosFinsol.containsKey(contratoVO.getTipocont())) {
						pagoEspecial.setTipo(DataMapperAdministracion.mapProductosFinsol.get(contratoVO.getTipocont()));
					}
					else {
						pagoEspecial.setTipo(contratoVO.getTipocont());
					}
					pagoEspecial.setSaldoGarantia(contratoVO.getSaldoGarantia());
					pagoEspecial.setSaldoGarantiaFormato(formatMontos(pagoEspecial.getSaldoGarantia().toString() != null
							? pagoEspecial.getSaldoGarantia().toString() : "0.0"));

					pagoEspecial.setTotalAPagar(creditoCliente.getSaldoLiquidar() - pagoEspecial.getSaldoGarantia());
					pagoEspecial.setTotalAPagarFormato(formatMontos(pagoEspecial.getTotalAPagar().toString() != null
							? pagoEspecial.getTotalAPagar().toString() : "0.0"));

					Date miFecha = sdf1.parse(peticion.getFecha());
					pagoEspecial.setFechaPago(sdf2.format(miFecha));

					pagoEspecial.setGarantiaADepositar(contratoVO.getGarantiaADepositar());
					pagoEspecial.setGarantiaADepositarFormat(formatMontos(contratoVO.getGarantiaADepositar().toString() != null
							? pagoEspecial.getGarantiaADepositar().toString() : "0.0"));
					if (pagoEspecial.getGarantiaADepositarFormat().equals(".00")) {
						pagoEspecial.setGarantiaADepositarFormat("0.0");
					}

					pagoEspecial.setGarantiaTraspasada(contratoVO.getGarantiaTraspasada());
					pagoEspecial.setGarantiaTraspasadaFormat(formatMontos(contratoVO.getGarantiaTraspasada().toString() != null
							? pagoEspecial.getGarantiaTraspasada().toString() : "0.0"));
					if (pagoEspecial.getGarantiaTraspasadaFormat().equals(".00")) {
						pagoEspecial.setGarantiaTraspasadaFormat("0.0");
					}

					pagoEspecial.setTotalPagarGarantia(contratoVO.getGarantiaADepositar() - contratoVO.getGarantiaTraspasada());
					pagoEspecial.setTotalPagarGarantiaFormat(formatMontos(pagoEspecial.getTotalPagarGarantia().toString() != null
							? pagoEspecial.getTotalPagarGarantia().toString() : "0.0"));
					if (pagoEspecial.getTotalPagarGarantiaFormat().equals(".00")) {
						pagoEspecial.setTotalPagarGarantiaFormat("0.0");
					}

					String codigo = pagoEspecial.getLd() + pagoEspecial.getImptepago().replace(".", "");
					pagoEspecial.setCodigoBarras(codigo);

				}

				//ReferenciasBancarias
				ConsultaReferenciasPagoPeticion peticionRef = new ConsultaReferenciasPagoPeticion();
				peticionRef.setContrato(contrato);
				peticionRef.setNumContrato(contrato);
				peticionRef.setMontoPago(String.valueOf(creditoCliente.getMontoPago()));
				peticionRef.setProducto("CRED");

				ConsultaReferenciasPagoRespuesta referencias = consultas.consultaReferenciasPago(peticionRef, uid);

				if (!referencias.getHeader().isEstatus()) {
					throw new Exception("Ocurrio un error al obtener las referencias : "
							+ referencias.getHeader().getMensaje() +  " UID:  "  + referencias.getHeader().getUID());
				}
				pagoEspecial.setReferenciaOXXO(referencias.getReferenciaOXXO());
				pagoEspecial.setReferenciaDIESTEL(referencias.getreferenciaDIESTEL());
				pagoEspecial.setReferenciaPayBin(referencias.getReferenciaPayBin());
				//Fin ReferenciasBancarias

				respuesta.setFichaEspecial(pagoEspecial);

				if ( peticion.getAlmacenaBD() ) {
					//Registrar Ficha Especial
					sesionTx = FabricaConexiones.obtenerSesionTx();
					SimpleDateFormat formatFecha = new SimpleDateFormat("yyyyMMdd");
					parametros.clear();
					parametros.put("contrato", contrato);
					parametros.put("fecha_contable", formatFecha.format(comun.obtenerFechaContable(uid).getFecha().getTime()));
					parametros.put("fecha_calculo", formatFecha.parse(fecha));
					parametros.put("usuario", peticion.getUsuario());
					parametros.put("importe", Double.parseDouble(pagoEspecial.getTotalpagar() == null ? "0.0"
							 : pagoEspecial.getTotalpagar()));
					/*Iterator it = parametros.entrySet().iterator();
					while (it.hasNext()) {
					Map.Entry e = (Map.Entry)it.next();
					LogHandler.info(uid, getClass(), "hash->" +e.getKey() + " " + e.getValue());
					}*/
					sesionTx.insert("insertaFichaPromesaLiq", parametros);
					sesionTx.commit(true);
				}
		} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generaFichaEspecialPago: " + e.getMessage(), e);
				respuesta.getHeader().setMensaje( e.getMessage() );
				respuesta.getHeader().setEstatus( false );
		} finally {
				FabricaConexiones.close(sesion);
				FabricaConexiones.close(sesionTx);
		}
		return respuesta;
	}

	/**
	 * @author rmendoza
	 * @param<ul>
	 *  <li>sexo: string con M=masculino F=femenino</li>
	 *  <li>edoCivil: String con V=viudo, U=UnionLibre D=Divorciado, C=Casado</li>
	 * </ul>
	 * @return Cadena con el titulo del aval Sr., Sta., Sra. etc
	 */
	private String ObtenerTitAval(String sexo, String edoCivil) {
		if (sexo.equals(MUJER)) {
			if (edoCivil.equals(SOLTERO)) {
				edoCivil = "Sta.";
				return edoCivil;
			}
			if (edoCivil.equals(CASADO) || edoCivil.equals(VIUDO) || edoCivil.equals(DIVORCIADO)
					|| edoCivil.equals(UNION_LIBRE) || edoCivil.equals("CASADO")
					|| edoCivil.equals("UNION LIBRE") || edoCivil.equals("DIVORCIADO")) {
				edoCivil = "Sra.";
				return edoCivil;
			} else {
				edoCivil = "C.";
				return edoCivil;
			}
		}
		if (sexo.equals(HOMBRE)) {
			edoCivil = "Sr.";
			return edoCivil;
		}
		edoCivil = "C.";
		return edoCivil;
	}

	/**
	 * @author out_jflores
	 * @param contrato .
	 * @param ld .
	 * @param tipoInfo .
	 * @param uid .
	 *
	 * @return OFS con formato para los contratos oportunidad
	 */
	@SuppressWarnings("unchecked")
	public ImpresionDocsConsultaRespuesta oportunidadContrato(String contrato, String ld, String tipoInfo, String uid) {
		OFSResultAssemblerImpl ofsOportunidad = new OFSResultAssemblerImpl();
		final java.text.DecimalFormat decimalFormat = new DecimalFormat( "000000000" );
		ImpresionDocsConsultaRespuesta respuesta = new ImpresionDocsConsultaRespuesta();
		SqlSession sesion 			= null;
		ContratoVO contratoVO 		= null;
		DecimalFormat df = new DecimalFormat("0.00");
		OportunidadContratoOV oportunidadContraro = null;
		if (tipoInfo.equals(OPORTUNIDAD_DATOS_GRUPO)) {
			try {
				sesion = FabricaConexiones.obtenerSesionNTx();
				String nombres = "";
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - dsConsultaContratoOportunidad");
				oportunidadContraro = (OportunidadContratoOV) sesion.selectOne("dsConsultaContratoOportunidad", contrato);
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - consulaDatosIntegrantes");
				List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", contrato);

				//Formateo del numero de cheque
				for ( MiembroGrupoVO miembroGrupoVO : miembros  )
					{
					miembroGrupoVO.setNumcheque( decimalFormat.format(
								Double.parseDouble( miembroGrupoVO.getNumcheque() ) ).trim() );
					//miembroGrupoVO.setCodigocte( miembroGrupoVO.getNumcheque() ) ;
					}

				ofsOportunidad.inicializaResultAssembler(1);
				ofsOportunidad.setTypeReturn(ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_DATOS_GRUPO);
				//Se formatea el campo cdaFirma
				oportunidadContraro.setCdadfirma( oportunidadContraro.getCdadfirma().toUpperCase() );
				oportunidadContraro.setNombreApoderado(oportunidadContraro.getNombreApoderado());
				oportunidadContraro.setImpteletras(getMontoLetras(oportunidadContraro.getImporte()));
				oportunidadContraro.setImptepagoletra(getMontoLetras(oportunidadContraro.getImptepago()));

				Map<String, Object>parametros = new HashMap<String, Object>();
				parametros.put( "sucursal", Integer.parseInt(oportunidadContraro.getBranchcode()));
				parametros.put( "fecha", new Date() );
				parametros.put( "codigo" , CODIGO_IVA );
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - " + OPER_VER_VALOR_HISTORICO);
				Integer iva  = (Integer) sesion.selectOne(OPER_VER_VALOR_HISTORICO, parametros );
				Double aux = (double) iva;
				Double tasa = Double.parseDouble(oportunidadContraro.getTasa());
				oportunidadContraro.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - consulaDatosContrato");
				contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", contrato);
				final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, contratoVO.getEjecutivo().trim());
				oportunidadContraro.setEjecutivo( asesorOV != null ? asesorOV.getNombreCompleto() : "" );
						oportunidadContraro.setDirsucursal(oportunidadContraro.getDirsucursal()
								+ ", " + textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase()));
						oportunidadContraro.setNombregpo(contratoVO.getNombregpo());
				 			for (int i = 0; i < miembros.size(); i++) {
				 				if (miembros.get(i).getRol().equals(ID_PRESIDENTE)) {
									oportunidadContraro.setPresidente(miembros.get(i).getNombrec());
								}
				 				if (miembros.get(i).getRol().equals(ID_SECRETARIO)) {
									oportunidadContraro.setSecretario(miembros.get(i).getNombrec());
								}
				 				if (miembros.get(i).getRol().equals(ID_TESORERO)) {
									oportunidadContraro.setTesorero(miembros.get(i).getNombrec());
								}
				 				if (oportunidadContraro.getPresidente() == null || oportunidadContraro.getPresidente().isEmpty()
				 						|| oportunidadContraro.getSecretario() == null
				 						|| oportunidadContraro.getSecretario().isEmpty()
				 						|| oportunidadContraro.getTesorero() == null
				 						|| oportunidadContraro.getTesorero().isEmpty()) {
				 					oportunidadContraro.setPresidente(
				 							validarCamposNulosCadenas(oportunidadContraro.getPresidente(), CAMPO_CADENA_VACIA));
				 					oportunidadContraro.setSecretario(
				 							validarCamposNulosCadenas(
				 									oportunidadContraro.getSecretario(), CAMPO_CADENA_VACIA));
				 					oportunidadContraro.setTesorero(
				 							validarCamposNulosCadenas(oportunidadContraro.getTesorero(), CAMPO_CADENA_VACIA));
				 				}
					 				if ( i + 1 != miembros.size()) {
										nombres = nombres + miembros.get(i).getCliente() + ", ";
									} else {
										nombres = nombres + miembros.get(i).getCliente();
									}
					 				if (miembros.get(i).getRol().equals(ID_SUPERVISOR)) {
					 					if (miembros.get(i).getCliente() == null || miembros.get(i).getCliente().isEmpty()) {
					 						LogHandler.debug(uid, getClass(), "ENTRO EN EL IF DE VACIO !!!!!!!!!");
					 						oportunidadContraro.setSupervisor("");
					 					} else {
					 					oportunidadContraro.setSupervisor(miembros.get(i).getCliente());
					 					}
					 				}
							}

	 			LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerCAT" );
				final java.util.HashMap<String, Object>
										condicionesValor = (HashMap<String, Object>) sesion.selectOne( "obtenerCAT", contrato );
				final java.lang.String CAT = condicionesValor != null && condicionesValor.get( "valor" ) != null
						? condicionesValor.get( "valor" ).toString() : "0";
				oportunidadContraro.setNombres2("");
				oportunidadContraro.setNombres3("");
				oportunidadContraro.setNombres4("");
				oportunidadContraro.setTipocont("CREDITO OPORTUNIDAD");
	 			oportunidadContraro.setCat( CAT );
	 			oportunidadContraro.setNombres(nombres);
	 			oportunidadContraro.setNombresava(nombres);
	 			oportunidadContraro.setBranchcode(getBranchCodeMapeado(oportunidadContraro.getBranchcode()));
				ofsOportunidad.addObject(oportunidadContraro, ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_DATOS_GRUPO);
				respuesta.setOfs_result(ofsOportunidad.getOFS());
				return respuesta;
			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS de OPORTUNIDAD CONTRATO", e);
				//e.printStackTrace();
				respuesta.getEncabezado().setMensaje( e.getMessage() );
				respuesta.getEncabezado().setEstatus( false );
				respuesta.getEncabezado().setUID( uid );
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}
		if (tipoInfo.equals(OPORTUNIDAD_DATOS_MIEMBROS)) {
			try {
				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - consulaDatosIntegrantes");
				List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", contrato);

				//Formateo del numero de cheque
				for ( MiembroGrupoVO miembroGrupoVO : miembros  )
					{
					miembroGrupoVO.setNumcheque(decimalFormat.format(
								Double.parseDouble(miembroGrupoVO.getNumcheque() ) ).trim());
					//miembroGrupoVO.setCodigocte( miembroGrupoVO.getNumcheque() ) ;
					}

				ofsOportunidad.inicializaResultAssembler(miembros.size());
				ofsOportunidad.setTypeReturn(ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_DATOS_MIEMBROS);
				for (int i = 0; i < miembros.size(); i++) {
					miembros.get(i).setNummiembro(i + 1 + "");
					String montoFinanciado = miembros.get(i).getMontoFinanciado();
					if (miembros.get(i).getTipoid() == null || miembros.get(i).getTipoid().isEmpty()) {
						miembros.get(i).setTipoid("No esta en catalogo");
					}
					if (montoFinanciado.isEmpty() || montoFinanciado == null || montoFinanciado.equals("0.0000")
								|| montoFinanciado.equals("0")) {
						miembros.get(i).setMontofin("0");
						miembros.get(i).setMontoreal("0");
					} else {
						Double montoReal = Double.parseDouble( miembros.get(i).getCapitalcte())
									- Double.parseDouble( miembros.get(i).getMontofin());
						miembros.get(i).setMontofin(miembros.get(i).getMontoFinanciado());
						miembros.get(i).setMontoreal(montoReal + "");
					}
					//Se coloca el monto en real en el formato que le corresponde
					miembros.get(i).setMontoreal( df.format( Double.parseDouble( miembros.get(i).getMontoreal() ) ) );
					ofsOportunidad.addObject(miembros.get(i), ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_DATOS_MIEMBROS);
				}
				respuesta.setOfs_result(ofsOportunidad.getOFS());
				return respuesta;
			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS de OPORTUNIDAD DATOS MIEMBROS: " + e.getMessage(), e);
				//e.printStackTrace();
				respuesta.getEncabezado().setMensaje( e.getMessage() );
				respuesta.getEncabezado().setEstatus( false );
				respuesta.getEncabezado().setUID( uid );
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}

		if (tipoInfo.equals(OPORTUNIDAD_DATOS_PAGOS)) {
			try {
				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - obtenerAmortizacionGrupal");
				List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", contrato);
				ofsOportunidad.inicializaResultAssembler(result.size());
				ofsOportunidad.setTypeReturn(ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_DATOS_PAGOS);
				for (AmortizacionOV m : result) {
					PagoGrupo pago = new PagoGrupo();
					pago.setFechapago(m.getFechaPago());
					pago.setImptepago(m.getMontoPago() + "");
					pago.setInteres(m.getInteresPeriodo() + "");
					pago.setNumpago(m.getNoPago() + "");
					pago.setCapital(m.getAbonoCapital() + "");
					pago.setImptepagored(Math.rint((m.getMontoPago() * 1000) / 1000) + "");
					ofsOportunidad.addObject(pago, ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_DATOS_PAGOS);
				}
				respuesta.setOfs_result(ofsOportunidad.getOFS());
				return respuesta;

			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el OFS de OPORTUNIDAD DATOS PAGOS: " + e.getMessage(), e);
				//e.printStackTrace();
				respuesta.getEncabezado().setMensaje( e.getMessage() );
				respuesta.getEncabezado().setEstatus( false );
				respuesta.getEncabezado().setUID( uid );
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}
		if (tipoInfo.equals(OPORTUNIDAD_NOMBRE_CLIENTE)) {
			try {
				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> oportunidadContrato - dsObtenerIntegrantes");
				List<DatosMiembrosVO> result = sesion.selectList("dsObtenerIntegrantes", contrato);
				ofsOportunidad.inicializaResultAssembler(result.size());
				ofsOportunidad.setTypeReturn(ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_NOMBRES_CLIENTES);
				for (DatosMiembrosVO m : result) {
					DatosMiembrosVO datosMiembros = new DatosMiembrosVO();
					datosMiembros.setNombre(m.getNombre());
					ofsOportunidad.addObject(datosMiembros, ObjetosImpresionDocumentos.CONTRATO_OPORTUNIDAD_NOMBRES_CLIENTES);
				}
				respuesta.setOfs_result(ofsOportunidad.getOFS());
				return respuesta;

			} catch (Exception e) {
				LogHandler.error(uid, getClass(),
							"Error al generar el OFS de OPORTUNIDAD NOMBRES CLIENTES: " + e.getMessage(), e);
				//e.printStackTrace();
				respuesta.getEncabezado().setMensaje( e.getMessage() );
				respuesta.getEncabezado().setEstatus( false );
				respuesta.getEncabezado().setUID( uid );
				return respuesta;
			} finally {
				FabricaConexiones.close(sesion);
			}
		}
		return respuesta;
	}


	public OportunidadPagareRespuesta oportunidadPagare(String contrato, String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	public SolidarioContratoRespuesta solidarioContrato(String contrato, String uid) {
		// TODO Auto-generated method stub
		return null;
	}


	public SolidarioPagareRespuesta solidarioPagare(String contrato, String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getMontoLetras(String importe) {
		//Para el formato de los decimales extras necesitamos 2 ceros
		final java.text.DecimalFormat
						decimalFormat = new DecimalFormat("00");
		final Numero2Letra NumLetra = new Numero2Letra();
		return (NumLetra.Convertir(importe.split("[.]")[0], true)
				+ "PESOS "
				+ decimalFormat.format( Double.parseDouble( (importe.split("[.]")[1]) ) )
				+ "/100 MN");
	}

	private String getBranchCodeMapeado(String sucursal) {
		String result ="";
		for(int i = 2; i < sucursal.length(); i++) {
			result =result + String.valueOf(sucursal.charAt(i));
		}
		result = result + "000";
		return result;
	}

	private String validarCamposNulosCadenas(String campo,int tipo) {
		if (tipo == CAMPO_CADENA_VACIA) {
			String respuesta = "";
			if (campo == null || campo.isEmpty()) {
				return respuesta;
			} else {
				return campo;
			}
		} else {
			String respuesta ="0";
			if (campo == null || campo.isEmpty() || campo.equals("0")) {
				return respuesta;
			} else {
				return campo;
			}
		}
	}

	private int getDiasTranscurridos(String fechaDisposicion) {
			try {
				SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaDis = formatoFecha.parse(fechaDisposicion);
				Date actual = new Date();
				GregorianCalendar date1 = new GregorianCalendar();
				GregorianCalendar date2 = new GregorianCalendar();
				date1.setTime(fechaDis);
				date2.setTime(actual);
				GregorianCalendar dateTemp = null;
				int diff = (date2.get(Calendar.YEAR)) - (date1.get(Calendar.YEAR));
				dateTemp = (GregorianCalendar) date1.clone();

				int sum = 0;
					for (int i = 0; i < diff; i++) {
						sum += dateTemp.isLeapYear(dateTemp.get(Calendar.YEAR)) ? 366 : 365;
						dateTemp.add(Calendar.YEAR, 1);
					}
						int numeroCorrectoDias = sum + ((date2.get(Calendar.DAY_OF_YEAR) - (date1.get(Calendar.DAY_OF_YEAR))));
				return numeroCorrectoDias;
			} catch (Exception e) {
				return 0;
			}
		}

	public String textoTipoTitulo(String cadena) {
		String cadenaConvertir = cadena;
		String resto = cadenaConvertir.substring(1);
		char letra = cadenaConvertir.charAt(0);
		letra = Character.toUpperCase(letra);
		return ( letra + resto.toLowerCase() );
	}

	public ImpresionDocsConsultaRespuesta generaDocumentoKitImpresion( String uid, ImpresionDocsConsulta peticion) {
		ImpresionDocsConsultaRespuesta respuesta = new ImpresionDocsConsultaRespuesta();
		String tipoDato = "";
		try {
			respuesta.setNumVeces("1");

			//se realiza la conversion de credito t24 a credprod
			String numeroContrato = comun.obtenerNumeroContrato(null/*uid*/, peticion.getNumeroCredito());
			if (numeroContrato == null || numeroContrato.isEmpty( ) ) {
				respuesta.setMsjError( "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
				return respuesta;
			}
			int tipo = peticion.getTipo();

			switch ( tipo ) {

				case KIT_FIN_CONTRACT:
					if ( peticion.getTipoDato().equals("0") || peticion.getTipoDato().equals("1")
							|| peticion.getTipoDato().equals("2") || peticion.getTipoDato().equals("21")
							|| peticion.getTipoDato().equals("22") || peticion.getTipoDato().equals("23")) {
						respuesta  = comunalContrato(numeroContrato, peticion.getNumeroCredito(), peticion.getTipoDato(), uid );
					}
					else if	( peticion.getTipoDato().equals("3") || peticion.getTipoDato().equals("4")
							|| peticion.getTipoDato().equals("5") || peticion.getTipoDato().equals("6") ) {
						if (peticion.getTipoDato().equals("3")) tipoDato = "0";
						else if ( peticion.getTipoDato().equals("4")) tipoDato = "1";
						else if ( peticion.getTipoDato().equals("5")) tipoDato = "2";
						else if ( peticion.getTipoDato().equals("6")) tipoDato = "3";
							respuesta = oportunidadContrato(numeroContrato, peticion.getNumeroCredito(), tipoDato, uid );
					}
					else if	(peticion.getTipoDato().equals("7") || peticion.getTipoDato().equals("8")
							|| peticion.getTipoDato().equals("9") ) {
						if (peticion.getTipoDato().equals("7")) tipoDato = "0";
						else if ( peticion.getTipoDato().equals("8")) tipoDato = "1";
						else if ( peticion.getTipoDato().equals("9")) tipoDato = "2";
							respuesta = comunalContrato(numeroContrato, peticion.getNumeroCredito(), tipoDato, uid );
					}
					break;
				case  KIT_FIN_PROMISE_NOTE:
					if ( peticion.getTipoDato().equals("12") || peticion.getTipoDato().equals("1")
							|| peticion.getTipoDato().equals("2") ) {
						if (peticion.getTipoDato().equals("12")) tipoDato = "0";
						else if ( peticion.getTipoDato().equals("1")) tipoDato = "1";
						else if ( peticion.getTipoDato().equals("2")) tipoDato = "2";
						respuesta  = comunalPagare(numeroContrato, peticion.getNumeroCredito(), tipoDato, uid );
					}
					else if	( peticion.getTipoDato().equals("6") || peticion.getTipoDato().equals("4")
							|| peticion.getTipoDato().equals("5") ) {
						if (peticion.getTipoDato().equals("6")) tipoDato = "0";
						else if ( peticion.getTipoDato().equals("4")) tipoDato = "1";
						else if ( peticion.getTipoDato().equals("5")) tipoDato = "2";
						respuesta  = comunalPagare(numeroContrato, peticion.getNumeroCredito(), tipoDato, uid );
					}
					else if	( peticion.getTipoDato().equals("18") || peticion.getTipoDato().equals("8")
							|| peticion.getTipoDato().equals("9") ) {
						if (peticion.getTipoDato().equals("18")) tipoDato = "0";
						else if ( peticion.getTipoDato().equals("8")) tipoDato = "1";
						else if ( peticion.getTipoDato().equals("9")) tipoDato = "2";
						respuesta  = comunalPagare(numeroContrato, peticion.getNumeroCredito(), tipoDato, uid );
					}
					break;
				case  KIT_FIN_PAYMENT:
					if (peticion.getTipoDato().equals("11")) {
						 respuesta = fichaPagoEspecial(numeroContrato, peticion.getNumeroCredito(),
								 		peticion.getFechaPeticion(), uid );
					} else {
						respuesta = fichaPago(numeroContrato, peticion.getNumeroCredito(), uid );
					}
					break;
				default:
					respuesta.setOfs_result("");
				break;
			}

		} catch ( Exception e) {
			LogHandler.error(uid, getClass(), "Error al generar el kit de impresion: " + e.getMessage(), e);
			respuesta.getEncabezado().setMensaje( e.getMessage() );
			respuesta.getEncabezado().setEstatus( false );
			respuesta.getEncabezado().setUID( uid );
			//e.printStackTrace();
		}
		return respuesta;
	}

	/**
	 * Se obtiene la tabla de amortizaciones
	 * @param uid identificador unico
	 * @param cuenta contrato
	 * @return List<AmortizacionActualOV>
	 * @throws Exception .
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private List<AmortizacionActualOV> amortizacionGrupoActual(String uid, String cuenta) throws Exception {
		List pagos = null;
		try {
		  pagos = comun.storeEstadoCuentaEx(uid, cuenta,
				  ObtenerEstadoCuenta.AMORTIZACION_GRUPAL_ACTUAL/*obtenerAmortizacionGrupalActual*/);
		} catch ( Exception e ) {
			LogHandler.error(uid, getClass(), "Existio un error dentro de obtenerUnidadEspecializada", e);
			throw new Exception("No se pudo obtener la tabla de AmortizacionActual." );
		}
		return (pagos != null	&& !pagos.isEmpty() && pagos.get(0) instanceof AmortizacionActualOV) ? pagos : null;
	}

	/**
	 * @param uid identificador unico
	 * @param peticion para obtener el estado de cuenta
	 * @return ContratoFinsolRespuesta
	 */
	@SuppressWarnings("unchecked")
	public ContratoFinsolRespuesta generaContratoFinsol(String uid, ContratoPeticionKit peticion) {
		ContratoFinsolRespuesta respuesta = new ContratoFinsolRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		ContratoFinsolOV contrato = null;
		List<AmortizacionActualOV> amortizacionActual = null;
		List<CreditoGrupalCSOV> infoCreditoGrupal = null;
		List<CreditoOportunidadOV> infoCreditoOportunidad = null;
		List<CartaInstruccionOV> infoCartaInstruccion = null;

		SqlSession sesion = null;

		try {
			if (peticion.getContrato() == null || peticion.getContrato().isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}
			//Fabrica de conexiones
			sesion = FabricaConexiones.obtenerSesionNTx();
			//Se obtiene el numero de contrato
			String numeroContrato = comun.obtenerNumeroContrato(uid, peticion.getContrato());
			if (numeroContrato == null || numeroContrato.isEmpty()) {
				throw new Exception("NO SE HA ENCONTRADO INFORMACIÓN PARA ESTE NUMERO DE CONTRATO.");
			}
			//Se obtiene la infomacion del contrato
			LogHandler.trace(uid, getClass(), "==>Contrato - generaContratoFinsol");
			contrato = (ContratoFinsolOV) sesion.selectOne("consultaInformacionContrato", numeroContrato);

			if (contrato == null) {
				throw new Exception("NO SE HA ENCONTRADO INFORMACIÓN PARA ESTE NUMERO DE CONTRATO.");
			}
			//Se hace la validación del ambiente de trabajo para p_independencia
			String dbEntorno = sesion.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "consulaDatosIntegrantesFinsol:	dbEntorno: " + dbEntorno);
			final HashMap<Object, Object> parametros = new HashMap<Object, Object>();
			parametros.put("dbEntorno", dbEntorno);
			parametros.put("contrato", numeroContrato);

			//Se consulta la informacion de los clientes
			List<MiembroGrupoVO> miembros = null;
			if ( contrato.getTipoProducto().trim().equals("GOS1") ) {
				miembros = sesion.selectList("consulaDatosIntegrantesFinsolOpor", parametros);
			} else {
				miembros = sesion.selectList("consulaDatosIntegrantesFinsol", parametros);
			}

			if (miembros == null) {
				throw new Exception("NO SE HA ENCONTRADO INFORMACIÓN DE LOS INTEGRANTES." );
			}

			//Se obtene el CAT
			LogHandler.trace(uid, getClass(), "==> Contrato - generaContratoFinsol - obtenerCAT" );
			final HashMap<String, Object>
						condicionesValor = (HashMap<String, Object>) sesion.selectOne( "obtenerCAT", numeroContrato );
			final String cat = condicionesValor != null && condicionesValor.get("valor") != null
						? condicionesValor.get("valor").toString() : "0";
			contrato.setCat(cat);
			Double montoTotalPagar = contrato.getPagoParcialPesos() * contrato.getNumPagos();
			contrato.setMontoTotalPagar(montoTotalPagar);
//			contrato.setImptepagored(formatMontos(montoTotalPagar + "" ));

			//Se obtiene el Tipo de producto
			String tipoProducto =  DataMapper.mapCategoriaProductos.get(contrato.getTipoProducto());
			LogHandler.trace(uid, getClass(), "==>Contrato - tipoProducto -> " +  tipoProducto);
			contrato.setTipoProducto(tipoProducto);

			if ("OPORTUNIDAD".equals(tipoProducto)) {
				infoCreditoOportunidad = new ArrayList<CreditoOportunidadOV>();
			}

			if ("SOLIDARIO".equals(tipoProducto) || "COMUNAL".equals(tipoProducto)) {
				infoCreditoGrupal = new ArrayList<CreditoGrupalCSOV>();
			}

			if (contrato.isFinanciado()) {
				infoCartaInstruccion = new ArrayList<CartaInstruccionOV>();
			}

			//Bandera para saber si existe seguro de vida y/o enfermedad en algun cliente
			boolean vida = false;
			boolean enfermedad = false;
			for (int i = 0; i  < miembros.size(); i++) {
				if ("OPORTUNIDAD".equals(tipoProducto)) {
					//Se llena informacion Credito Oportunidad
					CreditoOportunidadOV oportunidad = new CreditoOportunidadOV();
					oportunidad.setNombreAcreditado(miembros.get(i).getCliente());
					oportunidad.setNumeroCheque(miembros.get(i).getNumcheque());
					oportunidad.setImporteCheque(
							miembros.get(i).getMontoCheque() != null
							? Double.parseDouble(miembros.get(i).getMontoCheque())
							: 0);
					oportunidad.setMontoTotalPagar(
							miembros.get(i).getImptecte() != null
							? Double.parseDouble(miembros.get(i).getImptecte())
							: 0);
					infoCreditoOportunidad.add(oportunidad);
				} else if ("SOLIDARIO".equals(tipoProducto) || "COMUNAL".equals(tipoProducto)) {
					//Se llena informacion Credito Grupal
					CreditoGrupalCSOV creditoGrupal = new CreditoGrupalCSOV();
					creditoGrupal.setNombreAcreditado(miembros.get(i).getCliente());
					creditoGrupal.setMontoCreditoOtorgado(
							miembros.get(i).getMontoOtorgado() != null
							? Double.parseDouble(miembros.get(i).getMontoOtorgado())
							: 0);
					creditoGrupal.setSeguroVida(miembros.get(i).getTieneSeguroVida());
					creditoGrupal.setSeguroEnfermedad(miembros.get(i).getTieneSeguroEnfermedad());
					creditoGrupal.setMontoSeguroVida(
							miembros.get(i).getMontoSeguroVida() != null
							? Double.parseDouble(miembros.get(i).getMontoSeguroVida())
							: 0);
					creditoGrupal.setMontoSeguroEnfermedad(
							miembros.get(i).getMontoSeguroEnfermedad() != null
							? Double.parseDouble(miembros.get(i).getMontoSeguroEnfermedad())
							: 0);
					creditoGrupal.setPlazoSeguroEnfermedad(miembros.get(i).getPlazoSeguroEnfermedad());
					creditoGrupal.setPlazoSeguroVida(miembros.get(i).getPlazoSeguroVida());
					infoCreditoGrupal.add(creditoGrupal);
				}

				//Se llena Carta_instruccion_finsol v0.1
				if (contrato.isFinanciado()) {
					CartaInstruccionOV cartaInstruccion = new CartaInstruccionOV();
					cartaInstruccion.setNombreCliente(miembros.get(i).getCliente());
					cartaInstruccion.setAdeudoPrevio(Double.parseDouble(miembros.get(i).getMontoFinanciado()));
					cartaInstruccion.setMontoFinanciar(Double.parseDouble(miembros.get(i).getMontoOtorgado()));
					cartaInstruccion.setEfectivoEntregar(cartaInstruccion.getMontoFinanciar()
							- cartaInstruccion.getAdeudoPrevio());
					infoCartaInstruccion.add(cartaInstruccion);
				}

				if (!"No".equals(miembros.get(i).getTieneSeguroVida())) {
					vida = true;
				}

				if (!"No".equals(miembros.get(i).getTieneSeguroEnfermedad())) {
					enfermedad = true;
				}

			}
			contrato.setInfoCartaInstruccion(infoCartaInstruccion);
			contrato.setInfoCreditoGrupal(infoCreditoGrupal);
			contrato.setInfoCreditoOportunidad(infoCreditoOportunidad);

			//Tabla de amortizacion
			amortizacionActual = amortizacionGrupoActual(uid, numeroContrato);
			if (amortizacionActual != null && !amortizacionActual.isEmpty()) {
				contrato.setAmorizaciones(amortizacionActual);
			}

			//Leyendas de la caratula de vida y de enfermedad
			/* Si algun cliente tiene seguro vida o enfermedad se hace la validacion para
			 * ver si aplica o no la leyenda */
			if (vida) {
				ParGeneralOV parVida = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "LEYENDA_VIDA");

				if (parVida == null) {
					throw new Exception("No se pudo obtener el valor de LEYENDA_VIDA");
				}
				contrato.setLeyendaVidaCaratula(parVida.getCgValor());

			} else {
				contrato.setLeyendaVidaCaratula("");
			}
			if (enfermedad) {
				ParGeneralOV parEnfermedad = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "LEYENDA_ENFERMEDAD");

				if (parEnfermedad == null) {
					throw new Exception("No se pudo obtener el valor de LEYENDA_ENFERMEDAD");
				}
				contrato.setLeyendaEnfermedadCaratula(parEnfermedad.getCgValor());
			} else {
				contrato.setLeyendaEnfermedadCaratula("");
			}

			//Se obtiene EL numero de Paginas que se va a mandar en el contrato
			contrato.setNumeroPagina(obtenerNumeroPaginasContrato(contrato.getTipoProducto(), miembros));


			respuesta.setContrato(contrato);

		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "generaContratoFinsol(): " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( e.getMessage());
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}

	/**
	 * Metodo que se utiliza para regresar el numero de hojas en el contrato para el jasper
	 * @param tipoProducto Es tipo de producto
	 * @param miembros Es la lista de los integrantes.
	 * @return Regresa el numero de paginas para el contrato
	 */
	private String obtenerNumeroPaginasContrato(String tipoProducto,  List<MiembroGrupoVO> miembros) {
		String respuesta = null;
		int paginaInicialFirmas = PAGINA_INICAL_FIRMAS;
		int paginaSiguienteFirmas = PAGINA_SIGUIENTE_FIRMAS;
		int numeroIntegrantes = miembros.size();
		int numeroPaginas = 0;
		int auxIntegrantes = 0;
		int restoIntegrantes = 0;
		if (tipoProducto.equals("COMUNAL")) {
			int paginaComunal = PAGINA_COMUNAL;
			if (numeroIntegrantes >= paginaInicialFirmas) {
				auxIntegrantes = numeroIntegrantes - paginaInicialFirmas;
				if (auxIntegrantes >= paginaSiguienteFirmas) {
					numeroPaginas = auxIntegrantes / paginaSiguienteFirmas;
					restoIntegrantes = auxIntegrantes % paginaSiguienteFirmas;
					if (restoIntegrantes > 0 ) {
						numeroPaginas = numeroPaginas + 1;
					} else {
						numeroPaginas = 1;
					}
				} else {
					numeroPaginas = 1;
				}
				numeroPaginas += 1;
			} else {
				numeroPaginas = 1;
			}
			numeroPaginas = numeroPaginas + paginaComunal;
		} else if (tipoProducto.equals("SOLIDARIO")) {
			int paginaSolidario = PAGINA_SOLIDARIO;
			if (numeroIntegrantes >= paginaInicialFirmas) {
				auxIntegrantes = numeroIntegrantes - paginaInicialFirmas;
				if (auxIntegrantes >= paginaSiguienteFirmas) {
					numeroPaginas = auxIntegrantes / paginaSiguienteFirmas;
					restoIntegrantes = auxIntegrantes % paginaSiguienteFirmas;
					if (restoIntegrantes > 0 ) {
						numeroPaginas = numeroPaginas + 1;
					} else {
						numeroPaginas = 1;
					}
				} else {
					numeroPaginas = 1;
				}
				numeroPaginas += 1;
			} else {
				numeroPaginas = 1;
			}
			numeroPaginas = numeroPaginas + paginaSolidario;

		}
		else if (tipoProducto.equals("OPORTUNIDAD")) {
			int paginaOportunidad = PAGINA_OPORTUNIDAD;
			if (numeroIntegrantes >= paginaInicialFirmas) {
				auxIntegrantes = numeroIntegrantes - paginaInicialFirmas;
				if (auxIntegrantes >= paginaSiguienteFirmas) {
					numeroPaginas = auxIntegrantes / paginaSiguienteFirmas;
					restoIntegrantes = auxIntegrantes % paginaSiguienteFirmas;
					if (restoIntegrantes > 0 ) {
						numeroPaginas = numeroPaginas + 1;
					} else {
						numeroPaginas = 1;
					}
				} else {
					numeroPaginas = 1;
				}
				numeroPaginas += 1;
			} else {
				numeroPaginas = 1;
			}
			numeroPaginas = numeroPaginas + paginaOportunidad;
		}

		respuesta = new Integer(numeroPaginas).toString();
		return respuesta;
	}


	@SuppressWarnings("unchecked")
	public ContratoComunalKitRespuesta generaContratoComunalDepositoGarantia(String uid , ContratoPeticionKit contratoPeticion) {
		ContratoComunalKitRespuesta respuesta = new ContratoComunalKitRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		ContratoVO contratoVO = null;
		DecimalFormat df = new DecimalFormat("0.00");

		final java.text.DecimalFormat decimalFormat = new DecimalFormat( "000000000" );

		try
		{
			if (contratoPeticion.getContrato() == null || contratoPeticion.getContrato().isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}
			if (contratoPeticion.getReca() == null) {
				contratoPeticion.setReca("");
			}

			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoPeticion.getContrato() );
			if (numeroContrato == null || numeroContrato.isEmpty( ) ) {
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
			}
			//Contrato General
			OportunidadContratoOV oportunidadContraro = null;

			String nombres = "";
			Double aux = 0.0;

			LogHandler.trace(uid, getClass(), "==>comunalContrato - dsConsultaContratoOportunidad");
			oportunidadContraro = (OportunidadContratoOV) sesion.selectOne("dsConsultaContratoDepositoGarantia", numeroContrato);

			if (oportunidadContraro == null) {
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
			}
			LogHandler.trace(uid, getClass(), "==>comunalContrato - consulaDatosIntegrantes");
			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", numeroContrato);

			LogHandler.info(uid, getClass(), "==>comunalContrato - " + Double.parseDouble(oportunidadContraro.getImptepago()));
			LogHandler.info(uid, getClass(), "==>comunalContrato - " + Double.parseDouble(oportunidadContraro.getTasa()) );


			oportunidadContraro.setImpteletras(getMontoLetras(oportunidadContraro.getImporte()));
			oportunidadContraro.setImporte(formatMontos(oportunidadContraro.getImporte()));
			oportunidadContraro.setImptepagoletra(getMontoLetras(oportunidadContraro.getImptepago()));
			LogHandler.trace(uid, getClass(), "==> comunalContrato - consulaDatosContrato");
			contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);
			String importeRed = (Math.rint((Double.parseDouble(oportunidadContraro.getImptepago()) * 1000) / 1000) + "");
			oportunidadContraro.setImptepagoletrared(getMontoLetras(importeRed));
			oportunidadContraro.setNombregpo(contratoVO.getNombregpo());
			Map<String, Object>parametros = new HashMap<String, Object>();
			parametros.put("sucursal", Integer.parseInt(oportunidadContraro.getBranchcode()));
			parametros.put("codigo", CODIGO_IVA);
			parametros.put("fecha", new Date());
			LogHandler.trace(uid, getClass(), "==> comunalContrato - verValorHistorico");
			Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
			aux = (double) iva;
			Double tasa = Double.parseDouble(oportunidadContraro.getTasa());
			oportunidadContraro.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));

			Double montoTotalPagar = Double.parseDouble(oportunidadContraro.getImptepago())
					* Double.parseDouble(oportunidadContraro.getPlazo());


			//Se adapta la direccion de la sucursal
			oportunidadContraro.setDirsucursal(oportunidadContraro.getDirsucursal()
					+ "," + textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase()));
			LogHandler.trace(uid, getClass(), "==> comunalContrato - consulaDatosContrato");
			//contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);
			LogHandler.info(uid, this.getClass(), "Se carga el asesor externo." +  contratoVO.getEjecutivo() );
			//Obtenemos los asesores
			final AsesorOV asesorOV = AsesorData.obtenAsesor(uid, contratoVO.getEjecutivo().trim());
			oportunidadContraro.setEjecutivo( asesorOV != null ? asesorOV.getNombreCompleto() : "" );

			oportunidadContraro.setFechaEscritura( formatFechaNormal(oportunidadContraro.getFechaEscritura()));
			oportunidadContraro.setTipocont("CREDITO COMUNAL");

			oportunidadContraro.setSucursal( oportunidadContraro.getSucursal().trim() );

			for (int i = 0; i  < miembros.size(); i++) {
		 				if (miembros.get(i).getRol().equals(ID_PRESIDENTE)) {
							oportunidadContraro.setPresidente(miembros.get(i).getCliente());
						}
		 				if (miembros.get(i).getRol().equals(ID_SECRETARIO)) {
							oportunidadContraro.setSecretario(miembros.get(i).getCliente());
						}
		 				if (miembros.get(i).getRol().equals(ID_TESORERO)) {
							oportunidadContraro.setTesorero(miembros.get(i).getCliente());
						}
		 				if (miembros.get(i).getRol().equals(ID_SUPERVISOR)) {

		 					if (miembros.get(i).getCliente() == null || miembros.get(i).getCliente().isEmpty()) {

		 						oportunidadContraro.setSupervisor("");
		 					} else {

		 					oportunidadContraro.setSupervisor(miembros.get(i).getCliente());
		 					}
		 				}
		 				if (oportunidadContraro.getPresidente() == null || oportunidadContraro.getPresidente().isEmpty()
		 						|| oportunidadContraro.getSecretario() == null || oportunidadContraro.getSecretario().isEmpty()
		 						|| oportunidadContraro.getTesorero() == null || oportunidadContraro.getTesorero().isEmpty() ) {
		 					oportunidadContraro.setPresidente(
		 							validarCamposNulosCadenas(oportunidadContraro.getPresidente(), CAMPO_CADENA_VACIA));
		 					oportunidadContraro.setSecretario(
		 							validarCamposNulosCadenas(oportunidadContraro.getSecretario(), CAMPO_CADENA_VACIA));
		 					oportunidadContraro.setTesorero(
		 							validarCamposNulosCadenas(oportunidadContraro.getTesorero(), CAMPO_CADENA_VACIA));
		 				}

								if (i + 1 != miembros.size()) {
									nombres = nombres + miembros.get(i).getCliente() + ", ";
								} else {
									nombres = nombres + miembros.get(i).getCliente();
								}
					}

	 			LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerCAT" );
				final java.util.HashMap<String, Object>
							condicionesValor = (HashMap<String, Object>) sesion.selectOne( "obtenerCAT", numeroContrato );
				final java.lang.String CAT = condicionesValor != null && condicionesValor.get( "valor" ) != null
							? condicionesValor.get( "valor" ).toString() : "0";
				oportunidadContraro.setNombres2("");
				oportunidadContraro.setNombres3("");
				oportunidadContraro.setNombres4("");
	 			oportunidadContraro.setCat( CAT );
	 			oportunidadContraro.setNombres( validarCamposNulosCadenas(nombres, CAMPO_CADENA_VACIA) );
	 			oportunidadContraro.setNombresava( validarCamposNulosCadenas(nombres, CAMPO_CADENA_VACIA) );
	 			oportunidadContraro.setBranchcode( getBranchCodeMapeado(oportunidadContraro.getBranchcode()) );


	 			oportunidadContraro.setFechavto( formatFecha14(oportunidadContraro.getFechavto( )));
	 			oportunidadContraro.setFechafirma( formatFecha8(oportunidadContraro.getFechafirma()));
	 			oportunidadContraro.setFfin( formatFecha3(oportunidadContraro.getFfin()) );
	 			oportunidadContraro.setFinicio( formatFecha3(oportunidadContraro.getFinicio()) );

	 			oportunidadContraro.setImptepagored(
	 													formatMontos(	montoTotalPagar + "" )
	 											   );
	 			oportunidadContraro.setMontoGarantia(formatMontos(oportunidadContraro.getMontoGarantia()));
	 			oportunidadContraro.setMontoGarantiaLetra(getMontoLetras(validaMonto(oportunidadContraro.getMontoGarantia())));
	 			oportunidadContraro.setReca(contratoPeticion.getReca());
	 			respuesta.setDatosGeneralesContrato(oportunidadContraro);

	 			//Cheques
	 			for ( MiembroGrupoVO miembroGrupoVO : miembros )
				{
	 				//miembroGrupoVO.setNumcheque( "XXXXXXX" ) ;
	 				miembroGrupoVO.setNumcheque( decimalFormat.format(
	 								Double.parseDouble( miembroGrupoVO.getNumcheque() ) ).trim() );
				}



	 			//Integrates
	 			boolean auxVida = false;
	 			boolean auxEnfermedades = false;
				for (int i = 0; i < miembros.size(); i++)
					{
						String montoFinanciado = miembros.get(i).getMontoFinanciado();
						if (miembros.get(i).getTipoid() == null || miembros.get(i).getTipoid().isEmpty())
							{
							miembros.get(i).setTipoid("No esta en catalogo");
							}
						if (montoFinanciado == null || montoFinanciado.isEmpty() || montoFinanciado.equals("0")
									|| montoFinanciado.equals("0.0000"))
							{
							miembros.get(i).setMontofin("0.0");
							miembros.get(i).setMontoreal("0.0");
							}
						else
							{
							Double montoReal = Double.parseDouble( miembros.get(i).getCapitalcte())
											- Double.parseDouble( miembros.get(i).getMontoFinanciado());
							miembros.get(i).setMontofin(miembros.get(i).getMontoFinanciado());
							miembros.get(i).setMontoreal(montoReal + "");
							}
						miembros.get(i).setNummiembro(i + 1 + "");

						miembros.get(i).setCapitalcte( formatMontos(miembros.get(i).getCapitalcte()) );
						miembros.get(i).setMontoOtorgado( formatMontos(miembros.get(i).getMontoOtorgado()) );
						miembros.get(i).setImptecte( formatMontos(miembros.get(i).getImptecte()) );
						miembros.get(i).setFnacimiento( formatFecha3(miembros.get(i).getFnacimiento()) );
						miembros.get(i).setMontoGarantia( formatMontos(miembros.get(i).getMontoGarantia()) );
						miembros.get(i).setMontoGarantiaLetras(getMontoLetras(validaMonto(miembros.get(i).getMontoGarantia())));
						miembros.get(i).setMontoSeguroVida(formatMontos(miembros.get(i).getMontoSeguroVida()));
						miembros.get(i).setMontoSeguroEnfermedad(formatMontos(miembros.get(i).getMontoSeguroEnfermedad()));

						LogHandler.trace(uid, getClass(), "ImporteVale" + miembros.get(i).getImporteValeCredito());

						miembros.get(i).setImporteValeCreditoLetra(getMontoLetras(miembros.get(i).getImporteValeCredito()));
						miembros.get(i).setImporteValeCredito(formatMontos(miembros.get(i).getImporteValeCredito()));

						if (miembros.get(i).getImporteValeCredito().equals(".00")) {
							miembros.get(i).setImporteValeCredito("0.00");
							miembros.get(i).setImporteValeCreditoLetra("CERO PESOS 00/100 MN");
						}

						if (Double.parseDouble(miembros.get(i).getMontoSeguroVida()) > 0) {
							auxVida = true;
						}

						if (Double.parseDouble(miembros.get(i).getMontoSeguroEnfermedad()) > 0) {
							auxEnfermedades = true;
						}

						miembros.get(i).setReca(contratoPeticion.getReca());

					}

		if (auxVida) {
			ParGeneralOV parVida = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "LEYENDA_VIDA");

			if (parVida == null) {
				throw new Exception("No se pudo obtener el valor de LEYENDA_VIDA");
			}
			respuesta.getDatosGeneralesContrato().setLeyendaVidaCaratula(parVida.getCgValor());
		} else {
			respuesta.getDatosGeneralesContrato().setLeyendaVidaCaratula(
					" ");
		}
		if (auxEnfermedades) {
			ParGeneralOV parEnfermedad = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "LEYENDA_ENFERMEDAD");

			if (parEnfermedad == null) {
				throw new Exception("No se pudo obtener el valor de LEYENDA_ENFERMEDAD");
			}
			respuesta.getDatosGeneralesContrato().setLeyendaEnfermedadCaratula(parEnfermedad.getCgValor());
		} else {
			respuesta.getDatosGeneralesContrato().setLeyendaEnfermedadCaratula(
					"  ");
		}

		respuesta.setIntegrantes(miembros);


				//Amortizaciones

				List<PagoGrupo> pagos = new ArrayList<PagoGrupo>();

				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerAmortizacionGrupal ");
				List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", numeroContrato);
					for (int i = 0; i < result.size(); i++) {
						PagoGrupo pago = new PagoGrupo();
						pago.setFechapago(formatFecha15(result.get(i).getFechaPago()));
						pago.setImptepago( formatMontos(result.get(i).getMontoPago() + ""));
						pago.setInteres( formatMontos(result.get(i).getInteresPeriodo() + ""));
						pago.setNumpago( result.get(i).getNoPago() + "");
						pago.setCapital( formatMontos((result.get(i).getAbonoCapital() * 1000) / 1000 + ""));
						pago.setImptepagored( formatMontos(Math.rint((result.get(i).getMontoPago() * 1000) / 1000) + ""));
						pagos.add(pago);
					}

				respuesta.setAmortizacion(pagos);

				//Se agrega parte para contrato anterior

				if (contratoPeticion.getAnterior()) {

					LogHandler.trace(uid, getClass(), "==>comunalContratoGarantia - obtenerContratoAnterior");
					String contratoAnterior =
							(String) sesion.selectOne("obtenerContratoAnterior", numeroContrato);

					if (contratoAnterior == null || contratoAnterior.isEmpty()) {
						throw new Exception(  "NO SE PUDO OBTENER EL CONTRATO ANTERIOR" );
					}

					ContratoComunalKitRespuesta respuestaAnterior =
							generaContratoComunalDepositoGarantiaAnterior(uid, contratoAnterior);

					if (respuestaAnterior.getHeader().isEstatus()) {
					respuesta.setDatosGeneralesContratoAnterior(respuestaAnterior.getDatosGeneralesContrato());
					respuesta.setIntegrantesAnterior(respuestaAnterior.getIntegrantes());
					} else {
						throw new Exception(  "OCURRIO UN ERROR AL OBTENER LOS DATOS EL CONTRATO ANTERIOR" );
					}
				}

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "generaContratoComunalDepositoGarantia(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;

	}


	/**
	 * Genera contrato comunal deposito garantia anterior.
	 *
	 * @param uid the uid
	 * @param contratoAnterior the contrato anterior
	 * @return the contrato comunal kit respuesta
	 */
	public ContratoComunalKitRespuesta generaContratoComunalDepositoGarantiaAnterior(String uid , String contratoAnterior) {
		ContratoComunalKitRespuesta respuesta = new ContratoComunalKitRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		ContratoVO contratoVO = null;
		DecimalFormat df = new DecimalFormat("0.00");

		final java.text.DecimalFormat decimalFormat = new DecimalFormat( "000000000" );

		try
		{
			if (contratoAnterior == null || contratoAnterior.isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}

			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoAnterior );
			if (numeroContrato == null || numeroContrato.isEmpty( ) ) {
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
			}
			//Contrato General
			OportunidadContratoOV oportunidadContraro = null;

			String nombres = "";
			Double aux = 0.0;

			LogHandler.trace(uid, getClass(), "==>comunalContrato - obtenerContratoDepositoGarantiaAnterior");
			oportunidadContraro = (OportunidadContratoOV)
					sesion.selectOne("obtenerContratoDepositoGarantiaAnterior", numeroContrato);

			if (oportunidadContraro == null) {
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
			}

			HashMap<String, Object> paramsQuery	= new HashMap<String, Object>();
			String dbEntorno = sesion.getConfiguration().getVariables().getProperty("db.entorno");
			LogHandler.info(uid, getClass(), "getUniversoPrimerPagoTarea: - dbEntorno: " + dbEntorno);
			paramsQuery.put("dbEntorno", dbEntorno);
			paramsQuery.put("contrato", numeroContrato);

		LogHandler.trace(uid, getClass(), "generaContratoComunalDepositoGarantiaAnterior: consulaDatosIntegrantesAnteriorKit");
			LogHandler.info(uid, getClass(), "generaContratoComunalDepositoGarantiaAnterior: consulaDatosIntegrantesAnteriorKit");
			@SuppressWarnings("unchecked")
			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantesAnteriorKit", paramsQuery);

			LogHandler.info(uid, getClass(), "==>comunalContrato - " + Double.parseDouble(oportunidadContraro.getImporte()));
			LogHandler.info(uid, getClass(), "==>comunalContrato - " + Double.parseDouble(oportunidadContraro.getTasa()) );


			oportunidadContraro.setImpteletras(getMontoLetras(oportunidadContraro.getImporte()));
			oportunidadContraro.setImporte(formatMontos(oportunidadContraro.getImporte()));

			LogHandler.trace(uid, getClass(), "==> comunalContrato - consulaDatosContrato");
			contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);
			oportunidadContraro.setPlazo(contratoVO.getPlazo());

			Map<String, Object>parametros = new HashMap<String, Object>();
			parametros.put("sucursal", Integer.parseInt(oportunidadContraro.getBranchcode()));
			parametros.put("codigo", CODIGO_IVA);
			parametros.put("fecha", new Date());
			LogHandler.trace(uid, getClass(), "==> comunalContrato - verValorHistorico");
			Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
			aux = (double) iva;
			Double tasa = Double.parseDouble(oportunidadContraro.getTasa());
			oportunidadContraro.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));

	 		oportunidadContraro.setFechavto( formatFecha14(oportunidadContraro.getFechavto( )));

	 		respuesta.setDatosGeneralesContrato(oportunidadContraro);

	 			//Cheques
	 			for ( MiembroGrupoVO miembroGrupoVO : miembros  ) {
	 				miembroGrupoVO.setNumcheque(decimalFormat.format(
	 						Double.parseDouble( miembroGrupoVO.getNumcheque() ) ).trim() );
				}

	 			//Integrates Anteriores Montos

				for (int i = 0; i < miembros.size(); i++) {

						miembros.get(i).setNummiembro(i + 1 + "");

						miembros.get(i).setImporteValeCreditoLetra(getMontoLetras(miembros.get(i).getImporteValeCredito()));
						miembros.get(i).setImporteValeCredito(formatMontos(miembros.get(i).getImporteValeCredito()));

						if (miembros.get(i).getImporteValeCredito().equals(".00")) {
							miembros.get(i).setImporteValeCredito("0.00");
							miembros.get(i).setImporteValeCreditoLetra("CERO PESOS 00/100 MN");
						}

						miembros.get(i).setCapitalcte( formatMontos(miembros.get(i).getCapitalcte()) );
						miembros.get(i).setImptecte( formatMontos(miembros.get(i).getImptecte()) );

						if (i + 1 != miembros.size()) {
							nombres = nombres + miembros.get(i).getCliente() + ", ";
						} else {
							nombres = nombres + miembros.get(i).getCliente();
							respuesta.getDatosGeneralesContrato().setNombres(nombres);
						}

					}

				respuesta.setIntegrantes(miembros);


				//Amortizaciones

				List<PagoGrupo> pagos = new ArrayList<PagoGrupo>();

				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> comunalContrato - obtenerAmortizacionGrupal ");
				List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", numeroContrato);
					for (int i = 0; i < result.size(); i++) {
						PagoGrupo pago = new PagoGrupo();
						pago.setFechapago(formatFecha15(result.get(i).getFechaPago()));
						pago.setImptepago( formatMontos(result.get(i).getMontoPago() + ""));
						pago.setInteres( formatMontos(result.get(i).getInteresPeriodo() + ""));
						pago.setNumpago( result.get(i).getNoPago() + "");
						pago.setCapital( formatMontos((result.get(i).getAbonoCapital() * 1000) / 1000 + ""));
						pago.setImptepagored( formatMontos(Math.rint((result.get(i).getMontoPago() * 1000) / 1000) + ""));
						pagos.add(pago);
					}

				respuesta.setAmortizacion(pagos);

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "generaContratoComunalDepositoGarantia(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;

	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ContratoPagareKitRespuesta generaPagareComunalDepositoGarantia(String uid , ContratoPeticionKit contratoPeticion) {

		ContratoPagareKitRespuesta respuesta = new ContratoPagareKitRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		try
		{

			if (contratoPeticion.getContrato() == null || contratoPeticion.getContrato().isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}

			contratoPeticion.setContrato(contratoPeticion.getContrato().toUpperCase());

			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoPeticion.getContrato() );

			if (numeroContrato == null) {
				throw new Exception("El contrato no existe.");
			}

			DecimalFormat df = new DecimalFormat("0.00");
			int count = 0;
			List<AvalGrupo> avales = new ArrayList<AvalGrupo>();

	 		LogHandler.trace( uid, getClass(), " ==> comunalPagareDepositoGarantia - consulaDatosIntegrantes");

			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", numeroContrato);

			//Objeto para los telefonos
			final java.util.HashMap<String, String>
										telefonos = new HashMap<String, String>();

			//Formateo del numero de cheque
			for ( MiembroGrupoVO miembroGrupoVO : miembros  )
				{

				//Calculamos los telefonos
				LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - obtenerTelefonoKitImpresion");
				final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
				final String telefono = objectTel != null ? "" + objectTel : "";
				telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());
				}


				LogHandler.debug(uid, getClass(), "comunalPagareDepositoGarantia ");
				//Se determina el tipo de contrato
				LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - dsObtenerTipoContrato");
				final HashMap<String, Object>
							tipoContrato = (HashMap<String, Object>) sesion.selectOne( "dsObtenerTipoContrato", numeroContrato );

				final String categoria = (String)tipoContrato.get("categoria");

				final java.lang.Integer miembrosOriginales = miembros.size();

				//Compensacion de avales solo para creditos comunales
				if (  miembros.size() <= INTEGRANTES_MINIMOS_AVAL && categoria.contains( "COM" )
						|| miembros.size() < INTEGRANTES_MINIMOS_AVAL && !categoria.contains( "COM" ) )
					{
					final HashMap<String,Object>
									params = new HashMap<String, Object>();
									params.put("contrato"	, numeroContrato);

					LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - obtenerDatosAvales");
					final List<MiembroGrupoVO> miembrosExtras = sesion.selectList("obtenerDatosAvales", params);

					if (miembrosExtras.size() == 0) {
					  //Renovacion Especial
						LogHandler.debug(uid, getClass(), "Avales Renovacion Especial");
						for (int i = 0; i < miembrosOriginales; i++)
						{
						count = i + 1;

						for (int j = 1; j < miembrosOriginales; j++) {
							count =+count;
							if ( count >= miembros.size() ) {
								count = 0;
								}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
										miembros.get(count).getEdocivil()));
							avales.add(aval);
							count ++;

						}
					}

					}

					//Formateo del numero de cheque
					for ( MiembroGrupoVO miembroGrupoVO : miembrosExtras  )
						{
						//Se determinan los telefonos
						LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - obtenerTelefonoKitImpresion");
						final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
						final String telefono = objectTel != null ? "" + objectTel : "";
						telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());

						//Se agrega los avalaes faltantes
						if ( miembros.size() <= INTEGRANTES_MINIMOS_AVAL ) {
							miembros.add( miembroGrupoVO );
							}
						else	{
							break;
							}
						}

					}

				if (miembros.size() >= INTEGRANTES_MINIMOS_AVAL ) {
					for (int i = 0; i < miembrosOriginales; i++)
						{
						count = i + 1;
						for (int j = 1; j < (categoria.contains( "COM" ) ? 5 : 3); j++) {
							count =+count;
							if ( count >= miembros.size() ) {
								count = 0;
								}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
										miembros.get(count).getEdocivil()));
							count ++;
							avales.add(aval);

						}
					}
				}

				respuesta.setAvales(avales);

				//Miembros pagare
				List<MiembroGrupoPagare> miembrosPagare = new ArrayList<MiembroGrupoPagare>();

				LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - consulaDatosIntegrantes ");
				List<MiembroGrupoVO> miembrosGrupo = sesion.selectList("consulaDatosIntegrantes", numeroContrato);


				LogHandler.debug(uid, getClass(), "Comunal pagare Datos de los MIEMBROS");
				HashMap params = new HashMap();
				HashMap datosPersona = new HashMap();
				String edoCivil = "";
				String titGrupo = "";
				params.put("contrato", numeroContrato);
				params.put("fechaActual", new Date());
				LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - consulaDatosContrato ");
				ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);
				LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - obtenerSaldoFv ");
				CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne(	"obtenerSaldoFv", params);
				LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - direccionSucursal ");
				String direccionSucursal = (String) sesion.selectOne("direccionSucursal", creditoCliente.getSucursal());

				/*Se le da el formato en la direccion de la sucursal para el estado*/
				final String [] datosDirecccion = direccionSucursal.split(",");
				final String estadoTit = textoTipoTitulo( datosDirecccion[ datosDirecccion.length - 1 ].trim().toLowerCase() );
				direccionSucursal = direccionSucursal.replace( datosDirecccion[ datosDirecccion.length - 1 ].trim(), estadoTit );
				//String entidad =textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase());
				//direccionSucursal = datamapper.DataMapper.mapClaveEntidad( direccionSucursal );
				for (int i = 0; i < miembrosGrupo.size(); i++)
					{
						LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - obtenerTelefonoKitImpresion");
						//Integer clienteId= Integer.parseInt(miembrosGrupo.get(i).getNumcheque());
						Integer clienteId = Integer.parseInt(miembrosGrupo.get(i).getCodigocte());
						MiembroGrupoPagare mp = new MiembroGrupoPagare();
						String persona = (String) miembros.get(i).getPersona();
						LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - datosPersona");
						datosPersona = (HashMap) sesion.selectOne("datosPersona", persona);
						String sexo = datosPersona.get("sexo") != null ? (String) datosPersona.get("sexo") : "";
						edoCivil = datosPersona.get("edoCivil") != null ? (String) datosPersona.get("edoCivil") : "";
						titGrupo = ObtenerTitAval(sexo, edoCivil);
						String montoLetra = miembros.get(i).getMontoOtorgado();
						mp.setCalle(miembrosGrupo.get(i).getCallecte());
						mp.setCiudad(miembrosGrupo.get(i).getCiudadcte());
						mp.setCliente(clienteId.toString());
						mp.setColonia(miembrosGrupo.get(i).getColoniacte());
						mp.setCp(miembrosGrupo.get(i).getCpcte());
						mp.setCtabanco(CUENTA_BANCO);
						mp.setDirsucursal(direccionSucursal);
						mp.setEmpresa(EMPRESA_FINSOL);
						mp.setEstado(miembrosGrupo.get(i).getEstadocte());
						mp.setFechainicio(formatFechaDireccion(direccionSucursal + "|" + contratoVO.getFechafirma()));
						mp.setImporte(formatMontos(miembros.get(i).getMontoOtorgado()));
						mp.setNombre(miembrosGrupo.get(i).getCliente());
						mp.setPagos(miembrosGrupo.get(i).getNoPagos());
						mp.setPeriodo(formatFrecuencia(creditoCliente.getFrecuenciaPago()));
						LogHandler.info(uid, getClass(), "====> Numero telefonico : "
											+ telefonos.get(miembros.get(i).getNummiembro()));
						mp.setTel( telefonos.get(miembros.get(i).getNummiembro()) );
						mp.setImpteletra(getMontoLetras(montoLetra));
						mp.setTitulo(titGrupo);
						//CALCULO DE LA TASA
						Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
						parametros.put( "sucursal", (Integer) (creditoCliente.getSucursal()));
						parametros.put( "fecha", new Date() );
						parametros.put( "codigo" , CODIGO_IVA );

						LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - obtenerTasaMoratoria");
						HashMap map = (HashMap) sesion.selectOne( "obtenerTasaMoratoria", numeroContrato );
						Double tasa = Double.parseDouble(creditoCliente.getTasa());
						LogHandler.trace(uid, getClass(), "==> comunalPagareDepositoGarantia - " + OPER_VER_VALOR_HISTORICO);
						Integer iva  =(Integer) sesion.selectOne(OPER_VER_VALOR_HISTORICO, parametros);
						Double aux = (double) iva;
						mp.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
						Double tasaMora = Double.parseDouble( (String) map.get("valor") );
						mp.setTasamora(df.format((tasaMora * (1 + (aux / 100))) * 12));
						miembrosPagare.add(mp);

					}

					respuesta.setMiembros(miembrosPagare);


					//Amortizaciones
					List<PagoGrupo> amortizaciones = new ArrayList<PagoGrupo>();

					LogHandler.trace("", getClass(), "==> comunalPagareDepositoGarantia - amortizacionPagares");
					List<AmortizacionOV> obj = sesion.selectList("amortizacionPagares", numeroContrato);
					LogHandler.debug(uid, getClass(), "Comunal pagare Datos de los PAGO AMORTIZACION");
					for (int i = 0; i < obj.size(); i++) {
						int cliente = Integer.parseInt(obj.get(i).getIntegrante().trim());
						String saldoCapital = Double.toString(obj.get(i).getSaldoCapital());
						PagoGrupo pago = new PagoGrupo();
						pago.setCliente(cliente + "");
						pago.setFechapago(formatFecha(obj.get(i).getFechaPago()));
						pago.setImptepago(Double.toString(obj.get(i).getMontoPago()));
						pago.setInteres(Double.toString(obj.get(i).getInteresPeriodo()));
						pago.setNumpago(obj.get(i).getNoPago().toString());
						pago.setCapital(Double.toString(obj.get(i).getAbonoCapital()));
						pago.setImptepagored(Math.rint((obj.get(i).getMontoPago() * 1000) / 1000) + "");
						pago.setSdo(saldoCapital);
						amortizaciones.add(pago);
					}

					respuesta.setAmortizaciones(amortizaciones);

				return respuesta;

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "generaPagareComunalDepositoGarantia(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;


	}

	public String formatMontos(String value) {
		NumberFormat formatter  = new DecimalFormat("#,###,###.00");
		String respuesta = formatter.format(Double.parseDouble(value));

				if (respuesta.equals(".00")) {
					respuesta = "0.00";
				}
				
				if (respuesta.startsWith(".")) {
					respuesta = "0" + respuesta;
				}
				
		return respuesta;
	}

	public String formatFrecuencia(String value) {
			return value.replace("S", "Semanal")
				      .replace("Q", "Quincenal")
				      .replace("M", "Mensual")
				      .replace("C", "Catorcenal");
	}

	public String formatFechaDireccion(String res) {
		if (res == null || res.isEmpty()) {
			res = "";
		}

		String mes = null;


		  String[] temp;
		  String delimiter = "\\|";
		  temp = res.split(delimiter);
		  String direccion = "";
		  String fecha = "";
		  for (int k = 0; k < temp.length; k++) {
		    direccion = temp[0];
		    fecha = temp[1];
		  }


		String formDate13 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(fecha));
		mes = textoTipoTitulo(formDate13.split("[.]")[2]).toUpperCase();
		res = "A LOS " + (formDate13.split("[.]")[1] )
				+ ( Integer.parseInt( formDate13.split("[.]")[1]  ) == 1 ? " DIA" : " DIAS" )
				+ " DEL MES DE " + mes + " DE " + formDate13.split("[.]")[3];
		LogHandler.debug("", getClass(), "Respuesta" + res);
		res = direccion + "," + res;
		return res;
	}

	public SimpleDateFormat obtenerFormatoLocal(String formato) {
		return  new SimpleDateFormat(formato,new Locale("es","ES"));
	}

	public Date parsearFecha(String fecha) {
		try {
			SimpleDateFormat format2 = null;
			if (fecha.length() > 10) {
				format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			} else {
				format2 = new SimpleDateFormat("yyyy-MM-dd");
			}

			Date date2;
			date2 = (Date) format2.parse(fecha);
			return date2;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}

	}

	public String formatFecha(String res) {
		String mes = null;
		String dia = null;
		String formDate2 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
		dia = textoTipoTitulo(formDate2.split("[.]")[0]);
		mes = textoTipoTitulo(formDate2.split("[.]")[2]);
		res = dia + ", " + formDate2.split("[.]")[1] + " de " + mes + " de " + formDate2.split("[.]")[3];
		res.toUpperCase();
		return res;
	}

	public String formatFecha14(String res) {
		if (res == null || res.isEmpty()) {
			res = "";
		}
		String mes = null;
		String dia = null;
		String formDate14 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
		dia = textoTipoTitulo(formDate14.split("[.]")[0]);
		mes = textoTipoTitulo(formDate14.split("[.]")[2]);
		res = dia + ", " + mes + " " + formDate14.split("[.]")[1] + ", " + formDate14.split("[.]")[3];
		return res;
	}

	public String formatFecha8(String res) {
		String formDate8 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
		res = (formDate8.split("[.]")[1] ) + ( Integer.parseInt( formDate8.split("[.]")[1]  )  == 1 ? " DIA" : " DIAS" )
				+ " DEL MES DE " + formDate8.toUpperCase().split("[.]")[2] + " DE " + formDate8.split("[.]")[3];
		return res.toUpperCase();
	}

	public String formatFechaNormal(String res) {
		String formDate7 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
		res = (formDate7.split("[.]")[1] ) + " DE " + formDate7.toUpperCase().split("[.]")[2]
				+ " DEL " + formDate7.split("[.]")[3];
		return res.toUpperCase();
	}

	public String formatFecha3(String res) {
	 return obtenerFormatoLocal("dd/MM/yyyy").format(parsearFecha(res));
	}

	public String formatFecha15(String res) {
		String mes = null;
		String dia = null;

		if (res == null || res.isEmpty()) {
			res = "";
		}
			String formDate15 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
			dia = textoTipoTitulo(formDate15.split("[.]")[0]);
			mes = textoTipoTitulo(formDate15.split("[.]")[2]);
			res = dia + ", " + mes + " " + formDate15.split("[.]")[1] + ", " + formDate15.split("[.]")[3];
			return res;
	}


	/* Metodo para generar Convenio Reestructura (prueba documentacion)
	 * @author Roberto Guadarrama
	 * @version 1.0
	 * @see tarea.impresiondocs.ImpresionDocsInformacion#generaConvenioReestructura
	 * (java.lang.String, utilitario.mensajes.impresiondocs.comun.ContratoPeticionKit)
	 */
	@SuppressWarnings("unchecked")
	public ConvenioReestructuraKitRespuesta generaConvenioReestructura(String uid, ContratoPeticionKit contratoPeticion) {
		ConvenioReestructuraKitRespuesta respuesta = new ConvenioReestructuraKitRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);
		DecimalFormat df = new DecimalFormat("0.00");
		SqlSession sesion = null;
		SqlSession sesionTx = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {
			if (contratoPeticion.getContrato() == null || contratoPeticion.getContrato().isEmpty())
				throw new Exception(CONTRATO_INVALIDO);


			sesion = FabricaConexiones.obtenerSesionNTx();


			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoPeticion.getContrato() );
			if (numeroContrato == null || numeroContrato.isEmpty( ) )
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );

			//Hacer validacion GRES
			ContratoRestructuraVO contratoNuevo = null;
			LogHandler.trace(uid, getClass(), "==> convenioReestructura - obtenerDatosCreditoNuevoRes");
			contratoNuevo = (ContratoRestructuraVO) sesion.selectOne("obtenerDatosCreditoNuevoRes", numeroContrato);
			if (contratoNuevo == null)
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );

			//para el Cat
			LogHandler.trace(uid, getClass(), "==> convenioReestructura - obtenerCAT" );
			final java.util.HashMap<String, Object> condicionesValor =
					(HashMap<String, Object>) sesion.selectOne( "obtenerCAT", numeroContrato);
			final java.lang.String CAT = condicionesValor != null && condicionesValor.get( "valor" ) != null
					? condicionesValor.get( "valor" ).toString() : "0";
			contratoNuevo.setCat(CAT);
			//CALCULO DE LA TASA
			Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
			parametros.put( "sucursal", (Integer) (contratoNuevo.getSucursal()));
			parametros.put( "fecha", new Date() );
			parametros.put( "codigo" , CODIGO_IVA );
			Double tasa = Double.parseDouble(contratoNuevo.getTasa());
			LogHandler.trace(uid, getClass(), "==> convenioReestructura - " + OPER_VER_VALOR_HISTORICO);
			Integer iva  = (Integer) sesion.selectOne(OPER_VER_VALOR_HISTORICO, parametros);
			Double aux = (double) iva;
			contratoNuevo.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
			contratoNuevo.setNomSucursal(contratoNuevo.getNomSucursal().trim());

			respuesta.setContratoNuevo(contratoNuevo);
			LogHandler.info(uid, getClass(), "******" + contratoNuevo.getFechaDesembolso());
			LogHandler.info(uid, getClass(), "******" + dateFormat.format(contratoNuevo.getFechaDesembolso()));

			contratoNuevo.setFechaDesembolsoFormato( formatFechaNormal( dateFormat.format(contratoNuevo.getFechaDesembolso())));

			if(!contratoNuevo.getProducto().trim().equals("GRES"))
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );

			LogHandler.info(uid, getClass(), "******" + contratoNuevo.getContratoVigente());

			ContratoVigenteVO contratoVigente = null;

			LogHandler.trace(uid, getClass(), "==> convenioReestructura - obtenerDatosCreditoVigenteRes");
			contratoVigente = (ContratoVigenteVO)
					sesion.selectOne("obtenerDatosCreditoVigenteRes", contratoNuevo.getContratoVigente());

			contratoVigente.setMontoLetra(getMontoLetras(contratoVigente.getMonto().toString()));
			contratoVigente.setAdeudoLetra(getMontoLetras(contratoVigente.getAdeudo().toString()));
			LogHandler.info(uid, getClass(), "******" + contratoVigente.getFechaDesembolso());

			contratoVigente.setFechaDesembolsoFormato(formatFechaNormal(
					dateFormat.format(contratoVigente.getFechaDesembolso())) );
			respuesta.setContratoAnterior(contratoVigente);

			//Miembros Nuevo
			LogHandler.trace(uid, getClass(), "==>convenioReestructura - consulaDatosIntegrantes");
			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", numeroContrato);

			String nombres = "";
			for (int i = 0; i < miembros.size(); i++) {

					if ( i + 1 != miembros.size()) {
						nombres = nombres + miembros.get(i).getCliente() + ", ";
					} else {
						nombres = nombres + miembros.get(i).getCliente();
					}

			}

			contratoNuevo.setNombres(nombres);
			contratoNuevo.setMontoLetra(getMontoLetras(contratoNuevo.getMonto().toString()));

			List<String> personas = new ArrayList<String>();
			for (int i = 0; i < miembros.size(); i++) {
				miembros.get(i).setMontoLetra(getMontoLetras(df.format(
						Double.parseDouble(miembros.get(i).getMontoOtorgado().toString()))));
				miembros.get(i).setNummiembro(i + 1 + "");
				miembros.get(i).setCapitalcte( formatMontos(miembros.get(i).getCapitalcte()) );
				personas.addAll(Arrays.asList(miembros.get(i).getPersona().trim()));

			}
			respuesta.setIntegrantes(miembros);

			//Integrantes Anterior

			final HashMap<String, Object> parametros1 = new HashMap<String, Object>();
			parametros1.put("contrato", contratoNuevo.getContratoVigente());
			parametros1.put("numerosPersona", personas);

			LogHandler.trace(uid, getClass(), "==>convenioReestructura - consulaDatosIntegrantesAnterior");
			List<MiembroGrupoVigenteVO> miembrosAnterior = sesion.selectList("consulaDatosIntegrantesAnterior", parametros1);

			for (int i = 0; i < miembrosAnterior.size(); i++) {
				miembrosAnterior.get(i).setMontoOtorgado(
						Double.valueOf( df.format(miembrosAnterior.get(i).getMontoOtorgado().doubleValue()) ));
				miembrosAnterior.get(i).setMontoLetra(getMontoLetras(miembrosAnterior.get(i).getMontoOtorgado().toString()));
				miembrosAnterior.get(i).setNumMiembro(i + 1 + "");


			}
			respuesta.setIntegrantesAnterior(miembrosAnterior);

			//Amortizaciones

				List<PagoGrupo> pagos = new ArrayList<PagoGrupo>();

				sesion = FabricaConexiones.obtenerSesionNTx();
				LogHandler.trace(uid, getClass(), "==> convenioReestructura - obtenerAmortizacionGrupal ");
				List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", numeroContrato);
					for (int i = 0; i < result.size(); i++) {
						PagoGrupo pago = new PagoGrupo();
						pago.setFechapago(formatFecha15(result.get(i).getFechaPago()));
						pago.setImptepago( formatMontos(result.get(i).getMontoPago() + ""));
						pago.setInteres( formatMontos(result.get(i).getInteresPeriodo() + ""));
						pago.setNumpago( result.get(i).getNoPago() + "");
						pago.setCapital( formatMontos((result.get(i).getAbonoCapital() * 1000) / 1000 + ""));
						pago.setImptepagored( formatMontos(Math.rint((result.get(i).getMontoPago() * 1000) / 1000) + ""));
						pagos.add(pago);
					}

				respuesta.setAmortizaciones(pagos);

			//Vales

				try {
				List<ValesVO> vales = new ArrayList<ValesVO>();
				sesion = FabricaConexiones.obtenerSesionNTx();

				LogHandler.trace(uid, getClass(), "==> convenioReestructura - obtenerVales ");
				List<ValesVO> vale = sesion.selectList("obtenerVales", numeroContrato);


				for (int i = 0; i < vale.size(); i++) {
					ValesVO miVale = new ValesVO();
					miVale.setNombre(miembros.get(i).getCliente());
					miVale.setLDnuevo(contratoNuevo.getContratoLD());
					miVale.setLDvigente(contratoVigente.getContratoLD());
					miVale.setContrato(vale.get(i).getContrato());
					miVale.setIntegrante(vale.get(i).getIntegrante());
					miVale.setFolio("CV" + ValidaCodigo(10, vale.get(i).getFolio()));
					miVale.setMonto(vale.get(i).getMonto());
					miVale.setMontoLetra(getMontoLetras(vale.get(i).getMonto().toString()));
					miVale.setStatus(vale.get(i).getStatus());
					miVale.setFecha(formatFecha15(	vale.get(i).getFecha()	));
					miVale.setDirSucursal(contratoNuevo.getDirSucursal());
					miVale.setNomSucursal(contratoNuevo.getNomSucursal());
					miVale.setNomGerente(contratoNuevo.getNomGerente());
					vales.add(miVale);
				}


				sesionTx = FabricaConexiones.obtenerSesionTx();
				if (vale.size() == 0) {

					final java.util.HashMap<String, Object>
					parametrosInsertaVales = new HashMap<String, Object>();

					for (int i = 0; i < miembros.size(); i++) {
						parametrosInsertaVales.put( "contrato", numeroContrato );
						parametrosInsertaVales.put( "integrante", miembros.get(i).getPersona());
						parametrosInsertaVales.put( "monto", Double.valueOf(miembros.get(i).getMontoOtorgado()).doubleValue());

						LogHandler.trace(uid, getClass(), "==> contratoReestructura - insertaVales "
									+ miembros.get(i).getCliente());
						sesionTx.insert( "insertaVales", parametrosInsertaVales );

					}


					LogHandler.trace(uid, getClass(), "==> convenioReestructura - obtenerValesInsertados ");
					List<ValesVO> vale2 = sesion.selectList("obtenerVales", numeroContrato);


					for (int i = 0; i < vale2.size(); i++) {
						ValesVO miVale = new ValesVO();
						miVale.setNombre(miembros.get(i).getCliente());
						miVale.setLDnuevo(contratoNuevo.getContratoLD());
						miVale.setLDvigente(contratoVigente.getContratoLD());
						miVale.setContrato(vale2.get(i).getContrato());
						miVale.setIntegrante(vale2.get(i).getIntegrante());
						miVale.setFolio("CV" + ValidaCodigo(10, vale2.get(i).getFolio()));
						miVale.setMonto(vale2.get(i).getMonto());
						miVale.setMontoLetra(getMontoLetras(vale2.get(i).getMonto().toString()));
						miVale.setStatus(vale2.get(i).getStatus());
						miVale.setFecha(formatFecha15(	vale2.get(i).getFecha()	));
						miVale.setDirSucursal(contratoNuevo.getDirSucursal());
						miVale.setNomSucursal(contratoNuevo.getNomSucursal());
						miVale.setNomGerente(contratoNuevo.getNomGerente());
						vales.add(miVale);
					}

					respuesta.setVales(vales);
					sesionTx.commit(true);
				} else {
					respuesta.setVales(vales);
				}


				} catch (Exception e) {

					FabricaConexiones.rollBack(sesionTx);

					LogHandler.error(uid, getClass(), "==> Error al tratar contratoReestructura"
							+ "- insertaVales " + e.getMessage(), e);

				} finally {
					FabricaConexiones.close(sesionTx);
				}


			} catch (Exception e) {
				LogHandler.error(uid, getClass(), "Error al generar el convenio : " + e.getMessage(), e);
				respuesta.getHeader().setEstatus(false);
				respuesta.getHeader().setMensaje( e.getMessage() );
			} finally {
				FabricaConexiones.close( sesion );

			}
		return respuesta;
	}


	public String ValidaCodigo(int index, String mifolio) {
		String folio = mifolio;
		int j = index - folio.length();
		for (int i = 0; i < j; i++) {
			folio = "0" + folio;
		}

		return folio;
	}


//	public ImpresionDocsInformacionImpl(){}

	public static void main(String ... args) {

//		Correccion bug decimales
//
//		final java.text.DecimalFormat df = new DecimalFormat("00.00");
//		final java.text.DecimalFormat decimalFormatA = new DecimalFormat("00000000.00");
//		String importe = "3524";
//		importe = decimalFormatA.format( Double.parseDouble(importe));
//		final Numero2Letra NumLetra = new Numero2Letra();
//		+ "PESOS "
//		+ decimalFormat.format( Double.parseDouble( (importe.split("[.]")[1]) ) )
//		+ "/100 MN");
//		String metodo = new ImpresionDocsInformacionImpl().ValidaCodigo(10, "12");
//		ImpresionDocsInformacionImpl metodo = new ImpresionDocsInformacionImpl();
//		String monto = metodo.validaMonto("2,100.00");

		Date now = new Date();
		DateFormat df = DateFormat.getDateInstance();
		String s = df.format(now);

	}

	public String validaMonto(String monto) {
		String montoValido = null;
		if (monto.contains(",")) {
			montoValido = monto.replace(",", "");
		} else {
			montoValido = monto;
		}

		return montoValido;
	}


	@SuppressWarnings({ "unchecked", "rawtypes" })
	public PagareReestructuraKitRespuesta generaPagareReestructura(String uid, ContratoPeticionKit contratoPeticion) {
		PagareReestructuraKitRespuesta respuesta = new PagareReestructuraKitRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		try
		{

			if (contratoPeticion.getContrato() == null || contratoPeticion.getContrato().isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}

			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoPeticion.getContrato() );


			DecimalFormat df = new DecimalFormat("0.00");
			int count =0;
			List<AvalGrupo> avales = new ArrayList<AvalGrupo>();

	 		LogHandler.trace( uid, getClass(), " ==> PagareReestructura - consulaDatosIntegrantes");
			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", numeroContrato);

			//Objeto para los telefonos
			final java.util.HashMap<String, String>
										telefonos = new HashMap<String, String>();

			//Formateo del numero de cheque
			for ( MiembroGrupoVO miembroGrupoVO : miembros  ) {

				//Calculamos los telefonos
				LogHandler.trace(uid, getClass(), "==> PagareReestructura - obtenerTelefonoKitImpresion");
				final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
				final String telefono = objectTel != null ? "" + objectTel : "";
				telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());
				}


				LogHandler.debug(uid, getClass(), "PagareReestructura ");
				//Se determina el tipo de contrato
				LogHandler.trace(uid, getClass(), "==> PagareReestructura - dsObtenerTipoContrato");
				final HashMap<String, Object>
							tipoContrato = (HashMap<String, Object>) sesion.selectOne( "dsObtenerTipoContrato", numeroContrato );

				final String categoria = (String) tipoContrato.get("categoria");

				final java.lang.Integer miembrosOriginales = miembros.size();

				//Compensacion de avales solo para creditos comunales
				if (  miembros.size() <= INTEGRANTES_MINIMOS_REESTRUCTURA && categoria.contains( "COM" )
					|| miembros.size() < INTEGRANTES_MINIMOS_REESTRUCTURA && !categoria.contains( "COM" ) ) {
					final HashMap<String, Object>
									params = new HashMap<String, Object>();
									params.put("contrato"	, numeroContrato);

					LogHandler.trace(uid, getClass(), "==> PagareReestructura - obtenerDatosAvales");
					final List<MiembroGrupoVO> miembrosExtras = sesion.selectList("obtenerDatosAvales", params);

					if (miembrosExtras.size() == 0) {
					  //Renovacion Especial
						LogHandler.debug(uid, getClass(), "PagareReestructura -- Avales Renovacion Especial");
						for (int i = 0; i < miembrosOriginales; i++) {
						count = i + 1;

						for (int j = 1; j < miembrosOriginales; j++) {
							count =+ count;
							if ( count >= miembros.size() ) {	count = 0;	}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
									miembros.get(count).getEdocivil()));
							avales.add(aval);
							count++;
						}
					}
					}

					//Formateo del numero de cheque
					for ( MiembroGrupoVO miembroGrupoVO : miembrosExtras  ) {
						//Se determinan los telefonos
						LogHandler.trace(uid, getClass(), "==> PagareReestructura - obtenerTelefonoKitImpresion");
						final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
						final String telefono = objectTel != null ? "" + objectTel : "";
						telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());

						//Se agrega los avalaes faltantes
						if ( miembros.size() <= INTEGRANTES_MINIMOS_REESTRUCTURA ) { miembros.add( miembroGrupoVO ); }
						else	{ break; }
						}

					} //no falta lanzar un msj???????????

				if (miembros.size() >= INTEGRANTES_MINIMOS_REESTRUCTURA ) {
					for (int i = 0; i < miembrosOriginales; i++) {
						count = i + 1;
						for (int j = 1; j < (categoria.contains( "COM" ) ? 5 : 3); j++) {
							count =+ count;
							if ( count >= miembros.size() ) {
								count = 0;
							}
							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
									miembros.get(count).getEdocivil()));
							count++;
							avales.add(aval);
						}
					}
				}

				respuesta.setAvales(avales);

				//Miembros pagare
				List<MiembroGrupoPagare> miembrosPagare = new ArrayList<MiembroGrupoPagare>();
				LogHandler.trace(uid, getClass(), "==> PagareReestructura - consulaDatosIntegrantes ");
				List<MiembroGrupoVO> miembrosGrupo = sesion.selectList("consulaDatosIntegrantes", numeroContrato);
				LogHandler.debug(uid, getClass(), "PagareReestructura Datos de los MIEMBROS");
				HashMap params = new HashMap();
				HashMap datosPersona = new HashMap();
				String edoCivil = "";
				String titGrupo = "";
				params.put("contrato", numeroContrato);
				params.put("fechaActual", new Date());
				LogHandler.trace(uid, getClass(), "==> PagareReestructura - consulaDatosContrato ");
				ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);
				LogHandler.trace(uid, getClass(), "==> PagareReestructura - obtenerSaldoFv ");
				CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne(	"obtenerSaldoFv", params);
				LogHandler.trace(uid, getClass(), "==> PagareReestructura - direccionSucursal ");
				String direccionSucursal = (String) sesion.selectOne("direccionSucursal", creditoCliente.getSucursal());

				/*Se le da el formato en la direccion de la sucursal para el estado*/
				final String [] datosDirecccion = direccionSucursal.split(",");
				final String estadoTit = textoTipoTitulo( datosDirecccion[ datosDirecccion.length - 1 ].trim().toLowerCase() );
				direccionSucursal = direccionSucursal.replace( datosDirecccion[ datosDirecccion.length - 1 ].trim(), estadoTit );
				//String entidad =textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase());
				//direccionSucursal = datamapper.DataMapper.mapClaveEntidad( direccionSucursal );
				for (int i = 0; i < miembrosGrupo.size(); i++) {
						LogHandler.trace(uid, getClass(), "==> PagareReestructura - obtenerTelefonoKitImpresion");
						//Integer clienteId= Integer.parseInt(miembrosGrupo.get(i).getNumcheque());
						Integer clienteId = Integer.parseInt(miembrosGrupo.get(i).getCodigocte());
						MiembroGrupoPagare mp = new MiembroGrupoPagare();
						String persona = (String) miembros.get(i).getPersona();
						LogHandler.trace(uid, getClass(), "==> PagareReestructura - datosPersona");
						datosPersona = (HashMap) sesion.selectOne("datosPersona", persona);
						String sexo = datosPersona.get("sexo") != null ? (String) datosPersona.get("sexo") : "";
						edoCivil = datosPersona.get("edoCivil") != null ? (String) datosPersona.get("edoCivil") : "";
						titGrupo = ObtenerTitAval(sexo, edoCivil);
						String montoLetra = miembros.get(i).getMontoOtorgado();
						mp.setCalle(miembrosGrupo.get(i).getCallecte());
						mp.setCiudad(miembrosGrupo.get(i).getCiudadcte());
						mp.setCliente(clienteId.toString());
						mp.setColonia(miembrosGrupo.get(i).getColoniacte());
						mp.setCp(miembrosGrupo.get(i).getCpcte());
						mp.setCtabanco(CUENTA_BANCO);
						mp.setDirsucursal(direccionSucursal);
						mp.setEmpresa(EMPRESA_FINSOL);
						mp.setEstado(miembrosGrupo.get(i).getEstadocte());
						mp.setFechainicio(formatFechaDireccion(direccionSucursal + "|" + contratoVO.getFechafirma()));
						mp.setImporte(formatMontos(miembros.get(i).getMontoOtorgado()));
						mp.setNombre(miembrosGrupo.get(i).getCliente());
						mp.setPagos(miembrosGrupo.get(i).getNoPagos());
						mp.setPeriodo(formatFrecuencia(creditoCliente.getFrecuenciaPago()));
						LogHandler.info(uid, getClass(), "====> Numero telefonico : "
						+ telefonos.get(miembros.get(i).getNummiembro()));
						mp.setTel( telefonos.get(miembros.get(i).getNummiembro()) );
						mp.setImpteletra(getMontoLetras(montoLetra));
						mp.setTitulo(titGrupo);
						//CALCULO DE LA TASA
						Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
						parametros.put( "sucursal", (Integer) (creditoCliente.getSucursal()));
						parametros.put( "fecha", new Date() );
						parametros.put( "codigo" , CODIGO_IVA );

						LogHandler.trace(uid, getClass(), "==> PagareReestructura - obtenerTasaMoratoria");
						HashMap map = (HashMap) sesion.selectOne( "obtenerTasaMoratoria", numeroContrato );
						Double tasa = Double.parseDouble(creditoCliente.getTasa());
						LogHandler.trace(uid, getClass(), "==> PagareReestructura - " + OPER_VER_VALOR_HISTORICO);
						Integer iva  = (Integer) sesion.selectOne(OPER_VER_VALOR_HISTORICO, parametros);
						Double aux = (double) iva;
						mp.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
						Double tasaMora = Double.parseDouble( (String) map.get("valor") );
						mp.setTasamora(df.format((tasaMora * (1 + (aux / 100))) * 12));
						miembrosPagare.add(mp);

					}

					respuesta.setMiembros(miembrosPagare);

					//Amortizaciones
					List<PagoGrupo> amortizaciones = new ArrayList<PagoGrupo>();

					LogHandler.trace("", getClass(), "==> PagareReestructura - amortizacionPagares");
					List<AmortizacionOV> obj = sesion.selectList("amortizacionPagares", numeroContrato);
					LogHandler.debug(uid, getClass(), "PagareReestructura Datos de los PAGO AMORTIZACION");
					for (int i = 0; i < obj.size(); i++) {
						int cliente = Integer.parseInt(obj.get(i).getIntegrante().trim());
						String saldoCapital = Double.toString(obj.get(i).getSaldoCapital());
						PagoGrupo pago = new PagoGrupo();
						pago.setCliente(cliente + "");
						pago.setFechapago(formatFecha(obj.get(i).getFechaPago()));
						pago.setImptepago(Double.toString(obj.get(i).getMontoPago()));
						pago.setInteres(Double.toString(obj.get(i).getInteresPeriodo()));
						pago.setNumpago(obj.get(i).getNoPago().toString());
						pago.setCapital(Double.toString(obj.get(i).getAbonoCapital()));
						pago.setImptepagored(Math.rint((obj.get(i).getMontoPago() * 1000) / 1000) + "");
						pago.setSdo(saldoCapital);
						amortizaciones.add(pago);
					}

					respuesta.setAmortizaciones(amortizaciones);

				return respuesta;

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "generaPagareReestructura(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}
		return respuesta;
	}


	public FichaPagoEspecialRespuesta fichaPagoEspecial(String credito,	String uid) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * genera Ficha Pago Tarea.
	 *
	 * @param uid the uid
	 * @param peticion tipo FichaPagoPeticion
	 * @return the ficha pago respuesta
	 */
	public FichaPagoRespuesta generaFichaPagoTarea(String uid, FichaPagoPeticion peticion) {
		FichaPagoRespuesta respuesta = new FichaPagoRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setEstatus(true);
		respuesta.getHeader().setUID(uid);
		SqlSession sesion = null;
		DecimalFormat df = new DecimalFormat("0.00");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			sesion = FabricaConexiones.obtenerSesionNTx();

			String numeroContrato = comun.obtenerNumeroContrato( uid, peticion.getContrato() );
			//OXXO
			String contratoLD = comun.obtenerNumeroContratoLD(uid, peticion.getContrato());

			if (numeroContrato == null || numeroContrato.isEmpty( ) ) {
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
			}

			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("contrato", numeroContrato);
			params.put("fechaActual", new Date());

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerSaldoFv");
			CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne(	"obtenerSaldoFv", params);

			if (creditoCliente == null ) {
				throw new Exception("No se pudo obtener saldos del contrato.");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - consulaDatosContrato");
			ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);

			Map<String, Object>parametros = new HashMap<String, Object>();
			parametros.put("sucursal", Integer.parseInt(contratoVO.getBranchcode()));
			parametros.put("codigo", CODIGO_IVA);
			parametros.put("fecha", new Date());
			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - verValorHistorico");
			Integer iva = (Integer) sesion.selectOne("verValorHistorico", parametros);
			Double aux = (double) iva;
			Double tasa = Double.parseDouble(contratoVO.getTasa());
			contratoVO.setTasa(df.format((tasa * (1 + (aux / CIEN))) * DOCE));

			//Amortizaciones

			List<PagoGrupo> pagos = new ArrayList<PagoGrupo>();

			sesion = FabricaConexiones.obtenerSesionNTx();
			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerAmortizacionGrupal ");
			@SuppressWarnings("unchecked")
			List<AmortizacionOV> result = sesion.selectList("obtenerAmortizacionGrupal", numeroContrato);

			if (result == null) {
				throw new Exception("Ocurrio un error al obtener la Amortizacion grupal");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerTasaMoratoria");
			HashMap<String, Object> map = (HashMap<String, Object>) sesion.selectOne( "obtenerTasaMoratoria", numeroContrato );
				for (int i = 0; i < result.size(); i++) {
					PagoGrupo pago = new PagoGrupo();

					Double capitalPago = result.get(i).getAbonoCapital();
					Double tasaMora = Double.parseDouble((String) map.get("valor"));
					Double intMora = (((capitalPago * (tasaMora / CIEN)) / TREINTA)) * (1 + (aux / CIEN));

					LogHandler.debug(uid, getClass(), "INTERES MORA !!!!!!!!" + intMora);

					Date miFecha = sdf2.parse(result.get(i).getFechaPago());

					pago.setFechapago(sdf4.format(miFecha));
					pago.setImptepago("$ " + formatMontos(result.get(i).getMontoPago().toString()));
					pago.setImptepagored(result.get(i).getMontoPagoRed().toString());
					pago.setIntemoratorio(df.format(intMora));
					pago.setNumpago(result.get(i).getNoPago().toString());
					pagos.add(pago);
				}

			respuesta.setAmortizacion(pagos);

			//ReferenciasBancarias
			ConsultaReferenciasPagoPeticion peticionRef = new ConsultaReferenciasPagoPeticion();
			//Indispensable el contratoLD si menten contrato y se puede generar las referencias bancarias
			peticionRef.setContrato(contratoLD);
			peticionRef.setMontoPago(String.valueOf(creditoCliente.getMontoPago()));
			peticionRef.setProducto("CRED");
//OXXO			peticionRef.setNumContrato(numeroContrato);

			ConsultaReferenciasPagoRespuesta referencias = consultas.consultaReferenciasPago(peticionRef, uid);

			if (!referencias.getHeader().isEstatus()) {
				throw new Exception("Ocurrio un error al obtener las referencias bancarias:"
						+ referencias.getHeader().getMensaje()
						+ "  UID: " + referencias.getHeader().getUID());
			}

			respuesta.setReferencias(referencias);
			respuesta.setDatosContrato(contratoVO);
			if (pagos.get(0).getIntemoratorio() != null) {
				respuesta.setInteresMoratorioDia(pagos.get(0).getIntemoratorio());
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerParGeneral");
			ParGeneralOV parClave = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "CVE_FICHAPAGO");

			if (parClave == null) {
				throw new Exception("No se pudo obtener el valor de CVE_FICHAPAGO");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerParGeneral");
			ParGeneralOV parRev = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "REV_FICHAPAGO" );

			if (parRev == null) {
				throw new Exception("No se pudo obtener el valor de REV_FICHAPAGO");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerParGeneral");
			ParGeneralOV parClave2 = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "CVE_FICHAPAGO2");

			if (parClave2 == null) {
				throw new Exception("No se pudo obtener el valor de CVE_FICHAPAGO2");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerParGeneral");
			ParGeneralOV parRev2 = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "REV_FICHAPAGO2" );

			if (parRev2 == null) {
				throw new Exception("No se pudo obtener el valor de REV_FICHAPAGO2");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerParGeneral");
			ParGeneralOV parFichaDiestel1 = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "REV_FICHAPAGODIESTEL1");

			if (parFichaDiestel1 == null) {
				throw new Exception("No se pudo obtener el valor de REV_FICHAPAGODIESTEL1");
			}

			LogHandler.trace(uid, getClass(), "==> generaFichaPagoTarea - obtenerParGeneral");
			ParGeneralOV parFichaDiestel2 = (ParGeneralOV) sesion.selectOne( "obtenerParGeneral", "REV_FICHAPAGODIESTEL2" );

			if (parFichaDiestel2 == null) {
				throw new Exception("No se pudo obtener el valor de REV_FICHAPAGODIESTEL2");
			}

			respuesta.setClaveFicha(parClave.getCgValor());
			respuesta.setRevisionFicha(parRev.getCgValor());
			respuesta.setClaveFicha2(parClave2.getCgValor());
			respuesta.setRevisionFicha2(parRev2.getCgValor());

			respuesta.setRevisionFichaDiestel1(parFichaDiestel1.getCgValor());
			respuesta.setRevisionFichaDiestel2(parFichaDiestel2.getCgValor());

		} catch (Exception e) {
			LogHandler.error(uid, getClass(), "Error en generaFichaPagoTarea: " + e.getMessage(), e);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje("Error en generaFichaPagoTarea: " + e.getMessage());

		} finally {
			FabricaConexiones.close( sesion );
		}
		return respuesta;
	}

	/**
	 *
	 */
	public KitImpresionPagareRespuesta generarKitImpresionPagareTarea(
			String uid, ContratoPeticionKit contratoPeticion) {
		KitImpresionPagareRespuesta respuesta = new KitImpresionPagareRespuesta();
		List<MiembroGrupoVO> miembrosGrupo = null;
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;

		try
		{

			if (contratoPeticion.getContrato() == null || contratoPeticion.getContrato().isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}

			contratoPeticion.setContrato(contratoPeticion.getContrato().toUpperCase());

			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato( uid , contratoPeticion.getContrato() );

			if (numeroContrato == null) {
				throw new Exception("El contrato no existe.");
			}

			LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - consulaDatosContrato");
			ContratoVO datosContrato = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);

//			respuesta.setDatosContrato(datosContrato);

			DecimalFormat df = new DecimalFormat("0.00");
			int count = 0;
			List<AvalGrupo> avales = new ArrayList<AvalGrupo>();

	 		LogHandler.trace( uid, getClass(), " ==> generarKitImpresionPagareTarea - consulaDatosIntegrantes");

			List<MiembroGrupoVO> miembros = sesion.selectList("consulaDatosIntegrantes", numeroContrato);
			miembrosGrupo =  new ArrayList<MiembroGrupoVO>();
			//Se ocupara esta consulta para sacar los miembros
			miembrosGrupo.addAll(miembros);

			if (miembros == null || miembros.size() <= 0) {
				throw new Exception("El contrato no tiene miembros.");
			}
			
			//Objeto para los telefonos
			final java.util.HashMap<String, String>
										telefonos = new HashMap<String, String>();

			//Formateo del numero de cheque
			for ( MiembroGrupoVO miembroGrupoVO : miembros  )
				{

				//Calculamos los telefonos
				LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - obtenerTelefonoKitImpresion");
				final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
				final String telefono = objectTel != null ? "" + objectTel : "";
				telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());
				}


				LogHandler.debug(uid, getClass(), "generarKitImpresionPagareTarea ");
				//Se determina el tipo de contrato
				LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - dsObtenerTipoContrato");
				final HashMap<String, Object>
							tipoContrato = (HashMap<String, Object>) sesion.selectOne( "dsObtenerTipoContrato", numeroContrato );

				final String categoria = (String) tipoContrato.get("categoria");

				final java.lang.Integer miembrosOriginales = miembros.size();

				//Compensacion de avales solo para creditos comunales
				if (  miembros.size() <= INTEGRANTES_MINIMOS_AVAL && categoria.contains( "COM" )
						|| miembros.size() < INTEGRANTES_MINIMOS_AVAL && !categoria.contains( "COM" ) )
					{
					final HashMap<String, Object>
									params = new HashMap<String, Object>();
									params.put("contrato"	, numeroContrato);

					LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - obtenerDatosAvales");
					final List<MiembroGrupoVO> miembrosExtras = sesion.selectList("obtenerDatosAvales", params);

					if (miembrosExtras.size() == 0) {
					  //Renovacion Especial
						LogHandler.debug(uid, getClass(), "generarKitImpresionPagareTarea - Avales Renovacion Especial");
						for (int i = 0; i < miembrosOriginales; i++)
						{
						count = i + 1;

						for (int j = 1; j < miembrosOriginales; j++) {
							count =+count;
							if ( count >= miembros.size() ) {
								count = 0;
								}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
										miembros.get(count).getEdocivil()));
							avales.add(aval);
							count ++;

						}
					}

					}

					//Formateo del numero de cheque
					for ( MiembroGrupoVO miembroGrupoVO : miembrosExtras  )
						{
						//Se determinan los telefonos
						LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - obtenerTelefonoKitImpresion");
						final Object objectTel = sesion.selectOne("obtenerTelefonoKitImpresion",  miembroGrupoVO.getNummiembro());
						final String telefono = objectTel != null ? "" + objectTel : "";
						telefonos.put(miembroGrupoVO.getNummiembro(), telefono.trim());

						//Se agrega los avalaes faltantes
						if ( miembros.size() <= INTEGRANTES_MINIMOS_AVAL ) {
							miembros.add( miembroGrupoVO );
							}
						else	{
							break;
							}
						}

					}

				if (miembros.size() >= INTEGRANTES_MINIMOS_AVAL ) {
					for (int i = 0; i < miembrosOriginales; i++)
						{
						count = i + 1;
						for (int j = 1; j < (categoria.contains( "COM" ) ? 5 : 3); j++) {
							count =+count;
							if ( count >= miembros.size() ) {
								count = 0;
								}

							count = count == i ? (count + 1) == miembros.size() ? 0 : ++count : count;
							AvalGrupo aval = new AvalGrupo();
							aval.setCalleaval(miembros.get(count).getCallecte());
							aval.setCiudadaval(miembros.get(count).getCiudadcte());
							aval.setColoniaaval(miembros.get(count).getColoniacte());
							aval.setCpaval(miembros.get(count).getCpcte());
							aval.setEstadoaval(miembros.get(count).getEstadocte());
							aval.setCliente(miembros.get(i).getClienteId());
							aval.setNomaval(miembros.get(count).getCliente().toString());
							aval.setNumaval(j + "");
							aval.setTel( telefonos.get(miembros.get(count).getNummiembro()) );
							aval.setTitaval(ObtenerTitAval(miembros.get(count).getSexo().trim(),
										miembros.get(count).getEdocivil()));
							count ++;
							avales.add(aval);

						}
					}
				}

				respuesta.setAvales(avales);

					//Amortizaciones
					List<PagoGrupo> amortizaciones = new ArrayList<PagoGrupo>();

					LogHandler.trace("", getClass(), "==> generarKitImpresionPagareTarea - amortizacionPagares");
					List<AmortizacionOV> obj = sesion.selectList("amortizacionPagares", numeroContrato);
					
					if (obj == null || obj.size() <= 0) {
						throw new Exception("Sin amortizacion Pagares.");
					}
					
					LogHandler.debug(uid, getClass(), " generarKitImpresionPagareTarea - Comunal pagare Datos de los PAGO AMORTIZACION");
					for (int i = 0; i < obj.size(); i++) {
						int cliente = Integer.parseInt(obj.get(i).getIntegrante().trim());
						String saldoCapital = Double.toString(obj.get(i).getSaldoCapital());
						PagoGrupo pago = new PagoGrupo();
						pago.setCliente(cliente + "");
						pago.setFechapago(formatFecha(obj.get(i).getFechaPago()));
						pago.setImptepago(Double.toString(obj.get(i).getMontoPago()));
						pago.setInteres(Double.toString(obj.get(i).getInteresPeriodo()));
						pago.setNumpago(obj.get(i).getNoPago().toString());
						pago.setCapital(Double.toString(obj.get(i).getAbonoCapital()));
						pago.setImptepagored(Math.rint((obj.get(i).getMontoPago() * 1000) / 1000) + "");
						pago.setSdo(saldoCapital);
						amortizaciones.add(pago);
					}

					respuesta.setAmortizaciones(amortizaciones);


					//Miembros pagare
					List<MiembroGrupoKitPagare> miembrosPagare = new ArrayList<MiembroGrupoKitPagare>();

//					LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - consulaDatosIntegrantes ");
//					List<MiembroGrupoVO> miembrosGrupo = sesion.selectList("consulaDatosIntegrantes", numeroContrato + " ");

//					if (miembrosGrupo == null || miembrosGrupo.size() <= 0) {
//						throw new Exception("Sin miembros grupo.");
//					}
					

					LogHandler.debug(uid, getClass(), "generarKitImpresionPagareTarea - Comunal pagare Datos de los MIEMBROS");
					HashMap params = new HashMap();
					HashMap datosPersona = new HashMap();
					String edoCivil = "";
					String titGrupo = "";
					params.put("contrato", numeroContrato);
					params.put("fechaActual", new Date());
					//LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - consulaDatosContrato ");
					//ContratoVO contratoVO = (ContratoVO) sesion.selectOne("consulaDatosContrato", numeroContrato);
					LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - obtenerSaldoFv ");
					CreditoSaldo creditoCliente = (CreditoSaldo) sesion.selectOne(	"obtenerSaldoFv", params);
					LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - direccionSucursal ");
					String direccionSucursal = (String) sesion.selectOne("direccionSucursal", creditoCliente.getSucursal());

					/*Se le da el formato en la direccion de la sucursal para el estado*/
					final String [] datosDirecccion = direccionSucursal.split(",");
					final String estadoTit = textoTipoTitulo( datosDirecccion[ datosDirecccion.length - 1 ].trim().toLowerCase() );
					direccionSucursal = direccionSucursal.replace( datosDirecccion[ datosDirecccion.length - 1 ].trim(), estadoTit );
					//String entidad =textoTipoTitulo(miembros.get(0).getEstadocte().toLowerCase());
					//direccionSucursal = datamapper.DataMapper.mapClaveEntidad( direccionSucursal );
					for (int i = 0; i < miembrosGrupo.size(); i++)
						{
							LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - obtenerTelefonoKitImpresion");
							//Integer clienteId= Integer.parseInt(miembrosGrupo.get(i).getNumcheque());
							Integer clienteId = Integer.parseInt(miembrosGrupo.get(i).getCodigocte());
							MiembroGrupoKitPagare mp = new MiembroGrupoKitPagare();
							mp.setContratoLd(datosContrato.getContratoLD());
							String persona = (String) miembros.get(i).getPersona();
							LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - datosPersona");
							datosPersona = (HashMap) sesion.selectOne("datosPersona", persona);
							String sexo = datosPersona.get("sexo") != null ? (String) datosPersona.get("sexo") : "";
							edoCivil = datosPersona.get("edoCivil") != null ? (String) datosPersona.get("edoCivil") : "";
							titGrupo = ObtenerTitAval(sexo, edoCivil);
							String montoLetra = miembros.get(i).getMontoOtorgado();
							mp.setCalle(miembrosGrupo.get(i).getCallecte());
							mp.setCiudad(miembrosGrupo.get(i).getCiudadcte());
							mp.setCliente(clienteId.toString());
							mp.setColonia(miembrosGrupo.get(i).getColoniacte());
							mp.setCp(miembrosGrupo.get(i).getCpcte());
							mp.setCtabanco(CUENTA_BANCO);
							mp.setDirsucursal(direccionSucursal);
							mp.setEmpresa(EMPRESA_FINSOL);
							mp.setEstado(miembrosGrupo.get(i).getEstadocte());
							mp.setFechainicio(formatFechaDireccion(direccionSucursal + "|" + datosContrato.getFechafirma()));
							mp.setImporte(formatMontos(miembros.get(i).getMontoOtorgado()));
							mp.setNombre(miembrosGrupo.get(i).getCliente());
							mp.setPagos(miembrosGrupo.get(i).getNoPagos());
							mp.setPeriodo(formatFrecuencia(creditoCliente.getFrecuenciaPago()));
							LogHandler.info(uid, getClass(), "====> Numero telefonico : "
												+ telefonos.get(miembros.get(i).getNummiembro()));
							mp.setTel( telefonos.get(miembros.get(i).getNummiembro()) );
							mp.setImpteletra(getMontoLetras(montoLetra));
							mp.setTitulo(titGrupo);
							//CALCULO DE LA TASA
							Map<String, Object> 		parametros 			= new HashMap<String, Object>( );
							parametros.put( "sucursal", (Integer) (creditoCliente.getSucursal()));
							parametros.put( "fecha", new Date() );
							parametros.put( "codigo" , CODIGO_IVA );

							LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - obtenerTasaMoratoria");
							HashMap map = (HashMap) sesion.selectOne( "obtenerTasaMoratoria", numeroContrato );
							Double tasa = Double.parseDouble(creditoCliente.getTasa());
							LogHandler.trace(uid, getClass(), "==> generarKitImpresionPagareTarea - " + OPER_VER_VALOR_HISTORICO);
							Integer iva  = (Integer) sesion.selectOne(OPER_VER_VALOR_HISTORICO, parametros);
							Double aux = (double) iva;
							mp.setTasa(df.format((tasa * (1 + (aux / 100))) * 12));
							Double tasaMora = Double.parseDouble( (String) map.get("valor") );
							mp.setTasamora(df.format((tasaMora * (1 + (aux / 100))) * 12));
							miembrosPagare.add(mp);

							List<AvalGrupo> avalesMiembro = new ArrayList<AvalGrupo>();
							List misAvalesA = new ArrayList();
							boolean mienbrosA = false;
							List misAvalesB = new ArrayList();
							//Se Agrega codigo para setear loa avales a cada miembro e imprimirlos en el JasperPagare
							for (int j = 0; j < respuesta.getAvales().size(); j++) {
								if(mienbrosA == false){
									if (mp.getCliente().equals(respuesta.getAvales().get(j).getCliente())) {
//										avalesMiembro.add(respuesta.getAvales().get(j));
										misAvalesA.add(respuesta.getAvales().get(j));
										if(misAvalesA.size() == 2) {
											mienbrosA = true;
										}
									}	
								} else {
									if (mp.getCliente().equals(respuesta.getAvales().get(j).getCliente())) {
//										avalesMiembro.add(respuesta.getAvales().get(j));
										misAvalesB.add(respuesta.getAvales().get(j));
									}	
								}
								
							}

//							mp.setAvales(avalesMiembro);
							mp.setAvalesA(misAvalesA);
							mp.setAvalesB(misAvalesB);

							List<PagoGrupo> pagosMiembro = new ArrayList<PagoGrupo>();
//							List misPagos = new ArrayList();
							//Se Agrega codigo para setear loa pagos a cada miembro e imprimirlos en el JasperPagare
							for (int k = 0; k < respuesta.getAmortizaciones().size(); k++) {
								if (mp.getCliente().equals(respuesta.getAmortizaciones().get(k).getCliente())) {
									pagosMiembro.add(respuesta.getAmortizaciones().get(k));
//									misPagos.add(respuesta.getAmortizaciones().get(k));
								}
							}

//							mp.setAmortizacion(pagosMiembro);
//							mp.setMisPagos(misPagos);

							int partes = 2;
							final int entreDos = pagosMiembro.size() / partes;
						    int residuo = pagosMiembro.size() % partes;
						    int iTake = entreDos;

						    List pagosMiembro1 = new ArrayList();
						    List pagosMiembro2 = new ArrayList();

						    if ( residuo > 0 ) {
					            iTake = entreDos + 1;
					        } else {
					            iTake = entreDos;
					        }

						    for (int j = 0; j < iTake; j++) {
								pagosMiembro1.add(pagosMiembro.get(j));
							}

							mp.setPagosA(pagosMiembro1);

							for (int j = iTake; j < pagosMiembro.size(); j++) {
								pagosMiembro2.add(pagosMiembro.get(j));
							}
							mp.setPagosB(pagosMiembro2);

						}

						respuesta.setMiembros(miembrosPagare);

						respuesta.setAvales(null);
						respuesta.setAmortizaciones(null);

				return respuesta;

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "generarKitImpresionPagareTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;
	}


	public PreSolicitudRespuesta generarPreSolicitudCreditoTarea(String uid , PreSolicitudPeticion peticion) {
		PreSolicitudRespuesta respuesta = new PreSolicitudRespuesta();
		respuesta.setHeader(new EncabezadoRespuesta());
		respuesta.getHeader().setUID(uid);
		respuesta.getHeader().setEstatus(true);

		SqlSession sesion = null;
		ContratoVO contratoVO = null;
		DecimalFormat df = new DecimalFormat("0.00");
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdfh = new SimpleDateFormat("HH:mm");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final java.text.DecimalFormat decimalFormat = new DecimalFormat( "000000000" );

		ConsultaCreditoPeticion peticionDatos = new ConsultaCreditoPeticion();

		try
		{
			if (peticion.getContratoAnterior() == null || peticion.getContratoAnterior().isEmpty()) {
				throw new Exception(CONTRATO_INVALIDO);
			}

			sesion = FabricaConexiones.obtenerSesionNTx();
			String numeroContrato = comun.obtenerNumeroContrato( uid , peticion.getContratoAnterior() );
			if (numeroContrato == null || numeroContrato.isEmpty( ) ) {
				throw new Exception(  "NO SE HA ENCONTRADO INFORMACION PARA ESTE NUMERO DE CONTRATO." );
			}

			peticionDatos.setContrato(numeroContrato);

			DatosCreditoIntegrantesRespuesta respuestaDatos = consultas.obtenerDatosCreditoIntegrantes(uid, peticionDatos);

			//Se recalculan el saldo del credito a renovar con la fecha desembolso.
			CreditoSaldo creditoSaldo = consultas.consultaSaldoCredito(uid, peticion.getContratoAnterior(),
					respuestaDatos.getDatosCredito().getFechaInicio(), sesion);
			creditoSaldo.setSaldoLiquidar(creditoSaldo.getSaldoLiquidar() != null
											? creditoSaldo.getSaldoLiquidar() : 0.0 );
			LogHandler.info(uid, getClass(), "==> creditoSaldo :" + creditoSaldo);

			Double montoCreditoTotal = 0.0;
			Double montoAhorroTotal = 0.0;
			Double montoRefinanciarTotal = 0.0;

			for (int i = 0; i < respuestaDatos.getIntegrantes().length; i++) {
				respuestaDatos.getIntegrantes()[i].setNumIntegrante(i + 1);

				respuestaDatos.getIntegrantes()[i].setMontoRefinanciar(
						creditoSaldo.getSaldoLiquidar() * respuestaDatos.getIntegrantes()[i].getPorcentajeParticipacion());

				respuestaDatos.getIntegrantes()[i].setMontoAhorro(
						formatMontos(respuestaDatos.getIntegrantes()[i].getMontoAhorro()));

				respuestaDatos.getIntegrantes()[i].setMontoFormato(
						formatMontos(respuestaDatos.getIntegrantes()[i].getMonto().toString()));

				respuestaDatos.getIntegrantes()[i].setMontoRefinanciarFormato(
						formatMontos(respuestaDatos.getIntegrantes()[i].getMontoRefinanciar().toString()));

				montoCreditoTotal = montoCreditoTotal + respuestaDatos.getIntegrantes()[i].getMonto();
				montoAhorroTotal = montoAhorroTotal + Double.parseDouble(respuestaDatos.getIntegrantes()[i].getMontoAhorro());
				montoRefinanciarTotal = montoRefinanciarTotal + respuestaDatos.getIntegrantes()[i].getMontoRefinanciar();
			}

			respuestaDatos.getDatosCredito().setMontoCreditoFormato(
					formatMontos(respuestaDatos.getDatosCredito().getMontoCredito().toString()));
			respuestaDatos.getDatosCredito().setParcialidadFormato(
					formatMontos(respuestaDatos.getDatosCredito().getParcialidad().toString()));
			respuestaDatos.getDatosCredito().setFechaInicioFormato(
					sdf4.format(respuestaDatos.getDatosCredito().getFechaInicio()));

			Date date1 = sdf2.parse(respuestaDatos.getDatosCredito().getHoraReunion());
			respuestaDatos.getDatosCredito().setHoraReunion(sdfh.format(date1));

			Date mifecha = new Date();

			respuesta.setRespuestaDatos(respuestaDatos);
			respuesta.setNumeroMiembros(respuestaDatos.getIntegrantes().length);
			respuesta.setFechaSolicitud(sdf4.format(mifecha));
			respuesta.setMontoAhorroTotal(montoAhorroTotal);
			respuesta.setMontoCreditoTotal(montoCreditoTotal);
			respuesta.setMontoRefinanciarTotal(montoRefinanciarTotal);

			respuesta.setMontoAhorroTotalFormato(formatMontos(respuesta.getMontoAhorroTotal().toString()));
			respuesta.setMontoCreditoTotalFormato(formatMontos(respuesta.getMontoCreditoTotal().toString()));
			respuesta.setMontoRefinanciarTotalFormato(formatMontos(respuesta.getMontoRefinanciarTotal().toString()));

				if (peticion.getSolicitud() != null & !peticion.getSolicitud().isEmpty()) {
					//Obtener los elementos del contrato
					LogHandler.trace(uid, getClass(), "generarPreSolicitudCreditoTarea: - obtenerSolicitudKitImpresion");
					LogHandler.info(uid, getClass(), "generarPreSolicitudCreditoTarea: - obtenerSolicitudKitImpresion");
					KitSolicitudOV resSolicitud = (KitSolicitudOV) sesion.selectOne(
							"obtenerSolicitudKitImpresion", peticion.getSolicitud());

					if (resSolicitud == null) {
						throw new Exception("La consulta no arrojo resultados para la solicitud,"
								+ "la solicitud no existe o esta cancelada");
					}

					respuesta.setSolicitud(resSolicitud);
				}

		}
		catch (Exception ex) {
			LogHandler.error(uid, getClass(), "Ocurrio un error en generarPreSolicitudCreditoTarea(): " + ex.getMessage(), ex);
			respuesta.getHeader().setEstatus(false);
			respuesta.getHeader().setMensaje( ex.getMessage() );
		}
		finally {
			FabricaConexiones.close(sesion);
		}

		return respuesta;

	}

}
