package tarea.comun;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import utilitario.mensajes.impresiondocs.comun.ObjetosImpresionDocumentos;

public interface OFSResultAssembler {

	public void inicializaResultAssembler( Integer  numRegistros);
	
	
	/**
	 * @return the restricted
	 */
	public List<?> getRestricted();

	/**
	 * @param restricted the restricted to set
	 */
	public void setRestricted(List<?> restricted);

	public void addLine(Integer i);

	//ESTE METODO AGREGA EL NO BRE DE LOS CAMPOS DE LOS REGISTROS (HEADER)
	public void setTypeReturn(ObjetosImpresionDocumentos doc);

	// DEL OBJETO QUE RECIBE EXTRAE (POR REFLEXION)LOS VALORES  Y LOS AGREGA AL OFS, LES DA FORMATO A LOS QUE LO REQUIERAN
	public void addObject(Object obj, ObjetosImpresionDocumentos doc);

	public String getOFS();

	public Date parsearFecha(String fecha);

	public SimpleDateFormat obtenerFormato(String formato);

	public SimpleDateFormat obtenerFormatoLocal(String formato);

	public String formatoEstado(String estado);

	public String textoTipoTitulo(String cadena);

}