package kr.co.sellerall.sys.service;

import java.util.List;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.cmm.domain.menu.TbMenuMst;
import kr.co.sellerall.cmm.vo.MenuVO;
import kr.co.sellerall.sys.vo.MenuGrpRequestVO;
import kr.co.sellerall.sys.vo.MenuMstRequestVO;

public interface MenuMgmtService {
	List<Object> menuAllList();
	List<TbMenuGrp> menuGrpList();
	void menuGrpDelete(Long menuGrpSeq);
	void menuMstDelete(Long menuMstSeq);
	void menuGrpInsert(MenuGrpRequestVO param,SessionUser user);
	void menuMstInsert(MenuMstRequestVO param,SessionUser user);
	
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
	
	default TbMenuGrp voTOGrpEntity(MenuGrpRequestVO param,SessionUser user) {
		return TbMenuGrp.builder()
				.menuGrpName(param.getMenuGrpName())
				.sortOrdr(param.getSortOrdr())
				.useYn(param.getUseYn())
				.crtName(user.getName())
				.uptName(user.getName())
				.build();
	}
	
	default TbMenuGrp modGrpEntity(TbMenuGrp menu,MenuGrpRequestVO param,SessionUser user) {
		menu.modMenuGrp(
				param.getMenuGrpName(), 
				param.getSortOrdr(), 
				param.getUseYn(),
				user.getName());
		return menu;
	}
	
	default TbMenuMst voTOMstEntity(MenuMstRequestVO param,SessionUser user) {
		return TbMenuMst.builder()
				.menuGrpSeq(param.getMenuGrpSeq())
				.menuName(param.getMenuName())
				.menuUrl(param.getMenuUrl())
				.authCode(param.getAuthCode())
				.sortOrdr(param.getSortOrdr())
				.useYn(param.getUseYn())
				.crtName(user.getName())
				.uptName(user.getName())
				.build();
	}
	
	default TbMenuMst modMstEntity(TbMenuMst menu,MenuMstRequestVO param,SessionUser user) {
		menu.modMenuMst(
				param.getMenuGrpSeq(), 
				param.getMenuName(), 
				param.getMenuUrl(),
				param.getAuthCode(),
				param.getSortOrdr(),
				param.getUseYn(),
				user.getName());
		return menu;
	}
}
