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

options_${parameters.grid?html}_colmodels_${parameters.name?html} = {};
options_${parameters.grid?html}_colmodels_${parameters.name?html}.name = "${parameters.name?html}";
options_${parameters.grid?html}_colmodels_${parameters.name?html}.jsonmap = "${parameters.name?html}";
<#if parameters.index?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.index = "${parameters.index?html}";
</#if>
<#if parameters.width?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.width = ${parameters.width?html};
</#if>
<#if parameters.editoptions?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editoptions = ${parameters.editoptions?html};
</#if>
<#if parameters.edittype?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.edittype = "${parameters.edittype?html}";
</#if>
<#if parameters.editrules?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editrules = ${parameters.editrules?html};
</#if>
<#if parameters.formatter?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.formatter = "${parameters.formatter?html}";
</#if>
<#if parameters.formatoptions?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.formatoptions = ${parameters.formatoptions?html};
</#if>
<#if parameters.editable?default(false)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editable = true;
<#else>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editable = false;
</#if>
<#if parameters.sortable?default(true)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.sortable = true;
<#else>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.sortable = false;
</#if>
<#if parameters.resizable?default(true)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.resizable = true;
<#else>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.resizable = false;
</#if>
<#if parameters.search?default(true)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.search = true;
<#else>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.search = false;
</#if>
<#if parameters.key?default(false)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.key = true;
</#if>
<#if parameters.hidedlg?default(false)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.hidedlg = true;
</#if>
<#if parameters.hidden?default(false)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.hidden = true;
</#if>
<#if parameters.searchoptions?if_exists != "">
options_${parameters.grid?html}_colmodels_${parameters.name?html}.searchoptions = ${parameters.searchoptions?html};
</#if>
options_${parameters.grid?html}_colnames.push("${parameters.title?html}");
options_${parameters.grid?html}_colmodels.push(options_${parameters.grid?html}_colmodels_${parameters.name?html});