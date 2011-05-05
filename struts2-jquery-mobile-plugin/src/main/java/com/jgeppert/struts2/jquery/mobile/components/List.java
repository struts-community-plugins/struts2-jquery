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

import com.jgeppert.struts2.jquery.components.AbstractFormListElement;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * This tag generates an List View.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * lt;sjm:list&gt;
 * 	&lt;s:url id=&quot;url1&quot; action=&quot;actionOne&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url1}&quot;&gt;Action 1&lt;/sjm:listItem&gt;
 * 	&lt;s:url id=&quot;url2&quot; action=&quot;actionTwo&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url1}&quot;&gt;Action 2&lt;/sjm:listItem&gt;
 * &lt;/sjm:list&gt;
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 * &lt;sjm:list inset=&quot;true&quot; filter=&quot;true&quot;&gt;
 * 	&lt;sjm:listItem divider=&quot;true&quot;&gt;Group 1&lt;/sjm:listItem&gt;
 * 	&lt;s:url id=&quot;url1&quot; action=&quot;actionOne&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url1}&quot;&gt;Action 1&lt;/sjm:listItem&gt;
 * 	&lt;s:url id=&quot;url2&quot; action=&quot;actionTwo&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url1}&quot;&gt;Action 2&lt;/sjm:listItem&gt;
 * 	
 * 	&lt;sjm:listItem divider=&quot;true&quot;&gt;Group 2&lt;/sjm:listItem&gt;
 * 	&lt;s:url id=&quot;url3&quot; action=&quot;actionThree&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url3}&quot;&gt;Action 3&lt;/sjm:listItem&gt;
 * 	&lt;s:url id=&quot;url4&quot; action=&quot;actionFour&quot;/&gt;
 * 	&lt;sjm:listItem href=&quot;%{url4}&quot;&gt;Action 4&lt;/sjm:listItem&gt;
 * &lt;/sjm:list&gt;
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "list", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.ListTag", description = "Render List View element", allowDynamicAttributes = true)
public class List extends AbstractFormListElement implements ThemeableBean {

    public static final String TEMPLATE = "list";
    public static final String TEMPLATE_CLOSE = "list-close";
    public static final String COMPONENT_NAME = List.class.getName();
    private static final transient Random RANDOM = new Random();

    protected String dataTheme;
    protected String inset;
    protected String filter;
    protected String listParam;
    protected String listHref;
    protected String listCounter;

    public List(ValueStack stack, HttpServletRequest request,
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

	if (dataTheme != null)
	    addParameter("dataTheme", findString(dataTheme));
	addParameter("role", "listview");

	if (this.inset != null)
	    addParameter("inset", findValue(this.inset, Boolean.class));
	if (this.filter != null)
	    addParameter("filter", findValue(this.filter, Boolean.class));
	if (listParam != null)
	    addParameter("listParam", findString(listParam));
	if (listHref != null)
	    addParameter("listHref", findString(listHref));
	if (listCounter != null)
	    addParameter("listCounter", findString(listCounter));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "list_" + String.valueOf(nextInt);
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

    @StrutsTagAttribute(description = "embed the list in the content area", defaultValue = "false", type = "Boolean")
    public void setInset(String inset) {
	this.inset = inset;
    }

    @StrutsTagAttribute(description = "make a list filterable", defaultValue = "false", type = "Boolean")
    public void setFilter(String filter) {
	this.filter = filter;
    }

    @StrutsTagAttribute(description = "parameter for listHref if listHref is set", defaultValue = "id")
    public void setListParam(String listParam) {
	this.listParam = listParam;
    }

    @StrutsTagAttribute(description = "href value for each list value.")
    public void setListHref(String listHref) {
	this.listHref = listHref;
    }

    @StrutsTagAttribute(description = "counter value of list item")
    public void setListCounter(String listCounter) {
	this.listCounter = listCounter;
    }

    @StrutsTagAttribute(description = "Set the List View theme. e.g. a,b,c,d or e")
    public void setDataTheme(String dataTheme) {
	this.dataTheme = dataTheme;
    }

}
