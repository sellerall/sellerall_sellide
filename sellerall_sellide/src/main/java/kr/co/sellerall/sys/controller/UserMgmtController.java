package kr.co.sellerall.sys.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@Secured({"ROLE_ADMIN","ROLE_SUPER"})
@RequestMapping(value = "/sys")
public class UserMgmtController {
	private static final Logger logger = LoggerFactory.getLogger(UserMgmtController.class);
	
	/**
	 * 사용자관리 페이지 이동
	 * @methodName    : userMgmt
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/usermanage")
	public String userMgmt(Model model,HttpServletResponse res ,@LoginUser SessionUser user) throws Exception {
		logger.debug("유저 관리 컨트롤러");
		if(user != null){
			model.addAttribute("userName", user.getName());
		}else {
			res.sendRedirect("/sellide/main");
		}
		return "vue/index.html";
	}
}
