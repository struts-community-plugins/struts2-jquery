package com.jgeppert.struts2.jquery.results;

import java.util.Collection;

public class JqueryGridResult {
	private Integer page; //the number of the requested page
	private Integer total; //the total pages of the query
	private Integer records; //total number of records for the query
	private Collection<Object> rows; //an array that contains the actual data
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Integer getRecords() {
		return records;
	}
	public void setRecords(Integer records) {
		this.records = records;
	}
	public Collection<Object> getRows() {
		return rows;
	}
	public void setRows(Collection<Object> rows) {
		this.rows = rows;
	}
	
}
