package com.paultamayo.webservice.client.demo;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService(name = "MdwServices", targetNamespace = MdwServicesImplService.TARGET_NAMESPACES)
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface MdwServices {

	@WebMethod
	@WebResult(name = "logeoUsuarioReturn")
	String logeoUsuario(@WebParam(name = "strCanal") String canal, @WebParam(name = "strUser") String user,
			@WebParam(name = "strPwd") String password);
}
