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
<#assign escapedOptionId="${parameters.id?string?replace('.', '_')}">

  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />

options_${escapedOptionId?html}.xaxis = {};
<#if parameters.xaxisPosition?if_exists != "">
options_${escapedOptionId?html}.xaxis.position = "${parameters.xaxisPosition?html}";
</#if>
<#if parameters.xaxisMode?if_exists == "time">
options_${escapedOptionId?html}.xaxis.mode = "time";
	<#if parameters.xaxisTimeformat?if_exists != "">
options_${escapedOptionId?html}.xaxis.timeformat = "${parameters.xaxisTimeformat?html}";
	</#if>
</#if>
<#if parameters.xaxisColor?if_exists != "">
options_${escapedOptionId?html}.xaxis.color = "${parameters.xaxisColor?html}";
</#if>
<#if parameters.xaxisTick?if_exists != "">
options_${escapedOptionId?html}.xaxis.tick = ${parameters.xaxisTick?html};
</#if>
<#if parameters.xaxisTickSize?if_exists != "">
options_${escapedOptionId?html}.xaxis.tickSize = ${parameters.xaxisTickSize?html};
</#if>
<#if parameters.xaxisTickDecimals?if_exists != "">
options_${escapedOptionId?html}.xaxis.tickDecimals = ${parameters.xaxisTickDecimals?html};
</#if>
<#if parameters.xaxisTickColor?if_exists != "">
options_${escapedOptionId?html}.xaxis.tickColor = "${parameters.xaxisTickColor?html}";
</#if>
<#if parameters.xaxisMin?if_exists != "">
options_${escapedOptionId?html}.xaxis.min = ${parameters.xaxisMin?html};
</#if>
<#if parameters.xaxisMax?if_exists != "">
options_${escapedOptionId?html}.xaxis.max = ${parameters.xaxisMax?html};
</#if>
options_${escapedOptionId?html}.yaxis = {};
<#if parameters.yaxisPosition?if_exists != "">
options_${escapedOptionId?html}.yaxis.position = "${parameters.yaxisPosition?html}";
</#if>
<#if parameters.yaxisMode?if_exists == "time">
options_${escapedOptionId?html}.yaxis.mode = "time";
	<#if parameters.yaxisTimeformat?if_exists != "">
options_${escapedOptionId?html}.yaxis.timeformat = "${parameters.yaxisTimeformat?html}";
	</#if>
</#if>
<#if parameters.yaxisColor?if_exists != "">
options_${escapedOptionId?html}.yaxis.color = "${parameters.yaxisColor?html}";
</#if>
<#if parameters.yaxisTick?if_exists != "">
options_${escapedOptionId?html}.yaxis.tick = ${parameters.yaxisTick?html};
</#if>
<#if parameters.yaxisTickSize?if_exists != "">
options_${escapedOptionId?html}.yaxis.tickSize = ${parameters.yaxisTickSize?html};
</#if>
<#if parameters.yaxisTickDecimals?if_exists != "">
options_${escapedOptionId?html}.yaxis.tickDecimals = ${parameters.yaxisTickDecimals?html};
</#if>
<#if parameters.yaxisTickColor?if_exists != "">
options_${escapedOptionId?html}.yaxis.tickColor = "${parameters.yaxisTickColor?html}";
</#if>
<#if parameters.yaxisMin?if_exists != "">
options_${escapedOptionId?html}.yaxis.min = ${parameters.yaxisMin?html};
</#if>
<#if parameters.yaxisMax?if_exists != "">
options_${escapedOptionId?html}.yaxis.max = ${parameters.yaxisMax?html};
</#if>
options_${escapedOptionId?html}.legend = {};
<#if parameters.legendShow?exists>
options_${escapedOptionId?html}.legend.show = ${parameters.legendShow?string};
</#if>
<#if parameters.legendPosition?if_exists != "">
options_${escapedOptionId?html}.legend.position = "${parameters.legendPosition?html}";
</#if>
<#if parameters.legendLabelBoxBorderColor?if_exists != "">
options_${escapedOptionId?html}.legend.labelBoxBorderColor = "${parameters.legendLabelBoxBorderColor?html}";
</#if>
<#if parameters.legendBackgroundColor?if_exists != "">
options_${escapedOptionId?html}.legend.backgroundColor = "${parameters.legendBackgroundColor?html}";
</#if>
<#if parameters.onHoverTopics?if_exists != "">
options_${escapedOptionId?html}.onhover = "${parameters.onHoverTopics?html}";
</#if>

	<#assign escapedId="${parameters.id?string?replace('.', '\\\\\\\\.')}">
	jQuery.struts2_jquery_chart.bind(jQuery('#${escapedId?html}'),options_${escapedOptionId?html});
 });  
</script>
