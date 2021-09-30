package kr.co.sellerall.sys.exception;

import kr.co.sellerall.cmm.enums.ErrorCode;
import lombok.Getter;

@Getter
public class AccessDeniedException extends Exception {
	private ErrorCode errorCode;
	
	public AccessDeniedException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}

}
