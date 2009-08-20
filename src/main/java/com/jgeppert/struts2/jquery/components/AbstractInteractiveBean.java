package com.jgeppert.struts2.jquery.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class AbstractInteractiveBean extends AbstractBase {

  protected String onEnableTopics; // topics that will enable element
  protected String onDisableTopics; // topics that will disable element

  public AbstractInteractiveBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {

    super(stack, request, response);
  }

  public void evaluateExtraParams()
  {

    super.evaluateExtraParams();

    if (onEnableTopics != null) addParameter("onEnableTopics", findString(onEnableTopics));
    if (onDisableTopics != null) addParameter("onDisableTopics", findString(onDisableTopics));
  }
  
  protected void setStack(ValueStack stack)
  {
    this.stack = stack;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that will enable this element", type = "String", defaultValue = "")
  public void setOnEnableTopics(String onEnableTopics)
  {
    this.onEnableTopics = onEnableTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that will disable this element", type = "String", defaultValue = "")
  public void setOnDisableTopics(String onDisableTopics)
  {
    this.onDisableTopics = onDisableTopics;
  }

}
