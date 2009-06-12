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

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;
import org.apache.struts2.components.Div;

import com.opensymphony.xwork2.util.ValueStack;

@StrutsTag(name="effectDiv", tldTagClass="com.jgeppert.struts2.jquery.views.jsp.ui.EffectDivTag", description="Render HTML div that execute an effect on speciefied event")
public class EffectDiv extends Div {

    public static final String TEMPLATE = "effect";
    public static final String TEMPLATE_CLOSE = "effect-close";
    public static final String COMPONENT_NAME = EffectDiv.class.getName();
    final private static transient Random RANDOM = new Random();    

    protected String bindOn;
    protected String events;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;

    public EffectDiv(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

      if (bindOn != null)
          addParameter("bindOn", findString(bindOn));
      if (events != null)
          addParameter("events", findString(events));
      if (effect != null)
          addParameter("effect", findString(effect));
      if (effectDuration != null)
          addParameter("effectDuration", findValue(this.effectDuration, Integer.class));
      if (effectOptions != null)
          addParameter("effectOptions", findString(effectOptions));

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
    
    @StrutsTagAttribute(description = "Bind the start of effect on element. e.g. button or link")
    public void setBindOn(String bindOn)
    {
      this.bindOn = bindOn;
    }

    @StrutsTagAttribute(description = "Start the effect on specified event. Possible values are click, dblclick, mouseenter, mouseleave", defaultValue="click")
    public void setEvents(String events)
    {
      this.events = events;
    }

    @StrutsTagAttribute(description = "Perform a effect on the elements specified in the 'targets' attribute. e.g. bounce, highlight, pulsate, shake, size or transfer. See more details at http://docs.jquery.com/UI/Effects", required=true)
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @StrutsTagAttribute(description = "Duration of effect in milliseconds. Only valid if 'effect' attribute is set", defaultValue = "2000", type="Integer")
    public void setEffectDuration(String effectDuration) {
        this.effectDuration = effectDuration;
    }
    
    @StrutsTagAttribute(description = "jQuery options for effect, eg 'color : #aaaaaa' for the highlight effect or 'times : 3' for the bounce effect. Only valid if 'effect' attribute is set. See more details at http://docs.jquery.com/UI/Effects", defaultValue = "")
        public void setEffectOptions(String effectOptions) {
            this.effectOptions = effectOptions;
        }
}
