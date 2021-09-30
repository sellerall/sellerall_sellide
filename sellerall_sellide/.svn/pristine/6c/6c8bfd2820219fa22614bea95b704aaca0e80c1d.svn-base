package kr.co.sellerall.cmm.domain.user;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import kr.co.sellerall.cmm.config.auth.dto.SessionUser;
import kr.co.sellerall.sys.vo.UserMgmtRequestVO;

public class TbUserInfoPredicate {
	public static Predicate search(UserMgmtRequestVO userMgmtRequestVO,SessionUser user) {
		QTbUserInfo userInfo = QTbUserInfo.tbUserInfo;
		
		BooleanBuilder builder = new BooleanBuilder();

        if(userMgmtRequestVO.getUserId() != null && userMgmtRequestVO.getUserId().length() > 0){
            builder.and(userInfo.userId.eq(userMgmtRequestVO.getUserId()));
        }
        if(userMgmtRequestVO.getUserEmail() != null && userMgmtRequestVO.getUserEmail().length() > 0){
            builder.and(userInfo.userEmail.eq(userMgmtRequestVO.getUserEmail()));
        }
        if(userMgmtRequestVO.getUserName() != null && userMgmtRequestVO.getUserName().length() > 0){
            builder.and(userInfo.userName.eq(userMgmtRequestVO.getUserName()));
        }
        if(userMgmtRequestVO.getRole() != null ){
            builder.and(userInfo.role.eq(userMgmtRequestVO.getRole()));
        }
        if(userMgmtRequestVO.getUseYn() != null && userMgmtRequestVO.getUseYn().length() > 0){
            builder.and(userInfo.useYn.eq(userMgmtRequestVO.getUseYn()));
        }
        //관리자 권한일경우 루트관리자 제외 
        if(user.getRole() == Role.ADMIN){
        	builder.and(userInfo.role.ne(Role.SUPER));
        	builder.or(userInfo.role.isNull());
        }
		return builder;
	}
}
