package utilitario.mensajes.originacion.consulta;

import utilitario.mensajes.comun.ObjetoValor;
/**
 * Clase que se hizo para simplificacion de la renovacion.
 * @version 4.10
 *
 */
public class ContratoRenovacionPeticion extends ObjetoValor {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 7036105341213381968L;
	/** contrato */
	private String contrato;
	/** sucursal */
	private int sucursal;
	/** numero de personas */
	private String[] arrayPersonas;
	/** numero de integrantes nuevos*/
	private int integrantesNuevos;
	/**codigo del documento*/
	private String codigoDocumento = "";
	/** contrato */
	private String categoria;
	/** nombreAsesor */
	private String nombreAsesor;
	/** nombreGerenteSucursal */
	private String nombreGerenteSucursal;
	/** nombreGerenteRegional */
	private String nombreGerenteRegional;
	/** porcentaje */
	private boolean porcentaje;
	/** producto */
	private String producto;
	
	/** codigo */
	private String codigo;
	
	/**
	 * @return the contrato
	 */
	public String getContrato() {
		return contrato;
	}

	/**
	 * @param contrato the contrato to set
	 */
	public void setContrato(String contrato) {
		this.contrato = contrato;
	}

	/**
	 * @return the sucursal
	 */
	public int getSucursal() {
		return sucursal;
	}

	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(int sucursal) {
		this.sucursal = sucursal;
	}

	/**
	 * @return the numeroDePersonas
	 */
	public String[] getArrayPersonas() {
		return arrayPersonas;
	}

	/**
	 * @param arrayPersonas the numeroDePersonas to set
	 */
	public void setArrayPersonas(String[] arrayPersonas) {
		this.arrayPersonas = arrayPersonas;
	}

	/**
	 * @return the integrantesNuevos
	 */
	public int getIntegrantesNuevos() {
		return integrantesNuevos;
	}

	/**
	 * @param integrantesNuevos the integrantesNuevos to set
	 */
	public void setIntegrantesNuevos(int integrantesNuevos) {
		this.integrantesNuevos = integrantesNuevos;
	}

	/**
	 * @return the codigoDocumento
	 */
	public String getCodigoDocumento() {
		return codigoDocumento;
	}

	/**
	 * @param codigoDocumento the codigoDocumento to set
	 */
	public void setCodigoDocumento(String codigoDocumento) {
		this.codigoDocumento = codigoDocumento;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	/**
	 * @return the nombreAsesor
	 */
	public String getNombreAsesor() {
		return nombreAsesor;
	}

	/**
	 * @param nombreAsesor the nombreAsesor to set
	 */
	public void setNombreAsesor(String nombreAsesor) {
		this.nombreAsesor = nombreAsesor;
	}

	/**
	 * @return the nombreGerenteSucursal
	 */
	public String getNombreGerenteSucursal() {
		return nombreGerenteSucursal;
	}

	/**
	 * @param nombreGerenteSucursal the nombreGerenteSucursal to set
	 */
	public void setNombreGerenteSucursal(String nombreGerenteSucursal) {
		this.nombreGerenteSucursal = nombreGerenteSucursal;
	}

	/**
	 * @return the nombreGerenteRegional
	 */
	public String getNombreGerenteRegional() {
		return nombreGerenteRegional;
	}

	/**
	 * @param nombreGerenteRegional the nombreGerenteRegional to set
	 */
	public void setNombreGerenteRegional(String nombreGerenteRegional) {
		this.nombreGerenteRegional = nombreGerenteRegional;
	}

	/**
	 * @return the porcentaje
	 */
	public boolean isPorcentaje() {
		return porcentaje;
	}

	/**
	 * @param porcentaje the porcentaje to set
	 */
	public void setPorcentaje(boolean porcentaje) {
		this.porcentaje = porcentaje;
	}

	/**
	 * @return the producto
	 */
	public String getProducto() {
		return producto;
	}

	/**
	 * @param producto the producto to set
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
