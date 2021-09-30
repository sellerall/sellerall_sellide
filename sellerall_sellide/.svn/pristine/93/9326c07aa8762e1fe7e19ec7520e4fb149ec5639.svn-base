package kr.co.sellerall.sellide.vo;

import kr.co.sellerall.cmm.vo.CommonVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DbProductRequestVO extends CommonVO{
	private String prodIdx;			/* 사용자상품index (auto_increment) */
	private String userId;			/* 사용자 ID */
	private String partnerCd;		/* 거래처코드 */			/*( 필수) */
	private String prodCd;			/* 상품코드 */				/*( 필수) */
	private String prodNm;			/* 상품명 */				/*( 필수) */
	private String uprodNm;			/* 사용자수정상품명 */
	private String wdmCd;			/* 왕도매 카테고리 코드 */
	private String gmkCd;			/* g마켓 카테고리 코드 */
	private String aucCd; 			/* 옥션 카테고리 코드 */
    private String estCd; 			/* 11번가 카테고리 코드 */
    private String itpCd;			/* 인터파크 카테고리 코드 */
    private String stpCd; 			/* 스토어팜 카테고리 코드 */
    private String couCd; 			/* 쿠팡 카테고리 코드 */
    private int prodPrice; 			/* 상품가격 */
    private int uProdPrice; 		/* 사용자상품가격 */
    private int uSalePrice; 		/* 사용자판매가격 */
    private int consumerPrice; 		/* 소비자가격 */
    private int uConsumerPrice; 	/* 사용자소비자가격 */
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
    private int lOptionCnt; 		/* 옵션개수 */
    private String lOption; 		/* 옵션 */
    private String ulOption; 		/* 사용자옵션 */
    private String lOptionPrice; 	/* 옵션가격 */
    private String ulOptionPrice; 	/* 사용자옵션가격 */
    private int boxQty; 			/* 묶음수량 */
    private int uBoxQty; 			/* 사용자묶음수량 */
    private String uKeyword; 		/* 사용자키워드 */
    private String prodStatus; 		/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
    private String adultYn; 		/* 성인용품여부 */
    private String uAdultYn; 		/* 사용자성인용품여부 */
    private String taxYn; 			/* 과세여부 */					/*( 필수) */
    private String useYn; 			/* 사용여부 */					/*( 필수) */
    private String authInfo1; 		/* 인증정보1 */
    private String authInfo2; 		/* 인증정보2(상품속성 - 1:건강식품, 2:의료용품, 3:해외직배송, 4:해외직구, 5:유통금지상품) */
    private String authInfo3; 		/* 인증정보3 */
    
    /* 기존시스템 외 추가된 필드 */
    private String categoryCd;		/* 카테고리 코드 */											/*( 필수) */
	private String categoryLCd;		/* 카테고리대 코드 */	
	private String categoryLNm;		/* 카테고리대 명 */	
	private String categoryMCd;		/* 카테고리중 코드 */	
	private String categoryMNm;		/* 카테고리중 명 */	
	private String categorySCd;		/* 카테고리소 코드 */
	private String categorySNm;		/* 카테고리소 명 */
	private String shExplan;		/* 짧은설명 */
	private String asFlag; 			/* A/S가능여부	*/
    private String deliArea; 		/* 배송가능지역 */											/*( 필수) */
    private String deliAreaExplan; 	/* 배송가능지역추가설명  */
    private String priceSub; 		/* 가격대체문구	*/
    private String invenType; 		/* 재고적용타입(0:무제한, 1:한정) */						/*( 필수) */
    private int invenCnt; 			/* 재고수량 */
    private int invenNtCnt; 		/* 재고통보수량 */
    private int minOrderLimit; 		/* 최소주문한도 */
    private int maxOrderLimit; 		/* 최대주문한도 */
    private String reserves; 		/* 적립금 */
    private String salesStDate; 	/* 판매기간 시작일 (YYYY-MM-DD) */
    private String salesEdDate; 	/* 판매기간 종료일 (YYYY-MM-DD) */
    private String impoLevel; 		/* 구매가능레벨 (10:제한없음, 9:일반회원, 8:우수회원, 7:특별회원, 6~2:가맹점)*/	/*( 필수) */
    private String priceOpen; 		/* 가격공개(0:사용안함, 1:사용함) */							/*( 필수) */
    private String deliType; 		/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */	/*( 필수) */
    private String deliPay; 		/* 배송비결제 (0: 선불, 1:착불) */								/*( 필수) */
    private String imgEnType; 		/* 이미지등록방식(0:직접 업로드, 1:URL 입력) */					/*( 필수) */
    private String img1; 			/* 이미지1 */												/*( 필수) */
    private String img2; 			/* 이미지2 */												/*( 필수) */
    private String img3; 			/* 이미지3 */
    private String img4; 			/* 이미지4 */
    private String img5; 			/* 이미지5 */
    private String img6; 			/* 이미지6 */
    private String adminMemo; 		/* 관리자메모 */
    
    @Builder
    public DbProductRequestVO(String prodIdx,String userId,String partnerCd,String prodCd,
    		String prodNm,int prodPrice,int consumerPrice,String deliFlag,String deliPrice,
    		String madePlace,String maker,String brand,String model,String listImg,
    		String prodStatus,String deliType,String deliPay){
        this.prodIdx = prodIdx;
        this.userId = userId;
        this.partnerCd = partnerCd;
        this.prodCd = prodCd;
        this.prodNm = prodNm;
        this.prodPrice = prodPrice;
        this.consumerPrice = consumerPrice;
        this.deliFlag = deliFlag;
        this.deliPrice = deliPrice;
        this.prodStatus = prodStatus;
        this.deliType = deliType;
        this.deliPay = deliPay;
	}

}
