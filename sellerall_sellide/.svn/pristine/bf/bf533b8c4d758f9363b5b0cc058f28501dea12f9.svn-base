package kr.co.sellerall.scout.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sellerall.aid.controller.StatusController;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.sys.controller
 * @fileName      : MenuController.java
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
@RequestMapping(value = "/scout")
public class ScoutController {
	private static final Logger logger = LoggerFactory.getLogger(ScoutController.class);

	/**
	 * 
	 * @methodName    : temp1
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/temp1")
	public String temp1(Model model,HttpServletResponse res ,@LoginUser SessionUser user) throws Exception {
		logger.debug("temp1 컨트롤러");
		if(user != null){
            model.addAttribute("userName", user.getName());
		}else {
			res.sendRedirect("/sellide/main");
		}
		return "vue/index.html";
	}
	
	/**
	 * 
	 * @methodName    : temp2
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @return
	 * @throws Exception
	 */
	@GetMapping(value = "/temp2")
	public String temp2(Model model,HttpServletResponse res ,@LoginUser SessionUser user) throws Exception {
		logger.debug("temp2 컨트롤러");
		if(user != null){
            model.addAttribute("userName", user.getName());
		}else {
			res.sendRedirect("/sellide/main");
		}
		return "vue/index.html";
	}
}
