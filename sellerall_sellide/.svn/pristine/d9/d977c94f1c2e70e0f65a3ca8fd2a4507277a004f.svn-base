package kr.co.sellerall.cmm.config.auth;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import kr.co.sellerall.cmm.domain.user.TbAuthInfo;
import kr.co.sellerall.cmm.domain.user.TbAuthInfoRepository;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.domain.user.TbUserInfoRepository;


/**
 * @packageName   : kr.co.sellerall.cmm.config.auth
 * @fileName      : AuthorizationChecker.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17
 * @description   :  요청한 USER의 권한이 해당 URL에 접근 가능한 권한을 가지고 있는지 판단하는  확인 메소드 (DB access 부하로 인해 현재 사용안함. 
 * 					추후  Cache Abstraction을 이용하여 개선 예정 )
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */
/*
@Component
public class AuthorizationChecker {
	@Autowired
	private TbAuthInfoRepository tbAuthInfoRepository;

	@Autowired
	private TbUserInfoRepository tbUserInfoRepository;

	public boolean check(HttpServletRequest request, Authentication authentication) {
		Object principalObj = authentication.getPrincipal();

		if (!(principalObj instanceof TbUserInfo)) {
			return false;
		}

		String authority = null;
		for (TbAuthInfo matcher : tbAuthInfoRepository.findAll()) {
			if (new AntPathMatcher().match(matcher.getUrl(), request.getRequestURI())) {
				authority = matcher.getHasAuthority();
				break;
			}
		}

		String userId = ((TbUserInfo) authentication.getPrincipal()).getUserId();
		TbUserInfo loggedUser = tbUserInfoRepository.findByUserId(userId).orElseThrow(()-> new IllegalArgumentException("해당 ID 없습니다."));

		List<String> authorities = loggedUser.getRole();

		if (authority == null || !authorities.contains(authority)) {
			return false;
		}
		return true;
	}
}*/