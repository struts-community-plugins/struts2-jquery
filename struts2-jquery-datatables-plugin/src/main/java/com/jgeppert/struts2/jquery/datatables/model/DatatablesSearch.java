/**
 * 
 */
package com.jgeppert.struts2.jquery.datatables.model;

import java.io.Serializable;
import java.util.Map;

/**
 *
 */
public class DatatablesSearch implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8746961193307466223L;
	public static final String VALUE = "value";
	public static final String REGEX = "regex";

	private String value;
	private boolean regex;

	/**
	 * 
	 */
	public DatatablesSearch() {
	}

	public DatatablesSearch(String value, boolean regex) {
		super();
		this.value = value;
		this.regex = regex;
	}

	public DatatablesSearch(Map<String, Object> v) {
		this.value = (String) v.get(VALUE);
		this.regex = Boolean.valueOf((String) v.get(REGEX));
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isRegex() {
		return this.regex;
	}

	public void setRegex(boolean regex) {
		this.regex = regex;
	}
}
