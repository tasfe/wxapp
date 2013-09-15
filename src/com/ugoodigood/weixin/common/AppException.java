package com.ugoodigood.weixin.common;

/**
 * Exception for weixin app
 * 
 * @author meng@tofindaway.com
 * @version 0.0.1
 */
public class AppException extends RuntimeException {

	private static final long serialVersionUID = -1853569410898276870L;

	private int errCode = 0;

	private String errMessage = null;
	
	public AppException(int errCode) {
		this(errCode, null);
	}
	
	public AppException(int errCode, String errMessage) {
		this.errCode = errCode;
		this.errMessage = errMessage;
	}
	
	public int getErrCode() {
		return errCode;
	}
	
	public String getErrMessage() {
		if (errMessage != null) {
			return errMessage;
		} else {
			return getErrMessageFromCode(errCode);
		}
		
	}

	private String getErrMessageFromCode(int errCode2) {
		
		return "unknow error";
	}
	

}
