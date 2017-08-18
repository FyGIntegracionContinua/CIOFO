/**
 * DepositosGarantiaWS_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.depositosgarantia.ws;

public class DepositosGarantiaWS_ServiceLocator extends org.apache.axis.client.Service implements mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_Service {

    public DepositosGarantiaWS_ServiceLocator() {
    }


    public DepositosGarantiaWS_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DepositosGarantiaWS_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for DepositosGarantiaWSPort
    private java.lang.String DepositosGarantiaWSPort_address = "http://localhost:7001/DepositosGarantia/DepositosGarantiaWS";

    public java.lang.String getDepositosGarantiaWSPortAddress() {
        return DepositosGarantiaWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String DepositosGarantiaWSPortWSDDServiceName = "DepositosGarantiaWSPort";

    public java.lang.String getDepositosGarantiaWSPortWSDDServiceName() {
        return DepositosGarantiaWSPortWSDDServiceName;
    }

    public void setDepositosGarantiaWSPortWSDDServiceName(java.lang.String name) {
        DepositosGarantiaWSPortWSDDServiceName = name;
    }

    public mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_PortType getDepositosGarantiaWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(DepositosGarantiaWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getDepositosGarantiaWSPort(endpoint);
    }

    public mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_PortType getDepositosGarantiaWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.com.findep.depositosgarantia.ws.DepositosGarantiaWSPortBindingStub _stub = new mx.com.findep.depositosgarantia.ws.DepositosGarantiaWSPortBindingStub(portAddress, this);
            _stub.setPortName(getDepositosGarantiaWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setDepositosGarantiaWSPortEndpointAddress(java.lang.String address) {
        DepositosGarantiaWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.com.findep.depositosgarantia.ws.DepositosGarantiaWS_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.com.findep.depositosgarantia.ws.DepositosGarantiaWSPortBindingStub _stub = new mx.com.findep.depositosgarantia.ws.DepositosGarantiaWSPortBindingStub(new java.net.URL(DepositosGarantiaWSPort_address), this);
                _stub.setPortName(getDepositosGarantiaWSPortWSDDServiceName());
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
        if ("DepositosGarantiaWSPort".equals(inputPortName)) {
            return getDepositosGarantiaWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "DepositosGarantiaWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.depositosgarantia.findep.com.mx/", "DepositosGarantiaWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("DepositosGarantiaWSPort".equals(portName)) {
            setDepositosGarantiaWSPortEndpointAddress(address);
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
