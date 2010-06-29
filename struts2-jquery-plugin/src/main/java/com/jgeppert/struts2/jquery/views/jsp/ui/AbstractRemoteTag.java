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

package com.jgeppert.struts2.jquery.views.jsp.ui;

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;

public abstract class AbstractRemoteTag extends AbstractTopicTag {

  private static final long serialVersionUID = -704912163849377645L;

  protected String          targets;
  protected String          href;
  protected String          formIds;
  protected String          indicator;
  protected String          loadingText;
  protected String          errorText;
  protected String          errorElementId;
  protected String          dataType;
  protected String          requestType;
  protected String          effect;
  protected String          effectDuration;
  protected String          effectOptions;
  protected String          timeout;
  protected String          listenTopics;

  protected void populateParams()
  {
    super.populateParams();

    AbstractRemoteBean remote = (AbstractRemoteBean) component;
    remote.setHref(href);
    remote.setTargets(targets);
    remote.setFormIds(formIds);
    remote.setIndicator(indicator);
    remote.setLoadingText(loadingText);
    remote.setErrorText(errorText);
    remote.setErrorElementId(errorElementId);
    remote.setDataType(dataType);
    remote.setRequestType(requestType);
    remote.setEffect(effect);
    remote.setEffectDuration(effectDuration);
    remote.setEffectOptions(effectOptions);
    remote.setTimeout(timeout);
    remote.setListenTopics(listenTopics);
  }

  public void setTargets(String targets)
  {
    this.targets = targets;
  }

  public void setHref(String href)
  {
    this.href = href;
  }

  public void setFormIds(String formIds)
  {
    this.formIds = formIds;
  }

  public void setIndicator(String indicator)
  {
    this.indicator = indicator;
  }

  public void setLoadingText(String loadingText)
  {
    this.loadingText = loadingText;
  }

  public void setErrorText(String errorText)
  {
    this.errorText = errorText;
  }

  public void setErrorElementId(String errorElementId)
  {
    this.errorElementId = errorElementId;
  }

  public void setDataType(String dataType)
  {
    this.dataType = dataType;
  }

  public void setRequestType(String requestType)
  {
    this.requestType = requestType;
  }

  public void setEffect(String effect)
  {
    this.effect = effect;
  }

  public void setEffectDuration(String effectDuration)
  {
    this.effectDuration = effectDuration;
  }

  public void setEffectOptions(String effectOptions)
  {
    this.effectOptions = effectOptions;
  }

  public void setTimeout(String timeout)
  {
    this.timeout = timeout;
  }

  public void setListenTopics(String listenTopics)
  {
    this.listenTopics = listenTopics;
  }
}
