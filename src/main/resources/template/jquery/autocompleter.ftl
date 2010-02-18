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
<#if parameters.parentTheme == 'xhtml' || parameters.parentTheme == 'simple'>
<#if parameters.parentTheme == 'xhtml'>
<#include "/${parameters.templateDir}/xhtml/controlheader.ftl" />
</#if>
  <#if (parameters.list?? && parameters.listKey??) || parameters.selectBox??>
	<select<#rt/>
	 name="${parameters.name?default("")?html}"<#rt/>
	<#if parameters.disabled?default(false)>
	 disabled="disabled"<#rt/>
	</#if>
	<#if parameters.tabindex??>
	 tabindex="${parameters.tabindex?html}"<#rt/>
	</#if>
	<#if parameters.id??>
	 id="${parameters.id?html}"<#rt/>
	</#if>
	<#include "/${parameters.templateDir}/simple/css.ftl" />
	<#if parameters.title??>
	 title="${parameters.title?html}"<#rt/>
	</#if>
	<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
	<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
	<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
	>
	<@s.iterator value="parameters.list">
	        <#if parameters.listKey??>
	            <#if stack.findValue(parameters.listKey)??>
	              <#assign itemKey = stack.findValue(parameters.listKey)/>
	              <#assign itemKeyStr = stack.findString(parameters.listKey)/>
	            <#else>
	              <#assign itemKey = ''/>
	              <#assign itemKeyStr = ''/>
	            </#if>
	        <#else>
	            <#assign itemKey = stack.findValue('top')/>
	            <#assign itemKeyStr = stack.findString('top')>
	        </#if>
	        <#if parameters.listValue??>
	            <#if stack.findString(parameters.listValue)??>
	              <#assign itemValue = stack.findString(parameters.listValue)/>
	            <#else>
	              <#assign itemValue = ''/>
	            </#if>
	        <#else>
	            <#assign itemValue = stack.findString('top')/>
	        </#if>
	    <option value="${itemKeyStr?html}">${itemValue?html}</option><#lt/>
	</@s.iterator>
	</select>
  <#else>
<#include "/${parameters.templateDir}/simple/text.ftl" />
  </#if>
<#if parameters.parentTheme == 'xhtml'>
<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
</#if>
<#else>
<#include "/${parameters.templateDir}/${parameters.parentTheme}/text.ftl" />
</#if>
