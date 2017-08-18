package utilitario.test.oxxo;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;

import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.operacion.pagos.AplicarPagoPeticion;
import utilitario.mensajes.operacion.pagos.AplicarPagoRespuesta;
import utilitario.mensajes.operacion.pagos.oxxo.CatalogoDeEstados;
import utilitario.mensajes.operacion.pagos.oxxo.Concept;
import utilitario.mensajes.operacion.pagos.oxxo.PeticionEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaConsultaEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.RespuestaReverseEnLineaOxxo;
import utilitario.mensajes.operacion.pagos.oxxo.VariablesTestOxxo;

/**
 * TDD de un contrato normal
 *
 * @author out_rmontellanom
 *
 */
public class TestPagoEnLineaDTO {
	/**
	 * variable para instanciar PeticionEnLineaOxxo.
	 */
	PeticionEnLineaOxxo peticionEnLineaOxxo;
	/**
	 * variable para instanciar RespuestaConsultaEnLineaOxxo.
	 */
	RespuestaConsultaEnLineaOxxo respuestaConsultaEnLineaOxxo;
	/**
	 * variable para instanciar aplicarPagoPeticion
	 */
	AplicarPagoPeticion aplicarPagoPeticion;
	/**
	 * variable para instanciar conceptos
	 */
	Concept conceptos;
	/**
	 * variable para instanciar List<Concept>
	 */
	List<Concept> listConcept;

	/**
	 * variable para instanciar AplicarPagoRespuesta.
	 */
	AplicarPagoRespuesta aplicarPagoRespuesta;

	/**
	 * variable para instanciar respuestaReverseEnLineaOxxo.
	 */
	RespuestaReverseEnLineaOxxo respuestaReverseEnLineaOxxo;

	/**
	 * M&eacute;todo que contiene la decaración de las propiedades. del sistema
	 *
	 * @throws Exception
	 *             ser&aacute; lanzada si ocurre en error al inicilizar las
	 *             propiedades del sistema
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("JUnitMode", "ON");
	}

	/**
	 * Inicializacion de nuestras variables de instancia.
	 *
	 * @throws Exception
	 *             sera lanzada si no se pueden inicializar nuestras variables.
	 */
	@Before
	public final void setUp() throws Exception {
		peticionEnLineaOxxo = new PeticionEnLineaOxxo();
		respuestaConsultaEnLineaOxxo = new RespuestaConsultaEnLineaOxxo();
		aplicarPagoPeticion = new AplicarPagoPeticion();
		conceptos = new Concept();
		listConcept = new ArrayList<Concept>();
		aplicarPagoRespuesta = new AplicarPagoRespuesta();
		respuestaReverseEnLineaOxxo = new RespuestaReverseEnLineaOxxo();
	}

	/**
	 * metodo principal de test.
	 */
	@Test
	public void test() {
		validarCreacionDtos();
	}

	/**
	 * m&eacute;todo que checa una consulta correcta.
	 */
	public void validarCreacionDtos() {
		

// validar dto de peticionEnLineaOxxo
		// ans15 Y C P R
		peticionEnLineaOxxo.setToken("OXXO_DESPAGOS10");
		// ans15 Y C P
		peticionEnLineaOxxo.setClient("95181109"); // contrato
		// n 10 Y R
		peticionEnLineaOxxo.setFolio(VariablesTestOxxo.FOLIO.getFecha());
		// n10 N R
		peticionEnLineaOxxo.setAuth(VariablesTestOxxo.AUT2.getFecha());
		// ans 30 Y P
		peticionEnLineaOxxo.setAccount("123454132");
		// n8 Y P
		peticionEnLineaOxxo.setAdminDate(VariablesTestOxxo.TRANDATE.getFecha());
		// n 12 Y P
		peticionEnLineaOxxo.setAmount(VariablesTestOxxo.AMOUNT2.getFecha());
		// n 2 N P
		peticionEnLineaOxxo.setCashMachine(1);
		// an 3 N P
		peticionEnLineaOxxo.setEntryMode("021");
		// an 1 Y P
		peticionEnLineaOxxo.setPartial("P");
		// n 10 Y P
		peticionEnLineaOxxo.setTicket(VariablesTestOxxo.TICKET.getFecha());
		// an 10 Y P
		peticionEnLineaOxxo.setStore("10MON50EDI");
		// an 14 Y P
		peticionEnLineaOxxo.setTranDate("20110110091520");

// validar dto respuestaConsultaEnLineaOxxo
		// ans37 Y
		respuestaConsultaEnLineaOxxo.setAccount("124544");
		// ans 150 y
		respuestaConsultaEnLineaOxxo.setName("carmelitas");
		// ans 100 N
		respuestaConsultaEnLineaOxxo.setAddress("calle 123");
		// ans 20 N
		respuestaConsultaEnLineaOxxo.setStatus("Regular");
		// a 40 N
		respuestaConsultaEnLineaOxxo.setReference("residencial");
		// an 1 Y
		respuestaConsultaEnLineaOxxo.setPartial("T");
		// objeto
		respuestaConsultaEnLineaOxxo.setConcepts(listConcept);
		// n 3 Y
		respuestaConsultaEnLineaOxxo.setCode("00");
		// a 100 y
		respuestaConsultaEnLineaOxxo.setMessage(CatalogoDeEstados.CODIGO_00.getTitulo());

// validar dto aplicarPagoPeticion
		aplicarPagoPeticion.setTipoAplicacion("123454132"); // account
		aplicarPagoPeticion.setUsuario("Juan Perez"); // client
		aplicarPagoPeticion.setFechaValor(new Date(VariablesTestOxxo.TRANDATE.getFecha())); // tranDate
		aplicarPagoPeticion.setMonto(VariablesTestOxxo.AMOUNT.getAm()); // amount
		aplicarPagoPeticion.setMedioPago("12334"); // ticket de venta
		aplicarPagoPeticion.setTipoAplicacion("P"); // partial
		aplicarPagoPeticion.setReferencia("18748749385"); // folio
// validar dto conceptos
		conceptos.setDescription("Descuento");
		conceptos.setAmount("1000");
		conceptos.setOperation("-");

// validar dto listConcept
		listConcept.add(conceptos);

// validar dto aplicarPagoRespuesta
		EncabezadoRespuesta encabezado = new EncabezadoRespuesta();
		encabezado.setCodigo("05"); // code
		encabezado.setMensaje("nose"); // errorDesc, message ticket
		encabezado.setUID("123454132"); // account
		encabezado.setCorrelationId("130.00"); // amount
		aplicarPagoRespuesta.setIdTransaccion(VariablesTestOxxo.AUTH.getAut()); // auth
		aplicarPagoRespuesta.setHeader(encabezado);

// validar dto respuestaReverseEnLineaOxxo
		// n10 Y
		respuestaReverseEnLineaOxxo.setIdReverse(VariablesTestOxxo.REVERSE.getFecha());
		// n12 N
		respuestaReverseEnLineaOxxo.setAmount(VariablesTestOxxo.REVERSE.getAm() + "");
		// n10 Y
		respuestaReverseEnLineaOxxo.setAuth(VariablesTestOxxo.REVERSE.getFecha());
		// an 30 N
		respuestaReverseEnLineaOxxo.setAccount("123454132L");
		// n3 Y
		respuestaReverseEnLineaOxxo.setCode("00");
		// a100 Y
		respuestaReverseEnLineaOxxo.setErrorDesc("Reverso Realizado");
		// an 120 N
		respuestaReverseEnLineaOxxo.setMessageTicket("Reverso Realizado");

	}
}
