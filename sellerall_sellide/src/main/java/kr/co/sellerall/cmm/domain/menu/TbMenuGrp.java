package kr.co.sellerall.cmm.domain.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
public class TbMenuGrp extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuGrpSeq;
	
	@Column(nullable = false)
	private String menuGrpName;
	
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
	public TbMenuGrp(Long menuGrpSeq,String menuGrpName,String sortOrdr,String useYn,String note,String crtName,String uptName) {
		this.menuGrpSeq = menuGrpSeq;
		this.menuGrpName = menuGrpName;
		this.sortOrdr = sortOrdr;
		this.useYn = useYn;
		this.note = note;
		this.crtName = crtName;
		this.uptName = uptName;
	}
	
	public TbMenuGrp modMenuGrp(String menuGrpName,String sortOrdr,String useYn,String uptName) {
		this.menuGrpName = menuGrpName;
		this.sortOrdr = sortOrdr;
		this.useYn = useYn;
		this.uptName = uptName;
		return this;
	}
}

