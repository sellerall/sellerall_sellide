package kr.co.sellerall.sellide.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShopInfoRequestVO{
	private String shopCode;
	private String shopName;
	private String shopId;
	private String shopPw;
	private String sellerId;
	private String apiId;
	private String domainId;
}
