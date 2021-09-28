package kr.co.sellerall.sellide.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.vo.ResultVO;
import kr.co.sellerall.sellide.service.ProductManageService;
import kr.co.sellerall.sellide.vo.DbProductRequestVO;
import kr.co.sellerall.sellide.vo.DomeProductRequestVO;
import kr.co.sellerall.sellide.vo.StorageProductRequestVO;
import lombok.RequiredArgsConstructor;
import net.sf.json.JSONObject;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/product-manage", method=RequestMethod.GET)
public class ProductManageRestController {
	private static final Logger logger = LoggerFactory.getLogger(ProductManageRestController.class);
	private final ProductManageService productManageService;

	@PostMapping(value ="/v1/dome-list",produces = "application/json; charset=utf-8")
	public String getDomeList(@RequestBody DomeProductRequestVO param,@LoginUser SessionUser user){
		logger.debug("/v1/dome-list , dome-list 컨트롤러");
		return productManageService.domeList(param, user);	
	}
	
	
	@PostMapping("/v1/db-list")
	public ResultVO getDbList(@RequestBody DbProductRequestVO param) throws Exception {
		logger.debug("/v1/db-list , db-list 컨트롤러");
		ResultVO result = productManageService.dbProductList(param);

		return result;
	}
	
	@PostMapping("v1/empty-product")
	public void emptyProduct(@RequestBody StorageProductRequestVO param, @LoginUser SessionUser user) {
		logger.debug("/v1/empty-product , empty-product 컨트롤러");
		logger.debug("test"+param.getPartnerCd());
		
		productManageService.emptyStorageProduct(param, user);
	}
	
	@PostMapping("/v1/storage-product")
	public ResponseEntity<ApiResult> insertStorage(@RequestBody List<StorageProductRequestVO> param, @LoginUser SessionUser user) throws Exception {
		logger.debug("/v1/storage-product , insertStorage 컨트롤러");
		
		productManageService.insertStorageProduct(param, user);
		return Result.ok("ok");
	}
	@PostMapping("/v1/storage-product-del")
	public ResponseEntity<ApiResult> deleteStorage(@RequestBody List<StorageProductRequestVO> param, @LoginUser SessionUser user) throws Exception {
		logger.debug("/v1/storage-product , deleteStorage 컨트롤러");
		productManageService.deleteStorageProduct(param, user);
		return Result.ok("ok");
	}
	
	@PostMapping("/v1/storage-list")
	public ResultVO getStorageList(@RequestBody StorageProductRequestVO param, @LoginUser SessionUser user) throws Exception {
		logger.debug("/v1/storage-list , getStorageList 컨트롤러");
		ResultVO resultVO = productManageService.storageProductList(param,user);
		return resultVO;
	}
	
	@PostMapping("/v1/stpInfo")
	public String stpInfo(@LoginUser SessionUser user) {
		logger.debug("/v1/stpInfo , stpInfo 컨트롤러");
		
		Map cookies = new HashMap();
		
		cookies = productManageService.naverLogin(user);
		String result = productManageService.naverUserInfo(cookies);
		
		return result;
	}	
	
	@PostMapping("/v1/stpProduct")
	public ResponseEntity<ApiResult> stpProduct(@RequestBody JSONObject product, @LoginUser SessionUser user) {
		logger.debug("/v1/stpProduct , stpProduct 컨트롤러");
		
		Map cookies = new HashMap();
		
		//String request = "{\"product\":{\"saleType\":\"NEW\",\"excludeAdminDiscount\":false,\"excludeGivePresent\":false,\"payExposure\":true,\"images\":[{\"imageType\":\"REPRESENTATIVE\",\"order\":1,\"imageUrl\":\"http://shop1.phinf.naver.net/20210917_110/1631837641820TVr2B_PNG/32973484533839972_1584987784.PNG\",\"width\":264,\"height\":227,\"fileSize\":755}],\"videos\":[],\"detailAttribute\":{\"naverShoppingSearchInfo\":{},\"afterServiceInfo\":{\"afterServiceTelephoneNumber\":\"010-9224-8577\",\"afterServiceGuideContent\":\"제조사에 문의하세요.\"},\"originAreaInfo\":{\"type\":\"LOCAL\",\"originArea\":{\"code\":\"0002281\"}},\"sellerCodeInfo\":{\"sellerManagementCode\":\"\",\"sellerBarcode\":\"\",\"sellerCustomCode1\":\"\",\"sellerCustomCode2\":\"\"},\"seoInfo\":{\"sellerTags\":[],\"pageTitle\":\"\",\"metaDescription\":\"\"},\"optionInfo\":{\"optionUsable\":false,\"options\":[],\"optionCombinations\":[],\"optionStandards\":[],\"optionDeliveryAttributes\":[],\"useStockManagement\":true},\"supplementProductInfo\":{\"sortType\":\"CREATE\",\"count\":0,\"usable\":false,\"supplementProducts\":[]},\"purchaseReviewInfo\":{\"purchaseReviewExposure\":true},\"customMadeInfo\":{\"customMade\":false},\"taxType\":\"TAX\",\"productCertificationInfos\":[],\"minorPurchasable\":true,\"productInfoProvidedNotice\":{\"productInfoProvidedNoticeType\":\"ETC\",\"productInfoProvidedNoticeContent\":{\"templateType\":\"PRODUCT_INFO_PROVIDED_NOTICE\",\"productInfoProvidedNoticeType\":\"ETC\",\"returnCostReason\":\"0\",\"noRefundReason\":\"0\",\"qualityAssuranceStandard\":\"0\",\"compensationProcedure\":\"0\",\"troubleShootingContents\":\"0\",\"itemName\":\"상세정보 참조\",\"modelName\":\"상세정보 참조\",\"certificateDetails\":\"상세정보 참조\",\"manufacturer\":\"상세정보 참조\",\"afterServiceDirector\":\"상세정보 참조\"}},\"productAttributes\":[],\"consumptionTax\":\"TEN\",\"certificationTargetExcludeContent\":{\"kcYn\":\"TRUE\"},\"useReturnCancelNotification\":false},\"detailContent\":{\"editorType\":\"NONE\",\"editorTypeForEditor\":\"SEONE\",\"existsRemoveTags\":false,\"productDetailInfoContent\":\"testcontent\"},\"deliveryInfo\":{\"deliveryType\":\"DELIVERY\",\"deliveryAttributeType\":\"NORMAL\",\"deliveryFee\":{\"deliveryFeeType\":\"PAID\",\"baseFee\":2500,\"deliveryFeePayType\":\"PREPAID\",\"deliveryFeeByArea\":{\"deliveryAreaType\":\"AREA_3\",\"area2extraFee\":3000,\"area3extraFee\":5000}},\"claimDeliveryInfo\":{\"returnDeliveryCompany\":{\"regDate\":\"2020-08-19T14:05:40.011+0000\",\"modDate\":\"2020-08-19T14:05:40.011+0000\",\"regAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"modAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"id\":1146763,\"accountNo\":100807757,\"returnDeliveryCompanyPriorityType\":\"PRIMARY\",\"naverPayAppointment\":true,\"deliveryCompanyName\":\"우체국택배\"},\"returnDeliveryCompanySeq\":1146763,\"returnDeliveryFee\":2500,\"exchangeDeliveryFee\":5000,\"shippingAddress\":{\"id\":102324513,\"accountNo\":100807757,\"alias\":\"상품출고지\",\"addressType\":\"RELEASE\",\"addressInfo\":{\"fullAddressInfo\":\"인천광역시 서구 봉오재2로 37 (엘에이치웨스턴블루힐) 210동 2404호 (우 : 22732) \"},\"isOverseas\":false},\"shippingAddressId\":102324513,\"returnAddress\":{\"id\":102324514,\"accountNo\":100807757,\"alias\":\"반품교환지\",\"addressType\":\"REFUND_OR_EXCHANGE\",\"addressInfo\":{\"fullAddressInfo\":\"인천광역시 서구 봉오재2로 37 (엘에이치웨스턴블루힐) 210동 2404호 (우 : 22732) \"},\"isOverseas\":false},\"returnAddressId\":102324514,\"freeReturnInsuranceYn\":false},\"installationFee\":false,\"accountNo\":100807757,\"cloneDeliveryAttributeType\":\"NORMAL\",\"customMadeDirectInputYn\":false,\"expectedDeliveryPeriodType\":\"\",\"expectedDeliveryPeriodDirectInput\":\"\"},\"customerBenefit\":{},\"productStats\":{},\"representImageUrl\":\"\",\"useSalePeriod\":false,\"category\":{\"id\":\"50001914\",\"parentId\":\"50000024\",\"name\":\"헬스보충제\",\"wholeCategoryId\":\"50000006>50000024>50001914\",\"wholeCategoryName\":\"식품>다이어트식품>헬스보충제\",\"level\":3,\"lastLevel\":true,\"deleted\":false,\"sellBlogUse\":true,\"sortOrder\":0,\"juvenileHarmful\":false,\"$promise\":{},\"$resolved\":true,\"$order\":21,\"exceptionalCategoryTypes\":[\"REVIEW_UNEXPOSE\",\"REGULAR_SUBSCRIPTION\"],\"exceptionalCategoryAttributes\":[]},\"name\":\"hamtest\",\"liveDiscountBenefit\":null,\"salePrice\":\"11300\",\"stockQuantity\":\"11\"},\"savedTemplate\":{\"EVENT_PHRASE\":false},\"singleChannelProductMap\":{\"STOREFARM\":{\"id\":\"\",\"selfProductNameUsable\":false,\"channelProductName\":\"\",\"channelServiceType\":\"STOREFARM\",\"channelProductType\":\"SINGLE\",\"channel\":null,\"epInfo\":{\"naverShoppingRegistration\":true,\"enuriRegistration\":false,\"danawaRegistration\":false,\"naverDisabled\":false,\"enuriDisabled\":true,\"danawaDisabled\":true,\"disabledAll\":false},\"channelProductDisplayStatusType\":\"ON\",\"channelProductStatusType\":\"NORMAL\",\"storeKeepExclusiveProduct\":false,\"orderRequestUsable\":false,\"best\":false,\"bbsConfig\":false,\"materialImages\":[],\"tagImages\":[],\"barcodeImage\":null,\"affiliateInfo\":{\"affiliateYn\":false},\"channelNo\":100870126}},\"representNo\":100779884,\"representName\":\"만화상회\",\"representativeBirthDay\":\"1981-09-07T15:00:00.000+0000\",\"representType\":\"DOMESTIC_BUSINESS\",\"productRegistAuthCategories\":[\"HEALTH_FUNC_FOOD\"],\"accountNo\":100807757,\"accountId\":\"ncp_1o0nrh_01\",\"advertiser\":true,\"mallSeq\":1953499,\"defaultChannelNo\":100870126,\"accountExternalStatusType\":\"NORMAL\",\"npayRefKey\":\"510817653\",\"payUseYn\":true,\"actionGrade\":\"FOURTH\",\"branchUseYn\":false,\"sellerNo\":510817653,\"ownerChannelInfoList\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}],\"thisDayDispatchBasisHour\":16,\"thisDayDispatchBasisMinute\":0,\"sellerHolidayList\":[\"2021-09-16\",\"2021-09-17\"],\"enforcedPermitPreOrderConfig\":false,\"subscriptionUseYn\":false,\"businessType\":\"PRIVATE\",\"freeReturnInsuranceYn\":false,\"searchableChannelInfoListMap\":{\"STOREFARM\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}]},\"hasTalkTalkChannel\":true,\"brandPackageCatalogType\":false,\"overseas\":false,\"epNaverShoppingOperable\":true,\"creatableChannelInfoListMap\":{\"STOREFARM\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}]},\"updatableChannelInfoListMap\":{\"STOREFARM\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}]},\"epEnuriOperable\":false,\"epDanawaOperable\":false,\"adult\":true}";
		
		cookies = productManageService.naverLogin(user);
		productManageService.naverProductUpload(product, cookies);

		return Result.ok("ok");
	}
}
