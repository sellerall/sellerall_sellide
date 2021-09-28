package kr.co.sellerall.cmm.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sellerall.cmm.enums.ErrorCode;

@Controller 
public class CustomErrorController implements ErrorController { 
	private static final Logger logger = LoggerFactory.getLogger(CustomErrorController.class);
	private String VIEW_PATH = "/error/"; 
	
	@RequestMapping(value = "/error") 
	public String handleError(HttpServletRequest request) { 
		logger.debug("에러 컨트롤러");
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE); 
		if(status != null){ 
			int statusCode = Integer.valueOf(status.toString());
			//logger.debug("에러 코드 :" + statusCode);
			if(statusCode == HttpStatus.NOT_FOUND.value()){ 
				return VIEW_PATH + "pageNotFoundError"; 
			} 
			if(statusCode == HttpStatus.FORBIDDEN.value()){ 
				return VIEW_PATH + "defalutError"; 
			} 
			if(statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()){ 
				return VIEW_PATH + "defalutError"; 
			}
			if(statusCode == ErrorCode.NOT_EXISTS_USER.getStatus()){ 
				return "views/login/login"; 
			}
		} 
		
	return "error"; 
	} 
	
	@RequestMapping(value = "/error/denied-page") 
		public String accessDeniedError(HttpServletRequest request) { 
		
		logger.debug("엑세스 디나이드 컨트롤러");
		return "/error/accessDeniedError"; 
	} 					
	
}
