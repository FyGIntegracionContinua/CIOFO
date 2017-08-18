package utilitario.mensajes.impresiondocs.comun;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 * The Class MiembroGrupoPagare.
 */
public class MiembroGrupoKitPagare {

	/**
	 * MiembroGrupoPagare.
	 */
	public MiembroGrupoKitPagare() {

	}
	
	/** The contrato ld. */
	private String contratoLd;

	/**  Id del cliente? SI. */
	private String cliente;

	/**  Importe? Cr�dito Otorgado. */
	private String importe;

	/**  Importe en letra. */
	private String impteletra;

	/**  Tasa de interes anual? SI. */
	private String tasa;

	/** Frecuencia de pago. */
	private String periodo;

	/**
	 * The ctabanco.
	 *
	 * @return the cliente
	 */
	/** Cuenta del banco?.. De donde se obtiene? Es parametro */
	private String ctabanco;

	/**  Direcci�n de la sucursal. */
	private String dirsucursal;

	/**  Tasa moratoria anual? SI. */
	private String tasamora;

	/**  ?? Direccion Sucursal + Fecha Actual. */
	private String fechainicio;

	/** Nombre FINSOL. */
	private String empresa;
	/**
	 * ?? , Sr.,Sra, etc
	 */
	private String titulo;

	/** Nombre del cliente. */
	private String nombre;

	/** Domicilio cliente (calle). */
	private String calle;

	/**  Domicilio cliente (colonia). */
	private String colonia;

	/** Domicilio cliente (ciudad). */
	private String ciudad;

	/**  Domicilio cliente (estado). */
	private String estado;

	/**  Domicilio cliente (cp). */
	private String cp;

	/** N�mero de pagos? SI. */
	private String pagos;

	/**  Telefono del cliente �domicilio? SI. */
	private String tel;
	
//	/** The avales. */
//	private List<AvalGrupo> avales;

	/** The amortizacion. */
	private List<PagoGrupo> amortizacion;
	
	private List avalesA = new ArrayList();
	
	private List avalesB = new ArrayList();
	
	private List pagosA = new ArrayList();

	private List pagosB = new ArrayList();

	/**
	 * Obtiene cliente.
	 *
	 * @return .
	 */
	public String getCliente() {
		return cliente;
	}

	/**
	 * Establece cliente.
	 *
	 * @param cliente the cliente to set
	 */
	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	/**
	 * Obtiene importe.
	 *
	 * @return the importe
	 */
	public String getImporte() {
		return importe;
	}

	/**
	 * Establece importe.
	 *
	 * @param importe the importe to set
	 */
	public void setImporte(String importe) {
		this.importe = importe;
	}

	/**
	 * Obtiene impteletra.
	 *
	 * @return the impteletra
	 */
	public String getImpteletra() {
		return impteletra;
	}

	/**
	 * Establece impteletra.
	 *
	 * @param impteletra the impteletra to set
	 */
	public void setImpteletra(String impteletra) {
		this.impteletra = impteletra;
	}

	/**
	 * Obtiene tasa.
	 *
	 * @return the tasa
	 */
	public String getTasa() {
		return tasa;
	}

	/**
	 * Establece tasa.
	 *
	 * @param tasa the tasa to set
	 */
	public void setTasa(String tasa) {
		this.tasa = tasa;
	}

	/**
	 * Obtiene periodo.
	 *
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}

	/**
	 * Establece periodo.
	 *
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	/**
	 * Obtiene ctabanco.
	 *
	 * @return the ctabanco
	 */
	public String getCtabanco() {
		return ctabanco;
	}

	/**
	 * Establece ctabanco.
	 *
	 * @param ctabanco the ctabanco to set
	 */
	public void setCtabanco(String ctabanco) {
		this.ctabanco = ctabanco;
	}

	/**
	 * Obtiene dirsucursal.
	 *
	 * @return the dirsucursal
	 */
	public String getDirsucursal() {
		return dirsucursal;
	}

	/**
	 * Establece dirsucursal.
	 *
	 * @param dirsucursal the dirsucursal to set
	 */
	public void setDirsucursal(String dirsucursal) {
		this.dirsucursal = dirsucursal;
	}

	/**
	 * Obtiene tasamora.
	 *
	 * @return the tasamora
	 */
	public String getTasamora() {
		return tasamora;
	}

	/**
	 * Establece tasamora.
	 *
	 * @param tasamora the tasamora to set
	 */
	public void setTasamora(String tasamora) {
		this.tasamora = tasamora;
	}

	/**
	 * Obtiene fechainicio.
	 *
	 * @return the fechainicio
	 */
	public String getFechainicio() {
		return fechainicio;
	}

	/**
	 * Establece fechainicio.
	 *
	 * @param fechainicio the fechainicio to set
	 */
	public void setFechainicio(String fechainicio) {
		this.fechainicio = fechainicio;
	}

	/**
	 * Obtiene empresa.
	 *
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * Establece empresa.
	 *
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * Obtiene titulo.
	 *
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * Establece titulo.
	 *
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene calle.
	 *
	 * @return the calle
	 */
	public String getCalle() {
		return calle;
	}

	/**
	 * Establece calle.
	 *
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}

	/**
	 * Obtiene colonia.
	 *
	 * @return the colonia
	 */
	public String getColonia() {
		return colonia;
	}

	/**
	 * Establece colonia.
	 *
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}

	/**
	 * Obtiene ciudad.
	 *
	 * @return the ciudad
	 */
	public String getCiudad() {
		return ciudad;
	}

	/**
	 * Establece ciudad.
	 *
	 * @param ciudad the ciudad to set
	 */
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	/**
	 * Obtiene estado.
	 *
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Establece estado.
	 *
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
	 * Obtiene cp.
	 *
	 * @return the cp
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Establece cp.
	 *
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}

	/**
	 * Obtiene pagos.
	 *
	 * @return the pagos
	 */
	public String getPagos() {
		return pagos;
	}

	/**
	 * Establece pagos.
	 *
	 * @param pagos the pagos to set
	 */
	public void setPagos(String pagos) {
		this.pagos = pagos;
	}

	/**
	 * Obtiene tel.
	 *
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * Establece tel.
	 *
	 * @param tel the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}


	/**
	 * @return the amortizacion
	 */
	public List<PagoGrupo> getAmortizacion() {
		return amortizacion;
	}

	/**
	 * @param amortizacion the amortizacion to set
	 */
	public void setAmortizacion(List<PagoGrupo> amortizacion) {
		this.amortizacion = amortizacion;
	}

	/**
	 * @return the contratoLd
	 */
	public String getContratoLd() {
		return contratoLd;
	}

	/**
	 * @param contratoLd the contratoLd to set
	 */
	public void setContratoLd(String contratoLd) {
		this.contratoLd = contratoLd;
	}

	/**
	 * @return the pagosA
	 */
	public List getPagosA() {
		return pagosA;
	}

	/**
	 * @param pagosA the pagosA to set
	 */
	public void setPagosA(List pagosA) {
		this.pagosA = pagosA;
	}

	/**
	 * @return the pagosB
	 */
	public List getPagosB() {
		return pagosB;
	}

	/**
	 * @param pagosB the pagosB to set
	 */
	public void setPagosB(List pagosB) {
		this.pagosB = pagosB;
	}

	/**
	 * @return the avalesA
	 */
	public List getAvalesA() {
		return avalesA;
	}

	/**
	 * @param avalesA the avalesA to set
	 */
	public void setAvalesA(List avalesA) {
		this.avalesA = avalesA;
	}

	/**
	 * @return the avalesB
	 */
	public List getAvalesB() {
		return avalesB;
	}

	/**
	 * @param avalesB the avalesB to set
	 */
	public void setAvalesB(List avalesB) {
		this.avalesB = avalesB;
	}




	

	
}
