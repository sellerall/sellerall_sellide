package kr.co.sellerall.cmm.service.Impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.RegistrationManagement;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.domain.user.SimpleUser;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.domain.user.TbUserInfoRepository;
import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;
import kr.co.sellerall.cmm.exception.RegistrationException;
import kr.co.sellerall.cmm.exception.UserEmailExistsException;
import kr.co.sellerall.cmm.exception.UserIdExistsException;
import kr.co.sellerall.cmm.service.UserService;
import kr.co.sellerall.cmm.vo.UserSaveRequestVO;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import kr.co.sellerall.sys.vo.UserMgmtResponseVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	private final TbUserInfoRepository userRepository;
	private final RegistrationManagement registrationManagement;
	@PersistenceContext
    private final EntityManager entityManager;

	@Override
	public ResponseEntity<ApiResult> findByDuplicateUserId(String userId) throws UserIdExistsException {
		/*TbUserInfo entity = userRepository.findByUserId(userId).orElseThrow(()-> new IllegalArgumentException("해당 아이디가 없습니다. id="+userId));*/
		TbUserInfo entity = userRepository.findByUserId(userId).orElse(null);
		if (entity != null) {
			throw new UserIdExistsException(ErrorCode.ID_DUPLICATION.getMessage(), ErrorCode.ID_DUPLICATION);
		}
		return Result.ok("ok");
	}
	
	@Override
	public ResponseEntity<ApiResult> findByDuplicateUserEmail(String userEmail) throws UserEmailExistsException {
		TbUserInfo entity = userRepository.findByUserEmail(userEmail).orElse(null);
		if (entity != null) {
			throw new UserEmailExistsException(ErrorCode.EMAIL_DUPLICATION.getMessage(), ErrorCode.EMAIL_DUPLICATION);
		}
		return Result.ok("ok");
	}
	
	@Override
	public UserMgmtResponseVO userSelectOne(String email) throws UserNotExistsException {
		TbUserInfo userInfo = userRepository.findByUserEmail(email.toLowerCase()).orElse(null);
		
		if (userInfo == null) {
			throw new UserNotExistsException(ErrorCode.NOT_EXISTS_USER.getMessage(), ErrorCode.NOT_EXISTS_USER);
		}
		return EntityTOvo(userInfo);
	}

	@Transactional
	@Override
	public String register(UserSaveRequestVO requestVO) throws RegistrationException {
		TbUserInfo newUser = registrationManagement.register(requestVO);
		StoredProcedureQuery sqp = entityManager.createNamedStoredProcedureQuery(TbUserInfo.product);
		sqp.setParameter("TableName", newUser.getUserSeq());
		sqp.execute();
		return newUser.getUserId();
	}
	
	@Override
	public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
		if (StringUtils.isEmpty(userId)) {
			throw new UsernameNotFoundException("No user found");
		}
		TbUserInfo user;
		if (userId.contains("@")) {
			user = userRepository.findByUserEmail(userId).orElseThrow(()-> new CommonRuntimeException(ErrorCode.NOT_EXISTS_USER.getMessage(), ErrorCode.NOT_EXISTS_USER));
		} else {
			user = userRepository.findByUserId(userId).orElseThrow(()-> new CommonRuntimeException(ErrorCode.NOT_EXISTS_USER.getMessage(), ErrorCode.NOT_EXISTS_USER));
		}
		
		if (user == null) {
			throw new UsernameNotFoundException("No user found by `" + userId + "`");
		}
		
		return new SimpleUser(user);
	}
}

