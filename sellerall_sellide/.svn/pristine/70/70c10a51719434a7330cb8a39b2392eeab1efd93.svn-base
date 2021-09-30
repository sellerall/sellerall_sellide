package kr.co.sellerall.sellide.domain.productManager;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import kr.co.sellerall.cmm.domain.user.TbUserInfo;

public interface TbProductRepository extends JpaRepository<TbProduct, Long>,QuerydslPredicateExecutor<TbProduct> {
	Optional<TbProduct> findByProdCd(String prodCd);
}
