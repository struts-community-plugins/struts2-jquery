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
  <#if parameters.rowNum?if_exists != "">
	options_${escapedOptionId?html}.rowNum = ${parameters.rowNum?html};
  </#if>
  <#if parameters.rowList?if_exists != "">
	options_${escapedOptionId?html}.rowList = [${parameters.rowList?html}];
  </#if>
  <#if parameters.sortname?if_exists != "">
	options_${escapedOptionId?html}.sortname = "${parameters.sortname?html}";
  </#if>
  <#if parameters.viewrecords?default(false)>
	options_${escapedOptionId?html}.viewrecords = true;
  </#if>
  <#if parameters.scroll?default(false)>
	options_${escapedOptionId?html}.scroll = true;
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
  </#if>
  <#if parameters.editinline?default(false)>
	options_${escapedOptionId?html}.editinline = true;
  </#if>
  <#if parameters.loadonce?default(false)>
	options_${escapedOptionId?html}.loadonce = true;
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
  <#if parameters.caption?if_exists != "">
	options_${escapedOptionId?html}.caption = "${parameters.caption?html}";
  </#if>
  <#if parameters.sortable?default(false)>
	options_${escapedOptionId?html}.sortable = true;
  </#if>
  <#if parameters.shrinkToFit?default(true)>
	options_${escapedOptionId?html}.shrinkToFit = true;
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
  <#if parameters.hidegrid?default(false)>
	options_${escapedOptionId?html}.hidegrid = true;
  </#if>
  <#if parameters.hoverrows?default(false)>
	options_${escapedOptionId?html}.hoverrows = true;
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
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#if !parameters.subGrid?default(false)>
<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });  
</script>
<#else>
	<#if parameters.subGridUrl?if_exists != "">
	options_${escapedOptionId?html}.url = "${parameters.subGridUrl?string}";
	</#if>
	<#assign escapedParentOptionId="${parameters.parentGrid?string?replace('.', '_')}">
	options_${escapedParentOptionId?html}.subgridoptions = options_${escapedOptionId?html};
</#if>