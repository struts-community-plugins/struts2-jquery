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
 * A tag that creates an Autocompleter.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * Autocompleter handle a String Array
 * </p>
 * <pre>
 * &lt;sj:autocompleter id=&quot;languages&quot; list=&quot;%{languages}&quot;/&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 * <!-- START SNIPPET: example2 -->
 * <p>
 * Autocompleter that handle a JSON Result
 * </p>
 * <pre>
 *  &lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonlanguages&quot;/&gt;
 *  &lt;sj:autocompleter
 *     id=&quot;languages&quot;
 *     href=&quot;%{remoteurl}&quot;
 *     delay=&quot;50&quot;
 *     loadMinimumCount=&quot;2&quot;
 *   /&gt;
 * </pre>
 * <!-- END SNIPPET: example2 -->
 * <!-- START SNIPPET: example3 -->
 * <p>
 * Autocompleter as Select Box
 * </p>
 * <pre>
 *          &lt;sj:autocompleter
 *           id=&quot;customers&quot;
 *           name=&quot;echo&quot;
 *           list=&quot;%{customers}&quot;
 *           listValue=&quot;name&quot;
 *           listKey=&quot;id&quot;
 *           selectBox=&quot;true&quot;
 *         /&gt;
 * </pre>
 * <!-- END SNIPPET: example3 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "autocompleter", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AutocompleterTag", description = "Render a jQuery UI Autocompleter", allowDynamicAttributes = true)
public class Autocompleter extends AbstractFormListElement {

    public static final String JQUERYACTION = "autocompleter";
    public static final String TEMPLATE = "autocompleter-close";
    public static final String OPEN_TEMPLATE = "autocompleter";

    private static final String PARAM_DELAY = "delay";
    private static final String PARAM_LOAD_MINIMUM_COUNT = "loadMinimumCount";
    private static final String PARAM_SIZE = "size";
    private static final String PARAM_MAXLENGTH = "maxlength";
    private static final String PARAM_SELECT_BOX = "selectBox";
    private static final String PARAM_SELECT_BOX_ICON = "selectBoxIcon";
    private static final String PARAM_READONLY = "readonly";
    private static final String PARAM_MULTIPLE = "multiple";
    private static final String PARAM_ON_SELECT_TOPICS = "onSelectTopics";
    private static final String PARAM_ON_FOCUS_TOPICS = "onFocusTopics";
    private static final String PARAM_ON_SEARCH_TOPICS = "onSearchTopics";
    private static final String PARAM_LIST_LABEL = "listLabel";
    private static final String PARAM_FORCE_VALID_OPTION = "forceValidOption";
    private static final String PARAM_AUTO_FOCUS = "autoFocus";
    private static final String PARAM_WIDGET_ID = "widgetid";
    private static final String PARAM_NAME = "name";
    private static final String PARAM_WIDGET_NAME = "widgetname";
    private static final String PARAM_VALUE_WIDGET = "valueWidget";

    private static final String SUFFIX_WIDGET = "_widget";
    private static final String ID_PREFIX_AUTOCOMPLETER = "autocompleter_";

    protected String delay;
    protected String loadMinimumCount;
    protected String selectBox;
    protected String selectBoxIcon;
    protected String onSelectTopics;
    protected String onFocusTopics;
    protected String onSearchTopics;
    protected String maxlength;
    protected String readonly;
    protected String size;
    protected String multiple;
    protected String listLabel;
    protected String forceValidOption;
    protected String autoFocus;
    protected String valueWidget;

    public Autocompleter(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
        return OPEN_TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE;
    }

    public void evaluateParams() {
        super.evaluateParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        if (getParameters().get(PARAM_LIST) != null) {
            addParameter("emptyOption", true);
        }

        addParameterIfPresent(PARAM_DELAY, this.delay, Integer.class);
        addParameterIfPresent(PARAM_LOAD_MINIMUM_COUNT, this.loadMinimumCount, Integer.class);
        addParameterIfPresent(PARAM_SIZE, this.size);
        addParameterIfPresent(PARAM_MAXLENGTH, this.maxlength);
        addParameterIfPresent(PARAM_SELECT_BOX, this.selectBox, Boolean.class);
        addParameterIfPresent(PARAM_SELECT_BOX_ICON, this.selectBoxIcon, Boolean.class);
        addParameterIfPresent(PARAM_READONLY, this.readonly, Boolean.class);
        addParameterIfPresent(PARAM_MULTIPLE, this.multiple, Boolean.class);
        addParameterIfPresent(PARAM_ON_SELECT_TOPICS, this.onSelectTopics);
        addParameterIfPresent(PARAM_ON_FOCUS_TOPICS, this.onFocusTopics);
        addParameterIfPresent(PARAM_ON_SEARCH_TOPICS, this.onSearchTopics);
        addParameterIfPresent(PARAM_SIZE, this.size);
        addParameterIfPresent(PARAM_FORCE_VALID_OPTION, this.forceValidOption, Boolean.class);
        addParameterIfPresent(PARAM_AUTO_FOCUS, this.autoFocus, Boolean.class);

        if (listLabel != null) {
            addParameter(PARAM_LIST_LABEL, stripExpressionIfAltSyntax(listLabel));
        }

        addGeneratedIdParam(ID_PREFIX_AUTOCOMPLETER);

        addParameter(PARAM_ID, this.id + SUFFIX_WIDGET);
        addParameter(PARAM_WIDGET_ID, this.id);

        String nameValue = (String) getParameters().get(PARAM_NAME);
        addParameter(PARAM_NAME, nameValue + SUFFIX_WIDGET);
        addParameter(PARAM_WIDGET_NAME, nameValue);

        if (valueWidget != null) {
            addParameter(PARAM_VALUE_WIDGET, findString(valueWidget));
        } else if (value != null) {
            addParameter(PARAM_VALUE_WIDGET, findString(value));
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

    @StrutsTagAttribute(description = "Delay before making the search", type = "Integer", defaultValue = "300")
    public void setDelay(String delay) {
        this.delay = delay;
    }

    @StrutsTagAttribute(description = "Minimum number of characters that will force the content to be loaded", type = "Integer", defaultValue = "1")
    public void setLoadMinimumCount(String loadMinimumCount) {
        this.loadMinimumCount = loadMinimumCount;
    }

    @StrutsTagAttribute(description = "Use an Select Box as Autocompleter", defaultValue = "false", type = "Boolean")
    public void setSelectBox(String selectBox) {
        this.selectBox = selectBox;
    }

    @StrutsTagAttribute(description = "display the select box icon", type = "Boolean", defaultValue = "false")
    public void setSelectBoxIcon(String selectBoxIcon) {
        this.selectBoxIcon = selectBoxIcon;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when item is selected")
    public void setOnSelectTopics(String onSelectTopics) {
        this.onSelectTopics = onSelectTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published before focus is moved to an item")
    public void setOnFocusTopics(String onFocusTopics) {
        this.onFocusTopics = onFocusTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published before a request is started, after loadMinimumCount and delay are met.")
    public void setOnSearchTopics(String onSearchTopics) {
        this.onSearchTopics = onSearchTopics;
    }

    @StrutsTagAttribute(description = "HTML maxlength attribute", type = "Integer")
    public void setMaxlength(String maxlength) {
        this.maxlength = maxlength;
    }

    @StrutsTagAttribute(description = "Whether the input is readonly", type = "Boolean", defaultValue = "false")
    public void setReadonly(String readonly) {
        this.readonly = readonly;
    }

    @StrutsTagAttribute(description = "HTML size attribute", type = "Integer")
    public void setSize(String size) {
        this.size = size;
    }

    @StrutsTagAttribute(description = " Creates a multiple select. The tag will pre-select multiple values"
            + " if the values are passed as an Array or a Collection(of appropriate types) via the value attribute. If one of the keys equals"
            + " one of the values in the Collection or Array it wil be selected", type = "Boolean", defaultValue = "false")
    public void setMultiple(String multiple) {
        this.multiple = multiple;
    }

    @StrutsTagAttribute(description = "a seperate label element.")
    public void setListLabel(String listLabel) {
        this.listLabel = listLabel;
    }

    @StrutsTagAttribute(description = "Force selection to be one of the options.", defaultValue = "true", type = "Boolean")
    public void setForceValidOption(String forceValidOption) {
        this.forceValidOption = forceValidOption;
    }

    @StrutsTagAttribute(description = "If set to true the first item will be automatically focused.", defaultValue = "false", type = "Boolean")
    public void setAutoFocus(String autoFocus) {
        this.autoFocus = autoFocus;
    }

    @StrutsTagAttribute(description = "The value of the Widget Input Field.")
    public void setValueWidget(String valueWidget) {
        this.valueWidget = valueWidget;
    }

}
