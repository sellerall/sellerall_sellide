package kr.co.sellerall.sellide.domain.preferences;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert

@Table(name = "tb_shop_user_info")
public class TbShopUserInfo extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shopSeq;
	
	@Column
	private String userId;

	@Column
	private String shopCode;		/* 1:오픈마켓 소셜커머스 전문몰, 2:자사몰, 3:종합몰 */	
	
	@Column
	private String shopName;
	
	@Column
	private String shopId;
	
	@Column
	private String shopPw;
	
	@Column
	private String sellerId;
	
	@Column
	private String apiId;
	
	@Column
	private String domainId;
	
	@Column
	private String crtName;
	
	@Column
	private String uptName;
	
	@Builder
	public TbShopUserInfo(String userId,String shopCode,String shopName,String shopId,String shopPw,
			String sellerId,String apiId,String domainId,String crtName,String uptName) {
		this.userId = userId;
		this.shopCode = shopCode;
		this.shopName = shopName;
		this.shopId = shopId;
		this.shopPw = shopPw;
		this.sellerId = sellerId;
		this.apiId = apiId;
		this.domainId = domainId;
		this.crtName = crtName;
		this.uptName = uptName;
	}
	
	public TbShopUserInfo modUserInfo(String shopId,String shopPw,
			String sellerId,String apiId,String domainId,String uptName) {
		this.shopId = shopId;
		this.shopPw = shopPw;
		this.sellerId = sellerId;
		this.apiId = apiId;
		this.domainId = domainId;
		this.uptName = uptName;
		return this;
	}
}
