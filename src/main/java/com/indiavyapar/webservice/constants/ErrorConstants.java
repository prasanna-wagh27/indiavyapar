package com.indiavyapar.webservice.constants;

public enum ErrorConstants {

	SUCCESS("200"),
	CREATED("201"),
	INVALID("300"),
	BAD_REQUEST("400"),
	UNAUTHORIZED("401"),
	FORBIDDEN("403"),
	NOT_FOUND("404"),
	INTERNAL_SERVER_ERROR("500")
	;
	
	private String displayName;
	
	ErrorConstants(String displayname){
		this.displayName = displayname;
	}
	
	@Override
	public String toString() { return displayName;}
	
}
