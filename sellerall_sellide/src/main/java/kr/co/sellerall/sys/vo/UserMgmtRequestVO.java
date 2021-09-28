package kr.co.sellerall.sys.vo;

import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.vo.CommonVO;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserMgmtRequestVO extends CommonVO {
		private String userSeq;
		private String userId;
		private String userPwd;
		private String userName;
		private String userEmail;
		private String userPhone;
		private String userPicture;
		private String useYn;
		private Role role;
		private String authCode;
		
		@Builder
	    public UserMgmtRequestVO(String userId,String userPwd,String userName,String userEmail,
	    		String userPhone,String userPicture,String useYn,Role role,String authCode){
	        this.userId = userId;
	        this.userPwd = userPwd;
	        this.userName = userName;
	        this.userEmail = userEmail;
	        this.userPhone = userPhone;
	        this.userPicture = userPicture;
	        this.useYn = useYn;
	        this.role = role;
	        this.authCode = authCode;
		}

	    public UserMgmtRequestVO toEntity(){
	        return UserMgmtRequestVO.builder()
	                .userId(userId)
	                .userPwd(userPwd)
	                .userName(userName)
	                .userEmail(userEmail)
	                .userPhone(userPhone)
	                .userPicture(userPicture)
	                .useYn(useYn)
	                .role(role)
	                .authCode(authCode)
	                .build();
	    }
}
