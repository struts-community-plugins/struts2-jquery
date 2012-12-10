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
 * A tag that creates an Spinner. BETA
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * <p>
 * A simple Spinner.
 * </p>
 * 
 * <pre>
 * &lt;sj:spinner name=&quot;spinner1&quot; id=&quot;spinner1&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * <p>
 * A Spinner max=50 and step=2.
 * </p>
 * 
 * <pre>
 *     &lt;sj:spinner
 *       name=&quot;spinner2&quot;
 *       id=&quot;spinner2&quot;
 *       min=&quot;5&quot;
 *       max=&quot;50&quot;
 *       step=&quot;2&quot;
 *       value=&quot;25&quot;/&gt;
 * 
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * <p>
 * A Spinner with currency format and mouse wheel support.
 * </p>
 * 
 * <pre>
 * &lt;sj:spinner
 *       name=&quot;spinner3&quot;
 *       id=&quot;spinner3&quot;
 *       min=&quot;0.00&quot;
 *       max=&quot;5.00&quot;
 *       step=&quot;0.15&quot;
 *       value=&quot;2.50&quot;
 *       numberFormat=&quot;C&quot;
 *       mouseWheel=&quot;true&quot;/&gt;
 *     &lt;br/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example3 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "spinner", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SpinnerTag", description = "Render a Spinner. BETA", allowDynamicAttributes = true)
public class Spinner extends Textfield {

    public static final String JQUERYACTION = "spinner";
    public static final String TEMPLATE = "spinner";
    public static final String TEMPLATE_CLOSE = "spinner-close";
    final private static transient Random RANDOM = new Random();

    protected String max;
    protected String min;
    protected String step;
    protected String mouseWheel;
    protected String culture;
    protected String numberFormat;
    protected String incremental;
    protected String page;

    public Spinner(ValueStack stack, HttpServletRequest request,
	    HttpServletResponse response) {
	super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
	return TEMPLATE;
    }

    protected String getDefaultTemplate() {
	return TEMPLATE_CLOSE;
    }

    public void evaluateParams() {
	super.evaluateParams();

	addParameter("jqueryaction", JQUERYACTION);

	if (max != null)
	    addParameter("max", findValue(max, Number.class));
	if (min != null)
	    addParameter("min", findValue(min, Number.class));
	if (step != null)
	    addParameter("step", findValue(step, Number.class));
	if (mouseWheel != null)
	    addParameter("mouseWheel", findValue(mouseWheel, Boolean.class));
	if (culture != null)
	    addParameter("culture", findString(culture));
	if (numberFormat != null)
	    addParameter("numberFormat", findString(numberFormat));
	if (page != null)
	    addParameter("page", findValue(page, Number.class));
	if (incremental != null)
	    addParameter("incremental", findString(incremental));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "spinner_" + String.valueOf(nextInt);
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

    @StrutsTagAttribute(description = "maximum value allowed", type = "Number")
    public void setMax(String max) {
	this.max = max;
    }

    @StrutsTagAttribute(description = "minimum value allowed", type = "Number")
    public void setMin(String min) {
	this.min = min;
    }

    @StrutsTagAttribute(description = "size of step to take when spinning", type = "Number", defaultValue = "1")
    public void setStep(String step) {
	this.step = step;
    }

    @StrutsTagAttribute(description = "If true then mouse wheel events will be attached.", type = "Boolean")
    public void setMouseWheel(String mouseWheel) {
	this.mouseWheel = mouseWheel;
    }

    @StrutsTagAttribute(description = "Sets the culture to use for parsing and formatting the value.", defaultValue = "null")
    public void setCulture(String culture) {
	this.culture = culture;
    }

    @StrutsTagAttribute(description = "Format of numbers passed to Globalize, if available. Most common are 'n' for a decimal number and 'C' for a currency value.", defaultValue = "null")
    public void setNumberFormat(String numberFormat) {
	this.numberFormat = numberFormat;
    }

    @StrutsTagAttribute(description = "Controls the number of steps taken when holding down a spin button.When set to true, the stepping delta will increase when spun incessantly. When set to false, all steps are equal (as defined by the step option).", type = "Boolean", defaultValue = "true")
    public void setIncremental(String incremental) {
	this.incremental = incremental;
    }

    @StrutsTagAttribute(description = "The number of steps to take when paging via the pageUp/pageDown methods.", type = "Number", defaultValue = "10")
    public void setPage(String page) {
	this.page = page;
    }
}
