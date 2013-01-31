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
	var options_${escapedOptionId?html} = {};
  <#if parameters.height?if_exists != "">
  	<#if parameters.height?if_exists == "auto">
	options_${escapedOptionId?html}.height = "auto";
  	<#else>
	options_${escapedOptionId?html}.height = ${parameters.height?html};
  	</#if>
  </#if>
  <#if parameters.width?if_exists != "">
 	<#if parameters.width?if_exists == "auto">
	options_${escapedOptionId?html}.width = "auto";
  	<#else>
	options_${escapedOptionId?html}.width = ${parameters.width?html};
  	</#if>
  </#if>
   <#if parameters.maxHeight?if_exists != "">
	options_${escapedOptionId?html}.maxHeight = ${parameters.maxHeight?html};
  </#if>
  <#if parameters.maxWidth?if_exists != "">
	options_${escapedOptionId?html}.maxWidth = ${parameters.maxWidth?html};
  </#if>
   <#if parameters.minHeight?if_exists != "">
	options_${escapedOptionId?html}.minHeight = ${parameters.minHeight?html};
  </#if>
  <#if parameters.minWidth?if_exists != "">
	options_${escapedOptionId?html}.minWidth = ${parameters.minWidth?html};
  </#if>
  <#if parameters.title?if_exists != "">
	options_${escapedOptionId?html}.title = "${parameters.title?html}";
  </#if>
  <#if parameters.dialogClass?if_exists != "">
	options_${escapedOptionId?html}.dialogClass = "${parameters.dialogClass?html}";
  </#if>
  <#if parameters.showEffect?if_exists != "">
	options_${escapedOptionId?html}.show = "${parameters.showEffect?html}";
  </#if>
  <#if parameters.hideEffect?if_exists != "">
	options_${escapedOptionId?html}.hide = "${parameters.hideEffect?html}";
  </#if>
  <#if parameters.position?if_exists != "">
  	  <#-- Is position an Array or Object? -->
	  <#if parameters.position?substring(0, 1) == "[" || parameters.position?substring(0, 1) == "{">
	options_${escapedOptionId?html}.position = ${parameters.position?html};
	  <#else>
	options_${escapedOptionId?html}.position = "${parameters.position?html}";
	  </#if>
  </#if>
  <#if parameters.appendTo?if_exists != "">
    options_${escapedOptionId?html}.appendTo = "${parameters.appendTo?html}";
  </#if>
  <#if parameters.buttons?if_exists != "">
	options_${escapedOptionId?html}.buttons = ${parameters.buttons?string};
  </#if>
  <#if parameters.draggable?exists>
	options_${escapedOptionId?html}.draggable = ${parameters.draggable?string};
  </#if>
  <#if parameters.resizable?exists>
	options_${escapedOptionId?html}.resizable = ${parameters.resizable?string};
  </#if>
  <#if parameters.autoOpen?exists>
	options_${escapedOptionId?html}.autoOpen = ${parameters.autoOpen?string};
  </#if>
  <#if parameters.closeOnEscape?exists>
	options_${escapedOptionId?html}.closeOnEscape = ${parameters.closeOnEscape?string};
  </#if>
<#if parameters.modal?if_exists == "true" >
 <#if parameters.overlayColor?if_exists != "" || parameters.overlayOpacity?if_exists != "">
	<#if parameters.overlayColor?if_exists != "">
	options_${escapedOptionId?html}.backgroundColor = "${parameters.overlayColor?html}";
	</#if>
	<#if parameters.overlayOpacity?if_exists != "">
	options_${escapedOptionId?html}.opacity = ${parameters.overlayOpacity?html};
	<#else>
	opacity="0.7"<#rt/>
	options_${escapedOptionId?html}.opacity = 0.7;
	</#if>
  </#if>
	options_${escapedOptionId?html}.modal = true;
</#if>
  <#if parameters.onOpenTopics?if_exists != "">
	options_${escapedOptionId?html}.onopentopics = "${parameters.onOpenTopics?html}";
  </#if>
  <#if parameters.onCloseTopics?if_exists != "">
	options_${escapedOptionId?html}.onclosetopics = "${parameters.onCloseTopics?html}";
  </#if>
  <#if parameters.onFocusTopics?if_exists != "">
	options_${escapedOptionId?html}.onfocustopics = "${parameters.onFocusTopics?html}";
  </#if>
  <#if parameters.onBeforeCloseTopics?if_exists != "">
	options_${escapedOptionId?html}.onbeforeclosetopics = "${parameters.onBeforeCloseTopics?html}";
  </#if>
  <#if parameters.openTopics?if_exists != "">
	options_${escapedOptionId?html}.opentopics = "${parameters.openTopics?html}";
  </#if>
  <#if parameters.closeTopics?if_exists != "">
	options_${escapedOptionId?html}.closetopics = "${parameters.closeTopics?html}";
  </#if>
  <#if parameters.destroyTopics?if_exists != "">
	options_${escapedOptionId?html}.destroytopics = "${parameters.destroyTopics?html}";
  </#if>
<#include "/${parameters.templateDir}/jquery/base.ftl" />
<#include "/${parameters.templateDir}/jquery/interactive.ftl" />
<#include "/${parameters.templateDir}/jquery/topics.ftl" />
<#include "/${parameters.templateDir}/jquery/action.ftl" />

<#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });  
</script>
