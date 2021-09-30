package kr.co.sellerall.sys.vo;

import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserMgmtSaveRequestVO {
    private String userId;
    private String userName;
    private String userPwd;
    private String userEmail;
    private String useYn;
    private String note;
    private Role role;
    
    @Builder
    public UserMgmtSaveRequestVO(String userId,String userName,String userPwd,
    		String userEmail,String useYn,String note,Role role){
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
        this.useYn = useYn;
        this.note = note;
        this.role = role;
        
    }

    public TbUserInfo toEntity(){
        return TbUserInfo.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(userPwd)
                .userEmail(userEmail)
                .useYn(useYn)
                .note(note)
                .role(role)
                .crtName(userName)
                .uptName(userName)
                .build();
    }
}