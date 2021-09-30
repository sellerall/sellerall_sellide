package kr.co.sellerall.sellide.component;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @packageName   : kr.co.sellerall.sellide.component
 * @fileName      : UrlMaker.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 * URL example (http://ip:8080/file/chart/domain.do?key1=value1&key2=value2#Somewhere)
 * (Path)					/file/chart/domain.do
 * (Parameters)				?key1=value1&key2=value2
 * (Anchor)					#Somewhere
 * 
 */

public class DomeUrlMaker {
	private String protocolAuthority;
	private String path="";
	private String ver="";
	private String mode="";
	private String aid="";
	private String market="";
	private String om="json";
	private String so="";			//정렬 방식
	private String ev="";			//기획전 번호
	private String ca="";			//카테고리 검색
	private String id="";			//판매자 아이디 검색
	private String kw="";			//검색어 검색
	private String mnp="";			//가격대 검색 : 최저 가격대
	private String mxp="";			//가격대 검색 : 최대 가격대
	private String mnq="";			//최소구매 수량 검색 :최저수량
	private String mxq="";			//최소구매 수량 검색 :최대수량
	private String who="";			//배송비부담
	private String org="";			//국산 여부
	private String sgd="";			//우수판매자 상품 검색
	private String fdl="";			//빠른배송 상품 검색
	private String itemNo="";		//상품번호 검색
	private String no="";			//상품번호 검색
	private String sz="";			//상품 출력 개수
	private String pg="";			//페이지 번호
	
	public static class Builder {
		private String protocolAuthority;
		private String path="";
		private String ver="";
		private String mode="";
		private String aid="";
		private String market="";
		private String om="";
		private String so="";			//정렬 방식
		private String ev="";			//기획전 번호
		private String ca="";			//카테고리 검색
		private String id="";			//판매자 아이디 검색
		private String kw="";			//검색어 검색
		private String mnp="";			//가격대 검색 : 최저 가격대
		private String mxp="";			//가격대 검색 : 최대 가격대
		private String mnq="";			//최소구매 수량 검색 :최저수량
		private String mxq="";			//최소구매 수량 검색 :최대수량
		private String who="";			//배송비부담
		private String org="";			//국산 여부
		private String sgd="";			//우수판매자 상품 검색
		private String fdl="";			//빠른배송 상품 검색
		private String itemNo="";		//상품번호 검색
		private String no="";			//상품번호 검색
		
		private String sz="";		//상품 출력 개수
		private String pg="";		//페이지 번호
		
		
		public Builder protocolAuthority(String protocolAuthority) {
			this.protocolAuthority = protocolAuthority;
			return this;
		}
		
		public Builder path(String path) {
			this.path = path;
			return this;
		}
		public Builder ver(String ver) {
			this.ver= "?ver=" + ver;
			return this;
		}
		public Builder mode(String mode) {
			this.mode= "&mode=" + mode;
			return this;
		}
		public Builder aid(String aid) {
			this.aid= "&aid=" + aid;
			return this;
		}
		public Builder market(String market) {
			this.market= "&market=" + market;
			return this;
		}
		public Builder om(String om) {
			this.om= "&om=" + om;
			return this;
		}
		public Builder sz(String sz) {
			this.sz= "&sz=" + sz;
			return this;
		}
		public Builder pg(String pg) {
			this.pg= "&pg=" + pg;
			return this;
		}
		public Builder so(String so) {
			this.so="&so="+so;
			return this;
		}
		public Builder ev(String ev) {
			this.ev="&ev="+ev;
			return this;
		}
		public Builder ca(String ca) {
			this.ca="&ca="+ca;
			return this;
		}
		public Builder id(String id) {
			this.id="&id="+id;
			return this;
		}
		public Builder kw(String kw) {
			this.kw="&kw="+kw;
			return this;
		}
		public Builder mnp(String mnp) {
			this.mnp="&mnp="+mnp;
			return this;
		}
		public Builder mxp(String mxp) {
			this.mxp="&mxp="+mxp;
			return this;
		}
		public Builder mnq(String mnq) {
			this.mnq="&mnq="+mnq;
			return this;
		}
		public Builder mxq(String mxq) {
			this.mxq="&mxq="+mxq;
			return this;
		}
		public Builder who(String who) {
			this.who="&who="+who;
			return this;
		}
		public Builder org(String org) {
			this.org="&org="+org;
			return this;
		}
		public Builder sgd(String sgd) {
			this.sgd="&sgd="+sgd;
			return this;
		}
		public Builder fdl(String fdl) {
			this.fdl="&fdl="+fdl;
			return this;
		}
		public Builder itemNo(String itemNo) {
			this.itemNo="&itemNo="+itemNo;
			return this;
		}
		public Builder no(String no) {
			this.no="&no="+no;
			return this;
		}
	
		
		public DomeUrlMaker builder() {
			return new DomeUrlMaker(this);
		}
	}
	
	private DomeUrlMaker(Builder builder){
		protocolAuthority	= builder.protocolAuthority;
		path				= builder.path;
		ver					= builder.ver;
		mode				= builder.mode;
		aid					= builder.aid;
		market				= builder.market;
		om					= builder.om;
		so					= builder.so;
		ev					= builder.ev;
		ca					= builder.ca;
		id					= builder.id;
		kw					= builder.kw;
		mnp					= builder.mnp;
		mxp       			= builder.mxp;
		mnq					= builder.mnq;
		mxq					= builder.mxq;
		who					= builder.who;
		org					= builder.org;
		sgd					= builder.sgd;
		fdl					= builder.fdl;
		itemNo				= builder.itemNo;
		no					= builder.no;
		sz					= builder.sz;
		pg					= builder.pg;
	}
	
	protected static String encodingString(String string){
		try {
			string=URLEncoder.encode(string, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return string;
	}
	
	public String encodingSpace(String string) {
		return string.replace(" ", "+");
	}
	
	@Override
	public String toString() {
		return encodingSpace(protocolAuthority + path + ver + mode + aid + market + om + sz+ pg +so + ev + ca + id + kw + mnp + mxp + mnq + mxq + who + org + sgd + fdl + itemNo + no) ;
	}

	
	/*
	 * // 엑셀 다운로드용 중복제거 필요해서 하나 만듬. public String toDistinctString() { return
	 * encodingSpace(protocolAuthority + path + from + volume + "&" + "where=" +
	 * encodingString(where) + distinct + whereGroupOrder + "&" + query + "&" +
	 * limit+"&"+offset) ; }
	 */
	

}