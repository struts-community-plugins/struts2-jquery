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
$(document).ready(function () { 
	var options_${escapedOptionId?html} = {};
  <#if parameters.delay??>
	options_${escapedOptionId?html}.delay = ${parameters.delay?html};
  </#if>
  <#if parameters.loadMinimumCount??>
	options_${escapedOptionId?html}.minimum = ${parameters.loadMinimumCount?html};
  </#if>
  <#if parameters.selectBox?default(false) || parameters.list?? && parameters.listKey??>
	options_${escapedOptionId?html}.selectBox = true;
  <#else>
	options_${escapedOptionId?html}.selectBox = false;
  </#if>
  <#if parameters.list?? && !parameters.listKey?? && !parameters.selectBox??>
	options_${escapedOptionId?html}.list = new Array();
<@s.iterator value="parameters.list">
        <#if parameters.listValue??>
            <#if stack.findString(parameters.listValue)??>
              <#assign itemValue = stack.findString(parameters.listValue)/>
            <#else>
              <#assign itemValue = ''/>
            </#if>
        <#else>
            <#assign itemValue = stack.findString('top')/>
        </#if>
	options_${escapedOptionId?html}.list.push("${itemValue?html}");
</@s.iterator>
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
