package kr.co.sellerall.cmm.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
	//common
	INVALID_INPUT_VALUE(400, "COMMON-ERR-400", " Invalid Input Value"),
	TOKEN_EXPIRATION(401, "COMMON-ERR-401", "Token Expiration"),
	NOT_FOUND(404,"COMMON-ERR-404","Page Not Found"),
    INTER_SERVER_ERROR(500,"COMMON-ERR-500","Inter Server Error"),
    HANDLE_ACCESS_DENIED(403, "COMMON-ERR-403", "Access Denied"),
    EXISTS_DATA(405,"COMMON-ERR-405","Exists Data"),
    
    //user
    EMAIL_DUPLICATION(400,"USER-ERR-400","UserEmail already exists"),
    ID_DUPLICATION(400,"USER-ERR-400","UserId already exists"),
    NOT_EXISTS_USER(402,"USER-ERR-402","Not Exists User"),
    NOT_ALLOW_USER(401, "USER-ERR-401", "Not Allow User"),
    
    //productManager
    PROD_CD_PARTNER_CD_NULL(400, "PRODUCT-ERR-400", "ProdCd Not Null,PartnerCd Not Null"),
    
    ;

    private int status;
    private String errorCode;
    private String message;
}
