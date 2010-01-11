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
	options_${parameters.id?html}.datatype = "${parameters.dataType?default('json')}";
  <#if parameters.href?exists>
	options_${parameters.id?html}.url = "${parameters.href?string}";
  </#if>
  <#if parameters.editurl?if_exists != "">
	options_${parameters.id?html}.editurl = "${parameters.editurl?string}";
  </#if>
  <#if parameters.cellurl?if_exists != "">
	options_${parameters.id?html}.cellurl = "${parameters.cellurl?string}";
  </#if>
  <#if parameters.multiselectWidth?exists>
	options_${parameters.id?html}.multiselectWidth = ${parameters.multiselectWidth?html};
  </#if>
  <#if parameters.page?exists>
	options_${parameters.id?html}.page = ${parameters.page?html};
  </#if>
  <#if parameters.width?exists>
	options_${parameters.id?html}.width = ${parameters.width?html};
  </#if>
  <#if parameters.height?exists>
	options_${parameters.id?html}.height = ${parameters.height?html};
  <#else>
	options_${parameters.id?html}.height = 'auto';
  </#if>
  <#if parameters.pager?default(false)>
	options_${parameters.id?html}.pager = "${parameters.id?html}_pager";
  </#if>
  <#if parameters.rowNum?if_exists != "">
	options_${parameters.id?html}.rowNum = ${parameters.rowNum?html};
  </#if>
  <#if parameters.rowList?if_exists != "">
	options_${parameters.id?html}.rowList = [${parameters.rowList?html}];
  </#if>
  <#if parameters.sortname?if_exists != "">
	options_${parameters.id?html}.sortname = "${parameters.sortname?html}";
  </#if>
  <#if parameters.viewrecords?default(false)>
	options_${parameters.id?html}.viewrecords = true;
  </#if>
  <#if parameters.scroll?default(false)>
	options_${parameters.id?html}.scroll = true;
  </#if>
  <#if parameters.sortorder?if_exists != "">
	options_${parameters.id?html}.sortorder = "${parameters.sortorder?html}";
  </#if>
  <#if parameters.navigator?default(false)>
	options_${parameters.id?html}.navigator = "${parameters.id?html}_navigator";
	  <#if parameters.navigatorEditOptions?if_exists != "">
		options_${parameters.id?html}.navigatoreditoptions = ${parameters.navigatorEditOptions?html};
	  </#if>
	  <#if parameters.navigatorAddOptions?if_exists != "">
		options_${parameters.id?html}.navigatoraddoptions = ${parameters.navigatorAddOptions?html};
	  </#if>
	  <#if parameters.navigatorDeleteOptions?if_exists != "">
		options_${parameters.id?html}.navigatordeleteoptions = ${parameters.navigatorDeleteOptions?html};
	  </#if>
	  <#if parameters.navigatorViewOptions?if_exists != "">
		options_${parameters.id?html}.navigatorviewoptions = ${parameters.navigatorViewOptions?html};
	  </#if>
	  <#if parameters.navigatorSearchOptions?if_exists != "">
		options_${parameters.id?html}.navigatorsearchoptions = ${parameters.navigatorSearchOptions?html};
	  </#if>
	  <#if parameters.navigatorAdd?default(true)>
		options_${parameters.id?html}.navigatoradd = true;
	  <#else>
		options_${parameters.id?html}.navigatoradd = false;
	  </#if>
	  <#if parameters.navigatorDelete?default(true)>
		options_${parameters.id?html}.navigatordel = true;
	  <#else>
		options_${parameters.id?html}.navigatordel = false;
	  </#if>
	  <#if parameters.navigatorEdit?default(true)>
		options_${parameters.id?html}.navigatoredit = true;
	  <#else>
		options_${parameters.id?html}.navigatoredit = false;
	  </#if>
	  <#if parameters.navigatorRefresh?default(true)>
		options_${parameters.id?html}.navigatorrefresh = true;
	  <#else>
		options_${parameters.id?html}.navigatorrefresh = false;
	  </#if>
	  <#if parameters.navigatorSearch?default(true)>
		options_${parameters.id?html}.navigatorsearch = true;
	  <#else>
		options_${parameters.id?html}.navigatorsearch = false;
	  </#if>
	  <#if parameters.navigatorView?default(false)>
		options_${parameters.id?html}.navigatorview = true;
	  <#else>
		options_${parameters.id?html}.navigatorview = false;
	  </#if>
  </#if>
  <#if parameters.editinline?default(false)>
	options_${parameters.id?html}.editinline = true;
  </#if>
  <#if parameters.loadonce?default(false)>
	options_${parameters.id?html}.loadonce = true;
  </#if>
  <#if parameters.filter?default(false)>
	options_${parameters.id?html}.filter = true;
  </#if>
  <#if parameters.multiselect?default(false)>
	options_${parameters.id?html}.multiselect = true;
  </#if>
  <#if parameters.caption?if_exists != "">
	options_${parameters.id?html}.caption = "${parameters.caption?html}";
  </#if>
  <#if parameters.sortable?default(false)>
	options_${parameters.id?html}.sortable = true;
  </#if>
  <#if parameters.shrinkToFit?default(true)>
	options_${parameters.id?html}.shrinkToFit = true;
  </#if>
  <#if parameters.autoencode?default(true)>
	options_${parameters.id?html}.autoencode = true;
  </#if>
  <#if parameters.cellEdit?default(false)>
	options_${parameters.id?html}.cellEdit = true;
  </#if>
  <#if parameters.footerrow?default(false)>
	options_${parameters.id?html}.footerrow = true;
  </#if>
  <#if parameters.hiddengrid?default(false)>
	options_${parameters.id?html}.hiddengrid = true;
  </#if>
  <#if parameters.hidegrid?default(false)>
	options_${parameters.id?html}.hidegrid = true;
  </#if>
  <#if parameters.hoverrows?default(false)>
	options_${parameters.id?html}.hoverrows = true;
  </#if>
  <#if parameters.rownumbers?default(false)>
	options_${parameters.id?html}.rownumbers = true;
  </#if>
  <#if parameters.scrollrows?default(false)>
	options_${parameters.id?html}.scrollrows = true;
  </#if>
  <#if parameters.onSelectRowTopics?if_exists != "">
	options_${parameters.id?html}.onselectrowtopics = "${parameters.onSelectRowTopics?html}";
  </#if>
  <#if parameters.onPagingTopics?if_exists != "">
	options_${parameters.id?html}.onpagingtopics = "${parameters.onPagingTopics?html}";
  </#if>
  <#if parameters.onSortColTopics?if_exists != "">
	options_${parameters.id?html}.onsortcoltopics = "${parameters.onSortColTopics?html}";
  </#if>
  <#if parameters.onCellSelectTopics?if_exists != "">
	options_${parameters.id?html}.oncellselecttopics = "${parameters.onCellSelectTopics?html}";
  </#if>
  <#if parameters.onGridCompleteTopics?if_exists != "">
	options_${parameters.id?html}.ongridcompletetopics = "${parameters.onGridCompleteTopics?html}";
  </#if>


	options_${parameters.id?html}.colNames = options_${parameters.id?html}_colnames;
	options_${parameters.id?html}.colModel = options_${parameters.id?html}_colmodels;
	options_${parameters.id?html}.gridview = true;
	options_${parameters.id?html}.jsonReader = {};
  <#if parameters.gridModel?if_exists != "">
	options_${parameters.id?html}.jsonReader.root = "${parameters.gridModel?html}";
  <#else>
	options_${parameters.id?html}.jsonReader.root = "gridModel";
  </#if>
  <#if parameters.loadonce?default(false)>
  <#else>
	options_${parameters.id?html}.jsonReader.page = "page";
	options_${parameters.id?html}.jsonReader.total = "total";
	options_${parameters.id?html}.jsonReader.records = "records";
  </#if>
	options_${parameters.id?html}.jsonReader.repeatitems = false;
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });  
</script>
