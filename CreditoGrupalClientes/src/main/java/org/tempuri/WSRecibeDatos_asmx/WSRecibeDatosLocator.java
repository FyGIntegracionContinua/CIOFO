/**
 * WSRecibeDatosLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.tempuri.WSRecibeDatos_asmx;

public class WSRecibeDatosLocator extends org.apache.axis.client.Service implements org.tempuri.WSRecibeDatos_asmx.WSRecibeDatos {

    public WSRecibeDatosLocator() {
    }


    public WSRecibeDatosLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public WSRecibeDatosLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for WSRecibeDatosSoap
    private java.lang.String WSRecibeDatosSoap_address = "http://169.169.7.171:7014/wsrecibedatos.asmx";

    public java.lang.String getWSRecibeDatosSoapAddress() {
        return WSRecibeDatosSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String WSRecibeDatosSoapWSDDServiceName = "WSRecibeDatosSoap";

    public java.lang.String getWSRecibeDatosSoapWSDDServiceName() {
        return WSRecibeDatosSoapWSDDServiceName;
    }

    public void setWSRecibeDatosSoapWSDDServiceName(java.lang.String name) {
        WSRecibeDatosSoapWSDDServiceName = name;
    }

    public org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoap getWSRecibeDatosSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(WSRecibeDatosSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getWSRecibeDatosSoap(endpoint);
    }

    public org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoap getWSRecibeDatosSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoapStub _stub = new org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoapStub(portAddress, this);
            _stub.setPortName(getWSRecibeDatosSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setWSRecibeDatosSoapEndpointAddress(java.lang.String address) {
        WSRecibeDatosSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoapStub _stub = new org.tempuri.WSRecibeDatos_asmx.WSRecibeDatosSoapStub(new java.net.URL(WSRecibeDatosSoap_address), this);
                _stub.setPortName(getWSRecibeDatosSoapWSDDServiceName());
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
        if ("WSRecibeDatosSoap".equals(inputPortName)) {
            return getWSRecibeDatosSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "WSRecibeDatos");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/WSRecibeDatos.asmx", "WSRecibeDatosSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("WSRecibeDatosSoap".equals(portName)) {
            setWSRecibeDatosSoapEndpointAddress(address);
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
