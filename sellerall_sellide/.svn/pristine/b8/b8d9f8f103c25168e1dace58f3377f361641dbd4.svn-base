package kr.co.sellerall.cmm.exception;

import kr.co.sellerall.cmm.enums.ErrorCode;
import lombok.Getter;

@Getter
public class RegistrationException extends Exception {
	private ErrorCode errorCode;
	
	public RegistrationException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}
}