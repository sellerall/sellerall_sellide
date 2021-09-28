package kr.co.sellerall.sellide.domain.productManager;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.sellide.domain.BaseTimeProductEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
public class TbProduct extends BaseTimeProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String prodIdx;			/* 사용자상품index (auto_increment) */
	
	@Column
	private String userId;			/* 사용자 ID */
	
	@Column
	private String partnerCd;		/* 거래처코드 */			/*( 필수) */
	
	@Column
	private String prodCd;			/* 상품코드 */				/*( 필수) */
	
	@Column
	private String prodNm;			/* 상품명 */				/*( 필수) */
	
	@Column
	private String categoryCd;		/* 카테고리 코드 */			/*( 필수) */
	
	@Column(name = "CATEGORY_L_CD")
	private String categoryLCd;		/* 카테고리대 코드 */	
	
	@Column(name = "CATEGORY_L_NM")
	private String categoryLNm;		/* 카테고리대 명 */	
	
	@Column(name = "CATEGORY_M_CD")
	private String categoryMCd;		/* 카테고리중 코드 */	
	
	@Column(name = "CATEGORY_M_NM")
	private String categoryMNm;		/* 카테고리중 명 */	
	
	@Column(name = "CATEGORY_S_CD")
	private String categorySCd;		/* 카테고리소 코드 */
	
	@Column(name = "CATEGORY_S_NM")
	private String categorySNm;		/* 카테고리소 명 */
	
	@Column
	private String uprodNm;			/* 사용자수정상품명 */
	
	@Column
	private String wdmCd;			/* 왕도매 카테고리 코드 */
	
	@Column
	private String gmkCd;			/* g마켓 카테고리 코드 */
	
	@Column
	private String aucCd; 			/* 옥션 카테고리 코드 */
    
	@Column
	private String estCd; 			/* 11번가 카테고리 코드 */
    
	@Column
	private String itpCd;			/* 인터파크 카테고리 코드 */
    
	@Column
	private String stpCd; 			/* 스토어팜 카테고리 코드 */
    
	@Column
	private String couCd; 			/* 쿠팡 카테고리 코드 */
	
	@Column
	private Integer prodPrice; 			/* 상품가격 */
    
	@Column(name = "UPROD_PRICE")
	private Integer uProdPrice; 		/* 사용자상품가격 */
    
	@Column(name = "USALE_PRICE")
	private Integer uSalePrice; 		/* 사용자판매가격 */
    
	@Column
	private Integer consumerPrice; 		/* 소비자가격 */
    
	@Column(name = "UCONSUMER_PRICE")
	private Integer uConsumerPrice; 	/* 사용자소비자가격 */
    
	@Column
	private String consumerYn; 		/* 가격자율여부(y:준수, n:자율) */
    
	@Column
	private String deliFlag; 		/* 배송구분(h:선/착불, f:무료, g:착불, s:선불) */
    
	@Column(name = "UDELI_FLAG")
	private String uDeliFlag; 		/* 사용자배송구분(h:선/착불, f:무료, g:착불, s:선불) */
    
	@Column
	private String deliPrice; 		/* 배송비 */
    
	@Column(name = "UDELI_PRICE")
	private String udeliPrice; 		/* 사용자배송비 */
    
	@Column
	private String returnYn; 		/* 반품여부 */
    
	@Column(name = "URETURN_YN")
	private String ureturnYn; 		/* 사용자반품여부 */
    
	@Column(name = "URETURN_PRICE")
	private String ureturnPrice; 	/* 사용자반품배송비 */
    
	@Column(name = "URETURN_PLACE")
	private String ureturnPlace; 	/* 사용자반품배송지코드(오너클랜제공) */
    
	@Column
	private String madePlace; 		/* 원산지 */
    
	@Column(name = "UMADE_PLACE")
	private String umadePlace; 		/* 사용자원산지 */
    
	@Column
	private String maker; 			/* 제조사 */
    
	@Column
	private String brand; 			/* 브랜드 */
    
	@Column(name = "UBRAND")
	private String ubrand; 			/* 사용자브랜드 */
    
	@Column
	private String model; 			/* 모델명 */
    
	@Column
	private String listImg; 		/* 리스트이미지 */
    
	@Column(name = "ULIST_IMG")
	private String uListImg; 		/* 사용자리스트이미지 */
    
	@Column
	private String content; 		/* 상세설명 */
    
	@Column(name = "UCONTENT")
	private String uContent; 		/* 사용자상세설명 */
    
	@Column(name = "UINTRO")
	private String uIntro; 			/* 사용자상단설명 */
    
	@Column
	private Integer lOptionCnt; 	/* 옵션개수 */
    
	@Column
	private String lOption; 		/* 옵션 */
    
	@Column
	private String ulOption; 		/* 사용자옵션 */
    
	@Column
	private String lOptionPrice; 	/* 옵션가격 */
    
	@Column
	private String ulOptionPrice; 	/* 사용자옵션가격 */
    
	@Column
	private Integer boxQty; 		/* 묶음수량 */
    
	@Column(name = "UBOX_QTY")
	private Integer uBoxQty; 		/* 사용자묶음수량 */
	
	@Column(name = "UKEYWORD")
	private String uKeyword; 		/* 사용자키워드 */
    
	@Column
	private String prodStatus; 		/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
    
	@Column
	private String adultYn; 		/* 성인용품여부 */
    
	@Column(name = "UADULT_YN")
	private String uAdultYn; 		/* 사용자성인용품여부 */
    
	@Column
	private String taxYn; 			/* 과세여부 */					/*( 필수) */
    
	@Column
	private String useYn; 			/* 사용여부 */					/*( 필수) */
    
	@Column
	private String authInfo1; 		/* 인증정보1 */
    
	@Column
	private String authInfo2; 		/* 인증정보2(상품속성 - 1:건강식품, 2:의료용품, 3:해외직배송, 4:해외직구, 5:유통금지상품) */
    
	@Column
	private String authInfo3; 		/* 인증정보3 */
    
	@Column
	private String shExplan;		/* 짧은설명 */
	
	@Column
	private String asFlag; 			/* A/S가능여부	*/
    
	@Column
	private String deliArea; 		/* 배송가능지역 */											/*( 필수) */
    
	@Column
	private String deliAreaExplan; 	/* 배송가능지역추가설명  */
    
	@Column
	private String priceSub; 		/* 가격대체문구	*/
    
	@Column
	private String invenType; 		/* 재고적용타입(0:무제한, 1:한정) */						/*( 필수) */
    
	@Column
	private Integer invenCnt; 		/* 재고수량 */
    
	@Column
	private Integer invenNtCnt; 	/* 재고통보수량 */
    
	@Column
	private Integer minOrderLimit; 		/* 최소주문한도 */
    
	@Column
	private Integer maxOrderLimit; 		/* 최대주문한도 */
    
	@Column
	private String reserves; 		/* 적립금 */
    
	@Column
	private String salesStDate; 	/* 판매기간 시작일 (YYYY-MM-DD) */
    
	@Column
	private String salesEdDate; 	/* 판매기간 종료일 (YYYY-MM-DD) */
    
	@Column
	private String impoLevel; 		/* 구매가능레벨 (10:제한없음, 9:일반회원, 8:우수회원, 7:특별회원, 6~2:가맹점)*/	/*( 필수) */
    
	@Column
	private String priceOpen; 		/* 가격공개(0:사용안함, 1:사용함) */							/*( 필수) */
    
	@Column
	private String deliType; 		/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */	/*( 필수) */
    
	@Column
	private String deliPay; 		/* 배송비결제 (0: 선불, 1:착불) */								/*( 필수) */
    
	@Column
	private String imgEnType; 		/* 이미지등록방식(0:직접 업로드, 1:URL 입력) */					/*( 필수) */
    
	@Column(name = "IMG_1")
	private String img1; 			/* 이미지1 */												/*( 필수) */
    
	@Column(name = "IMG_2")
	private String img2; 			/* 이미지2 */												/*( 필수) */
    
	@Column(name = "IMG_3")
	private String img3; 			/* 이미지3 */
    
	@Column(name = "IMG_4")
	private String img4; 			/* 이미지4 */
    
	@Column(name = "IMG_5")
	private String img5; 			/* 이미지5 */
    
	@Column(name = "IMG_6")
	private String img6; 			/* 이미지6 */
    
	@Column
	private String adminMemo; 		/* 관리자메모 */
	
	@Column
	private String regName;
	
	@Column
	private String uptName;
	
	@Builder
	public TbProduct( String prodIdx, String userId, String partnerCd, String prodCd,
			 String prodNm,	String uprodNm, String wdmCd, String gmkCd, String aucCd, 
		     String estCd, String itpCd, String stpCd, String couCd, 		
		     int prodPrice, int uProdPrice, int uSalePrice, int consumerPrice, int uConsumerPrice, 
		     String consumerYn, String deliFlag, String uDeliFlag,
		     String deliPrice, String udeliPrice, String returnYn, String ureturnYn,
		     String ureturnPrice, String ureturnPlace, String madePlace, String umadePlace,
		     String maker, String brand, String ubrand, String model,
		     String listImg, String uListImg, String content, String uContent, String uIntro,
		     int lOptionCnt, String lOption, String ulOption,
		     String lOptionPrice, String ulOptionPrice, int boxQty, int uBoxQty,
		     String uKeyword, String prodStatus, String adultYn, String uAdultYn,
		     String taxYn, String useYn, String authInfo1, String authInfo2, String authInfo3,
		     LocalDateTime regDate, String regName, LocalDateTime uptDate, String uptName,
		     String categoryCd, String categoryLCd, String categoryLNm, 
			 String categoryMCd, String categoryMNm, String categorySCd, String categorySNm,
			 String shExplan, String asFlag, String deliArea, String deliAreaExplan,
		     String priceSub, String invenType, int invenCnt, int invenNtCnt,
		     int minOrderLimit, int maxOrderLimit, String reserves,
		     String salesStDate, String salesEdDate, String impoLevel,
		     String priceOpen, String deliType, String deliPay, String imgEnType,
		     String img1, String img2, String img3, String img4,
		     String img5, String img6, String adminMemo ) {
		this.prodIdx = prodIdx;			/* 사용자상품index (auto_increment) */
		this.userId = userId;			/* 사용자 ID */
		this.partnerCd = partnerCd;		/* 거래처코드 */			/*( 필수) */
		this.prodCd = prodCd;			/* 상품코드 */				/*( 필수) */
		this.prodNm = prodNm;			/* 상품명 */				/*( 필수) */
		this.uprodNm = uprodNm;			/* 사용자수정상품명 */
		this.wdmCd = wdmCd;			/* 왕도매 카테고리 코드 */
		this.gmkCd = gmkCd;			/* g마켓 카테고리 코드 */
		this.aucCd = aucCd; 			/* 옥션 카테고리 코드 */
	    this.estCd = estCd; 			/* 11번가 카테고리 코드 */
	    this.itpCd = itpCd;			/* 인터파크 카테고리 코드 */
	    this.stpCd = stpCd; 			/* 스토어팜 카테고리 코드 */
	    this.couCd = couCd; 			/* 쿠팡 카테고리 코드 */
	    this.prodPrice = prodPrice; 			/* 상품가격 */
	    this.uProdPrice = uProdPrice; 		/* 사용자상품가격 */
	    this.uSalePrice = uSalePrice; 		/* 사용자판매가격 */
	    this.consumerPrice = consumerPrice; 		/* 소비자가격 */
	    this.uConsumerPrice = uConsumerPrice; 	/* 사용자소비자가격 */
	    this.consumerYn = consumerYn; 		/* 가격자율여부(y:준수, n:자율) */
	    this.deliFlag = deliFlag; 		/* 배송구분(h:선/착불, f:무료, g:착불, s:선불) */
	    this.uDeliFlag = uDeliFlag; 		/* 사용자배송구분(h:선/착불, f:무료, g:착불, s:선불) */
	    this.deliPrice = deliPrice; 		/* 배송비 */
	    this.udeliPrice = udeliPrice; 		/* 사용자배송비 */
	    this.returnYn = returnYn; 		/* 반품여부 */
	    this.ureturnYn = ureturnYn; 		/* 사용자반품여부 */
	    this.ureturnPrice = ureturnPrice; 	/* 사용자반품배송비 */
	    this.ureturnPlace = ureturnPlace; 	/* 사용자반품배송지코드(오너클랜제공) */
	    this.madePlace = madePlace; 		/* 원산지 */
	    this.umadePlace = umadePlace; 		/* 사용자원산지 */
	    this.maker = maker; 			/* 제조사 */
	    this.brand = brand; 			/* 브랜드 */
	    this.ubrand = ubrand; 			/* 사용자브랜드 */
	    this.model = model; 			/* 모델명 */
	    this.listImg = listImg; 		/* 리스트이미지 */
	    this.uListImg = uListImg; 		/* 사용자리스트이미지 */
	    this.content = content; 		/* 상세설명 */
	    this.uContent = uContent; 		/* 사용자상세설명 */
	    this.uIntro = uIntro; 			/* 사용자상단설명 */
	    this.lOptionCnt = lOptionCnt; 		/* 옵션개수 */
	    this.lOption = lOption; 		/* 옵션 */
	    this.ulOption = ulOption; 		/* 사용자옵션 */
	    this.lOptionPrice = lOptionPrice; 	/* 옵션가격 */
	    this.ulOptionPrice = ulOptionPrice; 	/* 사용자옵션가격 */
	    this.boxQty = boxQty; 			/* 묶음수량 */
	    this.uBoxQty = uBoxQty; 			/* 사용자묶음수량 */
	    this.uKeyword = uKeyword; 		/* 사용자키워드 */
	    this.prodStatus = prodStatus; 		/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
	    this.adultYn = adultYn; 		/* 성인용품여부 */
	    this.uAdultYn = uAdultYn; 		/* 사용자성인용품여부 */
	    this.taxYn = taxYn; 			/* 과세여부 */					/*( 필수) */
	    this.useYn = useYn; 			/* 사용여부 */					/*( 필수) */
	    this.authInfo1 = authInfo1; 		/* 인증정보1 */
	    this.authInfo2 = authInfo2; 		/* 인증정보2(상품속성 - 1:건강식품, 2:의료용품, 3:해외직배송, 4:해외직구, 5:유통금지상품) */
	    this.authInfo3 = authInfo3; 		/* 인증정보3 */
	    this.regName = regName; 		/* 등록아이디 */
	    this.uptName = uptName; 		/* 수정아이디 */
	    this.categoryCd = categoryCd;		/* 카테고리 코드 */											/*( 필수) */
		this.categoryLCd = categoryLCd;		/* 카테고리대 코드 */	
		this.categoryLNm = categoryLNm;		/* 카테고리대 명 */	
		this.categoryMCd = categoryMCd;		/* 카테고리중 코드 */	
		this.categoryMNm = categoryMNm;		/* 카테고리중 명 */	
		this.categorySCd = categorySCd;		/* 카테고리소 코드 */
		this.categorySNm = categorySNm;		/* 카테고리소 명 */
		this.shExplan = shExplan;		/* 짧은설명 */
		this.asFlag = asFlag; 			/* A/S가능여부	*/
	    this.deliArea = deliArea; 		/* 배송가능지역 */											/*( 필수) */
	    this.deliAreaExplan = deliAreaExplan; 	/* 배송가능지역추가설명  */
	    this.priceSub = priceSub; 		/* 가격대체문구	*/
	    this.invenType = invenType; 		/* 재고적용타입(0:무제한, 1:한정) */						/*( 필수) */
	    this.invenCnt = invenCnt; 			/* 재고수량 */
	    this.invenNtCnt = invenNtCnt; 		/* 재고통보수량 */
	    this.minOrderLimit = minOrderLimit; 		/* 최소주문한도 */
	    this.maxOrderLimit = maxOrderLimit; 		/* 최대주문한도 */
	    this.reserves = reserves; 		/* 적립금 */
	    this.salesStDate = salesStDate; 	/* 판매기간 시작일 (YYYY-MM-DD) */
	    this.salesEdDate = salesEdDate; 	/* 판매기간 종료일 (YYYY-MM-DD) */
	    this.impoLevel = impoLevel; 		/* 구매가능레벨 (10:제한없음, 9:일반회원, 8:우수회원, 7:특별회원, 6~2:가맹점)*/	/*( 필수) */
	    this.priceOpen = priceOpen; 		/* 가격공개(0:사용안함, 1:사용함) */							/*( 필수) */
	    this.deliType = deliType; 		/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */	/*( 필수) */
	    this.deliPay = deliPay; 		/* 배송비결제 (0: 선불, 1:착불) */								/*( 필수) */
	    this.imgEnType = imgEnType; 		/* 이미지등록방식(0:직접 업로드, 1:URL 입력) */					/*( 필수) */
	    this.img1 = img1; 			/* 이미지1 */												/*( 필수) */
	    this.img2 = img2; 			/* 이미지2 */												/*( 필수) */
	    this.img3 = img3; 			/* 이미지3 */
	    this.img4 = img4; 			/* 이미지4 */
	    this.img5 = img5; 			/* 이미지5 */
	    this.img6 = img6; 			/* 이미지6 */
	    this.adminMemo = adminMemo; 		/* 관리자메모 */
	}

}
