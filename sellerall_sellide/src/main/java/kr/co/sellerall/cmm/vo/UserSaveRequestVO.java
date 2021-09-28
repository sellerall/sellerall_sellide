package kr.co.sellerall.cmm.vo;

import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestVO {
    private String userId;
    private String userName;
    private String userPwd;
    private String userEmail;

    @Builder
    public UserSaveRequestVO(String userId,String userName,String userPwd,String userEmail){
        this.userId = userId;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userEmail = userEmail;
    }

    public TbUserInfo toEntity(){
        return TbUserInfo.builder()
                .userId(userId)
                .userName(userName)
                .userPwd(userPwd)
                .userEmail(userEmail)
                .role(Role.GUEST)
                .crtName(userName)
                .uptName(userName)
                .build();
    }
}