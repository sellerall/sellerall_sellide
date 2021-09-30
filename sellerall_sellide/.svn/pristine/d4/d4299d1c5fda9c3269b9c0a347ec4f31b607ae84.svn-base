package kr.co.sellerall.sellide.domain.preferences;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert

@Table(name = "tb_shop_info")
public class TbShopInfo extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer shopSeq;
	
	@Column
	private String shopCode;		/* 1:오픈마켓 소셜커머스 전문몰, 2:자사몰, 3:종합몰 */
	
	@Column
	private String shopName;
	
	@Column
	private String crtName;
	
	@Column
	private String uptName;
}
