package com.acxiom.handlerTest.AbstractHandler;

public abstract class AbstractHandler {
	
	protected String sourceSystem;
	protected AbstractHandler nextHandler;
	
	public void setNextHandler(AbstractHandler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	public void handleSourceSystem(String handler, String message) {
		
		System.out.println("handleSourceSystem handler is:" + handler);
		if (this.sourceSystem.equalsIgnoreCase(handler)) {
			write(message);
		}
		else if (nextHandler != null) {
			nextHandler.handleSourceSystem(handler, message);
		}
	}
	
	abstract protected void write(String message);

}
