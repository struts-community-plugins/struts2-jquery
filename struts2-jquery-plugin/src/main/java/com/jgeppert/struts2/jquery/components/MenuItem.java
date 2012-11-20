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

package com.jgeppert.struts2.jquery.components;

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
 * Renders a menu item
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "menuItem", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.MenuItemTag", description = "Render an menu item.")
public class MenuItem extends AbstractRemoteBean {

    final private static transient Random RANDOM = new Random();
    public static final String TEMPLATE = "menuItem";
    public static final String JQUERYACTION = "menuItem";
    public static final String TEMPLATE_CLOSE = "menuItem-close";
    public static final String COMPONENT_NAME = MenuItem.class.getName();

    protected String title;
    protected String menuIcon;
    protected String onClickTopics;

    public MenuItem(ValueStack stack, HttpServletRequest request,
	    HttpServletResponse response) {
	super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
	return TEMPLATE;
    }

    protected String getDefaultTemplate() {
	return TEMPLATE_CLOSE;
    }

    public void evaluateExtraParams() {
	super.evaluateExtraParams();

	addParameter("jqueryaction", JQUERYACTION);

	if (title != null)
	    addParameter("title", findString(title));
	if (menuIcon != null)
	    addParameter("menuIcon", findString(menuIcon));
	if (onClickTopics != null)
	    addParameter("onClickTopics", findString(onClickTopics));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "menuItem_" + String.valueOf(nextInt);
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
	return "jquery";
    }

    @StrutsTagAttribute(description = "menu item title")
    public void setTitle(String title) {
	this.title = title;
    }

    @StrutsTagAttribute(description = "Icons to display. The icon is displayed on the left of the label text. Value must be a classname (String), eg. ui-icon-gear.")
    public void setMenuIcon(String menuIcon) {
	this.menuIcon = menuIcon;
    }

    @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked", type = "String", defaultValue = "")
    public void setOnClickTopics(String onClickTopics) {
	this.onClickTopics = onClickTopics;
    }
}
