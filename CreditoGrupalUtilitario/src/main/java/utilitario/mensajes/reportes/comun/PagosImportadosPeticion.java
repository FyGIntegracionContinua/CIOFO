package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;

public class PagosImportadosPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 5774954257162933665L;

	 /**
	 * Fecha para consultar el reporte de pagos importados
	 */
	private String fecha;

	/**
	 * @return the fecha
	 */
	public String getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
