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
import org.apache.struts2.views.jsp.ui.DivTag;

import com.jgeppert.struts2.jquery.components.EffectDiv;
import com.opensymphony.xwork2.util.ValueStack;

public class EffectDivTag extends DivTag {

    private static final long serialVersionUID = 3111231035916461758L;

    protected String bindOn;
    protected String events;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String befor;
    protected String after;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new EffectDiv(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        EffectDiv div = (EffectDiv) component;
        div.setBindOn(bindOn);
        div.setEffect(effect);
        div.setEffectDuration(effectDuration);
        div.setEffectOptions(effectOptions);
        div.setEvents(events);
        div.setBefor(befor);
        div.setAfter(after);
    }

    public void setBindOn(String bindOn)
    {
      this.bindOn = bindOn;
    }

    public void setEvents(String events)
    {
      this.events = events;
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

    public void setBefor(String befor)
    {
      this.befor = befor;
    }

    public void setAfter(String after)
    {
      this.after = after;
    }
}
