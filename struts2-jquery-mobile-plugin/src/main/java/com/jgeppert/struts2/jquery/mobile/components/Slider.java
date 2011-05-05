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
 * A tag that creates an Slider.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 *     &lt;sjm:slider
 * id=&quot;slider1&quot;
 * name=&quot;slider1&quot;
 * label=&quot;Slider One&quot;
 * /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 *     &lt;sjm:slider
 * id=&quot;slider2&quot;
 * name=&quot;slider2&quot;
 * label=&quot;Slider Two&quot;
 * min=&quot;100&quot;
 * max=&quot;250&quot;
 * value=&quot;175&quot;
 * /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */

@StrutsTag(name = "slider", tldTagClass = "com.jgeppert.struts2.jquery.mobile.views.jsp.ui.SliderTag", description = "Renders a slider field", allowDynamicAttributes = true)
public class Slider extends org.apache.struts2.components.TextField implements
	ThemeableBean {

    public static final String TEMPLATE = "slider";
    public static final String COMPONENT_NAME = Slider.class.getName();
    final private static transient Random RANDOM = new Random();

    protected String dataTheme;
    protected String max;
    protected String min;

    public Slider(ValueStack stack, HttpServletRequest request,
	    HttpServletResponse response) {
	super(stack, request, response);
    }

    protected String getDefaultTemplate() {
	return TEMPLATE;
    }

    public void evaluateExtraParams() {
	super.evaluateExtraParams();

	if (dataTheme != null)
	    addParameter("dataTheme", findString(dataTheme));
	if (max != null)
	    addParameter("max", findValue(max, Integer.class));
	if (min != null)
	    addParameter("min", findValue(min, Integer.class));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "slider_" + String.valueOf(nextInt);
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

    @StrutsTagAttribute(description = "Initialize a slider with the max option specified. Default: 100", type = "Integer")
    public void setMax(String max) {
	this.max = max;
    }

    @StrutsTagAttribute(description = "The minimum value of the slider. Default: 0", type = "Integer")
    public void setMin(String min) {
	this.min = min;
    }

    @StrutsTagAttribute(description = "Set the Slider theme. e.g. a,b,c,d or e")
    public void setDataTheme(String dataTheme) {
	this.dataTheme = dataTheme;
    }

}
