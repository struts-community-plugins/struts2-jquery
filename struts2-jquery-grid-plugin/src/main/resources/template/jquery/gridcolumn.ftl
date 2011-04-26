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
<#assign colName="${parameters.name?string?replace('.', '_')}">
<#assign escapedOptionId="${parameters.grid?string?replace('.', '_')}">

options_${escapedOptionId?html}_colmodels_${colName} = {};
options_${escapedOptionId?html}_colmodels_${colName}.name = "${parameters.name?string?replace('.', '_')?html}";
options_${escapedOptionId?html}_colmodels_${colName}.jsonmap = "${parameters.name?html}";
<#if parameters.index?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.index = "${parameters.index?html}";
</#if>
<#if parameters.width?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.width = ${parameters.width?html};
</#if>
<#if parameters.editoptions?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.editoptions = ${parameters.editoptions?html};
</#if>
<#if parameters.edittype?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.edittype = "${parameters.edittype?html}";
</#if>
<#if parameters.editrules?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.editrules = ${parameters.editrules?html};
</#if>
<#if parameters.formoptions?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.formoptions = ${parameters.formoptions?html};
</#if>
<#if parameters.formatter?if_exists != "">
	<#if parameters.formatter == "integer" 
		|| parameters.formatter == "number" 
		|| parameters.formatter == "currency" 
		|| parameters.formatter == "date" 
		|| parameters.formatter == "email" 
		|| parameters.formatter == "link" 
		|| parameters.formatter == "showlink" 
		|| parameters.formatter == "checkbox" 
		|| parameters.formatter == "select" 
		>
		options_${escapedOptionId?html}_colmodels_${colName}.formatter = "${parameters.formatter?html}";
	<#else>
		options_${escapedOptionId?html}_colmodels_${colName}.formatter = ${parameters.formatter?html};
	</#if>
</#if>
<#if parameters.formatoptions?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.formatoptions = ${parameters.formatoptions?html};
</#if>
<#if parameters.align?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.align = "${parameters.align?html}";
</#if>
<#if parameters.cssClass?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.classes = "${parameters.cssClass?html}";
</#if>
<#if parameters.editable?default(false)>
options_${escapedOptionId?html}_colmodels_${colName}.editable = true;
<#else>
options_${escapedOptionId?html}_colmodels_${colName}.editable = false;
</#if>
<#if parameters.sortable?default(true)>
options_${escapedOptionId?html}_colmodels_${colName}.sortable = true;
<#else>
options_${escapedOptionId?html}_colmodels_${colName}.sortable = false;
</#if>
<#if parameters.resizable?default(true)>
options_${escapedOptionId?html}_colmodels_${colName}.resizable = true;
<#else>
options_${escapedOptionId?html}_colmodels_${colName}.resizable = false;
</#if>
<#if parameters.search?default(true)>
options_${escapedOptionId?html}_colmodels_${colName}.search = true;
<#else>
options_${escapedOptionId?html}_colmodels_${colName}.search = false;
</#if>
<#if parameters.key?default(false)>
options_${escapedOptionId?html}_colmodels_${colName}.key = true;
</#if>
<#if parameters.hidedlg?default(false)>
options_${escapedOptionId?html}_colmodels_${colName}.hidedlg = true;
</#if>
<#if parameters.hidden?default(false)>
options_${escapedOptionId?html}_colmodels_${colName}.hidden = true;
</#if>
<#if parameters.defval?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.defval = "${parameters.defval?html}";
</#if>
<#if parameters.surl?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.surl = "${parameters.surl?string}";
</#if>
<#if parameters.searchoptions?if_exists != "">
options_${escapedOptionId?html}_colmodels_${colName}.searchoptions = ${parameters.searchoptions?html};
</#if>
options_${escapedOptionId?html}_colnames.push("${parameters.title?html}");
options_${escapedOptionId?html}_colmodels.push(options_${escapedOptionId?html}_colmodels_${colName});
