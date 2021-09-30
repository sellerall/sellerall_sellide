package kr.co.sellerall.sys.service;

import java.util.List;
import java.util.Optional;

import kr.co.sellerall.cmm.component.CommonUtils;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.exception.RegistrationException;
import kr.co.sellerall.cmm.vo.ResultVO;
import kr.co.sellerall.sys.exception.AccessDeniedException;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import kr.co.sellerall.sys.vo.UserMgmtRequestVO;
import kr.co.sellerall.sys.vo.UserMgmtResponseVO;
import kr.co.sellerall.sys.vo.UserMgmtSaveRequestVO;

public interface UserMgmtService {
	String register(UserMgmtSaveRequestVO param,SessionUser user) throws RegistrationException,AccessDeniedException;
	ResultVO userSelectList(UserMgmtRequestVO param,SessionUser user);
	UserMgmtResponseVO userSelectOne(String email) throws UserNotExistsException;
	String userMod(UserMgmtRequestVO param,SessionUser user) throws UserNotExistsException, AccessDeniedException;
	Optional<UserMgmtResponseVO> userDel(UserMgmtRequestVO param);
	List<Role> userRoleList(SessionUser user);
	
	default TbUserInfo voTOEntity(UserMgmtRequestVO param) {
		return TbUserInfo.builder()
                .userId(param.getUserId())
                .userName(param.getUserName())
                .userEmail(param.getUserEmail())
                .role(param.getRole())
                .crtName(param.getCrtName())
                .uptName(param.getUptName())
                .userPicture(param.getUserPicture())
                .build();
		
	}
	
	default UserMgmtResponseVO EntityTOvo(TbUserInfo vo) {
		return UserMgmtResponseVO.builder()
				.userInfo(vo)
                .build();
		
	}
	
	default TbUserInfo modEntity(TbUserInfo user, UserMgmtRequestVO param) {
		user.modUser(param.getUserId(),
				param.getUserName(), 
				param.getUserEmail(),
				param.getUserPicture(),
				param.getRole(),
				param.getUseYn(),
				param.getUserEmail());
		
		return user;
	}
}