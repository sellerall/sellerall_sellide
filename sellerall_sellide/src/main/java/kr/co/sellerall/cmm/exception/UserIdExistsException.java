package kr.co.sellerall.cmm.exception;

import kr.co.sellerall.cmm.enums.ErrorCode;

public class UserIdExistsException extends RegistrationException {

	public UserIdExistsException(String message, ErrorCode errorCode) {
		super(message, errorCode);
	}
}