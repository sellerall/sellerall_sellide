package kr.co.sellerall.cmm.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import kr.co.sellerall.cmm.enums.ErrorCode;
import lombok.Getter;

@Getter
/*@ResponseStatus(HttpStatus.BAD_REQUEST)*/
public class Ouath2NotExistRegistrationException extends RuntimeException{
	private ErrorCode errorCode;

	public Ouath2NotExistRegistrationException(String message, ErrorCode errorCode){
		super(message);
		this.errorCode = errorCode;
	}
	
	public Ouath2NotExistRegistrationException(String message) {
        super(message);
    }
    public Ouath2NotExistRegistrationException(String message, Throwable cause) {
        super(message, cause);
    }
}
