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
<#if parameters.parentTheme == 'xhtml' || parameters.parentTheme == 'css_xhtml' || parameters.parentTheme == 'simple'>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlheader.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlheader.ftl" />
	</#if>
<#setting number_format="#.#####">
<select<#rt/>
 name="${parameters.name?default("")}"<#rt/>
<#if parameters.get("size")??>
 size="${parameters.get("size")}"<#rt/>
</#if>
<#if parameters.multiple?default(false)>
 multiple="multiple"<#rt/>
</#if>
<#if parameters.disabled?default(false)>
 disabled="disabled"<#rt/>
</#if>
<#if parameters.tabindex??>
 tabindex="${parameters.tabindex}"<#rt/>
</#if>
<#if parameters.id??>
 id="${parameters.id}"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/css.ftl" />
<#if parameters.title??>
 title="${parameters.title}"<#rt/>
</#if>
<#if parameters.multiple?default(false)>
 multiple="multiple"<#rt/>
</#if>
<#include "/${parameters.templateDir}/simple/scripting-events.ftl" />
<#include "/${parameters.templateDir}/simple/common-attributes.ftl" />
<#include "/${parameters.templateDir}/simple/dynamic-attributes.ftl" />
>
<option value=""></option>
</select>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlfooter.ftl" />
	</#if>
<#else>
	<#include "/${parameters.templateDir}/${parameters.parentTheme}/select.ftl" />
</#if>
