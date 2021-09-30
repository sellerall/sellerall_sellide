package kr.co.sellerall.sellide.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Connection.Method;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.sellide.component.CommonUtil;
import kr.co.sellerall.sellide.vo.SmartstoreCategoryVO;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/category", method=RequestMethod.GET)
public class CategoryController {
	private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);
	
	@PostMapping("/v1/smartstore1")
	public ArrayList<SmartstoreCategoryVO> smartstore_category1() {
		ArrayList<SmartstoreCategoryVO> c_list1 = new ArrayList();

		try {
			Map cookies = new HashMap();
			JSONObject json = new JSONObject();

			json.accumulate("url", "https%3A%2F%2Fsell.smartstore.naver.com%2F%23");
			json.accumulate("id", CommonUtil.nvl("sacaura"));
			json.accumulate("pw", CommonUtil.nvl("fnqlsp0815"));
			
			Connection.Response res = Jsoup.connect("https://sell.smartstore.naver.com/api/login?url=https%253A%252F%252Fsell.smartstore.naver.com%252F%2523%252Fhome%252Fdashboard")
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
			
			logger.debug("test"+res);
			
			cookies.putAll(res.cookies());

			System.out.println("카테고리 수집 시작");
			
			Response category_1 = Jsoup.connect("https://sell.smartstore.naver.com/api/category-search/root?_action=getChild&isValid=true")
					.method(Method.GET)
					.cookies(cookies)
					.ignoreHttpErrors(true)
					.ignoreContentType(true)
					.timeout(180000)
					.execute();
			
			JSONObject obj = new JSONObject();
			obj.accumulate("list", category_1.body());
			JSONArray arr = obj.getJSONArray("list");
			int cnt = arr.size();
			for(int i=0; i < cnt; i++) {
				JSONObject c_obj = (JSONObject)arr.get(i);
				SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
				
				categoryVO.setFg(CommonUtil.nvl(c_obj.get("lastLevel")));
				categoryVO.setMarketCd("A077");
				categoryVO.setCategoryCd(CommonUtil.nvl(c_obj.get("wholeCategoryId")));
				categoryVO.setCategoryNm(CommonUtil.nvl(c_obj.get("wholeCategoryName")));

				if(CommonUtil.nvl(c_obj.get("deleted")).equals("false")) {
					c_list1.add(categoryVO);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c_list1;
	}
	
	@PostMapping("/v1/smartstore2")
	public ArrayList<SmartstoreCategoryVO> smartstore_category2(@RequestBody SmartstoreCategoryVO requestVO) {
		ArrayList<SmartstoreCategoryVO> c_list2 = new ArrayList();
		Map cookies = new HashMap();
		
		try {
			if(requestVO.getFg().equals("false")) {
				Response category_2 = Jsoup.connect("https://sell.smartstore.naver.com/api/category-search/"+requestVO.getCategoryCd()+"?_action=getChild&isValid=true")
						.method(Method.GET)
						.cookies(cookies)
						.ignoreHttpErrors(true)
						.ignoreContentType(true)
						.timeout(180000)
						.execute();
				
				JSONObject obj2 = new JSONObject();
				obj2.accumulate("list", category_2.body());
				JSONArray arr2 = obj2.getJSONArray("list");
				
				for(int j=0; j < arr2.size(); j++) {
					JSONObject c_obj = (JSONObject)arr2.get(j);
					SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
					
					categoryVO.setFg(CommonUtil.nvl(c_obj.get("lastLevel")));
					categoryVO.setMarketCd("A077");
					categoryVO.setCategoryCd(CommonUtil.nvl(c_obj.get("wholeCategoryId")));
					categoryVO.setCategoryNm(CommonUtil.nvl(c_obj.get("wholeCategoryName")));
					
					if(CommonUtil.nvl(c_obj.get("deleted")).equals("false")) {
						c_list2.add(categoryVO);
					}
				}
			} else {
				SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
				categoryVO.setCategoryNm("하위 카테고리가 없습니다.");
				c_list2.add(categoryVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		return c_list2;
	}

	@PostMapping("/v1/smartstore3")
	public ArrayList<SmartstoreCategoryVO> smartstore_category3(@RequestBody SmartstoreCategoryVO requestVO){
		ArrayList<SmartstoreCategoryVO> c_list3 = new ArrayList();
		Map cookies = new HashMap();
		
		try {
			if(requestVO.getFg().equals("false")) {
				String[] c_arr = CommonUtil.nvl(requestVO.getCategoryCd()).split(">");
				Response category_3 = Jsoup.connect("https://sell.smartstore.naver.com/api/category-search/"+CommonUtil.nvl(c_arr[1])+"?_action=getChild&isValid=true")
						.method(Method.GET)
						.cookies(cookies)
						.ignoreHttpErrors(true)
						.ignoreContentType(true)
						.timeout(180000)
						.execute();
				
				JSONObject obj3 = new JSONObject();
				obj3.accumulate("list", category_3.body());
				JSONArray arr3 = obj3.getJSONArray("list");
				
				for(int j=0; j < arr3.size(); j++) {
					JSONObject c_obj = (JSONObject)arr3.get(j);
					SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
					
					categoryVO.setFg(CommonUtil.nvl(c_obj.get("lastLevel")));
					categoryVO.setMarketCd("A077");
					categoryVO.setCategoryCd(CommonUtil.nvl(c_obj.get("wholeCategoryId")));
					categoryVO.setCategoryNm(CommonUtil.nvl(c_obj.get("wholeCategoryName")));
					
					if(CommonUtil.nvl(c_obj.get("deleted")).equals("false")) {
						c_list3.add(categoryVO);
					}
				}
			} else {
				SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
				categoryVO.setCategoryNm("하위 카테고리가 없습니다.");
				c_list3.add(categoryVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c_list3;
	}

	@PostMapping("/v1/smartstore4")
	public ArrayList<SmartstoreCategoryVO> smartstore_category4(@RequestBody SmartstoreCategoryVO requestVO){
		ArrayList<SmartstoreCategoryVO> c_list4 = new ArrayList();
		Map cookies = new HashMap();
		
		try {
			if(requestVO.getFg().equals("false")) {
				String[] c_arr = CommonUtil.nvl(requestVO.getCategoryCd()).split(">");
				Response category_4 = Jsoup.connect("https://sell.smartstore.naver.com/api/category-search/"+CommonUtil.nvl(c_arr[2])+"?_action=getChild&isValid=true")
						.method(Method.GET)
						.cookies(cookies)
						.ignoreHttpErrors(true)
						.ignoreContentType(true)
						.timeout(180000)
						.execute();
				
				JSONObject obj4 = new JSONObject();
				obj4.accumulate("list", category_4.body());
				JSONArray arr4 = obj4.getJSONArray("list");
				
				for(int j=0; j < arr4.size(); j++) {
					JSONObject c_obj = (JSONObject)arr4.get(j);
					SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
					
					categoryVO.setFg(CommonUtil.nvl(c_obj.get("lastLevel")));
					categoryVO.setMarketCd("A077");
					categoryVO.setCategoryCd(CommonUtil.nvl(c_obj.get("wholeCategoryId")));
					categoryVO.setCategoryNm(CommonUtil.nvl(c_obj.get("wholeCategoryName")));
					
					if(CommonUtil.nvl(c_obj.get("deleted")).equals("false")) {
						c_list4.add(categoryVO);
					}
				}
			} else {
				SmartstoreCategoryVO categoryVO = new SmartstoreCategoryVO();
				categoryVO.setCategoryNm("하위 카테고리가 없습니다.");
				c_list4.add(categoryVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c_list4;
	}
}