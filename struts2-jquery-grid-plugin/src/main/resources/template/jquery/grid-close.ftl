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
	options_${escapedOptionId?html}.datatype = "${parameters.dataType?default('json')}";
  <#if parameters.href?exists>
	options_${escapedOptionId?html}.url = "${parameters.href?string}";
  </#if>
  <#if parameters.requestType?if_exists != "">
	options_${escapedOptionId?html}.mtype = "${parameters.requestType?html}";
  </#if>
  <#if parameters.formIds?exists>
	options_${escapedOptionId?html}.formids = "${parameters.formIds?html}";
  </#if>
  <#if parameters.editurl?if_exists != "">
	options_${escapedOptionId?html}.editurl = "${parameters.editurl?string}";
  </#if>
  <#if parameters.cellurl?if_exists != "">
	options_${escapedOptionId?html}.cellurl = "${parameters.cellurl?string}";
  </#if>
  <#if parameters.multiselectWidth?exists>
	options_${escapedOptionId?html}.multiselectWidth = ${parameters.multiselectWidth?html};
  </#if>
  <#if parameters.page?exists>
	options_${escapedOptionId?html}.page = ${parameters.page?html};
  </#if>
  <#if parameters.width?exists>
	options_${escapedOptionId?html}.width = ${parameters.width?html};
  </#if>
  <#if parameters.height?exists>
	options_${escapedOptionId?html}.height = ${parameters.height?html};
  <#else>
	options_${escapedOptionId?html}.height = 'auto';
  </#if>
  <#if parameters.pager?default(false)>
	options_${escapedOptionId?html}.pager = "${escapedOptionId?html}_pager";
  </#if>
  <#if parameters.pagerButtons?default(true)>
	options_${escapedOptionId?html}.pgbuttons = true;
  <#else>
	options_${escapedOptionId?html}.pgbuttons = false;
  </#if>
  <#if parameters.pagerInput?default(true)>
	options_${escapedOptionId?html}.pginput = true;
  <#else>
	options_${escapedOptionId?html}.pginput = false;
  </#if>
  <#if parameters.pagerPosition?if_exists != "">
	options_${escapedOptionId?html}.pagerpos = "${parameters.pagerPosition?string}";
  </#if>
  <#if parameters.rowNum?if_exists != "">
	options_${escapedOptionId?html}.rowNum = ${parameters.rowNum?html};
  </#if>
  <#if parameters.rowList?if_exists != "">
	options_${escapedOptionId?html}.rowList = [${parameters.rowList?html}];
  </#if>
  <#if parameters.rowTotal?exists>
	options_${escapedOptionId?html}.rowTotal = ${parameters.rowTotal?html};
  </#if>
  <#if parameters.sortname?if_exists != "">
	options_${escapedOptionId?html}.sortname = "${parameters.sortname?html}";
  </#if>
  <#if parameters.viewrecords?default(false)>
	options_${escapedOptionId?html}.viewrecords = true;
  </#if>
  <#if parameters.gridview?default(false)>
	options_${escapedOptionId?html}.gridview = true;
  </#if>
  <#if parameters.autowidth?default(false)>
	options_${escapedOptionId?html}.autowidth = true;
  </#if>
  <#if parameters.scroll?if_exists != "">
	options_${escapedOptionId?html}.scroll = ${parameters.scroll?html};
  </#if>
  <#if parameters.sortorder?if_exists != "">
	options_${escapedOptionId?html}.sortorder = "${parameters.sortorder?html}";
  </#if>
  <#if parameters.altRows?default(false)>
	options_${escapedOptionId?html}.altRows = true;
  </#if>
  <#if parameters.altClass?if_exists != "">
	options_${escapedOptionId?html}.altclass = "${parameters.altClass?html}";
  </#if>
  <#if parameters.prmNames?if_exists != "">
	options_${escapedOptionId?html}.prmNames = ${parameters.prmNames?html};
  </#if>
  <#if parameters.direction?if_exists != "">
	options_${escapedOptionId?html}.direction = "${parameters.direction?html}";
  </#if>
  <#if parameters.recordpos?if_exists != "">
	options_${escapedOptionId?html}.recordpos = "${parameters.recordpos?html}";
  </#if>
  <#if parameters.viewsortcols?if_exists != "">
	options_${escapedOptionId?html}.viewsortcols = ${parameters.viewsortcols?html};
  </#if>
  <#if parameters.toppager?default(false)>
	options_${escapedOptionId?html}.toppager = true;
  </#if>
  <#if parameters.groupField?if_exists != "">
	options_${escapedOptionId?html}.grouping = true;
	options_${escapedOptionId?html}.groupingView = { groupField : ${parameters.groupField ?string} };
	  <#if parameters.groupColumnShow?if_exists != "">
		options_${escapedOptionId?html}.groupingView.groupColumnShow = ${parameters.groupColumnShow?html};
	  </#if>
	  <#if parameters.groupText?if_exists != "">
		options_${escapedOptionId?html}.groupingView.groupText = ${parameters.groupText?string};
	  </#if>
  	  <#if parameters.groupCollapse?default(false)>
		options_${escapedOptionId?html}.groupingView.groupCollapse = true;
	  </#if>
	  <#if parameters.groupOrder?if_exists != "">
		options_${escapedOptionId?html}.groupingView.groupOrder = ${parameters.groupOrder?html};
	  </#if>
	  <#if parameters.groupSummary?if_exists != "">
		options_${escapedOptionId?html}.groupingView.groupSummary = ${parameters.groupSummary?html};
	  </#if>
  	  <#if parameters.groupDataSorted?default(false)>
		options_${escapedOptionId?html}.groupingView.groupDataSorted = true;
	  </#if>
  	  <#if parameters.groupShowSummaryOnHide?default(false)>
		options_${escapedOptionId?html}.groupingView.showSummaryOnHide = true;
	  </#if>
	  <#if parameters.groupPlusIcon?if_exists != "">
		options_${escapedOptionId?html}.groupingView.plusicon = "${parameters.groupPlusIcon?html}";
	  </#if>
	  <#if parameters.groupMinusIcon?if_exists != "">
		options_${escapedOptionId?html}.groupingView.minusicon = "${parameters.groupMinusIcon?html}";
	  </#if>
  </#if>
  <#if parameters.navigator?default(false)>
	options_${escapedOptionId?html}.navigator = true;
	  <#if parameters.navigatorEditOptions?if_exists != "">
		options_${escapedOptionId?html}.navigatoreditoptions = ${parameters.navigatorEditOptions?html};
	  </#if>
	  <#if parameters.navigatorAddOptions?if_exists != "">
		options_${escapedOptionId?html}.navigatoraddoptions = ${parameters.navigatorAddOptions?html};
	  </#if>
	  <#if parameters.navigatorDeleteOptions?if_exists != "">
		options_${escapedOptionId?html}.navigatordeleteoptions = ${parameters.navigatorDeleteOptions?html};
	  </#if>
	  <#if parameters.navigatorViewOptions?if_exists != "">
		options_${escapedOptionId?html}.navigatorviewoptions = ${parameters.navigatorViewOptions?html};
	  </#if>
	  <#if parameters.navigatorSearchOptions?if_exists != "">
		options_${escapedOptionId?html}.navigatorsearchoptions = ${parameters.navigatorSearchOptions?html};
	  </#if>
	  <#if parameters.navigatorAdd?default(true)>
		options_${escapedOptionId?html}.navigatoradd = true;
	  <#else>
		options_${escapedOptionId?html}.navigatoradd = false;
	  </#if>
	  <#if parameters.navigatorDelete?default(true)>
		options_${escapedOptionId?html}.navigatordel = true;
	  <#else>
		options_${escapedOptionId?html}.navigatordel = false;
	  </#if>
	  <#if parameters.navigatorEdit?default(true)>
		options_${escapedOptionId?html}.navigatoredit = true;
	  <#else>
		options_${escapedOptionId?html}.navigatoredit = false;
	  </#if>
	  <#if parameters.navigatorRefresh?default(true)>
		options_${escapedOptionId?html}.navigatorrefresh = true;
	  <#else>
		options_${escapedOptionId?html}.navigatorrefresh = false;
	  </#if>
	  <#if parameters.navigatorSearch?default(true)>
		options_${escapedOptionId?html}.navigatorsearch = true;
	  <#else>
		options_${escapedOptionId?html}.navigatorsearch = false;
	  </#if>
	  <#if parameters.navigatorView?default(false)>
		options_${escapedOptionId?html}.navigatorview = true;
	  <#else>
		options_${escapedOptionId?html}.navigatorview = false;
	  </#if>
	  <#if parameters.navigatorExtraButtons?if_exists != "">
		options_${escapedOptionId?html}.navigatorextrabuttons = ${parameters.navigatorExtraButtons?html};
	  </#if>
	  <#if parameters.navigatorInlineEditButtons?default(true)>
		options_${escapedOptionId?html}.navinline = true;
	  <#else>
		options_${escapedOptionId?html}.navinline = false;
	  </#if>
	  <#if parameters.navigatorCloneToTop?default(false)>
		options_${escapedOptionId?html}.cloneToTop = true;
	  </#if>
  </#if>
  <#if parameters.editinline?default(false)>
	options_${escapedOptionId?html}.editinline = true;
  </#if>
  <#if parameters.loadonce?default(false)>
	options_${escapedOptionId?html}.loadonce = true;
  </#if>
  <#if parameters.loadingText?if_exists != "">
	options_${escapedOptionId?html}.loadtext = "${parameters.loadingText?html}";
  </#if>
  <#if parameters.filter?default(false)>
	options_${escapedOptionId?html}.filter = true;
  </#if>
  <#if parameters.filter?default(false) && parameters.filterOptions?if_exists != "">
	options_${escapedOptionId?html}.filteroptions = ${parameters.filterOptions?html};
  </#if>
  <#if parameters.multiselect?default(false)>
	options_${escapedOptionId?html}.multiselect = true;
  </#if>
  <#if parameters.multiboxonly?default(false)>
	options_${escapedOptionId?html}.multiboxonly = true;
  </#if>
  <#if parameters.caption?if_exists != "">
	options_${escapedOptionId?html}.caption = "${parameters.caption?html}";
  </#if>
  <#if parameters.sortableRows?default(false)>
	options_${escapedOptionId?html}.sortableRows = true;
  </#if>
  <#if parameters.shrinkToFit?exists>
	options_${escapedOptionId?html}.shrinkToFit = ${parameters.shrinkToFit?string};
  </#if>
  <#if parameters.autoencode?default(true)>
	options_${escapedOptionId?html}.autoencode = true;
  </#if>
  <#if parameters.cellEdit?default(false)>
	options_${escapedOptionId?html}.cellEdit = true;
  </#if>
  <#if parameters.footerrow?default(false)>
	options_${escapedOptionId?html}.footerrow = true;
  </#if>
  <#if parameters.hiddengrid?default(false)>
	options_${escapedOptionId?html}.hiddengrid = true;
  </#if>
  <#if parameters.hidegrid?exists>
	options_${escapedOptionId?html}.hidegrid = ${parameters.hidegrid?string};
  </#if>
  <#if parameters.hoverrows?exists>
	options_${escapedOptionId?html}.hoverrows = ${parameters.hoverrows?string};
  </#if>
  <#if parameters.rownumbers?default(false)>
	options_${escapedOptionId?html}.rownumbers = true;
  </#if>
  <#if parameters.scrollrows?default(false)>
	options_${escapedOptionId?html}.scrollrows = true;
  </#if>
  <#if parameters.userDataOnFooter?default(false)>
	options_${escapedOptionId?html}.userDataOnFooter = true;
  </#if>
  <#if parameters.onSelectRowTopics?if_exists != "">
	options_${escapedOptionId?html}.onselectrowtopics = "${parameters.onSelectRowTopics?html}";
  </#if>
  <#if parameters.onSelectAllTopics?if_exists != "">
	options_${escapedOptionId?html}.onselectalltopics = "${parameters.onSelectAllTopics?html}";
  </#if>
  <#if parameters.onPagingTopics?if_exists != "">
	options_${escapedOptionId?html}.onpagingtopics = "${parameters.onPagingTopics?html}";
  </#if>
  <#if parameters.onSortColTopics?if_exists != "">
	options_${escapedOptionId?html}.onsortcoltopics = "${parameters.onSortColTopics?html}";
  </#if>
  <#if parameters.onCellSelectTopics?if_exists != "">
	options_${escapedOptionId?html}.oncellselecttopics = "${parameters.onCellSelectTopics?html}";
  </#if>
  <#if parameters.onGridCompleteTopics?if_exists != "">
	options_${escapedOptionId?html}.ongridcompletetopics = "${parameters.onGridCompleteTopics?html}";
  </#if>
  <#if parameters.onEditInlineAfterSaveTopics?if_exists != "">
	options_${escapedOptionId?html}.oneisave = "${parameters.onEditInlineAfterSaveTopics?html}";
  </#if>
  <#if parameters.onEditInlineBeforeTopics?if_exists != "">
	options_${escapedOptionId?html}.oneibefore = "${parameters.onEditInlineBeforeTopics?html}";
  </#if>
  <#if parameters.onEditInlineSuccessTopics?if_exists != "">
	options_${escapedOptionId?html}.oneisuccess = "${parameters.onEditInlineSuccessTopics?html}";
  </#if>
  <#if parameters.onEditInlineErrorTopics?if_exists != "">
	options_${escapedOptionId?html}.oneierror = "${parameters.onEditInlineErrorTopics?html}";
  </#if>
  <#if parameters.onCellEditSuccessTopics?if_exists != "">
	options_${escapedOptionId?html}.oncesuccess = "${parameters.onCellEditSuccessTopics?html}";
  </#if>
  <#if parameters.onCellEditErrorTopics?if_exists != "">
	options_${escapedOptionId?html}.onceerror = "${parameters.onCellEditErrorTopics?html}";
  </#if>
  <#if parameters.onSubGridRowExpanded?if_exists != "">
	options_${escapedOptionId?html}.onsgrowexpanded = "${parameters.onSubGridRowExpanded?html}";
  </#if>
  <#if parameters.onClickGroupTopics?if_exists != "">
	options_${escapedOptionId?html}.onclickgroup = "${parameters.onClickGroupTopics?html}";
  </#if>
  <#if parameters.onDblClickRowTopics?if_exists != "">
	options_${escapedOptionId?html}.ondblclickrow = "${parameters.onDblClickRowTopics?html}";
  </#if>
  <#if parameters.onRightClickRowTopics?if_exists != "">
	options_${escapedOptionId?html}.onrightclickrow = "${parameters.onRightClickRowTopics?html}";
  </#if>
  <#if parameters.reloadTopics?if_exists != "">
	options_${escapedOptionId?html}.reloadtopics = "${parameters.reloadTopics?html}";
  </#if>
  <#if parameters.connectWith?if_exists != "">
	options_${escapedOptionId?html}.connectWith = "${parameters.connectWith?html}";
  </#if>


	options_${escapedOptionId?html}.colNames = options_${escapedOptionId?html}_colnames;
	options_${escapedOptionId?html}.colModel = options_${escapedOptionId?html}_colmodels;
	options_${escapedOptionId?html}.jsonReader = {};
  <#if parameters.gridModel?if_exists != "">
	options_${escapedOptionId?html}.jsonReader.root = "${parameters.gridModel?html}";
  <#else>
	options_${escapedOptionId?html}.jsonReader.root = "gridModel";
  </#if>
  <#if parameters.loadonce?default(false)>
  <#else>
	options_${escapedOptionId?html}.jsonReader.page = "page";
	options_${escapedOptionId?html}.jsonReader.total = "total";
	options_${escapedOptionId?html}.jsonReader.records = "records";
  </#if>
	options_${escapedOptionId?html}.jsonReader.repeatitems = false;

  <#include "/${parameters.templateDir}/jquery/draggable.ftl" />
  <#include "/${parameters.templateDir}/jquery/droppable.ftl" />
  <#include "/${parameters.templateDir}/jquery/resizable.ftl" />
  <#include "/${parameters.templateDir}/jquery/selectable.ftl" />
  <#include "/${parameters.templateDir}/jquery/sortable.ftl" />
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#if !parameters.subGrid?default(false)>
	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_grid.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
 });
</script>
<#else>
	<#if parameters.subGridUrl?if_exists != "">
	options_${escapedOptionId?html}.url = "${parameters.subGridUrl?string}";
	</#if>
	<#assign escapedParentOptionId="${parameters.parentGrid?string?replace('.', '_')}">
	options_${escapedParentOptionId?html}.subgridoptions = options_${escapedOptionId?html};
</#if>