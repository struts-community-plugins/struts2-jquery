<#--
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
-->
<#assign escapedOptionId="${parameters.escapedId}">
</table>
<@s.script type='text/javascript'>
jQuery(document).ready(function () {
    var options_${escapedOptionId} = {};
    options_${escapedOptionId}.theme="${parameters.datatablesTheme!'default'}";
    <#include "/${parameters.templateDir}/jquery/topics.ftl" />
    <#include "/${parameters.templateDir}/jquery/base.ftl" />
    <#if parameters.autoWidth!true == false>
    options_${escapedOptionId}.autoWidth = false
    </#if>
    <#if parameters.deferRender!false == true>
    options_${escapedOptionId}.deferRender = true;
    </#if>
    <#if parameters.info!true == false>
    options_${escapedOptionId}.info = false;
    </#if>
    <#if parameters.lengthChange!true == false>
    options_${escapedOptionId}.lengthChange = false;
    </#if>
    <#if parameters.ordering!true == false>
    options_${escapedOptionId}.ordering = false;
    </#if>
    <#if parameters.paging!true == false>
    options_${escapedOptionId}.paging = false;
    </#if>
    <#if parameters.processing!false == true>
    options_${escapedOptionId}.processing = true;
    </#if>
    <#if parameters.scrollX!false == true>
    options_${escapedOptionId}.scrollX = true;
    </#if>
    <#if parameters.scrollY!false == true>
    options_${escapedOptionId}.scrollY = true;
    </#if>
    <#if parameters.searching!true == false>
    options_${escapedOptionId}.searching = false;
    </#if>
    <#if parameters.serverSide!false == true>
    options_${escapedOptionId}.serverSide = true;
    </#if>
    <#if parameters.stateSave!false == true>
    options_${escapedOptionId}.stateSave = true;
    </#if>
    <#if parameters.data! != "">
    options_${escapedOptionId}.data = <#outputformat "JavaScript">${parameters.data!'[]'}</#outputformat>;
    </#if>
    <#if parameters.ajax! != "">
    options_${escapedOptionId}.ajax = <#outputformat "JavaScript">${parameters.ajax!'{}'}</#outputformat>;
    </#if>
    <#if parameters.columns! != "">
    options_${escapedOptionId}.columns = <#outputformat "JavaScript">${parameters.columns!'[]'}</#outputformat>;
    </#if>
    <#if parameters.columnDefs! != "">
    options_${escapedOptionId}.columnDefs = <#outputformat "JavaScript">${parameters.columnDefs!'[]'}</#outputformat>;
    </#if>
    <#if parameters.deferLoading?? >
    options_${escapedOptionId}.deferLoading = ${parameters.deferLoading!0};
    </#if>
    <#if parameters.displayStart??>
    options_${escapedOptionId}.displayStart = ${parameters.displayStart!0};
    </#if>
    <#if parameters.dom! != "">
    options_${escapedOptionId}.dom = "${parameters.dom!''}";
    </#if>
    <#if parameters.lengthMenu! != "">
    options_${escapedOptionId}.lengthMenu = <#outputformat "JavaScript">${parameters.lengthMenu!'[10,25,50,100]'}</#outputformat>;
    </#if>
    <#if parameters.pageLength?? >
    options_${escapedOptionId}.pageLength = <#outputformat "JavaScript">${parameters.pageLength!10}</#outputformat>;
    </#if>
    <#if parameters.pagingType! != "">
    options_${escapedOptionId}.pagingType = "<#outputformat "JavaScript">${parameters.pagingType!'full_numbers'}</#outputformat>";
    </#if>
    <#if parameters.order! != "">
    options_${escapedOptionId}.order = <#outputformat "JavaScript">${parameters.order!"[[0,'asc']]"}</#outputformat>;
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId}.orderCellsTop = <#outputformat "JavaScript">${parameters.orderCellsTop!'false'}</#outputformat>;
    </#if>
    <#if parameters.orderClasses?? >
    options_${escapedOptionId}.orderClasses = <#outputformat "JavaScript">${parameters.orderClasses!'true'}</#outputformat>;
    </#if>
    <#if parameters.orderFixed! != "">
    options_${escapedOptionId}.orderFixed = <#outputformat "JavaScript">${parameters.orderFixed!'null'}</#outputformat>;
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId}.orderCellsTop = <#outputformat "JavaScript">${parameters.orderCellsTop!'false'}</#outputformat>;
    </#if>
    <#if parameters.orderMulti! != "">
    options_${escapedOptionId}.orderMulti = <#outputformat "JavaScript">${parameters.orderMulti!'true'}</#outputformat>;
    </#if>
    <#if parameters.renderer! != "">
    options_${escapedOptionId}.renderer = "<#outputformat "JavaScript">${parameters.renderer!''}</#outputformat>";
    </#if>
    <#if parameters.rowId! != "">
    options_${escapedOptionId}.rowId = "<#outputformat "JavaScript">${parameters.rowId!''}</#outputformat>";
    </#if>
    <#if parameters.scrollCollapse?? >
    options_${escapedOptionId}.scrollCollapse = <#outputformat "JavaScript">${parameters.scrollCollapse?string('true','false')}</#outputformat>;
    </#if>
    <#if parameters.search! != "">
    options_${escapedOptionId}.search = <#outputformat "JavaScript">${parameters.search!''}</#outputformat>;
    </#if>
    <#if parameters.searchCols! != "">
    options_${escapedOptionId}.searchCols = <#outputformat "JavaScript">${parameters.searchCols!'null'}</#outputformat>;
    </#if>
    <#if parameters.searchDelay?? >
    options_${escapedOptionId}.searchDelay = <#outputformat "JavaScript">${parameters.searchDelay!'null'}</#outputformat>;
    </#if>
    <#if parameters.stateDuration?? >
    options_${escapedOptionId}.stateDuration = ${parameters.stateDuration!7200};
    </#if>
    <#if parameters.stripeClasses! != "">
    options_${escapedOptionId}.stripeClasses = <#outputformat "JavaScript">${parameters.stripeClasses!"['odd','even']"}</#outputformat>;
    </#if>
    <#if parameters.responsive! != "">
    options_${escapedOptionId}.responsive = <#outputformat "JavaScript">${parameters.responsive!'false'}</#outputformat>;
    </#if>
    <#if parameters.autoFill! != "">
    options_${escapedOptionId}.autoFill = <#outputformat "JavaScript">${parameters.autoFill!'false'}</#outputformat>;
    </#if>
    <#if parameters.buttons! != "">
    options_${escapedOptionId}.buttons = <#outputformat "JavaScript">${parameters.buttons!'false'}</#outputformat>;
    </#if>
    <#if parameters.colReorder! != "">
    options_${escapedOptionId}.colReorder = <#outputformat "JavaScript">${parameters.colReorder!'false'}</#outputformat>;
    </#if>
    <#if parameters.fixedColumns! != "">
    options_${escapedOptionId}.fixedColumns = <#outputformat "JavaScript">${parameters.fixedColumns!'false'}</#outputformat>;
    </#if>
    <#if parameters.fixedHeader! != "">
    options_${escapedOptionId}.fixedHeader = <#outputformat "JavaScript">${parameters.fixedHeader!'false'}</#outputformat>;
    </#if>
    <#if parameters.keys! != "">
    options_${escapedOptionId}.keys = ${parameters.keys!'false'};
    </#if>
    <#if parameters.rowGroup! != "">
    options_${escapedOptionId}.rowGroup = <#outputformat "JavaScript">${parameters.rowGroup!'false'}</#outputformat>;
    </#if>
    <#if parameters.rowReorder! != "">
    options_${escapedOptionId}.rowReorder = <#outputformat "JavaScript">${parameters.rowReorder!'false'}</#outputformat>;
    </#if>
    <#if parameters.scroller! != "">
    options_${escapedOptionId}.scroller = <#outputformat "JavaScript">${parameters.scroller!'false'}</#outputformat>;
    </#if>
    <#if parameters.select! != "">
    options_${escapedOptionId}.select = <#outputformat "JavaScript">${parameters.select!'false'}</#outputformat>;
    </#if>
    <#if parameters.createdRow??>
    options_${escapedOptionId}.createdRow = <#outputformat "JavaScript">${parameters.createdRow?string}</#outputformat>;
  </#if>
    <#if parameters.drawCallback??>
    options_${escapedOptionId}.drawCallback = <#outputformat "JavaScript">${parameters.drawCallback?string}</#outputformat>;
  </#if>
    <#if parameters.footerCallback??>
    options_${escapedOptionId}.footerCallback = "<#outputformat "JavaScript">${parameters.footerCallback?string}</#outputformat>";
  </#if>
    <#if parameters.formatNumber??>
    options_${escapedOptionId}.formatNumber = <#outputformat "JavaScript">${parameters.formatNumber?string}</#outputformat>;
  </#if>
    <#if parameters.headerCallback??>
    options_${escapedOptionId}.headerCallback = <#outputformat "JavaScript">${parameters.headerCallback?string}</#outputformat>;
  </#if>
    <#if parameters.infoCallback??>
    options_${escapedOptionId}.infoCallback = <#outputformat "JavaScript">${parameters.infoCallback?string}</#outputformat>;
  </#if>
    <#if parameters.initComplete??>
    options_${escapedOptionId}.initComplete = <#outputformat "JavaScript">${parameters.initComplete?string}</#outputformat>;
  </#if>
    <#if parameters.preDrawCallback??>
    options_${escapedOptionId}.preDrawCallback = <#outputformat "JavaScript">${parameters.preDrawCallback?string}</#outputformat>;
  </#if>
    <#if parameters.rowCallback??>
    options_${escapedOptionId}.rowCallback = <#outputformat "JavaScript">${parameters.rowCallback?string}</#outputformat>;
  </#if>
    <#if parameters.stateLoadCallback??>
    options_${escapedOptionId}.stateLoadCallback = <#outputformat "JavaScript">${parameters.stateLoadCallback?string}</#outputformat>;
  </#if>
    <#if parameters.stateLoaded??>
    options_${escapedOptionId}.stateLoaded = <#outputformat "JavaScript">${parameters.stateLoaded?string}</#outputformat>;
  </#if>
    <#if parameters.stateLoadParams??>
    options_${escapedOptionId}.stateLoadParams = <#outputformat "JavaScript">${parameters.stateLoadParams?string}</#outputformat>;
  </#if>
    <#if parameters.stateSaveCallback??>
    options_${escapedOptionId}.stateSaveCallback = <#outputformat "JavaScript">${parameters.stateSaveCallback?string}</#outputformat>;
  </#if>
    <#if parameters.stateSaveParams??>
    options_${escapedOptionId}.stateSaveParams = <#outputformat "JavaScript">${parameters.stateSaveParams?string}</#outputformat>;
  </#if>
<#if parameters.clearTableTopics??>
    options_${escapedOptionId}.clearTableTopics = "<#outputformat "JavaScript">${parameters.clearTableTopics?string}</#outputformat>";
  </#if>
<#if parameters.ajaxReloadTopics??>
    options_${escapedOptionId}.ajaxReloadTopics = "<#outputformat "JavaScript">${parameters.ajaxReloadTopics?string}</#outputformat>";
  </#if>
<#if parameters.redrawTopics??>
    options_${escapedOptionId}.redrawTopics = "<#outputformat "JavaScript">${parameters.redrawTopics?string}</#outputformat>";
  </#if>
<#if parameters.orderTopics??>
    options_${escapedOptionId}.orderTopics = "<#outputformat "JavaScript">${parameters.orderTopics?string}</#outputformat>";
  </#if>
<#if parameters.pageTopics??>
    options_${escapedOptionId}.pageTopics = "<#outputformat "JavaScript">${parameters.pageTopics?string}</#outputformat>";
  </#if>
<#if parameters.pageLengthTopics??>
    options_${escapedOptionId}.pageLengthTopics = "<#outputformat "JavaScript">${parameters.pageLengthTopics?string}</#outputformat>";
  </#if>
<#if parameters.searchTopics??>
    options_${escapedOptionId}.searchTopics = "<#outputformat "JavaScript">${parameters.searchTopics?string}</#outputformat>";
  </#if>
<#if parameters.stateClearTopics??>
    options_${escapedOptionId}.stateClearTopics = "<#outputformat "JavaScript">${parameters.stateClearTopics?string}</#outputformat>";
  </#if>
<#if parameters.stateSaveTopics??>
    options_${escapedOptionId}.stateSaveTopics = "<#outputformat "JavaScript">${parameters.stateSaveTopics?string}</#outputformat>";
  </#if>
<#if parameters.onColumnSizingTopics??>
    options_${escapedOptionId}.onColumnSizingTopics = "<#outputformat "JavaScript">${parameters.onColumnSizingTopics?string}</#outputformat>";
  </#if>
<#if parameters.onColumnVisibilityTopics??>
    options_${escapedOptionId}.onColumnVisibilityTopics = "<#outputformat "JavaScript">${parameters.onColumnVisibilityTopics?string}</#outputformat>";
  </#if>
<#if parameters.onDestroyTopics??>
    options_${escapedOptionId}.onDestroyTopics = "<#outputformat "JavaScript">${parameters.onDestroyTopics?string}</#outputformat>";
  </#if>
<#if parameters.onDrawTopics??>
    options_${escapedOptionId}.onDrawTopics = "<#outputformat "JavaScript">${parameters.onDrawTopics?string}</#outputformat>";
  </#if>
<#if parameters.onProcessingErrorTopics??>
    options_${escapedOptionId}.onProcessingErrorTopics = "<#outputformat "JavaScript">${parameters.onProcessingErrorTopics?string}</#outputformat>";
  </#if>
<#if parameters.onInitCompleteTopics??>
    options_${escapedOptionId}.onInitCompleteTopics = "<#outputformat "JavaScript">${parameters.onInitCompleteTopics?string}</#outputformat>";
  </#if>
<#if parameters.onPageLengthChangeTopics??>
    options_${escapedOptionId}.onPageLengthChangeTopics = "<#outputformat "JavaScript">${parameters.onPageLengthChangeTopics?string}</#outputformat>";
  </#if>
<#if parameters.onOrderTopics??>
    options_${escapedOptionId}.onOrderTopics = "<#outputformat "JavaScript">${parameters.onOrderTopics?string}</#outputformat>";
  </#if>
<#if parameters.onPageChangeTopics??>
    options_${escapedOptionId}.onPageChangeTopics = "<#outputformat "JavaScript">${parameters.onPageChangeTopics?string}</#outputformat>";
  </#if>
<#if parameters.onInitStartTopics??>
    options_${escapedOptionId}.onInitStartTopics = "<#outputformat "JavaScript">${parameters.onInitStartTopics?string}</#outputformat>";
  </#if>
<#if parameters.onProcessingTopics??>
    options_${escapedOptionId}.onProcessingTopics = "<#outputformat "JavaScript">${parameters.onProcessingTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSearchTopics??>
    options_${escapedOptionId}.onSearchTopics = "<#outputformat "JavaScript">${parameters.onSearchTopics?string}</#outputformat>";
  </#if>
<#if parameters.onStateLoadedTopics??>
    options_${escapedOptionId}.onStateLoadedTopics = "<#outputformat "JavaScript">${parameters.onStateLoadedTopics?string}</#outputformat>";
  </#if>
<#if parameters.onStateLoadingTopics??>
    options_${escapedOptionId}.onStateLoadingTopics = "<#outputformat "JavaScript">${parameters.onStateLoadingTopics?string}</#outputformat>";
  </#if>
<#if parameters.onStateSavingTopics??>
    options_${escapedOptionId}.onStateSavingTopics = "<#outputformat "JavaScript">${parameters.onStateSavingTopics?string}</#outputformat>";
  </#if>

<#if parameters.onAutoFillTopics??>
    options_${escapedOptionId}.onAutoFillTopics = "<#outputformat "JavaScript">${parameters.onAutoFillTopics?string}</#outputformat>";
  </#if>
<#if parameters.onBeforeAutoFillTopics??>
    options_${escapedOptionId}.onBeforeAutoFillTopics = "<#outputformat "JavaScript">${parameters.onBeforeAutoFillTopics?string}</#outputformat>";
  </#if>
<#if parameters.onButtonActionTopics??>
    options_${escapedOptionId}.onButtonActionTopics = "<#outputformat "JavaScript">${parameters.onButtonActionTopics?string}</#outputformat>";
  </#if>
<#if parameters.onColumnReorderTopics??>
    options_${escapedOptionId}.onColumnReorderTopics = "<#outputformat "JavaScript">${parameters.onColumnReorderTopics?string}</#outputformat>";
  </#if>
<#if parameters.onKeyBlurTopics??>
    options_${escapedOptionId}.onKeyBlurTopics = "<#outputformat "JavaScript">${parameters.onKeyBlurTopics?string}</#outputformat>";
  </#if>
<#if parameters.onKeyFocusTopics??>
    options_${escapedOptionId}.onKeyFocusTopics = "<#outputformat "JavaScript">${parameters.onKeyFocusTopics?string}</#outputformat>";
  </#if>
<#if parameters.onOtherKeyTopics??>
    options_${escapedOptionId}.onOtherKeyTopics = "<#outputformat "JavaScript">${parameters.onOtherKeyTopics?string}</#outputformat>";
  </#if>
<#if parameters.onResponsiveDisplayTopics??>
    options_${escapedOptionId}.onResponsiveDisplayTopics = "<#outputformat "JavaScript">${parameters.onResponsiveDisplayTopics?string}</#outputformat>";
  </#if>
<#if parameters.onResponsiveResizeTopics??>
    options_${escapedOptionId}.onResponsiveResizeTopics = "<#outputformat "JavaScript">${parameters.onResponsiveResizeTopics?string}</#outputformat>";
  </#if>
<#if parameters.onRowGroupPointChangedTopics??>
    options_${escapedOptionId}.onRowGroupPointChangedTopics = "<#outputformat "JavaScript">${parameters.onRowGroupPointChangedTopics?string}</#outputformat>";
  </#if>
<#if parameters.onRowReorderTopics??>
    options_${escapedOptionId}.onRowReorderTopics = "<#outputformat "JavaScript">${parameters.onRowReorderTopics?string}</#outputformat>";
  </#if>
<#if parameters.onRowReorderedTopics??>
    options_${escapedOptionId}.onRowReorderedTopics = "<#outputformat "JavaScript">${parameters.onRowReorderedTopics?string}</#outputformat>";
  </#if>
<#if parameters.onDeselectTopics??>
    options_${escapedOptionId}.onDeselectTopics = "<#outputformat "JavaScript">${parameters.onDeselectTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSelectTopics??>
    options_${escapedOptionId}.onSelectTopics = "<#outputformat "JavaScript">${parameters.onSelectTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSelectItemsTopics??>
    options_${escapedOptionId}.onSelectItemsTopics = "<#outputformat "JavaScript">${parameters.onSelectItemsTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSelectStyleTopics??>
    options_${escapedOptionId}.onSelectStyleTopics = "<#outputformat "JavaScript">${parameters.onSelectStyleTopics?string}</#outputformat>";
  </#if>
<#if parameters.onUserSelectTopics??>
    options_${escapedOptionId}.onUserSelectTopics = "<#outputformat "JavaScript">${parameters.onUserSelectTopics?string}</#outputformat>";
  </#if>

    <#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
    jQuery.struts2_jquery_datatables.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
});
</@s.script>
