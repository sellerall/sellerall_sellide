package kr.co.sellerall.sellide.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.vo.ResultVO;
import kr.co.sellerall.sellide.component.CommonUtil;
import kr.co.sellerall.sellide.component.RESTUtils;
import kr.co.sellerall.sellide.config.Constants;
import kr.co.sellerall.sellide.dao.StorageProductDao;
import kr.co.sellerall.sellide.dao.UrlMakerDao;
import kr.co.sellerall.sellide.domain.preferences.TbShopInfo;
import kr.co.sellerall.sellide.domain.preferences.TbShopUserInfo;
import kr.co.sellerall.sellide.domain.preferences.TbShopUserInfoRepository;
import kr.co.sellerall.sellide.domain.productManager.TbProduct;
import kr.co.sellerall.sellide.domain.productManager.TbProductPredicate;
import kr.co.sellerall.sellide.domain.productManager.TbProductRepository;
import kr.co.sellerall.sellide.dto.StorageProductDTO;
import kr.co.sellerall.sellide.service.ProductManageService;
import kr.co.sellerall.sellide.vo.DbProductRequestVO;
import kr.co.sellerall.sellide.vo.DbProductResponseVO;
import kr.co.sellerall.sellide.vo.DomeProductRequestVO;
import kr.co.sellerall.sellide.vo.StorageProductRequestVO;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;

@Service
@RequiredArgsConstructor
public class ProductManageServiceImpl implements ProductManageService {
	private static final Logger logger = LoggerFactory.getLogger(ProductManageServiceImpl.class);
	private final TbProductRepository productRepository;
	private final TbShopUserInfoRepository shopInfoRepository;
	
	@Autowired
	private UrlMakerDao urlMakerDao;
	@Autowired
	private RESTUtils restUtil;
	@Autowired
    StorageProductDao storageProductDao;
	 
	@Override
	public String domeList(DomeProductRequestVO param, SessionUser user) {
		/*String[] restUrlSpl = urlMakerDao.domeItemListUrlMaker(param).split("\\?");
		String result = restUtil.request(restUrlSpl[0], restUrlSpl[1], Constants.HTTP_POST);*/
		String restUrl = urlMakerDao.domeItemListUrlMaker(param);
		String result = restUtil.request(restUrl);
		logger.debug("domeList targetURL : " + restUrl);
		logger.debug("domeList result : " + result);
		
		return result;
	}
	
	@Override
	public ResultVO dbProductList(DbProductRequestVO param) {	
		ResultVO resultVO = new ResultVO();
		Page<TbProduct> pageList = null;
		pageList = productRepository.findAll(TbProductPredicate.search(param),PageRequest.of(param.getPageIndex()-1,param.getPageSize()));
		List<TbProduct> productList = pageList.getContent();
		List<DbProductResponseVO> list = productList.stream().map(entity -> EntityTOvo(entity)).collect(Collectors.toList());
		resultVO.handleResultList(list,(int)pageList.getTotalElements());
		resultVO.setPageIndex(param.getPageIndex());
		resultVO.setPageSize(param.getPageSize());
		return resultVO;
	}
	
	@Override
	public void emptyStorageProduct(StorageProductRequestVO param, SessionUser user) {
		storageProductDao.insertStorageProduct((String)Constants.STORAGE_TABLE+user.getUserSeq(),paramTOdto(param, user));
	}
	
	@Override
	public String domeDetail(String prodCd) {		
		String restUrl = urlMakerDao.domeItemDetailUrlMaker(prodCd);	
		String result = restUtil.request(restUrl);
		
		return result;
	}
	
	/*
	@Override
	public List<String> domeDetail(List<StorageProductRequestVO> param) {		
		List<String> retResult = new ArrayList<String>();

		param.stream()
		.forEach(e-> {
			if( e!= null) {
				String restUrl = urlMakerDao.domeItemDetailUrlMaker(e.getProdCd());
				String result = restUtil.request(restUrl);
				logger.debug("result:"+ result);
				retResult.add(result);
			}
		});
		 		
		return retResult;
	}
	*/
	
	@Override
	public void insertStorageProduct(List<StorageProductRequestVO> param, SessionUser user) {
		param.stream()
		.forEach(e-> {
			if(e != null) {
				TbProduct result = productRepository.findByProdCd(e.getProdCd()).orElse(null);
				if(result == null) {//DB ?????? ????????????  ???????????? 
					storageProductDao.insertStorageProduct((String)Constants.STORAGE_TABLE+user.getUserSeq(),paramTOdto(e,user));
				}else {	//???????????? ???????????????
					storageProductDao.insertStorageProduct((String)Constants.STORAGE_TABLE+user.getUserSeq(),EntityTOdto(result,user));
					storageProductDao.insertStorageProduct((String)Constants.STORAGE_TABLE+user.getUserSeq(),paramTOdto(e,user));
				}
			}
		});
	}
	
	@Override
	public void deleteStorageProduct(List<StorageProductRequestVO> param, SessionUser user) {
		param.stream()
		.forEach(e-> {
			if(e != null) {
				storageProductDao.deleteStorageProduct((String)Constants.STORAGE_TABLE+user.getUserSeq(),e.getProdIdx());
			}
		});
		
	}
	
	@Override
	public ResultVO storageProductList(StorageProductRequestVO param , SessionUser user) {
		ResultVO resultVO = new ResultVO();
		int total = 0;
		List<StorageProductDTO> list =storageProductDao.selectStorageProductList((String)Constants.STORAGE_TABLE+user.getUserSeq(), param);
		total = storageProductDao.selectStorageProductListTotal((String)Constants.STORAGE_TABLE+user.getUserSeq());
		resultVO.handleResultList(list,total);
		resultVO.setPageIndex(param.getPageIndex());
		resultVO.setPageSize(param.getPageSize());
		return resultVO;	
	}

	@Override
	public String domeItemDetail(String prodCd) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Map naverLogin(SessionUser user) {
		Map cookies = new HashMap();
		JSONObject json = new JSONObject();

		TbShopUserInfo shopInfoVO = new TbShopUserInfo();
		shopInfoVO = shopInfoRepository.findByUserIdAndShopCode(user.getEmail(), "101").orElse(null);
		
		String naverId = shopInfoVO.getShopId();
		String naverPw = shopInfoVO.getShopPw();

		json.accumulate("url", "https%3A%2F%2Fsell.smartstore.naver.com%2F%23");
		json.accumulate("id", CommonUtil.nvl(naverId));
		json.accumulate("pw", CommonUtil.nvl(naverPw));
		
		try {		
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
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		return cookies;		
	}
	
	@Override
	public String naverUserInfo(Map cookies) {	
		String userInfo = "";
		
		try {
			Connection.Response res1 = Jsoup.connect("https://sell.smartstore.naver.com/#/seller/info")
					.method(Method.GET)
					.cookies(cookies)
					.header("path", "/api/sellers/account?maskApplyTypes=MEMBER&maskApplyTypes=SETTLEMENT")
					.header("Content-Type", "application/json;  charset=utf-8")
					.header("x-current-state", "https://sell.smartstore.naver.com/#/seller/info")
					.header("x-current-stateName", "main.seller-info")
					.header("x-to-stateName", "main.seller-info")
					.timeout(10000)
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.execute();
			
			Connection.Response res2 = Jsoup.connect("https://sell.smartstore.naver.com/api/sellers/account?maskApplyTypes=MEMBER&maskApplyTypes=SETTLEMENT")
					.method(Method.GET)
					.cookies(cookies)
					.header("path", "/api/sellers/account?maskApplyTypes=MEMBER&maskApplyTypes=SETTLEMENT")
					.header("Content-Type", "application/json;  charset=utf-8")
					.header("x-current-state", "https://sell.smartstore.naver.com/#/seller/info")
					.header("x-current-stateName", "main.seller-info")
					.header("x-to-stateName", "main.seller-info")
					.timeout(10000)
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.execute();
			
			userInfo = res2.body();

		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userInfo;
	}

	@Override
	public String naverProductUpload(Object param, Map cookies) {
		String result = "";
		
		try {
			Connection.Response res1 = Jsoup.connect("https://sell.smartstore.naver.com/api/sellers/account?maskApplyTypes=MEMBER&maskApplyTypes=SETTLEMENT")
					.method(Method.GET)
					.cookies(cookies)
					.header("Content-Type", "application/json;  charset=utf-8")
					.header("x-current-state", "https://sell.smartstore.naver.com/#/products/create")
					.header("x-current-stateName", "main.product.create")
					.header("x-to-stateName", "main.product.create")
					.timeout(10000)
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.execute();
		
			Connection.Response res2 = Jsoup.connect("https://sell.smartstore.naver.com/api/products")
					.method(Method.POST)
					.cookies(cookies)
					.header("authority", "sell.smartstore.naver.com")
					.header("path", "/api/products")
					.header("scheme", "https")
					.header("accept", "*/*")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
					.header("cache-control", "no-cache")
					.header("content-length", "7547")				
					.header("content-type", "application/json;charset=UTF-8")	
					.header("origin", "https://sell.smartstore.naver.com")
					.header("pragma", "no-cache")
					.header("referer", "https://sell.smartstore.naver.com/")
					.header("sec-ch-ua", "")
					.header("sec-ch-ua-mobile", "?0")				
					.header("sec-ch-ua-platform", "Windows")
					.header("sec-fetch-dest", "empty")
					.header("sec-fetch-mode", "cors")
					.header("sec-fetch-site", "same-origin")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/93.0.4577.63 Safari/537.36")
					.header("x-current-state", "https://sell.smartstore.naver.com/#/products/create")
					.header("x-to-statename", "https://sell.smartstore.naver.com/#/products/create")
					.header("x-current-statename", "main.product.create")
					.header("x-to-statename", "main.product.create")
					.requestBody(param.toString())
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.execute();
			
			logger.debug("result: "+ res2.body());
			result = res2.body().toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	
	@Override
	public String naverProductEdit(Object request, Map cookies) {
		String result = "";
		try {
			//??????????????? ??????
			Connection.Response res1 = Jsoup.connect("https://sell.smartstore.naver.com/api/products/5867688237")
					.method(Method.GET)
					.cookies(cookies)
					.header("Content-encoding", "gzip")
					.header("Content-Type", "application/json;  charset=utf-8")
					.header("authority", "sell.smartstore.naver.com")
					.header("referer", "https://sell.smartstore.naver.com/")				
					.header("x-current-state", "https://sell.smartstore.naver.com/#/products/edit/5894871096")
					.header("x-current-stateName", "main.product.edit")
					.header("x-to-stateName", "main.product.edit")
					.timeout(10000)
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.execute();
			
			logger.debug("result1: " + res1.body());
			
			//??????
			Connection.Response res2 = Jsoup.connect("https://sell.smartstore.naver.com/api/products")
					.method(Method.POST)
					.cookies(cookies)
					.header("authority", "sell.smartstore.naver.com")
					.header("path", "/api/products")
					.header("scheme", "https")
					.header("accept", "*/*")
					.header("accept-encoding", "gzip, deflate, br")
					.header("accept-language", "ko-KR,ko;q=0.9,en-US;q=0.8,en;q=0.7")
					.header("cache-control", "no-cache")
					.header("content-length", "12772")				
					.header("content-type", "application/json;charset=UTF-8")	
					.header("origin", "https://sell.smartstore.naver.com")
					.header("pragma", "no-cache")
					.header("referer", "https://sell.smartstore.naver.com/")
					.header("sec-ch-ua", "")
					.header("sec-ch-ua-mobile", "?0")				
					.header("sec-ch-ua-platform", "Windows")
					.header("sec-fetch-dest", "empty")
					.header("sec-fetch-mode", "cors")
					.header("sec-fetch-site", "same-origin")
					.header("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.61 Safari/537.36")
					.header("x-current-state", "https://sell.smartstore.naver.com/#/products/edit/5894871096")				
					.header("x-to-statename", "main.product.edit")
					.header("x-current-statename", "main.product.edit")
					.header("x-to-statename", "main.product.edit")
					.requestBody(request.toString())
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.execute();
			
			logger.debug("result2: " + res2.body());
			result = res2.body();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String updateRegisterCode(StorageProductRequestVO param, SessionUser user) {	
		storageProductDao.updateRegisterCode((String)Constants.STORAGE_TABLE+user.getUserSeq(), param);		

		return "????????? ?????????????????????";
	}

	// ?????????????????? ?????????
	@Override
	public ResultVO registeredProductList(StorageProductRequestVO param, SessionUser user) {
		ResultVO resultVO = new ResultVO();
		int total = 0;
		
		List<StorageProductDTO> list = storageProductDao.selectRegisteredProductList((String)Constants.STORAGE_TABLE+user.getUserSeq(), param);
		total = storageProductDao.selectStorageProductListTotal((String)Constants.STORAGE_TABLE+user.getUserSeq());
		resultVO.handleResultList(list,total);
		resultVO.setPageIndex(param.getPageIndex());
		resultVO.setPageSize(param.getPageSize());

		return resultVO;
	}
}
