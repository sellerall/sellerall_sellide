package kr.co.sellerall.sys.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.sellerall.cmm.component.ApiResult;
import kr.co.sellerall.cmm.component.Result;
import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.TbRankInfo;
import kr.co.sellerall.sys.service.RankMgmtService;
import kr.co.sellerall.sys.vo.MenuMstRequestVO;
import kr.co.sellerall.sys.vo.RankRequestVO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/api/sys")
public class RankMgmtRestController {
	private static final Logger logger = LoggerFactory.getLogger(RankMgmtRestController.class);
	private final RankMgmtService rankMgmtService;
	
	/**
	 * 권한 목록 리스트 요청
	 * @methodName    : menuSelectAllList
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@Secured({"ROLE_ADMIN","ROLE_SUPER"})
	@PostMapping(value = "/v1/rank/list")
	public List<TbRankInfo> rankSelectAllList(Model model) throws Exception {
		logger.debug("sys/v1/rank/list/ , rankList 컨트롤러 ");
    	List<TbRankInfo> rankList = rankMgmtService.rankAllList();
		return rankList;
	}
	/**
	 * 권한 추가
	 * @methodName    : rankInsert
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@Secured({"ROLE_SUPER"})
	@PostMapping(value = "/v1/rank")
	public ResponseEntity<ApiResult> rankInsert(@RequestBody RankRequestVO param,@LoginUser SessionUser user) throws Exception {
		logger.debug("sys/v1/rank , menuInsert 컨트롤러 ");
    	rankMgmtService.rankInsert(param,user);
		return Result.ok("ok");
	}
	
	/**
	 * 권한 삭제
	 * @methodName    : rankDelete
	 * @author        : YoungHun Yoon
	 * @date          : 2021.02.08
	 * @Description	  : 버전/api명
	 */
	@Secured({"ROLE_SUPER"})
	@DeleteMapping(value = "/v1/rank/{rankSeq}")
	public ResponseEntity<ApiResult> rankDelete(@PathVariable("rankSeq") Long rankSeq,Model model) throws Exception {
		logger.debug("sys/v1/rank , delete 컨트롤러 ");
		rankMgmtService.rankDelete(rankSeq);
		return Result.ok("ok");
	}
	
}
