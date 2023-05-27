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

package com.jgeppert.struts2.jquery.datatables.components;

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a datatable
 * </p>
 * <!-- END SNIPPET: javadoc -->
 *
 * @author <a href="https://www.jgeppert.com">Johannes Geppert</a>
 */
@StrutsTag(name = "datatables", tldTagClass = "com.jgeppert.struts2.jquery.datatables.views.jsp.ui.DatatablesTag", description = "Render a table enhanced with jQuery DataTables")
public class Datatables extends AbstractRemoteBean {

    public static final String JQUERYACTION = "datatables";
    public static final String TEMPLATE = "datatables";
    public static final String TEMPLATE_CLOSE = "datatables-close";
    public static final String COMPONENT_NAME = Datatables.class.getName();

    private static final String PARAM_DATATABLES_THEME = "datatablesTheme";
    private static final String PARAM_AUTO_WIDTH = "autoWidth";
    private static final String PARAM_DEFER_RENDER = "deferRender";
    private static final String PARAM_INFO = "info";
    private static final String PARAM_LENGTH_CHANGE = "lengthChange";
    private static final String PARAM_ORDERING = "ordering";
    private static final String PARAM_PAGING = "paging";
    private static final String PARAM_PROCESSING = "processing";
    private static final String PARAM_SCROLL_X = "scrollX";
    private static final String PARAM_SCROLL_Y = "scrollY";
    private static final String PARAM_SEARCHING = "searching";
    private static final String PARAM_SERVER_SIDE = "serverSide";
    private static final String PARAM_STATE_SAVE = "stateSave";
    private static final String PARAM_DATA = "data";
    private static final String PARAM_AJAX = "ajax";
    private static final String PARAM_COLUMNS = "columns";
    private static final String PARAM_COLUMN_DEFS = "columnDefs";
    private static final String PARAM_DEFER_LOADING = "deferLoading";
    private static final String PARAM_DISPLAY_START = "displayStart";
    private static final String PARAM_DOM = "dom";
    private static final String PARAM_LENGTH_MENU = "lengthMenu";
    private static final String PARAM_PAGE_LENGTH = "pageLength";
    private static final String PARAM_PAGING_TYPE = "pagingType";
    private static final String PARAM_ORDER = "order";
    private static final String PARAM_ORDER_CELLS_TOP = "orderCellsTop";
    private static final String PARAM_ORDER_CLASSES = "orderClasses";
    private static final String PARAM_ORDER_FIXED = "orderFixed";
    private static final String PARAM_ORDER_MULTI = "orderMulti";
    private static final String PARAM_RENDERER = "renderer";
    private static final String PARAM_ROW_ID = "rowId";
    private static final String PARAM_SCROLL_COLLAPSE = "scrollCollapse";
    private static final String PARAM_SEARCH = "search";
    private static final String PARAM_SEARCH_COLS = "searchCols";
    private static final String PARAM_SEARCH_DELAY = "searchDelay";
    private static final String PARAM_STATE_DURATION = "stateDuration";
    private static final String PARAM_STRIPE_CLASSES = "stripeClasses";
    private static final String PARAM_RESPONSIVE = "responsive";
    private static final String PARAM_AUTO_FILL = "autoFill";
    private static final String PARAM_BUTTONS = "buttons";
    private static final String PARAM_COL_REORDER = "colReorder";
    private static final String PARAM_FIXED_COLUMNS = "fixedColumns";
    private static final String PARAM_FIXED_HEADER = "fixedHeader";
    private static final String PARAM_KEYS = "keys";
    private static final String PARAM_ROW_REORDER = "rowReorder";
    private static final String PARAM_ROW_GROUP = "rowGroup";
    private static final String PARAM_SCROLLER = "scroller";
    private static final String PARAM_SELECT = "select";
    private static final String PARAM_CREATED_ROW = "createdRow";
    private static final String PARAM_DRAW_CALLBACK = "drawCallback";
    private static final String PARAM_FOOTER_CALLBACK = "footerCallback";
    private static final String PARAM_FORMAT_NUMBER = "formatNumber";
    private static final String PARAM_HEADER_CALLBACK = "headerCallback";
    private static final String PARAM_INFO_CALLBACK = "infoCallback";
    private static final String PARAM_INIT_COMPLETE = "initComplete";
    private static final String PARAM_PRE_DRAW_CALLBACK = "preDrawCallback";
    private static final String PARAM_ROW_CALLBACK = "rowCallback";
    private static final String PARAM_STATE_LOAD_CALLBACK = "stateLoadCallback";
    private static final String PARAM_STATE_LOADED = "stateLoaded";
    private static final String PARAM_STATE_LOAD_PARAMS = "stateLoadParams";
    private static final String PARAM_STATE_SAVE_CALLBACK = "stateSaveCallback";
    private static final String PARAM_STATE_SAVE_PARAMS = "stateSaveParams";
    private static final String PARAM_CLEAR_TABLE_TOPICS = "clearTableTopics";
    private static final String PARAM_AJAX_RELOAD_TOPICS = "ajaxReloadTopics";
    private static final String PARAM_REDRAW_TOPICS = "redrawTopics";
    private static final String PARAM_ORDER_TOPICS = "orderTopics";
    private static final String PARAM_PAGE_TOPICS = "pageTopics";
    private static final String PARAM_PAGE_LENGTH_TOPICS = "pageLengthTopics";
    private static final String PARAM_SEARCH_TOPICS = "searchTopics";
    private static final String PARAM_STATE_CLEAR_TOPICS = "stateClearTopics";
    private static final String PARAM_STATE_SAVE_TOPICS = "stateSaveTopics";
    private static final String PARAM_ON_STATE_SAVING_TOPICS = "onStateSavingTopics";
    private static final String PARAM_ON_STATE_LOADING_TOPICS = "onStateLoadingTopics";
    private static final String PARAM_ON_STATE_LOADED_TOPICS = "onStateLoadedTopics";
    private static final String PARAM_ON_SEARCH_TOPICS = "onSearchTopics";
    private static final String PARAM_ON_PROCESSING_TOPICS = "onProcessingTopics";
    private static final String PARAM_ON_INIT_START_TOPICS = "onInitStartTopics";
    private static final String PARAM_ON_PAGE_CHANGE_TOPICS = "onPageChangeTopics";
    private static final String PARAM_ON_ORDER_TOPICS = "onOrderTopics";
    private static final String PARAM_ON_PAGE_LENGTH_CHANGE_TOPICS = "onPageLengthChangeTopics";
    private static final String PARAM_ON_INIT_COMPLETE_TOPICS = "onInitCompleteTopics";
    private static final String PARAM_ON_PROCESSING_ERROR_TOPICS = "onProcessingErrorTopics";
    private static final String PARAM_ON_DRAW_TOPICS = "onDrawTopics";
    private static final String PARAM_ON_DESTROY_TOPICS = "onDestroyTopics";
    private static final String PARAM_ON_COLUMN_VISIBILITY_TOPICS = "onColumnVisibilityTopics";
    private static final String PARAM_ON_COLUMN_SIZING_TOPICS = "onColumnSizingTopics";
    private static final String PARAM_ON_AUTO_FILL_TOPICS = "onAutoFillTopics";
    private static final String PARAM_ON_BEFORE_AUTO_FILL_TOPICS = "onBeforeAutoFillTopics";
    private static final String PARAM_ON_BUTTON_ACTION_TOPICS = "onButtonActionTopics";
    private static final String PARAM_ON_COLUMN_REORDER_TOPICS = "onColumnReorderTopics";
    private static final String PARAM_ON_KEY_BLUR_TOPICS = "onKeyBlurTopics";
    private static final String PARAM_ON_KEY_FOCUS_TOPICS = "onKeyFocusTopics";
    private static final String PARAM_ON_OTHER_KEY_TOPICS = "onOtherKeyTopics";
    private static final String PARAM_ON_RESPONSIVE_DISPLAY_TOPICS = "onResponsiveDisplayTopics";
    private static final String PARAM_ON_RESPONSIVE_RESIZE_TOPICS = "onResponsiveResizeTopics";   
    private static final String PARAM_ON_ROW_GROUP_POINT_CHANGED_TOPICS = "onRowGroupPointChangedTopics";   
    private static final String PARAM_ON_ROW_REORDER_TOPICS = "onRowReorderTopics";
    private static final String PARAM_ON_ROW_REORDERED_TOPICS = "onRowReorderedTopics";
    private static final String PARAM_ON_DESELECT_TOPICS = "onDeselectTopics";
    private static final String PARAM_ON_SELECT_TOPICS = "onSelectTopics";
    private static final String PARAM_ON_SELECT_ITEMS_TOPICS = "onSelectItemsTopics";
    private static final String PARAM_ON_SELECT_STYLE_TOPICS = "onSelectStyleTopics";
    private static final String PARAM_ON_USER_SELECT_TOPICS = "onUserSelectTopics";

    private static final String ID_PREFIX_DATATABLES = "datatables_";

    // core features
    protected String datatablesTheme;
    protected String autoWidth;
    protected String deferRender;
    protected String info;
    protected String lengthChange;
    protected String ordering;
    protected String paging;
    protected String processing;
    protected String scrollX;
    protected String scrollY;
    protected String searching;
    protected String serverSide;
    protected String stateSave;

    // data features
    protected String data;
    protected String ajax;

    // columns definitions
    protected String columns;
    protected String columnDefs;

    // options
    protected String deferLoading;
    protected String displayStart;
    protected String dom;
    protected String lengthMenu;
    protected String pageLength;
    protected String pagingType;
    protected String order;
    protected String orderCellsTop;
    protected String orderClasses;
    protected String orderFixed;
    protected String orderMulti;
    protected String renderer;
    protected String rowId;
    protected String scrollCollapse;
    protected String search;
    protected String searchCols;
    protected String searchDelay;
    protected String stateDuration;
    protected String stripeClasses;

    // callbacks
    protected String createdRow;
    protected String drawCallback;
    protected String footerCallback;
    protected String formatNumber;
    protected String headerCallback;
    protected String infoCallback;
    protected String initComplete;
    protected String preDrawCallback;
    protected String rowCallback;
    protected String stateLoadCallback;
    protected String stateLoaded;
    protected String stateLoadParams;
    protected String stateSaveCallback;
    protected String stateSaveParams;

    // API -> topic binding
    protected String clearTableTopics;
    protected String ajaxReloadTopics;
    protected String redrawTopics;
    protected String orderTopics;
    protected String pageTopics;
    protected String pageLengthTopics;
    protected String searchTopics;
    protected String stateClearTopics;
    protected String stateSaveTopics;

    // events -> topic binding
    protected String onColumnSizingTopics;
    protected String onColumnVisibilityTopics;
    protected String onDestroyTopics;
    protected String onDrawTopics;
    protected String onProcessingErrorTopics;
    protected String onInitCompleteTopics;
    protected String onPageLengthChangeTopics;
    protected String onOrderTopics;
    protected String onPageChangeTopics;
    protected String onInitStartTopics;
    protected String onProcessingTopics;
    protected String onSearchTopics;
    protected String onStateLoadedTopics;
    protected String onStateLoadingTopics;
    protected String onStateSavingTopics;
    // plugins events
    protected String onAutoFillTopics;
    protected String onBeforeAutoFillTopics;
    protected String onButtonActionTopics;
    protected String onColumnReorderTopics;
    protected String onKeyBlurTopics;
    protected String onKeyFocusTopics;
    protected String onOtherKeyTopics;
    protected String onResponsiveDisplayTopics;
    protected String onResponsiveResizeTopics;
    protected String onRowGroupPointChangedTopics;
    protected String onRowReorderTopics;
    protected String onRowReorderedTopics;
    protected String onDeselectTopics;
    protected String onSelectTopics;
    protected String onSelectItemsTopics;
    protected String onSelectStyleTopics;
    protected String onUserSelectTopics;

    // plugins configurations
    protected String responsive;
    protected String autoFill;
    protected String buttons;
    protected String colReorder;
    protected String fixedColumns;
    protected String fixedHeader;
    protected String keys;
    protected String rowReorder;
    protected String scroller;
    protected String select;
    protected String rowGroup;

    public Datatables(ValueStack stack, HttpServletRequest request, HttpServletResponse response) {
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

        addParameterIfPresent(PARAM_DATATABLES_THEME, this.datatablesTheme);
        addParameterIfPresent(PARAM_AUTO_WIDTH, this.autoWidth, Boolean.class);
        addParameterIfPresent(PARAM_DEFER_RENDER, this.deferRender, Boolean.class);
        addParameterIfPresent(PARAM_INFO, this.info, Boolean.class);
        addParameterIfPresent(PARAM_LENGTH_CHANGE, this.lengthChange, Boolean.class);
        addParameterIfPresent(PARAM_ORDERING, this.ordering, Boolean.class);
        addParameterIfPresent(PARAM_PAGING, this.paging, Boolean.class);
        addParameterIfPresent(PARAM_PROCESSING, this.processing, Boolean.class);
        addParameterIfPresent(PARAM_SCROLL_X, this.scrollX);
        addParameterIfPresent(PARAM_SCROLL_Y, this.scrollY);
        addParameterIfPresent(PARAM_SEARCHING, this.searching, Boolean.class);
        addParameterIfPresent(PARAM_SERVER_SIDE, this.serverSide, Boolean.class);
        addParameterIfPresent(PARAM_STATE_SAVE, this.stateSave, Boolean.class);
        addParameterIfPresent(PARAM_DATA, this.data);
        addParameterIfPresent(PARAM_AJAX, this.ajax);
        addParameterIfPresent(PARAM_COLUMNS, this.columns);
        addParameterIfPresent(PARAM_COLUMN_DEFS, this.columnDefs);
        addParameterIfPresent(PARAM_DEFER_LOADING, this.deferLoading, Long.class);
        addParameterIfPresent(PARAM_DISPLAY_START, this.displayStart, Long.class);
        addParameterIfPresent(PARAM_DOM, this.dom);
        addParameterIfPresent(PARAM_LENGTH_MENU, this.lengthMenu);
        addParameterIfPresent(PARAM_PAGE_LENGTH, this.pageLength, Long.class);
        addParameterIfPresent(PARAM_PAGING_TYPE, this.pagingType);
        addParameterIfPresent(PARAM_ORDER, this.order);
        addParameterIfPresent(PARAM_ORDER_CELLS_TOP, this.orderCellsTop, Boolean.class);
        addParameterIfPresent(PARAM_ORDER_CLASSES, this.orderClasses, Boolean.class);
        addParameterIfPresent(PARAM_ORDER_FIXED, this.orderFixed);
        addParameterIfPresent(PARAM_ORDER_MULTI, this.orderMulti, Boolean.class);
        addParameterIfPresent(PARAM_RENDERER, this.renderer);
        addParameterIfPresent(PARAM_ROW_ID, this.rowId);
        addParameterIfPresent(PARAM_SCROLL_COLLAPSE, this.scrollCollapse, Boolean.class);
        addParameterIfPresent(PARAM_SEARCH, this.search);
        addParameterIfPresent(PARAM_SEARCH_COLS, this.searchCols);
        addParameterIfPresent(PARAM_SEARCH_DELAY, this.searchDelay, Long.class);
        addParameterIfPresent(PARAM_STATE_DURATION, this.stateDuration, Long.class);
        addParameterIfPresent(PARAM_STRIPE_CLASSES, this.stripeClasses);
        addParameterIfPresent(PARAM_RESPONSIVE, this.responsive);
        addParameterIfPresent(PARAM_AUTO_FILL, this.autoFill);
        addParameterIfPresent(PARAM_BUTTONS, this.buttons);
        addParameterIfPresent(PARAM_COL_REORDER, this.colReorder);
        addParameterIfPresent(PARAM_FIXED_COLUMNS, this.fixedColumns);
        addParameterIfPresent(PARAM_FIXED_HEADER, this.fixedHeader);
        addParameterIfPresent(PARAM_KEYS, this.keys);
        addParameterIfPresent(PARAM_ROW_GROUP, this.rowGroup);
        addParameterIfPresent(PARAM_ROW_REORDER, this.rowReorder);
        addParameterIfPresent(PARAM_SCROLLER, this.scroller);
        addParameterIfPresent(PARAM_SELECT, this.select);
        addParameterIfPresent(PARAM_CREATED_ROW, this.createdRow);
        addParameterIfPresent(PARAM_DRAW_CALLBACK, this.drawCallback);
        addParameterIfPresent(PARAM_FOOTER_CALLBACK, this.footerCallback);
        addParameterIfPresent(PARAM_FORMAT_NUMBER, this.formatNumber);
        addParameterIfPresent(PARAM_HEADER_CALLBACK, this.headerCallback);
        addParameterIfPresent(PARAM_INFO_CALLBACK, this.infoCallback);
        addParameterIfPresent(PARAM_INIT_COMPLETE, this.initComplete);
        addParameterIfPresent(PARAM_PRE_DRAW_CALLBACK, this.preDrawCallback);
        addParameterIfPresent(PARAM_ROW_CALLBACK, this.rowCallback);
        addParameterIfPresent(PARAM_STATE_LOAD_CALLBACK, this.stateLoadCallback);
        addParameterIfPresent(PARAM_STATE_LOADED, this.stateLoaded);
        addParameterIfPresent(PARAM_STATE_LOAD_PARAMS, this.stateLoadParams);
        addParameterIfPresent(PARAM_STATE_SAVE_CALLBACK, this.stateSaveCallback);
        addParameterIfPresent(PARAM_STATE_SAVE_PARAMS, this.stateSaveParams);
        addParameterIfPresent(PARAM_CLEAR_TABLE_TOPICS, this.clearTableTopics);
        addParameterIfPresent(PARAM_AJAX_RELOAD_TOPICS, this.ajaxReloadTopics);
        addParameterIfPresent(PARAM_REDRAW_TOPICS, this.redrawTopics);
        addParameterIfPresent(PARAM_ORDER_TOPICS, this.orderTopics);
        addParameterIfPresent(PARAM_PAGE_TOPICS, this.pageTopics);
        addParameterIfPresent(PARAM_PAGE_LENGTH_TOPICS, this.pageLengthTopics);
        addParameterIfPresent(PARAM_SEARCH_TOPICS, this.searchTopics);
        addParameterIfPresent(PARAM_STATE_CLEAR_TOPICS, this.stateClearTopics);
        addParameterIfPresent(PARAM_STATE_SAVE_TOPICS, this.stateSaveTopics);
        addParameterIfPresent(PARAM_ON_STATE_SAVING_TOPICS, this.onStateSavingTopics);
        addParameterIfPresent(PARAM_ON_STATE_LOADING_TOPICS, this.onStateLoadingTopics);
        addParameterIfPresent(PARAM_ON_STATE_LOADED_TOPICS, this.onStateLoadedTopics);
        addParameterIfPresent(PARAM_ON_SEARCH_TOPICS, this.onSearchTopics);
        addParameterIfPresent(PARAM_ON_PROCESSING_TOPICS, this.onProcessingTopics);
        addParameterIfPresent(PARAM_ON_INIT_START_TOPICS, this.onInitStartTopics);
        addParameterIfPresent(PARAM_ON_PAGE_CHANGE_TOPICS, this.onPageChangeTopics);
        addParameterIfPresent(PARAM_ON_ORDER_TOPICS, this.onOrderTopics);
        addParameterIfPresent(PARAM_ON_PAGE_LENGTH_CHANGE_TOPICS, this.onPageLengthChangeTopics);
        addParameterIfPresent(PARAM_ON_INIT_COMPLETE_TOPICS, this.onInitCompleteTopics);
        addParameterIfPresent(PARAM_ON_PROCESSING_ERROR_TOPICS, this.onProcessingErrorTopics);
        addParameterIfPresent(PARAM_ON_DRAW_TOPICS, this.onDrawTopics);
        addParameterIfPresent(PARAM_ON_DESTROY_TOPICS, this.onDestroyTopics);
        addParameterIfPresent(PARAM_ON_COLUMN_VISIBILITY_TOPICS, this.onColumnVisibilityTopics);
        addParameterIfPresent(PARAM_ON_COLUMN_SIZING_TOPICS, this.onColumnSizingTopics);
        addParameterIfPresent(PARAM_ON_AUTO_FILL_TOPICS, this.onAutoFillTopics);
        addParameterIfPresent(PARAM_ON_BEFORE_AUTO_FILL_TOPICS, this.onBeforeAutoFillTopics);
        addParameterIfPresent(PARAM_ON_BUTTON_ACTION_TOPICS, this.onButtonActionTopics);
        addParameterIfPresent(PARAM_ON_COLUMN_REORDER_TOPICS, this.onColumnReorderTopics);
        addParameterIfPresent(PARAM_ON_KEY_BLUR_TOPICS, this.onKeyBlurTopics);
        addParameterIfPresent(PARAM_ON_KEY_FOCUS_TOPICS, this.onKeyFocusTopics);
        addParameterIfPresent(PARAM_ON_OTHER_KEY_TOPICS, this.onOtherKeyTopics);
        addParameterIfPresent(PARAM_ON_RESPONSIVE_DISPLAY_TOPICS, this.onResponsiveDisplayTopics);
        addParameterIfPresent(PARAM_ON_RESPONSIVE_RESIZE_TOPICS, this.onResponsiveResizeTopics);
        addParameterIfPresent(PARAM_ON_ROW_GROUP_POINT_CHANGED_TOPICS, this.onRowGroupPointChangedTopics);
        addParameterIfPresent(PARAM_ON_ROW_REORDER_TOPICS, this.onRowReorderTopics);
        addParameterIfPresent(PARAM_ON_ROW_REORDERED_TOPICS, this.onRowReorderedTopics);
        addParameterIfPresent(PARAM_ON_DESELECT_TOPICS, this.onDeselectTopics);
        addParameterIfPresent(PARAM_ON_SELECT_TOPICS, this.onSelectTopics);
        addParameterIfPresent(PARAM_ON_SELECT_ITEMS_TOPICS, this.onSelectItemsTopics);
        addParameterIfPresent(PARAM_ON_SELECT_STYLE_TOPICS, this.onSelectStyleTopics);
        addParameterIfPresent(PARAM_ON_USER_SELECT_TOPICS, this.onUserSelectTopics);

        addGeneratedIdParam(ID_PREFIX_DATATABLES);
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

    @StrutsTagAttribute(description = "the theme for DataTables", defaultValue = "default")
    public void setDatatablesTheme(String datatablesTheme) {
        this.datatablesTheme = datatablesTheme;
    }

    @StrutsTagAttribute(description = "enable/disable automatic column width calculation", defaultValue = "true")
    public void setAutoWidth(String autoWidth) {
        this.autoWidth = autoWidth;
    }

    @StrutsTagAttribute(description = "Deffer initial rendering for additional speed up of initialisation", defaultValue = "false")
    public void setDeferRender(String deferRender) {
        this.deferRender = deferRender;
    }

    @StrutsTagAttribute(description = "enable/disable information display", defaultValue = "true")
    public void setInfo(String info) {
        this.info = info;
    }

    @StrutsTagAttribute(description = "enable/disable paging length select", defaultValue = "true")
    public void setLengthChange(String lengthChange) {
        this.lengthChange = lengthChange;
    }

    @StrutsTagAttribute(description = "enable/disable ordering", defaultValue = "true")
    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    @StrutsTagAttribute(description = "enable/disable paging", defaultValue = "true")
    public void setPaging(String paging) {
        this.paging = paging;
    }

    @StrutsTagAttribute(description = "enable/disable processing message", defaultValue = "false")
    public void setProcessing(String processing) {
        this.processing = processing;
    }

    @StrutsTagAttribute(description = "controls horizontal scrolling, can be true (auto), or any CSS unit, or any Number", defaultValue = "false")
    public void setScrollX(String scrollX) {
        this.scrollX = scrollX;
    }

    @StrutsTagAttribute(description = "controls vertical scrolling, can be true (auto), or any CSS unit, or any Number", defaultValue = "false")
    public void setScrollY(String scrollY) {
        this.scrollY = scrollY;
    }

    @StrutsTagAttribute(description = "enable/disable searching", defaultValue = "true")
    public void setSearching(String searching) {
        this.searching = searching;
    }

    @StrutsTagAttribute(description = "enable/disable server side processing of searching, paginating,ordering,...", defaultValue = "false")
    public void setServerSide(String serverSide) {
        this.serverSide = serverSide;
    }

    @StrutsTagAttribute(description = "enable/disable state saving feature", defaultValue = "false")
    public void setStateSave(String stateSave) {
        this.stateSave = stateSave;
    }

    @StrutsTagAttribute(description = "Use of a JS array as dataSource for the table")
    public void setData(String data) {
        this.data = data;
    }

    @StrutsTagAttribute(description = "Configuration of an AJAX Datasource for the Table. Expect a string (url), oan object(jQuery ajax like config object), or a custom function. See datatables reference for more infos")
    public void setAjax(String ajax) {
        this.ajax = ajax;
    }

    @StrutsTagAttribute(description = "Configuration of columns. Expect a JS array, as specified by datatables manual.")
    public void setColumns(String columns) {
        this.columns = columns;
    }

    @StrutsTagAttribute(description = "Other way of configuring columns. Expect a JS array, as specified by datatables manual.")
    public void setColumnDefs(String columnDefs) {
        this.columnDefs = columnDefs;
    }

    @StrutsTagAttribute(description = "When server side processing is enabled, and initial data is already in the DOM content of the table,"
            + " if this option is setted with the full dataset size, datatables will defer requesting the server until needed")
    public void setDeferLoading(String deferLoading) {
        this.deferLoading = deferLoading;
    }

    @StrutsTagAttribute(description = "Initial page to show", defaultValue = "0")
    public void setDisplayStart(String displayStart) {
        this.displayStart = displayStart;
    }

    @StrutsTagAttribute(description = "DataTables dom configuration")
    public void setDom(String dom) {
        this.dom = dom;
    }

    @StrutsTagAttribute(description = "specify the entries in the drop down select for pagination.Expect a 1D array containing integer values of page length or a 2D array with first index being the page lengths and second index being the dispalyed options", defaultValue = "[10,25,50,100]")
    public void setLengthMenu(String lengthMenu) {
        this.lengthMenu = lengthMenu;
    }

    @StrutsTagAttribute(description = "change the initial page length", defaultValue = "10")
    public void setPageLength(String pageLength) {
        this.pageLength = pageLength;
    }

    @StrutsTagAttribute(description = "pagination buttons display options.Expects a string whin can be 'numbers': page buttons number only, 'simple': previous and next buttons only, 'simple_numbers' : previous, next plus page numbers, 'full' : first previous next and last buttons, 'full_numbers' : full + numbers ", defaultValue = "simple_numbers")
    public void setPagingType(String pagingType) {
        this.pagingType = pagingType;
    }

    @StrutsTagAttribute(description = "initial order to apply to the table. Must be an array of arrays, the inner arrays comprised of : column index to order upon, and 'asc' or 'desc' string", defaultValue = "[[0,'asc']]")
    public void setOrder(String order) {
        this.order = order;
    }

    @StrutsTagAttribute(description = "Control whether DataTables should use the top (true) unique cell for a single column, or the bottom to attach the default order listener", defaultValue = "false")
    public void setOrderCellsTop(String orderCellsTop) {
        this.orderCellsTop = orderCellsTop;
    }

    @StrutsTagAttribute(description = "Highlight the column being ordered in the table body", defaultValue = "true")
    public void setOrderClasses(String orderClasses) {
        this.orderClasses = orderClasses;
    }

    @StrutsTagAttribute(description = "ordering to be always applied to the table. See 'order' attribute for argument detail ")
    public void setOrderFixed(String orderFixed) {
        this.orderFixed = orderFixed;
    }

    @StrutsTagAttribute(description = "Enable/Disable multiple column ordering", defaultValue = "true")
    public void setOrderMulti(String orderMulti) {
        this.orderMulti = orderMulti;
    }

    @StrutsTagAttribute(description = "Display component renderer type")
    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    @StrutsTagAttribute(description = "Data property name that must be used to set tr elements DOM IDs")
    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    @StrutsTagAttribute(description = "Allow the table to reduce in height when a limited number of row is shown", defaultValue = "false")
    public void setScrollCollapse(String scrollCollapse) {
        this.scrollCollapse = scrollCollapse;
    }

    @StrutsTagAttribute(description = "Search feature configuration. See DataTables reference for more infos")
    public void setSearch(String search) {
        this.search = search;
    }

    @StrutsTagAttribute(description = "Define an initial search for individual columns.Expect an array of the same size as the number of columns, containing an object with 'search' and 'escapeRegex' properties ")
    public void setSearchCols(String searchCols) {
        this.searchCols = searchCols;
    }

    @StrutsTagAttribute(description = "Set a throttle frequency for searching.expect an integer", defaultValue = "null")
    public void setSearchDelay(String searchDelay) {
        this.searchDelay = searchDelay;
    }

    @StrutsTagAttribute(description = "Saved state validity duration, in seconds", defaultValue = "7200")
    public void setStateDuration(String stateDuration) {
        this.stateDuration = stateDuration;
    }

    @StrutsTagAttribute(description = "Sets the zebra stripe class names for the rows in the table.Expect an array of class names", defaultValue = "['odd','even']")
    public void setStripeClasses(String stripeClasses) {
        this.stripeClasses = stripeClasses;
    }

    @StrutsTagAttribute(description = "Responsive plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setResponsive(String responsive) {
        this.responsive = responsive;
    }

    @StrutsTagAttribute(description = "AutoFill plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setAutoFill(String autoFill) {
        this.autoFill = autoFill;
    }

    @StrutsTagAttribute(description = "Buttons plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setButtons(String buttons) {
        this.buttons = buttons;
    }

    @StrutsTagAttribute(description = "ColReorder plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setColReorder(String colReorder) {
        this.colReorder = colReorder;
    }

    @StrutsTagAttribute(description = "Fixed plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setFixedColumns(String fixedColumns) {
        this.fixedColumns = fixedColumns;
    }

    @StrutsTagAttribute(description = "FixedHeader plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setFixedHeader(String fixedHeader) {
        this.fixedHeader = fixedHeader;
    }

    @StrutsTagAttribute(description = "KeyTable plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setKeys(String keys) {
        this.keys = keys;
    }

    @StrutsTagAttribute(description = "RowReorder plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setRowReorder(String rowReorder) {
        this.rowReorder = rowReorder;
    }
      
    @StrutsTagAttribute(description = "RowGroup plugin configuration. No defaults here, you have to provide a rowGroup config Object. See DataTables docs for detail", defaultValue = "false")
    public void setRowGroup(String rowGroup) {
		this.rowGroup = rowGroup;
	}

	@StrutsTagAttribute(description = "Scroller plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setScroller(String scroller) {
        this.scroller = scroller;
    }

    @StrutsTagAttribute(description = "Select plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false")
    public void setSelect(String select) {
        this.select = select;
    }

    @StrutsTagAttribute(description = "Callback for whenever az TR element is created for the table's body")
    public void setCreatedRow(String createdRow) {
        this.createdRow = createdRow;
    }

    @StrutsTagAttribute(description = "Callback called every time DataTables performs a draw")
    public void setDrawCallback(String drawCallback) {
        this.drawCallback = drawCallback;
    }

    @StrutsTagAttribute(description = "Footer dispplay Callback")
    public void setFooterCallback(String footerCallback) {
        this.footerCallback = footerCallback;
    }

    @StrutsTagAttribute(description = "Number formatting Callback")
    public void setFormatNumber(String formatNumber) {
        this.formatNumber = formatNumber;
    }

    @StrutsTagAttribute(description = "Header display Callback")
    public void setHeaderCallback(String headerCallback) {
        this.headerCallback = headerCallback;
    }

    @StrutsTagAttribute(description = "Table summary display Callback")
    public void setInfoCallback(String infoCallback) {
        this.infoCallback = infoCallback;
    }

    @StrutsTagAttribute(description = "Initialisation complete Callback")
    public void setInitComplete(String initComplete) {
        this.initComplete = initComplete;
    }

    @StrutsTagAttribute(description = "Pre draw Callback")
    public void setPreDrawCallback(String preDrawCallback) {
        this.preDrawCallback = preDrawCallback;
    }

    @StrutsTagAttribute(description = "row draw Callback")
    public void setRowCallback(String rowCallback) {
        this.rowCallback = rowCallback;
    }

    @StrutsTagAttribute(description = "Callback that define where and how a saved state should be loaded")
    public void setStateLoadCallback(String stateLoadCallback) {
        this.stateLoadCallback = stateLoadCallback;
    }

    @StrutsTagAttribute(description = "State loaded Callback")
    public void setStateLoaded(String stateLoaded) {
        this.stateLoaded = stateLoaded;
    }

    @StrutsTagAttribute(description = "State loaded - data manipulation Callback")
    public void setStateLoadParams(String stateLoadParams) {
        this.stateLoadParams = stateLoadParams;
    }

    @StrutsTagAttribute(description = "Callback that define how the table state is stored and where")
    public void setStateSaveCallback(String stateSaveCallback) {
        this.stateSaveCallback = stateSaveCallback;
    }

    @StrutsTagAttribute(description = "State save - Data manipulation Callback")
    public void setStateSaveParams(String stateSaveParams) {
        this.stateSaveParams = stateSaveParams;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a table clear")
    public void setClearTableTopics(String clearTableTopics) {
        this.clearTableTopics = clearTableTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger an AJAX reload")
    public void setAjaxReloadTopics(String ajaxReloadTopics) {
        this.ajaxReloadTopics = ajaxReloadTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a table redraw")
    public void setRedrawTopics(String redrawTopics) {
        this.redrawTopics = redrawTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a table order. The data attribute contains ordering params")
    public void setOrderTopics(String orderTopics) {
        this.orderTopics = orderTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a table page change. The data attribute contains the page number")
    public void setPageTopics(String pageTopics) {
        this.pageTopics = pageTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a page length change. The data attribute contains page length")
    public void setPageLengthTopics(String pageLengthTopics) {
        this.pageLengthTopics = pageLengthTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a search. The data attribute contains searching param")
    public void setSearchTopics(String searchTopic) {
        this.searchTopics = searchTopic;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a state clear")
    public void setStateClearTopics(String stateClearTopics) {
        this.stateClearTopics = stateClearTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics that trigger a state save")
    public void setStateSaveTopics(String stateSaveTopics) {
        this.stateSaveTopics = stateSaveTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when column are resized")
    public void setOnColumnSizingTopics(String onColumnSizingTopics) {
        this.onColumnSizingTopics = onColumnSizingTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when column visibility change")
    public void setOnColumnVisibilityTopics(String onColumnVisibilityTopics) {
        this.onColumnVisibilityTopics = onColumnVisibilityTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired the datatable is destroyed")
    public void setOnDestroyTopics(String onDestroyTopics) {
        this.onDestroyTopics = onDestroyTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when a draw has finished")
    public void setOnDrawTopics(String onDrawTopics) {
        this.onDrawTopics = onDrawTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when an error occured while processing data")
    public void setOnProcessingErrorTopics(String onProcessingErrorTopics) {
        this.onProcessingErrorTopics = onProcessingErrorTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired datatable initialization is complete")
    public void setOnInitCompleteTopics(String onInitCompleteTopics) {
        this.onInitCompleteTopics = onInitCompleteTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when the page length has changed")
    public void setOnPageLengthChangeTopics(String onPageLengthChangeTopics) {
        this.onPageLengthChangeTopics = onPageLengthChangeTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when data contained in the table is ordered")
    public void setOnOrderTopics(String onOrderTopics) {
        this.onOrderTopics = onOrderTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when paging is updated")
    public void setOnPageChangeTopics(String onPageChangeTopics) {
        this.onPageChangeTopics = onPageChangeTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when initialisation started, immediately before data load")
    public void setOnInitStartTopics(String onInitStartTopics) {
        this.onInitStartTopics = onInitStartTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when data is processed")
    public void setOnProcessingTopics(String onProcessingTopics) {
        this.onProcessingTopics = onProcessingTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when the table is filtered")
    public void setOnSearchTopics(String onSearchTopics) {
        this.onSearchTopics = onSearchTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when state has been loaded and applied")
    public void setOnStateLoadedTopics(String onStateLoadedTopics) {
        this.onStateLoadedTopics = onStateLoadedTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when state is beeing loaded from storage")
    public void setOnStateLoadingTopics(String onStateLoadingTopics) {
        this.onStateLoadingTopics = onStateLoadingTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when column state is beeing stored")
    public void setOnStateSavingTopics(String onStateSavingTopics) {
        this.onStateSavingTopics = onStateSavingTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when an autoFill action has been completed")
    public void setOnAutoFillTopics(String onAutoFillTopics) {
        this.onAutoFillTopics = onAutoFillTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when an auto fill action is about to be applied to the table")
    public void setOnBeforeAutoFillTopics(String onBeforeAutoFillTopics) {
        this.onBeforeAutoFillTopics = onBeforeAutoFillTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when a button action has been triggered")
    public void setOnButtonActionTopics(String onButtonActionTopics) {
        this.onButtonActionTopics = onButtonActionTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when columns have been reordered by user or API")
    public void setOnColumnReorderTopics(String onColumnReorderTopics) {
        this.onColumnReorderTopics = onColumnReorderTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when KeyTable has blurred focus from a cell")
    public void setOnKeyBlurTopics(String onKeyBlurTopics) {
        this.onKeyBlurTopics = onKeyBlurTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when KeyTable has focused a cell")
    public void setOnKeyFocusTopics(String onKeyFocusTopics) {
        this.onKeyFocusTopics = onKeyFocusTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when a key event has been detected and is not handled by KeyTable")
    public void setOnOtherKeyTopics(String onOtherKeyTopics) {
        this.onOtherKeyTopics = onOtherKeyTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when the details for a row has been displayed, updated or hidden")
    public void setOnResponsiveDisplayTopics(String onResponsiveDisplayTopics) {
        this.onResponsiveDisplayTopics = onResponsiveDisplayTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when the columns displayed by Responsive has changed due to resize")
    public void setOnResponsiveResizeTopics(String onResponsiveResizeTopics) {
        this.onResponsiveResizeTopics = onResponsiveResizeTopics;
    }
    @StrutsTagAttribute(description = "Comma separated list of topics fired when row group point have been changed")
    public void setOnRowGroupPointChangedTopics(String onRowGroupPointChangedTopics) {
        this.onRowGroupPointChangedTopics = onRowGroupPointChangedTopics;
    }
    @StrutsTagAttribute(description = "Comma separated list of topics fired when row have been reordered by the user, when dropping is done, but before data change is applied")
    public void setOnRowReorderTopics(String onRowReorderTopics) {
        this.onRowReorderTopics = onRowReorderTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when rows have been reordered by the user")
    public void setOnRowReorderedTopics(String onRowReorderedTopics) {
        this.onRowReorderedTopics = onRowReorderedTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when items have been deselected")
    public void setOnDeselectTopics(String onDeselectTopics) {
        this.onDeselectTopics = onDeselectTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when items have been selected")
    public void setOnSelectTopics(String onSelectTopics) {
        this.onSelectTopics = onSelectTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when select items type change event")
    public void setOnSelectItemsTopics(String onSelectItemsTopics) {
        this.onSelectItemsTopics = onSelectItemsTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when select items style change event")
    public void setOnSelectStyleTopics(String onSelectStyleTopics) {
        this.onSelectStyleTopics = onSelectStyleTopics;
    }

    @StrutsTagAttribute(description = "Comma separated list of topics fired when a user action cause items to be selected in the table")
    public void setOnUserSelectTopics(String onUserSelectTopics) {
        this.onUserSelectTopics = onUserSelectTopics;
    }
}
