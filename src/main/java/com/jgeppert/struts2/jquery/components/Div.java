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

import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * This tag generates an HTML div that loads its content using an XMLHttpRequest call, via
 * the jQuery framework.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>Examples</p>
 * <!-- START SNIPPET: example1 -->
 * &lt;sj:div href="%{#url}"&gt;Initial Content&lt;/sj:div&gt;
 * <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 -->
 * &lt;img id="indicator" src="${pageContext.request.contextPath}/images/indicator.gif" style="display:none"/&gt;
 * &lt;sj:div href="%{#url}" indicator="indicator"&gt;
 *   Initial Content
 * &lt;/sj:div&gt;
 * <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 -->
 * &lt;sj:div 
 *      href="%{#url}" 
 *       effect="highlight" 
 *       effectOptions="color : '#222222'" 
 *       effectDuration="3600"&gt;
 *  Initial Content
 * &lt;/sj:div&gt;
 * <!-- END SNIPPET: example3 -->
 */
@StrutsTag(name="div", tldTagClass="com.jgeppert.struts2.jquery.views.jsp.ui.DivTag", description="Render HTML div providing content from remote call via AJAX")
public class Div extends AbstractRemoteBean implements RemoteBean, ResizableBean {

    public static final String TEMPLATE = "div";
    public static final String TEMPLATE_CLOSE = "div-close";
    public static final String COMPONENT_NAME = Div.class.getName();
    final private static transient Random RANDOM = new Random();    

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

    public Div(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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
          addParameter("resizableGhost", findString(resizableGhost));
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
    
    @StrutsTagAttribute(description="Enable this div element to be resizable. With the cursor grab the right or bottom border and drag to the desired width or height.", type="Boolean")
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
}
