package kr.co.sellerall.cmm.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.cmm.controller
 * @fileName      : LoginController.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17
 * @description   : 로그인 컨트롤러
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	private final HttpSession httpSession;
	/**
	 * Login 페이지 이동
	 * @methodName    : authMgmtView
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/login")
	public String authMgmtView(Model model,HttpServletResponse res ,@LoginUser SessionUser user) throws Exception {
		logger.debug("로그 설정 테스트 ");
		if(user != null){
            model.addAttribute("userName", user.getName());
            res.sendRedirect("/sellide/main");
        }
		return "views/login/login";
	}
}
