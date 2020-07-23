package com.paultamayo.webservice.client.demo.hello;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

@WebServiceClient(name = "HelloWorldImplService", targetNamespace = HelloWorldImplService.TARGET_NAMESPACES, wsdlLocation = HelloWorldImplService.URL_WSDL)
public class HelloWorldImplService extends javax.xml.ws.Service {

	public static final String TARGET_NAMESPACES = "http://ws.mkyong.com/";
	
	public static final String URL_WSDL = "http://localhost:9999/ws/hello?wsdl";
	
	public static URL loginWDSL = null;

	static {
		try {
			loginWDSL = new URL(URL_WSDL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public HelloWorldImplService() {
		super(loginWDSL, new QName(TARGET_NAMESPACES, "HelloWorldImplService"));
	}

	protected HelloWorldImplService(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
	}

	@WebEndpoint(name = "HelloWorldImplPort")
	public HelloWorld getLogeoUsuarioImplPort() {
		HelloWorld respuesta = getPort(new QName(TARGET_NAMESPACES, "HelloWorldImplPort"), HelloWorld.class);

		return respuesta;
	}
}
