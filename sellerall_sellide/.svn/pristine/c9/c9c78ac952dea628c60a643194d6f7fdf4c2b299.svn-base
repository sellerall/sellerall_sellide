package kr.co.sellerall.cmm.domain.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;

public class SimpleUser implements UserDetails, Serializable {

	private static final long serialVersionUID = -7144174657188362966L;

	private String userId;
	private String userName;
	private String userPwd;
	private Role role;

	public SimpleUser(TbUserInfo user) {
		this.userId = user.getUserId();
		this.userName = user.getUserName();
		this.userPwd = user.getUserPwd();
		this.role = user.getRole();
	}

	public String getUserId() {
		return userId;
	}

	@Override
	public String getPassword() {
		return userPwd;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singleton(new SimpleGrantedAuthority(this.role.getKey()));
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof SimpleUser)) return false;
		SimpleUser that = (SimpleUser) o;
		return Objects.equals(userName, that.userName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userName);
	}

	@Override
	public String toString() {
		return "SimpleUser{" +
				"userId=" + userId +
				", username='" + userName + '\'' +
				", password='" + userPwd + '\'' +
				'}';
	}
}