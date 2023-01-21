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
<#assign escapedOptionId="${parameters.escapedId}">

  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />

options_${escapedOptionId}.xaxis = {};
<#if parameters.xaxisPosition! != "">
options_${escapedOptionId}.xaxis.position = "${parameters.xaxisPosition}";
</#if>
<#if parameters.xaxisMode! == "time">
options_${escapedOptionId}.xaxis.mode = "time";
options_${escapedOptionId}.xaxis.timeBase = "milliseconds";
	<#if parameters.xaxisTimeformat! != "">
options_${escapedOptionId}.xaxis.timeformat = "${parameters.xaxisTimeformat}";
	</#if>
</#if>
<#if parameters.xaxisColor! != "">
options_${escapedOptionId}.xaxis.color = "${parameters.xaxisColor}";
</#if>
<#if parameters.xaxisTick! != "">
options_${escapedOptionId}.xaxis.ticks = ${parameters.xaxisTick};
</#if>
<#if parameters.xaxisTickSize! != "">
options_${escapedOptionId}.xaxis.tickSize = <#outputformat "JavaScript">${parameters.xaxisTickSize}</#outputformat>;
</#if>
<#if parameters.xaxisTickDecimals! != "">
options_${escapedOptionId}.xaxis.tickDecimals = ${parameters.xaxisTickDecimals};
</#if>
<#if parameters.xaxisTickColor! != "">
options_${escapedOptionId}.xaxis.tickColor = "${parameters.xaxisTickColor}";
</#if>
<#if parameters.xaxisMin! != "">
options_${escapedOptionId}.xaxis.min = ${parameters.xaxisMin};
</#if>
<#if parameters.xaxisMax! != "">
options_${escapedOptionId}.xaxis.max = ${parameters.xaxisMax};
</#if>
<#if parameters.xaxisLabel! != "">
options_${escapedOptionId}.xaxis.axisLabel = "${parameters.xaxisLabel}";
options_${escapedOptionId}.xaxis.axisLabelUseCanvas = true;
	<#if parameters.xaxisLabelFontSizePixels??>
options_${escapedOptionId}.xaxis.axisLabelFontSizePixels = ${parameters.xaxisLabelFontSizePixels?c};
	</#if>
	<#if parameters.xaxisLabelFontFamily! != "">
options_${escapedOptionId}.xaxis.axisLabelFontFamily = "${parameters.xaxisLabelFontFamily}";
	</#if>
</#if>
options_${escapedOptionId}.yaxis = {};
<#if parameters.yaxisPosition! != "">
options_${escapedOptionId}.yaxis.position = "${parameters.yaxisPosition}";
</#if>
<#if parameters.yaxisMode! == "time">
options_${escapedOptionId}.yaxis.mode = "time";
	<#if parameters.yaxisTimeformat! != "">
options_${escapedOptionId}.yaxis.timeformat = "${parameters.yaxisTimeformat}";
	</#if>
</#if>
<#if parameters.yaxisColor! != "">
options_${escapedOptionId}.yaxis.color = "${parameters.yaxisColor}";
</#if>
<#if parameters.yaxisTick??>
options_${escapedOptionId}.yaxis.ticks = ${parameters.yaxisTick?string};
</#if>
<#if parameters.yaxisTickSize??>
options_${escapedOptionId}.yaxis.tickSize = <#outputformat "JavaScript">${parameters.yaxisTickSize?string}</#outputformat>;
</#if>
<#if parameters.yaxisTickDecimals??>
options_${escapedOptionId}.yaxis.tickDecimals = ${parameters.yaxisTickDecimals?string};
</#if>
<#if parameters.yaxisTickColor! != "">
options_${escapedOptionId}.yaxis.tickColor = "${parameters.yaxisTickColor}";
</#if>
<#if parameters.yaxisMin??>
options_${escapedOptionId}.yaxis.min = ${parameters.yaxisMin?string};
</#if>
<#if parameters.yaxisMax??>
options_${escapedOptionId}.yaxis.max = ${parameters.yaxisMax?string};
</#if>
<#if parameters.yaxisLabel! != "">
options_${escapedOptionId}.yaxis.axisLabel = "${parameters.yaxisLabel}";
options_${escapedOptionId}.yaxis.axisLabelUseCanvas = true;
	<#if parameters.yaxisLabelFontSizePixels??>
options_${escapedOptionId}.yaxis.axisLabelFontSizePixels = ${parameters.yaxisLabelFontSizePixels?c};
	</#if>
	<#if parameters.yaxisLabelFontFamily! != "">
options_${escapedOptionId}.yaxis.axisLabelFontFamily = "${parameters.yaxisLabelFontFamily}";
	</#if>
</#if>
options_${escapedOptionId}.legend = {};
<#if parameters.legendShow??>
options_${escapedOptionId}.legend.show = ${parameters.legendShow?string};
</#if>
<#if parameters.legendPosition! != "">
options_${escapedOptionId}.legend.position = "${parameters.legendPosition}";
</#if>
<#if parameters.legendLabelBoxBorderColor! != "">
options_${escapedOptionId}.legend.labelBoxBorderColor = "${parameters.legendLabelBoxBorderColor}";
</#if>
<#if parameters.legendBackgroundColor! != "">
options_${escapedOptionId}.legend.backgroundColor = "${parameters.legendBackgroundColor}";
</#if>
<#if parameters.onHoverTopics! != "">
options_${escapedOptionId}.onhover = "${parameters.onHoverTopics}";
</#if>
<#if parameters.crosshair!false>
	options_${escapedOptionId}.crosshair = {};
	<#if parameters.crosshairMode! != "">
	options_${escapedOptionId}.crosshair.mode = "${parameters.crosshairMode}";
	</#if>
	<#if parameters.crosshairColor! != "">
	options_${escapedOptionId}.crosshair.color = "${parameters.crosshairColor}";
	</#if>
  	<#if parameters.crosshairLineWidth??>
	options_${escapedOptionId}.crosshair.lineWidth = ${parameters.crosshairLineWidth?string};
  	</#if>
</#if>
<#if parameters.pie!false>
	if(options_${escapedOptionId}.series){
	options_${escapedOptionId}.series = $.extend(options_${escapedOptionId}.series , { pie: { show: true }});
	} else {
	options_${escapedOptionId}.series = { pie: { show: true }};
	}
	<#if parameters.pieRadius??>
		options_${escapedOptionId}.series.pie.radius = ${parameters.pieRadius?string};
	</#if>
	<#if parameters.pieInnerRadius??>
		options_${escapedOptionId}.series.pie.innerRadius = ${parameters.pieInnerRadius?string};
	</#if>
	<#if parameters.pieLabel!false>
		options_${escapedOptionId}.series.pie.label = { show: true };
		<#if parameters.pieLabelRadius??>
			options_${escapedOptionId}.series.pie.label.radius = ${parameters.pieLabelRadius?string};
		</#if>
		<#if parameters.pieLabelFormatter! != "">
			options_${escapedOptionId}.series.pie.label.formatter = ${parameters.pieLabelFormatter};
		</#if>
	  	<#if parameters.pieLabelBackgroundColor?? || parameters.pieLabelBackgroundOpacity??>
			options_${escapedOptionId}.series.pie.label.background = {};
		<#if parameters.pieLabelBackgroundColor! != "">
			options_${escapedOptionId}.series.pie.label.background.color = "${parameters.pieLabelBackgroundColor}";
		</#if>
		<#if parameters.pieLabelBackgroundOpacity??>
			options_${escapedOptionId}.series.pie.label.background.opacity = ${parameters.pieLabelBackgroundOpacity?string};
		</#if>
	  	</#if>
	</#if>
</#if>
<#if parameters.autoResize!false>
	options_${escapedOptionId}.autoresize = true;
</#if>
	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_chart.bind(jQuery('#${escapedId}'),options_${escapedOptionId});
 });
</script>

