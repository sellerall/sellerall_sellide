package kr.co.sellerall.sellide.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.sellide.component.CommonUtil;
import kr.co.sellerall.sellide.domain.preferences.TbShopInfo;
import kr.co.sellerall.sellide.domain.preferences.TbShopInfoRepository;
import kr.co.sellerall.sellide.domain.preferences.TbShopUserInfo;
import kr.co.sellerall.sellide.domain.preferences.TbShopUserInfoRepository;
import kr.co.sellerall.sellide.service.ShopService;
import kr.co.sellerall.sellide.vo.ShopInfoRequestVO;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;

@Service
@RequiredArgsConstructor
public class ShopServiceImpl implements ShopService{
	private static final Logger logger = LoggerFactory.getLogger(ShopServiceImpl.class);
	private final TbShopInfoRepository shopInfoRepository;
	private final TbShopUserInfoRepository shopUserInfoRepository;

	@Override
	public List<TbShopInfo> shopInfoAllList() {
		List<TbShopInfo> shopInfoList = shopInfoRepository.findAll();
		return shopInfoList;
	}
	
	@Override
	public List<TbShopUserInfo> shopUserInfoList(SessionUser user) {
		List<TbShopUserInfo> shopUserInfoList = shopUserInfoRepository.findByUserId(user.getEmail());
		
		return shopUserInfoList;
	}

	@Override
	public void saveShopInfo(ShopInfoRequestVO param, SessionUser user){
		TbShopUserInfo check = shopUserInfoRepository.findByUserIdAndShopCode(user.getEmail(), param.getShopCode()).orElse(null);
		if(check != null) {
			TbShopUserInfo shopUserInfo = modEntity(check,param,user);
			shopUserInfoRepository.save(shopUserInfo);
		}else {
			TbShopUserInfo shopUserInfo = voTOEntity(param,user);
			shopUserInfoRepository.save(shopUserInfo);
		}

	}
	
	@Override
	public Map loginShop(String userId, SessionUser user) {
		Map cookies = new HashMap();
		JSONObject json = new JSONObject();

		try {
			TbShopUserInfo shopUserInfo = shopUserInfoRepository.findByUserIdAndShopId(user.getEmail(), userId).orElse(null);
			
			logger.debug("test2"+shopUserInfo);
			
			if(shopUserInfo.getShopCode() == "101") {
				
				String id = shopUserInfo.getShopId();
				String pw = shopUserInfo.getShopPw();
				
				json.accumulate("url", "https%3A%2F%2Fsell.smartstore.naver.com%2F%23");
				json.accumulate("id", CommonUtil.nvl(id));
				json.accumulate("pw", CommonUtil.nvl(pw));
				
				Connection.Response res;
				res = Jsoup.connect("https://sell.smartstore.naver.com/api/login?url=https%253A%252F%252Fsell.smartstore.naver.com%252F%2523%252Fhome%252Fdashboard")
						.method(Method.POST)
						.header("Content-Type", "application/json;  charset=utf-8")
						.header("x-current-state", "https://sell.smartstore.naver.com/#/login?url=https%253A%252F%252Fsell.smartstore.naver.com%252F%2523%252Fhome%252Fdashboard")
						.header("x-current-stateName", "login")
						.header("x-to-stateName", "login")
						.timeout(10000)
						.requestBody(json.toString())
						.ignoreHttpErrors(true)
						.ignoreContentType(true)
						.execute();
				
				cookies.putAll(res.cookies());
			}
		} catch(Exception e) {
			e.printStackTrace();
		}

		return cookies;	
	}

	@Override
	public void deleteShop(String userId, SessionUser user) {
		TbShopUserInfo shopUserInfo = shopUserInfoRepository.findByUserIdAndShopId(user.getEmail(), userId).orElse(null);
		shopUserInfoRepository.delete(shopUserInfo);
	}
}