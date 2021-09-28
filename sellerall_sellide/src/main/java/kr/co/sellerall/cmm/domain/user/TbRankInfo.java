package kr.co.sellerall.cmm.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
@Table(name = "tb_rank_info")
public class TbRankInfo extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long rankSeq;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;

	@Column(nullable = false)
	private String authCode;
	
	@Column
	private String sortOrdr;
	
	@Column
	private String useYn;
	
	@Column
	private String note;
	
	@Column
	private String crtName;
	
	@Column
	private String uptName;
	
	@Builder
	public TbRankInfo(Role role,String authCode,String sortOrdr,String useYn,String note,String crtName,String uptName) {
		this.role = role;
		this.authCode = authCode;
		this.sortOrdr = sortOrdr;
		this.useYn = useYn;
		this.note = note;
		this.crtName = crtName;
		this.uptName = uptName;
	}
	
	public TbRankInfo modRankInfo(Role role,String authCode,String sortOrdr,String useYn,String note,String uptName) {
		this.role = role;
		this.authCode = authCode;
		this.sortOrdr = sortOrdr;
		this.useYn = useYn;
		this.note = note;
		this.uptName = uptName;
		return this;
	}
}
