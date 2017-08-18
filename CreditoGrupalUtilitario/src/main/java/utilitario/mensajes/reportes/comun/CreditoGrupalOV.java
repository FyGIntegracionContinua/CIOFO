package utilitario.mensajes.reportes.comun;

import utilitario.mensajes.comun.ObjetoValor;
import utilitario.mensajes.impresiondocs.comun.MiembroGrupoVO;

/**
 * The Class CreditoGrupalOV.
 */
public class CreditoGrupalOV extends ObjetoValor {

	/**
	 * CreditoGrupalOV
	 */
	public CreditoGrupalOV() {

	}
	/**
	 *
	 */
	private static final long serialVersionUID = -7L;
	/**
	 * String grupo
	 */
	private String	grupo;
	/**
	 * String nombreGrupo
	 */
	private String	nombreGrupo;
	/**
	 * Integer ciclo
	 */
	private Integer	ciclo;
	/**
	 * Integer sucursal
	 */
	private Integer	sucursal;
	/**
	 * String nombreSucursal
	 */
	private String	nombreSucursal;
	/**
	 * String asesor
	 */
	private String	asesor;
	/**
	 * String nombreAsesor
	 */
	private String	nombreAsesor;
	/**
	 * String numeroContrato
	 */
	private String	numeroContrato;
	/**
	 * String producto
	 */
	private String	producto;
	/**
	 * String nombreProducto
	 */
	private String	nombreProducto;
	/**
	 * String contratoLD
	 */
	private String 	contratoLD;
	/**
	 * Integer numero de integrantes
	 */
	private Integer	noIntegrantes;
	/**
	 * String nombres de integrantes
	 */
	private String 	nombresIntegrantes;
	/**
	 * String periodo
	 */
	private String 	periodo;
	/**
	 * MiembroGrupoVO[] integrantes
	 */
	private MiembroGrupoVO[] integrantes;
	/**
	 * @return the grupo
	 */
	public String getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}
	/**
	 * @return the nombreGrupo
	 */
	public String getNombreGrupo() {
		return nombreGrupo;
	}
	/**
	 * @param nombreGrupo the nombreGrupo to set
	 */
	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
	}
	/**
	 * @return the ciclo
	 */
	public Integer getCiclo() {
		return ciclo;
	}
	/**
	 * @param ciclo the ciclo to set
	 */
	public void setCiclo(Integer ciclo) {
		this.ciclo = ciclo;
	}
	/**
	 * @return the sucursal
	 */
	public Integer getSucursal() {
		return sucursal;
	}
	/**
	 * @param sucursal the sucursal to set
	 */
	public void setSucursal(Integer sucursal) {
		this.sucursal = sucursal;
	}
	/**
	 * @return the nombreSucursal
	 */
	public String getNombreSucursal() {
		return nombreSucursal;
	}
	/**
	 * @param nombreSucursal the nombreSucursal to set
	 */
	public void setNombreSucursal(String nombreSucursal) {
		this.nombreSucursal = nombreSucursal;
	}
	/**
	 * @return the asesor
	 */
	public String getAsesor() {
		return asesor;
	}
	/**
	 * @param asesor the asesor to set
	 */
	public void setAsesor(String asesor) {
		this.asesor = asesor;
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
	 * @return the numeroContrato
	 */
	public String getNumeroContrato() {
		return numeroContrato;
	}
	/**
	 * @param numeroContrato the numeroContrato to set
	 */
	public void setNumeroContrato(String numeroContrato) {
		this.numeroContrato = numeroContrato;
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
	 * @return the nombreProducto
	 */
	public String getNombreProducto() {
		return nombreProducto;
	}
	/**
	 * @param nombreProducto the nombreProducto to set
	 */
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	/**
	 * @return the contratoLD
	 */
	public String getContratoLD() {
		return contratoLD;
	}
	/**
	 * @param contratoLD the contratoLD to set
	 */
	public void setContratoLD(String contratoLD) {
		this.contratoLD = contratoLD;
	}
	/**
	 * @return the integrantes
	 */
	public MiembroGrupoVO[] getIntegrantes() {
		return integrantes;
	}
	/**
	 * @param integrantes the integrantes to set
	 */
	public void setIntegrantes(MiembroGrupoVO[] integrantes) {
		this.integrantes = integrantes;
	}
	/**
	 * @return the noIntegrantes
	 */
	public Integer getNoIntegrantes() {
		return noIntegrantes;
	}
	/**
	 * @param noIntegrantes the noIntegrantes to set
	 */
	public void setNoIntegrantes(Integer noIntegrantes) {
		this.noIntegrantes = noIntegrantes;
	}
	/**
	 * @return the nombresIntegrantes
	 */
	public String getNombresIntegrantes() {
		return nombresIntegrantes;
	}
	/**
	 * @param nombresIntegrantes the nombresIntegrantes to set
	 */
	public void setNombresIntegrantes(String nombresIntegrantes) {
		this.nombresIntegrantes = nombresIntegrantes;
	}
	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

}
