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

public class EffectDivTag extends DivTag implements ResizableTag, DraggableTag, DroppableTag {

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
    protected String resizableHandles;
    protected String droppable;
    protected String droppableAccept;
    protected String droppableActiveClass;
    protected String droppableAddClasses;
    protected String droppableGreedy;
    protected String droppableHoverClass;
    protected String droppableScope;
    protected String droppableTolerance;
    protected String droppableActivate;
    protected String droppableDeactivate;
    protected String droppableDrop;
    protected String droppableOut;
    protected String droppableOver;
    protected String draggable;
    protected String draggableAppendTo;
    protected String draggableAxis;
    protected String draggableCancel;
    protected String draggableContainment;
    protected String draggableDelay;
    protected String draggableDistance;
    protected String draggableDrag;
    protected String draggableHandle;
    protected String draggableHelper;
    protected String draggableIframeFix;
    protected String draggableOpacity;
    protected String draggableRefreshPositions;
    protected String draggableRevert;
    protected String draggableRevertDuration;
    protected String draggableScope;
    protected String draggableScroll;
    protected String draggableScrollSensitivity;
    protected String draggableScrollSpeed;
    protected String draggableSnap;
    protected String draggableSnapMode;
    protected String draggableSnapTolerance;
    protected String draggableStart;
    protected String draggableStop;
    protected String draggableZindex;
    protected String draggableAddClasses;

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
        div.setResizableHandles(resizableHandles);
        div.setDroppable(droppable);
        div.setDroppableAccept(droppableAccept);
        div.setDroppableActiveClass(droppableActiveClass);
        div.setDroppableAddClasses(droppableAddClasses);
        div.setDroppableGreedy(droppableGreedy);
        div.setDroppableHoverClass(droppableHoverClass);
        div.setDroppableScope(droppableScope);
        div.setDroppableTolerance(droppableTolerance);
        div.setDroppableActivate(droppableActivate);
        div.setDroppableDeactivate(droppableDeactivate);
        div.setDroppableDrop(droppableDrop);
        div.setDroppableOut(droppableOut);
        div.setDroppableOver(droppableOver);
        div.setDraggable(draggable);
        div.setDraggableAppendTo(draggableAppendTo);
        div.setDraggableAxis(draggableAxis);
        div.setDraggableCancel(draggableCancel);
        div.setDraggableContainment(draggableContainment);
        div.setDraggableDelay(draggableDelay);
        div.setDraggableDistance(draggableDistance);
        div.setDraggableDrag(draggableDrag);
        div.setDraggableHandle(draggableHandle);
        div.setDraggableHelper(draggableHelper);
        div.setDraggableIframeFix(draggableIframeFix);
        div.setDraggableOpacity(draggableOpacity);
        div.setDraggableRefreshPositions(draggableRefreshPositions);
        div.setDraggableRevert(draggableRevert);
        div.setDraggableRevertDuration(draggableRevertDuration);
        div.setDraggableScope(draggableScope);
        div.setDraggableScroll(draggableScroll);
        div.setDraggableScrollSensitivity(draggableScrollSensitivity);
        div.setDraggableScrollSpeed(draggableScrollSpeed);
        div.setDraggableSnap(draggableSnap);
        div.setDraggableSnapMode(draggableSnapMode);
        div.setDraggableSnapTolerance(draggableSnapTolerance);
        div.setDraggableStart(draggableStart);
        div.setDraggableStop(draggableStop);
        div.setDraggableZindex(draggableZindex);
        div.setDraggableAddClasses(draggableAddClasses);
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

    public void setResizableHandles(String resizableHandles)
    {
      this.resizableHandles = resizableHandles;
    }

    public void setDroppable(String droppable)
    {
      this.droppable = droppable;
    }

    public void setDroppableAccept(String droppableAccept)
    {
      this.droppableAccept = droppableAccept;
    }

    public void setDroppableActiveClass(String droppableActiveClass)
    {
      this.droppableActiveClass = droppableActiveClass;
    }

    public void setDroppableAddClasses(String droppableAddClasses)
    {
      this.droppableAddClasses = droppableAddClasses;
    }

    public void setDroppableGreedy(String droppableGreedy)
    {
      this.droppableGreedy = droppableGreedy;
    }

    public void setDroppableHoverClass(String droppableHoverClass)
    {
      this.droppableHoverClass = droppableHoverClass;
    }

    public void setDroppableScope(String droppableScope)
    {
      this.droppableScope = droppableScope;
    }

    public void setDroppableTolerance(String droppableTolerance)
    {
      this.droppableTolerance = droppableTolerance;
    }

    public void setDroppableActivate(String droppableActivate)
    {
      this.droppableActivate = droppableActivate;
    }

    public void setDroppableDeactivate(String droppableDeactivate)
    {
      this.droppableDeactivate = droppableDeactivate;
    }

    public void setDroppableDrop(String droppableDrop)
    {
      this.droppableDrop = droppableDrop;
    }

    public void setDroppableOut(String droppableOut)
    {
      this.droppableOut = droppableOut;
    }

    public void setDroppableOver(String droppableOver)
    {
      this.droppableOver = droppableOver;
    }

    public void setDraggable(String draggable)
    {
      this.draggable = draggable;
    }

    public void setDraggableAppendTo(String draggableAppendTo)
    {
      this.draggableAppendTo = draggableAppendTo;
    }

    public void setDraggableAxis(String draggableAxis)
    {
      this.draggableAxis = draggableAxis;
    }

    public void setDraggableCancel(String draggableCancel)
    {
      this.draggableCancel = draggableCancel;
    }

    public void setDraggableContainment(String draggableContainment)
    {
      this.draggableContainment = draggableContainment;
    }

    public void setDraggableDelay(String draggableDelay)
    {
      this.draggableDelay = draggableDelay;
    }

    public void setDraggableDistance(String draggableDistance)
    {
      this.draggableDistance = draggableDistance;
    }

    public void setDraggableDrag(String draggableDrag)
    {
      this.draggableDrag = draggableDrag;
    }

    public void setDraggableHandle(String draggableHandle)
    {
      this.draggableHandle = draggableHandle;
    }

    public void setDraggableHelper(String draggableHelper)
    {
      this.draggableHelper = draggableHelper;
    }

    public void setDraggableIframeFix(String draggableIframeFix)
    {
      this.draggableIframeFix = draggableIframeFix;
    }

    public void setDraggableOpacity(String draggableOpacity)
    {
      this.draggableOpacity = draggableOpacity;
    }

    public void setDraggableRefreshPositions(String draggableRefreshPositions)
    {
      this.draggableRefreshPositions = draggableRefreshPositions;
    }

    public void setDraggableRevert(String draggableRevert)
    {
      this.draggableRevert = draggableRevert;
    }

    public void setDraggableRevertDuration(String draggableRevertDuration)
    {
      this.draggableRevertDuration = draggableRevertDuration;
    }

    public void setDraggableScope(String draggableScope)
    {
      this.draggableScope = draggableScope;
    }

    public void setDraggableScroll(String draggableScroll)
    {
      this.draggableScroll = draggableScroll;
    }

    public void setDraggableScrollSensitivity(String draggableScrollSensitivity)
    {
      this.draggableScrollSensitivity = draggableScrollSensitivity;
    }

    public void setDraggableScrollSpeed(String draggableScrollSpeed)
    {
      this.draggableScrollSpeed = draggableScrollSpeed;
    }

    public void setDraggableSnap(String draggableSnap)
    {
      this.draggableSnap = draggableSnap;
    }

    public void setDraggableSnapMode(String draggableSnapMode)
    {
      this.draggableSnapMode = draggableSnapMode;
    }

    public void setDraggableSnapTolerance(String draggableSnapTolerance)
    {
      this.draggableSnapTolerance = draggableSnapTolerance;
    }

    public void setDraggableStart(String draggableStart)
    {
      this.draggableStart = draggableStart;
    }

    public void setDraggableStop(String draggableStop)
    {
      this.draggableStop = draggableStop;
    }

    public void setDraggableZindex(String draggableZindex)
    {
      this.draggableZindex = draggableZindex;
    }

    public void setDraggableAddClasses(String draggableAddClasses)
    {
      this.draggableAddClasses = draggableAddClasses;
    }
}
