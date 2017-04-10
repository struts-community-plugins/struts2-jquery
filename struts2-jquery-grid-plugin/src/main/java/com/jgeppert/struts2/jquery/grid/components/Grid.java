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

package com.jgeppert.struts2.jquery.grid.components;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.BooleanUtils;
import org.apache.struts2.components.Component;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractContainer;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render an grid from a JSON Result.
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * <p>
 * <p>
 * Examples:
 * </p>
 *
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "grid", tldTagClass = "com.jgeppert.struts2.jquery.grid.views.jsp.ui.GridTag", description = "Render an grid from a JSON Result.")
public class Grid extends AbstractContainer {

    public static final String JQUERYACTION = "grid";
    public static final String TEMPLATE = "grid";
    public static final String TEMPLATE_CLOSE = "grid-close";
    public static final String COMPONENT_NAME = Grid.class.getName();

    private static final String PARAM_NAVIGATOR_EXTRA_BUTTONS = "navigatorExtraButtons";
    private static final String PARAM_SUB_GRID = "subGrid";
    private static final String PARAM_PARENT_GRID = "parentGrid";
    private static final String PARAM_SUB_GRID_URL = "subGridUrl";
    private static final String PARAM_SUB_GRID_WIDTH = "subGridWidth";
    private static final String PARAM_WIDTH = "width";
    private static final String PARAM_HEIGHT = "height";
    private static final String PARAM_PAGER = "pager";
    private static final String PARAM_PAGER_BUTTONS = "pagerButtons";
    private static final String PARAM_PAGER_INPUT = "pagerInput";
    private static final String PARAM_PAGER_POSITION = "pagerPosition";
    private static final String PARAM_ROW_NUM = "rowNum";
    private static final String PARAM_SORTNAME = "sortname";
    private static final String PARAM_VIEWRECORDS = "viewrecords";
    private static final String PARAM_AUTOWIDTH = "autowidth";
    private static final String PARAM_GRIDVIEW = "gridview";
    private static final String PARAM_SORTORDER = "sortorder";
    private static final String PARAM_LOADONCE = "loadonce";
    private static final String PARAM_MULTISELECT = "multiselect";
    private static final String PARAM_MULTIBOXONLY = "multiboxonly";
    private static final String PARAM_EDITURL = "editurl";
    private static final String PARAM_EDITINLINE = "editinline";
    private static final String PARAM_CAPTION = "caption";
    private static final String PARAM_SHRINK_TO_FIT = "shrinkToFit";
    private static final String PARAM_GRID_MODEL = "gridModel";
    private static final String PARAM_SCROLL = "scroll";
    private static final String PARAM_ROW_LIST = "rowList";
    private static final String PARAM_NAVIGATOR = "navigator";
    private static final String PARAM_NAVIGATOR_ADD_OPTIONS = "navigatorAddOptions";
    private static final String PARAM_NAVIGATOR_EDIT_OPTIONS = "navigatorEditOptions";
    private static final String PARAM_NAVIGATOR_DELETE_OPTIONS = "navigatorDeleteOptions";
    private static final String PARAM_NAVIGATOR_VIEW_OPTIONS = "navigatorViewOptions";
    private static final String PARAM_NAVIGATOR_SEARCH_OPTIONS = "navigatorSearchOptions";
    private static final String PARAM_NAVIGATOR_ADD = "navigatorAdd";
    private static final String PARAM_NAVIGATOR_DELETE = "navigatorDelete";
    private static final String PARAM_NAVIGATOR_EDIT = "navigatorEdit";
    private static final String PARAM_NAVIGATOR_REFRESH = "navigatorRefresh";
    private static final String PARAM_NAVIGATOR_VIEW = "navigatorView";
    private static final String PARAM_NAVIGATOR_SEARCH = "navigatorSearch";
    private static final String PARAM_NAVIGATOR_INLINE_EDIT_BUTTONS = "navigatorInlineEditButtons";
    private static final String PARAM_NAVIGATOR_CLONE_TO_TOP = "navigatorCloneToTop";
    private static final String PARAM_CELLURL = "cellurl";
    private static final String PARAM_MULTISELECT_WIDTH = "multiselectWidth";
    private static final String PARAM_PAGE = "page";
    private static final String PARAM_AUTOENCODE = "autoencode";
    private static final String PARAM_CELL_EDIT = "cellEdit";
    private static final String PARAM_FOOTERROW = "footerrow";
    private static final String PARAM_HIDDENGRID = "hiddengrid";
    private static final String PARAM_HIDEGRID = "hidegrid";
    private static final String PARAM_HOVERROWS = "hoverrows";
    private static final String PARAM_ROWNUMBERS = "rownumbers";
    private static final String PARAM_SCROLLROWS = "scrollrows";
    private static final String PARAM_FILTER = "filter";
    private static final String PARAM_FILTER_OPTIONS = "filterOptions";
    private static final String PARAM_USER_DATA_ON_FOOTER = "userDataOnFooter";
    private static final String PARAM_ALT_CLASS = "altClass";
    private static final String PARAM_ALT_ROWS = "altRows";
    private static final String PARAM_PRM_NAMES = "prmNames";
    private static final String PARAM_DIRECTION = "direction";
    private static final String PARAM_RECORDPOS = "recordpos";
    private static final String PARAM_ROW_TOTAL = "rowTotal";
    private static final String PARAM_VIEWSORTCOLS = "viewsortcols";
    private static final String PARAM_TOPPAGER = "toppager";
    private static final String PARAM_ON_SELECT_ROW_TOPICS = "onSelectRowTopics";
    private static final String PARAM_ON_SELECT_ALL_TOPICS = "onSelectAllTopics";
    private static final String PARAM_ON_CELL_SELECT_TOPICS = "onCellSelectTopics";
    private static final String PARAM_ON_PAGING_TOPICS = "onPagingTopics";
    private static final String PARAM_ON_SORT_COL_TOPICS = "onSortColTopics";
    private static final String PARAM_ON_GRID_COMPLETE_TOPICS = "onGridCompleteTopics";
    private static final String PARAM_ON_EDIT_INLINE_AFTER_SAVE_TOPICS = "onEditInlineAfterSaveTopics";
    private static final String PARAM_ON_EDIT_INLINE_BEFORE_TOPICS = "onEditInlineBeforeTopics";
    private static final String PARAM_ON_EDIT_INLINE_ERROR_TOPICS = "onEditInlineErrorTopics";
    private static final String PARAM_ON_EDIT_INLINE_SUCCESS_TOPICS = "onEditInlineSuccessTopics";
    private static final String PARAM_ON_CELL_EDIT_ERROR_TOPICS = "onCellEditErrorTopics";
    private static final String PARAM_ON_CELL_EDIT_SUCCESS_TOPICS = "onCellEditSuccessTopics";
    private static final String PARAM_ON_SUB_GRID_ROW_EXPANDED = "onSubGridRowExpanded";
    private static final String PARAM_ON_CLICK_GROUP_TOPICS = "onClickGroupTopics";
    private static final String PARAM_ON_DBL_CLICK_ROW_TOPICS = "onDblClickRowTopics";
    private static final String PARAM_ON_RIGHT_CLICK_ROW_TOPICS = "onRightClickRowTopics";
    private static final String PARAM_RELOAD_TOPICS = "reloadTopics";
    private static final String PARAM_CONNECT_WITH = "connectWith";
    private static final String PARAM_GROUP_FIELD = "groupField";
    private static final String PARAM_GROUP_COLUMN_SHOW = "groupColumnShow";
    private static final String PARAM_GROUP_TEXT = "groupText";
    private static final String PARAM_GROUP_ORDER = "groupOrder";
    private static final String PARAM_GROUP_SUMMARY = "groupSummary";
    private static final String PARAM_GROUP_SHOW_SUMMARY_ON_HIDE = "groupShowSummaryOnHide";
    private static final String PARAM_GROUP_PLUS_ICON = "groupPlusIcon";
    private static final String PARAM_GROUP_MINUS_ICON = "groupMinusIcon";
    private static final String PARAM_GROUP_DATA_SORTED = "groupDataSorted";
    private static final String PARAM_GROUP_COLLAPSE = "groupCollapse";
    private static final String PARAM_SORTABLE_ROWS = "sortableRows";

    private static final String ID_PREFIX_GRID = "grid_";

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
    protected String navigatorInlineEditButtons;
    protected String navigatorExtraButtons;
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
    protected String sortableRows;

    public Grid(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
        super(stack, request, response);
    }

    @Override
    public String getDefaultOpenTemplate() {
        return TEMPLATE;
    }

    @Override
    protected String getDefaultTemplate() {
        return TEMPLATE_CLOSE;
    }

    @Override
    public void evaluateExtraParams() {
        super.evaluateExtraParams();

        addParameter(PARAM_JQUERY_ACTION, JQUERYACTION);

        Component parentGrid = findAncestor(Grid.class);
        if (parentGrid != null) {
            addParameter(PARAM_SUB_GRID, true);
            addParameter(PARAM_PARENT_GRID, findString(((Grid) parentGrid).getId()));
            addParameterIfPresent(PARAM_SUB_GRID_URL, this.subGridUrl);
            addParameterIfPresent(PARAM_SUB_GRID_WIDTH, this.subGridWidth);
        }
        addParameterIfPresent(PARAM_WIDTH, this.width);
        addParameterIfPresent(PARAM_HEIGHT, this.height);
        addParameterIfPresent(PARAM_PAGER, this.pager, Boolean.class);
        addParameterIfPresent(PARAM_PAGER_BUTTONS, this.pagerButtons, Boolean.class);
        addParameterIfPresent(PARAM_PAGER_INPUT, this.pagerInput, Boolean.class);
        addParameterIfPresent(PARAM_PAGER_POSITION, this.pagerPosition);
        addParameterIfPresent(PARAM_ROW_NUM, this.rowNum);
        addParameterIfPresent(PARAM_SORTNAME, this.sortname);
        addParameterIfPresent(PARAM_SORTORDER, this.sortorder);
        addParameterIfPresent(PARAM_VIEWRECORDS, this.viewrecords, Boolean.class);
        addParameterIfPresent(PARAM_AUTOWIDTH, this.autowidth, Boolean.class);
        addParameterIfPresent(PARAM_GRIDVIEW, this.gridview, Boolean.class);
        addParameterIfPresent(PARAM_LOADONCE, this.loadonce, Boolean.class);
        addParameterIfPresent(PARAM_MULTISELECT, this.multiselect, Boolean.class);
        addParameterIfPresent(PARAM_MULTIBOXONLY, this.multiboxonly, Boolean.class);
        addParameterIfPresent(PARAM_EDITURL, this.editurl);
        addParameterIfPresent(PARAM_EDITINLINE, this.editinline, Boolean.class);
        addParameterIfPresent(PARAM_CAPTION, this.caption);
        addParameterIfPresent(PARAM_SHRINK_TO_FIT, this.shrinkToFit, Boolean.class);
        addParameterIfPresent(PARAM_GRID_MODEL, this.gridModel);
        addParameterIfPresent(PARAM_SCROLL, this.scroll);
        addParameterIfPresent(PARAM_ROW_LIST, this.rowList);
        addParameterIfPresent(PARAM_NAVIGATOR, this.navigator, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_ADD_OPTIONS, this.navigatorAddOptions);
        addParameterIfPresent(PARAM_NAVIGATOR_EDIT_OPTIONS, this.navigatorEditOptions);
        addParameterIfPresent(PARAM_NAVIGATOR_DELETE_OPTIONS, this.navigatorDeleteOptions);
        addParameterIfPresent(PARAM_NAVIGATOR_VIEW_OPTIONS, this.navigatorViewOptions);
        addParameterIfPresent(PARAM_NAVIGATOR_SEARCH_OPTIONS, this.navigatorSearchOptions);
        addParameterIfPresent(PARAM_NAVIGATOR_ADD, this.navigatorAdd, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_DELETE, this.navigatorDelete, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_EDIT, this.navigatorEdit, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_REFRESH, this.navigatorRefresh, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_VIEW, this.navigatorView, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_SEARCH, this.navigatorSearch, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_EXTRA_BUTTONS, this.navigatorExtraButtons);
        addParameterIfPresent(PARAM_NAVIGATOR_INLINE_EDIT_BUTTONS, this.navigatorInlineEditButtons, Boolean.class);
        addParameterIfPresent(PARAM_NAVIGATOR_CLONE_TO_TOP, this.navigatorCloneToTop, Boolean.class);
        addParameterIfPresent(PARAM_CELLURL, this.cellurl);
        addParameterIfPresent(PARAM_MULTISELECT_WIDTH, this.multiselectWidth);
        addParameterIfPresent(PARAM_PAGE, this.page);
        addParameterIfPresent(PARAM_AUTOENCODE, this.autoencode, Boolean.class);
        addParameterIfPresent(PARAM_CELL_EDIT, this.cellEdit, Boolean.class);
        addParameterIfPresent(PARAM_FOOTERROW, this.footerrow, Boolean.class);
        addParameterIfPresent(PARAM_HIDDENGRID, this.hiddengrid, Boolean.class);
        addParameterIfPresent(PARAM_HIDEGRID, this.hidegrid, Boolean.class);
        addParameterIfPresent(PARAM_HOVERROWS, this.hoverrows, Boolean.class);
        addParameterIfPresent(PARAM_ROWNUMBERS, this.rownumbers, Boolean.class);
        addParameterIfPresent(PARAM_SCROLLROWS, this.scrollrows, Boolean.class);
        addParameterIfPresent(PARAM_FILTER, this.filter, Boolean.class);
        addParameterIfPresent(PARAM_FILTER_OPTIONS, this.filterOptions);
        addParameterIfPresent(PARAM_USER_DATA_ON_FOOTER, this.userDataOnFooter, Boolean.class);
        addParameterIfPresent(PARAM_ALT_CLASS, this.altClass);
        addParameterIfPresent(PARAM_ALT_ROWS, this.altRows, Boolean.class);
        addParameterIfPresent(PARAM_PRM_NAMES, this.prmNames);
        addParameterIfPresent(PARAM_DIRECTION, this.direction);
        addParameterIfPresent(PARAM_RECORDPOS, this.recordpos);
        addParameterIfPresent(PARAM_ROW_TOTAL, this.rowTotal, Integer.class);
        addParameterIfPresent(PARAM_VIEWSORTCOLS, this.viewsortcols);
        addParameterIfPresent(PARAM_TOPPAGER, this.toppager, Boolean.class);
        addParameterIfPresent(PARAM_ON_SELECT_ROW_TOPICS, this.onSelectRowTopics);
        addParameterIfPresent(PARAM_ON_SELECT_ALL_TOPICS, this.onSelectAllTopics);
        addParameterIfPresent(PARAM_ON_CELL_SELECT_TOPICS, this.onCellSelectTopics);
        addParameterIfPresent(PARAM_ON_PAGING_TOPICS, this.onPagingTopics);
        addParameterIfPresent(PARAM_ON_SORT_COL_TOPICS, this.onSortColTopics);
        addParameterIfPresent(PARAM_ON_GRID_COMPLETE_TOPICS, this.onGridCompleteTopics);
        addParameterIfPresent(PARAM_ON_EDIT_INLINE_AFTER_SAVE_TOPICS, this.onEditInlineAfterSaveTopics);
        addParameterIfPresent(PARAM_ON_EDIT_INLINE_BEFORE_TOPICS, this.onEditInlineBeforeTopics);
        addParameterIfPresent(PARAM_ON_EDIT_INLINE_ERROR_TOPICS, this.onEditInlineErrorTopics);
        addParameterIfPresent(PARAM_ON_EDIT_INLINE_SUCCESS_TOPICS, this.onEditInlineSuccessTopics);
        addParameterIfPresent(PARAM_ON_CELL_EDIT_ERROR_TOPICS, this.onCellEditErrorTopics);
        addParameterIfPresent(PARAM_ON_CELL_EDIT_SUCCESS_TOPICS, this.onCellEditSuccessTopics);
        addParameterIfPresent(PARAM_ON_SUB_GRID_ROW_EXPANDED, this.onSubGridRowExpanded);
        addParameterIfPresent(PARAM_ON_CLICK_GROUP_TOPICS, this.onClickGroupTopics);
        addParameterIfPresent(PARAM_ON_DBL_CLICK_ROW_TOPICS, this.onDblClickRowTopics);
        addParameterIfPresent(PARAM_ON_RIGHT_CLICK_ROW_TOPICS, this.onRightClickRowTopics);
        addParameterIfPresent(PARAM_RELOAD_TOPICS, this.reloadTopics);
        addParameterIfPresent(PARAM_CONNECT_WITH, this.connectWith);
        addParameterIfPresent(PARAM_GROUP_FIELD, this.groupField);
        addParameterIfPresent(PARAM_GROUP_COLUMN_SHOW, this.groupColumnShow);
        addParameterIfPresent(PARAM_GROUP_TEXT, this.groupText);
        addParameterIfPresent(PARAM_GROUP_ORDER, this.groupOrder);
        addParameterIfPresent(PARAM_GROUP_SUMMARY, this.groupSummary);
        addParameterIfPresent(PARAM_GROUP_SHOW_SUMMARY_ON_HIDE, this.groupShowSummaryOnHide, Boolean.class);
        addParameterIfPresent(PARAM_GROUP_PLUS_ICON, this.groupPlusIcon);
        addParameterIfPresent(PARAM_GROUP_MINUS_ICON, this.groupMinusIcon);
        addParameterIfPresent(PARAM_GROUP_DATA_SORTED, this.groupDataSorted, Boolean.class);
        addParameterIfPresent(PARAM_GROUP_COLLAPSE, this.groupCollapse, Boolean.class);

        if (sortableRows != null) {
            String sortableValue = findString(sortableRows);
            if (BooleanUtils.toBoolean(sortableValue)) {
                addParameter(PARAM_SORTABLE_ROWS, Boolean.TRUE);
            }
        }
        addGeneratedIdParam(ID_PREFIX_GRID);
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

    @StrutsTagAttribute(description = "If this option is not set, the width of the grid is a sum of the widths of the columns defined in the colModel (in pixels). If this option is set, the initial width of each column is set according to the value of shrinkToFit option.")
    public void setWidth(String width) {
        this.width = width;
    }

    @StrutsTagAttribute(description = "The height of the grid. Can be set as number e.g. 400. Default: auto")
    public void setHeight(String height) {
        this.height = height;
    }

    @StrutsTagAttribute(description = "Defines that we want to use a pager bar to navigate through the records. This must be a true or false.", defaultValue = "false", type = "Boolean")
    public void setPager(String pager) {
        this.pager = pager;
    }

    @StrutsTagAttribute(description = "Determines if the Pager buttons should be shown if pager is available. Also valid only if pager is set correctly. The buttons are placed in the pager bar.", defaultValue = "true", type = "Boolean")
    public void setPagerButtons(String pagerButtons) {
        this.pagerButtons = pagerButtons;
    }

    @StrutsTagAttribute(description = "Determines the position of the pager in the grid. By default the pager element when created is divided in 3 parts. Can be left, center, right", defaultValue = "center")
    public void setPagerPosition(String pagerPosition) {
        this.pagerPosition = pagerPosition;
    }

    @StrutsTagAttribute(description = "DDetermines if the input box, where the user can change the number of requested page, should be available. The input box appear in the pager bar.", defaultValue = "true", type = "Boolean")
    public void setPagerInput(String pagerInput) {
        this.pagerInput = pagerInput;
    }

    @StrutsTagAttribute(description = "Sets how many records we want to view in the grid. This parameter is passed to the url for use by the server routine retrieving the data. Note that if you set this parameter to 10 (i.e. retrieve 10 records) and your server return 15 then only 10 records will be loaded. Set this parameter to -1 (unlimited) to disable this checking. Default: 20")
    public void setRowNum(String rowNum) {
        this.rowNum = rowNum;
    }

    @StrutsTagAttribute(description = "The initial sorting name. This parameter is added to the url. If set and the index (name) match the name from colModel then to this column by default is added a image sorting icon, according to the parameter sortorder (below).")
    public void setSortname(String sortname) {
        this.sortname = sortname;
    }

    @StrutsTagAttribute(description = "Defines whether we want to display the number of total records from the query in the pager bar.", defaultValue = "false", type = "Boolean")
    public void setViewrecords(String viewrecords) {
        this.viewrecords = viewrecords;
    }

    @StrutsTagAttribute(description = "Insert the entry row at once with a jQuery append. The result is impressive - about 3-5 times faster. If set to true we can not use treeGrid, subGrid, or afterInsertRow event.", defaultValue = "false", type = "Boolean")
    public void setGridview(String gridview) {
        this.gridview = gridview;
    }

    @StrutsTagAttribute(description = "When set to true, the grid width is recalculated automatically to the width of the parent element. This is done only initially when the grid is created.", defaultValue = "false", type = "Boolean")
    public void setAutowidth(String autowidth) {
        this.autowidth = autowidth;
    }

    @StrutsTagAttribute(description = "The initial sorting order.This parameter is added to the url - see prnNames. Two possible values - asc or desc. Default asc")
    public void setSortorder(String sortorder) {
        this.sortorder = sortorder;
    }

    @StrutsTagAttribute(description = "If this flag is set to true, the grid loads the data from the server only once. After the first request all further manipulations are done on the client side. The functions of the pager (if present) are disabled.", defaultValue = "false", type = "Boolean")
    public void setLoadonce(String loadonce) {
        this.loadonce = loadonce;
    }

    @StrutsTagAttribute(description = "If this flag is set to true a multi selection of rows is enabled. A new column at left side is added.", defaultValue = "false", type = "Boolean")
    public void setMultiselect(String multiselect) {
        this.multiselect = multiselect;
    }

    @StrutsTagAttribute(description = "This option works only when multiselect = true. When multiselect is set to true, clicking anywhere on a row selects that row; when multiboxonly is also set to true, the multiselection is done only when the checkbox is clicked (Yahoo style). Clicking in any other row (suppose the checkbox is not clicked) deselects all rows and the current row is selected.", defaultValue = "false", type = "Boolean")
    public void setMultiboxonly(String multiboxonly) {
        this.multiboxonly = multiboxonly;
    }

    @StrutsTagAttribute(description = "Defines the url for inline and form editing.")
    public void setEditurl(String editurl) {
        this.editurl = editurl;
    }

    @StrutsTagAttribute(description = "Enable editing inline. Default: false", defaultValue = "false", type = "Boolean")
    public void setEditinline(String editinline) {
        this.editinline = editinline;
    }

    @StrutsTagAttribute(description = "Defines the Caption layer for the grid. This caption appear above the Header layer. If the string is empty the caption does not appear.")
    public void setCaption(String caption) {
        this.caption = caption;
    }

    @StrutsTagAttribute(description = "This option describes the type of calculation of the initial width of each column against with the width of the grid. If the value is true and the value in width option is set then: Every column width is scaled according to the defined option width.", defaultValue = "true", type = "Boolean")
    public void setShrinkToFit(String shrinkToFit) {
        this.shrinkToFit = shrinkToFit;
    }

    @StrutsTagAttribute(description = "Name of you grid model. Must be a Collection", required = true)
    public void setGridModel(String gridModel) {
        this.gridModel = gridModel;
    }

    @StrutsTagAttribute(description = "An array to construct a select box element in the pager in which we can change the number of the visible rows. e.g. 10,15,20")
    public void setRowList(String rowList) {
        this.rowList = rowList;
    }

    @StrutsTagAttribute(description = "Creates dynamic scrolling grids. When enabled, the pager elements are disabled and we can use the vertical scrollbar to load data. When set to true the grid will always hold all the items from the start through to the latest point ever visited.", defaultValue = "false")
    public void setScroll(String scroll) {
        this.scroll = scroll;
    }

    @StrutsTagAttribute(description = "Navigator is a method that can add predefined actions like editing, adding, deleting, and searching. This must be a true or false.", defaultValue = "false", type = "Boolean")
    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    @StrutsTagAttribute(description = "Edit Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
    public void setNavigatorEditOptions(String navigatorEditOptions) {
        this.navigatorEditOptions = navigatorEditOptions;
    }

    @StrutsTagAttribute(description = "Add Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
    public void setNavigatorAddOptions(String navigatorAddOptions) {
        this.navigatorAddOptions = navigatorAddOptions;
    }

    @StrutsTagAttribute(description = "Delete Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
    public void setNavigatorDeleteOptions(String navigatorDeleteOptions) {
        this.navigatorDeleteOptions = navigatorDeleteOptions;
    }

    @StrutsTagAttribute(description = "Search Options for Navigator. e.g. {height:280,reloadAfterSubmit:false},")
    public void setNavigatorSearchOptions(String navigatorSearchOptions) {
        this.navigatorSearchOptions = navigatorSearchOptions;
    }

    @StrutsTagAttribute(description = "View Options for Navigator. e.g. {sopt:['cn','bw','eq','ne','lt','gt','ew']},")
    public void setNavigatorViewOptions(String navigatorViewOptions) {
        this.navigatorViewOptions = navigatorViewOptions;
    }

    @StrutsTagAttribute(description = "Clones all the actions from the bottom pager to the top pager if defined.", defaultValue = "false", type = "Boolean")
    public void setNavigatorCloneToTop(String navigatorCloneToTop) {
        this.navigatorCloneToTop = navigatorCloneToTop;
    }

    @StrutsTagAttribute(description = "When set to true encodes (html encode) the incoming (from server) and posted data (from editing modules). By example < will be converted to &lt;", defaultValue = "true", type = "Boolean")
    public void setAutoencode(String autoencode) {
        this.autoencode = autoencode;
    }

    @StrutsTagAttribute(description = "Enables (disables) cell editing. See Cell Editing for more details", defaultValue = "false", type = "Boolean")
    public void setCellEdit(String cellEdit) {
        this.cellEdit = cellEdit;
    }

    @StrutsTagAttribute(description = "the url where the cell is to be saved.", defaultValue = "false", type = "Boolean")
    public void setCellurl(String cellurl) {
        this.cellurl = cellurl;
    }

    @StrutsTagAttribute(description = "If set to true this will place a footer table with one row below the gird records and above the pager.", defaultValue = "false", type = "Boolean")
    public void setFooterrow(String footerrow) {
        this.footerrow = footerrow;
    }

    @StrutsTagAttribute(description = "If set to true the grid initially is hidden. The data is not loaded (no request is sent) and only the caption layer is shown. When the show/hide button is clicked the first time to show grid, the request is sent to the server, the data is loaded, and grid is shown. From this point we have a regular grid.", defaultValue = "false", type = "Boolean")
    public void setHiddengrid(String hiddengrid) {
        this.hiddengrid = hiddengrid;
    }

    @StrutsTagAttribute(description = "Enables or disables the show/hide grid button, which appears on the right side of the Caption layer. Takes effect only if the caption property is not an empty string.", defaultValue = "false", type = "Boolean")
    public void setHidegrid(String hidegrid) {
        this.hidegrid = hidegrid;
    }

    @StrutsTagAttribute(description = "When set to false the mouse hovering is disabled in the grid data rows.", defaultValue = "false", type = "Boolean")
    public void setHoverrows(String hoverrows) {
        this.hoverrows = hoverrows;
    }

    @StrutsTagAttribute(description = "If this option is set to true, a new column at left of the grid is added. The purpose of this column is to count the number of available rows, beginning from 1. In this case colModel is extended automatically with new element with name - 'rn'. Also, be careful not to use the name 'rn' in gridModel", defaultValue = "false", type = "Boolean")
    public void setRownumbers(String rownumbers) {
        this.rownumbers = rownumbers;
    }

    @StrutsTagAttribute(description = "etermines the width of the multiselect column if multiselect is set to true.")
    public void setMultiselectWidth(String multiselectWidth) {
        this.multiselectWidth = multiselectWidth;
    }

    @StrutsTagAttribute(description = "Set the initial number of page when we make the request.This parameter is passed to the url for use by the server routine retrieving the data", defaultValue = "1")
    public void setPage(String page) {
        this.page = page;
    }

    @StrutsTagAttribute(description = "When enabled, selecting a row with setSelection scrolls the grid so that the selected row is visible.", defaultValue = "false", type = "Boolean")
    public void setScrollrows(String scrollrows) {
        this.scrollrows = scrollrows;
    }

    @StrutsTagAttribute(description = "Enables or disables the add action in the navigator. When the button is clicked a editGridRow with parameter new method is executed", defaultValue = "true", type = "Boolean")
    public void setNavigatorAdd(String navigatorAdd) {
        this.navigatorAdd = navigatorAdd;
    }

    @StrutsTagAttribute(description = "Enables or disables the delete action in the navigator. When the button is clicked a delGridRow method is executed.", defaultValue = "true", type = "Boolean")
    public void setNavigatorDelete(String navigatorDelete) {
        this.navigatorDelete = navigatorDelete;
    }

    @StrutsTagAttribute(description = "Enables or disables the edit action in the navigator. When the button is clicked a editGridRow method is executed with parameter the - current selected row", defaultValue = "true", type = "Boolean")
    public void setNavigatorEdit(String navigatorEdit) {
        this.navigatorEdit = navigatorEdit;
    }

    @StrutsTagAttribute(description = "Enables or disables the refresh button in the pager. When the button is clicked a trigger(reloadGrid) is executed and the search parameters are cleared", defaultValue = "true", type = "Boolean")
    public void setNavigatorRefresh(String navigatorRefresh) {
        this.navigatorRefresh = navigatorRefresh;
    }

    @StrutsTagAttribute(description = "Enables or disables the search button in the pager.When the button is clicked a searchGrid method is executed", defaultValue = "true", type = "Boolean")
    public void setNavigatorSearch(String navigatorSearch) {
        this.navigatorSearch = navigatorSearch;
    }

    @StrutsTagAttribute(description = "Enables or disables the view button in the pager. When the button is clicked a viewGridRow method is executed", defaultValue = "false", type = "Boolean")
    public void setNavigatorView(String navigatorView) {
        this.navigatorView = navigatorView;
    }

    @StrutsTagAttribute(description = "Add extra buttons to Navigator. e.g.: { seperator: { title : 'seperator'  }, hidebutton : { title : 'Show Hide', icon: 'ui-icon-gear', topic: showHideGrid} }")
    public void setNavigatorExtraButtons(String navigatorExtraButtons) {
        this.navigatorExtraButtons = navigatorExtraButtons;
    }

    @StrutsTagAttribute(description = "Show buttons for edit and add rows in case of editinline is true.", defaultValue = "true", type = "Boolean")
    public void setNavigatorInlineEditButtons(String navigatorInlineEditButtons) {
        this.navigatorInlineEditButtons = navigatorInlineEditButtons;
    }

    @StrutsTagAttribute(description = "This method construct searching creating input elements just below the header elements of the grid.", defaultValue = "false", type = "Boolean")
    public void setFilter(String filter) {
        this.filter = filter;
    }

    @StrutsTagAttribute(description = "Determines the width of the subGrid column if subgrid is enabled.")
    public void setSubGridWidth(String subGridWidth) {
        this.subGridWidth = subGridWidth;
    }

    @StrutsTagAttribute(description = "This option has effect only if subGrid option is set to true. This option points to the file from which we get the data for the subgrid. jqGrid adds the id of the row to this url as parameter.")
    public void setSubGridUrl(String subGridUrl) {
        this.subGridUrl = subGridUrl;
    }

    @StrutsTagAttribute(description = "When set to true we directly place the user data array userData at footer. The rules are as follow: If the userData array contain name which is equal to those of colModel then the value is placed in that column.If there are no such values nothing is palced. Note that if this option is used we use the current formatter options (if available) for that column.")
    public void setUserDataOnFooter(String userDataOnFooter) {
        this.userDataOnFooter = userDataOnFooter;
    }

    @StrutsTagAttribute(description = "Options for Filter Settings as JavaScript Object. e.g. { autosearch : false, formtype : vertical }")
    public void setFilterOptions(String filterOptions) {
        this.filterOptions = filterOptions;
    }

    @StrutsTagAttribute(description = "The class that is used for alternate rows. You can construct your own class and replace this value. This option is valid only if altRows options is set to true", defaultValue = "ui-priority-secondary")
    public void setAltClass(String altClass) {
        this.altClass = altClass;
    }

    @StrutsTagAttribute(description = "Set a zebra-striped grid", defaultValue = "false", type = "Boolean")
    public void setAltRows(String altRows) {
        this.altRows = altRows;
    }

    @StrutsTagAttribute(description = "Customizes names of the fields sent to the server on a Post. When some parameter is set to null they will be not sended to the server.", defaultValue = "{page:\"page\",rows:\"rows\", sort: \"sidx\",order: \"sord\", search:\"_search\", nd:\"nd\", id:\"id\",oper:\"oper\",editoper:\"edit\",addoper:\"add\",deloper:\"del\"}")
    public void setPrmNames(String prmNames) {
        this.prmNames = prmNames;
    }

    @StrutsTagAttribute(description = "Determines the language direction in grid. The default is 'ltr' (Left To Right language). When set to 'rtl' (Right To Left) the grid automatically do the needed.", defaultValue = "ltr")
    public void setDirection(String direction) {
        this.direction = direction;
    }

    @StrutsTagAttribute(description = "Determines the position of the record information in the pager. Can be left, center, right", defaultValue = "right")
    public void setRecordpos(String recordpos) {
        this.recordpos = recordpos;
    }

    @StrutsTagAttribute(description = "When set this parameter can instruct the server to load the total number of rows needed to work on. Note that rowNum determines the total records displayed in the grid, while rowTotal the total rows on which we operate. When this parameter is set we send a additional parameter to server named totalrows. You can check for this parameter and if it is available you can replace the rows parameter with this one. Mostly this parameter can be combined wit loadonce parameter set to true.", defaultValue = "null", type = "Integer")
    public void setRowTotal(String rowTotal) {
        this.rowTotal = rowTotal;
    }

    @StrutsTagAttribute(description = "The purpose of this parameter is to define different look and behavior of sorting icons that appear near the header. This parameter is array with the following default options viewsortcols : [false,'vertical',true]. The first parameter determines if all icons should be viewed at the same time when all columns have sort property set to true. The default of false determines that only the icons of the current sorting column should be viewed. Setting this parameter to true causes all icons in all sortable columns to be viewed. The second parameter determines how icons should be placed - vertical means that the sorting icons are one under another. 'horizontal' means that the icons should be one near other. The third parameter determines the click functionality. If set to true the columns are sorted if the header is clicked. If set to false the columns are sorted only when the icons are clicked. Important note: When set a third parameter to false be a sure that the first parameter is set to true, otherwise you will loose the sorting.", defaultValue = "false")
    public void setViewsortcols(String viewsortcols) {
        this.viewsortcols = viewsortcols;
    }

    @StrutsTagAttribute(description = "When enabled this option place a pager element at top of the grid below the caption (if available).", defaultValue = "false", type = "Boolean")
    public void setToppager(String toppager) {
        this.toppager = toppager;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when a row is selected")
    public void setOnSelectRowTopics(String onSelectRowTopics) {
        this.onSelectRowTopics = onSelectRowTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when multiselect option is true and you click on the header checkbox.")
    public void setOnSelectAllTopics(String onSelectAllTopics) {
        this.onSelectAllTopics = onSelectAllTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published after click on page button and before populating the data. Parameter: pgButton")
    public void setOnPagingTopics(String onPagingTopics) {
        this.onPagingTopics = onPagingTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published immediately after sortable column was clicked and before sorting the data. Parameters: index is the index name from colModel, iCol is the index of column, sortorder is the new sorting order - can be 'asc' or 'desc'")
    public void setOnSortColTopics(String onSortColTopics) {
        this.onSortColTopics = onSortColTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when we click on particular cell in the grid. Parameters: rowid is the id of the row, iCol is the index of the cell, cellcontent is the content of the cell, e is the event object element where we click.")
    public void setOnCellSelectTopics(String onCellSelectTopics) {
        this.onCellSelectTopics = onCellSelectTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published after all the data is loaded into the grid and all other processes are complete.")
    public void setOnGridCompleteTopics(String onGridCompleteTopics) {
        this.onGridCompleteTopics = onGridCompleteTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published after successfully accessing the row for editing, prior to allowing user access to the input fields.")
    public void setOnEditInlineBeforeTopics(String onEditInlineBeforeTopics) {
        this.onEditInlineBeforeTopics = onEditInlineBeforeTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published is called immediately after the request is successful.")
    public void setOnEditInlineSuccessTopics(String onEditInlineSuccessTopics) {
        this.onEditInlineSuccessTopics = onEditInlineSuccessTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published is called immediately after the data is saved to the server")
    public void setOnEditInlineErrorTopics(String onEditInlineErrorTopics) {
        this.onEditInlineErrorTopics = onEditInlineErrorTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published is called immediately after the data is saved to the server")
    public void setOnEditInlineAfterSaveTopics(String onEditInlineAfterSaveTopics) {
        this.onEditInlineAfterSaveTopics = onEditInlineAfterSaveTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published is called immediately after the cell has been successfully saved.")
    public void setOnCellEditSuccessTopics(String onCellEditSuccessTopics) {
        this.onCellEditSuccessTopics = onCellEditSuccessTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published is called immediately if there is a server error.")
    public void setOnCellEditErrorTopics(String onCellEditErrorTopics) {
        this.onCellEditErrorTopics = onCellEditErrorTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when subgrid row is expanded. Set event.originalEvent.orginal.proceed = false in your topic to prevent default action.")
    public void setOnSubGridRowExpanded(String onSubGridRowExpanded) {
        this.onSubGridRowExpanded = onSubGridRowExpanded;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published when a group is clicked.")
    public void setOnClickGroupTopics(String onClickGroupTopics) {
        this.onClickGroupTopics = onClickGroupTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published row was double clicked.")
    public void setOnDblClickRowTopics(String onDblClickRowTopics) {
        this.onDblClickRowTopics = onDblClickRowTopics;
    }

    @StrutsTagAttribute(description = "A comma delimited list of topics that published after row was right clicked. Note - this event does not work in Opera browsers, since Opera does not support oncontextmenu event")
    public void setOnRightClickRowTopics(String onRightClickRowTopics) {
        this.onRightClickRowTopics = onRightClickRowTopics;
    }

    @Override
    @StrutsTagAttribute(name = "reloadTopics", description = "A comma delimited list of topics that will cause this grid to reload")
    public void setReloadTopics(String reloadTopics) {
        this.reloadTopics = reloadTopics;
    }

    @StrutsTagAttribute(description = "Determines the target grid(s) to which the row should be dropped. The option is a string. In case of more than one grid the ids should be delemited with comma - i.e #grid1, #grid2 ", defaultValue = "empty string")
    public void setConnectWith(String connectWith) {
        this.connectWith = connectWith;
    }

    @StrutsTagAttribute(description = "Defines the name from  colModel  on which we group. The first value is the first lavel, the second values is the second level and etc. Currently only one level is supported. e.g. ['name']")
    public void setGroupField(String groupField) {
        this.groupField = groupField;
    }

    @StrutsTagAttribute(description = "Show/Hide the column on which we group. The value here should be a boolean true/false for the group level. If the grouping is enabled we set this value to true. e.g. [true]")
    public void setGroupColumnShow(String groupColumnShow) {
        this.groupColumnShow = groupColumnShow;
    }

    @StrutsTagAttribute(description = "Defines the grouping header text for the group level that will be displayed in the grid. By default if defined the value if {0} which means that the group value name will be displayed. It is possible to specify another value {1} which meant the the total cont of this group will be displayed too. It is possible to set here any valid html content. e.g. ['<b>{0} - {1} Item(s)</b>'] ")
    public void setGroupText(String groupText) {
        this.groupText = groupText;
    }

    @StrutsTagAttribute(description = "Defines if the initially the grid should show or hide the detailed rows of the group.", defaultValue = "false", type = "Boolean")
    public void setGroupCollapse(String groupCollapse) {
        this.groupCollapse = groupCollapse;
    }

    @StrutsTagAttribute(description = "Defines the initial sort order of the group level. Can be asc for ascending or desc for descending order. If the grouping is enabled the default value is asc. e.g. ['asc']")
    public void setGroupOrder(String groupOrder) {
        this.groupOrder = groupOrder;
    }

    @StrutsTagAttribute(description = "Enable or disable the summary (footer) row of the current group level. If grouping is set the default value for the group is false. e.g. [true]")
    public void setGroupSummary(String groupSummary) {
        this.groupSummary = groupSummary;
    }

    @StrutsTagAttribute(description = "If this parameter is set to true we send a additional parameter to the server in order to tell him to sort the data. This way all the sorting is done at server leaving the grid only to display the grouped data. If this parameter is false additionally before to display the data we make our own sorting in order to support grouping. This of course slow down the speed on relative big data. This parameter is not valid is the datatype is local.", defaultValue = "false", type = "Boolean")
    public void setGroupDataSorted(String groupDataSorted) {
        this.groupDataSorted = groupDataSorted;
    }

    @StrutsTagAttribute(description = "Show or hide the summary (footer) row when we collapse the group.", defaultValue = "false", type = "Boolean")
    public void setGroupShowSummaryOnHide(String groupShowSummaryOnHide) {
        this.groupShowSummaryOnHide = groupShowSummaryOnHide;
    }

    @StrutsTagAttribute(description = "Set the icon from jQuery UI Theme Roller that will be used if the grouped row is collapsed", defaultValue = "ui-icon-circlesmall-plus")
    public void setGroupPlusIcon(String groupPlusIcon) {
        this.groupPlusIcon = groupPlusIcon;
    }

    @StrutsTagAttribute(description = "Set the icon from jQuery UI Theme Roller that will be used if the grouped row is expanded", defaultValue = "ui-icon-circlesmall-minus")
    public void setGroupMinusIcon(String groupMinusIcon) {
        this.groupMinusIcon = groupMinusIcon;
    }

    @Override
    @StrutsTagAttribute(description = "Enable sortable columns", type = "Boolean")
    public void setSortable(String sortable) {
        this.sortable = sortable;
    }

    @StrutsTagAttribute(description = "Enable sortable rows", type = "Boolean")
    public void setSortableRows(String sortableRows) {
        this.sortableRows = sortableRows;
    }

}
