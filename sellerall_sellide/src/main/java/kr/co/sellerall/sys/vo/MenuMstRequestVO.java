package kr.co.sellerall.sys.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuMstRequestVO {
	private Long menuSeq;
	private Long menuGrpSeq;
	private String menuName;
	private String menuUrl;
	private String sortOrdr;
	private String authCode;
	private String useYn;
	
	@Builder
    public MenuMstRequestVO(Long menuSeq,Long menuGrpSeq,String menuName,String menuUrl,
    		String sortOrdr,String authCode,String useYn){
        this.menuSeq = menuSeq;
        this.menuGrpSeq = menuGrpSeq;
        this.menuName = menuName;
        this.menuUrl = menuUrl;
        this.sortOrdr = sortOrdr;
        this.authCode = authCode;
        this.useYn = useYn;
	}

}
