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
 * A tag that creates an Spinner. BETA
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sj:spinner id=&quot;mysspinner&quot; name=&quot;mysspinner&quot;/&gt;
 * </pre>
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "spinner", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SpinnerTag", description = "Render a Spinner. BETA", allowDynamicAttributes = true)
public class Spinner extends AbstractFormElement {

  public static final String            JQUERYACTION   = "spinner";
  public static final String            TEMPLATE       = "spinner";
  public static final String            TEMPLATE_CLOSE = "spinner-close";
  final private static transient Random RANDOM         = new Random();

  protected String                      max;
  protected String                      min;
  protected String                      step;

  public Spinner(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

  public void evaluateParams()
  {
    super.evaluateParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (max != null) addParameter("max", findValue(max, Integer.class));
    if (min != null) addParameter("min", findValue(min, Integer.class));
    if (step != null) addParameter("step", findValue(step, Integer.class));

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "spinner_" + String.valueOf(nextInt);
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

  @StrutsTagAttribute(description = "maximum value allowed", type = "Integer")
  public void setMax(String max)
  {
    this.max = max;
  }

  @StrutsTagAttribute(description = "minimum value allowed", type = "Integer")
  public void setMin(String min)
  {
    this.min = min;
  }

  @StrutsTagAttribute(description = "size of step to take when spinning", type = "Integer")
  public void setStep(String step)
  {
    this.step = step;
  }
}
