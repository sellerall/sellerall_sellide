package kr.co.sellerall.sys.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MenuGrpRequestVO {
	private Long menuGrpSeq;
	private String menuGrpName;
	private String sortOrdr;
	private String useYn;
	
	@Builder
    public MenuGrpRequestVO(Long menuGrpSeq,String menuGrpName,String sortOrdr,String useYn){
        this.menuGrpSeq = menuGrpSeq;
        this.menuGrpName = menuGrpName;
        this.sortOrdr = sortOrdr;
        this.useYn = useYn;
	}
}
