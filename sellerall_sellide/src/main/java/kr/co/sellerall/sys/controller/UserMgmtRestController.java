package kr.co.sellerall.sys.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.Role;
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

@RequiredArgsConstructor
@RestController
@Secured({"ROLE_ADMIN","ROLE_SUPER"})
@RequestMapping(value = "/api/sys")
public class UserMgmtRestController {
	private static final Logger logger = LoggerFactory.getLogger(UserMgmtRestController.class);
	private final UserMgmtService userMgmtService;
	
	/**
	 * @param 		: requestDto
	 * @return		: String
	 * @throws AccessDeniedException 
	 * @description	: 사용자 추가
	 */
    @PostMapping("/v1/user")
    public ResponseEntity<ApiResult> save(@RequestBody UserMgmtSaveRequestVO requestDto,@LoginUser SessionUser user) throws AccessDeniedException{
    	logger.debug("회원가입");
    	try {
    		userMgmtService.register(requestDto,user);
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
	 * 사용자 목록 리스트 요청
	 * @methodName    : userSelectList
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/user/list")
	public ResultVO userSelectList(@RequestBody UserMgmtRequestVO param,Model model,@LoginUser SessionUser user) throws Exception {
		logger.debug("/v1/user/ , userList 컨트롤러 " + param.getPageIndex() + " ," + param.getPageSize());
		return userMgmtService.userSelectList(param,user);
	}
	
	
	/**
	 * 사용자 정보 요청
	 * @methodName    : userSelectOne
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/user/{userEmail}")
	public UserMgmtResponseVO userSelectOne(@PathVariable String userEmail) throws UserNotExistsException{
		logger.debug("/v1/user/ , userSelectOne 컨트롤러");
		return userMgmtService.userSelectOne(userEmail);
	}
	
	
	/**
	 * 사용자 수정
	 * @methodName    : userMod
	 * @author        : YoungHun Yoon
	 * @throws UserNotExistsException 
	 * @throws AccessDeniedException 
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PutMapping(value = "/v1/user")
	public ResponseEntity<ApiResult> userMod(@RequestBody UserMgmtRequestVO requestDto,@LoginUser SessionUser user) throws UserNotExistsException, AccessDeniedException{
		String result = userMgmtService.userMod(requestDto,user);
		return Result.ok(result);
	}
	
	/**
	 * 사용자 권한 정보 
	 * @methodName    : userMod
	 * @author        : YoungHun Yoon
	 * @throws UserNotExistsException 
	 * @throws AccessDeniedException 
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@PostMapping(value = "/v1/user/role")
	public List<Role> userRoleList(Model model,@LoginUser SessionUser user) {
		List<Role> list = userMgmtService.userRoleList(user);
		return list;
	}
}
