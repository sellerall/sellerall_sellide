package kr.co.sellerall.sellide.domain.preferences;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TbShopUserInfoRepository extends JpaRepository<TbShopUserInfo, Long> {
	List<TbShopUserInfo> findByUserId(String email);
	Optional<TbShopUserInfo> findByUserIdAndShopCode(String email, String shopCode);
	Optional<TbShopUserInfo> findByUserIdAndShopId(String email, String userId);
}
