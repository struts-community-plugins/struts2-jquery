/*
 * $Id: AbstractRemoteTag.java 651946 2008-04-27 13:41:38Z apetrelli $
 *
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

import org.apache.struts2.views.jsp.ui.AbstractClosingTag;

import com.jgeppert.struts2.jquery.components.RemoteBean;

public abstract class AbstractRemoteTag extends AbstractClosingTag {

    private static final long serialVersionUID = -704912163849377645L;
    
    protected String href;
    protected String beforeSend;
    protected String complete;
    protected String error;
    protected String dataType;
    protected String formId;
    protected String indicator;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String timeout;
    
    protected void populateParams() {
        super.populateParams();

        RemoteBean remote = (RemoteBean) component;
        remote.setHref(href);
        remote.setBeforeSend(beforeSend);
        remote.setComplete(complete);
        remote.setError(error);
        remote.setDataType(dataType);
        remote.setFormId(formId);
        remote.setIndicator(indicator);
        remote.setEffect(effect);
        remote.setEffectDuration(effectDuration);
        remote.setEffectOptions(effectOptions);
        remote.setTimeout(timeout);
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setBeforeSend(String beforeSend) {
        this.beforeSend = beforeSend;
    }

    public void setComplete(String complete) {
        this.complete = complete;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
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

    public void setTimeout(String timeout)
    {
      this.timeout = timeout;
    }

}
