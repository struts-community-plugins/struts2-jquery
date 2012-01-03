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
  <#if parameters.timepicker?default(false)>
	jQuery.struts2_jquery.initDatepicker(true);
  <#else>
	jQuery.struts2_jquery.initDatepicker(false);
  </#if>

});
jQuery(document).ready(function () {
	var options_${escapedOptionId?html} = {};
  <#if parameters.dayValue?if_exists != "">
	options_${escapedOptionId?html}.day = ${parameters.dayValue?html};
  </#if>
  <#if parameters.monthValue?if_exists != "">
	options_${escapedOptionId?html}.month = ${parameters.monthValue?html};
  </#if>
  <#if parameters.yearValue?if_exists != "">
	options_${escapedOptionId?html}.year = ${parameters.yearValue?html};
  </#if>
  <#if parameters.hourValue?if_exists != "">
	options_${escapedOptionId?html}.hour = ${parameters.hourValue?html};
  </#if>
  <#if parameters.minuteValue?if_exists != "">
	options_${escapedOptionId?html}.minute = ${parameters.minuteValue?html};
  </#if>
  <#if parameters.secondValue?if_exists != "">
	options_${escapedOptionId?html}.second = ${parameters.secondValue?html};
  </#if>
  <#if parameters.showButtonPanel?default(false)>
	options_${escapedOptionId?html}.showButtonPanel = true;
  </#if>
  <#if parameters.buttonImageOnly?default(false)>
	options_${escapedOptionId?html}.buttonImageOnly = true;
  </#if>
  <#if parameters.changeMonth?default(false)>
	options_${escapedOptionId?html}.changeMonth = true;
  </#if>
  <#if parameters.changeYear?default(false)>
	options_${escapedOptionId?html}.changeYear = true;
  </#if>
  <#if parameters.showOn?if_exists != "">
	options_${escapedOptionId?html}.showOn = "${parameters.showOn?html}";
  <#else>
	options_${escapedOptionId?html}.showOn = "both";
  </#if>
  <#if parameters.buttonImage?if_exists != "">
	options_${escapedOptionId?html}.buttonImage = "${parameters.buttonImage?html}";
  <#else>
    <#if parameters.buttonText?if_exists == "">
	options_${escapedOptionId?html}.buttonImage = "${base}/struts/js/calendar.gif";
    </#if>
  </#if>
  <#if parameters.buttonText?if_exists != "">
	options_${escapedOptionId?html}.buttonText = "${parameters.buttonText?html}";
  </#if>
  <#if parameters.duration?if_exists != "">
	options_${escapedOptionId?html}.duration = "${parameters.duration?html}";
  </#if>
  <#if parameters.showAnim?if_exists != "">
	options_${escapedOptionId?html}.showAnim = "${parameters.showAnim?html}";
  </#if>
  <#if parameters.firstDay?if_exists != "">
	options_${escapedOptionId?html}.firstDay = "${parameters.firstDay?html}";
  </#if>
  <#if parameters.numberOfMonths?if_exists != "">
	options_${escapedOptionId?html}.numberofmonths = "${parameters.numberOfMonths?html}";
  </#if>
  <#if parameters.showOptions?if_exists != "">
	options_${escapedOptionId?html}.showoptions = "${parameters.showOptions?html}";
  </#if>
  <#if parameters.yearRange?if_exists != "">
	options_${escapedOptionId?html}.yearRange = "${parameters.yearRange?html}";
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
	options_${escapedOptionId?html}.appendText = "${parameters.appendText?html}";
  </#if>
  <#if parameters.maxDate?if_exists != "">
	options_${escapedOptionId?html}.maxDate = "${parameters.maxDate?html}";
  </#if>
  <#if parameters.maxDayValue??>
  	<#if parameters.timepicker?default(false)>
	options_${escapedOptionId?html}.maxDate = new Date(${parameters.maxYearValue?html}, ${parameters.maxMonthValue?html}, ${parameters.maxDayValue?html});
	<#else>
	options_${escapedOptionId?html}.maxDate = new Date(${parameters.maxYearValue?html}, ${parameters.maxMonthValue?html}, ${parameters.maxDayValue?html});
  	</#if>
  </#if>
  <#if parameters.minDate?if_exists != "">
	options_${escapedOptionId?html}.minDate = "${parameters.minDate?html}";
  </#if>
  <#if parameters.minDayValue??>
  	<#if parameters.timepicker?default(false)>
	options_${escapedOptionId?html}.minDate = new Date(${parameters.minYearValue?html}, ${parameters.minMonthValue?html}, ${parameters.minDayValue?html});
	<#else>
	options_${escapedOptionId?html}.minDate = new Date(${parameters.minYearValue?html}, ${parameters.minMonthValue?html}, ${parameters.minDayValue?html});
  	</#if>
  </#if>
  <#if parameters.inline?default(false)>
	options_${escapedOptionId?html}.inline = true;
  </#if>
  <#if parameters.timepicker?default(false)>
	options_${escapedOptionId?html}.timepicker = true;
  	<#if parameters.timepickerOnly?default(false)>
	options_${escapedOptionId?html}.tponly = true;
  	</#if>
   	<#if parameters.timepickerAmPm?default(false)>
	options_${escapedOptionId?html}.ampm = true;
  	</#if>
    <#if parameters.timepickerShowHour?exists>
	options_${escapedOptionId?html}.showHour = ${parameters.timepickerShowHour?string};
	</#if>
    <#if parameters.timepickerShowMinute?exists>
	options_${escapedOptionId?html}.showMinute = ${parameters.timepickerShowMinute?string};
	</#if>
    <#if parameters.timepickerShowSecond?exists>
	options_${escapedOptionId?html}.showSecond = ${parameters.timepickerShowSecond?string};
	</#if>
    <#if parameters.timepickerStepHour?exists>
	options_${escapedOptionId?html}.stepHour = ${parameters.timepickerStepHour?c};
	</#if>
    <#if parameters.timepickerStepMinute?exists>
	options_${escapedOptionId?html}.stepMinute = ${parameters.timepickerStepMinute?c};
	</#if>
    <#if parameters.timepickerStepSecond?exists>
	options_${escapedOptionId?html}.stepSecond = ${parameters.timepickerStepSecond?c};
	</#if>
  	<#if parameters.timepickerFormat?if_exists != "">
	options_${escapedOptionId?html}.timeFormat = "${parameters.timepickerFormat?html}";
  	</#if>
  	<#if parameters.timepickerCurrentText?if_exists != "">
	options_${escapedOptionId?html}.currentText = "${parameters.timepickerCurrentText?html}";
  	</#if>
  	<#if parameters.timepickerSeparator?if_exists != "">
	options_${escapedOptionId?html}.separator = "${parameters.timepickerSeparator?html}";
  	</#if>
     <#if parameters.timepickerGridHour?exists>
	options_${escapedOptionId?html}.hourGrid = ${parameters.timepickerGridHour?c};
	</#if>
    <#if parameters.timepickerGridMinute?exists>
	options_${escapedOptionId?html}.minuteGrid = ${parameters.timepickerGridMinute?c};
	</#if>
    <#if parameters.timepickerGridSecond?exists>
	options_${escapedOptionId?html}.secondGrid = ${parameters.timepickerGridSecond?c};
	</#if>
  	<#if parameters.timepickerTimeOnlyTitle?if_exists != "">
	options_${escapedOptionId?html}.timeOnlyTitle = "${parameters.timepickerTimeOnlyTitle?html}";
  	</#if>
  	<#if parameters.timepickerTimeText?if_exists != "">
	options_${escapedOptionId?html}.timeText = "${parameters.timepickerTimeText?html}";
  	</#if>
  	<#if parameters.timepickerHourText?if_exists != "">
	options_${escapedOptionId?html}.hourText = "${parameters.timepickerHourText?html}";
  	</#if>
  	<#if parameters.timepickerMinuteText?if_exists != "">
	options_${escapedOptionId?html}.minuteText = "${parameters.timepickerMinuteText?html}";
  	</#if>
  	<#if parameters.timepickerSecondText?if_exists != "">
	options_${escapedOptionId?html}.secondText = "${parameters.timepickerSecondText?html}";
  	</#if>
  	<#if parameters.timepickerCurrentText?if_exists != "">
	options_${escapedOptionId?html}.currentText = "${parameters.timepickerCurrentText?html}";
  	</#if>
  	<#if parameters.timepickerCloseText?if_exists != "">
	options_${escapedOptionId?html}.closeText = "${parameters.timepickerCloseText?html}";
  	</#if>
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });
</script>
