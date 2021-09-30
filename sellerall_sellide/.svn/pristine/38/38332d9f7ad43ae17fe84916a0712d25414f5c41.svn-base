package kr.co.sellerall.cmm.domain.user.authenticate;


import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.JsonUtils;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.domain.user.TbUserInfoRepository;
import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;

@Service
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
	@Autowired
	private TbUserInfoRepository userRepository;
	@Autowired
	private HttpSession httpSession;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {
		WebAuthenticationDetails web = (WebAuthenticationDetails) authentication.getDetails();
		
		TbUserInfo user = user = userRepository.findByUserId(authentication.getName()).orElseThrow(()-> new CommonRuntimeException(ErrorCode.NOT_EXISTS_USER.getMessage(), ErrorCode.NOT_EXISTS_USER));

		userRepository.save(user.update(user.getUserName(), user.getUserPicture(), LocalDateTime.now()));
		httpSession.setAttribute("user", new SessionUser(user));
        
		response.setStatus(HttpStatus.OK.value());
		JsonUtils.write(response.getWriter(), ApiResult.message("authenticated"));
	}
}