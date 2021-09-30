package kr.co.sellerall.sys.service.Impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.cmm.domain.menu.TbMenuGrp;
import kr.co.sellerall.cmm.domain.user.TbRankInfo;
import kr.co.sellerall.cmm.domain.user.TbRankInfoRepository;
import kr.co.sellerall.sys.service.RankMgmtService;
import kr.co.sellerall.sys.vo.RankRequestVO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class RankMgmtServiceImpl implements RankMgmtService {
	private static final Logger logger = LoggerFactory.getLogger(UserMgmtServiceImpl.class);
	private final TbRankInfoRepository rankRepository;
	
	@Override
	public List<TbRankInfo> rankAllList() {
		List<TbRankInfo> rankList = rankRepository.findAll(Sort.by("sortOrdr"));
		
		return rankList;
	}

	@Override
	public void rankDelete(Long rankSeq) {
		rankRepository.deleteById(rankSeq);
	}

	@Override
	public void rankInsert(RankRequestVO param, SessionUser user) {
		TbRankInfo rankInfo = rankRepository.findById(param.getRankSeq()).orElse(null);
		if(rankInfo != null) {
			TbRankInfo modRank = modRankEntity(rankInfo,param,user);
			rankRepository.save(modRank);
		}else {
			TbRankInfo newRank = voTORankEntity(param,user);
			rankRepository.save(newRank);
		}
		
	}
	
	
}
