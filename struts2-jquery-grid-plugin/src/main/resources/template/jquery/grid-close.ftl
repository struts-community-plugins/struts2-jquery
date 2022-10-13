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
	options_${escapedOptionId}.datatype = "${parameters.dataType!'json'}";
  <#if parameters.href??>
	options_${escapedOptionId}.url = "<#outputformat "JavaScript">${parameters.href}</#outputformat>";
  </#if>
  <#if parameters.requestType! != "">
	options_${escapedOptionId}.mtype = "${parameters.requestType}";
  </#if>
  <#if parameters.formIds??>
	options_${escapedOptionId}.formids = "${parameters.formIds}";
  </#if>
  <#if parameters.editurl! != "">
	options_${escapedOptionId}.editurl = "${parameters.editurl?string}";
  </#if>
  <#if parameters.cellurl! != "">
	options_${escapedOptionId}.cellurl = "${parameters.cellurl?string}";
  </#if>
  <#if parameters.multiselectWidth??>
	options_${escapedOptionId}.multiselectWidth = ${parameters.multiselectWidth};
  </#if>
  <#if parameters.page??>
	options_${escapedOptionId}.page = ${parameters.page};
  </#if>
  <#if parameters.width??>
	options_${escapedOptionId}.width = ${parameters.width};
  </#if>
  <#if parameters.height??>
	options_${escapedOptionId}.height = ${parameters.height};
  <#else>
	options_${escapedOptionId}.height = 'auto';
  </#if>
  <#if parameters.pager!false>
	options_${escapedOptionId}.pager = "${escapedOptionId}_pager";
  </#if>
  <#if parameters.pagerButtons!true>
	options_${escapedOptionId}.pgbuttons = true;
  <#else>
	options_${escapedOptionId}.pgbuttons = false;
  </#if>
  <#if parameters.pagerInput!true>
	options_${escapedOptionId}.pginput = true;
  <#else>
	options_${escapedOptionId}.pginput = false;
  </#if>
  <#if parameters.pagerPosition! != "">
	options_${escapedOptionId}.pagerpos = "${parameters.pagerPosition?string}";
  </#if>
  <#if parameters.rowNum! != "">
	options_${escapedOptionId}.rowNum = ${parameters.rowNum};
  </#if>
  <#if parameters.rowList! != "">
	options_${escapedOptionId}.rowList = [${parameters.rowList}];
  </#if>
  <#if parameters.rowTotal??>
	options_${escapedOptionId}.rowTotal = ${parameters.rowTotal};
  </#if>
  <#if parameters.sortname! != "">
	options_${escapedOptionId}.sortname = "${parameters.sortname}";
  </#if>
  <#if parameters.viewrecords!false>
	options_${escapedOptionId}.viewrecords = true;
  </#if>
  <#if parameters.gridview!false>
	options_${escapedOptionId}.gridview = true;
  </#if>
  <#if parameters.autowidth!false>
	options_${escapedOptionId}.autowidth = true;
  </#if>
  <#if parameters.scroll! != "">
	options_${escapedOptionId}.scroll = ${parameters.scroll};
  </#if>
  <#if parameters.sortorder! != "">
	options_${escapedOptionId}.sortorder = "${parameters.sortorder}";
  </#if>
  <#if parameters.altRows!false>
	options_${escapedOptionId}.altRows = true;
  </#if>
  <#if parameters.altClass! != "">
	options_${escapedOptionId}.altclass = "${parameters.altClass}";
  </#if>
  <#if parameters.prmNames! != "">
	options_${escapedOptionId}.prmNames = ${parameters.prmNames};
  </#if>
  <#if parameters.direction! != "">
	options_${escapedOptionId}.direction = "${parameters.direction}";
  </#if>
  <#if parameters.recordpos! != "">
	options_${escapedOptionId}.recordpos = "${parameters.recordpos}";
  </#if>
  <#if parameters.guiStyle! != "">
	options_${escapedOptionId}.guiStyle = "${parameters.guiStyle}";
  </#if>
  <#if parameters.iconSet! != "">
	options_${escapedOptionId}.iconSet = "${parameters.iconSet}";
  </#if>
  <#if parameters.viewsortcols! != "">
	options_${escapedOptionId}.viewsortcols = <#outputformat "JavaScript">${parameters.viewsortcols}</#outputformat>;
  </#if>
  <#if parameters.toppager!false>
	options_${escapedOptionId}.toppager = true;
    options_${escapedOptionId}.toppagerElem = "${escapedOptionId}_toppager";
  </#if>
  <#if parameters.groupField! != "">
	options_${escapedOptionId}.grouping = true;
	options_${escapedOptionId}.groupingView = { groupField : <#outputformat "JavaScript">${parameters.groupField ?string}</#outputformat> };
	  <#if parameters.groupColumnShow! != "">
		options_${escapedOptionId}.groupingView.groupColumnShow = <#outputformat "JavaScript">${parameters.groupColumnShow}</#outputformat>;
	  </#if>
	  <#if parameters.groupText! != "">
		options_${escapedOptionId}.groupingView.groupText = <#outputformat "JavaScript">${parameters.groupText?string}</#outputformat>;
	  </#if>
  	  <#if parameters.groupCollapse!false>
		options_${escapedOptionId}.groupingView.groupCollapse = true;
	  </#if>
	  <#if parameters.groupOrder! != "">
		options_${escapedOptionId}.groupingView.groupOrder = <#outputformat "JavaScript">${parameters.groupOrder}</#outputformat>;
	  </#if>
	  <#if parameters.groupSummary! != "">
		options_${escapedOptionId}.groupingView.groupSummary = <#outputformat "JavaScript">${parameters.groupSummary}</#outputformat>;
	  </#if>
  	  <#if parameters.groupDataSorted!false>
		options_${escapedOptionId}.groupingView.groupDataSorted = true;
	  </#if>
  	  <#if parameters.groupShowSummaryOnHide!false>
		options_${escapedOptionId}.groupingView.showSummaryOnHide = true;
	  </#if>
	  <#if parameters.groupPlusIcon! != "">
		options_${escapedOptionId}.groupingView.plusicon = "${parameters.groupPlusIcon}";
	  </#if>
	  <#if parameters.groupMinusIcon! != "">
		options_${escapedOptionId}.groupingView.minusicon = "${parameters.groupMinusIcon}";
	  </#if>
  </#if>
  <#if parameters.navigator!false>
	options_${escapedOptionId}.navigator = true;
	  <#if parameters.navigatorEditOptions! != "">
		options_${escapedOptionId}.navigatoreditoptions = <#outputformat "JavaScript">${parameters.navigatorEditOptions}</#outputformat>;
	  </#if>
	  <#if parameters.navigatorAddOptions! != "">
		options_${escapedOptionId}.navigatoraddoptions = <#outputformat "JavaScript">${parameters.navigatorAddOptions}</#outputformat>;
	  </#if>
	  <#if parameters.navigatorDeleteOptions! != "">
		options_${escapedOptionId}.navigatordeleteoptions = <#outputformat "JavaScript">${parameters.navigatorDeleteOptions}</#outputformat>;
	  </#if>
	  <#if parameters.navigatorViewOptions! != "">
		options_${escapedOptionId}.navigatorviewoptions = <#outputformat "JavaScript">${parameters.navigatorViewOptions}</#outputformat>;
	  </#if>
	  <#if parameters.navigatorSearchOptions! != "">
		options_${escapedOptionId}.navigatorsearchoptions = <#outputformat "JavaScript">${parameters.navigatorSearchOptions}</#outputformat>;
	  </#if>
	  <#if parameters.navigatorAdd!true>
		options_${escapedOptionId}.navigatoradd = true;
	  <#else>
		options_${escapedOptionId}.navigatoradd = false;
	  </#if>
	  <#if parameters.navigatorDelete!true>
		options_${escapedOptionId}.navigatordel = true;
	  <#else>
		options_${escapedOptionId}.navigatordel = false;
	  </#if>
	  <#if parameters.navigatorEdit!true>
		options_${escapedOptionId}.navigatoredit = true;
	  <#else>
		options_${escapedOptionId}.navigatoredit = false;
	  </#if>
	  <#if parameters.navigatorRefresh!true>
		options_${escapedOptionId}.navigatorrefresh = true;
	  <#else>
		options_${escapedOptionId}.navigatorrefresh = false;
	  </#if>
	  <#if parameters.navigatorSearch!true>
		options_${escapedOptionId}.navigatorsearch = true;
	  <#else>
		options_${escapedOptionId}.navigatorsearch = false;
	  </#if>
	  <#if parameters.navigatorView!false>
		options_${escapedOptionId}.navigatorview = true;
	  <#else>
		options_${escapedOptionId}.navigatorview = false;
	  </#if>
	  <#if parameters.navigatorExtraButtons! != "">
		options_${escapedOptionId}.navigatorextrabuttons = <#outputformat "JavaScript">${parameters.navigatorExtraButtons}</#outputformat>;
	  </#if>
	  <#if parameters.navigatorInlineEditButtons!true>
		options_${escapedOptionId}.navinline = true;
	  <#else>
		options_${escapedOptionId}.navinline = false;
	  </#if>
	  <#if parameters.navigatorCloneToTop!false>
		options_${escapedOptionId}.cloneToTop = true;
	  </#if>
  </#if>
  <#if parameters.editinline!false>
	options_${escapedOptionId}.editinline = true;
  </#if>
  <#if parameters.loadonce!false>
	options_${escapedOptionId}.loadonce = true;
  </#if>
  <#if parameters.loadingText! != "">
	options_${escapedOptionId}.loadtext = "${parameters.loadingText}";
  </#if>
  <#if parameters.filter!false>
	options_${escapedOptionId}.filter = true;
  </#if>
  <#if parameters.filter!false && parameters.filterOptions! != "">
	options_${escapedOptionId}.filteroptions = ${parameters.filterOptions};
  </#if>
  <#if parameters.multiselect!false>
	options_${escapedOptionId}.multiselect = true;
  </#if>
  <#if parameters.multiboxonly!false>
	options_${escapedOptionId}.multiboxonly = true;
  </#if>
  <#if parameters.caption! != "">
	options_${escapedOptionId}.caption = "${parameters.caption}";
  </#if>
  <#if parameters.sortableRows!false>
	options_${escapedOptionId}.sortableRows = true;
  </#if>
  <#if parameters.shrinkToFit??>
	options_${escapedOptionId}.shrinkToFit = ${parameters.shrinkToFit?string};
  </#if>
  <#if parameters.autoencode!true>
	options_${escapedOptionId}.autoencode = true;
  </#if>
  <#if parameters.cellEdit!false>
	options_${escapedOptionId}.cellEdit = true;
  </#if>
  <#if parameters.footerrow!false>
	options_${escapedOptionId}.footerrow = true;
  </#if>
  <#if parameters.hiddengrid!false>
	options_${escapedOptionId}.hiddengrid = true;
  </#if>
  <#if parameters.hidegrid??>
	options_${escapedOptionId}.hidegrid = ${parameters.hidegrid?string};
  </#if>
  <#if parameters.hoverrows??>
	options_${escapedOptionId}.hoverrows = ${parameters.hoverrows?string};
  </#if>
  <#if parameters.rownumbers!false>
	options_${escapedOptionId}.rownumbers = true;
  </#if>
  <#if parameters.scrollrows!false>
	options_${escapedOptionId}.scrollrows = true;
  </#if>
  <#if parameters.userDataOnFooter!false>
	options_${escapedOptionId}.userDataOnFooter = true;
  </#if>
  <#if parameters.onSelectRowTopics! != "">
	options_${escapedOptionId}.onselectrowtopics = "${parameters.onSelectRowTopics}";
  </#if>
  <#if parameters.onSelectAllTopics! != "">
	options_${escapedOptionId}.onselectalltopics = "${parameters.onSelectAllTopics}";
  </#if>
  <#if parameters.onPagingTopics! != "">
	options_${escapedOptionId}.onpagingtopics = "${parameters.onPagingTopics}";
  </#if>
  <#if parameters.onSortColTopics! != "">
	options_${escapedOptionId}.onsortcoltopics = "${parameters.onSortColTopics}";
  </#if>
  <#if parameters.onCellSelectTopics! != "">
	options_${escapedOptionId}.oncellselecttopics = "${parameters.onCellSelectTopics}";
  </#if>
  <#if parameters.onGridCompleteTopics! != "">
	options_${escapedOptionId}.ongridcompletetopics = "${parameters.onGridCompleteTopics}";
  </#if>
  <#if parameters.onEditInlineAfterSaveTopics! != "">
	options_${escapedOptionId}.oneisave = "${parameters.onEditInlineAfterSaveTopics}";
  </#if>
  <#if parameters.onEditInlineBeforeTopics! != "">
	options_${escapedOptionId}.oneibefore = "${parameters.onEditInlineBeforeTopics}";
  </#if>
  <#if parameters.onEditInlineSuccessTopics! != "">
	options_${escapedOptionId}.oneisuccess = "${parameters.onEditInlineSuccessTopics}";
  </#if>
  <#if parameters.onEditInlineErrorTopics! != "">
	options_${escapedOptionId}.oneierror = "${parameters.onEditInlineErrorTopics}";
  </#if>
  <#if parameters.onCellEditSuccessTopics! != "">
	options_${escapedOptionId}.oncesuccess = "${parameters.onCellEditSuccessTopics}";
  </#if>
  <#if parameters.onCellEditErrorTopics! != "">
	options_${escapedOptionId}.onceerror = "${parameters.onCellEditErrorTopics}";
  </#if>
  <#if parameters.onSubGridRowExpanded! != "">
	options_${escapedOptionId}.onsgrowexpanded = "${parameters.onSubGridRowExpanded}";
  </#if>
  <#if parameters.onClickGroupTopics! != "">
	options_${escapedOptionId}.onclickgroup = "${parameters.onClickGroupTopics}";
  </#if>
  <#if parameters.onDblClickRowTopics! != "">
	options_${escapedOptionId}.ondblclickrow = "${parameters.onDblClickRowTopics}";
  </#if>
  <#if parameters.onRightClickRowTopics! != "">
	options_${escapedOptionId}.onrightclickrow = "${parameters.onRightClickRowTopics}";
  </#if>
  <#if parameters.reloadTopics! != "">
	options_${escapedOptionId}.reloadtopics = "${parameters.reloadTopics}";
  </#if>
  <#if parameters.connectWith! != "">
	options_${escapedOptionId}.connectWith = "${parameters.connectWith}";
  </#if>


	options_${escapedOptionId}.colNames = options_${escapedOptionId}_colnames;
	options_${escapedOptionId}.colModel = options_${escapedOptionId}_colmodels;
	options_${escapedOptionId}.jsonReader = {};
  <#if parameters.gridModel! != "">
	options_${escapedOptionId}.jsonReader.root = "${parameters.gridModel}";
  <#else>
	options_${escapedOptionId}.jsonReader.root = "gridModel";
  </#if>
  <#if parameters.loadonce!false>
  <#else>
	options_${escapedOptionId}.jsonReader.page = "page";
	options_${escapedOptionId}.jsonReader.total = "total";
	options_${escapedOptionId}.jsonReader.records = "records";
  </#if>
	options_${escapedOptionId}.jsonReader.repeatitems = false;

  <#include "/${parameters.templateDir}/jquery/draggable.ftl" />
  <#include "/${parameters.templateDir}/jquery/droppable.ftl" />
  <#include "/${parameters.templateDir}/jquery/resizable.ftl" />
  <#include "/${parameters.templateDir}/jquery/selectable.ftl" />
  <#include "/${parameters.templateDir}/jquery/sortable.ftl" />
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#if !parameters.subGrid!false>
	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_grid.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
 });
</script>
<#else>
	<#if parameters.subGridUrl! != "">
	options_${escapedOptionId}.url = "${parameters.subGridUrl?string}";
	</#if>
	<#assign escapedParentOptionId="${parameters.parentGrid?string?replace('.', '_')}">
	options_${escapedParentOptionId}.subgridoptions = options_${escapedOptionId};
</#if>
