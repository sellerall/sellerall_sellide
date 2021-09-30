package kr.co.sellerall.sys.vo;

import kr.co.sellerall.cmm.domain.user.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RankRequestVO {
	private Long rankSeq;
	private Role role;
	private String authCode;
	private String sortOrdr;
	private String note;
	private String useYn;
	
	@Builder
    public RankRequestVO(Long rankSeq,Role role,String authCode,String sortOrdr,String note,String useYn){
        this.rankSeq = rankSeq;
        this.role = role;
        this.authCode = authCode;
        this.sortOrdr = sortOrdr;
        this.note = note;
        this.useYn = useYn;
	}
}
