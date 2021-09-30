package kr.co.sellerall.sellide.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/sellide")
public class MainController {
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	private final HttpSession httpSession;
	/**
	 * Login 페이지 이동
	 * @methodName    : authMgmtView
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = {"/main","/error"})
	public String authMgmtView(HttpServletResponse response,Model model, @LoginUser SessionUser user) throws Exception {
        if(user != null){
            model.addAttribute("userName",user.getName());
            response.addHeader("userName",user.getName());
        }
        
		return "vue/index.html";
	}
}