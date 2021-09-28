package kr.co.sellerall.cmm.component;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;
import kr.co.sellerall.cmm.exception.Ouath2NotExistRegistrationException;
import kr.co.sellerall.cmm.vo.ErrorResponseVO;
import kr.co.sellerall.sys.exception.AccessDeniedException;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(Ouath2NotExistRegistrationException.class)
	public ResponseEntity<ErrorResponseVO> handleOuath2NotExistRegistrationException(Ouath2NotExistRegistrationException ex){
		log.error("handleOuath2NotExistRegistrationException",ex);
		ErrorResponseVO response = new ErrorResponseVO(ex.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
	}
	
	@ExceptionHandler(UserNotExistsException.class)
	public ResponseEntity<ErrorResponseVO> handleUserIdExistsException(UserNotExistsException ex){
		log.error("handleUserNotExistsException",ex);
		ErrorResponseVO response = new ErrorResponseVO(ex.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
	}
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponseVO> handleUserIdExistsException(AccessDeniedException ex){
		log.error("handleAccessDeniedException",ex);
		ErrorResponseVO response = new ErrorResponseVO(ex.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
	}
	
	@ExceptionHandler(CommonRuntimeException.class)
	public ResponseEntity<ErrorResponseVO> handleUserIdExistsException(CommonRuntimeException ex){
		log.error("handleCommonRuntimeException",ex);
		ErrorResponseVO response = new ErrorResponseVO(ex.getErrorCode());
		return new ResponseEntity<>(response, HttpStatus.valueOf(ex.getErrorCode().getStatus()));
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponseVO> handleException(Exception ex){
		log.error("handleException",ex);
		ErrorResponseVO response = new ErrorResponseVO(ErrorCode.INTER_SERVER_ERROR);
		response.setMessage(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
}
