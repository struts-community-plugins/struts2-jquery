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

import java.io.Writer;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Form;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;
import com.opensymphony.xwork2.util.logging.Logger;
import com.opensymphony.xwork2.util.logging.LoggerFactory;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Renders a submit button that can submit a form asynchronously. The submit can
 * have three different types of rendering:
 * <ul>
 * <li>input: renders as html &lt;input type="submit"...&gt;</li>
 * <li>image: renders as html &lt;input type="image"...&gt;</li>
 * <li>button: renders as html &lt;button type="submit"...&gt;</li>
 * </ul>
 * Please note that the button type has advantages by adding the possibility to
 * seperate the submitted value from the text shown on the button face, but has
 * issues with Microsoft Internet Explorer at least up to 6.0
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 -->
 * 
 * <pre>
 * &lt;sj:submit value=&quot;%{'Submit'}&quot; /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * 
 * <pre>
 * &lt;sj:submit type=&quot;image&quot; value=&quot;%{'Submit'}&quot; label=&quot;Submit the form&quot; src=&quot;submit.gif&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * 
 * <pre>
 * &lt;sj:submit type=&quot;button&quot; value=&quot;%{'Submit'}&quot; label=&quot;Submit the form&quot;/&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example3 -->
 * 
 * <!-- START SNIPPET: example4 -->
 * 
 * <pre>
 * &lt;div id=&quot;div1&quot;&gt;Div 1&lt;/div&gt; 
 * &lt;s:url id=&quot;ajaxTest&quot; value=&quot;/AjaxTest.action&quot;/&gt;
 * &lt;sj:submit id=&quot;link1&quot; href=&quot;%{ajaxTest}&quot; target=&quot;div1&quot; /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example4 -->
 * 
 * <!-- START SNIPPET: example5 -->
 * 
 * <pre>
 * &lt;s:form id=&quot;form&quot; action=&quot;AjaxTest&quot;&gt;
 * &lt;input type=&quot;textbox&quot; name=&quot;data&quot;&gt; &lt;sj:submit /&gt; 
 * &lt;/s:form&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example5 -->
 * 
 * <!-- START SNIPPET: example6 -->
 * 
 * <pre>
 * &lt;s:form id=&quot;form&quot; action=&quot;AjaxTest&quot;&gt;
 * &lt;input type=&quot;textbox&quot; name=&quot;data&quot;&gt; 
 * &lt;/s:form&gt;
 * 
 * &lt;sj:submit formId=&quot;form&quot; /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example6 -->
 * 
 * <!-- START SNIPPET: example7 -->
 * 
 * <pre>
 * &lt;script type=&quot;text/javascript&quot;&gt;
 * function before(event){ alert('before request'); }; 
 * function complete(event){ alert('after request'); }; 
 * &lt;/script&gt;
 * 
 * &lt;sj:submit beforeSend=&quot;before()&quot; complete=&quot;complete()&quot; /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example7 -->
 * 
 * <!-- START SNIPPET: example8 -->
 * 
 * <pre>
 * &lt;sj:submit value&quot;AJAX Submit with effect&quot;
 * effect=&quot;highlight&quot; effectOptions=&quot;color : '#222222'&quot;
 * effectDuration=&quot;3600&quot;&gt; href=&quot;%{#ajaxTest}&quot; /&gt;
 * </pre>
 * 
 * <!-- END SNIPPET: example8 -->
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "submit", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.SubmitTag", description = "Render a submit button", allowDynamicAttributes = true)
public class Submit extends AbstractRemoteBean implements ButtonBean {

  private static final Logger           LOG            = LoggerFactory.getLogger(Submit.class);
  private final static transient Random RANDOM         = new Random();

  public static final String            TEMPLATE       = "submit";
  public static final String            TEMPLATE_CLOSE = "submit-close";
  public static final String            JQUERYACTION   = "button";
  public static final String            COMPONENT_NAME = Submit.class.getName();

  protected String                      src;
  protected String                      type;
  protected String                      clearForm;
  protected String                      resetForm;
  protected String                      iframe;
  protected String                      onClickTopics;
  protected String                      openDialog;
  protected String                      parentTheme;
  protected String                      button;
  protected String                      buttonIcon;
  protected String                      buttonIconSecondary;
  protected String                      validate;
  protected String                      validateFunction;
  protected String                      formFilter;
  protected String                      replaceTarget;

  public Submit(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

  public void evaluateParams()
  {
    super.evaluateExtraParams();
    addParameter("jqueryaction", JQUERYACTION);

    if ((key == null) && (value == null))
    {
      value = "Submit";
    }

    if (((key != null)) && (value == null))
    {
      this.value = "%{getText('" + key + "')}";
    }

    super.evaluateParams();
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    if (type != null) addParameter("type", findString(type));
    if (src != null) addParameter("src", findString(src));
    if (clearForm != null) addParameter("clearForm", findValue(clearForm, Boolean.class));
    if (resetForm != null) addParameter("resetForm", findValue(resetForm, Boolean.class));
    if (iframe != null) addParameter("iframe", findValue(iframe, Boolean.class));
    if (onClickTopics != null) addParameter("onClickTopics", findString(onClickTopics));
    if (openDialog != null) addParameter("openDialog", findString(openDialog));
    if (button != null) addParameter("button", findValue(this.button, Boolean.class));
    if (buttonIcon != null) addParameter("buttonIcon", findString(buttonIcon));
    if (buttonIconSecondary != null) addParameter("buttonIconSecondary", findString(buttonIconSecondary));
    if (validate != null) addParameter("validate", findValue(this.validate, Boolean.class));
    if (validateFunction != null) addParameter("validateFunction", findString(validateFunction));
    if (formFilter != null) addParameter("formFilter", findString(formFilter));
    if (replaceTarget != null) addParameter("replaceTarget", findValue(this.replaceTarget, Boolean.class));

    if ((this.id == null || this.id.length() == 0))
    {
      // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs
      // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
      int nextInt = RANDOM.nextInt();
      nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
      this.id = "submit_" + String.valueOf(nextInt);
      addParameter("id", this.id);
    }

    Form form = (Form) findAncestor(Form.class);
    if (parentTheme != null)
    {
      addParameter("parentTheme", findString(parentTheme));
    }
    else if (form != null)
    {
      if (form != null) addParameter("parentTheme", form.getTheme());
    }
    else
    {
      addParameter("parentTheme", "simple");
    }

    if (form != null && (formIds == null || formIds.length() <= 0)) addParameter("formIds", form.getId());
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

  /**
   * Indicate whether the concrete button supports the type "image".
   * 
   * @return <tt>true</tt> to indicate type image is supported.
   */
  protected boolean supportsImageType()
  {
    return true;
  }

  /**
   * Overrides to be able to render body in a template rather than always before
   * the template
   */
  public boolean end(Writer writer, String body)
  {
    evaluateParams();
    try
    {
      addParameter("body", body);

      mergeTemplate(writer, buildTemplateName(template, getDefaultTemplate()));
    }
    catch (Exception e)
    {
      LOG.error("error when rendering", e);
    }
    finally
    {
      popComponentStack();
    }

    return false;
  }

  @StrutsTagAttribute(description = "The type of submit to use. Valid values are <i>input</i>, " + "<i>button</i> and <i>image</i>.", defaultValue = "input")
  public void setType(String type)
  {
    this.type = type;
  }

  @StrutsTagAttribute(description = "Supply an image src for <i>image</i> type submit button. Will have no effect for types <i>input</i> and <i>button</i>.")
  public void setSrc(String src)
  {
    this.src = src;
  }

  @StrutsTagAttribute(description = "Clear all form fields after successful submit. Default: false", type = "Boolean")
  public void setClearForm(String clearForm)
  {
    this.clearForm = clearForm;
  }

  @StrutsTagAttribute(description = "Reset the form after successful submit. Default: false", type = "Boolean")
  public void setResetForm(String resetForm)
  {
    this.resetForm = resetForm;
  }

  @StrutsTagAttribute(description = "Boolean flag indicating whether the form should always target the server response to an iframe. This is useful in conjuction with file uploads. Default: false", type = "Boolean")
  public void setIframe(String iframe)
  {
    this.iframe = iframe;
  }

  @StrutsTagAttribute(name = "onClickTopics", description = "A comma delimited list of topics that published when the element is clicked", type = "String", defaultValue = "")
  public void setOnClickTopics(String onClickTopics)
  {
    this.onClickTopics = onClickTopics;
  }

  @StrutsTagAttribute(description = "id of dialog that will be opened when clicked.")
  public void setOpenDialog(String openDialog)
  {
    this.openDialog = openDialog;
  }

  @StrutsTagAttribute(description = "The parent theme. Default: value of parent form tag or simple if no parent form tag is available")
  public void setParentTheme(String parentTheme)
  {
    this.parentTheme = parentTheme;
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

  @StrutsTagAttribute(description = "A function that handle the client validation result. eg.: myValidation(form, errors)")
  public void setValidateFunction(String validateFunction)
  {
    this.validateFunction = validateFunction;
  }

  @StrutsTagAttribute(description = "Enable client AJAX validation", defaultValue = "false", type = "Boolean")
  public void setValidate(String validate)
  {
    this.validate = validate;
  }

  @StrutsTagAttribute(description = "Function name used to filter the fields of the form.")
  public void setFormFilter(String formFilter)
  {
    this.formFilter = formFilter;
  }

  @StrutsTagAttribute(description = "Set to true if the target should be replaced or false if only the target contents should be replaced.", defaultValue = "false", type = "Boolean")
  public void setReplaceTarget(String replaceTarget)
  {
    this.replaceTarget = replaceTarget;
  }
}
