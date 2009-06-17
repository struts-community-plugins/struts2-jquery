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

public class EffectDivTag extends DivTag implements ResizableTag {

    private static final long serialVersionUID = 3111231035916461758L;

    protected String bindOn;
    protected String events;
    protected String effect;
    protected String effectDuration;
    protected String effectOptions;
    protected String befor;
    protected String after;
    protected String resizable;
    protected String resizableAnimate;
    protected String resizableAnimateDuration;
    protected String resizableAnimateEasing;
    protected String resizableAspectRatio;
    protected String resizableAutoHide;
    protected String resizableContainment;
    protected String resizableDelay;
    protected String resizableDistance;
    protected String resizableGhost;
    protected String resizableHelper;
    protected String resizableMaxHeight;
    protected String resizableMaxWidth;
    protected String resizableMinHeight;
    protected String resizableMinWidth;
    protected String resizableResize;
    protected String resizableStart;
    protected String resizableStop;

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
        div.setResizable(resizable);
        div.setResizableAnimate(resizableAnimate);
        div.setResizableAnimateDuration(resizableAnimateDuration);
        div.setResizableAnimateEasing(resizableAnimateEasing);
        div.setResizableAspectRatio(resizableAspectRatio);
        div.setResizableAutoHide(resizableAutoHide);
        div.setResizableContainment(resizableContainment);
        div.setResizableDelay(resizableDelay);
        div.setResizableDistance(resizableDistance);
        div.setResizableGhost(resizableGhost);
        div.setResizableHelper(resizableHelper);
        div.setResizableMaxHeight(resizableMaxHeight);
        div.setResizableMaxWidth(resizableMaxWidth);
        div.setResizableMinHeight(resizableMinHeight);
        div.setResizableMinWidth(resizableMinWidth);
        div.setResizableResize(resizableResize);
        div.setResizableStart(resizableStart);
        div.setResizableStop(resizableStop);
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
    public void setResizableAnimate(String animate)
    {
      this.resizableAnimate = animate;
    }

    public void setResizableAnimateDuration(String animateDuration)
    {
      this.resizableAnimateDuration = animateDuration;
    }

    public void setResizableAnimateEasing(String animateEasing)
    {
      this.resizableAnimateEasing = animateEasing;
    }

    public void setResizableAspectRatio(String aspectRatio)
    {
      this.resizableAspectRatio = aspectRatio;
    }

    public void setResizableAutoHide(String autoHide)
    {
      this.resizableAutoHide = autoHide;
    }

    public void setResizableContainment(String containment)
    {
      this.resizableContainment = containment;
    }

    public void setResizableDelay(String delay)
    {
      this.resizableDelay = delay;
    }

    public void setResizableDistance(String distance)
    {
      this.resizableDistance = distance;
    }

    public void setResizableGhost(String ghost)
    {
      this.resizableGhost = ghost;
    }

    public void setResizableHelper(String helper)
    {
      this.resizableHelper = helper;
    }

    public void setResizableMaxHeight(String maxHeight)
    {
      this.resizableMaxHeight = maxHeight;
    }

    public void setResizableMaxWidth(String maxWidth)
    {
      this.resizableMaxWidth = maxWidth;
    }

    public void setResizableMinHeight(String minHeight)
    {
      this.resizableMinHeight = minHeight;
    }

    public void setResizableMinWidth(String minWidth)
    {
      this.resizableMinWidth = minWidth;
    }

    public void setResizableResize(String resize)
    {
      this.resizableResize = resize;
    }

    public void setResizableStart(String start)
    {
      this.resizableStart = start;
    }

    public void setResizableStop(String stop)
    {
      this.resizableStop = stop;
    }

    public void setResizable(String resizable)
    {
      this.resizable = resizable;
    }
}
