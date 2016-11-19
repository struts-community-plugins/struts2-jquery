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

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a menu.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * Menu with Items
 * </p>
 * <pre>
 * 	&lt;sj:menu id=&quot;menuWithItems&quot; cssStyle=&quot;width:50%&quot;&gt;
 * &lt;sj:menuItem title=&quot;Struts2&quot; href=&quot;http://struts.apache.org/2.x/index.html&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Struts2 jQuery News&quot; href=&quot;http://www.jgeppert.com/category/java/struts2-jquery/&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Struts2 Plugins&quot;&gt;
 * &lt;sj:menu id=&quot;subMenuPlugins&quot;&gt;
 * &lt;sj:menuItem title=&quot;Struts2 Plugins&quot; href=&quot;https://cwiki.apache.org/S2PLUGINS/home.html&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Struts2 jQuery Plugin&quot; href=&quot;http://code.google.com/p/struts2-jquery/&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Struts2 Bootstrap Plugin&quot; href=&quot;http://code.google.com/p/struts2-jquery/&quot;/&gt;
 * &lt;/sj:menu&gt;
 * &lt;/sj:menuItem&gt;
 *
 * &lt;sj:menuItem title=&quot;Struts2 @ Social Media&quot;&gt;
 * &lt;sj:menu id=&quot;subMenuSocialMedia&quot;&gt;
 * &lt;sj:menuItem title=&quot;Struts2 @ Twitter&quot; href=&quot;https://twitter.com/TheApacheStruts&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Struts2 @ Google+&quot; href=&quot;https://www.google.com/+ApacheStruts&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Struts2 @ Facebook&quot; href=&quot;http://www.facebook.com/struts2&quot;/&gt;
 * &lt;/sj:menu&gt;
 * &lt;/sj:menuItem&gt;
 * &lt;sj:menuItem title=&quot;AJAX&quot;&gt;
 * &lt;sj:menu id=&quot;subMenuAjax&quot;&gt;
 * &lt;s:url var=&quot;ajax1&quot; value=&quot;/ajax1.action&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Ajax 1&quot; href=&quot;%{ajax1}&quot; targets=&quot;result&quot;/&gt;
 * &lt;s:url var=&quot;ajax2&quot; value=&quot;/ajax2.action&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Ajax 2&quot; href=&quot;%{ajax2}&quot; targets=&quot;result&quot; effect=&quot;highlight&quot; effectDuration=&quot;2500&quot;/&gt;
 * &lt;s:url var=&quot;ajax3&quot; value=&quot;/ajax3.action&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Ajax 3&quot; href=&quot;%{ajax3}&quot; targets=&quot;result&quot; onBeforeTopics=&quot;beforeLink&quot; onCompleteTopics=&quot;completeLink&quot;/&gt;
 * &lt;s:url var=&quot;ajax4&quot; value=&quot;/ajax4.action&quot;/&gt;
 * &lt;sj:menuItem title=&quot;Ajax 4&quot; href=&quot;%{ajax4}&quot; targets=&quot;result&quot; effect=&quot;bounce&quot; effectDuration=&quot;1000&quot;/&gt;
 * &lt;/sj:menu&gt;
 * &lt;/sj:menuItem&gt;
 * &lt;/sj:menu&gt;
 *
 * &lt;br/&gt;
 * &lt;strong&gt;Result Div :&lt;/strong&gt;
 * &lt;div id=&quot;result&quot; class=&quot;result ui-widget-content ui-corner-all&quot;&gt;Click on the AJAX Links above.&lt;/div&gt;
 *
 * </pre>
 * <!-- END SNIPPET: example1 -->
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "menu", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.MenuTag", description = "Render an Menu.")
public class Menu extends AbstractTopicsBean {

    public static final String JQUERYACTION = "menu";
    public static final String TEMPLATE = "menu";
    public static final String TEMPLATE_CLOSE = "menu-close";
    public static final String COMPONENT_NAME = Menu.class.getName();

    private static final String PARAM_DISABLED = "disabled";
    private static final String PARAM_TARGETS = "targets";
    private static final String PARAM_HREF = "href";
    private static final String PARAM_PARAM_NAME = "paramName";
    private static final String PARAM_SUB_MENU = "subMenu";
    private static final String PARAM_PARENT_MENU = "parentMenu";

    private static final String ID_PREFIX_MENU = "menu_";

    protected boolean throwExceptionOnNullValueAttribute = false;
    protected String disabled;
    protected String targets;
    protected String href;
    protected String paramName;
    protected Object list;
    protected String listKey;
    protected String listValue;

    public Menu(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameterIfPresent(PARAM_DISABLED, this.disabled, Boolean.class);
        addParameterIfPresent(PARAM_TARGETS, this.targets);
        addParameterIfPresent(PARAM_HREF, this.href);
        addParameterIfPresent(PARAM_PARAM_NAME, this.paramName);

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
                value = findValue((list == null) ? (String) list : list.toString(), "list", "The requested list key '" + list + "' could not be resolved as a collection/array/map/enumeration/iterator type. Example: people or people.{name}");
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
            listKey = stripExpressionIfAltSyntax(listKey);
            addParameter(PARAM_LIST_KEY, listKey);
        } else if (value instanceof Map) {
            addParameter(PARAM_LIST_KEY, "key");
        }

        if (listValue != null) {
            listValue = stripExpressionIfAltSyntax(listValue);
            addParameter(PARAM_LIST_VALUE, listValue);
        } else if (value instanceof Map) {
            addParameter(PARAM_LIST_VALUE, "value");
        }

        addGeneratedIdParam(ID_PREFIX_MENU);

        Menu parentMenu = (Menu) findAncestor(Menu.class);
        if (parentMenu != null) {
            addParameter(PARAM_SUB_MENU, true);
            addParameter(PARAM_PARENT_MENU, findString(parentMenu.getId()));
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

    @StrutsTagAttribute(description = "Disables the menu if set to true.", defaultValue = "false", type = "Boolean")
    public void setDisabled(String disabled) {
        this.disabled = disabled;
    }

    @StrutsTagAttribute(name = "targets", description = "A comma separated list of ids of container elements to load with the contents from the result of this request")
    public void setTargets(String targets) {
        this.targets = targets;
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

    @StrutsTagAttribute(description = "Parameter name for the href url used when rendered from a collection. e.g. id,name", defaultValue = "id")
    public void setParamName(String paramName) {
        this.paramName = paramName;
    }
}
