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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public abstract class AbstractTopicsBean extends ClosingUIBean {

    protected String onBeforeTopics;
    protected String onAfterValidationTopics;
    protected String onCompleteTopics;
    protected String onSuccessTopics;
    protected String onErrorTopics;
    protected String onAlwaysTopics;
    protected String onChangeTopics;
    protected String onEnableTopics;
    protected String onDisableTopics;
    protected String onBlurTopics;
    protected String onFocusTopics;

    public AbstractTopicsBean(ValueStack stack, HttpServletRequest request,
	    HttpServletResponse response) {
	super(stack, request, response);
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addOgnlEvaluatedStringParameterIfExists("onBeforeTopics", onBeforeTopics);
        addOgnlEvaluatedStringParameterIfExists("onAfterValidationTopics", onAfterValidationTopics);
        addOgnlEvaluatedStringParameterIfExists("onCompleteTopics", onCompleteTopics);
        addOgnlEvaluatedStringParameterIfExists("onSuccessTopics", onSuccessTopics);
        addOgnlEvaluatedStringParameterIfExists("onErrorTopics", onErrorTopics);
        addOgnlEvaluatedStringParameterIfExists("onChangeTopics", onChangeTopics);
        addOgnlEvaluatedStringParameterIfExists("onAlwaysTopics", onAlwaysTopics);
        addOgnlEvaluatedStringParameterIfExists("onEnableTopics", onEnableTopics);
        addOgnlEvaluatedStringParameterIfExists("onDisableTopics", onDisableTopics);
        addOgnlEvaluatedStringParameterIfExists("onBlurTopics", onBlurTopics);
        addOgnlEvaluatedStringParameterIfExists("onFocusTopics", onFocusTopics);
    }

    @StrutsTagAttribute(description = "Topics that are published before a load", type = "String", defaultValue = "")
    public void setOnBeforeTopics(String onBeforeTopics) {
	this.onBeforeTopics = onBeforeTopics;
    }

    @StrutsTagAttribute(name = "onAfterValidationTopics", description = "A comma delimited list of topics that published after the Ajax validation. event.originalEvent.formvalidate to see if validation passed/failed.", type = "String", defaultValue = "")
    public void setOnAfterValidationTopics(String onAfterValidationTopics) {
	this.onAfterValidationTopics = onAfterValidationTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element ajax request is completed (will override settings for a target container if provided)", type = "String", defaultValue = "")
    public void setOnCompleteTopics(String onCompleteTopics) {
	this.onCompleteTopics = onCompleteTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element ajax request is completed successfully  (will override settings for a target container if provided)", type = "String", defaultValue = "")
    public void setOnSuccessTopics(String onSuccessTopics) {
	this.onSuccessTopics = onSuccessTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element ajax request returns an error (will override settings for a target container if provided)", type = "String", defaultValue = "")
    public void setOnErrorTopics(String onErrorTopics) {
	this.onErrorTopics = onErrorTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published always", type = "String", defaultValue = "")
    public void setOnAlwaysTopics(String onAlwaysTopics) {
	this.onAlwaysTopics = onAlwaysTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element changed", type = "String", defaultValue = "")
    public void setOnChangeTopics(String onChangeTopics) {
	this.onChangeTopics = onChangeTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element is enabled", type = "String", defaultValue = "")
    public void setOnEnableTopics(String onEnableTopics) {
	this.onEnableTopics = onEnableTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element disabled", type = "String", defaultValue = "")
    public void setOnDisableTopics(String onDisableTopics) {
	this.onDisableTopics = onDisableTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element is blured", type = "String", defaultValue = "")
    public void setOnBlurTopics(String onBlurTopics) {
	this.onBlurTopics = onBlurTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element is focused", type = "String", defaultValue = "")
    public void setOnFocusTopics(String onFocusTopics) {
	this.onFocusTopics = onFocusTopics;
    }

    protected void addOgnlEvaluatedStringParameterIfExists(String parameterName, String parameter) {
        if (parameter != null) {
            addParameter(parameterName, findString(parameter)); 
        }
    }

    protected void addOgnlEvaluatedObjectParameterIfExists(String parameterName, String parameter, Class type) {
        if (parameter != null) {
            addParameter(parameterName, findValue(parameter, type)); 
        }
    }

}
