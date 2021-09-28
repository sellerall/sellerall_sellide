package kr.co.sellerall.cmm.component;


import org.springframework.stereotype.Component;

import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.domain.user.TbUserInfoRepository;
import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;
import kr.co.sellerall.cmm.exception.RegistrationException;
import kr.co.sellerall.cmm.exception.UserEmailExistsException;
import kr.co.sellerall.cmm.exception.UserIdExistsException;
import kr.co.sellerall.cmm.vo.UserSaveRequestVO;

/**
 * User registration domain service
 */
@Component
public class RegistrationManagement {

	private TbUserInfoRepository userRepository;
	private PasswordEncryptor passwordEncryptor;

	public RegistrationManagement(TbUserInfoRepository repository, PasswordEncryptor passwordEncryptor) {
		this.userRepository = repository;
		this.passwordEncryptor = passwordEncryptor;
	}

	public TbUserInfo register(UserSaveRequestVO requestVO)
			throws RegistrationException {
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

		TbUserInfo newUser = requestVO.toEntity().pwdEncrypt(passwordEncryptor.encrypt(requestVO.getUserPwd()));
		userRepository.save(newUser);
		return newUser;
	}
}