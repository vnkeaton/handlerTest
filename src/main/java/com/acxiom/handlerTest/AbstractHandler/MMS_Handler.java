package com.acxiom.handlerTest.AbstractHandler;

public class MMS_Handler extends AbstractHandler {
	
	public MMS_Handler(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("MMS Handler::Logger: " + message);
	}
	
}
