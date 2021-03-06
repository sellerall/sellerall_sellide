package kr.co.sellerall.sellide.vo;

import java.time.LocalDateTime;

import kr.co.sellerall.cmm.vo.CommonVO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@ToString
public class StorageProductRequestVO  extends CommonVO{
	private String prodIdx;			/* 사용자상품index (auto_increment) */	
	private String editCd;
	private String linkCd;
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
	private Integer prodPrice; 		/* 상품가격 */
	private Integer uProdPrice; 	/* 사용자상품가격 */
	private Integer uSalePrice; 	/* 사용자판매가격 */
	private Integer consumerPrice; 	/* 소비자가격 */
	private Integer uConsumerPrice; /* 사용자소비자가격 */
	private String deliFlag; 		/* 배송구분(h:선/착불, f:무료, g:착불, s:선불) */
	private String uDeliFlag; 		/* 사용자배송구분(h:선/착불, f:무료, g:착불, s:선불) */
	private String deliPrice; 		/* 배송비 */
	private String udeliPrice; 		/* 사용자배송비 */
	private String returnYn; 		/* 반품여부 */
	private String ureturnYn; 		/* 사용자반품여부 */
	private String madePlace; 		/* 원산지 */
	private String umadePlace; 		/* 사용자원산지 */
	private String maker; 			/* 제조사 */
	private String brand; 			/* 브랜드 */
	private String model; 			/* 모델명 */
	private String content; 		/* 상세설명 */
	private String uKeyword; 		/* 사용자키워드 */
	private String prodStatus; 		/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
	private String adultYn; 		/* 성인용품여부 */
	private Integer invenCnt; 		/* 재고수량 */
	private Integer minOrderLimit; 	/* 최소주문한도 */
	private String deliType; 		/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */			/*( 필수) */
	private String deliPay; 		/* 배송비결제 (0: 선불, 1:착불) */										/*( 필수) */
	private String listImg; 		/* 이미지1 */		
	private String img1; 			/* 이미지1 */															/*( 필수) */
	private String img2; 			/* 이미지2 */															/*( 필수) */
	private LocalDateTime crtStartDate;
	private LocalDateTime crtEndDate;
	private LocalDateTime uptStartDate;
	private LocalDateTime uptEndDate;
}
