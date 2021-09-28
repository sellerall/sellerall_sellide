package kr.co.sellerall.cmm.domain.user;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.sellerall.sys.vo.UserMgmtRequestVO;

public interface TbUserInfoRepository extends JpaRepository<TbUserInfo, Long>,QuerydslPredicateExecutor<TbUserInfo> {
	Optional<TbUserInfo> findByUserId(String userId);
	Optional<TbUserInfo> findByUserName(String userName);
    Optional<TbUserInfo> findByUserEmail(String userEmail);
    
    @Query(value = "SELECT u FROM TbUserInfo u where u.role != ?1")
	Page<TbUserInfo> findAllRoleNotIn(Role role, PageRequest of);

}
