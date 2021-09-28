package kr.co.sellerall.sys.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sellerall.cmm.component.PasswordEncryptor;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.domain.user.TbUserInfoPredicate;
import kr.co.sellerall.cmm.domain.user.TbUserInfoRepository;
import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;
import kr.co.sellerall.cmm.exception.RegistrationException;
import kr.co.sellerall.cmm.exception.UserEmailExistsException;
import kr.co.sellerall.cmm.exception.UserIdExistsException;
import kr.co.sellerall.cmm.vo.ResultVO;
import kr.co.sellerall.sys.exception.AccessDeniedException;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import kr.co.sellerall.sys.service.UserMgmtService;
import kr.co.sellerall.sys.vo.UserMgmtRequestVO;
import kr.co.sellerall.sys.vo.UserMgmtResponseVO;
import kr.co.sellerall.sys.vo.UserMgmtSaveRequestVO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserMgmtServiceImpl implements UserMgmtService {
	private static final Logger logger = LoggerFactory.getLogger(UserMgmtServiceImpl.class);
	private final TbUserInfoRepository userRepository;
	private final PasswordEncryptor passwordEncryptor;
	@PersistenceContext
    private final EntityManager entityManager;

	@Transactional
	@Override
	public String register(UserMgmtSaveRequestVO requestVO,SessionUser user) throws RegistrationException, AccessDeniedException {
		if(requestVO.getUserId().length() <= 1 && requestVO.getUserEmail().length() <= 1) {
			throw new CommonRuntimeException(ErrorCode.INVALID_INPUT_VALUE.getMessage(), ErrorCode.INVALID_INPUT_VALUE);
		}
		TbUserInfo existingUser = userRepository.findByUserId(requestVO.getUserId()).orElse(null);
		if (existingUser != null) {
			throw new UserIdExistsException(ErrorCode.ID_DUPLICATION.getMessage(), ErrorCode.ID_DUPLICATION);
		}
		existingUser = userRepository.findByUserEmail(requestVO.getUserEmail().toLowerCase()).orElse(null);
		if (existingUser != null) {
			throw new UserEmailExistsException(ErrorCode.ID_DUPLICATION.getMessage(), ErrorCode.EMAIL_DUPLICATION);
		}
		if(user.getRole() != Role.SUPER && (requestVO.getRole() == Role.ADMIN ||  requestVO.getRole() == Role.SUPER)){ //슈퍼유저 아닐 경우 슈퍼유저,관리자 권한 부여 불가
			throw new AccessDeniedException(ErrorCode.HANDLE_ACCESS_DENIED.getMessage(), ErrorCode.HANDLE_ACCESS_DENIED);
		}
		
		TbUserInfo newUser = requestVO.toEntity().pwdEncrypt(passwordEncryptor.encrypt(requestVO.getUserPwd()));
		userRepository.save(newUser);
		StoredProcedureQuery sqp = entityManager.createNamedStoredProcedureQuery(TbUserInfo.product);	//사용자 스토리지 생성
		sqp.setParameter("TableName", newUser.getUserSeq());
		sqp.execute();
		return newUser.getUserId();
	}
	
	@Override
	public ResultVO userSelectList(UserMgmtRequestVO param,SessionUser user) {
		ResultVO resultVO = new ResultVO();
		Page<TbUserInfo> pageList = null;
		pageList = userRepository.findAll(TbUserInfoPredicate.search(param,user),PageRequest.of(param.getPageIndex()-1,param.getPageSize()));
		
		List<TbUserInfo> userList = pageList.getContent();
		List<UserMgmtResponseVO> list = userList.stream().map(entity -> EntityTOvo(entity)).collect(Collectors.toList());
		resultVO.handleResultList(list,(int)pageList.getTotalElements());
		resultVO.setPageIndex(param.getPageIndex());
		resultVO.setPageSize(param.getPageSize());
		return resultVO;
	}
	
	@Override
	public UserMgmtResponseVO userSelectOne(String email) throws UserNotExistsException {
		TbUserInfo userInfo = userRepository.findByUserEmail(email.toLowerCase()).orElse(null);
		
		if (userInfo == null) {
			throw new UserNotExistsException(ErrorCode.NOT_EXISTS_USER.getMessage(), ErrorCode.NOT_EXISTS_USER);
		}
		return EntityTOvo(userInfo);
	}


	@Override
	public String userMod(UserMgmtRequestVO param,SessionUser user) throws UserNotExistsException, AccessDeniedException{
		Optional<TbUserInfo> userInfo = userRepository.findByUserEmail(param.getUserEmail().toLowerCase());
		if(userInfo != null) {
			if(userInfo.get().getRole() == Role.ADMIN && user.getRole() != Role.SUPER ) {		//사용자가 관리자일경우 슈퍼유저외에 수정 불가 
				throw new AccessDeniedException(ErrorCode.HANDLE_ACCESS_DENIED.getMessage(), ErrorCode.HANDLE_ACCESS_DENIED);
			}else if(user.getRole() != Role.SUPER && (param.getRole() == Role.ADMIN ||  param.getRole() == Role.SUPER)){ //슈퍼유저 아닐 경우 슈퍼유저,관리자 권한 부여 불가
				throw new AccessDeniedException(ErrorCode.HANDLE_ACCESS_DENIED.getMessage(), ErrorCode.HANDLE_ACCESS_DENIED);
			}else {
				TbUserInfo modUser = modEntity(userInfo.get(),param);
				if(param.getUserPwd() != null && param.getUserPwd().length() > 0) {
					modUser.pwdEncrypt(passwordEncryptor.encrypt(param.getUserPwd()));
				}
				userRepository.save(modUser);
			}
		}else {
			throw new UserNotExistsException(ErrorCode.NOT_EXISTS_USER.getMessage(), ErrorCode.NOT_EXISTS_USER);
		}
		return "ok";
	}

	@Override
	public Optional<UserMgmtResponseVO> userDel(UserMgmtRequestVO param) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Role> userRoleList(SessionUser user) {
		List<Role> list = new ArrayList<Role>();
		for (Role role : Role.values()) {
			if(user.getRole() != Role.SUPER && role ==  Role.SUPER) {
				continue;
			}
			list.add(role);
		}

		return list;
	}

}
