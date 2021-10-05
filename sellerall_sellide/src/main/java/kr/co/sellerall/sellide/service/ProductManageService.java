package kr.co.sellerall.sellide.service;

import java.util.List;
import java.util.Map;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.vo.ResultVO;
import kr.co.sellerall.sellide.domain.productManager.TbProduct;
import kr.co.sellerall.sellide.dto.StorageProductDTO;
import kr.co.sellerall.sellide.vo.DbProductRequestVO;
import kr.co.sellerall.sellide.vo.DbProductResponseVO;
import kr.co.sellerall.sellide.vo.DomeProductRequestVO;
import kr.co.sellerall.sellide.vo.StorageProductRequestVO;

public interface ProductManageService {
	/* 보관상품등록 서비스 */
	String domeList(DomeProductRequestVO param,SessionUser user);
	ResultVO dbProductList(DbProductRequestVO param);
	void emptyStorageProduct(StorageProductRequestVO param, SessionUser user);
	//List<String> domeDetail(List<StorageProductRequestVO> param);
	String domeDetail(String prodCd);
	void insertStorageProduct(List<StorageProductRequestVO> param, SessionUser user);
	
	/* 개별 스토리지 서비스 */
	String domeItemDetail(String prodCd);
	ResultVO storageProductList(StorageProductRequestVO param, SessionUser user);	
	void deleteStorageProduct(List<StorageProductRequestVO> param, SessionUser user);
	
	/* 상품등록 서비스 */
	Map naverLogin(SessionUser user);
	String naverUserInfo(Map cookies);
	public String naverProductUpload(Object param, Map cookies);
	public String naverProductEdit(Object request, Map cookies);
	public String updateRegisterCode(StorageProductRequestVO param, SessionUser user);
	
	/* 등록상품관리 서비스 */
	ResultVO registeredProductList(StorageProductRequestVO param, SessionUser user);
	
	default DbProductResponseVO EntityTOvo(TbProduct vo) {
		return DbProductResponseVO.builder()
                .product(vo)
                .build();
	}
	
	default StorageProductDTO paramTOdto(StorageProductRequestVO param,SessionUser user) {
		return StorageProductDTO.builder()
				.param(param)
				.user(user)
				.build();
	}
	
	default StorageProductDTO EntityTOdto(TbProduct vo,SessionUser user) {
		return StorageProductDTO.builder()
				.product(vo)
				.user(user)
				.build();
	}
}