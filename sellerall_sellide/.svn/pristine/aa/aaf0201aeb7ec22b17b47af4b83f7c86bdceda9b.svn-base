package kr.co.sellerall.sellide.service;

import java.util.List;
import java.util.Map;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.sellide.domain.preferences.TbShopInfo;
import kr.co.sellerall.sellide.domain.preferences.TbShopUserInfo;
import kr.co.sellerall.sellide.vo.ShopInfoRequestVO;

public interface ShopService {
	List<TbShopInfo> shopInfoAllList();
	List<TbShopUserInfo> shopUserInfoList(SessionUser user);
	void saveShopInfo(ShopInfoRequestVO param, SessionUser user);
	Map loginShop(String userId, SessionUser user);
	void deleteShop(String userId, SessionUser user);
	
	default TbShopUserInfo voTOEntity(ShopInfoRequestVO param,SessionUser user) {
		return TbShopUserInfo.builder()
                .userId(user.getEmail())
                .shopCode(param.getShopCode())
                .shopName(param.getShopName())
                .shopId(param.getShopId())
                .shopPw(param.getShopPw())
                .sellerId(param.getSellerId())
                .apiId(param.getApiId())
                .domainId(param.getDomainId())
                .crtName(user.getEmail())
                .uptName(user.getEmail())
                .build();
		
	}
	default TbShopUserInfo modEntity(TbShopUserInfo userInfo,ShopInfoRequestVO param,SessionUser user) {
		userInfo.modUserInfo(
				param.getShopId(), 
				param.getShopPw(), 
				param.getSellerId(),
				param.getApiId(),
				param.getDomainId(),
				user.getEmail());
		return userInfo;
	}
	/*
	default UserMgmtResponseVO EntityTOvo(TbUserInfo vo) {
		return UserMgmtResponseVO.builder()
				.userInfo(vo)
                .build();
		
	}*/
}