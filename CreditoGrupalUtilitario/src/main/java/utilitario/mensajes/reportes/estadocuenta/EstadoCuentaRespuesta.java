package utilitario.mensajes.reportes.estadocuenta;

import utilitario.mensajes.comun.AmortizacionActualOV;
import utilitario.mensajes.comun.EncabezadoRespuesta;
import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.reportes.comun.CreditoGrupalOV;
import utilitario.mensajes.reportes.comun.CreditoOV;
import utilitario.mensajes.reportes.comun.DepositosGarantiaOV;
import utilitario.mensajes.reportes.comun.PagoOV;
import utilitario.mensajes.reportes.comun.ResumenSaldoOV;

/**
 * The Class EstadoCuentaRespuesta.
 */
public class EstadoCuentaRespuesta extends ObjetoValor {

	/**
	 * EstadoCuentaRespuesta.
	 */
	public EstadoCuentaRespuesta() {

	}

	/** long serialVersionUID. */
	private static final long serialVersionUID = -3345663333024675686L;

	/** EncabezadoRespuesta encabezado. */
	private EncabezadoRespuesta encabezado;
	//SECCIONES DE LOS REPORTES A REGRESAR COMO RESPUESTA FINAL
	/** CreditoGrupalOV grupo. */
	private CreditoGrupalOV 	grupo;

	/** CreditoOV datosCredito. */
	private CreditoOV 			datosCredito;

	/** PagoOV[] movimientos. */
	private PagoOV[] 			movimientos;

	/** PagoOV[] pagosVencidos. */
	private PagoOV[] 			pagosVencidos;

	/** ResumenSaldoOV resumenSaldo. */
	private ResumenSaldoOV		resumenSaldo;

	/** AmortizacionOV[] tablaAmortizacion. */
	private AmortizacionActualOV[] 	tablaAmortizacion;

	/** String domicilioFiscal. */
	private String 				domicilioFiscal;

	/** EstadoCuentaMontos montosExtras. */
	private EstadoCuentaMontos 	montosExtras;

	/** DepsitosGarantiaOV[] detalle depositos garantia. */
	private DepositosGarantiaOV[] depositosGarantia;
	/**
	 * Obtiene encabezado.
	 *
	 * @return the encabezado
	 */
	public EncabezadoRespuesta getEncabezado() {
		return encabezado;
	}

	/**
	 * Establece encabezado.
	 *
	 * @param encabezado the encabezado to set
	 */
	public void setEncabezado(EncabezadoRespuesta encabezado) {
		this.encabezado = encabezado;
	}

	/**
	 * Obtiene grupo.
	 *
	 * @return the grupo
	 */
	public CreditoGrupalOV getGrupo() {
		return grupo;
	}

	/**
	 * Establece grupo.
	 *
	 * @param grupo the grupo to set
	 */
	public void setGrupo(CreditoGrupalOV grupo) {
		this.grupo = grupo;
	}

	/**
	 * Obtiene datos credito.
	 *
	 * @return the datosCredito
	 */
	public CreditoOV getDatosCredito() {
		return datosCredito;
	}

	/**
	 * Establece datos credito.
	 *
	 * @param datosCredito the datosCredito to set
	 */
	public void setDatosCredito(CreditoOV datosCredito) {
		this.datosCredito = datosCredito;
	}

	/**
	 * Obtiene movimientos.
	 *
	 * @return the movimientos
	 */
	public PagoOV[] getMovimientos() {
		return movimientos;
	}

	/**
	 * Establece movimientos.
	 *
	 * @param movimientos the movimientos to set
	 */
	public void setMovimientos(PagoOV[] movimientos) {
		this.movimientos = movimientos;
	}

	/**
	 * Obtiene pagos vencidos.
	 *
	 * @return the pagosVencidos
	 */
	public PagoOV[] getPagosVencidos() {
		return pagosVencidos;
	}

	/**
	 * Establece pagos vencidos.
	 *
	 * @param pagosVencidos the pagosVencidos to set
	 */
	public void setPagosVencidos(PagoOV[] pagosVencidos) {
		this.pagosVencidos = pagosVencidos;
	}

	/**
	 * Obtiene resumen saldo.
	 *
	 * @return the resumenSaldo
	 */
	public ResumenSaldoOV getResumenSaldo() {
		return resumenSaldo;
	}

	/**
	 * Establece resumen saldo.
	 *
	 * @param resumenSaldo the resumenSaldo to set
	 */
	public void setResumenSaldo(ResumenSaldoOV resumenSaldo) {
		this.resumenSaldo = resumenSaldo;
	}

	/**
	 * Obtiene tabla amortizacion.
	 *
	 * @return the tablaAmortizacion
	 */
	public AmortizacionActualOV[] getTablaAmortizacion() {
		return tablaAmortizacion;
	}

	/**
	 * Establece tabla amortizacion.
	 *
	 * @param tablaAmortizacion the tablaAmortizacion to set
	 */
	public void setTablaAmortizacion(AmortizacionActualOV[] tablaAmortizacion) {
		this.tablaAmortizacion = tablaAmortizacion;
	}

	/**
	 * Obtiene domicilio fiscal.
	 *
	 * @return the domicilioFiscal
	 */
	public String getDomicilioFiscal() {
		return domicilioFiscal;
	}

	/**
	 * Establece domicilio fiscal.
	 *
	 * @param domicilioFiscal the domicilioFiscal to set
	 */
	public void setDomicilioFiscal(String domicilioFiscal) {
		this.domicilioFiscal = domicilioFiscal;
	}

	/**
	 * Obtiene montos extras.
	 *
	 * @return the montosExtras
	 */
	public EstadoCuentaMontos getMontosExtras() {
		return montosExtras;
	}

	/**
	 * Establece montos extras.
	 *
	 * @param montosExtras the montosExtras to set
	 */
	public void setMontosExtras(EstadoCuentaMontos montosExtras) {
		this.montosExtras = montosExtras;
	}

	/**
	 * @return the depositosGarantia
	 */
	public DepositosGarantiaOV[] getDepositosGarantia() {
		return depositosGarantia;
	}

	/**
	 * @param depositosGarantia the depositosGarantia to set
	 */
	public void setDepositosGarantia(DepositosGarantiaOV[] depositosGarantia) {
		this.depositosGarantia = depositosGarantia;
	}

}
