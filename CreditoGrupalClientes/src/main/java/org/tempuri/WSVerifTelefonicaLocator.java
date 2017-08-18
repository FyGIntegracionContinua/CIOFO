/**
 * WSVerifTelefonicaLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri;

public class WSVerifTelefonicaLocator extends org.apache.axis.client.Service implements org.tempuri.WSVerifTelefonica {

    public WSVerifTelefonicaLocator() {
    }


    public WSVerifTelefonicaLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSVerifTelefonicaLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSVerifTelefonicaSoap
    private java.lang.String WSVerifTelefonicaSoap_address = "http://169.169.4.42:81/WSVerifTelefonica.asmx";

    public java.lang.String getWSVerifTelefonicaSoapAddress() {
        return WSVerifTelefonicaSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSVerifTelefonicaSoapWSDDServiceName = "WSVerifTelefonicaSoap";

    public java.lang.String getWSVerifTelefonicaSoapWSDDServiceName() {
        return WSVerifTelefonicaSoapWSDDServiceName;
    }

    public void setWSVerifTelefonicaSoapWSDDServiceName(java.lang.String name) {
        WSVerifTelefonicaSoapWSDDServiceName = name;
    }

    public org.tempuri.WSVerifTelefonicaSoap getWSVerifTelefonicaSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSVerifTelefonicaSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSVerifTelefonicaSoap(endpoint);
    }

    public org.tempuri.WSVerifTelefonicaSoap getWSVerifTelefonicaSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.WSVerifTelefonicaSoapStub _stub = new org.tempuri.WSVerifTelefonicaSoapStub(portAddress, this);
            _stub.setPortName(getWSVerifTelefonicaSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSVerifTelefonicaSoapEndpointAddress(java.lang.String address) {
        WSVerifTelefonicaSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.WSVerifTelefonicaSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.WSVerifTelefonicaSoapStub _stub = new org.tempuri.WSVerifTelefonicaSoapStub(new java.net.URL(WSVerifTelefonicaSoap_address), this);
                _stub.setPortName(getWSVerifTelefonicaSoapWSDDServiceName());
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
        if ("WSVerifTelefonicaSoap".equals(inputPortName)) {
            return getWSVerifTelefonicaSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "WSVerifTelefonica");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "WSVerifTelefonicaSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSVerifTelefonicaSoap".equals(portName)) {
            setWSVerifTelefonicaSoapEndpointAddress(address);
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
