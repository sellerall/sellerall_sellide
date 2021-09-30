package kr.co.sellerall.cmm.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuVO {
	private Long menuSeq;
	private Long menuGrpSeq;
	private String menuName;
	private String menuUrl;
	private String sortOrdr;
	private String authCode;
	private String note;
	private String useYn;
	String uptName;
	LocalDateTime uptDate;
	String crtName;
	LocalDateTime crtDate;
	private boolean active;
	
	@Builder
    public MenuVO(Long menuSeq,Long menuGrpSeq,String menuName,String menuUrl,
    		String sortOrdr,String authCode,String note,String useYn,boolean active,
    		String uptName,LocalDateTime uptDate,String crtName,LocalDateTime crtDate){
        this.menuSeq = menuSeq;
        this.menuGrpSeq = menuGrpSeq;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.sortOrdr = sortOrdr;
        this.authCode = authCode;
        this.note = note;
        this.useYn = useYn;
        this.uptName = uptName;
        this.uptDate = uptDate;
        this.crtName = crtName;
        this.crtDate = crtDate;
        this.active = active;
    }

}
