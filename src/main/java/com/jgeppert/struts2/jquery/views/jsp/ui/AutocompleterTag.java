/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.jgeppert.struts2.jquery.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.components.Autocompleter;
import com.opensymphony.xwork2.util.ValueStack;

public class AutocompleterTag extends AbstractFormElementTag
{

	private static final long	serialVersionUID	= 4675729906623010236L;

	protected String			delay;
	protected String			loadMinimumCount;
	protected String			list;
	protected String			listKey;
	protected String			listValue;
	protected String			selectBox;
	protected String			emptyOption;
	protected String			headerKey;
	protected String			headerValue;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Autocompleter(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		Autocompleter completer = (Autocompleter) component;
		completer.setDelay(delay);
		completer.setLoadMinimumCount(loadMinimumCount);
		completer.setList(list);
		completer.setListKey(listKey);
		completer.setListValue(listValue);
		completer.setSelectBox(selectBox);
		completer.setEmptyOption(emptyOption);
		completer.setHeaderKey(headerKey);
		completer.setHeaderValue(headerValue);
	}

	public void setDelay(String delay) {
		this.delay = delay;
	}

	public void setLoadMinimumCount(String loadMinimumCount) {
		this.loadMinimumCount = loadMinimumCount;
	}

	public void setList(String list) {
		this.list = list;
	}

	public void setListKey(String listKey) {
		this.listKey = listKey;
	}

	public void setListValue(String listValue) {
		this.listValue = listValue;
	}

	public void setSelectBox(String selectBox) {
		this.selectBox = selectBox;
	}

	public void setEmptyOption(String emptyOption) {
		this.emptyOption = emptyOption;
	}

	public void setHeaderKey(String headerKey) {
		this.headerKey = headerKey;
	}

	public void setHeaderValue(String headerValue) {
		this.headerValue = headerValue;
	}
}
