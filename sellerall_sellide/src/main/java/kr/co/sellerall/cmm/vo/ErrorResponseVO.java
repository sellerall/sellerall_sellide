package kr.co.sellerall.cmm.vo;

import kr.co.sellerall.cmm.enums.ErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponseVO {
    private int status;
    private String message;
    private String code;

    public ErrorResponseVO(ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.message = errorCode.getMessage();
        this.code = errorCode.getErrorCode();
    }
}