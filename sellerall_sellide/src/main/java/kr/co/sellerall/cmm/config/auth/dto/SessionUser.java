package kr.co.sellerall.cmm.config.auth.dto;


import lombok.Getter;

import java.io.Serializable;

import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;

@Getter
public class SessionUser implements Serializable {
	private String userSeq;
	private String userId;
    private String name;
    private String email;
    private String picture;
    private Role role;

    public SessionUser(TbUserInfo user) {
    	this.userSeq =  user.getUserSeq();
    	this.userId = user.getUserId();
        this.name = user.getUserName();
        this.email = user.getUserEmail();
        this.picture = user.getUserPicture();
        this.role = user.getRole();
    }
}