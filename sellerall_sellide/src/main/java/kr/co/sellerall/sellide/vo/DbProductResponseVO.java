package kr.co.sellerall.sellide.vo;

import java.time.LocalDateTime;

import kr.co.sellerall.sellide.domain.productManager.TbProduct;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class DbProductResponseVO{
	private String prodIdx;			/* 사용자상품index (auto_increment) */
	private String userId;			/* 사용자 ID */
	private String partnerCd;		/* 거래처코드 */			/*( 필수) */
	private String prodCd;			/* 상품코드 */				/*( 필수) */
	private String prodNm;			/* 상품명 */				/*( 필수) */
    private int prodPrice; 			/* 상품가격 */
    private int consumerPrice; 		/* 소비자가격 */
    private String deliFlag; 		/* 배송구분(h:선/착불, f:무료, g:착불, s:선불) */
    private String deliPrice; 		/* 배송비 */
    private String madePlace; 		/* 원산지 */
    private String maker; 			/* 제조사 */
    private String brand; 			/* 브랜드 */
    private String model; 			/* 모델명 */
    private String prodStatus; 		/* 상품상태(1:정상, 8:품절) */	/*( 필수) */
    private LocalDateTime crtDate; 		/* 등록일 */
    private String crtName; 		/* 등록아이디 */
    private LocalDateTime uptDate; 		/* 수정일 */
    private String uptName; 		/* 수정아이디 */
    private String deliType; 		/* 배송비유형 (0:공통설정, 1:무료배송, 2:조건부무료배송, 3:유료배송) */	/*( 필수) */
    private String deliPay; 		/* 배송비결제 (0: 선불, 1:착불) */								/*( 필수) */
    private String listImg;
    private String img1;
    private String img2;
    
    @Builder
    public DbProductResponseVO(TbProduct product){
    	this.prodIdx = product.getProdIdx();
        this.userId = product.getUserId();
        this.partnerCd = product.getPartnerCd();
        this.prodCd = product.getProdCd();
        this.prodNm = product.getProdNm();
        this.prodPrice = product.getProdPrice();
        this.consumerPrice = product.getConsumerPrice();
        this.deliFlag = product.getDeliFlag();
        this.deliPrice = product.getDeliPrice();
        this.madePlace = product.getMadePlace();
        this.maker = product.getMaker();
        this.brand = product.getBrand();
        this.model = product.getModel();
        this.prodStatus = product.getProdStatus();
        this.crtDate = product.getRegDate();
        this.crtName = product.getRegName();
        this.uptDate = product.getUptDate();
        this.uptName = product.getUptName();
        this.deliType = product.getDeliType();
        this.deliPay = product.getDeliPay();
        this.listImg = product.getListImg();
        this.img1 = product.getImg1();
        this.img2 = product.getImg2();
    }
    
}
