package kr.co.sellerall.sys.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.sellerall.cmm.component.CommonUtils;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrpRepository;
import kr.co.sellerall.cmm.domain.menu.TbMenuMst;
import kr.co.sellerall.cmm.domain.menu.TbMenuMstRepository;
import kr.co.sellerall.cmm.domain.user.Role;
import kr.co.sellerall.cmm.domain.user.TbUserInfo;
import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;
import kr.co.sellerall.cmm.vo.MenuVO;
import kr.co.sellerall.sys.exception.AccessDeniedException;
import kr.co.sellerall.sys.exception.UserNotExistsException;
import kr.co.sellerall.sys.service.MenuMgmtService;
import kr.co.sellerall.sys.vo.MenuGrpRequestVO;
import kr.co.sellerall.sys.vo.MenuMstRequestVO;
import lombok.RequiredArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.sys.service.Impl
 * @fileName      : MenuMgmtServiceImpl.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */
@Service
@RequiredArgsConstructor
public class MenuMgmtServiceImpl implements MenuMgmtService{

	private final TbMenuGrpRepository menuGrpRepository;
	private final TbMenuMstRepository menuMstRepository;
	
	@Override
	public List<Object> menuAllList() {
		List<Object> resultList =  new ArrayList<Object>();
		HashMap<String, Object> menuMap = new HashMap<String, Object>();
		List<MenuVO> menuMstList = new ArrayList<MenuVO>();
		
		List<TbMenuGrp> grpList = menuGrpRepository.findAll(Sort.by("sortOrdr"));
		List<TbMenuMst> mstList = menuMstRepository.findAll(Sort.by("sortOrdr"));
		
		CommonUtils.isEmptyException(grpList);
		CommonUtils.isEmptyException(mstList);
		//logger.debug("현재 URL :" + reqUrl);
		
		for (TbMenuGrp menuGroup : grpList) {
			menuMap = new HashMap<String, Object>();
			Long key = menuGroup.getMenuGrpSeq();
			
			menuMap.put("menuGrpSeq",menuGroup.getMenuGrpSeq());
			menuMap.put("menuGrpName",menuGroup.getMenuGrpName());
			menuMap.put("sortOrdr",menuGroup.getSortOrdr());
			menuMap.put("note",menuGroup.getNote());
			menuMap.put("useYn",menuGroup.getUseYn());
			menuMap.put("crtName",menuGroup.getCrtName());
			menuMap.put("crtDate",menuGroup.getCrtDate());
			menuMap.put("uptName",menuGroup.getUptName());
			menuMap.put("uptDate",menuGroup.getUptDate());
          
			menuMstList = new ArrayList<MenuVO>();
			mstList.stream()
					.map(e->menuMstTOvo(e))
					.filter(m -> m.getMenuGrpSeq().equals(key))
					.forEach(menuMstList::add);
			
			menuMap.put("menuMst",menuMstList);
			resultList.add(menuMap);
		}
		
		return resultList;
	}

	@Override
	public List<TbMenuGrp> menuGrpList() {
		List<TbMenuGrp> grpList = menuGrpRepository.findAll();
		return grpList;
	}

	@Override
	public void menuGrpDelete(Long menuGrpSeq) {
		menuGrpRepository.deleteById(menuGrpSeq);
	}

	@Override
	public void menuMstDelete(Long menuMstSeq) {
		menuMstRepository.deleteById(menuMstSeq);
	}

	@Override
	public void menuGrpInsert(MenuGrpRequestVO param,SessionUser user) {
		TbMenuGrp menuGrp = menuGrpRepository.findById(param.getMenuGrpSeq()).orElse(null);
		if(menuGrp != null) {
			TbMenuGrp modGrpMenu = modGrpEntity(menuGrp,param,user);
			menuGrpRepository.save(modGrpMenu);
		}else {
			TbMenuGrp newGrpMenu = voTOGrpEntity(param,user);
			menuGrpRepository.save(newGrpMenu);
		}
	}

	@Override
	public void menuMstInsert(MenuMstRequestVO param,SessionUser user) {
		TbMenuMst menuMst = menuMstRepository.findById(param.getMenuSeq()).orElse(null);
		if(menuMst != null) {
			TbMenuMst modMstMenu = modMstEntity(menuMst,param,user);
			menuMstRepository.save(modMstMenu);
		}else {
			TbMenuMst newMstMenu = voTOMstEntity(param,user);
			menuMstRepository.save(newMstMenu);
		}
	}
	
	
}
