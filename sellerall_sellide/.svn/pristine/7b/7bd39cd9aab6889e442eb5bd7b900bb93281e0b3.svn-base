package kr.co.sellerall.cmm.component;

import kr.co.sellerall.cmm.enums.ErrorCode;
import kr.co.sellerall.cmm.exception.CommonRuntimeException;

public class CommonUtils {
	
	/**
	 * obj가 null 일경우 익셉션
	 * @methodName    : isEmptyException
	 * @author        : YoungHun yoon
	 * @date          : 2021.07.17
	 * @param <I>
	 * @param obj
	 * @return obj
	 */
	public static <I> I isEmptyException(I obj) {
		if (obj == null) {
			throw new CommonRuntimeException(ErrorCode.INVALID_INPUT_VALUE.getMessage(),
					ErrorCode.INVALID_INPUT_VALUE);
		}
		return obj;
	}
}