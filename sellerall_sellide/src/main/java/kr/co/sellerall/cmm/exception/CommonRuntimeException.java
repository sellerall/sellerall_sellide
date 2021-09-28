package kr.co.sellerall.cmm.exception;

import kr.co.sellerall.cmm.enums.ErrorCode;
import lombok.Getter;

@Getter
public class CommonRuntimeException extends RuntimeException {
	private ErrorCode errorCode;
	
	public CommonRuntimeException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}
}