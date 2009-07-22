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
public class Div extends AbstractRemoteBean implements RemoteBean, ResizableBean, DroppableBean, DraggableBean, SelectableBean {

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
  protected String                      selectable;
  protected String                      selectableAutoRefresh;
  protected String                      selectableCancel;
  protected String                      selectableDelay;
  protected String                      selectableFilter;
  protected String                      selectableSelected;
  protected String                      selectableSelecting;
  protected String                      selectableStart;
  protected String                      selectableStop;
  protected String                      selectableDistance;
  protected String                      selectableTolerance;
  protected String                      selectableUnselected;
  protected String                      selectableUnselecting;
  protected String                      sortableZindex;
  protected String                      sortableUpdate;
  protected String                      sortableTolerance;
  protected String                      sortableStop;
  protected String                      sortableStart;
  protected String                      sortableSort;
  protected String                      sortableScrollSpeed;
  protected String                      sortableScrollSensitivity;
  protected String                      sortableScroll;
  protected String                      sortableRevert;
  protected String                      sortableRemove;
  protected String                      sortableReceive;
  protected String                      sortablePlaceholder;
  protected String                      sortableOver;
  protected String                      sortableOut;
  protected String                      sortableOpacity;
  protected String                      sortableItems;
  protected String                      sortableHelper;
  protected String                      sortableHandle;
  protected String                      sortableGrid;
  protected String                      sortableForcePlaceholderSize;
  protected String                      sortableForceHelperSize;
  protected String                      sortableDropOnEmpty;
  protected String                      sortableDistance;
  protected String                      sortableDelay;
  protected String                      sortableDeactivate;
  protected String                      sortableCursorAt;
  protected String                      sortableCursor;
  protected String                      sortableContainment;
  protected String                      sortableConnectWith;
  protected String                      sortableChange;
  protected String                      sortableCancel;
  protected String                      sortableBeforeStop;
  protected String                      sortableAxis;
  protected String                      sortableAppendTo;
  protected String                      sortableActivate;
  protected String                      sortable;

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

    if (selectable != null) addParameter("selectable", findValue(selectable, Boolean.class));
    if (selectableCancel != null) addParameter("selectableCancel", findString(selectableCancel));
    if (selectableDelay != null) addParameter("selectableDelay", findString(selectableDelay));
    if (selectableDistance != null) addParameter("selectableDistance", findString(selectableDistance));
    if (selectableFilter != null) addParameter("selectableFilter", findString(selectableFilter));
    if (selectableSelected != null) addParameter("selectableSelected", findString(selectableSelected));
    if (selectableSelecting != null) addParameter("selectableSelecting", findString(selectableSelecting));
    if (selectableStart != null) addParameter("selectableStart", findString(selectableStart));
    if (selectableStop != null) addParameter("selectableStop", findString(selectableStop));
    if (selectableTolerance != null) addParameter("selectableTolerance", findString(selectableTolerance));
    if (selectableUnselected != null) addParameter("selectableUnselected", findString(selectableUnselected));
    if (selectableUnselecting != null) addParameter("selectableUnselecting", findString(selectableUnselecting));


    if (sortable != null) addParameter("sortable", findValue(sortable, Boolean.class));
    if (sortableActivate != null) addParameter("sortableActivate", findString(sortableActivate));
    if (sortableAppendTo != null) addParameter("sortableAppendTo", findString(sortableAppendTo));
    if (sortableAxis != null) addParameter("sortableAxis", findString(sortableAxis));
    if (sortableBeforeStop != null) addParameter("sortableBeforeStop", findString(sortableBeforeStop));
    if (sortableCancel != null) addParameter("sortableCancel", findString(sortableCancel));
    if (sortableChange != null) addParameter("sortableChange", findString(sortableChange));
    if (sortableConnectWith != null) addParameter("sortableConnectWith", findString(sortableConnectWith));
    if (sortableContainment != null) addParameter("sortableContainment", findString(sortableContainment));
    if (sortableCursor != null) addParameter("sortableCursor", findString(sortableCursor));
    if (sortableCursorAt != null) addParameter("sortableCursorAt", findString(sortableCursorAt));
    if (sortableDeactivate != null) addParameter("sortableDeactivate", findString(sortableDeactivate));
    if (sortableDelay != null) addParameter("sortableDelay", findString(sortableDelay));
    if (sortableDistance != null) addParameter("sortableDistance", findString(sortableDistance));
    if (sortableDropOnEmpty != null) addParameter("sortableDropOnEmpty", findValue(sortableDropOnEmpty, Boolean.class));
    if (sortableForceHelperSize != null) addParameter("sortableForceHelperSize", findValue(sortableForceHelperSize, Boolean.class));
    if (sortableForcePlaceholderSize != null) addParameter("sortableForcePlaceholderSize", findValue(sortableForcePlaceholderSize, Boolean.class));
    if (sortableGrid != null) addParameter("sortableGrid", findString(sortableGrid));
    if (sortableHandle != null) addParameter("sortableHandle", findString(sortableHandle));
    if (sortableItems != null) addParameter("sortableItems", findString(sortableItems));
    if (sortableOpacity != null) addParameter("sortableOpacity", findString(sortableOpacity));
    if (sortableOut != null) addParameter("sortableOut", findString(sortableOut));
    if (sortableOver != null) addParameter("sortableOver", findString(sortableOver));
    if (sortablePlaceholder != null) addParameter("sortablePlaceholder", findString(sortablePlaceholder));
    if (sortableReceive != null) addParameter("sortableReceive", findString(sortableReceive));
    if (sortableRemove != null) addParameter("sortableRemove", findString(sortableRemove));
    if (sortableRevert != null) addParameter("sortableRevert", findValue(sortableRevert, Boolean.class));
    if (sortableScroll != null) addParameter("sortableScroll", findValue(sortableScroll, Boolean.class));
    if (sortableScrollSensitivity != null) addParameter("sortableScrollSensitivity", findString(sortableScrollSensitivity));
    if (sortableScrollSpeed != null) addParameter("sortableScrollSpeed", findString(sortableScrollSpeed));
    if (sortableSort != null) addParameter("sortableSort", findString(sortableSort));
    if (sortableStart != null) addParameter("sortableStart", findString(sortableStart));
    if (sortableStop != null) addParameter("sortableStop", findString(sortableStop));
    if (sortableTolerance != null) addParameter("sortableTolerance", findString(sortableTolerance));
    if (sortableUpdate != null) addParameter("sortableUpdate", findString(sortableUpdate));
    if (sortableZindex != null) addParameter("sortableZindex", findString(sortableZindex));

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

  @StrutsTagAttribute(description = "Enable a element to be selectable. Draw a box with your cursor to select items. Hold down the Ctrl key to make multiple non-adjacent selections.", type = "Boolean")
  public void setSelectable(String selectable)
  {
    this.selectable = selectable;
  }

  @StrutsTagAttribute(description = "This determines whether to refresh (recalculate) the position and size of each selectee at the beginning of each select operation. If you have many many items, you may want to set this to false and call the refresh method manually. Default: true")
  public void setSelectableAutoRefresh(String selectableAutoRefresh)
  {
    this.selectableAutoRefresh = selectableAutoRefresh;
  }

  @StrutsTagAttribute(description = "Prevents selecting if you start on elements matching the selector. Default: ':input,option'")
  public void setSelectableCancel(String selectableCancel)
  {
    this.selectableCancel = selectableCancel;
  }

  @StrutsTagAttribute(description = "Time in milliseconds to define when the selecting should start. It helps preventing unwanted selections when clicking on an element.")
  public void setSelectableDelay(String selectableDelay)
  {
    this.selectableDelay = selectableDelay;
  }
  
  @StrutsTagAttribute(description = "Tolerance, in pixels, for when selecting should start. If specified, selecting will not start until after mouse is dragged beyond distance.")
  public void setSelectableDistance(String selectableDistance)
  {
    this.selectableDistance = selectableDistance;
  }

  @StrutsTagAttribute(description = "The matching child elements will be made selectees (able to be selected). Default: '*'")
  public void setSelectableFilter(String selectableFilter)
  {
    this.selectableFilter = selectableFilter;
  }

  @StrutsTagAttribute(description = "This event is triggered at the end of the select operation, on each element added to the selection.")
  public void setSelectableSelected(String selectableSelected)
  {
    this.selectableSelected = selectableSelected;
  }

  @StrutsTagAttribute(description = "This event is triggered during the select operation, on each element added to the selection.")
  public void setSelectableSelecting(String selectableSelecting)
  {
    this.selectableSelecting = selectableSelecting;
  }

  @StrutsTagAttribute(description = "This event is triggered at the beginning of the select operation.")
  public void setSelectableStart(String selectableStart)
  {
    this.selectableStart = selectableStart;
  }

  @StrutsTagAttribute(description = "This event is triggered at the end of the select operation.")
  public void setSelectableStop(String selectableStop)
  {
    this.selectableStop = selectableStop;
  }

  @StrutsTagAttribute(description = "Possible values: 'touch', 'fit'. Default: 'touch'")
  public void setSelectableTolerance(String selectableTolerance)
  {
    this.selectableTolerance = selectableTolerance;
  }

  @StrutsTagAttribute(description = "This event is triggered at the end of the select operation, on each element removed from the selection.")
  public void setSelectableUnselected(String selectableUnselected)
  {
    this.selectableUnselected = selectableUnselected;
  }

  @StrutsTagAttribute(description = "This event is triggered during the select operation, on each element removed from the selection.")
  public void setSelectableUnselecting(String selectableUnselecting)
  {
    this.selectableUnselecting = selectableUnselecting;
  }

  @StrutsTagAttribute(description = "Enable a elements to be sortable", type = "Boolean")
  public void setSortable(String sortable)
  {
    this.sortable = sortable;
  }

  @StrutsTagAttribute(description = "This event is triggered when using connected lists, every connected list on drag start receives it.")
  public void setSortableActivate(String sortableActivate)
  {
    this.sortableActivate = sortableActivate;
  }

  @StrutsTagAttribute(description = "Defines where the helper that moves with the mouse is being appended to during the drag. Default: 'parent'")
  public void setSortableAppendTo(String sortableAppendTo)
  {
    this.sortableAppendTo = sortableAppendTo;
  }

  @StrutsTagAttribute(description = "If defined, the items can be dragged only horizontally or vertically. Possible values:'x', 'y'.")
  public void setSortableAxis(String sortableAxis)
  {
    this.sortableAxis = sortableAxis;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting stops, but when the placeholder/helper is still available.")
  public void setSortableBeforeStop(String sortableBeforeStop)
  {
    this.sortableBeforeStop = sortableBeforeStop;
  }

  @StrutsTagAttribute(description = "Prevents sorting if you start on elements matching the selector. Default: ':input,button'")
  public void setSortableCancel(String sortableCancel)
  {
    this.sortableCancel = sortableCancel;
  }

  @StrutsTagAttribute(description = "This event is triggered during sorting, but only when the DOM position has changed.")
  public void setSortableChange(String sortableChange)
  {
    this.sortableChange = sortableChange;
  }

  @StrutsTagAttribute(description = "Takes a jQuery selector with items that also have sortables applied. If used, the sortable is now connected to the other one-way, so you can drag from this sortable to the other. e.g. #myothersortable or .myothersortables")
  public void setSortableConnectWith(String sortableConnectWith)
  {
    this.sortableConnectWith = sortableConnectWith;
  }

  @StrutsTagAttribute(description = "Constrains dragging to within the bounds of the specified element - can be a DOM element, 'parent', 'document', 'window', or a jQuery selector.")
  public void setSortableContainment(String sortableContainment)
  {
    this.sortableContainment = sortableContainment;
  }

  @StrutsTagAttribute(description = "Defines the cursor that is being shown while sorting.")
  public void setSortableCursor(String sortableCursor)
  {
    this.sortableCursor = sortableCursor;
  }

  @StrutsTagAttribute(description = "Moves the sorting element or helper so the cursor always appears to drag from the same position. Coordinates can be given as a hash using a combination of one or two keys: top, left, right, bottom.")
  public void setSortableCursorAt(String sortableCursorAt)
  {
    this.sortableCursorAt = sortableCursorAt;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting was stopped, is propagated to all possible connected lists.")
  public void setSortableDeactivate(String sortableDeactivate)
  {
    this.sortableDeactivate = sortableDeactivate;
  }

  @StrutsTagAttribute(description = "Time in milliseconds to define when the sorting should start. It helps preventing unwanted drags when clicking on an element.")
  public void setSortableDelay(String sortableDelay)
  {
    this.sortableDelay = sortableDelay;
  }

  @StrutsTagAttribute(description = "Tolerance, in pixels, for when sorting should start. If specified, sorting will not start until after mouse is dragged beyond distance. Can be used to allow for clicks on elements within a handle.")
  public void setSortableDistance(String sortableDistance)
  {
    this.sortableDistance = sortableDistance;
  }

  @StrutsTagAttribute(description = "If empty allows for an item to be dropped from a linked selectable. Default: true", type = "Boolean")
  public void setSortableDropOnEmpty(String sortableDropOnEmpty)
  {
    this.sortableDropOnEmpty = sortableDropOnEmpty;
  }

  @StrutsTagAttribute(description = "If true, forces the helper to have a size. Default: false", type = "Boolean")
  public void setSortableForceHelperSize(String sortableForceHelperSize)
  {
    this.sortableForceHelperSize = sortableForceHelperSize;
  }

  @StrutsTagAttribute(description = "If true, forces the placeholder to have a size. Default: false", type = "Boolean")
  public void setSortableForcePlaceholderSize(String sortableForcePlaceholderSize)
  {
    this.sortableForcePlaceholderSize = sortableForcePlaceholderSize;
  }

  @StrutsTagAttribute(description = "Snaps the sorting element or helper to a grid, every x and y pixels. Array values: [x, y]")
  public void setSortableGrid(String sortableGrid)
  {
    this.sortableGrid = sortableGrid;
  }

  @StrutsTagAttribute(description = "Restricts sort start click to the specified element.")
  public void setSortableHandle(String sortableHandle)
  {
    this.sortableHandle = sortableHandle;
  }

  @StrutsTagAttribute(description = "Allows for a helper element to be used for dragging display. The supplied function receives the event and the element being sorted, and should return a DOMElement to be used as a custom proxy helper. Possible values: 'original', 'clone'. Default: 'original'")
  public void setSortableHelper(String sortableHelper)
  {
    this.sortableHelper = sortableHelper;
  }

  @StrutsTagAttribute(description = "Specifies which items inside the element should be sortable. Default: '> *'")
  public void setSortableItems(String sortableItems)
  {
    this.sortableItems = sortableItems;
  }

  @StrutsTagAttribute(description = "Defines the opacity of the helper while sorting. From 0.01 to 1")
  public void setSortableOpacity(String sortableOpacity)
  {
    this.sortableOpacity = sortableOpacity;
  }

  @StrutsTagAttribute(description = "This event is triggered when a sortable item is moved away from a connected list.")
  public void setSortableOut(String sortableOut)
  {
    this.sortableOut = sortableOut;
  }

  @StrutsTagAttribute(description = "This event is triggered when a sortable item is moved into a connected list.")
  public void setSortableOver(String sortableOver)
  {
    this.sortableOver = sortableOver;
  }

  @StrutsTagAttribute(description = "Class that gets applied to the otherwise white space.")
  public void setSortablePlaceholder(String sortablePlaceholder)
  {
    this.sortablePlaceholder = sortablePlaceholder;
  }

  @StrutsTagAttribute(description = "This event is triggered when a connected sortable list has received an item from another list.")
  public void setSortableReceive(String sortableReceive)
  {
    this.sortableReceive = sortableReceive;
  }

  @StrutsTagAttribute(description = "This event is triggered when a sortable item has been dragged out from the list and into another.")
  public void setSortableRemove(String sortableRemove)
  {
    this.sortableRemove = sortableRemove;
  }

  @StrutsTagAttribute(description = "If set to true, the item will be reverted to its new DOM position with a smooth animation. Default: false", type = "Boolean")
  public void setSortableRevert(String sortableRevert)
  {
    this.sortableRevert = sortableRevert;
  }

  @StrutsTagAttribute(description = "If set to true, the page scrolls when coming to an edge. Default: true", type = "Boolean")
  public void setSortableScroll(String sortableScroll)
  {
    this.sortableScroll = sortableScroll;
  }

  @StrutsTagAttribute(description = "Defines how near the mouse must be to an edge to start scrolling. Default: 20")
  public void setSortableScrollSensitivity(String sortableScrollSensitivity)
  {
    this.sortableScrollSensitivity = sortableScrollSensitivity;
  }

  @StrutsTagAttribute(description = "The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Default: 20")
  public void setSortableScrollSpeed(String sortableScrollSpeed)
  {
    this.sortableScrollSpeed = sortableScrollSpeed;
  }

  @StrutsTagAttribute(description = "This event is triggered during sorting.")
  public void setSortableSort(String sortableSort)
  {
    this.sortableSort = sortableSort;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting starts.")
  public void setSortableStart(String sortableStart)
  {
    this.sortableStart = sortableStart;
  }

  @StrutsTagAttribute(description = "This event is triggered when sorting has stopped.")
  public void setSortableStop(String sortableStop)
  {
    this.sortableStop = sortableStop;
  }

  @StrutsTagAttribute(description = "This is the way the reordering behaves during drag. Possible values: 'intersect', 'pointer'. In some setups, 'pointer' is more natural. Default: 'intersect'")
  public void setSortableTolerance(String sortableTolerance)
  {
    this.sortableTolerance = sortableTolerance;
  }

  @StrutsTagAttribute(description = "This event is triggered when the user stopped sorting and the DOM position has changed.")
  public void setSortableUpdate(String sortableUpdate)
  {
    this.sortableUpdate = sortableUpdate;
  }

  @StrutsTagAttribute(description = "Z-index for element/helper while being sorted. Default: 1000")
  public void setSortableZindex(String sortableZindex)
  {
    this.sortableZindex = sortableZindex;
  }
}
