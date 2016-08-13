/**
 * 
 */
package com.jgeppert.struts2.jquery.datatables.model;

import java.io.Serializable;

/**
 *
 */
public class DatatablesColumn implements Serializable {

	public static final String DATA = "data";
	public static final String NAME = "name";
	public static final String ORDERABLE = "orderable";
	public static final String SEARCH = "search";
	public static final String SEARCHABLE = "searchable";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1351750155261698861L;

	private String data;
	private String name;
	private boolean orderable;
	private DatatablesSearch search;
	private boolean searchable;

	/**
	 * 
	 */
	public DatatablesColumn() {
	}

	public String getData() {
		return this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOrderable() {
		return this.orderable;
	}

	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

	public DatatablesSearch getSearch() {
		return this.search;
	}

	public void setSearch(DatatablesSearch search) {
		this.search = search;
	}

	public boolean isSearchable() {
		return this.searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}
}
