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
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId?html} = {};
  <#if parameters.dayValue?if_exists != "">
	options_${escapedOptionId?html}.day = "${parameters.dayValue?html}";
  </#if>
  <#if parameters.monthValue?if_exists != "">
	options_${escapedOptionId?html}.month = "${parameters.monthValue?html}";
  </#if>
  <#if parameters.yearValue?if_exists != "">
	options_${escapedOptionId?html}.year = "${parameters.yearValue?html}";
  </#if>
  <#if parameters.showButtonPanel?default(false)>
	options_${escapedOptionId?html}.showbuttonpanel = true;
  </#if>
  <#if parameters.buttonImageOnly?default(false)>
	options_${escapedOptionId?html}.buttonimageonly = true;
  </#if>
  <#if parameters.changeMonth?default(false)>
	options_${escapedOptionId?html}.changemonth = true;
  </#if>
  <#if parameters.changeYear?default(false)>
	options_${escapedOptionId?html}.changeyear = true;
  </#if>
  <#if parameters.showOn?if_exists != "">
	options_${escapedOptionId?html}.showon = "${parameters.showOn?html}";
  <#else>
	options_${escapedOptionId?html}.showon = "both";
  </#if>
  <#if parameters.buttonImage?if_exists != "">
	options_${escapedOptionId?html}.buttonimage = "${parameters.buttonImage?html}";
  <#else>
    <#if parameters.buttonText?if_exists == "">
	options_${escapedOptionId?html}.buttonimage = "${base}/struts/js/calendar.gif";
    </#if>
  </#if>
  <#if parameters.buttonText?if_exists != "">
	options_${escapedOptionId?html}.buttontext = "${parameters.buttonText?html}";
  </#if>
  <#if parameters.duration?if_exists != "">
	options_${escapedOptionId?html}.duration = "${parameters.duration?html}";
  </#if>
  <#if parameters.showAnim?if_exists != "">
	options_${escapedOptionId?html}.showanim = "${parameters.showAnim?html}";
  </#if>
  <#if parameters.firstDay?if_exists != "">
	options_${escapedOptionId?html}.firstday = "${parameters.firstDay?html}";
  </#if>
  <#if parameters.numberOfMonths?if_exists != "">
	options_${escapedOptionId?html}.numberofmonths = "${parameters.numberOfMonths?html}";
  </#if>
  <#if parameters.showOptions?if_exists != "">
	options_${escapedOptionId?html}.showoptions = "${parameters.showOptions?html}";
  </#if>
  <#if parameters.yearRange?if_exists != "">
	options_${escapedOptionId?html}.yearrange = "${parameters.yearRange?html}";
  </#if>
  <#if parameters.displayFormat?if_exists != "">
	options_${escapedOptionId?html}.displayformat = "${parameters.displayFormat?html}";
  </#if>
  <#if parameters.onBeforeShowDayTopics?if_exists != "">
 	options_${escapedOptionId?html}.onbeforeshowdaytopics = "${parameters.onBeforeShowDayTopics?html}";
  </#if>
  <#if parameters.onChangeMonthYearTopics?if_exists != "">
 	options_${escapedOptionId?html}.onchangemonthyeartopics = "${parameters.onChangeMonthYearTopics?html}";
  </#if>
  <#if parameters.zindex?if_exists != "">
 	options_${escapedOptionId?html}.zindex = ${parameters.zindex?html};
  </#if>
  <#if parameters.appendText?if_exists != "">
	options_${escapedOptionId?html}.appendtext = "${parameters.appendText?html}";
  </#if>
  <#if parameters.maxDate?if_exists != "">
	options_${escapedOptionId?html}.maxdate = "${parameters.maxDate?html}";
  </#if>
  <#if parameters.maxDayValue??>
	options_${escapedOptionId?html}.maxdate = new Date(${parameters.maxYearValue?html}, ${parameters.maxMonthValue?html}, ${parameters.maxDayValue?html});
  </#if>
  <#if parameters.minDate?if_exists != "">
	options_${escapedOptionId?html}.mindate = "${parameters.minDate?html}";
  </#if>
  <#if parameters.minDayValue??>
	options_${escapedOptionId?html}.mindate = new Date(${parameters.minYearValue?html}, ${parameters.minMonthValue?html}, ${parameters.minDayValue?html});
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });
</script>
