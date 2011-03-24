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

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * This tag generates an List Item.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * 	&lt;s:url id=&quot;url1&quot; action=&quot;actionOne&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url1}&quot;&gt;Action 1&lt;/sjm:listItem&gt;
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <p>
 * A List Item as Divider.
 * </p>
 * 
 * <pre>
 * 	&lt;sjm:listItem divider=&quot;true&quot;&gt;Group 1&lt;/sjm:listItem&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "listItem", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.ListItemTag", description = "Render List Item element", allowDynamicAttributes = true)
public class ListItem extends Anchor {

	public static final String TEMPLATE = "listItem";
	public static final String TEMPLATE_CLOSE = "listItem-close";
	public static final String COMPONENT_NAME = ListItem.class.getName();
	private static final transient Random RANDOM = new Random();

	protected String divider;

	public ListItem(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		if (this.divider != null)
			addParameter("divider", findValue(this.divider, Boolean.class));

		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
					.abs(nextInt);
			this.id = "list_item_" + String.valueOf(nextInt);
			addParameter("id", this.id);
		}
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

	@StrutsTagAttribute(description = "a divider list item", defaultValue = "false", type = "Boolean")
	public void setDivider(String divider) {
		this.divider = divider;
	}
}
