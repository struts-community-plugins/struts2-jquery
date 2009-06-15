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

import org.apache.struts2.components.ClosingUIBean;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.opensymphony.xwork2.util.ValueStack;

/**
 * AbstractRemoteCallUIBean is superclass for all components dealing with remote
 * calls.
 */
public abstract class AbstractRemoteBean extends ClosingUIBean {

    final private static transient Random RANDOM = new Random();    

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
    
    public AbstractRemoteBean(ValueStack stack, HttpServletRequest request,
            HttpServletResponse response) {
        super(stack, request, response);
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        if (href != null)
            addParameter("href", findString(href));
        if (beforeSend != null)
            addParameter("beforeSend", findString(beforeSend));
        if (complete != null)
            addParameter("complete", findString(complete));
        if (error != null)
            addParameter("error", findString(error));
        if (dataType != null)
            addParameter("dataType", findString(dataType));
        if (formId != null)
            addParameter("formId", findString(formId));
        if (indicator != null)
            addParameter("indicator", findString(indicator));
        if (effect != null)
            addParameter("effect", findString(effect));
        if (effectDuration != null)
          addParameter("effectDuration", findString(effectDuration));
        if (effectOptions != null)
            addParameter("effectOptions", findString(effectOptions));
        if (timeout != null)
          addParameter("timeout", findString(timeout));

        if ((this.id == null || this.id.length() == 0)) {
            // resolves Math.abs(Integer.MIN_VALUE) issue reported by FindBugs 
            // http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
            int nextInt = RANDOM.nextInt();
            nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);  
            this.id = "widget_" + String.valueOf(nextInt);
            addParameter("id", this.id);
        }
    }

    @Override
    @StrutsTagSkipInheritance
    public void setTheme(String theme) {
        super.setTheme(theme);
    }
    
    @Override
    public String getTheme() {
        return "jquery";
    }

    @StrutsTagAttribute(description="Executed javascript function befor ajax request. e.g. befor()")
    public void setBeforeSend(String beforeSend) {
        this.beforeSend = beforeSend;
    }

    @StrutsTagAttribute(description="The URL to call to obtain the content. Note: If used with ajax context, the value must be set as an url tag value.")
    public void setHref(String href) {
        this.href = href;
    }


    @StrutsTagAttribute(description="Executed javascript function after completed ajax request. e.g. after()")
    public void setComplete(String complete) {
        this.complete = complete;
    }

    @StrutsTagAttribute(description="Executed javascript function on error. e.g. error()")
    public void setError(String error) {
        this.error = error;
    }


    @StrutsTagAttribute(description="Type of the result. e.g. html, xml, text, json, ...")
    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    @StrutsTagAttribute(description="Form id whose fields will be serialized and passed as parameters")
    public void setFormId(String formId) {
        this.formId = formId;
    }

     @StrutsTagAttribute(description="Id of element that will be shown while making request")
    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }


    @StrutsTagAttribute(description="The css class to use for element")
    public void setCssClass(String cssClass) {
        super.setCssClass(cssClass);
    }

    @StrutsTagAttribute(description="The css style to use for element")
    public void setCssStyle(String cssStyle) {
        super.setCssStyle(cssStyle);
    }

    @StrutsTagAttribute(description="The id to use for the element")
    public void setId(String id) {
        super.setId(id);
    }

    @StrutsTagAttribute(description="The name to set for element")
    public void setName(String name) {
        super.setName(name);
    }

    @StrutsTagAttribute(description = "Perform a effect on the elements specified in the 'targets' attribute. e.g. bounce, highlight, pulsate, shake, size or transfer. See more details at http://docs.jquery.com/UI/Effects", 
        defaultValue = "none")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @StrutsTagAttribute(description = "Duration of effect in milliseconds. Only valid if 'effect' attribute is set", defaultValue = "2000")
    public void setEffectDuration(String effectDuration) {
        this.effectDuration = effectDuration;
    }
    
    @StrutsTagAttribute(description = "jQuery options for effect, eg 'color : #aaaaaa' for the highlight effect or 'times : 3' for the bounce effect. Only valid if 'effect' attribute is set. See more details at http://docs.jquery.com/UI/Effects", 
            defaultValue = "")
        public void setEffectOptions(String effectOptions) {
            this.effectOptions = effectOptions;
        }

   @StrutsTagAttribute(description = "jQuery options for timeout. Default is 3000", defaultValue = "3000", type="Integer")
   public void setTimeout(String timeout)
    {
      this.timeout = timeout;
    }
}
