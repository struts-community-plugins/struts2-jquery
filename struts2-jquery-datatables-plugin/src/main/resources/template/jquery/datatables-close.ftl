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
    options_${escapedOptionId}.data = <#outputformat "JavaScript">${parameters.data?default('[]')}</#outputformat>;
    </#if>
    <#if parameters.ajax?if_exists != "">
    options_${escapedOptionId}.ajax = <#outputformat "JavaScript">${parameters.ajax?default('{}')}</#outputformat>;
    </#if>
    <#if parameters.columns?if_exists != "">
    options_${escapedOptionId}.columns = <#outputformat "JavaScript">${parameters.columns?default('[]')}</#outputformat>;
    </#if>
    <#if parameters.columnDefs?if_exists != "">
    options_${escapedOptionId}.columnDefs = <#outputformat "JavaScript">${parameters.columnDefs?default('[]')}</#outputformat>;
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
    options_${escapedOptionId}.lengthMenu = <#outputformat "JavaScript">${parameters.lengthMenu?default('[10,25,50,100]')}</#outputformat>;
    </#if>
    <#if parameters.pageLength?? >
    options_${escapedOptionId}.pageLength = <#outputformat "JavaScript">${parameters.pageLength?default(10)}</#outputformat>;
    </#if>
    <#if parameters.pagingType?if_exists != "">
    options_${escapedOptionId}.pagingType = "<#outputformat "JavaScript">${parameters.pagingType?default('full_numbers')}</#outputformat>";
    </#if>
    <#if parameters.order?if_exists != "">
    options_${escapedOptionId}.order = <#outputformat "JavaScript">${parameters.order?default('[[0,'asc']]')}</#outputformat>;
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId}.orderCellsTop = <#outputformat "JavaScript">${parameters.orderCellsTop?default('false')}</#outputformat>;
    </#if>
    <#if parameters.orderClasses?? >
    options_${escapedOptionId}.orderClasses = <#outputformat "JavaScript">${parameters.orderClasses?default('true')}</#outputformat>;
    </#if>
    <#if parameters.orderFixed?if_exists != "">
    options_${escapedOptionId}.orderFixed = <#outputformat "JavaScript">${parameters.orderFixed?default('null')}</#outputformat>;
    </#if>
    <#if parameters.orderCellsTop?? >
    options_${escapedOptionId}.orderCellsTop = <#outputformat "JavaScript">${parameters.orderCellsTop?default('false')}</#outputformat>;
    </#if>
    <#if parameters.orderMulti?if_exists != "">
    options_${escapedOptionId}.orderMulti = <#outputformat "JavaScript">${parameters.orderMulti?default('true')}</#outputformat>;
    </#if>
    <#if parameters.renderer?if_exists != "">
    options_${escapedOptionId}.renderer = "<#outputformat "JavaScript">${parameters.renderer?default('')}</#outputformat>";
    </#if>
    <#if parameters.rowId?if_exists != "">
    options_${escapedOptionId}.rowId = "<#outputformat "JavaScript">${parameters.rowId?default('')}</#outputformat>";
    </#if>
    <#if parameters.scrollCollapse?? >
    options_${escapedOptionId}.scrollCollapse = <#outputformat "JavaScript">${parameters.scrollCollapse?string('true','false')}</#outputformat>;
    </#if>
    <#if parameters.search?if_exists != "">
    options_${escapedOptionId}.search = <#outputformat "JavaScript">${parameters.search?default('')}</#outputformat>;
    </#if>
    <#if parameters.searchCols?if_exists != "">
    options_${escapedOptionId}.searchCols = <#outputformat "JavaScript">${parameters.searchCols?default('null')}</#outputformat>;
    </#if>
    <#if parameters.searchDelay?? >
    options_${escapedOptionId}.searchDelay = <#outputformat "JavaScript">${parameters.searchDelay?default('null')}</#outputformat>;
    </#if>
    <#if parameters.stateDuration?? >
    options_${escapedOptionId}.stateDuration = ${parameters.stateDuration?default(7200)};
    </#if>
    <#if parameters.stripeClasses?if_exists != "">
    options_${escapedOptionId}.stripeClasses = <#outputformat "JavaScript">${parameters.stripeClasses?default('['odd','even']')}</#outputformat>;
    </#if>
    <#if parameters.responsive?if_exists != "">
    options_${escapedOptionId}.responsive = <#outputformat "JavaScript">${parameters.responsive?default('false')}</#outputformat>;
    </#if>
    <#if parameters.autoFill?if_exists != "">
    options_${escapedOptionId}.autoFill = <#outputformat "JavaScript">${parameters.autoFill?default('false')}</#outputformat>;
    </#if>
    <#if parameters.buttons?if_exists != "">
    options_${escapedOptionId}.buttons = <#outputformat "JavaScript">${parameters.buttons?default('false')}</#outputformat>;
    </#if>
    <#if parameters.colReorder?if_exists != "">
    options_${escapedOptionId}.colReorder = <#outputformat "JavaScript">${parameters.colReorder?default('false')}</#outputformat>;
    </#if>
    <#if parameters.fixedColumns?if_exists != "">
    options_${escapedOptionId}.fixedColumns = <#outputformat "JavaScript">${parameters.fixedColumns?default('false')}</#outputformat>;
    </#if>
    <#if parameters.fixedHeader?if_exists != "">
    options_${escapedOptionId}.fixedHeader = <#outputformat "JavaScript">${parameters.fixedHeader?default('false')}</#outputformat>;
    </#if>
    <#if parameters.keys?if_exists != "">
    options_${escapedOptionId}.keys = ${parameters.keys?default('false')};
    </#if>
    <#if parameters.rowGroup?if_exists != "">
    options_${escapedOptionId}.rowGroup = <#outputformat "JavaScript">${parameters.rowGroup?default('false')}</#outputformat>;
    </#if>
    <#if parameters.rowReorder?if_exists != "">
    options_${escapedOptionId}.rowReorder = <#outputformat "JavaScript">${parameters.rowReorder?default('false')}</#outputformat>;
    </#if>
    <#if parameters.scroller?if_exists != "">
    options_${escapedOptionId}.scroller = <#outputformat "JavaScript">${parameters.scroller?default('false')}</#outputformat>;
    </#if>
    <#if parameters.select?if_exists != "">
    options_${escapedOptionId}.select = <#outputformat "JavaScript">${parameters.select?default('false')}</#outputformat>;
    </#if>
    <#if parameters.createdRow?exists>
    options_${escapedOptionId}.createdRow = <#outputformat "JavaScript">${parameters.createdRow?string}</#outputformat>;
  </#if>
    <#if parameters.drawCallback?exists>
    options_${escapedOptionId}.drawCallback = <#outputformat "JavaScript">${parameters.drawCallback?string}</#outputformat>;
  </#if>
    <#if parameters.footerCallback?exists>
    options_${escapedOptionId}.footerCallback = "<#outputformat "JavaScript">${parameters.footerCallback?string}</#outputformat>";
  </#if>
    <#if parameters.formatNumber?exists>
    options_${escapedOptionId}.formatNumber = <#outputformat "JavaScript">${parameters.formatNumber?string}</#outputformat>;
  </#if>
    <#if parameters.headerCallback?exists>
    options_${escapedOptionId}.headerCallback = <#outputformat "JavaScript">${parameters.headerCallback?string}</#outputformat>;
  </#if>
    <#if parameters.infoCallback?exists>
    options_${escapedOptionId}.infoCallback = <#outputformat "JavaScript">${parameters.infoCallback?string}</#outputformat>;
  </#if>
    <#if parameters.initComplete?exists>
    options_${escapedOptionId}.initComplete = <#outputformat "JavaScript">${parameters.initComplete?string}</#outputformat>;
  </#if>
    <#if parameters.preDrawCallback?exists>
    options_${escapedOptionId}.preDrawCallback = <#outputformat "JavaScript">${parameters.preDrawCallback?string}</#outputformat>;
  </#if>
    <#if parameters.rowCallback?exists>
    options_${escapedOptionId}.rowCallback = <#outputformat "JavaScript">${parameters.rowCallback?string}</#outputformat>;
  </#if>
    <#if parameters.stateLoadCallback?exists>
    options_${escapedOptionId}.stateLoadCallback = <#outputformat "JavaScript">${parameters.stateLoadCallback?string}</#outputformat>;
  </#if>
    <#if parameters.stateLoaded?exists>
    options_${escapedOptionId}.stateLoaded = <#outputformat "JavaScript">${parameters.stateLoaded?string}</#outputformat>;
  </#if>
    <#if parameters.stateLoadParams?exists>
    options_${escapedOptionId}.stateLoadParams = <#outputformat "JavaScript">${parameters.stateLoadParams?string}</#outputformat>;
  </#if>
    <#if parameters.stateSaveCallback?exists>
    options_${escapedOptionId}.stateSaveCallback = <#outputformat "JavaScript">${parameters.stateSaveCallback?string}</#outputformat>;
  </#if>
    <#if parameters.stateSaveParams?exists>
    options_${escapedOptionId}.stateSaveParams = <#outputformat "JavaScript">${parameters.stateSaveParams?string}</#outputformat>;
  </#if>
<#if parameters.clearTableTopics?exists>
    options_${escapedOptionId}.clearTableTopics = "<#outputformat "JavaScript">${parameters.clearTableTopics?string}</#outputformat>";
  </#if>
<#if parameters.ajaxReloadTopics?exists>
    options_${escapedOptionId}.ajaxReloadTopics = "<#outputformat "JavaScript">${parameters.ajaxReloadTopics?string}</#outputformat>";
  </#if>
<#if parameters.redrawTopics?exists>
    options_${escapedOptionId}.redrawTopics = "<#outputformat "JavaScript">${parameters.redrawTopics?string}</#outputformat>";
  </#if>
<#if parameters.orderTopics?exists>
    options_${escapedOptionId}.orderTopics = "<#outputformat "JavaScript">${parameters.orderTopics?string}</#outputformat>";
  </#if>
<#if parameters.pageTopics?exists>
    options_${escapedOptionId}.pageTopics = "<#outputformat "JavaScript">${parameters.pageTopics?string}</#outputformat>";
  </#if>
<#if parameters.pageLengthTopics?exists>
    options_${escapedOptionId}.pageLengthTopics = "<#outputformat "JavaScript">${parameters.pageLengthTopics?string}</#outputformat>";
  </#if>
<#if parameters.searchTopics?exists>
    options_${escapedOptionId}.searchTopics = "<#outputformat "JavaScript">${parameters.searchTopics?string}</#outputformat>";
  </#if>
<#if parameters.stateClearTopics?exists>
    options_${escapedOptionId}.stateClearTopics = "<#outputformat "JavaScript">${parameters.stateClearTopics?string}</#outputformat>";
  </#if>
<#if parameters.stateSaveTopics?exists>
    options_${escapedOptionId}.stateSaveTopics = "<#outputformat "JavaScript">${parameters.stateSaveTopics?string}</#outputformat>";
  </#if>
<#if parameters.onColumnSizingTopics?exists>
    options_${escapedOptionId}.onColumnSizingTopics = "<#outputformat "JavaScript">${parameters.onColumnSizingTopics?string}</#outputformat>";
  </#if>
<#if parameters.onColumnVisibilityTopics?exists>
    options_${escapedOptionId}.onColumnVisibilityTopics = "<#outputformat "JavaScript">${parameters.onColumnVisibilityTopics?string}</#outputformat>";
  </#if>
<#if parameters.onDestroyTopics?exists>
    options_${escapedOptionId}.onDestroyTopics = "<#outputformat "JavaScript">${parameters.onDestroyTopics?string}</#outputformat>";
  </#if>
<#if parameters.onDrawTopics?exists>
    options_${escapedOptionId}.onDrawTopics = "<#outputformat "JavaScript">${parameters.onDrawTopics?string}</#outputformat>";
  </#if>
<#if parameters.onProcessingErrorTopics?exists>
    options_${escapedOptionId}.onProcessingErrorTopics = "<#outputformat "JavaScript">${parameters.onProcessingErrorTopics?string}</#outputformat>";
  </#if>
<#if parameters.onInitCompleteTopics?exists>
    options_${escapedOptionId}.onInitCompleteTopics = "<#outputformat "JavaScript">${parameters.onInitCompleteTopics?string}</#outputformat>";
  </#if>
<#if parameters.onPageLengthChangeTopics?exists>
    options_${escapedOptionId}.onPageLengthChangeTopics = "<#outputformat "JavaScript">${parameters.onPageLengthChangeTopics?string}</#outputformat>";
  </#if>
<#if parameters.onOrderTopics?exists>
    options_${escapedOptionId}.onOrderTopics = "<#outputformat "JavaScript">${parameters.onOrderTopics?string}</#outputformat>";
  </#if>
<#if parameters.onPageChangeTopics?exists>
    options_${escapedOptionId}.onPageChangeTopics = "<#outputformat "JavaScript">${parameters.onPageChangeTopics?string}</#outputformat>";
  </#if>
<#if parameters.onInitStartTopics?exists>
    options_${escapedOptionId}.onInitStartTopics = "<#outputformat "JavaScript">${parameters.onInitStartTopics?string}</#outputformat>";
  </#if>
<#if parameters.onProcessingTopics?exists>
    options_${escapedOptionId}.onProcessingTopics = "<#outputformat "JavaScript">${parameters.onProcessingTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSearchTopics?exists>
    options_${escapedOptionId}.onSearchTopics = "<#outputformat "JavaScript">${parameters.onSearchTopics?string}</#outputformat>";
  </#if>
<#if parameters.onStateLoadedTopics?exists>
    options_${escapedOptionId}.onStateLoadedTopics = "<#outputformat "JavaScript">${parameters.onStateLoadedTopics?string}</#outputformat>";
  </#if>
<#if parameters.onStateLoadingTopics?exists>
    options_${escapedOptionId}.onStateLoadingTopics = "<#outputformat "JavaScript">${parameters.onStateLoadingTopics?string}</#outputformat>";
  </#if>
<#if parameters.onStateSavingTopics?exists>
    options_${escapedOptionId}.onStateSavingTopics = "<#outputformat "JavaScript">${parameters.onStateSavingTopics?string}</#outputformat>";
  </#if>

<#if parameters.onAutoFillTopics?exists>
    options_${escapedOptionId}.onAutoFillTopics = "<#outputformat "JavaScript">${parameters.onAutoFillTopics?string}</#outputformat>";
  </#if>
<#if parameters.onBeforeAutoFillTopics?exists>
    options_${escapedOptionId}.onBeforeAutoFillTopics = "<#outputformat "JavaScript">${parameters.onBeforeAutoFillTopics?string}</#outputformat>";
  </#if>
<#if parameters.onButtonActionTopics?exists>
    options_${escapedOptionId}.onButtonActionTopics = "<#outputformat "JavaScript">${parameters.onButtonActionTopics?string}</#outputformat>";
  </#if>
<#if parameters.onColumnReorderTopics?exists>
    options_${escapedOptionId}.onColumnReorderTopics = "<#outputformat "JavaScript">${parameters.onColumnReorderTopics?string}</#outputformat>";
  </#if>
<#if parameters.onKeyBlurTopics?exists>
    options_${escapedOptionId}.onKeyBlurTopics = "<#outputformat "JavaScript">${parameters.onKeyBlurTopics?string}</#outputformat>";
  </#if>
<#if parameters.onKeyFocusTopics?exists>
    options_${escapedOptionId}.onKeyFocusTopics = "<#outputformat "JavaScript">${parameters.onKeyFocusTopics?string}</#outputformat>";
  </#if>
<#if parameters.onOtherKeyTopics?exists>
    options_${escapedOptionId}.onOtherKeyTopics = "<#outputformat "JavaScript">${parameters.onOtherKeyTopics?string}</#outputformat>";
  </#if>
<#if parameters.onResponsiveDisplayTopics?exists>
    options_${escapedOptionId}.onResponsiveDisplayTopics = "<#outputformat "JavaScript">${parameters.onResponsiveDisplayTopics?string}</#outputformat>";
  </#if>
<#if parameters.onResponsiveResizeTopics?exists>
    options_${escapedOptionId}.onResponsiveResizeTopics = "<#outputformat "JavaScript">${parameters.onResponsiveResizeTopics?string}</#outputformat>";
  </#if>
<#if parameters.onRowGroupPointChangedTopics?exists>
    options_${escapedOptionId}.onRowGroupPointChangedTopics = "<#outputformat "JavaScript">${parameters.onRowGroupPointChangedTopics?string}</#outputformat>";
  </#if>
<#if parameters.onRowReorderTopics?exists>
    options_${escapedOptionId}.onRowReorderTopics = "<#outputformat "JavaScript">${parameters.onRowReorderTopics?string}</#outputformat>";
  </#if>
<#if parameters.onRowReorderedTopics?exists>
    options_${escapedOptionId}.onRowReorderedTopics = "<#outputformat "JavaScript">${parameters.onRowReorderedTopics?string}</#outputformat>";
  </#if>
<#if parameters.onDeselectTopics?exists>
    options_${escapedOptionId}.onDeselectTopics = "<#outputformat "JavaScript">${parameters.onDeselectTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSelectTopics?exists>
    options_${escapedOptionId}.onSelectTopics = "<#outputformat "JavaScript">${parameters.onSelectTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSelectItemsTopics?exists>
    options_${escapedOptionId}.onSelectItemsTopics = "<#outputformat "JavaScript">${parameters.onSelectItemsTopics?string}</#outputformat>";
  </#if>
<#if parameters.onSelectStyleTopics?exists>
    options_${escapedOptionId}.onSelectStyleTopics = "<#outputformat "JavaScript">${parameters.onSelectStyleTopics?string}</#outputformat>";
  </#if>
<#if parameters.onUserSelectTopics?exists>
    options_${escapedOptionId}.onUserSelectTopics = "<#outputformat "JavaScript">${parameters.onUserSelectTopics?string}</#outputformat>";
  </#if>

    <#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
    jQuery.struts2_jquery_datatables.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
});
</script>  