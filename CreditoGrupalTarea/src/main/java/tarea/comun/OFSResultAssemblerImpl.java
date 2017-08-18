package tarea.comun;

import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import utilitario.log.LogHandler;
import utilitario.mensajes.impresiondocs.comun.ObjetosImpresionDocumentos;

public class OFSResultAssemblerImpl implements OFSResultAssembler {

	private StringBuffer ofs;
//lista con los campos que restringir�
	private static final int LADA_MAS_CUERPO			=10;
	private static final int SOLO_CUERPO				=8;
	
	public OFSResultAssemblerImpl( ) {
		
	}
	
	private List<?> restricted = new ArrayList<Object>();

	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#getRestricted()
	 */
	
	public List<?> getRestricted() {
		return restricted;
	}

	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#setRestricted(java.util.List)
	 */
	
	public void setRestricted(List<?> restricted) {
		this.restricted = restricted;
	}

	
	
	public void inicializaResultAssembler(Integer numRegistros) {
		
		
		ofs = new StringBuffer(",NOFILE::NOFILE,\"" + numRegistros + "|");
		
	}
	
	
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#addLine(java.lang.Integer)
	 */
	
	public void addLine(Integer i) {
		ofs.append("\n");
		ofs.append(",NOFILE::NOFILE,\"" + i + "|");
	}
	String dia = null;
	String mes = null;
//ESTE METODO AGREGA EL NO BRE DE LOS CAMPOS DE LOS REGISTROS (HEADER)
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#setTypeReturn(utilitario.mensajes.impresiondocs.comun.ObjetosImpresionDocumentos)
	 */
	
	public void setTypeReturn(ObjetosImpresionDocumentos doc) {
		try {
			
			String [] params = doc.getOperacion().split("[,]");
			for(int i = 0; i < params.length; i++) {
				if(!restricted.contains(doc.getOperacion().split("[,]")[i])) {
					
					
					if(params[i].contains("$$")) {
						ofs.append(params[i].split("[$$]")[0]);
					} else {
						ofs.append(params[i]);
					}
					
					
					
					ofs.append("~");
					
				}
				
			}
			ofs.deleteCharAt(ofs.length() - 1);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		ofs.append("\"");
	}
	
	// DEL OBJETO QUE RECIBE EXTRAE (POR REFLEXION)LOS VALORES  Y LOS AGREGA AL OFS, LES DA FORMATO A LOS QUE LO REQUIERAN
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#addObject(java.lang.Object, utilitario.mensajes.impresiondocs.comun.ObjetosImpresionDocumentos)
	 */
	
	public void addObject(Object obj,ObjetosImpresionDocumentos doc) {
		ofs.append(",\"");
		try {
			String [] params = doc.getOperacion().split("[,]");
			
			for(int i = 0; i < params.length;i++) {
				int formatoEspecial = 0;
				boolean format = false;
				if(params[i].contains("$$")) {
					 formatoEspecial = Integer.parseInt(params[i].substring(params[i].indexOf("$$") + 2));
					 format = true;
				}
				params[i] = params[i].split("[$$]")[0];
				//para formar el nombre del metodo getXxx
				String method = "get" + Character.toUpperCase(params[i].charAt(0)) + params[i].substring(1); //RERESA getXxxxx
				//crear un metodo con la cadena obtenida
				Method miM = obj.getClass().getDeclaredMethod(method);
				//sino  se quizo evitar este parametro en la cadena de restringidos
				if (!restricted.contains(miM.getName().replace("get", "").toLowerCase())) {
					//String res = (String) miM.invoke(obj);
					String res = "" + miM.invoke(obj);
					if (res != null) {
						
						if(format) {
							try {
								// es un tipo de dato especial, quiz� fecha o numero, obtenemos su indice
								
								switch (formatoEspecial) {
								case 1:
									//fechas en formato "DD , dd , MM , yyyy"
									if(res == null || res.isEmpty()) {
										res = "";
									}
									String formDate = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
									dia = textoTipoTitulo(formDate.split("[.]")[0]);
									mes = textoTipoTitulo(formDate.split("[.]")[2]);
									res = dia + " " + formDate.split("[.]")[1] + " //43 " +mes + " //43 " + formDate.split("[.]")[3];
									res = res.replace(",", "//43")
									.replace("'", "//44")
									.replace("�", "//27")
									.replace("�", "//27");
									break;
								case 2:
									//fechas en formato "EEEE + dd + DEL MES DE + MMMM DEL A�O yyyy"
									String formDate2 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
									dia = textoTipoTitulo(formDate2.split("[.]")[0]);
									mes = textoTipoTitulo(formDate2.split("[.]")[2]);
									res = dia + "//43 " + formDate2.split("[.]")[1] + " de " +mes + " de " + formDate2.split("[.]")[3];
									res.toUpperCase();
									res = res.replace(",", "//43")
									.replace("'", "//44")
									.replace("�", "//27")
									.replace("�", "//27");
									break;
								case 3:
									//fechas en formato "dd/MM/yyyy"
									res = obtenerFormatoLocal("dd/MM/yyyy").format(parsearFecha(res));
									
									break;
								case 4:
									String formDate3 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
									res = formDate3.split("[.]")[1] + " DE " +formDate3.split("[.]")[2] + " DE " + formDate3.split("[.]")[3];
									res = res.replace(",", "//43")
									.replace("'", "//44")
									.replace("�", "//27")
									.replace("�", "//27");
									
									break;
								case 5:
									//fechas en formato "DD , dd , MM , yyyy"
									String formDate5 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
									dia = textoTipoTitulo(formDate5.split("[.]")[0]);
									mes = textoTipoTitulo(formDate5.split("[.]")[2]);
									res = dia + " //43 " + formDate5.split("[.]")[1] + " //43  " + mes + " //43 " + formDate5.split("[.]")[3];
									res = res
									.replace("'", "//44")
									.replace("�", "//27")
									.replace("�", "//27");
									break;
								case 6:
									if(res.equals(null) || res.isEmpty()) {
										res = "0,0";
									} else {
										if( !res.trim().equals( "0.00" ) )
										{
										NumberFormat formatter  = new DecimalFormat("#,###,###.00");
										res = formatter.format(Double.parseDouble(res));
										res = res.replace(",", "//43");
										}
									}
									break;
								case 7:
									if(res ==null || res.isEmpty()) {
										res = "";
									} else {
										String formDate7 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
										res = (formDate7.split("[.]")[1] ) + ( Integer.parseInt( formDate7.split("[.]")[1]  )  == 1 ? " DIA" : " DIAS" ) + 
											  " DEL MES DE " + formDate7.toUpperCase().split("[.]")[2] + " DEL " + formDate7.split("[.]")[3];
										res.toUpperCase();	
									}
									
									break;
								case 8:
									String formDate8 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
									res = (formDate8.split("[.]")[1] ) + ( Integer.parseInt( formDate8.split("[.]")[1]  )  == 1 ? " DIA" : " DIAS" ) + 
										  " DEL MES DE " + formDate8.toUpperCase().split("[.]")[2] + " DE " + formDate8.split("[.]")[3];
									res.toUpperCase();	
									break;
								case 9:
									res = res.replace("Semanal", "Semanas")
											.replace("Quincenal","Quincenas")
											.replace("Mensual","Meses")
											.replace("Catorcenal", "Catorcenas");	
									break;
								case 10:
									res = res.replace("D", "DIVORCIADO")
									.replace("S","SOLTERO")
									.replace("C","CASADO")
									.replace("V", "VIUDO")
									.replace("U", "UNION LIBRE");
									break;
								case 11:
									if(res ==null || res.isEmpty()) {
										res = "";
									}
									res = res.replace("S", "Semanal")
											.replace("Q","Quincenal")
											.replace("M","Mensual")
											.replace("C", "Catorcenal");
									break;
								case 12:
									/**
									 * Formato para los telefonos al tipo XX-XXXX-XXXX
									 */
									if(res ==null || res.isEmpty()) {
										res = "";
									}
									String lada ="";
									String cuerpo1 ="";
									String cuerpo2 ="";
									for (int j = 0; j < res.length(); j++) {
										if(res.length() == LADA_MAS_CUERPO) {
											if(j == 1) {
												lada = String.valueOf(res.charAt(0) + "" + res.charAt(1) + "-");
											} else if(j == 5) {
												cuerpo1 = String.valueOf(res.charAt(2) + "" + res.charAt(3) + res.charAt(4) + "" + res.charAt(5) + "-");
											} else if(j > 8) {
												cuerpo2 = String.valueOf(res.charAt(6) + "" + res.charAt(7) + res.charAt(8) + "" + res.charAt(9));
											}
										} else if(res.length() == SOLO_CUERPO) {
											if(j == 3) {
												cuerpo1 = String.valueOf(res.charAt(0) + "" + res.charAt(1) + res.charAt(2) + "" + res.charAt(3) + "-");
											} else if(j > 6) {
												cuerpo2 = String.valueOf(res.charAt(4) + "" + res.charAt(5) + res.charAt(6) + "" + res.charAt(7));
											}
										}
									} if(cuerpo1.isEmpty() || cuerpo1 ==null) {
										res = "";
									} else
									res = (lada + cuerpo1 + cuerpo2).trim();
									break;
								case 13:
								/**
								 * En los pagares se pide que se concatene la direccion formateada como cualquier texto y concatenarle la fecha actual.	
								 */
									if(res == null || res.isEmpty()) {
										res = "";
									}
									
									res = res.replace(",", "//43")
									.replace("'", "//44")
									.replace("�", "//26")
									.replace("�", "//27")
									.replace("�", "//28")
									.replace("�", "//29")
									.replace("�", "//30")
									.replace("�", "//41")
									.replace("�", "//42")
									.replace("�","//26")
									.replace("�","//27")
									.replace("�","//28")
									.replace("�","//29")
									.replace("�","//30")
									.replace("�","�");
									
									
									  String[] temp;
									  String delimiter = "\\|";
									  temp = res.split(delimiter);
									  String direccion = "";
									  String fecha = "";
									  for(int k =0; k < temp.length ; k++) {
									    direccion = temp[0];
									    fecha = temp[1];
									  }
									
									String formDate13 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(fecha));
									mes = textoTipoTitulo(formDate13.split("[.]")[2]).toUpperCase();
									res = "A LOS " + (formDate13.split("[.]")[1] ) + ( Integer.parseInt( formDate13.split("[.]")[1]  )  == 1 ? " DIA" : " DIAS" ) +
									     " DEL MES DE " + mes + " DE " + formDate13.split("[.]")[3];
									LogHandler.debug("", getClass(), "Respuesta" + res);
									res = direccion +"//43 " +res.replace(",", "//43");
									LogHandler.debug("", getClass(), "Respuesta Final" + res);

									break;
								case 14:			
									if(res ==null || res.isEmpty()) {
										res = "";
									}
										String formDate14 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
										dia = textoTipoTitulo(formDate14.split("[.]")[0]);
										mes = textoTipoTitulo(formDate14.split("[.]")[2]);
										res = dia + "//43 " + mes + " " + formDate14.split("[.]")[1] + "//43 " + formDate14.split("[.]")[3];
										res = res.replace(",", "//43")
										.replace("'", "//44")
										.replace("�", "//27")
										.replace("�", "//27");
									break;
								case 15:	
									if(res ==null || res.isEmpty()) {
										res = "";
									}
										String formDate15 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
										dia = textoTipoTitulo(formDate15.split("[.]")[0]);
										mes = textoTipoTitulo(formDate15.split("[.]")[2]);
										if(i != (params.length - 1)) {
											res = dia + "//43 " + mes + " " + formDate15.split("[.]")[1] + "//43 " + formDate15.split("[.]")[3];
										} else {
											res = dia + "//43 " + mes + " " + formDate15.split("[.]")[1] + "//43 " + formDate15.split("[.]")[3];
										}
										res = res.replace("'", "//44")
										.replace("�", "//27")
										.replace("�", "//27");
									break;
								case 16:
									if(res.equals(null) || res.isEmpty()) {
										res = "0,0";
									} else {
										NumberFormat formatter  = new DecimalFormat("#,###,###.00");
										res = formatter.format(Double.parseDouble(res)) + ",";
										res = res.replace(",", "//43");
									}
									break;
								case 17:
									String formDate7 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
									res = (formDate7.split("[.]")[1] ) + " DE " +formDate7.toUpperCase().split("[.]")[2] + " DEL " + formDate7.split("[.]")[3];
									res.toUpperCase();	
									break;

								case 18:
									res = res.replace("//43", ",")
									.replace("//27", "�");
									break;
									
								case 19:
									if(res.equals(null) || res.isEmpty()) {
										res = "0,0";
									} else {
										NumberFormat formatter  = new DecimalFormat("#,###,###.00000");
										res = formatter.format(Double.parseDouble(res));
										res = res.replace(",", "//43");
									}
									break;
								case 20:
									if(res ==null || res.isEmpty()) {
										res = "";
									} else {
										String formDate20 = obtenerFormatoLocal("EEEE.dd.MMMM.yyyy").format(parsearFecha(res));
										res = (formDate20.split("[.]")[1] ) +  " DEL MES DE " + 
										formDate20.toUpperCase().split("[.]")[2] + " DEL " + formDate20.split("[.]")[3];
										res.toUpperCase();	
									}
									break;
								case 21:
									if(res.equals(null) || res.isEmpty()) {
										res = "$0.0";
									} else {
										NumberFormat formatter  = new DecimalFormat("#,###,###.00");
										res = "$" + formatter.format(Double.parseDouble(res));
										res = res.replace(",", "//43");
									}
									break;
								}
								
								
								
							} catch (Exception e) {
								e.printStackTrace();
								//error en el campo
								res = "error";
							}
							
						} else {
							//es una cadena normal
							if(res ==null || res.isEmpty()) {
								res = "";
							} else {
								 res = res.replace("'", "//44")
								.replace("�", "//26")
								.replace("�", "//27")
								.replace("�", "//28")
								.replace("�", "//29")
								.replace("�", "//30")
								.replace("�", "//41")
								.replace("�", "//42")
								.replace(",", "//43");	
							}
						}
						ofs.append(res);
					}
					if(i != (params.length - 1)) { //si NO es el ultimo parametro se a�ade el caracter ~ como separador
						ofs.append("~");
					} else {
						ofs.append("");    //si es el ultimo parametro se a�ade el un espacio en blanco como separador
					}
				}
			}
		} catch (Throwable e) {
			e.printStackTrace();
		}
		ofs.append("\"");
	}
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#getOFS()
	 */
	
	public String getOFS() {
		return this.ofs.toString();
	}


	
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#parsearFecha(java.lang.String)
	 */
	
	public Date parsearFecha(String fecha) {
		try {
			SimpleDateFormat format2 =null;
			if(fecha.length() > 10) {
				format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
			} else {
				format2 = new SimpleDateFormat("yyyy-MM-dd");
			}
			
			Date date2;
			date2 = (Date)format2.parse(fecha);
			return date2;
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#obtenerFormato(java.lang.String)
	 */
	
	public SimpleDateFormat obtenerFormato(String formato) {
		
		return  new SimpleDateFormat(formato);
	}
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#obtenerFormatoLocal(java.lang.String)
	 */
	
	public SimpleDateFormat obtenerFormatoLocal(String formato) {
		return  new SimpleDateFormat(formato,new Locale("es","ES"));
	}
	
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#formatoEstado(java.lang.String)
	 */
	
	public String formatoEstado(String estado) {
		//Con este metodo completamos el nombre del estado ya q
		
		return estado;
	}
	
	/* (non-Javadoc)
	 * @see tarea.comun.OFSResultAssembler#textoTipoTitulo(java.lang.String)
	 */
	
	public String textoTipoTitulo(String cadena) {
		String cadenaConvertir = cadena;
		String resto = cadenaConvertir.substring(1);
		char letra = cadenaConvertir.charAt(0);
		letra = Character.toUpperCase(letra);
		return(Character.toString(letra) + resto);
	}

}
