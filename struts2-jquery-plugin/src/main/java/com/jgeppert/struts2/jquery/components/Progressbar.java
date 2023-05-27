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
 * <p>Renders a progressbar</p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 * &lt;sj:progressbar value=&quot;40&quot; /&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "progressbar", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.ProgressbarTag", description = "Render an progressbar.", allowDynamicAttributes = true)
public class Progressbar extends AbstractTopicsBean {

    public static final String JQUERYACTION = "progressbar";
    public static final String TEMPLATE = "progressbar";
    public static final String TEMPLATE_CLOSE = "progressbar-close";
    public static final String COMPONENT_NAME = Progressbar.class.getName();

    private static final String PARAM_VALUE = "value";

    private static final String ID_PREFIX_PROGRESSBAR = "progressbar_";

    protected String value;

    public Progressbar(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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


        if (value != null) {
            addParameter(PARAM_VALUE, findString(value));
        } else {
            if (name != null) {
                addParameter(PARAM_VALUE, findString(name));
            }
        }

        addGeneratedIdParam(ID_PREFIX_PROGRESSBAR);
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

    @StrutsTagAttribute(description = "The value of the progressbar. Integer value from 0 to 100.  Default: 0")
    public void setValue(String value) {
        this.value = value;
    }
}
