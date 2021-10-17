package com.acxiom.handlerTest.AbstractHandler;

public class SINGLE_SOURCE_Handler extends AbstractHandler {
	
	public SINGLE_SOURCE_Handler(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("SINGLE SOURCE Handler::Logger: " + message);
	}
	
}
