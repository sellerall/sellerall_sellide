package kr.co.sellerall.cmm.service;

import java.util.HashMap;
import java.util.List;

import kr.co.sellerall.cmm.config.auth.LoginUser;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.cmm.domain.menu.TbMenuMst;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.vo.MenuVO;
import kr.co.sellerall.sys.vo.UserMgmtRequestVO;
import kr.co.sellerall.sys.vo.UserMgmtResponseVO;

/**
 * @packageName   : kr.co.sellerall.cmm.service
 * @fileName      : MenuService.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */
public interface MenuService {
	List<Object> menuAllList(SessionUser user,String reqUrl);
	List<TbMenuGrp> menuGrpList();
	List<TbMenuMst> menuMstList();
	
	default MenuVO menuMstTOvo(TbMenuMst vo) {
		return MenuVO.builder()
				.menuGrpSeq(vo.getMenuGrpSeq())
                .menuSeq(vo.getMenuSeq())
                .menuUrl(vo.getMenuUrl())
                .menuName(vo.getMenuName())
                .sortOrdr(vo.getSortOrdr())
                .authCode(vo.getAuthCode())
                .note(vo.getNote())
                .useYn(vo.getUseYn())
                .crtName(vo.getCrtName())
                .crtDate(vo.getCrtDate())
                .uptName(vo.getUptName())
                .uptDate(vo.getUptDate())
                .build();
		
	}
	
}
