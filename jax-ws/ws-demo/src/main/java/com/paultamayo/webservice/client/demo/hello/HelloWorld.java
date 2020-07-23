package com.paultamayo.webservice.client.demo.hello;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "HelloWorld", targetNamespace = HelloWorldImplService.TARGET_NAMESPACES)
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface HelloWorld {

	@WebMethod
	@WebResult(name = "return")
	String getHelloWorldAsString(@WebParam(name = "arg0") String canal, @WebParam(name = "arg1") String user);
}
