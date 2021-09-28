package kr.co.sellerall.cmm.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {									// 	코드 (00000000 길이8) (+,스카우터,셀리드,에이드,관리자)  		
	SUPER("ROLE_SUPER", "루트관리자"),					// 	   00 00 00 11 (관리자)
	ADMIN("ROLE_ADMIN", "관리자"),					// 	   00 00 00 10 (관리자)
	USER("ROLE_USER", "일반 사용자"),					// 	   00 11 00 00 (셀리드)
	GUEST("ROLE_GUEST", "손님"),						// 	   00 00 00 00 (가입유저)  
	
	SELLIDE("ROLE_SELLIDE", "셀리드 사용자"),			// 	   00 11 11 00 (에이드, 셀리드)
	AID("ROLE_AID", "에이드 사용자"),					// 	   00 00 11 00
	SCOUT("ROLE_SCOUT", "스카우터 사용자");				// 	   11 00 00 00
	
	//TEMP("ROLE_TEMP", "그룹메뉴 추가시 예시");				// 	11 00 00 00 00 
	
	private final String key;
	private final String title;
}
