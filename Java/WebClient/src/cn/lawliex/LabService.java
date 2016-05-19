/**
 * LabService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.lawliex;

public interface LabService extends javax.xml.rpc.Service {
    public java.lang.String getLabAddress();

    public cn.lawliex.Lab getLab() throws javax.xml.rpc.ServiceException;

    public cn.lawliex.Lab getLab(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
