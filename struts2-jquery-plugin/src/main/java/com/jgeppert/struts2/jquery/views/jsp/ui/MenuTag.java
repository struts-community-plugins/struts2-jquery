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

import com.jgeppert.struts2.jquery.components.Menu;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * @see com.jgeppert.struts2.jquery.components.Menu
 */
public class MenuTag extends AbstractTopicTag {

	private static final long serialVersionUID = 594523103591646134L;

	protected String disabled;
	protected String targets;
	protected String href;
	protected Object list;
	protected String listKey;
	protected String listValue;
	protected String paramName;

	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		return new Menu(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		Menu menu = (Menu) component;
		menu.setDisabled(disabled);
		menu.setTargets(targets);
		menu.setHref(href);
		menu.setParamName(paramName);
		menu.setList(list);
		menu.setListKey(listKey);
		menu.setListValue(listValue);
	}


	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setList(Object list) {
		this.list = list;
	}

	public void setTargets(String targets) {
		this.targets = targets;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
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
