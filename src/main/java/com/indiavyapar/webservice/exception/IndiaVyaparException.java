package com.indiavyapar.webservice.exception;

import java.io.Serializable;

public class IndiaVyaparException implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String errorCode;

	private String message;

	private String uniqueNo;

	public IndiaVyaparException(String errorCode, String message) {
		super();
		this.errorCode = errorCode;
		this.message = message;
	}

	public IndiaVyaparException(String errorCode, String message, String uniqueNo) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.uniqueNo = uniqueNo;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getUniqueNo() {
		return uniqueNo;
	}

	public void setUniqueNo(String uniqueNo) {
		this.uniqueNo = uniqueNo;
	}

}
