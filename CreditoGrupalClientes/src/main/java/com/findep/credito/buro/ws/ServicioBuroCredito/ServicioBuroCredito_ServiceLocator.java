/**
 * ServicioBuroCredito_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.findep.credito.buro.ws.ServicioBuroCredito;

public class ServicioBuroCredito_ServiceLocator extends org.apache.axis.client.Service implements com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_Service {

    public ServicioBuroCredito_ServiceLocator() {
    }


    public ServicioBuroCredito_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioBuroCredito_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ServicioBuroCreditoSOAP
    private java.lang.String ServicioBuroCreditoSOAP_address = "http://10.1.50.73:7002/ServicioBuroCreditoWS/services/ServicioBuroCreditoSOAP";

    public java.lang.String getServicioBuroCreditoSOAPAddress() {
        return ServicioBuroCreditoSOAP_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ServicioBuroCreditoSOAPWSDDServiceName = "ServicioBuroCreditoSOAP";

    public java.lang.String getServicioBuroCreditoSOAPWSDDServiceName() {
        return ServicioBuroCreditoSOAPWSDDServiceName;
    }

    public void setServicioBuroCreditoSOAPWSDDServiceName(java.lang.String name) {
        ServicioBuroCreditoSOAPWSDDServiceName = name;
    }

    public com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_PortType getServicioBuroCreditoSOAP() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ServicioBuroCreditoSOAP_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getServicioBuroCreditoSOAP(endpoint);
    }

    public com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_PortType getServicioBuroCreditoSOAP(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoSOAPSoapBindingStub _stub = new com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoSOAPSoapBindingStub(portAddress, this);
            _stub.setPortName(getServicioBuroCreditoSOAPWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setServicioBuroCreditoSOAPEndpointAddress(java.lang.String address) {
        ServicioBuroCreditoSOAP_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCredito_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoSOAPSoapBindingStub _stub = new com.findep.credito.buro.ws.ServicioBuroCredito.ServicioBuroCreditoSOAPSoapBindingStub(new java.net.URL(ServicioBuroCreditoSOAP_address), this);
                _stub.setPortName(getServicioBuroCreditoSOAPWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ServicioBuroCreditoSOAP".equals(inputPortName)) {
            return getServicioBuroCreditoSOAP();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.buro.credito.findep.com/ServicioBuroCredito/", "ServicioBuroCredito");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.buro.credito.findep.com/ServicioBuroCredito/", "ServicioBuroCreditoSOAP"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ServicioBuroCreditoSOAP".equals(portName)) {
            setServicioBuroCreditoSOAPEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
