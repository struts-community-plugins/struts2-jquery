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

import com.jgeppert.struts2.jquery.components.Accordion;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * @see Accordion
 */
public class AccordionTag extends AbstractTopicTag {

	private static final long serialVersionUID = 5309231035916461134L;

	protected String active;
	protected String animate;
	protected String heightStyle;
	protected String collapsible;
	protected String header;
	protected String openOnMouseover;
	protected String href;
	protected String paramKeys;
	protected String paramValues;
	protected String list;
	protected String listKey;
	protected String listValue;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Accordion(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		Accordion accordion = (Accordion) component;
		accordion.setActive(active);
		accordion.setAnimate(animate);
		accordion.setHeightStyle(heightStyle);
		accordion.setCollapsible(collapsible);
		accordion.setHeader(header);
		accordion.setOpenOnMouseover(openOnMouseover);
		accordion.setHref(href);
		accordion.setParamKeys(paramKeys);
		accordion.setParamValues(paramValues);
		accordion.setList(list);
		accordion.setListKey(listKey);
		accordion.setListValue(listValue);
	}

	public void setActive(String active) {
		this.active = active;
	}

	public void setAnimate(String animate) {
		this.animate = animate;
	}

	public void setHeightStyle(String heightStyle) {
		this.heightStyle = heightStyle;
	}


	public void setCollapsible(String collapsible) {
		this.collapsible = collapsible;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public void setOpenOnMouseover(String openOnMouseover) {
		this.openOnMouseover = openOnMouseover;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setParamKeys(String paramKeys) {
		this.paramKeys = paramKeys;
	}

	public void setParamValues(String paramValues) {
		this.paramValues = paramValues;
	}

	public void setOnBeforeTopics(String onBeforeTopics) {
		this.onBeforeTopics = onBeforeTopics;
	}

	public void setOnAlwaysTopics(String onAlwaysTopics) {
		this.onAlwaysTopics = onAlwaysTopics;
	}

	public void setOnChangeTopics(String onChangeTopics) {
		this.onChangeTopics = onChangeTopics;
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
}
