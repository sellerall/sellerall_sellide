package kr.co.sellerall.cmm.vo;

import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import kr.co.sellerall.cmm.component.DateJsonSerializer;

/**
 * @packageName   : kr.co.sellerall.cmm.vo
 * @fileName      : CommonVO.java
 * @author        : YoungHun Yoon
 * @date          : 2021.07.17 
 * @description   : 
 * ==============================================
 * DATE            AUTH            NOTE
 * ----------------------------------------------
 * 2021.07.17      YoungHun Yoon      최초생성
 *
 */
public class CommonVO {

	private String note;
	private String crtName;
	private LocalDateTime crtDate;
	private String uptName;
	private LocalDateTime uptDate;
	private String srchKeyword;
	private String orderByName;
	private String orderByType;
	private int pageIndex; 
    private int startRow; 
    private int endRow;
    private int pageSize; 
    private int defaultSize = 10; 
    
    /**
	 * @return the orderByName
	 */
	public String getOrderByName() {
		return orderByName;
	}

	/**
	 * @param orderByName the orderByName to set
	 */
	public void setOrderByName(String orderByName) {
		this.orderByName = orderByName;
	}

	/**
	 * @return the orderByType
	 */
	public String getOrderByType() {
		return orderByType;
	}

	/**
	 * @param orderByType the orderByType to set
	 */
	public void setOrderByType(String orderByType) {
		this.orderByType = orderByType;
	}

	/**
	 * @return the srchKeyword
	 */
	public String getSrchKeyword() {
		return srchKeyword;
	}

	/**
	 * @param srchKeyword the srchKeyword to set
	 */
	public void setSrchKeyword(String srchKeyword) {
		this.srchKeyword = srchKeyword;
	}

	/**
	 * @return the defaultSize
	 */
	public int getDefaultSize() {
		return defaultSize;
	}

	/**
	 * @param defaultSize the defaultSize to set
	 */
	public void setDefaultSize(int defaultSize) {
		this.defaultSize = defaultSize;
	}

	/**
	 * @param startRow the startRow to set
	 */
	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	/**
	 * @param endRow the endRow to set
	 */
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}

	/**
	 * 
	 */
	public CommonVO() {
		super();
		handlePaging(0, defaultSize);
	}

	/**
	 * @param pageIndex
	 */
	public CommonVO(int pageIndex) {
		super();
		handlePaging(pageIndex, defaultSize);
	}

    /**
	 * @param pageIndex
	 * @param pageSize
	 */
	public CommonVO(int pageIndex, int pageSize) {
		super();
		handlePaging(pageIndex, pageSize);
	}

	/**
     * @methodName    : handlePaging
     * @author        : Kenny Kim
     * @date          : 2020.10.23
     * @param pageIndex
     * @param pageSize
     * startRow, endRow를 계산한다. 
     */
    public void handlePaging(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex < 1 ? 1 : pageIndex;
        this.pageSize = pageSize;
        this.startRow = ((this.pageIndex-1) * pageSize);
        this.endRow = startRow + pageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public int getStartRow() {
        return startRow;
    }

    public int getEndRow() {
        return endRow;
    }

    public int getPageSize() {
        return pageSize;
    }
    
	/**
	 * @param pageIndex the pageIndex to set
	 */
	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
		handlePaging(pageIndex, this.pageSize);
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
		handlePaging(this.pageIndex, this.pageSize);
	}

	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the crtName
	 */
	public String getCrtName() {
		return crtName;
	}
	/**
	 * @param crtName the crtName to set
	 */
	public void setCrtName(String crtName) {
		this.crtName = crtName;
	}
	/**
	 * @return the uptName
	 */
	public String getUptName() {
		return uptName;
	}
	/**
	 * @param uptName the uptName to set
	 */
	public void setUptName(String uptName) {
		this.uptName = uptName;
	}

	/**
	 * @return the crtDate
	 */
	@JsonSerialize(using = DateJsonSerializer.class)
	public LocalDateTime getCrtDate() {
		return crtDate;
	}

	/**
	 * @param crtDate the crtDate to set
	 */
	public void setCrtDate(LocalDateTime crtDate) {
		this.crtDate = crtDate;
	}

	/**
	 * @return the uptDate
	 */
	@JsonSerialize(using = DateJsonSerializer.class)
	public LocalDateTime getUptDate() {
		return uptDate;
	}

	/**
	 * @param uptDate the uptDate to set
	 */
	public void setUptDate(LocalDateTime uptDate) {
		this.uptDate = uptDate;
	}
}
