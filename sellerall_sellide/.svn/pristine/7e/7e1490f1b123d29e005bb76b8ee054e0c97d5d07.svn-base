package kr.co.sellerall.cmm.domain.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TbAuthInfoRepository extends JpaRepository<TbAuthInfo, Long> {
	Optional<TbAuthInfo> findByUrl(String url);
	Optional<TbAuthInfo> findByHasAuthority(String hasAuthority);
	List<TbAuthInfo> findAll();
}
