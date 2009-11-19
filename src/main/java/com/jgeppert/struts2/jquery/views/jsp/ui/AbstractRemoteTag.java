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
    
    
    protected String targets;     //The targets into which to load content
    protected String href;        //The url to execute
    protected String formIds;     //the forms
    protected String validate;      //text to be displayed on load error
    protected String indicator;   //If loading content into a target, Id of element that will be displayed during loading and hidden afterwards
    protected String loadingText;   //If loading content into a target, The text to be displayed during load
    protected String errorText;       //text to be displayed on load error
    protected String errorElementId;    //the element into which to place error messages
    protected String dataType;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String timeout;
    
    protected void populateParams() {
        super.populateParams();

        AbstractRemoteBean remote = (AbstractRemoteBean) component;
        remote.setHref(href);
        remote.setTargets(targets);
        remote.setFormIds(formIds);
        remote.setValidate(validate);
        remote.setIndicator(indicator);
        remote.setLoadingText(loadingText);
        remote.setErrorText(errorText);
        remote.setErrorElementId(errorElementId);
        remote.setDataType(dataType);
        remote.setEffect(effect);
        remote.setEffectDuration(effectDuration);
        remote.setEffectOptions(effectOptions);
        remote.setTimeout(timeout);
    }

    public void setTargets(String targets) {
      this.targets = targets;
    }

    public void setHref(String href) {
      this.href = href;
    }

    public void setFormIds(String formIds) {
      this.formIds = formIds;
    }

    public void setValidate(String validate) {
      this.validate = validate;
    }
    
    public void setIndicator(String indicator) {
      this.indicator = indicator;
    }

    public void setLoadingText(String loadingText) {
      this.loadingText = loadingText;
    }

    public void setErrorText(String errorText) {
      this.errorText = errorText;
    }

    public void setErrorElementId(String errorElementId) {
      this.errorElementId = errorElementId;
    }

    public void setDataType(String dataType) {
      this.dataType = dataType;
    }

    public void setEffect(String effect) {
      this.effect = effect;
    }

    public void setEffectDuration(String effectDuration) {
      this.effectDuration = effectDuration;
    }

    public void setEffectOptions(String effectOptions) {
      this.effectOptions = effectOptions;
    }

    public void setTimeout(String timeout) {
      this.timeout = timeout;
    }
}
