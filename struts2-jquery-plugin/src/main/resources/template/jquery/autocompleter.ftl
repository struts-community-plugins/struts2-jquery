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
<#assign hasFieldErrors = parameters.widgetname?? && fieldErrors?? && fieldErrors[parameters.widgetname]??/>
<input type="hidden"
    <#if parameters.widgetid?if_exists != "">
        id="${parameters.widgetid?html}"<#rt/>
    </#if>
    <#if parameters.nameValue??>
        value="<@s.property value="parameters.nameValue"/>"<#rt/>
    </#if>
    <#if parameters.widgetname?if_exists != "">
        name="${parameters.widgetname?html}"<#rt/>
    </#if>
    <#if parameters.cssClass?has_content && !(hasFieldErrors && parameters.cssErrorClass??)>
        class="${parameters.cssClass?html}"<#rt/>
    <#elseif parameters.cssClass?has_content && (hasFieldErrors && parameters.cssErrorClass??)>
        class="${parameters.cssClass?html} ${parameters.cssErrorClass?html}"<#rt/>
    <#elseif !(parameters.cssClass?has_content) && (hasFieldErrors && parameters.cssErrorClass??)>
        class="${parameters.cssErrorClass?html}"<#rt/>
    </#if>
    <#if parameters.cssStyle?has_content && !(hasFieldErrors && (parameters.cssErrorStyle?? || parameters.cssErrorClass??))>
        style="${parameters.cssStyle?html}"<#rt/>
    <#elseif hasFieldErrors && parameters.cssErrorStyle??>
        style="${parameters.cssErrorStyle?html}"<#rt/>
    </#if>
    <#if parameters.disabled?default(false)>
        disabled="disabled"<#rt/>
    </#if>
/>
<#if parameters.parentTheme == 'xhtml' || parameters.parentTheme == 'css_xhtml' || parameters.parentTheme == 'simple'>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlheader.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlheader.ftl" />
	</#if>
	<#if (parameters.list?? && parameters.listKey??) || parameters.selectBox??>
		<#include "/${parameters.templateDir}/simple/select.ftl" />
  	<#else>
		<#include "/${parameters.templateDir}/simple/text.ftl" />
  	</#if>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlfooter.ftl" />
	</#if>
<#else>
	<#if (parameters.list?? && parameters.listKey??) || parameters.selectBox??>
		<#include "/${parameters.templateDir}/${parameters.parentTheme}/select.ftl" />
  	<#else>
  		<#include "/${parameters.templateDir}/${parameters.parentTheme}/text.ftl" />
  	</#if>
</#if>
