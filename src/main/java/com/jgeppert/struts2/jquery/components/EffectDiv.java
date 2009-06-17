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
public class EffectDiv extends Div implements ResizableBean {

    public static final String TEMPLATE = "effect";
    public static final String TEMPLATE_CLOSE = "effect-close";
    public static final String COMPONENT_NAME = EffectDiv.class.getName();
    final private static transient Random RANDOM = new Random();    

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
    protected String resizableHandles;
 
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
        addParameter("effectDuration", findString(effectDuration));
      if (effectOptions != null)
          addParameter("effectOptions", findString(effectOptions));
      if (befor != null)
        addParameter("befor", findString(befor));
      if (after != null)
        addParameter("after", findString(after));
      if(resizable != null)
        addParameter("resizable", findValue(resizable, Boolean.class));
      if (resizableAnimate != null)
        addParameter("resizableAnimate", findValue(resizableAnimate, Boolean.class));
      if (resizableAnimateDuration != null)
        addParameter("resizableAnimateDuration", findString(resizableAnimateDuration));
      if (resizableAnimateEasing != null)
        addParameter("resizableAnimateEasing", findString(resizableAnimateEasing));
      if (resizableAspectRatio != null)
        addParameter("resizableAspectRatio", findValue(resizableAspectRatio, Boolean.class));
      if (resizableAutoHide != null)
        addParameter("resizableAutoHide", findValue(resizableAutoHide, Boolean.class));
      if (resizableContainment != null)
        addParameter("resizableContainment", findString(resizableContainment));
      if (resizableDelay != null)
        addParameter("resizableDelay", findString(resizableDelay));
      if (resizableDistance != null)
        addParameter("resizableDistance", findString(resizableDistance));
      if (resizableGhost != null)
        addParameter("resizableGhost", findValue(resizableGhost, Boolean.class));
      if (resizableHelper != null)
        addParameter("resizableHelper", findString(resizableHelper));
      if (resizableMaxHeight != null)
        addParameter("resizableMaxHeight", findString(resizableMaxHeight));
      if (resizableMaxWidth != null)
        addParameter("resizableMaxWidth", findString(resizableMaxWidth));
      if (resizableMinHeight != null)
        addParameter("resizableMinHeight", findString(resizableMinHeight));
      if (resizableMinWidth != null)
        addParameter("resizableMinWidth", findString(resizableMinWidth));
      if (resizableResize != null)
        addParameter("resizableResize", findString(resizableResize));
      if (resizableStart != null)
        addParameter("resizableStart", findString(resizableStart));
      if (resizableStop != null)
        addParameter("resizableStop", findString(resizableStop));
      if (resizableHandles != null)
        addParameter("resizableHandles", findString(resizableHandles));

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

    @StrutsTagAttribute(description = "Perform a effect on the elements specified in the 'targets' attribute. e.g. bounce, highlight, pulsate, shake, size or transfer. See more details at http://docs.jquery.com/UI/Effects")
    public void setEffect(String effect) {
        this.effect = effect;
    }

    @StrutsTagAttribute(description = "Duration of effect in milliseconds. Only valid if 'effect' attribute is set", defaultValue = "2000")
    public void setEffectDuration(String effectDuration) {
        this.effectDuration = effectDuration;
    }
    
    @StrutsTagAttribute(description = "jQuery options for effect, eg 'color : #aaaaaa' for the highlight effect or 'times : 3' for the bounce effect. Only valid if 'effect' attribute is set. See more details at http://docs.jquery.com/UI/Effects", defaultValue = "")
    public void setEffectOptions(String effectOptions) {
        this.effectOptions = effectOptions;
    }

    @StrutsTagAttribute(description="Executed javascript function befor effect.")
    public void setBefor(String befor)
    {
      this.befor = befor;
    }

    @StrutsTagAttribute(description="Executed javascript function after effect.")
    public void setAfter(String after)
    {
      this.after = after;
    }

    @StrutsTagAttribute(description="Enable this div element to be resizable. With the cursor grab the right or bottom border and drag to the desired width or height. Default: false", type="Boolean")
    public void setResizable(String resizable)
    {
      this.resizable = resizable;
    }

    @StrutsTagAttribute(description="Animates to the final size after resizing. Default: false", type="Boolean")
    public void setResizableAnimate(String animate)
    {
      this.resizableAnimate = animate;
    }

    @StrutsTagAttribute(description="Duration time for animating, in milliseconds.")
    public void setResizableAnimateDuration(String animateDuration)
    {
      this.resizableAnimateDuration = animateDuration;
    }

    @StrutsTagAttribute(description="Easing effect for animating. Default: swing")
    public void setResizableAnimateEasing(String animateEasing)
    {
      this.resizableAnimateEasing = animateEasing;
    }

    @StrutsTagAttribute(description="If set to true, resizing is constrained by the original aspect ratio. Default: false", type="Boolean")
    public void setResizableAspectRatio(String aspectRatio)
    {
      this.resizableAspectRatio = aspectRatio;
    }

    @StrutsTagAttribute(description="If set to true, automatically hides the handles except when the mouse hovers over the element. Default: false", type="Boolean")
    public void setResizableAutoHide(String autoHide)
    {
      this.resizableAutoHide = autoHide;
    }

    @StrutsTagAttribute(description="Constrains resizing to within the bounds of the specified element. Possible values: 'parent', 'document' or an id")
    public void setResizableContainment(String containment)
    {
      this.resizableContainment = containment;
    }

    @StrutsTagAttribute(description="Tolerance, in milliseconds, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond duration. This can help prevent unintended resizing when clicking on an element.")
    public void setResizableDelay(String delay)
    {
      this.resizableDelay = delay;
    }

    @StrutsTagAttribute(description="Tolerance, in pixels, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond distance. This can help prevent unintended resizing when clicking on an element.")
    public void setResizableDistance(String distance)
    {
      this.resizableDistance = distance;
    }

    @StrutsTagAttribute(description="If set to true, a semi-transparent helper element is shown for resizing. Default: false", type="Boolean")
    public void setResizableGhost(String ghost)
    {
      this.resizableGhost = ghost;
    }

    @StrutsTagAttribute(description="This is the css class that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized. e.g. ui-state-highlight")
    public void setResizableHelper(String helper)
    {
      this.resizableHelper = helper;
    }

    @StrutsTagAttribute(description="This is the maximum height the resizable should be allowed to resize to.")
    public void setResizableMaxHeight(String maxHeight)
    {
      this.resizableMaxHeight = maxHeight;
    }

    @StrutsTagAttribute(description="This is the maximum width the resizable should be allowed to resize to.")
    public void setResizableMaxWidth(String maxWidth)
    {
      this.resizableMaxWidth = maxWidth;
    }

    @StrutsTagAttribute(description="This is the minimum height the resizable should be allowed to resize to.")
    public void setResizableMinHeight(String minHeight)
    {
      this.resizableMinHeight = minHeight;
    }

    @StrutsTagAttribute(description="This is the minimum width the resizable should be allowed to resize to.")
    public void setResizableMinWidth(String minWidth)
    {
      this.resizableMinWidth = minWidth;
    }

    @StrutsTagAttribute(description="This event javascript function is triggered during the resize, on the drag of the resize handler.")
    public void setResizableResize(String resize)
    {
      this.resizableResize = resize;
    }

    @StrutsTagAttribute(description="This event javascript function is triggered at the start of a resize operation.")
    public void setResizableStart(String start)
    {
      this.resizableStart = start;
    }

    @StrutsTagAttribute(description="This event javascript function is triggered at the end of a resize operation.")
    public void setResizableStop(String stop)
    {
      this.resizableStop = stop;
    }

    @StrutsTagAttribute(description="If specified as a string, should be a comma-split list of any of the following: 'n, e, s, w, ne, se, sw, nw, all'. Default: e, s, se")
    public void setResizableHandles(String handles)
    {
      this.resizableHandles = handles;
    }

}
