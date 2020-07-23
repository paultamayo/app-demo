package com.paultamayo.webservice.client.demo;

import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;

@WebServiceClient(name = "MdwServicesService", targetNamespace = MdwServicesImplService.TARGET_NAMESPACES, wsdlLocation = MdwServicesImplService.URL_WSDL)
public class MdwServicesImplService extends javax.xml.ws.Service {

	public static final String TARGET_NAMESPACES = "http://servicios.com";
	
	public static final String URL_WSDL = "http://192.168.122.252:8090/WsCanalesCoac/services/MdwServices?wsdl";
	
	public static URL loginWDSL = null;

	static {
		try {
			loginWDSL = new URL(URL_WSDL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MdwServicesImplService() {
		super(loginWDSL, new QName(TARGET_NAMESPACES, "MdwServicesService"));
	}

	protected MdwServicesImplService(URL wsdlDocumentLocation, QName serviceName) {
		super(wsdlDocumentLocation, serviceName);
	}

	@WebEndpoint(name = "MdwServices")
	public MdwServices getLogeoUsuarioImplPort() {
		MdwServices respuesta = getPort(new QName(TARGET_NAMESPACES, "MdwServices"), MdwServices.class);

		return respuesta;
	}
}
