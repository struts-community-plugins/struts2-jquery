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
 * A tag that creates an HTML &lt;a/&gt; element.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sjm:a id=&quot;myLink&quot; href=&quot;#page1&quot;&gt;My Link to an Page&lt;/sjm:a&gt;&lt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <p>
 * An Link displayed as Button with Icon which reference an external Page.
 * </p>
 * 
 * <pre>
 * &lt;sjm:a href=&quot;http://code.google.com/p/struts2-jquery/&quot; button=&quot;true&quot; buttonIcon=&quot;star&quot; rel=&quot;external&quot;&gt;Plugin Homepage&lt;/sjm:a&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "a", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.AnchorTag", description = "Renders an HTML anchor element.", allowDynamicAttributes = true)
public class Anchor extends com.jgeppert.struts2.jquery.components.Anchor {
	public static final String TEMPLATE = "a";
	public static final String TEMPLATE_CLOSE = "a-close";
	public static final String COMPONENT_NAME = Anchor.class.getName();
	public static final transient Random RANDOM = new Random();

	protected String button;
	protected String buttonIcon;
	protected String buttonIconPosition;

	public Anchor(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public String getComponentName() {
		return COMPONENT_NAME;
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		if (button != null)
			addParameter("button", findValue(this.button, Boolean.class));
		if (buttonIcon != null)
			addParameter("buttonIcon", findString(buttonIcon));
		if (buttonIconPosition != null)
			addParameter("buttonIconPosition", findString(buttonIconPosition));

		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
					.abs(nextInt);
			this.id = "anchor_" + String.valueOf(nextInt);
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

	@StrutsTagAttribute(description = "Render a Button", defaultValue = "false", type = "Boolean")
	public void setButton(String button) {
		this.button = button;
	}

	@StrutsTagAttribute(description = "Icons to display. eg. gear, arrow-l, home, ....")
	public void setButtonIcon(String buttonIcon) {
		this.buttonIcon = buttonIcon;
	}

	@StrutsTagAttribute(description = "Button Icon Position. eg. left, right, top, bottom, notext")
	public void setButtonIconPosition(String buttonIconPosition) {
		this.buttonIconPosition = buttonIconPosition;
	}
}
