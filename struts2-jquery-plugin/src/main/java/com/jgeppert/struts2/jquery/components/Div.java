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
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * This tag generates an HTML div that loads its content using an XMLHttpRequest
 * call, via the jQuery framework.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 --> &lt;sj:div href="%{#url}"&gt;Initial
 * Content&lt;/sj:div&gt; <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 --> &lt;img id="indicator"
 * src="${pageContext.request.contextPath}/images/indicator.gif"
 * style="display:none"/&gt; &lt;sj:div href="%{#url}" indicator="indicator"&gt;
 * Initial Content &lt;/sj:div&gt; <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 --> &lt;sj:div href="%{#url}" effect="highlight"
 * effectOptions="color : '#222222'" effectDuration="3600"&gt; Initial Content
 * &lt;/sj:div&gt; <!-- END SNIPPET: example3 -->
 */
@StrutsTag(name = "div", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.DivTag", description = "Render HTML div providing content from remote call via AJAX", allowDynamicAttributes = true)
public class Div extends AbstractContainer implements ResizableBean, DroppableBean, DraggableBean, SelectableBean {

  public static final String            TEMPLATE       = "div";
  public static final String            TEMPLATE_CLOSE = "div-close";
  public static final String            COMPONENT_NAME = Div.class.getName();
  final private static transient Random RANDOM         = new Random();
  public static final String            JQUERYACTION   = "container";

  public Div(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "div_" + String.valueOf(nextInt);
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
}
