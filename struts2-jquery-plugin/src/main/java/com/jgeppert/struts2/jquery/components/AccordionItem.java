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
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a accordion item
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <pre>
 *       &lt;sj:accordionItem title=&quot;Sed non urna&quot;&gt;
 *         Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.
 *       &lt;/sj:accordionItem&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "accordionItem", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AccordionItemTag", description = "Render an accordion item.")
public class AccordionItem extends ClosingUIBean {

    private static final Random RANDOM = new Random();

    public static final String TEMPLATE = "accordionItem";
    public static final String JQUERYACTION = "accordionItem";
    public static final String TEMPLATE_CLOSE = "accordionItem-close";
    public static final String COMPONENT_NAME = AccordionItem.class.getName();

    private static final String PARAM_TITLE = "title";
    private static final String PARAM_ON_CLICK_TOPICS = "onClickTopics";

    private static final String ID_PREFIX_ACCORDION_ITEM = "accordionItem_";

    protected String title;
    protected String onClickTopics;

    public AccordionItem(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(AbstractTopicsBean.PARAM_JQUERY_ACTION, JQUERYACTION);

        if (title != null) {
            addParameter(PARAM_TITLE, findString(title));
        }
        if (onClickTopics != null) {
            addParameter(PARAM_ON_CLICK_TOPICS, findString(onClickTopics));
        }

        Accordion accordion = (Accordion) findAncestor(Accordion.class);

        if (accordion != null) {
            addParameter("header", accordion.getHeader());
        }

        if (StringUtils.isBlank(this.id)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
            this.id = ID_PREFIX_ACCORDION_ITEM + String.valueOf(nextInt);
        }
        addParameter(AbstractTopicsBean.PARAM_ID, this.id);
        addParameter(AbstractTopicsBean.PARAM_ESCAPED_ID, escape(this.id));

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

    @StrutsTagAttribute(description = "accordion item title")
    public void setTitle(String title) {
        this.title = title;
    }

    @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked")
    public void setOnClickTopics(String onClickTopics) {
        this.onClickTopics = onClickTopics;
    }
}
