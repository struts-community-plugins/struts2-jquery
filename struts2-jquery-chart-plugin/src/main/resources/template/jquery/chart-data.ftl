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
options_${escapedOptionId?html}_data.id = "${parameters.id?html}";
<#if parameters.hrefUrl?if_exists != "">
options_${escapedOptionId?html}_data.href = "${parameters.hrefUrl?html}";
</#if>
<#if parameters.hrefParameter?if_exists != "">
options_${escapedOptionId?html}_data.hrefparameter = "${parameters.hrefParameter?string}";
</#if>
<#if parameters.formIds?exists>
options_${escapedOptionId?html}_data.formids = "${parameters.formIds?html}";
</#if>
<#if parameters.indicator?exists>
options_${escapedOptionId?html}_data.indicatorid = "${parameters.indicator?html}";
</#if>
<#if parameters.loadingText?exists>
options_${escapedOptionId?html}_data.loadingtext = "${parameters.loadingText?html}";
</#if>
<#if parameters.remoteList??>
options_${escapedOptionId?html}_data.list = "${parameters.remoteList?html}";
</#if>
<#if parameters.remoteListKey??>
options_${escapedOptionId?html}_data.listkey = "${parameters.remoteListKey?html}";
</#if>
<#if parameters.remoteListValue??>
options_${escapedOptionId?html}_data.listvalue = "${parameters.remoteListValue?html}";
</#if>
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
<#if parameters.xaxis??>
options_${escapedOptionId?html}_data.xaxis = ${parameters.xaxis};
</#if>
<#if parameters.yaxis??>
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
<#if parameters.fillBetween?if_exists != "">
options_${escapedOptionId?html}_data.fillBetween = "${parameters.fillBetween}";
options_${escapedOptionId?html}.fill = true;
</#if>
<#if parameters.stack?if_exists != "">
options_${escapedOptionId?html}_data.stack = "${parameters.stack}";
options_${escapedOptionId?html}.stack = true;
</#if>
<#if parameters.curvedLines?default(false)>
options_${escapedOptionId?html}_data.curvedLines = { show : true };
if(options_${escapedOptionId?html}.series){
options_${escapedOptionId?html}.series = $.extend(options_${escapedOptionId?html}.series , { curvedLines: { active : true }});
} else {
options_${escapedOptionId?html}.series = { curvedLines: { active: true }};
}
    options_${escapedOptionId?html}_data.curvedLines.apply = true;
	<#if parameters.curvedLinesFit?default(false)>
	options_${escapedOptionId?html}_data.curvedLines.fit = true;
	</#if>
	<#if parameters.curvedLinesFill?default(false)>
	options_${escapedOptionId?html}_data.curvedLines.fill = true;
	</#if>
	<#if parameters.curvedLinesFillColor?if_exists != "">
	options_${escapedOptionId?html}_data.curvedLines.fillColor = "${parameters.curvedLinesFillColor?html}";
	</#if>
	<#if parameters.curvedLinesLineWidth??>
	options_${escapedOptionId?html}_data.curvedLines.lineWidth = ${parameters.curvedLinesLineWidth};
	</#if>
</#if>
<#if parameters.reloadTopics?exists>
options_${escapedOptionId?html}_data.reloadtopics = "${parameters.reloadTopics?html}";
</#if>
<#if parameters.listenTopics?exists>
options_${escapedOptionId?html}_data.listentopics = "${parameters.listenTopics?html}";
</#if>
<#if parameters.deferredLoading?default(false)>
options_${escapedOptionId?html}_data.deferredloading = true;
</#if>
<#if parameters.onCompleteTopics?exists>
options_${escapedOptionId?html}_data.oncom = "${parameters.onCompleteTopics?html}";
</#if>
<#if parameters.onSuccessTopics?exists>
options_${escapedOptionId?html}_data.onsuc = "${parameters.onSuccessTopics?html}";
</#if>
<#if parameters.onErrorTopics?exists>
options_${escapedOptionId?html}_data.onerr = "${parameters.onErrorTopics?html}";
</#if>
<#if parameters.onBeforeTopics?exists>
options_${escapedOptionId?html}_data.onbef = "${parameters.onBeforeTopics?html}";
</#if>
<#if parameters.onAlwaysTopics?exists>
options_${escapedOptionId?html}_data.onalw = "${parameters.onAlwaysTopics?html}";
</#if>

options_${escapedOptionId?html}.data.push(options_${escapedOptionId?html}_data);
