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
 * This tag generates an HTML div that loads its content using an XMLHttpRequest
 * call, via the jQuery framework.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples
 * </p>
 * <!-- START SNIPPET: example1 --> &lt;sj:div href="%{#url}"&gt;Initial
 * Content&lt;/sj:div&gt; <!-- END SNIPPET: example1 -->
 * 
 * <!-- START SNIPPET: example2 --> &lt;img id="indicator"
 * src="${pageContext.request.contextPath}/images/indicator.gif"
 * style="display:none"/&gt; &lt;sj:div href="%{#url}" indicator="indicator"&gt;
 * Initial Content &lt;/sj:div&gt; <!-- END SNIPPET: example2 -->
 * 
 * <!-- START SNIPPET: example3 --> &lt;sj:div href="%{#url}" effect="highlight"
 * effectOptions="color : '#222222'" effectDuration="3600"&gt; Initial Content
 * &lt;/sj:div&gt; <!-- END SNIPPET: example3 -->
 */
@StrutsTag(name = "div", tldTagClass = "com.jgeppert.struts2.jquery.views.jsp.ui.DivTag", description = "Render HTML div providing content from remote call via AJAX")
public class Div extends AbstractRemoteBean implements RemoteBean, ResizableBean, DroppableBean, DraggableBean {

  public static final String            TEMPLATE       = "div";
  public static final String            TEMPLATE_CLOSE = "div-close";
  public static final String            COMPONENT_NAME = Div.class.getName();
  final private static transient Random RANDOM         = new Random();

  protected String                      resizable;
  protected String                      resizableAnimate;
  protected String                      resizableAnimateDuration;
  protected String                      resizableAnimateEasing;
  protected String                      resizableAspectRatio;
  protected String                      resizableAutoHide;
  protected String                      resizableContainment;
  protected String                      resizableDelay;
  protected String                      resizableDistance;
  protected String                      resizableGhost;
  protected String                      resizableHelper;
  protected String                      resizableMaxHeight;
  protected String                      resizableMaxWidth;
  protected String                      resizableMinHeight;
  protected String                      resizableMinWidth;
  protected String                      resizableResize;
  protected String                      resizableStart;
  protected String                      resizableStop;
  protected String                      resizableHandles;
  protected String                      droppable;
  protected String                      droppableAccept;
  protected String                      droppableActiveClass;
  protected String                      droppableAddClasses;
  protected String                      droppableGreedy;
  protected String                      droppableHoverClass;
  protected String                      droppableScope;
  protected String                      droppableTolerance;
  protected String                      droppableActivate;
  protected String                      droppableDeactivate;
  protected String                      droppableDrop;
  protected String                      droppableOut;
  protected String                      droppableOver;
  protected String                      draggable;
  protected String                      draggableAppendTo;
  protected String                      draggableAxis;
  protected String                      draggableCancel;
  protected String                      draggableContainment;
  protected String                      draggableDelay;
  protected String                      draggableDistance;
  protected String                      draggableDrag;
  protected String                      draggableHandle;
  protected String                      draggableHelper;
  protected String                      draggableIframeFix;
  protected String                      draggableOpacity;
  protected String                      draggableRefreshPositions;
  protected String                      draggableRevert;
  protected String                      draggableRevertDuration;
  protected String                      draggableScope;
  protected String                      draggableScroll;
  protected String                      draggableScrollSensitivity;
  protected String                      draggableScrollSpeed;
  protected String                      draggableSnap;
  protected String                      draggableSnapMode;
  protected String                      draggableSnapTolerance;
  protected String                      draggableStart;
  protected String                      draggableStop;
  protected String                      draggableZindex;
  protected String                      draggableAddClasses;

  public Div(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
    super(stack, request, response);
  }

  public String getDefaultOpenTemplate()
  {
    return TEMPLATE;
  }

  protected String getDefaultTemplate()
  {
    return TEMPLATE_CLOSE;
  }

  public void evaluateExtraParams()
  {
    super.evaluateExtraParams();

    if (resizable != null) addParameter("resizable", findValue(resizable, Boolean.class));
    if (resizableAnimate != null) addParameter("resizableAnimate", findValue(resizableAnimate, Boolean.class));
    if (resizableAnimateDuration != null) addParameter("resizableAnimateDuration", findString(resizableAnimateDuration));
    if (resizableAnimateEasing != null) addParameter("resizableAnimateEasing", findString(resizableAnimateEasing));
    if (resizableAspectRatio != null) addParameter("resizableAspectRatio", findValue(resizableAspectRatio, Boolean.class));
    if (resizableAutoHide != null) addParameter("resizableAutoHide", findValue(resizableAutoHide, Boolean.class));
    if (resizableContainment != null) addParameter("resizableContainment", findString(resizableContainment));
    if (resizableDelay != null) addParameter("resizableDelay", findString(resizableDelay));
    if (resizableDistance != null) addParameter("resizableDistance", findString(resizableDistance));
    if (resizableGhost != null) addParameter("resizableGhost", findValue(resizableGhost, Boolean.class));
    if (resizableHelper != null) addParameter("resizableHelper", findString(resizableHelper));
    if (resizableMaxHeight != null) addParameter("resizableMaxHeight", findString(resizableMaxHeight));
    if (resizableMaxWidth != null) addParameter("resizableMaxWidth", findString(resizableMaxWidth));
    if (resizableMinHeight != null) addParameter("resizableMinHeight", findString(resizableMinHeight));
    if (resizableMinWidth != null) addParameter("resizableMinWidth", findString(resizableMinWidth));
    if (resizableResize != null) addParameter("resizableResize", findString(resizableResize));
    if (resizableStart != null) addParameter("resizableStart", findString(resizableStart));
    if (resizableStop != null) addParameter("resizableStop", findString(resizableStop));
    if (resizableHandles != null) addParameter("resizableHandles", findString(resizableHandles));

    if (droppable != null) addParameter("droppable", findValue(droppable, Boolean.class));
    if (droppableAccept != null) addParameter("droppableAccept", findString(droppableAccept));
    if (droppableActiveClass != null) addParameter("droppableActiveClass", findString(droppableActiveClass));
    if (droppableAddClasses != null) addParameter("droppableAddClasses", findValue(droppableAddClasses, Boolean.class));
    if (droppableGreedy != null) addParameter("droppableGreedy", findValue(droppableGreedy, Boolean.class));
    if (droppableHoverClass != null) addParameter("droppableHoverClass", findString(droppableHoverClass));
    if (droppableScope != null) addParameter("droppableScope", findString(droppableScope));
    if (droppableTolerance != null) addParameter("droppableTolerance", findString(droppableTolerance));
    if (droppableActivate != null) addParameter("droppableActivate", findString(droppableActivate));
    if (droppableDeactivate != null) addParameter("droppableDeactivate", findString(droppableDeactivate));
    if (droppableOver != null) addParameter("droppableOver", findString(droppableOver));
    if (droppableOut != null) addParameter("droppableOut", findString(droppableOut));
    if (droppableDrop != null) addParameter("droppableDrop", findString(droppableDrop));

    if (draggable != null) addParameter("draggable", findValue(draggable, Boolean.class));
    if (draggableAddClasses != null) addParameter("draggableAddClasses", findValue(draggableAddClasses, Boolean.class));
    if (draggableAppendTo != null) addParameter("draggableAppendTo", findString(draggableAppendTo));
    if (draggableAxis != null) addParameter("draggableAxis", findString(draggableAxis));
    if (draggableCancel != null) addParameter("draggableCancel", findString(draggableCancel));
    if (draggableContainment != null) addParameter("draggableContainment", findString(draggableContainment));
    if (draggableDelay != null) addParameter("draggableDelay", findString(draggableDelay));
    if (draggableDistance != null) addParameter("draggableDistance", findString(draggableDistance));
    if (draggableDrag != null) addParameter("draggableDrag", findString(draggableDrag));
    if (draggableHandle != null) addParameter("draggableHandle", findString(draggableHandle));
    if (draggableHelper != null) addParameter("draggableHelper", findString(draggableHelper));
    if (draggableIframeFix != null) addParameter("draggableIframeFix", findString(draggableIframeFix));
    if (draggableOpacity != null) addParameter("draggableOpacity", findString(draggableOpacity));
    if (draggableRefreshPositions != null) addParameter("draggableRefreshPositions", findValue(draggableRefreshPositions, Boolean.class));
    if (draggableRevert != null) addParameter("draggableRevert", findString(draggableRevert));
    if (draggableRevertDuration != null) addParameter("draggableRevertDuration", findString(draggableRevertDuration));
    if (draggableScope != null) addParameter("draggableScope", findString(draggableScope));
    if (draggableScroll != null) addParameter("draggableScroll", findValue(draggableScroll, Boolean.class));
    if (draggableScrollSensitivity != null) addParameter("draggableScrollSensitivity", findString(draggableScrollSensitivity));
    if (draggableScrollSpeed != null) addParameter("draggableScrollSpeed", findString(draggableScrollSpeed));
    if (draggableSnap != null) addParameter("draggableSnap", findValue(draggableSnap, Boolean.class));
    if (draggableSnapMode != null) addParameter("draggableSnapMode", findString(draggableSnapMode));
    if (draggableSnapTolerance != null) addParameter("draggableSnapTolerance", findString(draggableSnapTolerance));
    if (draggableStart != null) addParameter("draggableStart", findString(draggableStart));
    if (draggableStop != null) addParameter("draggableStop", findString(draggableStop));
    if (draggableZindex != null) addParameter("draggableZindex", findString(draggableZindex));

    if ((this.id == null || this.id.length() == 0))
    {
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
  public void setTheme(String theme)
  {
    super.setTheme(theme);
  }

  @Override
  public String getTheme()
  {
    return "jquery";
  }

  @StrutsTagAttribute(description = "Enable this div element to be resizable. With the cursor grab the right or bottom border and drag to the desired width or height.", type = "Boolean")
  public void setResizable(String resizable)
  {
    this.resizable = resizable;
  }

  @StrutsTagAttribute(description = "Animates to the final size after resizing. Default: false", type = "Boolean")
  public void setResizableAnimate(String animate)
  {
    this.resizableAnimate = animate;
  }

  @StrutsTagAttribute(description = "Duration time for animating, in milliseconds.")
  public void setResizableAnimateDuration(String animateDuration)
  {
    this.resizableAnimateDuration = animateDuration;
  }

  @StrutsTagAttribute(description = "Easing effect for animating. Default: swing")
  public void setResizableAnimateEasing(String animateEasing)
  {
    this.resizableAnimateEasing = animateEasing;
  }

  @StrutsTagAttribute(description = "If set to true, resizing is constrained by the original aspect ratio. Default: false", type = "Boolean")
  public void setResizableAspectRatio(String aspectRatio)
  {
    this.resizableAspectRatio = aspectRatio;
  }

  @StrutsTagAttribute(description = "If set to true, automatically hides the handles except when the mouse hovers over the element. Default: false", type = "Boolean")
  public void setResizableAutoHide(String autoHide)
  {
    this.resizableAutoHide = autoHide;
  }

  @StrutsTagAttribute(description = "Constrains resizing to within the bounds of the specified element. Possible values: 'parent', 'document' or an id")
  public void setResizableContainment(String containment)
  {
    this.resizableContainment = containment;
  }

  @StrutsTagAttribute(description = "Tolerance, in milliseconds, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond duration. This can help prevent unintended resizing when clicking on an element.")
  public void setResizableDelay(String delay)
  {
    this.resizableDelay = delay;
  }

  @StrutsTagAttribute(description = "Tolerance, in pixels, for when resizing should start. If specified, resizing will not start until after mouse is moved beyond distance. This can help prevent unintended resizing when clicking on an element.")
  public void setResizableDistance(String distance)
  {
    this.resizableDistance = distance;
  }

  @StrutsTagAttribute(description = "If set to true, a semi-transparent helper element is shown for resizing. Default: false", type = "Boolean")
  public void setResizableGhost(String ghost)
  {
    this.resizableGhost = ghost;
  }

  @StrutsTagAttribute(description = "This is the css class that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized. e.g. ui-state-highlight")
  public void setResizableHelper(String helper)
  {
    this.resizableHelper = helper;
  }

  @StrutsTagAttribute(description = "This is the maximum height the resizable should be allowed to resize to.")
  public void setResizableMaxHeight(String maxHeight)
  {
    this.resizableMaxHeight = maxHeight;
  }

  @StrutsTagAttribute(description = "This is the maximum width the resizable should be allowed to resize to.")
  public void setResizableMaxWidth(String maxWidth)
  {
    this.resizableMaxWidth = maxWidth;
  }

  @StrutsTagAttribute(description = "This is the minimum height the resizable should be allowed to resize to.")
  public void setResizableMinHeight(String minHeight)
  {
    this.resizableMinHeight = minHeight;
  }

  @StrutsTagAttribute(description = "This is the minimum width the resizable should be allowed to resize to.")
  public void setResizableMinWidth(String minWidth)
  {
    this.resizableMinWidth = minWidth;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered during the resize, on the drag of the resize handler.")
  public void setResizableResize(String resize)
  {
    this.resizableResize = resize;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered at the start of a resize operation.")
  public void setResizableStart(String start)
  {
    this.resizableStart = start;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered at the end of a resize operation.")
  public void setResizableStop(String stop)
  {
    this.resizableStop = stop;
  }

  @StrutsTagAttribute(description = "If specified as a string, should be a comma-split list of any of the following: 'n, e, s, w, ne, se, sw, nw, all'. Default: e, s, se")
  public void setResizableHandles(String handles)
  {
    this.resizableHandles = handles;
  }

  @StrutsTagAttribute(description = "Enable any DIV element to be droppable, a target for draggable elements.", type = "Boolean")
  public void setDroppable(String droppable)
  {
    this.droppable = droppable;
  }

  @StrutsTagAttribute(description = "All draggables that match the jQuery selector will be accepted. e.g. #myid or .myclass")
  public void setDroppableAccept(String droppableAccept)
  {
    this.droppableAccept = droppableAccept;
  }

  @StrutsTagAttribute(description = "If specified, the class will be added to the droppable while an acceptable draggable is being dragged.")
  public void setDroppableActiveClass(String droppableActiveClass)
  {
    this.droppableActiveClass = droppableActiveClass;
  }

  @StrutsTagAttribute(description = "If set to false, will prevent the ui-droppable class from being added. This may be desired as a performance optimization when calling droppable init on many hundreds of elements. Default: true", defaultValue = "true", type = "Boolean")
  public void setDroppableAddClasses(String droppableAddClasses)
  {
    this.droppableAddClasses = droppableAddClasses;
  }

  @StrutsTagAttribute(description = "If true, will prevent event propagation on nested droppables. Default: false", defaultValue = "false", type = "Boolean")
  public void setDroppableGreedy(String droppableGreedy)
  {
    this.droppableGreedy = droppableGreedy;
  }

  @StrutsTagAttribute(description = "If specified, the class will be added to the droppable while an acceptable draggable is being hovered.")
  public void setDroppableHoverClass(String droppableHoverClass)
  {
    this.droppableHoverClass = droppableHoverClass;
  }

  @StrutsTagAttribute(description = "Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted.")
  public void setDroppableScope(String droppableScope)
  {
    this.droppableScope = droppableScope;
  }

  @StrutsTagAttribute(description = "Specifies which mode to use for testing whether a draggable is over a droppable. Possible values: fit, intersect, pointer, touch. ")
  public void setDroppableTolerance(String droppableTolerance)
  {
    this.droppableTolerance = droppableTolerance;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered any time an accepted draggable starts dragging. This can be useful if you want to make the droppable 'light up' when it can be dropped on.")
  public void setDroppableActivate(String droppableActivate)
  {
    this.droppableActivate = droppableActivate;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered any time an accepted draggable stops dragging.")
  public void setDroppableDeactivate(String droppableDeactivate)
  {
    this.droppableDeactivate = droppableDeactivate;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when an accepted draggable is dropped 'over' this droppable.")
  public void setDroppableDrop(String droppableDrop)
  {
    this.droppableDrop = droppableDrop;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when an accepted draggable is dragged 'out' this droppable.")
  public void setDroppableOut(String droppableOut)
  {
    this.droppableOut = droppableOut;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered as an accepted draggable is dragged 'over' this droppable.")
  public void setDroppableOver(String droppableOver)
  {
    this.droppableOver = droppableOver;
  }

  @StrutsTagAttribute(description = "Enable draggable functionality to the DIV element. Move the draggable object by clicking on it with the mouse and dragging it anywhere within the viewport. ", type = "Boolean")
  public void setDraggable(String draggable)
  {
    this.draggable = draggable;
  }

  @StrutsTagAttribute(description = "If set to false, will prevent the ui-draggable class from being added. This may be desired as a performance optimization when calling draggable init on many hundreds of elements. Default: true", type = "Boolean")
  public void setDraggableAddClasses(String draggableAddClasses)
  {
    this.draggableAddClasses = draggableAddClasses;
  }

  @StrutsTagAttribute(description = "The element passed to or selected by the appendTo option will be used as the draggable helper's container during dragging. By default, the helper is appended to the same container as the draggable. Default: parent")
  public void setDraggableAppendTo(String draggableAppendTo)
  {
    this.draggableAppendTo = draggableAppendTo;
  }

  @StrutsTagAttribute(description = "Constrains dragging to either the horizontal (x) or vertical (y) axis. Possible values: x or y.")
  public void setDraggableAxis(String draggableAxis)
  {
    this.draggableAxis = draggableAxis;
  }

  @StrutsTagAttribute(description = "Prevents dragging from starting on specified elements.")
  public void setDraggableCancel(String draggableCancel)
  {
    this.draggableCancel = draggableCancel;
  }

  @StrutsTagAttribute(description = "Constrains dragging to within the bounds of the specified element or region. Possible string values: parent, document, window, [x1, y1, x2, y2].")
  public void setDraggableContainment(String draggableContainment)
  {
    this.draggableContainment = draggableContainment;
  }

  @StrutsTagAttribute(description = "Time in milliseconds after mousedown until dragging should start. This option can be used to prevent unwanted drags when clicking on an element.")
  public void setDraggableDelay(String draggableDelay)
  {
    this.draggableDelay = draggableDelay;
  }

  @StrutsTagAttribute(description = "Distance in pixels after mousedown the mouse must move before dragging should start. This option can be used to prevent unwanted drags when clicking on an element.")
  public void setDraggableDistance(String draggableDistance)
  {
    this.draggableDistance = draggableDistance;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when the mouse is moved during the dragging.")
  public void setDraggableDrag(String draggableDrag)
  {
    this.draggableDrag = draggableDrag;
  }

  @StrutsTagAttribute(description = "If specified, restricts drag start click to the specified element(s). e.g. h2")
  public void setDraggableHandle(String draggableHandle)
  {
    this.draggableHandle = draggableHandle;
  }

  @StrutsTagAttribute(description = "Allows for a helper element to be used for dragging display. Possible values: original, clone. Default is original")
  public void setDraggableHelper(String draggableHelper)
  {
    this.draggableHelper = draggableHelper;
  }

  @StrutsTagAttribute(description = "Prevent iframes from capturing the mousemove events during a drag. Useful in combination with cursorAt, or in any case, if the mouse cursor is not over the helper. If set to true, transparent overlays will be placed over all iframes on the page. If a selector is supplied, the matched iframes will have an overlay placed over them. Default: false", type = "Boolean")
  public void setDraggableIframeFix(String draggableIframeFix)
  {
    this.draggableIframeFix = draggableIframeFix;
  }

  @StrutsTagAttribute(description = "Opacity for the helper while being dragged. e.g. 0.75")
  public void setDraggableOpacity(String draggableOpacity)
  {
    this.draggableOpacity = draggableOpacity;
  }

  @StrutsTagAttribute(description = "If set to true, all droppable positions are calculated on every mousemove. Caution: This solves issues on highly dynamic pages, but dramatically decreases performance. Default: false", type = "Boolean")
  public void setDraggableRefreshPositions(String draggableRefreshPositions)
  {
    this.draggableRefreshPositions = draggableRefreshPositions;
  }

  @StrutsTagAttribute(description = "If set to true, the element will return to its start position when dragging stops. e.g. true, valid, invalid Default: false")
  public void setDraggableRevert(String draggableRevert)
  {
    this.draggableRevert = draggableRevert;
  }

  @StrutsTagAttribute(description = "The duration of the revert animation, in milliseconds. Ignored if revert is false.")
  public void setDraggableRevertDuration(String draggableRevertDuration)
  {
    this.draggableRevertDuration = draggableRevertDuration;
  }

  @StrutsTagAttribute(description = "Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.")
  public void setDraggableScope(String draggableScope)
  {
    this.draggableScope = draggableScope;
  }

  @StrutsTagAttribute(description = "If set to true, container auto-scrolls while dragging.", type = "Boolean")
  public void setDraggableScroll(String draggableScroll)
  {
    this.draggableScroll = draggableScroll;
  }

  @StrutsTagAttribute(description = "Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not the draggable. Default: 20")
  public void setDraggableScrollSensitivity(String draggableScrollSensitivity)
  {
    this.draggableScrollSensitivity = draggableScrollSensitivity;
  }

  @StrutsTagAttribute(description = "The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Default: 20")
  public void setDraggableScrollSpeed(String draggableScrollSpeed)
  {
    this.draggableScrollSpeed = draggableScrollSpeed;
  }

  @StrutsTagAttribute(description = "If set to true, the draggable will snap to the edges of the selected elements when near an edge of the element. Default: false", type = "Boolean")
  public void setDraggableSnap(String draggableSnap)
  {
    this.draggableSnap = draggableSnap;
  }

  @StrutsTagAttribute(description = "Determines which edges of snap elements the draggable will snap to. Ignored if snap is false. Possible values: inner, outer, both. Default: both")
  public void setDraggableSnapMode(String draggableSnapMode)
  {
    this.draggableSnapMode = draggableSnapMode;
  }

  @StrutsTagAttribute(description = "The distance in pixels from the snap element edges at which snapping should occur. Ignored if snap is false. Default: 20")
  public void setDraggableSnapTolerance(String draggableSnapTolerance)
  {
    this.draggableSnapTolerance = draggableSnapTolerance;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when dragging starts.")
  public void setDraggableStart(String draggableStart)
  {
    this.draggableStart = draggableStart;
  }

  @StrutsTagAttribute(description = "This event javascript function is triggered when dragging stops.")
  public void setDraggableStop(String draggableStop)
  {
    this.draggableStop = draggableStop;
  }

  @StrutsTagAttribute(description = "z-index for the helper while being dragged.")
  public void setDraggableZindex(String draggableZindex)
  {
    this.draggableZindex = draggableZindex;
  }
}
