/**
 * CalculoCostoSeguroServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.crediseguros.webservice.finsol;

public class CalculoCostoSeguroServiceLocator extends org.apache.axis.client.Service implements mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroService {

    public CalculoCostoSeguroServiceLocator() {
    }


    public CalculoCostoSeguroServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CalculoCostoSeguroServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalculoCostoSeguroPort
    private java.lang.String CalculoCostoSeguroPort_address = "http://10.169.249.158:7341/CredisegurosWS/CalculoCostoSeguroService";

    public java.lang.String getCalculoCostoSeguroPortAddress() {
        return CalculoCostoSeguroPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalculoCostoSeguroPortWSDDServiceName = "CalculoCostoSeguroPort";

    public java.lang.String getCalculoCostoSeguroPortWSDDServiceName() {
        return CalculoCostoSeguroPortWSDDServiceName;
    }

    public void setCalculoCostoSeguroPortWSDDServiceName(java.lang.String name) {
        CalculoCostoSeguroPortWSDDServiceName = name;
    }

    public mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguro getCalculoCostoSeguroPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalculoCostoSeguroPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalculoCostoSeguroPort(endpoint);
    }

    public mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguro getCalculoCostoSeguroPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroPortBindingStub _stub = new mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroPortBindingStub(portAddress, this);
            _stub.setPortName(getCalculoCostoSeguroPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalculoCostoSeguroPortEndpointAddress(java.lang.String address) {
        CalculoCostoSeguroPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguro.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroPortBindingStub _stub = new mx.com.findep.crediseguros.webservice.finsol.CalculoCostoSeguroPortBindingStub(new java.net.URL(CalculoCostoSeguroPort_address), this);
                _stub.setPortName(getCalculoCostoSeguroPortWSDDServiceName());
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
        if ("CalculoCostoSeguroPort".equals(inputPortName)) {
            return getCalculoCostoSeguroPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://finsol.webservice.crediseguros.findep.com.mx/", "CalculoCostoSeguroService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://finsol.webservice.crediseguros.findep.com.mx/", "CalculoCostoSeguroPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalculoCostoSeguroPort".equals(portName)) {
            setCalculoCostoSeguroPortEndpointAddress(address);
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
