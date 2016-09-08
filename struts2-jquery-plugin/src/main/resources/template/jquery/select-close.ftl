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
	options_${escapedOptionId?html}.datatype = "json";
	options_${escapedOptionId?html}.type = 'select';
<#if parameters.emptyOption?default(false)>
	options_${escapedOptionId?html}.emptyoption = true;
</#if>
<#if parameters.headerKey?? && parameters.headerValue??>
	options_${escapedOptionId?html}.headerkey = "${parameters.headerKey?html}";
	options_${escapedOptionId?html}.headervalue = "${parameters.headerValue?html}";
</#if>
<#if parameters.list??>
	options_${escapedOptionId?html}.list = "${parameters.list?html}";
</#if>
<#if parameters.listKey??>
	options_${escapedOptionId?html}.listkey = "${parameters.listKey?html}";
</#if>
<#if parameters.listTitle??>
	options_${escapedOptionId?html}.listtitle = "${parameters.listTitle?html}";
</#if>
<#if parameters.listValue??>
	options_${escapedOptionId?html}.listvalue = "${parameters.listValue?html}";
</#if>
<#if parameters.nameValue??>
	options_${escapedOptionId?html}.value = "<@s.property value="parameters.nameValue"/>";
</#if>
<#if parameters.bindOn?if_exists != "">
	options_${escapedOptionId?html}.bindon = "${parameters.bindOn?html}";
</#if>
<#if parameters.events?if_exists != "">
	options_${escapedOptionId?html}.events = "${parameters.events?html}";
</#if>
<#if parameters.autocomplete?default(false)>
	options_${escapedOptionId?html}.autocomplete = true;
</#if>
<#if parameters.selectBoxIcon?default(false) >
	options_${escapedOptionId?html}.icon = true;
</#if>
<#if parameters.loadMinimumCount??>
	options_${escapedOptionId?html}.minimum = ${parameters.loadMinimumCount?html};
</#if>
<#if parameters.onSelectTopics?if_exists != "">
	options_${escapedOptionId?html}.onselecttopics = "${parameters.onSelectTopics?html}";
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
