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

@StrutsTag(name = "textfield", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.TextfieldTag", description = "Render HTML textfield providing content from remote call via AJAX")
public class Textfield extends AbstractFormElement {

  public static final String            TEMPLATE       = "textfield";
  public static final String            TEMPLATE_CLOSE = "textfield-close";
  public static final String            COMPONENT_NAME = Textfield.class.getName();
  final private static transient Random RANDOM         = new Random();
  public static final String            JQUERYACTION   = "container";

  protected String                      maxlength;
  protected String                      readonly;
  protected String                      size;

  public Textfield(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

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
    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "textfield_" + String.valueOf(nextInt);
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
}
