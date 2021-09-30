package kr.co.sellerall.cmm.domain.user.authenticate;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import kr.co.sellerall.cmm.component.JsonUtils;
import kr.co.sellerall.cmm.domain.user.Role;


public class AuthenticationFilter extends AbstractAuthenticationProcessingFilter {

	private static final Logger log = LoggerFactory.getLogger(AuthenticationFilter.class);
	
	public AuthenticationFilter() {
		super(new AntPathRequestMatcher("/api/authentications", "POST"));
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException {

		log.debug("Processing login request");

		String requestBody = IOUtils.toString(request.getReader());
		LoginRequest loginRequest = JsonUtils.toObject(requestBody, LoginRequest.class);
		if (loginRequest == null || loginRequest.isInvalid()) {
			throw new InsufficientAuthenticationException("Invalid authentication request");
		}
		
		UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(loginRequest.userId, loginRequest.userPwd);
		return this.getAuthenticationManager().authenticate(token);
	}

	static class LoginRequest {
		private String userId;
		private String userPwd;
		private String useYn;

		public boolean isInvalid() {
			return StringUtils.isBlank(userId) || StringUtils.isBlank(userPwd);
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserPwd() {
			return userPwd;
		}

		public void setUserPwd(String userPwd) {
			this.userPwd = userPwd;
		}
	}
}