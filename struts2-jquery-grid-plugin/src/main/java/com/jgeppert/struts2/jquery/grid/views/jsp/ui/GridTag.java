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

package com.jgeppert.struts2.jquery.grid.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;

import com.jgeppert.struts2.jquery.grid.components.Grid;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractRemoteTag;
import com.jgeppert.struts2.jquery.views.jsp.ui.DraggableTag;
import com.jgeppert.struts2.jquery.views.jsp.ui.DroppableTag;
import com.jgeppert.struts2.jquery.views.jsp.ui.ResizableTag;
import com.jgeppert.struts2.jquery.views.jsp.ui.SortableTag;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * 
 * @see Grid
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
public class GridTag extends AbstractRemoteTag implements ResizableTag,
	DraggableTag, DroppableTag, SortableTag {

    private static final long serialVersionUID = 2134613468009192567L;

    protected String width;
    protected String height;
    protected String pager;
    protected String pagerButtons;
    protected String pagerPosition;
    protected String pagerInput;
    protected String rowNum;
    protected String sortname;
    protected String viewrecords;
    protected String gridview;
    protected String autowidth;
    protected String sortorder;
    protected String loadonce;
    protected String multiselect;
    protected String multiboxonly;
    protected String editurl;
    protected String editinline;
    protected String caption;
    protected String shrinkToFit;
    protected String gridModel;
    protected String rowList;
    protected String scroll;
    protected String navigator;
    protected String navigatorEditOptions;
    protected String navigatorAddOptions;
    protected String navigatorDeleteOptions;
    protected String navigatorSearchOptions;
    protected String navigatorViewOptions;
    protected String navigatorAdd;
    protected String navigatorDelete;
    protected String navigatorEdit;
    protected String navigatorRefresh;
    protected String navigatorSearch;
    protected String navigatorView;
    protected String navigatorExtraButtons;
    protected String navigatorInlineEditButtons;
    protected String navigatorCloneToTop;
    protected String autoencode;
    protected String cellEdit;
    protected String cellurl;
    protected String footerrow;
    protected String hiddengrid;
    protected String hidegrid;
    protected String hoverrows;
    protected String rownumbers;
    protected String multiselectWidth;
    protected String page;
    protected String scrollrows;
    protected String filter;
    protected String subGridWidth;
    protected String subGridUrl;
    protected String userDataOnFooter;
    protected String filterOptions;
    protected String altClass;
    protected String altRows;
    protected String prmNames;
    protected String direction;
    protected String recordpos;
    protected String rowTotal;
    protected String viewsortcols;
    protected String toppager;

    protected String onSelectRowTopics;
    protected String onSelectAllTopics;
    protected String onPagingTopics;
    protected String onSortColTopics;
    protected String onCellSelectTopics;
    protected String onGridCompleteTopics;
    protected String onEditInlineBeforeTopics;
    protected String onEditInlineSuccessTopics;
    protected String onEditInlineErrorTopics;
    protected String onEditInlineAfterSaveTopics;
    protected String onCellEditSuccessTopics;
    protected String onCellEditErrorTopics;
    protected String onSubGridRowExpanded;
    protected String onClickGroupTopics;
    protected String onDblClickRowTopics;
    protected String onRightClickRowTopics;

    protected String reloadTopics;

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
    protected String resizableOnResizeTopics;
    protected String resizableOnStartTopics;
    protected String resizableOnStopTopics;
    protected String resizableHandles;

    protected String droppable;
    protected String droppableAccept;
    protected String droppableActiveClass;
    protected String droppableAddClasses;
    protected String droppableGreedy;
    protected String droppableHoverClass;
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
    protected String draggableDelay;
    protected String draggableDistance;
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
    protected String draggableOnDragTopics;
    protected String draggableOnStartTopics;
    protected String draggableOnStopTopics;
    protected String draggableZindex;
    protected String draggableAddClasses;

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
    protected String sortableDistance;
    protected String sortableDelay;
    protected String sortableCursorAt;
    protected String sortableCursor;
    protected String sortableContainment;
    protected String sortableConnectWith;
    protected String sortableCancel;
    protected String sortableAxis;
    protected String sortableAppendTo;
    protected String sortable;
    protected String sortableRows;

    protected String sortableOnOverTopics;
    protected String sortableOnOutTopics;
    protected String sortableOnUpdateTopics;
    protected String sortableOnStopTopics;
    protected String sortableOnStartTopics;
    protected String sortableOnSortTopics;
    protected String sortableOnChangeTopics;
    protected String sortableOnBeforeStopTopics;
    protected String sortableOnActivateTopics;
    protected String sortableOnDeactivateTopics;
    protected String sortableOnRemoveTopics;
    protected String sortableOnReceiveTopics;

    protected String connectWith;

    protected String groupField;
    protected String groupColumnShow;
    protected String groupText;
    protected String groupCollapse;
    protected String groupOrder;
    protected String groupSummary;
    protected String groupDataSorted;
    protected String groupShowSummaryOnHide;
    protected String groupPlusIcon;
    protected String groupMinusIcon;

    public Component getBean(ValueStack stack, HttpServletRequest req,
	    HttpServletResponse res) {
	return new Grid(stack, req, res);
    }

    protected void populateParams() {
	super.populateParams();

	Grid grid = (Grid) component;
	grid.setWidth(width);
	grid.setHeight(height);
	grid.setPager(pager);
	grid.setPagerButtons(pagerButtons);
	grid.setPagerInput(pagerInput);
	grid.setPagerPosition(pagerPosition);
	grid.setRowNum(rowNum);
	grid.setSortname(sortname);
	grid.setViewrecords(viewrecords);
	grid.setAutowidth(autowidth);
	grid.setGridview(gridview);
	grid.setSortorder(sortorder);
	grid.setLoadonce(loadonce);
	grid.setMultiselect(multiselect);
	grid.setMultiboxonly(multiboxonly);
	grid.setEditurl(editurl);
	grid.setEditinline(editinline);
	grid.setCaption(caption);
	grid.setGridModel(gridModel);
	grid.setShrinkToFit(shrinkToFit);
	grid.setRowList(rowList);
	grid.setScroll(scroll);
	grid.setNavigator(navigator);
	grid.setNavigatorAddOptions(navigatorAddOptions);
	grid.setNavigatorEditOptions(navigatorEditOptions);
	grid.setNavigatorDeleteOptions(navigatorDeleteOptions);
	grid.setNavigatorViewOptions(navigatorViewOptions);
	grid.setNavigatorSearchOptions(navigatorSearchOptions);
	grid.setNavigatorAdd(navigatorAdd);
	grid.setNavigatorEdit(navigatorEdit);
	grid.setNavigatorDelete(navigatorDelete);
	grid.setNavigatorView(navigatorView);
	grid.setNavigatorSearch(navigatorSearch);
	grid.setNavigatorRefresh(navigatorRefresh);
	grid.setNavigatorExtraButtons(navigatorExtraButtons);
	grid.setNavigatorInlineEditButtons(navigatorInlineEditButtons);
	grid.setNavigatorCloneToTop(navigatorCloneToTop);
	grid.setAutoencode(autoencode);
	grid.setCellEdit(cellEdit);
	grid.setCellurl(cellurl);
	grid.setFooterrow(footerrow);
	grid.setHiddengrid(hiddengrid);
	grid.setHidegrid(hidegrid);
	grid.setHoverrows(hoverrows);
	grid.setRownumbers(rownumbers);
	grid.setMultiselectWidth(multiselectWidth);
	grid.setPage(page);
	grid.setScrollrows(scrollrows);
	grid.setFilter(filter);
	grid.setOnSelectRowTopics(onSelectRowTopics);
	grid.setOnSelectAllTopics(onSelectAllTopics);
	grid.setOnSortColTopics(onSortColTopics);
	grid.setOnPagingTopics(onPagingTopics);
	grid.setOnGridCompleteTopics(onGridCompleteTopics);
	grid.setOnEditInlineAfterSaveTopics(onEditInlineAfterSaveTopics);
	grid.setOnEditInlineBeforeTopics(onEditInlineBeforeTopics);
	grid.setOnEditInlineErrorTopics(onEditInlineErrorTopics);
	grid.setOnEditInlineSuccessTopics(onEditInlineSuccessTopics);
	grid.setOnCellEditSuccessTopics(onCellEditSuccessTopics);
	grid.setOnCellEditErrorTopics(onCellEditErrorTopics);
	grid.setOnSubGridRowExpanded(onSubGridRowExpanded);
	grid.setOnClickGroupTopics(onClickGroupTopics);
	grid.setOnDblClickRowTopics(onDblClickRowTopics);
	grid.setOnRightClickRowTopics(onRightClickRowTopics);
	grid.setReloadTopics(reloadTopics);
	grid.setOnCellSelectTopics(onCellSelectTopics);
	grid.setSubGridUrl(subGridUrl);
	grid.setSubGridWidth(subGridWidth);
	grid.setUserDataOnFooter(userDataOnFooter);
	grid.setFilterOptions(filterOptions);
	grid.setAltClass(altClass);
	grid.setAltRows(altRows);
	grid.setPrmNames(prmNames);
	grid.setDirection(direction);
	grid.setRecordpos(recordpos);
	grid.setRowTotal(rowTotal);
	grid.setViewsortcols(viewsortcols);
	grid.setToppager(toppager);

	grid.setResizable(resizable);
	grid.setResizableAnimate(resizableAnimate);
	grid.setResizableAnimateDuration(resizableAnimateDuration);
	grid.setResizableAnimateEasing(resizableAnimateEasing);
	grid.setResizableAspectRatio(resizableAspectRatio);
	grid.setResizableAutoHide(resizableAutoHide);
	grid.setResizableContainment(resizableContainment);
	grid.setResizableDelay(resizableDelay);
	grid.setResizableDistance(resizableDistance);
	grid.setResizableGhost(resizableGhost);
	grid.setResizableHelper(resizableHelper);
	grid.setResizableMaxHeight(resizableMaxHeight);
	grid.setResizableMaxWidth(resizableMaxWidth);
	grid.setResizableMinHeight(resizableMinHeight);
	grid.setResizableMinWidth(resizableMinWidth);
	grid.setResizableOnResizeTopics(resizableOnResizeTopics);
	grid.setResizableOnStartTopics(resizableOnStartTopics);
	grid.setResizableOnStopTopics(resizableOnStopTopics);
	grid.setResizableHandles(resizableHandles);

	grid.setDroppable(droppable);
	grid.setDroppableAccept(droppableAccept);
	grid.setDroppableActiveClass(droppableActiveClass);
	grid.setDroppableAddClasses(droppableAddClasses);
	grid.setDroppableGreedy(droppableGreedy);
	grid.setDroppableHoverClass(droppableHoverClass);
	grid.setDroppableScope(droppableScope);
	grid.setDroppableTolerance(droppableTolerance);
	grid.setDroppableOnActivateTopics(droppableOnActivateTopics);
	grid.setDroppableOnDeactivateTopics(droppableOnDeactivateTopics);
	grid.setDroppableOnDropTopics(droppableOnDropTopics);
	grid.setDroppableOnOutTopics(droppableOnOutTopics);
	grid.setDroppableOnOverTopics(droppableOnOverTopics);
	grid.setDraggable(draggable);
	grid.setDraggableAppendTo(draggableAppendTo);
	grid.setDraggableAxis(draggableAxis);
	grid.setDraggableCancel(draggableCancel);
	grid.setDraggableCursor(draggableCursor);
	grid.setDraggableContainment(draggableContainment);
	grid.setDraggableDelay(draggableDelay);
	grid.setDraggableDistance(draggableDistance);
	grid.setDraggableOnDragTopics(draggableOnDragTopics);
	grid.setDraggableHandle(draggableHandle);
	grid.setDraggableHelper(draggableHelper);
	grid.setDraggableIframeFix(draggableIframeFix);
	grid.setDraggableOpacity(draggableOpacity);
	grid.setDraggableRefreshPositions(draggableRefreshPositions);
	grid.setDraggableRevert(draggableRevert);
	grid.setDraggableRevertDuration(draggableRevertDuration);
	grid.setDraggableScope(draggableScope);
	grid.setDraggableScroll(draggableScroll);
	grid.setDraggableScrollSensitivity(draggableScrollSensitivity);
	grid.setDraggableScrollSpeed(draggableScrollSpeed);
	grid.setDraggableSnap(draggableSnap);
	grid.setDraggableSnapMode(draggableSnapMode);
	grid.setDraggableSnapTolerance(draggableSnapTolerance);
	grid.setDraggableOnStartTopics(draggableOnStartTopics);
	grid.setDraggableOnStopTopics(draggableOnStopTopics);
	grid.setDraggableZindex(draggableZindex);
	grid.setDraggableAddClasses(draggableAddClasses);

	grid.setSortableRows(sortableRows);
	grid.setSortable(sortable);
	grid.setSortableAppendTo(sortableAppendTo);
	grid.setSortableAxis(sortableAxis);
	grid.setSortableCancel(sortableCancel);
	grid.setSortableConnectWith(sortableConnectWith);
	grid.setSortableContainment(sortableContainment);
	grid.setSortableCursor(sortableCursor);
	grid.setSortableCursorAt(sortableCursorAt);
	grid.setSortableDelay(sortableDelay);
	grid.setSortableDistance(sortableDistance);
	grid.setSortableDropOnEmpty(sortableDropOnEmpty);
	grid.setSortableForceHelperSize(sortableForceHelperSize);
	grid.setSortableForcePlaceholderSize(sortableForcePlaceholderSize);
	grid.setSortableGrid(sortableGrid);
	grid.setSortableHandle(sortableHandle);
	grid.setSortableHelper(sortableHelper);
	grid.setSortableItems(sortableItems);
	grid.setSortableOpacity(sortableOpacity);
	grid.setSortablePlaceholder(sortablePlaceholder);
	grid.setSortableRevert(sortableRevert);
	grid.setSortableScroll(sortableScroll);
	grid.setSortableScrollSensitivity(sortableScrollSensitivity);
	grid.setSortableScrollSpeed(sortableScrollSpeed);
	grid.setSortableTolerance(sortableTolerance);
	grid.setSortableZindex(sortableZindex);
	grid.setSortableOnActivateTopics(sortableOnActivateTopics);
	grid.setSortableOnBeforeStopTopics(sortableOnBeforeStopTopics);
	grid.setSortableOnChangeTopics(sortableOnChangeTopics);
	grid.setSortableOnDeactivateTopics(sortableOnDeactivateTopics);
	grid.setSortableOnOutTopics(sortableOnOutTopics);
	grid.setSortableOnOverTopics(sortableOnOverTopics);
	grid.setSortableOnReceiveTopics(sortableOnReceiveTopics);
	grid.setSortableOnSortTopics(sortableOnSortTopics);
	grid.setSortableOnStartTopics(sortableOnStartTopics);
	grid.setSortableOnStopTopics(sortableOnStopTopics);
	grid.setSortableOnUpdateTopics(sortableOnUpdateTopics);

	grid.setConnectWith(connectWith);

	grid.setGroupField(groupField);
	grid.setGroupColumnShow(groupColumnShow);
	grid.setGroupText(groupText);
	grid.setGroupCollapse(groupCollapse);
	grid.setGroupOrder(groupOrder);
	grid.setGroupSummary(groupSummary);
	grid.setGroupDataSorted(groupDataSorted);
	grid.setGroupShowSummaryOnHide(groupShowSummaryOnHide);
	grid.setGroupPlusIcon(groupPlusIcon);
	grid.setGroupMinusIcon(groupMinusIcon);
    }

    public void setWidth(String width) {
	this.width = width;
    }

    public void setHeight(String height) {
	this.height = height;
    }

    public void setPager(String pager) {
	this.pager = pager;
    }

    public void setPagerButtons(String pagerButtons) {
	this.pagerButtons = pagerButtons;
    }

    public void setPagerPosition(String pagerPosition) {
	this.pagerPosition = pagerPosition;
    }

    public void setPagerInput(String pagerInput) {
	this.pagerInput = pagerInput;
    }

    public void setRowNum(String rowNum) {
	this.rowNum = rowNum;
    }

    public void setSortname(String sortname) {
	this.sortname = sortname;
    }

    public void setViewrecords(String viewrecords) {
	this.viewrecords = viewrecords;
    }

    public void setGridview(String gridview) {
	this.gridview = gridview;
    }

    public void setAutowidth(String autowidth) {
	this.autowidth = autowidth;
    }

    public void setSortorder(String sortorder) {
	this.sortorder = sortorder;
    }

    public void setLoadonce(String loadonce) {
	this.loadonce = loadonce;
    }

    public void setMultiselect(String multiselect) {
	this.multiselect = multiselect;
    }

    public void setMultiboxonly(String multiboxonly) {
	this.multiboxonly = multiboxonly;
    }

    public void setEditurl(String editurl) {
	this.editurl = editurl;
    }

    public void setCaption(String caption) {
	this.caption = caption;
    }

    public void setShrinkToFit(String shrinkToFit) {
	this.shrinkToFit = shrinkToFit;
    }

    public void setGridModel(String gridModel) {
	this.gridModel = gridModel;
    }

    public void setRowList(String rowList) {
	this.rowList = rowList;
    }

    public void setScroll(String scroll) {
	this.scroll = scroll;
    }

    public void setNavigator(String navigator) {
	this.navigator = navigator;
    }

    public void setNavigatorEditOptions(String navigatorEditOptions) {
	this.navigatorEditOptions = navigatorEditOptions;
    }

    public void setNavigatorAddOptions(String navigatorAddOptions) {
	this.navigatorAddOptions = navigatorAddOptions;
    }

    public void setNavigatorDeleteOptions(String navigatorDeleteOptions) {
	this.navigatorDeleteOptions = navigatorDeleteOptions;
    }

    public void setNavigatorSearchOptions(String navigatorSearchOptions) {
	this.navigatorSearchOptions = navigatorSearchOptions;
    }

    public void setNavigatorViewOptions(String navigatorViewOptions) {
	this.navigatorViewOptions = navigatorViewOptions;
    }

    public void setAutoencode(String autoencode) {
	this.autoencode = autoencode;
    }

    public void setCellEdit(String cellEdit) {
	this.cellEdit = cellEdit;
    }

    public void setCellurl(String cellurl) {
	this.cellurl = cellurl;
    }

    public void setFooterrow(String footerrow) {
	this.footerrow = footerrow;
    }

    public void setHiddengrid(String hiddengrid) {
	this.hiddengrid = hiddengrid;
    }

    public void setHidegrid(String hidegrid) {
	this.hidegrid = hidegrid;
    }

    public void setHoverrows(String hoverrows) {
	this.hoverrows = hoverrows;
    }

    public void setRownumbers(String rownumbers) {
	this.rownumbers = rownumbers;
    }

    public void setMultiselectWidth(String multiselectWidth) {
	this.multiselectWidth = multiselectWidth;
    }

    public void setPage(String page) {
	this.page = page;
    }

    public void setScrollrows(String scrollrows) {
	this.scrollrows = scrollrows;
    }

    public void setNavigatorAdd(String navigatorAdd) {
	this.navigatorAdd = navigatorAdd;
    }

    public void setNavigatorDelete(String navigatorDelete) {
	this.navigatorDelete = navigatorDelete;
    }

    public void setNavigatorEdit(String navigatorEdit) {
	this.navigatorEdit = navigatorEdit;
    }

    public void setNavigatorRefresh(String navigatorRefresh) {
	this.navigatorRefresh = navigatorRefresh;
    }

    public void setNavigatorSearch(String navigatorSearch) {
	this.navigatorSearch = navigatorSearch;
    }

    public void setNavigatorView(String navigatorView) {
	this.navigatorView = navigatorView;
    }

    public void setNavigatorExtraButtons(String navigatorExtraButtons) {
	this.navigatorExtraButtons = navigatorExtraButtons;
    }
    
    public void setNavigatorInlineEditButtons(String navigatorInlineEditButtons) {
	this.navigatorInlineEditButtons = navigatorInlineEditButtons;
    }

    public void setNavigatorCloneToTop(String navigatorCloneToTop) {
        this.navigatorCloneToTop = navigatorCloneToTop;
    }

    public void setFilter(String filter) {
	this.filter = filter;
    }
    
    public void setToppager(String toppager) {
        this.toppager = toppager;
    }

    public void setOnSelectRowTopics(String onSelectRowTopics) {
	this.onSelectRowTopics = onSelectRowTopics;
    }

    public void setOnSelectAllTopics(String onSelectAllTopics) {
	this.onSelectAllTopics = onSelectAllTopics;
    }

    public void setOnPagingTopics(String onPagingTopics) {
	this.onPagingTopics = onPagingTopics;
    }

    public void setOnSortColTopics(String onSortColTopics) {
	this.onSortColTopics = onSortColTopics;
    }

    public void setOnCellSelectTopics(String onCellSelectTopics) {
	this.onCellSelectTopics = onCellSelectTopics;
    }

    public void setOnGridCompleteTopics(String onGridCompleteTopics) {
	this.onGridCompleteTopics = onGridCompleteTopics;
    }

    public void setOnEditInlineBeforeTopics(String onEditInlineBeforeTopics) {
	this.onEditInlineBeforeTopics = onEditInlineBeforeTopics;
    }

    public void setOnEditInlineSuccessTopics(String onEditInlineSuccessTopics) {
	this.onEditInlineSuccessTopics = onEditInlineSuccessTopics;
    }

    public void setOnEditInlineErrorTopics(String onEditInlineErrorTopics) {
	this.onEditInlineErrorTopics = onEditInlineErrorTopics;
    }

    public void setOnEditInlineAfterSaveTopics(
	    String onEditInlineAfterSaveTopics) {
	this.onEditInlineAfterSaveTopics = onEditInlineAfterSaveTopics;
    }

    public void setEditinline(String editinline) {
	this.editinline = editinline;
    }

    public void setSubGridWidth(String subGridWidth) {
	this.subGridWidth = subGridWidth;
    }

    public void setSubGridUrl(String subGridUrl) {
	this.subGridUrl = subGridUrl;
    }

    public void setUserDataOnFooter(String userDataOnFooter) {
	this.userDataOnFooter = userDataOnFooter;
    }

    public void setFilterOptions(String filterOptions) {
	this.filterOptions = filterOptions;
    }

    public void setAltClass(String altClass) {
	this.altClass = altClass;
    }

    public void setAltRows(String altRows) {
	this.altRows = altRows;
    }

    public void setPrmNames(String prmNames) {
	this.prmNames = prmNames;
    }

    public void setDirection(String direction) {
	this.direction = direction;
    }

    public void setRecordpos(String recordpos) {
	this.recordpos = recordpos;
    }

    public void setRowTotal(String rowTotal) {
	this.rowTotal = rowTotal;
    }

    public void setViewsortcols(String viewsortcols) {
	this.viewsortcols = viewsortcols;
    }

    public void setResizableAnimate(String animate) {
	this.resizableAnimate = animate;
    }

    public void setResizableAnimateDuration(String animateDuration) {
	this.resizableAnimateDuration = animateDuration;
    }

    public void setResizableAnimateEasing(String animateEasing) {
	this.resizableAnimateEasing = animateEasing;
    }

    public void setResizableAspectRatio(String aspectRatio) {
	this.resizableAspectRatio = aspectRatio;
    }

    public void setResizableAutoHide(String autoHide) {
	this.resizableAutoHide = autoHide;
    }

    public void setResizableContainment(String containment) {
	this.resizableContainment = containment;
    }

    public void setResizableDelay(String delay) {
	this.resizableDelay = delay;
    }

    public void setResizableDistance(String distance) {
	this.resizableDistance = distance;
    }

    public void setResizableGhost(String ghost) {
	this.resizableGhost = ghost;
    }

    public void setResizableHelper(String helper) {
	this.resizableHelper = helper;
    }

    public void setResizableMaxHeight(String maxHeight) {
	this.resizableMaxHeight = maxHeight;
    }

    public void setResizableMaxWidth(String maxWidth) {
	this.resizableMaxWidth = maxWidth;
    }

    public void setResizableMinHeight(String minHeight) {
	this.resizableMinHeight = minHeight;
    }

    public void setResizableMinWidth(String minWidth) {
	this.resizableMinWidth = minWidth;
    }

    public void setResizableOnResizeTopics(String resize) {
	this.resizableOnResizeTopics = resize;
    }

    public void setResizableOnStartTopics(String start) {
	this.resizableOnStartTopics = start;
    }

    public void setResizableOnStopTopics(String stop) {
	this.resizableOnStopTopics = stop;
    }

    public void setResizable(String resizable) {
	this.resizable = resizable;
    }

    public void setResizableHandles(String resizableHandles) {
	this.resizableHandles = resizableHandles;
    }

    public void setDroppable(String droppable) {
	this.droppable = droppable;
    }

    public void setDroppableAccept(String droppableAccept) {
	this.droppableAccept = droppableAccept;
    }

    public void setDroppableActiveClass(String droppableActiveClass) {
	this.droppableActiveClass = droppableActiveClass;
    }

    public void setDroppableAddClasses(String droppableAddClasses) {
	this.droppableAddClasses = droppableAddClasses;
    }

    public void setDroppableGreedy(String droppableGreedy) {
	this.droppableGreedy = droppableGreedy;
    }

    public void setDroppableHoverClass(String droppableHoverClass) {
	this.droppableHoverClass = droppableHoverClass;
    }

    public void setDroppableScope(String droppableScope) {
	this.droppableScope = droppableScope;
    }

    public void setDroppableTolerance(String droppableTolerance) {
	this.droppableTolerance = droppableTolerance;
    }

    public void setDroppableOnActivateTopics(String droppableOnActivateTopics) {
	this.droppableOnActivateTopics = droppableOnActivateTopics;
    }

    public void setDroppableOnDeactivateTopics(
	    String droppableOnDeactivateTopics) {
	this.droppableOnDeactivateTopics = droppableOnDeactivateTopics;
    }

    public void setDroppableOnDropTopics(String droppableOnDropTopics) {
	this.droppableOnDropTopics = droppableOnDropTopics;
    }

    public void setDroppableOnOutTopics(String droppableOnOutTopics) {
	this.droppableOnOutTopics = droppableOnOutTopics;
    }

    public void setDroppableOnOverTopics(String droppableOnOverTopics) {
	this.droppableOnOverTopics = droppableOnOverTopics;
    }

    public void setDraggable(String draggable) {
	this.draggable = draggable;
    }

    public void setDraggableAppendTo(String draggableAppendTo) {
	this.draggableAppendTo = draggableAppendTo;
    }

    public void setDraggableAxis(String draggableAxis) {
	this.draggableAxis = draggableAxis;
    }

    public void setDraggableCancel(String draggableCancel) {
	this.draggableCancel = draggableCancel;
    }

    public void setDraggableCursor(String draggableCursor) {
	this.draggableCursor = draggableCursor;
    }

    public void setDraggableContainment(String draggableContainment) {
	this.draggableContainment = draggableContainment;
    }

    public void setDraggableDelay(String draggableDelay) {
	this.draggableDelay = draggableDelay;
    }

    public void setDraggableDistance(String draggableDistance) {
	this.draggableDistance = draggableDistance;
    }

    public void setDraggableOnDragTopics(String draggableOnDragTopics) {
	this.draggableOnDragTopics = draggableOnDragTopics;
    }

    public void setDraggableHandle(String draggableHandle) {
	this.draggableHandle = draggableHandle;
    }

    public void setDraggableHelper(String draggableHelper) {
	this.draggableHelper = draggableHelper;
    }

    public void setDraggableIframeFix(String draggableIframeFix) {
	this.draggableIframeFix = draggableIframeFix;
    }

    public void setDraggableOpacity(String draggableOpacity) {
	this.draggableOpacity = draggableOpacity;
    }

    public void setDraggableRefreshPositions(String draggableRefreshPositions) {
	this.draggableRefreshPositions = draggableRefreshPositions;
    }

    public void setDraggableRevert(String draggableRevert) {
	this.draggableRevert = draggableRevert;
    }

    public void setDraggableRevertDuration(String draggableRevertDuration) {
	this.draggableRevertDuration = draggableRevertDuration;
    }

    public void setDraggableScope(String draggableScope) {
	this.draggableScope = draggableScope;
    }

    public void setDraggableScroll(String draggableScroll) {
	this.draggableScroll = draggableScroll;
    }

    public void setDraggableScrollSensitivity(String draggableScrollSensitivity) {
	this.draggableScrollSensitivity = draggableScrollSensitivity;
    }

    public void setDraggableScrollSpeed(String draggableScrollSpeed) {
	this.draggableScrollSpeed = draggableScrollSpeed;
    }

    public void setDraggableSnap(String draggableSnap) {
	this.draggableSnap = draggableSnap;
    }

    public void setDraggableSnapMode(String draggableSnapMode) {
	this.draggableSnapMode = draggableSnapMode;
    }

    public void setDraggableSnapTolerance(String draggableSnapTolerance) {
	this.draggableSnapTolerance = draggableSnapTolerance;
    }

    public void setDraggableOnStartTopics(String draggableOnStartTopics) {
	this.draggableOnStartTopics = draggableOnStartTopics;
    }

    public void setDraggableOnStopTopics(String draggableOnStopTopics) {
	this.draggableOnStopTopics = draggableOnStopTopics;
    }

    public void setDraggableZindex(String draggableZindex) {
	this.draggableZindex = draggableZindex;
    }

    public void setDraggableAddClasses(String draggableAddClasses) {
	this.draggableAddClasses = draggableAddClasses;
    }

    public void setSortableZindex(String sortableZindex) {
	this.sortableZindex = sortableZindex;
    }

    public void setSortableTolerance(String sortableTolerance) {
	this.sortableTolerance = sortableTolerance;
    }

    public void setSortableScrollSpeed(String sortableScrollSpeed) {
	this.sortableScrollSpeed = sortableScrollSpeed;
    }

    public void setSortableScrollSensitivity(String sortableScrollSensitivity) {
	this.sortableScrollSensitivity = sortableScrollSensitivity;
    }

    public void setSortableScroll(String sortableScroll) {
	this.sortableScroll = sortableScroll;
    }

    public void setSortableRevert(String sortableRevert) {
	this.sortableRevert = sortableRevert;
    }

    public void setSortablePlaceholder(String sortablePlaceholder) {
	this.sortablePlaceholder = sortablePlaceholder;
    }

    public void setSortableOpacity(String sortableOpacity) {
	this.sortableOpacity = sortableOpacity;
    }

    public void setSortableItems(String sortableItems) {
	this.sortableItems = sortableItems;
    }

    public void setSortableHelper(String sortableHelper) {
	this.sortableHelper = sortableHelper;
    }

    public void setSortableHandle(String sortableHandle) {
	this.sortableHandle = sortableHandle;
    }

    public void setSortableGrid(String sortableGrid) {
	this.sortableGrid = sortableGrid;
    }

    public void setSortableForcePlaceholderSize(
	    String sortableForcePlaceholderSize) {
	this.sortableForcePlaceholderSize = sortableForcePlaceholderSize;
    }

    public void setSortableForceHelperSize(String sortableForceHelperSize) {
	this.sortableForceHelperSize = sortableForceHelperSize;
    }

    public void setSortableDropOnEmpty(String sortableDropOnEmpty) {
	this.sortableDropOnEmpty = sortableDropOnEmpty;
    }

    public void setSortableDistance(String sortableDistance) {
	this.sortableDistance = sortableDistance;
    }

    public void setSortableDelay(String sortableDelay) {
	this.sortableDelay = sortableDelay;
    }

    public void setSortableCursorAt(String sortableCursorAt) {
	this.sortableCursorAt = sortableCursorAt;
    }

    public void setSortableCursor(String sortableCursor) {
	this.sortableCursor = sortableCursor;
    }

    public void setSortableContainment(String sortableContainment) {
	this.sortableContainment = sortableContainment;
    }

    public void setSortableConnectWith(String sortableConnectWith) {
	this.sortableConnectWith = sortableConnectWith;
    }

    public void setSortableCancel(String sortableCancel) {
	this.sortableCancel = sortableCancel;
    }

    public void setSortableAxis(String sortableAxis) {
	this.sortableAxis = sortableAxis;
    }

    public void setSortableAppendTo(String sortableAppendTo) {
	this.sortableAppendTo = sortableAppendTo;
    }

    public void setSortableOnDeactivateTopics(String sortableDeactivate) {
	this.sortableOnDeactivateTopics = sortableDeactivate;
    }

    public void setSortableOnChangeTopics(String sortableChange) {
	this.sortableOnChangeTopics = sortableChange;
    }

    public void setSortableOnBeforeStopTopics(String sortableBeforeStop) {
	this.sortableOnBeforeStopTopics = sortableBeforeStop;
    }

    public void setSortableOnActivateTopics(String sortableActivate) {
	this.sortableOnActivateTopics = sortableActivate;
    }

    public void setSortableOnUpdateTopics(String sortableUpdate) {
	this.sortableOnUpdateTopics = sortableUpdate;
    }

    public void setSortableOnStopTopics(String sortableStop) {
	this.sortableOnStopTopics = sortableStop;
    }

    public void setSortableOnStartTopics(String sortableStart) {
	this.sortableOnStartTopics = sortableStart;
    }

    public void setSortableOnSortTopics(String sortableSort) {
	this.sortableOnSortTopics = sortableSort;
    }

    public void setSortableOnRemoveTopics(String sortableRemove) {
	this.sortableOnRemoveTopics = sortableRemove;
    }

    public void setSortableOnReceiveTopics(String sortableReceive) {
	this.sortableOnReceiveTopics = sortableReceive;
    }

    public void setSortableOnOverTopics(String sortableOver) {
	this.sortableOnOverTopics = sortableOver;
    }

    public void setSortableOnOutTopics(String sortableOut) {
	this.sortableOnOutTopics = sortableOut;
    }

    public void setSortable(String sortable) {
	this.sortable = sortable;
    }

    public void setSortableRows(String sortableRows) {
	this.sortableRows = sortableRows;
    }

    public void setConnectWith(String connectWith) {
	this.connectWith = connectWith;
    }

    public void setReloadTopics(String reloadTopics) {
	this.reloadTopics = reloadTopics;
    }

    public void setGroupField(String groupField) {
	this.groupField = groupField;
    }

    public void setGroupColumnShow(String groupColumnShow) {
	this.groupColumnShow = groupColumnShow;
    }

    public void setGroupText(String groupText) {
	this.groupText = groupText;
    }

    public void setGroupCollapse(String groupCollapse) {
	this.groupCollapse = groupCollapse;
    }

    public void setGroupOrder(String groupOrder) {
	this.groupOrder = groupOrder;
    }

    public void setGroupSummary(String groupSummary) {
	this.groupSummary = groupSummary;
    }

    public void setGroupDataSorted(String groupDataSorted) {
	this.groupDataSorted = groupDataSorted;
    }

    public void setGroupShowSummaryOnHide(String groupShowSummaryOnHide) {
	this.groupShowSummaryOnHide = groupShowSummaryOnHide;
    }

    public void setGroupPlusIcon(String groupPlusIcon) {
	this.groupPlusIcon = groupPlusIcon;
    }

    public void setGroupMinusIcon(String groupMinusIcon) {
	this.groupMinusIcon = groupMinusIcon;
    }

    public void setOnCellEditSuccessTopics(String onCellEditSuccessTopics) {
	this.onCellEditSuccessTopics = onCellEditSuccessTopics;
    }

    public void setOnCellEditErrorTopics(String onCellEditErrorTopics) {
	this.onCellEditErrorTopics = onCellEditErrorTopics;
    }

    public void setOnSubGridRowExpanded(String onSubGridRowExpanded) {
	this.onSubGridRowExpanded = onSubGridRowExpanded;
    }

    public void setOnClickGroupTopics(String onClickGroupTopics) {
        this.onClickGroupTopics = onClickGroupTopics;
    }

    public void setOnDblClickRowTopics(String onDblClickRowTopics) {
        this.onDblClickRowTopics = onDblClickRowTopics;
    }

    public void setOnRightClickRowTopics(String onRightClickRowTopics) {
        this.onRightClickRowTopics = onRightClickRowTopics;
    }

}
