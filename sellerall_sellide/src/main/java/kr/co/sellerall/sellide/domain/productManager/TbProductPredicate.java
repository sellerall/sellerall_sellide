package kr.co.sellerall.sellide.domain.productManager;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import kr.co.sellerall.sellide.vo.DbProductRequestVO;

public class TbProductPredicate {
	public static Predicate search(DbProductRequestVO dbProductRequestVO) {
		QTbProduct product = QTbProduct.tbProduct;
		
		BooleanBuilder builder = new BooleanBuilder();

        if(dbProductRequestVO.getUserId() != null && dbProductRequestVO.getUserId().length() > 0){
            builder.and(product.userId.eq(dbProductRequestVO.getUserId()));
        }
        if(dbProductRequestVO.getProdIdx() != null && dbProductRequestVO.getProdIdx().length() > 0){
            builder.and(product.prodIdx.eq(dbProductRequestVO.getProdIdx()));
        }
        if(dbProductRequestVO.getPartnerCd() != null && dbProductRequestVO.getPartnerCd().length() > 0){
            builder.and(product.partnerCd.eq(dbProductRequestVO.getPartnerCd()));
        }
        if(dbProductRequestVO.getProdCd() != null && dbProductRequestVO.getProdCd().length() > 0){
            builder.and(product.prodCd.eq(dbProductRequestVO.getProdCd()));
        }
        if(dbProductRequestVO.getProdNm() != null && dbProductRequestVO.getProdNm().length() > 0){
            builder.and(product.prodNm.eq(dbProductRequestVO.getProdNm()));
        }
        if(dbProductRequestVO.getDeliFlag() != null && dbProductRequestVO.getDeliFlag().length() > 0){
            builder.and(product.deliFlag.eq(dbProductRequestVO.getDeliFlag()));
        }
        if(dbProductRequestVO.getMadePlace() != null && dbProductRequestVO.getMadePlace().length() > 0){
            builder.and(product.madePlace.eq(dbProductRequestVO.getMadePlace()));
        }
        if(dbProductRequestVO.getMaker() != null && dbProductRequestVO.getMaker().length() > 0){
            builder.and(product.maker.eq(dbProductRequestVO.getMaker()));
        }
        if(dbProductRequestVO.getBrand() != null && dbProductRequestVO.getBrand().length() > 0){
            builder.and(product.brand.eq(dbProductRequestVO.getBrand()));
        }
        if(dbProductRequestVO.getModel() != null && dbProductRequestVO.getModel().length() > 0){
            builder.and(product.model.eq(dbProductRequestVO.getModel()));
        }
        if(dbProductRequestVO.getProdStatus() != null && dbProductRequestVO.getProdStatus().length() > 0){
            builder.and(product.prodStatus.eq(dbProductRequestVO.getProdStatus()));
        }
        
		return builder;
	}
}
