package kr.co.sellerall.cmm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.service.MenuService;
import lombok.RequiredArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.cmm.controller
 * @fileName      : MenuRestController.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/menu")
public class MenuRestController {
	private static final Logger logger = LoggerFactory.getLogger(MenuRestController.class);
	private final MenuService menuService;
	
	/**
	 * @param 		: requestDto
	 * @return		: String
	 * @description	: 메뉴 리스트
	 */
    @PostMapping("/v1/all-list")
    public List<Object> menuAllList(HttpServletRequest req,@LoginUser SessionUser user){
    	logger.debug("메뉴 리스트");
    	List<Object> menuList = menuService.menuAllList(user,req.getContextPath());
		return menuList;
    }
}
