package com.paultamayo.webservice.client.demo.hello;

public class Main {

	public static void main(String[] args) {
		HelloWorldImplService serviceImpl = new HelloWorldImplService();
		HelloWorld service = serviceImpl.getLogeoUsuarioImplPort();

		System.out.println(service.getHelloWorldAsString("CANAL", "176"));
	}

}
