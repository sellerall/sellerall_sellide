package kr.co.sellerall.sellide.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import kr.co.sellerall.sellide.dto.StorageProductDTO;
import kr.co.sellerall.sellide.vo.StorageProductRequestVO;

@Mapper
public interface StorageProductDao {
	List<StorageProductDTO> selectStorageProductList(@Param("tableName") String tableName,@Param("vo") StorageProductRequestVO vo);
	StorageProductDTO selectOneStorageProduct(String tableName,String prodIdx);
	Integer insertStorageProduct(@Param("tableName") String tableName, @Param("dto") StorageProductDTO dto);
	Integer selectStorageProductListTotal(@Param("tableName") String tableName);
	void updateRegisterCode(@Param("tableName") String tableName, @Param("vo") StorageProductRequestVO vo);
	
	List<StorageProductDTO> selectRegisteredProductList(@Param("tableName") String tableName,@Param("vo") StorageProductRequestVO vo);
	Integer selectRegisteredProductListTotal(@Param("tableName") String tableName);
	
	@Delete("DELETE FROM ${tableName} WHERE prod_idx = #{prodIdx};")
	Integer deleteStorageProduct(@Param("tableName") String tableName, @Param("prodIdx") String prodIdx);
}
