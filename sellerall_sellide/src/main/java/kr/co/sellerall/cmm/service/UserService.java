package kr.co.sellerall.cmm.service;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.exception.RegistrationException;
import kr.co.sellerall.cmm.exception.UserEmailExistsException;
import kr.co.sellerall.cmm.exception.UserIdExistsException;
import kr.co.sellerall.cmm.vo.UserSaveRequestVO;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import kr.co.sellerall.sys.vo.UserMgmtResponseVO;

/**
 * @packageName   : kr.co.sellerall.cmm.service
 * @fileName      : UserService.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */
public interface UserService extends UserDetailsService {
	ResponseEntity<ApiResult> findByDuplicateUserId(String userId) throws UserIdExistsException;
	ResponseEntity<ApiResult> findByDuplicateUserEmail(String userEmail) throws UserEmailExistsException;
	String register(UserSaveRequestVO param) throws RegistrationException;
	UserMgmtResponseVO userSelectOne(String email) throws UserNotExistsException;
	
	default UserMgmtResponseVO EntityTOvo(TbUserInfo vo) {
		return UserMgmtResponseVO.builder()
                .userInfo(vo)
                .build();
		
	}
}