package com.acxiom.handlerTest.AbstractHandler;

public class SERVICE_Handler extends AbstractHandler {
	
	public SERVICE_Handler(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("SERVICE Handler::Logger: " + message);
	}
	
}
