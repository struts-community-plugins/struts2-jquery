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

import com.jgeppert.struts2.jquery.components.Select;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @see Select
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */

public class SelectTag extends AbstractFormElementTag {

    private static final long serialVersionUID = 3974875529913867071L;
    protected String emptyOption;
    protected String headerKey;
    protected String headerValue;
    protected String list;
    protected String listKey;
    protected String listTitle;
    protected String listValue;
    protected String size;
    protected String multiple;
    protected String autocomplete;
    protected String loadMinimumCount;
    protected String selectBoxIcon;
    protected String onSelectTopics;

    public Component getBean(ValueStack stack, HttpServletRequest req,
	    HttpServletResponse res) {
	return new Select(stack, req, res);
    }

    protected void populateParams() {
	super.populateParams();

	Select select = (Select) component;
	select.setEmptyOption(emptyOption);
	select.setHeaderKey(headerKey);
	select.setHeaderValue(headerValue);
	select.setList(list);
	select.setListKey(listKey);
	select.setListTitle(listTitle);
	select.setListValue(listValue);
	select.setSize(size);
	select.setMultiple(multiple);
	select.setAutocomplete(autocomplete);
	select.setLoadMinimumCount(loadMinimumCount);
	select.setSelectBoxIcon(selectBoxIcon);
	select.setOnSelectTopics(onSelectTopics);
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

    public void setList(String list) {
	this.list = list;
    }

    public void setListKey(String listKey) {
	this.listKey = listKey;
    }

    public void setListTitle(String listTitle) {
	this.listTitle = listTitle;
    }

    public void setListValue(String listValue) {
	this.listValue = listValue;
    }

    public void setSize(String size) {
	this.size = size;
    }

    public void setMultiple(String multiple) {
	this.multiple = multiple;
    }

    public void setAutocomplete(String autocomplete) {
	this.autocomplete = autocomplete;
    }

    public void setLoadMinimumCount(String loadMinimumCount) {
	this.loadMinimumCount = loadMinimumCount;
    }

    public void setSelectBoxIcon(String selectBoxIcon) {
	this.selectBoxIcon = selectBoxIcon;
    }

    public void setOnSelectTopics(String onSelectTopics) {
	this.onSelectTopics = onSelectTopics;
    }

}
