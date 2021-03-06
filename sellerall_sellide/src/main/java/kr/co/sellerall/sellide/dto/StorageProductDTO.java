package kr.co.sellerall.sellide.dto;

import java.time.LocalDateTime;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;
import kr.co.sellerall.sellide.component.CommonUtil;
import kr.co.sellerall.sellide.domain.productManager.TbProduct;
import kr.co.sellerall.sellide.vo.StorageProductRequestVO;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StorageProductDTO{
	private String prodIdx;			/* 사용자상품index (auto_increment) */
	private String editCd;			/* 네이버 수정 코드*/
	private String linkCd;			/* 네이버 상품 등록 코드*/
	private String userId;			/* 사용자 ID */	
	private String partnerCd;		/* 거래처코드 */			/*( 필수) */	
	private String prodCd;			/* 상품코드 */				/*( 필수) */
	private String prodNm;			/* 상품명 */				/*( 필수) */
	private String categoryCd;		/* 카테고리 코드 */			/*( 필수) */
	private String categoryLCd;		/* 카테고리대 코드 */	
	private String categoryLNm;		/* 카테고리대 명 */	
	private String categoryMCd;		/* 카테고리중 코드 */	
	private String categoryMNm;		/* 카테고리중 명 */	
	private String categorySCd;		/* 카테고리소 코드 */
	private String categorySNm;		/* 카테고리소 명 */
	private String uprodNm;			/* 사용자수정상품명 */	
	private String wdmCd;			/* 왕도매 카테고리 코드 */	
	private String gmkCd;			/* g마켓 카테고리 코드 */
	private String aucCd; 			/* 옥션 카테고리 코드 */	
	private String estCd; 			/* 11번가 카테고리 코드 */	
	private String itpCd;			/* 인터파크 카테고리 코드 */	
	private String stpCd; 			/* 스토어팜 카테고리 코드 */
	private String couCd; 			/* 쿠팡 카테고리 코드 */
	private Integer prodPrice; 		/* 상품가격 */
	private Integer uProdPrice; 	/* 사용자상품가격 */
	private Integer uSalePrice; 	/* 사용자판매가격 */
	private Integer consumerPrice; 	/* 소비자가격 */
	private Integer uConsumerPrice; /* 사용자소비자가격 */
	private String consumerYn; 		/* 가격자율여부(y:준수, n:자율) */
	private String deliFlag; 		/* 배송구분(h:선/착불, f:무료, g:착불, s:선불) */
	private String uDeliFlag; 		/* 사용자배송구분(h:선/착불, f:무료, g:착불, s:선불) */
	private String deliPrice; 		/* 배송비 */
	private String udeliPrice; 		/* 사용자배송비 */
	private String returnYn; 		/* 반품여부 */
	private String ureturnYn; 		/* 사용자반품여부 */
	private String ureturnPrice; 	/* 사용자반품배송비 */
	private String ureturnPlace; 	/* 사용자반품배송지코드(오너클랜제공) */   
	private String madePlace; 		/* 원산지 */
	private String umadePlace; 		/* 사용자원산지 */
	private String maker; 			/* 제조사 */
	private String brand; 			/* 브랜드 */
	private String ubrand; 			/* 사용자브랜드 */
	private String model; 			/* 모델명 */
	private String listImg; 		/* 리스트이미지 */
	private String uListImg; 		/* 사용자리스트이미지 */
	private String content; 		/* 상세설명 */
	private String uContent; 		/* 사용자상세설명 */
	private String uIntro; 			/* 사용자상단설명 */
	private Integer lOptionCnt; 	/* 옵션개수 */
	private String lOption; 		/* 옵션 */
	private String ulOption; 		/* 사용자옵션 */
	private String lOptionPrice; 	/* 옵션가격 */
	private String ulOptionPrice; 	/* 사용자옵션가격 */
	private Integer boxQty; 		/* 묶음수량 */
	private Integer uBoxQty; 		/* 사용자묶음수량 */
	private String uKeyword; 		/* 사용자키워드 */
	private String prodStatus; 		/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
	private String adultYn; 		/* 성인용품여부 */
	private String uAdultYn; 		/* 사용자성인용품여부 */
	private String taxYn; 			/* 과세여부 */															/*( 필수) */
	private String useYn; 			/* 사용여부 */															/*( 필수) */
	private String authInfo1; 		/* 인증정보1 */
	private String authInfo2; 		/* 인증정보2(상품속성 - 1:건강식품, 2:의료용품, 3:해외직배송, 4:해외직구, 5:유통금지상품) */
	private String authInfo3; 		/* 인증정보3 */
	private LocalDateTime crtDate; 	/* 등록일 */
	private String crtName; 		/* 등록아이디 */
	private LocalDateTime uptDate; 	/* 수정일 */
	private String uptName; 		/* 수정아이디 */
	private String shExplan;		/* 짧은설명 */
	private String asFlag; 			/* A/S가능여부	*/
	private String deliArea; 		/* 배송가능지역 */													 	/*( 필수) */
	private String deliAreaExplan; 	/* 배송가능지역추가설명  */
	private String priceSub; 		/* 가격대체문구	*/
	private String invenType; 		/* 재고적용타입(0:무제한, 1:한정) */									 	/*( 필수) */
	private Integer invenCnt; 		/* 재고수량 */
	private Integer invenNtCnt; 	/* 재고통보수량 */
	private Integer minOrderLimit; 	/* 최소주문한도 */
	private Integer maxOrderLimit; 	/* 최대주문한도 */
	private String reserves; 		/* 적립금 */
	private String salesStDate; 	/* 판매기간 시작일 (YYYY-MM-DD) */
	private String salesEdDate; 	/* 판매기간 종료일 (YYYY-MM-DD) */
	private String impoLevel; 		/* 구매가능레벨 (10:제한없음, 9:일반회원, 8:우수회원, 7:특별회원, 6~2:가맹점)*/	/*( 필수) */
	private String priceOpen; 		/* 가격공개(0:사용안함, 1:사용함) */										/*( 필수) */
	private String deliType; 		/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */			/*( 필수) */
	private String deliPay; 		/* 배송비결제 (0: 선불, 1:착불) */										/*( 필수) */
	private String imgEnType; 		/* 이미지등록방식(0:직접 업로드, 1:URL 입력) */								/*( 필수) */
	private String img1; 			/* 이미지1 */															/*( 필수) */
	private String img2; 			/* 이미지2 */															/*( 필수) */
	private String img3; 			/* 이미지3 */
	private String img4; 			/* 이미지4 */
	private String img5; 			/* 이미지5 */
	private String img6; 			/* 이미지6 */	
	private String adminMemo; 		/* 관리자메모 */
	private String margin;
	//@Builder(builderMethodName = "productBuilder")
	@Builder
    public StorageProductDTO(TbProduct product,StorageProductRequestVO param,SessionUser user){
		if(product != null) {
			if(product.getProdIdx() != null && product.getProdIdx().length() > 0) {
	    		this.prodIdx = product.getProdIdx();	/* 사용자상품index (auto_increment) */
	    	}
			this.userId = product.getUserId();			/* 사용자 ID */
			this.partnerCd = product.getPartnerCd();	/* 거래처코드 */			/*( 필수) */
			this.prodCd = product.getProdCd();			/* 상품코드 */				/*( 필수) */
			this.prodNm = product.getProdNm();			/* 상품명 */				/*( 필수) */
			this.uprodNm = product.getUprodNm();		/* 사용자수정상품명 */
			this.wdmCd = product.getWdmCd();			/* 왕도매 카테고리 코드 */
			this.gmkCd = product.getGmkCd();			/* g마켓 카테고리 코드 */
			this.aucCd = product.getAucCd(); 			/* 옥션 카테고리 코드 */
		    this.estCd = product.getEstCd(); 			/* 11번가 카테고리 코드 */
		    this.itpCd = product.getItpCd();			/* 인터파크 카테고리 코드 */
		    this.stpCd = product.getStpCd(); 			/* 스토어팜 카테고리 코드 */
		    this.couCd = product.getCouCd(); 			/* 쿠팡 카테고리 코드 */
		    this.prodPrice = product.getProdPrice(); 			/* 상품가격 */
		    this.uProdPrice = product.getUProdPrice(); 			/* 사용자상품가격 */
		    this.uSalePrice = product.getUSalePrice(); 			/* 사용자판매가격 */
		    this.consumerPrice = product.getConsumerPrice(); 	/* 소비자가격 */
		    this.uConsumerPrice = product.getUConsumerPrice(); 	/* 사용자소비자가격 */
		    this.consumerYn = product.getConsumerYn(); 			/* 가격자율여부(y:준수, n:자율) */
		    this.deliFlag = product.getDeliFlag(); 				/* 배송구분(h:선/착불, f:무료, g:착불, s:선불) */
		    this.uDeliFlag = product.getUDeliFlag(); 			/* 사용자배송구분(h:선/착불, f:무료, g:착불, s:선불) */
		    this.deliPrice = product.getDeliPrice(); 			/* 배송비 */
		    this.udeliPrice = product.getUdeliPrice(); 			/* 사용자배송비 */
		    this.returnYn = product.getReturnYn(); 				/* 반품여부 */
		    this.ureturnYn = product.getUreturnYn(); 			/* 사용자반품여부 */
		    this.ureturnPrice = product.getUreturnPrice(); 		/* 사용자반품배송비 */
		    this.ureturnPlace = product.getUreturnPlace(); 		/* 사용자반품배송지코드(오너클랜제공) */
		    this.madePlace = product.getMadePlace(); 			/* 원산지 */
		    this.umadePlace = product.getUmadePlace(); 			/* 사용자원산지 */
		    this.maker = product.getMaker(); 					/* 제조사 */
		    this.brand = product.getBrand(); 					/* 브랜드 */
		    this.ubrand = product.getUbrand(); 					/* 사용자브랜드 */
		    this.model = product.getModel(); 					/* 모델명 */
		    this.listImg = product.getListImg(); 				/* 리스트이미지 */
		    this.uListImg = product.getUListImg(); 				/* 사용자리스트이미지 */
		    this.content = product.getContent(); 				/* 상세설명 */
		    this.uContent = product.getUContent(); 				/* 사용자상세설명 */
		    this.uIntro = product.getUIntro(); 					/* 사용자상단설명 */
		    this.lOptionCnt = product.getLOptionCnt(); 			/* 옵션개수 */
		    this.lOption = product.getLOption(); 				/* 옵션 */
		    this.ulOption = product.getUlOption(); 				/* 사용자옵션 */
		    this.lOptionPrice = product.getLOptionPrice(); 		/* 옵션가격 */
		    this.ulOptionPrice = product.getUlOptionPrice(); 	/* 사용자옵션가격 */
		    this.boxQty = product.getBoxQty(); 					/* 묶음수량 */
		    this.uBoxQty = product.getUBoxQty(); 				/* 사용자묶음수량 */
		    this.uKeyword = product.getUKeyword(); 				/* 사용자키워드 */
		    this.prodStatus = product.getProdStatus(); 			/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
		    this.adultYn = product.getAdultYn(); 				/* 성인용품여부 */
		    this.uAdultYn = product.getUAdultYn(); 				/* 사용자성인용품여부 */
		    this.taxYn = product.getTaxYn(); 					/* 과세여부 */					/*( 필수) */
		    this.useYn = product.getUseYn(); 					/* 사용여부 */					/*( 필수) */
		    this.authInfo1 = product.getAuthInfo1(); 			/* 인증정보1 */
		    this.authInfo2 = product.getAuthInfo2(); 			/* 인증정보2(상품속성 - 1:건강식품, 2:의료용품, 3:해외직배송, 4:해외직구, 5:유통금지상품) */
		    this.authInfo3 = product.getAuthInfo3(); 			/* 인증정보3 */
		    this.crtName = user.getEmail(); 					/* 등록아이디 */
		    this.uptName = user.getEmail(); 					/* 수정아이디 */
		    this.categoryCd = product.getCategoryCd();			/* 카테고리 코드 */				/*( 필수) */
			this.categoryLCd = product.getCategoryLCd();		/* 카테고리대 코드 */	
			this.categoryLNm = product.getCategoryLNm();		/* 카테고리대 명 */	
			this.categoryMCd = product.getCategoryMCd();		/* 카테고리중 코드 */	
			this.categoryMNm = product.getCategoryMNm();		/* 카테고리중 명 */	
			this.categorySCd = product.getCategorySCd();		/* 카테고리소 코드 */
			this.categorySNm = product.getCategorySNm();		/* 카테고리소 명 */
			this.shExplan = product.getShExplan();				/* 짧은설명 */
			this.asFlag = product.getAsFlag(); 					/* A/S가능여부	*/
		    this.deliArea = product.getDeliArea(); 				/* 배송가능지역 */											/*( 필수) */
		    this.deliAreaExplan = product.getDeliAreaExplan(); 	/* 배송가능지역추가설명  */
		    this.priceSub = product.getPriceSub(); 				/* 가격대체문구	*/
		    this.invenType = product.getInvenType(); 			/* 재고적용타입(0:무제한, 1:한정) */							/*( 필수) */
		    this.invenCnt = product.getInvenCnt(); 				/* 재고수량 */
		    this.invenNtCnt = product.getInvenNtCnt(); 			/* 재고통보수량 */
		    this.minOrderLimit = product.getMinOrderLimit(); 	/* 최소주문한도 */
		    this.maxOrderLimit = product.getMaxOrderLimit(); 	/* 최대주문한도 */
		    this.reserves = product.getReserves(); 				/* 적립금 */
		    this.salesStDate = product.getSalesStDate(); 		/* 판매기간 시작일 (YYYY-MM-DD) */
		    this.salesEdDate = product.getSalesEdDate(); 		/* 판매기간 종료일 (YYYY-MM-DD) */
		    this.impoLevel = product.getImpoLevel(); 			/* 구매가능레벨 (10:제한없음, 9:일반회원, 8:우수회원, 7:특별회원, 6~2:가맹점)*/	/*( 필수) */
		    this.priceOpen = product.getPriceOpen(); 			/* 가격공개(0:사용안함, 1:사용함) */										/*( 필수) */
		    this.deliType = product.getDeliType(); 				/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */			/*( 필수) */
		    this.deliPay = product.getDeliPay(); 				/* 배송비결제 (0: 선불, 1:착불) */										/*( 필수) */
		    this.imgEnType = product.getImgEnType(); 			/* 이미지등록방식(0:직접 업로드, 1:URL 입력) */								/*( 필수) */
		    this.img1 = product.getImg1(); 						/* 이미지1 */															/*( 필수) */
		    this.img2 = product.getImg2(); 						/* 이미지2 */															/*( 필수) */
		    this.img3 = product.getImg3(); 						/* 이미지3 */
		    this.img4 = product.getImg4(); 						/* 이미지4 */
		    this.img5 = product.getImg5(); 						/* 이미지5 */
		    this.img6 = product.getImg6(); 						/* 이미지6 */
		    this.adminMemo = product.getAdminMemo(); 			/* 관리자메모 */
		}
		
		if(param != null) {
			if(param.getPartnerCd() ==null || param.getProdCd() == null) {
				throw new CommonRuntimeException(ErrorCode.PROD_CD_PARTNER_CD_NULL.getMessage(), ErrorCode.PROD_CD_PARTNER_CD_NULL);
			}
	    	if(param.getProdIdx() != null && param.getProdIdx().length() > 0) {
	    		this.prodIdx = param.getProdIdx();
	    	}
	        this.userId = param.getUserId();
	        this.partnerCd = param.getPartnerCd();
	        this.prodCd = param.getProdCd();
	        this.prodNm = param.getProdNm();
	        this.prodPrice = param.getProdPrice();
	        if(this.prodPrice != null && this.prodPrice > 0) {
		    	this.uProdPrice = CommonUtil.salePriceSetting(this.prodPrice, 10);
		    	this.margin = "10%";
		    }
	        this.consumerPrice = param.getConsumerPrice();
	        this.deliFlag = param.getDeliFlag();
	        this.deliPrice = param.getDeliPrice();
	        this.madePlace = param.getMadePlace();
	        this.maker = param.getMaker();
	        this.brand = param.getBrand();
	        this.model = param.getModel();
	        this.prodStatus = param.getProdStatus();
	        this.crtDate = param.getCrtDate();
	        this.crtName = user.getEmail();
	        this.uptDate = param.getUptDate();
	        this.uptName = user.getEmail();
	        this.deliType = param.getDeliType();
	        this.deliPay = param.getDeliPay();
	        this.listImg = param.getListImg();
	        this.img1 = param.getImg1();
	        this.img2 = param.getImg2();
		}
    }
	
}
