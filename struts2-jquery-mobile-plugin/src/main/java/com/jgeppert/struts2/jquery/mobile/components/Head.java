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
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a Head Element
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * <sjm:head />
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "head", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.HeadTag", description = "add necessary scripts and styles to the head area", allowDynamicAttributes = true)
public class Head extends com.jgeppert.struts2.jquery.components.Head {

	public static final String TEMPLATE = "head";
	public static final String COMPONENT_NAME = Head.class.getName();

	protected String compressed;
	protected String jqueryui;

	public Head(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	protected String getDefaultTemplate() {
		return TEMPLATE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		if (this.compressed != null)
			addParameter("compressed",
					findValue(this.compressed, Boolean.class));
		if (this.jqueryui != null)
			addParameter("jqueryui", findValue(this.jqueryui, Boolean.class));
		else
			addParameter("jqueryui", new Boolean(false));
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

	@StrutsTagAttribute(description = "enable jQuery UI Scripts", defaultValue = "false", type = "Boolean")
	public void setJqueryui(String jqueryui) {
		this.jqueryui = jqueryui;
	}

	@StrutsTagAttribute(description = "use compressed version of jquery mobile resources", defaultValue = "true", type = "Boolean")
	public void setCompressed(String compressed) {
		this.compressed = compressed;
	}
}
