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

import java.util.Collection;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.util.MakeIterator;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * A tag that creates an Autocompleter.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * <p>
 * Autocompleter handle a String Array
 * </p>
 * 
 * <pre>
 * &lt;sj:autocompleter id=&quot;languages&quot; list=&quot;%{languages}&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * <p>
 * Autocompleter that handle a JSON Result
 * </p>
 * 
 * <pre>
 *  &lt;s:url id=&quot;remoteurl&quot; action=&quot;jsonlanguages&quot;/&gt; 
 *  &lt;sj:autocompleter 
 *     id=&quot;languages&quot; 
 *     href=&quot;%{remoteurl}&quot; 
 *     delay=&quot;50&quot; 
 *     loadMinimumCount=&quot;2&quot;
 *   /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * <p>
 * Autocompleter as Select Box
 * </p>
 * 
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
 * 
 * <!-- END SNIPPET: example3 -->
 */
@StrutsTag(name = "autocompleter", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AutocompleterTag", description = "Render a jQuery UI Autocompleter", allowDynamicAttributes = true)
public class Autocompleter extends AbstractFormElement {

  public static final String            JQUERYACTION  = "autocompleter";
  public static final String            TEMPLATE      = "autocompleter-close";
  public static final String            OPEN_TEMPLATE = "autocompleter";
  final protected static Logger         LOG           = LoggerFactory.getLogger(Autocompleter.class);
  final private static transient Random RANDOM        = new Random();

  protected String                      delay;
  protected String                      loadMinimumCount;
  protected Object                      list;
  protected String                      listKey;
  protected String                      listValue;
  protected String                      selectBox;
  protected String                      onSelectTopics;
  protected String                      onFocusTopics;
  protected String                      onSearchTopics;

  public Autocompleter(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  @Override
  public String getDefaultOpenTemplate()
  {
    return OPEN_TEMPLATE;
  }

  protected String getDefaultTemplate()
  {
    return TEMPLATE;
  }

  public void evaluateParams()
  {
    super.evaluateParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (delay != null) addParameter("delay", findValue(delay, Integer.class));
    if (loadMinimumCount != null) addParameter("loadMinimumCount", findValue(loadMinimumCount, Integer.class));
    // if (list != null) addParameter("list", findString(list));
    Object value = null;

    if (list == null)
    {
      list = parameters.get("list");
    }
    if (listKey != null)
    {
      addParameter("listKey", findString(listKey));
    }
    if (listValue != null)
    {
      addParameter("listValue", findString(listValue));
    }
    if (selectBox != null)
    {
      addParameter("selectBox", findValue(selectBox, Boolean.class));
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
    if (value == null && list != null)
    {
      value = findValue((list == null) ? (String) list : list.toString(), "list", "The requested list key '" + list + "' could not be resolved as a collection/array/map/enumeration/iterator type. " + "Example: people or people.{name}");
    }
    if (value != null)
    {
      if (value instanceof Collection)
      {
        addParameter("list", value);
      }
      else
      {
        addParameter("list", MakeIterator.convert(value));
      }
    }

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "autocompleter_" + String.valueOf(nextInt);
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

  @StrutsTagAttribute(description = "Delay before making the search", type = "Integer", defaultValue = "300")
  public void setDelay(String delay)
  {
    this.delay = delay;
  }

  @StrutsTagAttribute(description = "Minimum number of characters that will force the content to be loaded", type = "Integer", defaultValue = "1")
  public void setLoadMinimumCount(String loadMinimumCount)
  {
    this.loadMinimumCount = loadMinimumCount;
  }

  @StrutsTagAttribute(description = "List of values for autocomplete", required = false)
  public void setList(String list)
  {
    this.list = list;
  }

  @StrutsTagAttribute(description = "Property of list objects to get field value from", required = false)
  public void setListKey(String listKey)
  {
    this.listKey = listKey;
  }

  @StrutsTagAttribute(description = "Property of list objects to get field content from", required = false)
  public void setListValue(String listValue)
  {
    this.listValue = listValue;
  }

  @StrutsTagAttribute(description = "Use an Select Box as Autocompleter", defaultValue = "false", type = "Boolean", required = false)
  public void setSelectBox(String selectBox)
  {
    this.selectBox = selectBox;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when item is selected")
  public void setOnSelectTopics(String onSelectTopics)
  {
    this.onSelectTopics = onSelectTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published before focus is moved to an item")
  public void setOnFocusTopics(String onFocusTopics)
  {
    this.onFocusTopics = onFocusTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published before a request is started, after loadMinimumCount and delay are met.")
  public void setOnSearchTopics(String onSearchTopics)
  {
    this.onSearchTopics = onSearchTopics;
  }
}
