package utilitario.mensajes.originacion.consulta;

import java.io.Serializable;
/**
 * clase que se hizo para renovacion financieras
 * @author rmontellano
 * @version 4.10
 *
 */
public class ClientesGrupo implements Serializable {

	/**
	 * serialVersionUID.
	 */
	private static final long serialVersionUID = 1440907639708877964L;
	/**
	 * numero del cliente grupo
	 */
	private int numeroClienteGrupo;
	/**
	 *  C=  Cargo: P (Presidenta), T (tesorera), Se (secretaria)
	 */
	private String c1ClienteGrupo = " ";
	/**
	 *  Indica el estatus de las solicitudes de cr&eacute;dito.
	 *  Por default deber&aacute; mostra el valor A
	 *  E= Estatus: A=Antiguo, N=Nuevo, D=Desertor, RI=Reingreso, CG=Cambio de grupo.
	 */
	private String e2ClienteGrupo = " ";
	/**
	 * Integrantes seleccionan en cuyo  domicilio se realizara la reuni&oacute;n grupal.
	 */
	private String r3ClienteGrupo = " ";
	/**
	 * n&uacute;mero de persona del cliente
	 */
	private String numPersonaClienteGrupo = " ";
	/**
	 * nombre del cliente.
	 */
	private String nombreClienteGrupo = " ";
	/**
	 *  ciclo del cliente int.
	 */
	private int cicloClienteGrupo;
	/**
	 * destino del cr&eacute;dito anterior del cliente.
	 * : C= Capital de trabajo, AF= Compra de Activo Fijo,
	 * RN=Remodelaci&oacute;n del Negocio, O=Otros
	 */
	private String destinoCreditoClienteGrupo = " ";
	/**
	 * monto del cr&eacute;dito que solicit&oacute; el cliente en el contrato actual.
	 */
	private String creditoVigenteClienteGrupo = "0.00";
	/**
	 * monto pre aprobado para el cliente.
	 */
	private String creditoPreAprobadoClienteGrupo = "0.00";
	/**
	 * rol del integrante que puede ser un presidente, tesorero, coordinador o secretario
	 */
	private String rolIntegrante = " ";
	/**
	 * @return the numeroClienteGrupo
	 */
	public int getNumeroClienteGrupo() {
		return numeroClienteGrupo;
	}
	/**
	 * @param numeroClienteGrupo the numeroClienteGrupo to set
	 */
	public void setNumeroClienteGrupo(int numeroClienteGrupo) {
		this.numeroClienteGrupo = numeroClienteGrupo;
	}
	/**
	 * @return the c1ClienteGrupo
	 */
	public String getC1ClienteGrupo() {
		return c1ClienteGrupo;
	}
	/**
	 * @param c1ClienteGrupo the c1ClienteGrupo to set
	 */
	public void setC1ClienteGrupo(String c1ClienteGrupo) {
		this.c1ClienteGrupo = c1ClienteGrupo;
	}
	/**
	 * @return the e2ClienteGrupo
	 */
	public String getE2ClienteGrupo() {
		return e2ClienteGrupo;
	}
	/**
	 * @param e2ClienteGrupo the e2ClienteGrupo to set
	 */
	public void setE2ClienteGrupo(String e2ClienteGrupo) {
		this.e2ClienteGrupo = e2ClienteGrupo;
	}
	/**
	 * @return the r3ClienteGrupo
	 */
	public String getR3ClienteGrupo() {
		return r3ClienteGrupo;
	}
	/**
	 * @param r3ClienteGrupo the r3ClienteGrupo to set
	 */
	public void setR3ClienteGrupo(String r3ClienteGrupo) {
		this.r3ClienteGrupo = r3ClienteGrupo;
	}
	/**
	 * @return the numPersonaClienteGrupo
	 */
	public String getNumPersonaClienteGrupo() {
		return numPersonaClienteGrupo;
	}
	/**
	 * @param numPersonaClienteGrupo the numPersonaClienteGrupo to set
	 */
	public void setNumPersonaClienteGrupo(String numPersonaClienteGrupo) {
		this.numPersonaClienteGrupo = numPersonaClienteGrupo;
	}
	/**
	 * @return the nombreClienteGrupo
	 */
	public String getNombreClienteGrupo() {
		return nombreClienteGrupo;
	}
	/**
	 * @param nombreClienteGrupo the nombreClienteGrupo to set
	 */
	public void setNombreClienteGrupo(String nombreClienteGrupo) {
		this.nombreClienteGrupo = nombreClienteGrupo;
	}
	/**
	 * @return the cicloClienteGrupo
	 */
	public int getCicloClienteGrupo() {
		return cicloClienteGrupo;
	}
	/**
	 * @param cicloClienteGrupo the cicloClienteGrupo to set
	 */
	public void setCicloClienteGrupo(int cicloClienteGrupo) {
		this.cicloClienteGrupo = cicloClienteGrupo;
	}
	/**
	 * @return the destinoCreditoClienteGrupo
	 */
	public String getDestinoCreditoClienteGrupo() {
		return destinoCreditoClienteGrupo;
	}
	/**
	 * @param destinoCreditoClienteGrupo the destinoCreditoClienteGrupo to set
	 */
	public void setDestinoCreditoClienteGrupo(String destinoCreditoClienteGrupo) {
		this.destinoCreditoClienteGrupo = destinoCreditoClienteGrupo;
	}
	/**
	 * @return the creditoAnteriorClienteGrupo
	 */
	public String getCreditoVigenteClienteGrupo() {
		return creditoVigenteClienteGrupo;
	}
	/**
	 * @param creditoVigenteClienteGrupo the creditoAnteriorClienteGrupo to set
	 */
	public void setCreditoVigenteClienteGrupo(String creditoVigenteClienteGrupo) {
		this.creditoVigenteClienteGrupo = creditoVigenteClienteGrupo;
	}
	/**
	 * @return the creditoPreAprobadoClienteGrupo
	 */
	public String getCreditoPreAprobadoClienteGrupo() {
		return creditoPreAprobadoClienteGrupo;
	}
	/**
	 * @param creditoPreAprobadoClienteGrupo the creditoPreAprobadoClienteGrupo to set
	 */
	public void setCreditoPreAprobadoClienteGrupo(String creditoPreAprobadoClienteGrupo) {
		this.creditoPreAprobadoClienteGrupo = creditoPreAprobadoClienteGrupo;
	}
	/**
	 * @return the rolIntegrante
	 */
	public String getRolIntegrante() {
		return rolIntegrante;
	}
	/**
	 * @param rolIntegrante the rolIntegrante to set
	 */
	public void setRolIntegrante(String rolIntegrante) {
		this.rolIntegrante = rolIntegrante;
	}

}
