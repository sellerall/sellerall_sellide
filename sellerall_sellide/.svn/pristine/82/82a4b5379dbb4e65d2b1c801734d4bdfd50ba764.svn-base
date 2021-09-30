package kr.co.sellerall.cmm.component;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import kr.co.sellerall.cmm.domain.user.TbUserInfo;

@Component
public class WebAccessDeniedHandler implements AccessDeniedHandler{
	private static final Logger logger = LoggerFactory.getLogger(WebAccessDeniedHandler.class);
	
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException, ServletException {
		
		response.setStatus(HttpStatus.FORBIDDEN.value());
		
		if(accessDeniedException instanceof AccessDeniedException) {
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			logger.debug("객체 타입 확인 : "+ (authentication.getPrincipal() instanceof TbUserInfo));
			logger.debug("객체 타입 확인 : "+ (authentication.getPrincipal() instanceof TbUserInfo));
			logger.debug("객체 널 확인 : "+ (authentication ==null));
			
			if(authentication != null ) {
				request.setAttribute("message","접근 권한 없는 사용자 입니다.");
				request.setAttribute("nextPage", "/");
				response.setStatus(HttpStatus.UNAUTHORIZED.value());
			}
		}else {
			logger.debug(accessDeniedException.getClass().getCanonicalName());
		}
		request.getRequestDispatcher("/error/denied-page").forward(request, response);
	}

	
}
