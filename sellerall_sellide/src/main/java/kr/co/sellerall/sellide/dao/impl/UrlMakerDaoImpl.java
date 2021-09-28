package kr.co.sellerall.sellide.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import kr.co.sellerall.sellide.component.DomeUrlMaker;
import kr.co.sellerall.sellide.config.Constants;
import kr.co.sellerall.sellide.dao.UrlMakerDao;
import kr.co.sellerall.sellide.vo.DomeProductRequestVO;

@Component
public class UrlMakerDaoImpl implements UrlMakerDao{
	private String domeUrl;
	private String stpUrl;
	
	public UrlMakerDaoImpl(@Value("${dome.openapi.url}") String domeUrl) {
		this.domeUrl = domeUrl;
	}
	
	@Override
	public String domeItemListUrlMaker(DomeProductRequestVO param) {
		return new DomeUrlMaker.Builder().protocolAuthority(domeUrl)
				.ver("4.0")			//필수값
				.mode("getItemList")
				.aid(Constants.DOMEGGOOK_API_KEY)
				.market("supply")
				.om("json")
				.sz(Integer.toString(param.getPageSize()))
				.pg(Integer.toString(param.getPageIndex()))
				
				.builder()
				.toString();
	}

	@Override
	public String domeItemDetailUrlMaker(String prodCd) {
		return new DomeUrlMaker.Builder().protocolAuthority(domeUrl)
				.ver("4.3")
				.mode("getItemView")
				.aid(Constants.DOMEGGOOK_API_KEY)
				.no(prodCd)
				
				.builder()
				.toString();
	}
}
