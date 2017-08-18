/**
 * AfiliacionServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package mx.com.findep.crediseguros.webservice.finsol;

public class AfiliacionServiceLocator extends org.apache.axis.client.Service implements mx.com.findep.crediseguros.webservice.finsol.AfiliacionService {

    public AfiliacionServiceLocator() {
    }


    public AfiliacionServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AfiliacionServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for AfiliacionPort
    private java.lang.String AfiliacionPort_address = "http://10.169.249.158:7341/CredisegurosWS/AfiliacionService";

    public java.lang.String getAfiliacionPortAddress() {
        return AfiliacionPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AfiliacionPortWSDDServiceName = "AfiliacionPort";

    public java.lang.String getAfiliacionPortWSDDServiceName() {
        return AfiliacionPortWSDDServiceName;
    }

    public void setAfiliacionPortWSDDServiceName(java.lang.String name) {
        AfiliacionPortWSDDServiceName = name;
    }

    public mx.com.findep.crediseguros.webservice.finsol.Afiliacion getAfiliacionPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(AfiliacionPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAfiliacionPort(endpoint);
    }

    public mx.com.findep.crediseguros.webservice.finsol.Afiliacion getAfiliacionPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            mx.com.findep.crediseguros.webservice.finsol.AfiliacionPortBindingStub _stub = new mx.com.findep.crediseguros.webservice.finsol.AfiliacionPortBindingStub(portAddress, this);
            _stub.setPortName(getAfiliacionPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAfiliacionPortEndpointAddress(java.lang.String address) {
        AfiliacionPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (mx.com.findep.crediseguros.webservice.finsol.Afiliacion.class.isAssignableFrom(serviceEndpointInterface)) {
                mx.com.findep.crediseguros.webservice.finsol.AfiliacionPortBindingStub _stub = new mx.com.findep.crediseguros.webservice.finsol.AfiliacionPortBindingStub(new java.net.URL(AfiliacionPort_address), this);
                _stub.setPortName(getAfiliacionPortWSDDServiceName());
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
        if ("AfiliacionPort".equals(inputPortName)) {
            return getAfiliacionPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://finsol.webservice.crediseguros.findep.com.mx/", "AfiliacionService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://finsol.webservice.crediseguros.findep.com.mx/", "AfiliacionPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("AfiliacionPort".equals(portName)) {
            setAfiliacionPortEndpointAddress(address);
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
