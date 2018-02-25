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

package com.jgeppert.struts2.jquery.datatables.views.jsp.ui;

import com.jgeppert.struts2.jquery.datatables.components.Datatables;
import com.jgeppert.struts2.jquery.views.jsp.ui.AbstractRemoteTag;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.components.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="http://www.jgeppert.com">Johannes Geppert</a>
 * @see Datatables
 */
public class DatatablesTag extends AbstractRemoteTag {

    private static final long serialVersionUID = 2134613468009192567L;

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
    protected String data;
    protected String ajax;
    protected String columns;
    protected String columnDefs;
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
    protected String responsive;
    protected String autoFill;
    protected String buttons;
    protected String colReorder;
    protected String fixedColumns;
    protected String fixedHeader;
    protected String keys;
    protected String rowReorder;
    protected String rowGroup;
    protected String scroller;
    protected String select;
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
    protected String clearTableTopics;
    protected String ajaxReloadTopics;
    protected String redrawTopics;
    protected String orderTopics;
    protected String pageTopics;
    protected String pageLengthTopics;
    protected String searchTopics;
    protected String stateClearTopics;
    protected String stateSaveTopics;
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

    @Override
    public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
        return new Datatables(stack, req, res);
    }

    @Override
    protected void populateParams() {
        super.populateParams();

        Datatables dt = (Datatables) component;
        dt.setDatatablesTheme(datatablesTheme);
        dt.setAutoWidth(autoWidth);
        dt.setDeferRender(deferRender);
        dt.setInfo(info);
        dt.setLengthChange(lengthChange);
        dt.setOrdering(ordering);
        dt.setPaging(paging);
        dt.setProcessing(processing);
        dt.setScrollX(scrollX);
        dt.setScrollY(scrollY);
        dt.setSearching(searching);
        dt.setServerSide(serverSide);
        dt.setStateSave(stateSave);
        dt.setData(data);
        dt.setAjax(ajax);
        dt.setColumns(columns);
        dt.setColumnDefs(columnDefs);
        dt.setDeferLoading(deferLoading);
        dt.setDisplayStart(displayStart);
        dt.setDom(dom);
        dt.setLengthMenu(lengthMenu);
        dt.setPageLength(pageLength);
        dt.setPagingType(pagingType);
        dt.setOrder(order);
        dt.setOrderCellsTop(orderCellsTop);
        dt.setOrderClasses(orderClasses);
        dt.setOrderFixed(orderFixed);
        dt.setOrderMulti(orderMulti);
        dt.setRenderer(renderer);
        dt.setRowId(rowId);
        dt.setScrollCollapse(scrollCollapse);
        dt.setSearch(search);
        dt.setSearchCols(searchCols);
        dt.setSearchDelay(searchDelay);
        dt.setStateDuration(stateDuration);
        dt.setStripeClasses(stripeClasses);
        dt.setResponsive(responsive);
        dt.setAutoFill(autoFill);
        dt.setButtons(buttons);
        dt.setColReorder(colReorder);
        dt.setFixedColumns(fixedColumns);
        dt.setFixedHeader(fixedHeader);
        dt.setKeys(keys);
        dt.setRowGroup(rowGroup);
        dt.setRowReorder(rowReorder);
        dt.setScroller(scroller);
        dt.setSelect(select);
        dt.setCreatedRow(createdRow);
        dt.setDrawCallback(drawCallback);
        dt.setFooterCallback(footerCallback);
        dt.setFormatNumber(formatNumber);
        dt.setHeaderCallback(headerCallback);
        dt.setInfoCallback(infoCallback);
        dt.setInitComplete(initComplete);
        dt.setPreDrawCallback(preDrawCallback);
        dt.setRowCallback(rowCallback);
        dt.setStateLoadCallback(stateLoadCallback);
        dt.setStateLoaded(stateLoaded);
        dt.setStateLoadParams(stateLoadParams);
        dt.setStateSaveCallback(stateSaveCallback);
        dt.setStateSaveParams(stateSaveParams);
        dt.setClearTableTopics(clearTableTopics);
        dt.setAjaxReloadTopics(ajaxReloadTopics);
        dt.setRedrawTopics(redrawTopics);
        dt.setOrderTopics(orderTopics);
        dt.setPageTopics(pageTopics);
        dt.setPageLengthTopics(pageLengthTopics);
        dt.setSearchTopics(searchTopics);
        dt.setStateClearTopics(stateClearTopics);
        dt.setStateSaveTopics(stateSaveTopics);
        dt.setOnColumnSizingTopics(onColumnSizingTopics);
        dt.setOnColumnVisibilityTopics(onColumnVisibilityTopics);
        dt.setOnDestroyTopics(onDestroyTopics);
        dt.setOnDrawTopics(onDrawTopics);
        dt.setOnProcessingTopics(onProcessingTopics);
        dt.setOnInitCompleteTopics(onInitCompleteTopics);
        dt.setOnPageLengthChangeTopics(onPageLengthChangeTopics);
        dt.setOnOrderTopics(onOrderTopics);
        dt.setOnPageChangeTopics(onPageChangeTopics);
        dt.setOnInitStartTopics(onInitStartTopics);
        dt.setOnProcessingErrorTopics(onProcessingErrorTopics);
        dt.setOnSearchTopics(onSearchTopics);
        dt.setOnStateLoadedTopics(onStateLoadedTopics);
        dt.setOnStateLoadingTopics(onStateLoadingTopics);
        dt.setOnStateSavingTopics(onStateSavingTopics);
        dt.setOnAutoFillTopics(onAutoFillTopics);
        dt.setOnBeforeAutoFillTopics(onBeforeAutoFillTopics);
        dt.setOnButtonActionTopics(onButtonActionTopics);
        dt.setOnColumnReorderTopics(onColumnReorderTopics);
        dt.setOnKeyBlurTopics(onKeyBlurTopics);
        dt.setOnKeyFocusTopics(onKeyFocusTopics);
        dt.setOnOtherKeyTopics(onOtherKeyTopics);
        dt.setOnResponsiveDisplayTopics(onResponsiveDisplayTopics);
        dt.setOnResponsiveResizeTopics(onResponsiveResizeTopics);
        dt.setOnRowReorderedTopics(onRowReorderedTopics);
        dt.setOnRowGroupPointChangedTopics(onRowGroupPointChangedTopics);
        dt.setOnRowReorderTopics(onRowReorderTopics);
        dt.setOnDeselectTopics(onDeselectTopics);
        dt.setOnSelectTopics(onSelectTopics);
        dt.setOnSelectItemsTopics(onSelectItemsTopics);
        dt.setOnSelectStyleTopics(onSelectStyleTopics);
        dt.setOnUserSelectTopics(onUserSelectTopics);
    }

    public void setDatatablesTheme(String datatablesTheme) {
        this.datatablesTheme = datatablesTheme;
    }

    public void setAutoWidth(String autoWidth) {
        this.autoWidth = autoWidth;
    }

    public void setDeferRender(String deferRender) {
        this.deferRender = deferRender;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public void setLengthChange(String lengthChange) {
        this.lengthChange = lengthChange;
    }

    public void setOrdering(String ordering) {
        this.ordering = ordering;
    }

    public void setPaging(String paging) {
        this.paging = paging;
    }

    public void setProcessing(String processing) {
        this.processing = processing;
    }

    public void setScrollX(String scrollX) {
        this.scrollX = scrollX;
    }

    public void setScrollY(String scrollY) {
        this.scrollY = scrollY;
    }

    public void setSearching(String searching) {
        this.searching = searching;
    }

    public void setServerSide(String serverSide) {
        this.serverSide = serverSide;
    }

    public void setStateSave(String stateSave) {
        this.stateSave = stateSave;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setAjax(String ajax) {
        this.ajax = ajax;
    }

    public void setColumns(String columns) {
        this.columns = columns;
    }

    public void setColumnDefs(String columnDefs) {
        this.columnDefs = columnDefs;
    }

    public void setDeferLoading(String deferLoading) {
        this.deferLoading = deferLoading;
    }

    public void setDisplayStart(String displayStart) {
        this.displayStart = displayStart;
    }

    public void setDom(String dom) {
        this.dom = dom;
    }

    public void setLengthMenu(String lengthMenu) {
        this.lengthMenu = lengthMenu;
    }

    public void setPageLength(String pageLength) {
        this.pageLength = pageLength;
    }

    public void setPagingType(String pagingType) {
        this.pagingType = pagingType;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public void setOrderCellsTop(String orderCellsTop) {
        this.orderCellsTop = orderCellsTop;
    }

    public void setOrderClasses(String orderClasses) {
        this.orderClasses = orderClasses;
    }

    public void setOrderFixed(String orderFixed) {
        this.orderFixed = orderFixed;
    }

    public void setOrderMulti(String orderMulti) {
        this.orderMulti = orderMulti;
    }

    public void setRenderer(String renderer) {
        this.renderer = renderer;
    }

    public void setRowId(String rowId) {
        this.rowId = rowId;
    }

    public void setScrollCollapse(String scrollCollapse) {
        this.scrollCollapse = scrollCollapse;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public void setSearchCols(String searchCols) {
        this.searchCols = searchCols;
    }

    public void setSearchDelay(String searchDelay) {
        this.searchDelay = searchDelay;
    }

    public void setStateDuration(String stateDuration) {
        this.stateDuration = stateDuration;
    }

    public void setStripeClasses(String stripeClasses) {
        this.stripeClasses = stripeClasses;
    }

    public void setResponsive(String responsive) {
        this.responsive = responsive;
    }

    public void setAutoFill(String autoFill) {
        this.autoFill = autoFill;
    }

    public void setButtons(String buttons) {
        this.buttons = buttons;
    }

    public void setColReorder(String colReorder) {
        this.colReorder = colReorder;
    }

    public void setFixedColumns(String fixedColumns) {
        this.fixedColumns = fixedColumns;
    }

    public void setFixedHeader(String fixedHeader) {
        this.fixedHeader = fixedHeader;
    }

    public void setKeys(String keys) {
        this.keys = keys;
    }

    public void setRowReorder(String rowReorder) {
        this.rowReorder = rowReorder;
    }
    
    public void setRowGroup(String rowGroup) {
		this.rowGroup = rowGroup;
	}

	public void setScroller(String scroller) {
        this.scroller = scroller;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public void setCreatedRow(String createdRow) {
        this.createdRow = createdRow;
    }

    public void setDrawCallback(String drawCallback) {
        this.drawCallback = drawCallback;
    }

    public void setFooterCallback(String footerCallback) {
        this.footerCallback = footerCallback;
    }

    public void setFormatNumber(String formatNumber) {
        this.formatNumber = formatNumber;
    }

    public void setHeaderCallback(String headerCallback) {
        this.headerCallback = headerCallback;
    }

    public void setInfoCallback(String infoCallback) {
        this.infoCallback = infoCallback;
    }

    public void setInitComplete(String initComplete) {
        this.initComplete = initComplete;
    }

    public void setPreDrawCallback(String preDrawCallback) {
        this.preDrawCallback = preDrawCallback;
    }

    public void setRowCallback(String rowCallback) {
        this.rowCallback = rowCallback;
    }

    public void setStateLoadCallback(String stateLoadCallback) {
        this.stateLoadCallback = stateLoadCallback;
    }

    public void setStateLoaded(String stateLoaded) {
        this.stateLoaded = stateLoaded;
    }

    public void setStateLoadParams(String stateLoadParams) {
        this.stateLoadParams = stateLoadParams;
    }

    public void setStateSaveCallback(String stateSaveCallback) {
        this.stateSaveCallback = stateSaveCallback;
    }

    public void setStateSaveParams(String stateSaveParams) {
        this.stateSaveParams = stateSaveParams;
    }

    public void setOnAutoFillTopics(String onAutoFillTopics) {
        this.onAutoFillTopics = onAutoFillTopics;
    }

    public void setOnBeforeAutoFillTopics(String onBeforeAutoFillTopics) {
        this.onBeforeAutoFillTopics = onBeforeAutoFillTopics;
    }

    public void setOnButtonActionTopics(String onButtonActionTopics) {
        this.onButtonActionTopics = onButtonActionTopics;
    }

    public void setOnColumnReorderTopics(String onColumnReorderTopics) {
        this.onColumnReorderTopics = onColumnReorderTopics;
    }

    public void setOnKeyBlurTopics(String onKeyBlurTopics) {
        this.onKeyBlurTopics = onKeyBlurTopics;
    }

    public void setOnKeyFocusTopics(String onKeyFocusTopics) {
        this.onKeyFocusTopics = onKeyFocusTopics;
    }

    public void setOnOtherKeyTopics(String onOtherKeyTopics) {
        this.onOtherKeyTopics = onOtherKeyTopics;
    }

    public void setOnResponsiveDisplayTopics(String onResponsiveDisplayTopics) {
        this.onResponsiveDisplayTopics = onResponsiveDisplayTopics;
    }

    public void setOnResponsiveResizeTopics(String onResponsiveResizeTopics) {
        this.onResponsiveResizeTopics = onResponsiveResizeTopics;
    }

    public void setOnRowGroupPointChangedTopics(String onRowGroupPointChangedTopics) {
		this.onRowGroupPointChangedTopics = onRowGroupPointChangedTopics;
	}

	public void setOnRowReorderTopics(String onRowReorderTopics) {
        this.onRowReorderTopics = onRowReorderTopics;
    }

    public void setOnRowReorderedTopics(String onRowReorderedTopics) {
        this.onRowReorderedTopics = onRowReorderedTopics;
    }

    public void setOnDeselectTopics(String onDeselectTopics) {
        this.onDeselectTopics = onDeselectTopics;
    }

    public void setOnSelectTopics(String onSelectTopics) {
        this.onSelectTopics = onSelectTopics;
    }

    public void setOnSelectItemsTopics(String onSelectItemsTopics) {
        this.onSelectItemsTopics = onSelectItemsTopics;
    }

    public void setOnSelectStyleTopics(String onSelectStyleTopics) {
        this.onSelectStyleTopics = onSelectStyleTopics;
    }

    public void setOnUserSelectTopics(String onUserSelectTopics) {
        this.onUserSelectTopics = onUserSelectTopics;
    }

    public void setOnColumnSizingTopics(String onColumnSizingTopics) {
        this.onColumnSizingTopics = onColumnSizingTopics;
    }

    public void setOnColumnVisibilityTopics(String onColumnVisibilityTopics) {
        this.onColumnVisibilityTopics = onColumnVisibilityTopics;
    }

    public void setOnDestroyTopics(String onDestroyTopics) {
        this.onDestroyTopics = onDestroyTopics;
    }

    public void setOnDrawTopics(String onDrawTopics) {
        this.onDrawTopics = onDrawTopics;
    }

    public void setOnProcessingErrorTopics(String onProcessingErrorTopics) {
        this.onProcessingErrorTopics = onProcessingErrorTopics;
    }

    public void setOnInitCompleteTopics(String onInitCompleteTopics) {
        this.onInitCompleteTopics = onInitCompleteTopics;
    }

    public void setOnPageLengthChangeTopics(String onPageLengthChangeTopics) {
        this.onPageLengthChangeTopics = onPageLengthChangeTopics;
    }

    public void setOnOrderTopics(String onOrderTopics) {
        this.onOrderTopics = onOrderTopics;
    }

    public void setOnPageChangeTopics(String onPageChangeTopics) {
        this.onPageChangeTopics = onPageChangeTopics;
    }

    public void setOnInitStartTopics(String onInitStartTopics) {
        this.onInitStartTopics = onInitStartTopics;
    }

    public void setOnProcessingTopics(String onProcessingTopics) {
        this.onProcessingTopics = onProcessingTopics;
    }

    public void setOnSearchTopics(String onSearchTopics) {
        this.onSearchTopics = onSearchTopics;
    }

    public void setOnStateLoadedTopics(String onStateLoadedTopics) {
        this.onStateLoadedTopics = onStateLoadedTopics;
    }

    public void setOnStateLoadingTopics(String onStateLoadingTopics) {
        this.onStateLoadingTopics = onStateLoadingTopics;
    }

    public void setOnStateSavingTopics(String onStateSavingTopics) {
        this.onStateSavingTopics = onStateSavingTopics;
    }

    public void setClearTableTopics(String clearTableTopics) {
        this.clearTableTopics = clearTableTopics;
    }

    public void setAjaxReloadTopics(String ajaxReloadTopics) {
        this.ajaxReloadTopics = ajaxReloadTopics;
    }

    public void setRedrawTopics(String redrawTopics) {
        this.redrawTopics = redrawTopics;
    }

    public void setOrderTopics(String orderTopics) {
        this.orderTopics = orderTopics;
    }

    public void setPageTopics(String pageTopics) {
        this.pageTopics = pageTopics;
    }

    public void setPageLengthTopics(String pageLengthTopics) {
        this.pageLengthTopics = pageLengthTopics;
    }

    public void setSearchTopics(String searchTopic) {
        this.searchTopics = searchTopic;
    }

    public void setStateClearTopics(String stateClearTopics) {
        this.stateClearTopics = stateClearTopics;
    }

    public void setStateSaveTopics(String stateSaveTopics) {
        this.stateSaveTopics = stateSaveTopics;
    }
}
