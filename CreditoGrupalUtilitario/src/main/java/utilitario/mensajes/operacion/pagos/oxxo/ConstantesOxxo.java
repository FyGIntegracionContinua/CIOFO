package utilitario.mensajes.operacion.pagos.oxxo;

/**
 * clase para las constantes que se usan en oxxo
 * @author out_rmontellanom
 * @version 4.2
 */
public enum ConstantesOxxo {
	/**
	 *
	 */
	OXXO("aqui va la descripcion");
     /**
      * descripcion.
      */
	private String  descripcion;
	/**
	 * constructor con un parametro.
	 * @param descrip descripcion.
	 */
	private ConstantesOxxo(String descrip) {
		descripcion = descrip;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
}
