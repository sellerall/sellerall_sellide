package kr.co.sellerall.cmm.service.Impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.sellerall.cmm.component.CommonUtils;
import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrpRepository;
import kr.co.sellerall.cmm.domain.menu.TbMenuMst;
import kr.co.sellerall.cmm.domain.menu.TbMenuMstRepository;
import kr.co.sellerall.cmm.domain.user.TbAuthInfoRepository;
import kr.co.sellerall.cmm.domain.user.TbRankInfo;
import kr.co.sellerall.cmm.domain.user.TbRankInfoRepository;
import kr.co.sellerall.cmm.service.MenuService;
import kr.co.sellerall.cmm.vo.MenuVO;
import lombok.RequiredArgsConstructor;

/**
 * @packageName   : kr.co.sellerall.cmm.service
 * @fileName      : MenuServiceImpl.java
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
public class MenuServiceImpl implements MenuService{
	private static final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	private final TbMenuGrpRepository menuGrpRepository;
	private final TbMenuMstRepository menuMstRepository;
	private final TbRankInfoRepository tbRankInfoRepository;
	
	@Override
	public List<Object> menuAllList(SessionUser user,String reqUrl) {
		List<Object> resultList =  new ArrayList<Object>();
		HashMap<String, Object> menuMap = new HashMap<String, Object>();
		List<MenuVO> menuMstList = new ArrayList<MenuVO>();
		
		List<TbMenuGrp> grpList = menuGrpRepository.findAll(Sort.by("sortOrdr"));
		List<TbMenuMst> mstList = menuMstRepository.findAll(Sort.by("sortOrdr"));
		TbRankInfo authCode = tbRankInfoRepository.findByRole(user.getRole());
		CommonUtils.isEmptyException(grpList);
		CommonUtils.isEmptyException(mstList);
		CommonUtils.isEmptyException(authCode);
		
		//authCode = CommonUtils.checkAuthCode(user.getRole());
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
			
			menuMstList = (List<MenuVO>) getAuthMenuList(menuMstList,reqUrl, authCode.getAuthCode());
			
			menuMap.put("menuMst",menuMstList);
			if(menuMstList.size() != 0) {
				resultList.add(menuMap);
			}
		}
		
		return resultList;
	}
	
	@Override
	public List<TbMenuGrp> menuGrpList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TbMenuMst> menuMstList() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * @methodName    : getAuthMenuList
	 * @author        : YoungHun Yoon
	 * @date          : 2020.10.23
	 * @param list
	 * @param nowMenuGrpSeq
	 * @param userAuth
	 * @return Collection<?>
	 * 메뉴 권한이 있는 메뉴리스트 조회
	 */
	private Collection<?> getAuthMenuList(List<MenuVO> list, String reqUrl, String userAuth) {
		Collection<?> col = CollectionUtils.select(list, new Predicate() {
			@Override
			public boolean evaluate(Object object) {
				MenuVO menuVO = (MenuVO) object;
				Long menuGrpSeq = menuVO.getMenuGrpSeq();
				String menuUrl = menuVO.getMenuUrl();
				
				if (menuUrl.equalsIgnoreCase(reqUrl)) {
					menuVO.setActive(true);
				}
				if (menuGrpSeq != 0) {
					String menuAuth = menuVO.getAuthCode();
					int menuAuthNum = Integer.parseInt(menuAuth, 2);
					int userAuthNum = Integer.parseInt(userAuth, 2);
					int access = menuAuthNum & userAuthNum;
					// 논리곱 후에 0이면 해당 메뉴의 권한이 없는 것.
					if(access == 0 ) {
						return false;
					}
				}
				return true;
			}
		});
		return col;
	}
	
}
