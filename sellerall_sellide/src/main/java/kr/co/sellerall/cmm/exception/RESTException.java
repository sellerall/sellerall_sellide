package kr.co.sellerall.cmm.exception;


/**
 * @packageName   : kr.co.sellerall.cmm.exception
 * @fileName      : RESTException.java
 * @author        : YoungHun Yun
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yun      최초생성
 *
 */
public class RESTException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private int statusCode = -1;

	public RESTException() {
	}

	public RESTException(String message) {
		super(message);
	}

	public RESTException(String message, Throwable cause) {
		super(message, cause);
	}

	public RESTException(Throwable cause) {
		super(cause);
	}

	public RESTException(int statusCode, String message) {
		super(message);
		this.statusCode = statusCode;
	}

	public int getStatusCode() {
		return this.statusCode;
	}
}