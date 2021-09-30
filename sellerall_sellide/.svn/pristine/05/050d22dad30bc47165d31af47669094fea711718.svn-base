package kr.co.sellerall.sellide.vo;

import kr.co.sellerall.cmm.vo.CommonVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.sellide.vo
 * @fileName      : DomeProductRequestVO.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 * 참고 사이트 : http://openapi.domeggook.com/main/reference/detail?api_no=68&scope_code=SCP_OPEN
 */
@Getter
@NoArgsConstructor
public class DomeProductRequestVO extends CommonVO {
	private String so;			//정렬 방식
	private String ev;			//기획전 번호
	private String ca;			//카테고리 검색
	private String id;			//판매자 아이디 검색
	private String kw;			//검색어 검색
	private String mnp;			//가격대 검색 : 최저 가격대
	private String mxp;			//가격대 검색 : 최대 가격대
	private String mnq;			//최소구매 수량 검색 :최저수량
	private String mxq;			//최소구매 수량 검색 :최대수량
	private String who;			//배송비부담
	private String org;			//국산 여부
	private String sgd;			//우수판매자 상품 검색
	private String fdl;			//빠른배송 상품 검색
	private String itemNo;		//상품번호 검색
	
	@Builder
    public DomeProductRequestVO(String so,String ev,String ca,String id,
    		String kw,String mnp,String mxp,String mnq,String mxq,
    		String who,String org,String sgd,String fdl,String itemNo){
        this.so = so;
        this.ev = ev;
        this.ca = ca;
        this.id = id;
        this.kw = kw;
        this.mnp = mnp;
        this.mxp = mxp;
        this.mnq = mnq;
        this.mxq = mxq;
        this.who = who;
        this.org = org;
        this.sgd = sgd;
        this.fdl = fdl;
        this.itemNo = itemNo;
	}

    public DomeProductRequestVO toEntity(){
        return DomeProductRequestVO.builder()
                .so(so)
                .ev(ev)
                .ca(ca)
                .id(id)
                .kw(kw)
                .mnp(mnp)
                .mxp(mxp)
                .mnq(mnq)
                .mxq(mxq)
                .who(who)
                .org(org)
                .sgd(sgd)
                .fdl(fdl)
                .itemNo(itemNo)
                .build();
    }
    
}
