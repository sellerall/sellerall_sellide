package kr.co.sellerall.cmm.vo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVO {
	private String status;
	private List<?> resultList;
    private int totalCount;
    private int pageSize;
    private int pageIndex;
    
    /**
	 * 
	 */
	public ResultVO() {
		super();
		this.pageSize = 10; //기본사이즈 10
		this.pageIndex = 1;
	}
	/**
	 * @param status
	 * @param resultList
	 * @param totalCount
	 */
	public ResultVO(String status, List<?> resultList, int totalCount) {
		super();
		this.status = status;
		this.resultList = resultList;
		this.totalCount = totalCount;
		this.pageSize = 5;
		this.pageIndex = 1;
	}
	
	public void handleResultList(List<?> resultList, int totalCount) {
		this.resultList = resultList;
		this.totalCount = totalCount;
	}
	
	public void handleResultList(String status, List<?> resultList, int totalCount) {
		this.status = status;
		this.resultList = resultList;
		this.totalCount = totalCount;
	}
}
