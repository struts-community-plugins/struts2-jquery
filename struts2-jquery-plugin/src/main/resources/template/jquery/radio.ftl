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
<div id="${parameters.id}">
<#include "/${parameters.templateDir}/simple/radiomap.ftl" />
</div>
	<#if parameters.parentTheme == 'xhtml'>
		<#include "/${parameters.templateDir}/xhtml/controlfooter.ftl" />
	</#if>
	<#if parameters.parentTheme == 'css_xhtml'>
		<#include "/${parameters.templateDir}/css_xhtml/controlfooter.ftl" />
	</#if>
<#else>
<#include "/${parameters.templateDir}/${parameters.parentTheme}/controlheader.ftl" />
<div id="${parameters.id}">
<#include "/${parameters.templateDir}/${parameters.parentTheme}/radiomap.ftl" />
</div>
<#include "/${parameters.templateDir}/${parameters.parentTheme}/controlfooter.ftl" />

</#if>
