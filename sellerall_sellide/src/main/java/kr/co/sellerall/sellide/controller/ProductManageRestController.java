package kr.co.sellerall.sellide.controller;

import java.util.ArrayList;
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
	
	@PostMapping("/v1/dome-detail")
	public String getDomeDetail(@RequestBody String prodCd) {
		logger.debug("/v1/dome-detail , dome-detail 컨트롤러");
		prodCd = prodCd.replace("=","");
		logger.debug("result-> "+ productManageService.domeDetail(prodCd));
		return productManageService.domeDetail(prodCd);
	}
	
	@PostMapping("/v1/storage-product")
	public ResponseEntity<ApiResult> insertStorage(@RequestBody List<StorageProductRequestVO> param, @LoginUser SessionUser user) throws Exception {
		logger.debug("/v1/storage-product , insertStorage 컨트롤러");
		logger.debug("param"+param);
		
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
	
	@PostMapping("/v1/info-stp")
	public Object infoStp(@LoginUser SessionUser user) {
		logger.debug("/v1/info-stp , info-stp 컨트롤러");
		Object result = new Object();
		Map cookies = new HashMap();
		
		cookies = productManageService.naverLogin(user);
		result = productManageService.naverUserInfo(cookies);
		
		logger.debug("result: " + result);
		return result;
	}	
	
	@PostMapping("/v1/register-stp")
	public /*ResponseEntity<ApiResult>*/Object registerStp(@RequestBody JSONObject product, @LoginUser SessionUser user) {
		logger.debug("/v1/register-stp , register-stp 컨트롤러");
		logger.debug("request: "+product);
		
		Map cookies = new HashMap();
		String result = "";
		String returnData = "";
		
		//String request = "{\"product\":{\"saleType\":\"NEW\",\"excludeAdminDiscount\":false,\"excludeGivePresent\":false,\"payExposure\":true,\"images\":[{\"imageType\":\"REPRESENTATIVE\",\"order\":1,\"imageUrl\":\"http://shop1.phinf.naver.net/20210917_110/1631837641820TVr2B_PNG/32973484533839972_1584987784.PNG\",\"width\":264,\"height\":227,\"fileSize\":755}],\"videos\":[],\"detailAttribute\":{\"naverShoppingSearchInfo\":{},\"afterServiceInfo\":{\"afterServiceTelephoneNumber\":\"010-9224-8577\",\"afterServiceGuideContent\":\"제조사에 문의하세요.\"},\"originAreaInfo\":{\"type\":\"LOCAL\",\"originArea\":{\"code\":\"0002281\"}},\"sellerCodeInfo\":{\"sellerManagementCode\":\"\",\"sellerBarcode\":\"\",\"sellerCustomCode1\":\"\",\"sellerCustomCode2\":\"\"},\"seoInfo\":{\"sellerTags\":[],\"pageTitle\":\"\",\"metaDescription\":\"\"},\"optionInfo\":{\"optionUsable\":false,\"options\":[],\"optionCombinations\":[],\"optionStandards\":[],\"optionDeliveryAttributes\":[],\"useStockManagement\":true},\"supplementProductInfo\":{\"sortType\":\"CREATE\",\"count\":0,\"usable\":false,\"supplementProducts\":[]},\"purchaseReviewInfo\":{\"purchaseReviewExposure\":true},\"customMadeInfo\":{\"customMade\":false},\"taxType\":\"TAX\",\"productCertificationInfos\":[],\"minorPurchasable\":true,\"productInfoProvidedNotice\":{\"productInfoProvidedNoticeType\":\"ETC\",\"productInfoProvidedNoticeContent\":{\"templateType\":\"PRODUCT_INFO_PROVIDED_NOTICE\",\"productInfoProvidedNoticeType\":\"ETC\",\"returnCostReason\":\"0\",\"noRefundReason\":\"0\",\"qualityAssuranceStandard\":\"0\",\"compensationProcedure\":\"0\",\"troubleShootingContents\":\"0\",\"itemName\":\"상세정보 참조\",\"modelName\":\"상세정보 참조\",\"certificateDetails\":\"상세정보 참조\",\"manufacturer\":\"상세정보 참조\",\"afterServiceDirector\":\"상세정보 참조\"}},\"productAttributes\":[],\"consumptionTax\":\"TEN\",\"certificationTargetExcludeContent\":{\"kcYn\":\"TRUE\"},\"useReturnCancelNotification\":false},\"detailContent\":{\"editorType\":\"NONE\",\"editorTypeForEditor\":\"SEONE\",\"existsRemoveTags\":false,\"productDetailInfoContent\":\"testcontent\"},\"deliveryInfo\":{\"deliveryType\":\"DELIVERY\",\"deliveryAttributeType\":\"NORMAL\",\"deliveryFee\":{\"deliveryFeeType\":\"PAID\",\"baseFee\":2500,\"deliveryFeePayType\":\"PREPAID\",\"deliveryFeeByArea\":{\"deliveryAreaType\":\"AREA_3\",\"area2extraFee\":3000,\"area3extraFee\":5000}},\"claimDeliveryInfo\":{\"returnDeliveryCompany\":{\"regDate\":\"2020-08-19T14:05:40.011+0000\",\"modDate\":\"2020-08-19T14:05:40.011+0000\",\"regAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"modAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"id\":1146763,\"accountNo\":100807757,\"returnDeliveryCompanyPriorityType\":\"PRIMARY\",\"naverPayAppointment\":true,\"deliveryCompanyName\":\"우체국택배\"},\"returnDeliveryCompanySeq\":1146763,\"returnDeliveryFee\":2500,\"exchangeDeliveryFee\":5000,\"shippingAddress\":{\"id\":102324513,\"accountNo\":100807757,\"alias\":\"상품출고지\",\"addressType\":\"RELEASE\",\"addressInfo\":{\"fullAddressInfo\":\"인천광역시 서구 봉오재2로 37 (엘에이치웨스턴블루힐) 210동 2404호 (우 : 22732) \"},\"isOverseas\":false},\"shippingAddressId\":102324513,\"returnAddress\":{\"id\":102324514,\"accountNo\":100807757,\"alias\":\"반품교환지\",\"addressType\":\"REFUND_OR_EXCHANGE\",\"addressInfo\":{\"fullAddressInfo\":\"인천광역시 서구 봉오재2로 37 (엘에이치웨스턴블루힐) 210동 2404호 (우 : 22732) \"},\"isOverseas\":false},\"returnAddressId\":102324514,\"freeReturnInsuranceYn\":false},\"installationFee\":false,\"accountNo\":100807757,\"cloneDeliveryAttributeType\":\"NORMAL\",\"customMadeDirectInputYn\":false,\"expectedDeliveryPeriodType\":\"\",\"expectedDeliveryPeriodDirectInput\":\"\"},\"customerBenefit\":{},\"productStats\":{},\"representImageUrl\":\"\",\"useSalePeriod\":false,\"category\":{\"id\":\"50001914\",\"parentId\":\"50000024\",\"name\":\"헬스보충제\",\"wholeCategoryId\":\"50000006>50000024>50001914\",\"wholeCategoryName\":\"식품>다이어트식품>헬스보충제\",\"level\":3,\"lastLevel\":true,\"deleted\":false,\"sellBlogUse\":true,\"sortOrder\":0,\"juvenileHarmful\":false,\"$promise\":{},\"$resolved\":true,\"$order\":21,\"exceptionalCategoryTypes\":[\"REVIEW_UNEXPOSE\",\"REGULAR_SUBSCRIPTION\"],\"exceptionalCategoryAttributes\":[]},\"name\":\"hamtest\",\"liveDiscountBenefit\":null,\"salePrice\":\"11300\",\"stockQuantity\":\"11\"},\"savedTemplate\":{\"EVENT_PHRASE\":false},\"singleChannelProductMap\":{\"STOREFARM\":{\"id\":\"\",\"selfProductNameUsable\":false,\"channelProductName\":\"\",\"channelServiceType\":\"STOREFARM\",\"channelProductType\":\"SINGLE\",\"channel\":null,\"epInfo\":{\"naverShoppingRegistration\":true,\"enuriRegistration\":false,\"danawaRegistration\":false,\"naverDisabled\":false,\"enuriDisabled\":true,\"danawaDisabled\":true,\"disabledAll\":false},\"channelProductDisplayStatusType\":\"ON\",\"channelProductStatusType\":\"NORMAL\",\"storeKeepExclusiveProduct\":false,\"orderRequestUsable\":false,\"best\":false,\"bbsConfig\":false,\"materialImages\":[],\"tagImages\":[],\"barcodeImage\":null,\"affiliateInfo\":{\"affiliateYn\":false},\"channelNo\":100870126}},\"representNo\":100779884,\"representName\":\"만화상회\",\"representativeBirthDay\":\"1981-09-07T15:00:00.000+0000\",\"representType\":\"DOMESTIC_BUSINESS\",\"productRegistAuthCategories\":[\"HEALTH_FUNC_FOOD\"],\"accountNo\":100807757,\"accountId\":\"ncp_1o0nrh_01\",\"advertiser\":true,\"mallSeq\":1953499,\"defaultChannelNo\":100870126,\"accountExternalStatusType\":\"NORMAL\",\"npayRefKey\":\"510817653\",\"payUseYn\":true,\"actionGrade\":\"FOURTH\",\"branchUseYn\":false,\"sellerNo\":510817653,\"ownerChannelInfoList\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}],\"thisDayDispatchBasisHour\":16,\"thisDayDispatchBasisMinute\":0,\"sellerHolidayList\":[\"2021-09-16\",\"2021-09-17\"],\"enforcedPermitPreOrderConfig\":false,\"subscriptionUseYn\":false,\"businessType\":\"PRIVATE\",\"freeReturnInsuranceYn\":false,\"searchableChannelInfoListMap\":{\"STOREFARM\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}]},\"hasTalkTalkChannel\":true,\"brandPackageCatalogType\":false,\"overseas\":false,\"epNaverShoppingOperable\":true,\"creatableChannelInfoListMap\":{\"STOREFARM\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}]},\"updatableChannelInfoListMap\":{\"STOREFARM\":[{\"id\":100870126,\"accountNo\":100807757,\"type\":\"STOREFARM\",\"name\":\"만화상회\",\"url\":\"manhwasuper\",\"channelExternalStatusType\":\"NORMAL\",\"talkAccountId\":\"w4ue50\",\"talkExposure\":true,\"subVerticalServiceTypes\":[],\"payUseYn\":true,\"channelServiceType\":\"STOREFARM\",\"fullUrl\":\"https://smartstore.naver.com/manhwasuper\",\"mobileUrl\":\"https://m.smartstore.naver.com/manhwasuper\"}]},\"epEnuriOperable\":false,\"epDanawaOperable\":false,\"adult\":true}";
		
		cookies = productManageService.naverLogin(user);
		result = productManageService.naverProductUpload(product, cookies);
		
		return result;
	}
	
	@PostMapping("/v1/register-stp-after")
	public String registerStpAfter(@RequestBody StorageProductRequestVO param, @LoginUser SessionUser user) {
		logger.debug("/v1/register-stp-after , register-stp-after 컨트롤러");
		
		String result = "";
		result = productManageService.updateRegisterCode(param, user);
		
		return result;
	}
	
	@PostMapping("/v1/edit-stp")
	public Object editStp(@RequestBody JSONObject product, @LoginUser SessionUser user) {
		logger.debug("/v1/edit-stp , edit-stp 컨트롤러");
		Map cookies = new HashMap();
		String result = "";
		
		String request = "{\"product\":{\"regDate\":\"2021-09-30T01:24:33.519+0000\",\"modDate\":\"2021-09-30T01:28:11.810+0000\",\"regAuditInfo\":{\"memberNo\":101946549,\"loginId\":\"as****@naver.com\",\"name\":\"권*상\",\"memberType\":\"BUSINESS\",\"ip\":\"115.137.99.36\",\"requestId\":\"m-Muca0VTGuzAZSdhk1paA\",\"isMasking\":true,\"adminViewText\":\"as****@naver.com(BUSINESS)\"},\"modAuditInfo\":{\"memberNo\":101946549,\"loginId\":\"as****@naver.com\",\"name\":\"권*상\",\"memberType\":\"BUSINESS\",\"ip\":\"115.137.99.36\",\"requestId\":\"m-Muca0VTGuzAZSdhk1paA\",\"isMasking\":true,\"adminViewText\":\"as****@naver.com(BUSINESS)\"},\"id\":5867688237,\"accountNo\":100807757,\"name\":\"product edit test\",\"salePrice\":1230,\"stockQuantity\":999,\"statusType\":\"SALE\",\"saleType\":\"NEW\",\"excludeAdminDiscount\":false,\"excludeGivePresent\":false,\"payExposure\":true,\"category1Id\":\"50000006\",\"category2Id\":\"50000024\",\"category3Id\":\"50001914\",\"category\":{\"id\":\"50001914\",\"parentId\":\"50000024\",\"baseId\":\"50000006\",\"name\":\"헬스보충제\",\"level\":3,\"lastLevel\":true,\"sortOrder\":0,\"wholeCategoryId\":\"50000006>50000024>50001914\",\"wholeCategoryName\":\"식품>다이어트식품>헬스보충제\",\"impossibleByCredit\":false,\"deleted\":false,\"serviceUse\":true,\"restrictCategory\":null,\"sellBlogUseYn\":true,\"exceptionalCategoryTypes\":[\"REVIEW_UNEXPOSE\",\"REGULAR_SUBSCRIPTION\"],\"largeCategoryName\":\"식품\",\"middleCategoryName\":\"다이어트식품\",\"smallCategoryName\":\"헬스보충제\",\"exceptionalCategoryAttributes\":[],\"sellBlogUse\":true,\"juvenileHarmful\":false,\"$promise\":{},\"$resolved\":true},\"images\":[{\"imageType\":\"REPRESENTATIVE\",\"order\":1,\"imageUrl\":\"http://shop1.phinf.naver.net/20210917_110/1631837641820TVr2B_PNG/32973484533839972_1584987784.PNG\",\"width\":264,\"height\":227,\"fileSize\":755}],\"videos\":[],\"videoRegisterYn\":false,\"detailAttribute\":{\"id\":5867688237,\"afterServiceInfo\":{\"afterServiceTelephoneNumber\":\"010-9224-8577\",\"afterServiceGuideContent\":\"제조사에 문의하세요.\"},\"originAreaInfo\":{\"type\":\"LOCAL\",\"originArea\":{\"code\":\"0002820\"},\"plural\":false},\"seoInfo\":{\"sellerTags\":[],\"pageTitle\":\"\",\"metaDescription\":\"\"},\"optionInfo\":{\"optionUsable\":false,\"useStockManagement\":true,\"useDispatchPolicyManagement\":false,\"options\":[],\"optionCombinations\":[],\"optionStandards\":[],\"optionDeliveryAttributes\":[]},\"supplementProductInfo\":{\"sortType\":\"CREATE\",\"count\":0,\"usable\":false,\"supplementProducts\":null},\"purchaseReviewInfo\":{\"purchaseReviewExposure\":true},\"customMadeInfo\":{\"customMade\":false},\"taxType\":\"TAX\",\"certification\":false,\"productCertificationInfos\":[],\"certificationTargetExcludeContent\":{\"kcYn\":\"TRUE\"},\"minorPurchasable\":true,\"productInfoProvidedNotice\":{\"id\":4867551086,\"productInfoProvidedNoticeType\":\"ETC\",\"productInfoProvidedNoticeContent\":{\"templateType\":\"PRODUCT_INFO_PROVIDED_NOTICE\",\"productInfoProvidedNoticeType\":\"ETC\",\"returnCostReason\":\"0\",\"noRefundReason\":\"0\",\"qualityAssuranceStandard\":\"0\",\"compensationProcedure\":\"0\",\"troubleShootingContents\":\"0\",\"itemName\":\"상세설명 참조\",\"modelName\":\"상세설명 참조\",\"certificateDetails\":\"상세설명 참조\",\"manufacturer\":\"상세설명 참조\",\"afterServiceDirector\":\"상세설명 참조\"}},\"productAttributeUsable\":false,\"productAttributes\":[],\"detailContentTextInfo\":{\"detailContentText\":\"test\",\"excessDetailContentText\":false},\"editorType\":\"NONE\",\"mobileDetailType\":\"ORIGINAL\",\"itselfProductionProductYn\":false,\"consumptionTax\":\"TEN\",\"naverShoppingSearchInfo\":{\"manufacturerName\":\"\",\"brandName\":\"\",\"brandId\":\"\",\"modelName\":\"\",\"modelId\":\"\"},\"useReturnCancelNotification\":false,\"sellerCodeInfo\":{\"sellerManagementCode\":\"\",\"sellerBarcode\":\"\",\"sellerCustomCode1\":\"\",\"sellerCustomCode2\":\"\"}},\"detailContent\":{\"id\":5867688237,\"productDetailInfoContent\":\"test\",\"editorType\":\"NONE\",\"mobileProductDetailPreviewType\":\"SNAP\",\"mobileDetailType\":\"ORIGINAL\",\"editorTypeForEditor\":\"NONE\",\"existsRemoveTags\":false},\"deliveryInfo\":{\"deliveryType\":\"DELIVERY\",\"deliveryAttributeType\":\"NORMAL\",\"deliveryFee\":{\"deliveryFeeType\":\"UNIT_QUANTITY_PAID\",\"baseFee\":2500,\"repeatQuantity\":10,\"deliveryFeePayType\":\"PREPAID\",\"deliveryFeeByArea\":{\"deliveryAreaType\":\"AREA_3\",\"area2extraFee\":3000,\"area3extraFee\":5000}},\"claimDeliveryInfo\":{\"returnDeliveryCompany\":{\"regDate\":\"2020-08-19T14:05:40.011+0000\",\"modDate\":\"2020-08-19T14:05:40.011+0000\",\"regAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"modAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"id\":1146763,\"accountNo\":100807757,\"returnDeliveryCompanyPriorityType\":\"PRIMARY\",\"naverPayAppointment\":true,\"deliveryCompanyName\":\"우체국택배\"},\"returnDeliveryCompanySeq\":1146763,\"returnDeliveryFee\":2500,\"exchangeDeliveryFee\":5000,\"shippingAddress\":{\"id\":102324513,\"accountNo\":100807757,\"alias\":\"상품출고지\",\"addressType\":\"RELEASE\",\"addressInfo\":{\"fullAddressInfo\":\"인천광역시 서구 봉오재2로 37 (엘에이치웨스턴블루힐) 210동 2404호 (우 : 22732) \"},\"isOverseas\":false},\"shippingAddressId\":102324513,\"returnAddress\":{\"id\":103700361,\"accountNo\":100807757,\"alias\":\"지성아이엔씨\",\"addressType\":\"GENERAL\",\"addressInfo\":{\"fullAddressInfo\":\"경기도 부천시 부천로198번길 36 (춘의테크노파크) 101동 807호 (우 : 14557) \"},\"isOverseas\":false},\"returnAddressId\":103700361,\"freeReturnInsuranceYn\":false},\"installationFee\":false,\"accountNo\":100807757,\"id\":4872308134,\"cloneDeliveryAttributeType\":\"NORMAL\",\"customMadeDirectInputYn\":false,\"expectedDeliveryPeriodType\":\"\",\"expectedDeliveryPeriodDirectInput\":\"\"},\"customerBenefit\":{\"id\":4867958210},\"singleChannelProducts\":null,\"productStats\":null,\"representImageUrl\":\"http://shop1.phinf.naver.net/20210917_110/1631837641820TVr2B_PNG/32973484533839972_1584987784.PNG\",\"useSalePeriod\":false,\"liveDiscountBenefit\":null},\"savedTemplate\":{\"EVENT_PHRASE\":false},\"singleChannelProductMap\":{\"STOREFARM\":{\"channelProductType\":\"SINGLE\",\"regDate\":\"2021-09-30T01:24:33.524+0000\",\"modDate\":\"2021-09-30T01:28:11.810+0000\",\"regAuditInfo\":{\"memberNo\":101946549,\"loginId\":\"as****@naver.com\",\"name\":\"권*상\",\"memberType\":\"BUSINESS\",\"ip\":\"115.137.99.36\",\"requestId\":\"m-Muca0VTGuzAZSdhk1paA\",\"isMasking\":true,\"adminViewText\":\"as****@naver.com(BUSINESS)\"},\"modAuditInfo\":{\"memberNo\":101946549,\"loginId\":\"as****@naver.com\",\"name\":\"권*상\",\"memberType\":\"BUSINESS\",\"ip\":\"115.137.99.36\",\"requestId\":\"m-Muca0VTGuzAZSdhk1paA\",\"isMasking\":true,\"adminViewText\":\"as****@naver.com(BUSINESS)\"},\"id\":5894871096,\"channelServiceType\":\"STOREFARM\",\"channelNo\":100870126,\"channelProductSupplyType\":\"OWNER\",\"channelProductDisplayStatusType\":\"SUSPENSION\",\"channelProductStatusType\":\"NORMAL\",\"images\":[],\"videos\":null,\"productAttributes\":null,\"storeKeepExclusiveProduct\":false,\"orderRequestUsable\":false,\"epInfo\":{\"naverShoppingRegistration\":true,\"enuriRegistration\":false,\"danawaRegistration\":false,\"syncNvMid\":83439370510,\"naverDisabled\":false,\"enuriDisabled\":true,\"danawaDisabled\":true,\"disabledAll\":false},\"best\":false,\"product\":{\"regDate\":\"2021-09-30T01:24:33.519+0000\",\"modDate\":\"2021-09-30T01:28:11.810+0000\",\"regAuditInfo\":{\"memberNo\":101946549,\"loginId\":\"as****@naver.com\",\"name\":\"권*상\",\"memberType\":\"BUSINESS\",\"ip\":\"115.137.99.36\",\"requestId\":\"m-Muca0VTGuzAZSdhk1paA\",\"isMasking\":true,\"adminViewText\":\"as****@naver.com(BUSINESS)\"},\"modAuditInfo\":{\"memberNo\":101946549,\"loginId\":\"as****@naver.com\",\"name\":\"권*상\",\"memberType\":\"BUSINESS\",\"ip\":\"115.137.99.36\",\"requestId\":\"m-Muca0VTGuzAZSdhk1paA\",\"isMasking\":true,\"adminViewText\":\"as****@naver.com(BUSINESS)\"},\"id\":5867688237,\"accountNo\":100807757,\"name\":\"test22\",\"salePrice\":1230,\"stockQuantity\":999,\"statusType\":\"SALE\",\"saleType\":\"NEW\",\"excludeAdminDiscount\":false,\"excludeGivePresent\":false,\"payExposure\":true,\"saleStartDate\":\"1998-12-31T15:00:00.000+0000\",\"saleEndDate\":\"9999-12-31T14:59:59.999+0000\",\"category1Id\":\"50000006\",\"category2Id\":\"50000024\",\"category3Id\":\"50001914\",\"category\":{\"id\":\"50001914\",\"parentId\":\"50000024\",\"baseId\":\"50000006\",\"name\":\"헬스보충제\",\"level\":3,\"lastLevel\":true,\"sortOrder\":6,\"wholeCategoryId\":\"50000006>50000024>50001914\",\"wholeCategoryName\":\"식품>다이어트식품>헬스보충제\",\"impossibleByCredit\":false,\"deleted\":false,\"serviceUse\":true,\"restrictCategory\":null,\"sellBlogUseYn\":true,\"exceptionalCategoryTypes\":[\"REVIEW_UNEXPOSE\",\"REGULAR_SUBSCRIPTION\"],\"largeCategoryName\":\"식품\",\"middleCategoryName\":\"다이어트식품\",\"smallCategoryName\":\"헬스보충제\"},\"images\":[{\"order\":1,\"imageUrl\":\"http://shop1.phinf.naver.net/20210917_110/1631837641820TVr2B_PNG/32973484533839972_1584987784.PNG\",\"width\":264,\"height\":227,\"fileSize\":755,\"id\":41274877262,\"imageType\":\"REPRESENTATIVE\"}],\"videos\":[],\"videoRegisterYn\":false,\"detailAttribute\":{\"id\":5867688237,\"afterServiceInfo\":{\"afterServiceTelephoneNumber\":\"010-9224-8577\",\"afterServiceGuideContent\":\"제조사에 문의하세요.\"},\"originAreaInfo\":{\"type\":\"LOCAL\",\"content\":\"국산(경기도 가평군)\",\"originArea\":{\"code\":\"0002820\",\"name\":\"가평군\",\"usable\":true,\"parentCode\":\"0002\",\"wholeCodes\":[\"00\",\"0002\",\"0002820\"]},\"originAreaCode\":\"0002820\",\"plural\":false},\"seoInfo\":{\"sellerTags\":[]},\"optionInfo\":{\"optionUsable\":false,\"useStockManagement\":true,\"useDispatchPolicyManagement\":false,\"options\":null,\"optionCombinations\":null,\"optionStandards\":null,\"optionDeliveryAttributes\":null},\"supplementProductInfo\":{\"sortType\":\"CREATE\",\"count\":0,\"usable\":false,\"supplementProducts\":null},\"purchaseReviewInfo\":{\"purchaseReviewExposure\":true},\"customMadeInfo\":{\"customMade\":false},\"taxType\":\"TAX\",\"certification\":false,\"productCertificationInfos\":[],\"certificationTargetExcludeContent\":{},\"minorPurchasable\":true,\"productInfoProvidedNotice\":{\"id\":4867551086,\"productInfoProvidedNoticeType\":\"ETC\",\"productInfoProvidedNoticeContent\":{\"templateType\":\"PRODUCT_INFO_PROVIDED_NOTICE\",\"productInfoProvidedNoticeType\":\"ETC\",\"returnCostReason\":\"0\",\"noRefundReason\":\"0\",\"qualityAssuranceStandard\":\"0\",\"compensationProcedure\":\"0\",\"troubleShootingContents\":\"0\",\"itemName\":\"상세설명 참조\",\"modelName\":\"상세설명 참조\",\"certificateDetails\":\"상세설명 참조\",\"manufacturer\":\"상세설명 참조\",\"afterServiceDirector\":\"상세설명 참조\"}},\"productAttributeUsable\":false,\"productAttributes\":[],\"detailContentTextInfo\":{\"detailContentText\":\"test\",\"excessDetailContentText\":false},\"editorType\":\"NONE\",\"mobileDetailType\":\"ORIGINAL\",\"itselfProductionProductYn\":false,\"consumptionTax\":\"TEN\"},\"detailContent\":{\"id\":5867688237,\"productDetailInfoContent\":\"test\",\"editorType\":\"NONE\",\"mobileProductDetailPreviewType\":\"SNAP\",\"mobileDetailType\":\"ORIGINAL\",\"editorTypeForEditor\":\"NONE\",\"existsRemoveTags\":false},\"deliveryInfo\":{\"deliveryType\":\"DELIVERY\",\"deliveryAttributeType\":\"NORMAL\",\"deliveryFee\":{\"deliveryFeeType\":\"UNIT_QUANTITY_PAID\",\"baseFee\":2500,\"repeatQuantity\":10,\"deliveryFeePayType\":\"PREPAID\",\"deliveryFeeByArea\":{\"deliveryAreaType\":\"AREA_3\",\"area2extraFee\":3000,\"area3extraFee\":5000}},\"claimDeliveryInfo\":{\"returnDeliveryCompany\":{\"regDate\":\"2020-08-19T14:05:40.011+0000\",\"modDate\":\"2020-08-19T14:05:40.011+0000\",\"regAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"modAuditInfo\":{\"memberNo\":101057393,\"loginId\":\"as****\",\"name\":\"권*상\",\"memberType\":\"NAVER\",\"ip\":\"49.168.141.108\",\"requestId\":\"0dmVJtm4TeaSd_3-Yd7AQQ\",\"isMasking\":true,\"adminViewText\":\"as****(NAVER)\"},\"id\":1146763,\"accountNo\":100807757,\"returnDeliveryCompanyPriorityType\":\"PRIMARY\",\"naverPayAppointment\":true,\"deliveryCompanyName\":\"우체국택배\"},\"returnDeliveryCompanySeq\":1146763,\"returnDeliveryFee\":2500,\"exchangeDeliveryFee\":5000,\"shippingAddress\":{\"id\":102324513,\"accountNo\":100807757,\"alias\":\"상품출고지\",\"addressType\":\"RELEASE\",\"addressInfo\":{\"fullAddressInfo\":\"인천광역시 서구 봉오재2로 37 (엘에이치웨스턴블루힐) 210동 2404호 (우 : 22732) \"},\"isOverseas\":false},\"shippingAddressId\":102324513,\"returnAddress\":{\"id\":103700361,\"accountNo\":100807757,\"alias\":\"지성아이엔씨\",\"addressType\":\"GENERAL\",\"addressInfo\":{\"fullAddressInfo\":\"경기도 부천시 부천로198번길 36 (춘의테크노파크) 101동 807호 (우 : 14557) \"},\"isOverseas\":false},\"returnAddressId\":103700361,\"freeReturnInsuranceYn\":false},\"installationFee\":false,\"accountNo\":100807757,\"id\":4872308134},\"customerBenefit\":{\"id\":4867958210},\"singleChannelProducts\":null,\"productStats\":null,\"representImageUrl\":\"http://shop1.phinf.naver.net/20210917_110/1631837641820TVr2B_PNG/32973484533839972_1584987784.PNG\",\"useSalePeriod\":false},\"productNo\":5867688237,\"affiliateInfo\":{\"affiliateYn\":false},\"representImageUrl\":\"\",\"bbsConfig\":false,\"selfProductNameUsable\":false}}}";

		cookies = productManageService.naverLogin(user);
		result = productManageService.naverProductEdit(request, cookies);
		
		return result;
	}
	
	//등록상품 관리
	@PostMapping("/v1/registered-list")
	public ResultVO getRegisteredList(@RequestBody StorageProductRequestVO param, @LoginUser SessionUser user) throws Exception {
		logger.debug("/v1/registered-list , getRegisteredList 컨트롤러");
		ResultVO resultVO = productManageService.registeredProductList(param,user);
		return resultVO;
	}
}
