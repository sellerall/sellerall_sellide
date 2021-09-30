package kr.co.sellerall.cmm.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;

@Component
public class TokenChkInterceptor implements HandlerInterceptor{
	private static final Logger logger = LoggerFactory.getLogger(TokenChkInterceptor.class);

	@Override 
	public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, 
			final Object handler ) throws IOException, ModelAndViewDefiningException { 
		/*logger.debug("==================================================");
		logger.debug(request.getRequestURL().toString());
		logger.debug("==================================================");*/
		String reqUrl = null;
		HttpSession session = request.getSession();
		SessionUser loginVO = (SessionUser) session.getAttribute("user");
 
        if(ObjectUtils.isEmpty(loginVO)){
        	logger.debug("==================== Token Expiration =======================");
            response.sendRedirect("/login/login");
            return false;
        }else{
            session.setMaxInactiveInterval(30*60);
            return true;
        }
		
	}
}
