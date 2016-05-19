package cn.lawliex;

public class HelloProxy implements cn.lawliex.Hello {
  private String _endpoint = null;
  private cn.lawliex.Hello hello = null;
  
  public HelloProxy() {
    _initHelloProxy();
  }
  
  public HelloProxy(String endpoint) {
    _endpoint = endpoint;
    _initHelloProxy();
  }
  
  private void _initHelloProxy() {
    try {
      hello = (new cn.lawliex.HelloServiceLocator()).getHello();
      if (hello != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)hello)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (hello != null)
      ((javax.xml.rpc.Stub)hello)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.lawliex.Hello getHello() {
    if (hello == null)
      _initHelloProxy();
    return hello;
  }
  
  public java.lang.String getName(java.lang.String ans) throws java.rmi.RemoteException{
    if (hello == null)
      _initHelloProxy();
    return hello.getName(ans);
  }
  
  
}