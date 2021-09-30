package kr.co.sellerall.sys.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.sys.service.MenuMgmtService;
import kr.co.sellerall.sys.vo.MenuGrpRequestVO;
import kr.co.sellerall.sys.vo.MenuMstRequestVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@Secured({"ROLE_ADMIN","ROLE_SUPER"})
@RequestMapping(value = "/api/sys")
public class MenuMgmtRestController {
	private static final Logger logger = LoggerFactory.getLogger(MenuMgmtRestController.class);
	private final MenuMgmtService menuMgmtService;
	
	/**
	 * 메뉴 목록 리스트 요청
	 * @methodName    : menuSelectAllList
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/menu/list")
	public List<Object> menuSelectAllList(Model model) throws Exception {
		logger.debug("sys/v1/menu/list/ , menuList 컨트롤러 ");
    	List<Object> menuList = menuMgmtService.menuAllList();
		return menuList;
	}
	
	/**
	 * 메뉴 그룹 리스트 요청
	 * @methodName    : menuGroupSelectList
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/menugroup/list")
	public List<TbMenuGrp> menuGroupSelectList(Model model) throws Exception {
		logger.debug("sys/v1/menu/list/ , menuList 컨트롤러 ");
    	List<TbMenuGrp> menuList = menuMgmtService.menuGrpList();
		return menuList;
	}
	
	/**
	 * 메뉴 추가
	 * @methodName    : menuGroupSelectList
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/menugroup")
	public ResponseEntity<ApiResult> menuGrpInsert(@RequestBody MenuGrpRequestVO param,@LoginUser SessionUser user) throws Exception {
		logger.debug("sys/v1/menugroup , menuGrpInsert 컨트롤러 ");
    	menuMgmtService.menuGrpInsert(param,user);
		return Result.ok("ok");
	}
	/**
	 * 메뉴 추가
	 * @methodName    : menuGroupSelectList
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/menu")
	public ResponseEntity<ApiResult> menuMstInsert(@RequestBody MenuMstRequestVO param,@LoginUser SessionUser user) throws Exception {
		logger.debug("sys/v1/menu , menuInsert 컨트롤러 ");
    	menuMgmtService.menuMstInsert(param,user);
		return Result.ok("ok");
	}
	
	/**
	 * 메뉴 그룹 삭제
	 * @methodName    : menuGroupDelete
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@DeleteMapping(value = "/v1/menugroup/{menuGrpSeq}")
	public ResponseEntity<ApiResult> menuGroupDelete(@PathVariable("menuGrpSeq") Long menuGrpSeq,Model model) throws Exception {
		logger.debug("sys/v1/menugroup , delete 컨트롤러 ");
    	menuMgmtService.menuGrpDelete(menuGrpSeq);
		return Result.ok("ok");
	}
	/**
	 * 메뉴 삭제
	 * @methodName    : menuDelete
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@DeleteMapping(value = "/v1/menu/{menuSeq}")
	public ResponseEntity<ApiResult> menuDelete(@PathVariable("menuSeq") Long menuSeq,Model model) throws Exception {
		logger.debug("sys/v1/menu , delete 컨트롤러 ");
    	menuMgmtService.menuMstDelete(menuSeq);
		return Result.ok("ok");
	}
}
