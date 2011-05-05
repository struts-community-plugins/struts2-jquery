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
 * This tag generates an HTML div for the jQuery mobile framework.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * A Div with role <strong>page</strong>
 * </p>
 * 
 * <pre>
 * &lt;sjm:div role=&quot;page&quot; id=&quot;page1&quot;&gt;
 * &lt;/sjm:div&gt;
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * <p>
 * A Div with role <strong>header</strong>
 * </p>
 * 
 * <pre>
 * &lt;sjm:div role=&quot;header&quot;&gt;
 * &lt;/sjm:div&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * 
 * <!-- START SNIPPET: example3 -->
 * <p>
 * A Div with theme <strong>n</strong>
 * </p>
 * 
 * <pre>
 * &lt;sjm:div dataTheme=&quot;b&quot;&gt;
 * &lt;/sjm:div&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example3 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "div", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.DivTag", description = "Render HTML div element", allowDynamicAttributes = true)
public class Div extends org.apache.struts2.components.Div implements
	ThemeableBean {

    public static final String TEMPLATE = "div";
    public static final String TEMPLATE_CLOSE = "div-close";
    public static final String COMPONENT_NAME = Div.class.getName();
    private static final transient Random RANDOM = new Random();

    protected String role;
    protected String dataTheme;

    public Div(ValueStack stack, HttpServletRequest request,
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

	if (role != null)
	    addParameter("role", findString(role));
	if (dataTheme != null)
	    addParameter("dataTheme", findString(dataTheme));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "div_" + String.valueOf(nextInt);
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

    @StrutsTagAttribute(description = "div role. e.g.: page, header, content, footer")
    public void setRole(String role) {
	this.role = role;
    }

    @StrutsTagAttribute(description = "set the div theme. e.g. a,b,c,d or e")
    public void setDataTheme(String dataTheme) {
	this.dataTheme = dataTheme;
    }
}
