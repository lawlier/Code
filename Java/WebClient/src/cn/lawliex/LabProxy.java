package cn.lawliex;

public class LabProxy implements cn.lawliex.Lab {
  private String _endpoint = null;
  private cn.lawliex.Lab lab = null;
  
  public LabProxy() {
    _initLabProxy();
  }
  
  public LabProxy(String endpoint) {
    _endpoint = endpoint;
    _initLabProxy();
  }
  
  private void _initLabProxy() {
    try {
      lab = (new cn.lawliex.LabServiceLocator()).getLab();
      if (lab != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)lab)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)lab)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (lab != null)
      ((javax.xml.rpc.Stub)lab)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.lawliex.Lab getLab() {
    if (lab == null)
      _initLabProxy();
    return lab;
  }
  
  public java.lang.String printHello(java.lang.String ans) throws java.rmi.RemoteException{
    if (lab == null)
      _initLabProxy();
    return lab.printHello(ans);
  }
  
  
}