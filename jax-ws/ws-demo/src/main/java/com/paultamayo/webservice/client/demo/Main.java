package com.paultamayo.webservice.client.demo;

public class Main {

	public static void main(String[] args) {
		MdwServicesImplService serviceImpl = new MdwServicesImplService();
		MdwServices service = serviceImpl.getLogeoUsuarioImplPort();

		System.out.println(service.logeoUsuario("CANAL", "176", "CoopD@qu1l3m@"));
	}

}
