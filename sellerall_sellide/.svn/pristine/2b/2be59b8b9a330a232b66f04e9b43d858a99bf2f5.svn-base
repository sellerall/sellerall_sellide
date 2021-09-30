package kr.co.sellerall.cmm.domain.user;


import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;

import kr.co.sellerall.cmm.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
@NamedStoredProcedureQuery(name = TbUserInfo.product, procedureName = "ps_storage_product_create", parameters = {
		  @StoredProcedureParameter(mode = ParameterMode.IN, name = "TableName", type = String.class) })
@DynamicInsert
@Table(name = "tb_user_info")
public class TbUserInfo extends BaseTimeEntity {
	public static final String product = "create_storage";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String userSeq;
	
	/*@Column(nullable = false,unique = true,length = 50)*/
	@Column
	private String userId;

	/*@Column(nullable = false)*/
	@Column
	private String userPwd;
	
	@Column
	private String userName;
	
	@Column(nullable = false,unique = true)
	private String userEmail;
	
	@Column
	private String userPhone;
	
	@Column
	private String userPicture;
	
	@Column
	private String lastLoginIp;
	
	@Column
	private LocalDateTime acuntExpDt;
	
	@Column
	private String userStatCd;
	
	@Column
	private String loginFailCnt;
	
	@Column
	private LocalDateTime loginDt;
	
	@Column
	private String userToken;
	
/*	@Column(columnDefinition = "char(8) default '00000000'")
	private String authCode;*/
	
	@Column
	private String useYn;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Role role;
	
	@Column
	private String note;
	
	@Column
	private String crtName;
	
	@Column
	private String uptName;
	
	@Builder
	public TbUserInfo(String userId,String userPwd,String userName,String userEmail,String userPicture,Role role,String crtName,String uptName,String useYn,String note) {
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPicture = userPicture;
		this.useYn = useYn;
		this.note = note;
		this.role = role;
		this.crtName = crtName;
		this.uptName = uptName;
	}
	
	public TbUserInfo update(String userName, String userPicture,LocalDateTime loginDt) {
		this.userName = userName;
	    this.userPicture = userPicture;
	    this.loginDt = loginDt;
		return this;
	}
	
	public TbUserInfo modUser(String userId,String userName, String userEmail,
			String userPicture,Role role,String useYn, String uptName) {
		this.userId = userId;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPicture = userPicture;
		this.role = role;
		this.useYn = useYn;
		this.uptName = uptName;
		return this;
	}
	
	public TbUserInfo pwdEncrypt(String userPwd) {
		this.userPwd = userPwd;
		return this;
	}
	
	public String getRoleKey() {
		return this.role.getKey();
	}
	
}
