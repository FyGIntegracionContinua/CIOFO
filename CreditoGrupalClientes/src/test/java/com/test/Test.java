package com.test;

import java.rmi.RemoteException;

import com.findep.credito.buro.dto.ObtenerXMLReporteCreditoRequest;
import com.findep.credito.buro.dto.ObtenerXMLReporteCreditoResponse;
import com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoProxy;
import com.findep.credito.buro.ws.fault.ServicioBuroCreditoFault;

public class Test {

	/**
	 * @param args
	 * @throws RemoteException 
	 * @throws ServicioBuroCreditoFault 
	 */
	public static void main(String[] args) throws ServicioBuroCreditoFault, RemoteException {
		// TODO Auto-generated method stub

		ServicioBuroCreditoProxy ws = new ServicioBuroCreditoProxy();
		ObtenerXMLReporteCreditoRequest request = new ObtenerXMLReporteCreditoRequest();				
		ObtenerXMLReporteCreditoResponse response = new ObtenerXMLReporteCreditoResponse();		
		request.setPersona("950463766");		
		response = ws.obtenerXMLReporteCredito(request);		

	}

}
