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

import com.jgeppert.struts2.jquery.components.MenuItem;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * @see com.jgeppert.struts2.jquery.components.MenuItem
 */
public class MenuItemTag extends AbstractRemoteTag {

	private static final long serialVersionUID = -270033824138017378L;

	protected String title;
	protected String onClickTopics;

	public Component getBean(ValueStack stack, HttpServletRequest req,
							 HttpServletResponse res) {
		return new MenuItem(stack, req, res);
	}

	protected void populateParams() {
		super.populateParams();

		MenuItem item = (MenuItem) component;
		item.setTitle(title);
		item.setOnClickTopics(onClickTopics);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setOnClickTopics(String onClickTopics) {
		this.onClickTopics = onClickTopics;
	}
}
