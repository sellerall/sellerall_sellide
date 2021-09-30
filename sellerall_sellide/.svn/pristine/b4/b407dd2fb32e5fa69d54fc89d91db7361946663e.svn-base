package kr.co.sellerall.sys.vo;

import java.time.LocalDateTime;

import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserMgmtResponseVO {
	private String userSeq;
	private String userId;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userPicture;
	private String useYn;
	private Role role;
	private LocalDateTime loginDt;
	private String note;
	private String crtName;
	private LocalDateTime crtDate;
	private String uptName;
	private LocalDateTime uptDate;
	
	@Builder
    public UserMgmtResponseVO(TbUserInfo userInfo){
		this.userSeq = userInfo.getUserSeq();
		this.userId = userInfo.getUserId();
        this.userName = userInfo.getUserName();
        this.userEmail = userInfo.getUserEmail();
        this.userPhone = userInfo.getUserPhone();
        this.userPicture = userInfo.getUserPicture();
        this.useYn = userInfo.getUseYn();
        this.role = userInfo.getRole();
        this.loginDt = userInfo.getLoginDt();
        this.note = userInfo.getNote();
        this.crtName = userInfo.getCrtName();
        this.crtDate = userInfo.getCrtDate();
        this.uptName = userInfo.getUptName();
        this.uptDate = userInfo.getUptDate();
    }
}
