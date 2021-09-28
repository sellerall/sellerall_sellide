package kr.co.sellerall.cmm.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.exception.RegistrationException;
import kr.co.sellerall.cmm.exception.UserEmailExistsException;
import kr.co.sellerall.cmm.exception.UserIdExistsException;
import kr.co.sellerall.cmm.service.UserService;
import kr.co.sellerall.cmm.vo.UserSaveRequestVO;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import kr.co.sellerall.sys.vo.UserMgmtResponseVO;
import lombok.RequiredArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.cmm.controller
 * @fileName      : LoginRestController.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2020.10.20      YoungHun Yoon      최초생성
 *
 */

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/login")
public class LoginRestController {
	private static final Logger logger = LoggerFactory.getLogger(LoginRestController.class);
	private final UserService userService;

	/**
	 * @param 		: requestDto
	 * @return		: String
	 * @description	: 회원가입
	 */
    @PostMapping("/user")
    public ResponseEntity<ApiResult> save(@RequestBody UserSaveRequestVO requestDto){
    	logger.debug("회원가입");
    	try {
			userService.register(requestDto);
			return Result.ok("ok");
		} catch (RegistrationException e) {
			String errorMessage = "Registration failed";
			if (e instanceof UserIdExistsException) {
				errorMessage = "Username already exists";
			} else if (e instanceof UserEmailExistsException) {
				errorMessage = "Email address already exists";
			}
			return Result.failure(errorMessage);
		}
    }
    
    /**
	 * 현재 사용자 정보
	 * @methodName    : userInfo
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@GetMapping(value = "/user")
	public UserMgmtResponseVO userInfo(@LoginUser SessionUser user) throws UserNotExistsException{
		logger.debug("/userInfo/ , userInfo 컨트롤러");
		return userService.userSelectOne(user.getEmail());
	}
	
    /**
	 * @param 		: userId
	 * @return		: String
	 * @description	: 아이디 중복 확인
	 */
    @PostMapping("/user/id/{userId}")
    public ResponseEntity<ApiResult> findById(@PathVariable String userId){
    	logger.debug("아이디 중복 확인");
    	try {
			return userService.findByDuplicateUserId(userId);
		} catch (UserIdExistsException e) {
			return Result.ok("duplicate");
		}
    }
    
    /**
     * @param 		: userEmail
     * @return		: String
     * @description	: 이메일 중복 확인
     */
    @PostMapping("/user/em/{userEmail}")
    public ResponseEntity<ApiResult> findByEmail(@PathVariable String userEmail){
    	logger.debug("이메일 중복 확인");
    	try {
    		return userService.findByDuplicateUserEmail(userEmail);
    	} catch (UserEmailExistsException e) {
    		return Result.ok("duplicate");
    	}
    }
    /* @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }*/
    
    
  /*  @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id) {
        postsService.delete(id);
        return id;
    }*/
}
