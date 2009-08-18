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
    protected String dataType;
    protected String formIds;
    protected String indicator;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String targets;
    protected String src;
    protected String type;
    protected String timeout;
    protected String clearForm;
    protected String resetForm;
    protected String iframe;
    protected String onBeforeTopics;
    protected String onCompleteTopics;
    protected String onSuccessTopics;
    protected String onErrorTopics;
    protected String onAlwaysTopics;
    protected String onChangeTopics;
    protected String onClickTopics;   //topics that are published on click
    protected String loadingText;   //If loading content into a target, The text to be displayed during load
    protected String errorText;       //text to be displayed on load error
    protected String errorElementId;    //the id of the element in to which to put the error text
    protected String elementIds;    //Form elements that should be individually serialized and sent with the input's load request
    protected String validate;      //text to be displayed on load error
   
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Submit(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Submit submit = ((Submit) component);
        submit.setOnClickTopics(onClickTopics);
        submit.setHref(href);
        submit.setDataType(dataType);
        submit.setFormIds(formIds);
        submit.setEffect(effect);
        submit.setEffectDuration(effectDuration);
        submit.setEffectOptions(effectOptions);
        submit.setTargets(targets);
        submit.setSrc(src);
        submit.setType(type);
        submit.setIndicator(indicator);
        submit.setClearForm(clearForm);
        submit.setResetForm(resetForm);
        submit.setIframe(iframe);
        submit.setTimeout(timeout);
        submit.setOnAlwaysTopics(onAlwaysTopics);
        submit.setOnErrorTopics(onErrorTopics);
        submit.setOnBeforeTopics(onBeforeTopics);
        submit.setOnChangeTopics(onChangeTopics);
        submit.setOnCompleteTopics(onCompleteTopics);
        submit.setOnSuccessTopics(onSuccessTopics);
        submit.setLoadingText(loadingText);
        submit.setErrorText(errorText);
        submit.setErrorElementId(errorElementId);
        submit.setElementIds(elementIds);
    }

    public void setOnClickTopics(String onClickTopics) {
      this.onClickTopics = onClickTopics;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public void setFormIds(String formIds) {
        this.formIds = formIds;
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

  public void setClearForm(String clearForm)
  {
    this.clearForm = clearForm;
  }

  public void setResetForm(String resetForm)
  {
    this.resetForm = resetForm;
  }

  public void setIframe(String iframe)
  {
    this.iframe = iframe;
  }

  public void setTimeout(String timeout)
  {
    this.timeout = timeout;
  }

  public void setOnBeforeTopics(String onBeforeTopics)
  {
    this.onBeforeTopics = onBeforeTopics;
  }

  public void setOnCompleteTopics(String onCompleteTopics)
  {
    this.onCompleteTopics = onCompleteTopics;
  }

  public void setOnSuccessTopics(String onSuccessTopics)
  {
    this.onSuccessTopics = onSuccessTopics;
  }

  public void setOnErrorTopics(String onErrorTopics)
  {
    this.onErrorTopics = onErrorTopics;
  }

  public void setOnAlwaysTopics(String onAlwaysTopics)
  {
    this.onAlwaysTopics = onAlwaysTopics;
  }

  public void setOnChangeTopics(String onChangeTopics)
  {
    this.onChangeTopics = onChangeTopics;
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

  public void setElementIds(String elementIds)
  {
    this.elementIds = elementIds;
  }

  public void setValidate(String validate)
  {
    this.validate = validate;
  }
}
