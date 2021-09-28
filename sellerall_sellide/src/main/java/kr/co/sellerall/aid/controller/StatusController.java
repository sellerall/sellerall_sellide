package kr.co.sellerall.aid.controller;

import javax.servlet.http.HttpServletResponse;

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
 * @packageName   : kr.co.sellerall.aid.controller
 * @fileName      : StatusController.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17
 * @description   : 메뉴 컨트롤러
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/aid")
public class StatusController {
	private static final Logger logger = LoggerFactory.getLogger(StatusController.class);

	/**
	 * 
	 * @methodName    : crawler
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/status")
	public String status(Model model,HttpServletResponse res ,@LoginUser SessionUser user) throws Exception {
		logger.debug("status 컨트롤러");
		if(user != null){
            model.addAttribute("userName", user.getName());
		}else {
			res.sendRedirect("/sellide/main");
		}
		return "vue/index.html";
	}

}
