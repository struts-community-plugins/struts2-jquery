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
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "autocompleter", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AutocompleterTag", description = "Render a jQuery UI Autocompleter", allowDynamicAttributes = true)
public class Autocompleter extends AbstractFormListElement {

  public static final String            JQUERYACTION  = "autocompleter";
  public static final String            TEMPLATE      = "autocompleter-close";
  public static final String            OPEN_TEMPLATE = "autocompleter";
  final protected static Logger         LOG           = LoggerFactory.getLogger(Autocompleter.class);
  final private static transient Random RANDOM        = new Random();

  protected String                      delay;
  protected String                      loadMinimumCount;
  protected String                      selectBox;
  protected String                      onSelectTopics;
  protected String                      onFocusTopics;
  protected String                      onSearchTopics;
  protected String                      maxlength;
  protected String                      readonly;
  protected String                      size;
  protected String                      multiple;

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

    if (size != null)
    {
      addParameter("size", findString(size));
    }

    if (maxlength != null)
    {
      addParameter("maxlength", findString(maxlength));
    }

    if (readonly != null)
    {
      addParameter("readonly", findValue(readonly, Boolean.class));
    }

    if (multiple != null)
    {
      addParameter("multiple", findValue(multiple, Boolean.class));
    }

    if (onSelectTopics != null)
    {
      addParameter("onSelectTopics", findString(onSelectTopics));
    }

    if (onFocusTopics != null)
    {
      addParameter("onFocusTopics", findString(onFocusTopics));
    }

    if (onSearchTopics != null)
    {
      addParameter("onSearchTopics", findString(onSearchTopics));
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

  @StrutsTagAttribute(description = "HTML maxlength attribute", type = "Integer")
  public void setMaxlength(String maxlength)
  {
    this.maxlength = maxlength;
  }

  @StrutsTagAttribute(description = "Whether the input is readonly", type = "Boolean", defaultValue = "false")
  public void setReadonly(String readonly)
  {
    this.readonly = readonly;
  }

  @StrutsTagAttribute(description = "HTML size attribute", type = "Integer")
  public void setSize(String size)
  {
    this.size = size;
  }

  @StrutsTagAttribute(description = " Creates a multiple select. The tag will pre-select multiple values" + " if the values are passed as an Array or a Collection(of appropriate types) via the value attribute. If one of the keys equals" + " one of the values in the Collection or Array it wil be selected", type = "Boolean", defaultValue = "false")
  public void setMultiple(String multiple)
  {
    this.multiple = multiple;
  }

}
