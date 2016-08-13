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

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.views.annotations.StrutsTag;
import org.apache.struts2.views.annotations.StrutsTagAttribute;
import org.apache.struts2.views.annotations.StrutsTagSkipInheritance;

import com.jgeppert.struts2.jquery.components.AbstractRemoteBean;
import com.opensymphony.xwork2.util.ValueStack;

/**
 * <!-- START SNIPPET: javadoc -->
 * <p>
 * Render a datatableq
 * </p>
 * <!-- END SNIPPET: javadoc -->
 * 
 * <p>
 * Examples:
 * </p>
 * 
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * 
 */
@StrutsTag(name = "datatables", tldTagClass = "com.jgeppert.struts2.jquery.datatables.views.jsp.ui.DatatablesTag", description = "Render a table enhanced with jQuery DataTables")
public class Datatables extends AbstractRemoteBean {

	final private static transient Random RANDOM = new Random();
	public static final String JQUERYACTION = "datatables";
	public static final String TEMPLATE = "datatables";
	public static final String TEMPLATE_CLOSE = "datatables-close";
	public static final String COMPONENT_NAME = Datatables.class.getName();

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

		if (datatablesTheme != null)
			addParameter("datatablesTheme", findString(datatablesTheme));
		if (autoWidth != null)
			addParameter("autoWidth", findValue(autoWidth, Boolean.class));
		if (deferRender != null)
			addParameter("deferRender", findValue(deferRender, Boolean.class));
		if (info != null)
			addParameter("info", findValue(info, Boolean.class));
		if (lengthChange != null)
			addParameter("lengthChange", findValue(lengthChange, Boolean.class));
		if (ordering != null)
			addParameter("ordering", findValue(ordering, Boolean.class));
		if (paging != null)
			addParameter("paging", findValue(paging, Boolean.class));
		if (processing != null)
			addParameter("processing", findValue(processing, Boolean.class));
		if (scrollX != null)
			addParameter("scrollX", findString(scrollX));
		if (scrollY != null)
			addParameter("scrollY", findString(scrollY));
		if (searching != null)
			addParameter("searching", findValue(searching, Boolean.class));
		if (serverSide != null)
			addParameter("serverSide", findValue(serverSide, Boolean.class));
		if (stateSave != null)
			addParameter("stateSave", findValue(stateSave, Boolean.class));
		if (data != null)
			addParameter("data", findString(data));
		if (ajax != null)
			addParameter("ajax", findString(ajax));
		if (columns != null)
			addParameter("columns", findString(columns));
		if (columnDefs != null)
			addParameter("columnDefs", findString(columnDefs));
		if (deferLoading != null)
			addParameter("deferLoading", findValue(deferLoading, Long.class));
		if (displayStart != null)
			addParameter("displayStart", findValue(displayStart, Long.class));
		if (dom != null)
			addParameter("dom", findString(dom));
		if (lengthMenu != null)
			addParameter("lengthMenu", findString(lengthMenu));
		if (pageLength != null)
			addParameter("pageLength", findValue(pageLength, Long.class));
		if (pagingType != null)
			addParameter("pagingType", findString(pagingType));
		if (order != null)
			addParameter("order", findString(order));
		if (orderCellsTop != null)
			addParameter("orderCellsTop", findValue(orderCellsTop, Boolean.class));
		if (orderClasses != null)
			addParameter("orderClasses", findValue(orderClasses, Boolean.class));
		if (orderFixed != null)
			addParameter("orderFixed", findString(orderFixed));
		if (orderMulti != null)
			addParameter("orderMulti", findValue(orderMulti, Boolean.class));
		if (renderer != null)
			addParameter("renderer", findString(renderer));
		if (rowId != null)
			addParameter("rowId", findString(rowId));
		if (scrollCollapse != null)
			addParameter("scrollCollapse", findValue(scrollCollapse, Boolean.class));
		if (search != null)
			addParameter("search", findString(search));
		if (searchCols != null)
			addParameter("searchCols", findString(searchCols));
		if (searchDelay != null)
			addParameter("searchDelay", findValue(searchDelay, Long.class));
		if (stateDuration != null)
			addParameter("stateDuration", findValue(stateDuration, Long.class));
		if (stripeClasses != null)
			addParameter("stripeClasses", findString(stripeClasses));
		if (responsive != null)
			addParameter("responsive", findString(responsive));
		if (autoFill != null)
			addParameter("autoFill", findString(autoFill));
		if (buttons != null)
			addParameter("buttons", findString(buttons));
		if (colReorder != null)
			addParameter("colReorder", findString(colReorder));
		if (fixedColumns != null)
			addParameter("fixedColumns", findString(fixedColumns));
		if (fixedHeader != null)
			addParameter("fixedHeader", findString(fixedHeader));
		if (keys != null)
			addParameter("keys", findString(keys));
		if (rowReorder != null)
			addParameter("rowReorder", findString(rowReorder));
		if (scroller != null)
			addParameter("scroller", findString(scroller));
		if (select != null)
			addParameter("select", findString(select));
		if (createdRow != null)
			addParameter("createdRow", findString(createdRow));
		if (drawCallback != null)
			addParameter("drawCallback", findString(drawCallback));
		if (footerCallback != null)
			addParameter("footerCallback", findString(footerCallback));
		if (formatNumber != null)
			addParameter("formatNumber", findString(formatNumber));
		if (headerCallback != null)
			addParameter("headerCallback", findString(headerCallback));
		if (infoCallback != null)
			addParameter("infoCallback", findString(infoCallback));
		if (initComplete != null)
			addParameter("initComplete", findString(initComplete));
		if (preDrawCallback != null)
			addParameter("preDrawCallback", findString(preDrawCallback));
		if (rowCallback != null)
			addParameter("rowCallback", findString(rowCallback));
		if (stateLoadCallback != null)
			addParameter("stateLoadCallback", findString(stateLoadCallback));
		if (stateLoaded != null)
			addParameter("stateLoaded", findString(stateLoaded));
		if (stateLoadParams != null)
			addParameter("stateLoadParams", findString(stateLoadParams));
		if (stateSaveCallback != null)
			addParameter("stateSaveCallback", findString(stateSaveCallback));
		if (stateSaveParams != null)
			addParameter("stateSaveParams", findString(stateSaveParams));
		if (clearTableTopics != null)
			addParameter("clearTableTopics", findString(clearTableTopics));
		if (ajaxReloadTopics != null)
			addParameter("ajaxReloadTopics", findString(ajaxReloadTopics));
		if (redrawTopics != null)
			addParameter("redrawTopics", findString(redrawTopics));
		if (orderTopics != null)
			addParameter("orderTopics", findString(orderTopics));
		if (pageTopics != null)
			addParameter("pageTopics", findString(pageTopics));
		if (pageLengthTopics != null)
			addParameter("pageLengthTopics", findString(pageLengthTopics));
		if (searchTopics != null)
			addParameter("searchTopics", findString(searchTopics));
		if (stateClearTopics != null)
			addParameter("stateClearTopics", findString(stateClearTopics));
		if (stateSaveTopics != null)
			addParameter("stateSaveTopics", findString(stateSaveTopics));
		if (onStateSavingTopics != null)
			addParameter("onStateSavingTopics", findString(onStateSavingTopics));
		if (onStateLoadingTopics != null)
			addParameter("onStateLoadingTopics", findString(onStateLoadingTopics));
		if (onStateLoadedTopics != null)
			addParameter("onStateLoadedTopics", findString(onStateLoadedTopics));
		if (onSearchTopics != null)
			addParameter("onSearchTopics", findString(onSearchTopics));
		if (onProcessingTopics != null)
			addParameter("onProcessingTopics", findString(onProcessingTopics));
		if (onInitStartTopics != null)
			addParameter("onInitStartTopics", findString(onInitStartTopics));
		if (onPageChangeTopics != null)
			addParameter("onPageChangeTopics", findString(onPageChangeTopics));
		if (onOrderTopics != null)
			addParameter("onOrderTopics", findString(onOrderTopics));
		if (onPageLengthChangeTopics != null)
			addParameter("onPageLengthChangeTopics", findString(onPageLengthChangeTopics));
		if (onInitCompleteTopics != null)
			addParameter("onInitCompleteTopics", findString(onInitCompleteTopics));
		if (onProcessingErrorTopics != null)
			addParameter("onProcessingErrorTopics", findString(onProcessingErrorTopics));
		if (onDrawTopics != null)
			addParameter("onDrawTopics", findString(onDrawTopics));
		if (onDestroyTopics != null)
			addParameter("onDestroyTopics", findString(onDestroyTopics));
		if (onColumnVisibilityTopics != null)
			addParameter("onColumnVisibilityTopics", findString(onColumnVisibilityTopics));
		if (onColumnSizingTopics != null)
			addParameter("onColumnSizingTopics", findString(onColumnSizingTopics));
		if (onAutoFillTopics != null)
			addParameter("onAutoFillTopics", findString(onAutoFillTopics));
		if (onBeforeAutoFillTopics != null)
			addParameter("onBeforeAutoFillTopics", findString(onBeforeAutoFillTopics));
		if (onButtonActionTopics != null)
			addParameter("onButtonActionTopics", findString(onButtonActionTopics));
		if (onColumnReorderTopics != null)
			addParameter("onColumnReorderTopics", findString(onColumnReorderTopics));
		if (onKeyBlurTopics != null)
			addParameter("onKeyBlurTopics", findString(onKeyBlurTopics));
		if (onKeyFocusTopics != null)
			addParameter("onKeyFocusTopics", findString(onKeyFocusTopics));
		if (onOtherKeyTopics != null)
			addParameter("onOtherKeyTopics", findString(onOtherKeyTopics));
		if (onResponsiveDisplayTopics != null)
			addParameter("onResponsiveDisplayTopics", findString(onResponsiveDisplayTopics));
		if (onResponsiveResizeTopics != null)
			addParameter("onResponsiveResizeTopics", findString(onResponsiveResizeTopics));
		if (onRowReorderTopics != null)
			addParameter("onRowReorderTopics", findString(onRowReorderTopics));
		if (onRowReorderedTopics != null)
			addParameter("onRowReorderedTopics", findString(onRowReorderedTopics));
		if (onDeselectTopics != null)
			addParameter("onDeselectTopics", findString(onDeselectTopics));
		if (onSelectTopics != null)
			addParameter("onSelectTopics", findString(onSelectTopics));
		if (onSelectItemsTopics != null)
			addParameter("onSelectItemsTopics", findString(onSelectItemsTopics));
		if (onSelectStyleTopics != null)
			addParameter("onSelectStyleTopics", findString(onSelectStyleTopics));
		if (onUserSelectTopics != null)
			addParameter("onUserSelectTopics", findString(onUserSelectTopics));

		addParameter("jqueryaction", JQUERYACTION);
		if ((this.id == null || this.id.length() == 0)) {
			// resolves Math.abs(Integer.MIN_VALUE) issue reported by
			// FindBugs
			// http://findbugs.sourceforge.net/bugDescriptions.html#RV_ABSOLUTE_VALUE_OF_RANDOM_INT
			int nextInt = RANDOM.nextInt();
			nextInt = nextInt == Integer.MIN_VALUE ? Integer.MAX_VALUE : Math.abs(nextInt);
			this.id = "datatables_" + String.valueOf(nextInt);
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

	@StrutsTagAttribute(description = "the theme for DataTables", defaultValue = "default", required = false)
	public void setDatatablesTheme(String datatablesTheme) {
		this.datatablesTheme = datatablesTheme;
	}

	@StrutsTagAttribute(description = "enable/disable automatic column width calculation", defaultValue = "true", required = false)
	public void setAutoWidth(String autoWidth) {
		this.autoWidth = autoWidth;
	}

	@StrutsTagAttribute(description = "Deffer initial rendering for additional speed up of initialisation", defaultValue = "false", required = false)
	public void setDeferRender(String deferRender) {
		this.deferRender = deferRender;
	}

	@StrutsTagAttribute(description = "enable/disable information display", defaultValue = "true", required = false)
	public void setInfo(String info) {
		this.info = info;
	}

	@StrutsTagAttribute(description = "enable/disable paging length select", defaultValue = "true", required = false)
	public void setLengthChange(String lengthChange) {
		this.lengthChange = lengthChange;
	}

	@StrutsTagAttribute(description = "enable/disable ordering", defaultValue = "true", required = false)
	public void setOrdering(String ordering) {
		this.ordering = ordering;
	}

	@StrutsTagAttribute(description = "enable/disable paging", defaultValue = "true", required = false)
	public void setPaging(String paging) {
		this.paging = paging;
	}

	@StrutsTagAttribute(description = "enable/disable processing message", defaultValue = "false", required = false)
	public void setProcessing(String processing) {
		this.processing = processing;
	}

	@StrutsTagAttribute(description = "controls horizontal scrolling, can be true (auto), or any CSS unit, or any Number", defaultValue = "false", required = false)
	public void setScrollX(String scrollX) {
		this.scrollX = scrollX;
	}

	@StrutsTagAttribute(description = "controls vertical scrolling, can be true (auto), or any CSS unit, or any Number", defaultValue = "false", required = false)
	public void setScrollY(String scrollY) {
		this.scrollY = scrollY;
	}

	@StrutsTagAttribute(description = "enable/disable searching", defaultValue = "true", required = false)
	public void setSearching(String searching) {
		this.searching = searching;
	}

	@StrutsTagAttribute(description = "enable/disable server side processing of searching, paginating,ordering,...", defaultValue = "false", required = false)
	public void setServerSide(String serverSide) {
		this.serverSide = serverSide;
	}

	@StrutsTagAttribute(description = "enable/disable state saving feature", defaultValue = "false", required = false)
	public void setStateSave(String stateSave) {
		this.stateSave = stateSave;
	}

	@StrutsTagAttribute(description = "Use of a JS array as dataSource for the table", defaultValue = "", required = false)
	public void setData(String data) {
		this.data = data;
	}

	@StrutsTagAttribute(description = "Configuration of an AJAX Datasource for the Table. Expect a string (url), oan object(jQuery ajax like config object), or a custom function. See datatables reference for more infos", defaultValue = "", required = false)
	public void setAjax(String ajax) {
		this.ajax = ajax;
	}

	@StrutsTagAttribute(description = "Configuration of columns. Expect a JS array, as specified by datatables manual.", defaultValue = "", required = false)
	public void setColumns(String columns) {
		this.columns = columns;
	}

	@StrutsTagAttribute(description = "Other way of configuring columns. Expect a JS array, as specified by datatables manual.", defaultValue = "", required = false)
	public void setColumnDefs(String columnDefs) {
		this.columnDefs = columnDefs;
	}

	@StrutsTagAttribute(description = "When server side processing is enabled, and initial data is already in the DOM content of the table,"
			+ " if this option is setted with the full dataset size, datatables will defer requesting the server until needed", defaultValue = "", required = false)
	public void setDeferLoading(String deferLoading) {
		this.deferLoading = deferLoading;
	}

	@StrutsTagAttribute(description = "Initial page to show", defaultValue = "0", required = false)
	public void setDisplayStart(String displayStart) {
		this.displayStart = displayStart;
	}

	@StrutsTagAttribute(description = "DataTables dom configuration", defaultValue = "", required = false)
	public void setDom(String dom) {
		this.dom = dom;
	}

	@StrutsTagAttribute(description = "specify the entries in the drop down select for pagination.Expect a 1D array containing integer values of page length or a 2D array with first index being the page lengths and second index being the dispalyed options", defaultValue = "[10,25,50,100]", required = false)
	public void setLengthMenu(String lengthMenu) {
		this.lengthMenu = lengthMenu;
	}

	@StrutsTagAttribute(description = "change the initial page length", defaultValue = "10", required = false)
	public void setPageLength(String pageLength) {
		this.pageLength = pageLength;
	}

	@StrutsTagAttribute(description = "pagination buttons display options.Expects a string whin can be 'numbers': page buttons number only, 'simple': previous and next buttons only, 'simple_numbers' : previous, next plus page numbers, 'full' : first previous next and last buttons, 'full_numbers' : full + numbers ", defaultValue = "simple_numbers", required = false)
	public void setPagingType(String pagingType) {
		this.pagingType = pagingType;
	}

	@StrutsTagAttribute(description = "initial order to apply to the table. Must be an array of arrays, the inner arrays comprised of : column index to order upon, and 'asc' or 'desc' string", defaultValue = "[[0,'asc']]", required = false)
	public void setOrder(String order) {
		this.order = order;
	}

	@StrutsTagAttribute(description = "Control whether DataTables should use the top (true) unique cell for a single column, or the bottom to attach the default order listener", defaultValue = "false", required = false)
	public void setOrderCellsTop(String orderCellsTop) {
		this.orderCellsTop = orderCellsTop;
	}

	@StrutsTagAttribute(description = "Highlight the column being ordered in the table body", defaultValue = "true", required = false)
	public void setOrderClasses(String orderClasses) {
		this.orderClasses = orderClasses;
	}

	@StrutsTagAttribute(description = "ordering to be always applied to the table. See 'order' attribute for argument detail ", defaultValue = "", required = false)
	public void setOrderFixed(String orderFixed) {
		this.orderFixed = orderFixed;
	}

	@StrutsTagAttribute(description = "Enable/Disable multiple column ordering", defaultValue = "true", required = false)
	public void setOrderMulti(String orderMulti) {
		this.orderMulti = orderMulti;
	}

	@StrutsTagAttribute(description = "Display component renderer type", defaultValue = "", required = false)
	public void setRenderer(String renderer) {
		this.renderer = renderer;
	}

	@StrutsTagAttribute(description = "Data property name that must be used to set tr elements DOM IDs", defaultValue = "", required = false)
	public void setRowId(String rowId) {
		this.rowId = rowId;
	}

	@StrutsTagAttribute(description = "Allow the table to reduce in height when a limited number of row is shown", defaultValue = "false", required = false)
	public void setScrollCollapse(String scrollCollapse) {
		this.scrollCollapse = scrollCollapse;
	}

	@StrutsTagAttribute(description = "Search feature configuration. See DataTables reference for more infos", defaultValue = "", required = false)
	public void setSearch(String search) {
		this.search = search;
	}

	@StrutsTagAttribute(description = "Define an initial search for individual columns.Expect an array of the same size as the number of columns, containing an object with 'search' and 'escapeRegex' properties ", defaultValue = "", required = false)
	public void setSearchCols(String searchCols) {
		this.searchCols = searchCols;
	}

	@StrutsTagAttribute(description = "Set a throttle frequency for searching.expect an integer", defaultValue = "null", required = false)
	public void setSearchDelay(String searchDelay) {
		this.searchDelay = searchDelay;
	}

	@StrutsTagAttribute(description = "Saved state validity duration, in seconds", defaultValue = "7200", required = false)
	public void setStateDuration(String stateDuration) {
		this.stateDuration = stateDuration;
	}

	@StrutsTagAttribute(description = "Sets the zebra stripe class names for the rows in the table.Expect an array of class names", defaultValue = "['odd','even']", required = false)
	public void setStripeClasses(String stripeClasses) {
		this.stripeClasses = stripeClasses;
	}

	@StrutsTagAttribute(description = "Responsive plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setResponsive(String responsive) {
		this.responsive = responsive;
	}

	@StrutsTagAttribute(description = "AutoFill plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setAutoFill(String autoFill) {
		this.autoFill = autoFill;
	}

	@StrutsTagAttribute(description = "Buttons plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setButtons(String buttons) {
		this.buttons = buttons;
	}

	@StrutsTagAttribute(description = "ColReorder plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setColReorder(String colReorder) {
		this.colReorder = colReorder;
	}

	@StrutsTagAttribute(description = "Fixed plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setFixedColumns(String fixedColumns) {
		this.fixedColumns = fixedColumns;
	}

	@StrutsTagAttribute(description = "FixedHeader plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setFixedHeader(String fixedHeader) {
		this.fixedHeader = fixedHeader;
	}

	@StrutsTagAttribute(description = "KeyTable plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setKeys(String keys) {
		this.keys = keys;
	}

	@StrutsTagAttribute(description = "RowReorder plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setRowReorder(String rowReorder) {
		this.rowReorder = rowReorder;
	}

	@StrutsTagAttribute(description = "Scroller plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setScroller(String scroller) {
		this.scroller = scroller;
	}

	@StrutsTagAttribute(description = "Select plugin configuration. True to enable with defaults, JS object to enable with custom options", defaultValue = "false", required = false)
	public void setSelect(String select) {
		this.select = select;
	}

	@StrutsTagAttribute(description = "Callback for whenever az TR element is created for the table's body", defaultValue = "", required = false)
	public void setCreatedRow(String createdRow) {
		this.createdRow = createdRow;
	}

	@StrutsTagAttribute(description = "Callback called every time DataTables performs a draw", defaultValue = "", required = false)
	public void setDrawCallback(String drawCallback) {
		this.drawCallback = drawCallback;
	}

	@StrutsTagAttribute(description = "Footer dispplay Callback", defaultValue = "", required = false)
	public void setFooterCallback(String footerCallback) {
		this.footerCallback = footerCallback;
	}

	@StrutsTagAttribute(description = "Number formatting Callback", defaultValue = "", required = false)
	public void setFormatNumber(String formatNumber) {
		this.formatNumber = formatNumber;
	}

	@StrutsTagAttribute(description = "Header display Callback", defaultValue = "", required = false)
	public void setHeaderCallback(String headerCallback) {
		this.headerCallback = headerCallback;
	}

	@StrutsTagAttribute(description = "Table summary display Callback", defaultValue = "", required = false)
	public void setInfoCallback(String infoCallback) {
		this.infoCallback = infoCallback;
	}

	@StrutsTagAttribute(description = "Initialisation complete Callback", defaultValue = "", required = false)
	public void setInitComplete(String initComplete) {
		this.initComplete = initComplete;
	}

	@StrutsTagAttribute(description = "Pre draw Callback", defaultValue = "", required = false)
	public void setPreDrawCallback(String preDrawCallback) {
		this.preDrawCallback = preDrawCallback;
	}

	@StrutsTagAttribute(description = "row draw Callback", defaultValue = "", required = false)
	public void setRowCallback(String rowCallback) {
		this.rowCallback = rowCallback;
	}

	@StrutsTagAttribute(description = "Callback that define where and how a saved state should be loaded", defaultValue = "", required = false)
	public void setStateLoadCallback(String stateLoadCallback) {
		this.stateLoadCallback = stateLoadCallback;
	}

	@StrutsTagAttribute(description = "State loaded Callback", defaultValue = "", required = false)
	public void setStateLoaded(String stateLoaded) {
		this.stateLoaded = stateLoaded;
	}

	@StrutsTagAttribute(description = "State loaded - data manipulation Callback", defaultValue = "", required = false)
	public void setStateLoadParams(String stateLoadParams) {
		this.stateLoadParams = stateLoadParams;
	}

	@StrutsTagAttribute(description = "Callback that define how the table state is stored and where", defaultValue = "", required = false)
	public void setStateSaveCallback(String stateSaveCallback) {
		this.stateSaveCallback = stateSaveCallback;
	}

	@StrutsTagAttribute(description = "State save - Data manipulation Callback", defaultValue = "", required = false)
	public void setStateSaveParams(String stateSaveParams) {
		this.stateSaveParams = stateSaveParams;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a table clear", defaultValue = "", required = false)
	public void setClearTableTopics(String clearTableTopics) {
		this.clearTableTopics = clearTableTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger an AJAX reload", defaultValue = "", required = false)
	public void setAjaxReloadTopics(String ajaxReloadTopics) {
		this.ajaxReloadTopics = ajaxReloadTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a table redraw", defaultValue = "", required = false)
	public void setRedrawTopics(String redrawTopics) {
		this.redrawTopics = redrawTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a table order. The data attribute contains ordering params", defaultValue = "", required = false)
	public void setOrderTopics(String orderTopics) {
		this.orderTopics = orderTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a table page change. The data attribute contains the page number", defaultValue = "", required = false)
	public void setPageTopics(String pageTopics) {
		this.pageTopics = pageTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a page length change. The data attribute contains page length", defaultValue = "", required = false)
	public void setPageLengthTopics(String pageLengthTopics) {
		this.pageLengthTopics = pageLengthTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a search. The data attribute contains searching param", defaultValue = "", required = false)
	public void setSearchTopics(String searchTopic) {
		this.searchTopics = searchTopic;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a state clear", defaultValue = "", required = false)
	public void setStateClearTopics(String stateClearTopics) {
		this.stateClearTopics = stateClearTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics that trigger a state save", defaultValue = "", required = false)
	public void setStateSaveTopics(String stateSaveTopics) {
		this.stateSaveTopics = stateSaveTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when column are resized", defaultValue = "", required = false)
	public void setOnColumnSizingTopics(String onColumnSizingTopics) {
		this.onColumnSizingTopics = onColumnSizingTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when column visibility change", defaultValue = "", required = false)
	public void setOnColumnVisibilityTopics(String onColumnVisibilityTopics) {
		this.onColumnVisibilityTopics = onColumnVisibilityTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired the datatable is destroyed", defaultValue = "", required = false)
	public void setOnDestroyTopics(String onDestroyTopics) {
		this.onDestroyTopics = onDestroyTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when a draw has finished", defaultValue = "", required = false)
	public void setOnDrawTopics(String onDrawTopics) {
		this.onDrawTopics = onDrawTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when an error occured while processing data", defaultValue = "", required = false)
	public void setOnProcessingErrorTopics(String onProcessingErrorTopics) {
		this.onProcessingErrorTopics = onProcessingErrorTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired datatable initialization is complete", defaultValue = "", required = false)
	public void setOnInitCompleteTopics(String onInitCompleteTopics) {
		this.onInitCompleteTopics = onInitCompleteTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when the page length has changed", defaultValue = "", required = false)
	public void setOnPageLengthChangeTopics(String onPageLengthChangeTopics) {
		this.onPageLengthChangeTopics = onPageLengthChangeTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when data contained in the table is ordered", defaultValue = "", required = false)
	public void setOnOrderTopics(String onOrderTopics) {
		this.onOrderTopics = onOrderTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when paging is updated", defaultValue = "", required = false)
	public void setOnPageChangeTopics(String onPageChangeTopics) {
		this.onPageChangeTopics = onPageChangeTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when initialisation started, immediately before data load", defaultValue = "", required = false)
	public void setOnInitStartTopics(String onInitStartTopics) {
		this.onInitStartTopics = onInitStartTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when data is processed", defaultValue = "", required = false)
	public void setOnProcessingTopics(String onProcessingTopics) {
		this.onProcessingTopics = onProcessingTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when the table is filtered", defaultValue = "", required = false)
	public void setOnSearchTopics(String onSearchTopics) {
		this.onSearchTopics = onSearchTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when state has been loaded and applied", defaultValue = "", required = false)
	public void setOnStateLoadedTopics(String onStateLoadedTopics) {
		this.onStateLoadedTopics = onStateLoadedTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when state is beeing loaded from storage", defaultValue = "", required = false)
	public void setOnStateLoadingTopics(String onStateLoadingTopics) {
		this.onStateLoadingTopics = onStateLoadingTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when column state is beeing stored", defaultValue = "", required = false)
	public void setOnStateSavingTopics(String onStateSavingTopics) {
		this.onStateSavingTopics = onStateSavingTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when an autoFill action has been completed", defaultValue = "", required = false)
	public void setOnAutoFillTopics(String onAutoFillTopics) {
		this.onAutoFillTopics = onAutoFillTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when an auto fill action is about to be applied to the table", defaultValue = "", required = false)
	public void setOnBeforeAutoFillTopics(String onBeforeAutoFillTopics) {
		this.onBeforeAutoFillTopics = onBeforeAutoFillTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when a button action has been triggered", defaultValue = "", required = false)
	public void setOnButtonActionTopics(String onButtonActionTopics) {
		this.onButtonActionTopics = onButtonActionTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when columns have been reordered by user or API", defaultValue = "", required = false)
	public void setOnColumnReorderTopics(String onColumnReorderTopics) {
		this.onColumnReorderTopics = onColumnReorderTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when KeyTable has blurred focus from a cell", defaultValue = "", required = false)
	public void setOnKeyBlurTopics(String onKeyBlurTopics) {
		this.onKeyBlurTopics = onKeyBlurTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when KeyTable has focused a cell", defaultValue = "", required = false)
	public void setOnKeyFocusTopics(String onKeyFocusTopics) {
		this.onKeyFocusTopics = onKeyFocusTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when a key event has been detected and is not handled by KeyTable", defaultValue = "", required = false)
	public void setOnOtherKeyTopics(String onOtherKeyTopics) {
		this.onOtherKeyTopics = onOtherKeyTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when the details for a row has been displayed, updated or hidden", defaultValue = "", required = false)
	public void setOnResponsiveDisplayTopics(String onResponsiveDisplayTopics) {
		this.onResponsiveDisplayTopics = onResponsiveDisplayTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when the columns displayed by Responsive has changed due to resize", defaultValue = "", required = false)
	public void setOnResponsiveResizeTopics(String onResponsiveResizeTopics) {
		this.onResponsiveResizeTopics = onResponsiveResizeTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when row have been reordered by the user, when dropping is done, but before data change is applied", defaultValue = "", required = false)
	public void setOnRowReorderTopics(String onRowReorderTopics) {
		this.onRowReorderTopics = onRowReorderTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when rows have been reordered by the user", defaultValue = "", required = false)
	public void setOnRowReorderedTopics(String onRowReorderedTopics) {
		this.onRowReorderedTopics = onRowReorderedTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when items have been deselected", defaultValue = "", required = false)
	public void setOnDeselectTopics(String onDeselectTopics) {
		this.onDeselectTopics = onDeselectTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when items have been selected", defaultValue = "", required = false)
	public void setOnSelectTopics(String onSelectTopics) {
		this.onSelectTopics = onSelectTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when select items type change event", defaultValue = "", required = false)
	public void setOnSelectItemsTopics(String onSelectItemsTopics) {
		this.onSelectItemsTopics = onSelectItemsTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when select items style change event", defaultValue = "", required = false)
	public void setOnSelectStyleTopics(String onSelectStyleTopics) {
		this.onSelectStyleTopics = onSelectStyleTopics;
	}

	@StrutsTagAttribute(description = "Comma separated list of topics fired when a user action cause items to be selected in the table", defaultValue = "", required = false)
	public void setOnUserSelectTopics(String onUserSelectTopics) {
		this.onUserSelectTopics = onUserSelectTopics;
	}
}
