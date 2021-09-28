package kr.co.sellerall.sellide.controller;

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

@RequiredArgsConstructor
@Controller
@RequestMapping(value = "/sellide")
public class PreferencesController {
	private static final Logger logger = LoggerFactory.getLogger(PreferencesController.class);
	private final HttpSession httpSession;
	
	@GetMapping(value = "/preferences")
	public String preferencesView(Model model, @LoginUser SessionUser user) throws Exception {

        if(user != null){
            model.addAttribute("userName", user.getName());
        }
		return "vue/index.html";
	}
}