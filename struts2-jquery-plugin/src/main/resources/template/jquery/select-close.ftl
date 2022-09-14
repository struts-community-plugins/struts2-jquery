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
<script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId} = {};
	options_${escapedOptionId}.datatype = "json";
	options_${escapedOptionId}.type = 'select';
<#if parameters.emptyOption!false>
	options_${escapedOptionId}.emptyoption = true;
</#if>
<#if parameters.headerKey?? && parameters.headerValue??>
	options_${escapedOptionId}.headerkey = "${parameters.headerKey}";
	options_${escapedOptionId}.headervalue = "${parameters.headerValue}";
</#if>
<#if parameters.list??>
	options_${escapedOptionId}.list = "${parameters.list}";
</#if>
<#if parameters.listKey??>
	options_${escapedOptionId}.listkey = "${parameters.listKey}";
</#if>
<#if parameters.listTitle??>
	options_${escapedOptionId}.listtitle = "${parameters.listTitle}";
</#if>
<#if parameters.listValue??>
	options_${escapedOptionId}.listvalue = "${parameters.listValue}";
</#if>
<#if parameters.nameValue??>
	options_${escapedOptionId}.value = "<@s.property value="parameters.nameValue"/>";
</#if>
<#if parameters.bindOn! != "">
	options_${escapedOptionId}.bindon = "${parameters.bindOn}";
</#if>
<#if parameters.events! != "">
	options_${escapedOptionId}.events = "${parameters.events}";
</#if>
<#if parameters.autocomplete!false>
	options_${escapedOptionId}.autocomplete = true;
</#if>
<#if parameters.selectBoxIcon!false >
	options_${escapedOptionId}.icon = true;
</#if>
<#if parameters.loadMinimumCount??>
	options_${escapedOptionId}.minimum = ${parameters.loadMinimumCount};
</#if>
<#if parameters.onSelectTopics! != "">
	options_${escapedOptionId}.onselecttopics = "${parameters.onSelectTopics}";
</#if>
  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />
  <#include "/${parameters.templateDir}/jquery/draggable.ftl" />
  <#include "/${parameters.templateDir}/jquery/droppable.ftl" />
  <#include "/${parameters.templateDir}/jquery/resizable.ftl" />
  <#include "/${parameters.templateDir}/jquery/selectable.ftl" />
  <#include "/${parameters.templateDir}/jquery/sortable.ftl" />

  <#include "/${parameters.templateDir}/jquery/jquery-bind.ftl" />
 });
</script>
