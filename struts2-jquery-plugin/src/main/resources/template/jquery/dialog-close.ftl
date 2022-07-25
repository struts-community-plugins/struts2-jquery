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
</div>
<script type='text/javascript'>
jQuery(document).ready(function () { 
	var options_${escapedOptionId} = {};
  <#if parameters.height?if_exists != "">
  	<#if parameters.height?if_exists == "auto">
	options_${escapedOptionId}.height = "auto";
  	<#else>
	options_${escapedOptionId}.height = ${parameters.height};
  	</#if>
  </#if>
  <#if parameters.width?if_exists != "">
 	<#if parameters.width?if_exists == "auto">
	options_${escapedOptionId}.width = "auto";
  	<#else>
	options_${escapedOptionId}.width = ${parameters.width};
  	</#if>
  </#if>
   <#if parameters.maxHeight?if_exists != "">
	options_${escapedOptionId}.maxHeight = ${parameters.maxHeight};
  </#if>
  <#if parameters.maxWidth?if_exists != "">
	options_${escapedOptionId}.maxWidth = ${parameters.maxWidth};
  </#if>
   <#if parameters.minHeight?if_exists != "">
	options_${escapedOptionId}.minHeight = ${parameters.minHeight};
  </#if>
  <#if parameters.minWidth?if_exists != "">
	options_${escapedOptionId}.minWidth = ${parameters.minWidth};
  </#if>
  <#if parameters.title?if_exists != "">
	options_${escapedOptionId}.title = "${parameters.title}";
  </#if>
  <#if parameters.dialogClass?if_exists != "">
	options_${escapedOptionId}.dialogClass = "${parameters.dialogClass}";
  </#if>
  <#if parameters.showEffect?if_exists != "">
	options_${escapedOptionId}.show = "${parameters.showEffect}";
  </#if>
  <#if parameters.hideEffect?if_exists != "">
	options_${escapedOptionId}.hide = "${parameters.hideEffect}";
  </#if>
  <#if parameters.position?if_exists != "">
  	  <#-- Is position an Array or Object? -->
	  <#if parameters.position?substring(0, 1) == "[" || parameters.position?substring(0, 1) == "{">
	options_${escapedOptionId}.position = ${parameters.position};
	  <#else>
	options_${escapedOptionId}.position = "${parameters.position}";
	  </#if>
  </#if>
  <#if parameters.appendTo?if_exists != "">
    options_${escapedOptionId}.appendTo = "${parameters.appendTo}";
  </#if>
  <#if parameters.buttons?if_exists != "">
	options_${escapedOptionId}.buttons = ${parameters.buttons?no_esc};
  </#if>
  <#if parameters.draggable?exists>
	options_${escapedOptionId}.draggable = ${parameters.draggable?string};
  </#if>
  <#if parameters.resizable?exists>
	options_${escapedOptionId}.resizable = ${parameters.resizable?string};
  </#if>
  <#if parameters.autoOpen?exists>
	options_${escapedOptionId}.autoOpen = ${parameters.autoOpen?string};
  </#if>
  <#if parameters.closeOnEscape?exists>
	options_${escapedOptionId}.closeOnEscape = ${parameters.closeOnEscape?string};
  </#if>
  <#if parameters.modal?if_exists == "true" >
	options_${escapedOptionId}.modal = true;
  </#if>
  <#if parameters.onOpenTopics?if_exists != "">
	options_${escapedOptionId}.onopentopics = "${parameters.onOpenTopics}";
  </#if>
  <#if parameters.onCloseTopics?if_exists != "">
	options_${escapedOptionId}.onclosetopics = "${parameters.onCloseTopics}";
  </#if>
  <#if parameters.onFocusTopics?if_exists != "">
	options_${escapedOptionId}.onfocustopics = "${parameters.onFocusTopics}";
  </#if>
  <#if parameters.onBeforeCloseTopics?if_exists != "">
	options_${escapedOptionId}.onbeforeclosetopics = "${parameters.onBeforeCloseTopics}";
  </#if>
  <#if parameters.openTopics?if_exists != "">
	options_${escapedOptionId}.opentopics = "${parameters.openTopics}";
  </#if>
  <#if parameters.closeTopics?if_exists != "">
	options_${escapedOptionId}.closetopics = "${parameters.closeTopics}";
  </#if>
  <#if parameters.destroyTopics?if_exists != "">
	options_${escapedOptionId}.destroytopics = "${parameters.destroyTopics}";
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />
<#include "/${parameters.templateDir}/jquery/action.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });  
</script>
