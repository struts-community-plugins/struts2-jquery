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
 * A tag that creates an Spinner. BETA
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * A simple Spinner.
 * </p>
 * <p>
 * <pre>
 * &lt;sj:spinner name=&quot;spinner1&quot; id=&quot;spinner1&quot;/&gt;
 * </pre>
 * <p>
 * <!-- END SNIPPET: example1 -->
 * <p>
 * <!-- START SNIPPET: example2 -->
 * <p>
 * A Spinner max=50 and step=2.
 * </p>
 * <p>
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
 * <p>
 * <!-- END SNIPPET: example2 -->
 * <p>
 * <!-- START SNIPPET: example3 -->
 * <p>
 * A Spinner with currency format and mouse wheel support.
 * </p>
 * <p>
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
 * <p>
 * <!-- END SNIPPET: example3 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "spinner", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SpinnerTag", description = "Render a Spinner.", allowDynamicAttributes = true)
public class Spinner extends Textfield {

    public static final String JQUERYACTION = "spinner";
    public static final String TEMPLATE = "spinner";
    public static final String TEMPLATE_CLOSE = "spinner-close";

    private static final String PARAM_MAX = "max";
    private static final String PARAM_MIN = "min";
    private static final String PARAM_STEP = "step";
    private static final String PARAM_MOUSE_WHEEL = "mouseWheel";
    private static final String PARAM_CULTURE = "culture";
    private static final String PARAM_NUMBER_FORMAT = "numberFormat";
    private static final String PARAM_PAGE = "page";
    private static final String PARAM_INCREMENTAL = "incremental";

    private static final String ID_PREFIX_SPINNER = "spinner_";

    protected String max;
    protected String min;
    protected String step;
    protected String mouseWheel;
    protected String culture;
    protected String numberFormat;
    protected String incremental;
    protected String page;

    public Spinner(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_MAX, this.max, Number.class);
        addParameterIfPresent(PARAM_MIN, this.min, Number.class);
        addParameterIfPresent(PARAM_STEP, this.step, Number.class);
        addParameterIfPresent(PARAM_MOUSE_WHEEL, this.mouseWheel, Boolean.class);
        addParameterIfPresent(PARAM_CULTURE, this.culture);
        addParameterIfPresent(PARAM_NUMBER_FORMAT, this.numberFormat);
        addParameterIfPresent(PARAM_PAGE, this.page, Number.class);
        addParameterIfPresent(PARAM_INCREMENTAL, this.incremental);

        addGeneratedIdParam(ID_PREFIX_SPINNER);
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
