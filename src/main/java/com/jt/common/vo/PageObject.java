package com.jt.common.vo;

import java.io.Serializable;
import java.util.List;

public class PageObject<T> implements Serializable {

	private static final long serialVersionUID = 6780580291247550747L;

	/**每页要显示的最大记录数*/
	private Integer pageSize=3;
	/**当前页*/
	private Integer pageCurrent;
	/**总页数*/
	private Integer pageCount;
	/**总记录数*/
	private Integer rowCount;
	/**当前页数据(记录)*/
	private List<T> records;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getPageCurrent() {
		return pageCurrent;
	}
	public void setPageCurrent(Integer pageCurrent) {
		this.pageCurrent = pageCurrent;
	}
	public Integer getPageCount() {
		return pageCount;
	}
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getRowCount() {
		return rowCount;
	}
	public void setRowCount(Integer rowCount) {
		this.rowCount = rowCount;
	}
	public List<T> getRecords() {
		return records;
	}
	public void setRecords(List<T> records) {
		this.records = records;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
