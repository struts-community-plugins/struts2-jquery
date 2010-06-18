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

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc --> Renders a accordion from a given list or map
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * <p>
 * Build Accordion manuelly
 * </p>
 * 
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
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * <p>
 * A Accordion build from a Map.
 * </p>
 * <strong>Code in JSP:</strong>
 * 
 * <pre>
 * &lt;sj:accordion id=&quot;accordionlist&quot; list=&quot;accordion&quot;/&gt;
 * </pre>
 * 
 * <strong>Code in Action:</strong>
 * 
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
 * 
 * <!-- END SNIPPET: example2 -->
 */
@StrutsTag(name = "accordion", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AccordionTag", description = "Render an accordion from a List.")
public class Accordion extends AbstractTopicsBean {

  final private static transient Random RANDOM                             = new Random();
  public static final String            JQUERYACTION                       = "accordion";
  public static final String            TEMPLATE                           = "accordion";
  public static final String            TEMPLATE_CLOSE                     = "accordion-close";
  public static final String            COMPONENT_NAME                     = Accordion.class.getName();

  protected boolean                     throwExceptionOnNullValueAttribute = false;

  protected String                      active;
  protected String                      animated;
  protected String                      autoHeight;
  protected String                      clearStyle;
  protected String                      collapsible;
  protected String                      fillSpace;
  protected String                      header;
  protected String                      openOnMouseover;
  protected String                      href;
  protected String                      paramKeys;
  protected String                      paramValues;
  protected Object                      list;
  protected String                      listKey;
  protected String                      listValue;

  public Accordion(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  public String getDefaultOpenTemplate()
  {
    return TEMPLATE;
  }

  protected String getDefaultTemplate()
  {
    return TEMPLATE_CLOSE;
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (active != null) addParameter("active", findString(active));
    if (animated != null) addParameter("animated", findString(animated));
    if (autoHeight != null) addParameter("autoHeight", findValue(this.autoHeight, Boolean.class));
    if (clearStyle != null) addParameter("clearStyle", findValue(this.clearStyle, Boolean.class));
    if (collapsible != null) addParameter("collapsible", findValue(this.collapsible, Boolean.class));
    if (fillSpace != null) addParameter("fillSpace", findValue(this.fillSpace, Boolean.class));
    if (header != null) addParameter("header", findString(header));
    if (openOnMouseover != null) addParameter("openOnMouseover", findValue(this.openOnMouseover, Boolean.class));
    if (href != null) addParameter("href", findString(href));
    if (paramKeys != null) addParameter("paramKeys", findString(paramKeys));
    if (paramValues != null) addParameter("paramValues", findString(paramValues));

    Object value = null;

    if (list == null)
    {
      list = parameters.get("list");
    }

    if (list instanceof String)
    {
      value = findValue((String) list);
    }
    else if (list instanceof Collection)
    {
      value = list;
    }
    else if (MakeIterator.isIterable(list))
    {
      value = MakeIterator.convert(list);
    }
    if (value == null)
    {
      if (throwExceptionOnNullValueAttribute)
      {
        // will throw an exception if not found
        value = findValue((list == null) ? (String) list : list.toString(), "list", "The requested list key '" + list + "' could not be resolved as a collection/array/map/enumeration/iterator type. " + "Example: people or people.{name}");
      }
      else
      {
        // ww-1010, allows value with null value to be compatible with
        // ww
        // 2.1.7 behaviour
        value = findValue((list == null) ? (String) list : list.toString());
      }
    }

    if (value instanceof Collection)
    {
      addParameter("list", value);
    }
    else
    {
      addParameter("list", MakeIterator.convert(value));
    }

    if (value instanceof Collection)
    {
      addParameter("listSize", Integer.valueOf(((Collection) value).size()));
    }
    else if (value instanceof Map)
    {
      addParameter("listSize", Integer.valueOf(((Map) value).size()));
    }
    else if (value != null && value.getClass().isArray())
    {
      addParameter("listSize", Integer.valueOf(Array.getLength(value)));
    }

    if (listKey != null)
    {
      listKey = stripExpressionIfAltSyntax(listKey);
      addParameter("listKey", listKey);
    }
    else if (value instanceof Map)
    {
      addParameter("listKey", "key");
    }

    if (listValue != null)
    {
      listValue = stripExpressionIfAltSyntax(listValue);
      addParameter("listValue", listValue);
    }
    else if (value instanceof Map)
    {
      addParameter("listValue", "value");
    }

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "accordion_" + String.valueOf(nextInt);
      addParameter("id", this.id);
    }
  }

  @Override
  @StrutsTagSkipInheritance
  public void setTheme(String theme)
  {
    super.setTheme(theme);
  }

  @Override
  public String getTheme()
  {
    return "jquery";
  }

  @StrutsTagAttribute(description = "Selector for the active element. Set to false to display none at start. Needs collapsible: true.  Default: 0")
  public void setActive(String active)
  {
    this.active = active;
  }

  @StrutsTagAttribute(description = "Choose your favorite animation, or disable them (set to false). Values are slide, bounceslide. Default: slide")
  public void setAnimated(String animated)
  {
    this.animated = animated;
  }

  @StrutsTagAttribute(description = "If set, the highest content part is used as height reference for all other parts. Provides more consistent animations. Default: true", defaultValue = "true", type = "Boolean")
  public void setAutoHeight(String autoHeight)
  {
    this.autoHeight = autoHeight;
  }

  @StrutsTagAttribute(description = "If set, clears height and overflow styles after finishing animations. This enables accordions to work with dynamic content. Won't work together with autoHeight. Default: false", defaultValue = "false", type = "Boolean")
  public void setClearStyle(String clearStyle)
  {
    this.clearStyle = clearStyle;
  }

  @StrutsTagAttribute(description = "Whether all the sections can be closed at once. Allows collapsing the active section by the triggering event. Default: false", defaultValue = "false", type = "Boolean")
  public void setCollapsible(String collapsible)
  {
    this.collapsible = collapsible;
  }

  @StrutsTagAttribute(description = "If set, the accordion completely fills the height of the parent element. Overrides autoheight.. Default: false", defaultValue = "false", type = "Boolean")
  public void setFillSpace(String fillSpace)
  {
    this.fillSpace = fillSpace;
  }

  @StrutsTagAttribute(description = "Selector for the header element. Default: h3", defaultValue = "h3")
  public void setHeader(String header)
  {
    this.header = header;
  }

  public String getHeader()
  {
    return header;
  }

  @StrutsTagAttribute(description = "open accordion on mouse over event. Default: false", defaultValue = "false", type = "Boolean")
  public void setOpenOnMouseover(String openOnMouseover)
  {
    this.openOnMouseover = openOnMouseover;
  }

  @StrutsTagAttribute(description = "Iterable source to populate from. If the list is a Map (key, value), the Map key will become the option 'value' parameter and the Map value will become the option body.")
  public void setList(Object list)
  {
    this.list = list;
  }

  @StrutsTagAttribute(description = "Property of list objects to get field value from")
  public void setListKey(String listKey)
  {
    this.listKey = listKey;
  }

  @StrutsTagAttribute(description = "Property of list objects to get field content from")
  public void setListValue(String listValue)
  {
    this.listValue = listValue;
  }

  @StrutsTagAttribute(description = "The URL to call to obtain the content. Note: If used with ajax context, the value must be set as an url tag value.")
  public void setHref(String href)
  {
    this.href = href;
  }

  @StrutsTagAttribute(description = "Comma seperated List of parameter names for the href url. e.g. queryParam1,queryParam2")
  public void setParamKeys(String paramKeys)
  {
    this.paramKeys = paramKeys;
  }

  @StrutsTagAttribute(description = "Comma seperated List of List Keys for parameter values. e.g. queryValue1,queryValue2")
  public void setParamValues(String paramValues)
  {
    this.paramValues = paramValues;
  }
}
