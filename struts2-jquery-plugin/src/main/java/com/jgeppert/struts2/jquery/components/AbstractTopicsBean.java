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
import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
public abstract class AbstractTopicsBean extends ClosingUIBean {

    private static final transient Random RANDOM = new Random();

    public static final String PARAM_JQUERY_ACTION = "jqueryaction";

    static final String PARAM_LIST = "list";
    static final String PARAM_LIST_SIZE = "listSize";
    static final String PARAM_LIST_KEY = "listKey";
    static final String PARAM_LIST_VALUE = "listValue";
    static final String PARAM_ID = "id";

    private static final String PARAM_ON_BEFORE_TOPICS = "onBeforeTopics";
    private static final String PARAM_ON_AFTER_VALIDATION_TOPICS = "onAfterValidationTopics";
    private static final String PARAM_ON_COMPLETE_TOPICS = "onCompleteTopics";
    private static final String PARAM_ON_SUCCESS_TOPICS = "onSuccessTopics";
    private static final String PARAM_ON_ERROR_TOPICS = "onErrorTopics";
    private static final String PARAM_ON_CHANGE_TOPICS = "onChangeTopics";
    private static final String PARAM_ON_ALWAYS_TOPICS = "onAlwaysTopics";
    private static final String PARAM_ON_ENABLE_TOPICS = "onEnableTopics";
    private static final String PARAM_ON_DISABLE_TOPICS = "onDisableTopics";
    private static final String PARAM_ON_BLUR_TOPICS = "onBlurTopics";
    private static final String PARAM_ON_FOCUS_TOPICS = "onFocusTopics";

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

    public AbstractTopicsBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameterIfPresent(PARAM_ON_BEFORE_TOPICS, this.onBeforeTopics);
        addParameterIfPresent(PARAM_ON_AFTER_VALIDATION_TOPICS, this.onAfterValidationTopics);
        addParameterIfPresent(PARAM_ON_COMPLETE_TOPICS, this.onCompleteTopics);
        addParameterIfPresent(PARAM_ON_SUCCESS_TOPICS, this.onSuccessTopics);
        addParameterIfPresent(PARAM_ON_ERROR_TOPICS, this.onErrorTopics);
        addParameterIfPresent(PARAM_ON_CHANGE_TOPICS, this.onChangeTopics);
        addParameterIfPresent(PARAM_ON_ALWAYS_TOPICS, this.onAlwaysTopics);
        addParameterIfPresent(PARAM_ON_ENABLE_TOPICS, this.onEnableTopics);
        addParameterIfPresent(PARAM_ON_DISABLE_TOPICS, this.onDisableTopics);
        addParameterIfPresent(PARAM_ON_BLUR_TOPICS, this.onBlurTopics);
        addParameterIfPresent(PARAM_ON_FOCUS_TOPICS, this.onFocusTopics);
    }

    protected void addParameterIfPresent(String parameterKey, String parameterValue) {
        addParameterIfPresent(parameterKey, parameterValue, null);
    }

    protected void addParameterIfPresent(String parameterKey, String parameterValue, Class<?> clazz) {
        if (parameterValue != null) {
            if (clazz != null) {
                addParameter(parameterKey, findValue(parameterValue, clazz));
            } else {
                addParameter(parameterKey, findString(parameterValue));
            }
        }
    }

    protected void addGeneratedIdParam(String prefix) {
        if (StringUtils.isBlank(this.id)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
            this.id = prefix + String.valueOf(nextInt);
        }
        addParameter(PARAM_ID, this.id);
    }

    @StrutsTagAttribute(description = "Topics that are published before a load")
    public void setOnBeforeTopics(String onBeforeTopics) {
        this.onBeforeTopics = onBeforeTopics;
    }

    @StrutsTagAttribute(name = "onAfterValidationTopics", description = "A comma delimited list of topics that published after the Ajax validation. event.originalEvent.formvalidate to see if validation passed/failed.")
    public void setOnAfterValidationTopics(String onAfterValidationTopics) {
        this.onAfterValidationTopics = onAfterValidationTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element ajax request is completed (will override settings for a target container if provided)")
    public void setOnCompleteTopics(String onCompleteTopics) {
        this.onCompleteTopics = onCompleteTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element ajax request is completed successfully  (will override settings for a target container if provided)")
    public void setOnSuccessTopics(String onSuccessTopics) {
        this.onSuccessTopics = onSuccessTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element ajax request returns an error (will override settings for a target container if provided)")
    public void setOnErrorTopics(String onErrorTopics) {
        this.onErrorTopics = onErrorTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published always")
    public void setOnAlwaysTopics(String onAlwaysTopics) {
        this.onAlwaysTopics = onAlwaysTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element changed")
    public void setOnChangeTopics(String onChangeTopics) {
        this.onChangeTopics = onChangeTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element is enabled")
    public void setOnEnableTopics(String onEnableTopics) {
        this.onEnableTopics = onEnableTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element disabled")
    public void setOnDisableTopics(String onDisableTopics) {
        this.onDisableTopics = onDisableTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element is blured")
    public void setOnBlurTopics(String onBlurTopics) {
        this.onBlurTopics = onBlurTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the element is focused")
    public void setOnFocusTopics(String onFocusTopics) {
        this.onFocusTopics = onFocusTopics;
    }

}
