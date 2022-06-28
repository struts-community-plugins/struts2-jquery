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
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">
</table>
<script type='text/javascript'>
jQuery(document).ready(function () {
    var options_${escapedOptionId} = {};   
    options_${escapedOptionId}.theme="${parameters.datatablesTheme?default('default')}";
    <#include "/${parameters.templateDir}/jquery/topics.ftl" />
    <#include "/${parameters.templateDir}/jquery/base.ftl" />
    <#if parameters.autoWidth?default(true) == false>
    options_${escapedOptionId}.autoWidth = false
    </#if>
    <#if parameters.deferRender?default(false) == true>
    options_${escapedOptionId}.deferRender = true;
    </#if>
    <#if parameters.info?default(true) == false>
    options_${escapedOptionId}.info = false;
    </#if>
    <#if parameters.lengthChange?default(true) == false>
    options_${escapedOptionId}.lengthChange = false;
    </#if>
    <#if parameters.ordering?default(true) == false>
    options_${escapedOptionId}.ordering = false;
    </#if>
    <#if parameters.paging?default(true) == false>
    options_${escapedOptionId}.paging = false;
    </#if>
    <#if parameters.processing?default(false) == true>
    options_${escapedOptionId}.processing = true;
    </#if>
    <#if parameters.scrollX?default(false) == true>
    options_${escapedOptionId}.scrollX = true;
    </#if>
    <#if parameters.scrollY?default(false) == true>
    options_${escapedOptionId}.scrollY = true;
    </#if>
    <#if parameters.searching?default(true) == false>
    options_${escapedOptionId}.searching = false;
    </#if>
    <#if parameters.serverSide?default(false) == true>
    options_${escapedOptionId}.serverSide = true;
    </#if>
    <#if parameters.stateSave?default(false) == true>
    options_${escapedOptionId}.stateSave = true;
    </#if>
    <#if parameters.data?if_exists != "">
    options_${escapedOptionId}.data = ${parameters.data?default('[]')};
    </#if>
    <#if parameters.ajax?if_exists != "">
    options_${escapedOptionId}.ajax = ${parameters.ajax?default('{}')};
    </#if>
    <#if parameters.columns?if_exists != "">
    options_${escapedOptionId}.columns = ${parameters.columns?default('[]')};
    </#if>
    <#if parameters.columnDefs?if_exists != "">
    options_${escapedOptionId}.columnDefs = ${parameters.columnDefs?default('[]')};
    </#if>
    <#if parameters.deferLoading?? >
    options_${escapedOptionId}.deferLoading = ${parameters.deferLoading?default(0)};
    </#if>
    <#if parameters.displayStart??>
    options_${escapedOptionId}.displayStart = ${parameters.displayStart?default(0)};
    </#if>
    <#if parameters.dom?if_exists != "">
    options_${escapedOptionId}.dom = "${parameters.dom?default('')}";
    </#if>
    <#if parameters.lengthMenu?if_exists != "">
    options_${escapedOptionId}.lengthMenu = ${parameters.lengthMenu?default('[10,25,50,100]')};
    </#if>
    <#if parameters.pageLength?? >
    options_${escapedOptionId}.pageLength = ${parameters.pageLength?default(10)};
    </#if>
    <#if parameters.pagingType?if_exists != "">
    options_${escapedOptionId}.pagingType = "${parameters.pagingType?default('full_numbers')}";
    </#if>
    <#if parameters.order?if_exists != "">
    options_${escapedOptionId}.order = ${parameters.order?default('[[0,'asc']]')};
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId}.orderCellsTop = ${parameters.orderCellsTop?default('false')};
    </#if>
    <#if parameters.orderClasses?? >
    options_${escapedOptionId}.orderClasses = ${parameters.orderClasses?default('true')};
    </#if>
    <#if parameters.orderFixed?if_exists != "">
    options_${escapedOptionId}.orderFixed = ${parameters.orderFixed?default('null')};
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId}.orderCellsTop = ${parameters.orderCellsTop?default('false')};
    </#if>
    <#if parameters.orderMulti?if_exists != "">
    options_${escapedOptionId}.orderMulti = ${parameters.orderMulti?default('true')};
    </#if>
    <#if parameters.renderer?if_exists != "">
    options_${escapedOptionId}.renderer = "${parameters.renderer?default('')}";
    </#if>
    <#if parameters.rowId?if_exists != "">
    options_${escapedOptionId}.rowId = "${parameters.rowId?default('')}";
    </#if>
    <#if parameters.scrollCollapse?? >
    options_${escapedOptionId}.scrollCollapse = ${parameters.scrollCollapse?string('true','false')};
    </#if>
    <#if parameters.search?if_exists != "">
    options_${escapedOptionId}.search = ${parameters.search?default('')};
    </#if>
    <#if parameters.searchCols?if_exists != "">
    options_${escapedOptionId}.searchCols = ${parameters.searchCols?default('null')};
    </#if>
    <#if parameters.searchDelay?? >
    options_${escapedOptionId}.searchDelay = ${parameters.searchDelay?default('null')};
    </#if>
    <#if parameters.stateDuration?? >
    options_${escapedOptionId}.stateDuration = ${parameters.stateDuration?default(7200)};
    </#if>
    <#if parameters.stripeClasses?if_exists != "">
    options_${escapedOptionId}.stripeClasses = ${parameters.stripeClasses?default('['odd','even']')};
    </#if>
    <#if parameters.responsive?if_exists != "">
    options_${escapedOptionId}.responsive = ${parameters.responsive?default('false')};
    </#if>
    <#if parameters.autoFill?if_exists != "">
    options_${escapedOptionId}.autoFill = ${parameters.autoFill?default('false')};
    </#if>
    <#if parameters.buttons?if_exists != "">
    options_${escapedOptionId}.buttons = ${parameters.buttons?default('false')};
    </#if>
    <#if parameters.colReorder?if_exists != "">
    options_${escapedOptionId}.colReorder = ${parameters.colReorder?default('false')};
    </#if>
    <#if parameters.fixedColumns?if_exists != "">
    options_${escapedOptionId}.fixedColumns = ${parameters.fixedColumns?default('false')};
    </#if>
    <#if parameters.fixedHeader?if_exists != "">
    options_${escapedOptionId}.fixedHeader = ${parameters.fixedHeader?default('false')};
    </#if>
    <#if parameters.keys?if_exists != "">
    options_${escapedOptionId}.keys = ${parameters.keys?default('false')};
    </#if>
    <#if parameters.rowGroup?if_exists != "">
    options_${escapedOptionId}.rowGroup = ${parameters.rowGroup?default('false')};
    </#if>
    <#if parameters.rowReorder?if_exists != "">
    options_${escapedOptionId}.rowReorder = ${parameters.rowReorder?default('false')};
    </#if>
    <#if parameters.scroller?if_exists != "">
    options_${escapedOptionId}.scroller = ${parameters.scroller?default('false')};
    </#if>
    <#if parameters.select?if_exists != "">
    options_${escapedOptionId}.select = ${parameters.select?default('false')};
    </#if>
    <#if parameters.createdRow?exists>
    options_${escapedOptionId}.createdRow = ${parameters.createdRow?string};
  </#if>
    <#if parameters.drawCallback?exists>
    options_${escapedOptionId}.drawCallback = ${parameters.drawCallback?string};
  </#if>
    <#if parameters.footerCallback?exists>
    options_${escapedOptionId}.footerCallback = "${parameters.footerCallback?string}";
  </#if>
    <#if parameters.formatNumber?exists>
    options_${escapedOptionId}.formatNumber = ${parameters.formatNumber?string};
  </#if>
    <#if parameters.headerCallback?exists>
    options_${escapedOptionId}.headerCallback = ${parameters.headerCallback?string};
  </#if>
    <#if parameters.infoCallback?exists>
    options_${escapedOptionId}.infoCallback = ${parameters.infoCallback?string};
  </#if>
    <#if parameters.initComplete?exists>
    options_${escapedOptionId}.initComplete = ${parameters.initComplete?string};
  </#if>
    <#if parameters.preDrawCallback?exists>
    options_${escapedOptionId}.preDrawCallback = ${parameters.preDrawCallback?string};
  </#if>
    <#if parameters.rowCallback?exists>
    options_${escapedOptionId}.rowCallback = ${parameters.rowCallback?string};
  </#if>
    <#if parameters.stateLoadCallback?exists>
    options_${escapedOptionId}.stateLoadCallback = ${parameters.stateLoadCallback?string};
  </#if>
    <#if parameters.stateLoaded?exists>
    options_${escapedOptionId}.stateLoaded = ${parameters.stateLoaded?string};
  </#if>
    <#if parameters.stateLoadParams?exists>
    options_${escapedOptionId}.stateLoadParams = ${parameters.stateLoadParams?string};
  </#if>
    <#if parameters.stateSaveCallback?exists>
    options_${escapedOptionId}.stateSaveCallback = ${parameters.stateSaveCallback?string};
  </#if>
    <#if parameters.stateSaveParams?exists>
    options_${escapedOptionId}.stateSaveParams = ${parameters.stateSaveParams?string};
  </#if>
<#if parameters.clearTableTopics?exists>
    options_${escapedOptionId}.clearTableTopics = "${parameters.clearTableTopics?string}";
  </#if>
<#if parameters.ajaxReloadTopics?exists>
    options_${escapedOptionId}.ajaxReloadTopics = "${parameters.ajaxReloadTopics?string}";
  </#if>
<#if parameters.redrawTopics?exists>
    options_${escapedOptionId}.redrawTopics = "${parameters.redrawTopics?string}";
  </#if>
<#if parameters.orderTopics?exists>
    options_${escapedOptionId}.orderTopics = "${parameters.orderTopics?string}";
  </#if>
<#if parameters.pageTopics?exists>
    options_${escapedOptionId}.pageTopics = "${parameters.pageTopics?string}";
  </#if>
<#if parameters.pageLengthTopics?exists>
    options_${escapedOptionId}.pageLengthTopics = "${parameters.pageLengthTopics?string}";
  </#if>
<#if parameters.searchTopics?exists>
    options_${escapedOptionId}.searchTopics = "${parameters.searchTopics?string}";
  </#if>
<#if parameters.stateClearTopics?exists>
    options_${escapedOptionId}.stateClearTopics = "${parameters.stateClearTopics?string}";
  </#if>
<#if parameters.stateSaveTopics?exists>
    options_${escapedOptionId}.stateSaveTopics = "${parameters.stateSaveTopics?string}";
  </#if>
<#if parameters.onColumnSizingTopics?exists>
    options_${escapedOptionId}.onColumnSizingTopics = "${parameters.onColumnSizingTopics?string}";
  </#if>
<#if parameters.onColumnVisibilityTopics?exists>
    options_${escapedOptionId}.onColumnVisibilityTopics = "${parameters.onColumnVisibilityTopics?string}";
  </#if>
<#if parameters.onDestroyTopics?exists>
    options_${escapedOptionId}.onDestroyTopics = "${parameters.onDestroyTopics?string}";
  </#if>
<#if parameters.onDrawTopics?exists>
    options_${escapedOptionId}.onDrawTopics = "${parameters.onDrawTopics?string}";
  </#if>
<#if parameters.onProcessingErrorTopics?exists>
    options_${escapedOptionId}.onProcessingErrorTopics = "${parameters.onProcessingErrorTopics?string}";
  </#if>
<#if parameters.onInitCompleteTopics?exists>
    options_${escapedOptionId}.onInitCompleteTopics = "${parameters.onInitCompleteTopics?string}";
  </#if>
<#if parameters.onPageLengthChangeTopics?exists>
    options_${escapedOptionId}.onPageLengthChangeTopics = "${parameters.onPageLengthChangeTopics?string}";
  </#if>
<#if parameters.onOrderTopics?exists>
    options_${escapedOptionId}.onOrderTopics = "${parameters.onOrderTopics?string}";
  </#if>
<#if parameters.onPageChangeTopics?exists>
    options_${escapedOptionId}.onPageChangeTopics = "${parameters.onPageChangeTopics?string}";
  </#if>
<#if parameters.onInitStartTopics?exists>
    options_${escapedOptionId}.onInitStartTopics = "${parameters.onInitStartTopics?string}";
  </#if>
<#if parameters.onProcessingTopics?exists>
    options_${escapedOptionId}.onProcessingTopics = "${parameters.onProcessingTopics?string}";
  </#if>
<#if parameters.onSearchTopics?exists>
    options_${escapedOptionId}.onSearchTopics = "${parameters.onSearchTopics?string}";
  </#if>
<#if parameters.onStateLoadedTopics?exists>
    options_${escapedOptionId}.onStateLoadedTopics = "${parameters.onStateLoadedTopics?string}";
  </#if>
<#if parameters.onStateLoadingTopics?exists>
    options_${escapedOptionId}.onStateLoadingTopics = "${parameters.onStateLoadingTopics?string}";
  </#if>
<#if parameters.onStateSavingTopics?exists>
    options_${escapedOptionId}.onStateSavingTopics = "${parameters.onStateSavingTopics?string}";
  </#if>

<#if parameters.onAutoFillTopics?exists>
    options_${escapedOptionId}.onAutoFillTopics = "${parameters.onAutoFillTopics?string}";
  </#if>
<#if parameters.onBeforeAutoFillTopics?exists>
    options_${escapedOptionId}.onBeforeAutoFillTopics = "${parameters.onBeforeAutoFillTopics?string}";
  </#if>
<#if parameters.onButtonActionTopics?exists>
    options_${escapedOptionId}.onButtonActionTopics = "${parameters.onButtonActionTopics?string}";
  </#if>
<#if parameters.onColumnReorderTopics?exists>
    options_${escapedOptionId}.onColumnReorderTopics = "${parameters.onColumnReorderTopics?string}";
  </#if>
<#if parameters.onKeyBlurTopics?exists>
    options_${escapedOptionId}.onKeyBlurTopics = "${parameters.onKeyBlurTopics?string}";
  </#if>
<#if parameters.onKeyFocusTopics?exists>
    options_${escapedOptionId}.onKeyFocusTopics = "${parameters.onKeyFocusTopics?string}";
  </#if>
<#if parameters.onOtherKeyTopics?exists>
    options_${escapedOptionId}.onOtherKeyTopics = "${parameters.onOtherKeyTopics?string}";
  </#if>
<#if parameters.onResponsiveDisplayTopics?exists>
    options_${escapedOptionId}.onResponsiveDisplayTopics = "${parameters.onResponsiveDisplayTopics?string}";
  </#if>
<#if parameters.onResponsiveResizeTopics?exists>
    options_${escapedOptionId}.onResponsiveResizeTopics = "${parameters.onResponsiveResizeTopics?string}";
  </#if>
<#if parameters.onRowGroupPointChangedTopics?exists>
    options_${escapedOptionId}.onRowGroupPointChangedTopics = "${parameters.onRowGroupPointChangedTopics?string}";
  </#if>
<#if parameters.onRowReorderTopics?exists>
    options_${escapedOptionId}.onRowReorderTopics = "${parameters.onRowReorderTopics?string}";
  </#if>
<#if parameters.onRowReorderedTopics?exists>
    options_${escapedOptionId}.onRowReorderedTopics = "${parameters.onRowReorderedTopics?string}";
  </#if>
<#if parameters.onDeselectTopics?exists>
    options_${escapedOptionId}.onDeselectTopics = "${parameters.onDeselectTopics?string}";
  </#if>
<#if parameters.onSelectTopics?exists>
    options_${escapedOptionId}.onSelectTopics = "${parameters.onSelectTopics?string}";
  </#if>
<#if parameters.onSelectItemsTopics?exists>
    options_${escapedOptionId}.onSelectItemsTopics = "${parameters.onSelectItemsTopics?string}";
  </#if>
<#if parameters.onSelectStyleTopics?exists>
    options_${escapedOptionId}.onSelectStyleTopics = "${parameters.onSelectStyleTopics?string}";
  </#if>
<#if parameters.onUserSelectTopics?exists>
    options_${escapedOptionId}.onUserSelectTopics = "${parameters.onUserSelectTopics?string}";
  </#if>

    <#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
    jQuery.struts2_jquery_datatables.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
});
</script>  