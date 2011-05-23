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
 * Render HTML select box providing content from remote call via AJAX
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "select", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SelectTag", description = "Render HTML select box providing content from remote call via AJAX", allowDynamicAttributes = true)
public class Select extends AbstractFormListElement {

    public static final String TEMPLATE = "select";
    public static final String TEMPLATE_CLOSE = "select-close";
    public static final String COMPONENT_NAME = Select.class.getName();
    final private static transient Random RANDOM = new Random();
    public static final String JQUERYACTION = "select";

    protected String emptyOption;
    protected String headerKey;
    protected String headerValue;
    protected String list;
    protected String listKey;
    protected String listValue;
    protected String size;
    protected String multiple;
    protected String autocomplete;
    protected String loadMinimumCount;
    protected String selectBoxIcon;
    protected String onSelectTopics;

    public Select(ValueStack stack, HttpServletRequest request,
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

	if (emptyOption != null) {
	    addParameter("emptyOption", findValue(emptyOption, Boolean.class));
	}

	if ((headerKey != null) && (headerValue != null)) {
	    addParameter("headerKey", findString(headerKey));
	    addParameter("headerValue", findString(headerValue));
	}

	if (list != null) {
	    addParameter("list", findString(list));
	}
	if (listKey != null) {
	    addParameter("listKey", findString(listKey));
	}
	if (listValue != null) {
	    addParameter("listValue", findString(listValue));
	}
	if (size != null) {
	    addParameter("size", findString(size));
	}
	if (multiple != null) {
	    addParameter("multiple", findValue(multiple, Boolean.class));
	}
	if (autocomplete != null) {
	    addParameter("autocomplete", findValue(autocomplete, Boolean.class));
	}
	if (selectBoxIcon != null) {
	    addParameter("selectBoxIcon", findValue(selectBoxIcon,
		    Boolean.class));
	}
	if (loadMinimumCount != null) {
	    addParameter("loadMinimumCount", findValue(loadMinimumCount,
		    Integer.class));
	}
	if (onSelectTopics != null)
	    addParameter("onSelectTopics", findString(onSelectTopics));

	if ((this.id == null || this.id.length() == 0)) {
	    // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
	    // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
	    int nextInt = RANDOM.nextInt();
	    nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math
		    .abs(nextInt);
	    this.id = "select_" + String.valueOf(nextInt);
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

    @StrutsTagAttribute(description = "Add an empty option after the header option", defaultValue = "false", type = "Boolean")
    public void setEmptyOption(String emptyOption) {
	this.emptyOption = emptyOption;
    }

    @StrutsTagAttribute(description = "Key for list header option. Must not be empty", type = "String", defaultValue = "")
    public void setHeaderKey(String headerKey) {
	this.headerKey = headerKey;
    }

    @StrutsTagAttribute(description = "Value for list header option. Must not be empty", type = "String", defaultValue = "")
    public void setHeaderValue(String headerValue) {
	this.headerValue = headerValue;
    }

    @StrutsTagAttribute(description = "Name of the JSON list", required = false)
    public void setList(String list) {
	this.list = list;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field value from", required = false)
    public void setListKey(String listKey) {
	this.listKey = listKey;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field content from", required = false)
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

    @StrutsTagAttribute(description = "Minimum number of characters that will force the content to be loaded, only valid when autocomplet is true", type = "Integer", defaultValue = "1")
    public void setLoadMinimumCount(String loadMinimumCount) {
	this.loadMinimumCount = loadMinimumCount;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when element is selected", type = "String", defaultValue = "")
    public void setOnSelectTopics(String onSelectTopics) {
	this.onSelectTopics = onSelectTopics;
    }

}
