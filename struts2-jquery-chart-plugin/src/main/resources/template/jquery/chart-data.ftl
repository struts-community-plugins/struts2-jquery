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

options_${escapedOptionId}_data = {};
options_${escapedOptionId}_data.id = "${parameters.id}";
<#if parameters.hrefUrl?if_exists != "">
options_${escapedOptionId}_data.href = "${parameters.hrefUrl}";
</#if>
<#if parameters.hrefParameter?if_exists != "">
options_${escapedOptionId}_data.hrefparameter = "${parameters.hrefParameter?string}";
</#if>
<#if parameters.formIds?exists>
options_${escapedOptionId}_data.formids = "${parameters.formIds}";
</#if>
<#if parameters.indicator?exists>
options_${escapedOptionId}_data.indicatorid = "${parameters.indicator}";
</#if>
<#if parameters.loadingText?exists>
options_${escapedOptionId}_data.loadingtext = "${parameters.loadingText}";
</#if>
<#if parameters.remoteList??>
options_${escapedOptionId}_data.list = "${parameters.remoteList}";
</#if>
<#if parameters.remoteListKey??>
options_${escapedOptionId}_data.listkey = "${parameters.remoteListKey}";
</#if>
<#if parameters.remoteListValue??>
options_${escapedOptionId}_data.listvalue = "${parameters.remoteListValue}";
</#if>
<#if parameters.label?if_exists != "">
options_${escapedOptionId}_data.label = "${parameters.label}";
</#if>
<#if parameters.data?if_exists != "">
options_${escapedOptionId}_data.data = ${parameters.data};
</#if>
<#if parameters.color?if_exists != "">
options_${escapedOptionId}_data.color = "${parameters.color}";
</#if>
<#if parameters.lines?if_exists != "">
options_${escapedOptionId}_data.lines = ${parameters.lines};
</#if>
<#if parameters.bars?if_exists != "">
options_${escapedOptionId}_data.bars = ${parameters.bars};
</#if>
<#if parameters.points?if_exists != "">
options_${escapedOptionId}_data.points = ${parameters.points};
</#if>
<#if parameters.xaxis??>
options_${escapedOptionId}_data.xaxis = ${parameters.xaxis};
</#if>
<#if parameters.yaxis??>
options_${escapedOptionId}_data.yaxis = ${parameters.yaxis};
</#if>
<#if parameters.clickable?default(false)>
options_${escapedOptionId}_data.clickable = true;
</#if>
<#if parameters.hoverable?default(false)>
options_${escapedOptionId}_data.hoverable = true;
</#if>
<#if parameters.shadowSize?if_exists != "">
options_${escapedOptionId}_data.shadowSize = ${parameters.shadowSize};
</#if>
<#if parameters.fillBetween?if_exists != "">
options_${escapedOptionId}_data.fillBetween = "${parameters.fillBetween}";
options_${escapedOptionId}.fill = true;
</#if>
<#if parameters.stack?if_exists != "">
options_${escapedOptionId}_data.stack = "${parameters.stack}";
options_${escapedOptionId}.stack = true;
</#if>
<#if parameters.curvedLines?default(false)>
options_${escapedOptionId}_data.curvedLines = { show : true };
if(options_${escapedOptionId}.series){
options_${escapedOptionId}.series = $.extend(options_${escapedOptionId}.series , { curvedLines: { active : true }});
} else {
options_${escapedOptionId}.series = { curvedLines: { active: true }};
}
    options_${escapedOptionId}_data.curvedLines.apply = true;
	<#if parameters.curvedLinesFit?default(false)>
	options_${escapedOptionId}_data.curvedLines.fit = true;
	</#if>
	<#if parameters.curvedLinesFill?default(false)>
	options_${escapedOptionId}_data.curvedLines.fill = true;
	</#if>
	<#if parameters.curvedLinesFillColor?if_exists != "">
	options_${escapedOptionId}_data.curvedLines.fillColor = "${parameters.curvedLinesFillColor}";
	</#if>
	<#if parameters.curvedLinesLineWidth??>
	options_${escapedOptionId}_data.curvedLines.lineWidth = ${parameters.curvedLinesLineWidth};
	</#if>
</#if>
<#if parameters.reloadTopics?exists>
options_${escapedOptionId}_data.reloadtopics = "${parameters.reloadTopics}";
</#if>
<#if parameters.listenTopics?exists>
options_${escapedOptionId}_data.listentopics = "${parameters.listenTopics}";
</#if>
<#if parameters.deferredLoading?default(false)>
options_${escapedOptionId}_data.deferredloading = true;
</#if>
<#if parameters.onCompleteTopics?exists>
options_${escapedOptionId}_data.oncom = "${parameters.onCompleteTopics}";
</#if>
<#if parameters.onSuccessTopics?exists>
options_${escapedOptionId}_data.onsuc = "${parameters.onSuccessTopics}";
</#if>
<#if parameters.onErrorTopics?exists>
options_${escapedOptionId}_data.onerr = "${parameters.onErrorTopics}";
</#if>
<#if parameters.onBeforeTopics?exists>
options_${escapedOptionId}_data.onbef = "${parameters.onBeforeTopics}";
</#if>
<#if parameters.onAlwaysTopics?exists>
options_${escapedOptionId}_data.onalw = "${parameters.onAlwaysTopics}";
</#if>

options_${escapedOptionId}.data.push(options_${escapedOptionId}_data);
