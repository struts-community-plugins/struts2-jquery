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
 * This tag generates an HTML div that loads its content using an XMLHttpRequest
 * call, via the jQuery framework.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sj:div href=&quot;%{#url}&quot;&gt;Initial Content&lt;/sj:div&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 * &lt;img id=&quot;indicator&quot; src=&quot;${pageContext.request.contextPath}/images/indicator.gif&quot; style=&quot;display:none&quot;/&gt; 
 * &lt;sj:div href=&quot;%{#url}&quot; indicator=&quot;indicator&quot;&gt; Initial Content &lt;/sj:div&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * 
 * <pre>
 * &lt;sj:div href=&quot;%{#url}&quot; effect=&quot;highlight&quot; effectOptions=&quot;color : '#222222'&quot; effectDuration=&quot;3600&quot;&gt;
 *  Initial Content
 * &lt;/sj:div&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example3 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "div", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.DivTag", description = "Render HTML div providing content from remote call via AJAX", allowDynamicAttributes = true)
public class Div extends AbstractContainer implements ResizableBean,
	DroppableBean, DraggableBean, SelectableBean {

    public static final String TEMPLATE = "div";
    public static final String TEMPLATE_CLOSE = "div-close";
    public static final String COMPONENT_NAME = Div.class.getName();
    final private static transient Random RANDOM = new Random();
    public static final String JQUERYACTION = "container";

    protected String updateFreq;
    protected String delay;

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
	addParameter("jqueryaction", JQUERYACTION);

	if (updateFreq != null)
	    addParameter("updateFreq", findValue(updateFreq, Number.class));
	if (delay != null)
	    addParameter("delay", findValue(delay, Number.class));

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
	return "jquery";
    }

    @StrutsTagAttribute(description = "How often to reload the content (in milliseconds). e.g. 5000", type = "Number")
    public void setUpdateFreq(String updateFreq) {
	this.updateFreq = updateFreq;
    }

    @StrutsTagAttribute(description = "How long to wait before fetching the content (in milliseconds). e.g. 2000", type = "Number")
    public void setDelay(String delay) {
        this.delay = delay;
    }
}
