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
	options_${parameters.id?html}.url = "${parameters.href?html}";
  </#if>
  <#if parameters.width?exists>
	options_${parameters.id?html}.width = ${parameters.width?html};
  </#if>
  <#if parameters.height?exists>
	options_${parameters.id?html}.height = ${parameters.height?html};
  <#else>
	options_${parameters.id?html}.height = 'auto';
  </#if>
  <#if parameters.pager?if_exists != "">
	options_${parameters.id?html}.pager = "${parameters.pager?html}";
  </#if>
  <#if parameters.rowNum?if_exists != "">
	options_${parameters.id?html}.rowNum = "${parameters.rowNum?html}";
  </#if>
  <#if parameters.sortname?if_exists != "">
	options_${parameters.id?html}.sortname = "${parameters.sortname?html}";
  </#if>
  <#if parameters.viewrecords?default(false)>
	options_${parameters.id?html}.viewrecords = true;
  </#if>
  <#if parameters.sortorder?if_exists != "">
	options_${parameters.id?html}.sortorder = "${parameters.sortorder?html}";
  </#if>
  <#if parameters.loadonce?default(false)>
	options_${parameters.id?html}.loadonce = true;
  </#if>
  <#if parameters.multiselect?default(false)>
	options_${parameters.id?html}.multiselect = true;
  </#if>
  <#if parameters.editurl?if_exists != "">
	options_${parameters.id?html}.editurl = "${parameters.editurl?html}";
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
	options_${parameters.id?html}.colNames = options_${parameters.id?html}_colnames;
	options_${parameters.id?html}.colModel = options_${parameters.id?html}_colmodels;
	options_${parameters.id?html}.jsonReader = {};
	options_${parameters.id?html}.jsonReader.root = "rows";
	options_${parameters.id?html}.jsonReader.page = "page";
	options_${parameters.id?html}.jsonReader.total = "total";
	options_${parameters.id?html}.jsonReader.records = "records";
	options_${parameters.id?html}.jsonReader.repeatitems = false;
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });  
</script>
