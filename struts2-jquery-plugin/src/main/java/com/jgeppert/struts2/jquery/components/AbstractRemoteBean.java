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
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * AbstractRemoteCallUIBean is superclass for all components dealing with remote
 * calls.
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
public abstract class AbstractRemoteBean extends AbstractTopicsBean {

    private static final String PARAM_HREF = "href";
    private static final String PARAM_HREF_URL = "hrefUrl";
    private static final String PARAM_HREF_PARAMETER = "hrefParameter";
    private static final String PARAM_TARGETS = "targets";
    private static final String PARAM_FORM_IDS = "formIds";
    private static final String PARAM_INDICATOR = "indicator";
    private static final String PARAM_LOADING_TEXT = "loadingText";
    private static final String PARAM_ERROR_TEXT = "errorText";
    private static final String PARAM_ERROR_ELEMENT_ID = "errorElementId";
    private static final String PARAM_DATA_TYPE = "dataType";
    private static final String PARAM_REQUEST_TYPE = "requestType";
    private static final String PARAM_EFFECT = "effect";
    private static final String PARAM_EFFECT_DURATION = "effectDuration";
    private static final String PARAM_EFFECT_OPTIONS = "effectOptions";
    private static final String PARAM_EFFECT_MODE = "effectMode";
    private static final String PARAM_TIMEOUT = "timeout";
    private static final String PARAM_LISTEN_TOPICS = "listenTopics";
    private static final String PARAM_ON_EFFECT_COMPLETE_TOPICS = "onEffectCompleteTopics";

    protected String targets;
    protected String href;
    protected String formIds;
    protected String indicator;
    protected String loadingText;
    protected String errorText;
    protected String errorElementId;

    protected String dataType;
    protected String requestType;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String effectMode;
    protected String timeout;
    protected String listenTopics;
    protected String onEffectCompleteTopics;

    public AbstractRemoteBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        if (href != null) {
            String hrefValue = findString(href);
            addParameter(PARAM_HREF, hrefValue);
            if (hrefValue.indexOf("?") > 0) {
                addParameter(PARAM_HREF_URL, hrefValue.substring(0, hrefValue.indexOf("?")));
                addParameter(PARAM_HREF_PARAMETER, hrefValue.substring(hrefValue.indexOf("?") + 1));
            } else {
                addParameter(PARAM_HREF_URL, hrefValue);
            }
        }

        addParameterIfPresent(PARAM_TARGETS, this.targets);
        addParameterIfPresent(PARAM_FORM_IDS, this.formIds);
        addParameterIfPresent(PARAM_INDICATOR, this.indicator);
        addParameterIfPresent(PARAM_LOADING_TEXT, this.loadingText);
        addParameterIfPresent(PARAM_ERROR_TEXT, this.errorText);
        addParameterIfPresent(PARAM_ERROR_ELEMENT_ID, this.errorElementId);
        addParameterIfPresent(PARAM_DATA_TYPE, this.dataType);
        addParameterIfPresent(PARAM_REQUEST_TYPE, this.requestType);
        addParameterIfPresent(PARAM_EFFECT, this.effect);
        addParameterIfPresent(PARAM_EFFECT_DURATION, this.effectDuration);
        addParameterIfPresent(PARAM_EFFECT_OPTIONS, this.effectOptions);
        addParameterIfPresent(PARAM_EFFECT_MODE, this.effectMode);
        addParameterIfPresent(PARAM_TIMEOUT, this.timeout);
        addParameterIfPresent(PARAM_LISTEN_TOPICS, this.listenTopics);
        addParameterIfPresent(PARAM_ON_EFFECT_COMPLETE_TOPICS, this.onEffectCompleteTopics);
    }

    @StrutsTagAttribute(name = "href", description = "The url to be use when this element is clicked")
    public void setHref(String href) {
        this.href = href;
    }

    @StrutsTagAttribute(name = "formIds", description = "Comma delimited list of form ids for which to serialize all fields during submission when this element is clicked (if multiple forms have overlapping element names, it is indeterminate which will be used)")
    public void setFormIds(String formIds) {
        this.formIds = formIds;
    }

    @StrutsTagAttribute(name = "targets", description = "A comma separated list of ids of container elements to load with the contents from the result of this request")
    public void setTargets(String targets) {
        this.targets = targets;
    }

    @StrutsTagAttribute(name = "indicator", description = "If loading content into a target, Id of element that will be displayed during loading and hidden afterwards (will override settings for the target container)")
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    @StrutsTagAttribute(name = "loadingText", description = "If loading content into a target, The text to be displayed during load (will be shown if any provided, will override settings for the target container)")
    public void setLoadingText(String loadingText) {
        this.loadingText = loadingText;
    }

    @StrutsTagAttribute(name = "errorText", description = "The text to be displayed on load error. If 'errorElement' is provided, " + "this will display the error in the elemtn (if existing), if not, it will display the error as the contents of this container")
    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }

    @StrutsTagAttribute(name = "errorElementId", description = "This should provide the id of the element into which the error text will be placed when an error ocurrs loading the container. If 'errorTest' is provided, that  wil be used, otherwise the ajax error message text wil be used.", defaultValue = "false")
    public void setErrorElementId(String errorElementId) {
        this.errorElementId = errorElementId;
    }

    @StrutsTagAttribute(description = "Perform a effect on the elements specified in the 'targets' attribute. e.g. bounce, highlight, pulsate, shake, size or transfer. See more details at http://docs.jquery.com/UI/Effects", defaultValue = "none")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @StrutsTagAttribute(description = "Duration of effect in milliseconds. Only valid if 'effect' attribute is set", defaultValue = "2000")
    public void setEffectDuration(String effectDuration) {
        this.effectDuration = effectDuration;
    }

    @StrutsTagAttribute(description = "jQuery options for effect, eg 'color : #aaaaaa' for the highlight effect or 'times : 3' for the bounce effect. Only valid if 'effect' attribute is set. See more details at http://docs.jquery.com/UI/Effects")
    public void setEffectOptions(String effectOptions) {
        this.effectOptions = effectOptions;
    }

    @StrutsTagAttribute(description = "The Effect Mode. show, hide, toggle, none", defaultValue = "none")
    public void setEffectMode(String effectMode) {
        this.effectMode = effectMode;
    }

    @StrutsTagAttribute(description = "jQuery options for timeout. Default is 3000", defaultValue = "3000", type = "Integer")
    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    @StrutsTagAttribute(description = "Type of the result. e.g. html, xml, text, json, ...")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @StrutsTagAttribute(description = "Type of the AJAX Request. POST, GET, PUT", defaultValue = "POST")
    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    @StrutsTagAttribute(description = "The comma separated list 'listenTopics' is the list of topic names that is used to trigger a request.")
    public void setListenTopics(String listenTopics) {
        this.listenTopics = listenTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when an effect is completed ")
    public void setOnEffectCompleteTopics(String onEffectCompleteTopics) {
        this.onEffectCompleteTopics = onEffectCompleteTopics;
    }

}
