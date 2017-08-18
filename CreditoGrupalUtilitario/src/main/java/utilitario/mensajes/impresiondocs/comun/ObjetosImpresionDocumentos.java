package utilitario.mensajes.impresiondocs.comun;
/** cada  objeto tiene una lista de campos , estas constantes especifican
  */
/**
 * @author mi.mejorada
 *
 */
public enum ObjetosImpresionDocumentos {

	//CONTRATO COMUNALES
	/**
	 * MIEMBRO_GRUPO ObjetosImpresionDocumentos
	 */
	MIEMBRO_GRUPO("grupo,nummiembro,cliente,callecte,coloniacte,ciudadcte,estadocte,cpcte,tipoid,idnum,edocivil,ocupacion,"
	 + "capitalcte$$6,imptecte$$6,numcheque,montofin,montoreal,nombrec,rfc,tel$$12,fnacimiento$$3,sexo,codigocte,persona"),
	/**
	 * CONTRATO ObjetosImpresionDocumentos
	 */
	CONTRATO("grupo,contratoLD,nombregpo,importe$$6,impteletras,tasa,plazo,fechavto$$14,imptepago$$6,imptepagoletra,"
	 + "imptepagored$$6,imptepagoletrared,presidente,tesorero,secretario,ciclogpo,ejecutivo,gtesucursal,dirsucursal,"
	 + "cdadfirma,fechafirma$$8,nombres,tipocont,NombreApoderado,NoEscritura,FechaEscritura$$17,Supervisor,Periodo,"
	 + "Periodicidad$$9,nombres2,nombres3,nombres4,cat,branchcode,finicio$$3,ffin$$3"),
	/**
	 * PAGO ObjetosImpresionDocumentos
	 */
	PAGO("numpago,capital$$6,interes$$6,imptepago$$6,imptepagored$$6,fechapago$$15"),

	//FICHAS
	/**
	 * FICHA_PAGO ObjetosImpresionDocumentos
	 */
	FICHA_PAGO("cliente,nombre,tipo,ciclo,numpago,sucursal,fechapago$$3,contrato,contbcmer,contbanmx,imptepago$$6,"
	+			"imptepagored$$6,intemoratorio$$19,ld,frecuencia$$11,conthsbc"),
	/**
	 * FICHA_PAGO_ESPECIAL ObjetosImpresionDocumentos
	 */
FICHA_PAGO_ESPECIAL("cliente,nombre,tipo,ciclo,numpago,sucursal,contrato,contbcmer,contbanmx,imptepago$$6,imptepagored$$6,"
	+ "intemoratorio,ld,frecuencia$$11,fechainicio$$3,tasa,cantidadauto,diasreales,interespagado,saldocapital,"
	+ "interesmora,recargos,interesdevengados,totalpagar$$6,workingbalance,fechafin$$3,conthsbc"),

	//PAGARE COMUNALES
	/**
	 * AVAL ObjetosImpresionDocumentos
	 */
	AVAL("cliente,titaval,numaval,nomaval,calleaval,coloniaaval,ciudadaval,estadoaval,cpaval,tel$$12"),
	/**
	 * MIEMBRO_PAGARE ObjetosImpresionDocumentos
	 */
	MIEMBRO_PAGARE ("cliente,importe$$6,impteletra,tasa$$6,periodo$$11,ctabanco,dirsucursal,tasamora,fechainicio$$13,"
	+			"empresa,titulo,nombre,calle,colonia,ciudad,estado,cp,pagos$$6,tel$$12"),
	/**
	 * PAGO_AMORTIZACION ObjetosImpresionDocumentos
	 */
	PAGO_AMORTIZACION("cliente,numpago,fechapago$$2,imptepago,imptepagored,capital,interes,sdo"),

	//CONTRATO COMUNAL FINANCIADO
	/**
	 * CONTRATO_FIN ObjetosImpresionDocumentos
	 */
	CONTRATO_FIN("grupo,contratoLD,nombregpo,importe$$6,impteletras,tasa,plazo,fechavto$$14,imptepago$$6,imptepagoletra,"
	+ "imptepagored$$6,imptepagoletrared,presidente,tesorero,secretario,ciclogpo,ejecutivo,gtesucursal,dirsucursal,"
	+ "cdadfirma,fechafirma$$8,nombres,tipocont,NombreApoderado,NoEscritura,FechaEscritura$$17,Supervisor,Periodo,"
	+ "Periodicidad$$9,nombres2,nombres3,nombres4,cat,sucursal,branchcode,finicio$$3,ffin$$3"),
	/**
	 * MIEMBRO_GRUPO_FIN ObjetosImpresionDocumentos
	 */
MIEMBRO_GRUPO_FIN("grupo,nummiembro,cliente,callecte,coloniacte,ciudadcte,estadocte,cpcte,tipoid,idnum,edocivil,ocupacion,"
	+ "capitalcte$$6,imptecte$$6,numcheque,montofin$$6,montoreal$$6,nombrec,rfc,tel$$12,montofinletra,fecha,numvale,"
	+ "nocliente,fnacimiento$$3,sexo,codigocte,persona"),
	//El de pago es el mismo que el comunal normal
	/**
	 * MIEMBRO_GRUPO_ANT ObjetosImpresionDocumentos
	 */
	MIEMBRO_GRUPO_ANT("NoIndice,nombre,montochequeovale$$6,montovalecredito$$6,capintereses$$6,fecha$$20,cantidad$$21,"
	+ "cantidadletra,ldanterior,pagares,tasa$$6,semanas,ciclo,direccion,noamort,sdocapital$$6,sdointeres$$6,"
	+ "sdototal$$6,capminteres$$6,chequeovale,valecredito"),

	/**
	 * CONTRATO OPORTUNIDAD
	 */
	CONTRATO_OPORTUNIDAD_DATOS_GRUPO("grupo,contratoLD,nombregpo,importe$$6,impteletras,tasa,plazo,fechavto$$14,imptepago$$6,"
	 + "imptepagoletra,imptepagored$$6,"
	 + "imptepagoletrared,presidente,tesorero,secretario,ciclogpo,ejecutivo,gtesucursal,dirsucursal,cdadfirma,fechafirma$$8,"
	 + "nombres,nombresava,"
	+ "tipocont,NombreApoderado,NoEscritura,FechaEscritura$$17,Supervisor,Periodo,Periodicidad$$9,renovacion,cat,branchcode"),

	/**
	 * CONTRATO_OPORTUNIDAD_DATOS_MIEMBROS ObjetosImpresionDocumentos
	 */
	CONTRATO_OPORTUNIDAD_DATOS_MIEMBROS("grupo,nummiembro,cliente,callecte,coloniacte,ciudadcte,estadocte,cpcte,tipoid,idnum,"
	 +		"edocivil,ocupacion,"
	 +		"capitalcte$$6,imptecte$$6,numcheque,montofin,montoreal"),

	/**
	 * CONTRATO_OPORTUNIDAD_DATOS_PAGOS ObjetosImpresionDocumentos
	 */
	CONTRATO_OPORTUNIDAD_DATOS_PAGOS("numpago,capital$$6,interes$$6,imptepago$$6,imptepagored$$6,fechapago$$15"),
	/**
	 * CONTRATO_OPORTUNIDAD_NOMBRES_CLIENTES ObjetosImpresionDocumentos
	 */
	CONTRATO_OPORTUNIDAD_NOMBRES_CLIENTES("nombre"),

	/**
	 * CONTRATO SOLIDARIO
	 */
	CONTRATO_SOLIDARIO_DATOS_MIEMBROS("grupo,nummiembro,cliente,callecte,coloniacte,ciudadcte,estadocte,cpcte,"
	 +		"tipoid,idnum,edocivil,ocupacion,"
	 +		"capitalcte$$6,imptecte$$6,numcheque,montofin,montoreal$$6,fnacimiento$$3,sexo,codigocte,rfc,tel$$12,persona"),

	/**
	 * CONTRATO_SOLIDARIO_DATOS_GRUPO ObjetosImpresionDocumentos
	 */
	CONTRATO_SOLIDARIO_DATOS_GRUPO("grupo,contratoLD,nombregpo,importe$$6,impteletras,tasa,plazo,fechavto$$14,"
	+ "imptepago$$6,imptepagoletra,imptepagored$$6,"
	+ "imptepagoletrared,presidente,tesorero,secretario,ciclogpo,ejecutivo,gtesucursal,dirsucursal,cdadfirma,"
	+ "fechafirma$$8,nombres,tipocont,"
	+ "NombreApoderado,NoEscritura,FechaEscritura$$8,Supervisor,Periodo,Periodicidad$$9,renovacion,cat,branchcode,"
	+ "finicio$$3,ffin$$3"),

	/**
	 * SOLIDARIO FINANCIADO
	 */
	//PLANILLA DE APROBACION
	/**
	 * PLANILLA_APROBACION ObjetosImpresionDocumentos
	 */
	PLANILLA_APROBACION("Producto,FechaInicio,FechaTermino,Sucursal,Asesor,GrupoID,Grupo,MontoAprobado,Ciclo,ClienteID,"
	 + "Cliente,MntSolicitadoActual,Fecha,DestinoCreditoActual,CuotaSemanalActual,Tasa,Plazo,TotalInteres,TotalPagar,"
	 + "Presidente,Tesorero,Secretario,Supervisor,DirSucursal");
	//PLANILLA_APROBACION("Producto,FechaInicio,FechaTermino,Sucursal,Asesor,GrupoID,Grupo,MontAprobado,Ciclo,ClienteID,
	//Cliente,Fecha,DestinoCreditoActual,Tasa,Plazo,Presidente,Tesorero,Secretario,Supervisor,DirSucursal");

	/**
	 * ObjetosImpresionDocumentos
	 * @param a :
	 */
	private ObjetosImpresionDocumentos(String a) {
		this.operacion = a;
	}

	/**
	 * operacion String
	 */
	private String operacion;

	/**
	 * @return the operacion
	 */
	public String getOperacion() {
		return operacion;
	}

}
