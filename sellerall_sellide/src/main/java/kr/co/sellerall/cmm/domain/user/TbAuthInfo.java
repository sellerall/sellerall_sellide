package kr.co.sellerall.cmm.domain.user;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
/**
 * @packageName   : kr.co.sellerall.cmm.domain.user
 * @fileName      : TbAuthInfo.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17
 * @description   : 시큐리티 동적 권한 을 위한 사용자 등급 테이블 (DB access 부하로 인해 현재 사용안함. 
 * 					추후  Cache Abstraction을 이용하여 개선 예정
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */


@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
public class TbAuthInfo extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String authSeq;
	
	/*@Column(nullable = false,unique = true,length = 50)*/
	@Column(nullable = false)
	private String url;

	/*@Column(nullable = false)*/
	@Column(nullable = false)
	private String hasAuthority;
	
	@Column
	private String crtName;
	
	@Column
	private String uptName;
	
	@Builder
	public TbAuthInfo(String url,String hasAuthority,String crtName,String uptName) {
		this.url = url;
		this.hasAuthority = hasAuthority;
		this.crtName = crtName;
		this.uptName = uptName;
	}
	
	public TbAuthInfo update(String url, String hasAuthority, String uptName) {
		this.url = url;
	    this.hasAuthority = hasAuthority;
	    this.uptName = uptName;
		return this;
	}
}
