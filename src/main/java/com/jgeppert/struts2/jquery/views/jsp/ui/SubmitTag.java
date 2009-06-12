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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.jgeppert.struts2.jquery.components.Submit;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * @see Submit
 */
public class SubmitTag extends AbstractUITag {

    private static final long serialVersionUID = 2179281109958301343L;

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
    protected String targets;
    protected String type;
    protected String src;
    
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Submit(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Submit submit = ((Submit) component);
        submit.setHref(href);
        submit.setBeforeSend(beforeSend);
        submit.setComplete(complete);
        submit.setError(error);
        submit.setDataType(dataType);
        submit.setFormId(formId);
        submit.setEffect(effect);
        submit.setEffectDuration(effectDuration);
        submit.setEffectOptions(effectOptions);
        submit.setTargets(targets);
        submit.setSrc(src);
        submit.setType(type);
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

	public void setTargets(String targets) {
		this.targets = targets;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}
