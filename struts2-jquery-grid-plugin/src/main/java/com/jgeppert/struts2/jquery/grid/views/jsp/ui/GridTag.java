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

import com.jgeppert.struts2.jquery.grid.components.Grid;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractContainerTag;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 * @see Grid
 */
public class GridTag extends AbstractContainerTag {

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
    protected String sortableRows;
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

    protected String guiStyle;
    protected String iconSet;

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
        grid.setSortableRows(sortableRows);
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
        grid.setGuiStyle(guiStyle);
        grid.setIconSet(iconSet);
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

    public void setOnEditInlineAfterSaveTopics(String onEditInlineAfterSaveTopics) {
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

    public void setGuiStyle(String guiStyle) {
        this.guiStyle = guiStyle;
    }

    public void setIconSet(String iconSet) {
        this.iconSet = iconSet;
    }
}
