package kr.co.sellerall.sellide.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.sellide.domain.preferences.TbShopInfo;
import kr.co.sellerall.sellide.domain.preferences.TbShopUserInfo;
import kr.co.sellerall.sellide.service.ShopService;
import kr.co.sellerall.sellide.vo.ShopInfoRequestVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/preferences", method=RequestMethod.GET)
public class PreferencesRestController {
	private static final Logger logger = LoggerFactory.getLogger(PreferencesRestController.class);
	private final ShopService shopService;
	
	@PostMapping("v1/shop-list")
	public List<TbShopInfo> shopAllList(){
		logger.debug("/v1/shopList , shopList 컨트롤러");
		List<TbShopInfo> shopInfoList = shopService.shopInfoAllList();
		
		return shopInfoList;
	}
	
	@PostMapping("v1/user-list")
	public List<TbShopUserInfo> shopInfoList(@LoginUser SessionUser user){
		logger.debug("/v1/shopInfoList , shopInfoList 컨트롤러");
		List<TbShopUserInfo> shopUserInfoList = shopService.shopUserInfoList(user);
		
		return shopUserInfoList;
	}
	
	@PostMapping("v1/shop-user")
	public ResponseEntity<ApiResult> saveShopInfo(@RequestBody ShopInfoRequestVO requestVO, @LoginUser SessionUser user){
		logger.debug("/v1/saveshopInfo , saveshopInfo 컨트롤러");
		shopService.saveShopInfo(requestVO, user);
		
		return Result.ok("ok");
	}
	
	@PostMapping("v1/shop")
	public String loginShop(@RequestBody Object request, @LoginUser SessionUser user) {
		logger.debug("/v1/loginShop , loginShop 컨트롤러");
		String retMsg = "";
		
		String userId = request.toString();
		userId = userId.replace("{userId=[", "");
		userId = userId.replace("]}", "");

		try {
			if(shopService.loginShop(userId, user) != null) {
				retMsg = "로그인 되었습니다.";
			} else {
				retMsg = "로그인에 실패했습니다.";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return retMsg;
	}
	
	@PostMapping("v1/deleteShop")
	public ResponseEntity<ApiResult> deleteShop(@RequestBody Object request, @LoginUser SessionUser user) {
		logger.debug("/v1/deleteShop , deleteShop 컨트롤러");
		String userId = request.toString();
		userId = userId.replace("{userId=[", "");
		userId = userId.replace("]}", "");

		shopService.deleteShop(userId, user);

		return Result.ok("ok");
	}
	
}
