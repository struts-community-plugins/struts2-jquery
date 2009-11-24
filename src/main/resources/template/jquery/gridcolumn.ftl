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
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editoptions = "${parameters.editoptions?html}";
</#if>
<#if parameters.loadonce?default(false)>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editable = true;
<#else>
options_${parameters.grid?html}_colmodels_${parameters.name?html}.editable = false;
</#if>
options_${parameters.grid?html}_colnames.push("${parameters.title?html}");
options_${parameters.grid?html}_colmodels.push(options_${parameters.grid?html}_colmodels_${parameters.name?html});