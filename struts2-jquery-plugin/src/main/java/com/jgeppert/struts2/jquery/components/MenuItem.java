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

import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

    public static final String TEMPLATE = "menuItem";
    public static final String JQUERYACTION = "menuItem";
    public static final String TEMPLATE_CLOSE = "menuItem-close";
    public static final String COMPONENT_NAME = MenuItem.class.getName();

    private static final String PARAM_TITLE = "title";
    private static final String PARAM_MENU_ICON = "menuIcon";
    private static final String PARAM_ON_CLICK_TOPICS = "onClickTopics";
    private static final String ID_PREFIX_MENU_ITEM = "menuItem_";

    protected String title;
    protected String menuIcon;
    protected String onClickTopics;

    public MenuItem(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_TITLE, this.title);
        addParameterIfPresent(PARAM_MENU_ICON, this.menuIcon);
        addParameterIfPresent(PARAM_ON_CLICK_TOPICS, this.onClickTopics);

        addGeneratedIdParam(ID_PREFIX_MENU_ITEM);

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

    @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked")
    public void setOnClickTopics(String onClickTopics) {
        this.onClickTopics = onClickTopics;
    }
}
