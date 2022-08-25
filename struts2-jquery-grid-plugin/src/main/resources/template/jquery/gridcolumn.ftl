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

options_${escapedOptionId}_colmodels_${colName} = {};
options_${escapedOptionId}_colmodels_${colName}.name = "${parameters.name?string}";
<#if parameters.jsonmap?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.jsonmap = "${parameters.jsonmap}";
<#else>
options_${escapedOptionId}_colmodels_${colName}.jsonmap = "${parameters.name}";
</#if>
<#if parameters.index?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.index = "${parameters.index}";
</#if>
<#if parameters.width?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.width = <#outputformat "JavaScript">${parameters.width}</#outputformat>;
</#if>
<#if parameters.editoptions?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.editoptions = <#outputformat "JavaScript">${parameters.editoptions}</#outputformat>;
</#if>
<#if parameters.edittype?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.edittype = "${parameters.edittype}";
</#if>
<#if parameters.editrules?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.editrules = <#outputformat "JavaScript">${parameters.editrules}</#outputformat>;
</#if>
<#if parameters.formoptions?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.formoptions = <#outputformat "JavaScript">${parameters.formoptions}</#outputformat>;
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
		options_${escapedOptionId}_colmodels_${colName}.formatter = "${parameters.formatter}";
	<#else>
		options_${escapedOptionId}_colmodels_${colName}.formatter = <#outputformat "JavaScript">${parameters.formatter}</#outputformat>;
	</#if>
</#if>
<#if parameters.formatoptions?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.formatoptions = <#outputformat "JavaScript">${parameters.formatoptions}</#outputformat>;
</#if>
<#if parameters.align?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.align = "${parameters.align}";
</#if>
<#if parameters.cssClass?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.classes = "${parameters.cssClass}";
</#if>
<#if parameters.fixed?default(false)>
options_${escapedOptionId}_colmodels_${colName}.fixed = true;
options_${escapedOptionId}.true = false;
</#if>
<#if parameters.frozen?default(false)>
options_${escapedOptionId}_colmodels_${colName}.frozen = true;
options_${escapedOptionId}.frozen = true;
</#if>
<#if parameters.editable?default(false)>
options_${escapedOptionId}_colmodels_${colName}.editable = true;
<#else>
options_${escapedOptionId}_colmodels_${colName}.editable = false;
</#if>
<#if parameters.sortable?default(true)>
options_${escapedOptionId}_colmodels_${colName}.sortable = true;
<#else>
options_${escapedOptionId}_colmodels_${colName}.sortable = false;
</#if>
<#if parameters.sorttype?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.sorttype = "${parameters.sorttype}";
</#if>
<#if parameters.resizable?default(true)>
options_${escapedOptionId}_colmodels_${colName}.resizable = true;
<#else>
options_${escapedOptionId}_colmodels_${colName}.resizable = false;
</#if>
<#if parameters.search?default(true)>
options_${escapedOptionId}_colmodels_${colName}.search = true;
	<#if parameters.searchtype?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.stype = "${parameters.searchtype}";
	</#if>
<#else>
options_${escapedOptionId}_colmodels_${colName}.search = false;
</#if>
<#if parameters.key?default(false)>
options_${escapedOptionId}_colmodels_${colName}.key = true;
</#if>
<#if parameters.hidedlg?default(false)>
options_${escapedOptionId}_colmodels_${colName}.hidedlg = true;
</#if>
<#if parameters.hidden?default(false)>
options_${escapedOptionId}_colmodels_${colName}.hidden = true;
</#if>
<#if parameters.defval?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.defval = "${parameters.defval}";
</#if>
<#if parameters.surl?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.surl = "${parameters.surl?string}";
</#if>
<#if parameters.searchoptions?if_exists != "">
options_${escapedOptionId}_colmodels_${colName}.searchoptions = <#outputformat "JavaScript">${parameters.searchoptions}</#outputformat>;
</#if>
<#if !parameters.displayTitle?default(true)>
options_${escapedOptionId}_colmodels_${colName}.title = false;
</#if>

options_${escapedOptionId}_colnames.push("${parameters.title}");
options_${escapedOptionId}_colmodels.push(options_${escapedOptionId}_colmodels_${colName});
