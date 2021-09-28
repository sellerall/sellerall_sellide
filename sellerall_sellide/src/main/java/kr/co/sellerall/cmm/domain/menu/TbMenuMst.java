package kr.co.sellerall.cmm.domain.menu;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@DynamicInsert
public class TbMenuMst extends BaseTimeEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long menuSeq;
	
	@Column
	private Long menuGrpSeq;
	
	@Column(nullable = false)
	private String menuName;
	
	@Column(nullable = false)
	private String menuUrl;
	
	@Column
	private String sortOrdr;

	@Column
	private String authCode;

	@Column
	private String useYn;
	
	@Column
	private String note;
	
	@Column
	private String crtName;
	
	@Column
	private String uptName;
	
	@Builder
	public TbMenuMst(Long menuSeq,Long menuGrpSeq,String menuName,String menuUrl,
			String sortOrdr,String authCode,String useYn,String note,String crtName,String uptName) {
		this.menuSeq = menuSeq;
		this.menuGrpSeq = menuGrpSeq;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.sortOrdr = sortOrdr;
		this.authCode = authCode;
		this.useYn = useYn;
		this.note = note;
		this.crtName = crtName;
		this.uptName = uptName;
	}
	
	public TbMenuMst modMenuMst(Long menuGrpSeq,String menuName,String menuUrl,
			String authCode,String sortOrdr,String useYn,String uptName) {
		this.menuGrpSeq = menuGrpSeq;
		this.menuName = menuName;
		this.menuUrl = menuUrl;
		this.authCode = authCode;
		this.sortOrdr = sortOrdr;
		this.useYn = useYn;
		this.uptName = uptName;
		return this;
	}
}