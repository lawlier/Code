/**
 * LabServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.lawliex;

public class LabServiceLocator extends org.apache.axis.client.Service implements cn.lawliex.LabService {

    public LabServiceLocator() {
    }


    public LabServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public LabServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Lab
    private java.lang.String Lab_address = "http://localhost:8080/Web/services/Lab";

    public java.lang.String getLabAddress() {
        return Lab_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String LabWSDDServiceName = "Lab";

    public java.lang.String getLabWSDDServiceName() {
        return LabWSDDServiceName;
    }

    public void setLabWSDDServiceName(java.lang.String name) {
        LabWSDDServiceName = name;
    }

    public cn.lawliex.Lab getLab() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Lab_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getLab(endpoint);
    }

    public cn.lawliex.Lab getLab(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.lawliex.LabSoapBindingStub _stub = new cn.lawliex.LabSoapBindingStub(portAddress, this);
            _stub.setPortName(getLabWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setLabEndpointAddress(java.lang.String address) {
        Lab_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.lawliex.Lab.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.lawliex.LabSoapBindingStub _stub = new cn.lawliex.LabSoapBindingStub(new java.net.URL(Lab_address), this);
                _stub.setPortName(getLabWSDDServiceName());
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
        if ("Lab".equals(inputPortName)) {
            return getLab();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://lawliex.cn", "LabService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://lawliex.cn", "Lab"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Lab".equals(portName)) {
            setLabEndpointAddress(address);
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
