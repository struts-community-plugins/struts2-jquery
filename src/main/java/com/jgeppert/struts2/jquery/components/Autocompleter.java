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
 * <!-- START SNIPPET: example1 --><!-- END SNIPPET: example1 -->
 */
@StrutsTag(name = "autocompleter", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AutocompleterTag", description = "Render a jQuery UI Autocompleter")
public class Autocompleter extends AbstractFormElement {

  public static final String            JQUERYACTION  = "autocompleter";
  public static final String            TEMPLATE      = "autocompleter-close";
  public static final String            OPEN_TEMPLATE = "autocompleter";
  final protected static Logger         LOG           = LoggerFactory.getLogger(Autocompleter.class);
  final private static transient Random RANDOM        = new Random();

  protected String                      delay;
  protected String                      loadMinimumCount;
  protected String                      list;

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
    if (list != null) addParameter("list", findString(list));

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
}
