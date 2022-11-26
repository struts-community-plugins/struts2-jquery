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
<@s.script type='text/javascript'>
jQuery(document).ready(function () {
	var options_${escapedOptionId} = {};
<#if parameters.nameValue??>
	options_${escapedOptionId}.value = "<@s.property value="parameters.nameValue"/>";
</#if>
<#if parameters.remoteList??>
	options_${escapedOptionId}.datatype = "json";
	options_${escapedOptionId}.type = 'radio';
	options_${escapedOptionId}.list = "${parameters.remoteList}";
</#if>
<#if parameters.remoteListKey??>
	options_${escapedOptionId}.listkey = "${parameters.remoteListKey}";
</#if>
<#if parameters.remoteListValue??>
	options_${escapedOptionId}.listvalue = "${parameters.remoteListValue}";
</#if>
<#if parameters.buttonset!true>
	options_${escapedOptionId}.buttonset = true;
<#else>
	options_${escapedOptionId}.buttonset = false;
</#if>
<#if parameters.icon!true>
    options_${escapedOptionId}.icon = true;
<#else>
    options_${escapedOptionId}.icon = false;
</#if>
<#if parameters.direction??>
    options_${escapedOptionId}.direction = "${parameters.direction}";
</#if>
  <#include "/${parameters.templateDir}/jquery/base.ftl" />
  <#include "/${parameters.templateDir}/jquery/interactive.ftl" />
  <#include "/${parameters.templateDir}/jquery/topics.ftl" />
  <#include "/${parameters.templateDir}/jquery/action.ftl" />
  <#include "/${parameters.templateDir}/jquery/container.ftl" />

  <#include "/${parameters.templateDir}/jquery/jquery-ui-bind.ftl" />
 });
</@s.script>
