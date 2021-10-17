package com.acxiom.handlerTest.AbstractHandler;

import java.util.EnumSet;

public enum SourceSystemHandlerType {
	
    DT_PROD{
		@Override
		public String getSourceSystemName() { return "DT_PROD"; }
	},
    MMS{
		@Override
		public String getSourceSystemName() { return "MMS"; }
	},
    SERVICE{
		@Override
		public String getSourceSystemName() { return "Service"; }
	},
	SINGLE_SOURCE{//this is the default currently
	    @Override
	    public String getSourceSystemName() { return "SINGLE-SOURCE"; }
    };
    
	public abstract String getSourceSystemName();
	
	public static SourceSystemHandlerType parseFromString(String value){
		System.out.println("SourceSystemHandlerType value is: " + value);
		
		for(SourceSystemHandlerType handlerType : EnumSet.allOf(SourceSystemHandlerType.class)){
			if(value.equalsIgnoreCase(handlerType.getSourceSystemName())){
				System.out.println("SourceSystemHandlerType handlerType is: " + handlerType.name());
				return handlerType;
			}
		}
		System.out.println("SourceSystemHandlerType returning single source");
		return SINGLE_SOURCE;//this is the default currently
	}
	
}
