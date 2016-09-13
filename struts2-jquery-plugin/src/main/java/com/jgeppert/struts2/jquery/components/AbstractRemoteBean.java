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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTagAttribute;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * AbstractRemoteCallUIBean is superclass for all components dealing with remote
 * calls.
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public abstract class AbstractRemoteBean extends AbstractTopicsBean {

  protected String targets;
  protected String href;
  protected String formIds;
  protected String indicator;
  protected String loadingText;
  protected String errorText;
  protected String errorElementId;

  protected String dataType;
  protected String requestType;
  protected String effect;
  protected String effectDuration;
  protected String effectOptions;
  protected String effectMode;
  protected String timeout;
  protected String listenTopics;
  protected String onEffectCompleteTopics;

  public AbstractRemoteBean(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    if (href != null)
    {
      String hrefValue = findString(href);
      addParameter("href", hrefValue);
      if (hrefValue.indexOf("?") > 0)
      {
        addParameter("hrefUrl", hrefValue.substring(0, hrefValue.indexOf("?")));
        addParameter("hrefParameter", hrefValue.substring(hrefValue.indexOf("?") + 1));
      }
      else
      {
        addParameter("hrefUrl", hrefValue);
      }
    }
    addOgnlEvaluatedStringParameterIfExists("targets", targets);
    addOgnlEvaluatedStringParameterIfExists("formIds", formIds);
    addOgnlEvaluatedStringParameterIfExists("indicator", indicator);
    addOgnlEvaluatedStringParameterIfExists("loadingText", loadingText);
    addOgnlEvaluatedStringParameterIfExists("errorText", errorText);
    addOgnlEvaluatedStringParameterIfExists("errorElementId", errorElementId);
    addOgnlEvaluatedStringParameterIfExists("dataType", dataType);
    addOgnlEvaluatedStringParameterIfExists("requestType", requestType);
    addOgnlEvaluatedStringParameterIfExists("effect", effect);
    addOgnlEvaluatedStringParameterIfExists("effectDuration", effectDuration);
    addOgnlEvaluatedStringParameterIfExists("effectOptions", effectOptions);
    addOgnlEvaluatedStringParameterIfExists("effectMode", effectMode);
    addOgnlEvaluatedStringParameterIfExists("timeout", timeout);
    addOgnlEvaluatedStringParameterIfExists("listenTopics", listenTopics);
    addOgnlEvaluatedStringParameterIfExists("onEffectCompleteTopics", onEffectCompleteTopics);
  }

  @StrutsTagAttribute(name = "href", description = "The url to be use when this element is clicked", type = "String", defaultValue = "")
  public void setHref(String href)
  {
    this.href = href;
  }

  @StrutsTagAttribute(name = "formIds", description = "Comma delimited list of form ids for which to serialize all fields during submission when this element is clicked (if multiple forms have overlapping element names, it is indeterminate which will be used)", type = "String", defaultValue = "")
  public void setFormIds(String formIds)
  {
    this.formIds = formIds;
  }

  @StrutsTagAttribute(name = "targets", description = "A comma separated list of ids of container elements to load with the contents from the result of this request", type = "String", defaultValue = "")
  public void setTargets(String targets)
  {
    this.targets = targets;
  }

  @StrutsTagAttribute(name = "indicator", description = "If loading content into a target, Id of element that will be displayed during loading and hidden afterwards (will override settings for the target container)", type = "String", defaultValue = "")
  public void setIndicator(String indicator)
  {
    this.indicator = indicator;
  }

  @StrutsTagAttribute(name = "loadingText", description = "If loading content into a target, The text to be displayed during load (will be shown if any provided, will override settings for the target container)", type = "String", defaultValue = "")
  public void setLoadingText(String loadingText)
  {
    this.loadingText = loadingText;

  }

  @StrutsTagAttribute(name = "errorText", description = "The text to be displayed on load error. If 'errorElement' is provided, " + "this will display the error in the elemtn (if existing), if not, it will display the error as the contents of this container", type = "String", defaultValue = "false")
  public void setErrorText(String errorText)
  {
    this.errorText = errorText;
  }

  @StrutsTagAttribute(name = "errorElementId", description = "This should provide the id of the element into which the error text will be placed when an error ocurrs loading the container. If 'errorTest' is provided, that  wil be used, otherwise the ajax error message text wil be used.", type = "String", defaultValue = "false")
  public void setErrorElementId(String errorElementId)
  {
    this.errorElementId = errorElementId;
  }

  @StrutsTagAttribute(description = "Perform a effect on the elements specified in the 'targets' attribute. e.g. bounce, highlight, pulsate, shake, size or transfer. See more details at http://docs.jquery.com/UI/Effects", defaultValue = "none")
  public void setEffect(String effect)
  {
    this.effect = effect;
  }

  @StrutsTagAttribute(description = "Duration of effect in milliseconds. Only valid if 'effect' attribute is set", defaultValue = "2000")
  public void setEffectDuration(String effectDuration)
  {
    this.effectDuration = effectDuration;
  }

  @StrutsTagAttribute(description = "jQuery options for effect, eg 'color : #aaaaaa' for the highlight effect or 'times : 3' for the bounce effect. Only valid if 'effect' attribute is set. See more details at http://docs.jquery.com/UI/Effects", defaultValue = "")
  public void setEffectOptions(String effectOptions)
  {
    this.effectOptions = effectOptions;
  }

  @StrutsTagAttribute(description = "The Effect Mode. show, hide, toggle, none", defaultValue = "none")
  public void setEffectMode(String effectMode)
  {
    this.effectMode = effectMode;
  }

  @StrutsTagAttribute(description = "jQuery options for timeout. Default is 3000", defaultValue = "3000", type = "Integer")
  public void setTimeout(String timeout)
  {
    this.timeout = timeout;
  }

  @StrutsTagAttribute(description = "Type of the result. e.g. html, xml, text, json, ...")
  public void setDataType(String dataType)
  {
    this.dataType = dataType;
  }

  @StrutsTagAttribute(description = "Type of the AJAX Request. POST, GET, PUT", defaultValue = "POST")
  public void setRequestType(String requestType)
  {
    this.requestType = requestType;
  }

  @StrutsTagAttribute(description = "The comma separated list 'listenTopics' is the list of topic names that is used to trigger a request.")
  public void setListenTopics(String listenTopics)
  {
    this.listenTopics = listenTopics;
  }

  @StrutsTagAttribute(description = "A comma delimited list of topics that published when an effect is completed ", type = "String", defaultValue = "")
  public void setOnEffectCompleteTopics(String onEffectCompleteTopics)
  {
    this.onEffectCompleteTopics = onEffectCompleteTopics;
  }

}
