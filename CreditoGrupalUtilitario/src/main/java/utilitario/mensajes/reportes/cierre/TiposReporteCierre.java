/**
 *
 */
package utilitario.mensajes.reportes.cierre;

/**
 * @author out_jcmoreno
 *
 */
public enum TiposReporteCierre {

	/**
	 * TiposReporteCierre CARTERA_ACTIVA
	 */
	CARTERA_ACTIVA(1),
	/**
	 * TiposReporteCierre CONTRATOS_ACTIVOS_CON_MORA
	 */
	CONTRATOS_ACTIVOS_CON_MORA(2),
	/**
	 * TiposReporteCierre CONTRATOS_ACTIVOS_SALDO_FAVOR
	 */
	CONTRATOS_ACTIVOS_SALDO_FAVOR(3),
	/**
	 * TiposReporteCierre DESEMBOLSO_OPEN_CONTRACT
	 */
	DESEMBOLSO_OPEN_CONTRACT(4),
	/**
	 * TiposReporteCierre DESEMBOLSO_REPAYMENTS
	 */
	DESEMBOLSO_REPAYMENTS(5),
	/**
	 * TiposReporteCierre DESEMBOLOS_SE_FINSOL1
	 */
	DESEMBOLOS_SE_FINSOL1(6),
	/**
	 * TiposReporteCierre DESEMBOLOS_SE_FINSOL2
	 */
	DESEMBOLOS_SE_FINSOL2(7);

	/**
	 * int tipo
	 */
	private int tipo;

	/**
	 * @param tipo :
	 */
	TiposReporteCierre( int tipo ) {
		this.tipo = tipo;
	}

	/**
	 * @return getTipo :
	 */
	public int getTipo( ) {
		return tipo;
	}

}

