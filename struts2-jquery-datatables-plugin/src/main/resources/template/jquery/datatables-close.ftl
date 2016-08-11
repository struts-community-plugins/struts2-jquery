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
    var options_${escapedOptionId?html} = {};   
    options_${escapedOptionId?html}.theme="${parameters.datatablesTheme?default('default')}";
    <#include "/${parameters.templateDir}/jquery/topics.ftl" />
    <#include "/${parameters.templateDir}/jquery/base.ftl" />
    <#if parameters.autoWidth?default(true) == false>
    options_${escapedOptionId?html}.autoWidth = false
    </#if>
    <#if parameters.deferRender?default(false) == true>
    options_${escapedOptionId?html}.deferRender = true;
    </#if>
    <#if parameters.info?default(true) == false>
    options_${escapedOptionId?html}.info = false;
    </#if>
    <#if parameters.lengthChange?default(true) == false>
    options_${escapedOptionId?html}.lengthChange = false;
    </#if>
    <#if parameters.ordering?default(true) == false>
    options_${escapedOptionId?html}.ordering = false;
    </#if>
    <#if parameters.paging?default(true) == false>
    options_${escapedOptionId?html}.paging = false;
    </#if>
    <#if parameters.processing?default(false) == true>
    options_${escapedOptionId?html}.processing = true;
    </#if>
    <#if parameters.scrollX?default(false) == true>
    options_${escapedOptionId?html}.scrollX = true;
    </#if>
    <#if parameters.scrollY?default(false) == true>
    options_${escapedOptionId?html}.scrollY = true;
    </#if>
    <#if parameters.searching?default(true) == false>
    options_${escapedOptionId?html}.searching = false;
    </#if>
    <#if parameters.serverSide?default(false) == true>
    options_${escapedOptionId?html}.serverSide = true;
    </#if>
    <#if parameters.stateSave?default(false) == true>
    options_${escapedOptionId?html}.stateSave = true;
    </#if>
    <#if parameters.data?if_exists != "">
    options_${escapedOptionId?html}.data = ${parameters.data?default('[]')};
    </#if>
    <#if parameters.ajax?if_exists != "">
    options_${escapedOptionId?html}.ajax = ${parameters.ajax?default('{}')};
    </#if>
    <#if parameters.columns?if_exists != "">
    options_${escapedOptionId?html}.columns = ${parameters.columns?default('[]')};
    </#if>
    <#if parameters.columnDefs?if_exists != "">
    options_${escapedOptionId?html}.columnDefs = ${parameters.columnDefs?default('[]')};
    </#if>
    <#if parameters.deferLoading?? >
    options_${escapedOptionId?html}.deferLoading = ${parameters.deferLoading?default(0)};
    </#if>
    <#if parameters.displayStart?if_exists>
    options_${escapedOptionId?html}.displayStart = ${parameters.displayStart?default(0)};
    </#if>
    <#if parameters.dom?if_exists != "">
    options_${escapedOptionId?html}.dom = "${parameters.dom?default('')}";
    </#if>
    <#if parameters.lengthMenu?if_exists != "">
    options_${escapedOptionId?html}.lengthMenu = ${parameters.lengthMenu?default('[10,25,50,100]')};
    </#if>
    <#if parameters.pageLength?? >
    options_${escapedOptionId?html}.pageLength = ${parameters.pageLength?default(10)};
    </#if>
    <#if parameters.pagingType?if_exists != "">
    options_${escapedOptionId?html}.pagingType = "${parameters.pagingType?default('full_numbers')}";
    </#if>
    <#if parameters.order?if_exists != "">
    options_${escapedOptionId?html}.order = ${parameters.order?default('[[0,'asc']]')};
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId?html}.orderCellsTop = ${parameters.orderCellsTop?default('false')};
    </#if>
    <#if parameters.orderClasses?? >
    options_${escapedOptionId?html}.orderClasses = ${parameters.orderClasses?default('true')};
    </#if>
    <#if parameters.orderFixed?if_exists != "">
    options_${escapedOptionId?html}.orderFixed = ${parameters.orderFixed?default('null')};
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId?html}.orderCellsTop = ${parameters.orderCellsTop?default('false')};
    </#if>
    <#if parameters.orderMulti?if_exists != "">
    options_${escapedOptionId?html}.orderMulti = ${parameters.orderMulti?default('true')};
    </#if>
    <#if parameters.renderer?if_exists != "">
    options_${escapedOptionId?html}.renderer = "${parameters.renderer?default('')}";
    </#if>
    <#if parameters.rowId?if_exists != "">
    options_${escapedOptionId?html}.rowId = "${parameters.rowId?default('')}";
    </#if>
    <#if parameters.scrollCollapse?? >
    options_${escapedOptionId?html}.scrollCollapse = ${parameters.scrollCollapse?string('true','false')};
    </#if>
    <#if parameters.search?if_exists != "">
    options_${escapedOptionId?html}.search = ${parameters.search?default('')};
    </#if>
    <#if parameters.searchCols?if_exists != "">
    options_${escapedOptionId?html}.searchCols = ${parameters.searchCols?default('null')};
    </#if>
    <#if parameters.searchDelay?? >
    options_${escapedOptionId?html}.searchDelay = ${parameters.searchDelay?default('null')};
    </#if>
    <#if parameters.stateDuration?? >
    options_${escapedOptionId?html}.stateDuration = ${parameters.stateDuration?default(7200)};
    </#if>
    <#if parameters.stripeClasses?if_exists != "">
    options_${escapedOptionId?html}.stripeClasses = ${parameters.stripeClasses?default('['odd','even']')};
    </#if>
    <#if parameters.responsive?if_exists != "">
    options_${escapedOptionId?html}.responsive = ${parameters.responsive?default('false')};
    </#if>
    <#if parameters.autoFill?if_exists != "">
    options_${escapedOptionId?html}.autoFill = ${parameters.autoFill?default('false')};
    </#if>
    <#if parameters.buttons?if_exists != "">
    options_${escapedOptionId?html}.buttons = ${parameters.buttons?default('false')};
    </#if>
    <#if parameters.colReorder?if_exists != "">
    options_${escapedOptionId?html}.colReorder = ${parameters.colReorder?default('false')};
    </#if>
    <#if parameters.fixedColumns?if_exists != "">
    options_${escapedOptionId?html}.fixedColumns = ${parameters.fixedColumns?default('false')};
    </#if>
    <#if parameters.fixedHeader?if_exists != "">
    options_${escapedOptionId?html}.fixedHeader = ${parameters.fixedHeader?default('false')};
    </#if>
    <#if parameters.keys?if_exists != "">
    options_${escapedOptionId?html}.keys = ${parameters.keys?default('false')};
    </#if>
    <#if parameters.rowReorder?if_exists != "">
    options_${escapedOptionId?html}.rowReorder = ${parameters.rowReorder?default('false')};
    </#if>
    <#if parameters.scroller?if_exists != "">
    options_${escapedOptionId?html}.scroller = ${parameters.scroller?default('false')};
    </#if>
    <#if parameters.select?if_exists != "">
    options_${escapedOptionId?html}.select = ${parameters.select?default('false')};
    </#if>
    <#if parameters.createdRow?exists>
    options_${escapedOptionId?html}.createdRow = ${parameters.createdRow?string?html};
  </#if>
    <#if parameters.drawCallback?exists>
    options_${escapedOptionId?html}.drawCallback = ${parameters.drawCallback?string?html};
  </#if>
    <#if parameters.footerCallback?exists>
    options_${escapedOptionId?html}.footerCallback = "${parameters.footerCallback?string?html}";
  </#if>
    <#if parameters.formatNumber?exists>
    options_${escapedOptionId?html}.formatNumber = ${parameters.formatNumber?string?html};
  </#if>
    <#if parameters.headerCallback?exists>
    options_${escapedOptionId?html}.headerCallback = ${parameters.headerCallback?string?html};
  </#if>
    <#if parameters.infoCallback?exists>
    options_${escapedOptionId?html}.infoCallback = ${parameters.infoCallback?string?html};
  </#if>
    <#if parameters.initComplete?exists>
    options_${escapedOptionId?html}.initComplete = ${parameters.initComplete?string?html};
  </#if>
    <#if parameters.preDrawCallback?exists>
    options_${escapedOptionId?html}.preDrawCallback = ${parameters.preDrawCallback?string?html};
  </#if>
    <#if parameters.rowCallback?exists>
    options_${escapedOptionId?html}.rowCallback = ${parameters.rowCallback?string?html};
  </#if>
    <#if parameters.stateLoadCallback?exists>
    options_${escapedOptionId?html}.stateLoadCallback = ${parameters.stateLoadCallback?string?html};
  </#if>
    <#if parameters.stateLoaded?exists>
    options_${escapedOptionId?html}.stateLoaded = ${parameters.stateLoaded?string?html};
  </#if>
    <#if parameters.stateLoadParams?exists>
    options_${escapedOptionId?html}.stateLoadParams = ${parameters.stateLoadParams?string?html};
  </#if>
    <#if parameters.stateSaveCallback?exists>
    options_${escapedOptionId?html}.stateSaveCallback = ${parameters.stateSaveCallback?string?html};
  </#if>
    <#if parameters.stateSaveParams?exists>
    options_${escapedOptionId?html}.stateSaveParams = ${parameters.stateSaveParams?string?html};
  </#if>
<#if parameters.clearTableTopics?exists>
    options_${escapedOptionId?html}.clearTableTopics = "${parameters.clearTableTopics?string?html}";
  </#if>
<#if parameters.ajaxReloadTopics?exists>
    options_${escapedOptionId?html}.ajaxReloadTopics = "${parameters.ajaxReloadTopics?string?html}";
  </#if>
<#if parameters.redrawTopics?exists>
    options_${escapedOptionId?html}.redrawTopics = "${parameters.redrawTopics?string?html}";
  </#if>
<#if parameters.orderTopics?exists>
    options_${escapedOptionId?html}.orderTopics = "${parameters.orderTopics?string?html}";
  </#if>
<#if parameters.pageTopics?exists>
    options_${escapedOptionId?html}.pageTopics = "${parameters.pageTopics?string?html}";
  </#if>
<#if parameters.pageLengthTopics?exists>
    options_${escapedOptionId?html}.pageLengthTopics = "${parameters.pageLengthTopics?string?html}";
  </#if>
<#if parameters.searchTopics?exists>
    options_${escapedOptionId?html}.searchTopics = "${parameters.searchTopics?string?html}";
  </#if>
<#if parameters.stateClearTopics?exists>
    options_${escapedOptionId?html}.stateClearTopics = "${parameters.stateClearTopics?string?html}";
  </#if>
<#if parameters.stateSaveTopics?exists>
    options_${escapedOptionId?html}.stateSaveTopics = "${parameters.stateSaveTopics?string?html}";
  </#if>
<#if parameters.onColumnSizingTopics?exists>
    options_${escapedOptionId?html}.onColumnSizingTopics = "${parameters.onColumnSizingTopics?string?html}";
  </#if>
<#if parameters.onColumnVisibilityTopics?exists>
    options_${escapedOptionId?html}.onColumnVisibilityTopics = "${parameters.onColumnVisibilityTopics?string?html}";
  </#if>
<#if parameters.onDestroyTopics?exists>
    options_${escapedOptionId?html}.onDestroyTopics = "${parameters.onDestroyTopics?string?html}";
  </#if>
<#if parameters.onDrawTopics?exists>
    options_${escapedOptionId?html}.onDrawTopics = "${parameters.onDrawTopics?string?html}";
  </#if>
<#if parameters.onProcessingErrorTopics?exists>
    options_${escapedOptionId?html}.onProcessingErrorTopics = "${parameters.onProcessingErrorTopics?string?html}";
  </#if>
<#if parameters.onInitCompleteTopics?exists>
    options_${escapedOptionId?html}.onInitCompleteTopics = "${parameters.onInitCompleteTopics?string?html}";
  </#if>
<#if parameters.onPageLengthChangeTopics?exists>
    options_${escapedOptionId?html}.onPageLengthChangeTopics = "${parameters.onPageLengthChangeTopics?string?html}";
  </#if>
<#if parameters.onOrderTopics?exists>
    options_${escapedOptionId?html}.onOrderTopics = "${parameters.onOrderTopics?string?html}";
  </#if>
<#if parameters.onPageChangeTopics?exists>
    options_${escapedOptionId?html}.onPageChangeTopics = "${parameters.onPageChangeTopics?string?html}";
  </#if>
<#if parameters.onInitStartTopics?exists>
    options_${escapedOptionId?html}.onInitStartTopics = "${parameters.onInitStartTopics?string?html}";
  </#if>
<#if parameters.onProcessingTopics?exists>
    options_${escapedOptionId?html}.onProcessingTopics = "${parameters.onProcessingTopics?string?html}";
  </#if>
<#if parameters.onSearchTopics?exists>
    options_${escapedOptionId?html}.onSearchTopics = "${parameters.onSearchTopics?string?html}";
  </#if>
<#if parameters.onStateLoadedTopics?exists>
    options_${escapedOptionId?html}.onStateLoadedTopics = "${parameters.onStateLoadedTopics?string?html}";
  </#if>
<#if parameters.onStateLoadingTopics?exists>
    options_${escapedOptionId?html}.onStateLoadingTopics = "${parameters.onStateLoadingTopics?string?html}";
  </#if>
<#if parameters.onStateSavingTopics?exists>
    options_${escapedOptionId?html}.onStateSavingTopics = "${parameters.onStateSavingTopics?string?html}";
  </#if>

<#if parameters.onAutoFillTopics?exists>
    options_${escapedOptionId?html}.onAutoFillTopics = "${parameters.onAutoFillTopics?string?html}";
  </#if>
<#if parameters.onBeforeAutoFillTopics?exists>
    options_${escapedOptionId?html}.onBeforeAutoFillTopics = "${parameters.onBeforeAutoFillTopics?string?html}";
  </#if>
<#if parameters.onButtonActionTopics?exists>
    options_${escapedOptionId?html}.onButtonActionTopics = "${parameters.onButtonActionTopics?string?html}";
  </#if>
<#if parameters.onColumnReorderTopics?exists>
    options_${escapedOptionId?html}.onColumnReorderTopics = "${parameters.onColumnReorderTopics?string?html}";
  </#if>
<#if parameters.onKeyBlurTopics?exists>
    options_${escapedOptionId?html}.onKeyBlurTopics = "${parameters.onKeyBlurTopics?string?html}";
  </#if>
<#if parameters.onKeyFocusTopics?exists>
    options_${escapedOptionId?html}.onKeyFocusTopics = "${parameters.onKeyFocusTopics?string?html}";
  </#if>
<#if parameters.onOtherKeyTopics?exists>
    options_${escapedOptionId?html}.onOtherKeyTopics = "${parameters.onOtherKeyTopics?string?html}";
  </#if>
<#if parameters.onResponsiveDisplayTopics?exists>
    options_${escapedOptionId?html}.onResponsiveDisplayTopics = "${parameters.onResponsiveDisplayTopics?string?html}";
  </#if>
<#if parameters.onResponsiveResizeTopics?exists>
    options_${escapedOptionId?html}.onResponsiveResizeTopics = "${parameters.onResponsiveResizeTopics?string?html}";
  </#if>
<#if parameters.onRowReorderTopics?exists>
    options_${escapedOptionId?html}.onRowReorderTopics = "${parameters.onRowReorderTopics?string?html}";
  </#if>
<#if parameters.onRowReorderedTopics?exists>
    options_${escapedOptionId?html}.onRowReorderedTopics = "${parameters.onRowReorderedTopics?string?html}";
  </#if>
<#if parameters.onDeselectTopics?exists>
    options_${escapedOptionId?html}.onDeselectTopics = "${parameters.onDeselectTopics?string?html}";
  </#if>
<#if parameters.onSelectTopics?exists>
    options_${escapedOptionId?html}.onSelectTopics = "${parameters.onSelectTopics?string?html}";
  </#if>
<#if parameters.onSelectItemsTopics?exists>
    options_${escapedOptionId?html}.onSelectItemsTopics = "${parameters.onSelectItemsTopics?string?html}";
  </#if>
<#if parameters.onSelectStyleTopics?exists>
    options_${escapedOptionId?html}.onSelectStyleTopics = "${parameters.onSelectStyleTopics?string?html}";
  </#if>
<#if parameters.onUserSelectTopics?exists>
    options_${escapedOptionId?html}.onUserSelectTopics = "${parameters.onUserSelectTopics?string?html}";
  </#if>

    <#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
    jQuery.struts2_jquery_datatables.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
});
</script>  