package com.acxiom.handlerTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.acxiom.handlerTest.AbstractHandler.AbstractHandler;
import com.acxiom.handlerTest.AbstractHandler.DT_PROD_Handler;
import com.acxiom.handlerTest.AbstractHandler.MMS_Handler;
import com.acxiom.handlerTest.AbstractHandler.SERVICE_Handler;
import com.acxiom.handlerTest.AbstractHandler.SINGLE_SOURCE_Handler;
import com.acxiom.handlerTest.AbstractHandler.SourceSystemHandlerType;

@SpringBootApplication
public class HandlerTestApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(HandlerTestApplication.class, args);
	    
		AbstractHandler handlerChain = getChainOfHandlers();
		System.out.println("sending dt-prod");
		handlerChain.handleSourceSystem("DT_PROD", "This is a DT-PROD source system");
		
		System.out.println("sending viki");
		handlerChain.handleSourceSystem("viki", "This is the else and it is a SINGLE SOURCE.");
		
		System.out.println("sending mms");
		handlerChain.handleSourceSystem("MMS", "This is a MMS.");
		
		System.out.println("sending joe");
		handlerChain.handleSourceSystem("joe", "This is the else and it is a SINGLE SOURCE.");
		
		System.out.println("sending service");
		handlerChain.handleSourceSystem("Service", "This is a SERVICE.");
		
		System.out.println("sending foobar");
		handlerChain.handleSourceSystem("foobar", "This is the else and it is a SINGLE SOURCE.");
	}
	
	private static AbstractHandler getChainOfHandlers(){

		System.out.println("set up chain of handlers");
		AbstractHandler dt_prod_Handler = new DT_PROD_Handler(SourceSystemHandlerType.DT_PROD.name());
		AbstractHandler mms_Handler = new MMS_Handler(SourceSystemHandlerType.MMS.name());
		AbstractHandler service_Handler = new SERVICE_Handler(SourceSystemHandlerType.SERVICE.name());
		AbstractHandler single_source_Handler = new SINGLE_SOURCE_Handler(SourceSystemHandlerType.SINGLE_SOURCE.name());

		dt_prod_Handler.setNextHandler(mms_Handler);
		mms_Handler.setNextHandler(service_Handler);
		service_Handler.setNextHandler(single_source_Handler);
		single_source_Handler.setNextHandler(null);

	    return dt_prod_Handler;//start at dt-prod	
	}

}
