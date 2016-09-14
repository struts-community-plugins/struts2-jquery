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

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render HTML textarea providing content from remote call via AJAX
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "textarea", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.TextareaTag", description = "Render HTML textarea providing content from remote call via AJAX", allowDynamicAttributes = true)
public class Textarea extends AbstractFormElement {

  public static final String            TEMPLATE       = "textarea";
  public static final String            TEMPLATE_CLOSE = "textarea-close";
  public static final String            COMPONENT_NAME = Textarea.class.getName();
  final private static transient Random RANDOM         = new Random();
  public static final String            JQUERYACTION   = "container";

  protected String                      cols;
  protected String                      readonly;
  protected String                      rows;
  protected String                      wrap;

  public Textarea(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

    addOgnlEvaluatedObjectParameterIfExists("readonly", readonly, Boolean.class);
    addOgnlEvaluatedStringParameterIfExists("cols", cols);
    addOgnlEvaluatedStringParameterIfExists("rows", rows);
    addOgnlEvaluatedStringParameterIfExists("wrap", wrap);

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "textarea_" + String.valueOf(nextInt);
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

  @StrutsTagAttribute(description = "HTML cols attribute", type = "Integer")
  public void setCols(String cols)
  {
    this.cols = cols;
  }

  @StrutsTagAttribute(description = "Whether the textarea is readonly", type = "Boolean", defaultValue = "false")
  public void setReadonly(String readonly)
  {
    this.readonly = readonly;
  }

  @StrutsTagAttribute(description = "HTML rows attribute", type = "Integer")
  public void setRows(String rows)
  {
    this.rows = rows;
  }

  @StrutsTagAttribute(description = "HTML wrap attribute")
  public void setWrap(String wrap)
  {
    this.wrap = wrap;
  }
}
