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
	jQuery.struts2_jquery_ui.initDatepicker(true);
  <#else>
	jQuery.struts2_jquery_ui.initDatepicker(false);
  </#if>

});
jQuery(document).ready(function () {
	var options_${escapedOptionId} = {};
  <#if parameters.dayValue?if_exists != "">
	options_${escapedOptionId}.day = ${parameters.dayValue};
  </#if>
  <#if parameters.monthValue?if_exists != "">
	options_${escapedOptionId}.month = ${parameters.monthValue};
  </#if>
  <#if parameters.yearValue?if_exists != "">
	options_${escapedOptionId}.year = ${parameters.yearValue};
  </#if>
  <#if parameters.hourValue?if_exists != "">
	options_${escapedOptionId}.hour = ${parameters.hourValue};
  </#if>
  <#if parameters.minuteValue?if_exists != "">
	options_${escapedOptionId}.minute = ${parameters.minuteValue};
  </#if>
  <#if parameters.secondValue?if_exists != "">
	options_${escapedOptionId}.second = ${parameters.secondValue};
  </#if>
  <#if parameters.showButtonPanel?default(false)>
	options_${escapedOptionId}.showButtonPanel = true;
  </#if>
  <#if parameters.buttonImageOnly?default(false)>
	options_${escapedOptionId}.buttonImageOnly = true;
  </#if>
  <#if parameters.changeMonth?default(false)>
	options_${escapedOptionId}.changeMonth = true;
  </#if>
  <#if parameters.changeYear?default(false)>
	options_${escapedOptionId}.changeYear = true;
  </#if>
  <#if parameters.showOn?if_exists != "">
	options_${escapedOptionId}.showOn = "${parameters.showOn}";
  <#else>
	options_${escapedOptionId}.showOn = "both";
  </#if>
  <#if parameters.buttonImage?if_exists != "">
	options_${escapedOptionId}.buttonImage = "${parameters.buttonImage}";
  <#else>
    <#if parameters.buttonText?if_exists == "">
	options_${escapedOptionId}.buttonImage = "${base}/struts/js/calendar.gif";
    </#if>
  </#if>
  <#if parameters.buttonText?if_exists != "">
	options_${escapedOptionId}.buttonText = "${parameters.buttonText}";
  </#if>
  <#if parameters.duration?if_exists != "">
	options_${escapedOptionId}.duration = "${parameters.duration}";
  </#if>
  <#if parameters.showAnim?if_exists != "">
	options_${escapedOptionId}.showAnim = "${parameters.showAnim}";
  </#if>
  <#if parameters.firstDay?if_exists != "">
	options_${escapedOptionId}.firstDay = "${parameters.firstDay}";
  </#if>
  <#if parameters.numberOfMonths?if_exists != "">
	options_${escapedOptionId}.numberofmonths = "${parameters.numberOfMonths}";
  </#if>
  <#if parameters.showOptions?if_exists != "">
	options_${escapedOptionId}.showoptions = "${parameters.showOptions}";
  </#if>
  <#if parameters.yearRange?if_exists != "">
	options_${escapedOptionId}.yearRange = "${parameters.yearRange}";
  </#if>
  <#if parameters.displayFormat?if_exists != "">
	options_${escapedOptionId}.displayformat = "${parameters.displayFormat}";
  </#if>
  <#if parameters.onBeforeShowDayTopics?if_exists != "">
 	options_${escapedOptionId}.onbeforeshowdaytopics = "${parameters.onBeforeShowDayTopics}";
  </#if>
  <#if parameters.onChangeMonthYearTopics?if_exists != "">
 	options_${escapedOptionId}.onchangemonthyeartopics = "${parameters.onChangeMonthYearTopics}";
  </#if>
  <#if parameters.zindex?if_exists != "">
 	options_${escapedOptionId}.zindex = ${parameters.zindex};
  </#if>
  <#if parameters.appendText?if_exists != "">
	options_${escapedOptionId}.appendText = "${parameters.appendText}";
  </#if>
  <#if parameters.maxDate?if_exists != "">
	options_${escapedOptionId}.maxDate = "${parameters.maxDate}";
  </#if>
  <#if parameters.maxDayValue??>
  	<#if parameters.timepicker?default(false)>
	options_${escapedOptionId}.maxDate = new Date(${parameters.maxYearValue}, ${parameters.maxMonthValue}, ${parameters.maxDayValue});
	<#else>
	options_${escapedOptionId}.maxDate = new Date(${parameters.maxYearValue}, ${parameters.maxMonthValue}, ${parameters.maxDayValue});
  	</#if>
  </#if>
  <#if parameters.minDate?if_exists != "">
	options_${escapedOptionId}.minDate = "${parameters.minDate}";
  </#if>
  <#if parameters.minDayValue??>
  	<#if parameters.timepicker?default(false)>
	options_${escapedOptionId}.minDate = new Date(${parameters.minYearValue}, ${parameters.minMonthValue}, ${parameters.minDayValue});
	<#else>
	options_${escapedOptionId}.minDate = new Date(${parameters.minYearValue}, ${parameters.minMonthValue}, ${parameters.minDayValue});
  	</#if>
  </#if>
  <#if parameters.inline?default(false)>
	options_${escapedOptionId}.inline = true;
  </#if>
  <#if parameters.timepicker?default(false)>
	options_${escapedOptionId}.timepicker = true;
  	<#if parameters.timepickerOnly?default(false)>
	options_${escapedOptionId}.tponly = true;
  	</#if>
   	<#if parameters.timepickerAmPm?default(false)>
	options_${escapedOptionId}.ampm = true;
  	</#if>
    <#if parameters.timepickerShowHour?exists>
	options_${escapedOptionId}.showHour = ${parameters.timepickerShowHour?string};
	</#if>
    <#if parameters.timepickerShowMinute?exists>
	options_${escapedOptionId}.showMinute = ${parameters.timepickerShowMinute?string};
	</#if>
    <#if parameters.timepickerShowSecond?exists>
	options_${escapedOptionId}.showSecond = ${parameters.timepickerShowSecond?string};
	</#if>
    <#if parameters.timepickerStepHour?exists>
	options_${escapedOptionId}.stepHour = ${parameters.timepickerStepHour?c};
	</#if>
    <#if parameters.timepickerStepMinute?exists>
	options_${escapedOptionId}.stepMinute = ${parameters.timepickerStepMinute?c};
	</#if>
    <#if parameters.timepickerStepSecond?exists>
	options_${escapedOptionId}.stepSecond = ${parameters.timepickerStepSecond?c};
	</#if>
  	<#if parameters.timepickerFormat?if_exists != "">
	options_${escapedOptionId}.timeFormat = "${parameters.timepickerFormat}";
  	</#if>
  	<#if parameters.timepickerCurrentText?if_exists != "">
	options_${escapedOptionId}.currentText = "${parameters.timepickerCurrentText}";
  	</#if>
  	<#if parameters.timepickerSeparator?if_exists != "">
	options_${escapedOptionId}.separator = "${parameters.timepickerSeparator}";
  	</#if>
     <#if parameters.timepickerGridHour?exists>
	options_${escapedOptionId}.hourGrid = ${parameters.timepickerGridHour?c};
	</#if>
    <#if parameters.timepickerGridMinute?exists>
	options_${escapedOptionId}.minuteGrid = ${parameters.timepickerGridMinute?c};
	</#if>
    <#if parameters.timepickerGridSecond?exists>
	options_${escapedOptionId}.secondGrid = ${parameters.timepickerGridSecond?c};
	</#if>
  	<#if parameters.timepickerTimeOnlyTitle?if_exists != "">
	options_${escapedOptionId}.timeOnlyTitle = "${parameters.timepickerTimeOnlyTitle}";
  	</#if>
  	<#if parameters.timepickerTimeText?if_exists != "">
	options_${escapedOptionId}.timeText = "${parameters.timepickerTimeText}";
  	</#if>
  	<#if parameters.timepickerHourText?if_exists != "">
	options_${escapedOptionId}.hourText = "${parameters.timepickerHourText}";
  	</#if>
  	<#if parameters.timepickerMinuteText?if_exists != "">
	options_${escapedOptionId}.minuteText = "${parameters.timepickerMinuteText}";
  	</#if>
  	<#if parameters.timepickerSecondText?if_exists != "">
	options_${escapedOptionId}.secondText = "${parameters.timepickerSecondText}";
  	</#if>
  	<#if parameters.timepickerCurrentText?if_exists != "">
	options_${escapedOptionId}.currentText = "${parameters.timepickerCurrentText}";
  	</#if>
  	<#if parameters.timepickerCloseText?if_exists != "">
	options_${escapedOptionId}.closeText = "${parameters.timepickerCloseText}";
  	</#if>
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });
</script>
