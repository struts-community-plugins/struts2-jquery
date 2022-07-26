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

import com.jgeppert.struts2.jquery.components.util.ObjectParameterBuilder;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.struts2.views.annotations.StrutsTagAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
public abstract class AbstractContainer extends AbstractRemoteBean implements ResizableBean, DroppableBean, DraggableBean, SelectableBean, SortableBean {

    private static final String PARAM_RELOAD_TOPICS = "reloadTopics";
    private static final String PARAM_BIND_ON = "bindOn";
    private static final String PARAM_EVENTS = "events";
    private static final String PARAM_DEFERRED_LOADING = "deferredLoading";
    private static final String PARAM_RESIZABLE = "resizable";
    private static final String PARAM_RESIZABLE_OPTIONS = "resizableOptions";
    private static final String PARAM_RESIZABLE_ON_RESIZE_TOPICS = "resizableOnResizeTopics";
    private static final String PARAM_RESIZABLE_ON_START_TOPICS = "resizableOnStartTopics";
    private static final String PARAM_RESIZABLE_ON_STOP_TOPICS = "resizableOnStopTopics";
    private static final String PARAM_DROPPABLE = "droppable";
    private static final String PARAM_DROPPABLE_OPTIONS = "droppableOptions";
    private static final String PARAM_DROPPABLE_ON_ACTIVATE_TOPICS = "droppableOnActivateTopics";
    private static final String PARAM_DROPPABLE_ON_DEACTIVATE_TOPICS = "droppableOnDeactivateTopics";
    private static final String PARAM_DROPPABLE_ON_OVER_TOPICS = "droppableOnOverTopics";
    private static final String PARAM_DROPPABLE_ON_OUT_TOPICS = "droppableOnOutTopics";
    private static final String PARAM_DROPPABLE_ON_DROP_TOPICS = "droppableOnDropTopics";
    private static final String PARAM_DRAGGABLE = "draggable";
    private static final String PARAM_DRAGGABLE_OPTIONS = "draggableOptions";
    private static final String PARAM_DRAGGABLE_ON_DRAG_TOPICS = "draggableOnDragTopics";
    private static final String PARAM_DRAGGABLE_ON_START_TOPICS = "draggableOnStartTopics";
    private static final String PARAM_DRAGGABLE_ON_STOP_TOPICS = "draggableOnStopTopics";
    private static final String PARAM_SELECTABLE = "selectable";
    private static final String PARAM_SELECTABLE_OPTIONS = "selectableOptions";
    private static final String PARAM_SELECTABLE_ON_SELECTED_TOPICS = "selectableOnSelectedTopics";
    private static final String PARAM_SELECTABLE_ON_SELECTING_TOPICS = "selectableOnSelectingTopics";
    private static final String PARAM_SELECTABLE_ON_START_TOPICS = "selectableOnStartTopics";
    private static final String PARAM_SELECTABLE_ON_STOP_TOPICS = "selectableOnStopTopics";
    private static final String PARAM_SELECTABLE_ON_UNSELECTED_TOPICS = "selectableOnUnselectedTopics";
    private static final String PARAM_SELECTABLE_ON_UNSELECTING_TOPICS = "selectableOnUnselectingTopics";
    private static final String PARAM_SORTABLE = "sortable";
    private static final String PARAM_SORTABLE_OPTIONS = "sortableOptions";
    private static final String PARAM_SORTABLE_ON_ACTIVATE_TOPICS = "sortableOnActivateTopics";
    private static final String PARAM_SORTABLE_ON_UPDATE_TOPICS = "sortableOnUpdateTopics";
    private static final String PARAM_SORTABLE_ON_STOP_TOPICS = "sortableOnStopTopics";
    private static final String PARAM_SORTABLE_ON_START_TOPICS = "sortableOnStartTopics";
    private static final String PARAM_SORTABLE_ON_SORT_TOPICS = "sortableOnSortTopics";
    private static final String PARAM_SORTABLE_ON_REMOVE_TOPICS = "sortableOnRemoveTopics";
    private static final String PARAM_SORTABLE_ON_RECEIVE_TOPICS = "sortableOnReceiveTopics";
    private static final String PARAM_SORTABLE_ON_OVER_TOPICS = "sortableOnOverTopics";
    private static final String PARAM_SORTABLE_ON_OUT_TOPICS = "sortableOnOutTopics";
    private static final String PARAM_SORTABLE_ON_DEACTIVATE_TOPICS = "sortableOnDeactivateTopics";
    private static final String PARAM_SORTABLE_ON_CHANGE_TOPICS = "sortableOnChangeTopics";
    private static final String PARAM_SORTABLE_ON_BEFORE_STOP_TOPICS = "sortableOnBeforeStopTopics";

    protected String reloadTopics;
    protected String bindOn;
    protected String events;
    protected String deferredLoading;

    protected String resizable;
    protected String resizableAnimate;
    protected String resizableAnimateDuration;
    protected String resizableAnimateEasing;
    protected String resizableAspectRatio;
    protected String resizableAutoHide;
    protected String resizableContainment;
    protected String resizableGhost;
    protected String resizableHelper;
    protected String resizableMaxHeight;
    protected String resizableMaxWidth;
    protected String resizableMinHeight;
    protected String resizableMinWidth;
    protected String resizableHandles;
    protected String resizableOnResizeTopics;
    protected String resizableOnStartTopics;
    protected String resizableOnStopTopics;

    protected String droppable;
    protected String droppableAccept;
    protected String droppableAddClasses;
    protected String droppableClasses;
    protected String droppableGreedy;
    protected String droppableScope;
    protected String droppableTolerance;

    protected String droppableOnActivateTopics;
    protected String droppableOnDeactivateTopics;
    protected String droppableOnDropTopics;
    protected String droppableOnOutTopics;
    protected String droppableOnOverTopics;

    protected String draggable;
    protected String draggableAppendTo;
    protected String draggableAxis;
    protected String draggableCancel;
    protected String draggableCursor;
    protected String draggableContainment;
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
    protected String draggableZindex;
    protected String draggableAddClasses;
    protected String draggableOnDragTopics;
    protected String draggableOnStartTopics;
    protected String draggableOnStopTopics;
    protected String selectable;
    protected String selectableAutoRefresh;
    protected String selectableCancel;
    protected String selectableFilter;
    protected String selectableTolerance;

    protected String selectableOnUnselectedTopics;
    protected String selectableOnUnselectingTopics;
    protected String selectableOnSelectedTopics;
    protected String selectableOnSelectingTopics;
    protected String selectableOnStartTopics;
    protected String selectableOnStopTopics;

    protected String sortableZindex;
    protected String sortableTolerance;
    protected String sortableScrollSpeed;
    protected String sortableScrollSensitivity;
    protected String sortableScroll;
    protected String sortableRevert;
    protected String sortablePlaceholder;
    protected String sortableOpacity;
    protected String sortableItems;
    protected String sortableHelper;
    protected String sortableHandle;
    protected String sortableGrid;
    protected String sortableForcePlaceholderSize;
    protected String sortableForceHelperSize;
    protected String sortableDropOnEmpty;
    protected String sortableCursorAt;
    protected String sortableCursor;
    protected String sortableContainment;
    protected String sortableConnectWith;
    protected String sortableCancel;
    protected String sortableAxis;
    protected String sortableAppendTo;
    protected String sortable;
    protected String sortableOnBeforeStopTopics;
    protected String sortableOnStopTopics;
    protected String sortableOnStartTopics;
    protected String sortableOnSortTopics;
    protected String sortableOnActivateTopics;
    protected String sortableOnDeactivateTopics;
    protected String sortableOnOverTopics;
    protected String sortableOnOutTopics;
    protected String sortableOnRemoveTopics;
    protected String sortableOnReceiveTopics;
    protected String sortableOnChangeTopics;
    protected String sortableOnUpdateTopics;

    public AbstractContainer(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameterIfPresent(PARAM_RELOAD_TOPICS, this.reloadTopics);
        addParameterIfPresent(PARAM_BIND_ON, this.bindOn);
        addParameterIfPresent(PARAM_EVENTS, this.events);
        addParameterIfPresent(PARAM_DEFERRED_LOADING, this.deferredLoading, Boolean.class);

        if (BooleanUtils.toBoolean(findString(resizable))) {
            addParameter(PARAM_RESIZABLE, Boolean.TRUE);
            ObjectParameterBuilder resizableBuilder = new ObjectParameterBuilder();
            if (resizableAnimate != null) {
                resizableBuilder.addParameter("animate", findString(resizableAnimate), false);
            }
            if (resizableAspectRatio != null) {
                resizableBuilder.addParameter("aspectRatio", findString(resizableAspectRatio), false);
            }
            if (resizableAutoHide != null) {
                resizableBuilder.addParameter("autoHide", findString(resizableAutoHide), false);
            }
            if (resizableGhost != null) {
                resizableBuilder.addParameter("ghost", findString(resizableGhost), false);
            }
            if (resizableAnimateDuration != null) {
                resizableBuilder.addParameter("animateDuration", findString(resizableAnimateDuration), false);
            }
            if (resizableMaxHeight != null) {
                resizableBuilder.addParameter("maxHeight", findString(resizableMaxHeight), false);
            }
            if (resizableMaxWidth != null) {
                resizableBuilder.addParameter("maxWidth", findString(resizableMaxWidth), false);
            }
            if (resizableMinHeight != null) {
                resizableBuilder.addParameter("minHeight", findString(resizableMinHeight), false);
            }
            if (resizableMinWidth != null) {
                resizableBuilder.addParameter("minWidth", findString(resizableMinWidth), false);
            }
            if (resizableAnimateEasing != null) {
                resizableBuilder.addParameter("animateEasing", findString(resizableAnimateEasing));
            }
            if (resizableHelper != null) {
                resizableBuilder.addParameter("helper", findString(resizableHelper));
            }
            if (resizableHandles != null) {
                resizableBuilder.addParameter("handles", findString(resizableHandles));
            }

            if (resizableContainment != null) {
                String containmentValue = findString(resizableContainment);

                if (containmentValue.equalsIgnoreCase("parent") || containmentValue.equalsIgnoreCase("document")) {
                    resizableBuilder.addParameter("containment", containmentValue);
                } else {
                    resizableBuilder.addParameter("containment", "#" + containmentValue);
                }
            }

            addParameter(PARAM_RESIZABLE_OPTIONS, resizableBuilder.toString());
            addParameterIfPresent(PARAM_RESIZABLE_ON_RESIZE_TOPICS, this.resizableOnResizeTopics);
            addParameterIfPresent(PARAM_RESIZABLE_ON_START_TOPICS, this.resizableOnStartTopics);
            addParameterIfPresent(PARAM_RESIZABLE_ON_STOP_TOPICS, this.resizableOnStopTopics);
        }

        if (BooleanUtils.toBoolean(findString(droppable))) {
            addParameter(PARAM_DROPPABLE, Boolean.TRUE);
            ObjectParameterBuilder droppableBuilder = new ObjectParameterBuilder();
            if (droppableAccept != null) {
                droppableBuilder.addParameter("accept", findString(droppableAccept));
            }
            if (droppableAddClasses != null) {
                droppableBuilder.addParameter("addClasses", findString(droppableAddClasses), false);
            }
            if (droppableClasses != null) {
                droppableBuilder.addParameter("classes", findString(droppableClasses), false);
            }
            if (droppableGreedy != null) {
                droppableBuilder.addParameter("greedy", findString(droppableGreedy), false);
            }
            if (droppableTolerance != null) {
                droppableBuilder.addParameter("tolerance", findString(droppableTolerance));
            }
            if (droppableScope != null) {
                droppableBuilder.addParameter("scope", findString(droppableScope));
            }

            addParameter(PARAM_DROPPABLE_OPTIONS, droppableBuilder.toString());
            addParameterIfPresent(PARAM_DROPPABLE_ON_ACTIVATE_TOPICS, this.droppableOnActivateTopics);
            addParameterIfPresent(PARAM_DROPPABLE_ON_DEACTIVATE_TOPICS, this.droppableOnDeactivateTopics);
            addParameterIfPresent(PARAM_DROPPABLE_ON_OVER_TOPICS, this.droppableOnOverTopics);
            addParameterIfPresent(PARAM_DROPPABLE_ON_OUT_TOPICS, this.droppableOnOutTopics);
            addParameterIfPresent(PARAM_DROPPABLE_ON_DROP_TOPICS, this.droppableOnDropTopics);
        }

        if (BooleanUtils.toBoolean(findString(draggable))) {
            addParameter(PARAM_DRAGGABLE, Boolean.TRUE);
            ObjectParameterBuilder draggableBuilder = new ObjectParameterBuilder();
            if (draggableAddClasses != null) {
                draggableBuilder.addParameter("addClasses", findString(draggableAddClasses), false);
            }
            if (draggableAppendTo != null) {
                draggableBuilder.addParameter("appendTo", findString(draggableAppendTo));
            }
            if (draggableAxis != null) {
                draggableBuilder.addParameter("axis", findString(draggableAxis));
            }
            if (draggableCancel != null) {
                draggableBuilder.addParameter("cancel", findString(draggableCancel));
            }
            if (draggableCursor != null) {
                draggableBuilder.addParameter("cursor", findString(draggableCursor));
            }
            if (draggableHandle != null) {
                draggableBuilder.addParameter("handle", findString(draggableHandle));
            }
            if (draggableHelper != null) {
                draggableBuilder.addParameter("helper", findString(draggableHelper));
            }
            if (draggableIframeFix != null) {
                draggableBuilder.addParameter("iframeFix", findString(draggableIframeFix), false);
            }
            if (draggableOpacity != null) {
                draggableBuilder.addParameter("opacity", findString(draggableOpacity));
            }
            if (draggableRefreshPositions != null) {
                draggableBuilder.addParameter("refreshPositions", findString(draggableRefreshPositions), false);
            }
            if (draggableRevertDuration != null) {
                draggableBuilder.addParameter("revertDuration", findString(draggableRevertDuration), false);
            }
            if (draggableScope != null) {
                draggableBuilder.addParameter("scope", findString(draggableScope));
            }
            if (draggableScroll != null) {
                draggableBuilder.addParameter("scroll", findString(draggableScroll), false);
            }
            if (draggableScrollSensitivity != null) {
                draggableBuilder.addParameter("sensitivity", findString(draggableScrollSensitivity), false);
            }
            if (draggableScrollSpeed != null) {
                draggableBuilder.addParameter("scrollSpeed", findString(draggableScrollSpeed), false);
            }
            if (draggableSnap != null) {
                draggableBuilder.addParameter("snap", findString(draggableSnap), false);
            }
            if (draggableSnapMode != null) {
                draggableBuilder.addParameter("snapMode", findString(draggableSnapMode));
            }
            if (draggableSnapTolerance != null) {
                draggableBuilder.addParameter("snapTolerance", findString(draggableSnapTolerance), false);
            }
            if (draggableZindex != null) {
                draggableBuilder.addParameter("zIndex", findString(draggableZindex), false);
            }

            if (draggableRevert != null) {
                String revertValue = findString(draggableRevert);

                if (revertValue.equalsIgnoreCase("true") || revertValue.equalsIgnoreCase("false")) {
                    draggableBuilder.addParameter("revert", revertValue, false);
                } else {
                    draggableBuilder.addParameter("revert", revertValue);
                }
            }
            if (draggableContainment != null) {
                String containmentValue = findString(draggableContainment);

                if (containmentValue.equalsIgnoreCase("parent") || containmentValue.equalsIgnoreCase("document") || containmentValue.equalsIgnoreCase("window")) {
                    draggableBuilder.addParameter("containment", containmentValue);
                } else {
                    draggableBuilder.addParameter("containment", "#" + containmentValue);
                }
            }

            addParameter(PARAM_DRAGGABLE_OPTIONS, draggableBuilder.toString());
            addParameterIfPresent(PARAM_DRAGGABLE_ON_DRAG_TOPICS, this.draggableOnDragTopics);
            addParameterIfPresent(PARAM_DRAGGABLE_ON_START_TOPICS, this.draggableOnStartTopics);
            addParameterIfPresent(PARAM_DRAGGABLE_ON_STOP_TOPICS, this.draggableOnStopTopics);
        }

        if (BooleanUtils.toBoolean(findString(selectable))) {
            addParameter(PARAM_SELECTABLE, Boolean.TRUE);
            ObjectParameterBuilder selectableBuilder = new ObjectParameterBuilder();
            if (selectableFilter != null) {
                selectableBuilder.addParameter("filter", findString(selectableFilter));
            }
            if (selectableCancel != null) {
                selectableBuilder.addParameter("cancel", findString(selectableCancel));
            }
            if (selectableTolerance != null) {
                selectableBuilder.addParameter("tolerance", findString(selectableTolerance));
            }

            addParameter(PARAM_SELECTABLE_OPTIONS, selectableBuilder.toString());
            addParameterIfPresent(PARAM_SELECTABLE_ON_SELECTED_TOPICS, this.selectableOnSelectedTopics);
            addParameterIfPresent(PARAM_SELECTABLE_ON_SELECTING_TOPICS, this.selectableOnSelectingTopics);
            addParameterIfPresent(PARAM_SELECTABLE_ON_START_TOPICS, this.selectableOnStartTopics);
            addParameterIfPresent(PARAM_SELECTABLE_ON_STOP_TOPICS, this.selectableOnStopTopics);
            addParameterIfPresent(PARAM_SELECTABLE_ON_UNSELECTED_TOPICS, this.selectableOnUnselectedTopics);
            addParameterIfPresent(PARAM_SELECTABLE_ON_UNSELECTING_TOPICS, this.selectableOnUnselectingTopics);
        }

        if (BooleanUtils.toBoolean(findString(sortable))) {
            addParameter(PARAM_SORTABLE, Boolean.TRUE);
            ObjectParameterBuilder sortableBuilder = new ObjectParameterBuilder();
            if (sortableDropOnEmpty != null) {
                sortableBuilder.addParameter("dropOnEmpty", findString(sortableDropOnEmpty), false);
            }
            if (sortableForceHelperSize != null) {
                sortableBuilder.addParameter("forceHelperSize", findString(sortableForceHelperSize), false);
            }
            if (sortableForcePlaceholderSize != null) {
                sortableBuilder.addParameter("forcePlaceholderSize", findString(sortableForcePlaceholderSize), false);
            }
            if (sortableRevert != null) {
                sortableBuilder.addParameter("revert", findString(sortableRevert), false);
            }
            if (sortableScroll != null) {
                sortableBuilder.addParameter("scroll", findString(sortableScroll), false);
            }

            if (sortableZindex != null) {
                sortableBuilder.addParameter("zIndex", findString(sortableZindex), false);
            }
            if (sortableScrollSensitivity != null) {
                sortableBuilder.addParameter("scrollSensitivity", findString(sortableScrollSensitivity), false);
            }
            if (sortableScrollSpeed != null) {
                sortableBuilder.addParameter("scrollSpeed", findString(sortableScrollSpeed), false);
            }
            if (sortableTolerance != null) {
                sortableBuilder.addParameter("tolerance", findString(sortableTolerance));
            }
            if (sortablePlaceholder != null) {
                sortableBuilder.addParameter("placeholder", findString(sortablePlaceholder));
            }
            if (sortableOpacity != null) {
                sortableBuilder.addParameter("opacity", findString(sortableOpacity));
            }
            if (sortableItems != null) {
                sortableBuilder.addParameter("items", findString(sortableItems));
            }
            if (sortableHandle != null) {
                sortableBuilder.addParameter("handle", findString(sortableHandle));
            }
            if (sortableGrid != null) {
                sortableBuilder.addParameter("grid", findString(sortableGrid));
            }
            if (sortableCursorAt != null) {
                sortableBuilder.addParameter("cursorAt", findString(sortableCursorAt));
            }
            if (sortableCursor != null) {
                sortableBuilder.addParameter("cursor", findString(sortableCursor));
            }
            if (sortableConnectWith != null) {
                sortableBuilder.addParameter("connectWith", findString(sortableConnectWith));
            }
            if (sortableAxis != null) {
                sortableBuilder.addParameter("axis", findString(sortableAxis));
            }
            if (sortableAppendTo != null) {
                sortableBuilder.addParameter("appendTo", findString(sortableAppendTo));
            }
            if (sortableCancel != null) {
                sortableBuilder.addParameter("cancel", findString(sortableCancel));
            }

            if (sortableContainment != null) {
                String containmentValue = findString(sortableContainment);

                if (containmentValue.equalsIgnoreCase("parent") || containmentValue.equalsIgnoreCase("document") || containmentValue.equalsIgnoreCase("window")) {
                    sortableBuilder.addParameter("containment", containmentValue);
                } else {
                    sortableBuilder.addParameter("containment", "#" + containmentValue);
                }
            }

            addParameter(PARAM_SORTABLE_OPTIONS, sortableBuilder.toString());
            addParameterIfPresent(PARAM_SORTABLE_ON_ACTIVATE_TOPICS, this.sortableOnActivateTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_UPDATE_TOPICS, this.sortableOnUpdateTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_STOP_TOPICS, this.sortableOnStopTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_START_TOPICS, this.sortableOnStartTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_SORT_TOPICS, this.sortableOnSortTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_REMOVE_TOPICS, this.sortableOnRemoveTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_RECEIVE_TOPICS, this.sortableOnReceiveTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_OVER_TOPICS, this.sortableOnOverTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_OUT_TOPICS, this.sortableOnOutTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_DEACTIVATE_TOPICS, this.sortableOnDeactivateTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_CHANGE_TOPICS, this.sortableOnChangeTopics);
            addParameterIfPresent(PARAM_SORTABLE_ON_BEFORE_STOP_TOPICS, this.sortableOnBeforeStopTopics);
        }
    }

    @StrutsTagAttribute(description = "Enable this div element to be resizable. With the cursor grab the right or bottom border and drag to the desired width or height.", type = "Boolean")
    public void setResizable(String resizable) {
        this.resizable = resizable;
    }

    @StrutsTagAttribute(description = "Animates to the final size after resizing. Default: false", type = "Boolean")
    public void setResizableAnimate(String animate) {
        this.resizableAnimate = animate;
    }

    @StrutsTagAttribute(description = "Duration time for animating, in milliseconds.")
    public void setResizableAnimateDuration(String animateDuration) {
        this.resizableAnimateDuration = animateDuration;
    }

    @StrutsTagAttribute(description = "Easing effect for animating. Default: swing")
    public void setResizableAnimateEasing(String animateEasing) {
        this.resizableAnimateEasing = animateEasing;
    }

    @StrutsTagAttribute(description = "If set to true, resizing is constrained by the original aspect ratio. Default: false", type = "Boolean")
    public void setResizableAspectRatio(String aspectRatio) {
        this.resizableAspectRatio = aspectRatio;
    }

    @StrutsTagAttribute(description = "If set to true, automatically hides the handles except when the mouse hovers over the element. Default: false", type = "Boolean")
    public void setResizableAutoHide(String autoHide) {
        this.resizableAutoHide = autoHide;
    }

    @StrutsTagAttribute(description = "Constrains resizing to within the bounds of the specified element. Possible values: 'parent', 'document' or an id")
    public void setResizableContainment(String containment) {
        this.resizableContainment = containment;
    }

    @StrutsTagAttribute(description = "If set to true, a semi-transparent helper element is shown for resizing. Default: false", type = "Boolean")
    public void setResizableGhost(String ghost) {
        this.resizableGhost = ghost;
    }

    @StrutsTagAttribute(description = "This is the css class that will be added to a proxy element to outline the resize during the drag of the resize handle. Once the resize is complete, the original element is sized. e.g. ui-state-highlight")
    public void setResizableHelper(String helper) {
        this.resizableHelper = helper;
    }

    @StrutsTagAttribute(description = "This is the maximum height the resizable should be allowed to resize to.")
    public void setResizableMaxHeight(String maxHeight) {
        this.resizableMaxHeight = maxHeight;
    }

    @StrutsTagAttribute(description = "This is the maximum width the resizable should be allowed to resize to.")
    public void setResizableMaxWidth(String maxWidth) {
        this.resizableMaxWidth = maxWidth;
    }

    @StrutsTagAttribute(description = "This is the minimum height the resizable should be allowed to resize to.")
    public void setResizableMinHeight(String minHeight) {
        this.resizableMinHeight = minHeight;
    }

    @StrutsTagAttribute(description = "This is the minimum width the resizable should be allowed to resize to.")
    public void setResizableMinWidth(String minWidth) {
        this.resizableMinWidth = minWidth;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered during the resize, on the drag of the resize handler.")
    public void setResizableOnResizeTopics(String resizableOnResizeTopics) {
        this.resizableOnResizeTopics = resizableOnResizeTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered at the start of a resize operation.")
    public void setResizableOnStartTopics(String resizableOnStartTopics) {
        this.resizableOnStartTopics = resizableOnStartTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered at the end of a resize operation.")
    public void setResizableOnStopTopics(String resizableOnStopTopics) {
        this.resizableOnStopTopics = resizableOnStopTopics;
    }

    @StrutsTagAttribute(description = "If specified as a string, should be a comma-split list of any of the following: 'n, e, s, w, ne, se, sw, nw, all'. Default: e, s, se")
    public void setResizableHandles(String handles) {
        this.resizableHandles = handles;
    }

    @StrutsTagAttribute(description = "Enable any DIV element to be droppable, a target for draggable elements.")
    public void setDroppable(String droppable) {
        this.droppable = droppable;
    }

    @StrutsTagAttribute(description = "All draggables that match the jQuery selector will be accepted. e.g. #myid or .myclass")
    public void setDroppableAccept(String droppableAccept) {
        this.droppableAccept = droppableAccept;
    }

    @StrutsTagAttribute(description = "If set to false, will prevent the ui-droppable class from being added. This may be desired as a performance optimization when calling droppable init on many hundreds of elements. Default: true", defaultValue = "true")
    public void setDroppableAddClasses(String droppableAddClasses) {
        this.droppableAddClasses = droppableAddClasses;
    }
    
    @StrutsTagAttribute(description = "Specify additional classes to add to the widget's elements. Any of classes specified in the Theming section can be used as keys to override their value. Possible keys: ui-droppable-active, ui-droppable-hover, ...")
    public void setDroppableClasses(String droppableClasses) {
        this.droppableClasses = droppableClasses;
    }

    @StrutsTagAttribute(description = "If true, will prevent event propagation on nested droppables. Default: false", defaultValue = "false")
    public void setDroppableGreedy(String droppableGreedy) {
        this.droppableGreedy = droppableGreedy;
    }

    @StrutsTagAttribute(description = "Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted.")
    public void setDroppableScope(String droppableScope) {
        this.droppableScope = droppableScope;
    }

    @StrutsTagAttribute(description = "Specifies which mode to use for testing whether a draggable is over a droppable. Possible values: fit, intersect, pointer, touch. ")
    public void setDroppableTolerance(String droppableTolerance) {
        this.droppableTolerance = droppableTolerance;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered any time an accepted draggable starts dragging. This can be useful if you want to make the droppable 'light up' when it can be dropped on.")
    public void setDroppableOnActivateTopics(String droppableOnActivateTopics) {
        this.droppableOnActivateTopics = droppableOnActivateTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered any time an accepted draggable stops dragging.")
    public void setDroppableOnDeactivateTopics(String droppableOnDeactivateTopics) {
        this.droppableOnDeactivateTopics = droppableOnDeactivateTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered when an accepted draggable is dropped 'over' this droppable.")
    public void setDroppableOnDropTopics(String droppableOnDropTopics) {
        this.droppableOnDropTopics = droppableOnDropTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered when an accepted draggable is dragged 'out' this droppable.")
    public void setDroppableOnOutTopics(String droppableOnOutTopics) {
        this.droppableOnOutTopics = droppableOnOutTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered as an accepted draggable is dragged 'over' this droppable.")
    public void setDroppableOnOverTopics(String droppableOnOverTopics) {
        this.droppableOnOverTopics = droppableOnOverTopics;
    }

    @StrutsTagAttribute(description = "Enable draggable functionality to the DIV element. Move the draggable object by clicking on it with the mouse and dragging it anywhere within the viewport. ")
    public void setDraggable(String draggable) {
        this.draggable = draggable;
    }

    @StrutsTagAttribute(description = "If set to false, will prevent the ui-draggable class from being added. This may be desired as a performance optimization when calling draggable init on many hundreds of elements. Default: true", type = "Boolean")
    public void setDraggableAddClasses(String draggableAddClasses) {
        this.draggableAddClasses = draggableAddClasses;
    }

    @StrutsTagAttribute(description = "The element passed to or selected by the appendTo option will be used as the draggable helper's container during dragging. By default, the helper is appended to the same container as the draggable. Default: parent")
    public void setDraggableAppendTo(String draggableAppendTo) {
        this.draggableAppendTo = draggableAppendTo;
    }

    @StrutsTagAttribute(description = "Constrains dragging to either the horizontal (x) or vertical (y) axis. Possible values: x or y.")
    public void setDraggableAxis(String draggableAxis) {
        this.draggableAxis = draggableAxis;
    }

    @StrutsTagAttribute(description = "Prevents dragging from starting on specified elements.")
    public void setDraggableCancel(String draggableCancel) {
        this.draggableCancel = draggableCancel;
    }

    @StrutsTagAttribute(description = "The css cursor during the drag operation.")
    public void setDraggableCursor(String draggableCursor) {
        this.draggableCursor = draggableCursor;
    }

    @StrutsTagAttribute(description = "Constrains dragging to within the bounds of the specified element or region. Possible string values: parent, document, window, [x1, y1, x2, y2].")
    public void setDraggableContainment(String draggableContainment) {
        this.draggableContainment = draggableContainment;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered when the mouse is moved during the dragging.")
    public void setDraggableOnDragTopics(String draggableOnDragTopics) {
        this.draggableOnDragTopics = draggableOnDragTopics;
    }

    @StrutsTagAttribute(description = "If specified, restricts drag start click to the specified element(s). e.g. h2")
    public void setDraggableHandle(String draggableHandle) {
        this.draggableHandle = draggableHandle;
    }

    @StrutsTagAttribute(description = "Allows for a helper element to be used for dragging display. Possible values: original, clone. Default is original")
    public void setDraggableHelper(String draggableHelper) {
        this.draggableHelper = draggableHelper;
    }

    @StrutsTagAttribute(description = "Prevent iframes from capturing the mousemove events during a drag. Useful in combination with cursorAt, or in any case, if the mouse cursor is not over the helper. If set to true, transparent overlays will be placed over all iframes on the page. If a selector is supplied, the matched iframes will have an overlay placed over them. Default: false", type = "Boolean")
    public void setDraggableIframeFix(String draggableIframeFix) {
        this.draggableIframeFix = draggableIframeFix;
    }

    @StrutsTagAttribute(description = "Opacity for the helper while being dragged. e.g. 0.75")
    public void setDraggableOpacity(String draggableOpacity) {
        this.draggableOpacity = draggableOpacity;
    }

    @StrutsTagAttribute(description = "If set to true, all droppable positions are calculated on every mousemove. Caution: This solves issues on highly dynamic pages, but dramatically decreases performance. Default: false", type = "Boolean")
    public void setDraggableRefreshPositions(String draggableRefreshPositions) {
        this.draggableRefreshPositions = draggableRefreshPositions;
    }

    @StrutsTagAttribute(description = "If set to true, the element will return to its start position when dragging stops. e.g. true, valid, invalid Default: false")
    public void setDraggableRevert(String draggableRevert) {
        this.draggableRevert = draggableRevert;
    }

    @StrutsTagAttribute(description = "The duration of the revert animation, in milliseconds. Ignored if revert is false.")
    public void setDraggableRevertDuration(String draggableRevertDuration) {
        this.draggableRevertDuration = draggableRevertDuration;
    }

    @StrutsTagAttribute(description = "Used to group sets of draggable and droppable items, in addition to droppable's accept option. A draggable with the same scope value as a droppable will be accepted by the droppable.")
    public void setDraggableScope(String draggableScope) {
        this.draggableScope = draggableScope;
    }

    @StrutsTagAttribute(description = "If set to true, container auto-scrolls while dragging.", type = "Boolean")
    public void setDraggableScroll(String draggableScroll) {
        this.draggableScroll = draggableScroll;
    }

    @StrutsTagAttribute(description = "Distance in pixels from the edge of the viewport after which the viewport should scroll. Distance is relative to pointer, not the draggable. Default: 20")
    public void setDraggableScrollSensitivity(String draggableScrollSensitivity) {
        this.draggableScrollSensitivity = draggableScrollSensitivity;
    }

    @StrutsTagAttribute(description = "The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Default: 20")
    public void setDraggableScrollSpeed(String draggableScrollSpeed) {
        this.draggableScrollSpeed = draggableScrollSpeed;
    }

    @StrutsTagAttribute(description = "If set to true, the draggable will snap to the edges of the selected elements when near an edge of the element. Default: false", type = "Boolean")
    public void setDraggableSnap(String draggableSnap) {
        this.draggableSnap = draggableSnap;
    }

    @StrutsTagAttribute(description = "Determines which edges of snap elements the draggable will snap to. Ignored if snap is false. Possible values: inner, outer, both. Default: both")
    public void setDraggableSnapMode(String draggableSnapMode) {
        this.draggableSnapMode = draggableSnapMode;
    }

    @StrutsTagAttribute(description = "The distance in pixels from the snap element edges at which snapping should occur. Ignored if snap is false. Default: 20")
    public void setDraggableSnapTolerance(String draggableSnapTolerance) {
        this.draggableSnapTolerance = draggableSnapTolerance;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered when dragging starts.")
    public void setDraggableOnStartTopics(String draggableOnStartTopics) {
        this.draggableOnStartTopics = draggableOnStartTopics;
    }

    @StrutsTagAttribute(description = "This event javascript function is triggered when dragging stops.")
    public void setDraggableOnStopTopics(String draggableOnStopTopics) {
        this.draggableOnStopTopics = draggableOnStopTopics;
    }

    @StrutsTagAttribute(description = "z-index for the helper while being dragged.")
    public void setDraggableZindex(String draggableZindex) {
        this.draggableZindex = draggableZindex;
    }

    @StrutsTagAttribute(description = "Enable a element to be selectable. Draw a box with your cursor to select items. Hold down the Ctrl key to make multiple non-adjacent selections.", type = "Boolean")
    public void setSelectable(String selectable) {
        this.selectable = selectable;
    }

    @StrutsTagAttribute(description = "This determines whether to refresh (recalculate) the position and size of each selectee at the beginning of each select operation. If you have many many items, you may want to set this to false and call the refresh method manually. Default: true")
    public void setSelectableAutoRefresh(String selectableAutoRefresh) {
        this.selectableAutoRefresh = selectableAutoRefresh;
    }

    @StrutsTagAttribute(description = "Prevents selecting if you start on elements matching the selector. Default: ':input,option'")
    public void setSelectableCancel(String selectableCancel) {
        this.selectableCancel = selectableCancel;
    }

    @StrutsTagAttribute(description = "The matching child elements will be made selectees (able to be selected). Default: '*'")
    public void setSelectableFilter(String selectableFilter) {
        this.selectableFilter = selectableFilter;
    }

    @StrutsTagAttribute(description = "This event is triggered at the end of the select operation, on each element added to the selection.")
    public void setSelectableOnSelectedTopics(String selectableSelected) {
        this.selectableOnSelectedTopics = selectableSelected;
    }

    @StrutsTagAttribute(description = "This event is triggered during the select operation, on each element added to the selection.")
    public void setSelectableOnSelectingTopics(String selectableSelecting) {
        this.selectableOnSelectingTopics = selectableSelecting;
    }

    @StrutsTagAttribute(description = "This event is triggered at the beginning of the select operation.")
    public void setSelectableOnStartTopics(String selectableStart) {
        this.selectableOnStartTopics = selectableStart;
    }

    @StrutsTagAttribute(description = "This event is triggered at the end of the select operation.")
    public void setSelectableOnStopTopics(String selectableStop) {
        this.selectableOnStopTopics = selectableStop;
    }

    @StrutsTagAttribute(description = "Possible values: 'touch', 'fit'. Default: 'touch'")
    public void setSelectableTolerance(String selectableTolerance) {
        this.selectableTolerance = selectableTolerance;
    }

    @StrutsTagAttribute(description = "This event is triggered at the end of the select operation, on each element removed from the selection.")
    public void setSelectableOnUnselectedTopics(String selectableUnselected) {
        this.selectableOnUnselectedTopics = selectableUnselected;
    }

    @StrutsTagAttribute(description = "This event is triggered during the select operation, on each element removed from the selection.")
    public void setSelectableOnUnselectingTopics(String selectableUnselecting) {
        this.selectableOnUnselectingTopics = selectableUnselecting;
    }

    @StrutsTagAttribute(description = "Enable a elements to be sortable", type = "Boolean")
    public void setSortable(String sortable) {
        this.sortable = sortable;
    }

    @StrutsTagAttribute(description = "Defines where the helper that moves with the mouse is being appended to during the drag. Default: 'parent'")
    public void setSortableAppendTo(String sortableAppendTo) {
        this.sortableAppendTo = sortableAppendTo;
    }

    @StrutsTagAttribute(description = "If defined, the items can be dragged only horizontally or vertically. Possible values:'x', 'y'.")
    public void setSortableAxis(String sortableAxis) {
        this.sortableAxis = sortableAxis;
    }

    @StrutsTagAttribute(description = "Prevents sorting if you start on elements matching the selector. Default: ':input,button'")
    public void setSortableCancel(String sortableCancel) {
        this.sortableCancel = sortableCancel;
    }

    @StrutsTagAttribute(description = "Takes a jQuery selector with items that also have sortables applied. If used, the sortable is now connected to the other one-way, so you can drag from this sortable to the other. e.g. #myothersortable or .myothersortables")
    public void setSortableConnectWith(String sortableConnectWith) {
        this.sortableConnectWith = sortableConnectWith;
    }

    @StrutsTagAttribute(description = "Constrains dragging to within the bounds of the specified element - can be a DOM element, 'parent', 'document', 'window', or a jQuery selector.")
    public void setSortableContainment(String sortableContainment) {
        this.sortableContainment = sortableContainment;
    }

    @StrutsTagAttribute(description = "Defines the cursor that is being shown while sorting.")
    public void setSortableCursor(String sortableCursor) {
        this.sortableCursor = sortableCursor;
    }

    @StrutsTagAttribute(description = "Moves the sorting element or helper so the cursor always appears to drag from the same position. Coordinates can be given as a hash using a combination of one or two keys: top, left, right, bottom.")
    public void setSortableCursorAt(String sortableCursorAt) {
        this.sortableCursorAt = sortableCursorAt;
    }

    @StrutsTagAttribute(description = "If empty allows for an item to be dropped from a linked selectable. Default: true", type = "Boolean")
    public void setSortableDropOnEmpty(String sortableDropOnEmpty) {
        this.sortableDropOnEmpty = sortableDropOnEmpty;
    }

    @StrutsTagAttribute(description = "If true, forces the helper to have a size. Default: false", type = "Boolean")
    public void setSortableForceHelperSize(String sortableForceHelperSize) {
        this.sortableForceHelperSize = sortableForceHelperSize;
    }

    @StrutsTagAttribute(description = "If true, forces the placeholder to have a size. Default: false", type = "Boolean")
    public void setSortableForcePlaceholderSize(String sortableForcePlaceholderSize) {
        this.sortableForcePlaceholderSize = sortableForcePlaceholderSize;
    }

    @StrutsTagAttribute(description = "Snaps the sorting element or helper to a grid, every x and y pixels. Array values: [x, y]")
    public void setSortableGrid(String sortableGrid) {
        this.sortableGrid = sortableGrid;
    }

    @StrutsTagAttribute(description = "Restricts sort start click to the specified element.")
    public void setSortableHandle(String sortableHandle) {
        this.sortableHandle = sortableHandle;
    }

    @StrutsTagAttribute(description = "Allows for a helper element to be used for dragging display. The supplied function receives the event and the element being sorted, and should return a DOMElement to be used as a custom proxy helper. Possible values: 'original', 'clone'. Default: 'original'")
    public void setSortableHelper(String sortableHelper) {
        this.sortableHelper = sortableHelper;
    }

    @StrutsTagAttribute(description = "Specifies which items inside the element should be sortable. Default: '> *'")
    public void setSortableItems(String sortableItems) {
        this.sortableItems = sortableItems;
    }

    @StrutsTagAttribute(description = "Defines the opacity of the helper while sorting. From 0.01 to 1")
    public void setSortableOpacity(String sortableOpacity) {
        this.sortableOpacity = sortableOpacity;
    }

    @StrutsTagAttribute(description = "Class that gets applied to the otherwise white space.")
    public void setSortablePlaceholder(String sortablePlaceholder) {
        this.sortablePlaceholder = sortablePlaceholder;
    }

    @StrutsTagAttribute(description = "If set to true, the item will be reverted to its new DOM position with a smooth animation. Default: false", type = "Boolean")
    public void setSortableRevert(String sortableRevert) {
        this.sortableRevert = sortableRevert;
    }

    @StrutsTagAttribute(description = "If set to true, the page scrolls when coming to an edge. Default: true", type = "Boolean")
    public void setSortableScroll(String sortableScroll) {
        this.sortableScroll = sortableScroll;
    }

    @StrutsTagAttribute(description = "Defines how near the mouse must be to an edge to start scrolling. Default: 20")
    public void setSortableScrollSensitivity(String sortableScrollSensitivity) {
        this.sortableScrollSensitivity = sortableScrollSensitivity;
    }

    @StrutsTagAttribute(description = "The speed at which the window should scroll once the mouse pointer gets within the scrollSensitivity distance. Default: 20")
    public void setSortableScrollSpeed(String sortableScrollSpeed) {
        this.sortableScrollSpeed = sortableScrollSpeed;
    }

    @StrutsTagAttribute(description = "This is the way the reordering behaves during drag. Possible values: 'intersect', 'pointer'. In some setups, 'pointer' is more natural. Default: 'intersect'")
    public void setSortableTolerance(String sortableTolerance) {
        this.sortableTolerance = sortableTolerance;
    }

    @StrutsTagAttribute(description = "Z-index for element/helper while being sorted. Default: 1000")
    public void setSortableZindex(String sortableZindex) {
        this.sortableZindex = sortableZindex;
    }

    @StrutsTagAttribute(description = "This event is triggered when using connected lists, every connected list on drag start receives it.")
    public void setSortableOnActivateTopics(String sortableActivate) {
        this.sortableOnActivateTopics = sortableActivate;
    }

    @StrutsTagAttribute(description = "This event is triggered when sorting stops, but when the placeholder/helper is still available.")
    public void setSortableOnBeforeStopTopics(String sortableBeforeStop) {
        this.sortableOnBeforeStopTopics = sortableBeforeStop;
    }

    @StrutsTagAttribute(description = "This event is triggered during sorting, but only when the DOM position has changed.")
    public void setSortableOnChangeTopics(String sortableChange) {
        this.sortableOnChangeTopics = sortableChange;
    }

    @StrutsTagAttribute(description = "This event is triggered when sorting was stopped, is propagated to all possible connected lists.")
    public void setSortableOnDeactivateTopics(String sortableDeactivate) {
        this.sortableOnDeactivateTopics = sortableDeactivate;
    }

    @StrutsTagAttribute(description = "This event is triggered when a sortable item is moved away from a connected list.")
    public void setSortableOnOutTopics(String sortableOut) {
        this.sortableOnOutTopics = sortableOut;
    }

    @StrutsTagAttribute(description = "This event is triggered when a sortable item is moved into a connected list.")
    public void setSortableOnOverTopics(String sortableOver) {
        this.sortableOnOverTopics = sortableOver;
    }

    @StrutsTagAttribute(description = "This event is triggered when a connected sortable list has received an item from another list.")
    public void setSortableOnReceiveTopics(String sortableReceive) {
        this.sortableOnReceiveTopics = sortableReceive;
    }

    @StrutsTagAttribute(description = "This event is triggered when a sortable item has been dragged out from the list and into another.")
    public void setSortableOnRemoveTopics(String sortableRemove) {
        this.sortableOnRemoveTopics = sortableRemove;
    }

    @StrutsTagAttribute(description = "This event is triggered during sorting.")
    public void setSortableOnSortTopics(String sortableSort) {
        this.sortableOnSortTopics = sortableSort;
    }

    @StrutsTagAttribute(description = "This event is triggered when sorting starts.")
    public void setSortableOnStartTopics(String sortableStart) {
        this.sortableOnStartTopics = sortableStart;
    }

    @StrutsTagAttribute(description = "This event is triggered when sorting has stopped.")
    public void setSortableOnStopTopics(String sortableStop) {
        this.sortableOnStopTopics = sortableStop;
    }

    @StrutsTagAttribute(description = "This event is triggered when the user stopped sorting and the DOM position has changed.")
    public void setSortableOnUpdateTopics(String sortableUpdate) {
        this.sortableOnUpdateTopics = sortableUpdate;
    }

    @StrutsTagAttribute(name = "onCompleteTopics", description = "Topics that are published before after load is completed", type = "String", defaultValue = "")
    public void setOnCompleteTopics(String onCompleteTopics) {
        this.onCompleteTopics = onCompleteTopics;
    }

    @StrutsTagAttribute(name = "onErrorTopics", description = "Topics that are published on a load error", type = "String", defaultValue = "")
    public void setOnErrorTopics(String onErrorTopics) {
        this.onErrorTopics = onErrorTopics;
    }

    @StrutsTagAttribute(name = "onSuccessTopics", description = "Topics that are published after a succesful load", type = "String", defaultValue = "")
    public void setOnSuccessTopics(String onSuccessTopics) {
        this.onSuccessTopics = onSuccessTopics;
    }

    @StrutsTagAttribute(name = "reloadTopics", description = "A comma delimited list of topics that will cause this element to reload", type = "String", defaultValue = "")
    public void setReloadTopics(String reloadTopics) {
        this.reloadTopics = reloadTopics;
    }

    @StrutsTagAttribute(description = "Bind the start of load or effect on element. e.g. button or link")
    public void setBindOn(String bindOn) {
        this.bindOn = bindOn;
    }

    @StrutsTagAttribute(description = "Start load or effect on specified event. Possible values are click, dblclick, mouseover, mouseenter, mouseleave. Default: click", defaultValue = "click")
    public void setEvents(String events) {
        this.events = events;
    }

    @StrutsTagAttribute(description = "Defers the initial loading of this element.  The element will not be loaded until one of the reloadTopics is published.", type = "Boolean", defaultValue = "false")
    public void setDeferredLoading(String deferredLoading) {
        this.deferredLoading = deferredLoading;
    }
}
