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

package com.jgeppert.struts2.jquery.mobile.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an Combobox.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */

@StrutsTag(name = "select", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.SelectTag", description = "Renders a Combobox", allowDynamicAttributes = true)
public class Select extends org.apache.struts2.components.Select {

	public static final String TEMPLATE = "select";
	public static final String COMPONENT_NAME = Select.class.getName();

	public Select(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

	}

	@Override
	@StrutsTagSkipInheritance
	public void setTheme(String theme) {
		super.setTheme(theme);
	}

	@Override
	public String getTheme() {
		return "mobile";
	}
}
