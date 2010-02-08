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
 * A tag that creates an HTML &lt;a/&gt; element, that when clicked makes an
 * asynchronous request(XMLHttpRequest). The url attribute must be build using
 * the &lt;s:url/&gt; tag.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * Examples
 * </p>
 * 
 * <!-- START SNIPPET: example1 --> &lt;div id="div1"&gt;Div 1&lt;/div&gt;
 * &lt;s:url id="ajaxTest" value="/AjaxTest.action"/&gt;
 * 
 * &lt;sj:a id="link1" href="%{ajaxTest}" target="div1"&gt; Update Content
 * &lt;/sj:a&gt; <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 --> &lt;s:form id="form" action="AjaxTest"&gt;
 * &lt;input type="textbox" name="data"&gt; &lt;/s:form&gt;
 * 
 * &lt;sj:a formId="form" targets="div1"&gt;Submit form&lt;/sj:a&gt; <!-- END
 * SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 --> &lt;script type="text/javascript"&gt;
 * function before(event){ alert('before request'); }; function complete(event){
 * alert('after request'); }; &lt;/script&gt;
 * 
 * &lt;sj:a id="link1" href="%{ajaxTest}" target="div1" beforeSend="before()"
 * complete="complete()"&gt;Raise events&lt;/sj:a&gt; <!-- END SNIPPET: example3
 * -->
 */
@StrutsTag(name = "a", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.AnchorTag", description = "Renders an HTML anchor element that when clicked calls a URL via remote XMLHttpRequest and updates " + "its targets content")
public class Anchor extends AbstractRemoteBean implements ButtonBean {
  public static final String           TEMPLATE       = "a";
  public static final String           TEMPLATE_CLOSE = "a-close";
  public static final String           COMPONENT_NAME = Anchor.class.getName();
  public static final transient Random RANDOM         = new Random();
  public static final String           JQUERYACTION   = "anchor";

  protected String                     openDialog;
  protected String                     onClickTopics;
  protected String                     button;
  protected String                     buttonIcon;
  protected String                     buttonIconSecondary;

  public Anchor(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

  public String getComponentName()
  {
    return COMPONENT_NAME;
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    addParameter("jqueryaction", JQUERYACTION);

    if (openDialog != null) addParameter("openDialog", findString(openDialog));
    if (onClickTopics != null) addParameter("onClickTopics", findString(onClickTopics));
    if (button != null) addParameter("button", findValue(this.button, Boolean.class));
    if (buttonIcon != null) addParameter("buttonIcon", findString(buttonIcon));
    if (buttonIconSecondary != null) addParameter("buttonIconSecondary", findString(buttonIconSecondary));

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "anchor_" + String.valueOf(nextInt);
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

  @StrutsTagAttribute(description = "id of dialog that will be opened when clicked.")
  public void setOpenDialog(String openDialog)
  {
    this.openDialog = openDialog;
  }

  @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked", type = "String", defaultValue = "")
  public void setOnClickTopics(String onClickTopics)
  {
    this.onClickTopics = onClickTopics;
  }

  @StrutsTagAttribute(description = "jQuery UI Button", defaultValue = "false", type = "Boolean")
  public void setButton(String button)
  {
    this.button = button;
  }

  @StrutsTagAttribute(description = "Icons to display. The primary icon is displayed on the left of the label text. Value must be a classname (String), eg. ui-icon-gear.")
  public void setButtonIcon(String buttonIcon)
  {
    this.buttonIcon = buttonIcon;
  }

  @StrutsTagAttribute(description = "Icons to display. The secondary icon is displayed on the right of the label text. Value must be a classname (String), eg. ui-icon-gear.")
  public void setButtonIconSecondary(String buttonIconSecondary)
  {
    this.buttonIconSecondary = buttonIconSecondary;
  }
}
