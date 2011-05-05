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

package com.jgeppert.struts2.jquery.mobile.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.mobile.components.List;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractFormListElementTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @see List
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class ListTag extends AbstractFormListElementTag implements ThemeableTag {

    private static final long serialVersionUID = 4011274475116819123L;
    protected String inset;
    protected String filter;

    protected String dataTheme;
    protected String listParam;
    protected String listHref;
    protected String listCounter;

    public Component getBean(ValueStack stack, HttpServletRequest req,
	    HttpServletResponse res) {
	return new List(stack, req, res);
    }

    protected void populateParams() {
	super.populateParams();

	List list = (List) component;
	list.setDataTheme(dataTheme);
	list.setInset(inset);
	list.setFilter(filter);
	list.setListCounter(listCounter);
	list.setListHref(listHref);
	list.setListParam(listParam);
    }

    public void setDataTheme(String dataTheme) {
	this.dataTheme = dataTheme;
    }

    public void setInset(String inset) {
	this.inset = inset;
    }

    public void setFilter(String filter) {
	this.filter = filter;
    }

    public void setListParam(String listParam) {
	this.listParam = listParam;
    }

    public void setListHref(String listHref) {
	this.listHref = listHref;
    }

    public void setListCounter(String listCounter) {
	this.listCounter = listCounter;
    }
}
