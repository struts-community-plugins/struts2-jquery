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
import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a accordion from a given list or map
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * Build Accordion manuelly
 * </p>
 * <pre>
 *    &lt;s:url id=&quot;urlajax1&quot; action=&quot;ajax1&quot;/&gt;
 *     &lt;sj:accordion id=&quot;accordion&quot;&gt;
 *       &lt;sj:accordionItem title=&quot;Mauris mauris ante&quot;&gt;
 *         &lt;sj:div id=&quot;divInAccrodionItem&quot; href=&quot;%{urlajax1}&quot; /&gt;
 *       &lt;/sj:accordionItem&gt;
 *       &lt;sj:accordionItem title=&quot;Sed non urna&quot;&gt;
 *         Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.
 *       &lt;/sj:accordionItem&gt;
 *       &lt;sj:accordionItem title=&quot;Nam enim risus&quot;&gt;
 *         Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.
 *       &lt;/sj:accordionItem&gt;
 *       &lt;sj:accordionItem title=&quot;Cras dictum&quot;&gt;
 *         Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.
 *       &lt;/sj:accordionItem&gt;
 *     &lt;/sj:accordion&gt;
 * </pre>
 * <!-- END SNIPPET: example1 -->
 * <!-- START SNIPPET: example2 -->
 * <p>
 * A Accordion build from a Map.
 * </p>
 * <strong>Code in JSP:</strong>
 * <pre>
 * &lt;sj:accordion id=&quot;accordionlist&quot; list=&quot;accordion&quot;/&gt;
 * </pre>
 * <strong>Code in Action:</strong>
 * <pre>
 * private Map&lt;String, String&gt; accordion;
 *
 *                                        public String execute() throws Exception
 *                                        {
 *                                          accordion = new HashMap&lt;String, String&gt;();
 *                                          accordion.put(
 *                                              &quot;Section 1&quot;,
 *                                              &quot;Mauris mauris ante, blandit et, ultrices a, suscipit eget, quam. Integer ut neque. Vivamus nisi metus, molestie vel, gravida in, condimentum sit amet, nunc. Nam a nibh. Donec suscipit eros. Nam mi. Proin viverra leo ut odio. Curabitur malesuada. Vestibulum a velit eu ante scelerisque vulputate.&quot;);
 *                                          accordion.put(
 *                                              &quot;Section 2&quot;,
 *                                              &quot;Sed non urna. Donec et ante. Phasellus eu ligula. Vestibulum sit amet purus. Vivamus hendrerit, dolor at aliquet laoreet, mauris turpis porttitor velit, faucibus interdum tellus libero ac justo. Vivamus non quam. In suscipit faucibus urna.&quot;);
 *                                          accordion.put(
 *                                              &quot;Section 3&quot;,
 *                                              &quot;Nam enim risus, molestie et, porta ac, aliquam ac, risus. Quisque lobortis. Phasellus pellentesque purus in massa. Aenean in pede. Phasellus ac libero ac tellus pellentesque semper. Sed ac felis. Sed commodo, magna quis lacinia ornare, quam ante aliquam nisi, eu iaculis leo purus venenatis dui.&quot;);
 *                                          accordion.put(
 *                                              &quot;Section 4&quot;,
 *                                              &quot;Cras dictum. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia Curae; Aenean lacinia mauris vel est. Suspendisse eu nisl. Nullam ut libero. Integer dignissim consequat lectus. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos.&quot;);
 *
 *                                          return SUCCESS;
 *                                        }
 *
 *                                        public Map&lt;String, String&gt; getAccordion()
 *                                        {
 *                                          return accordion;
 *                                        }
 * </pre>
 * <!-- END SNIPPET: example2 -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "accordion", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AccordionTag", description = "Render an accordion from a List.")
public class Accordion extends AbstractTopicsBean {

    private static final Random RANDOM = new Random();

    public static final String JQUERYACTION = "accordion";
    public static final String TEMPLATE = "accordion";
    public static final String TEMPLATE_CLOSE = "accordion-close";
    public static final String COMPONENT_NAME = Accordion.class.getName();

    private static final String PARAM_ACTIVE = "active";
    private static final String PARAM_ANIMATE = "animate";
    private static final String PARAM_HEIGHT_STYLE = "heightStyle";
    private static final String PARAM_COLLAPSIBLE = "collapsible";
    private static final String PARAM_HEADER = "header";
    private static final String PARAM_OPEN_ON_MOUSEOVER = "openOnMouseover";
    private static final String PARAM_HREF = "href";
    private static final String PARAM_PARAM_KEYS = "paramKeys";
    private static final String PARAM_PARAM_VALUES = "paramValues";
    private static final String PARAM_ON_CREATE_TOPICS = "onCreateTopics";

    private static final String ID_PREFIX_ACCORDION = "accordion_";

    protected boolean throwExceptionOnNullValueAttribute = false;

    protected String active;
    protected String animate;
    protected String heightStyle;
    protected String collapsible;
    protected String header;
    protected String openOnMouseover;
    protected String href;
    protected String paramKeys;
    protected String paramValues;
    protected Object list;
    protected String listKey;
    protected String listValue;
    protected String onCreateTopics;

    public Accordion(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    @SuppressWarnings("rawtypes")
    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        addParameterIfPresent(PARAM_ACTIVE, this.active);
        addParameterIfPresent(PARAM_ANIMATE, this.animate);
        addParameterIfPresent(PARAM_HEIGHT_STYLE, this.heightStyle);
        addParameterIfPresent(PARAM_COLLAPSIBLE, this.collapsible, Boolean.class);
        addParameterIfPresent(PARAM_HEADER, this.header);
        addParameterIfPresent(PARAM_OPEN_ON_MOUSEOVER, this.openOnMouseover, Boolean.class);
        addParameterIfPresent(PARAM_HREF, this.href);
        addParameterIfPresent(PARAM_PARAM_KEYS, this.paramKeys);
        addParameterIfPresent(PARAM_PARAM_VALUES, this.paramValues);
        addParameterIfPresent(PARAM_ON_CREATE_TOPICS, this.onCreateTopics);

        Object value = null;

        if (list == null) {
            list = parameters.get(PARAM_LIST);
        }

        if (list instanceof String) {
            value = findValue((String) list);
        } else if (list instanceof Collection) {
            value = list;
        } else if (MakeIterator.isIterable(list)) {
            value = MakeIterator.convert(list);
        }
        if (value == null) {
            if (throwExceptionOnNullValueAttribute) {
                // will throw an exception if not found
                value = findValue((list == null) ? (String) list : list.toString(), PARAM_LIST, "The requested list key '" + list + "' could not be resolved as a collection/array/map/enumeration/iterator type. Example: people or people.{name}");
            } else {
                // ww-1010, allows value with null value to be compatible with ww
                // 2.1.7 behaviour
                value = findValue((list == null) ? (String) list : list.toString());
            }
        }

        if (value instanceof Collection) {
            addParameter(PARAM_LIST, value);
        } else {
            addParameter(PARAM_LIST, MakeIterator.convert(value));
        }

        if (value instanceof Collection) {
            addParameter(PARAM_LIST_SIZE, ((Collection) value).size());
        } else if (value instanceof Map) {
            addParameter(PARAM_LIST_SIZE, ((Map) value).size());
        } else if (value != null && value.getClass().isArray()) {
            addParameter(PARAM_LIST_SIZE, Array.getLength(value));
        }

        if (listKey != null) {
            listKey = stripExpression(listKey);
            addParameter(PARAM_LIST_KEY, listKey);
        } else if (value instanceof Map) {
            addParameter(PARAM_LIST_KEY, "key");
        }

        if (listValue != null) {
            listValue = stripExpression(listValue);
            addParameter(PARAM_LIST_VALUE, listValue);
        } else if (value instanceof Map) {
            addParameter(PARAM_LIST_VALUE, "value");
        }

        addGeneratedIdParam(ID_PREFIX_ACCORDION);
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

    @StrutsTagAttribute(description = "Selector for the active element. Set to false to display none at start. Needs collapsible: true.  Default: 0")
    public void setActive(String active) {
        this.active = active;
    }

    @StrutsTagAttribute(description = "If and how to animate changing panels. Can be Boolean, Number, String (Escaped with simple ' sign) or JavaScript Object", defaultValue = "false")
    public void setAnimate(String animate) {
        this.animate = animate;
    }

    @StrutsTagAttribute(description = "Controls the height of the accordion and each panel. Possible values 'auto': All panels will be set to the height of the tallest panel, 'content': Each panel will be only as tall as its content, 'fill': Expand to the available height based on the accordion's parent height.", defaultValue = "auto")
    public void setHeightStyle(String heightStyle) {
        this.heightStyle = heightStyle;
    }


    @StrutsTagAttribute(description = "Whether all the sections can be closed at once. Allows collapsing the active section by the triggering event. Default: false", defaultValue = "false", type = "Boolean")
    public void setCollapsible(String collapsible) {
        this.collapsible = collapsible;
    }

    @StrutsTagAttribute(description = "Selector for the header element. Default: h3", defaultValue = "h3")
    public void setHeader(String header) {
        this.header = header;
    }

    public String getHeader() {
        return header;
    }

    @StrutsTagAttribute(description = "open accordion on mouse over event. Default: false", defaultValue = "false", type = "Boolean")
    public void setOpenOnMouseover(String openOnMouseover) {
        this.openOnMouseover = openOnMouseover;
    }

    @StrutsTagAttribute(description = "Iterable source to populate from. If the list is a Map (key, value), the Map key will become the option 'value' parameter and the Map value will become the option body.")
    public void setList(Object list) {
        this.list = list;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field value from")
    public void setListKey(String listKey) {
        this.listKey = listKey;
    }

    @StrutsTagAttribute(description = "Property of list objects to get field content from")
    public void setListValue(String listValue) {
        this.listValue = listValue;
    }

    @StrutsTagAttribute(description = "The URL to call to obtain the content. Note: If used with ajax context, the value must be set as an url tag value.")
    public void setHref(String href) {
        this.href = href;
    }

    @StrutsTagAttribute(description = "Comma delimited List of parameter names for the href url. e.g. queryParam1,queryParam2")
    public void setParamKeys(String paramKeys) {
        this.paramKeys = paramKeys;
    }

    @StrutsTagAttribute(description = "Comma delimited List of List Keys for parameter values. e.g. queryValue1,queryValue2")
    public void setParamValues(String paramValues) {
        this.paramValues = paramValues;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when the accordion is created")
    public void setOnCreateTopics(String onCreateTopics) {
        this.onCreateTopics = onCreateTopics;
    }
}
