package com.acxiom.handlerTest.AbstractHandler;

public class DT_PROD_Handler extends AbstractHandler {
	
	public DT_PROD_Handler(String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}
	
	@Override
	protected void write(String message) {
		System.out.println("DT PROD Handler::Logger: " + message);
	}
	
}
