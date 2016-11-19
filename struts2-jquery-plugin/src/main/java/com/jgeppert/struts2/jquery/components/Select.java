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
 * Render HTML select box providing content from remote call via AJAX
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "select", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SelectTag", description = "Render HTML select box providing content from remote call via AJAX", allowDynamicAttributes = true)
public class Select extends AbstractFormListElement {

    public static final String TEMPLATE = "select";
    public static final String TEMPLATE_CLOSE = "select-close";
    public static final String COMPONENT_NAME = Select.class.getName();
    public static final String JQUERYACTION = "select";

    private static final String PARAM_EMPTY_OPTION = "emptyOption";
    private static final String PARAM_HEADER_KEY = "headerKey";
    private static final String PARAM_HEADER_VALUE = "headerValue";
    private static final String PARAM_LIST_TITLE = "listTitle";
    private static final String PARAM_SIZE = "size";
    private static final String PARAM_MULTIPLE = "multiple";
    private static final String PARAM_AUTOCOMPLETE = "autocomplete";
    private static final String PARAM_SELECT_BOX_ICON = "selectBoxIcon";
    private static final String PARAM_LOAD_MINIMUM_COUNT = "loadMinimumCount";
    private static final String PARAM_ON_SELECT_TOPICS = "onSelectTopics";

    private static final String ID_PREFIX_SELECT = "select_";

    protected String emptyOption;
    protected String headerKey;
    protected String headerValue;
    protected String list;
    protected String listKey;
    protected String listTitle;
    protected String listValue;
    protected String size;
    protected String multiple;
    protected String autocomplete;
    protected String loadMinimumCount;
    protected String selectBoxIcon;
    protected String onSelectTopics;

    public Select(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_EMPTY_OPTION, this.emptyOption, Boolean.class);
        addParameterIfPresent(PARAM_LIST, this.list);
        addParameterIfPresent(PARAM_LIST_KEY, this.listKey);
        addParameterIfPresent(PARAM_LIST_TITLE, this.listTitle);
        addParameterIfPresent(PARAM_LIST_VALUE, this.listValue);
        addParameterIfPresent(PARAM_SIZE, this.size);
        addParameterIfPresent(PARAM_MULTIPLE, this.multiple, Boolean.class);
        addParameterIfPresent(PARAM_AUTOCOMPLETE, this.autocomplete, Boolean.class);
        addParameterIfPresent(PARAM_SELECT_BOX_ICON, this.selectBoxIcon, Boolean.class);
        addParameterIfPresent(PARAM_LOAD_MINIMUM_COUNT, this.loadMinimumCount, Integer.class);
        addParameterIfPresent(PARAM_ON_SELECT_TOPICS, this.onSelectTopics);

        if ((headerKey != null) && (headerValue != null)) {
            addParameter(PARAM_HEADER_KEY, findString(headerKey));
            addParameter(PARAM_HEADER_VALUE, findString(headerValue));
        }

        addGeneratedIdParam(ID_PREFIX_SELECT);
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

    @StrutsTagAttribute(description = "Add an empty option after the header option", defaultValue = "false", type = "Boolean")
    public void setEmptyOption(String emptyOption) {
        this.emptyOption = emptyOption;
    }

    @StrutsTagAttribute(description = "Key for list header option. Must not be empty")
    public void setHeaderKey(String headerKey) {
        this.headerKey = headerKey;
    }

    @StrutsTagAttribute(description = "Value for list header option. Must not be empty")
    public void setHeaderValue(String headerValue) {
        this.headerValue = headerValue;
    }

    @StrutsTagAttribute(description = "Name of the JSON list")
    public void setList(String list) {
        this.list = list;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field value from")
    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field title from")
    public void setListTitle(String listTitle) {
        this.listTitle = listTitle;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field content from")
    public void setListValue(String listValue) {
        this.listValue = listValue;
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

    @StrutsTagAttribute(description = "use autocomplete for this select box", defaultValue = "false", type = "Boolean")
    public void setAutocomplete(String autocomplete) {
        this.autocomplete = autocomplete;
    }

    @StrutsTagAttribute(description = "display the select box icon, only valid when autocomplete is true", type = "Boolean", defaultValue = "false")
    public void setSelectBoxIcon(String selectBoxIcon) {
        this.selectBoxIcon = selectBoxIcon;
    }

    @StrutsTagAttribute(description = "Minimum number of characters that will force the content to be loaded, only valid when autocomplete is true", type = "Integer", defaultValue = "1")
    public void setLoadMinimumCount(String loadMinimumCount) {
        this.loadMinimumCount = loadMinimumCount;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when element is selected")
    public void setOnSelectTopics(String onSelectTopics) {
        this.onSelectTopics = onSelectTopics;
    }

}
