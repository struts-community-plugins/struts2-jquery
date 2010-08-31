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
<#assign escapedOptionId="${parameters.chart?string?replace('.', '_')}">

options_${escapedOptionId?html}_data = {};
<#if parameters.label?if_exists != "">
options_${escapedOptionId?html}_data.label = "${parameters.label?html}";
</#if>
<#if parameters.data?if_exists != "">
options_${escapedOptionId?html}_data.data = ${parameters.data};
</#if>
<#if parameters.color?if_exists != "">
options_${escapedOptionId?html}_data.color = "${parameters.color?html}";
</#if>
<#if parameters.lines?if_exists != "">
options_${escapedOptionId?html}_data.lines = ${parameters.lines?html};
</#if>
<#if parameters.bars?if_exists != "">
options_${escapedOptionId?html}_data.bars = ${parameters.bars?html};
</#if>
<#if parameters.points?if_exists != "">
options_${escapedOptionId?html}_data.points = ${parameters.points?html};
</#if>
<#if parameters.xaxis?if_exists != "">
options_${escapedOptionId?html}_data.xaxis = ${parameters.xaxis};
</#if>
<#if parameters.yaxis?if_exists != "">
options_${escapedOptionId?html}_data.yaxis = ${parameters.yaxis};
</#if>
<#if parameters.clickable?default(false)>
options_${escapedOptionId?html}_data.clickable = true;
</#if>
<#if parameters.hoverable?default(false)>
options_${escapedOptionId?html}_data.hoverable = true;
</#if>
<#if parameters.shadowSize?if_exists != "">
options_${escapedOptionId?html}_data.shadowSize = ${parameters.shadowSize};
</#if>

options_${escapedOptionId?html}.data.push(options_${escapedOptionId?html}_data);
