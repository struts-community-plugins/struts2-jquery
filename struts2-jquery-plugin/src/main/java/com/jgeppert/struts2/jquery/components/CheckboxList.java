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
 * A tag that creates an Button Set from a Checkbox List.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * Create a Buttonset from Checkbox List.
 * </p>
 * <pre>
 * &lt;div id=&quot;formResult&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Submit form bellow.&lt;/div&gt;
 *
 *   &lt;s:form id=&quot;form&quot; action=&quot;echo&quot; theme=&quot;xhtml&quot;&gt;
 *         &lt;sj:checkboxlist
 *             id=&quot;checkboxbuttonset&quot;
 *                 tooltip=&quot;Choose your Friends&quot;
 *                 label=&quot;Friends&quot;
 *                 list=&quot;{'Patrick', 'Jason', 'Jay', 'Toby', 'Rene'}&quot;
 *                 name=&quot;echo&quot;/&gt;
 *             &lt;sj:submit
 *               targets=&quot;formResult&quot;
 *               value=&quot;AJAX Submit&quot;
 *               indicator=&quot;indicator&quot;
 *               button=&quot;true&quot;
 *               /&gt;
 *   &lt;/s:form&gt;
 *   &lt;img id=&quot;indicator&quot; src=&quot;images/indicator.gif&quot; alt=&quot;Loading...&quot; style=&quot;display:none&quot;/&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */

@StrutsTag(name = "checkboxlist", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.CheckboxListTag", description = "Render a Button Set from a given checkbox list", allowDynamicAttributes = true)
public class CheckboxList extends AbstractFormListElement {

    public static final String TEMPLATE = "checkboxlist";
    public static final String TEMPLATE_CLOSE = "checkboxlist-close";
    public static final String COMPONENT_NAME = CheckboxList.class.getName();

    public static final String JQUERYACTION = "buttonset";

    private static final String PARAM_BUTTONSET = "buttonset";
    private static final String PARAM_ICON = "icon";
    private static final String PARAM_DIRECTION = "direction";

    private static final String ID_PREFIX_CHECKBOX = "checkbox_";

    protected String buttonset;
    protected String icon;
    protected String direction;

    public CheckboxList(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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
        addParameterIfPresent(PARAM_BUTTONSET, this.buttonset, Boolean.class);
        addParameterIfPresent(PARAM_ICON, this.icon, Boolean.class);
        addParameterIfPresent(PARAM_DIRECTION, this.direction);

        addGeneratedIdParam(ID_PREFIX_CHECKBOX);
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

    @StrutsTagAttribute(description = "Disable or enable the jQuery UI buttonset feature.", defaultValue = "true", type = "Boolean")
    public void setButtonset(String buttonset) {
        this.buttonset = buttonset;
    }

    @StrutsTagAttribute(description = "Whether to show the checkbox icon, depending on the input's type.", defaultValue = "true", type = "Boolean")
    public void setIcon(String icon) {
        this.icon = icon;
    }

    @StrutsTagAttribute(description = "By default, controlgroup displays its controls in a horizontal layout. Use this option to use a vertical layout instead.", defaultValue = "horizontal")
    public void setDirection(String direction) {
        this.direction = direction;
    }
}
