package kr.co.sellerall.sys.service;

import java.util.List;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.user.TbRankInfo;
import kr.co.sellerall.sys.vo.RankRequestVO;

public interface RankMgmtService {
	List<TbRankInfo> rankAllList();
	void rankDelete(Long menuGrpSeq);
	void rankInsert(RankRequestVO param,SessionUser user);
	
	default TbRankInfo modRankEntity(TbRankInfo rank,RankRequestVO param,SessionUser user) {
		rank.modRankInfo(
				param.getRole(), 
				param.getAuthCode(), 
				param.getSortOrdr(), 
				param.getUseYn(),
				param.getNote(), 
				user.getName());
		return rank;
	}
	
	default TbRankInfo voTORankEntity(RankRequestVO param,SessionUser user) {
		return TbRankInfo.builder()
				.role(param.getRole())
				.authCode(param.getAuthCode())
				.sortOrdr(param.getSortOrdr())
				.useYn(param.getUseYn())
				.note(param.getNote())
				.crtName(user.getName())
				.uptName(user.getName())
				.build();
	}
}
