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

import com.jgeppert.struts2.jquery.components.Div;
import com.opensymphony.xwork2.util.ValueStack;

public class DivTag extends AbstractRemoteTag implements ResizableTag, DraggableTag, DroppableTag, SelectableTag {

    private static final long serialVersionUID = 3769231035916461758L;
    
    protected String reloadTopics;      //topics that will cause container to reload
    protected String bindOn;
    protected String events;

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
    protected String selectable;
    protected String selectableAutoRefresh;
    protected String selectableCancel;
    protected String selectableDelay;
    protected String selectableFilter;
    protected String selectableSelected;
    protected String selectableSelecting;
    protected String selectableStart;
    protected String selectableStop;
    protected String selectableDistance;
    protected String selectableTolerance;
    protected String selectableUnselected;
    protected String selectableUnselecting;
    protected String sortableZindex;
    protected String sortableUpdate;
    protected String sortableTolerance;
    protected String sortableStop;
    protected String sortableStart;
    protected String sortableSort;
    protected String sortableScrollSpeed;
    protected String sortableScrollSensitivity;
    protected String sortableScroll;
    protected String sortableRevert;
    protected String sortableRemove;
    protected String sortableReceive;
    protected String sortablePlaceholder;
    protected String sortableOver;
    protected String sortableOut;
    protected String sortableOpacity;
    protected String sortableItems;
    protected String sortableHelper;
    protected String sortableHandle;
    protected String sortableGrid;
    protected String sortableForcePlaceholderSize;
    protected String sortableForceHelperSize;
    protected String sortableDropOnEmpty;
    protected String sortableDistance;
    protected String sortableDelay;
    protected String sortableDeactivate;
    protected String sortableCursorAt;
    protected String sortableCursor;
    protected String sortableContainment;
    protected String sortableConnectWith;
    protected String sortableChange;
    protected String sortableCancel;
    protected String sortableBeforeStop;
    protected String sortableAxis;
    protected String sortableAppendTo;
    protected String sortableActivate;
    protected String sortable;

    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Div(stack, req, res);
    }

    protected void populateParams() {
        super.populateParams();

        Div div = (Div) component;
        
        div.setReloadTopics(reloadTopics);
        div.setBindOn(bindOn);
        div.setEvents(events);
        
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
        div.setDroppableTolerance(droppableActivate);
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
        div.setSelectable(selectable);
        div.setSelectableAutoRefresh(selectableAutoRefresh);
        div.setSelectableCancel(selectableCancel);
        div.setSelectableDelay(selectableDelay);
        div.setSelectableDistance(selectableDistance);
        div.setSelectableFilter(selectableFilter);
        div.setSelectableSelected(selectableSelected);
        div.setSelectableSelecting(selectableSelecting);
        div.setSelectableStart(selectableStart);
        div.setSelectableStop(selectableStop);
        div.setSelectableTolerance(selectableTolerance);
        div.setSelectableUnselected(selectableUnselected);
        div.setSelectableUnselecting(selectableUnselecting);

        div.setSortable(sortable);
        div.setSortableActivate(sortableActivate);
        div.setSortableAppendTo(sortableAppendTo);
        div.setSortableAxis(sortableAxis);
        div.setSortableBeforeStop(sortableBeforeStop);
        div.setSortableCancel(sortableCancel);
        div.setSortableChange(sortableChange);
        div.setSortableConnectWith(sortableConnectWith);
        div.setSortableContainment(sortableContainment);
        div.setSortableCursor(sortableCursor);
        div.setSortableCursorAt(sortableCursorAt);
        div.setSortableDeactivate(sortableDeactivate);
        div.setSortableDelay(sortableDelay);
        div.setSortableDistance(sortableDistance);
        div.setSortableDropOnEmpty(sortableDropOnEmpty);
        div.setSortableForceHelperSize(sortableForceHelperSize);
        div.setSortableForcePlaceholderSize(sortableForcePlaceholderSize);
        div.setSortableGrid(sortableGrid);
        div.setSortableHandle(sortableHandle);
        div.setSortableHelper(sortableHelper);
        div.setSortableItems(sortableItems);
        div.setSortableOpacity(sortableOpacity);
        div.setSortableOut(sortableOut);
        div.setSortableOver(sortableOver);
        div.setSortablePlaceholder(sortablePlaceholder);
        div.setSortableReceive(sortableReceive);
        div.setSortableRevert(sortableRevert);
        div.setSortableScroll(sortableScroll);
        div.setSortableScrollSensitivity(sortableScrollSensitivity);
        div.setSortableScrollSpeed(sortableScrollSpeed);
        div.setSortableSort(sortableSort);
        div.setSortableStart(sortableStart);
        div.setSortableStop(sortableStop);
        div.setSortableTolerance(sortableTolerance);
        div.setSortableUpdate(sortableUpdate);
        div.setSortableZindex(sortableZindex);
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

    public void setSelectable(String selectable)
    {
      this.selectable = selectable;
    }

    public void setSelectableAutoRefresh(String selectableAutoRefresh)
    {
      this.selectableAutoRefresh = selectableAutoRefresh;
    }

    public void setSelectableCancel(String selectableCancel)
    {
      this.selectableCancel = selectableCancel;
    }

    public void setSelectableDelay(String selectableDelay)
    {
      this.selectableDelay = selectableDelay;
    }
    
    public void setSelectableDistance(String selectableDistance)
    {
      this.selectableDistance = selectableDistance;
    }

    public void setSelectableFilter(String selectableFilter)
    {
      this.selectableFilter = selectableFilter;
    }

    public void setSelectableSelected(String selectableSelected)
    {
      this.selectableSelected = selectableSelected;
    }

    public void setSelectableSelecting(String selectableSelecting)
    {
      this.selectableSelecting = selectableSelecting;
    }

    public void setSelectableStart(String selectableStart)
    {
      this.selectableStart = selectableStart;
    }

    public void setSelectableStop(String selectableStop)
    {
      this.selectableStop = selectableStop;
    }

    public void setSelectableTolerance(String selectableTolerance)
    {
      this.selectableTolerance = selectableTolerance;
    }

    public void setSelectableUnselected(String selectableUnselected)
    {
      this.selectableUnselected = selectableUnselected;
    }

    public void setSelectableUnselecting(String selectableUnselecting)
    {
      this.selectableUnselecting = selectableUnselecting;
    }

    public void setSortableZindex(String sortableZindex)
    {
      this.sortableZindex = sortableZindex;
    }

    public void setSortableUpdate(String sortableUpdate)
    {
      this.sortableUpdate = sortableUpdate;
    }

    public void setSortableTolerance(String sortableTolerance)
    {
      this.sortableTolerance = sortableTolerance;
    }

    public void setSortableStop(String sortableStop)
    {
      this.sortableStop = sortableStop;
    }

    public void setSortableStart(String sortableStart)
    {
      this.sortableStart = sortableStart;
    }

    public void setSortableSort(String sortableSort)
    {
      this.sortableSort = sortableSort;
    }

    public void setSortableScrollSpeed(String sortableScrollSpeed)
    {
      this.sortableScrollSpeed = sortableScrollSpeed;
    }

    public void setSortableScrollSensitivity(String sortableScrollSensitivity)
    {
      this.sortableScrollSensitivity = sortableScrollSensitivity;
    }

    public void setSortableScroll(String sortableScroll)
    {
      this.sortableScroll = sortableScroll;
    }

    public void setSortableRevert(String sortableRevert)
    {
      this.sortableRevert = sortableRevert;
    }

    public void setSortableRemove(String sortableRemove)
    {
      this.sortableRemove = sortableRemove;
    }

    public void setSortableReceive(String sortableReceive)
    {
      this.sortableReceive = sortableReceive;
    }

    public void setSortablePlaceholder(String sortablePlaceholder)
    {
      this.sortablePlaceholder = sortablePlaceholder;
    }

    public void setSortableOver(String sortableOver)
    {
      this.sortableOver = sortableOver;
    }

    public void setSortableOut(String sortableOut)
    {
      this.sortableOut = sortableOut;
    }

    public void setSortableOpacity(String sortableOpacity)
    {
      this.sortableOpacity = sortableOpacity;
    }

    public void setSortableItems(String sortableItems)
    {
      this.sortableItems = sortableItems;
    }

    public void setSortableHelper(String sortableHelper)
    {
      this.sortableHelper = sortableHelper;
    }

    public void setSortableHandle(String sortableHandle)
    {
      this.sortableHandle = sortableHandle;
    }

    public void setSortableGrid(String sortableGrid)
    {
      this.sortableGrid = sortableGrid;
    }

    public void setSortableForcePlaceholderSize(String sortableForcePlaceholderSize)
    {
      this.sortableForcePlaceholderSize = sortableForcePlaceholderSize;
    }

    public void setSortableForceHelperSize(String sortableForceHelperSize)
    {
      this.sortableForceHelperSize = sortableForceHelperSize;
    }

    public void setSortableDropOnEmpty(String sortableDropOnEmpty)
    {
      this.sortableDropOnEmpty = sortableDropOnEmpty;
    }

    public void setSortableDistance(String sortableDistance)
    {
      this.sortableDistance = sortableDistance;
    }

    public void setSortableDelay(String sortableDelay)
    {
      this.sortableDelay = sortableDelay;
    }

    public void setSortableDeactivate(String sortableDeactivate)
    {
      this.sortableDeactivate = sortableDeactivate;
    }

    public void setSortableCursorAt(String sortableCursorAt)
    {
      this.sortableCursorAt = sortableCursorAt;
    }

    public void setSortableCursor(String sortableCursor)
    {
      this.sortableCursor = sortableCursor;
    }

    public void setSortableContainment(String sortableContainment)
    {
      this.sortableContainment = sortableContainment;
    }

    public void setSortableConnectWith(String sortableConnectWith)
    {
      this.sortableConnectWith = sortableConnectWith;
    }

    public void setSortableChange(String sortableChange)
    {
      this.sortableChange = sortableChange;
    }

    public void setSortableCancel(String sortableCancel)
    {
      this.sortableCancel = sortableCancel;
    }

    public void setSortableBeforeStop(String sortableBeforeStop)
    {
      this.sortableBeforeStop = sortableBeforeStop;
    }

    public void setSortableAxis(String sortableAxis)
    {
      this.sortableAxis = sortableAxis;
    }

    public void setSortableAppendTo(String sortableAppendTo)
    {
      this.sortableAppendTo = sortableAppendTo;
    }

    public void setSortableActivate(String sortableActivate)
    {
      this.sortableActivate = sortableActivate;
    }

    public void setSortable(String sortable)
    {
      this.sortable = sortable;
    }

    public void setReloadTopics(String reloadTopics)
    {
      this.reloadTopics = reloadTopics;
    }

    public void setBindOn(String bindOn)
    {
      this.bindOn = bindOn;
    }

    public void setEvents(String events)
    {
      this.events = events;
    }
}
