package com.jgeppert.struts2.jquery.components;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

public abstract class AbstractBase extends ClosingUIBean {

  public AbstractBase(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  protected String onHideTopics;
  protected String onShowTopics;
  protected String onRemoveTopics;

  public void evaluateExtraParams()
  {
    if (onHideTopics != null) addParameter("onHideTopics", findString(onHideTopics));
    if (onShowTopics != null) addParameter("onShowTopics", findString(onShowTopics));
    if (onRemoveTopics != null) addParameter("onRemoveTopics", findString(onRemoveTopics));
  }

  protected void setStack(ValueStack stack)
  {
    this.stack = stack;
  }

  @SuppressWarnings("unchecked")
  protected void setParameters(Map parameters)
  {
    this.parameters = parameters;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that will hide (display: none) this element", type = "String", defaultValue = "")
  public void setOnHideTopics(String onHideTopics)
  {
    this.onHideTopics = onHideTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that will remove this element from the dom", type = "String", defaultValue = "")
  public void setOnRemoveTopics(String onRemoveTopics)
  {
    this.onRemoveTopics = onRemoveTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that will show (display: block) this element", type = "String", defaultValue = "")
  public void setOnShowTopics(String onShowTopics)
  {
    this.onShowTopics = onShowTopics;
  }
}
