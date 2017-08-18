package utilitario.mensajes.comun;

/**
 * clase que contiene la peticion para el catalogo
 * @author rmontellano
 * @version 4.12
 */
public class ConsultaCatalogoPeticionCIOF extends ObjetoValor {
	/**
	 * long serialVersionUID.
	 */
	private static final long serialVersionUID = 7524683472884001633L;
	/**
	 * EncabezadoPeticion header
	 */
	private EncabezadoPeticion header;
	/**
	 * identificador unico de transaccion
	 */
	private String uid;
	/**
	 * String tipoCatalogo
	 */
	private String tipoCatalogo;

	/**
	 * Boolean orderCodigo
	 */
	private boolean orderCodigo;
	/**
	 * contrato al que pertenece la solicitud
	 */
	private String contrato;
	/**
	 * ciclo en el que se encuentra el grupo.
	 */
	private int ciclo;
	/**
	 * si ya se cuenta con una campa&ntilde;a
	 */
	private String campana;
	/**
	 * perfil que vera el catalogo;
	 */
	private String perfil;
	
	/**
	 * sucursal que vera el catalogo;
	 */
	private String sucursal;

	/**
	 * ConsultaCatalogoPeticion
	 */
	public ConsultaCatalogoPeticionCIOF() {

	}
	/**
	 * @return the header
	 */
	public EncabezadoPeticion getHeader() {
		return header;
	}
	/**
	 * @param header the header to set
	 */
	public void setHeader(EncabezadoPeticion header) {
		this.header = header;
	}
	/**
	 * @return the tipoCatalogo
	 */
	public String getTipoCatalogo() {
		return tipoCatalogo;
	}
	/**
	 * @param tipoCatalogo the tipoCatalogo to set
	 */
	public void setTipoCatalogo(String tipoCatalogo) {
		this.tipoCatalogo = tipoCatalogo;
	}
	/**
	 * @return the orderCodigo
	 */
	public boolean getOrderCodigo() {
		return orderCodigo;
	}
	/**
	 * @param orderCodigo the orderCodigo to set
	 */
	public void setOrderCodigo(boolean orderCodigo) {
		this.orderCodigo = orderCodigo;
	}
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
	 * @return the ciclo
	 */
	public int getCiclo() {
		return ciclo;
	}
	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(int ciclo) {
		this.ciclo = ciclo;
	}
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the campana
	 */
	public String getCampana() {
		return campana;
	}
	/**
	 * @param campana the campana to set
	 */
	public void setCampana(String campana) {
		this.campana = campana;
	}
	/**
	 * @return the perfil
	 */
	public String getPerfil() {
		return perfil;
	}
	/**
	 * @param perfil the perfil to set
	 */
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	/**
	 * @return the sucursal
	 */
	public String getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(String sucursal) {
		this.sucursal = sucursal;
	}
	
}
