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
 * The tabbedpanel widget is primarily an AJAX component, where each tab can
 * either be local content or remote content.
 * </p>
 * <p>
 * If the useSelectedTabCookie attribute is set to true, the id of the selected
 * tab is saved in a cookie on activation. When coming back to this view, the
 * cookie is read and the tab will be activated again, unless an actual value
 * for the selectedTab attribute is specified.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * <b>Examples</b>
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sj:tabbedpanel id=&quot;mytabs&quot; animate=&quot;true&quot; collapsible=&quot;true&quot; useSelectedTabCookie=&quot;true&quot;&gt; 
 *  &lt;sj:tab id=&quot;tab1&quot; target=&quot;tone&quot; label=&quot;Tab One&quot;/&gt; 
 *  &lt;sj:tab id=&quot;tab2&quot; target=&quot;ttwo&quot; label=&quot;Tab Two&quot;/&gt; 
 *  &lt;sj:tab id=&quot;tab3&quot; target=&quot;tthree&quot; label=&quot;Tab Three&quot;/&gt; 
 *  &lt;div id=&quot;tone&quot;&gt; Test 1 &lt;/div&gt; 
 *  &lt;div id=&quot;ttwo&quot;&gt; Test 2 &lt;/div&gt; 
 *  &lt;div id=&quot;tthree&quot;&gt; Test 3 &lt;/div&gt;
 * &lt;/sj:tabbedpanel&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 * &lt;s:url id=&quot;remoteurl1&quot; action=&quot;myremoteactionone&quot;/&gt; 
 * &lt;s:url id=&quot;remoteurl2&quot; action=&quot;myremoteactiontwo&quot;/&gt; 
 * &lt;s:url id=&quot;remoteurl3&quot; action=&quot;myremoteactionthree&quot;/&gt; 
 * &lt;sj:tabbedpanel id=&quot;mytabs2&quot; selectedTab=&quot;1&quot;&gt; 
 *  &lt;sj:tab id=&quot;tab1&quot; href=&quot;%{remoteurl1}&quot; label=&quot;Tab One&quot;/&gt; 
 *  &lt;sj:tab id=&quot;tab2&quot; href=&quot;%{remoteurl2}&quot; label=&quot;Tab Two&quot;/&gt; 
 *  &lt;sj:tab id=&quot;tab3&quot; href=&quot;%{remoteurl3}&quot; label=&quot;Tab Three&quot;/&gt; 
 * &lt;/sj:tabbedpanel&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "tabbedpanel", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.TabbedPanelTag", description = "Render a tabbedPanel widget.")
public class TabbedPanel extends AbstractTopicsBean {
	public static final String JQUERYACTION = "tabbedpanel";
	public static final String TEMPLATE = "tabbedpanel";
	public static final String TEMPLATE_CLOSE = "tabbedpanel-close";
	final private static String COMPONENT_NAME = TabbedPanel.class.getName();
	private final static transient Random RANDOM = new Random();

	protected String selectedTab;
	protected String useSelectedTabCookie;
	protected String openOnMouseover;
	protected String collapsible;
	protected String show;
	protected String hide;
	protected String cache;
	protected String disabledTabs;
	protected String sortable;
	protected String onLoadTopics;
	protected String onActivateTopics;
	protected String onBeforeActivateTopics;
	protected String heightStyle;

	public TabbedPanel(ValueStack stack, HttpServletRequest request,
			HttpServletResponse response) {
		super(stack, request, response);
	}

	public void evaluateExtraParams() {
		super.evaluateExtraParams();

		addParameter("jqueryaction", JQUERYACTION);

		addOgnlEvaluatedObjectParameterIfExists("selectedTab", selectedTab, Integer.class);
		addOgnlEvaluatedObjectParameterIfExists("useSelectedTabCookie", this.useSelectedTabCookie, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("openOnMouseover", this.openOnMouseover, Boolean.class);
		addOgnlEvaluatedObjectParameterIfExists("collapsible", this.collapsible, Boolean.class);
		addOgnlEvaluatedStringParameterIfExists("show", show);
		addOgnlEvaluatedStringParameterIfExists("hide", hide);
		addOgnlEvaluatedObjectParameterIfExists("cache", this.cache, Boolean.class);
		addOgnlEvaluatedStringParameterIfExists("disabledTabs", this.disabledTabs);
		addOgnlEvaluatedStringParameterIfExists("onLoadTopics", this.onLoadTopics);
		addOgnlEvaluatedStringParameterIfExists("onActivateTopics", this.onActivateTopics);
		addOgnlEvaluatedStringParameterIfExists("onBeforeActivateTopics", this.onBeforeActivateTopics);
		addOgnlEvaluatedObjectParameterIfExists("sortable", this.sortable, Boolean.class);
		addOgnlEvaluatedStringParameterIfExists("heightStyle", heightStyle);

		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
					.abs(nextInt);
			this.id = "tabbedpanel_" + String.valueOf(nextInt);
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

	public String getDefaultOpenTemplate() {
		return TEMPLATE;
	}

	protected String getDefaultTemplate() {
		return TEMPLATE_CLOSE;
	}

	public String getComponentName() {
		return COMPONENT_NAME;
	}

	@StrutsTagAttribute(description = "The id to assign to the component.", required = true)
	public void setId(String id) {
		// This is required to override tld generation attributes to
		// required=true
		super.setId(id);
	}

	@StrutsTagAttribute(description = "Number of tab that will be selected by default. e.g. 0 for the first tab or 1 for the second tab.", type = "Integer", defaultValue = "0")
	public void setSelectedTab(String selectedTab) {
		this.selectedTab = selectedTab;
	}

	@StrutsTagAttribute(description = "Open Tabs by mouseover event", defaultValue = "false", type = "Boolean")
	public void setOpenOnMouseover(String openOnMouseover) {
		this.openOnMouseover = openOnMouseover;
	}

	@StrutsTagAttribute(description = "Set to true to allow an already selected tab to become unselected again upon reselection", defaultValue = "false", type = "Boolean")
	public void setCollapsible(String collapsible) {
		this.collapsible = collapsible;
	}

	@StrutsTagAttribute(description = "If and how to animate the hiding of the panel. Multiple types supported: Boolean, Number, Object or String (escaped with ' e.g.: 'fold' ")
	public void setShow(String show) {
		this.show = show;
	}

	@StrutsTagAttribute(description = "If and how to animate the showing of the panel. Multiple types supported: Boolean, Number, Object or String (escaped with ' e.g.: 'fold' ")
	public void setHide(String hide) {
		this.hide = hide;
	}

	@StrutsTagAttribute(description = "Store the latest selected tab in a cookie. The cookie is then used to determine the initially selected tab if the selectedTab option is not defined.", defaultValue = "false", type = "Boolean")
	public void setUseSelectedTabCookie(String useSelectedTabCookie) {
		this.useSelectedTabCookie = useSelectedTabCookie;
	}

	@StrutsTagAttribute(description = "Whether or not to cache remote tabs content, e.g. load only once or with every click. Cached content is being lazy loaded, e.g once and only once for the first click.", defaultValue = "false", type = "Boolean")
	public void setCache(String cache) {
		this.cache = cache;
	}

	@StrutsTagAttribute(description = "An array containing the position of the tabs (zero-based index) that should be disabled on initialization. e.g. [1, 2]")
	public void setDisabledTabs(String disabledTabs) {
		this.disabledTabs = disabledTabs;
	}
	@StrutsTagAttribute(description = "A comma delimited list of topics that published after the content of a remote tab has been loaded.", type = "String", defaultValue = "")
	public void setOnLoadTopics(String onLoadTopics) {
		this.onLoadTopics = onLoadTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published after a tab has been activated (after animation completes). If the tabs were previously collapsed.", type = "String", defaultValue = "")
	public void setOnActivateTopics(String onActivateTopics) {
		this.onActivateTopics = onActivateTopics;
	}

	@StrutsTagAttribute(description = "A comma delimited list of topics that published directly after a tab is activated.", type = "String", defaultValue = "")
	public void setOnBeforeActivateTopics(String onBeforeActivateTopics) {
		this.onBeforeActivateTopics = onBeforeActivateTopics;
	}

	@StrutsTagAttribute(description = "Making tabs sortable.", defaultValue = "false", type = "Boolean")
	public void setSortable(String sortable) {
		this.sortable = sortable;
	}

	@StrutsTagAttribute(description = "Controls the height of the accordion and each panel. Possible values 'auto\': All panels will be set to the height of the tallest panel, 'content': Each panel will be only as tall as its content, 'fill': Expand to the available height based on the accordion's parent height.", defaultValue = "auto")
	public void setHeightStyle(String heightStyle) {
		this.heightStyle = heightStyle;
	}
}
